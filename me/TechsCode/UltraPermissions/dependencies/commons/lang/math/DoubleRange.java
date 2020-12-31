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
/*     */ public final class DoubleRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892740L;
/*     */   private final double min;
/*     */   private final double max;
/*  51 */   private transient Double minObject = null;
/*     */ 
/*     */ 
/*     */   
/*  55 */   private transient Double maxObject = null;
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
/*     */   
/*     */   public DoubleRange(double paramDouble) {
/*  74 */     if (Double.isNaN(paramDouble)) {
/*  75 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*  77 */     this.min = paramDouble;
/*  78 */     this.max = paramDouble;
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
/*     */   public DoubleRange(Number paramNumber) {
/*  92 */     if (paramNumber == null) {
/*  93 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  95 */     this.min = paramNumber.doubleValue();
/*  96 */     this.max = paramNumber.doubleValue();
/*  97 */     if (Double.isNaN(this.min) || Double.isNaN(this.max)) {
/*  98 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/* 100 */     if (paramNumber instanceof Double) {
/* 101 */       this.minObject = (Double)paramNumber;
/* 102 */       this.maxObject = (Double)paramNumber;
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
/*     */   public DoubleRange(double paramDouble1, double paramDouble2) {
/* 119 */     if (Double.isNaN(paramDouble1) || Double.isNaN(paramDouble2)) {
/* 120 */       throw new IllegalArgumentException("The numbers must not be NaN");
/*     */     }
/* 122 */     if (paramDouble2 < paramDouble1) {
/* 123 */       this.min = paramDouble2;
/* 124 */       this.max = paramDouble1;
/*     */     } else {
/* 126 */       this.min = paramDouble1;
/* 127 */       this.max = paramDouble2;
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
/*     */   public DoubleRange(Number paramNumber1, Number paramNumber2) {
/* 145 */     if (paramNumber1 == null || paramNumber2 == null) {
/* 146 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 148 */     double d1 = paramNumber1.doubleValue();
/* 149 */     double d2 = paramNumber2.doubleValue();
/* 150 */     if (Double.isNaN(d1) || Double.isNaN(d2)) {
/* 151 */       throw new IllegalArgumentException("The numbers must not be NaN");
/*     */     }
/* 153 */     if (d2 < d1) {
/* 154 */       this.min = d2;
/* 155 */       this.max = d1;
/* 156 */       if (paramNumber2 instanceof Double) {
/* 157 */         this.minObject = (Double)paramNumber2;
/*     */       }
/* 159 */       if (paramNumber1 instanceof Double) {
/* 160 */         this.maxObject = (Double)paramNumber1;
/*     */       }
/*     */     } else {
/* 163 */       this.min = d1;
/* 164 */       this.max = d2;
/* 165 */       if (paramNumber1 instanceof Double) {
/* 166 */         this.minObject = (Double)paramNumber1;
/*     */       }
/* 168 */       if (paramNumber2 instanceof Double) {
/* 169 */         this.maxObject = (Double)paramNumber2;
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
/* 183 */     if (this.minObject == null) {
/* 184 */       this.minObject = new Double(this.min);
/*     */     }
/* 186 */     return this.minObject;
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
/* 197 */     return (long)this.min;
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
/* 208 */     return (int)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumDouble() {
/* 217 */     return this.min;
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
/* 228 */     return (float)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 237 */     if (this.maxObject == null) {
/* 238 */       this.maxObject = new Double(this.max);
/*     */     }
/* 240 */     return this.maxObject;
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
/* 251 */     return (long)this.max;
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
/* 262 */     return (int)this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumDouble() {
/* 271 */     return this.max;
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
/* 282 */     return (float)this.max;
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
/* 298 */     if (paramNumber == null) {
/* 299 */       return false;
/*     */     }
/* 301 */     return containsDouble(paramNumber.doubleValue());
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
/*     */   public boolean containsDouble(double paramDouble) {
/* 316 */     return (paramDouble >= this.min && paramDouble <= this.max);
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
/* 333 */     if (paramRange == null) {
/* 334 */       return false;
/*     */     }
/* 336 */     return (containsDouble(paramRange.getMinimumDouble()) && containsDouble(paramRange.getMaximumDouble()));
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
/* 350 */     if (paramRange == null) {
/* 351 */       return false;
/*     */     }
/* 353 */     return (paramRange.containsDouble(this.min) || paramRange.containsDouble(this.max) || containsDouble(paramRange.getMinimumDouble()));
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
/* 370 */     if (paramObject == this) {
/* 371 */       return true;
/*     */     }
/* 373 */     if (!(paramObject instanceof DoubleRange)) {
/* 374 */       return false;
/*     */     }
/* 376 */     DoubleRange doubleRange = (DoubleRange)paramObject;
/* 377 */     return (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(doubleRange.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(doubleRange.max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 387 */     if (this.hashCode == 0) {
/* 388 */       this.hashCode = 17;
/* 389 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 390 */       long l = Double.doubleToLongBits(this.min);
/* 391 */       this.hashCode = 37 * this.hashCode + (int)(l ^ l >> 32L);
/* 392 */       l = Double.doubleToLongBits(this.max);
/* 393 */       this.hashCode = 37 * this.hashCode + (int)(l ^ l >> 32L);
/*     */     } 
/* 395 */     return this.hashCode;
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
/* 406 */     if (this.toString == null) {
/* 407 */       StrBuilder strBuilder = new StrBuilder(32);
/* 408 */       strBuilder.append("Range[");
/* 409 */       strBuilder.append(this.min);
/* 410 */       strBuilder.append(',');
/* 411 */       strBuilder.append(this.max);
/* 412 */       strBuilder.append(']');
/* 413 */       this.toString = strBuilder.toString();
/*     */     } 
/* 415 */     return this.toString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/DoubleRange.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */