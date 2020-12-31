/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*    */ 
/*    */ import java.util.concurrent.Semaphore;
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
/*    */ public class SuspendResumeLock
/*    */ {
/* 30 */   public static final SuspendResumeLock FAUX_LOCK = new SuspendResumeLock(false)
/*    */     {
/*    */       public void acquire() {}
/*    */ 
/*    */ 
/*    */       
/*    */       public void release() {}
/*    */ 
/*    */       
/*    */       public void suspend() {}
/*    */ 
/*    */       
/*    */       public void resume() {}
/*    */     };
/*    */ 
/*    */   
/*    */   private static final int MAX_PERMITS = 10000;
/*    */   
/*    */   private final Semaphore acquisitionSemaphore;
/*    */ 
/*    */   
/*    */   public SuspendResumeLock() {
/* 52 */     this(true);
/*    */   }
/*    */ 
/*    */   
/*    */   private SuspendResumeLock(boolean paramBoolean) {
/* 57 */     this.acquisitionSemaphore = paramBoolean ? new Semaphore(10000, true) : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void acquire() {
/* 62 */     this.acquisitionSemaphore.acquireUninterruptibly();
/*    */   }
/*    */ 
/*    */   
/*    */   public void release() {
/* 67 */     this.acquisitionSemaphore.release();
/*    */   }
/*    */ 
/*    */   
/*    */   public void suspend() {
/* 72 */     this.acquisitionSemaphore.acquireUninterruptibly(10000);
/*    */   }
/*    */ 
/*    */   
/*    */   public void resume() {
/* 77 */     this.acquisitionSemaphore.release(10000);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/SuspendResumeLock.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */