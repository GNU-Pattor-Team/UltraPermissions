/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.pool;
/*     */ 
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.Properties;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import javax.management.MBeanServer;
/*     */ import javax.management.ObjectName;
/*     */ import javax.sql.DataSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariConfig;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.MetricsTracker;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.ClockSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.DefaultThreadFactory;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.DriverDataSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.PropertyElf;
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
/*     */ abstract class PoolBase
/*     */ {
/*  39 */   private final Logger LOGGER = LoggerFactory.getLogger(PoolBase.class);
/*     */   
/*     */   protected final HikariConfig config;
/*     */   protected final String poolName;
/*     */   protected long connectionTimeout;
/*  44 */   private static final String[] RESET_STATES = new String[] { "readOnly", "autoCommit", "isolation", "catalog", "netTimeout" };
/*     */   
/*     */   private static final int UNINITIALIZED = -1;
/*     */   
/*     */   private static final int TRUE = 1;
/*     */   
/*     */   private static final int FALSE = 0;
/*     */   
/*     */   private int networkTimeout;
/*     */   private int transactionIsolation;
/*     */   private int isNetworkTimeoutSupported;
/*     */   private int isQueryTimeoutSupported;
/*     */   private Executor netTimeoutExecutor;
/*     */   private DataSource dataSource;
/*     */   private final String catalog;
/*     */   private final boolean isReadOnly;
/*     */   private final boolean isAutoCommit;
/*     */   private final boolean isUseJdbc4Validation;
/*     */   private final boolean isIsolateInternalQueries;
/*     */   private final AtomicReference<Throwable> lastConnectionFailure;
/*     */   private volatile boolean isValidChecked;
/*     */   
/*     */   PoolBase(HikariConfig paramHikariConfig) {
/*  67 */     this.config = paramHikariConfig;
/*     */     
/*  69 */     this.networkTimeout = -1;
/*  70 */     this.catalog = paramHikariConfig.getCatalog();
/*  71 */     this.isReadOnly = paramHikariConfig.isReadOnly();
/*  72 */     this.isAutoCommit = paramHikariConfig.isAutoCommit();
/*  73 */     this.transactionIsolation = UtilityElf.getTransactionIsolation(paramHikariConfig.getTransactionIsolation());
/*     */     
/*  75 */     this.isQueryTimeoutSupported = -1;
/*  76 */     this.isNetworkTimeoutSupported = -1;
/*  77 */     this.isUseJdbc4Validation = (paramHikariConfig.getConnectionTestQuery() == null);
/*  78 */     this.isIsolateInternalQueries = paramHikariConfig.isIsolateInternalQueries();
/*     */     
/*  80 */     this.poolName = paramHikariConfig.getPoolName();
/*  81 */     this.connectionTimeout = paramHikariConfig.getConnectionTimeout();
/*  82 */     this.lastConnectionFailure = new AtomicReference<>();
/*     */     
/*  84 */     initializeDataSource();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  91 */     return this.poolName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void releaseConnection(PoolEntry paramPoolEntry);
/*     */ 
/*     */ 
/*     */   
/*     */   void quietlyCloseConnection(Connection paramConnection, String paramString) {
/* 102 */     if (paramConnection == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 107 */       this.LOGGER.debug("{} - Closing connection {}: {}", new Object[] { this.poolName, paramConnection, paramString });
/*     */       try {
/* 109 */         setNetworkTimeout(paramConnection, TimeUnit.SECONDS.toMillis(15L));
/*     */       }
/*     */       finally {
/*     */         
/* 113 */         paramConnection.close();
/*     */       }
/*     */     
/* 116 */     } catch (Throwable throwable) {
/* 117 */       this.LOGGER.debug("{} - Closing connection {} failed", new Object[] { this.poolName, paramConnection, throwable });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isConnectionAlive(Connection paramConnection) {
/*     */     try {
/* 124 */       long l = this.config.getValidationTimeout();
/*     */       
/* 126 */       if (this.isUseJdbc4Validation) {
/* 127 */         return paramConnection.isValid((int)TimeUnit.MILLISECONDS.toSeconds(l));
/*     */       }
/*     */       
/* 130 */       int i = getAndSetNetworkTimeout(paramConnection, l);
/*     */       
/* 132 */       try (Statement null = paramConnection.createStatement()) {
/* 133 */         if (this.isNetworkTimeoutSupported != 1) {
/* 134 */           setQueryTimeout(statement, (int)TimeUnit.MILLISECONDS.toSeconds(l));
/*     */         }
/*     */         
/* 137 */         statement.execute(this.config.getConnectionTestQuery());
/*     */       } 
/*     */       
/* 140 */       if (this.isIsolateInternalQueries && !this.isReadOnly && !this.isAutoCommit) {
/* 141 */         paramConnection.rollback();
/*     */       }
/*     */       
/* 144 */       setNetworkTimeout(paramConnection, i);
/*     */       
/* 146 */       return true;
/*     */     }
/* 148 */     catch (SQLException sQLException) {
/* 149 */       this.lastConnectionFailure.set(sQLException);
/* 150 */       this.LOGGER.warn("{} - Connection {} failed alive test with exception {}", new Object[] { this.poolName, paramConnection, sQLException.getMessage() });
/* 151 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   Throwable getLastConnectionFailure() {
/* 157 */     return this.lastConnectionFailure.getAndSet(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataSource getUnwrappedDataSource() {
/* 162 */     return this.dataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PoolEntry newPoolEntry() {
/* 171 */     return new PoolEntry(newConnection(), this, this.isReadOnly, this.isAutoCommit);
/*     */   }
/*     */ 
/*     */   
/*     */   void resetConnectionState(Connection paramConnection, ProxyConnection paramProxyConnection, int paramInt) {
/* 176 */     int i = 0;
/*     */     
/* 178 */     if ((paramInt & 0x1) != 0 && paramProxyConnection.getReadOnlyState() != this.isReadOnly) {
/* 179 */       paramConnection.setReadOnly(this.isReadOnly);
/* 180 */       i |= 0x1;
/*     */     } 
/*     */     
/* 183 */     if ((paramInt & 0x2) != 0 && paramProxyConnection.getAutoCommitState() != this.isAutoCommit) {
/* 184 */       paramConnection.setAutoCommit(this.isAutoCommit);
/* 185 */       i |= 0x2;
/*     */     } 
/*     */     
/* 188 */     if ((paramInt & 0x4) != 0 && paramProxyConnection.getTransactionIsolationState() != this.transactionIsolation) {
/* 189 */       paramConnection.setTransactionIsolation(this.transactionIsolation);
/* 190 */       i |= 0x4;
/*     */     } 
/*     */     
/* 193 */     if ((paramInt & 0x8) != 0 && this.catalog != null && !this.catalog.equals(paramProxyConnection.getCatalogState())) {
/* 194 */       paramConnection.setCatalog(this.catalog);
/* 195 */       i |= 0x8;
/*     */     } 
/*     */     
/* 198 */     if ((paramInt & 0x10) != 0 && paramProxyConnection.getNetworkTimeoutState() != this.networkTimeout) {
/* 199 */       setNetworkTimeout(paramConnection, this.networkTimeout);
/* 200 */       i |= 0x10;
/*     */     } 
/*     */     
/* 203 */     if (this.LOGGER.isDebugEnabled()) {
/* 204 */       this.LOGGER.debug("{} - Reset ({}) on connection {}", new Object[] { this.poolName, (i != 0) ? stringFromResetBits(i) : "nothing", paramConnection });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void shutdownNetworkTimeoutExecutor() {
/* 210 */     if (this.netTimeoutExecutor != null && this.netTimeoutExecutor instanceof ThreadPoolExecutor) {
/* 211 */       ((ThreadPoolExecutor)this.netTimeoutExecutor).shutdownNow();
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
/*     */   void registerMBeans(HikariPool paramHikariPool) {
/* 226 */     if (!this.config.isRegisterMbeans()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 231 */       MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
/*     */       
/* 233 */       ObjectName objectName1 = new ObjectName("me.TechsCode.UltraPermissions.dependencies.hikari:type=PoolConfig (" + this.poolName + ")");
/* 234 */       ObjectName objectName2 = new ObjectName("me.TechsCode.UltraPermissions.dependencies.hikari:type=Pool (" + this.poolName + ")");
/* 235 */       if (!mBeanServer.isRegistered(objectName1)) {
/* 236 */         mBeanServer.registerMBean(this.config, objectName1);
/* 237 */         mBeanServer.registerMBean(paramHikariPool, objectName2);
/*     */       } else {
/*     */         
/* 240 */         this.LOGGER.error("{} - You cannot use the same pool name for separate pool instances.", this.poolName);
/*     */       }
/*     */     
/* 243 */     } catch (Exception exception) {
/* 244 */       this.LOGGER.warn("{} - Unable to register management beans.", this.poolName, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void unregisterMBeans() {
/* 253 */     if (!this.config.isRegisterMbeans()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 258 */       MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
/*     */       
/* 260 */       ObjectName objectName1 = new ObjectName("me.TechsCode.UltraPermissions.dependencies.hikari:type=PoolConfig (" + this.poolName + ")");
/* 261 */       ObjectName objectName2 = new ObjectName("me.TechsCode.UltraPermissions.dependencies.hikari:type=Pool (" + this.poolName + ")");
/* 262 */       if (mBeanServer.isRegistered(objectName1)) {
/* 263 */         mBeanServer.unregisterMBean(objectName1);
/* 264 */         mBeanServer.unregisterMBean(objectName2);
/*     */       }
/*     */     
/* 267 */     } catch (Exception exception) {
/* 268 */       this.LOGGER.warn("{} - Unable to unregister management beans.", this.poolName, exception);
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
/*     */   private void initializeDataSource() {
/*     */     DriverDataSource driverDataSource;
/* 283 */     String str1 = this.config.getJdbcUrl();
/* 284 */     String str2 = this.config.getUsername();
/* 285 */     String str3 = this.config.getPassword();
/* 286 */     String str4 = this.config.getDataSourceClassName();
/* 287 */     String str5 = this.config.getDriverClassName();
/* 288 */     Properties properties = this.config.getDataSourceProperties();
/*     */     
/* 290 */     DataSource dataSource = this.config.getDataSource();
/* 291 */     if (str4 != null && dataSource == null) {
/* 292 */       dataSource = (DataSource)UtilityElf.createInstance(str4, DataSource.class, new Object[0]);
/* 293 */       PropertyElf.setTargetFromProperties(dataSource, properties);
/*     */     }
/* 295 */     else if (str1 != null && dataSource == null) {
/* 296 */       driverDataSource = new DriverDataSource(str1, str5, properties, str2, str3);
/*     */     } 
/*     */     
/* 299 */     if (driverDataSource != null) {
/* 300 */       setLoginTimeout((DataSource)driverDataSource, this.connectionTimeout);
/* 301 */       createNetworkTimeoutExecutor((DataSource)driverDataSource, str4, str1);
/*     */     } 
/*     */     
/* 304 */     this.dataSource = (DataSource)driverDataSource;
/*     */   }
/*     */ 
/*     */   
/*     */   private Connection newConnection() {
/* 309 */     Connection connection = null;
/*     */     try {
/* 311 */       String str1 = this.config.getUsername();
/* 312 */       String str2 = this.config.getPassword();
/*     */       
/* 314 */       connection = (str1 == null) ? this.dataSource.getConnection() : this.dataSource.getConnection(str1, str2);
/* 315 */       setupConnection(connection);
/* 316 */       this.lastConnectionFailure.set(null);
/* 317 */       return connection;
/*     */     }
/* 319 */     catch (Exception exception) {
/* 320 */       this.lastConnectionFailure.set(exception);
/* 321 */       quietlyCloseConnection(connection, "(exception during connection creation)");
/* 322 */       throw exception;
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
/*     */   private void setupConnection(Connection paramConnection) {
/* 334 */     this.networkTimeout = getAndSetNetworkTimeout(paramConnection, this.connectionTimeout);
/*     */     
/* 336 */     checkValidationMode(paramConnection);
/*     */     
/* 338 */     paramConnection.setAutoCommit(this.isAutoCommit);
/* 339 */     paramConnection.setReadOnly(this.isReadOnly);
/*     */     
/* 341 */     int i = paramConnection.getTransactionIsolation();
/* 342 */     this.transactionIsolation = (this.transactionIsolation < 0 || i == 0) ? i : this.transactionIsolation;
/*     */ 
/*     */     
/* 345 */     if (this.transactionIsolation != i) {
/* 346 */       paramConnection.setTransactionIsolation(this.transactionIsolation);
/*     */     }
/*     */     
/* 349 */     if (this.catalog != null) {
/* 350 */       paramConnection.setCatalog(this.catalog);
/*     */     }
/*     */     
/* 353 */     executeSql(paramConnection, this.config.getConnectionInitSql(), (this.isIsolateInternalQueries && !this.isAutoCommit), false);
/*     */     
/* 355 */     setNetworkTimeout(paramConnection, this.networkTimeout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkValidationMode(Connection paramConnection) {
/* 365 */     if (!this.isValidChecked) {
/* 366 */       if (this.isUseJdbc4Validation) {
/*     */         try {
/* 368 */           paramConnection.isValid(1);
/*     */         }
/* 370 */         catch (Throwable throwable) {
/* 371 */           this.LOGGER.debug("{} - Connection.isValid() is not supported, configure connection test query. ({})", this.poolName, throwable.getMessage());
/* 372 */           throw throwable;
/*     */         } 
/*     */       } else {
/*     */         
/*     */         try {
/* 377 */           executeSql(paramConnection, this.config.getConnectionTestQuery(), false, (this.isIsolateInternalQueries && !this.isAutoCommit));
/*     */         }
/* 379 */         catch (Throwable throwable) {
/* 380 */           this.LOGGER.debug("{} - Exception during executing connection test query. ({})", this.poolName, throwable.getMessage());
/* 381 */           throw throwable;
/*     */         } 
/*     */       } 
/* 384 */       this.isValidChecked = true;
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
/*     */   private void setQueryTimeout(Statement paramStatement, int paramInt) {
/* 396 */     if (this.isQueryTimeoutSupported != 0) {
/*     */       try {
/* 398 */         paramStatement.setQueryTimeout(paramInt);
/* 399 */         this.isQueryTimeoutSupported = 1;
/*     */       }
/* 401 */       catch (Throwable throwable) {
/* 402 */         if (this.isQueryTimeoutSupported == -1) {
/* 403 */           this.isQueryTimeoutSupported = 0;
/* 404 */           this.LOGGER.debug("{} - Statement.setQueryTimeout() is not supported ({})", this.poolName, throwable.getMessage());
/*     */         } 
/*     */       } 
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
/*     */   private int getAndSetNetworkTimeout(Connection paramConnection, long paramLong) {
/* 420 */     if (this.isNetworkTimeoutSupported != 0) {
/*     */       try {
/* 422 */         int i = paramConnection.getNetworkTimeout();
/* 423 */         paramConnection.setNetworkTimeout(this.netTimeoutExecutor, (int)paramLong);
/* 424 */         this.isNetworkTimeoutSupported = 1;
/* 425 */         return i;
/*     */       }
/* 427 */       catch (Throwable throwable) {
/* 428 */         if (this.isNetworkTimeoutSupported == -1) {
/* 429 */           this.isNetworkTimeoutSupported = 0;
/* 430 */           this.LOGGER.debug("{} - Connection.setNetworkTimeout() is not supported ({})", this.poolName, throwable.getMessage());
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 435 */     return 0;
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
/*     */   private void setNetworkTimeout(Connection paramConnection, long paramLong) {
/* 448 */     if (this.isNetworkTimeoutSupported == 1) {
/* 449 */       paramConnection.setNetworkTimeout(this.netTimeoutExecutor, (int)paramLong);
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
/*     */   private void executeSql(Connection paramConnection, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 463 */     if (paramString != null) {
/* 464 */       try (Statement null = paramConnection.createStatement()) {
/*     */ 
/*     */         
/* 467 */         statement.execute(paramString);
/*     */         
/* 469 */         if (!this.isReadOnly) {
/* 470 */           if (paramBoolean1) {
/* 471 */             paramConnection.commit();
/*     */           }
/* 473 */           else if (paramBoolean2) {
/* 474 */             paramConnection.rollback();
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void createNetworkTimeoutExecutor(DataSource paramDataSource, String paramString1, String paramString2) {
/* 484 */     if ((paramString1 != null && paramString1.contains("Mysql")) || (paramString2 != null && paramString2
/* 485 */       .contains("mysql")) || (paramDataSource != null && paramDataSource
/* 486 */       .getClass().getName().contains("Mysql"))) {
/* 487 */       this.netTimeoutExecutor = new SynchronousExecutor();
/*     */     } else {
/*     */       
/* 490 */       ThreadFactory threadFactory = (ThreadFactory)((this.config.getThreadFactory() != null) ? this.config.getThreadFactory() : new DefaultThreadFactory("Hikari JDBC-timeout executor", true));
/* 491 */       ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newCachedThreadPool(threadFactory);
/* 492 */       threadPoolExecutor.allowCoreThreadTimeOut(true);
/* 493 */       threadPoolExecutor.setKeepAliveTime(15L, TimeUnit.SECONDS);
/* 494 */       this.netTimeoutExecutor = threadPoolExecutor;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class SynchronousExecutor
/*     */     implements Executor
/*     */   {
/*     */     private SynchronousExecutor() {}
/*     */     
/*     */     public void execute(Runnable param1Runnable) {
/*     */       try {
/* 505 */         param1Runnable.run();
/*     */       }
/* 507 */       catch (Throwable throwable) {
/* 508 */         LoggerFactory.getLogger(PoolBase.class).debug("Exception executing {}", param1Runnable, throwable);
/*     */       } 
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
/*     */   private void setLoginTimeout(DataSource paramDataSource, long paramLong) {
/* 521 */     if (paramLong != 2147483647L) {
/*     */       try {
/* 523 */         paramDataSource.setLoginTimeout((int)TimeUnit.MILLISECONDS.toSeconds(Math.max(1000L, paramLong)));
/*     */       }
/* 525 */       catch (Throwable throwable) {
/* 526 */         this.LOGGER.warn("{} - Unable to set DataSource login timeout", this.poolName, throwable);
/*     */       } 
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
/*     */   
/*     */   private String stringFromResetBits(int paramInt) {
/* 543 */     StringBuilder stringBuilder = new StringBuilder();
/* 544 */     for (byte b = 0; b < RESET_STATES.length; b++) {
/* 545 */       if ((paramInt & 1 << b) != 0) {
/* 546 */         stringBuilder.append(RESET_STATES[b]).append(", ");
/*     */       }
/*     */     } 
/*     */     
/* 550 */     stringBuilder.setLength(stringBuilder.length() - 2);
/* 551 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   static class MetricsTrackerDelegate
/*     */     implements AutoCloseable
/*     */   {
/*     */     final MetricsTracker tracker;
/*     */     
/*     */     protected MetricsTrackerDelegate() {
/* 560 */       this.tracker = null;
/*     */     }
/*     */ 
/*     */     
/*     */     MetricsTrackerDelegate(MetricsTracker param1MetricsTracker) {
/* 565 */       this.tracker = param1MetricsTracker;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void close() {
/* 571 */       this.tracker.close();
/*     */     }
/*     */ 
/*     */     
/*     */     void recordConnectionUsage(PoolEntry param1PoolEntry) {
/* 576 */       this.tracker.recordConnectionUsageMillis(param1PoolEntry.getMillisSinceBorrowed());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void recordBorrowStats(PoolEntry param1PoolEntry, long param1Long) {
/* 585 */       long l = ClockSource.INSTANCE.currentTime();
/* 586 */       param1PoolEntry.lastBorrowed = l;
/* 587 */       this.tracker.recordConnectionAcquiredNanos(ClockSource.INSTANCE.elapsedNanos(param1Long, l));
/*     */     }
/*     */   }
/*     */   
/*     */   static final class NopMetricsTrackerDelegate extends MetricsTrackerDelegate {
/*     */     void recordConnectionUsage(PoolEntry param1PoolEntry) {}
/*     */     
/*     */     public void close() {}
/*     */     
/*     */     void recordBorrowStats(PoolEntry param1PoolEntry, long param1Long) {}
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/PoolBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */