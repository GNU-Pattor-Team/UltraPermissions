/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.permissionDatabase.PermissionInfo;
/*    */ 
/*    */ 
/*    */ public class PermissionWithInfo
/*    */ {
/*    */   private final String permission;
/*    */   private final PermissionInfo info;
/*    */   
/*    */   public PermissionWithInfo(String paramString, PermissionInfo paramPermissionInfo) {
/* 12 */     this.permission = paramString;
/* 13 */     this.info = paramPermissionInfo;
/*    */   }
/*    */   
/*    */   public boolean hasInfo() {
/* 17 */     return (this.info != null);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 21 */     return this.permission;
/*    */   }
/*    */   
/*    */   public PermissionInfo getInfo() {
/* 25 */     return this.info;
/*    */   }
/*    */   
/*    */   public boolean isThisPermission(String paramString) {
/* 29 */     return hasInfo() ? this.info.isThisPermission(paramString) : this.permission.equalsIgnoreCase(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 34 */     if (paramObject instanceof PermissionWithInfo) return this.permission.equalsIgnoreCase(((PermissionWithInfo)paramObject).permission);
/*    */     
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 41 */     return this.permission.hashCode();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PermissionWithInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */