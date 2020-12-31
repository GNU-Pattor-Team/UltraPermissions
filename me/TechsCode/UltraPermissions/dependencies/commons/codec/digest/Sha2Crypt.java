/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.digest;
/*     */ 
/*     */ import java.security.MessageDigest;
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
/*     */ public class Sha2Crypt
/*     */ {
/*     */   private static final int ROUNDS_DEFAULT = 5000;
/*     */   private static final int ROUNDS_MAX = 999999999;
/*     */   private static final int ROUNDS_MIN = 1000;
/*     */   private static final String ROUNDS_PREFIX = "rounds=";
/*     */   private static final int SHA256_BLOCKSIZE = 32;
/*     */   static final String SHA256_PREFIX = "$5$";
/*     */   private static final int SHA512_BLOCKSIZE = 64;
/*     */   static final String SHA512_PREFIX = "$6$";
/*  72 */   private static final Pattern SALT_PATTERN = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");
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
/*     */   public static String sha256Crypt(byte[] paramArrayOfbyte) {
/*  91 */     return sha256Crypt(paramArrayOfbyte, null);
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
/*     */   public static String sha256Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 112 */     if (paramString == null) {
/* 113 */       paramString = "$5$" + B64.getRandomSalt(8);
/*     */     }
/* 115 */     return sha2Crypt(paramArrayOfbyte, paramString, "$5$", 32, "SHA-256");
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
/*     */   public static String sha256Crypt(byte[] paramArrayOfbyte, String paramString, Random paramRandom) {
/* 137 */     if (paramString == null) {
/* 138 */       paramString = "$5$" + B64.getRandomSalt(8, paramRandom);
/*     */     }
/* 140 */     return sha2Crypt(paramArrayOfbyte, paramString, "$5$", 32, "SHA-256");
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
/*     */   private static String sha2Crypt(byte[] paramArrayOfbyte, String paramString1, String paramString2, int paramInt, String paramString3) {
/* 171 */     int i = paramArrayOfbyte.length;
/*     */ 
/*     */     
/* 174 */     int j = 5000;
/* 175 */     boolean bool = false;
/* 176 */     if (paramString1 == null) {
/* 177 */       throw new IllegalArgumentException("Salt must not be null");
/*     */     }
/*     */     
/* 180 */     Matcher matcher = SALT_PATTERN.matcher(paramString1);
/* 181 */     if (!matcher.find()) {
/* 182 */       throw new IllegalArgumentException("Invalid salt value: " + paramString1);
/*     */     }
/* 184 */     if (matcher.group(3) != null) {
/* 185 */       j = Integer.parseInt(matcher.group(3));
/* 186 */       j = Math.max(1000, Math.min(999999999, j));
/* 187 */       bool = true;
/*     */     } 
/* 189 */     String str = matcher.group(4);
/* 190 */     byte[] arrayOfByte1 = str.getBytes(Charsets.UTF_8);
/* 191 */     int k = arrayOfByte1.length;
/*     */ 
/*     */ 
/*     */     
/* 195 */     MessageDigest messageDigest1 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     messageDigest1.update(paramArrayOfbyte);
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
/* 216 */     messageDigest1.update(arrayOfByte1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     MessageDigest messageDigest2 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 229 */     messageDigest2.update(paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 235 */     messageDigest2.update(arrayOfByte1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     messageDigest2.update(paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     byte[] arrayOfByte2 = messageDigest2.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 257 */     int m = paramArrayOfbyte.length;
/* 258 */     while (m > paramInt) {
/* 259 */       messageDigest1.update(arrayOfByte2, 0, paramInt);
/* 260 */       m -= paramInt;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 265 */     messageDigest1.update(arrayOfByte2, 0, m);
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
/* 281 */     m = paramArrayOfbyte.length;
/* 282 */     while (m > 0) {
/* 283 */       if ((m & 0x1) != 0) {
/* 284 */         messageDigest1.update(arrayOfByte2, 0, paramInt);
/*     */       } else {
/* 286 */         messageDigest1.update(paramArrayOfbyte);
/*     */       } 
/* 288 */       m >>= 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     arrayOfByte2 = messageDigest1.digest();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     messageDigest2 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 310 */     for (byte b1 = 1; b1 <= i; b1++) {
/* 311 */       messageDigest2.update(paramArrayOfbyte);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     byte[] arrayOfByte3 = messageDigest2.digest();
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
/* 330 */     byte[] arrayOfByte4 = new byte[i];
/* 331 */     int n = 0;
/* 332 */     while (n < i - paramInt) {
/* 333 */       System.arraycopy(arrayOfByte3, 0, arrayOfByte4, n, paramInt);
/* 334 */       n += paramInt;
/*     */     } 
/* 336 */     System.arraycopy(arrayOfByte3, 0, arrayOfByte4, n, i - n);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     messageDigest2 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 351 */     for (byte b2 = 1; b2 <= 16 + (arrayOfByte2[0] & 0xFF); b2++) {
/* 352 */       messageDigest2.update(arrayOfByte1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 359 */     arrayOfByte3 = messageDigest2.digest();
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
/* 372 */     byte[] arrayOfByte5 = new byte[k];
/* 373 */     n = 0;
/* 374 */     while (n < k - paramInt) {
/* 375 */       System.arraycopy(arrayOfByte3, 0, arrayOfByte5, n, paramInt);
/* 376 */       n += paramInt;
/*     */     } 
/* 378 */     System.arraycopy(arrayOfByte3, 0, arrayOfByte5, n, k - n);
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
/* 391 */     for (byte b3 = 0; b3 <= j - 1; b3++) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 396 */       messageDigest1 = DigestUtils.getDigest(paramString3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 403 */       if ((b3 & 0x1) != 0) {
/* 404 */         messageDigest1.update(arrayOfByte4, 0, i);
/*     */       } else {
/* 406 */         messageDigest1.update(arrayOfByte2, 0, paramInt);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 413 */       if (b3 % 3 != 0) {
/* 414 */         messageDigest1.update(arrayOfByte5, 0, k);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 421 */       if (b3 % 7 != 0) {
/* 422 */         messageDigest1.update(arrayOfByte4, 0, i);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 430 */       if ((b3 & 0x1) != 0) {
/* 431 */         messageDigest1.update(arrayOfByte2, 0, paramInt);
/*     */       } else {
/* 433 */         messageDigest1.update(arrayOfByte4, 0, i);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 440 */       arrayOfByte2 = messageDigest1.digest();
/*     */     } 
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
/* 458 */     StringBuilder stringBuilder = new StringBuilder(paramString2);
/* 459 */     if (bool) {
/* 460 */       stringBuilder.append("rounds=");
/* 461 */       stringBuilder.append(j);
/* 462 */       stringBuilder.append("$");
/*     */     } 
/* 464 */     stringBuilder.append(str);
/* 465 */     stringBuilder.append("$");
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
/* 491 */     if (paramInt == 32) {
/* 492 */       B64.b64from24bit(arrayOfByte2[0], arrayOfByte2[10], arrayOfByte2[20], 4, stringBuilder);
/* 493 */       B64.b64from24bit(arrayOfByte2[21], arrayOfByte2[1], arrayOfByte2[11], 4, stringBuilder);
/* 494 */       B64.b64from24bit(arrayOfByte2[12], arrayOfByte2[22], arrayOfByte2[2], 4, stringBuilder);
/* 495 */       B64.b64from24bit(arrayOfByte2[3], arrayOfByte2[13], arrayOfByte2[23], 4, stringBuilder);
/* 496 */       B64.b64from24bit(arrayOfByte2[24], arrayOfByte2[4], arrayOfByte2[14], 4, stringBuilder);
/* 497 */       B64.b64from24bit(arrayOfByte2[15], arrayOfByte2[25], arrayOfByte2[5], 4, stringBuilder);
/* 498 */       B64.b64from24bit(arrayOfByte2[6], arrayOfByte2[16], arrayOfByte2[26], 4, stringBuilder);
/* 499 */       B64.b64from24bit(arrayOfByte2[27], arrayOfByte2[7], arrayOfByte2[17], 4, stringBuilder);
/* 500 */       B64.b64from24bit(arrayOfByte2[18], arrayOfByte2[28], arrayOfByte2[8], 4, stringBuilder);
/* 501 */       B64.b64from24bit(arrayOfByte2[9], arrayOfByte2[19], arrayOfByte2[29], 4, stringBuilder);
/* 502 */       B64.b64from24bit((byte)0, arrayOfByte2[31], arrayOfByte2[30], 3, stringBuilder);
/*     */     } else {
/* 504 */       B64.b64from24bit(arrayOfByte2[0], arrayOfByte2[21], arrayOfByte2[42], 4, stringBuilder);
/* 505 */       B64.b64from24bit(arrayOfByte2[22], arrayOfByte2[43], arrayOfByte2[1], 4, stringBuilder);
/* 506 */       B64.b64from24bit(arrayOfByte2[44], arrayOfByte2[2], arrayOfByte2[23], 4, stringBuilder);
/* 507 */       B64.b64from24bit(arrayOfByte2[3], arrayOfByte2[24], arrayOfByte2[45], 4, stringBuilder);
/* 508 */       B64.b64from24bit(arrayOfByte2[25], arrayOfByte2[46], arrayOfByte2[4], 4, stringBuilder);
/* 509 */       B64.b64from24bit(arrayOfByte2[47], arrayOfByte2[5], arrayOfByte2[26], 4, stringBuilder);
/* 510 */       B64.b64from24bit(arrayOfByte2[6], arrayOfByte2[27], arrayOfByte2[48], 4, stringBuilder);
/* 511 */       B64.b64from24bit(arrayOfByte2[28], arrayOfByte2[49], arrayOfByte2[7], 4, stringBuilder);
/* 512 */       B64.b64from24bit(arrayOfByte2[50], arrayOfByte2[8], arrayOfByte2[29], 4, stringBuilder);
/* 513 */       B64.b64from24bit(arrayOfByte2[9], arrayOfByte2[30], arrayOfByte2[51], 4, stringBuilder);
/* 514 */       B64.b64from24bit(arrayOfByte2[31], arrayOfByte2[52], arrayOfByte2[10], 4, stringBuilder);
/* 515 */       B64.b64from24bit(arrayOfByte2[53], arrayOfByte2[11], arrayOfByte2[32], 4, stringBuilder);
/* 516 */       B64.b64from24bit(arrayOfByte2[12], arrayOfByte2[33], arrayOfByte2[54], 4, stringBuilder);
/* 517 */       B64.b64from24bit(arrayOfByte2[34], arrayOfByte2[55], arrayOfByte2[13], 4, stringBuilder);
/* 518 */       B64.b64from24bit(arrayOfByte2[56], arrayOfByte2[14], arrayOfByte2[35], 4, stringBuilder);
/* 519 */       B64.b64from24bit(arrayOfByte2[15], arrayOfByte2[36], arrayOfByte2[57], 4, stringBuilder);
/* 520 */       B64.b64from24bit(arrayOfByte2[37], arrayOfByte2[58], arrayOfByte2[16], 4, stringBuilder);
/* 521 */       B64.b64from24bit(arrayOfByte2[59], arrayOfByte2[17], arrayOfByte2[38], 4, stringBuilder);
/* 522 */       B64.b64from24bit(arrayOfByte2[18], arrayOfByte2[39], arrayOfByte2[60], 4, stringBuilder);
/* 523 */       B64.b64from24bit(arrayOfByte2[40], arrayOfByte2[61], arrayOfByte2[19], 4, stringBuilder);
/* 524 */       B64.b64from24bit(arrayOfByte2[62], arrayOfByte2[20], arrayOfByte2[41], 4, stringBuilder);
/* 525 */       B64.b64from24bit((byte)0, (byte)0, arrayOfByte2[63], 2, stringBuilder);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 533 */     Arrays.fill(arrayOfByte3, (byte)0);
/* 534 */     Arrays.fill(arrayOfByte4, (byte)0);
/* 535 */     Arrays.fill(arrayOfByte5, (byte)0);
/* 536 */     messageDigest1.reset();
/* 537 */     messageDigest2.reset();
/* 538 */     Arrays.fill(paramArrayOfbyte, (byte)0);
/* 539 */     Arrays.fill(arrayOfByte1, (byte)0);
/*     */     
/* 541 */     return stringBuilder.toString();
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
/*     */   public static String sha512Crypt(byte[] paramArrayOfbyte) {
/* 561 */     return sha512Crypt(paramArrayOfbyte, null);
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
/*     */   public static String sha512Crypt(byte[] paramArrayOfbyte, String paramString) {
/* 583 */     if (paramString == null) {
/* 584 */       paramString = "$6$" + B64.getRandomSalt(8);
/*     */     }
/* 586 */     return sha2Crypt(paramArrayOfbyte, paramString, "$6$", 64, "SHA-512");
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
/*     */   public static String sha512Crypt(byte[] paramArrayOfbyte, String paramString, Random paramRandom) {
/* 612 */     if (paramString == null) {
/* 613 */       paramString = "$6$" + B64.getRandomSalt(8, paramRandom);
/*     */     }
/* 615 */     return sha2Crypt(paramArrayOfbyte, paramString, "$6$", 64, "SHA-512");
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/digest/Sha2Crypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */