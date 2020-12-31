/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ClockSource
/*     */ {
/*  29 */   public static final ClockSource INSTANCE = Factory.create();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long currentTime();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long toMillis(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long elapsedMillis(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long elapsedMillis(long paramLong1, long paramLong2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long elapsedNanos(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long elapsedNanos(long paramLong1, long paramLong2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long plusMillis(long paramLong1, long paramLong2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TimeUnit getSourceTimeUnit();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Factory
/*     */   {
/*     */     private static ClockSource create() {
/* 107 */       String str = System.getProperty("os.name");
/* 108 */       if ("Mac OS X".equals(str)) {
/* 109 */         return new ClockSource.MillisecondClockSource();
/*     */       }
/*     */       
/* 112 */       return new ClockSource.NanosecondClockSource();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class MillisecondClockSource
/*     */     implements ClockSource
/*     */   {
/*     */     public long currentTime() {
/* 122 */       return System.currentTimeMillis();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedMillis(long param1Long) {
/* 129 */       return System.currentTimeMillis() - param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedMillis(long param1Long1, long param1Long2) {
/* 136 */       return param1Long2 - param1Long1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedNanos(long param1Long) {
/* 143 */       return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis() - param1Long);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedNanos(long param1Long1, long param1Long2) {
/* 150 */       return TimeUnit.MILLISECONDS.toNanos(param1Long2 - param1Long1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long toMillis(long param1Long) {
/* 157 */       return param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long plusMillis(long param1Long1, long param1Long2) {
/* 164 */       return param1Long1 + param1Long2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TimeUnit getSourceTimeUnit() {
/* 171 */       return TimeUnit.MILLISECONDS;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class NanosecondClockSource
/*     */     implements ClockSource
/*     */   {
/*     */     public long currentTime() {
/* 181 */       return System.nanoTime();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final long toMillis(long param1Long) {
/* 188 */       return TimeUnit.NANOSECONDS.toMillis(param1Long);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedMillis(long param1Long) {
/* 195 */       return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - param1Long);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedMillis(long param1Long1, long param1Long2) {
/* 202 */       return TimeUnit.NANOSECONDS.toMillis(param1Long2 - param1Long1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedNanos(long param1Long) {
/* 209 */       return System.nanoTime() - param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsedNanos(long param1Long1, long param1Long2) {
/* 216 */       return param1Long2 - param1Long1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long plusMillis(long param1Long1, long param1Long2) {
/* 223 */       return param1Long1 + TimeUnit.MILLISECONDS.toNanos(param1Long2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TimeUnit getSourceTimeUnit() {
/* 230 */       return TimeUnit.NANOSECONDS;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/ClockSource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */