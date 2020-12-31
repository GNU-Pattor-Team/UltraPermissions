/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*    */ 
/*    */ import java.io.FilterWriter;
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
/*    */ public class ChunkedWriter
/*    */   extends FilterWriter
/*    */ {
/*    */   private static final int DEFAULT_CHUNK_SIZE = 4096;
/*    */   private final int chunkSize;
/*    */   
/*    */   public ChunkedWriter(Writer paramWriter, int paramInt) {
/* 50 */     super(paramWriter);
/* 51 */     if (paramInt <= 0) {
/* 52 */       throw new IllegalArgumentException();
/*    */     }
/* 54 */     this.chunkSize = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ChunkedWriter(Writer paramWriter) {
/* 62 */     this(paramWriter, 4096);
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
/*    */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 75 */     int i = paramInt2;
/* 76 */     int j = paramInt1;
/* 77 */     while (i > 0) {
/* 78 */       int k = Math.min(i, this.chunkSize);
/* 79 */       this.out.write(paramArrayOfchar, j, k);
/* 80 */       i -= k;
/* 81 */       j += k;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/ChunkedWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */