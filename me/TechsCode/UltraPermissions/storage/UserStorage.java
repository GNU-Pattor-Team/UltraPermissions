/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.UUID;
/*    */ import me.TechsCode.UltraPermissions.StorageController;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissionsAPI;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ import me.TechsCode.UltraPermissions.storage.collection.UserList;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class UserStorage extends Storage<User> {
/*    */   public UserStorage(TechPlugin paramTechPlugin, Class<? extends StorageImplementation> paramClass) {
/* 16 */     super(paramTechPlugin, "Users", User.class, paramClass, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMount(User paramUser) {}
/*    */ 
/*    */   
/*    */   public void onCreation(User paramUser) {
/* 24 */     StorageController storageController = (StorageController)this.plugin;
/* 25 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDestroy(User paramUser) {
/* 30 */     StorageController storageController = (StorageController)this.plugin;
/* 31 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onChange(User paramUser) {
/* 36 */     StorageController storageController = (StorageController)this.plugin;
/* 37 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDataSynchronization() {
/* 42 */     StorageController storageController = (StorageController)this.plugin;
/* 43 */     storageController.onDataModification();
/*    */   }
/*    */   
/*    */   public UserList getUsers() {
/* 47 */     UserList userList = new UserList();
/* 48 */     userList.addAll(get());
/* 49 */     return userList;
/*    */   }
/*    */   
/*    */   public User registerUser(UUID paramUUID, String paramString, boolean paramBoolean) {
/* 53 */     UltraPermissionsAPI ultraPermissionsAPI = (UltraPermissionsAPI)this.plugin;
/* 54 */     User user = (User)create((Storable)new User(paramUUID, paramString, false, new HashMap<>(), null, null, null));
/*    */     
/* 56 */     if (paramBoolean) ultraPermissionsAPI.getGroups().defaults(true).forEach(user::addGroup);
/*    */     
/* 58 */     return user;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/UserStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */