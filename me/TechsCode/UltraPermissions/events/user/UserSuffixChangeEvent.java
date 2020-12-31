/*    */ package me.TechsCode.UltraPermissions.events.user;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class UserSuffixChangeEvent
/*    */   extends UserEvent
/*    */ {
/*    */   private final String oldSuffix;
/*    */   private final String newSuffix;
/*    */   
/*    */   public UserSuffixChangeEvent(User paramUser, @Nullable String paramString1, @Nullable String paramString2) {
/* 13 */     super(paramUser);
/* 14 */     this.oldSuffix = paramString1;
/* 15 */     this.newSuffix = paramString2;
/*    */   }
/*    */   
/*    */   public String getOldSuffix() {
/* 19 */     return this.oldSuffix;
/*    */   }
/*    */   
/*    */   public String getNewSuffix() {
/* 23 */     return this.newSuffix;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/user/UserSuffixChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */