/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.builder;
/*      */ 
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.Collection;
/*      */ import java.util.Comparator;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.math.NumberUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CompareToBuilder
/*      */ {
/*  109 */   private int comparison = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2) {
/*  140 */     return reflectionCompare(paramObject1, paramObject2, false, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  172 */     return reflectionCompare(paramObject1, paramObject2, paramBoolean, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, Collection paramCollection) {
/*  205 */     return reflectionCompare(paramObject1, paramObject2, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, String[] paramArrayOfString) {
/*  238 */     return reflectionCompare(paramObject1, paramObject2, false, null, paramArrayOfString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, boolean paramBoolean, Class paramClass) {
/*  275 */     return reflectionCompare(paramObject1, paramObject2, paramBoolean, paramClass, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object paramObject1, Object paramObject2, boolean paramBoolean, Class paramClass, String[] paramArrayOfString) {
/*  317 */     if (paramObject1 == paramObject2) {
/*  318 */       return 0;
/*      */     }
/*  320 */     if (paramObject1 == null || paramObject2 == null) {
/*  321 */       throw new NullPointerException();
/*      */     }
/*  323 */     Class clazz = paramObject1.getClass();
/*  324 */     if (!clazz.isInstance(paramObject2)) {
/*  325 */       throw new ClassCastException();
/*      */     }
/*  327 */     CompareToBuilder compareToBuilder = new CompareToBuilder();
/*  328 */     reflectionAppend(paramObject1, paramObject2, clazz, compareToBuilder, paramBoolean, paramArrayOfString);
/*  329 */     while (clazz.getSuperclass() != null && clazz != paramClass) {
/*  330 */       clazz = clazz.getSuperclass();
/*  331 */       reflectionAppend(paramObject1, paramObject2, clazz, compareToBuilder, paramBoolean, paramArrayOfString);
/*      */     } 
/*  333 */     return compareToBuilder.toComparison();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void reflectionAppend(Object paramObject1, Object paramObject2, Class paramClass, CompareToBuilder paramCompareToBuilder, boolean paramBoolean, String[] paramArrayOfString) {
/*  355 */     Field[] arrayOfField = paramClass.getDeclaredFields();
/*  356 */     AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/*  357 */     for (byte b = 0; b < arrayOfField.length && paramCompareToBuilder.comparison == 0; b++) {
/*  358 */       Field field = arrayOfField[b];
/*  359 */       if (!ArrayUtils.contains((Object[])paramArrayOfString, field.getName()) && field.getName().indexOf('$') == -1 && (paramBoolean || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers())) {
/*      */         
/*      */         try {
/*      */ 
/*      */           
/*  364 */           paramCompareToBuilder.append(field.get(paramObject1), field.get(paramObject2));
/*  365 */         } catch (IllegalAccessException illegalAccessException) {
/*      */ 
/*      */           
/*  368 */           throw new InternalError("Unexpected IllegalAccessException");
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
/*      */   
/*      */   public CompareToBuilder appendSuper(int paramInt) {
/*  384 */     if (this.comparison != 0) {
/*  385 */       return this;
/*      */     }
/*  387 */     this.comparison = paramInt;
/*  388 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object paramObject1, Object paramObject2) {
/*  412 */     return append(paramObject1, paramObject2, (Comparator)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object paramObject1, Object paramObject2, Comparator paramComparator) {
/*  441 */     if (this.comparison != 0) {
/*  442 */       return this;
/*      */     }
/*  444 */     if (paramObject1 == paramObject2) {
/*  445 */       return this;
/*      */     }
/*  447 */     if (paramObject1 == null) {
/*  448 */       this.comparison = -1;
/*  449 */       return this;
/*      */     } 
/*  451 */     if (paramObject2 == null) {
/*  452 */       this.comparison = 1;
/*  453 */       return this;
/*      */     } 
/*  455 */     if (paramObject1.getClass().isArray()) {
/*      */ 
/*      */ 
/*      */       
/*  459 */       if (paramObject1 instanceof long[]) {
/*  460 */         append((long[])paramObject1, (long[])paramObject2);
/*  461 */       } else if (paramObject1 instanceof int[]) {
/*  462 */         append((int[])paramObject1, (int[])paramObject2);
/*  463 */       } else if (paramObject1 instanceof short[]) {
/*  464 */         append((short[])paramObject1, (short[])paramObject2);
/*  465 */       } else if (paramObject1 instanceof char[]) {
/*  466 */         append((char[])paramObject1, (char[])paramObject2);
/*  467 */       } else if (paramObject1 instanceof byte[]) {
/*  468 */         append((byte[])paramObject1, (byte[])paramObject2);
/*  469 */       } else if (paramObject1 instanceof double[]) {
/*  470 */         append((double[])paramObject1, (double[])paramObject2);
/*  471 */       } else if (paramObject1 instanceof float[]) {
/*  472 */         append((float[])paramObject1, (float[])paramObject2);
/*  473 */       } else if (paramObject1 instanceof boolean[]) {
/*  474 */         append((boolean[])paramObject1, (boolean[])paramObject2);
/*      */       }
/*      */       else {
/*      */         
/*  478 */         append((Object[])paramObject1, (Object[])paramObject2, paramComparator);
/*      */       }
/*      */     
/*      */     }
/*  482 */     else if (paramComparator == null) {
/*  483 */       this.comparison = ((Comparable)paramObject1).compareTo(paramObject2);
/*      */     } else {
/*  485 */       this.comparison = paramComparator.compare(paramObject1, paramObject2);
/*      */     } 
/*      */     
/*  488 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(long paramLong1, long paramLong2) {
/*  501 */     if (this.comparison != 0) {
/*  502 */       return this;
/*      */     }
/*  504 */     this.comparison = (paramLong1 < paramLong2) ? -1 : ((paramLong1 > paramLong2) ? 1 : 0);
/*  505 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(int paramInt1, int paramInt2) {
/*  517 */     if (this.comparison != 0) {
/*  518 */       return this;
/*      */     }
/*  520 */     this.comparison = (paramInt1 < paramInt2) ? -1 : ((paramInt1 > paramInt2) ? 1 : 0);
/*  521 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(short paramShort1, short paramShort2) {
/*  533 */     if (this.comparison != 0) {
/*  534 */       return this;
/*      */     }
/*  536 */     this.comparison = (paramShort1 < paramShort2) ? -1 : ((paramShort1 > paramShort2) ? 1 : 0);
/*  537 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(char paramChar1, char paramChar2) {
/*  549 */     if (this.comparison != 0) {
/*  550 */       return this;
/*      */     }
/*  552 */     this.comparison = (paramChar1 < paramChar2) ? -1 : ((paramChar1 > paramChar2) ? 1 : 0);
/*  553 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(byte paramByte1, byte paramByte2) {
/*  565 */     if (this.comparison != 0) {
/*  566 */       return this;
/*      */     }
/*  568 */     this.comparison = (paramByte1 < paramByte2) ? -1 : ((paramByte1 > paramByte2) ? 1 : 0);
/*  569 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(double paramDouble1, double paramDouble2) {
/*  586 */     if (this.comparison != 0) {
/*  587 */       return this;
/*      */     }
/*  589 */     this.comparison = NumberUtils.compare(paramDouble1, paramDouble2);
/*  590 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(float paramFloat1, float paramFloat2) {
/*  607 */     if (this.comparison != 0) {
/*  608 */       return this;
/*      */     }
/*  610 */     this.comparison = NumberUtils.compare(paramFloat1, paramFloat2);
/*  611 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(boolean paramBoolean1, boolean paramBoolean2) {
/*  623 */     if (this.comparison != 0) {
/*  624 */       return this;
/*      */     }
/*  626 */     if (paramBoolean1 == paramBoolean2) {
/*  627 */       return this;
/*      */     }
/*  629 */     if (!paramBoolean1) {
/*  630 */       this.comparison = -1;
/*      */     } else {
/*  632 */       this.comparison = 1;
/*      */     } 
/*  634 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  659 */     return append(paramArrayOfObject1, paramArrayOfObject2, (Comparator)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Comparator paramComparator) {
/*  686 */     if (this.comparison != 0) {
/*  687 */       return this;
/*      */     }
/*  689 */     if (paramArrayOfObject1 == paramArrayOfObject2) {
/*  690 */       return this;
/*      */     }
/*  692 */     if (paramArrayOfObject1 == null) {
/*  693 */       this.comparison = -1;
/*  694 */       return this;
/*      */     } 
/*  696 */     if (paramArrayOfObject2 == null) {
/*  697 */       this.comparison = 1;
/*  698 */       return this;
/*      */     } 
/*  700 */     if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
/*  701 */       this.comparison = (paramArrayOfObject1.length < paramArrayOfObject2.length) ? -1 : 1;
/*  702 */       return this;
/*      */     } 
/*  704 */     for (byte b = 0; b < paramArrayOfObject1.length && this.comparison == 0; b++) {
/*  705 */       append(paramArrayOfObject1[b], paramArrayOfObject2[b], paramComparator);
/*      */     }
/*  707 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/*  726 */     if (this.comparison != 0) {
/*  727 */       return this;
/*      */     }
/*  729 */     if (paramArrayOflong1 == paramArrayOflong2) {
/*  730 */       return this;
/*      */     }
/*  732 */     if (paramArrayOflong1 == null) {
/*  733 */       this.comparison = -1;
/*  734 */       return this;
/*      */     } 
/*  736 */     if (paramArrayOflong2 == null) {
/*  737 */       this.comparison = 1;
/*  738 */       return this;
/*      */     } 
/*  740 */     if (paramArrayOflong1.length != paramArrayOflong2.length) {
/*  741 */       this.comparison = (paramArrayOflong1.length < paramArrayOflong2.length) ? -1 : 1;
/*  742 */       return this;
/*      */     } 
/*  744 */     for (byte b = 0; b < paramArrayOflong1.length && this.comparison == 0; b++) {
/*  745 */       append(paramArrayOflong1[b], paramArrayOflong2[b]);
/*      */     }
/*  747 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  766 */     if (this.comparison != 0) {
/*  767 */       return this;
/*      */     }
/*  769 */     if (paramArrayOfint1 == paramArrayOfint2) {
/*  770 */       return this;
/*      */     }
/*  772 */     if (paramArrayOfint1 == null) {
/*  773 */       this.comparison = -1;
/*  774 */       return this;
/*      */     } 
/*  776 */     if (paramArrayOfint2 == null) {
/*  777 */       this.comparison = 1;
/*  778 */       return this;
/*      */     } 
/*  780 */     if (paramArrayOfint1.length != paramArrayOfint2.length) {
/*  781 */       this.comparison = (paramArrayOfint1.length < paramArrayOfint2.length) ? -1 : 1;
/*  782 */       return this;
/*      */     } 
/*  784 */     for (byte b = 0; b < paramArrayOfint1.length && this.comparison == 0; b++) {
/*  785 */       append(paramArrayOfint1[b], paramArrayOfint2[b]);
/*      */     }
/*  787 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/*  806 */     if (this.comparison != 0) {
/*  807 */       return this;
/*      */     }
/*  809 */     if (paramArrayOfshort1 == paramArrayOfshort2) {
/*  810 */       return this;
/*      */     }
/*  812 */     if (paramArrayOfshort1 == null) {
/*  813 */       this.comparison = -1;
/*  814 */       return this;
/*      */     } 
/*  816 */     if (paramArrayOfshort2 == null) {
/*  817 */       this.comparison = 1;
/*  818 */       return this;
/*      */     } 
/*  820 */     if (paramArrayOfshort1.length != paramArrayOfshort2.length) {
/*  821 */       this.comparison = (paramArrayOfshort1.length < paramArrayOfshort2.length) ? -1 : 1;
/*  822 */       return this;
/*      */     } 
/*  824 */     for (byte b = 0; b < paramArrayOfshort1.length && this.comparison == 0; b++) {
/*  825 */       append(paramArrayOfshort1[b], paramArrayOfshort2[b]);
/*      */     }
/*  827 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/*  846 */     if (this.comparison != 0) {
/*  847 */       return this;
/*      */     }
/*  849 */     if (paramArrayOfchar1 == paramArrayOfchar2) {
/*  850 */       return this;
/*      */     }
/*  852 */     if (paramArrayOfchar1 == null) {
/*  853 */       this.comparison = -1;
/*  854 */       return this;
/*      */     } 
/*  856 */     if (paramArrayOfchar2 == null) {
/*  857 */       this.comparison = 1;
/*  858 */       return this;
/*      */     } 
/*  860 */     if (paramArrayOfchar1.length != paramArrayOfchar2.length) {
/*  861 */       this.comparison = (paramArrayOfchar1.length < paramArrayOfchar2.length) ? -1 : 1;
/*  862 */       return this;
/*      */     } 
/*  864 */     for (byte b = 0; b < paramArrayOfchar1.length && this.comparison == 0; b++) {
/*  865 */       append(paramArrayOfchar1[b], paramArrayOfchar2[b]);
/*      */     }
/*  867 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  886 */     if (this.comparison != 0) {
/*  887 */       return this;
/*      */     }
/*  889 */     if (paramArrayOfbyte1 == paramArrayOfbyte2) {
/*  890 */       return this;
/*      */     }
/*  892 */     if (paramArrayOfbyte1 == null) {
/*  893 */       this.comparison = -1;
/*  894 */       return this;
/*      */     } 
/*  896 */     if (paramArrayOfbyte2 == null) {
/*  897 */       this.comparison = 1;
/*  898 */       return this;
/*      */     } 
/*  900 */     if (paramArrayOfbyte1.length != paramArrayOfbyte2.length) {
/*  901 */       this.comparison = (paramArrayOfbyte1.length < paramArrayOfbyte2.length) ? -1 : 1;
/*  902 */       return this;
/*      */     } 
/*  904 */     for (byte b = 0; b < paramArrayOfbyte1.length && this.comparison == 0; b++) {
/*  905 */       append(paramArrayOfbyte1[b], paramArrayOfbyte2[b]);
/*      */     }
/*  907 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/*  926 */     if (this.comparison != 0) {
/*  927 */       return this;
/*      */     }
/*  929 */     if (paramArrayOfdouble1 == paramArrayOfdouble2) {
/*  930 */       return this;
/*      */     }
/*  932 */     if (paramArrayOfdouble1 == null) {
/*  933 */       this.comparison = -1;
/*  934 */       return this;
/*      */     } 
/*  936 */     if (paramArrayOfdouble2 == null) {
/*  937 */       this.comparison = 1;
/*  938 */       return this;
/*      */     } 
/*  940 */     if (paramArrayOfdouble1.length != paramArrayOfdouble2.length) {
/*  941 */       this.comparison = (paramArrayOfdouble1.length < paramArrayOfdouble2.length) ? -1 : 1;
/*  942 */       return this;
/*      */     } 
/*  944 */     for (byte b = 0; b < paramArrayOfdouble1.length && this.comparison == 0; b++) {
/*  945 */       append(paramArrayOfdouble1[b], paramArrayOfdouble2[b]);
/*      */     }
/*  947 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/*  966 */     if (this.comparison != 0) {
/*  967 */       return this;
/*      */     }
/*  969 */     if (paramArrayOffloat1 == paramArrayOffloat2) {
/*  970 */       return this;
/*      */     }
/*  972 */     if (paramArrayOffloat1 == null) {
/*  973 */       this.comparison = -1;
/*  974 */       return this;
/*      */     } 
/*  976 */     if (paramArrayOffloat2 == null) {
/*  977 */       this.comparison = 1;
/*  978 */       return this;
/*      */     } 
/*  980 */     if (paramArrayOffloat1.length != paramArrayOffloat2.length) {
/*  981 */       this.comparison = (paramArrayOffloat1.length < paramArrayOffloat2.length) ? -1 : 1;
/*  982 */       return this;
/*      */     } 
/*  984 */     for (byte b = 0; b < paramArrayOffloat1.length && this.comparison == 0; b++) {
/*  985 */       append(paramArrayOffloat1[b], paramArrayOffloat2[b]);
/*      */     }
/*  987 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 1006 */     if (this.comparison != 0) {
/* 1007 */       return this;
/*      */     }
/* 1009 */     if (paramArrayOfboolean1 == paramArrayOfboolean2) {
/* 1010 */       return this;
/*      */     }
/* 1012 */     if (paramArrayOfboolean1 == null) {
/* 1013 */       this.comparison = -1;
/* 1014 */       return this;
/*      */     } 
/* 1016 */     if (paramArrayOfboolean2 == null) {
/* 1017 */       this.comparison = 1;
/* 1018 */       return this;
/*      */     } 
/* 1020 */     if (paramArrayOfboolean1.length != paramArrayOfboolean2.length) {
/* 1021 */       this.comparison = (paramArrayOfboolean1.length < paramArrayOfboolean2.length) ? -1 : 1;
/* 1022 */       return this;
/*      */     } 
/* 1024 */     for (byte b = 0; b < paramArrayOfboolean1.length && this.comparison == 0; b++) {
/* 1025 */       append(paramArrayOfboolean1[b], paramArrayOfboolean2[b]);
/*      */     }
/* 1027 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int toComparison() {
/* 1040 */     return this.comparison;
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/builder/CompareToBuilder.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */