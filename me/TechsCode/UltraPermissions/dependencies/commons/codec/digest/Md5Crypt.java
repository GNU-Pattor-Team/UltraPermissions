/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.digest;
/*     */ 
/*     */ import java.security.MessageDigest;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class Md5Crypt
/*     */ {
/*     */   static final String APR1_PREFIX = "$apr1$";
/*     */   private static final int BLOCKSIZE = 16;
/*     */   static final String MD5_PREFIX = "$1$";
/*     */   private static final int ROUNDS = 1000;
/*     */   
/*     */   public static String apr1Crypt(byte[] paramArrayOfbyte) {
/*  78 */     return apr1Crypt(paramArrayOfbyte, "$apr1$" + B64.getRandomSalt(8));
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
/*     */   public static String apr1Crypt(byte[] paramArrayOfbyte, Random paramRandom) {
/*  95 */     return apr1Crypt(paramArrayOfbyte, "$apr1$" + B64.getRandomSalt(8, paramRandom));
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
/*     */   public static String apr1Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 118 */     if (paramString != null && !paramString.startsWith("$apr1$")) {
/* 119 */       paramString = "$apr1$" + paramString;
/*     */     }
/* 121 */     return md5Crypt(paramArrayOfbyte, paramString, "$apr1$");
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
/*     */   public static String apr1Crypt(String paramString) {
/* 139 */     return apr1Crypt(paramString.getBytes(Charsets.UTF_8));
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
/*     */   public static String apr1Crypt(String paramString1, String paramString2) {
/* 161 */     return apr1Crypt(paramString1.getBytes(Charsets.UTF_8), paramString2);
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte) {
/* 181 */     return md5Crypt(paramArrayOfbyte, "$1$" + B64.getRandomSalt(8));
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, Random paramRandom) {
/* 203 */     return md5Crypt(paramArrayOfbyte, "$1$" + B64.getRandomSalt(8, paramRandom));
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 226 */     return md5Crypt(paramArrayOfbyte, paramString, "$1$");
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, String paramString1, String paramString2) {
/* 251 */     return md5Crypt(paramArrayOfbyte, paramString1, paramString2, new SecureRandom());
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
/*     */   public static String md5Crypt(byte[] paramArrayOfbyte, String paramString1, String paramString2, Random paramRandom) {
/*     */     String str;
/* 278 */     int i = paramArrayOfbyte.length;
/*     */ 
/*     */ 
/*     */     
/* 282 */     if (paramString1 == null) {
/* 283 */       str = B64.getRandomSalt(8, paramRandom);
/*     */     } else {
/* 285 */       Pattern pattern = Pattern.compile("^" + paramString2.replace("$", "\\$") + "([\\.\\/a-zA-Z0-9]{1,8}).*");
/* 286 */       Matcher matcher = pattern.matcher(paramString1);
/* 287 */       if (!matcher.find()) {
/* 288 */         throw new IllegalArgumentException("Invalid salt value: " + paramString1);
/*     */       }
/* 290 */       str = matcher.group(1);
/*     */     } 
/* 292 */     byte[] arrayOfByte1 = str.getBytes(Charsets.UTF_8);
/*     */     
/* 294 */     MessageDigest messageDigest1 = DigestUtils.getMd5Digest();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     messageDigest1.update(paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 304 */     messageDigest1.update(paramString2.getBytes(Charsets.UTF_8));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     messageDigest1.update(arrayOfByte1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     MessageDigest messageDigest2 = DigestUtils.getMd5Digest();
/* 315 */     messageDigest2.update(paramArrayOfbyte);
/* 316 */     messageDigest2.update(arrayOfByte1);
/* 317 */     messageDigest2.update(paramArrayOfbyte);
/* 318 */     byte[] arrayOfByte2 = messageDigest2.digest();
/* 319 */     int j = i;
/* 320 */     while (j > 0) {
/* 321 */       messageDigest1.update(arrayOfByte2, 0, (j > 16) ? 16 : j);
/* 322 */       j -= 16;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 328 */     Arrays.fill(arrayOfByte2, (byte)0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     j = i;
/* 334 */     boolean bool = false;
/* 335 */     while (j > 0) {
/* 336 */       if ((j & 0x1) == 1) {
/* 337 */         messageDigest1.update(arrayOfByte2[0]);
/*     */       } else {
/* 339 */         messageDigest1.update(paramArrayOfbyte[0]);
/*     */       } 
/* 341 */       j >>= 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 347 */     StringBuilder stringBuilder = new StringBuilder(paramString2 + str + "$");
/* 348 */     arrayOfByte2 = messageDigest1.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 354 */     for (byte b = 0; b < 'Ϩ'; b++) {
/* 355 */       messageDigest2 = DigestUtils.getMd5Digest();
/* 356 */       if ((b & 0x1) != 0) {
/* 357 */         messageDigest2.update(paramArrayOfbyte);
/*     */       } else {
/* 359 */         messageDigest2.update(arrayOfByte2, 0, 16);
/*     */       } 
/*     */       
/* 362 */       if (b % 3 != 0) {
/* 363 */         messageDigest2.update(arrayOfByte1);
/*     */       }
/*     */       
/* 366 */       if (b % 7 != 0) {
/* 367 */         messageDigest2.update(paramArrayOfbyte);
/*     */       }
/*     */       
/* 370 */       if ((b & 0x1) != 0) {
/* 371 */         messageDigest2.update(arrayOfByte2, 0, 16);
/*     */       } else {
/* 373 */         messageDigest2.update(paramArrayOfbyte);
/*     */       } 
/* 375 */       arrayOfByte2 = messageDigest2.digest();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 381 */     B64.b64from24bit(arrayOfByte2[0], arrayOfByte2[6], arrayOfByte2[12], 4, stringBuilder);
/* 382 */     B64.b64from24bit(arrayOfByte2[1], arrayOfByte2[7], arrayOfByte2[13], 4, stringBuilder);
/* 383 */     B64.b64from24bit(arrayOfByte2[2], arrayOfByte2[8], arrayOfByte2[14], 4, stringBuilder);
/* 384 */     B64.b64from24bit(arrayOfByte2[3], arrayOfByte2[9], arrayOfByte2[15], 4, stringBuilder);
/* 385 */     B64.b64from24bit(arrayOfByte2[4], arrayOfByte2[10], arrayOfByte2[5], 4, stringBuilder);
/* 386 */     B64.b64from24bit((byte)0, (byte)0, arrayOfByte2[11], 2, stringBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 392 */     messageDigest1.reset();
/* 393 */     messageDigest2.reset();
/* 394 */     Arrays.fill(paramArrayOfbyte, (byte)0);
/* 395 */     Arrays.fill(arrayOfByte1, (byte)0);
/* 396 */     Arrays.fill(arrayOfByte2, (byte)0);
/*     */     
/* 398 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/digest/Md5Crypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */