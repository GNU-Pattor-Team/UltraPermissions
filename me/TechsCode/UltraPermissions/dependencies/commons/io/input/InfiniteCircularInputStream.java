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
/*    */ public class InfiniteCircularInputStream
/*    */   extends InputStream
/*    */ {
/*    */   private final byte[] repeatedContent;
/* 33 */   private int position = -1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InfiniteCircularInputStream(byte[] paramArrayOfbyte) {
/* 42 */     this.repeatedContent = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */   
/*    */   public int read() {
/* 47 */     this.position = (this.position + 1) % this.repeatedContent.length;
/* 48 */     return this.repeatedContent[this.position] & 0xFF;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/InfiniteCircularInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */