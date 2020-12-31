/*    */ package me.TechsCode.UltraPermissions.internal.lookup.checks;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupCheck;
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupOutcome;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ 
/*    */ public class OperatorLookupCheck
/*    */   implements LookupCheck {
/*    */   private final OfflinePlayer offlinePlayer;
/*    */   
/*    */   public OperatorLookupCheck(OfflinePlayer paramOfflinePlayer) {
/* 12 */     this.offlinePlayer = paramOfflinePlayer;
/*    */   }
/*    */ 
/*    */   
/*    */   public LookupOutcome perform(String paramString) {
/* 17 */     if (this.offlinePlayer.isOp()) return new LookupOutcome(true, "Operator Rights");
/*    */     
/* 19 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/lookup/checks/OperatorLookupCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */