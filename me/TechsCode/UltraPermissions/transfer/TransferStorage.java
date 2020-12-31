/*    */ package me.TechsCode.UltraPermissions.transfer;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ 
/*    */ public class TransferStorage<S extends Storable>
/*    */   extends Storage<S> {
/*    */   private long lastWrite;
/*    */   
/*    */   public TransferStorage(TechPlugin paramTechPlugin, String paramString, Class<? extends Storable> paramClass, Class<? extends StorageImplementation> paramClass1, boolean paramBoolean) {
/* 13 */     super(paramTechPlugin, paramString, paramClass, paramClass1, paramBoolean);
/*    */     
/* 15 */     this.lastWrite = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void onMount(S paramS) {
/* 19 */     this.lastWrite = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void onCreation(S paramS) {
/* 23 */     this.lastWrite = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void onDestroy(S paramS) {
/* 27 */     this.lastWrite = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void onChange(S paramS) {
/* 31 */     this.lastWrite = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public long getLastWrite() {
/* 35 */     return this.lastWrite;
/*    */   }
/*    */   
/*    */   public void onDataSynchronization() {}
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/transfer/TransferStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */