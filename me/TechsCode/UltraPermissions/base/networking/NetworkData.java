/*    */ package me.TechsCode.UltraPermissions.base.networking;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ 
/*    */ public class NetworkData {
/*    */   private String proxyPluginVersion;
/*    */   private ServerList serverList;
/*    */   
/*    */   public NetworkData(String paramString, ServerList paramServerList) {
/* 11 */     this.proxyPluginVersion = paramString;
/* 12 */     this.serverList = paramServerList;
/*    */   }
/*    */   
/*    */   public String getProxyPluginVersion() {
/* 16 */     return this.proxyPluginVersion;
/*    */   }
/*    */   
/*    */   public ServerList getServerList() {
/* 20 */     return this.serverList;
/*    */   }
/*    */   
/*    */   public JsonObject toJsonObject() {
/* 24 */     JsonObject jsonObject = new JsonObject();
/*    */     
/* 26 */     jsonObject.addProperty("proxyVersion", this.proxyPluginVersion);
/* 27 */     jsonObject.add("serverList", (JsonElement)this.serverList.toJsonArray());
/*    */     
/* 29 */     return jsonObject;
/*    */   }
/*    */   
/*    */   public static NetworkData fromJsonObject(JsonObject paramJsonObject) {
/* 33 */     String str = paramJsonObject.get("proxyVersion").getAsString();
/* 34 */     ServerList serverList = new ServerList(paramJsonObject.getAsJsonArray("serverList"));
/*    */     
/* 36 */     return new NetworkData(str, serverList);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/networking/NetworkData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */