/*    */ package me.TechsCode.UltraPermissions.base.spigot;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ import java.util.Optional;
/*    */ 
/*    */ 
/*    */ public class SpigotPurchaseInfo
/*    */ {
/* 14 */   private static String USER_ID = "9182341";
/* 15 */   private static String USERNAME = null;
/*    */   
/*    */   public static Optional<String> getUserId() {
/* 18 */     return USER_ID.contains("__USER__") ? Optional.<String>empty() : Optional.<String>of(USER_ID);
/*    */   }
/*    */   
/*    */   public static Optional<String> getUsername() {
/* 22 */     if (USERNAME != null) return Optional.of(USERNAME);
/*    */     
/* 24 */     Optional<String> optional = getUserId();
/* 25 */     if (optional.isPresent()) {
/* 26 */       USERNAME = fetchUsername(optional.get());
/*    */       
/* 28 */       return Optional.of(USERNAME);
/*    */     } 
/* 30 */     return Optional.empty();
/*    */   }
/*    */ 
/*    */   
/*    */   private static String fetchUsername(String paramString) {
/*    */     try {
/* 36 */       URLConnection uRLConnection = (new URL("https://api.spigotmc.org/simple/0.1/index.php?action=getAuthor&id=" + paramString)).openConnection();
/*    */       
/* 38 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()));
/*    */       
/* 40 */       StringBuilder stringBuilder = new StringBuilder();
/*    */       
/*    */       String str;
/* 43 */       for (; (str = bufferedReader.readLine()) != null; stringBuilder.append(str));
/*    */       
/* 45 */       bufferedReader.close();
/*    */       
/* 47 */       JsonParser jsonParser = new JsonParser();
/* 48 */       JsonObject jsonObject = (JsonObject)jsonParser.parse(stringBuilder.toString());
/*    */       
/* 50 */       if (!jsonObject.has("username")) {
/* 51 */         return "Unknown";
/*    */       }
/*    */       
/* 54 */       return jsonObject.get("username").getAsString();
/* 55 */     } catch (Exception exception) {
/* 56 */       return "Unknown";
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/spigot/SpigotPurchaseInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */