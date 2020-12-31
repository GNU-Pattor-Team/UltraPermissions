/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.builder;
/*      */ 
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HashCodeBuilder
/*      */ {
/*  111 */   private static final ThreadLocal REGISTRY = new ThreadLocal();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int iConstant;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Set getRegistry() {
/*  139 */     return REGISTRY.get();
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
/*      */   static boolean isRegistered(Object paramObject) {
/*  154 */     Set set = getRegistry();
/*  155 */     return (set != null && set.contains(new IDKey(paramObject)));
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
/*      */   private static void reflectionAppend(Object paramObject, Class paramClass, HashCodeBuilder paramHashCodeBuilder, boolean paramBoolean, String[] paramArrayOfString) {
/*  176 */     if (isRegistered(paramObject)) {
/*      */       return;
/*      */     }
/*      */     try {
/*  180 */       register(paramObject);
/*  181 */       Field[] arrayOfField = paramClass.getDeclaredFields();
/*  182 */       AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/*  183 */       for (byte b = 0; b < arrayOfField.length; b++) {
/*  184 */         Field field = arrayOfField[b];
/*  185 */         if (!ArrayUtils.contains((Object[])paramArrayOfString, field.getName()) && field.getName().indexOf('$') == -1 && (paramBoolean || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers())) {
/*      */           
/*      */           try {
/*      */ 
/*      */             
/*  190 */             Object object = field.get(paramObject);
/*  191 */             paramHashCodeBuilder.append(object);
/*  192 */           } catch (IllegalAccessException illegalAccessException) {
/*      */ 
/*      */             
/*  195 */             throw new InternalError("Unexpected IllegalAccessException");
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } finally {
/*  200 */       unregister(paramObject);
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
/*      */   public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject) {
/*  242 */     return reflectionHashCode(paramInt1, paramInt2, paramObject, false, null, null);
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
/*      */   public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean) {
/*  286 */     return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, null, null);
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
/*      */   public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean, Class paramClass) {
/*  308 */     return reflectionHashCode(paramInt1, paramInt2, paramObject, paramBoolean, paramClass, null);
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
/*      */   public static int reflectionHashCode(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean, Class paramClass, String[] paramArrayOfString) {
/*  360 */     if (paramObject == null) {
/*  361 */       throw new IllegalArgumentException("The object to build a hash code for must not be null");
/*      */     }
/*  363 */     HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(paramInt1, paramInt2);
/*  364 */     Class clazz = paramObject.getClass();
/*  365 */     reflectionAppend(paramObject, clazz, hashCodeBuilder, paramBoolean, paramArrayOfString);
/*  366 */     while (clazz.getSuperclass() != null && clazz != paramClass) {
/*  367 */       clazz = clazz.getSuperclass();
/*  368 */       reflectionAppend(paramObject, clazz, hashCodeBuilder, paramBoolean, paramArrayOfString);
/*      */     } 
/*  370 */     return hashCodeBuilder.toHashCode();
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
/*      */   public static int reflectionHashCode(Object paramObject) {
/*  404 */     return reflectionHashCode(17, 37, paramObject, false, null, null);
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
/*      */   public static int reflectionHashCode(Object paramObject, boolean paramBoolean) {
/*  440 */     return reflectionHashCode(17, 37, paramObject, paramBoolean, null, null);
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
/*      */   public static int reflectionHashCode(Object paramObject, Collection paramCollection) {
/*  476 */     return reflectionHashCode(paramObject, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
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
/*      */   public static int reflectionHashCode(Object paramObject, String[] paramArrayOfString) {
/*  514 */     return reflectionHashCode(17, 37, paramObject, false, null, paramArrayOfString);
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
/*      */   static void register(Object paramObject) {
/*  526 */     synchronized (HashCodeBuilder.class) {
/*  527 */       if (getRegistry() == null) {
/*  528 */         REGISTRY.set(new HashSet());
/*      */       }
/*      */     } 
/*  531 */     getRegistry().add(new IDKey(paramObject));
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
/*      */   static void unregister(Object paramObject) {
/*  547 */     Set set = getRegistry();
/*  548 */     if (set != null) {
/*  549 */       set.remove(new IDKey(paramObject));
/*  550 */       synchronized (HashCodeBuilder.class) {
/*      */         
/*  552 */         set = getRegistry();
/*  553 */         if (set != null && set.isEmpty()) {
/*  554 */           REGISTRY.set(null);
/*      */         }
/*      */       } 
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
/*  568 */   private int iTotal = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HashCodeBuilder() {
/*  576 */     this.iConstant = 37;
/*  577 */     this.iTotal = 17;
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
/*      */   public HashCodeBuilder(int paramInt1, int paramInt2) {
/*  598 */     if (paramInt1 == 0) {
/*  599 */       throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
/*      */     }
/*  601 */     if (paramInt1 % 2 == 0) {
/*  602 */       throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
/*      */     }
/*  604 */     if (paramInt2 == 0) {
/*  605 */       throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
/*      */     }
/*  607 */     if (paramInt2 % 2 == 0) {
/*  608 */       throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
/*      */     }
/*  610 */     this.iConstant = paramInt2;
/*  611 */     this.iTotal = paramInt1;
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
/*      */   public HashCodeBuilder append(boolean paramBoolean) {
/*  636 */     this.iTotal = this.iTotal * this.iConstant + (paramBoolean ? 0 : 1);
/*  637 */     return this;
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
/*      */   public HashCodeBuilder append(boolean[] paramArrayOfboolean) {
/*  650 */     if (paramArrayOfboolean == null) {
/*  651 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  653 */       for (byte b = 0; b < paramArrayOfboolean.length; b++) {
/*  654 */         append(paramArrayOfboolean[b]);
/*      */       }
/*      */     } 
/*  657 */     return this;
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
/*      */   public HashCodeBuilder append(byte paramByte) {
/*  672 */     this.iTotal = this.iTotal * this.iConstant + paramByte;
/*  673 */     return this;
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
/*      */   public HashCodeBuilder append(byte[] paramArrayOfbyte) {
/*  688 */     if (paramArrayOfbyte == null) {
/*  689 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  691 */       for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/*  692 */         append(paramArrayOfbyte[b]);
/*      */       }
/*      */     } 
/*  695 */     return this;
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
/*      */   public HashCodeBuilder append(char paramChar) {
/*  708 */     this.iTotal = this.iTotal * this.iConstant + paramChar;
/*  709 */     return this;
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
/*      */   public HashCodeBuilder append(char[] paramArrayOfchar) {
/*  722 */     if (paramArrayOfchar == null) {
/*  723 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  725 */       for (byte b = 0; b < paramArrayOfchar.length; b++) {
/*  726 */         append(paramArrayOfchar[b]);
/*      */       }
/*      */     } 
/*  729 */     return this;
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
/*      */   public HashCodeBuilder append(double paramDouble) {
/*  742 */     return append(Double.doubleToLongBits(paramDouble));
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
/*      */   public HashCodeBuilder append(double[] paramArrayOfdouble) {
/*  755 */     if (paramArrayOfdouble == null) {
/*  756 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  758 */       for (byte b = 0; b < paramArrayOfdouble.length; b++) {
/*  759 */         append(paramArrayOfdouble[b]);
/*      */       }
/*      */     } 
/*  762 */     return this;
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
/*      */   public HashCodeBuilder append(float paramFloat) {
/*  775 */     this.iTotal = this.iTotal * this.iConstant + Float.floatToIntBits(paramFloat);
/*  776 */     return this;
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
/*      */   public HashCodeBuilder append(float[] paramArrayOffloat) {
/*  789 */     if (paramArrayOffloat == null) {
/*  790 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  792 */       for (byte b = 0; b < paramArrayOffloat.length; b++) {
/*  793 */         append(paramArrayOffloat[b]);
/*      */       }
/*      */     } 
/*  796 */     return this;
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
/*      */   public HashCodeBuilder append(int paramInt) {
/*  809 */     this.iTotal = this.iTotal * this.iConstant + paramInt;
/*  810 */     return this;
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
/*      */   public HashCodeBuilder append(int[] paramArrayOfint) {
/*  823 */     if (paramArrayOfint == null) {
/*  824 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  826 */       for (byte b = 0; b < paramArrayOfint.length; b++) {
/*  827 */         append(paramArrayOfint[b]);
/*      */       }
/*      */     } 
/*  830 */     return this;
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
/*      */   public HashCodeBuilder append(long paramLong) {
/*  847 */     this.iTotal = this.iTotal * this.iConstant + (int)(paramLong ^ paramLong >> 32L);
/*  848 */     return this;
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
/*      */   public HashCodeBuilder append(long[] paramArrayOflong) {
/*  861 */     if (paramArrayOflong == null) {
/*  862 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  864 */       for (byte b = 0; b < paramArrayOflong.length; b++) {
/*  865 */         append(paramArrayOflong[b]);
/*      */       }
/*      */     } 
/*  868 */     return this;
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
/*      */   public HashCodeBuilder append(Object paramObject) {
/*  881 */     if (paramObject == null) {
/*  882 */       this.iTotal *= this.iConstant;
/*      */     
/*      */     }
/*  885 */     else if (paramObject.getClass().isArray()) {
/*      */ 
/*      */       
/*  888 */       if (paramObject instanceof long[]) {
/*  889 */         append((long[])paramObject);
/*  890 */       } else if (paramObject instanceof int[]) {
/*  891 */         append((int[])paramObject);
/*  892 */       } else if (paramObject instanceof short[]) {
/*  893 */         append((short[])paramObject);
/*  894 */       } else if (paramObject instanceof char[]) {
/*  895 */         append((char[])paramObject);
/*  896 */       } else if (paramObject instanceof byte[]) {
/*  897 */         append((byte[])paramObject);
/*  898 */       } else if (paramObject instanceof double[]) {
/*  899 */         append((double[])paramObject);
/*  900 */       } else if (paramObject instanceof float[]) {
/*  901 */         append((float[])paramObject);
/*  902 */       } else if (paramObject instanceof boolean[]) {
/*  903 */         append((boolean[])paramObject);
/*      */       } else {
/*      */         
/*  906 */         append((Object[])paramObject);
/*      */       } 
/*      */     } else {
/*  909 */       this.iTotal = this.iTotal * this.iConstant + paramObject.hashCode();
/*      */     } 
/*      */     
/*  912 */     return this;
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
/*      */   public HashCodeBuilder append(Object[] paramArrayOfObject) {
/*  925 */     if (paramArrayOfObject == null) {
/*  926 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  928 */       for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*  929 */         append(paramArrayOfObject[b]);
/*      */       }
/*      */     } 
/*  932 */     return this;
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
/*      */   public HashCodeBuilder append(short paramShort) {
/*  945 */     this.iTotal = this.iTotal * this.iConstant + paramShort;
/*  946 */     return this;
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
/*      */   public HashCodeBuilder append(short[] paramArrayOfshort) {
/*  959 */     if (paramArrayOfshort == null) {
/*  960 */       this.iTotal *= this.iConstant;
/*      */     } else {
/*  962 */       for (byte b = 0; b < paramArrayOfshort.length; b++) {
/*  963 */         append(paramArrayOfshort[b]);
/*      */       }
/*      */     } 
/*  966 */     return this;
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
/*      */   public HashCodeBuilder appendSuper(int paramInt) {
/*  980 */     this.iTotal = this.iTotal * this.iConstant + paramInt;
/*  981 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int toHashCode() {
/*  992 */     return this.iTotal;
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
/*      */   public int hashCode() {
/* 1005 */     return toHashCode();
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/builder/HashCodeBuilder.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */