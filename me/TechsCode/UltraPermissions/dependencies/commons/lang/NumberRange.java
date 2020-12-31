/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NumberRange
/*     */ {
/*     */   private final Number min;
/*     */   private final Number max;
/*     */   
/*     */   public NumberRange(Number paramNumber) {
/*  55 */     if (paramNumber == null) {
/*  56 */       throw new NullPointerException("The number must not be null");
/*     */     }
/*     */     
/*  59 */     this.min = paramNumber;
/*  60 */     this.max = paramNumber;
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
/*     */   public NumberRange(Number paramNumber1, Number paramNumber2) {
/*  76 */     if (paramNumber1 == null)
/*  77 */       throw new NullPointerException("The minimum value must not be null"); 
/*  78 */     if (paramNumber2 == null) {
/*  79 */       throw new NullPointerException("The maximum value must not be null");
/*     */     }
/*     */     
/*  82 */     if (paramNumber2.doubleValue() < paramNumber1.doubleValue()) {
/*  83 */       this.min = this.max = paramNumber1;
/*     */     } else {
/*  85 */       this.min = paramNumber1;
/*  86 */       this.max = paramNumber2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMinimum() {
/*  96 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximum() {
/* 105 */     return this.max;
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
/*     */   public boolean includesNumber(Number paramNumber) {
/* 117 */     if (paramNumber == null) {
/* 118 */       return false;
/*     */     }
/* 120 */     return (this.min.doubleValue() <= paramNumber.doubleValue() && this.max.doubleValue() >= paramNumber.doubleValue());
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
/*     */   public boolean includesRange(NumberRange paramNumberRange) {
/* 134 */     if (paramNumberRange == null) {
/* 135 */       return false;
/*     */     }
/* 137 */     return (includesNumber(paramNumberRange.min) && includesNumber(paramNumberRange.max));
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
/*     */   public boolean overlaps(NumberRange paramNumberRange) {
/* 150 */     if (paramNumberRange == null) {
/* 151 */       return false;
/*     */     }
/* 153 */     return (paramNumberRange.includesNumber(this.min) || paramNumberRange.includesNumber(this.max) || includesRange(paramNumberRange));
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
/*     */   public boolean equals(Object paramObject) {
/* 167 */     if (paramObject == this)
/* 168 */       return true; 
/* 169 */     if (!(paramObject instanceof NumberRange)) {
/* 170 */       return false;
/*     */     }
/* 172 */     NumberRange numberRange = (NumberRange)paramObject;
/* 173 */     return (this.min.equals(numberRange.min) && this.max.equals(numberRange.max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 183 */     int i = 17;
/* 184 */     i = 37 * i + this.min.hashCode();
/* 185 */     i = 37 * i + this.max.hashCode();
/* 186 */     return i;
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
/*     */   public String toString() {
/* 199 */     StrBuilder strBuilder = new StrBuilder();
/*     */     
/* 201 */     if (this.min.doubleValue() < 0.0D) {
/* 202 */       strBuilder.append('(').append(this.min).append(')');
/*     */     }
/*     */     else {
/*     */       
/* 206 */       strBuilder.append(this.min);
/*     */     } 
/*     */     
/* 209 */     strBuilder.append('-');
/*     */     
/* 211 */     if (this.max.doubleValue() < 0.0D) {
/* 212 */       strBuilder.append('(').append(this.max).append(')');
/*     */     }
/*     */     else {
/*     */       
/* 216 */       strBuilder.append(this.max);
/*     */     } 
/*     */     
/* 219 */     return strBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/NumberRange.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */