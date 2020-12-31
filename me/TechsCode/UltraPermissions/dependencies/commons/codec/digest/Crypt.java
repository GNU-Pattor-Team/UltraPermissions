/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.digest;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.Charsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Crypt
/*     */ {
/*     */   public static String crypt(byte[] paramArrayOfbyte) {
/*  54 */     return crypt(paramArrayOfbyte, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String crypt(byte[] paramArrayOfbyte, String paramString) {
/*  76 */     if (paramString == null)
/*  77 */       return Sha2Crypt.sha512Crypt(paramArrayOfbyte); 
/*  78 */     if (paramString.startsWith("$6$"))
/*  79 */       return Sha2Crypt.sha512Crypt(paramArrayOfbyte, paramString); 
/*  80 */     if (paramString.startsWith("$5$"))
/*  81 */       return Sha2Crypt.sha256Crypt(paramArrayOfbyte, paramString); 
/*  82 */     if (paramString.startsWith("$1$")) {
/*  83 */       return Md5Crypt.md5Crypt(paramArrayOfbyte, paramString);
/*     */     }
/*  85 */     return UnixCrypt.crypt(paramArrayOfbyte, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String crypt(String paramString) {
/* 107 */     return crypt(paramString, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String crypt(String paramString1, String paramString2) {
/* 168 */     return crypt(paramString1.getBytes(Charsets.UTF_8), paramString2);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/digest/Crypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */