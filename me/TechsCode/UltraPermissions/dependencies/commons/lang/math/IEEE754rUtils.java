/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.math;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IEEE754rUtils
/*     */ {
/*     */   public static double min(double[] paramArrayOfdouble) {
/*  40 */     if (paramArrayOfdouble == null)
/*  41 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  42 */     if (paramArrayOfdouble.length == 0) {
/*  43 */       throw new IllegalArgumentException("Array cannot be empty.");
/*     */     }
/*     */ 
/*     */     
/*  47 */     double d = paramArrayOfdouble[0];
/*  48 */     for (byte b = 1; b < paramArrayOfdouble.length; b++) {
/*  49 */       d = min(paramArrayOfdouble[b], d);
/*     */     }
/*     */     
/*  52 */     return d;
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
/*     */   public static float min(float[] paramArrayOffloat) {
/*  65 */     if (paramArrayOffloat == null)
/*  66 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  67 */     if (paramArrayOffloat.length == 0) {
/*  68 */       throw new IllegalArgumentException("Array cannot be empty.");
/*     */     }
/*     */ 
/*     */     
/*  72 */     float f = paramArrayOffloat[0];
/*  73 */     for (byte b = 1; b < paramArrayOffloat.length; b++) {
/*  74 */       f = min(paramArrayOffloat[b], f);
/*     */     }
/*     */     
/*  77 */     return f;
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
/*     */   public static double min(double paramDouble1, double paramDouble2, double paramDouble3) {
/*  91 */     return min(min(paramDouble1, paramDouble2), paramDouble3);
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
/*     */   public static double min(double paramDouble1, double paramDouble2) {
/* 104 */     if (Double.isNaN(paramDouble1)) {
/* 105 */       return paramDouble2;
/*     */     }
/* 107 */     if (Double.isNaN(paramDouble2)) {
/* 108 */       return paramDouble1;
/*     */     }
/* 110 */     return Math.min(paramDouble1, paramDouble2);
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
/*     */   public static float min(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 125 */     return min(min(paramFloat1, paramFloat2), paramFloat3);
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
/*     */   public static float min(float paramFloat1, float paramFloat2) {
/* 138 */     if (Float.isNaN(paramFloat1)) {
/* 139 */       return paramFloat2;
/*     */     }
/* 141 */     if (Float.isNaN(paramFloat2)) {
/* 142 */       return paramFloat1;
/*     */     }
/* 144 */     return Math.min(paramFloat1, paramFloat2);
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
/*     */   public static double max(double[] paramArrayOfdouble) {
/* 158 */     if (paramArrayOfdouble == null)
/* 159 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 160 */     if (paramArrayOfdouble.length == 0) {
/* 161 */       throw new IllegalArgumentException("Array cannot be empty.");
/*     */     }
/*     */ 
/*     */     
/* 165 */     double d = paramArrayOfdouble[0];
/* 166 */     for (byte b = 1; b < paramArrayOfdouble.length; b++) {
/* 167 */       d = max(paramArrayOfdouble[b], d);
/*     */     }
/*     */     
/* 170 */     return d;
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
/*     */   public static float max(float[] paramArrayOffloat) {
/* 183 */     if (paramArrayOffloat == null)
/* 184 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 185 */     if (paramArrayOffloat.length == 0) {
/* 186 */       throw new IllegalArgumentException("Array cannot be empty.");
/*     */     }
/*     */ 
/*     */     
/* 190 */     float f = paramArrayOffloat[0];
/* 191 */     for (byte b = 1; b < paramArrayOffloat.length; b++) {
/* 192 */       f = max(paramArrayOffloat[b], f);
/*     */     }
/*     */     
/* 195 */     return f;
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
/*     */   public static double max(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 209 */     return max(max(paramDouble1, paramDouble2), paramDouble3);
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
/*     */   public static double max(double paramDouble1, double paramDouble2) {
/* 222 */     if (Double.isNaN(paramDouble1)) {
/* 223 */       return paramDouble2;
/*     */     }
/* 225 */     if (Double.isNaN(paramDouble2)) {
/* 226 */       return paramDouble1;
/*     */     }
/* 228 */     return Math.max(paramDouble1, paramDouble2);
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
/*     */   public static float max(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 243 */     return max(max(paramFloat1, paramFloat2), paramFloat3);
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
/*     */   public static float max(float paramFloat1, float paramFloat2) {
/* 256 */     if (Float.isNaN(paramFloat1)) {
/* 257 */       return paramFloat2;
/*     */     }
/* 259 */     if (Float.isNaN(paramFloat2)) {
/* 260 */       return paramFloat1;
/*     */     }
/* 262 */     return Math.max(paramFloat1, paramFloat2);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/IEEE754rUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */