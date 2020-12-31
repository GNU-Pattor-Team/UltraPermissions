/*    */ package me.TechsCode.UltraPermissions.base.networking;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class NServer
/*    */ {
/*    */   private String name;
/*    */   private String ip;
/*    */   private int port;
/*    */   private List<NPlayer> players;
/*    */   
/*    */   public NServer(String paramString1, String paramString2, int paramInt, List<NPlayer> paramList) {
/* 17 */     this.name = paramString1;
/* 18 */     this.ip = paramString2;
/* 19 */     this.port = paramInt;
/* 20 */     this.players = paramList;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 24 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getIp() {
/* 28 */     return this.ip;
/*    */   }
/*    */   
/*    */   public int getPort() {
/* 32 */     return this.port;
/*    */   }
/*    */   
/*    */   public List<NPlayer> getPlayers() {
/* 36 */     return this.players;
/*    */   }
/*    */   
/*    */   public JsonObject toJsonObject() {
/* 40 */     JsonObject jsonObject = new JsonObject();
/* 41 */     jsonObject.addProperty("name", this.name);
/* 42 */     jsonObject.addProperty("ip", this.ip);
/* 43 */     jsonObject.addProperty("port", Integer.valueOf(this.port));
/*    */     
/* 45 */     JsonArray jsonArray = new JsonArray();
/* 46 */     this.players.forEach(paramNPlayer -> paramJsonArray.add((JsonElement)paramNPlayer.toJsonObject()));
/* 47 */     jsonObject.add("players", (JsonElement)jsonArray);
/*    */     
/* 49 */     return jsonObject;
/*    */   }
/*    */   
/*    */   public static NServer fromJsonObject(JsonObject paramJsonObject) {
/* 53 */     String str1 = paramJsonObject.get("name").getAsString();
/* 54 */     String str2 = paramJsonObject.get("ip").getAsString();
/* 55 */     int i = paramJsonObject.get("port").getAsInt();
/*    */     
/* 57 */     NServer nServer = new NServer(str1, str2, i, new ArrayList<>());
/*    */     
/* 59 */     paramJsonObject.get("players").getAsJsonArray().forEach(paramJsonElement -> paramNServer.players.add(NPlayer.fromJsonObject((JsonObject)paramJsonElement, paramNServer)));
/*    */ 
/*    */ 
/*    */     
/* 63 */     return nServer;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/networking/NServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */