/*    */ package me.TechsCode.UltraPermissions.internal.lookup;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.internal.Node;
/*    */ 
/*    */ public abstract class PermissionLookup
/*    */ {
/*    */   private final Node permission;
/*    */   private LookupOutcome outcome;
/*    */   
/*    */   public PermissionLookup(String paramString) {
/* 11 */     this.permission = new Node(paramString);
/* 12 */     this.outcome = null;
/*    */   }
/*    */   
/*    */   public LookupOutcome getOutcome() {
/* 16 */     return this.outcome;
/*    */   }
/*    */   
/*    */   public LookupOutcome perform() {
/* 20 */     if (this.outcome != null) return this.outcome;
/*    */     
/* 22 */     for (String str : this.permission.getSelfAndWildcards()) {
/* 23 */       this.outcome = checkPermission(str);
/*    */       
/* 25 */       if (this.outcome != null) return this.outcome;
/*    */     
/*    */     } 
/* 28 */     return new LookupOutcome(false, null);
/*    */   }
/*    */   
/*    */   private LookupOutcome checkPermission(String paramString) {
/* 32 */     for (LookupCheck lookupCheck : getChecks()) {
/* 33 */       LookupOutcome lookupOutcome = lookupCheck.perform(paramString);
/*    */       
/* 35 */       if (lookupOutcome != null) return lookupOutcome;
/*    */     
/*    */     } 
/* 38 */     return null;
/*    */   }
/*    */   
/*    */   public abstract LookupCheck[] getChecks();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/lookup/PermissionLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */