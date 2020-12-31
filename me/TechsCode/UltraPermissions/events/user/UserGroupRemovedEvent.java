/*    */ package me.TechsCode.UltraPermissions.events.user;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.storage.Stored;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class UserGroupRemovedEvent
/*    */   extends UserEvent {
/*    */   private final Stored<Group> group;
/*    */   
/*    */   public UserGroupRemovedEvent(User paramUser, Stored<Group> paramStored) {
/* 12 */     super(paramUser);
/*    */     
/* 14 */     this.group = paramStored;
/*    */   }
/*    */   
/*    */   public Stored<Group> getGroup() {
/* 18 */     return this.group;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/user/UserGroupRemovedEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */