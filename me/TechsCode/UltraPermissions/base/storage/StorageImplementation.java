/*    */ package me.TechsCode.UltraPermissions.base.storage;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ 
/*    */ public abstract class StorageImplementation
/*    */ {
/*    */   protected TechPlugin plugin;
/*    */   protected String name;
/*    */   private boolean multiServerSupport;
/*    */   
/*    */   public StorageImplementation(TechPlugin paramTechPlugin, String paramString, boolean paramBoolean) {
/* 13 */     this.plugin = paramTechPlugin;
/* 14 */     this.name = paramString;
/* 15 */     this.multiServerSupport = paramBoolean;
/*    */   }
/*    */   
/*    */   public abstract void destroy(String paramString, WriteCallback paramWriteCallback);
/*    */   
/*    */   public abstract void create(String paramString, JsonObject paramJsonObject, WriteCallback paramWriteCallback);
/*    */   
/*    */   public abstract void update(String paramString, JsonObject paramJsonObject, WriteCallback paramWriteCallback);
/*    */   
/*    */   public abstract void read(String paramString, ReadCallback paramReadCallback);
/*    */   
/*    */   public boolean hasMultiServerSupport() {
/* 27 */     return this.multiServerSupport;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/StorageImplementation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */