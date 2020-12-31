/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
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
/*     */ public class BoundedInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final InputStream in;
/*     */   private final long max;
/*  46 */   private long pos = 0L;
/*     */ 
/*     */   
/*  49 */   private long mark = -1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean propagateClose = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundedInputStream(InputStream paramInputStream, long paramLong) {
/*  64 */     this.max = paramLong;
/*  65 */     this.in = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundedInputStream(InputStream paramInputStream) {
/*  75 */     this(paramInputStream, -1L);
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
/*     */   public int read() {
/*  87 */     if (this.max >= 0L && this.pos >= this.max) {
/*  88 */       return -1;
/*     */     }
/*  90 */     int i = this.in.read();
/*  91 */     this.pos++;
/*  92 */     return i;
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
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 104 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 118 */     if (this.max >= 0L && this.pos >= this.max) {
/* 119 */       return -1;
/*     */     }
/* 121 */     long l = (this.max >= 0L) ? Math.min(paramInt2, this.max - this.pos) : paramInt2;
/* 122 */     int i = this.in.read(paramArrayOfbyte, paramInt1, (int)l);
/*     */     
/* 124 */     if (i == -1) {
/* 125 */       return -1;
/*     */     }
/*     */     
/* 128 */     this.pos += i;
/* 129 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) {
/* 140 */     long l1 = (this.max >= 0L) ? Math.min(paramLong, this.max - this.pos) : paramLong;
/* 141 */     long l2 = this.in.skip(l1);
/* 142 */     this.pos += l2;
/* 143 */     return l2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 151 */     if (this.max >= 0L && this.pos >= this.max) {
/* 152 */       return 0;
/*     */     }
/* 154 */     return this.in.available();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     return this.in.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 173 */     if (this.propagateClose) {
/* 174 */       this.in.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/* 184 */     this.in.reset();
/* 185 */     this.pos = this.mark;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 194 */     this.in.mark(paramInt);
/* 195 */     this.mark = this.pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 204 */     return this.in.markSupported();
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
/*     */   public boolean isPropagateClose() {
/* 216 */     return this.propagateClose;
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
/*     */   public void setPropagateClose(boolean paramBoolean) {
/* 229 */     this.propagateClose = paramBoolean;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/BoundedInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */