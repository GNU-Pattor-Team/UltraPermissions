/*    */ package me.TechsCode.UltraPermissions.base.storage.implementations;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.io.File;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.HashMap;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.fileconf.FileConfiguration;
/*    */ import me.TechsCode.UltraPermissions.base.storage.ReadCallback;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ import me.TechsCode.UltraPermissions.base.storage.WriteCallback;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.Base64;
/*    */ 
/*    */ public class LocalFile
/*    */   extends StorageImplementation
/*    */ {
/*    */   private File file;
/*    */   private FileConfiguration configuration;
/*    */   
/*    */   public LocalFile(TechPlugin paramTechPlugin, String paramString) {
/* 22 */     super(paramTechPlugin, paramString, false);
/*    */     
/* 24 */     this.file = new File(paramTechPlugin.getPluginFolder().getAbsolutePath() + "/" + paramString + ".json");
/* 25 */     this.configuration = new FileConfiguration(paramTechPlugin, this.file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void destroy(String paramString, WriteCallback paramWriteCallback) {
/* 30 */     synchronized (this.configuration) {
/* 31 */       this.configuration.set(paramString, null);
/* 32 */       this.configuration.save();
/*    */       
/* 34 */       paramWriteCallback.onSuccess();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void create(String paramString, JsonObject paramJsonObject, WriteCallback paramWriteCallback) {
/* 39 */     update(paramString, paramJsonObject, paramWriteCallback);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(String paramString, JsonObject paramJsonObject, WriteCallback paramWriteCallback) {
/* 44 */     synchronized (this.configuration) {
/* 45 */       String str = Base64.encodeBase64String(paramJsonObject.toString().getBytes(StandardCharsets.UTF_8));
/* 46 */       this.configuration.set(paramString, str);
/* 47 */       this.configuration.save();
/* 48 */       paramWriteCallback.onSuccess();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(String paramString, ReadCallback paramReadCallback) {
/* 54 */     synchronized (this.configuration) {
/* 55 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*    */       
/* 57 */       JsonParser jsonParser = new JsonParser();
/*    */       
/* 59 */       for (String str1 : this.configuration.getKeys(false)) {
/* 60 */         String str2 = this.configuration.getString(str1);
/*    */         
/* 62 */         if (Base64.isBase64(str2)) {
/* 63 */           str2 = new String(Base64.decodeBase64(str2), StandardCharsets.UTF_8);
/*    */         }
/*    */         
/* 66 */         JsonObject jsonObject = (JsonObject)jsonParser.parse(str2);
/* 67 */         hashMap.put(str1, jsonObject);
/*    */       } 
/*    */       
/* 70 */       paramReadCallback.onSuccess(hashMap);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/implementations/LocalFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */