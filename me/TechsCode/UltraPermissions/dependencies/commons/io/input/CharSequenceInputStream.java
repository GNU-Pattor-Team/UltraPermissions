/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharSequenceInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private static final int BUFFER_SIZE = 2048;
/*     */   private static final int NO_MARK = -1;
/*     */   private final CharsetEncoder encoder;
/*     */   private final CharBuffer cbuf;
/*     */   private final ByteBuffer bbuf;
/*     */   private int mark_cbuf;
/*     */   private int mark_bbuf;
/*     */   
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset, int paramInt) {
/*  63 */     this
/*     */       
/*  65 */       .encoder = paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
/*     */     
/*  67 */     float f = this.encoder.maxBytesPerChar();
/*  68 */     if (paramInt < f) {
/*  69 */       throw new IllegalArgumentException("Buffer size " + paramInt + " is less than maxBytesPerChar " + f);
/*     */     }
/*     */     
/*  72 */     this.bbuf = ByteBuffer.allocate(paramInt);
/*  73 */     this.bbuf.flip();
/*  74 */     this.cbuf = CharBuffer.wrap(paramCharSequence);
/*  75 */     this.mark_cbuf = -1;
/*  76 */     this.mark_bbuf = -1;
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
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, String paramString, int paramInt) {
/*  88 */     this(paramCharSequence, Charset.forName(paramString), paramInt);
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
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset) {
/* 100 */     this(paramCharSequence, paramCharset, 2048);
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
/*     */   public CharSequenceInputStream(CharSequence paramCharSequence, String paramString) {
/* 112 */     this(paramCharSequence, paramString, 2048);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillBuffer() {
/* 122 */     this.bbuf.compact();
/* 123 */     CoderResult coderResult = this.encoder.encode(this.cbuf, this.bbuf, true);
/* 124 */     if (coderResult.isError()) {
/* 125 */       coderResult.throwException();
/*     */     }
/* 127 */     this.bbuf.flip();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 132 */     if (paramArrayOfbyte == null) {
/* 133 */       throw new NullPointerException("Byte array is null");
/*     */     }
/* 135 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length) {
/* 136 */       throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfbyte.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
/*     */     }
/*     */     
/* 139 */     if (paramInt2 == 0) {
/* 140 */       return 0;
/*     */     }
/* 142 */     if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
/* 143 */       return -1;
/*     */     }
/* 145 */     int i = 0;
/* 146 */     while (paramInt2 > 0) {
/* 147 */       if (this.bbuf.hasRemaining()) {
/* 148 */         int j = Math.min(this.bbuf.remaining(), paramInt2);
/* 149 */         this.bbuf.get(paramArrayOfbyte, paramInt1, j);
/* 150 */         paramInt1 += j;
/* 151 */         paramInt2 -= j;
/* 152 */         i += j; continue;
/*     */       } 
/* 154 */       fillBuffer();
/* 155 */       if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 160 */     return (i == 0 && !this.cbuf.hasRemaining()) ? -1 : i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() {
/*     */     while (true) {
/* 166 */       if (this.bbuf.hasRemaining()) {
/* 167 */         return this.bbuf.get() & 0xFF;
/*     */       }
/* 169 */       fillBuffer();
/* 170 */       if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
/* 171 */         return -1;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 178 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) {
/* 186 */     long l = 0L;
/* 187 */     while (paramLong > 0L && available() > 0) {
/* 188 */       read();
/* 189 */       paramLong--;
/* 190 */       l++;
/*     */     } 
/* 192 */     return l;
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
/*     */   public int available() {
/* 207 */     return this.bbuf.remaining() + this.cbuf.remaining();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 220 */     this.mark_cbuf = this.cbuf.position();
/* 221 */     this.mark_bbuf = this.bbuf.position();
/* 222 */     this.cbuf.mark();
/* 223 */     this.bbuf.mark();
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
/*     */   public synchronized void reset() {
/* 241 */     if (this.mark_cbuf != -1) {
/*     */       
/* 243 */       if (this.cbuf.position() != 0) {
/* 244 */         this.encoder.reset();
/* 245 */         this.cbuf.rewind();
/* 246 */         this.bbuf.rewind();
/* 247 */         this.bbuf.limit(0);
/* 248 */         while (this.cbuf.position() < this.mark_cbuf) {
/* 249 */           this.bbuf.rewind();
/* 250 */           this.bbuf.limit(0);
/* 251 */           fillBuffer();
/*     */         } 
/*     */       } 
/* 254 */       if (this.cbuf.position() != this.mark_cbuf) {
/* 255 */         throw new IllegalStateException("Unexpected CharBuffer postion: actual=" + this.cbuf.position() + " expected=" + this.mark_cbuf);
/*     */       }
/*     */       
/* 258 */       this.bbuf.position(this.mark_bbuf);
/* 259 */       this.mark_cbuf = -1;
/* 260 */       this.mark_bbuf = -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 266 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/CharSequenceInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */