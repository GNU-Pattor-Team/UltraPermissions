/*    */ package me.TechsCode.UltraPermissions.internal.lookup.checks;
/*    */ 
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupCheck;
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupOutcome;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DefinedPermissionCheck
/*    */   implements LookupCheck
/*    */ {
/* 14 */   private List<Permission> definedPermissions = getDefinedPermissions();
/*    */ 
/*    */ 
/*    */   
/*    */   public LookupOutcome perform(String paramString) {
/* 19 */     boolean bool = false;
/* 20 */     Permission permission = null;
/*    */     
/* 22 */     for (Permission permission1 : this.definedPermissions) {
/* 23 */       for (String str : permission1.asNode().getSelfAndContainedPermissions()) {
/* 24 */         if (str.equalsIgnoreCase(paramString)) {
/* 25 */           if (permission1.isPositive()) {
/* 26 */             bool = true;
/* 27 */             permission = permission1; continue;
/*    */           } 
/* 29 */           return new LookupOutcome(false, "Negated from -" + permission1.getName());
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 35 */     if (bool) return new LookupOutcome(true, "Through Permission '" + permission.getName() + "'");
/*    */     
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public abstract List<Permission> getDefinedPermissions();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/lookup/checks/DefinedPermissionCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */