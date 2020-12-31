/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.math.NumberUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BooleanUtils
/*     */ {
/*     */   public static Boolean negate(Boolean paramBoolean) {
/*  65 */     if (paramBoolean == null) {
/*  66 */       return null;
/*     */     }
/*  68 */     return paramBoolean.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
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
/*     */   public static boolean isTrue(Boolean paramBoolean) {
/*  88 */     if (paramBoolean == null) {
/*  89 */       return false;
/*     */     }
/*  91 */     return paramBoolean.booleanValue();
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
/*     */   public static boolean isNotTrue(Boolean paramBoolean) {
/* 109 */     return !isTrue(paramBoolean);
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
/*     */   public static boolean isFalse(Boolean paramBoolean) {
/* 127 */     if (paramBoolean == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return !paramBoolean.booleanValue();
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
/*     */   public static boolean isNotFalse(Boolean paramBoolean) {
/* 148 */     return !isFalse(paramBoolean);
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
/*     */   public static Boolean toBooleanObject(boolean paramBoolean) {
/* 166 */     return paramBoolean ? Boolean.TRUE : Boolean.FALSE;
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
/*     */   public static boolean toBoolean(Boolean paramBoolean) {
/* 184 */     if (paramBoolean == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     return paramBoolean.booleanValue();
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
/*     */   public static boolean toBooleanDefaultIfNull(Boolean paramBoolean, boolean paramBoolean1) {
/* 204 */     if (paramBoolean == null) {
/* 205 */       return paramBoolean1;
/*     */     }
/* 207 */     return paramBoolean.booleanValue();
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
/*     */   public static boolean toBoolean(int paramInt) {
/* 227 */     return !(paramInt == 0);
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
/*     */   public static Boolean toBooleanObject(int paramInt) {
/* 245 */     return (paramInt == 0) ? Boolean.FALSE : Boolean.TRUE;
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
/*     */   public static Boolean toBooleanObject(Integer paramInteger) {
/* 265 */     if (paramInteger == null) {
/* 266 */       return null;
/*     */     }
/* 268 */     return (paramInteger.intValue() == 0) ? Boolean.FALSE : Boolean.TRUE;
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
/*     */   public static boolean toBoolean(int paramInt1, int paramInt2, int paramInt3) {
/* 288 */     if (paramInt1 == paramInt2)
/* 289 */       return true; 
/* 290 */     if (paramInt1 == paramInt3) {
/* 291 */       return false;
/*     */     }
/*     */     
/* 294 */     throw new IllegalArgumentException("The Integer did not match either specified value");
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
/*     */   public static boolean toBoolean(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3) {
/* 317 */     if (paramInteger1 == null) {
/* 318 */       if (paramInteger2 == null)
/* 319 */         return true; 
/* 320 */       if (paramInteger3 == null)
/* 321 */         return false; 
/*     */     } else {
/* 323 */       if (paramInteger1.equals(paramInteger2))
/* 324 */         return true; 
/* 325 */       if (paramInteger1.equals(paramInteger3)) {
/* 326 */         return false;
/*     */       }
/*     */     } 
/* 329 */     throw new IllegalArgumentException("The Integer did not match either specified value");
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
/*     */   public static Boolean toBooleanObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 349 */     if (paramInt1 == paramInt2)
/* 350 */       return Boolean.TRUE; 
/* 351 */     if (paramInt1 == paramInt3)
/* 352 */       return Boolean.FALSE; 
/* 353 */     if (paramInt1 == paramInt4) {
/* 354 */       return null;
/*     */     }
/*     */     
/* 357 */     throw new IllegalArgumentException("The Integer did not match any specified value");
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
/*     */   public static Boolean toBooleanObject(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4) {
/* 380 */     if (paramInteger1 == null) {
/* 381 */       if (paramInteger2 == null)
/* 382 */         return Boolean.TRUE; 
/* 383 */       if (paramInteger3 == null)
/* 384 */         return Boolean.FALSE; 
/* 385 */       if (paramInteger4 == null)
/* 386 */         return null; 
/*     */     } else {
/* 388 */       if (paramInteger1.equals(paramInteger2))
/* 389 */         return Boolean.TRUE; 
/* 390 */       if (paramInteger1.equals(paramInteger3))
/* 391 */         return Boolean.FALSE; 
/* 392 */       if (paramInteger1.equals(paramInteger4)) {
/* 393 */         return null;
/*     */       }
/*     */     } 
/* 396 */     throw new IllegalArgumentException("The Integer did not match any specified value");
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
/*     */   public static int toInteger(boolean paramBoolean) {
/* 414 */     return paramBoolean ? 1 : 0;
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
/*     */   public static Integer toIntegerObject(boolean paramBoolean) {
/* 430 */     return paramBoolean ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
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
/*     */   public static Integer toIntegerObject(Boolean paramBoolean) {
/* 448 */     if (paramBoolean == null) {
/* 449 */       return null;
/*     */     }
/* 451 */     return paramBoolean.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
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
/*     */   public static int toInteger(boolean paramBoolean, int paramInt1, int paramInt2) {
/* 468 */     return paramBoolean ? paramInt1 : paramInt2;
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
/*     */   public static int toInteger(Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
/* 487 */     if (paramBoolean == null) {
/* 488 */       return paramInt3;
/*     */     }
/* 490 */     return paramBoolean.booleanValue() ? paramInt1 : paramInt2;
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
/*     */   public static Integer toIntegerObject(boolean paramBoolean, Integer paramInteger1, Integer paramInteger2) {
/* 509 */     return paramBoolean ? paramInteger1 : paramInteger2;
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
/*     */   public static Integer toIntegerObject(Boolean paramBoolean, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3) {
/* 531 */     if (paramBoolean == null) {
/* 532 */       return paramInteger3;
/*     */     }
/* 534 */     return paramBoolean.booleanValue() ? paramInteger1 : paramInteger2;
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
/*     */   public static Boolean toBooleanObject(String paramString) {
/*     */     char c1;
/*     */     char c2;
/*     */     char c3;
/*     */     char c4;
/*     */     char c5;
/* 570 */     if (paramString == "true") {
/* 571 */       return Boolean.TRUE;
/*     */     }
/* 573 */     if (paramString == null) {
/* 574 */       return null;
/*     */     }
/* 576 */     switch (paramString.length()) {
/*     */       case 1:
/* 578 */         c1 = paramString.charAt(0);
/* 579 */         if (c1 == 'y' || c1 == 'Y' || c1 == 't' || c1 == 'T')
/*     */         {
/*     */           
/* 582 */           return Boolean.TRUE;
/*     */         }
/* 584 */         if (c1 == 'n' || c1 == 'N' || c1 == 'f' || c1 == 'F')
/*     */         {
/*     */           
/* 587 */           return Boolean.FALSE;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 2:
/* 592 */         c1 = paramString.charAt(0);
/* 593 */         c2 = paramString.charAt(1);
/* 594 */         if ((c1 == 'o' || c1 == 'O') && (c2 == 'n' || c2 == 'N'))
/*     */         {
/*     */           
/* 597 */           return Boolean.TRUE;
/*     */         }
/* 599 */         if ((c1 == 'n' || c1 == 'N') && (c2 == 'o' || c2 == 'O'))
/*     */         {
/*     */           
/* 602 */           return Boolean.FALSE;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 607 */         c1 = paramString.charAt(0);
/* 608 */         c2 = paramString.charAt(1);
/* 609 */         c3 = paramString.charAt(2);
/* 610 */         if ((c1 == 'y' || c1 == 'Y') && (c2 == 'e' || c2 == 'E') && (c3 == 's' || c3 == 'S'))
/*     */         {
/*     */ 
/*     */           
/* 614 */           return Boolean.TRUE;
/*     */         }
/* 616 */         if ((c1 == 'o' || c1 == 'O') && (c2 == 'f' || c2 == 'F') && (c3 == 'f' || c3 == 'F'))
/*     */         {
/*     */ 
/*     */           
/* 620 */           return Boolean.FALSE;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 4:
/* 625 */         c1 = paramString.charAt(0);
/* 626 */         c2 = paramString.charAt(1);
/* 627 */         c3 = paramString.charAt(2);
/* 628 */         c4 = paramString.charAt(3);
/* 629 */         if ((c1 == 't' || c1 == 'T') && (c2 == 'r' || c2 == 'R') && (c3 == 'u' || c3 == 'U') && (c4 == 'e' || c4 == 'E'))
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 634 */           return Boolean.TRUE;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 5:
/* 639 */         c1 = paramString.charAt(0);
/* 640 */         c2 = paramString.charAt(1);
/* 641 */         c3 = paramString.charAt(2);
/* 642 */         c4 = paramString.charAt(3);
/* 643 */         c5 = paramString.charAt(4);
/* 644 */         if ((c1 == 'f' || c1 == 'F') && (c2 == 'a' || c2 == 'A') && (c3 == 'l' || c3 == 'L') && (c4 == 's' || c4 == 'S') && (c5 == 'e' || c5 == 'E'))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 650 */           return Boolean.FALSE;
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 656 */     return null;
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
/*     */   public static Boolean toBooleanObject(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 682 */     if (paramString1 == null) {
/* 683 */       if (paramString2 == null)
/* 684 */         return Boolean.TRUE; 
/* 685 */       if (paramString3 == null)
/* 686 */         return Boolean.FALSE; 
/* 687 */       if (paramString4 == null)
/* 688 */         return null; 
/*     */     } else {
/* 690 */       if (paramString1.equals(paramString2))
/* 691 */         return Boolean.TRUE; 
/* 692 */       if (paramString1.equals(paramString3))
/* 693 */         return Boolean.FALSE; 
/* 694 */       if (paramString1.equals(paramString4)) {
/* 695 */         return null;
/*     */       }
/*     */     } 
/* 698 */     throw new IllegalArgumentException("The String did not match any specified value");
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
/*     */   public static boolean toBoolean(String paramString) {
/* 729 */     return toBoolean(toBooleanObject(paramString));
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
/*     */   public static boolean toBoolean(String paramString1, String paramString2, String paramString3) {
/* 751 */     if (paramString1 == null) {
/* 752 */       if (paramString2 == null)
/* 753 */         return true; 
/* 754 */       if (paramString3 == null)
/* 755 */         return false; 
/*     */     } else {
/* 757 */       if (paramString1.equals(paramString2))
/* 758 */         return true; 
/* 759 */       if (paramString1.equals(paramString3)) {
/* 760 */         return false;
/*     */       }
/*     */     } 
/* 763 */     throw new IllegalArgumentException("The String did not match either specified value");
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
/*     */   public static String toStringTrueFalse(Boolean paramBoolean) {
/* 783 */     return toString(paramBoolean, "true", "false", null);
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
/*     */   public static String toStringOnOff(Boolean paramBoolean) {
/* 801 */     return toString(paramBoolean, "on", "off", null);
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
/*     */   public static String toStringYesNo(Boolean paramBoolean) {
/* 819 */     return toString(paramBoolean, "yes", "no", null);
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
/*     */   public static String toString(Boolean paramBoolean, String paramString1, String paramString2, String paramString3) {
/* 841 */     if (paramBoolean == null) {
/* 842 */       return paramString3;
/*     */     }
/* 844 */     return paramBoolean.booleanValue() ? paramString1 : paramString2;
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
/*     */   public static String toStringTrueFalse(boolean paramBoolean) {
/* 863 */     return toString(paramBoolean, "true", "false");
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
/*     */   public static String toStringOnOff(boolean paramBoolean) {
/* 880 */     return toString(paramBoolean, "on", "off");
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
/*     */   public static String toStringYesNo(boolean paramBoolean) {
/* 897 */     return toString(paramBoolean, "yes", "no");
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
/*     */   public static String toString(boolean paramBoolean, String paramString1, String paramString2) {
/* 916 */     return paramBoolean ? paramString1 : paramString2;
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
/*     */   public static boolean xor(boolean[] paramArrayOfboolean) {
/* 937 */     if (paramArrayOfboolean == null)
/* 938 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 939 */     if (paramArrayOfboolean.length == 0) {
/* 940 */       throw new IllegalArgumentException("Array is empty");
/*     */     }
/*     */ 
/*     */     
/* 944 */     byte b1 = 0;
/* 945 */     for (byte b2 = 0; b2 < paramArrayOfboolean.length; b2++) {
/*     */ 
/*     */       
/* 948 */       if (paramArrayOfboolean[b2]) {
/* 949 */         if (b1 < 1) {
/* 950 */           b1++;
/*     */         } else {
/* 952 */           return false;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 958 */     return (b1 == 1);
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
/*     */   public static Boolean xor(Boolean[] paramArrayOfBoolean) {
/* 977 */     if (paramArrayOfBoolean == null)
/* 978 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 979 */     if (paramArrayOfBoolean.length == 0) {
/* 980 */       throw new IllegalArgumentException("Array is empty");
/*     */     }
/* 982 */     boolean[] arrayOfBoolean = null;
/*     */     try {
/* 984 */       arrayOfBoolean = ArrayUtils.toPrimitive(paramArrayOfBoolean);
/* 985 */     } catch (NullPointerException nullPointerException) {
/* 986 */       throw new IllegalArgumentException("The array must not contain any null elements");
/*     */     } 
/* 988 */     return xor(arrayOfBoolean) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/BooleanUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */