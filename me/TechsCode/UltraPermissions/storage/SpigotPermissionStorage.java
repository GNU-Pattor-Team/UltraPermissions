/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ import me.TechsCode.UltraPermissions.events.permission.PermissionCreationEvent;
/*    */ import me.TechsCode.UltraPermissions.events.permission.PermissionDeletionEvent;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ public class SpigotPermissionStorage extends PermissionStorage {
/*    */   public SpigotPermissionStorage(TechPlugin paramTechPlugin, Class<? extends StorageImplementation> paramClass) {
/* 13 */     super(paramTechPlugin, paramClass);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreation(Permission paramPermission) {
/* 18 */     super.onCreation(paramPermission);
/*    */     
/* 20 */     PermissionCreationEvent permissionCreationEvent = new PermissionCreationEvent(paramPermission);
/* 21 */     permissionCreationEvent.call(this.plugin, (Event)permissionCreationEvent);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDestroy(Permission paramPermission) {
/* 26 */     super.onDestroy(paramPermission);
/*    */     
/* 28 */     PermissionDeletionEvent permissionDeletionEvent = new PermissionDeletionEvent(paramPermission);
/* 29 */     permissionDeletionEvent.call(this.plugin, (Event)permissionDeletionEvent);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onChange(Permission paramPermission) {
/* 34 */     super.onChange(paramPermission);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/SpigotPermissionStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */