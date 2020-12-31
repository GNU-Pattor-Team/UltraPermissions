/*    */ package me.TechsCode.UltraPermissions.events.user;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.events.UPEvent;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public abstract class UserEvent
/*    */   extends UPEvent {
/*    */   public final User user;
/*    */   
/*    */   public UserEvent(User paramUser) {
/* 11 */     this.user = paramUser;
/*    */   }
/*    */   
/*    */   public User getUser() {
/* 15 */     return this.user;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/user/UserEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */