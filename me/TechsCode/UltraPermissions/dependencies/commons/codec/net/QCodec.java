/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.net;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.BitSet;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.Charsets;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.DecoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringDecoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QCodec
/*     */   extends RFC1522Codec
/*     */   implements StringEncoder, StringDecoder
/*     */ {
/*     */   private final Charset charset;
/*  61 */   private static final BitSet PRINTABLE_CHARS = new BitSet(256);
/*     */   private static final byte SPACE = 32;
/*     */   
/*     */   static {
/*  65 */     PRINTABLE_CHARS.set(32);
/*  66 */     PRINTABLE_CHARS.set(33);
/*  67 */     PRINTABLE_CHARS.set(34);
/*  68 */     PRINTABLE_CHARS.set(35);
/*  69 */     PRINTABLE_CHARS.set(36);
/*  70 */     PRINTABLE_CHARS.set(37);
/*  71 */     PRINTABLE_CHARS.set(38);
/*  72 */     PRINTABLE_CHARS.set(39);
/*  73 */     PRINTABLE_CHARS.set(40);
/*  74 */     PRINTABLE_CHARS.set(41);
/*  75 */     PRINTABLE_CHARS.set(42);
/*  76 */     PRINTABLE_CHARS.set(43);
/*  77 */     PRINTABLE_CHARS.set(44);
/*  78 */     PRINTABLE_CHARS.set(45);
/*  79 */     PRINTABLE_CHARS.set(46);
/*  80 */     PRINTABLE_CHARS.set(47); byte b;
/*  81 */     for (b = 48; b <= 57; b++) {
/*  82 */       PRINTABLE_CHARS.set(b);
/*     */     }
/*  84 */     PRINTABLE_CHARS.set(58);
/*  85 */     PRINTABLE_CHARS.set(59);
/*  86 */     PRINTABLE_CHARS.set(60);
/*  87 */     PRINTABLE_CHARS.set(62);
/*  88 */     PRINTABLE_CHARS.set(64);
/*  89 */     for (b = 65; b <= 90; b++) {
/*  90 */       PRINTABLE_CHARS.set(b);
/*     */     }
/*  92 */     PRINTABLE_CHARS.set(91);
/*  93 */     PRINTABLE_CHARS.set(92);
/*  94 */     PRINTABLE_CHARS.set(93);
/*  95 */     PRINTABLE_CHARS.set(94);
/*  96 */     PRINTABLE_CHARS.set(96);
/*  97 */     for (b = 97; b <= 122; b++) {
/*  98 */       PRINTABLE_CHARS.set(b);
/*     */     }
/* 100 */     PRINTABLE_CHARS.set(123);
/* 101 */     PRINTABLE_CHARS.set(124);
/* 102 */     PRINTABLE_CHARS.set(125);
/* 103 */     PRINTABLE_CHARS.set(126);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final byte UNDERSCORE = 95;
/*     */ 
/*     */   
/*     */   private boolean encodeBlanks = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public QCodec() {
/* 116 */     this(Charsets.UTF_8);
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
/*     */   public QCodec(Charset paramCharset) {
/* 130 */     this.charset = paramCharset;
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
/*     */   public QCodec(String paramString) {
/* 144 */     this(Charset.forName(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getEncoding() {
/* 149 */     return "Q";
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doEncoding(byte[] paramArrayOfbyte) {
/* 154 */     if (paramArrayOfbyte == null) {
/* 155 */       return null;
/*     */     }
/* 157 */     byte[] arrayOfByte = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfbyte);
/* 158 */     if (this.encodeBlanks) {
/* 159 */       for (byte b = 0; b < arrayOfByte.length; b++) {
/* 160 */         if (arrayOfByte[b] == 32) {
/* 161 */           arrayOfByte[b] = 95;
/*     */         }
/*     */       } 
/*     */     }
/* 165 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doDecoding(byte[] paramArrayOfbyte) {
/* 170 */     if (paramArrayOfbyte == null) {
/* 171 */       return null;
/*     */     }
/* 173 */     boolean bool = false;
/* 174 */     for (byte b : paramArrayOfbyte) {
/* 175 */       if (b == 95) {
/* 176 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 180 */     if (bool) {
/* 181 */       byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
/* 182 */       for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 183 */         byte b1 = paramArrayOfbyte[b];
/* 184 */         if (b1 != 95) {
/* 185 */           arrayOfByte[b] = b1;
/*     */         } else {
/* 187 */           arrayOfByte[b] = 32;
/*     */         } 
/*     */       } 
/* 190 */       return QuotedPrintableCodec.decodeQuotedPrintable(arrayOfByte);
/*     */     } 
/* 192 */     return QuotedPrintableCodec.decodeQuotedPrintable(paramArrayOfbyte);
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
/*     */   public String encode(String paramString, Charset paramCharset) {
/* 208 */     if (paramString == null) {
/* 209 */       return null;
/*     */     }
/* 211 */     return encodeText(paramString, paramCharset);
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
/*     */   public String encode(String paramString1, String paramString2) {
/* 226 */     if (paramString1 == null) {
/* 227 */       return null;
/*     */     }
/*     */     try {
/* 230 */       return encodeText(paramString1, paramString2);
/* 231 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 232 */       throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/*     */   public String encode(String paramString) {
/* 247 */     if (paramString == null) {
/* 248 */       return null;
/*     */     }
/* 250 */     return encode(paramString, getCharset());
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
/*     */   public String decode(String paramString) {
/* 265 */     if (paramString == null) {
/* 266 */       return null;
/*     */     }
/*     */     try {
/* 269 */       return decodeText(paramString);
/* 270 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 271 */       throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/*     */   public Object encode(Object paramObject) {
/* 286 */     if (paramObject == null)
/* 287 */       return null; 
/* 288 */     if (paramObject instanceof String) {
/* 289 */       return encode((String)paramObject);
/*     */     }
/* 291 */     throw new EncoderException("Objects of type " + paramObject
/* 292 */         .getClass().getName() + " cannot be encoded using Q codec");
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
/* 310 */     if (paramObject == null)
/* 311 */       return null; 
/* 312 */     if (paramObject instanceof String) {
/* 313 */       return decode((String)paramObject);
/*     */     }
/* 315 */     throw new DecoderException("Objects of type " + paramObject
/* 316 */         .getClass().getName() + " cannot be decoded using Q codec");
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
/* 328 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 337 */     return this.charset.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEncodeBlanks() {
/* 346 */     return this.encodeBlanks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEncodeBlanks(boolean paramBoolean) {
/* 356 */     this.encodeBlanks = paramBoolean;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/net/QCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */