/*    */ package me.TechsCode.UltraPermissions.base.storage;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ 
/*    */ 
/*    */ public abstract class Storable
/*    */ {
/*    */   protected Storage storage;
/*    */   private JsonObject lastSyncedState;
/*    */   
/*    */   public void setStorage(Storage paramStorage) {
/* 13 */     this.storage = paramStorage;
/*    */   }
/*    */   
/*    */   protected void sync() {
/* 17 */     if (this.storage != null) {
/* 18 */       JsonObject jsonObject = getState();
/*    */       
/* 20 */       if (this.lastSyncedState == null || !this.lastSyncedState.toString().equalsIgnoreCase(jsonObject.toString())) {
/* 21 */         this.storage.update(this, jsonObject);
/* 22 */         this.lastSyncedState = jsonObject;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setLastSyncedState(JsonObject paramJsonObject) {
/* 28 */     this.lastSyncedState = paramJsonObject;
/*    */   }
/*    */   
/*    */   protected void destroy() {
/* 32 */     if (this.storage != null) {
/* 33 */       this.storage.destroy(this);
/* 34 */       this.storage = null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract String getKey();
/*    */   
/*    */   public abstract void setKey(String paramString);
/*    */   
/*    */   public abstract JsonObject getState();
/*    */   
/*    */   public abstract void setState(JsonObject paramJsonObject, TechPlugin paramTechPlugin);
/*    */   
/*    */   public boolean isLinkedToStorage() {
/* 47 */     return (this.storage != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 52 */     if (!(paramObject instanceof Storable)) return false;
/*    */     
/* 54 */     Storable storable = (Storable)paramObject;
/*    */     
/* 56 */     return storable.getKey().equals(getKey());
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 61 */     return getKey().hashCode();
/*    */   }
/*    */   
/*    */   public abstract void onMount(TechPlugin paramTechPlugin);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/Storable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */