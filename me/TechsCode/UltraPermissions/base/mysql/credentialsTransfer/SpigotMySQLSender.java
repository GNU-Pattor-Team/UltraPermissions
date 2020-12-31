/*    */ package me.TechsCode.UltraPermissions.base.mysql.credentialsTransfer;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateEvent;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateTime;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.QueuedMessage;
/*    */ import me.TechsCode.UltraPermissions.base.mysql.MySQLManager;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class SpigotMySQLSender implements Listener {
/*    */   private SpigotTechPlugin plugin;
/*    */   
/*    */   public SpigotMySQLSender(SpigotTechPlugin paramSpigotTechPlugin, MySQLManager paramMySQLManager) {
/* 20 */     this.plugin = paramSpigotTechPlugin;
/* 21 */     this.manager = paramMySQLManager;
/*    */     
/* 23 */     sendMySQLCredentials(false);
/* 24 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramSpigotTechPlugin.getBootstrap());
/*    */   }
/*    */   private MySQLManager manager;
/*    */   private void sendMySQLCredentials(boolean paramBoolean) {
/* 28 */     if (this.manager.isEnabled()) {
/* 29 */       JsonObject jsonObject = new JsonObject();
/* 30 */       jsonObject.addProperty("force", Boolean.valueOf(paramBoolean));
/* 31 */       jsonObject.add("state", (JsonElement)this.manager.getRegistry().getState());
/*    */       
/* 33 */       this.plugin.getMessagingService().send(new QueuedMessage("mysql", jsonObject)
/*    */           {
/*    */             public void onSend() {}
/*    */           });
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void send(UpdateEvent paramUpdateEvent) {
/* 42 */     if (paramUpdateEvent.getUpdateTime() != UpdateTime.HALFMIN) {
/*    */       return;
/*    */     }
/*    */     
/* 46 */     sendMySQLCredentials(false);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void join(PlayerJoinEvent paramPlayerJoinEvent) {
/* 51 */     sendMySQLCredentials(false);
/*    */   }
/*    */   
/*    */   public void forceUpdateBungeeMySQLCredentials() {
/* 55 */     sendMySQLCredentials(true);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/mysql/credentialsTransfer/SpigotMySQLSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */