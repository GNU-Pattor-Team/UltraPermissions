/*    */ package me.TechsCode.UltraPermissions.base.registry;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.implementations.LocalFile;
/*    */ import me.TechsCode.UltraPermissions.base.storage.implementations.MySQL;
/*    */ 
/*    */ public class Registry
/*    */ {
/*    */   private TechPlugin plugin;
/*    */   private RegistryStorage local;
/*    */   private RegistryStorage global;
/*    */   
/*    */   public Registry(TechPlugin paramTechPlugin) {
/* 14 */     this.plugin = paramTechPlugin;
/*    */     
/* 16 */     this.local = new RegistryStorage(paramTechPlugin, (Class)LocalFile.class);
/*    */   }
/*    */   
/*    */   private void startRemoteRegistry() {
/* 20 */     if (this.global != null)
/*    */       return; 
/* 22 */     this.global = (this.plugin.getMySQLManager() != null && this.plugin.getMySQLManager().isEnabled()) ? new RegistryStorage(this.plugin, (Class)MySQL.class) : null;
/*    */   }
/*    */   
/*    */   public <T extends RegistryStorable> BiRegistry<T> register(Class<? extends T> paramClass) {
/*    */     try {
/* 27 */       RegistryStorable registryStorable = (RegistryStorable)paramClass.newInstance();
/* 28 */       return register((T)registryStorable);
/* 29 */     } catch (InstantiationException|IllegalAccessException instantiationException) {
/* 30 */       instantiationException.printStackTrace();
/* 31 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public <T extends RegistryStorable> BiRegistry<T> register(T paramT) {
/* 36 */     T t1 = (T)register((Object)paramT, RegistrationChoice.LOCAL);
/* 37 */     T t2 = (T)register((Object)paramT, RegistrationChoice.GLOBAL);
/* 38 */     return new BiRegistry<>(t1, t2);
/*    */   }
/*    */   
/*    */   public <T extends RegistryStorable> T register(Class<? extends T> paramClass, RegistrationChoice paramRegistrationChoice) {
/*    */     try {
/* 43 */       RegistryStorable registryStorable = (RegistryStorable)paramClass.newInstance();
/* 44 */       return register((T)registryStorable, paramRegistrationChoice);
/* 45 */     } catch (InstantiationException|IllegalAccessException instantiationException) {
/* 46 */       instantiationException.printStackTrace();
/* 47 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public <T extends RegistryStorable> T register(T paramT, RegistrationChoice paramRegistrationChoice) {
/* 52 */     startRemoteRegistry();
/*    */     
/* 54 */     Registration registration = null;
/*    */     
/* 56 */     switch (paramRegistrationChoice) { case LOCAL:
/* 57 */         registration = Registration.LOCAL; break;
/*    */       case GLOBAL:
/* 59 */         registration = (this.global != null) ? Registration.GLOBAL : null; break;
/*    */       case GLOBAL_IF_AVAILABLE:
/* 61 */         registration = (this.global != null) ? Registration.GLOBAL : Registration.LOCAL;
/*    */         break; }
/*    */ 
/*    */     
/* 65 */     if (registration == null) {
/* 66 */       return null;
/*    */     }
/*    */     
/* 69 */     RegistryStorage registryStorage = (registration == Registration.LOCAL) ? this.local : this.global;
/* 70 */     RegistryStorageEntry registryStorageEntry = registryStorage.retrieve(new RegistryStorageEntry(paramT.getKey(), paramT.getState()));
/*    */     
/* 72 */     paramT.setStorageEntry(registryStorageEntry);
/* 73 */     paramT.setState(registryStorageEntry.getState());
/*    */     
/* 75 */     return paramT;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/registry/Registry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */