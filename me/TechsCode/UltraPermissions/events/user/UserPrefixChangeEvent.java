/*    */ package me.TechsCode.UltraPermissions.events.user;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class UserPrefixChangeEvent
/*    */   extends UserEvent
/*    */ {
/*    */   private final String oldPrefix;
/*    */   private final String newPrefix;
/*    */   
/*    */   public UserPrefixChangeEvent(User paramUser, @Nullable String paramString1, @Nullable String paramString2) {
/* 13 */     super(paramUser);
/* 14 */     this.oldPrefix = paramString1;
/* 15 */     this.newPrefix = paramString2;
/*    */   }
/*    */   
/*    */   public String getNewPrefix() {
/* 19 */     return this.newPrefix;
/*    */   }
/*    */   
/*    */   public String getOldPrefix() {
/* 23 */     return this.oldPrefix;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/user/UserPrefixChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */