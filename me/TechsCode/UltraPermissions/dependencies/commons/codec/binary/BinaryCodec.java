/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*     */ 
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
/*     */ public class BinaryCodec
/*     */   implements BinaryDecoder, BinaryEncoder
/*     */ {
/*  42 */   private static final char[] EMPTY_CHAR_ARRAY = new char[0];
/*     */ 
/*     */   
/*  45 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*     */ 
/*     */   
/*     */   private static final int BIT_0 = 1;
/*     */ 
/*     */   
/*     */   private static final int BIT_1 = 2;
/*     */ 
/*     */   
/*     */   private static final int BIT_2 = 4;
/*     */ 
/*     */   
/*     */   private static final int BIT_3 = 8;
/*     */ 
/*     */   
/*     */   private static final int BIT_4 = 16;
/*     */ 
/*     */   
/*     */   private static final int BIT_5 = 32;
/*     */ 
/*     */   
/*     */   private static final int BIT_6 = 64;
/*     */ 
/*     */   
/*     */   private static final int BIT_7 = 128;
/*     */   
/*  71 */   private static final int[] BITS = new int[] { 1, 2, 4, 8, 16, 32, 64, 128 };
/*     */ 
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
/*  83 */     return toAsciiBytes(paramArrayOfbyte);
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
/*  98 */     if (!(paramObject instanceof byte[])) {
/*  99 */       throw new EncoderException("argument not a byte array");
/*     */     }
/* 101 */     return toAsciiChars((byte[])paramObject);
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
/*     */   public Object decode(Object paramObject) {
/* 116 */     if (paramObject == null) {
/* 117 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 119 */     if (paramObject instanceof byte[]) {
/* 120 */       return fromAscii((byte[])paramObject);
/*     */     }
/* 122 */     if (paramObject instanceof char[]) {
/* 123 */       return fromAscii((char[])paramObject);
/*     */     }
/* 125 */     if (paramObject instanceof String) {
/* 126 */       return fromAscii(((String)paramObject).toCharArray());
/*     */     }
/* 128 */     throw new DecoderException("argument not a byte array");
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) {
/* 141 */     return fromAscii(paramArrayOfbyte);
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
/*     */   public byte[] toByteArray(String paramString) {
/* 153 */     if (paramString == null) {
/* 154 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 156 */     return fromAscii(paramString.toCharArray());
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
/*     */   public static byte[] fromAscii(char[] paramArrayOfchar) {
/* 172 */     if (paramArrayOfchar == null || paramArrayOfchar.length == 0) {
/* 173 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/*     */     
/* 176 */     byte[] arrayOfByte = new byte[paramArrayOfchar.length >> 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/* 181 */     for (b = 0, i = paramArrayOfchar.length - 1; b < arrayOfByte.length; b++, i -= 8) {
/* 182 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/* 183 */         if (paramArrayOfchar[i - b1] == '1') {
/* 184 */           arrayOfByte[b] = (byte)(arrayOfByte[b] | BITS[b1]);
/*     */         }
/*     */       } 
/*     */     } 
/* 188 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] fromAscii(byte[] paramArrayOfbyte) {
/* 199 */     if (isEmpty(paramArrayOfbyte)) {
/* 200 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/*     */     
/* 203 */     byte[] arrayOfByte = new byte[paramArrayOfbyte.length >> 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/* 208 */     for (b = 0, i = paramArrayOfbyte.length - 1; b < arrayOfByte.length; b++, i -= 8) {
/* 209 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/* 210 */         if (paramArrayOfbyte[i - b1] == 49) {
/* 211 */           arrayOfByte[b] = (byte)(arrayOfByte[b] | BITS[b1]);
/*     */         }
/*     */       } 
/*     */     } 
/* 215 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isEmpty(byte[] paramArrayOfbyte) {
/* 226 */     return (paramArrayOfbyte == null || paramArrayOfbyte.length == 0);
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
/*     */   public static byte[] toAsciiBytes(byte[] paramArrayOfbyte) {
/* 239 */     if (isEmpty(paramArrayOfbyte)) {
/* 240 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/*     */     
/* 243 */     byte[] arrayOfByte = new byte[paramArrayOfbyte.length << 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/* 248 */     for (b = 0, i = arrayOfByte.length - 1; b < paramArrayOfbyte.length; b++, i -= 8) {
/* 249 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/* 250 */         if ((paramArrayOfbyte[b] & BITS[b1]) == 0) {
/* 251 */           arrayOfByte[i - b1] = 48;
/*     */         } else {
/* 253 */           arrayOfByte[i - b1] = 49;
/*     */         } 
/*     */       } 
/*     */     } 
/* 257 */     return arrayOfByte;
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
/*     */   public static char[] toAsciiChars(byte[] paramArrayOfbyte) {
/* 269 */     if (isEmpty(paramArrayOfbyte)) {
/* 270 */       return EMPTY_CHAR_ARRAY;
/*     */     }
/*     */     
/* 273 */     char[] arrayOfChar = new char[paramArrayOfbyte.length << 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/* 278 */     for (b = 0, i = arrayOfChar.length - 1; b < paramArrayOfbyte.length; b++, i -= 8) {
/* 279 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/* 280 */         if ((paramArrayOfbyte[b] & BITS[b1]) == 0) {
/* 281 */           arrayOfChar[i - b1] = '0';
/*     */         } else {
/* 283 */           arrayOfChar[i - b1] = '1';
/*     */         } 
/*     */       } 
/*     */     } 
/* 287 */     return arrayOfChar;
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
/*     */   public static String toAsciiString(byte[] paramArrayOfbyte) {
/* 299 */     return new String(toAsciiChars(paramArrayOfbyte));
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/BinaryCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */