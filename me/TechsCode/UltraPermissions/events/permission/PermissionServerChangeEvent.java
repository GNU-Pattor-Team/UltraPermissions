/*    */ package me.TechsCode.UltraPermissions.events.permission;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ 
/*    */ public class PermissionServerChangeEvent
/*    */   extends PermissionEvent
/*    */ {
/*    */   private final Optional<String> oldServer;
/*    */   private final Optional<String> newServer;
/*    */   
/*    */   public PermissionServerChangeEvent(Permission paramPermission, Optional<String> paramOptional1, Optional<String> paramOptional2) {
/* 14 */     super(paramPermission);
/* 15 */     this.oldServer = paramOptional1;
/* 16 */     this.newServer = paramOptional2;
/*    */   }
/*    */   
/*    */   public Optional<String> getOldServer() {
/* 20 */     return this.oldServer;
/*    */   }
/*    */   
/*    */   public Optional<String> getNewServer() {
/* 24 */     return this.newServer;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/permission/PermissionServerChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */