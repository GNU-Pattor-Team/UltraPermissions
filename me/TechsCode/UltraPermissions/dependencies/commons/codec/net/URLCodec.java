/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.net;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.BitSet;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryDecoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.BinaryEncoder;
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
/*     */ public class URLCodec
/*     */   implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder
/*     */ {
/*     */   @Deprecated
/*     */   protected volatile String charset;
/*     */   protected static final byte ESCAPE_CHAR = 37;
/*     */   @Deprecated
/*     */   protected static final BitSet WWW_FORM_URL;
/*  72 */   private static final BitSet WWW_FORM_URL_SAFE = new BitSet(256);
/*     */ 
/*     */   
/*     */   static {
/*     */     byte b;
/*  77 */     for (b = 97; b <= 122; b++) {
/*  78 */       WWW_FORM_URL_SAFE.set(b);
/*     */     }
/*  80 */     for (b = 65; b <= 90; b++) {
/*  81 */       WWW_FORM_URL_SAFE.set(b);
/*     */     }
/*     */     
/*  84 */     for (b = 48; b <= 57; b++) {
/*  85 */       WWW_FORM_URL_SAFE.set(b);
/*     */     }
/*     */     
/*  88 */     WWW_FORM_URL_SAFE.set(45);
/*  89 */     WWW_FORM_URL_SAFE.set(95);
/*  90 */     WWW_FORM_URL_SAFE.set(46);
/*  91 */     WWW_FORM_URL_SAFE.set(42);
/*     */     
/*  93 */     WWW_FORM_URL_SAFE.set(32);
/*     */ 
/*     */     
/*  96 */     WWW_FORM_URL = (BitSet)WWW_FORM_URL_SAFE.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URLCodec() {
/* 104 */     this("UTF-8");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URLCodec(String paramString) {
/* 114 */     this.charset = paramString;
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
/*     */   public static final byte[] encodeUrl(BitSet paramBitSet, byte[] paramArrayOfbyte) {
/* 127 */     if (paramArrayOfbyte == null) {
/* 128 */       return null;
/*     */     }
/* 130 */     if (paramBitSet == null) {
/* 131 */       paramBitSet = WWW_FORM_URL_SAFE;
/*     */     }
/*     */     
/* 134 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 135 */     for (byte b : paramArrayOfbyte) {
/* 136 */       int i = b;
/* 137 */       if (i < 0) {
/* 138 */         i = 256 + i;
/*     */       }
/* 140 */       if (paramBitSet.get(i)) {
/* 141 */         if (i == 32) {
/* 142 */           i = 43;
/*     */         }
/* 144 */         byteArrayOutputStream.write(i);
/*     */       } else {
/* 146 */         byteArrayOutputStream.write(37);
/* 147 */         char c1 = Utils.hexDigit(i >> 4);
/* 148 */         char c2 = Utils.hexDigit(i);
/* 149 */         byteArrayOutputStream.write(c1);
/* 150 */         byteArrayOutputStream.write(c2);
/*     */       } 
/*     */     } 
/* 153 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static final byte[] decodeUrl(byte[] paramArrayOfbyte) {
/* 167 */     if (paramArrayOfbyte == null) {
/* 168 */       return null;
/*     */     }
/* 170 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 171 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 172 */       byte b1 = paramArrayOfbyte[b];
/* 173 */       if (b1 == 43) {
/* 174 */         byteArrayOutputStream.write(32);
/* 175 */       } else if (b1 == 37) {
/*     */         try {
/* 177 */           int i = Utils.digit16(paramArrayOfbyte[++b]);
/* 178 */           int j = Utils.digit16(paramArrayOfbyte[++b]);
/* 179 */           byteArrayOutputStream.write((char)((i << 4) + j));
/* 180 */         } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 181 */           throw new DecoderException("Invalid URL encoding: ", arrayIndexOutOfBoundsException);
/*     */         } 
/*     */       } else {
/* 184 */         byteArrayOutputStream.write(b1);
/*     */       } 
/*     */     } 
/* 187 */     return byteArrayOutputStream.toByteArray();
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
/* 199 */     return encodeUrl(WWW_FORM_URL_SAFE, paramArrayOfbyte);
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) {
/* 215 */     return decodeUrl(paramArrayOfbyte);
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
/* 230 */     if (paramString1 == null) {
/* 231 */       return null;
/*     */     }
/* 233 */     return StringUtils.newStringUsAscii(encode(paramString1.getBytes(paramString2)));
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
/*     */   public String encode(String paramString) {
/* 249 */     if (paramString == null) {
/* 250 */       return null;
/*     */     }
/*     */     try {
/* 253 */       return encode(paramString, getDefaultCharset());
/* 254 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 255 */       throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/*     */   public String decode(String paramString1, String paramString2) {
/* 276 */     if (paramString1 == null) {
/* 277 */       return null;
/*     */     }
/* 279 */     return new String(decode(StringUtils.getBytesUsAscii(paramString1)), paramString2);
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
/* 295 */     if (paramString == null) {
/* 296 */       return null;
/*     */     }
/*     */     try {
/* 299 */       return decode(paramString, getDefaultCharset());
/* 300 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 301 */       throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/* 316 */     if (paramObject == null)
/* 317 */       return null; 
/* 318 */     if (paramObject instanceof byte[])
/* 319 */       return encode((byte[])paramObject); 
/* 320 */     if (paramObject instanceof String) {
/* 321 */       return encode((String)paramObject);
/*     */     }
/* 323 */     throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL encoded");
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
/* 341 */     if (paramObject == null)
/* 342 */       return null; 
/* 343 */     if (paramObject instanceof byte[])
/* 344 */       return decode((byte[])paramObject); 
/* 345 */     if (paramObject instanceof String) {
/* 346 */       return decode((String)paramObject);
/*     */     }
/* 348 */     throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL decoded");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 359 */     return this.charset;
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
/*     */   public String getEncoding() {
/* 371 */     return this.charset;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/net/URLCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */