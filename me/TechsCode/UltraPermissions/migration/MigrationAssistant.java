/*    */ package me.TechsCode.UltraPermissions.migration;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerLoginEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public abstract class MigrationAssistant implements Listener {
/*    */   public static boolean isMigrating() {
/* 19 */     return migrating;
/*    */   }
/*    */ 
/*    */   
/*    */   private static boolean migrating;
/*    */   
/* 25 */   private static final Phrase KICK_MESSAGE = Phrase.create("migrationAssistant.kickMessage", "Please remove **%plugin%** after the server has stopped", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */   
/*    */   public void doMigration(UltraPermissions paramUltraPermissions) {
/* 28 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/* 29 */     Bukkit.getOnlinePlayers().forEach(paramPlayer -> paramPlayer.kickPlayer(KICK_MESSAGE.get().replace("%plugin%", getPluginName())));
/*    */     
/* 31 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)paramUltraPermissions.getBootstrap(), () -> {
/*    */           paramUltraPermissions.getUsers().forEach(User::remove);
/*    */           paramUltraPermissions.getPermissions().forEach(Permission::remove);
/*    */           paramUltraPermissions.getGroups().forEach(Group::remove);
/*    */           Runnable runnable = ();
/*    */           migrating = true;
/*    */           migrate(paramUltraPermissions, runnable);
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
/* 50 */   private static final Phrase LOGIN_MESSAGE = Phrase.create("migrationAssistant.loginMessage", "The Server will be back in a few minutes", Colors.GRAY, new Color[0]);
/*    */   
/*    */   @EventHandler
/*    */   public void login(PlayerLoginEvent paramPlayerLoginEvent) {
/* 54 */     paramPlayerLoginEvent.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, LOGIN_MESSAGE.get());
/*    */   }
/*    */   
/*    */   public abstract String getPluginName();
/*    */   
/*    */   protected abstract void migrate(UltraPermissions paramUltraPermissions, Runnable paramRunnable);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/migration/MigrationAssistant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */