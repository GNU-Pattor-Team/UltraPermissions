/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SoundexUtils
/*     */ {
/*     */   static String clean(String paramString) {
/*  42 */     if (paramString == null || paramString.length() == 0) {
/*  43 */       return paramString;
/*     */     }
/*  45 */     int i = paramString.length();
/*  46 */     char[] arrayOfChar = new char[i];
/*  47 */     byte b1 = 0;
/*  48 */     for (byte b2 = 0; b2 < i; b2++) {
/*  49 */       if (Character.isLetter(paramString.charAt(b2))) {
/*  50 */         arrayOfChar[b1++] = paramString.charAt(b2);
/*     */       }
/*     */     } 
/*  53 */     if (b1 == i) {
/*  54 */       return paramString.toUpperCase(Locale.ENGLISH);
/*     */     }
/*  56 */     return (new String(arrayOfChar, 0, b1)).toUpperCase(Locale.ENGLISH);
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
/*     */   static int difference(StringEncoder paramStringEncoder, String paramString1, String paramString2) {
/*  86 */     return differenceEncoded(paramStringEncoder.encode(paramString1), paramStringEncoder.encode(paramString2));
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
/*     */   static int differenceEncoded(String paramString1, String paramString2) {
/* 111 */     if (paramString1 == null || paramString2 == null) {
/* 112 */       return 0;
/*     */     }
/* 114 */     int i = Math.min(paramString1.length(), paramString2.length());
/* 115 */     byte b1 = 0;
/* 116 */     for (byte b2 = 0; b2 < i; b2++) {
/* 117 */       if (paramString1.charAt(b2) == paramString2.charAt(b2)) {
/* 118 */         b1++;
/*     */       }
/*     */     } 
/* 121 */     return b1;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/SoundexUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */