/*    */ package me.TechsCode.UltraPermissions.base.update.networkUpdate;
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.Message;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.QueuedMessage;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.SpigotMessagingListener;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.update.ResponseType;
/*    */ import me.TechsCode.UltraPermissions.base.update.UpdateResponse;
/*    */ import me.TechsCode.UltraPermissions.base.update.UpdateServer;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SpigotUpdateAgent implements SpigotMessagingListener {
/* 18 */   private static final Phrase MESSAGE = Phrase.create("update.remote.notify", "Updated from **%from%** to **%to%**", Colors.GRAY, new Color[] { Colors.RED, Colors.GREEN });
/*    */   
/*    */   private SpigotTechPlugin plugin;
/*    */   
/*    */   public SpigotUpdateAgent(SpigotTechPlugin paramSpigotTechPlugin) {
/* 23 */     this.plugin = paramSpigotTechPlugin;
/*    */     
/* 25 */     paramSpigotTechPlugin.getMessagingService().register(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMessage(Message paramMessage) {
/* 30 */     if (paramMessage.getKey().equals("update")) {
/* 31 */       JsonObject jsonObject = paramMessage.getData();
/*    */       
/* 33 */       String str1 = jsonObject.get("updateServer").getAsString();
/* 34 */       String str2 = jsonObject.get("uid").getAsString();
/* 35 */       String str3 = jsonObject.get("version").getAsString();
/*    */       
/* 37 */       if (!this.plugin.getVersion().equals(str3)) {
/*    */ 
/*    */         
/* 40 */         UpdateResponse updateResponse = UpdateServer.requestAndPerform((TechPlugin)this.plugin, str1, str2);
/*    */ 
/*    */         
/* 43 */         if (updateResponse.getType() == ResponseType.SUCCESS) {
/* 44 */           for (Player player : Bukkit.getOnlinePlayers()) {
/* 45 */             if (player.hasPermission("*")) {
/*    */ 
/*    */               
/* 48 */               String str = MESSAGE.get().replace("%from%", this.plugin.getVersion()).replace("%to%", str3);
/*    */               
/* 50 */               player.sendMessage(this.plugin.getPrefix() + str);
/*    */             } 
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void sendUpdateRequestToBungee(String paramString1, String paramString2, String paramString3) {
/* 59 */     JsonObject jsonObject = new JsonObject();
/* 60 */     jsonObject.addProperty("updateServer", paramString1);
/* 61 */     jsonObject.addProperty("uid", paramString2);
/* 62 */     jsonObject.addProperty("version", paramString3);
/*    */     
/* 64 */     this.plugin.getMessagingService().send(new QueuedMessage("update", jsonObject) {
/*    */           public void onSend() {}
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/networkUpdate/SpigotUpdateAgent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */