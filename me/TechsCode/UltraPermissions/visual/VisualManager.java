/*    */ package me.TechsCode.UltraPermissions.visual;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateEvent;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateTime;
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.migration.MigrationAssistant;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class VisualManager
/*    */   implements Listener
/*    */ {
/*    */   private final UltraPermissions plugin;
/*    */   private final VisualRegistry registry;
/*    */   
/*    */   public VisualManager(UltraPermissions paramUltraPermissions, VisualRegistry paramVisualRegistry) {
/* 25 */     this.plugin = paramUltraPermissions;
/* 26 */     this.registry = paramVisualRegistry;
/*    */     
/* 28 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void chat(AsyncPlayerChatEvent paramAsyncPlayerChatEvent) {
/* 33 */     if (MigrationAssistant.isMigrating())
/*    */       return; 
/* 35 */     String str = this.registry.getFormat(VisualType.CHAT);
/*    */     
/* 37 */     if (str == null) {
/*    */       return;
/*    */     }
/*    */     
/* 41 */     str = replacePlaceholders(paramAsyncPlayerChatEvent.getPlayer(), str).replace("%", "percent").replace("{Message}", "%2$s");
/*    */     
/* 43 */     paramAsyncPlayerChatEvent.setFormat(str);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void update(UpdateEvent paramUpdateEvent) {
/* 48 */     if (MigrationAssistant.isMigrating())
/*    */       return; 
/* 50 */     if (paramUpdateEvent.getUpdateTime() != UpdateTime.SLOWER)
/*    */       return; 
/* 52 */     if (this.registry.getFormat(VisualType.TABLIST) == null && this.registry.getFormat(VisualType.DISPLAY_NAME) == null)
/*    */       return; 
/* 54 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)this.plugin.getBootstrap(), () -> {
/*    */           for (Player player : Bukkit.getOnlinePlayers()) {
/*    */             String str1 = this.registry.getFormat(VisualType.TABLIST);
/*    */             String str2 = this.registry.getFormat(VisualType.DISPLAY_NAME);
/*    */             if (str1 != null)
/*    */               player.setPlayerListName(replacePlaceholders(player, str1)); 
/*    */             if (str2 != null)
/*    */               player.setDisplayName(replacePlaceholders(player, str2)); 
/*    */           } 
/*    */         });
/*    */   }
/*    */   private String replacePlaceholders(Player paramPlayer, String paramString) {
/* 66 */     Optional<User> optional = this.plugin.getUsers().uuid(paramPlayer.getUniqueId());
/*    */     
/* 68 */     if (!optional.isPresent()) return paramString;
/*    */     
/* 70 */     for (UpermsPlaceholder upermsPlaceholder : UltraPermissions.placeholders) {
/* 71 */       paramString = paramString.replace(upermsPlaceholder.getNativePlaceholder(), upermsPlaceholder.get(optional.get(), this.plugin.getThisServer().orElse(null)));
/*    */     }
/*    */     
/* 74 */     paramString = this.plugin.replacePlaceholders(paramPlayer, paramString);
/*    */     
/* 76 */     paramString = paramString.replace("{Player}", paramPlayer.getName());
/* 77 */     paramString = paramString.replace("{DisplayName}", paramPlayer.getDisplayName());
/*    */     
/* 79 */     return paramString.trim();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/visual/VisualManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */