/*    */ package me.TechsCode.UltraPermissions.events.user;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class UserSuperAdminChangeEvent
/*    */   extends UserEvent {
/*    */   private final boolean oldSuperadmin;
/*    */   private final boolean newSuperadmin;
/*    */   
/*    */   public UserSuperAdminChangeEvent(User paramUser, boolean paramBoolean1, boolean paramBoolean2) {
/* 11 */     super(paramUser);
/* 12 */     this.oldSuperadmin = paramBoolean1;
/* 13 */     this.newSuperadmin = paramBoolean2;
/*    */   }
/*    */   
/*    */   public boolean isNowSuperAdmin() {
/* 17 */     return this.newSuperadmin;
/*    */   }
/*    */   
/*    */   public boolean wasSuperAdmin() {
/* 21 */     return this.oldSuperadmin;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/user/UserSuperAdminChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */