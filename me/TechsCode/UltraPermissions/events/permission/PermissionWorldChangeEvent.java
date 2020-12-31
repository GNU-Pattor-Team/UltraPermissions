/*    */ package me.TechsCode.UltraPermissions.events.permission;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ 
/*    */ public class PermissionWorldChangeEvent
/*    */   extends PermissionEvent
/*    */ {
/*    */   private final Optional<String> oldWorld;
/*    */   private final Optional<String> newWorld;
/*    */   
/*    */   public PermissionWorldChangeEvent(Permission paramPermission, Optional<String> paramOptional1, Optional<String> paramOptional2) {
/* 14 */     super(paramPermission);
/* 15 */     this.oldWorld = paramOptional1;
/* 16 */     this.newWorld = paramOptional2;
/*    */   }
/*    */   
/*    */   public Optional<String> getOldWorld() {
/* 20 */     return this.oldWorld;
/*    */   }
/*    */   
/*    */   public Optional<String> getNewWorld() {
/* 24 */     return this.newWorld;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/permission/PermissionWorldChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */