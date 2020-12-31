/*    */ package me.TechsCode.UltraPermissions.events.permission;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ public class PermissionPolarityChangeEvent
/*    */   extends PermissionEvent {
/*    */   private final boolean oldPolarity;
/*    */   private final boolean newPolarity;
/*    */   
/*    */   public PermissionPolarityChangeEvent(Permission paramPermission, boolean paramBoolean1, boolean paramBoolean2) {
/* 11 */     super(paramPermission);
/* 12 */     this.oldPolarity = paramBoolean1;
/* 13 */     this.newPolarity = paramBoolean2;
/*    */   }
/*    */   
/*    */   public boolean getNewPolarity() {
/* 17 */     return this.newPolarity;
/*    */   }
/*    */   
/*    */   public boolean getOldPolarity() {
/* 21 */     return this.oldPolarity;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/permission/PermissionPolarityChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */