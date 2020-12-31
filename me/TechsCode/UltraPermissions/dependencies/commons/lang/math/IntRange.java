/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.math;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public final class IntRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892730L;
/*     */   private final int min;
/*     */   private final int max;
/*  51 */   private transient Integer minObject = null;
/*     */ 
/*     */ 
/*     */   
/*  55 */   private transient Integer maxObject = null;
/*     */ 
/*     */ 
/*     */   
/*  59 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/*  63 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntRange(int paramInt) {
/*  73 */     this.min = paramInt;
/*  74 */     this.max = paramInt;
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
/*     */   public IntRange(Number paramNumber) {
/*  86 */     if (paramNumber == null) {
/*  87 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  89 */     this.min = paramNumber.intValue();
/*  90 */     this.max = paramNumber.intValue();
/*  91 */     if (paramNumber instanceof Integer) {
/*  92 */       this.minObject = (Integer)paramNumber;
/*  93 */       this.maxObject = (Integer)paramNumber;
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
/*     */   public IntRange(int paramInt1, int paramInt2) {
/* 109 */     if (paramInt2 < paramInt1) {
/* 110 */       this.min = paramInt2;
/* 111 */       this.max = paramInt1;
/*     */     } else {
/* 113 */       this.min = paramInt1;
/* 114 */       this.max = paramInt2;
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
/*     */   public IntRange(Number paramNumber1, Number paramNumber2) {
/* 131 */     if (paramNumber1 == null || paramNumber2 == null) {
/* 132 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 134 */     int i = paramNumber1.intValue();
/* 135 */     int j = paramNumber2.intValue();
/* 136 */     if (j < i) {
/* 137 */       this.min = j;
/* 138 */       this.max = i;
/* 139 */       if (paramNumber2 instanceof Integer) {
/* 140 */         this.minObject = (Integer)paramNumber2;
/*     */       }
/* 142 */       if (paramNumber1 instanceof Integer) {
/* 143 */         this.maxObject = (Integer)paramNumber1;
/*     */       }
/*     */     } else {
/* 146 */       this.min = i;
/* 147 */       this.max = j;
/* 148 */       if (paramNumber1 instanceof Integer) {
/* 149 */         this.minObject = (Integer)paramNumber1;
/*     */       }
/* 151 */       if (paramNumber2 instanceof Integer) {
/* 152 */         this.maxObject = (Integer)paramNumber2;
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
/*     */   public Number getMinimumNumber() {
/* 166 */     if (this.minObject == null) {
/* 167 */       this.minObject = new Integer(this.min);
/*     */     }
/* 169 */     return this.minObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMinimumLong() {
/* 178 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumInteger() {
/* 187 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumDouble() {
/* 196 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMinimumFloat() {
/* 205 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 214 */     if (this.maxObject == null) {
/* 215 */       this.maxObject = new Integer(this.max);
/*     */     }
/* 217 */     return this.maxObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaximumLong() {
/* 226 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaximumInteger() {
/* 235 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumDouble() {
/* 244 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaximumFloat() {
/* 253 */     return this.max;
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
/*     */   public boolean containsNumber(Number paramNumber) {
/* 269 */     if (paramNumber == null) {
/* 270 */       return false;
/*     */     }
/* 272 */     return containsInteger(paramNumber.intValue());
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
/*     */   public boolean containsInteger(int paramInt) {
/* 287 */     return (paramInt >= this.min && paramInt <= this.max);
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
/*     */   public boolean containsRange(Range paramRange) {
/* 304 */     if (paramRange == null) {
/* 305 */       return false;
/*     */     }
/* 307 */     return (containsInteger(paramRange.getMinimumInteger()) && containsInteger(paramRange.getMaximumInteger()));
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
/*     */   public boolean overlapsRange(Range paramRange) {
/* 321 */     if (paramRange == null) {
/* 322 */       return false;
/*     */     }
/* 324 */     return (paramRange.containsInteger(this.min) || paramRange.containsInteger(this.max) || containsInteger(paramRange.getMinimumInteger()));
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
/*     */   public boolean equals(Object paramObject) {
/* 341 */     if (paramObject == this) {
/* 342 */       return true;
/*     */     }
/* 344 */     if (!(paramObject instanceof IntRange)) {
/* 345 */       return false;
/*     */     }
/* 347 */     IntRange intRange = (IntRange)paramObject;
/* 348 */     return (this.min == intRange.min && this.max == intRange.max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 357 */     if (this.hashCode == 0) {
/* 358 */       this.hashCode = 17;
/* 359 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 360 */       this.hashCode = 37 * this.hashCode + this.min;
/* 361 */       this.hashCode = 37 * this.hashCode + this.max;
/*     */     } 
/* 363 */     return this.hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 374 */     if (this.toString == null) {
/* 375 */       StrBuilder strBuilder = new StrBuilder(32);
/* 376 */       strBuilder.append("Range[");
/* 377 */       strBuilder.append(this.min);
/* 378 */       strBuilder.append(',');
/* 379 */       strBuilder.append(this.max);
/* 380 */       strBuilder.append(']');
/* 381 */       this.toString = strBuilder.toString();
/*     */     } 
/* 383 */     return this.toString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] toArray() {
/* 393 */     int[] arrayOfInt = new int[this.max - this.min + 1];
/* 394 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/* 395 */       arrayOfInt[b] = this.min + b;
/*     */     }
/*     */     
/* 398 */     return arrayOfInt;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/IntRange.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */