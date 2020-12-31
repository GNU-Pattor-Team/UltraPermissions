/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLFeatureNotSupportedException;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.logging.Logger;
/*     */ import javax.sql.DataSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.MetricsTrackerFactory;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.pool.HikariPool;
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
/*     */ public class HikariDataSource
/*     */   extends HikariConfig
/*     */   implements DataSource, Closeable
/*     */ {
/*  41 */   private static final Logger LOGGER = LoggerFactory.getLogger(HikariDataSource.class);
/*     */   
/*  43 */   private final AtomicBoolean isShutdown = new AtomicBoolean();
/*     */ 
/*     */ 
/*     */   
/*     */   private final HikariPool fastPathPool;
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile HikariPool pool;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HikariDataSource() {
/*  57 */     this.fastPathPool = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HikariDataSource(HikariConfig paramHikariConfig) {
/*  67 */     paramHikariConfig.validate();
/*  68 */     paramHikariConfig.copyState(this);
/*     */     
/*  70 */     LOGGER.info("{} - is starting.", paramHikariConfig.getPoolName());
/*  71 */     this.pool = this.fastPathPool = new HikariPool(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() {
/*  78 */     if (isClosed()) {
/*  79 */       throw new SQLException("HikariDataSource " + this + " has been closed.");
/*     */     }
/*     */     
/*  82 */     if (this.fastPathPool != null) {
/*  83 */       return this.fastPathPool.getConnection();
/*     */     }
/*     */ 
/*     */     
/*  87 */     HikariPool hikariPool = this.pool;
/*  88 */     if (hikariPool == null) {
/*  89 */       synchronized (this) {
/*  90 */         hikariPool = this.pool;
/*  91 */         if (hikariPool == null) {
/*  92 */           validate();
/*  93 */           LOGGER.info("{} - is starting.", getPoolName());
/*  94 */           this.pool = hikariPool = new HikariPool(this);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  99 */     return hikariPool.getConnection();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection(String paramString1, String paramString2) {
/* 106 */     throw new SQLFeatureNotSupportedException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintWriter getLogWriter() {
/* 113 */     return (this.pool != null) ? this.pool.getUnwrappedDataSource().getLogWriter() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogWriter(PrintWriter paramPrintWriter) {
/* 120 */     if (this.pool != null) {
/* 121 */       this.pool.getUnwrappedDataSource().setLogWriter(paramPrintWriter);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginTimeout(int paramInt) {
/* 129 */     if (this.pool != null) {
/* 130 */       this.pool.getUnwrappedDataSource().setLoginTimeout(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLoginTimeout() {
/* 138 */     return (this.pool != null) ? this.pool.getUnwrappedDataSource().getLoginTimeout() : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getParentLogger() {
/* 145 */     throw new SQLFeatureNotSupportedException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T unwrap(Class<T> paramClass) {
/* 153 */     if (paramClass.isInstance(this)) {
/* 154 */       return (T)this;
/*     */     }
/*     */     
/* 157 */     if (this.pool != null) {
/* 158 */       if (paramClass.isInstance(this.pool.getUnwrappedDataSource())) {
/* 159 */         return (T)this.pool.getUnwrappedDataSource();
/*     */       }
/*     */       
/* 162 */       if (this.pool.getUnwrappedDataSource() != null) {
/* 163 */         return this.pool.getUnwrappedDataSource().unwrap(paramClass);
/*     */       }
/*     */     } 
/*     */     
/* 167 */     throw new SQLException("Wrapped DataSource is not an instance of " + paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> paramClass) {
/* 174 */     if (paramClass.isInstance(this)) {
/* 175 */       return true;
/*     */     }
/*     */     
/* 178 */     if (this.pool != null) {
/* 179 */       if (paramClass.isInstance(this.pool.getUnwrappedDataSource())) {
/* 180 */         return true;
/*     */       }
/*     */       
/* 183 */       if (this.pool.getUnwrappedDataSource() != null) {
/* 184 */         return this.pool.getUnwrappedDataSource().isWrapperFor(paramClass);
/*     */       }
/*     */     } 
/*     */     
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMetricRegistry(Object paramObject) {
/* 195 */     boolean bool = (getMetricRegistry() != null) ? true : false;
/* 196 */     super.setMetricRegistry(paramObject);
/*     */     
/* 198 */     if (this.pool != null) {
/* 199 */       if (bool) {
/* 200 */         throw new IllegalStateException("MetricRegistry can only be set one time");
/*     */       }
/*     */       
/* 203 */       this.pool.setMetricRegistry(getMetricRegistry());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMetricsTrackerFactory(MetricsTrackerFactory paramMetricsTrackerFactory) {
/* 212 */     boolean bool = (getMetricsTrackerFactory() != null) ? true : false;
/* 213 */     super.setMetricsTrackerFactory(paramMetricsTrackerFactory);
/*     */     
/* 215 */     if (this.pool != null) {
/* 216 */       if (bool) {
/* 217 */         throw new IllegalStateException("MetricsTrackerFactory can only be set one time");
/*     */       }
/*     */       
/* 220 */       this.pool.setMetricsTrackerFactory(getMetricsTrackerFactory());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHealthCheckRegistry(Object paramObject) {
/* 229 */     boolean bool = (getHealthCheckRegistry() != null) ? true : false;
/* 230 */     super.setHealthCheckRegistry(paramObject);
/*     */     
/* 232 */     if (this.pool != null) {
/* 233 */       if (bool) {
/* 234 */         throw new IllegalStateException("HealthCheckRegistry can only be set one time");
/*     */       }
/*     */       
/* 237 */       this.pool.setHealthCheckRegistry(getHealthCheckRegistry());
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
/*     */   public void evictConnection(Connection paramConnection) {
/* 249 */     if (!isClosed() && this.pool != null && paramConnection.getClass().getName().startsWith("me.TechsCode.UltraPermissions.dependencies.hikari")) {
/* 250 */       this.pool.evictConnection(paramConnection);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void suspendPool() {
/* 260 */     if (!isClosed() && this.pool != null) {
/* 261 */       this.pool.suspendPool();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resumePool() {
/* 270 */     if (!isClosed() && this.pool != null) {
/* 271 */       this.pool.resumePool();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 281 */     if (this.isShutdown.getAndSet(true)) {
/*     */       return;
/*     */     }
/*     */     
/* 285 */     if (this.pool != null) {
/*     */       try {
/* 287 */         this.pool.shutdown();
/*     */       }
/* 289 */       catch (InterruptedException interruptedException) {
/* 290 */         LOGGER.warn("Interrupted during closing", interruptedException);
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
/*     */   public boolean isClosed() {
/* 302 */     return this.isShutdown.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void shutdown() {
/* 313 */     LOGGER.warn("The shutdown() method has been deprecated, please use the close() method instead");
/* 314 */     close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 321 */     return "HikariDataSource (" + this.pool + ")";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/HikariDataSource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */