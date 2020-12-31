/*    */ package me.TechsCode.UltraPermissions.base.mysql.credentialsTransfer;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParseException;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.BungeeMessagingListener;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.Message;
/*    */ import me.TechsCode.UltraPermissions.base.mysql.MySQLManager;
/*    */ import me.TechsCode.UltraPermissions.base.mysql.MySQLRegistry;
/*    */ import net.md_5.bungee.api.config.ServerInfo;
/*    */ 
/*    */ public class ProxyMySQLReceiver
/*    */   implements BungeeMessagingListener {
/*    */   private BungeeTechPlugin plugin;
/*    */   private MySQLManager manager;
/*    */   
/*    */   public ProxyMySQLReceiver(BungeeTechPlugin paramBungeeTechPlugin, MySQLManager paramMySQLManager) {
/* 18 */     this.plugin = paramBungeeTechPlugin;
/* 19 */     this.manager = paramMySQLManager;
/*    */     
/* 21 */     paramBungeeTechPlugin.getMessagingService().register(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMessage(ServerInfo paramServerInfo, Message paramMessage) {
/* 26 */     if (!paramMessage.getKey().equals("mysql")) {
/*    */       return;
/*    */     }
/*    */     
/* 30 */     boolean bool = paramMessage.getData().get("force").getAsBoolean();
/*    */     
/* 32 */     MySQLRegistry mySQLRegistry = this.manager.getRegistry();
/*    */     
/* 34 */     if (bool || !mySQLRegistry.hasCredentials())
/*    */       try {
/* 36 */         JsonObject jsonObject = paramMessage.getData().getAsJsonObject("state");
/* 37 */         mySQLRegistry.updateState(jsonObject);
/*    */         
/* 39 */         if (!bool) this.manager.setup(); 
/* 40 */       } catch (JsonParseException jsonParseException) {
/* 41 */         this.plugin.log("Can not process received MySQL Credentials.. is everything up-to-date?");
/* 42 */         this.plugin.log("Error Message: " + jsonParseException.getMessage());
/* 43 */         this.plugin.log("Content (May Contain Sensitive Information): " + paramMessage);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/mysql/credentialsTransfer/ProxyMySQLReceiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */