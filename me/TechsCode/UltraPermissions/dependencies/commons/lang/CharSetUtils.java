/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.text.StrBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharSetUtils
/*     */ {
/*     */   public static CharSet evaluateSet(String[] paramArrayOfString) {
/*  73 */     if (paramArrayOfString == null) {
/*  74 */       return null;
/*     */     }
/*  76 */     return new CharSet(paramArrayOfString);
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
/*     */   public static String squeeze(String paramString1, String paramString2) {
/* 100 */     if (StringUtils.isEmpty(paramString1) || StringUtils.isEmpty(paramString2)) {
/* 101 */       return paramString1;
/*     */     }
/* 103 */     String[] arrayOfString = new String[1];
/* 104 */     arrayOfString[0] = paramString2;
/* 105 */     return squeeze(paramString1, arrayOfString);
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
/*     */   public static String squeeze(String paramString, String[] paramArrayOfString) {
/* 123 */     if (StringUtils.isEmpty(paramString) || ArrayUtils.isEmpty((Object[])paramArrayOfString)) {
/* 124 */       return paramString;
/*     */     }
/* 126 */     CharSet charSet = CharSet.getInstance(paramArrayOfString);
/* 127 */     StrBuilder strBuilder = new StrBuilder(paramString.length());
/* 128 */     char[] arrayOfChar = paramString.toCharArray();
/* 129 */     int i = arrayOfChar.length;
/* 130 */     char c1 = ' ';
/* 131 */     char c2 = ' ';
/* 132 */     for (byte b = 0; b < i; b++) {
/* 133 */       c2 = arrayOfChar[b];
/* 134 */       if (!charSet.contains(c2) || 
/* 135 */         c2 != c1 || b == 0) {
/*     */ 
/*     */ 
/*     */         
/* 139 */         strBuilder.append(c2);
/* 140 */         c1 = c2;
/*     */       } 
/* 142 */     }  return strBuilder.toString();
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
/*     */   public static int count(String paramString1, String paramString2) {
/* 166 */     if (StringUtils.isEmpty(paramString1) || StringUtils.isEmpty(paramString2)) {
/* 167 */       return 0;
/*     */     }
/* 169 */     String[] arrayOfString = new String[1];
/* 170 */     arrayOfString[0] = paramString2;
/* 171 */     return count(paramString1, arrayOfString);
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
/*     */   public static int count(String paramString, String[] paramArrayOfString) {
/* 189 */     if (StringUtils.isEmpty(paramString) || ArrayUtils.isEmpty((Object[])paramArrayOfString)) {
/* 190 */       return 0;
/*     */     }
/* 192 */     CharSet charSet = CharSet.getInstance(paramArrayOfString);
/* 193 */     byte b1 = 0;
/* 194 */     char[] arrayOfChar = paramString.toCharArray();
/* 195 */     int i = arrayOfChar.length;
/* 196 */     for (byte b2 = 0; b2 < i; b2++) {
/* 197 */       if (charSet.contains(arrayOfChar[b2])) {
/* 198 */         b1++;
/*     */       }
/*     */     } 
/* 201 */     return b1;
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
/*     */   public static String keep(String paramString1, String paramString2) {
/* 226 */     if (paramString1 == null) {
/* 227 */       return null;
/*     */     }
/* 229 */     if (paramString1.length() == 0 || StringUtils.isEmpty(paramString2)) {
/* 230 */       return "";
/*     */     }
/* 232 */     String[] arrayOfString = new String[1];
/* 233 */     arrayOfString[0] = paramString2;
/* 234 */     return keep(paramString1, arrayOfString);
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
/*     */   public static String keep(String paramString, String[] paramArrayOfString) {
/* 254 */     if (paramString == null) {
/* 255 */       return null;
/*     */     }
/* 257 */     if (paramString.length() == 0 || ArrayUtils.isEmpty((Object[])paramArrayOfString)) {
/* 258 */       return "";
/*     */     }
/* 260 */     return modify(paramString, paramArrayOfString, true);
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
/*     */   public static String delete(String paramString1, String paramString2) {
/* 284 */     if (StringUtils.isEmpty(paramString1) || StringUtils.isEmpty(paramString2)) {
/* 285 */       return paramString1;
/*     */     }
/* 287 */     String[] arrayOfString = new String[1];
/* 288 */     arrayOfString[0] = paramString2;
/* 289 */     return delete(paramString1, arrayOfString);
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
/*     */   public static String delete(String paramString, String[] paramArrayOfString) {
/* 308 */     if (StringUtils.isEmpty(paramString) || ArrayUtils.isEmpty((Object[])paramArrayOfString)) {
/* 309 */       return paramString;
/*     */     }
/* 311 */     return modify(paramString, paramArrayOfString, false);
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
/*     */   private static String modify(String paramString, String[] paramArrayOfString, boolean paramBoolean) {
/* 324 */     CharSet charSet = CharSet.getInstance(paramArrayOfString);
/* 325 */     StrBuilder strBuilder = new StrBuilder(paramString.length());
/* 326 */     char[] arrayOfChar = paramString.toCharArray();
/* 327 */     int i = arrayOfChar.length;
/* 328 */     for (byte b = 0; b < i; b++) {
/* 329 */       if (charSet.contains(arrayOfChar[b]) == paramBoolean) {
/* 330 */         strBuilder.append(arrayOfChar[b]);
/*     */       }
/*     */     } 
/* 333 */     return strBuilder.toString();
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
/*     */   public static String translate(String paramString1, String paramString2, String paramString3) {
/* 371 */     if (StringUtils.isEmpty(paramString1)) {
/* 372 */       return paramString1;
/*     */     }
/* 374 */     StrBuilder strBuilder = new StrBuilder(paramString1.length());
/* 375 */     char[] arrayOfChar1 = paramString1.toCharArray();
/* 376 */     char[] arrayOfChar2 = paramString3.toCharArray();
/* 377 */     int i = arrayOfChar1.length;
/* 378 */     int j = paramString3.length() - 1;
/* 379 */     for (byte b = 0; b < i; b++) {
/* 380 */       int k = paramString2.indexOf(arrayOfChar1[b]);
/* 381 */       if (k != -1) {
/* 382 */         if (k > j) {
/* 383 */           k = j;
/*     */         }
/* 385 */         strBuilder.append(arrayOfChar2[k]);
/*     */       } else {
/* 387 */         strBuilder.append(arrayOfChar1[b]);
/*     */       } 
/*     */     } 
/* 390 */     return strBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/CharSetUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */