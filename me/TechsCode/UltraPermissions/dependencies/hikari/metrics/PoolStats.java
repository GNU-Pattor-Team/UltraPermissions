/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari.metrics;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.ClockSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class PoolStats
/*    */ {
/*    */   private final ClockSource clock;
/*    */   private final AtomicLong reloadAt;
/*    */   private final long timeoutMs;
/*    */   protected volatile int totalConnections;
/*    */   protected volatile int idleConnections;
/*    */   protected volatile int activeConnections;
/*    */   protected volatile int pendingThreads;
/*    */   
/*    */   public PoolStats(long paramLong) {
/* 40 */     this.timeoutMs = paramLong;
/* 41 */     this.reloadAt = new AtomicLong();
/* 42 */     this.clock = ClockSource.INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getTotalConnections() {
/* 47 */     if (shouldLoad()) {
/* 48 */       update();
/*    */     }
/*    */     
/* 51 */     return this.totalConnections;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getIdleConnections() {
/* 56 */     if (shouldLoad()) {
/* 57 */       update();
/*    */     }
/*    */     
/* 60 */     return this.idleConnections;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getActiveConnections() {
/* 65 */     if (shouldLoad()) {
/* 66 */       update();
/*    */     }
/*    */     
/* 69 */     return this.activeConnections;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getPendingThreads() {
/* 74 */     if (shouldLoad()) {
/* 75 */       update();
/*    */     }
/*    */     
/* 78 */     return this.pendingThreads;
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract void update();
/*    */   
/*    */   private boolean shouldLoad() {
/*    */     while (true) {
/* 86 */       long l1 = this.clock.currentTime();
/* 87 */       long l2 = this.reloadAt.get();
/* 88 */       if (l2 > l1) {
/* 89 */         return false;
/*    */       }
/* 91 */       if (this.reloadAt.compareAndSet(l2, this.clock.plusMillis(l1, this.timeoutMs)))
/* 92 */         return true; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/metrics/PoolStats.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */