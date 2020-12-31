/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
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
/*     */ public class NullReader
/*     */   extends Reader
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
/*     */   public NullReader(long paramLong) {
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
/*     */   public NullReader(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
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
/*     */   
/*     */   public void close() {
/* 128 */     this.eof = false;
/* 129 */     this.position = 0L;
/* 130 */     this.mark = -1L;
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
/* 142 */     if (!this.markSupported) {
/* 143 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 145 */     this.mark = this.position;
/* 146 */     this.readlimit = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 156 */     return this.markSupported;
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
/* 171 */     if (this.eof) {
/* 172 */       throw new IOException("Read after end of file");
/*     */     }
/* 174 */     if (this.position == this.size) {
/* 175 */       return doEndOfFile();
/*     */     }
/* 177 */     this.position++;
/* 178 */     return processChar();
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
/*     */   public int read(char[] paramArrayOfchar) {
/* 194 */     return read(paramArrayOfchar, 0, paramArrayOfchar.length);
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 212 */     if (this.eof) {
/* 213 */       throw new IOException("Read after end of file");
/*     */     }
/* 215 */     if (this.position == this.size) {
/* 216 */       return doEndOfFile();
/*     */     }
/* 218 */     this.position += paramInt2;
/* 219 */     int i = paramInt2;
/* 220 */     if (this.position > this.size) {
/* 221 */       i = paramInt2 - (int)(this.position - this.size);
/* 222 */       this.position = this.size;
/*     */     } 
/* 224 */     processChars(paramArrayOfchar, paramInt1, i);
/* 225 */     return i;
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
/* 238 */     if (!this.markSupported) {
/* 239 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 241 */     if (this.mark < 0L) {
/* 242 */       throw new IOException("No position has been marked");
/*     */     }
/* 244 */     if (this.position > this.mark + this.readlimit) {
/* 245 */       throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
/*     */     }
/*     */ 
/*     */     
/* 249 */     this.position = this.mark;
/* 250 */     this.eof = false;
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
/* 266 */     if (this.eof) {
/* 267 */       throw new IOException("Skip after end of file");
/*     */     }
/* 269 */     if (this.position == this.size) {
/* 270 */       return doEndOfFile();
/*     */     }
/* 272 */     this.position += paramLong;
/* 273 */     long l = paramLong;
/* 274 */     if (this.position > this.size) {
/* 275 */       l = paramLong - this.position - this.size;
/* 276 */       this.position = this.size;
/*     */     } 
/* 278 */     return l;
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
/*     */   protected int processChar() {
/* 290 */     return 0;
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
/*     */   protected void processChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {}
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
/* 316 */     this.eof = true;
/* 317 */     if (this.throwEofException) {
/* 318 */       throw new EOFException();
/*     */     }
/* 320 */     return -1;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/NullReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */