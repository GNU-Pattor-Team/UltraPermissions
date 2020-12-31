/*    */ package me.TechsCode.UltraPermissions.base.messaging;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.Base64;
/*    */ 
/*    */ public class Message
/*    */ {
/*    */   private String key;
/*    */   private JsonObject data;
/*    */   
/*    */   public Message(String paramString, JsonObject paramJsonObject) {
/* 15 */     this.key = paramString;
/* 16 */     this.data = paramJsonObject;
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 20 */     return this.key;
/*    */   }
/*    */   
/*    */   public JsonObject getData() {
/* 24 */     return this.data;
/*    */   }
/*    */   
/*    */   public String encode() {
/* 28 */     JsonObject jsonObject = new JsonObject();
/* 29 */     jsonObject.addProperty("key", this.key);
/* 30 */     jsonObject.add("data", (JsonElement)this.data);
/*    */     
/* 32 */     return Base64.encodeBase64String(jsonObject.toString().replace("'", "\\'").getBytes(StandardCharsets.UTF_8));
/*    */   }
/*    */   
/*    */   public static Message decode(String paramString) {
/* 36 */     String str1 = new String(Base64.decodeBase64(paramString), StandardCharsets.UTF_8);
/* 37 */     JsonObject jsonObject1 = (new JsonParser()).parse(str1).getAsJsonObject();
/*    */     
/* 39 */     String str2 = jsonObject1.get("key").getAsString();
/* 40 */     JsonObject jsonObject2 = jsonObject1.get("data").getAsJsonObject();
/*    */     
/* 42 */     return new Message(str2, jsonObject2);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/messaging/Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */