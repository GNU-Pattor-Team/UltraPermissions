/*    */ package me.TechsCode.UltraPermissions.base.update;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public abstract class UploadCompleteThread
/*    */   implements Runnable {
/*    */   private File file;
/*    */   private Thread thread;
/*    */   
/*    */   public UploadCompleteThread(File paramFile) {
/* 11 */     this.file = paramFile;
/*    */     
/* 13 */     this.thread = new Thread(this);
/* 14 */     this.thread.start();
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 19 */     boolean bool = true;
/*    */     
/* 21 */     long l = this.file.length();
/*    */     
/* 23 */     while (bool) {
/*    */       try {
/* 25 */         Thread.sleep(1000L);
/* 26 */       } catch (InterruptedException interruptedException) {
/* 27 */         interruptedException.printStackTrace();
/*    */       } 
/*    */       
/* 30 */       if (l == this.file.length()) {
/* 31 */         bool = false;
/*    */       }
/*    */       
/* 34 */       l = this.file.length();
/*    */     } 
/*    */     
/* 37 */     onComplete();
/*    */   }
/*    */   
/*    */   public abstract void onComplete();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/UploadCompleteThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */