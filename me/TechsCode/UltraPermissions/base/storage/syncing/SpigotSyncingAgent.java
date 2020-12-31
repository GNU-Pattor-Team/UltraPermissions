/*    */ package me.TechsCode.UltraPermissions.base.storage.syncing;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.Message;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.QueuedMessage;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.SpigotMessagingListener;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*    */ 
/*    */ public class SpigotSyncingAgent
/*    */   extends SyncingAgent implements SpigotMessagingListener {
/*    */   private SpigotTechPlugin plugin;
/*    */   
/*    */   public SpigotSyncingAgent(SpigotTechPlugin paramSpigotTechPlugin) {
/* 15 */     this.plugin = paramSpigotTechPlugin;
/*    */     
/* 17 */     paramSpigotTechPlugin.getMessagingService().register(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMessage(Message paramMessage) {
/* 22 */     if (paramMessage.getKey().equals("cache")) {
/* 23 */       String str1 = paramMessage.getData().get("model").getAsString();
/* 24 */       String str2 = paramMessage.getData().get("dataKey").getAsString();
/*    */       
/* 26 */       this.plugin.getScheduler().runAsync(() -> executeLocalSynchronization(paramString1, paramString2));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void notifyNewDataChanges(Storage paramStorage, String paramString) {
/* 31 */     JsonObject jsonObject = new JsonObject();
/*    */     
/* 33 */     jsonObject.addProperty("model", paramStorage.getModelName());
/* 34 */     jsonObject.addProperty("dataKey", paramString);
/*    */     
/* 36 */     this.plugin.getMessagingService().send(new QueuedMessage("cache", jsonObject) {
/*    */           public void onSend() {}
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/syncing/SpigotSyncingAgent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */