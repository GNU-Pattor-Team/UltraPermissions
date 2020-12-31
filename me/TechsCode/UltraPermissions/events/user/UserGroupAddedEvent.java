/*    */ package me.TechsCode.UltraPermissions.events.user;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.storage.Stored;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class UserGroupAddedEvent
/*    */   extends UserEvent {
/*    */   private final Stored<Group> group;
/*    */   private final long expiry;
/*    */   
/*    */   public UserGroupAddedEvent(User paramUser, Stored<Group> paramStored, long paramLong) {
/* 13 */     super(paramUser);
/*    */     
/* 15 */     this.group = paramStored;
/* 16 */     this.expiry = paramLong;
/*    */   }
/*    */   
/*    */   public Stored<Group> getGroup() {
/* 20 */     return this.group;
/*    */   }
/*    */   
/*    */   public long getExpiry() {
/* 24 */     return this.expiry;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/user/UserGroupAddedEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */