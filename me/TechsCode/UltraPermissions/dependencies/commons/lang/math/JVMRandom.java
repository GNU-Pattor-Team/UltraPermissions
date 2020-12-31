/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.math;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JVMRandom
/*     */   extends Random
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  49 */   private static final Random SHARED_RANDOM = new Random();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean constructed = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JVMRandom() {
/*  60 */     this.constructed = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setSeed(long paramLong) {
/*  70 */     if (this.constructed) {
/*  71 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized double nextGaussian() {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void nextBytes(byte[] paramArrayOfbyte) {
/*  92 */     throw new UnsupportedOperationException();
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
/*     */   public int nextInt() {
/* 105 */     return nextInt(2147483647);
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
/*     */   public int nextInt(int paramInt) {
/* 118 */     return SHARED_RANDOM.nextInt(paramInt);
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
/*     */   public long nextLong() {
/* 131 */     return nextLong(Long.MAX_VALUE);
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
/*     */   public static long nextLong(long paramLong) {
/* 145 */     if (paramLong <= 0L) {
/* 146 */       throw new IllegalArgumentException("Upper bound for nextInt must be positive");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 151 */     if ((paramLong & -paramLong) == paramLong)
/*     */     {
/* 153 */       return next63bits() >> 63 - bitsRequired(paramLong - 1L);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 160 */       long l2 = next63bits();
/* 161 */       long l1 = l2 % paramLong;
/* 162 */       if (l2 - l1 + paramLong - 1L >= 0L) {
/* 163 */         return l1;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nextBoolean() {
/* 173 */     return SHARED_RANDOM.nextBoolean();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float nextFloat() {
/* 184 */     return SHARED_RANDOM.nextFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double nextDouble() {
/* 193 */     return SHARED_RANDOM.nextDouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long next63bits() {
/* 202 */     return SHARED_RANDOM.nextLong() & Long.MAX_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int bitsRequired(long paramLong) {
/* 213 */     long l = paramLong;
/* 214 */     byte b = 0;
/*     */     
/*     */     while (true) {
/* 217 */       if (paramLong < 0L) {
/* 218 */         return 64 - b;
/*     */       }
/* 220 */       if (l == 0L) {
/* 221 */         return b;
/*     */       }
/* 223 */       b++;
/* 224 */       paramLong <<= 1L;
/* 225 */       l >>= 1L;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/JVMRandom.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */