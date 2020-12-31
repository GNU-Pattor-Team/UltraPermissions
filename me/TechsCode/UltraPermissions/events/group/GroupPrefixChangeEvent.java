/*    */ package me.TechsCode.UltraPermissions.events.group;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ 
/*    */ public class GroupPrefixChangeEvent
/*    */   extends GroupEvent {
/*    */   private final String oldPrefix;
/*    */   private final String newPrefix;
/*    */   
/*    */   public GroupPrefixChangeEvent(Group paramGroup, String paramString1, String paramString2) {
/* 11 */     super(paramGroup);
/* 12 */     this.oldPrefix = paramString1;
/* 13 */     this.newPrefix = paramString2;
/*    */   }
/*    */   
/*    */   public String getOldPrefix() {
/* 17 */     return this.oldPrefix;
/*    */   }
/*    */   
/*    */   public String getNewPrefix() {
/* 21 */     return this.newPrefix;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/group/GroupPrefixChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */