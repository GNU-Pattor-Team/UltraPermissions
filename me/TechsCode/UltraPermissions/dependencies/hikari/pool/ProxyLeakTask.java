/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari.pool;
/*    */ 
/*    */ import java.util.concurrent.ScheduledExecutorService;
/*    */ import java.util.concurrent.ScheduledFuture;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.LoggerFactory;
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
/*    */ class ProxyLeakTask
/*    */   implements Runnable
/*    */ {
/* 34 */   private static final Logger LOGGER = LoggerFactory.getLogger(ProxyLeakTask.class);
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
/* 45 */   private static final ProxyLeakTask NO_LEAK = new ProxyLeakTask() {
/*    */       public void cancel() {}
/*    */     };
/*    */   
/*    */   private ScheduledExecutorService executorService;
/*    */   private long leakDetectionThreshold;
/*    */   
/*    */   ProxyLeakTask(long paramLong, ScheduledExecutorService paramScheduledExecutorService) {
/* 53 */     this.executorService = paramScheduledExecutorService;
/* 54 */     this.leakDetectionThreshold = paramLong;
/*    */   }
/*    */   private ScheduledFuture<?> scheduledFuture; private String connectionName; private Exception exception;
/*    */   
/*    */   private ProxyLeakTask(ProxyLeakTask paramProxyLeakTask, PoolEntry paramPoolEntry) {
/* 59 */     this.exception = new Exception("Apparent connection leak detected");
/* 60 */     this.connectionName = paramPoolEntry.connection.toString();
/* 61 */     this.scheduledFuture = paramProxyLeakTask.executorService.schedule(this, paramProxyLeakTask.leakDetectionThreshold, TimeUnit.MILLISECONDS);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private ProxyLeakTask() {}
/*    */ 
/*    */   
/*    */   ProxyLeakTask start(PoolEntry paramPoolEntry) {
/* 70 */     return (this.leakDetectionThreshold == 0L) ? NO_LEAK : new ProxyLeakTask(this, paramPoolEntry);
/*    */   }
/*    */ 
/*    */   
/*    */   void updateLeakDetectionThreshold(long paramLong) {
/* 75 */     this.leakDetectionThreshold = paramLong;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 82 */     StackTraceElement[] arrayOfStackTraceElement1 = this.exception.getStackTrace();
/* 83 */     StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[arrayOfStackTraceElement1.length - 5];
/* 84 */     System.arraycopy(arrayOfStackTraceElement1, 5, arrayOfStackTraceElement2, 0, arrayOfStackTraceElement2.length);
/*    */     
/* 86 */     this.exception.setStackTrace(arrayOfStackTraceElement2);
/* 87 */     LOGGER.warn("Connection leak detection triggered for connection {}, stack trace follows", this.connectionName, this.exception);
/*    */   }
/*    */ 
/*    */   
/*    */   void cancel() {
/* 92 */     this.scheduledFuture.cancel(false);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/ProxyLeakTask.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */