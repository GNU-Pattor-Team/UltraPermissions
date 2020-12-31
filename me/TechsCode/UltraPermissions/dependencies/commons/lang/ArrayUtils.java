/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.builder.EqualsBuilder;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.builder.HashCodeBuilder;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.builder.ToStringBuilder;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.builder.ToStringStyle;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ArrayUtils
/*      */ {
/*   56 */   public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
/*      */ 
/*      */ 
/*      */   
/*   60 */   public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
/*      */ 
/*      */ 
/*      */   
/*   64 */   public static final String[] EMPTY_STRING_ARRAY = new String[0];
/*      */ 
/*      */ 
/*      */   
/*   68 */   public static final long[] EMPTY_LONG_ARRAY = new long[0];
/*      */ 
/*      */ 
/*      */   
/*   72 */   public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
/*      */ 
/*      */ 
/*      */   
/*   76 */   public static final int[] EMPTY_INT_ARRAY = new int[0];
/*      */ 
/*      */ 
/*      */   
/*   80 */   public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
/*      */ 
/*      */ 
/*      */   
/*   84 */   public static final short[] EMPTY_SHORT_ARRAY = new short[0];
/*      */ 
/*      */ 
/*      */   
/*   88 */   public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
/*      */ 
/*      */ 
/*      */   
/*   92 */   public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*      */ 
/*      */ 
/*      */   
/*   96 */   public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
/*      */ 
/*      */ 
/*      */   
/*  100 */   public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
/*      */ 
/*      */ 
/*      */   
/*  104 */   public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
/*      */ 
/*      */ 
/*      */   
/*  108 */   public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
/*      */ 
/*      */ 
/*      */   
/*  112 */   public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
/*      */ 
/*      */ 
/*      */   
/*  116 */   public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
/*      */ 
/*      */ 
/*      */   
/*  120 */   public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
/*      */ 
/*      */ 
/*      */   
/*  124 */   public static final char[] EMPTY_CHAR_ARRAY = new char[0];
/*      */ 
/*      */ 
/*      */   
/*  128 */   public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int INDEX_NOT_FOUND = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(Object paramObject) {
/*  162 */     return toString(paramObject, "{}");
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
/*      */   public static String toString(Object paramObject, String paramString) {
/*  178 */     if (paramObject == null) {
/*  179 */       return paramString;
/*      */     }
/*  181 */     return (new ToStringBuilder(paramObject, ToStringStyle.SIMPLE_STYLE)).append(paramObject).toString();
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
/*      */   public static int hashCode(Object paramObject) {
/*  193 */     return (new HashCodeBuilder()).append(paramObject).toHashCode();
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
/*      */   public static boolean isEquals(Object paramObject1, Object paramObject2) {
/*  207 */     return (new EqualsBuilder()).append(paramObject1, paramObject2).isEquals();
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
/*      */   public static Map toMap(Object[] paramArrayOfObject) {
/*  238 */     if (paramArrayOfObject == null) {
/*  239 */       return null;
/*      */     }
/*  241 */     HashMap hashMap = new HashMap((int)(paramArrayOfObject.length * 1.5D));
/*  242 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*  243 */       Object object = paramArrayOfObject[b];
/*  244 */       if (object instanceof Map.Entry) {
/*  245 */         Map.Entry entry = (Map.Entry)object;
/*  246 */         hashMap.put(entry.getKey(), entry.getValue());
/*  247 */       } else if (object instanceof Object[]) {
/*  248 */         Object[] arrayOfObject = (Object[])object;
/*  249 */         if (arrayOfObject.length < 2) {
/*  250 */           throw new IllegalArgumentException("Array element " + b + ", '" + object + "', has a length less than 2");
/*      */         }
/*      */ 
/*      */         
/*  254 */         hashMap.put(arrayOfObject[0], arrayOfObject[1]);
/*      */       } else {
/*  256 */         throw new IllegalArgumentException("Array element " + b + ", '" + object + "', is neither of type Map.Entry nor an Array");
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  261 */     return hashMap;
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
/*      */   public static Object[] clone(Object[] paramArrayOfObject) {
/*  279 */     if (paramArrayOfObject == null) {
/*  280 */       return null;
/*      */     }
/*  282 */     return (Object[])paramArrayOfObject.clone();
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
/*      */   public static long[] clone(long[] paramArrayOflong) {
/*  295 */     if (paramArrayOflong == null) {
/*  296 */       return null;
/*      */     }
/*  298 */     return (long[])paramArrayOflong.clone();
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
/*      */   public static int[] clone(int[] paramArrayOfint) {
/*  311 */     if (paramArrayOfint == null) {
/*  312 */       return null;
/*      */     }
/*  314 */     return (int[])paramArrayOfint.clone();
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
/*      */   public static short[] clone(short[] paramArrayOfshort) {
/*  327 */     if (paramArrayOfshort == null) {
/*  328 */       return null;
/*      */     }
/*  330 */     return (short[])paramArrayOfshort.clone();
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
/*      */   public static char[] clone(char[] paramArrayOfchar) {
/*  343 */     if (paramArrayOfchar == null) {
/*  344 */       return null;
/*      */     }
/*  346 */     return (char[])paramArrayOfchar.clone();
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
/*      */   public static byte[] clone(byte[] paramArrayOfbyte) {
/*  359 */     if (paramArrayOfbyte == null) {
/*  360 */       return null;
/*      */     }
/*  362 */     return (byte[])paramArrayOfbyte.clone();
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
/*      */   public static double[] clone(double[] paramArrayOfdouble) {
/*  375 */     if (paramArrayOfdouble == null) {
/*  376 */       return null;
/*      */     }
/*  378 */     return (double[])paramArrayOfdouble.clone();
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
/*      */   public static float[] clone(float[] paramArrayOffloat) {
/*  391 */     if (paramArrayOffloat == null) {
/*  392 */       return null;
/*      */     }
/*  394 */     return (float[])paramArrayOffloat.clone();
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
/*      */   public static boolean[] clone(boolean[] paramArrayOfboolean) {
/*  407 */     if (paramArrayOfboolean == null) {
/*  408 */       return null;
/*      */     }
/*  410 */     return (boolean[])paramArrayOfboolean.clone();
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
/*      */   public static Object[] nullToEmpty(Object[] paramArrayOfObject) {
/*  429 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/*  430 */       return EMPTY_OBJECT_ARRAY;
/*      */     }
/*  432 */     return paramArrayOfObject;
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
/*      */   public static String[] nullToEmpty(String[] paramArrayOfString) {
/*  449 */     if (paramArrayOfString == null || paramArrayOfString.length == 0) {
/*  450 */       return EMPTY_STRING_ARRAY;
/*      */     }
/*  452 */     return paramArrayOfString;
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
/*      */   public static long[] nullToEmpty(long[] paramArrayOflong) {
/*  469 */     if (paramArrayOflong == null || paramArrayOflong.length == 0) {
/*  470 */       return EMPTY_LONG_ARRAY;
/*      */     }
/*  472 */     return paramArrayOflong;
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
/*      */   public static int[] nullToEmpty(int[] paramArrayOfint) {
/*  489 */     if (paramArrayOfint == null || paramArrayOfint.length == 0) {
/*  490 */       return EMPTY_INT_ARRAY;
/*      */     }
/*  492 */     return paramArrayOfint;
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
/*      */   public static short[] nullToEmpty(short[] paramArrayOfshort) {
/*  509 */     if (paramArrayOfshort == null || paramArrayOfshort.length == 0) {
/*  510 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/*  512 */     return paramArrayOfshort;
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
/*      */   public static char[] nullToEmpty(char[] paramArrayOfchar) {
/*  529 */     if (paramArrayOfchar == null || paramArrayOfchar.length == 0) {
/*  530 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/*  532 */     return paramArrayOfchar;
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
/*      */   public static byte[] nullToEmpty(byte[] paramArrayOfbyte) {
/*  549 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/*  550 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/*  552 */     return paramArrayOfbyte;
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
/*      */   public static double[] nullToEmpty(double[] paramArrayOfdouble) {
/*  569 */     if (paramArrayOfdouble == null || paramArrayOfdouble.length == 0) {
/*  570 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/*  572 */     return paramArrayOfdouble;
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
/*      */   public static float[] nullToEmpty(float[] paramArrayOffloat) {
/*  589 */     if (paramArrayOffloat == null || paramArrayOffloat.length == 0) {
/*  590 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/*  592 */     return paramArrayOffloat;
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
/*      */   public static boolean[] nullToEmpty(boolean[] paramArrayOfboolean) {
/*  609 */     if (paramArrayOfboolean == null || paramArrayOfboolean.length == 0) {
/*  610 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/*  612 */     return paramArrayOfboolean;
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
/*      */   public static Long[] nullToEmpty(Long[] paramArrayOfLong) {
/*  629 */     if (paramArrayOfLong == null || paramArrayOfLong.length == 0) {
/*  630 */       return EMPTY_LONG_OBJECT_ARRAY;
/*      */     }
/*  632 */     return paramArrayOfLong;
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
/*      */   public static Integer[] nullToEmpty(Integer[] paramArrayOfInteger) {
/*  649 */     if (paramArrayOfInteger == null || paramArrayOfInteger.length == 0) {
/*  650 */       return EMPTY_INTEGER_OBJECT_ARRAY;
/*      */     }
/*  652 */     return paramArrayOfInteger;
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
/*      */   public static Short[] nullToEmpty(Short[] paramArrayOfShort) {
/*  669 */     if (paramArrayOfShort == null || paramArrayOfShort.length == 0) {
/*  670 */       return EMPTY_SHORT_OBJECT_ARRAY;
/*      */     }
/*  672 */     return paramArrayOfShort;
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
/*      */   public static Character[] nullToEmpty(Character[] paramArrayOfCharacter) {
/*  689 */     if (paramArrayOfCharacter == null || paramArrayOfCharacter.length == 0) {
/*  690 */       return EMPTY_CHARACTER_OBJECT_ARRAY;
/*      */     }
/*  692 */     return paramArrayOfCharacter;
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
/*      */   public static Byte[] nullToEmpty(Byte[] paramArrayOfByte) {
/*  709 */     if (paramArrayOfByte == null || paramArrayOfByte.length == 0) {
/*  710 */       return EMPTY_BYTE_OBJECT_ARRAY;
/*      */     }
/*  712 */     return paramArrayOfByte;
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
/*      */   public static Double[] nullToEmpty(Double[] paramArrayOfDouble) {
/*  729 */     if (paramArrayOfDouble == null || paramArrayOfDouble.length == 0) {
/*  730 */       return EMPTY_DOUBLE_OBJECT_ARRAY;
/*      */     }
/*  732 */     return paramArrayOfDouble;
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
/*      */   public static Float[] nullToEmpty(Float[] paramArrayOfFloat) {
/*  749 */     if (paramArrayOfFloat == null || paramArrayOfFloat.length == 0) {
/*  750 */       return EMPTY_FLOAT_OBJECT_ARRAY;
/*      */     }
/*  752 */     return paramArrayOfFloat;
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
/*      */   public static Boolean[] nullToEmpty(Boolean[] paramArrayOfBoolean) {
/*  769 */     if (paramArrayOfBoolean == null || paramArrayOfBoolean.length == 0) {
/*  770 */       return EMPTY_BOOLEAN_OBJECT_ARRAY;
/*      */     }
/*  772 */     return paramArrayOfBoolean;
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
/*      */   public static Object[] subarray(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/*  805 */     if (paramArrayOfObject == null) {
/*  806 */       return null;
/*      */     }
/*  808 */     if (paramInt1 < 0) {
/*  809 */       paramInt1 = 0;
/*      */     }
/*  811 */     if (paramInt2 > paramArrayOfObject.length) {
/*  812 */       paramInt2 = paramArrayOfObject.length;
/*      */     }
/*  814 */     int i = paramInt2 - paramInt1;
/*  815 */     Class clazz = paramArrayOfObject.getClass().getComponentType();
/*  816 */     if (i <= 0) {
/*  817 */       return (Object[])Array.newInstance(clazz, 0);
/*      */     }
/*  819 */     Object[] arrayOfObject = (Object[])Array.newInstance(clazz, i);
/*  820 */     System.arraycopy(paramArrayOfObject, paramInt1, arrayOfObject, 0, i);
/*  821 */     return arrayOfObject;
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
/*      */   public static long[] subarray(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/*  844 */     if (paramArrayOflong == null) {
/*  845 */       return null;
/*      */     }
/*  847 */     if (paramInt1 < 0) {
/*  848 */       paramInt1 = 0;
/*      */     }
/*  850 */     if (paramInt2 > paramArrayOflong.length) {
/*  851 */       paramInt2 = paramArrayOflong.length;
/*      */     }
/*  853 */     int i = paramInt2 - paramInt1;
/*  854 */     if (i <= 0) {
/*  855 */       return EMPTY_LONG_ARRAY;
/*      */     }
/*      */     
/*  858 */     long[] arrayOfLong = new long[i];
/*  859 */     System.arraycopy(paramArrayOflong, paramInt1, arrayOfLong, 0, i);
/*  860 */     return arrayOfLong;
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
/*      */   public static int[] subarray(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  883 */     if (paramArrayOfint == null) {
/*  884 */       return null;
/*      */     }
/*  886 */     if (paramInt1 < 0) {
/*  887 */       paramInt1 = 0;
/*      */     }
/*  889 */     if (paramInt2 > paramArrayOfint.length) {
/*  890 */       paramInt2 = paramArrayOfint.length;
/*      */     }
/*  892 */     int i = paramInt2 - paramInt1;
/*  893 */     if (i <= 0) {
/*  894 */       return EMPTY_INT_ARRAY;
/*      */     }
/*      */     
/*  897 */     int[] arrayOfInt = new int[i];
/*  898 */     System.arraycopy(paramArrayOfint, paramInt1, arrayOfInt, 0, i);
/*  899 */     return arrayOfInt;
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
/*      */   public static short[] subarray(short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  922 */     if (paramArrayOfshort == null) {
/*  923 */       return null;
/*      */     }
/*  925 */     if (paramInt1 < 0) {
/*  926 */       paramInt1 = 0;
/*      */     }
/*  928 */     if (paramInt2 > paramArrayOfshort.length) {
/*  929 */       paramInt2 = paramArrayOfshort.length;
/*      */     }
/*  931 */     int i = paramInt2 - paramInt1;
/*  932 */     if (i <= 0) {
/*  933 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/*      */     
/*  936 */     short[] arrayOfShort = new short[i];
/*  937 */     System.arraycopy(paramArrayOfshort, paramInt1, arrayOfShort, 0, i);
/*  938 */     return arrayOfShort;
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
/*      */   public static char[] subarray(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  961 */     if (paramArrayOfchar == null) {
/*  962 */       return null;
/*      */     }
/*  964 */     if (paramInt1 < 0) {
/*  965 */       paramInt1 = 0;
/*      */     }
/*  967 */     if (paramInt2 > paramArrayOfchar.length) {
/*  968 */       paramInt2 = paramArrayOfchar.length;
/*      */     }
/*  970 */     int i = paramInt2 - paramInt1;
/*  971 */     if (i <= 0) {
/*  972 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/*      */     
/*  975 */     char[] arrayOfChar = new char[i];
/*  976 */     System.arraycopy(paramArrayOfchar, paramInt1, arrayOfChar, 0, i);
/*  977 */     return arrayOfChar;
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
/*      */   public static byte[] subarray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 1000 */     if (paramArrayOfbyte == null) {
/* 1001 */       return null;
/*      */     }
/* 1003 */     if (paramInt1 < 0) {
/* 1004 */       paramInt1 = 0;
/*      */     }
/* 1006 */     if (paramInt2 > paramArrayOfbyte.length) {
/* 1007 */       paramInt2 = paramArrayOfbyte.length;
/*      */     }
/* 1009 */     int i = paramInt2 - paramInt1;
/* 1010 */     if (i <= 0) {
/* 1011 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/*      */     
/* 1014 */     byte[] arrayOfByte = new byte[i];
/* 1015 */     System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, i);
/* 1016 */     return arrayOfByte;
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
/*      */   public static double[] subarray(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 1039 */     if (paramArrayOfdouble == null) {
/* 1040 */       return null;
/*      */     }
/* 1042 */     if (paramInt1 < 0) {
/* 1043 */       paramInt1 = 0;
/*      */     }
/* 1045 */     if (paramInt2 > paramArrayOfdouble.length) {
/* 1046 */       paramInt2 = paramArrayOfdouble.length;
/*      */     }
/* 1048 */     int i = paramInt2 - paramInt1;
/* 1049 */     if (i <= 0) {
/* 1050 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/*      */     
/* 1053 */     double[] arrayOfDouble = new double[i];
/* 1054 */     System.arraycopy(paramArrayOfdouble, paramInt1, arrayOfDouble, 0, i);
/* 1055 */     return arrayOfDouble;
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
/*      */   public static float[] subarray(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/* 1078 */     if (paramArrayOffloat == null) {
/* 1079 */       return null;
/*      */     }
/* 1081 */     if (paramInt1 < 0) {
/* 1082 */       paramInt1 = 0;
/*      */     }
/* 1084 */     if (paramInt2 > paramArrayOffloat.length) {
/* 1085 */       paramInt2 = paramArrayOffloat.length;
/*      */     }
/* 1087 */     int i = paramInt2 - paramInt1;
/* 1088 */     if (i <= 0) {
/* 1089 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/*      */     
/* 1092 */     float[] arrayOfFloat = new float[i];
/* 1093 */     System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, 0, i);
/* 1094 */     return arrayOfFloat;
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
/*      */   public static boolean[] subarray(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
/* 1117 */     if (paramArrayOfboolean == null) {
/* 1118 */       return null;
/*      */     }
/* 1120 */     if (paramInt1 < 0) {
/* 1121 */       paramInt1 = 0;
/*      */     }
/* 1123 */     if (paramInt2 > paramArrayOfboolean.length) {
/* 1124 */       paramInt2 = paramArrayOfboolean.length;
/*      */     }
/* 1126 */     int i = paramInt2 - paramInt1;
/* 1127 */     if (i <= 0) {
/* 1128 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/*      */     
/* 1131 */     boolean[] arrayOfBoolean = new boolean[i];
/* 1132 */     System.arraycopy(paramArrayOfboolean, paramInt1, arrayOfBoolean, 0, i);
/* 1133 */     return arrayOfBoolean;
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
/*      */   public static boolean isSameLength(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/* 1150 */     if ((paramArrayOfObject1 == null && paramArrayOfObject2 != null && paramArrayOfObject2.length > 0) || (paramArrayOfObject2 == null && paramArrayOfObject1 != null && paramArrayOfObject1.length > 0) || (paramArrayOfObject1 != null && paramArrayOfObject2 != null && paramArrayOfObject1.length != paramArrayOfObject2.length))
/*      */     {
/*      */       
/* 1153 */       return false;
/*      */     }
/* 1155 */     return true;
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
/*      */   public static boolean isSameLength(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 1168 */     if ((paramArrayOflong1 == null && paramArrayOflong2 != null && paramArrayOflong2.length > 0) || (paramArrayOflong2 == null && paramArrayOflong1 != null && paramArrayOflong1.length > 0) || (paramArrayOflong1 != null && paramArrayOflong2 != null && paramArrayOflong1.length != paramArrayOflong2.length))
/*      */     {
/*      */       
/* 1171 */       return false;
/*      */     }
/* 1173 */     return true;
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
/*      */   public static boolean isSameLength(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 1186 */     if ((paramArrayOfint1 == null && paramArrayOfint2 != null && paramArrayOfint2.length > 0) || (paramArrayOfint2 == null && paramArrayOfint1 != null && paramArrayOfint1.length > 0) || (paramArrayOfint1 != null && paramArrayOfint2 != null && paramArrayOfint1.length != paramArrayOfint2.length))
/*      */     {
/*      */       
/* 1189 */       return false;
/*      */     }
/* 1191 */     return true;
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
/*      */   public static boolean isSameLength(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/* 1204 */     if ((paramArrayOfshort1 == null && paramArrayOfshort2 != null && paramArrayOfshort2.length > 0) || (paramArrayOfshort2 == null && paramArrayOfshort1 != null && paramArrayOfshort1.length > 0) || (paramArrayOfshort1 != null && paramArrayOfshort2 != null && paramArrayOfshort1.length != paramArrayOfshort2.length))
/*      */     {
/*      */       
/* 1207 */       return false;
/*      */     }
/* 1209 */     return true;
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
/*      */   public static boolean isSameLength(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/* 1222 */     if ((paramArrayOfchar1 == null && paramArrayOfchar2 != null && paramArrayOfchar2.length > 0) || (paramArrayOfchar2 == null && paramArrayOfchar1 != null && paramArrayOfchar1.length > 0) || (paramArrayOfchar1 != null && paramArrayOfchar2 != null && paramArrayOfchar1.length != paramArrayOfchar2.length))
/*      */     {
/*      */       
/* 1225 */       return false;
/*      */     }
/* 1227 */     return true;
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
/*      */   public static boolean isSameLength(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 1240 */     if ((paramArrayOfbyte1 == null && paramArrayOfbyte2 != null && paramArrayOfbyte2.length > 0) || (paramArrayOfbyte2 == null && paramArrayOfbyte1 != null && paramArrayOfbyte1.length > 0) || (paramArrayOfbyte1 != null && paramArrayOfbyte2 != null && paramArrayOfbyte1.length != paramArrayOfbyte2.length))
/*      */     {
/*      */       
/* 1243 */       return false;
/*      */     }
/* 1245 */     return true;
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
/*      */   public static boolean isSameLength(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/* 1258 */     if ((paramArrayOfdouble1 == null && paramArrayOfdouble2 != null && paramArrayOfdouble2.length > 0) || (paramArrayOfdouble2 == null && paramArrayOfdouble1 != null && paramArrayOfdouble1.length > 0) || (paramArrayOfdouble1 != null && paramArrayOfdouble2 != null && paramArrayOfdouble1.length != paramArrayOfdouble2.length))
/*      */     {
/*      */       
/* 1261 */       return false;
/*      */     }
/* 1263 */     return true;
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
/*      */   public static boolean isSameLength(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 1276 */     if ((paramArrayOffloat1 == null && paramArrayOffloat2 != null && paramArrayOffloat2.length > 0) || (paramArrayOffloat2 == null && paramArrayOffloat1 != null && paramArrayOffloat1.length > 0) || (paramArrayOffloat1 != null && paramArrayOffloat2 != null && paramArrayOffloat1.length != paramArrayOffloat2.length))
/*      */     {
/*      */       
/* 1279 */       return false;
/*      */     }
/* 1281 */     return true;
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
/*      */   public static boolean isSameLength(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 1294 */     if ((paramArrayOfboolean1 == null && paramArrayOfboolean2 != null && paramArrayOfboolean2.length > 0) || (paramArrayOfboolean2 == null && paramArrayOfboolean1 != null && paramArrayOfboolean1.length > 0) || (paramArrayOfboolean1 != null && paramArrayOfboolean2 != null && paramArrayOfboolean1.length != paramArrayOfboolean2.length))
/*      */     {
/*      */       
/* 1297 */       return false;
/*      */     }
/* 1299 */     return true;
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
/*      */   public static int getLength(Object paramObject) {
/* 1324 */     if (paramObject == null) {
/* 1325 */       return 0;
/*      */     }
/* 1327 */     return Array.getLength(paramObject);
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
/*      */   public static boolean isSameType(Object paramObject1, Object paramObject2) {
/* 1340 */     if (paramObject1 == null || paramObject2 == null) {
/* 1341 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/* 1343 */     return paramObject1.getClass().getName().equals(paramObject2.getClass().getName());
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
/*      */   public static void reverse(Object[] paramArrayOfObject) {
/* 1358 */     if (paramArrayOfObject == null) {
/*      */       return;
/*      */     }
/* 1361 */     byte b = 0;
/* 1362 */     int i = paramArrayOfObject.length - 1;
/*      */     
/* 1364 */     while (i > b) {
/* 1365 */       Object object = paramArrayOfObject[i];
/* 1366 */       paramArrayOfObject[i] = paramArrayOfObject[b];
/* 1367 */       paramArrayOfObject[b] = object;
/* 1368 */       i--;
/* 1369 */       b++;
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
/*      */   public static void reverse(long[] paramArrayOflong) {
/* 1381 */     if (paramArrayOflong == null) {
/*      */       return;
/*      */     }
/* 1384 */     byte b = 0;
/* 1385 */     int i = paramArrayOflong.length - 1;
/*      */     
/* 1387 */     while (i > b) {
/* 1388 */       long l = paramArrayOflong[i];
/* 1389 */       paramArrayOflong[i] = paramArrayOflong[b];
/* 1390 */       paramArrayOflong[b] = l;
/* 1391 */       i--;
/* 1392 */       b++;
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
/*      */   public static void reverse(int[] paramArrayOfint) {
/* 1404 */     if (paramArrayOfint == null) {
/*      */       return;
/*      */     }
/* 1407 */     byte b = 0;
/* 1408 */     int i = paramArrayOfint.length - 1;
/*      */     
/* 1410 */     while (i > b) {
/* 1411 */       int j = paramArrayOfint[i];
/* 1412 */       paramArrayOfint[i] = paramArrayOfint[b];
/* 1413 */       paramArrayOfint[b] = j;
/* 1414 */       i--;
/* 1415 */       b++;
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
/*      */   public static void reverse(short[] paramArrayOfshort) {
/* 1427 */     if (paramArrayOfshort == null) {
/*      */       return;
/*      */     }
/* 1430 */     byte b = 0;
/* 1431 */     int i = paramArrayOfshort.length - 1;
/*      */     
/* 1433 */     while (i > b) {
/* 1434 */       short s = paramArrayOfshort[i];
/* 1435 */       paramArrayOfshort[i] = paramArrayOfshort[b];
/* 1436 */       paramArrayOfshort[b] = s;
/* 1437 */       i--;
/* 1438 */       b++;
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
/*      */   public static void reverse(char[] paramArrayOfchar) {
/* 1450 */     if (paramArrayOfchar == null) {
/*      */       return;
/*      */     }
/* 1453 */     byte b = 0;
/* 1454 */     int i = paramArrayOfchar.length - 1;
/*      */     
/* 1456 */     while (i > b) {
/* 1457 */       char c = paramArrayOfchar[i];
/* 1458 */       paramArrayOfchar[i] = paramArrayOfchar[b];
/* 1459 */       paramArrayOfchar[b] = c;
/* 1460 */       i--;
/* 1461 */       b++;
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
/*      */   public static void reverse(byte[] paramArrayOfbyte) {
/* 1473 */     if (paramArrayOfbyte == null) {
/*      */       return;
/*      */     }
/* 1476 */     byte b = 0;
/* 1477 */     int i = paramArrayOfbyte.length - 1;
/*      */     
/* 1479 */     while (i > b) {
/* 1480 */       byte b1 = paramArrayOfbyte[i];
/* 1481 */       paramArrayOfbyte[i] = paramArrayOfbyte[b];
/* 1482 */       paramArrayOfbyte[b] = b1;
/* 1483 */       i--;
/* 1484 */       b++;
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
/*      */   public static void reverse(double[] paramArrayOfdouble) {
/* 1496 */     if (paramArrayOfdouble == null) {
/*      */       return;
/*      */     }
/* 1499 */     byte b = 0;
/* 1500 */     int i = paramArrayOfdouble.length - 1;
/*      */     
/* 1502 */     while (i > b) {
/* 1503 */       double d = paramArrayOfdouble[i];
/* 1504 */       paramArrayOfdouble[i] = paramArrayOfdouble[b];
/* 1505 */       paramArrayOfdouble[b] = d;
/* 1506 */       i--;
/* 1507 */       b++;
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
/*      */   public static void reverse(float[] paramArrayOffloat) {
/* 1519 */     if (paramArrayOffloat == null) {
/*      */       return;
/*      */     }
/* 1522 */     byte b = 0;
/* 1523 */     int i = paramArrayOffloat.length - 1;
/*      */     
/* 1525 */     while (i > b) {
/* 1526 */       float f = paramArrayOffloat[i];
/* 1527 */       paramArrayOffloat[i] = paramArrayOffloat[b];
/* 1528 */       paramArrayOffloat[b] = f;
/* 1529 */       i--;
/* 1530 */       b++;
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
/*      */   public static void reverse(boolean[] paramArrayOfboolean) {
/* 1542 */     if (paramArrayOfboolean == null) {
/*      */       return;
/*      */     }
/* 1545 */     byte b = 0;
/* 1546 */     int i = paramArrayOfboolean.length - 1;
/*      */     
/* 1548 */     while (i > b) {
/* 1549 */       boolean bool = paramArrayOfboolean[i];
/* 1550 */       paramArrayOfboolean[i] = paramArrayOfboolean[b];
/* 1551 */       paramArrayOfboolean[b] = bool;
/* 1552 */       i--;
/* 1553 */       b++;
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
/*      */   public static int indexOf(Object[] paramArrayOfObject, Object paramObject) {
/* 1573 */     return indexOf(paramArrayOfObject, paramObject, 0);
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
/*      */   public static int indexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt) {
/* 1591 */     if (paramArrayOfObject == null) {
/* 1592 */       return -1;
/*      */     }
/* 1594 */     if (paramInt < 0) {
/* 1595 */       paramInt = 0;
/*      */     }
/* 1597 */     if (paramObject == null) {
/* 1598 */       for (int i = paramInt; i < paramArrayOfObject.length; i++) {
/* 1599 */         if (paramArrayOfObject[i] == null) {
/* 1600 */           return i;
/*      */         }
/*      */       } 
/* 1603 */     } else if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
/* 1604 */       for (int i = paramInt; i < paramArrayOfObject.length; i++) {
/* 1605 */         if (paramObject.equals(paramArrayOfObject[i])) {
/* 1606 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/* 1610 */     return -1;
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
/*      */   public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject) {
/* 1624 */     return lastIndexOf(paramArrayOfObject, paramObject, 2147483647);
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
/*      */   public static int lastIndexOf(Object[] paramArrayOfObject, Object paramObject, int paramInt) {
/* 1642 */     if (paramArrayOfObject == null) {
/* 1643 */       return -1;
/*      */     }
/* 1645 */     if (paramInt < 0)
/* 1646 */       return -1; 
/* 1647 */     if (paramInt >= paramArrayOfObject.length) {
/* 1648 */       paramInt = paramArrayOfObject.length - 1;
/*      */     }
/* 1650 */     if (paramObject == null) {
/* 1651 */       for (int i = paramInt; i >= 0; i--) {
/* 1652 */         if (paramArrayOfObject[i] == null) {
/* 1653 */           return i;
/*      */         }
/*      */       } 
/* 1656 */     } else if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject)) {
/* 1657 */       for (int i = paramInt; i >= 0; i--) {
/* 1658 */         if (paramObject.equals(paramArrayOfObject[i])) {
/* 1659 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/* 1663 */     return -1;
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
/*      */   public static boolean contains(Object[] paramArrayOfObject, Object paramObject) {
/* 1676 */     return (indexOf(paramArrayOfObject, paramObject) != -1);
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
/*      */   public static int indexOf(long[] paramArrayOflong, long paramLong) {
/* 1692 */     return indexOf(paramArrayOflong, paramLong, 0);
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
/*      */   public static int indexOf(long[] paramArrayOflong, long paramLong, int paramInt) {
/* 1710 */     if (paramArrayOflong == null) {
/* 1711 */       return -1;
/*      */     }
/* 1713 */     if (paramInt < 0) {
/* 1714 */       paramInt = 0;
/*      */     }
/* 1716 */     for (int i = paramInt; i < paramArrayOflong.length; i++) {
/* 1717 */       if (paramLong == paramArrayOflong[i]) {
/* 1718 */         return i;
/*      */       }
/*      */     } 
/* 1721 */     return -1;
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
/*      */   public static int lastIndexOf(long[] paramArrayOflong, long paramLong) {
/* 1735 */     return lastIndexOf(paramArrayOflong, paramLong, 2147483647);
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
/*      */   public static int lastIndexOf(long[] paramArrayOflong, long paramLong, int paramInt) {
/* 1753 */     if (paramArrayOflong == null) {
/* 1754 */       return -1;
/*      */     }
/* 1756 */     if (paramInt < 0)
/* 1757 */       return -1; 
/* 1758 */     if (paramInt >= paramArrayOflong.length) {
/* 1759 */       paramInt = paramArrayOflong.length - 1;
/*      */     }
/* 1761 */     for (int i = paramInt; i >= 0; i--) {
/* 1762 */       if (paramLong == paramArrayOflong[i]) {
/* 1763 */         return i;
/*      */       }
/*      */     } 
/* 1766 */     return -1;
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
/*      */   public static boolean contains(long[] paramArrayOflong, long paramLong) {
/* 1779 */     return (indexOf(paramArrayOflong, paramLong) != -1);
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
/*      */   public static int indexOf(int[] paramArrayOfint, int paramInt) {
/* 1795 */     return indexOf(paramArrayOfint, paramInt, 0);
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
/*      */   public static int indexOf(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 1813 */     if (paramArrayOfint == null) {
/* 1814 */       return -1;
/*      */     }
/* 1816 */     if (paramInt2 < 0) {
/* 1817 */       paramInt2 = 0;
/*      */     }
/* 1819 */     for (int i = paramInt2; i < paramArrayOfint.length; i++) {
/* 1820 */       if (paramInt1 == paramArrayOfint[i]) {
/* 1821 */         return i;
/*      */       }
/*      */     } 
/* 1824 */     return -1;
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
/*      */   public static int lastIndexOf(int[] paramArrayOfint, int paramInt) {
/* 1838 */     return lastIndexOf(paramArrayOfint, paramInt, 2147483647);
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
/*      */   public static int lastIndexOf(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 1856 */     if (paramArrayOfint == null) {
/* 1857 */       return -1;
/*      */     }
/* 1859 */     if (paramInt2 < 0)
/* 1860 */       return -1; 
/* 1861 */     if (paramInt2 >= paramArrayOfint.length) {
/* 1862 */       paramInt2 = paramArrayOfint.length - 1;
/*      */     }
/* 1864 */     for (int i = paramInt2; i >= 0; i--) {
/* 1865 */       if (paramInt1 == paramArrayOfint[i]) {
/* 1866 */         return i;
/*      */       }
/*      */     } 
/* 1869 */     return -1;
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
/*      */   public static boolean contains(int[] paramArrayOfint, int paramInt) {
/* 1882 */     return (indexOf(paramArrayOfint, paramInt) != -1);
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
/*      */   public static int indexOf(short[] paramArrayOfshort, short paramShort) {
/* 1898 */     return indexOf(paramArrayOfshort, paramShort, 0);
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
/*      */   public static int indexOf(short[] paramArrayOfshort, short paramShort, int paramInt) {
/* 1916 */     if (paramArrayOfshort == null) {
/* 1917 */       return -1;
/*      */     }
/* 1919 */     if (paramInt < 0) {
/* 1920 */       paramInt = 0;
/*      */     }
/* 1922 */     for (int i = paramInt; i < paramArrayOfshort.length; i++) {
/* 1923 */       if (paramShort == paramArrayOfshort[i]) {
/* 1924 */         return i;
/*      */       }
/*      */     } 
/* 1927 */     return -1;
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
/*      */   public static int lastIndexOf(short[] paramArrayOfshort, short paramShort) {
/* 1941 */     return lastIndexOf(paramArrayOfshort, paramShort, 2147483647);
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
/*      */   public static int lastIndexOf(short[] paramArrayOfshort, short paramShort, int paramInt) {
/* 1959 */     if (paramArrayOfshort == null) {
/* 1960 */       return -1;
/*      */     }
/* 1962 */     if (paramInt < 0)
/* 1963 */       return -1; 
/* 1964 */     if (paramInt >= paramArrayOfshort.length) {
/* 1965 */       paramInt = paramArrayOfshort.length - 1;
/*      */     }
/* 1967 */     for (int i = paramInt; i >= 0; i--) {
/* 1968 */       if (paramShort == paramArrayOfshort[i]) {
/* 1969 */         return i;
/*      */       }
/*      */     } 
/* 1972 */     return -1;
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
/*      */   public static boolean contains(short[] paramArrayOfshort, short paramShort) {
/* 1985 */     return (indexOf(paramArrayOfshort, paramShort) != -1);
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
/*      */   public static int indexOf(char[] paramArrayOfchar, char paramChar) {
/* 2002 */     return indexOf(paramArrayOfchar, paramChar, 0);
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
/*      */   public static int indexOf(char[] paramArrayOfchar, char paramChar, int paramInt) {
/* 2021 */     if (paramArrayOfchar == null) {
/* 2022 */       return -1;
/*      */     }
/* 2024 */     if (paramInt < 0) {
/* 2025 */       paramInt = 0;
/*      */     }
/* 2027 */     for (int i = paramInt; i < paramArrayOfchar.length; i++) {
/* 2028 */       if (paramChar == paramArrayOfchar[i]) {
/* 2029 */         return i;
/*      */       }
/*      */     } 
/* 2032 */     return -1;
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
/*      */   public static int lastIndexOf(char[] paramArrayOfchar, char paramChar) {
/* 2047 */     return lastIndexOf(paramArrayOfchar, paramChar, 2147483647);
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
/*      */   public static int lastIndexOf(char[] paramArrayOfchar, char paramChar, int paramInt) {
/* 2066 */     if (paramArrayOfchar == null) {
/* 2067 */       return -1;
/*      */     }
/* 2069 */     if (paramInt < 0)
/* 2070 */       return -1; 
/* 2071 */     if (paramInt >= paramArrayOfchar.length) {
/* 2072 */       paramInt = paramArrayOfchar.length - 1;
/*      */     }
/* 2074 */     for (int i = paramInt; i >= 0; i--) {
/* 2075 */       if (paramChar == paramArrayOfchar[i]) {
/* 2076 */         return i;
/*      */       }
/*      */     } 
/* 2079 */     return -1;
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
/*      */   public static boolean contains(char[] paramArrayOfchar, char paramChar) {
/* 2093 */     return (indexOf(paramArrayOfchar, paramChar) != -1);
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
/*      */   public static int indexOf(byte[] paramArrayOfbyte, byte paramByte) {
/* 2109 */     return indexOf(paramArrayOfbyte, paramByte, 0);
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
/*      */   public static int indexOf(byte[] paramArrayOfbyte, byte paramByte, int paramInt) {
/* 2127 */     if (paramArrayOfbyte == null) {
/* 2128 */       return -1;
/*      */     }
/* 2130 */     if (paramInt < 0) {
/* 2131 */       paramInt = 0;
/*      */     }
/* 2133 */     for (int i = paramInt; i < paramArrayOfbyte.length; i++) {
/* 2134 */       if (paramByte == paramArrayOfbyte[i]) {
/* 2135 */         return i;
/*      */       }
/*      */     } 
/* 2138 */     return -1;
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
/*      */   public static int lastIndexOf(byte[] paramArrayOfbyte, byte paramByte) {
/* 2152 */     return lastIndexOf(paramArrayOfbyte, paramByte, 2147483647);
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
/*      */   public static int lastIndexOf(byte[] paramArrayOfbyte, byte paramByte, int paramInt) {
/* 2170 */     if (paramArrayOfbyte == null) {
/* 2171 */       return -1;
/*      */     }
/* 2173 */     if (paramInt < 0)
/* 2174 */       return -1; 
/* 2175 */     if (paramInt >= paramArrayOfbyte.length) {
/* 2176 */       paramInt = paramArrayOfbyte.length - 1;
/*      */     }
/* 2178 */     for (int i = paramInt; i >= 0; i--) {
/* 2179 */       if (paramByte == paramArrayOfbyte[i]) {
/* 2180 */         return i;
/*      */       }
/*      */     } 
/* 2183 */     return -1;
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
/*      */   public static boolean contains(byte[] paramArrayOfbyte, byte paramByte) {
/* 2196 */     return (indexOf(paramArrayOfbyte, paramByte) != -1);
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble) {
/* 2212 */     return indexOf(paramArrayOfdouble, paramDouble, 0);
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/* 2229 */     return indexOf(paramArrayOfdouble, paramDouble1, 0, paramDouble2);
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble, int paramInt) {
/* 2247 */     if (isEmpty(paramArrayOfdouble)) {
/* 2248 */       return -1;
/*      */     }
/* 2250 */     if (paramInt < 0) {
/* 2251 */       paramInt = 0;
/*      */     }
/* 2253 */     for (int i = paramInt; i < paramArrayOfdouble.length; i++) {
/* 2254 */       if (paramDouble == paramArrayOfdouble[i]) {
/* 2255 */         return i;
/*      */       }
/*      */     } 
/* 2258 */     return -1;
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
/*      */   public static int indexOf(double[] paramArrayOfdouble, double paramDouble1, int paramInt, double paramDouble2) {
/* 2279 */     if (isEmpty(paramArrayOfdouble)) {
/* 2280 */       return -1;
/*      */     }
/* 2282 */     if (paramInt < 0) {
/* 2283 */       paramInt = 0;
/*      */     }
/* 2285 */     double d1 = paramDouble1 - paramDouble2;
/* 2286 */     double d2 = paramDouble1 + paramDouble2;
/* 2287 */     for (int i = paramInt; i < paramArrayOfdouble.length; i++) {
/* 2288 */       if (paramArrayOfdouble[i] >= d1 && paramArrayOfdouble[i] <= d2) {
/* 2289 */         return i;
/*      */       }
/*      */     } 
/* 2292 */     return -1;
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble) {
/* 2306 */     return lastIndexOf(paramArrayOfdouble, paramDouble, 2147483647);
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/* 2323 */     return lastIndexOf(paramArrayOfdouble, paramDouble1, 2147483647, paramDouble2);
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble, int paramInt) {
/* 2341 */     if (isEmpty(paramArrayOfdouble)) {
/* 2342 */       return -1;
/*      */     }
/* 2344 */     if (paramInt < 0)
/* 2345 */       return -1; 
/* 2346 */     if (paramInt >= paramArrayOfdouble.length) {
/* 2347 */       paramInt = paramArrayOfdouble.length - 1;
/*      */     }
/* 2349 */     for (int i = paramInt; i >= 0; i--) {
/* 2350 */       if (paramDouble == paramArrayOfdouble[i]) {
/* 2351 */         return i;
/*      */       }
/*      */     } 
/* 2354 */     return -1;
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
/*      */   public static int lastIndexOf(double[] paramArrayOfdouble, double paramDouble1, int paramInt, double paramDouble2) {
/* 2375 */     if (isEmpty(paramArrayOfdouble)) {
/* 2376 */       return -1;
/*      */     }
/* 2378 */     if (paramInt < 0)
/* 2379 */       return -1; 
/* 2380 */     if (paramInt >= paramArrayOfdouble.length) {
/* 2381 */       paramInt = paramArrayOfdouble.length - 1;
/*      */     }
/* 2383 */     double d1 = paramDouble1 - paramDouble2;
/* 2384 */     double d2 = paramDouble1 + paramDouble2;
/* 2385 */     for (int i = paramInt; i >= 0; i--) {
/* 2386 */       if (paramArrayOfdouble[i] >= d1 && paramArrayOfdouble[i] <= d2) {
/* 2387 */         return i;
/*      */       }
/*      */     } 
/* 2390 */     return -1;
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
/*      */   public static boolean contains(double[] paramArrayOfdouble, double paramDouble) {
/* 2403 */     return (indexOf(paramArrayOfdouble, paramDouble) != -1);
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
/*      */   public static boolean contains(double[] paramArrayOfdouble, double paramDouble1, double paramDouble2) {
/* 2420 */     return (indexOf(paramArrayOfdouble, paramDouble1, 0, paramDouble2) != -1);
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
/*      */   public static int indexOf(float[] paramArrayOffloat, float paramFloat) {
/* 2436 */     return indexOf(paramArrayOffloat, paramFloat, 0);
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
/*      */   public static int indexOf(float[] paramArrayOffloat, float paramFloat, int paramInt) {
/* 2454 */     if (isEmpty(paramArrayOffloat)) {
/* 2455 */       return -1;
/*      */     }
/* 2457 */     if (paramInt < 0) {
/* 2458 */       paramInt = 0;
/*      */     }
/* 2460 */     for (int i = paramInt; i < paramArrayOffloat.length; i++) {
/* 2461 */       if (paramFloat == paramArrayOffloat[i]) {
/* 2462 */         return i;
/*      */       }
/*      */     } 
/* 2465 */     return -1;
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
/*      */   public static int lastIndexOf(float[] paramArrayOffloat, float paramFloat) {
/* 2479 */     return lastIndexOf(paramArrayOffloat, paramFloat, 2147483647);
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
/*      */   public static int lastIndexOf(float[] paramArrayOffloat, float paramFloat, int paramInt) {
/* 2497 */     if (isEmpty(paramArrayOffloat)) {
/* 2498 */       return -1;
/*      */     }
/* 2500 */     if (paramInt < 0)
/* 2501 */       return -1; 
/* 2502 */     if (paramInt >= paramArrayOffloat.length) {
/* 2503 */       paramInt = paramArrayOffloat.length - 1;
/*      */     }
/* 2505 */     for (int i = paramInt; i >= 0; i--) {
/* 2506 */       if (paramFloat == paramArrayOffloat[i]) {
/* 2507 */         return i;
/*      */       }
/*      */     } 
/* 2510 */     return -1;
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
/*      */   public static boolean contains(float[] paramArrayOffloat, float paramFloat) {
/* 2523 */     return (indexOf(paramArrayOffloat, paramFloat) != -1);
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
/*      */   public static int indexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 2539 */     return indexOf(paramArrayOfboolean, paramBoolean, 0);
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
/*      */   public static int indexOf(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt) {
/* 2558 */     if (isEmpty(paramArrayOfboolean)) {
/* 2559 */       return -1;
/*      */     }
/* 2561 */     if (paramInt < 0) {
/* 2562 */       paramInt = 0;
/*      */     }
/* 2564 */     for (int i = paramInt; i < paramArrayOfboolean.length; i++) {
/* 2565 */       if (paramBoolean == paramArrayOfboolean[i]) {
/* 2566 */         return i;
/*      */       }
/*      */     } 
/* 2569 */     return -1;
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
/*      */   public static int lastIndexOf(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 2584 */     return lastIndexOf(paramArrayOfboolean, paramBoolean, 2147483647);
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
/*      */   public static int lastIndexOf(boolean[] paramArrayOfboolean, boolean paramBoolean, int paramInt) {
/* 2602 */     if (isEmpty(paramArrayOfboolean)) {
/* 2603 */       return -1;
/*      */     }
/* 2605 */     if (paramInt < 0)
/* 2606 */       return -1; 
/* 2607 */     if (paramInt >= paramArrayOfboolean.length) {
/* 2608 */       paramInt = paramArrayOfboolean.length - 1;
/*      */     }
/* 2610 */     for (int i = paramInt; i >= 0; i--) {
/* 2611 */       if (paramBoolean == paramArrayOfboolean[i]) {
/* 2612 */         return i;
/*      */       }
/*      */     } 
/* 2615 */     return -1;
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
/*      */   public static boolean contains(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 2628 */     return (indexOf(paramArrayOfboolean, paramBoolean) != -1);
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
/*      */   public static char[] toPrimitive(Character[] paramArrayOfCharacter) {
/* 2646 */     if (paramArrayOfCharacter == null)
/* 2647 */       return null; 
/* 2648 */     if (paramArrayOfCharacter.length == 0) {
/* 2649 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/* 2651 */     char[] arrayOfChar = new char[paramArrayOfCharacter.length];
/* 2652 */     for (byte b = 0; b < paramArrayOfCharacter.length; b++) {
/* 2653 */       arrayOfChar[b] = paramArrayOfCharacter[b].charValue();
/*      */     }
/* 2655 */     return arrayOfChar;
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
/*      */   public static char[] toPrimitive(Character[] paramArrayOfCharacter, char paramChar) {
/* 2668 */     if (paramArrayOfCharacter == null)
/* 2669 */       return null; 
/* 2670 */     if (paramArrayOfCharacter.length == 0) {
/* 2671 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/* 2673 */     char[] arrayOfChar = new char[paramArrayOfCharacter.length];
/* 2674 */     for (byte b = 0; b < paramArrayOfCharacter.length; b++) {
/* 2675 */       Character character = paramArrayOfCharacter[b];
/* 2676 */       arrayOfChar[b] = (character == null) ? paramChar : character.charValue();
/*      */     } 
/* 2678 */     return arrayOfChar;
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
/*      */   public static Character[] toObject(char[] paramArrayOfchar) {
/* 2690 */     if (paramArrayOfchar == null)
/* 2691 */       return null; 
/* 2692 */     if (paramArrayOfchar.length == 0) {
/* 2693 */       return EMPTY_CHARACTER_OBJECT_ARRAY;
/*      */     }
/* 2695 */     Character[] arrayOfCharacter = new Character[paramArrayOfchar.length];
/* 2696 */     for (byte b = 0; b < paramArrayOfchar.length; b++) {
/* 2697 */       arrayOfCharacter[b] = new Character(paramArrayOfchar[b]);
/*      */     }
/* 2699 */     return arrayOfCharacter;
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
/*      */   public static long[] toPrimitive(Long[] paramArrayOfLong) {
/* 2714 */     if (paramArrayOfLong == null)
/* 2715 */       return null; 
/* 2716 */     if (paramArrayOfLong.length == 0) {
/* 2717 */       return EMPTY_LONG_ARRAY;
/*      */     }
/* 2719 */     long[] arrayOfLong = new long[paramArrayOfLong.length];
/* 2720 */     for (byte b = 0; b < paramArrayOfLong.length; b++) {
/* 2721 */       arrayOfLong[b] = paramArrayOfLong[b].longValue();
/*      */     }
/* 2723 */     return arrayOfLong;
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
/*      */   public static long[] toPrimitive(Long[] paramArrayOfLong, long paramLong) {
/* 2736 */     if (paramArrayOfLong == null)
/* 2737 */       return null; 
/* 2738 */     if (paramArrayOfLong.length == 0) {
/* 2739 */       return EMPTY_LONG_ARRAY;
/*      */     }
/* 2741 */     long[] arrayOfLong = new long[paramArrayOfLong.length];
/* 2742 */     for (byte b = 0; b < paramArrayOfLong.length; b++) {
/* 2743 */       Long long_ = paramArrayOfLong[b];
/* 2744 */       arrayOfLong[b] = (long_ == null) ? paramLong : long_.longValue();
/*      */     } 
/* 2746 */     return arrayOfLong;
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
/*      */   public static Long[] toObject(long[] paramArrayOflong) {
/* 2758 */     if (paramArrayOflong == null)
/* 2759 */       return null; 
/* 2760 */     if (paramArrayOflong.length == 0) {
/* 2761 */       return EMPTY_LONG_OBJECT_ARRAY;
/*      */     }
/* 2763 */     Long[] arrayOfLong = new Long[paramArrayOflong.length];
/* 2764 */     for (byte b = 0; b < paramArrayOflong.length; b++) {
/* 2765 */       arrayOfLong[b] = new Long(paramArrayOflong[b]);
/*      */     }
/* 2767 */     return arrayOfLong;
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
/*      */   public static int[] toPrimitive(Integer[] paramArrayOfInteger) {
/* 2782 */     if (paramArrayOfInteger == null)
/* 2783 */       return null; 
/* 2784 */     if (paramArrayOfInteger.length == 0) {
/* 2785 */       return EMPTY_INT_ARRAY;
/*      */     }
/* 2787 */     int[] arrayOfInt = new int[paramArrayOfInteger.length];
/* 2788 */     for (byte b = 0; b < paramArrayOfInteger.length; b++) {
/* 2789 */       arrayOfInt[b] = paramArrayOfInteger[b].intValue();
/*      */     }
/* 2791 */     return arrayOfInt;
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
/*      */   public static int[] toPrimitive(Integer[] paramArrayOfInteger, int paramInt) {
/* 2804 */     if (paramArrayOfInteger == null)
/* 2805 */       return null; 
/* 2806 */     if (paramArrayOfInteger.length == 0) {
/* 2807 */       return EMPTY_INT_ARRAY;
/*      */     }
/* 2809 */     int[] arrayOfInt = new int[paramArrayOfInteger.length];
/* 2810 */     for (byte b = 0; b < paramArrayOfInteger.length; b++) {
/* 2811 */       Integer integer = paramArrayOfInteger[b];
/* 2812 */       arrayOfInt[b] = (integer == null) ? paramInt : integer.intValue();
/*      */     } 
/* 2814 */     return arrayOfInt;
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
/*      */   public static Integer[] toObject(int[] paramArrayOfint) {
/* 2826 */     if (paramArrayOfint == null)
/* 2827 */       return null; 
/* 2828 */     if (paramArrayOfint.length == 0) {
/* 2829 */       return EMPTY_INTEGER_OBJECT_ARRAY;
/*      */     }
/* 2831 */     Integer[] arrayOfInteger = new Integer[paramArrayOfint.length];
/* 2832 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 2833 */       arrayOfInteger[b] = new Integer(paramArrayOfint[b]);
/*      */     }
/* 2835 */     return arrayOfInteger;
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
/*      */   public static short[] toPrimitive(Short[] paramArrayOfShort) {
/* 2850 */     if (paramArrayOfShort == null)
/* 2851 */       return null; 
/* 2852 */     if (paramArrayOfShort.length == 0) {
/* 2853 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/* 2855 */     short[] arrayOfShort = new short[paramArrayOfShort.length];
/* 2856 */     for (byte b = 0; b < paramArrayOfShort.length; b++) {
/* 2857 */       arrayOfShort[b] = paramArrayOfShort[b].shortValue();
/*      */     }
/* 2859 */     return arrayOfShort;
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
/*      */   public static short[] toPrimitive(Short[] paramArrayOfShort, short paramShort) {
/* 2872 */     if (paramArrayOfShort == null)
/* 2873 */       return null; 
/* 2874 */     if (paramArrayOfShort.length == 0) {
/* 2875 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/* 2877 */     short[] arrayOfShort = new short[paramArrayOfShort.length];
/* 2878 */     for (byte b = 0; b < paramArrayOfShort.length; b++) {
/* 2879 */       Short short_ = paramArrayOfShort[b];
/* 2880 */       arrayOfShort[b] = (short_ == null) ? paramShort : short_.shortValue();
/*      */     } 
/* 2882 */     return arrayOfShort;
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
/*      */   public static Short[] toObject(short[] paramArrayOfshort) {
/* 2894 */     if (paramArrayOfshort == null)
/* 2895 */       return null; 
/* 2896 */     if (paramArrayOfshort.length == 0) {
/* 2897 */       return EMPTY_SHORT_OBJECT_ARRAY;
/*      */     }
/* 2899 */     Short[] arrayOfShort = new Short[paramArrayOfshort.length];
/* 2900 */     for (byte b = 0; b < paramArrayOfshort.length; b++) {
/* 2901 */       arrayOfShort[b] = new Short(paramArrayOfshort[b]);
/*      */     }
/* 2903 */     return arrayOfShort;
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
/*      */   public static byte[] toPrimitive(Byte[] paramArrayOfByte) {
/* 2918 */     if (paramArrayOfByte == null)
/* 2919 */       return null; 
/* 2920 */     if (paramArrayOfByte.length == 0) {
/* 2921 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/* 2923 */     byte[] arrayOfByte = new byte[paramArrayOfByte.length];
/* 2924 */     for (byte b = 0; b < paramArrayOfByte.length; b++) {
/* 2925 */       arrayOfByte[b] = paramArrayOfByte[b].byteValue();
/*      */     }
/* 2927 */     return arrayOfByte;
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
/*      */   public static byte[] toPrimitive(Byte[] paramArrayOfByte, byte paramByte) {
/* 2940 */     if (paramArrayOfByte == null)
/* 2941 */       return null; 
/* 2942 */     if (paramArrayOfByte.length == 0) {
/* 2943 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/* 2945 */     byte[] arrayOfByte = new byte[paramArrayOfByte.length];
/* 2946 */     for (byte b = 0; b < paramArrayOfByte.length; b++) {
/* 2947 */       Byte byte_ = paramArrayOfByte[b];
/* 2948 */       arrayOfByte[b] = (byte_ == null) ? paramByte : byte_.byteValue();
/*      */     } 
/* 2950 */     return arrayOfByte;
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
/*      */   public static Byte[] toObject(byte[] paramArrayOfbyte) {
/* 2962 */     if (paramArrayOfbyte == null)
/* 2963 */       return null; 
/* 2964 */     if (paramArrayOfbyte.length == 0) {
/* 2965 */       return EMPTY_BYTE_OBJECT_ARRAY;
/*      */     }
/* 2967 */     Byte[] arrayOfByte = new Byte[paramArrayOfbyte.length];
/* 2968 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 2969 */       arrayOfByte[b] = new Byte(paramArrayOfbyte[b]);
/*      */     }
/* 2971 */     return arrayOfByte;
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
/*      */   public static double[] toPrimitive(Double[] paramArrayOfDouble) {
/* 2986 */     if (paramArrayOfDouble == null)
/* 2987 */       return null; 
/* 2988 */     if (paramArrayOfDouble.length == 0) {
/* 2989 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/* 2991 */     double[] arrayOfDouble = new double[paramArrayOfDouble.length];
/* 2992 */     for (byte b = 0; b < paramArrayOfDouble.length; b++) {
/* 2993 */       arrayOfDouble[b] = paramArrayOfDouble[b].doubleValue();
/*      */     }
/* 2995 */     return arrayOfDouble;
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
/*      */   public static double[] toPrimitive(Double[] paramArrayOfDouble, double paramDouble) {
/* 3008 */     if (paramArrayOfDouble == null)
/* 3009 */       return null; 
/* 3010 */     if (paramArrayOfDouble.length == 0) {
/* 3011 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/* 3013 */     double[] arrayOfDouble = new double[paramArrayOfDouble.length];
/* 3014 */     for (byte b = 0; b < paramArrayOfDouble.length; b++) {
/* 3015 */       Double double_ = paramArrayOfDouble[b];
/* 3016 */       arrayOfDouble[b] = (double_ == null) ? paramDouble : double_.doubleValue();
/*      */     } 
/* 3018 */     return arrayOfDouble;
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
/*      */   public static Double[] toObject(double[] paramArrayOfdouble) {
/* 3030 */     if (paramArrayOfdouble == null)
/* 3031 */       return null; 
/* 3032 */     if (paramArrayOfdouble.length == 0) {
/* 3033 */       return EMPTY_DOUBLE_OBJECT_ARRAY;
/*      */     }
/* 3035 */     Double[] arrayOfDouble = new Double[paramArrayOfdouble.length];
/* 3036 */     for (byte b = 0; b < paramArrayOfdouble.length; b++) {
/* 3037 */       arrayOfDouble[b] = new Double(paramArrayOfdouble[b]);
/*      */     }
/* 3039 */     return arrayOfDouble;
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
/*      */   public static float[] toPrimitive(Float[] paramArrayOfFloat) {
/* 3054 */     if (paramArrayOfFloat == null)
/* 3055 */       return null; 
/* 3056 */     if (paramArrayOfFloat.length == 0) {
/* 3057 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/* 3059 */     float[] arrayOfFloat = new float[paramArrayOfFloat.length];
/* 3060 */     for (byte b = 0; b < paramArrayOfFloat.length; b++) {
/* 3061 */       arrayOfFloat[b] = paramArrayOfFloat[b].floatValue();
/*      */     }
/* 3063 */     return arrayOfFloat;
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
/*      */   public static float[] toPrimitive(Float[] paramArrayOfFloat, float paramFloat) {
/* 3076 */     if (paramArrayOfFloat == null)
/* 3077 */       return null; 
/* 3078 */     if (paramArrayOfFloat.length == 0) {
/* 3079 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/* 3081 */     float[] arrayOfFloat = new float[paramArrayOfFloat.length];
/* 3082 */     for (byte b = 0; b < paramArrayOfFloat.length; b++) {
/* 3083 */       Float float_ = paramArrayOfFloat[b];
/* 3084 */       arrayOfFloat[b] = (float_ == null) ? paramFloat : float_.floatValue();
/*      */     } 
/* 3086 */     return arrayOfFloat;
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
/*      */   public static Float[] toObject(float[] paramArrayOffloat) {
/* 3098 */     if (paramArrayOffloat == null)
/* 3099 */       return null; 
/* 3100 */     if (paramArrayOffloat.length == 0) {
/* 3101 */       return EMPTY_FLOAT_OBJECT_ARRAY;
/*      */     }
/* 3103 */     Float[] arrayOfFloat = new Float[paramArrayOffloat.length];
/* 3104 */     for (byte b = 0; b < paramArrayOffloat.length; b++) {
/* 3105 */       arrayOfFloat[b] = new Float(paramArrayOffloat[b]);
/*      */     }
/* 3107 */     return arrayOfFloat;
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
/*      */   public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean) {
/* 3122 */     if (paramArrayOfBoolean == null)
/* 3123 */       return null; 
/* 3124 */     if (paramArrayOfBoolean.length == 0) {
/* 3125 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/* 3127 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
/* 3128 */     for (byte b = 0; b < paramArrayOfBoolean.length; b++) {
/* 3129 */       arrayOfBoolean[b] = paramArrayOfBoolean[b].booleanValue();
/*      */     }
/* 3131 */     return arrayOfBoolean;
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
/*      */   public static boolean[] toPrimitive(Boolean[] paramArrayOfBoolean, boolean paramBoolean) {
/* 3144 */     if (paramArrayOfBoolean == null)
/* 3145 */       return null; 
/* 3146 */     if (paramArrayOfBoolean.length == 0) {
/* 3147 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/* 3149 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfBoolean.length];
/* 3150 */     for (byte b = 0; b < paramArrayOfBoolean.length; b++) {
/* 3151 */       Boolean bool = paramArrayOfBoolean[b];
/* 3152 */       arrayOfBoolean[b] = (bool == null) ? paramBoolean : bool.booleanValue();
/*      */     } 
/* 3154 */     return arrayOfBoolean;
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
/*      */   public static Boolean[] toObject(boolean[] paramArrayOfboolean) {
/* 3166 */     if (paramArrayOfboolean == null)
/* 3167 */       return null; 
/* 3168 */     if (paramArrayOfboolean.length == 0) {
/* 3169 */       return EMPTY_BOOLEAN_OBJECT_ARRAY;
/*      */     }
/* 3171 */     Boolean[] arrayOfBoolean = new Boolean[paramArrayOfboolean.length];
/* 3172 */     for (byte b = 0; b < paramArrayOfboolean.length; b++) {
/* 3173 */       arrayOfBoolean[b] = paramArrayOfboolean[b] ? Boolean.TRUE : Boolean.FALSE;
/*      */     }
/* 3175 */     return arrayOfBoolean;
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
/*      */   public static boolean isEmpty(Object[] paramArrayOfObject) {
/* 3187 */     return (paramArrayOfObject == null || paramArrayOfObject.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(long[] paramArrayOflong) {
/* 3198 */     return (paramArrayOflong == null || paramArrayOflong.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(int[] paramArrayOfint) {
/* 3209 */     return (paramArrayOfint == null || paramArrayOfint.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(short[] paramArrayOfshort) {
/* 3220 */     return (paramArrayOfshort == null || paramArrayOfshort.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(char[] paramArrayOfchar) {
/* 3231 */     return (paramArrayOfchar == null || paramArrayOfchar.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(byte[] paramArrayOfbyte) {
/* 3242 */     return (paramArrayOfbyte == null || paramArrayOfbyte.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(double[] paramArrayOfdouble) {
/* 3253 */     return (paramArrayOfdouble == null || paramArrayOfdouble.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(float[] paramArrayOffloat) {
/* 3264 */     return (paramArrayOffloat == null || paramArrayOffloat.length == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(boolean[] paramArrayOfboolean) {
/* 3275 */     return (paramArrayOfboolean == null || paramArrayOfboolean.length == 0);
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
/*      */   public static boolean isNotEmpty(Object[] paramArrayOfObject) {
/* 3287 */     return (paramArrayOfObject != null && paramArrayOfObject.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(long[] paramArrayOflong) {
/* 3298 */     return (paramArrayOflong != null && paramArrayOflong.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(int[] paramArrayOfint) {
/* 3309 */     return (paramArrayOfint != null && paramArrayOfint.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(short[] paramArrayOfshort) {
/* 3320 */     return (paramArrayOfshort != null && paramArrayOfshort.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(char[] paramArrayOfchar) {
/* 3331 */     return (paramArrayOfchar != null && paramArrayOfchar.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(byte[] paramArrayOfbyte) {
/* 3342 */     return (paramArrayOfbyte != null && paramArrayOfbyte.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(double[] paramArrayOfdouble) {
/* 3353 */     return (paramArrayOfdouble != null && paramArrayOfdouble.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(float[] paramArrayOffloat) {
/* 3364 */     return (paramArrayOffloat != null && paramArrayOffloat.length != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(boolean[] paramArrayOfboolean) {
/* 3375 */     return (paramArrayOfboolean != null && paramArrayOfboolean.length != 0);
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
/*      */   public static Object[] addAll(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/* 3402 */     if (paramArrayOfObject1 == null)
/* 3403 */       return clone(paramArrayOfObject2); 
/* 3404 */     if (paramArrayOfObject2 == null) {
/* 3405 */       return clone(paramArrayOfObject1);
/*      */     }
/* 3407 */     Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject1.getClass().getComponentType(), paramArrayOfObject1.length + paramArrayOfObject2.length);
/*      */     
/* 3409 */     System.arraycopy(paramArrayOfObject1, 0, arrayOfObject, 0, paramArrayOfObject1.length);
/*      */     try {
/* 3411 */       System.arraycopy(paramArrayOfObject2, 0, arrayOfObject, paramArrayOfObject1.length, paramArrayOfObject2.length);
/* 3412 */     } catch (ArrayStoreException arrayStoreException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3419 */       Class clazz1 = paramArrayOfObject1.getClass().getComponentType();
/* 3420 */       Class clazz2 = paramArrayOfObject2.getClass().getComponentType();
/* 3421 */       if (!clazz1.isAssignableFrom(clazz2)) {
/* 3422 */         throw new IllegalArgumentException("Cannot store " + clazz2.getName() + " in an array of " + clazz1.getName());
/*      */       }
/* 3424 */       throw arrayStoreException;
/*      */     } 
/* 3426 */     return arrayOfObject;
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
/*      */   public static boolean[] addAll(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 3447 */     if (paramArrayOfboolean1 == null)
/* 3448 */       return clone(paramArrayOfboolean2); 
/* 3449 */     if (paramArrayOfboolean2 == null) {
/* 3450 */       return clone(paramArrayOfboolean1);
/*      */     }
/* 3452 */     boolean[] arrayOfBoolean = new boolean[paramArrayOfboolean1.length + paramArrayOfboolean2.length];
/* 3453 */     System.arraycopy(paramArrayOfboolean1, 0, arrayOfBoolean, 0, paramArrayOfboolean1.length);
/* 3454 */     System.arraycopy(paramArrayOfboolean2, 0, arrayOfBoolean, paramArrayOfboolean1.length, paramArrayOfboolean2.length);
/* 3455 */     return arrayOfBoolean;
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
/*      */   public static char[] addAll(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/* 3476 */     if (paramArrayOfchar1 == null)
/* 3477 */       return clone(paramArrayOfchar2); 
/* 3478 */     if (paramArrayOfchar2 == null) {
/* 3479 */       return clone(paramArrayOfchar1);
/*      */     }
/* 3481 */     char[] arrayOfChar = new char[paramArrayOfchar1.length + paramArrayOfchar2.length];
/* 3482 */     System.arraycopy(paramArrayOfchar1, 0, arrayOfChar, 0, paramArrayOfchar1.length);
/* 3483 */     System.arraycopy(paramArrayOfchar2, 0, arrayOfChar, paramArrayOfchar1.length, paramArrayOfchar2.length);
/* 3484 */     return arrayOfChar;
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
/*      */   public static byte[] addAll(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 3505 */     if (paramArrayOfbyte1 == null)
/* 3506 */       return clone(paramArrayOfbyte2); 
/* 3507 */     if (paramArrayOfbyte2 == null) {
/* 3508 */       return clone(paramArrayOfbyte1);
/*      */     }
/* 3510 */     byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramArrayOfbyte2.length];
/* 3511 */     System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramArrayOfbyte1.length);
/* 3512 */     System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte, paramArrayOfbyte1.length, paramArrayOfbyte2.length);
/* 3513 */     return arrayOfByte;
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
/*      */   public static short[] addAll(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/* 3534 */     if (paramArrayOfshort1 == null)
/* 3535 */       return clone(paramArrayOfshort2); 
/* 3536 */     if (paramArrayOfshort2 == null) {
/* 3537 */       return clone(paramArrayOfshort1);
/*      */     }
/* 3539 */     short[] arrayOfShort = new short[paramArrayOfshort1.length + paramArrayOfshort2.length];
/* 3540 */     System.arraycopy(paramArrayOfshort1, 0, arrayOfShort, 0, paramArrayOfshort1.length);
/* 3541 */     System.arraycopy(paramArrayOfshort2, 0, arrayOfShort, paramArrayOfshort1.length, paramArrayOfshort2.length);
/* 3542 */     return arrayOfShort;
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
/*      */   public static int[] addAll(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 3563 */     if (paramArrayOfint1 == null)
/* 3564 */       return clone(paramArrayOfint2); 
/* 3565 */     if (paramArrayOfint2 == null) {
/* 3566 */       return clone(paramArrayOfint1);
/*      */     }
/* 3568 */     int[] arrayOfInt = new int[paramArrayOfint1.length + paramArrayOfint2.length];
/* 3569 */     System.arraycopy(paramArrayOfint1, 0, arrayOfInt, 0, paramArrayOfint1.length);
/* 3570 */     System.arraycopy(paramArrayOfint2, 0, arrayOfInt, paramArrayOfint1.length, paramArrayOfint2.length);
/* 3571 */     return arrayOfInt;
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
/*      */   public static long[] addAll(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 3592 */     if (paramArrayOflong1 == null)
/* 3593 */       return clone(paramArrayOflong2); 
/* 3594 */     if (paramArrayOflong2 == null) {
/* 3595 */       return clone(paramArrayOflong1);
/*      */     }
/* 3597 */     long[] arrayOfLong = new long[paramArrayOflong1.length + paramArrayOflong2.length];
/* 3598 */     System.arraycopy(paramArrayOflong1, 0, arrayOfLong, 0, paramArrayOflong1.length);
/* 3599 */     System.arraycopy(paramArrayOflong2, 0, arrayOfLong, paramArrayOflong1.length, paramArrayOflong2.length);
/* 3600 */     return arrayOfLong;
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
/*      */   public static float[] addAll(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 3621 */     if (paramArrayOffloat1 == null)
/* 3622 */       return clone(paramArrayOffloat2); 
/* 3623 */     if (paramArrayOffloat2 == null) {
/* 3624 */       return clone(paramArrayOffloat1);
/*      */     }
/* 3626 */     float[] arrayOfFloat = new float[paramArrayOffloat1.length + paramArrayOffloat2.length];
/* 3627 */     System.arraycopy(paramArrayOffloat1, 0, arrayOfFloat, 0, paramArrayOffloat1.length);
/* 3628 */     System.arraycopy(paramArrayOffloat2, 0, arrayOfFloat, paramArrayOffloat1.length, paramArrayOffloat2.length);
/* 3629 */     return arrayOfFloat;
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
/*      */   public static double[] addAll(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/* 3650 */     if (paramArrayOfdouble1 == null)
/* 3651 */       return clone(paramArrayOfdouble2); 
/* 3652 */     if (paramArrayOfdouble2 == null) {
/* 3653 */       return clone(paramArrayOfdouble1);
/*      */     }
/* 3655 */     double[] arrayOfDouble = new double[paramArrayOfdouble1.length + paramArrayOfdouble2.length];
/* 3656 */     System.arraycopy(paramArrayOfdouble1, 0, arrayOfDouble, 0, paramArrayOfdouble1.length);
/* 3657 */     System.arraycopy(paramArrayOfdouble2, 0, arrayOfDouble, paramArrayOfdouble1.length, paramArrayOfdouble2.length);
/* 3658 */     return arrayOfDouble;
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
/*      */   public static Object[] add(Object[] paramArrayOfObject, Object paramObject) {
/*      */     Class clazz;
/* 3689 */     if (paramArrayOfObject != null) {
/* 3690 */       clazz = (Class)paramArrayOfObject.getClass();
/* 3691 */     } else if (paramObject != null) {
/* 3692 */       clazz = (Class)paramObject.getClass();
/*      */     } else {
/* 3694 */       clazz = Object.class;
/*      */     } 
/* 3696 */     Object[] arrayOfObject = (Object[])copyArrayGrow1(paramArrayOfObject, clazz);
/* 3697 */     arrayOfObject[arrayOfObject.length - 1] = paramObject;
/* 3698 */     return arrayOfObject;
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
/*      */   public static boolean[] add(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 3723 */     boolean[] arrayOfBoolean = (boolean[])copyArrayGrow1(paramArrayOfboolean, boolean.class);
/* 3724 */     arrayOfBoolean[arrayOfBoolean.length - 1] = paramBoolean;
/* 3725 */     return arrayOfBoolean;
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
/*      */   public static byte[] add(byte[] paramArrayOfbyte, byte paramByte) {
/* 3750 */     byte[] arrayOfByte = (byte[])copyArrayGrow1(paramArrayOfbyte, byte.class);
/* 3751 */     arrayOfByte[arrayOfByte.length - 1] = paramByte;
/* 3752 */     return arrayOfByte;
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
/*      */   public static char[] add(char[] paramArrayOfchar, char paramChar) {
/* 3777 */     char[] arrayOfChar = (char[])copyArrayGrow1(paramArrayOfchar, char.class);
/* 3778 */     arrayOfChar[arrayOfChar.length - 1] = paramChar;
/* 3779 */     return arrayOfChar;
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
/*      */   public static double[] add(double[] paramArrayOfdouble, double paramDouble) {
/* 3804 */     double[] arrayOfDouble = (double[])copyArrayGrow1(paramArrayOfdouble, double.class);
/* 3805 */     arrayOfDouble[arrayOfDouble.length - 1] = paramDouble;
/* 3806 */     return arrayOfDouble;
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
/*      */   public static float[] add(float[] paramArrayOffloat, float paramFloat) {
/* 3831 */     float[] arrayOfFloat = (float[])copyArrayGrow1(paramArrayOffloat, float.class);
/* 3832 */     arrayOfFloat[arrayOfFloat.length - 1] = paramFloat;
/* 3833 */     return arrayOfFloat;
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
/*      */   public static int[] add(int[] paramArrayOfint, int paramInt) {
/* 3858 */     int[] arrayOfInt = (int[])copyArrayGrow1(paramArrayOfint, int.class);
/* 3859 */     arrayOfInt[arrayOfInt.length - 1] = paramInt;
/* 3860 */     return arrayOfInt;
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
/*      */   public static long[] add(long[] paramArrayOflong, long paramLong) {
/* 3885 */     long[] arrayOfLong = (long[])copyArrayGrow1(paramArrayOflong, long.class);
/* 3886 */     arrayOfLong[arrayOfLong.length - 1] = paramLong;
/* 3887 */     return arrayOfLong;
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
/*      */   public static short[] add(short[] paramArrayOfshort, short paramShort) {
/* 3912 */     short[] arrayOfShort = (short[])copyArrayGrow1(paramArrayOfshort, short.class);
/* 3913 */     arrayOfShort[arrayOfShort.length - 1] = paramShort;
/* 3914 */     return arrayOfShort;
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
/*      */   private static Object copyArrayGrow1(Object paramObject, Class paramClass) {
/* 3927 */     if (paramObject != null) {
/* 3928 */       int i = Array.getLength(paramObject);
/* 3929 */       Object object = Array.newInstance(paramObject.getClass().getComponentType(), i + 1);
/* 3930 */       System.arraycopy(paramObject, 0, object, 0, i);
/* 3931 */       return object;
/*      */     } 
/* 3933 */     return Array.newInstance(paramClass, 1);
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
/*      */   public static Object[] add(Object[] paramArrayOfObject, int paramInt, Object paramObject) {
/* 3965 */     Class clazz = null;
/* 3966 */     if (paramArrayOfObject != null) {
/* 3967 */       clazz = paramArrayOfObject.getClass().getComponentType();
/* 3968 */     } else if (paramObject != null) {
/* 3969 */       clazz = paramObject.getClass();
/*      */     } else {
/* 3971 */       return new Object[] { null };
/*      */     } 
/* 3973 */     return (Object[])add(paramArrayOfObject, paramInt, paramObject, clazz);
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
/*      */   public static boolean[] add(boolean[] paramArrayOfboolean, int paramInt, boolean paramBoolean) {
/* 4004 */     return (boolean[])add(paramArrayOfboolean, paramInt, BooleanUtils.toBooleanObject(paramBoolean), boolean.class);
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
/*      */   public static char[] add(char[] paramArrayOfchar, int paramInt, char paramChar) {
/* 4036 */     return (char[])add(paramArrayOfchar, paramInt, new Character(paramChar), char.class);
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
/*      */   public static byte[] add(byte[] paramArrayOfbyte, int paramInt, byte paramByte) {
/* 4067 */     return (byte[])add(paramArrayOfbyte, paramInt, new Byte(paramByte), byte.class);
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
/*      */   public static short[] add(short[] paramArrayOfshort, int paramInt, short paramShort) {
/* 4098 */     return (short[])add(paramArrayOfshort, paramInt, new Short(paramShort), short.class);
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
/*      */   public static int[] add(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 4129 */     return (int[])add(paramArrayOfint, paramInt1, new Integer(paramInt2), int.class);
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
/*      */   public static long[] add(long[] paramArrayOflong, int paramInt, long paramLong) {
/* 4160 */     return (long[])add(paramArrayOflong, paramInt, new Long(paramLong), long.class);
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
/*      */   public static float[] add(float[] paramArrayOffloat, int paramInt, float paramFloat) {
/* 4191 */     return (float[])add(paramArrayOffloat, paramInt, new Float(paramFloat), float.class);
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
/*      */   public static double[] add(double[] paramArrayOfdouble, int paramInt, double paramDouble) {
/* 4222 */     return (double[])add(paramArrayOfdouble, paramInt, new Double(paramDouble), double.class);
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
/*      */   private static Object add(Object paramObject1, int paramInt, Object paramObject2, Class paramClass) {
/* 4237 */     if (paramObject1 == null) {
/* 4238 */       if (paramInt != 0) {
/* 4239 */         throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: 0");
/*      */       }
/* 4241 */       Object object1 = Array.newInstance(paramClass, 1);
/* 4242 */       Array.set(object1, 0, paramObject2);
/* 4243 */       return object1;
/*      */     } 
/* 4245 */     int i = Array.getLength(paramObject1);
/* 4246 */     if (paramInt > i || paramInt < 0) {
/* 4247 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
/*      */     }
/* 4249 */     Object object = Array.newInstance(paramClass, i + 1);
/* 4250 */     System.arraycopy(paramObject1, 0, object, 0, paramInt);
/* 4251 */     Array.set(object, paramInt, paramObject2);
/* 4252 */     if (paramInt < i) {
/* 4253 */       System.arraycopy(paramObject1, paramInt, object, paramInt + 1, i - paramInt);
/*      */     }
/* 4255 */     return object;
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
/*      */   public static Object[] remove(Object[] paramArrayOfObject, int paramInt) {
/* 4287 */     return (Object[])remove(paramArrayOfObject, paramInt);
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
/*      */   public static Object[] removeElement(Object[] paramArrayOfObject, Object paramObject) {
/* 4316 */     int i = indexOf(paramArrayOfObject, paramObject);
/* 4317 */     if (i == -1) {
/* 4318 */       return clone(paramArrayOfObject);
/*      */     }
/* 4320 */     return remove(paramArrayOfObject, i);
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
/*      */   public static boolean[] remove(boolean[] paramArrayOfboolean, int paramInt) {
/* 4352 */     return (boolean[])remove(paramArrayOfboolean, paramInt);
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
/*      */   public static boolean[] removeElement(boolean[] paramArrayOfboolean, boolean paramBoolean) {
/* 4381 */     int i = indexOf(paramArrayOfboolean, paramBoolean);
/* 4382 */     if (i == -1) {
/* 4383 */       return clone(paramArrayOfboolean);
/*      */     }
/* 4385 */     return remove(paramArrayOfboolean, i);
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
/*      */   public static byte[] remove(byte[] paramArrayOfbyte, int paramInt) {
/* 4417 */     return (byte[])remove(paramArrayOfbyte, paramInt);
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
/*      */   public static byte[] removeElement(byte[] paramArrayOfbyte, byte paramByte) {
/* 4446 */     int i = indexOf(paramArrayOfbyte, paramByte);
/* 4447 */     if (i == -1) {
/* 4448 */       return clone(paramArrayOfbyte);
/*      */     }
/* 4450 */     return remove(paramArrayOfbyte, i);
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
/*      */   public static char[] remove(char[] paramArrayOfchar, int paramInt) {
/* 4482 */     return (char[])remove(paramArrayOfchar, paramInt);
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
/*      */   public static char[] removeElement(char[] paramArrayOfchar, char paramChar) {
/* 4511 */     int i = indexOf(paramArrayOfchar, paramChar);
/* 4512 */     if (i == -1) {
/* 4513 */       return clone(paramArrayOfchar);
/*      */     }
/* 4515 */     return remove(paramArrayOfchar, i);
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
/*      */   public static double[] remove(double[] paramArrayOfdouble, int paramInt) {
/* 4547 */     return (double[])remove(paramArrayOfdouble, paramInt);
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
/*      */   public static double[] removeElement(double[] paramArrayOfdouble, double paramDouble) {
/* 4576 */     int i = indexOf(paramArrayOfdouble, paramDouble);
/* 4577 */     if (i == -1) {
/* 4578 */       return clone(paramArrayOfdouble);
/*      */     }
/* 4580 */     return remove(paramArrayOfdouble, i);
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
/*      */   public static float[] remove(float[] paramArrayOffloat, int paramInt) {
/* 4612 */     return (float[])remove(paramArrayOffloat, paramInt);
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
/*      */   public static float[] removeElement(float[] paramArrayOffloat, float paramFloat) {
/* 4641 */     int i = indexOf(paramArrayOffloat, paramFloat);
/* 4642 */     if (i == -1) {
/* 4643 */       return clone(paramArrayOffloat);
/*      */     }
/* 4645 */     return remove(paramArrayOffloat, i);
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
/*      */   public static int[] remove(int[] paramArrayOfint, int paramInt) {
/* 4677 */     return (int[])remove(paramArrayOfint, paramInt);
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
/*      */   public static int[] removeElement(int[] paramArrayOfint, int paramInt) {
/* 4706 */     int i = indexOf(paramArrayOfint, paramInt);
/* 4707 */     if (i == -1) {
/* 4708 */       return clone(paramArrayOfint);
/*      */     }
/* 4710 */     return remove(paramArrayOfint, i);
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
/*      */   public static long[] remove(long[] paramArrayOflong, int paramInt) {
/* 4742 */     return (long[])remove(paramArrayOflong, paramInt);
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
/*      */   public static long[] removeElement(long[] paramArrayOflong, long paramLong) {
/* 4771 */     int i = indexOf(paramArrayOflong, paramLong);
/* 4772 */     if (i == -1) {
/* 4773 */       return clone(paramArrayOflong);
/*      */     }
/* 4775 */     return remove(paramArrayOflong, i);
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
/*      */   public static short[] remove(short[] paramArrayOfshort, int paramInt) {
/* 4807 */     return (short[])remove(paramArrayOfshort, paramInt);
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
/*      */   public static short[] removeElement(short[] paramArrayOfshort, short paramShort) {
/* 4836 */     int i = indexOf(paramArrayOfshort, paramShort);
/* 4837 */     if (i == -1) {
/* 4838 */       return clone(paramArrayOfshort);
/*      */     }
/* 4840 */     return remove(paramArrayOfshort, i);
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
/*      */   private static Object remove(Object paramObject, int paramInt) {
/* 4865 */     int i = getLength(paramObject);
/* 4866 */     if (paramInt < 0 || paramInt >= i) {
/* 4867 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Length: " + i);
/*      */     }
/*      */     
/* 4870 */     Object object = Array.newInstance(paramObject.getClass().getComponentType(), i - 1);
/* 4871 */     System.arraycopy(paramObject, 0, object, 0, paramInt);
/* 4872 */     if (paramInt < i - 1) {
/* 4873 */       System.arraycopy(paramObject, paramInt + 1, object, paramInt, i - paramInt - 1);
/*      */     }
/*      */     
/* 4876 */     return object;
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/ArrayUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */