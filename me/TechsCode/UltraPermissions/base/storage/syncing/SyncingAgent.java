/*    */ package me.TechsCode.UltraPermissions.base.storage.syncing;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SyncingAgent
/*    */ {
/* 13 */   private List<Storage> storages = new ArrayList<>();
/*    */ 
/*    */   
/*    */   public void executeLocalSynchronization(String paramString1, String paramString2) {
/* 17 */     this.storages.forEach(paramStorage -> {
/*    */           if (paramStorage.getModelName().equals(paramString1)) {
/*    */             paramStorage.syncFromDatabase(paramString2);
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   public void register(Storage paramStorage) {
/* 25 */     this.storages.add(paramStorage);
/*    */   }
/*    */   
/*    */   public abstract void notifyNewDataChanges(Storage paramStorage, String paramString);
/*    */   
/*    */   public static class EmptyAgent extends SyncingAgent {
/*    */     public void notifyNewDataChanges(Storage param1Storage, String param1String) {}
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/syncing/SyncingAgent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */