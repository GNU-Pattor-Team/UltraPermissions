/*    */ package me.TechsCode.UltraPermissions.internal.lookup.checks;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupCheck;
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupOutcome;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.permissions.Permission;
/*    */ 
/*    */ public class DefaultPermissionCheck
/*    */   implements LookupCheck {
/*    */   private OfflinePlayer offlinePlayer;
/*    */   
/*    */   public DefaultPermissionCheck(OfflinePlayer paramOfflinePlayer) {
/* 14 */     this.offlinePlayer = paramOfflinePlayer;
/*    */   }
/*    */ 
/*    */   
/*    */   public LookupOutcome perform(String paramString) {
/* 19 */     Permission permission = Bukkit.getPluginManager().getPermission(paramString);
/*    */     
/* 21 */     if (permission != null && permission.getDefault().getValue(this.offlinePlayer.isOp())) {
/* 22 */       return new LookupOutcome(true, "Default Permission");
/*    */     }
/*    */     
/* 25 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/lookup/checks/DefaultPermissionCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */