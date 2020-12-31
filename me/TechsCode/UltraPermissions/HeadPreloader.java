/*    */ package me.TechsCode.UltraPermissions;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.SkinTexture;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class HeadPreloader
/*    */   implements Listener {
/*    */   private UltraPermissions plugin;
/*    */   
/*    */   public HeadPreloader(UltraPermissions paramUltraPermissions) {
/* 17 */     this.plugin = paramUltraPermissions;
/*    */     
/* 19 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void login(PlayerJoinEvent paramPlayerJoinEvent) {
/* 24 */     this.plugin.getScheduler().runTaskLaterAsync(() -> { SkinTexture skinTexture = Bukkit.getOnlineMode() ? SkinTexture.fromPlayer(paramPlayerJoinEvent.getPlayer()) : SkinTexture.fromMojangAPI(paramPlayerJoinEvent.getPlayer().getName()); if (skinTexture != null && skinTexture.getUrl() != null) { Optional optional = this.plugin.getUsers().uuid(paramPlayerJoinEvent.getPlayer().getUniqueId()); optional.ifPresent(()); }  }90L);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/HeadPreloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */