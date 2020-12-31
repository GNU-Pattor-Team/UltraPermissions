/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import me.TechsCode.UltraPermissions.StorageController;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Holder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ 
/*    */ public class PermissionStorage
/*    */   extends Storage<Permission>
/*    */ {
/*    */   public PermissionStorage(TechPlugin paramTechPlugin, Class<? extends StorageImplementation> paramClass) {
/* 18 */     super(paramTechPlugin, "Permissions", Permission.class, paramClass, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMount(Permission paramPermission) {}
/*    */ 
/*    */   
/*    */   public void onCreation(Permission paramPermission) {
/* 26 */     StorageController storageController = (StorageController)this.plugin;
/* 27 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDestroy(Permission paramPermission) {
/* 32 */     StorageController storageController = (StorageController)this.plugin;
/* 33 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onChange(Permission paramPermission) {
/* 38 */     StorageController storageController = (StorageController)this.plugin;
/* 39 */     storageController.onDataModification();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDataSynchronization() {
/* 44 */     StorageController storageController = (StorageController)this.plugin;
/* 45 */     storageController.onDataModification();
/*    */   }
/*    */   
/*    */   public PermissionList getPermissions() {
/* 49 */     PermissionList permissionList = new PermissionList();
/* 50 */     permissionList.addAll(get());
/* 51 */     permissionList.sort(Comparator.comparing(Permission::getId));
/* 52 */     return permissionList;
/*    */   }
/*    */   
/*    */   public PermissionCreator newPermission(String paramString, Holder paramHolder) {
/* 56 */     return new PermissionCreator(this, paramString, paramHolder);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/PermissionStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */