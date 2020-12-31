/*    */ package me.TechsCode.UltraPermissions.events.group;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.events.UPEvent;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ 
/*    */ public class GroupChangeEvent
/*    */   extends UPEvent {
/*    */   private final Group oldGroup;
/*    */   private final Group newGroup;
/*    */   
/*    */   public GroupChangeEvent(Group paramGroup1, Group paramGroup2) {
/* 12 */     this.oldGroup = paramGroup1;
/* 13 */     this.newGroup = paramGroup2;
/*    */   }
/*    */   
/*    */   public Group getNewGroup() {
/* 17 */     return this.newGroup;
/*    */   }
/*    */   
/*    */   public Group getOldGroup() {
/* 21 */     return this.oldGroup;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/group/GroupChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */