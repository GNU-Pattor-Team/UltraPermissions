/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*    */ 
/*    */ import java.io.Writer;
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
/*    */ public class NullWriter
/*    */   extends Writer
/*    */ {
/* 33 */   public static final NullWriter NULL_WRITER = new NullWriter();
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
/*    */   public Writer append(char paramChar) {
/* 50 */     return this;
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
/*    */   public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 64 */     return this;
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
/*    */   public Writer append(CharSequence paramCharSequence) {
/* 76 */     return this;
/*    */   }
/*    */   
/*    */   public void write(int paramInt) {}
/*    */   
/*    */   public void write(char[] paramArrayOfchar) {}
/*    */   
/*    */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void write(String paramString) {}
/*    */   
/*    */   public void write(String paramString, int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void flush() {}
/*    */   
/*    */   public void close() {}
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/NullWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */