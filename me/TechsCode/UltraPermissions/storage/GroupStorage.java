/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.StorageController;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ 
/*    */ public class GroupStorage extends Storage<Group> {
/*    */   public GroupStorage(TechPlugin paramTechPlugin, Class<? extends StorageImplementation> paramClass) {
/* 13 */     super(paramTechPlugin, "Groups", Group.class, paramClass, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMount(Group paramGroup) {}
/*    */ 
/*    */   
/*    */   public void onCreation(Group paramGroup) {
/* 21 */     StorageController storageController = (StorageController)this.plugin;
/* 22 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDestroy(Group paramGroup) {
/* 27 */     StorageController storageController = (StorageController)this.plugin;
/* 28 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onChange(Group paramGroup) {
/* 33 */     StorageController storageController = (StorageController)this.plugin;
/* 34 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDataSynchronization() {
/* 39 */     StorageController storageController = (StorageController)this.plugin;
/* 40 */     storageController.onDataModification();
/*    */   }
/*    */   
/*    */   public GroupList getGroups() {
/* 44 */     GroupList groupList = new GroupList();
/* 45 */     groupList.addAll(get());
/* 46 */     groupList.bestToWorst();
/* 47 */     return groupList;
/*    */   }
/*    */   
/*    */   public GroupCreator newGroup(String paramString) {
/* 51 */     return new GroupCreator(this, paramString);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/GroupStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */