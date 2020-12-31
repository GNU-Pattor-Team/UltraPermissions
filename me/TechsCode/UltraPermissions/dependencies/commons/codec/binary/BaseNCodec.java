/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryDecoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryEncoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.DecoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BaseNCodec
/*     */   implements BinaryEncoder, BinaryDecoder
/*     */ {
/*     */   static final int EOF = -1;
/*     */   public static final int MIME_CHUNK_SIZE = 76;
/*     */   public static final int PEM_CHUNK_SIZE = 64;
/*     */   private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
/*     */   private static final int DEFAULT_BUFFER_SIZE = 8192;
/*     */   protected static final int MASK_8BITS = 255;
/*     */   protected static final byte PAD_DEFAULT = 61;
/*     */   
/*     */   static class Context
/*     */   {
/*     */     int ibitWorkArea;
/*     */     long lbitWorkArea;
/*     */     byte[] buffer;
/*     */     int pos;
/*     */     int readPos;
/*     */     boolean eof;
/*     */     int currentLinePos;
/*     */     int modulus;
/*     */     
/*     */     public String toString() {
/* 103 */       return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[] {
/* 104 */             getClass().getSimpleName(), Arrays.toString(this.buffer), 
/* 105 */             Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos)
/*     */           });
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 159 */   protected final byte PAD = 61;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final byte pad;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int unencodedBlockSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int encodedBlockSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final int lineLength;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int chunkSeparatorLength;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 192 */     this(paramInt1, paramInt2, paramInt3, paramInt4, (byte)61);
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
/*     */   protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
/* 206 */     this.unencodedBlockSize = paramInt1;
/* 207 */     this.encodedBlockSize = paramInt2;
/* 208 */     boolean bool = (paramInt3 > 0 && paramInt4 > 0) ? true : false;
/* 209 */     this.lineLength = bool ? (paramInt3 / paramInt2 * paramInt2) : 0;
/* 210 */     this.chunkSeparatorLength = paramInt4;
/*     */     
/* 212 */     this.pad = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean hasData(Context paramContext) {
/* 222 */     return (paramContext.buffer != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int available(Context paramContext) {
/* 232 */     return (paramContext.buffer != null) ? (paramContext.pos - paramContext.readPos) : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDefaultBufferSize() {
/* 241 */     return 8192;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] resizeBuffer(Context paramContext) {
/* 249 */     if (paramContext.buffer == null) {
/* 250 */       paramContext.buffer = new byte[getDefaultBufferSize()];
/* 251 */       paramContext.pos = 0;
/* 252 */       paramContext.readPos = 0;
/*     */     } else {
/* 254 */       byte[] arrayOfByte = new byte[paramContext.buffer.length * 2];
/* 255 */       System.arraycopy(paramContext.buffer, 0, arrayOfByte, 0, paramContext.buffer.length);
/* 256 */       paramContext.buffer = arrayOfByte;
/*     */     } 
/* 258 */     return paramContext.buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] ensureBufferSize(int paramInt, Context paramContext) {
/* 269 */     if (paramContext.buffer == null || paramContext.buffer.length < paramContext.pos + paramInt) {
/* 270 */       return resizeBuffer(paramContext);
/*     */     }
/* 272 */     return paramContext.buffer;
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
/*     */   
/*     */   int readResults(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Context paramContext) {
/* 292 */     if (paramContext.buffer != null) {
/* 293 */       int i = Math.min(available(paramContext), paramInt2);
/* 294 */       System.arraycopy(paramContext.buffer, paramContext.readPos, paramArrayOfbyte, paramInt1, i);
/* 295 */       paramContext.readPos += i;
/* 296 */       if (paramContext.readPos >= paramContext.pos) {
/* 297 */         paramContext.buffer = null;
/*     */       }
/* 299 */       return i;
/*     */     } 
/* 301 */     return paramContext.eof ? -1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean isWhiteSpace(byte paramByte) {
/* 312 */     switch (paramByte) {
/*     */       case 9:
/*     */       case 10:
/*     */       case 13:
/*     */       case 32:
/* 317 */         return true;
/*     */     } 
/* 319 */     return false;
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
/*     */   public Object encode(Object paramObject) {
/* 335 */     if (!(paramObject instanceof byte[])) {
/* 336 */       throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
/*     */     }
/* 338 */     return encode((byte[])paramObject);
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
/*     */   public String encodeToString(byte[] paramArrayOfbyte) {
/* 350 */     return StringUtils.newStringUtf8(encode(paramArrayOfbyte));
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
/*     */   public String encodeAsString(byte[] paramArrayOfbyte) {
/* 363 */     return StringUtils.newStringUtf8(encode(paramArrayOfbyte));
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
/*     */   public Object decode(Object paramObject) {
/* 379 */     if (paramObject instanceof byte[])
/* 380 */       return decode((byte[])paramObject); 
/* 381 */     if (paramObject instanceof String) {
/* 382 */       return decode((String)paramObject);
/*     */     }
/* 384 */     throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
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
/*     */   public byte[] decode(String paramString) {
/* 396 */     return decode(StringUtils.getBytesUtf8(paramString));
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) {
/* 408 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 409 */       return paramArrayOfbyte;
/*     */     }
/* 411 */     Context context = new Context();
/* 412 */     decode(paramArrayOfbyte, 0, paramArrayOfbyte.length, context);
/* 413 */     decode(paramArrayOfbyte, 0, -1, context);
/* 414 */     byte[] arrayOfByte = new byte[context.pos];
/* 415 */     readResults(arrayOfByte, 0, arrayOfByte.length, context);
/* 416 */     return arrayOfByte;
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 428 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 429 */       return paramArrayOfbyte;
/*     */     }
/* 431 */     return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 448 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 449 */       return paramArrayOfbyte;
/*     */     }
/* 451 */     Context context = new Context();
/* 452 */     encode(paramArrayOfbyte, paramInt1, paramInt2, context);
/* 453 */     encode(paramArrayOfbyte, paramInt1, -1, context);
/* 454 */     byte[] arrayOfByte = new byte[context.pos - context.readPos];
/* 455 */     readResults(arrayOfByte, 0, arrayOfByte.length, context);
/* 456 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Context paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Context paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean isInAlphabet(byte paramByte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInAlphabet(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 486 */     for (byte b : paramArrayOfbyte) {
/* 487 */       if (!isInAlphabet(b) && (!paramBoolean || (b != this.pad && 
/* 488 */         !isWhiteSpace(b)))) {
/* 489 */         return false;
/*     */       }
/*     */     } 
/* 492 */     return true;
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
/*     */   public boolean isInAlphabet(String paramString) {
/* 505 */     return isInAlphabet(StringUtils.getBytesUtf8(paramString), true);
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
/*     */   protected boolean containsAlphabetOrPad(byte[] paramArrayOfbyte) {
/* 518 */     if (paramArrayOfbyte == null) {
/* 519 */       return false;
/*     */     }
/* 521 */     for (byte b : paramArrayOfbyte) {
/* 522 */       if (this.pad == b || isInAlphabet(b)) {
/* 523 */         return true;
/*     */       }
/*     */     } 
/* 526 */     return false;
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
/*     */   public long getEncodedLength(byte[] paramArrayOfbyte) {
/* 540 */     long l = ((paramArrayOfbyte.length + this.unencodedBlockSize - 1) / this.unencodedBlockSize) * this.encodedBlockSize;
/* 541 */     if (this.lineLength > 0)
/*     */     {
/* 543 */       l += (l + this.lineLength - 1L) / this.lineLength * this.chunkSeparatorLength;
/*     */     }
/* 545 */     return l;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/BaseNCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */