/*     */ package me.TechsCode.UltraPermissions.base.storage.implementations;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.regex.Pattern;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.storage.ReadCallback;
/*     */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*     */ import me.TechsCode.UltraPermissions.base.storage.WriteCallback;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.DecoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.Base64;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.Hex;
/*     */ 
/*     */ public class MySQL extends StorageImplementation {
/*  22 */   private static final Pattern REGEX_PATTERN = Pattern.compile("^\\p{XDigit}+$");
/*     */   
/*     */   private String tableName;
/*     */   private MySQLQueue queue;
/*     */   
/*     */   public MySQL(TechPlugin paramTechPlugin, String paramString) {
/*  28 */     super(paramTechPlugin, paramString, true);
/*     */     
/*  30 */     this.tableName = paramTechPlugin.getName() + "_" + paramString;
/*  31 */     this.queue = new MySQLQueue(paramTechPlugin);
/*     */     
/*     */     try {
/*  34 */       Connection connection = paramTechPlugin.getMySQLManager().newConnection();
/*  35 */       PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `" + this.tableName + "` ( `key` VARCHAR(64), `value` MEDIUMBLOB);");
/*  36 */       preparedStatement.execute();
/*  37 */       preparedStatement.close();
/*  38 */       connection.close();
/*  39 */     } catch (SQLException sQLException) {
/*  40 */       sQLException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroy(String paramString, WriteCallback paramWriteCallback) {
/*  46 */     this.queue.update("DELETE FROM " + this.tableName + " WHERE `key`='" + paramString + "';", paramWriteCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(String paramString, JsonObject paramJsonObject, WriteCallback paramWriteCallback) {
/*  51 */     this.queue.update("UPDATE " + this.tableName + " SET `value` = '" + jsonToString(paramJsonObject) + "' WHERE `key`='" + paramString + "';", paramWriteCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   public void create(String paramString, JsonObject paramJsonObject, WriteCallback paramWriteCallback) {
/*  56 */     destroy(paramString, (WriteCallback)new WriteCallback.EmptyWriteCallback());
/*  57 */     this.queue.update("INSERT INTO " + this.tableName + " (`key`, `value`) VALUES ('" + paramString + "', '" + jsonToString(paramJsonObject) + "');", paramWriteCallback);
/*     */   }
/*     */   
/*     */   private String jsonToString(JsonObject paramJsonObject) {
/*  61 */     return Base64.encodeBase64String(paramJsonObject.toString().replace("'", "\\'").getBytes(StandardCharsets.UTF_8));
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(String paramString, ReadCallback paramReadCallback) {
/*  66 */     JsonParser jsonParser = new JsonParser();
/*     */     
/*     */     try {
/*  69 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/*  71 */       Connection connection = this.plugin.getMySQLManager().newConnection();
/*     */       
/*  73 */       String str = "SELECT * FROM " + this.tableName + " WHERE " + (paramString.equals("*") ? "1" : ("`key`='" + paramString + "';"));
/*     */       
/*  75 */       PreparedStatement preparedStatement = connection.prepareStatement(str);
/*  76 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/*  78 */       while (resultSet.next()) {
/*  79 */         String str1 = resultSet.getString("key");
/*  80 */         Blob blob = resultSet.getBlob("value");
/*  81 */         String str2 = new String(blob.getBytes(1L, (int)blob.length()));
/*     */         
/*  83 */         if (Base64.isBase64(str2)) {
/*  84 */           str2 = new String(Base64.decodeBase64(str2), StandardCharsets.UTF_8);
/*     */         }
/*     */         
/*  87 */         if (REGEX_PATTERN.matcher(str2).matches()) {
/*     */           try {
/*  89 */             str2 = new String(Hex.decodeHex(str2), StandardCharsets.UTF_8);
/*  90 */           } catch (DecoderException decoderException) {
/*  91 */             decoderException.printStackTrace();
/*     */           } 
/*     */         }
/*     */         
/*     */         try {
/*  96 */           JsonObject jsonObject = (JsonObject)jsonParser.parse(str2);
/*  97 */           hashMap.put(str1, jsonObject);
/*  98 */         } catch (JsonSyntaxException jsonSyntaxException) {
/*  99 */           jsonSyntaxException.printStackTrace();
/*     */         } 
/*     */       } 
/*     */       
/* 103 */       resultSet.close();
/* 104 */       connection.close();
/*     */       
/* 106 */       paramReadCallback.onSuccess(hashMap);
/* 107 */     } catch (SQLException sQLException) {
/* 108 */       paramReadCallback.onFailure(sQLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/implementations/MySQL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */