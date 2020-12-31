/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
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
/*     */ public class NullInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final long size;
/*     */   private long position;
/*  69 */   private long mark = -1L;
/*     */ 
/*     */   
/*     */   private long readlimit;
/*     */   
/*     */   private boolean eof;
/*     */   
/*     */   private final boolean throwEofException;
/*     */   
/*     */   private final boolean markSupported;
/*     */ 
/*     */   
/*     */   public NullInputStream(long paramLong) {
/*  82 */     this(paramLong, true, false);
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
/*     */   public NullInputStream(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/*  97 */     this.size = paramLong;
/*  98 */     this.markSupported = paramBoolean1;
/*  99 */     this.throwEofException = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPosition() {
/* 108 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 117 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 127 */     long l = this.size - this.position;
/* 128 */     if (l <= 0L)
/* 129 */       return 0; 
/* 130 */     if (l > 2147483647L) {
/* 131 */       return Integer.MAX_VALUE;
/*     */     }
/* 133 */     return (int)l;
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
/*     */   public void close() {
/* 145 */     this.eof = false;
/* 146 */     this.position = 0L;
/* 147 */     this.mark = -1L;
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
/*     */   public synchronized void mark(int paramInt) {
/* 159 */     if (!this.markSupported) {
/* 160 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 162 */     this.mark = this.position;
/* 163 */     this.readlimit = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 173 */     return this.markSupported;
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
/*     */   public int read() {
/* 188 */     if (this.eof) {
/* 189 */       throw new IOException("Read after end of file");
/*     */     }
/* 191 */     if (this.position == this.size) {
/* 192 */       return doEndOfFile();
/*     */     }
/* 194 */     this.position++;
/* 195 */     return processByte();
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
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 211 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 229 */     if (this.eof) {
/* 230 */       throw new IOException("Read after end of file");
/*     */     }
/* 232 */     if (this.position == this.size) {
/* 233 */       return doEndOfFile();
/*     */     }
/* 235 */     this.position += paramInt2;
/* 236 */     int i = paramInt2;
/* 237 */     if (this.position > this.size) {
/* 238 */       i = paramInt2 - (int)(this.position - this.size);
/* 239 */       this.position = this.size;
/*     */     } 
/* 241 */     processBytes(paramArrayOfbyte, paramInt1, i);
/* 242 */     return i;
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
/*     */   public synchronized void reset() {
/* 255 */     if (!this.markSupported) {
/* 256 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 258 */     if (this.mark < 0L) {
/* 259 */       throw new IOException("No position has been marked");
/*     */     }
/* 261 */     if (this.position > this.mark + this.readlimit) {
/* 262 */       throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
/*     */     }
/*     */ 
/*     */     
/* 266 */     this.position = this.mark;
/* 267 */     this.eof = false;
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
/*     */   public long skip(long paramLong) {
/* 283 */     if (this.eof) {
/* 284 */       throw new IOException("Skip after end of file");
/*     */     }
/* 286 */     if (this.position == this.size) {
/* 287 */       return doEndOfFile();
/*     */     }
/* 289 */     this.position += paramLong;
/* 290 */     long l = paramLong;
/* 291 */     if (this.position > this.size) {
/* 292 */       l = paramLong - this.position - this.size;
/* 293 */       this.position = this.size;
/*     */     } 
/* 295 */     return l;
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
/*     */   protected int processByte() {
/* 307 */     return 0;
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
/*     */   protected void processBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {}
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
/*     */   private int doEndOfFile() {
/* 333 */     this.eof = true;
/* 334 */     if (this.throwEofException) {
/* 335 */       throw new EOFException();
/*     */     }
/* 337 */     return -1;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/NullInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */