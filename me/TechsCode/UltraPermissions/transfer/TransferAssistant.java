/*    */ package me.TechsCode.UltraPermissions.transfer;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerLoginEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransferAssistant
/*    */   implements Listener
/*    */ {
/* 23 */   private static final Phrase KICK_MESSAGE = Phrase.create("transferAssistant.kickMessage", "UltraPermissions will now convert data. The server will shut down when complete", Colors.GRAY, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/*    */   
/*    */   public TransferAssistant(UltraPermissions paramUltraPermissions, boolean paramBoolean) {
/* 26 */     Bukkit.getOnlinePlayers().forEach(paramPlayer -> paramPlayer.kickPlayer(KICK_MESSAGE.get()));
/* 27 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*    */     
/* 29 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)paramUltraPermissions.getBootstrap(), () -> {
/*    */           paramUltraPermissions.log("Transferring from " + (paramBoolean ? "File to MySQL" : "MySQL to File"));
/*    */           TransferStorageGroup transferStorageGroup1 = new TransferStorageGroup(paramUltraPermissions, false);
/*    */           TransferStorageGroup transferStorageGroup2 = new TransferStorageGroup(paramUltraPermissions, true);
/*    */           TransferStorageGroup transferStorageGroup3 = paramBoolean ? transferStorageGroup1 : transferStorageGroup2;
/*    */           TransferStorageGroup transferStorageGroup4 = paramBoolean ? transferStorageGroup2 : transferStorageGroup1;
/*    */           transferStorageGroup3.copyTo(transferStorageGroup4);
/*    */           paramUltraPermissions.getScheduler().runTaskTimer((), 0L, 1200L);
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   private static final Phrase LOGIN_MESSAGE = Phrase.create("transferAssistant.loginMessage", "Ultra Permissions is currently transferring. Wait until the server is stopped.", Colors.GRAY, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/*    */   
/*    */   @EventHandler
/*    */   public void login(PlayerLoginEvent paramPlayerLoginEvent) {
/* 53 */     paramPlayerLoginEvent.disallow(PlayerLoginEvent.Result.KICK_OTHER, LOGIN_MESSAGE.get());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/transfer/TransferAssistant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */