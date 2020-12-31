/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.Charsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringUtils
/*     */ {
/*     */   public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  72 */     if (paramCharSequence1 == paramCharSequence2) {
/*  73 */       return true;
/*     */     }
/*  75 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/*  76 */       return false;
/*     */     }
/*  78 */     if (paramCharSequence1 instanceof String && paramCharSequence2 instanceof String) {
/*  79 */       return paramCharSequence1.equals(paramCharSequence2);
/*     */     }
/*  81 */     return (paramCharSequence1.length() == paramCharSequence2.length() && CharSequenceUtils.regionMatches(paramCharSequence1, false, 0, paramCharSequence2, 0, paramCharSequence1.length()));
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
/*     */   private static byte[] getBytes(String paramString, Charset paramCharset) {
/*  94 */     if (paramString == null) {
/*  95 */       return null;
/*     */     }
/*  97 */     return paramString.getBytes(paramCharset);
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
/*     */   private static ByteBuffer getByteBuffer(String paramString, Charset paramCharset) {
/* 110 */     if (paramString == null) {
/* 111 */       return null;
/*     */     }
/* 113 */     return ByteBuffer.wrap(paramString.getBytes(paramCharset));
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
/*     */   public static ByteBuffer getByteBufferUtf8(String paramString) {
/* 131 */     return getByteBuffer(paramString, Charsets.UTF_8);
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
/*     */   public static byte[] getBytesIso8859_1(String paramString) {
/* 149 */     return getBytes(paramString, Charsets.ISO_8859_1);
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
/*     */   public static byte[] getBytesUnchecked(String paramString1, String paramString2) {
/* 173 */     if (paramString1 == null) {
/* 174 */       return null;
/*     */     }
/*     */     try {
/* 177 */       return paramString1.getBytes(paramString2);
/* 178 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 179 */       throw newIllegalStateException(paramString2, unsupportedEncodingException);
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
/*     */   public static byte[] getBytesUsAscii(String paramString) {
/* 198 */     return getBytes(paramString, Charsets.US_ASCII);
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
/*     */   public static byte[] getBytesUtf16(String paramString) {
/* 216 */     return getBytes(paramString, Charsets.UTF_16);
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
/*     */   public static byte[] getBytesUtf16Be(String paramString) {
/* 234 */     return getBytes(paramString, Charsets.UTF_16BE);
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
/*     */   public static byte[] getBytesUtf16Le(String paramString) {
/* 252 */     return getBytes(paramString, Charsets.UTF_16LE);
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
/*     */   public static byte[] getBytesUtf8(String paramString) {
/* 270 */     return getBytes(paramString, Charsets.UTF_8);
/*     */   }
/*     */ 
/*     */   
/*     */   private static IllegalStateException newIllegalStateException(String paramString, UnsupportedEncodingException paramUnsupportedEncodingException) {
/* 275 */     return new IllegalStateException(paramString + ": " + paramUnsupportedEncodingException);
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
/*     */   private static String newString(byte[] paramArrayOfbyte, Charset paramCharset) {
/* 291 */     return (paramArrayOfbyte == null) ? null : new String(paramArrayOfbyte, paramCharset);
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
/*     */   public static String newString(byte[] paramArrayOfbyte, String paramString) {
/* 314 */     if (paramArrayOfbyte == null) {
/* 315 */       return null;
/*     */     }
/*     */     try {
/* 318 */       return new String(paramArrayOfbyte, paramString);
/* 319 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 320 */       throw newIllegalStateException(paramString, unsupportedEncodingException);
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
/*     */   public static String newStringIso8859_1(byte[] paramArrayOfbyte) {
/* 337 */     return newString(paramArrayOfbyte, Charsets.ISO_8859_1);
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
/*     */   public static String newStringUsAscii(byte[] paramArrayOfbyte) {
/* 353 */     return newString(paramArrayOfbyte, Charsets.US_ASCII);
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
/*     */   public static String newStringUtf16(byte[] paramArrayOfbyte) {
/* 369 */     return newString(paramArrayOfbyte, Charsets.UTF_16);
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
/*     */   public static String newStringUtf16Be(byte[] paramArrayOfbyte) {
/* 385 */     return newString(paramArrayOfbyte, Charsets.UTF_16BE);
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
/*     */   public static String newStringUtf16Le(byte[] paramArrayOfbyte) {
/* 401 */     return newString(paramArrayOfbyte, Charsets.UTF_16LE);
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
/*     */   public static String newStringUtf8(byte[] paramArrayOfbyte) {
/* 417 */     return newString(paramArrayOfbyte, Charsets.UTF_8);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/StringUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */