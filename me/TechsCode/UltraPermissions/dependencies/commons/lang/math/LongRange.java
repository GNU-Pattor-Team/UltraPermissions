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
/*     */ public final class LongRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892720L;
/*     */   private final long min;
/*     */   private final long max;
/*  51 */   private transient Long minObject = null;
/*     */ 
/*     */ 
/*     */   
/*  55 */   private transient Long maxObject = null;
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
/*     */   public LongRange(long paramLong) {
/*  73 */     this.min = paramLong;
/*  74 */     this.max = paramLong;
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
/*     */   public LongRange(Number paramNumber) {
/*  87 */     if (paramNumber == null) {
/*  88 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  90 */     this.min = paramNumber.longValue();
/*  91 */     this.max = paramNumber.longValue();
/*  92 */     if (paramNumber instanceof Long) {
/*  93 */       this.minObject = (Long)paramNumber;
/*  94 */       this.maxObject = (Long)paramNumber;
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
/*     */   public LongRange(long paramLong1, long paramLong2) {
/* 110 */     if (paramLong2 < paramLong1) {
/* 111 */       this.min = paramLong2;
/* 112 */       this.max = paramLong1;
/*     */     } else {
/* 114 */       this.min = paramLong1;
/* 115 */       this.max = paramLong2;
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
/*     */   public LongRange(Number paramNumber1, Number paramNumber2) {
/* 132 */     if (paramNumber1 == null || paramNumber2 == null) {
/* 133 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 135 */     long l1 = paramNumber1.longValue();
/* 136 */     long l2 = paramNumber2.longValue();
/* 137 */     if (l2 < l1) {
/* 138 */       this.min = l2;
/* 139 */       this.max = l1;
/* 140 */       if (paramNumber2 instanceof Long) {
/* 141 */         this.minObject = (Long)paramNumber2;
/*     */       }
/* 143 */       if (paramNumber1 instanceof Long) {
/* 144 */         this.maxObject = (Long)paramNumber1;
/*     */       }
/*     */     } else {
/* 147 */       this.min = l1;
/* 148 */       this.max = l2;
/* 149 */       if (paramNumber1 instanceof Long) {
/* 150 */         this.minObject = (Long)paramNumber1;
/*     */       }
/* 152 */       if (paramNumber2 instanceof Long) {
/* 153 */         this.maxObject = (Long)paramNumber2;
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
/* 167 */     if (this.minObject == null) {
/* 168 */       this.minObject = new Long(this.min);
/*     */     }
/* 170 */     return this.minObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMinimumLong() {
/* 179 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumInteger() {
/* 190 */     return (int)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumDouble() {
/* 201 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMinimumFloat() {
/* 212 */     return (float)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 221 */     if (this.maxObject == null) {
/* 222 */       this.maxObject = new Long(this.max);
/*     */     }
/* 224 */     return this.maxObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaximumLong() {
/* 233 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaximumInteger() {
/* 244 */     return (int)this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumDouble() {
/* 255 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaximumFloat() {
/* 266 */     return (float)this.max;
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
/* 282 */     if (paramNumber == null) {
/* 283 */       return false;
/*     */     }
/* 285 */     return containsLong(paramNumber.longValue());
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
/*     */   public boolean containsLong(long paramLong) {
/* 300 */     return (paramLong >= this.min && paramLong <= this.max);
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
/* 317 */     if (paramRange == null) {
/* 318 */       return false;
/*     */     }
/* 320 */     return (containsLong(paramRange.getMinimumLong()) && containsLong(paramRange.getMaximumLong()));
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
/* 334 */     if (paramRange == null) {
/* 335 */       return false;
/*     */     }
/* 337 */     return (paramRange.containsLong(this.min) || paramRange.containsLong(this.max) || containsLong(paramRange.getMinimumLong()));
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
/* 354 */     if (paramObject == this) {
/* 355 */       return true;
/*     */     }
/* 357 */     if (!(paramObject instanceof LongRange)) {
/* 358 */       return false;
/*     */     }
/* 360 */     LongRange longRange = (LongRange)paramObject;
/* 361 */     return (this.min == longRange.min && this.max == longRange.max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 370 */     if (this.hashCode == 0) {
/* 371 */       this.hashCode = 17;
/* 372 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 373 */       this.hashCode = 37 * this.hashCode + (int)(this.min ^ this.min >> 32L);
/* 374 */       this.hashCode = 37 * this.hashCode + (int)(this.max ^ this.max >> 32L);
/*     */     } 
/* 376 */     return this.hashCode;
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
/* 387 */     if (this.toString == null) {
/* 388 */       StrBuilder strBuilder = new StrBuilder(32);
/* 389 */       strBuilder.append("Range[");
/* 390 */       strBuilder.append(this.min);
/* 391 */       strBuilder.append(',');
/* 392 */       strBuilder.append(this.max);
/* 393 */       strBuilder.append(']');
/* 394 */       this.toString = strBuilder.toString();
/*     */     } 
/* 396 */     return this.toString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] toArray() {
/* 406 */     long[] arrayOfLong = new long[(int)(this.max - this.min + 1L)];
/* 407 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 408 */       arrayOfLong[b] = this.min + b;
/*     */     }
/* 410 */     return arrayOfLong;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/LongRange.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */