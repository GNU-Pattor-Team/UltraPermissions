/*    */ package me.TechsCode.UltraPermissions.hooks.pluginHooks;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import net.milkbowl.vault.chat.Chat;
/*    */ import net.milkbowl.vault.permission.Permission;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.ServicePriority;
/*    */ import org.bukkit.plugin.ServicesManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class VaultHook {
/*    */   private final UltraPermissions plugin;
/*    */   private final VaultPermissionHook permissionHook;
/*    */   private final VaultChatHook vaultChatHook;
/*    */   
/*    */   public VaultHook(UltraPermissions paramUltraPermissions) {
/* 17 */     this.plugin = paramUltraPermissions;
/*    */     
/* 19 */     this.permissionHook = new VaultPermissionHook(paramUltraPermissions);
/* 20 */     this.vaultChatHook = new VaultChatHook(this.permissionHook, paramUltraPermissions);
/*    */     
/* 22 */     hook();
/*    */   }
/*    */   
/*    */   public void hook() {
/* 26 */     ServicesManager servicesManager = ((JavaPlugin)this.plugin.getBootstrap()).getServer().getServicesManager();
/* 27 */     servicesManager.register(Permission.class, this.permissionHook, (Plugin)this.plugin.getBootstrap(), ServicePriority.High);
/* 28 */     servicesManager.register(Chat.class, this.vaultChatHook, (Plugin)this.plugin.getBootstrap(), ServicePriority.High);
/*    */   }
/*    */   
/*    */   public void unhook() {
/* 32 */     ServicesManager servicesManager = ((JavaPlugin)this.plugin.getBootstrap()).getServer().getServicesManager();
/* 33 */     servicesManager.unregister(Permission.class, this.permissionHook);
/*    */   }
/*    */   
/*    */   public void clearCache() {
/* 37 */     this.permissionHook.clearCache();
/* 38 */     this.vaultChatHook.clearCache();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/pluginHooks/VaultHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */