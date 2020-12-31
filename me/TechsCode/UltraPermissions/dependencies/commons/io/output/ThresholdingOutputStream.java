/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ThresholdingOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   private final int threshold;
/*     */   private long written;
/*     */   private boolean thresholdExceeded;
/*     */   
/*     */   public ThresholdingOutputStream(int paramInt) {
/*  74 */     this.threshold = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) {
/*  91 */     checkThreshold(1);
/*  92 */     getStream().write(paramInt);
/*  93 */     this.written++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) {
/* 108 */     checkThreshold(paramArrayOfbyte.length);
/* 109 */     getStream().write(paramArrayOfbyte);
/* 110 */     this.written += paramArrayOfbyte.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 127 */     checkThreshold(paramInt2);
/* 128 */     getStream().write(paramArrayOfbyte, paramInt1, paramInt2);
/* 129 */     this.written += paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 142 */     getStream().flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/* 157 */       flush();
/*     */     }
/* 159 */     catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */     
/* 163 */     getStream().close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThreshold() {
/* 177 */     return this.threshold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getByteCount() {
/* 188 */     return this.written;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isThresholdExceeded() {
/* 201 */     return (this.written > this.threshold);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkThreshold(int paramInt) {
/* 220 */     if (!this.thresholdExceeded && this.written + paramInt > this.threshold) {
/*     */       
/* 222 */       this.thresholdExceeded = true;
/* 223 */       thresholdReached();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void resetByteCount() {
/* 233 */     this.thresholdExceeded = false;
/* 234 */     this.written = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setByteCount(long paramLong) {
/* 247 */     this.written = paramLong;
/*     */   }
/*     */   
/*     */   protected abstract OutputStream getStream();
/*     */   
/*     */   protected abstract void thresholdReached();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/ThresholdingOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */