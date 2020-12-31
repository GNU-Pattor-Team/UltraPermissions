/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*    */ 
/*    */ import java.io.FilterOutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChunkedOutputStream
/*    */   extends FilterOutputStream
/*    */ {
/*    */   private static final int DEFAULT_CHUNK_SIZE = 4096;
/*    */   private final int chunkSize;
/*    */   
/*    */   public ChunkedOutputStream(OutputStream paramOutputStream, int paramInt) {
/* 50 */     super(paramOutputStream);
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
/*    */   
/*    */   public ChunkedOutputStream(OutputStream paramOutputStream) {
/* 63 */     this(paramOutputStream, 4096);
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
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 77 */     int i = paramInt2;
/* 78 */     int j = paramInt1;
/* 79 */     while (i > 0) {
/* 80 */       int k = Math.min(i, this.chunkSize);
/* 81 */       this.out.write(paramArrayOfbyte, j, k);
/* 82 */       i -= k;
/* 83 */       j += k;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/ChunkedOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */