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
/*     */ 
/*     */ 
/*     */ public final class NumberRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892710L;
/*     */   private final Number min;
/*     */   private final Number max;
/*  53 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/*  57 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NumberRange(Number paramNumber) {
/*  69 */     if (paramNumber == null) {
/*  70 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  72 */     if (!(paramNumber instanceof Comparable)) {
/*  73 */       throw new IllegalArgumentException("The number must implement Comparable");
/*     */     }
/*  75 */     if (paramNumber instanceof Double && ((Double)paramNumber).isNaN()) {
/*  76 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*  78 */     if (paramNumber instanceof Float && ((Float)paramNumber).isNaN()) {
/*  79 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*     */     
/*  82 */     this.min = paramNumber;
/*  83 */     this.max = paramNumber;
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
/*     */   public NumberRange(Number paramNumber1, Number paramNumber2) {
/* 105 */     if (paramNumber1 == null || paramNumber2 == null) {
/* 106 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 108 */     if (paramNumber1.getClass() != paramNumber2.getClass()) {
/* 109 */       throw new IllegalArgumentException("The numbers must be of the same type");
/*     */     }
/* 111 */     if (!(paramNumber1 instanceof Comparable)) {
/* 112 */       throw new IllegalArgumentException("The numbers must implement Comparable");
/*     */     }
/* 114 */     if (paramNumber1 instanceof Double) {
/* 115 */       if (((Double)paramNumber1).isNaN() || ((Double)paramNumber2).isNaN()) {
/* 116 */         throw new IllegalArgumentException("The number must not be NaN");
/*     */       }
/* 118 */     } else if (paramNumber1 instanceof Float && ((
/* 119 */       (Float)paramNumber1).isNaN() || ((Float)paramNumber2).isNaN())) {
/* 120 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     } 
/*     */ 
/*     */     
/* 124 */     int i = ((Comparable)paramNumber1).compareTo(paramNumber2);
/* 125 */     if (i == 0) {
/* 126 */       this.min = paramNumber1;
/* 127 */       this.max = paramNumber1;
/* 128 */     } else if (i > 0) {
/* 129 */       this.min = paramNumber2;
/* 130 */       this.max = paramNumber1;
/*     */     } else {
/* 132 */       this.min = paramNumber1;
/* 133 */       this.max = paramNumber2;
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
/* 146 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 155 */     return this.max;
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
/*     */   public boolean containsNumber(Number paramNumber) {
/* 172 */     if (paramNumber == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (paramNumber.getClass() != this.min.getClass()) {
/* 176 */       throw new IllegalArgumentException("The number must be of the same type as the range numbers");
/*     */     }
/* 178 */     int i = ((Comparable)this.min).compareTo(paramNumber);
/* 179 */     int j = ((Comparable)this.max).compareTo(paramNumber);
/* 180 */     return (i <= 0 && j >= 0);
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
/*     */   public boolean equals(Object paramObject) {
/* 199 */     if (paramObject == this) {
/* 200 */       return true;
/*     */     }
/* 202 */     if (!(paramObject instanceof NumberRange)) {
/* 203 */       return false;
/*     */     }
/* 205 */     NumberRange numberRange = (NumberRange)paramObject;
/* 206 */     return (this.min.equals(numberRange.min) && this.max.equals(numberRange.max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 215 */     if (this.hashCode == 0) {
/* 216 */       this.hashCode = 17;
/* 217 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 218 */       this.hashCode = 37 * this.hashCode + this.min.hashCode();
/* 219 */       this.hashCode = 37 * this.hashCode + this.max.hashCode();
/*     */     } 
/* 221 */     return this.hashCode;
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
/* 232 */     if (this.toString == null) {
/* 233 */       StrBuilder strBuilder = new StrBuilder(32);
/* 234 */       strBuilder.append("Range[");
/* 235 */       strBuilder.append(this.min);
/* 236 */       strBuilder.append(',');
/* 237 */       strBuilder.append(this.max);
/* 238 */       strBuilder.append(']');
/* 239 */       this.toString = strBuilder.toString();
/*     */     } 
/* 241 */     return this.toString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/NumberRange.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */