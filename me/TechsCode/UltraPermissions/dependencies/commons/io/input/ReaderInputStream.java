/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReaderInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private static final int DEFAULT_BUFFER_SIZE = 1024;
/*     */   private final Reader reader;
/*     */   private final CharsetEncoder encoder;
/*     */   private final CharBuffer encoderIn;
/*     */   private final ByteBuffer encoderOut;
/*     */   private CoderResult lastCoderResult;
/*     */   private boolean endOfInput;
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder) {
/* 109 */     this(paramReader, paramCharsetEncoder, 1024);
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
/*     */   public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder, int paramInt) {
/* 121 */     this.reader = paramReader;
/* 122 */     this.encoder = paramCharsetEncoder;
/* 123 */     this.encoderIn = CharBuffer.allocate(paramInt);
/* 124 */     this.encoderIn.flip();
/* 125 */     this.encoderOut = ByteBuffer.allocate(128);
/* 126 */     this.encoderOut.flip();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, Charset paramCharset, int paramInt) {
/* 137 */     this(paramReader, paramCharset
/* 138 */         .newEncoder()
/* 139 */         .onMalformedInput(CodingErrorAction.REPLACE)
/* 140 */         .onUnmappableCharacter(CodingErrorAction.REPLACE), paramInt);
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
/*     */   public ReaderInputStream(Reader paramReader, Charset paramCharset) {
/* 152 */     this(paramReader, paramCharset, 1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, String paramString, int paramInt) {
/* 163 */     this(paramReader, Charset.forName(paramString), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReaderInputStream(Reader paramReader, String paramString) {
/* 174 */     this(paramReader, paramString, 1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ReaderInputStream(Reader paramReader) {
/* 186 */     this(paramReader, Charset.defaultCharset());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillBuffer() {
/* 196 */     if (!this.endOfInput && (this.lastCoderResult == null || this.lastCoderResult.isUnderflow())) {
/* 197 */       this.encoderIn.compact();
/* 198 */       int i = this.encoderIn.position();
/*     */ 
/*     */ 
/*     */       
/* 202 */       int j = this.reader.read(this.encoderIn.array(), i, this.encoderIn.remaining());
/* 203 */       if (j == -1) {
/* 204 */         this.endOfInput = true;
/*     */       } else {
/* 206 */         this.encoderIn.position(i + j);
/*     */       } 
/* 208 */       this.encoderIn.flip();
/*     */     } 
/* 210 */     this.encoderOut.compact();
/* 211 */     this.lastCoderResult = this.encoder.encode(this.encoderIn, this.encoderOut, this.endOfInput);
/* 212 */     this.encoderOut.flip();
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 227 */     if (paramArrayOfbyte == null) {
/* 228 */       throw new NullPointerException("Byte array must not be null");
/*     */     }
/* 230 */     if (paramInt2 < 0 || paramInt1 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length) {
/* 231 */       throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfbyte.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
/*     */     }
/*     */     
/* 234 */     int i = 0;
/* 235 */     if (paramInt2 == 0) {
/* 236 */       return 0;
/*     */     }
/* 238 */     while (paramInt2 > 0) {
/* 239 */       if (this.encoderOut.hasRemaining()) {
/* 240 */         int j = Math.min(this.encoderOut.remaining(), paramInt2);
/* 241 */         this.encoderOut.get(paramArrayOfbyte, paramInt1, j);
/* 242 */         paramInt1 += j;
/* 243 */         paramInt2 -= j;
/* 244 */         i += j; continue;
/*     */       } 
/* 246 */       fillBuffer();
/* 247 */       if (this.endOfInput && !this.encoderOut.hasRemaining()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 252 */     return (i == 0 && this.endOfInput) ? -1 : i;
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
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 265 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */     while (true) {
/* 278 */       if (this.encoderOut.hasRemaining()) {
/* 279 */         return this.encoderOut.get() & 0xFF;
/*     */       }
/* 281 */       fillBuffer();
/* 282 */       if (this.endOfInput && !this.encoderOut.hasRemaining()) {
/* 283 */         return -1;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 295 */     this.reader.close();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/ReaderInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */