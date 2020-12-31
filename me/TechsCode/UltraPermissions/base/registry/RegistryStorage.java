/*    */ package me.TechsCode.UltraPermissions.base.registry;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.SimpleStorage;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ 
/*    */ public class RegistryStorage
/*    */   extends SimpleStorage<RegistryStorageEntry>
/*    */ {
/*    */   public RegistryStorage(TechPlugin paramTechPlugin, Class<? extends StorageImplementation> paramClass) {
/* 11 */     super(paramTechPlugin, "Registry", RegistryStorageEntry.class, paramClass, true);
/*    */   }
/*    */   
/*    */   public RegistryStorageEntry retrieve(RegistryStorageEntry paramRegistryStorageEntry) {
/* 15 */     for (RegistryStorageEntry registryStorageEntry : get()) {
/* 16 */       if (registryStorageEntry.getKey().equalsIgnoreCase(paramRegistryStorageEntry.getKey())) {
/* 17 */         return registryStorageEntry;
/*    */       }
/*    */     } 
/*    */     
/* 21 */     return (RegistryStorageEntry)create(paramRegistryStorageEntry);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/registry/RegistryStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */