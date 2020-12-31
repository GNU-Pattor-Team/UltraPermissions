/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClosedOutputStream
/*    */   extends OutputStream
/*    */ {
/* 37 */   public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(int paramInt) {
/* 47 */     throw new IOException("write(" + paramInt + ") failed: stream is closed");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void flush() {
/* 57 */     throw new IOException("flush() failed: stream is closed");
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/ClosedOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */