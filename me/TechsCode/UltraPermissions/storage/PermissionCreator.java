/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Holder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ public class PermissionCreator
/*    */ {
/*    */   private PermissionStorage storage;
/*    */   private String name;
/*    */   private Holder holder;
/*    */   private String world;
/*    */   private String server;
/*    */   private boolean positive = true;
/*    */   private long expiration;
/*    */   
/*    */   public PermissionCreator(PermissionStorage paramPermissionStorage, String paramString, Holder paramHolder) {
/* 18 */     this.storage = paramPermissionStorage;
/* 19 */     this.name = paramString;
/* 20 */     this.holder = paramHolder;
/*    */     
/* 22 */     if (paramString.startsWith("-")) {
/* 23 */       this.name = paramString.substring(1);
/* 24 */       this.positive = false;
/*    */     } 
/*    */     
/* 27 */     this.name = this.name.replace(" ", ".");
/*    */   }
/*    */   
/*    */   public PermissionCreator setServer(String paramString) {
/* 31 */     this.server = paramString;
/* 32 */     return this;
/*    */   }
/*    */   
/*    */   public PermissionCreator setWorld(String paramString) {
/* 36 */     this.world = paramString;
/* 37 */     return this;
/*    */   }
/*    */   
/*    */   public PermissionCreator setPositive(boolean paramBoolean) {
/* 41 */     this.positive = paramBoolean;
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public PermissionCreator setExpiration(long paramLong) {
/* 46 */     this.expiration = paramLong;
/* 47 */     return this;
/*    */   }
/*    */   
/*    */   public Permission create() {
/* 51 */     return (Permission)this.storage.create((Storable)new Permission(this.storage.getNextNumericId(), this.holder, this.world, this.server, this.name, this.positive, this.expiration));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/PermissionCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */