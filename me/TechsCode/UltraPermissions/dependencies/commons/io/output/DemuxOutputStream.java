/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*    */ 
/*    */ import java.io.OutputStream;
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
/*    */ public class DemuxOutputStream
/*    */   extends OutputStream
/*    */ {
/* 27 */   private final InheritableThreadLocal<OutputStream> outputStreamThreadLocal = new InheritableThreadLocal<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public OutputStream bindStream(OutputStream paramOutputStream) {
/* 37 */     OutputStream outputStream = this.outputStreamThreadLocal.get();
/* 38 */     this.outputStreamThreadLocal.set(paramOutputStream);
/* 39 */     return outputStream;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {
/* 50 */     OutputStream outputStream = this.outputStreamThreadLocal.get();
/* 51 */     if (null != outputStream) {
/* 52 */       outputStream.close();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void flush() {
/* 65 */     OutputStream outputStream = this.outputStreamThreadLocal.get();
/* 66 */     if (null != outputStream) {
/* 67 */       outputStream.flush();
/*    */     }
/*    */   }
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
/*    */   public void write(int paramInt) {
/* 82 */     OutputStream outputStream = this.outputStreamThreadLocal.get();
/* 83 */     if (null != outputStream)
/* 84 */       outputStream.write(paramInt); 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/DemuxOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */