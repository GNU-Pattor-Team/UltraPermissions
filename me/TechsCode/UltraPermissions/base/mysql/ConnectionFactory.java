/*    */ package me.TechsCode.UltraPermissions.base.mysql;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariConfig;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariDataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConnectionFactory
/*    */ {
/*    */   private HikariDataSource dataSource;
/*    */   private String error;
/*    */   
/*    */   public ConnectionFactory(MySQLCredentials paramMySQLCredentials, boolean paramBoolean, int paramInt1, int paramInt2) {
/* 16 */     HikariConfig hikariConfig = new HikariConfig();
/* 17 */     hikariConfig.setJdbcUrl("jdbc:mysql://" + paramMySQLCredentials.getHostname() + ":" + paramMySQLCredentials.getPort() + "/" + paramMySQLCredentials.getDatabase() + "?useSSL=" + paramBoolean + "&characterEncoding=utf-8");
/* 18 */     hikariConfig.setUsername(paramMySQLCredentials.getUsername());
/* 19 */     hikariConfig.setPassword(paramMySQLCredentials.getPassword());
/*    */     
/* 21 */     hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
/* 22 */     hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
/* 23 */     hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
/*    */     
/*    */     try {
/* 26 */       this.dataSource = new HikariDataSource(hikariConfig);
/*    */       
/* 28 */       this.dataSource.setMinimumIdle(paramInt1);
/* 29 */       this.dataSource.setMaximumPoolSize(paramInt2);
/* 30 */       this.dataSource.setMaxLifetime(1800000L);
/* 31 */       this.dataSource.setConnectionTimeout(5000L);
/*    */       
/* 33 */       this.dataSource.setLeakDetectionThreshold(48000L);
/* 34 */     } catch (Exception exception) {
/* 35 */       this.error = exception.getMessage();
/*    */     } 
/*    */   }
/*    */   
/*    */   public Connection newConnection() {
/* 40 */     return (this.dataSource != null) ? this.dataSource.getConnection() : null;
/*    */   }
/*    */   
/*    */   public ConnectionTestResult testConnection() {
/* 44 */     if (this.error != null) {
/* 45 */       return new ConnectionTestResult(false, this.error);
/*    */     }
/*    */     
/*    */     try {
/* 49 */       newConnection();
/* 50 */       return new ConnectionTestResult(true, null);
/* 51 */     } catch (SQLException sQLException) {
/* 52 */       return new ConnectionTestResult(false, sQLException.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   public void close() {
/* 57 */     if (this.dataSource != null)
/* 58 */       this.dataSource.close(); 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/mysql/ConnectionFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */