/*    */ package me.TechsCode.UltraPermissions.base.registry;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ 
/*    */ public class RegistryStorageEntry
/*    */   extends Storable
/*    */ {
/*    */   private String key;
/*    */   private JsonObject value;
/*    */   private RegistryStorable storable;
/*    */   
/*    */   public RegistryStorageEntry(String paramString, JsonObject paramJsonObject) {
/* 15 */     this.key = paramString;
/* 16 */     this.value = paramJsonObject;
/*    */   }
/*    */   
/*    */   public void setStorable(RegistryStorable paramRegistryStorable) {
/* 20 */     this.storable = paramRegistryStorable;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getKey() {
/* 25 */     return this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setKey(String paramString) {
/* 30 */     this.key = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonObject getState() {
/* 35 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(JsonObject paramJsonObject, TechPlugin paramTechPlugin) {
/* 40 */     this.value = paramJsonObject;
/*    */     
/* 42 */     if (this.storable != null) {
/* 43 */       this.storable.setState(paramJsonObject);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMount(TechPlugin paramTechPlugin) {}
/*    */ 
/*    */   
/*    */   protected void sync() {
/* 52 */     super.sync();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/registry/RegistryStorageEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */