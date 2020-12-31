/*    */ package me.TechsCode.UltraPermissions.storage.objects;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.StorageController;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Stored;
/*    */ 
/*    */ 
/*    */ public class Holder
/*    */ {
/*    */   private final Stored<User> userHolder;
/*    */   private final Stored<Group> groupHolder;
/*    */   
/*    */   public static Holder fromUser(User paramUser) {
/* 16 */     return new Holder(paramUser.toStored(), null);
/*    */   }
/*    */   
/*    */   public static Holder fromGroup(Group paramGroup) {
/* 20 */     return new Holder(null, paramGroup.toStored());
/*    */   }
/*    */   
/*    */   public static Holder fromKey(JsonElement paramJsonElement, TechPlugin<?> paramTechPlugin) {
/* 24 */     StorageController storageController = (StorageController)paramTechPlugin;
/*    */     
/* 26 */     if (paramJsonElement.getAsString().length() > 10) {
/* 27 */       return new Holder(new Stored(paramJsonElement, storageController::getUserStorage), null);
/*    */     }
/* 29 */     return new Holder(null, new Stored(paramJsonElement, storageController::getGroupStorage));
/*    */   }
/*    */ 
/*    */   
/*    */   private Holder(Stored<User> paramStored, Stored<Group> paramStored1) {
/* 34 */     this.userHolder = paramStored;
/* 35 */     this.groupHolder = paramStored1;
/*    */   }
/*    */   
/*    */   public boolean isUser() {
/* 39 */     return (this.userHolder != null);
/*    */   }
/*    */   
/*    */   public boolean isGroup() {
/* 43 */     return (this.groupHolder != null);
/*    */   }
/*    */   
/*    */   public Optional<PermissionHolder> get() {
/* 47 */     return (this.userHolder != null) ? Optional.<PermissionHolder>ofNullable(this.userHolder.get().orElse(null)) : Optional.<PermissionHolder>ofNullable(this.groupHolder.get().orElse(null));
/*    */   }
/*    */   
/*    */   public String getName() {
/* 51 */     return get().<String>map(PermissionHolder::getName).orElse("INVALID");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 56 */     if (!(paramObject instanceof Holder)) return false;
/*    */     
/* 58 */     Holder holder = (Holder)paramObject;
/*    */     
/* 60 */     return toStored().equals(holder.toStored());
/*    */   }
/*    */   
/*    */   public Stored<?> toStored() {
/* 64 */     return (this.userHolder != null) ? this.userHolder : this.groupHolder;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/objects/Holder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */