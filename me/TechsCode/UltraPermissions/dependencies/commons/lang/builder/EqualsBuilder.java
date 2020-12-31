/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.builder;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Collection;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EqualsBuilder
/*     */ {
/*     */   private boolean isEquals = true;
/*     */   
/*     */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2) {
/* 124 */     return reflectionEquals(paramObject1, paramObject2, false, null, null);
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
/*     */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, Collection paramCollection) {
/* 147 */     return reflectionEquals(paramObject1, paramObject2, ReflectionToStringBuilder.toNoNullStringArray(paramCollection));
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
/*     */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, String[] paramArrayOfString) {
/* 170 */     return reflectionEquals(paramObject1, paramObject2, false, null, paramArrayOfString);
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
/*     */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean) {
/* 194 */     return reflectionEquals(paramObject1, paramObject2, paramBoolean, null, null);
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
/*     */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean, Class paramClass) {
/* 223 */     return reflectionEquals(paramObject1, paramObject2, paramBoolean, paramClass, null);
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
/*     */   public static boolean reflectionEquals(Object paramObject1, Object paramObject2, boolean paramBoolean, Class paramClass, String[] paramArrayOfString) {
/*     */     Class clazz3;
/* 254 */     if (paramObject1 == paramObject2) {
/* 255 */       return true;
/*     */     }
/* 257 */     if (paramObject1 == null || paramObject2 == null) {
/* 258 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     Class clazz1 = paramObject1.getClass();
/* 265 */     Class clazz2 = paramObject2.getClass();
/*     */     
/* 267 */     if (clazz1.isInstance(paramObject2)) {
/* 268 */       clazz3 = clazz1;
/* 269 */       if (!clazz2.isInstance(paramObject1))
/*     */       {
/* 271 */         clazz3 = clazz2;
/*     */       }
/* 273 */     } else if (clazz2.isInstance(paramObject1)) {
/* 274 */       clazz3 = clazz2;
/* 275 */       if (!clazz1.isInstance(paramObject2))
/*     */       {
/* 277 */         clazz3 = clazz1;
/*     */       }
/*     */     } else {
/*     */       
/* 281 */       return false;
/*     */     } 
/* 283 */     EqualsBuilder equalsBuilder = new EqualsBuilder();
/*     */     try {
/* 285 */       reflectionAppend(paramObject1, paramObject2, clazz3, equalsBuilder, paramBoolean, paramArrayOfString);
/* 286 */       while (clazz3.getSuperclass() != null && clazz3 != paramClass) {
/* 287 */         clazz3 = clazz3.getSuperclass();
/* 288 */         reflectionAppend(paramObject1, paramObject2, clazz3, equalsBuilder, paramBoolean, paramArrayOfString);
/*     */       } 
/* 290 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 296 */       return false;
/*     */     } 
/* 298 */     return equalsBuilder.isEquals();
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
/*     */   private static void reflectionAppend(Object paramObject1, Object paramObject2, Class paramClass, EqualsBuilder paramEqualsBuilder, boolean paramBoolean, String[] paramArrayOfString) {
/* 319 */     Field[] arrayOfField = paramClass.getDeclaredFields();
/* 320 */     AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/* 321 */     for (byte b = 0; b < arrayOfField.length && paramEqualsBuilder.isEquals; b++) {
/* 322 */       Field field = arrayOfField[b];
/* 323 */       if (!ArrayUtils.contains((Object[])paramArrayOfString, field.getName()) && field.getName().indexOf('$') == -1 && (paramBoolean || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers())) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 328 */           paramEqualsBuilder.append(field.get(paramObject1), field.get(paramObject2));
/* 329 */         } catch (IllegalAccessException illegalAccessException) {
/*     */ 
/*     */           
/* 332 */           throw new InternalError("Unexpected IllegalAccessException");
/*     */         } 
/*     */       }
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
/*     */   public EqualsBuilder appendSuper(boolean paramBoolean) {
/* 348 */     if (!this.isEquals) {
/* 349 */       return this;
/*     */     }
/* 351 */     this.isEquals = paramBoolean;
/* 352 */     return this;
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
/*     */   public EqualsBuilder append(Object paramObject1, Object paramObject2) {
/* 366 */     if (!this.isEquals) {
/* 367 */       return this;
/*     */     }
/* 369 */     if (paramObject1 == paramObject2) {
/* 370 */       return this;
/*     */     }
/* 372 */     if (paramObject1 == null || paramObject2 == null) {
/* 373 */       setEquals(false);
/* 374 */       return this;
/*     */     } 
/* 376 */     Class clazz = paramObject1.getClass();
/* 377 */     if (!clazz.isArray()) {
/*     */       
/* 379 */       this.isEquals = paramObject1.equals(paramObject2);
/* 380 */     } else if (paramObject1.getClass() != paramObject2.getClass()) {
/*     */       
/* 382 */       setEquals(false);
/*     */ 
/*     */     
/*     */     }
/* 386 */     else if (paramObject1 instanceof long[]) {
/* 387 */       append((long[])paramObject1, (long[])paramObject2);
/* 388 */     } else if (paramObject1 instanceof int[]) {
/* 389 */       append((int[])paramObject1, (int[])paramObject2);
/* 390 */     } else if (paramObject1 instanceof short[]) {
/* 391 */       append((short[])paramObject1, (short[])paramObject2);
/* 392 */     } else if (paramObject1 instanceof char[]) {
/* 393 */       append((char[])paramObject1, (char[])paramObject2);
/* 394 */     } else if (paramObject1 instanceof byte[]) {
/* 395 */       append((byte[])paramObject1, (byte[])paramObject2);
/* 396 */     } else if (paramObject1 instanceof double[]) {
/* 397 */       append((double[])paramObject1, (double[])paramObject2);
/* 398 */     } else if (paramObject1 instanceof float[]) {
/* 399 */       append((float[])paramObject1, (float[])paramObject2);
/* 400 */     } else if (paramObject1 instanceof boolean[]) {
/* 401 */       append((boolean[])paramObject1, (boolean[])paramObject2);
/*     */     } else {
/*     */       
/* 404 */       append((Object[])paramObject1, (Object[])paramObject2);
/*     */     } 
/* 406 */     return this;
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
/*     */   public EqualsBuilder append(long paramLong1, long paramLong2) {
/* 421 */     if (!this.isEquals) {
/* 422 */       return this;
/*     */     }
/* 424 */     this.isEquals = (paramLong1 == paramLong2);
/* 425 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(int paramInt1, int paramInt2) {
/* 436 */     if (!this.isEquals) {
/* 437 */       return this;
/*     */     }
/* 439 */     this.isEquals = (paramInt1 == paramInt2);
/* 440 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(short paramShort1, short paramShort2) {
/* 451 */     if (!this.isEquals) {
/* 452 */       return this;
/*     */     }
/* 454 */     this.isEquals = (paramShort1 == paramShort2);
/* 455 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(char paramChar1, char paramChar2) {
/* 466 */     if (!this.isEquals) {
/* 467 */       return this;
/*     */     }
/* 469 */     this.isEquals = (paramChar1 == paramChar2);
/* 470 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(byte paramByte1, byte paramByte2) {
/* 481 */     if (!this.isEquals) {
/* 482 */       return this;
/*     */     }
/* 484 */     this.isEquals = (paramByte1 == paramByte2);
/* 485 */     return this;
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
/*     */   public EqualsBuilder append(double paramDouble1, double paramDouble2) {
/* 502 */     if (!this.isEquals) {
/* 503 */       return this;
/*     */     }
/* 505 */     return append(Double.doubleToLongBits(paramDouble1), Double.doubleToLongBits(paramDouble2));
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
/*     */   public EqualsBuilder append(float paramFloat1, float paramFloat2) {
/* 522 */     if (!this.isEquals) {
/* 523 */       return this;
/*     */     }
/* 525 */     return append(Float.floatToIntBits(paramFloat1), Float.floatToIntBits(paramFloat2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(boolean paramBoolean1, boolean paramBoolean2) {
/* 536 */     if (!this.isEquals) {
/* 537 */       return this;
/*     */     }
/* 539 */     this.isEquals = (paramBoolean1 == paramBoolean2);
/* 540 */     return this;
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
/*     */   public EqualsBuilder append(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/* 554 */     if (!this.isEquals) {
/* 555 */       return this;
/*     */     }
/* 557 */     if (paramArrayOfObject1 == paramArrayOfObject2) {
/* 558 */       return this;
/*     */     }
/* 560 */     if (paramArrayOfObject1 == null || paramArrayOfObject2 == null) {
/* 561 */       setEquals(false);
/* 562 */       return this;
/*     */     } 
/* 564 */     if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
/* 565 */       setEquals(false);
/* 566 */       return this;
/*     */     } 
/* 568 */     for (byte b = 0; b < paramArrayOfObject1.length && this.isEquals; b++) {
/* 569 */       append(paramArrayOfObject1[b], paramArrayOfObject2[b]);
/*     */     }
/* 571 */     return this;
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
/*     */   public EqualsBuilder append(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 585 */     if (!this.isEquals) {
/* 586 */       return this;
/*     */     }
/* 588 */     if (paramArrayOflong1 == paramArrayOflong2) {
/* 589 */       return this;
/*     */     }
/* 591 */     if (paramArrayOflong1 == null || paramArrayOflong2 == null) {
/* 592 */       setEquals(false);
/* 593 */       return this;
/*     */     } 
/* 595 */     if (paramArrayOflong1.length != paramArrayOflong2.length) {
/* 596 */       setEquals(false);
/* 597 */       return this;
/*     */     } 
/* 599 */     for (byte b = 0; b < paramArrayOflong1.length && this.isEquals; b++) {
/* 600 */       append(paramArrayOflong1[b], paramArrayOflong2[b]);
/*     */     }
/* 602 */     return this;
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
/*     */   public EqualsBuilder append(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 616 */     if (!this.isEquals) {
/* 617 */       return this;
/*     */     }
/* 619 */     if (paramArrayOfint1 == paramArrayOfint2) {
/* 620 */       return this;
/*     */     }
/* 622 */     if (paramArrayOfint1 == null || paramArrayOfint2 == null) {
/* 623 */       setEquals(false);
/* 624 */       return this;
/*     */     } 
/* 626 */     if (paramArrayOfint1.length != paramArrayOfint2.length) {
/* 627 */       setEquals(false);
/* 628 */       return this;
/*     */     } 
/* 630 */     for (byte b = 0; b < paramArrayOfint1.length && this.isEquals; b++) {
/* 631 */       append(paramArrayOfint1[b], paramArrayOfint2[b]);
/*     */     }
/* 633 */     return this;
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
/*     */   public EqualsBuilder append(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/* 647 */     if (!this.isEquals) {
/* 648 */       return this;
/*     */     }
/* 650 */     if (paramArrayOfshort1 == paramArrayOfshort2) {
/* 651 */       return this;
/*     */     }
/* 653 */     if (paramArrayOfshort1 == null || paramArrayOfshort2 == null) {
/* 654 */       setEquals(false);
/* 655 */       return this;
/*     */     } 
/* 657 */     if (paramArrayOfshort1.length != paramArrayOfshort2.length) {
/* 658 */       setEquals(false);
/* 659 */       return this;
/*     */     } 
/* 661 */     for (byte b = 0; b < paramArrayOfshort1.length && this.isEquals; b++) {
/* 662 */       append(paramArrayOfshort1[b], paramArrayOfshort2[b]);
/*     */     }
/* 664 */     return this;
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
/*     */   public EqualsBuilder append(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/* 678 */     if (!this.isEquals) {
/* 679 */       return this;
/*     */     }
/* 681 */     if (paramArrayOfchar1 == paramArrayOfchar2) {
/* 682 */       return this;
/*     */     }
/* 684 */     if (paramArrayOfchar1 == null || paramArrayOfchar2 == null) {
/* 685 */       setEquals(false);
/* 686 */       return this;
/*     */     } 
/* 688 */     if (paramArrayOfchar1.length != paramArrayOfchar2.length) {
/* 689 */       setEquals(false);
/* 690 */       return this;
/*     */     } 
/* 692 */     for (byte b = 0; b < paramArrayOfchar1.length && this.isEquals; b++) {
/* 693 */       append(paramArrayOfchar1[b], paramArrayOfchar2[b]);
/*     */     }
/* 695 */     return this;
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
/*     */   public EqualsBuilder append(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 709 */     if (!this.isEquals) {
/* 710 */       return this;
/*     */     }
/* 712 */     if (paramArrayOfbyte1 == paramArrayOfbyte2) {
/* 713 */       return this;
/*     */     }
/* 715 */     if (paramArrayOfbyte1 == null || paramArrayOfbyte2 == null) {
/* 716 */       setEquals(false);
/* 717 */       return this;
/*     */     } 
/* 719 */     if (paramArrayOfbyte1.length != paramArrayOfbyte2.length) {
/* 720 */       setEquals(false);
/* 721 */       return this;
/*     */     } 
/* 723 */     for (byte b = 0; b < paramArrayOfbyte1.length && this.isEquals; b++) {
/* 724 */       append(paramArrayOfbyte1[b], paramArrayOfbyte2[b]);
/*     */     }
/* 726 */     return this;
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
/*     */   public EqualsBuilder append(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/* 740 */     if (!this.isEquals) {
/* 741 */       return this;
/*     */     }
/* 743 */     if (paramArrayOfdouble1 == paramArrayOfdouble2) {
/* 744 */       return this;
/*     */     }
/* 746 */     if (paramArrayOfdouble1 == null || paramArrayOfdouble2 == null) {
/* 747 */       setEquals(false);
/* 748 */       return this;
/*     */     } 
/* 750 */     if (paramArrayOfdouble1.length != paramArrayOfdouble2.length) {
/* 751 */       setEquals(false);
/* 752 */       return this;
/*     */     } 
/* 754 */     for (byte b = 0; b < paramArrayOfdouble1.length && this.isEquals; b++) {
/* 755 */       append(paramArrayOfdouble1[b], paramArrayOfdouble2[b]);
/*     */     }
/* 757 */     return this;
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
/*     */   public EqualsBuilder append(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 771 */     if (!this.isEquals) {
/* 772 */       return this;
/*     */     }
/* 774 */     if (paramArrayOffloat1 == paramArrayOffloat2) {
/* 775 */       return this;
/*     */     }
/* 777 */     if (paramArrayOffloat1 == null || paramArrayOffloat2 == null) {
/* 778 */       setEquals(false);
/* 779 */       return this;
/*     */     } 
/* 781 */     if (paramArrayOffloat1.length != paramArrayOffloat2.length) {
/* 782 */       setEquals(false);
/* 783 */       return this;
/*     */     } 
/* 785 */     for (byte b = 0; b < paramArrayOffloat1.length && this.isEquals; b++) {
/* 786 */       append(paramArrayOffloat1[b], paramArrayOffloat2[b]);
/*     */     }
/* 788 */     return this;
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
/*     */   public EqualsBuilder append(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 802 */     if (!this.isEquals) {
/* 803 */       return this;
/*     */     }
/* 805 */     if (paramArrayOfboolean1 == paramArrayOfboolean2) {
/* 806 */       return this;
/*     */     }
/* 808 */     if (paramArrayOfboolean1 == null || paramArrayOfboolean2 == null) {
/* 809 */       setEquals(false);
/* 810 */       return this;
/*     */     } 
/* 812 */     if (paramArrayOfboolean1.length != paramArrayOfboolean2.length) {
/* 813 */       setEquals(false);
/* 814 */       return this;
/*     */     } 
/* 816 */     for (byte b = 0; b < paramArrayOfboolean1.length && this.isEquals; b++) {
/* 817 */       append(paramArrayOfboolean1[b], paramArrayOfboolean2[b]);
/*     */     }
/* 819 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEquals() {
/* 829 */     return this.isEquals;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setEquals(boolean paramBoolean) {
/* 839 */     this.isEquals = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 847 */     this.isEquals = true;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/builder/EqualsBuilder.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */