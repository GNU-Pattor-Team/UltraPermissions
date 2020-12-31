/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class QueuedSequenceSynchronizer
/*     */ {
/*  59 */   private final Synchronizer synchronizer = new Synchronizer();
/*  60 */   private final Sequence sequence = Sequence.Factory.create();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void signal() {
/*  68 */     this.synchronizer.releaseShared(1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long currentSequence() {
/*  78 */     return this.sequence.get();
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
/*     */   public boolean waitUntilSequenceExceeded(long paramLong1, long paramLong2) {
/*  92 */     return this.synchronizer.tryAcquireSharedNanos(paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasQueuedThreads() {
/* 102 */     return this.synchronizer.hasQueuedThreads();
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
/*     */   public int getQueueLength() {
/* 115 */     return this.synchronizer.getQueueLength();
/*     */   }
/*     */   
/*     */   private final class Synchronizer
/*     */     extends AbstractQueuedLongSynchronizer
/*     */   {
/*     */     private static final long serialVersionUID = 104753538004341218L;
/*     */     
/*     */     private Synchronizer() {}
/*     */     
/*     */     protected long tryAcquireShared(long param1Long) {
/* 126 */       return QueuedSequenceSynchronizer.this.sequence.get() - param1Long + 1L;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean tryReleaseShared(long param1Long) {
/* 133 */       QueuedSequenceSynchronizer.this.sequence.increment();
/* 134 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/QueuedSequenceSynchronizer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */