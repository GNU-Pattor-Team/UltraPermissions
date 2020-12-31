/*    */ package me.TechsCode.UltraPermissions.base.mysql;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.mysql.credentialsTransfer.ProxyMySQLReceiver;
/*    */ import me.TechsCode.UltraPermissions.base.mysql.credentialsTransfer.SpigotMySQLSender;
/*    */ import me.TechsCode.UltraPermissions.base.registry.RegistrationChoice;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MySQLManager
/*    */ {
/*    */   private TechPlugin plugin;
/*    */   private MySQLRegistry registry;
/*    */   private ConnectionFactory factory;
/*    */   
/*    */   public MySQLManager(TechPlugin paramTechPlugin) {
/* 21 */     this.plugin = paramTechPlugin;
/* 22 */     this.registry = (MySQLRegistry)paramTechPlugin.getRegistry().register(MySQLRegistry.class, RegistrationChoice.LOCAL);
/*    */     
/* 24 */     if (paramTechPlugin instanceof BungeeTechPlugin) {
/* 25 */       new ProxyMySQLReceiver((BungeeTechPlugin)paramTechPlugin, this);
/* 26 */     } else if (paramTechPlugin instanceof SpigotTechPlugin) {
/* 27 */       new SpigotMySQLSender((SpigotTechPlugin)paramTechPlugin, this);
/*    */     } 
/*    */     
/* 30 */     setup();
/*    */   }
/*    */   
/*    */   public void setup() {
/* 34 */     close();
/*    */     
/* 36 */     if (this.registry.hasCredentials()) {
/* 37 */       this.factory = new ConnectionFactory(this.registry.getCredentials(), this.registry.hasSSL(), this.registry.getMinimumIdle(), this.registry.getMaximumPoolSize());
/*    */       
/* 39 */       ConnectionTestResult connectionTestResult = this.factory.testConnection();
/*    */       
/* 41 */       if (!connectionTestResult.isValid()) {
/* 42 */         this.factory = null;
/*    */         
/* 44 */         this.plugin.log("Could not contact MySQL Server:");
/* 45 */         this.plugin.log(connectionTestResult.getError());
/*    */       } 
/*    */     } else {
/* 48 */       this.factory = null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public MySQLRegistry getRegistry() {
/* 53 */     return this.registry;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 57 */     return (this.factory != null);
/*    */   }
/*    */   
/*    */   public Connection newConnection() {
/* 61 */     return (this.factory != null) ? this.factory.newConnection() : null;
/*    */   }
/*    */   
/*    */   public void close() {
/* 65 */     if (this.factory != null) {
/* 66 */       this.factory.close();
/* 67 */       this.factory = null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/mysql/MySQLManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */