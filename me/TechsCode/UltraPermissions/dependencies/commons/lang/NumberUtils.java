/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NumberUtils
/*     */ {
/*     */   public static int stringToInt(String paramString) {
/*  61 */     return stringToInt(paramString, 0);
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
/*     */   public static int stringToInt(String paramString, int paramInt) {
/*     */     try {
/*  74 */       return Integer.parseInt(paramString);
/*  75 */     } catch (NumberFormatException numberFormatException) {
/*  76 */       return paramInt;
/*     */     } 
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
/*     */   public static Number createNumber(String paramString) {
/*     */     String str1;
/*     */     Object object;
/*     */     String str2;
/* 139 */     if (paramString == null) {
/* 140 */       return null;
/*     */     }
/* 142 */     if (paramString.length() == 0) {
/* 143 */       throw new NumberFormatException("\"\" is not a valid number.");
/*     */     }
/* 145 */     if (paramString.length() == 1 && !Character.isDigit(paramString.charAt(0))) {
/* 146 */       throw new NumberFormatException(paramString + " is not a valid number.");
/*     */     }
/* 148 */     if (paramString.startsWith("--"))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 153 */       return null;
/*     */     }
/* 155 */     if (paramString.startsWith("0x") || paramString.startsWith("-0x")) {
/* 156 */       return createInteger(paramString);
/*     */     }
/* 158 */     char c = paramString.charAt(paramString.length() - 1);
/*     */ 
/*     */ 
/*     */     
/* 162 */     int i = paramString.indexOf('.');
/* 163 */     int j = paramString.indexOf('e') + paramString.indexOf('E') + 1;
/*     */     
/* 165 */     if (i > -1) {
/*     */       
/* 167 */       if (j > -1) {
/* 168 */         if (j < i) {
/* 169 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*     */         }
/* 171 */         object = paramString.substring(i + 1, j);
/*     */       } else {
/* 173 */         object = paramString.substring(i + 1);
/*     */       } 
/* 175 */       str1 = paramString.substring(0, i);
/*     */     } else {
/* 177 */       if (j > -1) {
/* 178 */         str1 = paramString.substring(0, j);
/*     */       } else {
/* 180 */         str1 = paramString;
/*     */       } 
/* 182 */       object = null;
/*     */     } 
/* 184 */     if (!Character.isDigit(c)) {
/* 185 */       if (j > -1 && j < paramString.length() - 1) {
/* 186 */         str2 = paramString.substring(j + 1, paramString.length() - 1);
/*     */       } else {
/* 188 */         str2 = null;
/*     */       } 
/*     */       
/* 191 */       String str = paramString.substring(0, paramString.length() - 1);
/* 192 */       boolean bool1 = (isAllZeros(str1) && isAllZeros(str2)) ? true : false;
/* 193 */       switch (c) {
/*     */         case 'L':
/*     */         case 'l':
/* 196 */           if (object == null && str2 == null && ((str.charAt(0) == '-' && isDigits(str.substring(1))) || isDigits(str))) {
/*     */             
/*     */             try {
/*     */               
/* 200 */               return createLong(str);
/* 201 */             } catch (NumberFormatException numberFormatException) {
/*     */ 
/*     */               
/* 204 */               return createBigInteger(str);
/*     */             } 
/*     */           }
/* 207 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*     */         case 'F':
/*     */         case 'f':
/*     */           try {
/* 211 */             Float float_ = createFloat(str);
/* 212 */             if (!float_.isInfinite() && (float_.floatValue() != 0.0F || bool1))
/*     */             {
/*     */               
/* 215 */               return float_;
/*     */             }
/*     */           }
/* 218 */           catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */         
/*     */         case 'D':
/*     */         case 'd':
/*     */           try {
/* 225 */             Double double_ = createDouble(str);
/* 226 */             if (!double_.isInfinite() && (double_.floatValue() != 0.0D || bool1)) {
/* 227 */               return double_;
/*     */             }
/* 229 */           } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */           
/*     */           try {
/* 233 */             return createBigDecimal(str);
/* 234 */           } catch (NumberFormatException numberFormatException) {
/*     */             break;
/*     */           } 
/*     */       } 
/*     */       
/* 239 */       throw new NumberFormatException(paramString + " is not a valid number.");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     if (j > -1 && j < paramString.length() - 1) {
/* 246 */       str2 = paramString.substring(j + 1, paramString.length());
/*     */     } else {
/* 248 */       str2 = null;
/*     */     } 
/* 250 */     if (object == null && str2 == null) {
/*     */       
/*     */       try {
/* 253 */         return createInteger(paramString);
/* 254 */       } catch (NumberFormatException numberFormatException) {
/*     */ 
/*     */         
/*     */         try {
/* 258 */           return createLong(paramString);
/* 259 */         } catch (NumberFormatException numberFormatException1) {
/*     */ 
/*     */           
/* 262 */           return createBigInteger(paramString);
/*     */         } 
/*     */       } 
/*     */     }
/* 266 */     boolean bool = (isAllZeros(str1) && isAllZeros(str2)) ? true : false;
/*     */     try {
/* 268 */       Float float_ = createFloat(paramString);
/* 269 */       if (!float_.isInfinite() && (float_.floatValue() != 0.0F || bool)) {
/* 270 */         return float_;
/*     */       }
/* 272 */     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */     
/*     */     try {
/* 276 */       Double double_ = createDouble(paramString);
/* 277 */       if (!double_.isInfinite() && (double_.doubleValue() != 0.0D || bool)) {
/* 278 */         return double_;
/*     */       }
/* 280 */     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */ 
/*     */     
/* 284 */     return createBigDecimal(paramString);
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
/*     */   private static boolean isAllZeros(String paramString) {
/* 300 */     if (paramString == null) {
/* 301 */       return true;
/*     */     }
/* 303 */     for (int i = paramString.length() - 1; i >= 0; i--) {
/* 304 */       if (paramString.charAt(i) != '0') {
/* 305 */         return false;
/*     */       }
/*     */     } 
/* 308 */     return (paramString.length() > 0);
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
/*     */   public static Float createFloat(String paramString) {
/* 321 */     return Float.valueOf(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Double createDouble(String paramString) {
/* 332 */     return Double.valueOf(paramString);
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
/*     */   public static Integer createInteger(String paramString) {
/* 345 */     return Integer.decode(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Long createLong(String paramString) {
/* 356 */     return Long.valueOf(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigInteger createBigInteger(String paramString) {
/* 367 */     return new BigInteger(paramString);
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
/*     */   public static BigDecimal createBigDecimal(String paramString) {
/* 379 */     return new BigDecimal(paramString);
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
/*     */   public static long minimum(long paramLong1, long paramLong2, long paramLong3) {
/* 394 */     if (paramLong2 < paramLong1) {
/* 395 */       paramLong1 = paramLong2;
/*     */     }
/* 397 */     if (paramLong3 < paramLong1) {
/* 398 */       paramLong1 = paramLong3;
/*     */     }
/* 400 */     return paramLong1;
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
/*     */   public static int minimum(int paramInt1, int paramInt2, int paramInt3) {
/* 412 */     if (paramInt2 < paramInt1) {
/* 413 */       paramInt1 = paramInt2;
/*     */     }
/* 415 */     if (paramInt3 < paramInt1) {
/* 416 */       paramInt1 = paramInt3;
/*     */     }
/* 418 */     return paramInt1;
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
/*     */   public static long maximum(long paramLong1, long paramLong2, long paramLong3) {
/* 430 */     if (paramLong2 > paramLong1) {
/* 431 */       paramLong1 = paramLong2;
/*     */     }
/* 433 */     if (paramLong3 > paramLong1) {
/* 434 */       paramLong1 = paramLong3;
/*     */     }
/* 436 */     return paramLong1;
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
/*     */   public static int maximum(int paramInt1, int paramInt2, int paramInt3) {
/* 448 */     if (paramInt2 > paramInt1) {
/* 449 */       paramInt1 = paramInt2;
/*     */     }
/* 451 */     if (paramInt3 > paramInt1) {
/* 452 */       paramInt1 = paramInt3;
/*     */     }
/* 454 */     return paramInt1;
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
/*     */   public static int compare(double paramDouble1, double paramDouble2) {
/* 494 */     if (paramDouble1 < paramDouble2) {
/* 495 */       return -1;
/*     */     }
/* 497 */     if (paramDouble1 > paramDouble2) {
/* 498 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 504 */     long l1 = Double.doubleToLongBits(paramDouble1);
/* 505 */     long l2 = Double.doubleToLongBits(paramDouble2);
/* 506 */     if (l1 == l2) {
/* 507 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 515 */     if (l1 < l2) {
/* 516 */       return -1;
/*     */     }
/* 518 */     return 1;
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
/*     */   public static int compare(float paramFloat1, float paramFloat2) {
/* 555 */     if (paramFloat1 < paramFloat2) {
/* 556 */       return -1;
/*     */     }
/* 558 */     if (paramFloat1 > paramFloat2) {
/* 559 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 565 */     int i = Float.floatToIntBits(paramFloat1);
/* 566 */     int j = Float.floatToIntBits(paramFloat2);
/* 567 */     if (i == j) {
/* 568 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 576 */     if (i < j) {
/* 577 */       return -1;
/*     */     }
/* 579 */     return 1;
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
/*     */   public static boolean isDigits(String paramString) {
/* 596 */     if (paramString == null || paramString.length() == 0) {
/* 597 */       return false;
/*     */     }
/* 599 */     for (byte b = 0; b < paramString.length(); b++) {
/* 600 */       if (!Character.isDigit(paramString.charAt(b))) {
/* 601 */         return false;
/*     */       }
/*     */     } 
/* 604 */     return true;
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
/*     */   public static boolean isNumber(String paramString) {
/* 621 */     if (StringUtils.isEmpty(paramString)) {
/* 622 */       return false;
/*     */     }
/* 624 */     char[] arrayOfChar = paramString.toCharArray();
/* 625 */     int i = arrayOfChar.length;
/* 626 */     boolean bool1 = false;
/* 627 */     boolean bool2 = false;
/* 628 */     boolean bool3 = false;
/* 629 */     boolean bool4 = false;
/*     */     
/* 631 */     byte b1 = (arrayOfChar[0] == '-') ? 1 : 0;
/* 632 */     if (i > b1 + 1 && 
/* 633 */       arrayOfChar[b1] == '0' && arrayOfChar[b1 + 1] == 'x') {
/* 634 */       int j = b1 + 2;
/* 635 */       if (j == i) {
/* 636 */         return false;
/*     */       }
/*     */       
/* 639 */       for (; j < arrayOfChar.length; j++) {
/* 640 */         if ((arrayOfChar[j] < '0' || arrayOfChar[j] > '9') && (arrayOfChar[j] < 'a' || arrayOfChar[j] > 'f') && (arrayOfChar[j] < 'A' || arrayOfChar[j] > 'F'))
/*     */         {
/*     */           
/* 643 */           return false;
/*     */         }
/*     */       } 
/* 646 */       return true;
/*     */     } 
/*     */     
/* 649 */     i--;
/*     */     
/* 651 */     byte b2 = b1;
/*     */ 
/*     */     
/* 654 */     while (b2 < i || (b2 < i + 1 && bool3 && !bool4)) {
/* 655 */       if (arrayOfChar[b2] >= '0' && arrayOfChar[b2] <= '9') {
/* 656 */         bool4 = true;
/* 657 */         bool3 = false;
/*     */       }
/* 659 */       else if (arrayOfChar[b2] == '.') {
/* 660 */         if (bool2 || bool1)
/*     */         {
/* 662 */           return false;
/*     */         }
/* 664 */         bool2 = true;
/* 665 */       } else if (arrayOfChar[b2] == 'e' || arrayOfChar[b2] == 'E') {
/*     */         
/* 667 */         if (bool1)
/*     */         {
/* 669 */           return false;
/*     */         }
/* 671 */         if (!bool4) {
/* 672 */           return false;
/*     */         }
/* 674 */         bool1 = true;
/* 675 */         bool3 = true;
/* 676 */       } else if (arrayOfChar[b2] == '+' || arrayOfChar[b2] == '-') {
/* 677 */         if (!bool3) {
/* 678 */           return false;
/*     */         }
/* 680 */         bool3 = false;
/* 681 */         bool4 = false;
/*     */       } else {
/* 683 */         return false;
/*     */       } 
/* 685 */       b2++;
/*     */     } 
/* 687 */     if (b2 < arrayOfChar.length) {
/* 688 */       if (arrayOfChar[b2] >= '0' && arrayOfChar[b2] <= '9')
/*     */       {
/* 690 */         return true;
/*     */       }
/* 692 */       if (arrayOfChar[b2] == 'e' || arrayOfChar[b2] == 'E')
/*     */       {
/* 694 */         return false;
/*     */       }
/* 696 */       if (!bool3 && (arrayOfChar[b2] == 'd' || arrayOfChar[b2] == 'D' || arrayOfChar[b2] == 'f' || arrayOfChar[b2] == 'F'))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 701 */         return bool4;
/*     */       }
/* 703 */       if (arrayOfChar[b2] == 'l' || arrayOfChar[b2] == 'L')
/*     */       {
/*     */         
/* 706 */         return (bool4 && !bool1);
/*     */       }
/*     */       
/* 709 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 713 */     return (!bool3 && bool4);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/NumberUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */