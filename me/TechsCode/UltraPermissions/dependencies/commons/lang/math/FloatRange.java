/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.math;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FloatRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892750L;
/*     */   private final float min;
/*     */   private final float max;
/*  49 */   private transient Float minObject = null;
/*     */ 
/*     */ 
/*     */   
/*  53 */   private transient Float maxObject = null;
/*     */ 
/*     */ 
/*     */   
/*  57 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/*  61 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatRange(float paramFloat) {
/*  72 */     if (Float.isNaN(paramFloat)) {
/*  73 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*  75 */     this.min = paramFloat;
/*  76 */     this.max = paramFloat;
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
/*     */   public FloatRange(Number paramNumber) {
/*  90 */     if (paramNumber == null) {
/*  91 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  93 */     this.min = paramNumber.floatValue();
/*  94 */     this.max = paramNumber.floatValue();
/*  95 */     if (Float.isNaN(this.min) || Float.isNaN(this.max)) {
/*  96 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*  98 */     if (paramNumber instanceof Float) {
/*  99 */       this.minObject = (Float)paramNumber;
/* 100 */       this.maxObject = (Float)paramNumber;
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
/*     */   public FloatRange(float paramFloat1, float paramFloat2) {
/* 117 */     if (Float.isNaN(paramFloat1) || Float.isNaN(paramFloat2)) {
/* 118 */       throw new IllegalArgumentException("The numbers must not be NaN");
/*     */     }
/* 120 */     if (paramFloat2 < paramFloat1) {
/* 121 */       this.min = paramFloat2;
/* 122 */       this.max = paramFloat1;
/*     */     } else {
/* 124 */       this.min = paramFloat1;
/* 125 */       this.max = paramFloat2;
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
/*     */   public FloatRange(Number paramNumber1, Number paramNumber2) {
/* 143 */     if (paramNumber1 == null || paramNumber2 == null) {
/* 144 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 146 */     float f1 = paramNumber1.floatValue();
/* 147 */     float f2 = paramNumber2.floatValue();
/* 148 */     if (Float.isNaN(f1) || Float.isNaN(f2)) {
/* 149 */       throw new IllegalArgumentException("The numbers must not be NaN");
/*     */     }
/* 151 */     if (f2 < f1) {
/* 152 */       this.min = f2;
/* 153 */       this.max = f1;
/* 154 */       if (paramNumber2 instanceof Float) {
/* 155 */         this.minObject = (Float)paramNumber2;
/*     */       }
/* 157 */       if (paramNumber1 instanceof Float) {
/* 158 */         this.maxObject = (Float)paramNumber1;
/*     */       }
/*     */     } else {
/* 161 */       this.min = f1;
/* 162 */       this.max = f2;
/* 163 */       if (paramNumber1 instanceof Float) {
/* 164 */         this.minObject = (Float)paramNumber1;
/*     */       }
/* 166 */       if (paramNumber2 instanceof Float) {
/* 167 */         this.maxObject = (Float)paramNumber2;
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
/* 181 */     if (this.minObject == null) {
/* 182 */       this.minObject = new Float(this.min);
/*     */     }
/* 184 */     return this.minObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMinimumLong() {
/* 195 */     return (long)this.min;
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
/* 206 */     return (int)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumDouble() {
/* 215 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMinimumFloat() {
/* 224 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 233 */     if (this.maxObject == null) {
/* 234 */       this.maxObject = new Float(this.max);
/*     */     }
/* 236 */     return this.maxObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaximumLong() {
/* 247 */     return (long)this.max;
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
/* 258 */     return (int)this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumDouble() {
/* 267 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaximumFloat() {
/* 276 */     return this.max;
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
/* 292 */     if (paramNumber == null) {
/* 293 */       return false;
/*     */     }
/* 295 */     return containsFloat(paramNumber.floatValue());
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
/*     */   public boolean containsFloat(float paramFloat) {
/* 310 */     return (paramFloat >= this.min && paramFloat <= this.max);
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
/* 327 */     if (paramRange == null) {
/* 328 */       return false;
/*     */     }
/* 330 */     return (containsFloat(paramRange.getMinimumFloat()) && containsFloat(paramRange.getMaximumFloat()));
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
/* 344 */     if (paramRange == null) {
/* 345 */       return false;
/*     */     }
/* 347 */     return (paramRange.containsFloat(this.min) || paramRange.containsFloat(this.max) || containsFloat(paramRange.getMinimumFloat()));
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
/* 364 */     if (paramObject == this) {
/* 365 */       return true;
/*     */     }
/* 367 */     if (!(paramObject instanceof FloatRange)) {
/* 368 */       return false;
/*     */     }
/* 370 */     FloatRange floatRange = (FloatRange)paramObject;
/* 371 */     return (Float.floatToIntBits(this.min) == Float.floatToIntBits(floatRange.min) && Float.floatToIntBits(this.max) == Float.floatToIntBits(floatRange.max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 381 */     if (this.hashCode == 0) {
/* 382 */       this.hashCode = 17;
/* 383 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 384 */       this.hashCode = 37 * this.hashCode + Float.floatToIntBits(this.min);
/* 385 */       this.hashCode = 37 * this.hashCode + Float.floatToIntBits(this.max);
/*     */     } 
/* 387 */     return this.hashCode;
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
/* 398 */     if (this.toString == null) {
/* 399 */       StringBuffer stringBuffer = new StringBuffer(32);
/* 400 */       stringBuffer.append("Range[");
/* 401 */       stringBuffer.append(this.min);
/* 402 */       stringBuffer.append(',');
/* 403 */       stringBuffer.append(this.max);
/* 404 */       stringBuffer.append(']');
/* 405 */       this.toString = stringBuffer.toString();
/*     */     } 
/* 407 */     return this.toString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/FloatRange.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */