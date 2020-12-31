/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*    */ 
/*    */ import java.util.concurrent.ThreadFactory;
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
/*    */ public class DefaultThreadFactory
/*    */   implements ThreadFactory
/*    */ {
/*    */   private final String threadName;
/*    */   private final boolean daemon;
/*    */   
/*    */   public DefaultThreadFactory(String paramString, boolean paramBoolean) {
/* 26 */     this.threadName = paramString;
/* 27 */     this.daemon = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public Thread newThread(Runnable paramRunnable) {
/* 32 */     Thread thread = new Thread(paramRunnable, this.threadName);
/* 33 */     thread.setDaemon(this.daemon);
/* 34 */     return thread;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/DefaultThreadFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */