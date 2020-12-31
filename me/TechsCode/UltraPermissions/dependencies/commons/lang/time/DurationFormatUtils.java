/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.time;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
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
/*     */ 
/*     */ 
/*     */ public class DurationFormatUtils
/*     */ {
/*     */   public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
/*     */   
/*     */   public static String formatDurationHMS(long paramLong) {
/*  82 */     return formatDuration(paramLong, "H:mm:ss.SSS");
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
/*     */   public static String formatDurationISO(long paramLong) {
/*  97 */     return formatDuration(paramLong, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false);
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
/*     */   public static String formatDuration(long paramLong, String paramString) {
/* 112 */     return formatDuration(paramLong, paramString, true);
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
/*     */   public static String formatDuration(long paramLong, String paramString, boolean paramBoolean) {
/* 130 */     Token[] arrayOfToken = lexx(paramString);
/*     */     
/* 132 */     int i = 0;
/* 133 */     int j = 0;
/* 134 */     int k = 0;
/* 135 */     int m = 0;
/* 136 */     int n = 0;
/*     */     
/* 138 */     if (Token.containsTokenWithValue(arrayOfToken, d)) {
/* 139 */       i = (int)(paramLong / 86400000L);
/* 140 */       paramLong -= i * 86400000L;
/*     */     } 
/* 142 */     if (Token.containsTokenWithValue(arrayOfToken, H)) {
/* 143 */       j = (int)(paramLong / 3600000L);
/* 144 */       paramLong -= j * 3600000L;
/*     */     } 
/* 146 */     if (Token.containsTokenWithValue(arrayOfToken, m)) {
/* 147 */       k = (int)(paramLong / 60000L);
/* 148 */       paramLong -= k * 60000L;
/*     */     } 
/* 150 */     if (Token.containsTokenWithValue(arrayOfToken, s)) {
/* 151 */       m = (int)(paramLong / 1000L);
/* 152 */       paramLong -= m * 1000L;
/*     */     } 
/* 154 */     if (Token.containsTokenWithValue(arrayOfToken, S)) {
/* 155 */       n = (int)paramLong;
/*     */     }
/*     */     
/* 158 */     return format(arrayOfToken, 0, 0, i, j, k, m, n, paramBoolean);
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
/*     */   public static String formatDurationWords(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 180 */     String str = formatDuration(paramLong, "d' days 'H' hours 'm' minutes 's' seconds'");
/* 181 */     if (paramBoolean1) {
/*     */       
/* 183 */       str = " " + str;
/* 184 */       String str1 = StringUtils.replaceOnce(str, " 0 days", "");
/* 185 */       if (str1.length() != str.length()) {
/* 186 */         str = str1;
/* 187 */         str1 = StringUtils.replaceOnce(str, " 0 hours", "");
/* 188 */         if (str1.length() != str.length()) {
/* 189 */           str = str1;
/* 190 */           str1 = StringUtils.replaceOnce(str, " 0 minutes", "");
/* 191 */           str = str1;
/* 192 */           if (str1.length() != str.length()) {
/* 193 */             str = StringUtils.replaceOnce(str1, " 0 seconds", "");
/*     */           }
/*     */         } 
/*     */       } 
/* 197 */       if (str.length() != 0)
/*     */       {
/* 199 */         str = str.substring(1);
/*     */       }
/*     */     } 
/* 202 */     if (paramBoolean2) {
/* 203 */       String str1 = StringUtils.replaceOnce(str, " 0 seconds", "");
/* 204 */       if (str1.length() != str.length()) {
/* 205 */         str = str1;
/* 206 */         str1 = StringUtils.replaceOnce(str, " 0 minutes", "");
/* 207 */         if (str1.length() != str.length()) {
/* 208 */           str = str1;
/* 209 */           str1 = StringUtils.replaceOnce(str, " 0 hours", "");
/* 210 */           if (str1.length() != str.length()) {
/* 211 */             str = StringUtils.replaceOnce(str1, " 0 days", "");
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 217 */     str = " " + str;
/* 218 */     str = StringUtils.replaceOnce(str, " 1 seconds", " 1 second");
/* 219 */     str = StringUtils.replaceOnce(str, " 1 minutes", " 1 minute");
/* 220 */     str = StringUtils.replaceOnce(str, " 1 hours", " 1 hour");
/* 221 */     str = StringUtils.replaceOnce(str, " 1 days", " 1 day");
/* 222 */     return str.trim();
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
/*     */   public static String formatPeriodISO(long paramLong1, long paramLong2) {
/* 236 */     return formatPeriod(paramLong1, paramLong2, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false, TimeZone.getDefault());
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
/*     */   public static String formatPeriod(long paramLong1, long paramLong2, String paramString) {
/* 249 */     return formatPeriod(paramLong1, paramLong2, paramString, true, TimeZone.getDefault());
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
/*     */   public static String formatPeriod(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, TimeZone paramTimeZone) {
/* 284 */     Token[] arrayOfToken = lexx(paramString);
/*     */ 
/*     */ 
/*     */     
/* 288 */     Calendar calendar1 = Calendar.getInstance(paramTimeZone);
/* 289 */     calendar1.setTime(new Date(paramLong1));
/* 290 */     Calendar calendar2 = Calendar.getInstance(paramTimeZone);
/* 291 */     calendar2.setTime(new Date(paramLong2));
/*     */ 
/*     */     
/* 294 */     int i = calendar2.get(14) - calendar1.get(14);
/* 295 */     int j = calendar2.get(13) - calendar1.get(13);
/* 296 */     int k = calendar2.get(12) - calendar1.get(12);
/* 297 */     int m = calendar2.get(11) - calendar1.get(11);
/* 298 */     int n = calendar2.get(5) - calendar1.get(5);
/* 299 */     int i1 = calendar2.get(2) - calendar1.get(2);
/* 300 */     int i2 = calendar2.get(1) - calendar1.get(1);
/*     */ 
/*     */     
/* 303 */     while (i < 0) {
/* 304 */       i += 1000;
/* 305 */       j--;
/*     */     } 
/* 307 */     while (j < 0) {
/* 308 */       j += 60;
/* 309 */       k--;
/*     */     } 
/* 311 */     while (k < 0) {
/* 312 */       k += 60;
/* 313 */       m--;
/*     */     } 
/* 315 */     while (m < 0) {
/* 316 */       m += 24;
/* 317 */       n--;
/*     */     } 
/*     */     
/* 320 */     if (Token.containsTokenWithValue(arrayOfToken, M)) {
/* 321 */       while (n < 0) {
/* 322 */         n += calendar1.getActualMaximum(5);
/* 323 */         i1--;
/* 324 */         calendar1.add(2, 1);
/*     */       } 
/*     */       
/* 327 */       while (i1 < 0) {
/* 328 */         i1 += 12;
/* 329 */         i2--;
/*     */       } 
/*     */       
/* 332 */       if (!Token.containsTokenWithValue(arrayOfToken, y) && i2 != 0) {
/* 333 */         while (i2 != 0) {
/* 334 */           i1 += 12 * i2;
/* 335 */           i2 = 0;
/*     */         }
/*     */       
/*     */       }
/*     */     } else {
/*     */       
/* 341 */       if (!Token.containsTokenWithValue(arrayOfToken, y)) {
/* 342 */         int i3 = calendar2.get(1);
/* 343 */         if (i1 < 0)
/*     */         {
/* 345 */           i3--;
/*     */         }
/*     */         
/* 348 */         while (calendar1.get(1) != i3) {
/* 349 */           n += calendar1.getActualMaximum(6) - calendar1.get(6);
/*     */ 
/*     */           
/* 352 */           if (calendar1 instanceof java.util.GregorianCalendar && 
/* 353 */             calendar1.get(2) == 1 && calendar1.get(5) == 29)
/*     */           {
/*     */             
/* 356 */             n++;
/*     */           }
/*     */ 
/*     */           
/* 360 */           calendar1.add(1, 1);
/*     */           
/* 362 */           n += calendar1.get(6);
/*     */         } 
/*     */         
/* 365 */         i2 = 0;
/*     */       } 
/*     */       
/* 368 */       while (calendar1.get(2) != calendar2.get(2)) {
/* 369 */         n += calendar1.getActualMaximum(5);
/* 370 */         calendar1.add(2, 1);
/*     */       } 
/*     */       
/* 373 */       i1 = 0;
/*     */       
/* 375 */       while (n < 0) {
/* 376 */         n += calendar1.getActualMaximum(5);
/* 377 */         i1--;
/* 378 */         calendar1.add(2, 1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 387 */     if (!Token.containsTokenWithValue(arrayOfToken, d)) {
/* 388 */       m += 24 * n;
/* 389 */       n = 0;
/*     */     } 
/* 391 */     if (!Token.containsTokenWithValue(arrayOfToken, H)) {
/* 392 */       k += 60 * m;
/* 393 */       m = 0;
/*     */     } 
/* 395 */     if (!Token.containsTokenWithValue(arrayOfToken, m)) {
/* 396 */       j += 60 * k;
/* 397 */       k = 0;
/*     */     } 
/* 399 */     if (!Token.containsTokenWithValue(arrayOfToken, s)) {
/* 400 */       i += 1000 * j;
/* 401 */       j = 0;
/*     */     } 
/*     */     
/* 404 */     return format(arrayOfToken, i2, i1, n, m, k, j, i, paramBoolean);
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
/*     */   static String format(Token[] paramArrayOfToken, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean) {
/* 424 */     StrBuilder strBuilder = new StrBuilder();
/* 425 */     boolean bool = false;
/* 426 */     int i = paramArrayOfToken.length;
/* 427 */     for (byte b = 0; b < i; b++) {
/* 428 */       Token token = paramArrayOfToken[b];
/* 429 */       Object object = token.getValue();
/* 430 */       int j = token.getCount();
/* 431 */       if (object instanceof StringBuffer) {
/* 432 */         strBuilder.append(object.toString());
/*     */       }
/* 434 */       else if (object == y) {
/* 435 */         strBuilder.append(paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt1), j, '0') : Integer.toString(paramInt1));
/*     */         
/* 437 */         bool = false;
/* 438 */       } else if (object == M) {
/* 439 */         strBuilder.append(paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt2), j, '0') : Integer.toString(paramInt2));
/*     */         
/* 441 */         bool = false;
/* 442 */       } else if (object == d) {
/* 443 */         strBuilder.append(paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt3), j, '0') : Integer.toString(paramInt3));
/*     */         
/* 445 */         bool = false;
/* 446 */       } else if (object == H) {
/* 447 */         strBuilder.append(paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt4), j, '0') : Integer.toString(paramInt4));
/*     */         
/* 449 */         bool = false;
/* 450 */       } else if (object == m) {
/* 451 */         strBuilder.append(paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt5), j, '0') : Integer.toString(paramInt5));
/*     */         
/* 453 */         bool = false;
/* 454 */       } else if (object == s) {
/* 455 */         strBuilder.append(paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt6), j, '0') : Integer.toString(paramInt6));
/*     */         
/* 457 */         bool = true;
/* 458 */       } else if (object == S) {
/* 459 */         if (bool) {
/* 460 */           paramInt7 += 1000;
/* 461 */           String str = paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt7), j, '0') : Integer.toString(paramInt7);
/*     */ 
/*     */           
/* 464 */           strBuilder.append(str.substring(1));
/*     */         } else {
/* 466 */           strBuilder.append(paramBoolean ? StringUtils.leftPad(Integer.toString(paramInt7), j, '0') : Integer.toString(paramInt7));
/*     */         } 
/*     */ 
/*     */         
/* 470 */         bool = false;
/*     */       } 
/*     */     } 
/*     */     
/* 474 */     return strBuilder.toString();
/*     */   }
/*     */   
/* 477 */   static final Object y = "y";
/* 478 */   static final Object M = "M";
/* 479 */   static final Object d = "d";
/* 480 */   static final Object H = "H";
/* 481 */   static final Object m = "m";
/* 482 */   static final Object s = "s";
/* 483 */   static final Object S = "S";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Token[] lexx(String paramString) {
/* 492 */     char[] arrayOfChar = paramString.toCharArray();
/* 493 */     ArrayList arrayList = new ArrayList(arrayOfChar.length);
/*     */     
/* 495 */     boolean bool = false;
/* 496 */     StringBuffer stringBuffer = null;
/* 497 */     Token token = null;
/* 498 */     int i = arrayOfChar.length;
/* 499 */     for (byte b = 0; b < i; b++) {
/* 500 */       char c = arrayOfChar[b];
/* 501 */       if (bool && c != '\'') {
/* 502 */         stringBuffer.append(c);
/*     */       } else {
/*     */         
/* 505 */         Object object = null;
/* 506 */         switch (c) {
/*     */           
/*     */           case '\'':
/* 509 */             if (bool) {
/* 510 */               stringBuffer = null;
/* 511 */               bool = false; break;
/*     */             } 
/* 513 */             stringBuffer = new StringBuffer();
/* 514 */             arrayList.add(new Token(stringBuffer));
/* 515 */             bool = true;
/*     */             break;
/*     */           case 'y':
/* 518 */             object = y; break;
/* 519 */           case 'M': object = M; break;
/* 520 */           case 'd': object = d; break;
/* 521 */           case 'H': object = H; break;
/* 522 */           case 'm': object = m; break;
/* 523 */           case 's': object = s; break;
/* 524 */           case 'S': object = S; break;
/*     */           default:
/* 526 */             if (stringBuffer == null) {
/* 527 */               stringBuffer = new StringBuffer();
/* 528 */               arrayList.add(new Token(stringBuffer));
/*     */             } 
/* 530 */             stringBuffer.append(c);
/*     */             break;
/*     */         } 
/* 533 */         if (object != null) {
/* 534 */           if (token != null && token.getValue() == object) {
/* 535 */             token.increment();
/*     */           } else {
/* 537 */             Token token1 = new Token(object);
/* 538 */             arrayList.add(token1);
/* 539 */             token = token1;
/*     */           } 
/* 541 */           stringBuffer = null;
/*     */         } 
/*     */       } 
/* 544 */     }  return arrayList.<Token>toArray(new Token[arrayList.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class Token
/*     */   {
/*     */     private Object value;
/*     */ 
/*     */     
/*     */     private int count;
/*     */ 
/*     */ 
/*     */     
/*     */     static boolean containsTokenWithValue(Token[] param1ArrayOfToken, Object param1Object) {
/* 560 */       int i = param1ArrayOfToken.length;
/* 561 */       for (byte b = 0; b < i; b++) {
/* 562 */         if (param1ArrayOfToken[b].getValue() == param1Object) {
/* 563 */           return true;
/*     */         }
/*     */       } 
/* 566 */       return false;
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
/*     */     Token(Object param1Object) {
/* 578 */       this.value = param1Object;
/* 579 */       this.count = 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Token(Object param1Object, int param1Int) {
/* 590 */       this.value = param1Object;
/* 591 */       this.count = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void increment() {
/* 598 */       this.count++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int getCount() {
/* 607 */       return this.count;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object getValue() {
/* 616 */       return this.value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 626 */       if (param1Object instanceof Token) {
/* 627 */         Token token = (Token)param1Object;
/* 628 */         if (this.value.getClass() != token.value.getClass()) {
/* 629 */           return false;
/*     */         }
/* 631 */         if (this.count != token.count) {
/* 632 */           return false;
/*     */         }
/* 634 */         if (this.value instanceof StringBuffer)
/* 635 */           return this.value.toString().equals(token.value.toString()); 
/* 636 */         if (this.value instanceof Number) {
/* 637 */           return this.value.equals(token.value);
/*     */         }
/* 639 */         return (this.value == token.value);
/*     */       } 
/*     */       
/* 642 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 653 */       return this.value.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 662 */       return StringUtils.repeat(this.value.toString(), this.count);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/time/DurationFormatUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */