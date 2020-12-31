/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.net;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.Charsets;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.DecoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringDecoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.Base64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BCodec
/*     */   extends RFC1522Codec
/*     */   implements StringEncoder, StringDecoder
/*     */ {
/*     */   private final Charset charset;
/*     */   
/*     */   public BCodec() {
/*  56 */     this(Charsets.UTF_8);
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
/*     */   public BCodec(Charset paramCharset) {
/*  69 */     this.charset = paramCharset;
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
/*     */   public BCodec(String paramString) {
/*  83 */     this(Charset.forName(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getEncoding() {
/*  88 */     return "B";
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doEncoding(byte[] paramArrayOfbyte) {
/*  93 */     if (paramArrayOfbyte == null) {
/*  94 */       return null;
/*     */     }
/*  96 */     return Base64.encodeBase64(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doDecoding(byte[] paramArrayOfbyte) {
/* 101 */     if (paramArrayOfbyte == null) {
/* 102 */       return null;
/*     */     }
/* 104 */     return Base64.decodeBase64(paramArrayOfbyte);
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
/* 120 */     if (paramString == null) {
/* 121 */       return null;
/*     */     }
/* 123 */     return encodeText(paramString, paramCharset);
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
/* 138 */     if (paramString1 == null) {
/* 139 */       return null;
/*     */     }
/*     */     try {
/* 142 */       return encodeText(paramString1, paramString2);
/* 143 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 144 */       throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/* 159 */     if (paramString == null) {
/* 160 */       return null;
/*     */     }
/* 162 */     return encode(paramString, getCharset());
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
/* 177 */     if (paramString == null) {
/* 178 */       return null;
/*     */     }
/*     */     try {
/* 181 */       return decodeText(paramString);
/* 182 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 183 */       throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/* 198 */     if (paramObject == null)
/* 199 */       return null; 
/* 200 */     if (paramObject instanceof String) {
/* 201 */       return encode((String)paramObject);
/*     */     }
/* 203 */     throw new EncoderException("Objects of type " + paramObject
/* 204 */         .getClass().getName() + " cannot be encoded using BCodec");
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
/* 222 */     if (paramObject == null)
/* 223 */       return null; 
/* 224 */     if (paramObject instanceof String) {
/* 225 */       return decode((String)paramObject);
/*     */     }
/* 227 */     throw new DecoderException("Objects of type " + paramObject
/* 228 */         .getClass().getName() + " cannot be decoded using BCodec");
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
/* 240 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 249 */     return this.charset.name();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/net/BCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */