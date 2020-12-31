/*    */ package me.TechsCode.UltraPermissions.base.storage.syncing;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.BungeeMessagingListener;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.Message;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.config.ServerInfo;
/*    */ 
/*    */ public class BungeeSyncingAgent
/*    */   extends SyncingAgent
/*    */   implements BungeeMessagingListener
/*    */ {
/*    */   private BungeeTechPlugin plugin;
/*    */   
/*    */   public BungeeSyncingAgent(BungeeTechPlugin paramBungeeTechPlugin) {
/* 19 */     this.plugin = paramBungeeTechPlugin;
/*    */     
/* 21 */     paramBungeeTechPlugin.getMessagingService().register(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMessage(ServerInfo paramServerInfo, Message paramMessage) {
/* 26 */     if (paramMessage.getKey().equals("cache")) {
/* 27 */       ArrayList arrayList = new ArrayList(ProxyServer.getInstance().getServers().values());
/* 28 */       arrayList.remove(paramServerInfo);
/*    */ 
/*    */       
/* 31 */       this.plugin.getMessagingService().send(paramMessage, (ServerInfo[])arrayList.toArray((Object[])new ServerInfo[0]));
/*    */       
/* 33 */       String str1 = paramMessage.getData().get("model").getAsString();
/* 34 */       String str2 = paramMessage.getData().get("dataKey").getAsString();
/*    */       
/* 36 */       executeLocalSynchronization(str1, str2);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void notifyNewDataChanges(Storage paramStorage, String paramString) {
/* 42 */     JsonObject jsonObject = new JsonObject();
/*    */     
/* 44 */     jsonObject.addProperty("model", paramStorage.getModelName());
/* 45 */     jsonObject.addProperty("dataKey", paramString);
/*    */     
/* 47 */     this.plugin.getMessagingService().send(new Message("cache", jsonObject), new ServerInfo[0]);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/syncing/BungeeSyncingAgent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */