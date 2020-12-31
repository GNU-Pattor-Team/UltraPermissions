/*    */ package me.TechsCode.UltraPermissions.base.networking;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ public class NPlayer
/*    */ {
/*    */   private UUID uuid;
/*    */   private String name;
/*    */   private NServer server;
/*    */   
/*    */   public NPlayer(UUID paramUUID, String paramString, NServer paramNServer) {
/* 14 */     this.uuid = paramUUID;
/* 15 */     this.name = paramString;
/* 16 */     this.server = paramNServer;
/*    */   }
/*    */   
/*    */   public UUID getUuid() {
/* 20 */     return this.uuid;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 24 */     return this.name;
/*    */   }
/*    */   
/*    */   public NServer getServer() {
/* 28 */     return this.server;
/*    */   }
/*    */   
/*    */   public JsonObject toJsonObject() {
/* 32 */     JsonObject jsonObject = new JsonObject();
/* 33 */     jsonObject.addProperty("uuid", this.uuid.toString());
/* 34 */     jsonObject.addProperty("name", this.name);
/* 35 */     return jsonObject;
/*    */   }
/*    */   
/*    */   public static NPlayer fromJsonObject(JsonObject paramJsonObject, NServer paramNServer) {
/* 39 */     UUID uUID = UUID.fromString(paramJsonObject.get("uuid").getAsString());
/* 40 */     String str = paramJsonObject.get("name").getAsString();
/*    */     
/* 42 */     return new NPlayer(uUID, str, paramNServer);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/networking/NPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */