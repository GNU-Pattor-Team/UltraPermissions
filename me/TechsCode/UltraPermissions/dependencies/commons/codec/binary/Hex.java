/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryDecoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryEncoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.Charsets;
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
/*     */ public class Hex
/*     */   implements BinaryEncoder, BinaryDecoder
/*     */ {
/*  46 */   public static final Charset DEFAULT_CHARSET = Charsets.UTF_8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String DEFAULT_CHARSET_NAME = "UTF-8";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private static final char[] DIGITS_LOWER = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private static final char[] DIGITS_UPPER = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Charset charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decodeHex(String paramString) {
/*  80 */     return decodeHex(paramString.toCharArray());
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
/*     */   public static byte[] decodeHex(char[] paramArrayOfchar) {
/*  96 */     int i = paramArrayOfchar.length;
/*     */     
/*  98 */     if ((i & 0x1) != 0) {
/*  99 */       throw new DecoderException("Odd number of characters.");
/*     */     }
/*     */     
/* 102 */     byte[] arrayOfByte = new byte[i >> 1];
/*     */ 
/*     */     
/* 105 */     for (byte b1 = 0, b2 = 0; b2 < i; b1++) {
/* 106 */       int j = toDigit(paramArrayOfchar[b2], b2) << 4;
/* 107 */       b2++;
/* 108 */       j |= toDigit(paramArrayOfchar[b2], b2);
/* 109 */       b2++;
/* 110 */       arrayOfByte[b1] = (byte)(j & 0xFF);
/*     */     } 
/*     */     
/* 113 */     return arrayOfByte;
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
/*     */   public static char[] encodeHex(byte[] paramArrayOfbyte) {
/* 126 */     return encodeHex(paramArrayOfbyte, true);
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
/*     */   public static char[] encodeHex(ByteBuffer paramByteBuffer) {
/* 140 */     return encodeHex(paramByteBuffer, true);
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
/*     */   public static char[] encodeHex(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 156 */     return encodeHex(paramArrayOfbyte, paramBoolean ? DIGITS_LOWER : DIGITS_UPPER);
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
/*     */   public static char[] encodeHex(ByteBuffer paramByteBuffer, boolean paramBoolean) {
/* 172 */     return encodeHex(paramByteBuffer, paramBoolean ? DIGITS_LOWER : DIGITS_UPPER);
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
/*     */   protected static char[] encodeHex(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
/* 189 */     int i = paramArrayOfbyte.length;
/* 190 */     char[] arrayOfChar = new char[i << 1];
/*     */     
/* 192 */     for (byte b1 = 0, b2 = 0; b1 < i; b1++) {
/* 193 */       arrayOfChar[b2++] = paramArrayOfchar[(0xF0 & paramArrayOfbyte[b1]) >>> 4];
/* 194 */       arrayOfChar[b2++] = paramArrayOfchar[0xF & paramArrayOfbyte[b1]];
/*     */     } 
/* 196 */     return arrayOfChar;
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
/*     */   protected static char[] encodeHex(ByteBuffer paramByteBuffer, char[] paramArrayOfchar) {
/* 213 */     return encodeHex(paramByteBuffer.array(), paramArrayOfchar);
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
/*     */   public static String encodeHexString(byte[] paramArrayOfbyte) {
/* 226 */     return new String(encodeHex(paramArrayOfbyte));
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
/*     */   public static String encodeHexString(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 241 */     return new String(encodeHex(paramArrayOfbyte, paramBoolean));
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
/*     */   public static String encodeHexString(ByteBuffer paramByteBuffer) {
/* 254 */     return new String(encodeHex(paramByteBuffer));
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
/*     */   public static String encodeHexString(ByteBuffer paramByteBuffer, boolean paramBoolean) {
/* 269 */     return new String(encodeHex(paramByteBuffer, paramBoolean));
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
/*     */   protected static int toDigit(char paramChar, int paramInt) {
/* 284 */     int i = Character.digit(paramChar, 16);
/* 285 */     if (i == -1) {
/* 286 */       throw new DecoderException("Illegal hexadecimal character " + paramChar + " at index " + paramInt);
/*     */     }
/* 288 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hex() {
/* 298 */     this.charset = DEFAULT_CHARSET;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hex(Charset paramCharset) {
/* 309 */     this.charset = paramCharset;
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
/*     */   public Hex(String paramString) {
/* 323 */     this(Charset.forName(paramString));
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) {
/* 340 */     return decodeHex((new String(paramArrayOfbyte, getCharset())).toCharArray());
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
/*     */   public byte[] decode(ByteBuffer paramByteBuffer) {
/* 357 */     return decodeHex((new String(paramByteBuffer.array(), getCharset())).toCharArray());
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
/* 375 */     if (paramObject instanceof String)
/* 376 */       return decode(((String)paramObject).toCharArray()); 
/* 377 */     if (paramObject instanceof byte[])
/* 378 */       return decode((byte[])paramObject); 
/* 379 */     if (paramObject instanceof ByteBuffer) {
/* 380 */       return decode((ByteBuffer)paramObject);
/*     */     }
/*     */     try {
/* 383 */       return decodeHex((char[])paramObject);
/* 384 */     } catch (ClassCastException classCastException) {
/* 385 */       throw new DecoderException(classCastException.getMessage(), classCastException);
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 407 */     return encodeHexString(paramArrayOfbyte).getBytes(getCharset());
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
/*     */   public byte[] encode(ByteBuffer paramByteBuffer) {
/* 426 */     return encodeHexString(paramByteBuffer).getBytes(getCharset());
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
/*     */   public Object encode(Object paramObject) {
/*     */     byte[] arrayOfByte;
/* 448 */     if (paramObject instanceof String) {
/* 449 */       arrayOfByte = ((String)paramObject).getBytes(getCharset());
/* 450 */     } else if (paramObject instanceof ByteBuffer) {
/* 451 */       arrayOfByte = ((ByteBuffer)paramObject).array();
/*     */     } else {
/*     */       try {
/* 454 */         arrayOfByte = (byte[])paramObject;
/* 455 */       } catch (ClassCastException classCastException) {
/* 456 */         throw new EncoderException(classCastException.getMessage(), classCastException);
/*     */       } 
/*     */     } 
/* 459 */     return encodeHex(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCharset() {
/* 469 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCharsetName() {
/* 479 */     return this.charset.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 489 */     return super.toString() + "[charsetName=" + this.charset + "]";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/Hex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */