/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.logging.Level;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.NBTItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VersionChecker
/*     */ {
/*     */   private static final String USER_AGENT = "nbt-api Version check";
/*     */   private static final String REQUEST_URL = "https://api.spiget.org/v2/resources/7939/versions?size=100";
/*     */   
/*     */   protected static void checkForUpdates() {
/*  26 */     URL uRL = new URL("https://api.spiget.org/v2/resources/7939/versions?size=100");
/*  27 */     HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
/*  28 */     httpURLConnection.addRequestProperty("User-Agent", "nbt-api Version check");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     InputStream inputStream = httpURLConnection.getInputStream();
/*  35 */     InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
/*     */ 
/*     */     
/*  38 */     JsonElement jsonElement = (new JsonParser()).parse(inputStreamReader);
/*  39 */     if (jsonElement.isJsonArray()) {
/*     */       
/*  41 */       JsonArray jsonArray = (JsonArray)jsonElement;
/*  42 */       JsonObject jsonObject = (JsonObject)jsonArray.get(jsonArray.size() - 1);
/*  43 */       int i = getVersionDifference(jsonObject.get("name").getAsString());
/*  44 */       if (i == -1) {
/*  45 */         MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] The NBT-API at '" + NBTItem.class
/*  46 */             .getPackage() + "' seems to be outdated!");
/*  47 */         MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] Current Version: '2.5.0' Newest Version: " + jsonObject
/*  48 */             .get("name").getAsString() + "'");
/*  49 */         MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] Please update the nbt-api or the plugin that contains the api!");
/*     */       
/*     */       }
/*  52 */       else if (i == 0) {
/*  53 */         MinecraftVersion.logger.log(Level.INFO, "[NBTAPI] The NBT-API seems to be up-to-date!");
/*  54 */       } else if (i == 1) {
/*  55 */         MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] The NBT-API at '" + NBTItem.class.getPackage() + "' seems to be a future Version, not yet released on Spigot!");
/*     */         
/*  57 */         MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] Current Version: '2.5.0' Newest Version: " + jsonObject
/*  58 */             .get("name").getAsString() + "'");
/*     */       } 
/*     */     } else {
/*     */       
/*  62 */       MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] Error when looking for Updates! Got non Json Array: '" + jsonElement
/*  63 */           .toString() + "'");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getVersionDifference(String paramString) {
/*  72 */     String str1 = "2.5.0";
/*  73 */     if (str1.equals(paramString))
/*  74 */       return 0; 
/*  75 */     String str2 = "\\.";
/*  76 */     if ((str1.split(str2)).length != 3 || (paramString.split(str2)).length != 3)
/*  77 */       return -1; 
/*  78 */     int i = Integer.parseInt(str1.split(str2)[0]);
/*  79 */     int j = Integer.parseInt(str1.split(str2)[1]);
/*  80 */     String str3 = str1.split(str2)[2];
/*  81 */     int k = Integer.parseInt(paramString.split(str2)[0]);
/*  82 */     int m = Integer.parseInt(paramString.split(str2)[1]);
/*  83 */     String str4 = paramString.split(str2)[2];
/*  84 */     if (i < k)
/*  85 */       return -1; 
/*  86 */     if (i > k)
/*  87 */       return 1; 
/*  88 */     if (j < m)
/*  89 */       return -1; 
/*  90 */     if (j > m)
/*  91 */       return 1; 
/*  92 */     int n = Integer.parseInt(str3.split("-")[0]);
/*  93 */     int i1 = Integer.parseInt(str4.split("-")[0]);
/*  94 */     if (n < i1)
/*  95 */       return -1; 
/*  96 */     if (n > i1)
/*  97 */       return 1; 
/*  98 */     if (!str4.contains("-") && str3.contains("-")) {
/*  99 */       return -1;
/*     */     }
/* 101 */     if (str4.contains("-") && str3.contains("-"))
/* 102 */       return 0; 
/* 103 */     return 1;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/VersionChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */