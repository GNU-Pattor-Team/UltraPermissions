/*   */ package me.TechsCode.UltraPermissions.base.storage;
/*   */ 
/*   */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*   */ 
/*   */ public class SimpleStorage<S extends Storable>
/*   */   extends Storage<S> {
/*   */   public SimpleStorage(TechPlugin<?> paramTechPlugin, String paramString, Class<? extends Storable> paramClass, Class<? extends StorageImplementation> paramClass1, boolean paramBoolean) {
/* 8 */     super(paramTechPlugin, paramString, paramClass, paramClass1, paramBoolean);
/*   */   }
/*   */   
/*   */   public void onMount(S paramS) {}
/*   */   
/*   */   public void onCreation(S paramS) {}
/*   */   
/*   */   public void onChange(S paramS) {}
/*   */   
/*   */   public void onDestroy(S paramS) {}
/*   */   
/*   */   public void onDataSynchronization() {}
/*   */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/SimpleStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */