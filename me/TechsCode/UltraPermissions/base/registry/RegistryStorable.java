/*    */ package me.TechsCode.UltraPermissions.base.registry;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ 
/*    */ public abstract class RegistryStorable
/*    */ {
/*    */   private String key;
/*    */   private RegistryStorageEntry storageEntry;
/*    */   
/*    */   public RegistryStorable(String paramString) {
/* 11 */     this.key = paramString;
/*    */   }
/*    */   
/*    */   public void setStorageEntry(RegistryStorageEntry paramRegistryStorageEntry) {
/* 15 */     this.storageEntry = paramRegistryStorageEntry;
/* 16 */     this.storageEntry.setStorable(this);
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 20 */     return this.key;
/*    */   }
/*    */   
/*    */   public abstract void setState(JsonObject paramJsonObject);
/*    */   
/*    */   public abstract JsonObject getState();
/*    */   
/*    */   public void sync() {
/* 28 */     this.storageEntry.setState(getState(), null);
/* 29 */     this.storageEntry.sync();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/registry/RegistryStorable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */