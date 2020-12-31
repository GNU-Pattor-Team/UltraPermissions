/*    */ package me.TechsCode.UltraPermissions.hooks;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.hooks.pluginHooks.MvdwPlaceholderAPIHook;
/*    */ import me.TechsCode.UltraPermissions.hooks.pluginHooks.NametagEditHook;
/*    */ import me.TechsCode.UltraPermissions.hooks.pluginHooks.PlaceholderAPIHook;
/*    */ import me.TechsCode.UltraPermissions.hooks.pluginHooks.VaultHook;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.EventPriority;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.server.PluginEnableEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class PluginHookManager
/*    */   implements Listener {
/*    */   private final UltraPermissions plugin;
/*    */   private final HashMap<String, Runnable> hooks;
/*    */   private PlaceholderAPIHook placeholderAPIHook;
/*    */   private MvdwPlaceholderAPIHook mvdwPlaceholderAPIHook;
/*    */   private VaultHook vaultHook;
/*    */   private NametagEditHook nametagEditHook;
/*    */   
/*    */   public PluginHookManager(UltraPermissions paramUltraPermissions) {
/* 29 */     this.plugin = paramUltraPermissions;
/*    */     
/* 31 */     this.hooks = new HashMap<>();
/*    */     
/* 33 */     this.hooks.put("NametagEdit", () -> this.nametagEditHook = new NametagEditHook(paramUltraPermissions));
/*    */     
/* 35 */     this.hooks.put("Vault", () -> this.vaultHook = new VaultHook(paramUltraPermissions));
/*    */     
/* 37 */     this.hooks.put("PlaceholderAPI", () -> this.placeholderAPIHook = new PlaceholderAPIHook(paramUltraPermissions));
/*    */     
/* 39 */     this.hooks.put("MVdWPlaceholderAPI", () -> this.mvdwPlaceholderAPIHook = new MvdwPlaceholderAPIHook(paramUltraPermissions));
/*    */     
/* 41 */     (new HashSet(this.hooks.keySet())).forEach(paramString -> tryHook(false, paramString));
/*    */     
/* 43 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*    */   }
/*    */   
/*    */   public void tryHook(boolean paramBoolean, String paramString) {
/* 47 */     if (!this.hooks.containsKey(paramString))
/*    */       return; 
/* 49 */     if (paramBoolean || Bukkit.getPluginManager().isPluginEnabled(paramString)) {
/* 50 */       ((Runnable)this.hooks.get(paramString)).run();
/* 51 */       this.hooks.remove(paramString);
/*    */       
/* 53 */       this.plugin.log("Hooked into " + paramString);
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventHandler(priority = EventPriority.LOWEST)
/*    */   public void onLoad(PluginEnableEvent paramPluginEnableEvent) {
/* 59 */     tryHook(true, paramPluginEnableEvent.getPlugin().getName());
/*    */   }
/*    */   
/*    */   public String replacePlaceholders(Player paramPlayer, String paramString) {
/* 63 */     if (this.placeholderAPIHook != null) paramString = this.placeholderAPIHook.replace((OfflinePlayer)paramPlayer, paramString);
/*    */     
/* 65 */     if (this.mvdwPlaceholderAPIHook != null) paramString = this.mvdwPlaceholderAPIHook.replace(paramPlayer, paramString);
/*    */     
/* 67 */     return paramString;
/*    */   }
/*    */   
/*    */   public void clearCaches() {
/* 71 */     if (this.vaultHook != null) this.vaultHook.clearCache(); 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/PluginHookManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */