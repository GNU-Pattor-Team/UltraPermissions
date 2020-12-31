/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Driver;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLFeatureNotSupportedException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Logger;
/*     */ import javax.sql.DataSource;
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
/*     */ public final class DriverDataSource
/*     */   implements DataSource
/*     */ {
/*  35 */   private static final Logger LOGGER = LoggerFactory.getLogger(DriverDataSource.class);
/*     */   
/*     */   private final String jdbcUrl;
/*     */   
/*     */   private final Properties driverProperties;
/*     */   private Driver driver;
/*     */   
/*     */   public DriverDataSource(String paramString1, String paramString2, Properties paramProperties, String paramString3, String paramString4) {
/*  43 */     this.jdbcUrl = paramString1;
/*  44 */     this.driverProperties = new Properties();
/*     */     
/*  46 */     for (Map.Entry<Object, Object> entry : paramProperties.entrySet()) {
/*  47 */       this.driverProperties.setProperty(entry.getKey().toString(), entry.getValue().toString());
/*     */     }
/*     */     
/*  50 */     if (paramString3 != null) {
/*  51 */       this.driverProperties.put("user", this.driverProperties.getProperty("user", paramString3));
/*     */     }
/*  53 */     if (paramString4 != null) {
/*  54 */       this.driverProperties.put("password", this.driverProperties.getProperty("password", paramString4));
/*     */     }
/*     */     
/*  57 */     if (paramString2 != null) {
/*  58 */       Enumeration<Driver> enumeration = DriverManager.getDrivers();
/*  59 */       while (enumeration.hasMoreElements()) {
/*  60 */         Driver driver = enumeration.nextElement();
/*  61 */         if (driver.getClass().getName().equals(paramString2)) {
/*  62 */           this.driver = driver;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  67 */       if (this.driver == null) {
/*  68 */         LOGGER.warn("Registered driver with driverClassName={} was not found, trying direct instantiation.", paramString2);
/*     */         try {
/*  70 */           Class<?> clazz = getClass().getClassLoader().loadClass(paramString2);
/*  71 */           this.driver = (Driver)clazz.newInstance();
/*     */         }
/*  73 */         catch (Exception exception) {
/*  74 */           LOGGER.warn("Could not instantiate instance of driver class {}, trying JDBC URL resolution", paramString2, exception);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*     */     try {
/*  80 */       if (this.driver == null) {
/*  81 */         this.driver = DriverManager.getDriver(paramString1);
/*     */       }
/*  83 */       else if (!this.driver.acceptsURL(paramString1)) {
/*  84 */         throw new RuntimeException("Driver " + paramString2 + " claims to not accept JDBC URL " + paramString1);
/*     */       }
/*     */     
/*  87 */     } catch (SQLException sQLException) {
/*  88 */       throw new RuntimeException("Unable to get driver instance for jdbcUrl=" + paramString1, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() {
/*  95 */     return this.driver.connect(this.jdbcUrl, this.driverProperties);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection(String paramString1, String paramString2) {
/* 101 */     return getConnection();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintWriter getLogWriter() {
/* 107 */     throw new SQLFeatureNotSupportedException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogWriter(PrintWriter paramPrintWriter) {
/* 113 */     throw new SQLFeatureNotSupportedException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginTimeout(int paramInt) {
/* 119 */     DriverManager.setLoginTimeout(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLoginTimeout() {
/* 125 */     return DriverManager.getLoginTimeout();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getParentLogger() {
/* 131 */     return this.driver.getParentLogger();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T unwrap(Class<T> paramClass) {
/* 137 */     throw new SQLFeatureNotSupportedException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> paramClass) {
/* 143 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/DriverDataSource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */