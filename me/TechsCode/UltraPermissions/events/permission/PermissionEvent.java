/*    */ package me.TechsCode.UltraPermissions.events.permission;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.events.UPEvent;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ public class PermissionEvent
/*    */   extends UPEvent {
/*    */   private final Permission permission;
/*    */   
/*    */   public PermissionEvent(Permission paramPermission) {
/* 11 */     this.permission = paramPermission;
/*    */   }
/*    */   
/*    */   public Permission getPermission() {
/* 15 */     return this.permission;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/permission/PermissionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */