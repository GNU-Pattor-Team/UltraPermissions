/*    */ package me.TechsCode.UltraPermissions.base.legacy.task;
/*    */ 
/*    */ public enum UpdateTime
/*    */ {
/*  5 */   TICK(1L),
/*  6 */   TWOTICKS(2L),
/*  7 */   FASTER(5L),
/*  8 */   FAST(10L),
/*  9 */   SEC(20L),
/* 10 */   SLOW(60L),
/* 11 */   SLOWER(100L),
/* 12 */   HALFMIN(600L),
/* 13 */   MIN(1200L),
/* 14 */   QUARTER_HOUR(18000L);
/*    */   
/*    */   private long time;
/*    */   
/*    */   UpdateTime(long paramLong) {
/* 19 */     this.time = paramLong;
/*    */   }
/*    */   
/*    */   public long getTime() {
/* 23 */     return this.time;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/task/UpdateTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */