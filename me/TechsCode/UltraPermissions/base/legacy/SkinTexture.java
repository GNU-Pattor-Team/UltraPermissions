/*     */ package me.TechsCode.UltraPermissions.base.legacy;
/*     */ 
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.properties.Property;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.UUID;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.utils.PlayerUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.Base64;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.IOUtils;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class SkinTexture {
/*     */   private String url;
/*     */   
/*     */   public static SkinTexture fromPlayer(Player paramPlayer) {
/*  21 */     GameProfile gameProfile = PlayerUtils.getGameProfile(paramPlayer);
/*     */     
/*     */     try {
/*  24 */       Property property = gameProfile.getProperties().get("textures").iterator().next();
/*  25 */       String str1 = property.getValue();
/*  26 */       String str2 = base64ToUrl(str1);
/*     */       
/*  28 */       if (str2 == null || str2.equals("null")) return null;
/*     */       
/*  30 */       return new SkinTexture(str2, System.currentTimeMillis());
/*  31 */     } catch (NoSuchElementException noSuchElementException) {
/*  32 */       return null;
/*     */     } 
/*     */   }
/*     */   private long createdAt;
/*     */   public static SkinTexture fromMojangAPI(String paramString) {
/*  37 */     String str1 = "https://api.mojang.com/users/profiles/minecraft/" + paramString;
/*  38 */     String str2 = getResponse(str1);
/*     */ 
/*     */     
/*     */     try {
/*  42 */       String str3 = (new JsonParser()).parse(str2).getAsJsonObject().get("id").getAsString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  49 */       String str4 = (new StringBuffer(str3)).insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString();
/*     */       
/*  51 */       return fromMojangAPI(UUID.fromString(str4));
/*  52 */     } catch (Exception exception) {
/*  53 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static SkinTexture fromMojangAPI(UUID paramUUID) {
/*  58 */     String str1 = "https://sessionserver.mojang.com/session/minecraft/profile/" + paramUUID.toString().replace("-", "") + "?unsigned=false";
/*  59 */     String str2 = getResponse(str1);
/*     */     try {
/*  61 */       JsonObject jsonObject = (new JsonParser()).parse(str2).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();
/*  62 */       String str = jsonObject.get("value").getAsString();
/*     */       
/*  64 */       return new SkinTexture(base64ToUrl(str), System.currentTimeMillis());
/*  65 */     } catch (Exception exception) {
/*  66 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String getResponse(String paramString) {
/*     */     try {
/*  72 */       URL uRL = new URL(paramString);
/*  73 */       return IOUtils.toString(uRL.openStream(), Charset.forName("UTF-8"));
/*  74 */     } catch (IOException iOException) {
/*  75 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String base64ToUrl(String paramString) {
/*     */     try {
/*  81 */       if (!paramString.contains("{")) {
/*  82 */         paramString = new String(Base64.decodeBase64(paramString.getBytes()));
/*     */       }
/*     */       
/*  85 */       JsonObject jsonObject1 = (JsonObject)(new JsonParser()).parse(paramString.trim());
/*  86 */       JsonObject jsonObject2 = jsonObject1.getAsJsonObject("textures").getAsJsonObject("SKIN");
/*     */       
/*  88 */       if (jsonObject2 == null) return null;
/*     */       
/*  90 */       return jsonObject2.get("url").getAsString();
/*     */     }
/*  92 */     catch (Exception exception) {
/*  93 */       System.out.println("Could not retrieve Url from Base64");
/*  94 */       System.out.println(paramString);
/*  95 */       System.out.println("Trace:");
/*  96 */       exception.printStackTrace();
/*     */       
/*  98 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SkinTexture(String paramString, long paramLong) {
/* 106 */     this.url = paramString;
/* 107 */     this.createdAt = paramLong;
/*     */   }
/*     */   
/*     */   public SkinTexture(String paramString) {
/* 111 */     this.url = paramString.split(":split:")[0];
/* 112 */     this.createdAt = Long.valueOf(paramString.split(":split:")[1]).longValue();
/*     */   }
/*     */   
/*     */   public String getUrl() {
/* 116 */     return this.url;
/*     */   }
/*     */   
/*     */   public long getCreatedAt() {
/* 120 */     return this.createdAt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     return this.url + ":split:" + this.createdAt;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/SkinTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */