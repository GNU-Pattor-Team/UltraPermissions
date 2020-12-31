/*    */ package me.TechsCode.UltraPermissions.storage.objects;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Stored;
/*    */ 
/*    */ public class UserRankup
/*    */ {
/*    */   private final User user;
/*    */   private final Stored<Group> group;
/*    */   private final long expiry;
/*    */   
/*    */   public UserRankup(User paramUser, Stored<Group> paramStored, long paramLong) {
/* 13 */     this.user = paramUser;
/* 14 */     this.group = paramStored;
/* 15 */     this.expiry = paramLong;
/*    */   }
/*    */   
/*    */   public User getUser() {
/* 19 */     return this.user;
/*    */   }
/*    */   
/*    */   public String getGroupName() {
/* 23 */     return this.group.get().map(Group::getName).orElse("INVALID");
/*    */   }
/*    */   
/*    */   public XMaterial getIcon() {
/* 27 */     return this.group.get().map(Group::getIcon).orElse(XMaterial.STONE);
/*    */   }
/*    */   
/*    */   public Stored<Group> getGroup() {
/* 31 */     return this.group;
/*    */   }
/*    */   
/*    */   public long getExpiry() {
/* 35 */     return this.expiry;
/*    */   }
/*    */   
/*    */   public long getLeftDuration() {
/* 39 */     return this.expiry - System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public boolean isPermanent() {
/* 43 */     return (this.expiry == 0L);
/*    */   }
/*    */   
/*    */   public boolean isTemporary() {
/* 47 */     return (this.expiry != 0L);
/*    */   }
/*    */   
/*    */   public boolean isExpired() {
/* 51 */     return (!isPermanent() && getLeftDuration() < 0L);
/*    */   }
/*    */   
/*    */   public void remove() {
/* 55 */     this.group.get().ifPresent(this.user::removeGroup);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/objects/UserRankup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */