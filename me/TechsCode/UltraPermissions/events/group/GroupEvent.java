/*    */ package me.TechsCode.UltraPermissions.events.group;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.events.UPEvent;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ 
/*    */ public abstract class GroupEvent
/*    */   extends UPEvent {
/*    */   public final Group group;
/*    */   
/*    */   public GroupEvent(Group paramGroup) {
/* 11 */     this.group = paramGroup;
/*    */   }
/*    */   
/*    */   public Group getGroup() {
/* 15 */     return this.group;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/group/GroupEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */