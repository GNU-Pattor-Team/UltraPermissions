/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.math;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NumberUtils
/*      */ {
/*   41 */   public static final Long LONG_ZERO = new Long(0L);
/*      */   
/*   43 */   public static final Long LONG_ONE = new Long(1L);
/*      */   
/*   45 */   public static final Long LONG_MINUS_ONE = new Long(-1L);
/*      */   
/*   47 */   public static final Integer INTEGER_ZERO = new Integer(0);
/*      */   
/*   49 */   public static final Integer INTEGER_ONE = new Integer(1);
/*      */   
/*   51 */   public static final Integer INTEGER_MINUS_ONE = new Integer(-1);
/*      */   
/*   53 */   public static final Short SHORT_ZERO = new Short((short)0);
/*      */   
/*   55 */   public static final Short SHORT_ONE = new Short((short)1);
/*      */   
/*   57 */   public static final Short SHORT_MINUS_ONE = new Short((short)-1);
/*      */   
/*   59 */   public static final Byte BYTE_ZERO = new Byte((byte)0);
/*      */   
/*   61 */   public static final Byte BYTE_ONE = new Byte((byte)1);
/*      */   
/*   63 */   public static final Byte BYTE_MINUS_ONE = new Byte((byte)-1);
/*      */   
/*   65 */   public static final Double DOUBLE_ZERO = new Double(0.0D);
/*      */   
/*   67 */   public static final Double DOUBLE_ONE = new Double(1.0D);
/*      */   
/*   69 */   public static final Double DOUBLE_MINUS_ONE = new Double(-1.0D);
/*      */   
/*   71 */   public static final Float FLOAT_ZERO = new Float(0.0F);
/*      */   
/*   73 */   public static final Float FLOAT_ONE = new Float(1.0F);
/*      */   
/*   75 */   public static final Float FLOAT_MINUS_ONE = new Float(-1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stringToInt(String paramString) {
/*  108 */     return toInt(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int toInt(String paramString) {
/*  129 */     return toInt(paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stringToInt(String paramString, int paramInt) {
/*  151 */     return toInt(paramString, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int toInt(String paramString, int paramInt) {
/*  172 */     if (paramString == null) {
/*  173 */       return paramInt;
/*      */     }
/*      */     try {
/*  176 */       return Integer.parseInt(paramString);
/*  177 */     } catch (NumberFormatException numberFormatException) {
/*  178 */       return paramInt;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long toLong(String paramString) {
/*  200 */     return toLong(paramString, 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long toLong(String paramString, long paramLong) {
/*  221 */     if (paramString == null) {
/*  222 */       return paramLong;
/*      */     }
/*      */     try {
/*  225 */       return Long.parseLong(paramString);
/*  226 */     } catch (NumberFormatException numberFormatException) {
/*  227 */       return paramLong;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float toFloat(String paramString) {
/*  250 */     return toFloat(paramString, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float toFloat(String paramString, float paramFloat) {
/*  273 */     if (paramString == null) {
/*  274 */       return paramFloat;
/*      */     }
/*      */     try {
/*  277 */       return Float.parseFloat(paramString);
/*  278 */     } catch (NumberFormatException numberFormatException) {
/*  279 */       return paramFloat;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double toDouble(String paramString) {
/*  302 */     return toDouble(paramString, 0.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double toDouble(String paramString, double paramDouble) {
/*  325 */     if (paramString == null) {
/*  326 */       return paramDouble;
/*      */     }
/*      */     try {
/*  329 */       return Double.parseDouble(paramString);
/*  330 */     } catch (NumberFormatException numberFormatException) {
/*  331 */       return paramDouble;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte toByte(String paramString) {
/*  354 */     return toByte(paramString, (byte)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte toByte(String paramString, byte paramByte) {
/*  375 */     if (paramString == null) {
/*  376 */       return paramByte;
/*      */     }
/*      */     try {
/*  379 */       return Byte.parseByte(paramString);
/*  380 */     } catch (NumberFormatException numberFormatException) {
/*  381 */       return paramByte;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short toShort(String paramString) {
/*  403 */     return toShort(paramString, (short)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short toShort(String paramString, short paramShort) {
/*  424 */     if (paramString == null) {
/*  425 */       return paramShort;
/*      */     }
/*      */     try {
/*  428 */       return Short.parseShort(paramString);
/*  429 */     } catch (NumberFormatException numberFormatException) {
/*  430 */       return paramShort;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Number createNumber(String paramString) {
/*      */     String str1;
/*      */     Object object;
/*      */     String str2;
/*  497 */     if (paramString == null) {
/*  498 */       return null;
/*      */     }
/*  500 */     if (StringUtils.isBlank(paramString)) {
/*  501 */       throw new NumberFormatException("A blank string is not a valid number");
/*      */     }
/*  503 */     if (paramString.startsWith("--"))
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  508 */       return null;
/*      */     }
/*  510 */     if (paramString.startsWith("0x") || paramString.startsWith("-0x")) {
/*  511 */       return createInteger(paramString);
/*      */     }
/*  513 */     char c = paramString.charAt(paramString.length() - 1);
/*      */ 
/*      */ 
/*      */     
/*  517 */     int i = paramString.indexOf('.');
/*  518 */     int j = paramString.indexOf('e') + paramString.indexOf('E') + 1;
/*      */     
/*  520 */     if (i > -1) {
/*      */       
/*  522 */       if (j > -1) {
/*  523 */         if (j < i || j > paramString.length()) {
/*  524 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*      */         }
/*  526 */         object = paramString.substring(i + 1, j);
/*      */       } else {
/*  528 */         object = paramString.substring(i + 1);
/*      */       } 
/*  530 */       str1 = paramString.substring(0, i);
/*      */     } else {
/*  532 */       if (j > -1) {
/*  533 */         if (j > paramString.length()) {
/*  534 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*      */         }
/*  536 */         str1 = paramString.substring(0, j);
/*      */       } else {
/*  538 */         str1 = paramString;
/*      */       } 
/*  540 */       object = null;
/*      */     } 
/*  542 */     if (!Character.isDigit(c) && c != '.') {
/*  543 */       if (j > -1 && j < paramString.length() - 1) {
/*  544 */         str2 = paramString.substring(j + 1, paramString.length() - 1);
/*      */       } else {
/*  546 */         str2 = null;
/*      */       } 
/*      */       
/*  549 */       String str = paramString.substring(0, paramString.length() - 1);
/*  550 */       boolean bool1 = (isAllZeros(str1) && isAllZeros(str2)) ? true : false;
/*  551 */       switch (c) {
/*      */         case 'L':
/*      */         case 'l':
/*  554 */           if (object == null && str2 == null && ((str.charAt(0) == '-' && isDigits(str.substring(1))) || isDigits(str))) {
/*      */             
/*      */             try {
/*      */               
/*  558 */               return createLong(str);
/*  559 */             } catch (NumberFormatException numberFormatException) {
/*      */ 
/*      */               
/*  562 */               return createBigInteger(str);
/*      */             } 
/*      */           }
/*  565 */           throw new NumberFormatException(paramString + " is not a valid number.");
/*      */         case 'F':
/*      */         case 'f':
/*      */           try {
/*  569 */             Float float_ = createFloat(str);
/*  570 */             if (!float_.isInfinite() && (float_.floatValue() != 0.0F || bool1))
/*      */             {
/*      */               
/*  573 */               return float_;
/*      */             }
/*      */           }
/*  576 */           catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */ 
/*      */         
/*      */         case 'D':
/*      */         case 'd':
/*      */           try {
/*  583 */             Double double_ = createDouble(str);
/*  584 */             if (!double_.isInfinite() && (double_.floatValue() != 0.0D || bool1)) {
/*  585 */               return double_;
/*      */             }
/*  587 */           } catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */           
/*      */           try {
/*  591 */             return createBigDecimal(str);
/*  592 */           } catch (NumberFormatException numberFormatException) {
/*      */             break;
/*      */           } 
/*      */       } 
/*      */       
/*  597 */       throw new NumberFormatException(paramString + " is not a valid number.");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  603 */     if (j > -1 && j < paramString.length() - 1) {
/*  604 */       str2 = paramString.substring(j + 1, paramString.length());
/*      */     } else {
/*  606 */       str2 = null;
/*      */     } 
/*  608 */     if (object == null && str2 == null) {
/*      */       
/*      */       try {
/*  611 */         return createInteger(paramString);
/*  612 */       } catch (NumberFormatException numberFormatException) {
/*      */ 
/*      */         
/*      */         try {
/*  616 */           return createLong(paramString);
/*  617 */         } catch (NumberFormatException numberFormatException1) {
/*      */ 
/*      */           
/*  620 */           return createBigInteger(paramString);
/*      */         } 
/*      */       } 
/*      */     }
/*  624 */     boolean bool = (isAllZeros(str1) && isAllZeros(str2)) ? true : false;
/*      */     try {
/*  626 */       Float float_ = createFloat(paramString);
/*  627 */       if (!float_.isInfinite() && (float_.floatValue() != 0.0F || bool)) {
/*  628 */         return float_;
/*      */       }
/*  630 */     } catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */     
/*      */     try {
/*  634 */       Double double_ = createDouble(paramString);
/*  635 */       if (!double_.isInfinite() && (double_.doubleValue() != 0.0D || bool)) {
/*  636 */         return double_;
/*      */       }
/*  638 */     } catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */ 
/*      */     
/*  642 */     return createBigDecimal(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAllZeros(String paramString) {
/*  657 */     if (paramString == null) {
/*  658 */       return true;
/*      */     }
/*  660 */     for (int i = paramString.length() - 1; i >= 0; i--) {
/*  661 */       if (paramString.charAt(i) != '0') {
/*  662 */         return false;
/*      */       }
/*      */     } 
/*  665 */     return (paramString.length() > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Float createFloat(String paramString) {
/*  679 */     if (paramString == null) {
/*  680 */       return null;
/*      */     }
/*  682 */     return Float.valueOf(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Double createDouble(String paramString) {
/*  695 */     if (paramString == null) {
/*  696 */       return null;
/*      */     }
/*  698 */     return Double.valueOf(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Integer createInteger(String paramString) {
/*  712 */     if (paramString == null) {
/*  713 */       return null;
/*      */     }
/*      */     
/*  716 */     return Integer.decode(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Long createLong(String paramString) {
/*  729 */     if (paramString == null) {
/*  730 */       return null;
/*      */     }
/*  732 */     return Long.valueOf(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigInteger createBigInteger(String paramString) {
/*  745 */     if (paramString == null) {
/*  746 */       return null;
/*      */     }
/*  748 */     return new BigInteger(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal createBigDecimal(String paramString) {
/*  761 */     if (paramString == null) {
/*  762 */       return null;
/*      */     }
/*      */     
/*  765 */     if (StringUtils.isBlank(paramString)) {
/*  766 */       throw new NumberFormatException("A blank string is not a valid number");
/*      */     }
/*  768 */     return new BigDecimal(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long min(long[] paramArrayOflong) {
/*  783 */     if (paramArrayOflong == null)
/*  784 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  785 */     if (paramArrayOflong.length == 0) {
/*  786 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  790 */     long l = paramArrayOflong[0];
/*  791 */     for (byte b = 1; b < paramArrayOflong.length; b++) {
/*  792 */       if (paramArrayOflong[b] < l) {
/*  793 */         l = paramArrayOflong[b];
/*      */       }
/*      */     } 
/*      */     
/*  797 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int min(int[] paramArrayOfint) {
/*  810 */     if (paramArrayOfint == null)
/*  811 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  812 */     if (paramArrayOfint.length == 0) {
/*  813 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  817 */     int i = paramArrayOfint[0];
/*  818 */     for (byte b = 1; b < paramArrayOfint.length; b++) {
/*  819 */       if (paramArrayOfint[b] < i) {
/*  820 */         i = paramArrayOfint[b];
/*      */       }
/*      */     } 
/*      */     
/*  824 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short min(short[] paramArrayOfshort) {
/*  837 */     if (paramArrayOfshort == null)
/*  838 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  839 */     if (paramArrayOfshort.length == 0) {
/*  840 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  844 */     short s = paramArrayOfshort[0];
/*  845 */     for (byte b = 1; b < paramArrayOfshort.length; b++) {
/*  846 */       if (paramArrayOfshort[b] < s) {
/*  847 */         s = paramArrayOfshort[b];
/*      */       }
/*      */     } 
/*      */     
/*  851 */     return s;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte min(byte[] paramArrayOfbyte) {
/*  864 */     if (paramArrayOfbyte == null)
/*  865 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  866 */     if (paramArrayOfbyte.length == 0) {
/*  867 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  871 */     byte b = paramArrayOfbyte[0];
/*  872 */     for (byte b1 = 1; b1 < paramArrayOfbyte.length; b1++) {
/*  873 */       if (paramArrayOfbyte[b1] < b) {
/*  874 */         b = paramArrayOfbyte[b1];
/*      */       }
/*      */     } 
/*      */     
/*  878 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double min(double[] paramArrayOfdouble) {
/*  892 */     if (paramArrayOfdouble == null)
/*  893 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  894 */     if (paramArrayOfdouble.length == 0) {
/*  895 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  899 */     double d = paramArrayOfdouble[0];
/*  900 */     for (byte b = 1; b < paramArrayOfdouble.length; b++) {
/*  901 */       if (Double.isNaN(paramArrayOfdouble[b])) {
/*  902 */         return Double.NaN;
/*      */       }
/*  904 */       if (paramArrayOfdouble[b] < d) {
/*  905 */         d = paramArrayOfdouble[b];
/*      */       }
/*      */     } 
/*      */     
/*  909 */     return d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float min(float[] paramArrayOffloat) {
/*  923 */     if (paramArrayOffloat == null)
/*  924 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  925 */     if (paramArrayOffloat.length == 0) {
/*  926 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  930 */     float f = paramArrayOffloat[0];
/*  931 */     for (byte b = 1; b < paramArrayOffloat.length; b++) {
/*  932 */       if (Float.isNaN(paramArrayOffloat[b])) {
/*  933 */         return Float.NaN;
/*      */       }
/*  935 */       if (paramArrayOffloat[b] < f) {
/*  936 */         f = paramArrayOffloat[b];
/*      */       }
/*      */     } 
/*      */     
/*  940 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long max(long[] paramArrayOflong) {
/*  955 */     if (paramArrayOflong == null)
/*  956 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  957 */     if (paramArrayOflong.length == 0) {
/*  958 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  962 */     long l = paramArrayOflong[0];
/*  963 */     for (byte b = 1; b < paramArrayOflong.length; b++) {
/*  964 */       if (paramArrayOflong[b] > l) {
/*  965 */         l = paramArrayOflong[b];
/*      */       }
/*      */     } 
/*      */     
/*  969 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int max(int[] paramArrayOfint) {
/*  982 */     if (paramArrayOfint == null)
/*  983 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  984 */     if (paramArrayOfint.length == 0) {
/*  985 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  989 */     int i = paramArrayOfint[0];
/*  990 */     for (byte b = 1; b < paramArrayOfint.length; b++) {
/*  991 */       if (paramArrayOfint[b] > i) {
/*  992 */         i = paramArrayOfint[b];
/*      */       }
/*      */     } 
/*      */     
/*  996 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short max(short[] paramArrayOfshort) {
/* 1009 */     if (paramArrayOfshort == null)
/* 1010 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 1011 */     if (paramArrayOfshort.length == 0) {
/* 1012 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/* 1016 */     short s = paramArrayOfshort[0];
/* 1017 */     for (byte b = 1; b < paramArrayOfshort.length; b++) {
/* 1018 */       if (paramArrayOfshort[b] > s) {
/* 1019 */         s = paramArrayOfshort[b];
/*      */       }
/*      */     } 
/*      */     
/* 1023 */     return s;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte max(byte[] paramArrayOfbyte) {
/* 1036 */     if (paramArrayOfbyte == null)
/* 1037 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 1038 */     if (paramArrayOfbyte.length == 0) {
/* 1039 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/* 1043 */     byte b = paramArrayOfbyte[0];
/* 1044 */     for (byte b1 = 1; b1 < paramArrayOfbyte.length; b1++) {
/* 1045 */       if (paramArrayOfbyte[b1] > b) {
/* 1046 */         b = paramArrayOfbyte[b1];
/*      */       }
/*      */     } 
/*      */     
/* 1050 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double max(double[] paramArrayOfdouble) {
/* 1064 */     if (paramArrayOfdouble == null)
/* 1065 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 1066 */     if (paramArrayOfdouble.length == 0) {
/* 1067 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/* 1071 */     double d = paramArrayOfdouble[0];
/* 1072 */     for (byte b = 1; b < paramArrayOfdouble.length; b++) {
/* 1073 */       if (Double.isNaN(paramArrayOfdouble[b])) {
/* 1074 */         return Double.NaN;
/*      */       }
/* 1076 */       if (paramArrayOfdouble[b] > d) {
/* 1077 */         d = paramArrayOfdouble[b];
/*      */       }
/*      */     } 
/*      */     
/* 1081 */     return d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float max(float[] paramArrayOffloat) {
/* 1095 */     if (paramArrayOffloat == null)
/* 1096 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 1097 */     if (paramArrayOffloat.length == 0) {
/* 1098 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/* 1102 */     float f = paramArrayOffloat[0];
/* 1103 */     for (byte b = 1; b < paramArrayOffloat.length; b++) {
/* 1104 */       if (Float.isNaN(paramArrayOffloat[b])) {
/* 1105 */         return Float.NaN;
/*      */       }
/* 1107 */       if (paramArrayOffloat[b] > f) {
/* 1108 */         f = paramArrayOffloat[b];
/*      */       }
/*      */     } 
/*      */     
/* 1112 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long min(long paramLong1, long paramLong2, long paramLong3) {
/* 1126 */     if (paramLong2 < paramLong1) {
/* 1127 */       paramLong1 = paramLong2;
/*      */     }
/* 1129 */     if (paramLong3 < paramLong1) {
/* 1130 */       paramLong1 = paramLong3;
/*      */     }
/* 1132 */     return paramLong1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int min(int paramInt1, int paramInt2, int paramInt3) {
/* 1144 */     if (paramInt2 < paramInt1) {
/* 1145 */       paramInt1 = paramInt2;
/*      */     }
/* 1147 */     if (paramInt3 < paramInt1) {
/* 1148 */       paramInt1 = paramInt3;
/*      */     }
/* 1150 */     return paramInt1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short min(short paramShort1, short paramShort2, short paramShort3) {
/* 1162 */     if (paramShort2 < paramShort1) {
/* 1163 */       paramShort1 = paramShort2;
/*      */     }
/* 1165 */     if (paramShort3 < paramShort1) {
/* 1166 */       paramShort1 = paramShort3;
/*      */     }
/* 1168 */     return paramShort1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte min(byte paramByte1, byte paramByte2, byte paramByte3) {
/* 1180 */     if (paramByte2 < paramByte1) {
/* 1181 */       paramByte1 = paramByte2;
/*      */     }
/* 1183 */     if (paramByte3 < paramByte1) {
/* 1184 */       paramByte1 = paramByte3;
/*      */     }
/* 1186 */     return paramByte1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double min(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1202 */     return Math.min(Math.min(paramDouble1, paramDouble2), paramDouble3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float min(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1218 */     return Math.min(Math.min(paramFloat1, paramFloat2), paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long max(long paramLong1, long paramLong2, long paramLong3) {
/* 1232 */     if (paramLong2 > paramLong1) {
/* 1233 */       paramLong1 = paramLong2;
/*      */     }
/* 1235 */     if (paramLong3 > paramLong1) {
/* 1236 */       paramLong1 = paramLong3;
/*      */     }
/* 1238 */     return paramLong1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int max(int paramInt1, int paramInt2, int paramInt3) {
/* 1250 */     if (paramInt2 > paramInt1) {
/* 1251 */       paramInt1 = paramInt2;
/*      */     }
/* 1253 */     if (paramInt3 > paramInt1) {
/* 1254 */       paramInt1 = paramInt3;
/*      */     }
/* 1256 */     return paramInt1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short max(short paramShort1, short paramShort2, short paramShort3) {
/* 1268 */     if (paramShort2 > paramShort1) {
/* 1269 */       paramShort1 = paramShort2;
/*      */     }
/* 1271 */     if (paramShort3 > paramShort1) {
/* 1272 */       paramShort1 = paramShort3;
/*      */     }
/* 1274 */     return paramShort1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte max(byte paramByte1, byte paramByte2, byte paramByte3) {
/* 1286 */     if (paramByte2 > paramByte1) {
/* 1287 */       paramByte1 = paramByte2;
/*      */     }
/* 1289 */     if (paramByte3 > paramByte1) {
/* 1290 */       paramByte1 = paramByte3;
/*      */     }
/* 1292 */     return paramByte1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double max(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 1308 */     return Math.max(Math.max(paramDouble1, paramDouble2), paramDouble3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float max(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1324 */     return Math.max(Math.max(paramFloat1, paramFloat2), paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compare(double paramDouble1, double paramDouble2) {
/* 1363 */     if (paramDouble1 < paramDouble2) {
/* 1364 */       return -1;
/*      */     }
/* 1366 */     if (paramDouble1 > paramDouble2) {
/* 1367 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1373 */     long l1 = Double.doubleToLongBits(paramDouble1);
/* 1374 */     long l2 = Double.doubleToLongBits(paramDouble2);
/* 1375 */     if (l1 == l2) {
/* 1376 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1384 */     if (l1 < l2) {
/* 1385 */       return -1;
/*      */     }
/* 1387 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compare(float paramFloat1, float paramFloat2) {
/* 1424 */     if (paramFloat1 < paramFloat2) {
/* 1425 */       return -1;
/*      */     }
/* 1427 */     if (paramFloat1 > paramFloat2) {
/* 1428 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1434 */     int i = Float.floatToIntBits(paramFloat1);
/* 1435 */     int j = Float.floatToIntBits(paramFloat2);
/* 1436 */     if (i == j) {
/* 1437 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1445 */     if (i < j) {
/* 1446 */       return -1;
/*      */     }
/* 1448 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isDigits(String paramString) {
/* 1464 */     if (StringUtils.isEmpty(paramString)) {
/* 1465 */       return false;
/*      */     }
/* 1467 */     for (byte b = 0; b < paramString.length(); b++) {
/* 1468 */       if (!Character.isDigit(paramString.charAt(b))) {
/* 1469 */         return false;
/*      */       }
/*      */     } 
/* 1472 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNumber(String paramString) {
/* 1489 */     if (StringUtils.isEmpty(paramString)) {
/* 1490 */       return false;
/*      */     }
/* 1492 */     char[] arrayOfChar = paramString.toCharArray();
/* 1493 */     int i = arrayOfChar.length;
/* 1494 */     boolean bool1 = false;
/* 1495 */     boolean bool2 = false;
/* 1496 */     boolean bool3 = false;
/* 1497 */     boolean bool4 = false;
/*      */     
/* 1499 */     byte b1 = (arrayOfChar[0] == '-') ? 1 : 0;
/* 1500 */     if (i > b1 + 1 && 
/* 1501 */       arrayOfChar[b1] == '0' && arrayOfChar[b1 + 1] == 'x') {
/* 1502 */       int j = b1 + 2;
/* 1503 */       if (j == i) {
/* 1504 */         return false;
/*      */       }
/*      */       
/* 1507 */       for (; j < arrayOfChar.length; j++) {
/* 1508 */         if ((arrayOfChar[j] < '0' || arrayOfChar[j] > '9') && (arrayOfChar[j] < 'a' || arrayOfChar[j] > 'f') && (arrayOfChar[j] < 'A' || arrayOfChar[j] > 'F'))
/*      */         {
/*      */           
/* 1511 */           return false;
/*      */         }
/*      */       } 
/* 1514 */       return true;
/*      */     } 
/*      */     
/* 1517 */     i--;
/*      */     
/* 1519 */     byte b2 = b1;
/*      */ 
/*      */     
/* 1522 */     while (b2 < i || (b2 < i + 1 && bool3 && !bool4)) {
/* 1523 */       if (arrayOfChar[b2] >= '0' && arrayOfChar[b2] <= '9') {
/* 1524 */         bool4 = true;
/* 1525 */         bool3 = false;
/*      */       }
/* 1527 */       else if (arrayOfChar[b2] == '.') {
/* 1528 */         if (bool2 || bool1)
/*      */         {
/* 1530 */           return false;
/*      */         }
/* 1532 */         bool2 = true;
/* 1533 */       } else if (arrayOfChar[b2] == 'e' || arrayOfChar[b2] == 'E') {
/*      */         
/* 1535 */         if (bool1)
/*      */         {
/* 1537 */           return false;
/*      */         }
/* 1539 */         if (!bool4) {
/* 1540 */           return false;
/*      */         }
/* 1542 */         bool1 = true;
/* 1543 */         bool3 = true;
/* 1544 */       } else if (arrayOfChar[b2] == '+' || arrayOfChar[b2] == '-') {
/* 1545 */         if (!bool3) {
/* 1546 */           return false;
/*      */         }
/* 1548 */         bool3 = false;
/* 1549 */         bool4 = false;
/*      */       } else {
/* 1551 */         return false;
/*      */       } 
/* 1553 */       b2++;
/*      */     } 
/* 1555 */     if (b2 < arrayOfChar.length) {
/* 1556 */       if (arrayOfChar[b2] >= '0' && arrayOfChar[b2] <= '9')
/*      */       {
/* 1558 */         return true;
/*      */       }
/* 1560 */       if (arrayOfChar[b2] == 'e' || arrayOfChar[b2] == 'E')
/*      */       {
/* 1562 */         return false;
/*      */       }
/* 1564 */       if (arrayOfChar[b2] == '.') {
/* 1565 */         if (bool2 || bool1)
/*      */         {
/* 1567 */           return false;
/*      */         }
/*      */         
/* 1570 */         return bool4;
/*      */       } 
/* 1572 */       if (!bool3 && (arrayOfChar[b2] == 'd' || arrayOfChar[b2] == 'D' || arrayOfChar[b2] == 'f' || arrayOfChar[b2] == 'F'))
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 1577 */         return bool4;
/*      */       }
/* 1579 */       if (arrayOfChar[b2] == 'l' || arrayOfChar[b2] == 'L')
/*      */       {
/*      */         
/* 1582 */         return (bool4 && !bool1);
/*      */       }
/*      */       
/* 1585 */       return false;
/*      */     } 
/*      */ 
/*      */     
/* 1589 */     return (!bool3 && bool4);
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/NumberUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */