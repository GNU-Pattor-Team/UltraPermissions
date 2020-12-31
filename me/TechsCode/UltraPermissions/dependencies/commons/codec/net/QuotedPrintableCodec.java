/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.net;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.BitSet;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryDecoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryEncoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.Charsets;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.DecoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringDecoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuotedPrintableCodec
/*     */   implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder
/*     */ {
/*     */   private final Charset charset;
/*     */   private final boolean strict;
/*  80 */   private static final BitSet PRINTABLE_CHARS = new BitSet(256);
/*     */ 
/*     */   
/*     */   private static final byte ESCAPE_CHAR = 61;
/*     */ 
/*     */   
/*     */   private static final byte TAB = 9;
/*     */ 
/*     */   
/*     */   private static final byte SPACE = 32;
/*     */   
/*     */   private static final byte CR = 13;
/*     */   
/*     */   private static final byte LF = 10;
/*     */   
/*     */   private static final int SAFE_LENGTH = 73;
/*     */ 
/*     */   
/*     */   static {
/*     */     byte b;
/* 100 */     for (b = 33; b <= 60; b++) {
/* 101 */       PRINTABLE_CHARS.set(b);
/*     */     }
/* 103 */     for (b = 62; b <= 126; b++) {
/* 104 */       PRINTABLE_CHARS.set(b);
/*     */     }
/* 106 */     PRINTABLE_CHARS.set(9);
/* 107 */     PRINTABLE_CHARS.set(32);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QuotedPrintableCodec() {
/* 114 */     this(Charsets.UTF_8, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QuotedPrintableCodec(boolean paramBoolean) {
/* 125 */     this(Charsets.UTF_8, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QuotedPrintableCodec(Charset paramCharset) {
/* 136 */     this(paramCharset, false);
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
/*     */   public QuotedPrintableCodec(Charset paramCharset, boolean paramBoolean) {
/* 149 */     this.charset = paramCharset;
/* 150 */     this.strict = paramBoolean;
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
/*     */   public QuotedPrintableCodec(String paramString) {
/* 170 */     this(Charset.forName(paramString), false);
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
/*     */   private static final int encodeQuotedPrintable(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream) {
/* 183 */     paramByteArrayOutputStream.write(61);
/* 184 */     char c1 = Utils.hexDigit(paramInt >> 4);
/* 185 */     char c2 = Utils.hexDigit(paramInt);
/* 186 */     paramByteArrayOutputStream.write(c1);
/* 187 */     paramByteArrayOutputStream.write(c2);
/* 188 */     return 3;
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
/*     */   private static int getUnsignedOctet(int paramInt, byte[] paramArrayOfbyte) {
/* 202 */     int i = paramArrayOfbyte[paramInt];
/* 203 */     if (i < 0) {
/* 204 */       i = 256 + i;
/*     */     }
/* 206 */     return i;
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
/*     */   private static int encodeByte(int paramInt, boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream) {
/* 222 */     if (paramBoolean) {
/* 223 */       return encodeQuotedPrintable(paramInt, paramByteArrayOutputStream);
/*     */     }
/* 225 */     paramByteArrayOutputStream.write(paramInt);
/* 226 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isWhitespace(int paramInt) {
/* 237 */     return (paramInt == 32 || paramInt == 9);
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
/*     */   public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfbyte) {
/* 253 */     return encodeQuotedPrintable(paramBitSet, paramArrayOfbyte, false);
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
/*     */   public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 273 */     if (paramArrayOfbyte == null) {
/* 274 */       return null;
/*     */     }
/* 276 */     if (paramBitSet == null) {
/* 277 */       paramBitSet = PRINTABLE_CHARS;
/*     */     }
/* 279 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/* 281 */     if (paramBoolean) {
/* 282 */       int i = 1;
/*     */       
/*     */       int j;
/* 285 */       for (j = 0; j < paramArrayOfbyte.length - 3; j++) {
/* 286 */         int m = getUnsignedOctet(j, paramArrayOfbyte);
/* 287 */         if (i < 73) {
/*     */           
/* 289 */           i += encodeByte(m, !paramBitSet.get(m), byteArrayOutputStream);
/*     */         } else {
/*     */           
/* 292 */           encodeByte(m, (!paramBitSet.get(m) || isWhitespace(m)), byteArrayOutputStream);
/*     */ 
/*     */           
/* 295 */           byteArrayOutputStream.write(61);
/* 296 */           byteArrayOutputStream.write(13);
/* 297 */           byteArrayOutputStream.write(10);
/* 298 */           i = 1;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 304 */       j = getUnsignedOctet(paramArrayOfbyte.length - 3, paramArrayOfbyte);
/* 305 */       boolean bool = (!paramBitSet.get(j) || (isWhitespace(j) && i > 68)) ? true : false;
/* 306 */       i += encodeByte(j, bool, byteArrayOutputStream);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 311 */       if (i > 71) {
/* 312 */         byteArrayOutputStream.write(61);
/* 313 */         byteArrayOutputStream.write(13);
/* 314 */         byteArrayOutputStream.write(10);
/*     */       } 
/* 316 */       for (int k = paramArrayOfbyte.length - 2; k < paramArrayOfbyte.length; k++) {
/* 317 */         j = getUnsignedOctet(k, paramArrayOfbyte);
/*     */         
/* 319 */         bool = (!paramBitSet.get(j) || (k > paramArrayOfbyte.length - 2 && isWhitespace(j))) ? true : false;
/* 320 */         encodeByte(j, bool, byteArrayOutputStream);
/*     */       } 
/*     */     } else {
/* 323 */       for (byte b : paramArrayOfbyte) {
/* 324 */         int i = b;
/* 325 */         if (i < 0) {
/* 326 */           i = 256 + i;
/*     */         }
/* 328 */         if (paramBitSet.get(i)) {
/* 329 */           byteArrayOutputStream.write(i);
/*     */         } else {
/* 331 */           encodeQuotedPrintable(i, byteArrayOutputStream);
/*     */         } 
/*     */       } 
/*     */     } 
/* 335 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static final byte[] decodeQuotedPrintable(byte[] paramArrayOfbyte) {
/* 352 */     if (paramArrayOfbyte == null) {
/* 353 */       return null;
/*     */     }
/* 355 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 356 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 357 */       byte b1 = paramArrayOfbyte[b];
/* 358 */       if (b1 == 61) {
/*     */         
/*     */         try {
/* 361 */           if (paramArrayOfbyte[++b] != 13)
/*     */           
/*     */           { 
/* 364 */             int i = Utils.digit16(paramArrayOfbyte[b]);
/* 365 */             int j = Utils.digit16(paramArrayOfbyte[++b]);
/* 366 */             byteArrayOutputStream.write((char)((i << 4) + j)); } 
/* 367 */         } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 368 */           throw new DecoderException("Invalid quoted-printable encoding", arrayIndexOutOfBoundsException);
/*     */         } 
/* 370 */       } else if (b1 != 13 && b1 != 10) {
/*     */         
/* 372 */         byteArrayOutputStream.write(b1);
/*     */       } 
/*     */     } 
/* 375 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 391 */     return encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfbyte, this.strict);
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) {
/* 409 */     return decodeQuotedPrintable(paramArrayOfbyte);
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
/*     */   public String encode(String paramString) {
/* 429 */     return encode(paramString, getCharset());
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
/*     */   public String decode(String paramString, Charset paramCharset) {
/* 446 */     if (paramString == null) {
/* 447 */       return null;
/*     */     }
/* 449 */     return new String(decode(StringUtils.getBytesUsAscii(paramString)), paramCharset);
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
/*     */   public String decode(String paramString1, String paramString2) {
/* 467 */     if (paramString1 == null) {
/* 468 */       return null;
/*     */     }
/* 470 */     return new String(decode(StringUtils.getBytesUsAscii(paramString1)), paramString2);
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
/*     */   public String decode(String paramString) {
/* 486 */     return decode(paramString, getCharset());
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
/*     */   public Object encode(Object paramObject) {
/* 501 */     if (paramObject == null)
/* 502 */       return null; 
/* 503 */     if (paramObject instanceof byte[])
/* 504 */       return encode((byte[])paramObject); 
/* 505 */     if (paramObject instanceof String) {
/* 506 */       return encode((String)paramObject);
/*     */     }
/* 508 */     throw new EncoderException("Objects of type " + paramObject
/* 509 */         .getClass().getName() + " cannot be quoted-printable encoded");
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
/*     */   public Object decode(Object paramObject) {
/* 527 */     if (paramObject == null)
/* 528 */       return null; 
/* 529 */     if (paramObject instanceof byte[])
/* 530 */       return decode((byte[])paramObject); 
/* 531 */     if (paramObject instanceof String) {
/* 532 */       return decode((String)paramObject);
/*     */     }
/* 534 */     throw new DecoderException("Objects of type " + paramObject
/* 535 */         .getClass().getName() + " cannot be quoted-printable decoded");
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
/*     */   public Charset getCharset() {
/* 547 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 556 */     return this.charset.name();
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
/*     */   public String encode(String paramString, Charset paramCharset) {
/* 574 */     if (paramString == null) {
/* 575 */       return null;
/*     */     }
/* 577 */     return StringUtils.newStringUsAscii(encode(paramString.getBytes(paramCharset)));
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
/*     */   public String encode(String paramString1, String paramString2) {
/* 596 */     if (paramString1 == null) {
/* 597 */       return null;
/*     */     }
/* 599 */     return StringUtils.newStringUsAscii(encode(paramString1.getBytes(paramString2)));
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/net/QuotedPrintableCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */