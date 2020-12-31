/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*    */ 
/*    */ import java.io.InputStream;
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
/*    */ public class DemuxInputStream
/*    */   extends InputStream
/*    */ {
/* 32 */   private final InheritableThreadLocal<InputStream> m_streams = new InheritableThreadLocal<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InputStream bindStream(InputStream paramInputStream) {
/* 42 */     InputStream inputStream = this.m_streams.get();
/* 43 */     this.m_streams.set(paramInputStream);
/* 44 */     return inputStream;
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
/*    */   public void close() {
/* 56 */     InputStream inputStream = this.m_streams.get();
/* 57 */     if (null != inputStream)
/*    */     {
/* 59 */       inputStream.close();
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
/*    */   public int read() {
/* 73 */     InputStream inputStream = this.m_streams.get();
/* 74 */     if (null != inputStream)
/*    */     {
/* 76 */       return inputStream.read();
/*    */     }
/*    */ 
/*    */     
/* 80 */     return -1;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/DemuxInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */