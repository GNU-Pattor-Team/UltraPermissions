/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RandomStringUtils
/*     */ {
/*  46 */   private static final Random RANDOM = new Random();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String random(int paramInt) {
/*  72 */     return random(paramInt, false, false);
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
/*     */   public static String randomAscii(int paramInt) {
/*  86 */     return random(paramInt, 32, 127, false, false);
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
/*     */   public static String randomAlphabetic(int paramInt) {
/* 100 */     return random(paramInt, true, false);
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
/*     */   public static String randomAlphanumeric(int paramInt) {
/* 114 */     return random(paramInt, true, true);
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
/*     */   public static String randomNumeric(int paramInt) {
/* 128 */     return random(paramInt, false, true);
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
/*     */   public static String random(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 146 */     return random(paramInt, 0, 0, paramBoolean1, paramBoolean2);
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
/*     */   public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
/* 166 */     return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, null, RANDOM);
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
/*     */   public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfchar) {
/* 190 */     return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramArrayOfchar, RANDOM);
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
/*     */   public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfchar, Random paramRandom) {
/* 228 */     if (paramInt1 == 0)
/* 229 */       return ""; 
/* 230 */     if (paramInt1 < 0) {
/* 231 */       throw new IllegalArgumentException("Requested random string length " + paramInt1 + " is less than 0.");
/*     */     }
/* 233 */     if (paramInt2 == 0 && paramInt3 == 0) {
/* 234 */       paramInt3 = 123;
/* 235 */       paramInt2 = 32;
/* 236 */       if (!paramBoolean1 && !paramBoolean2) {
/* 237 */         paramInt2 = 0;
/* 238 */         paramInt3 = Integer.MAX_VALUE;
/*     */       } 
/*     */     } 
/*     */     
/* 242 */     char[] arrayOfChar = new char[paramInt1];
/* 243 */     int i = paramInt3 - paramInt2;
/*     */     
/* 245 */     while (paramInt1-- != 0) {
/*     */       char c;
/* 247 */       if (paramArrayOfchar == null) {
/* 248 */         c = (char)(paramRandom.nextInt(i) + paramInt2);
/*     */       } else {
/* 250 */         c = paramArrayOfchar[paramRandom.nextInt(i) + paramInt2];
/*     */       } 
/* 252 */       if ((paramBoolean1 && Character.isLetter(c)) || (paramBoolean2 && Character.isDigit(c)) || (!paramBoolean1 && !paramBoolean2)) {
/*     */ 
/*     */ 
/*     */         
/* 256 */         if (c >= '?' && c <= '?') {
/* 257 */           if (paramInt1 == 0) {
/* 258 */             paramInt1++;
/*     */             continue;
/*     */           } 
/* 261 */           arrayOfChar[paramInt1] = c;
/* 262 */           paramInt1--;
/* 263 */           arrayOfChar[paramInt1] = (char)(55296 + paramRandom.nextInt(128)); continue;
/*     */         } 
/* 265 */         if (c >= '?' && c <= '?') {
/* 266 */           if (paramInt1 == 0) {
/* 267 */             paramInt1++;
/*     */             continue;
/*     */           } 
/* 270 */           arrayOfChar[paramInt1] = (char)(56320 + paramRandom.nextInt(128));
/* 271 */           paramInt1--;
/* 272 */           arrayOfChar[paramInt1] = c; continue;
/*     */         } 
/* 274 */         if (c >= '?' && c <= '?') {
/*     */           
/* 276 */           paramInt1++; continue;
/*     */         } 
/* 278 */         arrayOfChar[paramInt1] = c;
/*     */         continue;
/*     */       } 
/* 281 */       paramInt1++;
/*     */     } 
/*     */     
/* 284 */     return new String(arrayOfChar);
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
/*     */   public static String random(int paramInt, String paramString) {
/* 301 */     if (paramString == null) {
/* 302 */       return random(paramInt, 0, 0, false, false, null, RANDOM);
/*     */     }
/* 304 */     return random(paramInt, paramString.toCharArray());
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
/*     */   public static String random(int paramInt, char[] paramArrayOfchar) {
/* 320 */     if (paramArrayOfchar == null) {
/* 321 */       return random(paramInt, 0, 0, false, false, null, RANDOM);
/*     */     }
/* 323 */     return random(paramInt, 0, paramArrayOfchar.length, false, false, paramArrayOfchar, RANDOM);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/RandomStringUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */