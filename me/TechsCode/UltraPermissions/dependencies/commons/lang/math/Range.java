/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.math;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Range
/*     */ {
/*     */   public abstract Number getMinimumNumber();
/*     */   
/*     */   public long getMinimumLong() {
/*  60 */     return getMinimumNumber().longValue();
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
/*     */   public int getMinimumInteger() {
/*  72 */     return getMinimumNumber().intValue();
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
/*     */   public double getMinimumDouble() {
/*  84 */     return getMinimumNumber().doubleValue();
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
/*     */   public float getMinimumFloat() {
/*  96 */     return getMinimumNumber().floatValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Number getMaximumNumber();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaximumLong() {
/* 115 */     return getMaximumNumber().longValue();
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
/*     */   public int getMaximumInteger() {
/* 127 */     return getMaximumNumber().intValue();
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
/*     */   public double getMaximumDouble() {
/* 139 */     return getMaximumNumber().doubleValue();
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
/*     */   public float getMaximumFloat() {
/* 151 */     return getMaximumNumber().floatValue();
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
/*     */   public abstract boolean containsNumber(Number paramNumber);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsLong(Number paramNumber) {
/* 186 */     if (paramNumber == null) {
/* 187 */       return false;
/*     */     }
/* 189 */     return containsLong(paramNumber.longValue());
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
/* 204 */     return (paramLong >= getMinimumLong() && paramLong <= getMaximumLong());
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
/*     */   public boolean containsInteger(Number paramNumber) {
/* 220 */     if (paramNumber == null) {
/* 221 */       return false;
/*     */     }
/* 223 */     return containsInteger(paramNumber.intValue());
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
/* 238 */     return (paramInt >= getMinimumInteger() && paramInt <= getMaximumInteger());
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
/*     */   public boolean containsDouble(Number paramNumber) {
/* 254 */     if (paramNumber == null) {
/* 255 */       return false;
/*     */     }
/* 257 */     return containsDouble(paramNumber.doubleValue());
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
/* 272 */     int i = NumberUtils.compare(getMinimumDouble(), paramDouble);
/* 273 */     int j = NumberUtils.compare(getMaximumDouble(), paramDouble);
/* 274 */     return (i <= 0 && j >= 0);
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
/*     */   public boolean containsFloat(Number paramNumber) {
/* 290 */     if (paramNumber == null) {
/* 291 */       return false;
/*     */     }
/* 293 */     return containsFloat(paramNumber.floatValue());
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
/* 308 */     int i = NumberUtils.compare(getMinimumFloat(), paramFloat);
/* 309 */     int j = NumberUtils.compare(getMaximumFloat(), paramFloat);
/* 310 */     return (i <= 0 && j >= 0);
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
/*     */   public boolean containsRange(Range paramRange) {
/* 334 */     if (paramRange == null) {
/* 335 */       return false;
/*     */     }
/* 337 */     return (containsNumber(paramRange.getMinimumNumber()) && containsNumber(paramRange.getMaximumNumber()));
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
/*     */   public boolean overlapsRange(Range paramRange) {
/* 360 */     if (paramRange == null) {
/* 361 */       return false;
/*     */     }
/* 363 */     return (paramRange.containsNumber(getMinimumNumber()) || paramRange.containsNumber(getMaximumNumber()) || containsNumber(paramRange.getMinimumNumber()));
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
/*     */   public boolean equals(Object paramObject) {
/* 384 */     if (paramObject == this)
/* 385 */       return true; 
/* 386 */     if (paramObject == null || paramObject.getClass() != getClass()) {
/* 387 */       return false;
/*     */     }
/* 389 */     Range range = (Range)paramObject;
/* 390 */     return (getMinimumNumber().equals(range.getMinimumNumber()) && getMaximumNumber().equals(range.getMaximumNumber()));
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
/*     */   public int hashCode() {
/* 405 */     int i = 17;
/* 406 */     i = 37 * i + getClass().hashCode();
/* 407 */     i = 37 * i + getMinimumNumber().hashCode();
/* 408 */     i = 37 * i + getMaximumNumber().hashCode();
/* 409 */     return i;
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
/*     */   public String toString() {
/* 424 */     StrBuilder strBuilder = new StrBuilder(32);
/* 425 */     strBuilder.append("Range[");
/* 426 */     strBuilder.append(getMinimumNumber());
/* 427 */     strBuilder.append(',');
/* 428 */     strBuilder.append(getMaximumNumber());
/* 429 */     strBuilder.append(']');
/* 430 */     return strBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/Range.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */