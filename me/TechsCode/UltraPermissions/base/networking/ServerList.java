/*    */ package me.TechsCode.UltraPermissions.base.networking;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ServerList
/*    */   extends ArrayList<NServer> {
/*    */   public ServerList() {}
/*    */   
/*    */   public ServerList(JsonArray paramJsonArray) {
/* 13 */     paramJsonArray.forEach(paramJsonElement -> add(NServer.fromJsonObject((JsonObject)paramJsonElement)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonArray toJsonArray() {
/* 19 */     JsonArray jsonArray = new JsonArray();
/* 20 */     for (NServer nServer : this) {
/* 21 */       jsonArray.add((JsonElement)nServer.toJsonObject());
/*    */     }
/*    */     
/* 24 */     return jsonArray;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/networking/ServerList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */