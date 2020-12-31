/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Properties;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.naming.NamingException;
/*     */ import javax.sql.DataSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.MetricsTrackerFactory;
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
/*     */ public class HikariConfig
/*     */   implements HikariConfigMXBean
/*     */ {
/*  49 */   private static final Logger LOGGER = LoggerFactory.getLogger(HikariConfig.class);
/*     */   
/*  51 */   private static final long CONNECTION_TIMEOUT = TimeUnit.SECONDS.toMillis(30L);
/*  52 */   private static final long VALIDATION_TIMEOUT = TimeUnit.SECONDS.toMillis(5L);
/*  53 */   private static final long IDLE_TIMEOUT = TimeUnit.MINUTES.toMillis(10L);
/*  54 */   private static final long MAX_LIFETIME = TimeUnit.MINUTES.toMillis(30L);
/*     */   
/*  56 */   private static final AtomicInteger POOL_NUMBER = new AtomicInteger();
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
/* 102 */   private Properties dataSourceProperties = new Properties();
/* 103 */   private Properties healthCheckProperties = new Properties();
/*     */   
/* 105 */   private volatile long connectionTimeout = CONNECTION_TIMEOUT;
/* 106 */   private volatile long validationTimeout = VALIDATION_TIMEOUT;
/* 107 */   private volatile long idleTimeout = IDLE_TIMEOUT;
/*     */   private boolean isAutoCommit = true;
/*     */   private boolean isInitializationFailFast = true;
/* 110 */   private volatile int minIdle = -1;
/* 111 */   private volatile int maxPoolSize = 10; private static boolean unitTest; private volatile long leakDetectionThreshold; private String catalog; private String connectionInitSql; private String connectionTestQuery; private String dataSourceClassName;
/* 112 */   private volatile long maxLifetime = MAX_LIFETIME; private String dataSourceJndiName; private String driverClassName; private String jdbcUrl; private String password; private String poolName;
/*     */   public HikariConfig() {
/* 114 */     String str = System.getProperty("hikaricp.configurationFile");
/* 115 */     if (str != null)
/* 116 */       loadProperties(str); 
/*     */   }
/*     */   private String transactionIsolationName; private String username; private boolean isReadOnly; private boolean isIsolateInternalQueries; private boolean isRegisterMbeans; private boolean isAllowPoolSuspension;
/*     */   private DataSource dataSource;
/*     */   private ThreadFactory threadFactory;
/*     */   private ScheduledThreadPoolExecutor scheduledExecutor;
/*     */   private MetricsTrackerFactory metricsTrackerFactory;
/*     */   private Object metricRegistry;
/*     */   private Object healthCheckRegistry;
/*     */   
/*     */   public HikariConfig(Properties paramProperties) {
/* 127 */     this();
/* 128 */     PropertyElf.setTargetFromProperties(this, paramProperties);
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
/*     */   public HikariConfig(String paramString) {
/* 140 */     this();
/*     */     
/* 142 */     loadProperties(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCatalog() {
/* 152 */     return this.catalog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatalog(String paramString) {
/* 162 */     this.catalog = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConnectionTestQuery() {
/* 172 */     return this.connectionTestQuery;
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
/*     */   public void setConnectionTestQuery(String paramString) {
/* 185 */     this.connectionTestQuery = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConnectionInitSql() {
/* 196 */     return this.connectionInitSql;
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
/*     */   public void setConnectionInitSql(String paramString) {
/* 208 */     this.connectionInitSql = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getConnectionTimeout() {
/* 215 */     return this.connectionTimeout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConnectionTimeout(long paramLong) {
/* 222 */     if (paramLong == 0L) {
/* 223 */       this.connectionTimeout = 2147483647L;
/*     */     } else {
/* 225 */       if (paramLong < 1000L) {
/* 226 */         throw new IllegalArgumentException("connectionTimeout cannot be less than 1000ms");
/*     */       }
/*     */       
/* 229 */       this.connectionTimeout = paramLong;
/*     */     } 
/*     */     
/* 232 */     if (this.validationTimeout > paramLong && paramLong > 0L) {
/* 233 */       this.validationTimeout = paramLong;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getValidationTimeout() {
/* 241 */     return this.validationTimeout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValidationTimeout(long paramLong) {
/* 248 */     if (paramLong < 1000L) {
/* 249 */       throw new IllegalArgumentException("validationTimeout cannot be less than 1000ms");
/*     */     }
/*     */     
/* 252 */     this.validationTimeout = paramLong;
/*     */ 
/*     */     
/* 255 */     if (this.validationTimeout > this.connectionTimeout) {
/* 256 */       this.validationTimeout = this.connectionTimeout;
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
/*     */   public DataSource getDataSource() {
/* 268 */     return this.dataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataSource(DataSource paramDataSource) {
/* 279 */     this.dataSource = paramDataSource;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDataSourceClassName() {
/* 284 */     return this.dataSourceClassName;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDataSourceClassName(String paramString) {
/* 289 */     this.dataSourceClassName = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addDataSourceProperty(String paramString, Object paramObject) {
/* 294 */     this.dataSourceProperties.put(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDataSourceJNDI() {
/* 299 */     return this.dataSourceJndiName;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDataSourceJNDI(String paramString) {
/* 304 */     this.dataSourceJndiName = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public Properties getDataSourceProperties() {
/* 309 */     return this.dataSourceProperties;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDataSourceProperties(Properties paramProperties) {
/* 314 */     this.dataSourceProperties.putAll(paramProperties);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDriverClassName() {
/* 319 */     return this.driverClassName;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDriverClassName(String paramString) {
/*     */     try {
/* 325 */       Class<?> clazz = getClass().getClassLoader().loadClass(paramString);
/* 326 */       clazz.newInstance();
/* 327 */       this.driverClassName = paramString;
/*     */     }
/* 329 */     catch (Exception exception) {
/* 330 */       throw new RuntimeException("Could not load class of driverClassName " + paramString, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getIdleTimeout() {
/* 338 */     return this.idleTimeout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIdleTimeout(long paramLong) {
/* 345 */     if (paramLong < 0L) {
/* 346 */       throw new IllegalArgumentException("idleTimeout cannot be negative");
/*     */     }
/* 348 */     this.idleTimeout = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getJdbcUrl() {
/* 353 */     return this.jdbcUrl;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setJdbcUrl(String paramString) {
/* 358 */     this.jdbcUrl = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoCommit() {
/* 368 */     return this.isAutoCommit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoCommit(boolean paramBoolean) {
/* 378 */     this.isAutoCommit = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAllowPoolSuspension() {
/* 388 */     return this.isAllowPoolSuspension;
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
/*     */   public void setAllowPoolSuspension(boolean paramBoolean) {
/* 400 */     this.isAllowPoolSuspension = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInitializationFailFast() {
/* 411 */     return this.isInitializationFailFast;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInitializationFailFast(boolean paramBoolean) {
/* 422 */     this.isInitializationFailFast = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIsolateInternalQueries() {
/* 427 */     return this.isIsolateInternalQueries;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIsolateInternalQueries(boolean paramBoolean) {
/* 432 */     this.isIsolateInternalQueries = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean isJdbc4ConnectionTest() {
/* 438 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setJdbc4ConnectionTest(boolean paramBoolean) {
/* 444 */     LOGGER.warn("The jdbcConnectionTest property is now deprecated, see the documentation for connectionTestQuery");
/*     */   }
/*     */ 
/*     */   
/*     */   public MetricsTrackerFactory getMetricsTrackerFactory() {
/* 449 */     return this.metricsTrackerFactory;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMetricsTrackerFactory(MetricsTrackerFactory paramMetricsTrackerFactory) {
/* 454 */     if (this.metricRegistry != null) {
/* 455 */       throw new IllegalStateException("cannot use setMetricsTrackerFactory() and setMetricRegistry() together");
/*     */     }
/*     */     
/* 458 */     this.metricsTrackerFactory = paramMetricsTrackerFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getMetricRegistry() {
/* 468 */     return this.metricRegistry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMetricRegistry(Object paramObject) {
/* 478 */     if (this.metricsTrackerFactory != null) {
/* 479 */       throw new IllegalStateException("cannot use setMetricRegistry() and setMetricsTrackerFactory() together");
/*     */     }
/*     */     
/* 482 */     if (paramObject != null) {
/* 483 */       if (paramObject instanceof String) {
/*     */         try {
/* 485 */           InitialContext initialContext = new InitialContext();
/* 486 */           paramObject = initialContext.lookup((String)paramObject);
/*     */         }
/* 488 */         catch (NamingException namingException) {
/* 489 */           throw new IllegalArgumentException(namingException);
/*     */         } 
/*     */       }
/*     */       
/* 493 */       if (!(paramObject instanceof com.codahale.metrics.MetricRegistry)) {
/* 494 */         throw new IllegalArgumentException("Class must be an instance of com.codahale.metrics.MetricRegistry");
/*     */       }
/*     */     } 
/*     */     
/* 498 */     this.metricRegistry = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getHealthCheckRegistry() {
/* 508 */     return this.healthCheckRegistry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHealthCheckRegistry(Object paramObject) {
/* 518 */     if (paramObject != null) {
/* 519 */       if (paramObject instanceof String) {
/*     */         try {
/* 521 */           InitialContext initialContext = new InitialContext();
/* 522 */           paramObject = initialContext.lookup((String)paramObject);
/*     */         }
/* 524 */         catch (NamingException namingException) {
/* 525 */           throw new IllegalArgumentException(namingException);
/*     */         } 
/*     */       }
/*     */       
/* 529 */       if (!(paramObject instanceof com.codahale.metrics.health.HealthCheckRegistry)) {
/* 530 */         throw new IllegalArgumentException("Class must be an instance of com.codahale.metrics.health.HealthCheckRegistry");
/*     */       }
/*     */     } 
/*     */     
/* 534 */     this.healthCheckRegistry = paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public Properties getHealthCheckProperties() {
/* 539 */     return this.healthCheckProperties;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHealthCheckProperties(Properties paramProperties) {
/* 544 */     this.healthCheckProperties.putAll(paramProperties);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addHealthCheckProperty(String paramString1, String paramString2) {
/* 549 */     this.healthCheckProperties.setProperty(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 554 */     return this.isReadOnly;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean paramBoolean) {
/* 559 */     this.isReadOnly = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRegisterMbeans() {
/* 564 */     return this.isRegisterMbeans;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRegisterMbeans(boolean paramBoolean) {
/* 569 */     this.isRegisterMbeans = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLeakDetectionThreshold() {
/* 576 */     return this.leakDetectionThreshold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeakDetectionThreshold(long paramLong) {
/* 583 */     this.leakDetectionThreshold = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaxLifetime() {
/* 590 */     return this.maxLifetime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxLifetime(long paramLong) {
/* 597 */     this.maxLifetime = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaximumPoolSize() {
/* 604 */     return this.maxPoolSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumPoolSize(int paramInt) {
/* 611 */     if (paramInt < 1) {
/* 612 */       throw new IllegalArgumentException("maxPoolSize cannot be less than 1");
/*     */     }
/* 614 */     this.maxPoolSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumIdle() {
/* 621 */     return this.minIdle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumIdle(int paramInt) {
/* 628 */     if (paramInt < 0) {
/* 629 */       throw new IllegalArgumentException("minimumIdle cannot be negative");
/*     */     }
/* 631 */     this.minIdle = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPassword() {
/* 640 */     return this.password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPassword(String paramString) {
/* 649 */     this.password = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPoolName() {
/* 656 */     return this.poolName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoolName(String paramString) {
/* 667 */     this.poolName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScheduledThreadPoolExecutor getScheduledExecutorService() {
/* 677 */     return this.scheduledExecutor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScheduledExecutorService(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor) {
/* 687 */     this.scheduledExecutor = paramScheduledThreadPoolExecutor;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTransactionIsolation() {
/* 692 */     return this.transactionIsolationName;
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
/*     */   public void setTransactionIsolation(String paramString) {
/* 704 */     this.transactionIsolationName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUsername() {
/* 714 */     return this.username;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsername(String paramString) {
/* 724 */     this.username = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ThreadFactory getThreadFactory() {
/* 734 */     return this.threadFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThreadFactory(ThreadFactory paramThreadFactory) {
/* 744 */     this.threadFactory = paramThreadFactory;
/*     */   }
/*     */ 
/*     */   
/*     */   public void validate() {
/* 749 */     validateNumerics();
/*     */ 
/*     */     
/* 752 */     this.catalog = UtilityElf.getNullIfEmpty(this.catalog);
/* 753 */     this.connectionInitSql = UtilityElf.getNullIfEmpty(this.connectionInitSql);
/* 754 */     this.connectionTestQuery = UtilityElf.getNullIfEmpty(this.connectionTestQuery);
/* 755 */     this.transactionIsolationName = UtilityElf.getNullIfEmpty(this.transactionIsolationName);
/* 756 */     this.dataSourceClassName = UtilityElf.getNullIfEmpty(this.dataSourceClassName);
/* 757 */     this.dataSourceJndiName = UtilityElf.getNullIfEmpty(this.dataSourceJndiName);
/* 758 */     this.driverClassName = UtilityElf.getNullIfEmpty(this.driverClassName);
/* 759 */     this.jdbcUrl = UtilityElf.getNullIfEmpty(this.jdbcUrl);
/*     */     
/* 761 */     if (this.poolName == null) {
/* 762 */       this.poolName = "HikariPool-" + POOL_NUMBER.getAndIncrement();
/*     */     }
/*     */     
/* 765 */     if (this.poolName.contains(":") && this.isRegisterMbeans) {
/* 766 */       throw new IllegalArgumentException("poolName cannot contain ':' when used with JMX");
/*     */     }
/*     */     
/* 769 */     if (this.driverClassName != null && this.jdbcUrl == null) {
/* 770 */       LOGGER.error("jdbcUrl is required with driverClassName");
/* 771 */       throw new IllegalArgumentException("jdbcUrl is required with driverClassName");
/*     */     } 
/* 773 */     if (this.driverClassName != null && this.dataSourceClassName != null) {
/* 774 */       LOGGER.error("cannot use driverClassName and dataSourceClassName together");
/* 775 */       throw new IllegalArgumentException("cannot use driverClassName and dataSourceClassName together");
/*     */     } 
/* 777 */     if (this.jdbcUrl != null && this.dataSourceClassName != null) {
/* 778 */       LOGGER.warn("using dataSourceClassName and ignoring jdbcUrl");
/*     */     }
/* 780 */     else if (this.jdbcUrl == null) {
/*     */ 
/*     */       
/* 783 */       if (this.dataSource == null && this.dataSourceClassName == null) {
/* 784 */         LOGGER.error("either dataSource or dataSourceClassName is required");
/* 785 */         throw new IllegalArgumentException("either dataSource or dataSourceClassName is required");
/*     */       } 
/* 787 */       if (this.dataSource != null && this.dataSourceClassName != null) {
/* 788 */         LOGGER.warn("using dataSource and ignoring dataSourceClassName");
/*     */       }
/*     */     } 
/* 791 */     if (LOGGER.isDebugEnabled() || unitTest) {
/* 792 */       logConfiguration();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void validateNumerics() {
/* 798 */     if (this.validationTimeout > this.connectionTimeout && this.connectionTimeout != 2147483647L) {
/* 799 */       this.validationTimeout = this.connectionTimeout;
/*     */     }
/*     */     
/* 802 */     if (this.minIdle < 0) {
/* 803 */       this.minIdle = this.maxPoolSize;
/*     */     }
/* 805 */     else if (this.minIdle > this.maxPoolSize) {
/* 806 */       this.maxPoolSize = this.minIdle;
/*     */     } 
/*     */     
/* 809 */     if (this.maxLifetime < 0L) {
/* 810 */       LOGGER.error("maxLifetime cannot be negative.");
/* 811 */       throw new IllegalArgumentException("maxLifetime cannot be negative.");
/*     */     } 
/* 813 */     if (this.maxLifetime > 0L && this.maxLifetime < TimeUnit.SECONDS.toMillis(30L)) {
/* 814 */       LOGGER.warn("maxLifetime is less than 30000ms, setting to default {}ms.", Long.valueOf(MAX_LIFETIME));
/* 815 */       this.maxLifetime = MAX_LIFETIME;
/*     */     } 
/*     */     
/* 818 */     if (this.idleTimeout != 0L && this.idleTimeout < TimeUnit.SECONDS.toMillis(10L)) {
/* 819 */       LOGGER.warn("idleTimeout is less than 10000ms, setting to default {}ms.", Long.valueOf(IDLE_TIMEOUT));
/* 820 */       this.idleTimeout = IDLE_TIMEOUT;
/*     */     } 
/* 822 */     if (this.idleTimeout + TimeUnit.SECONDS.toMillis(1L) > this.maxLifetime && this.maxLifetime > 0L) {
/* 823 */       LOGGER.warn("idleTimeout is close to or greater than maxLifetime, disabling it.");
/* 824 */       this.maxLifetime = this.idleTimeout;
/* 825 */       this.idleTimeout = 0L;
/*     */     } 
/* 827 */     if (this.maxLifetime == 0L && this.idleTimeout == 0L) {
/* 828 */       LOGGER.warn("setting idleTimeout to {}ms.", Long.valueOf(IDLE_TIMEOUT));
/* 829 */       this.idleTimeout = IDLE_TIMEOUT;
/*     */     } 
/*     */     
/* 832 */     if (this.leakDetectionThreshold != 0L && this.leakDetectionThreshold < TimeUnit.SECONDS.toMillis(2L) && !unitTest) {
/* 833 */       LOGGER.warn("leakDetectionThreshold is less than 2000ms, setting to minimum 2000ms.");
/* 834 */       this.leakDetectionThreshold = 2000L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void logConfiguration() {
/* 840 */     LOGGER.debug("{} - configuration:", this.poolName);
/* 841 */     TreeSet treeSet = new TreeSet(PropertyElf.getPropertyNames(HikariConfig.class));
/* 842 */     for (String str : treeSet) {
/*     */       try {
/* 844 */         Object object = PropertyElf.getProperty(str, this);
/* 845 */         if ("dataSourceProperties".equals(str)) {
/* 846 */           Properties properties = PropertyElf.copyProperties(this.dataSourceProperties);
/* 847 */           properties.setProperty("password", "<masked>");
/* 848 */           object = properties;
/*     */         } 
/* 850 */         object = str.contains("password") ? "<masked>" : object;
/* 851 */         LOGGER.debug((str + "................................................").substring(0, 32) + ((object != null) ? (String)object : ""));
/*     */       }
/* 853 */       catch (Exception exception) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadProperties(String paramString) {
/* 861 */     File file = new File(paramString);
/* 862 */     try (InputStream null = file.isFile() ? new FileInputStream(file) : getClass().getResourceAsStream(paramString)) {
/* 863 */       if (inputStream != null) {
/* 864 */         Properties properties = new Properties();
/* 865 */         properties.load(inputStream);
/* 866 */         PropertyElf.setTargetFromProperties(this, properties);
/*     */       } else {
/*     */         
/* 869 */         throw new IllegalArgumentException("Property file " + paramString + " was not found.");
/*     */       }
/*     */     
/* 872 */     } catch (IOException iOException) {
/* 873 */       throw new RuntimeException("Error loading properties file", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void copyState(HikariConfig paramHikariConfig) {
/* 879 */     for (Field field : HikariConfig.class.getDeclaredFields()) {
/* 880 */       if (!Modifier.isFinal(field.getModifiers())) {
/* 881 */         field.setAccessible(true);
/*     */         try {
/* 883 */           field.set(paramHikariConfig, field.get(this));
/*     */         }
/* 885 */         catch (Exception exception) {
/* 886 */           throw new RuntimeException("Exception copying HikariConfig state: " + exception.getMessage(), exception);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/HikariConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */