/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.pool;
/*     */ 
/*     */ import com.codahale.metrics.MetricRegistry;
/*     */ import com.codahale.metrics.health.HealthCheckRegistry;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLTransientConnectionException;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadLocalRandom;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import javax.sql.DataSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariConfig;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariPoolMXBean;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.MetricsTrackerFactory;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.PoolStats;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.dropwizard.CodahaleHealthChecker;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.dropwizard.CodahaleMetricsTrackerFactory;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.ClockSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.ConcurrentBag;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.DefaultThreadFactory;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.SuspendResumeLock;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.UtilityElf;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HikariPool
/*     */   extends PoolBase
/*     */   implements HikariPoolMXBean, ConcurrentBag.IBagStateListener
/*     */ {
/*  67 */   private static final Logger LOGGER = LoggerFactory.getLogger(HikariPool.class);
/*     */   
/*  69 */   private static final ClockSource clockSource = ClockSource.INSTANCE;
/*     */   
/*  71 */   private final long ALIVE_BYPASS_WINDOW_MS = Long.getLong("me.TechsCode.UltraPermissions.dependencies.hikari.aliveBypassWindowMs", TimeUnit.MILLISECONDS.toMillis(500L)).longValue();
/*  72 */   private final long HOUSEKEEPING_PERIOD_MS = Long.getLong("me.TechsCode.UltraPermissions.dependencies.hikari.housekeeping.periodMs", TimeUnit.SECONDS.toMillis(30L)).longValue();
/*     */   
/*  74 */   private final PoolEntryCreator POOL_ENTRY_CREATOR = new PoolEntryCreator();
/*     */   
/*     */   private static final int POOL_NORMAL = 0;
/*     */   
/*     */   private static final int POOL_SUSPENDED = 1;
/*     */   
/*     */   private static final int POOL_SHUTDOWN = 2;
/*     */   
/*     */   private volatile int poolState;
/*     */   
/*     */   private final AtomicInteger totalConnections;
/*     */   
/*     */   private final ThreadPoolExecutor addConnectionExecutor;
/*     */   
/*     */   private final ThreadPoolExecutor closeConnectionExecutor;
/*     */   
/*     */   private final ScheduledThreadPoolExecutor houseKeepingExecutorService;
/*     */   
/*     */   private final ConcurrentBag<PoolEntry> connectionBag;
/*     */   
/*     */   private final ProxyLeakTask leakTask;
/*     */   
/*     */   private final SuspendResumeLock suspendResumeLock;
/*     */   
/*     */   private PoolBase.MetricsTrackerDelegate metricsTracker;
/*     */   private boolean isRecordMetrics;
/*     */   
/*     */   public HikariPool(HikariConfig paramHikariConfig) {
/* 102 */     super(paramHikariConfig);
/*     */     
/* 104 */     this.connectionBag = new ConcurrentBag(this);
/* 105 */     this.totalConnections = new AtomicInteger();
/* 106 */     this.suspendResumeLock = paramHikariConfig.isAllowPoolSuspension() ? new SuspendResumeLock() : SuspendResumeLock.FAUX_LOCK;
/*     */     
/* 108 */     this.addConnectionExecutor = UtilityElf.createThreadPoolExecutor(paramHikariConfig.getMaximumPoolSize(), "Hikari connection adder (pool " + this.poolName + ")", paramHikariConfig.getThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
/* 109 */     this.closeConnectionExecutor = UtilityElf.createThreadPoolExecutor(4, "Hikari connection closer (pool " + this.poolName + ")", paramHikariConfig.getThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
/*     */     
/* 111 */     if (paramHikariConfig.getScheduledExecutorService() == null) {
/* 112 */       ThreadFactory threadFactory = (ThreadFactory)((paramHikariConfig.getThreadFactory() != null) ? paramHikariConfig.getThreadFactory() : new DefaultThreadFactory("Hikari housekeeper (pool " + this.poolName + ")", true));
/* 113 */       this.houseKeepingExecutorService = new ScheduledThreadPoolExecutor(1, threadFactory, new ThreadPoolExecutor.DiscardPolicy());
/* 114 */       this.houseKeepingExecutorService.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
/* 115 */       this.houseKeepingExecutorService.setRemoveOnCancelPolicy(true);
/*     */     } else {
/*     */       
/* 118 */       this.houseKeepingExecutorService = paramHikariConfig.getScheduledExecutorService();
/*     */     } 
/*     */     
/* 121 */     this.houseKeepingExecutorService.scheduleAtFixedRate(new HouseKeeper(), this.HOUSEKEEPING_PERIOD_MS, this.HOUSEKEEPING_PERIOD_MS, TimeUnit.MILLISECONDS);
/*     */     
/* 123 */     this.leakTask = new ProxyLeakTask(paramHikariConfig.getLeakDetectionThreshold(), this.houseKeepingExecutorService);
/*     */     
/* 125 */     if (paramHikariConfig.getMetricsTrackerFactory() != null) {
/* 126 */       setMetricsTrackerFactory(paramHikariConfig.getMetricsTrackerFactory());
/*     */     } else {
/*     */       
/* 129 */       setMetricRegistry(paramHikariConfig.getMetricRegistry());
/*     */     } 
/*     */     
/* 132 */     setHealthCheckRegistry(paramHikariConfig.getHealthCheckRegistry());
/*     */     
/* 134 */     registerMBeans(this);
/*     */     
/* 136 */     initializeConnections();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Connection getConnection() {
/* 147 */     return getConnection(this.connectionTimeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Connection getConnection(long paramLong) {
/* 159 */     this.suspendResumeLock.acquire();
/* 160 */     long l = clockSource.currentTime();
/*     */     
/*     */     try {
/* 163 */       long l1 = paramLong;
/*     */       do {
/* 165 */         PoolEntry poolEntry = (PoolEntry)this.connectionBag.borrow(l1, TimeUnit.MILLISECONDS);
/* 166 */         if (poolEntry == null) {
/*     */           break;
/*     */         }
/*     */         
/* 170 */         long l2 = clockSource.currentTime();
/* 171 */         if (poolEntry.isMarkedEvicted() || (clockSource.elapsedMillis(poolEntry.lastAccessed, l2) > this.ALIVE_BYPASS_WINDOW_MS && !isConnectionAlive(poolEntry.connection))) {
/* 172 */           closeConnection(poolEntry, "(connection evicted or dead)");
/* 173 */           l1 = paramLong - clockSource.elapsedMillis(l);
/*     */         } else {
/*     */           
/* 176 */           this.metricsTracker.recordBorrowStats(poolEntry, l);
/* 177 */           return poolEntry.createProxyConnection(this.leakTask.start(poolEntry), l2);
/*     */         } 
/* 179 */       } while (l1 > 0L);
/*     */     }
/* 181 */     catch (InterruptedException interruptedException) {
/* 182 */       throw new SQLException(this.poolName + " - Interrupted during connection acquisition", interruptedException);
/*     */     } finally {
/*     */       
/* 185 */       this.suspendResumeLock.release();
/*     */     } 
/*     */     
/* 188 */     logPoolState(new String[] { "Timeout failure\t" });
/*     */     
/* 190 */     String str = null;
/* 191 */     Throwable throwable = getLastConnectionFailure();
/* 192 */     if (throwable instanceof SQLException) {
/* 193 */       str = ((SQLException)throwable).getSQLState();
/*     */     }
/* 195 */     SQLTransientConnectionException sQLTransientConnectionException = new SQLTransientConnectionException(this.poolName + " - Connection is not available, request timed out after " + clockSource.elapsedMillis(l) + "ms.", str, throwable);
/* 196 */     if (throwable instanceof SQLException) {
/* 197 */       sQLTransientConnectionException.setNextException((SQLException)throwable);
/*     */     }
/* 199 */     throw sQLTransientConnectionException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized void shutdown() {
/*     */     try {
/* 211 */       this.poolState = 2;
/*     */       
/* 213 */       LOGGER.info("{} - is closing down.", this.poolName);
/* 214 */       logPoolState(new String[] { "Before closing\t" });
/*     */       
/* 216 */       softEvictConnections();
/*     */       
/* 218 */       this.addConnectionExecutor.shutdown();
/* 219 */       this.addConnectionExecutor.awaitTermination(5L, TimeUnit.SECONDS);
/* 220 */       if (this.config.getScheduledExecutorService() == null) {
/* 221 */         this.houseKeepingExecutorService.shutdown();
/* 222 */         this.houseKeepingExecutorService.awaitTermination(5L, TimeUnit.SECONDS);
/*     */       } 
/*     */       
/* 225 */       this.connectionBag.close();
/*     */       
/* 227 */       ThreadPoolExecutor threadPoolExecutor = UtilityElf.createThreadPoolExecutor(this.config.getMaximumPoolSize(), "Hikari connection assassin (pool " + this.poolName + ")", this.config
/* 228 */           .getThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
/*     */       try {
/* 230 */         long l = clockSource.currentTime();
/*     */         do {
/* 232 */           abortActiveConnections(threadPoolExecutor);
/* 233 */           softEvictConnections();
/* 234 */         } while (getTotalConnections() > 0 && clockSource.elapsedMillis(l) < TimeUnit.SECONDS.toMillis(5L));
/*     */       } finally {
/*     */         
/* 237 */         threadPoolExecutor.shutdown();
/* 238 */         threadPoolExecutor.awaitTermination(5L, TimeUnit.SECONDS);
/*     */       } 
/*     */       
/* 241 */       shutdownNetworkTimeoutExecutor();
/* 242 */       this.closeConnectionExecutor.shutdown();
/* 243 */       this.closeConnectionExecutor.awaitTermination(5L, TimeUnit.SECONDS);
/*     */     } finally {
/*     */       
/* 246 */       logPoolState(new String[] { "After closing\t" });
/*     */       
/* 248 */       unregisterMBeans();
/* 249 */       this.metricsTracker.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void evictConnection(Connection paramConnection) {
/* 260 */     ProxyConnection proxyConnection = (ProxyConnection)paramConnection;
/* 261 */     proxyConnection.cancelLeakTask();
/*     */     
/* 263 */     softEvictConnection(proxyConnection.getPoolEntry(), "(connection evicted by user)", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMetricRegistry(Object paramObject) {
/* 268 */     this.isRecordMetrics = (paramObject != null);
/* 269 */     if (this.isRecordMetrics) {
/* 270 */       setMetricsTrackerFactory((MetricsTrackerFactory)new CodahaleMetricsTrackerFactory((MetricRegistry)paramObject));
/*     */     } else {
/*     */       
/* 273 */       setMetricsTrackerFactory((MetricsTrackerFactory)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMetricsTrackerFactory(MetricsTrackerFactory paramMetricsTrackerFactory) {
/* 279 */     this.isRecordMetrics = (paramMetricsTrackerFactory != null);
/* 280 */     if (this.isRecordMetrics) {
/* 281 */       this.metricsTracker = new PoolBase.MetricsTrackerDelegate(paramMetricsTrackerFactory.create(this.config.getPoolName(), getPoolStats()));
/*     */     } else {
/*     */       
/* 284 */       this.metricsTracker = new PoolBase.NopMetricsTrackerDelegate();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHealthCheckRegistry(Object paramObject) {
/* 290 */     if (paramObject != null) {
/* 291 */       CodahaleHealthChecker.registerHealthChecks(this, this.config, (HealthCheckRegistry)paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Future<Boolean> addBagItem() {
/* 303 */     return this.addConnectionExecutor.submit(this.POOL_ENTRY_CREATOR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getActiveConnections() {
/* 314 */     return this.connectionBag.getCount(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getIdleConnections() {
/* 321 */     return this.connectionBag.getCount(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getTotalConnections() {
/* 328 */     return this.connectionBag.size() - this.connectionBag.getCount(-1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getThreadsAwaitingConnection() {
/* 335 */     return this.connectionBag.getPendingQueue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void softEvictConnections() {
/* 342 */     for (PoolEntry poolEntry : this.connectionBag.values()) {
/* 343 */       softEvictConnection(poolEntry, "(connection evicted by user)", false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized void suspendPool() {
/* 351 */     if (this.suspendResumeLock == SuspendResumeLock.FAUX_LOCK) {
/* 352 */       throw new IllegalStateException(this.poolName + " - is not suspendable");
/*     */     }
/* 354 */     if (this.poolState != 1) {
/* 355 */       this.suspendResumeLock.suspend();
/* 356 */       this.poolState = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized void resumePool() {
/* 364 */     if (this.poolState == 1) {
/* 365 */       this.poolState = 0;
/* 366 */       fillPool();
/* 367 */       this.suspendResumeLock.resume();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void logPoolState(String... paramVarArgs) {
/* 382 */     if (LOGGER.isDebugEnabled()) {
/* 383 */       LOGGER.debug("{}pool {} stats (total={}, active={}, idle={}, waiting={})", new Object[] { (paramVarArgs.length > 0) ? paramVarArgs[0] : "", this.poolName, 
/*     */             
/* 385 */             Integer.valueOf(getTotalConnections()), Integer.valueOf(getActiveConnections()), Integer.valueOf(getIdleConnections()), Integer.valueOf(getThreadsAwaitingConnection()) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void releaseConnection(PoolEntry paramPoolEntry) {
/* 397 */     this.metricsTracker.recordConnectionUsage(paramPoolEntry);
/*     */     
/* 399 */     this.connectionBag.requite(paramPoolEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void closeConnection(PoolEntry paramPoolEntry, final String closureReason) {
/* 409 */     if (this.connectionBag.remove(paramPoolEntry)) {
/* 410 */       final Connection connection = paramPoolEntry.connection;
/* 411 */       paramPoolEntry.close();
/* 412 */       int i = this.totalConnections.decrementAndGet();
/* 413 */       if (i < 0) {
/* 414 */         LOGGER.warn("{} - Internal accounting inconsistency, totalConnections={}", new Object[] { this.poolName, Integer.valueOf(i), new Exception() });
/*     */       }
/*     */       
/* 417 */       this.closeConnectionExecutor.execute(new Runnable()
/*     */           {
/*     */             public void run() {
/* 420 */               HikariPool.this.quietlyCloseConnection(connection, closureReason);
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PoolEntry createPoolEntry() {
/*     */     try {
/* 436 */       final PoolEntry poolEntry = newPoolEntry();
/*     */       
/* 438 */       long l = this.config.getMaxLifetime();
/* 439 */       if (l > 0L) {
/*     */         
/* 441 */         long l1 = (l > 10000L) ? ThreadLocalRandom.current().nextLong(Math.max(10000L, l / 40L)) : 0L;
/* 442 */         long l2 = l - l1;
/* 443 */         poolEntry.setFutureEol(this.houseKeepingExecutorService.schedule(new Runnable()
/*     */               {
/*     */                 public void run() {
/* 446 */                   HikariPool.this.softEvictConnection(poolEntry, "(connection reached maxLifetime)", false);
/*     */                 }
/*     */               }l2, TimeUnit.MILLISECONDS));
/*     */       } 
/*     */       
/* 451 */       LOGGER.debug("{} - Added connection {}", this.poolName, poolEntry.connection);
/* 452 */       return poolEntry;
/*     */     }
/* 454 */     catch (Exception exception) {
/* 455 */       if (this.poolState == 0) {
/* 456 */         LOGGER.debug("{} - Cannot acquire connection from data source", this.poolName, exception);
/*     */       }
/* 458 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillPool() {
/* 467 */     int i = Math.min(this.config.getMaximumPoolSize() - this.totalConnections.get(), this.config.getMinimumIdle() - getIdleConnections());
/* 468 */     for (byte b = 0; b < i; b++) {
/* 469 */       addBagItem();
/*     */     }
/*     */     
/* 472 */     if (i > 0 && LOGGER.isDebugEnabled()) {
/* 473 */       this.addConnectionExecutor.execute(new Runnable()
/*     */           {
/*     */             public void run() {
/* 476 */               HikariPool.this.logPoolState(new String[] { "After adding\t" });
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void abortActiveConnections(ExecutorService paramExecutorService) {
/* 487 */     for (PoolEntry poolEntry : this.connectionBag.values(1)) {
/*     */       try {
/* 489 */         poolEntry.connection.abort(paramExecutorService);
/*     */       }
/* 491 */       catch (Throwable throwable) {
/* 492 */         quietlyCloseConnection(poolEntry.connection, "(connection aborted during shutdown)");
/*     */       } finally {
/*     */         
/* 495 */         poolEntry.close();
/* 496 */         if (this.connectionBag.remove(poolEntry)) {
/* 497 */           this.totalConnections.decrementAndGet();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initializeConnections() {
/* 508 */     if (this.config.isInitializationFailFast()) {
/*     */       try {
/* 510 */         Connection connection = getConnection();
/* 511 */         if (this.config.getMinimumIdle() == 0) {
/* 512 */           evictConnection(connection);
/*     */         } else {
/*     */           
/* 515 */           connection.close();
/*     */         }
/*     */       
/* 518 */       } catch (Throwable throwable) {
/*     */         try {
/* 520 */           shutdown();
/*     */         }
/* 522 */         catch (Throwable throwable1) {
/* 523 */           throwable.addSuppressed(throwable1);
/*     */         } 
/*     */         
/* 526 */         throw new PoolInitializationException(throwable);
/*     */       } 
/*     */     }
/*     */     
/* 530 */     fillPool();
/*     */   }
/*     */ 
/*     */   
/*     */   private void softEvictConnection(PoolEntry paramPoolEntry, String paramString, boolean paramBoolean) {
/* 535 */     if (paramBoolean || this.connectionBag.reserve(paramPoolEntry)) {
/* 536 */       closeConnection(paramPoolEntry, paramString);
/*     */     } else {
/*     */       
/* 539 */       paramPoolEntry.markEvicted();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private PoolStats getPoolStats() {
/* 545 */     return new PoolStats(TimeUnit.SECONDS.toMillis(1L))
/*     */       {
/*     */         protected void update() {
/* 548 */           this.pendingThreads = HikariPool.this.getThreadsAwaitingConnection();
/* 549 */           this.idleConnections = HikariPool.this.getIdleConnections();
/* 550 */           this.totalConnections = HikariPool.this.getTotalConnections();
/* 551 */           this.activeConnections = HikariPool.this.getActiveConnections();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class PoolEntryCreator
/*     */     implements Callable<Boolean>
/*     */   {
/*     */     private PoolEntryCreator() {}
/*     */ 
/*     */     
/*     */     public Boolean call() {
/* 565 */       long l = 200L;
/* 566 */       while (HikariPool.this.poolState == 0 && HikariPool.this.totalConnections.get() < HikariPool.this.config.getMaximumPoolSize()) {
/* 567 */         PoolEntry poolEntry = HikariPool.this.createPoolEntry();
/* 568 */         if (poolEntry != null) {
/* 569 */           HikariPool.this.totalConnections.incrementAndGet();
/* 570 */           HikariPool.this.connectionBag.add(poolEntry);
/* 571 */           return Boolean.TRUE;
/*     */         } 
/*     */ 
/*     */         
/* 575 */         UtilityElf.quietlySleep(l);
/* 576 */         l = Math.min(HikariPool.this.connectionTimeout / 2L, (long)(l * 1.3D));
/*     */       } 
/*     */       
/* 579 */       return Boolean.FALSE;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class HouseKeeper
/*     */     implements Runnable
/*     */   {
/* 588 */     private volatile long previous = HikariPool.clockSource.currentTime();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 594 */       HikariPool.this.connectionTimeout = HikariPool.this.config.getConnectionTimeout();
/* 595 */       HikariPool.this.leakTask.updateLeakDetectionThreshold(HikariPool.this.config.getLeakDetectionThreshold());
/*     */       
/* 597 */       long l1 = HikariPool.clockSource.currentTime();
/* 598 */       long l2 = HikariPool.this.config.getIdleTimeout();
/*     */ 
/*     */       
/* 601 */       if (l1 < this.previous || l1 > HikariPool.clockSource.plusMillis(this.previous, 2L * HikariPool.this.HOUSEKEEPING_PERIOD_MS)) {
/* 602 */         HikariPool.LOGGER.warn("{} - Unusual system clock change detected, soft-evicting connections from pool.", HikariPool.this.poolName);
/* 603 */         this.previous = l1;
/* 604 */         HikariPool.this.softEvictConnections();
/* 605 */         HikariPool.this.fillPool();
/*     */         
/*     */         return;
/*     */       } 
/* 609 */       this.previous = l1;
/*     */       
/* 611 */       HikariPool.this.logPoolState(new String[] { "Before cleanup\t" });
/*     */       
/* 613 */       if (l2 > 0L) {
/* 614 */         List<PoolEntry> list = HikariPool.this.connectionBag.values(0);
/* 615 */         int i = list.size() - HikariPool.this.config.getMinimumIdle();
/* 616 */         if (i > 0) {
/*     */           
/* 618 */           Collections.sort(list, PoolEntry.LASTACCESS_COMPARABLE);
/*     */           
/* 620 */           Iterator<PoolEntry> iterator = list.iterator();
/*     */           do {
/* 622 */             PoolEntry poolEntry = iterator.next();
/* 623 */             if (HikariPool.clockSource.elapsedMillis(poolEntry.lastAccessed, l1) <= l2 || !HikariPool.this.connectionBag.reserve(poolEntry))
/* 624 */               continue;  HikariPool.this.closeConnection(poolEntry, "(connection passed idleTimeout)");
/* 625 */             i--;
/*     */           }
/* 627 */           while (i > 0 && iterator.hasNext());
/*     */         } 
/*     */       } 
/*     */       
/* 631 */       HikariPool.this.logPoolState(new String[] { "After cleanup\t" });
/*     */       
/* 633 */       HikariPool.this.fillPool();
/*     */     }
/*     */ 
/*     */     
/*     */     private HouseKeeper() {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static class PoolInitializationException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 929872118275916520L;
/*     */     
/*     */     public PoolInitializationException(Throwable param1Throwable) {
/* 647 */       super("Exception during pool initialization: " + param1Throwable.getMessage(), param1Throwable);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/HikariPool.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */