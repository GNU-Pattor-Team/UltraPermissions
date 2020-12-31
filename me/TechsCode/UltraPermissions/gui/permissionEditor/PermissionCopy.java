/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.PermissionColor;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ public class PermissionCopy
/*    */ {
/*    */   private final Permission permission;
/*    */   private final boolean inherited;
/*    */   
/*    */   public PermissionCopy(Permission paramPermission, boolean paramBoolean) {
/* 12 */     this.permission = paramPermission;
/* 13 */     this.inherited = paramBoolean;
/*    */   }
/*    */   
/*    */   public Permission getPermission() {
/* 17 */     return this.permission;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 21 */     return this.permission.getName();
/*    */   }
/*    */   
/*    */   public String getColoredName() {
/* 25 */     PermissionColor permissionColor = PermissionColor.fromPermission(this);
/*    */     
/* 27 */     return permissionColor.getColor() + getName();
/*    */   }
/*    */   
/*    */   public PermissionColor getColor() {
/* 31 */     return PermissionColor.fromPermission(this);
/*    */   }
/*    */   
/*    */   public boolean isInherited() {
/* 35 */     return this.inherited;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PermissionCopy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */