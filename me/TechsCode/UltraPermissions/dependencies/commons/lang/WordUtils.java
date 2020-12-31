/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WordUtils
/*     */ {
/*     */   public static String wrap(String paramString, int paramInt) {
/* 142 */     return wrap(paramString, paramInt, null, false);
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
/*     */   public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
/* 164 */     if (paramString1 == null) {
/* 165 */       return null;
/*     */     }
/* 167 */     if (paramString2 == null) {
/* 168 */       paramString2 = SystemUtils.LINE_SEPARATOR;
/*     */     }
/* 170 */     if (paramInt < 1) {
/* 171 */       paramInt = 1;
/*     */     }
/* 173 */     int i = paramString1.length();
/* 174 */     int j = 0;
/* 175 */     StringBuffer stringBuffer = new StringBuffer(i + 32);
/*     */     
/* 177 */     while (i - j > paramInt) {
/* 178 */       if (paramString1.charAt(j) == ' ') {
/* 179 */         j++;
/*     */         continue;
/*     */       } 
/* 182 */       int k = paramString1.lastIndexOf(' ', paramInt + j);
/*     */       
/* 184 */       if (k >= j) {
/*     */         
/* 186 */         stringBuffer.append(paramString1.substring(j, k));
/* 187 */         stringBuffer.append(paramString2);
/* 188 */         j = k + 1;
/*     */         
/*     */         continue;
/*     */       } 
/* 192 */       if (paramBoolean) {
/*     */         
/* 194 */         stringBuffer.append(paramString1.substring(j, paramInt + j));
/* 195 */         stringBuffer.append(paramString2);
/* 196 */         j += paramInt;
/*     */         continue;
/*     */       } 
/* 199 */       k = paramString1.indexOf(' ', paramInt + j);
/* 200 */       if (k >= 0) {
/* 201 */         stringBuffer.append(paramString1.substring(j, k));
/* 202 */         stringBuffer.append(paramString2);
/* 203 */         j = k + 1; continue;
/*     */       } 
/* 205 */       stringBuffer.append(paramString1.substring(j));
/* 206 */       j = i;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     stringBuffer.append(paramString1.substring(j));
/*     */     
/* 215 */     return stringBuffer.toString();
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
/*     */   public static String capitalize(String paramString) {
/* 243 */     return capitalize(paramString, null);
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
/*     */   public static String capitalize(String paramString, char[] paramArrayOfchar) {
/* 276 */     boolean bool1 = (paramArrayOfchar == null) ? true : paramArrayOfchar.length;
/* 277 */     if (paramString == null || paramString.length() == 0 || !bool1) {
/* 278 */       return paramString;
/*     */     }
/* 280 */     int i = paramString.length();
/* 281 */     StringBuffer stringBuffer = new StringBuffer(i);
/* 282 */     boolean bool2 = true;
/* 283 */     for (byte b = 0; b < i; b++) {
/* 284 */       char c = paramString.charAt(b);
/*     */       
/* 286 */       if (isDelimiter(c, paramArrayOfchar)) {
/* 287 */         stringBuffer.append(c);
/* 288 */         bool2 = true;
/* 289 */       } else if (bool2) {
/* 290 */         stringBuffer.append(Character.toTitleCase(c));
/* 291 */         bool2 = false;
/*     */       } else {
/* 293 */         stringBuffer.append(c);
/*     */       } 
/*     */     } 
/* 296 */     return stringBuffer.toString();
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
/*     */   public static String capitalizeFully(String paramString) {
/* 320 */     return capitalizeFully(paramString, null);
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
/*     */   public static String capitalizeFully(String paramString, char[] paramArrayOfchar) {
/* 350 */     boolean bool = (paramArrayOfchar == null) ? true : paramArrayOfchar.length;
/* 351 */     if (paramString == null || paramString.length() == 0 || !bool) {
/* 352 */       return paramString;
/*     */     }
/* 354 */     paramString = paramString.toLowerCase();
/* 355 */     return capitalize(paramString, paramArrayOfchar);
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
/*     */   public static String uncapitalize(String paramString) {
/* 377 */     return uncapitalize(paramString, null);
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
/*     */   public static String uncapitalize(String paramString, char[] paramArrayOfchar) {
/* 406 */     boolean bool1 = (paramArrayOfchar == null) ? true : paramArrayOfchar.length;
/* 407 */     if (paramString == null || paramString.length() == 0 || !bool1) {
/* 408 */       return paramString;
/*     */     }
/* 410 */     int i = paramString.length();
/* 411 */     StringBuffer stringBuffer = new StringBuffer(i);
/* 412 */     boolean bool2 = true;
/* 413 */     for (byte b = 0; b < i; b++) {
/* 414 */       char c = paramString.charAt(b);
/*     */       
/* 416 */       if (isDelimiter(c, paramArrayOfchar)) {
/* 417 */         stringBuffer.append(c);
/* 418 */         bool2 = true;
/* 419 */       } else if (bool2) {
/* 420 */         stringBuffer.append(Character.toLowerCase(c));
/* 421 */         bool2 = false;
/*     */       } else {
/* 423 */         stringBuffer.append(c);
/*     */       } 
/*     */     } 
/* 426 */     return stringBuffer.toString();
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
/*     */   public static String swapCase(String paramString) {
/*     */     int i;
/* 454 */     if (paramString == null || (i = paramString.length()) == 0) {
/* 455 */       return paramString;
/*     */     }
/* 457 */     StringBuffer stringBuffer = new StringBuffer(i);
/*     */     
/* 459 */     boolean bool = true;
/* 460 */     char c1 = Character.MIN_VALUE;
/* 461 */     char c2 = Character.MIN_VALUE;
/*     */     
/* 463 */     for (byte b = 0; b < i; b++) {
/* 464 */       c1 = paramString.charAt(b);
/* 465 */       if (Character.isUpperCase(c1)) {
/* 466 */         c2 = Character.toLowerCase(c1);
/* 467 */       } else if (Character.isTitleCase(c1)) {
/* 468 */         c2 = Character.toLowerCase(c1);
/* 469 */       } else if (Character.isLowerCase(c1)) {
/* 470 */         if (bool) {
/* 471 */           c2 = Character.toTitleCase(c1);
/*     */         } else {
/* 473 */           c2 = Character.toUpperCase(c1);
/*     */         } 
/*     */       } else {
/* 476 */         c2 = c1;
/*     */       } 
/* 478 */       stringBuffer.append(c2);
/* 479 */       bool = Character.isWhitespace(c1);
/*     */     } 
/* 481 */     return stringBuffer.toString();
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
/*     */   public static String initials(String paramString) {
/* 508 */     return initials(paramString, null);
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
/*     */   public static String initials(String paramString, char[] paramArrayOfchar) {
/* 539 */     if (paramString == null || paramString.length() == 0) {
/* 540 */       return paramString;
/*     */     }
/* 542 */     if (paramArrayOfchar != null && paramArrayOfchar.length == 0) {
/* 543 */       return "";
/*     */     }
/* 545 */     int i = paramString.length();
/* 546 */     char[] arrayOfChar = new char[i / 2 + 1];
/* 547 */     byte b1 = 0;
/* 548 */     boolean bool = true;
/* 549 */     for (byte b2 = 0; b2 < i; b2++) {
/* 550 */       char c = paramString.charAt(b2);
/*     */       
/* 552 */       if (isDelimiter(c, paramArrayOfchar)) {
/* 553 */         bool = true;
/* 554 */       } else if (bool) {
/* 555 */         arrayOfChar[b1++] = c;
/* 556 */         bool = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 561 */     return new String(arrayOfChar, 0, b1);
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
/*     */   private static boolean isDelimiter(char paramChar, char[] paramArrayOfchar) {
/* 573 */     if (paramArrayOfchar == null)
/* 574 */       return Character.isWhitespace(paramChar);  byte b;
/*     */     int i;
/* 576 */     for (b = 0, i = paramArrayOfchar.length; b < i; b++) {
/* 577 */       if (paramChar == paramArrayOfchar[b]) {
/* 578 */         return true;
/*     */       }
/*     */     } 
/* 581 */     return false;
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
/*     */   public static String abbreviate(String paramString1, int paramInt1, int paramInt2, String paramString2) {
/* 607 */     if (paramString1 == null) {
/* 608 */       return null;
/*     */     }
/* 610 */     if (paramString1.length() == 0) {
/* 611 */       return "";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 616 */     if (paramInt1 > paramString1.length()) {
/* 617 */       paramInt1 = paramString1.length();
/*     */     }
/*     */ 
/*     */     
/* 621 */     if (paramInt2 == -1 || paramInt2 > paramString1.length()) {
/* 622 */       paramInt2 = paramString1.length();
/*     */     }
/*     */     
/* 625 */     if (paramInt2 < paramInt1) {
/* 626 */       paramInt2 = paramInt1;
/*     */     }
/*     */     
/* 629 */     StringBuffer stringBuffer = new StringBuffer();
/* 630 */     int i = StringUtils.indexOf(paramString1, " ", paramInt1);
/* 631 */     if (i == -1) {
/* 632 */       stringBuffer.append(paramString1.substring(0, paramInt2));
/*     */       
/* 634 */       if (paramInt2 != paramString1.length()) {
/* 635 */         stringBuffer.append(StringUtils.defaultString(paramString2));
/*     */       }
/* 637 */     } else if (i > paramInt2) {
/* 638 */       stringBuffer.append(paramString1.substring(0, paramInt2));
/* 639 */       stringBuffer.append(StringUtils.defaultString(paramString2));
/*     */     } else {
/* 641 */       stringBuffer.append(paramString1.substring(0, i));
/* 642 */       stringBuffer.append(StringUtils.defaultString(paramString2));
/*     */     } 
/* 644 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/WordUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */