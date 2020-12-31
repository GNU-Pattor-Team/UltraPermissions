/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Base64
/*     */   extends BaseNCodec
/*     */ {
/*     */   private static final int BITS_PER_ENCODED_BYTE = 6;
/*     */   private static final int BYTES_PER_UNENCODED_BLOCK = 3;
/*     */   private static final int BYTES_PER_ENCODED_BLOCK = 4;
/*  74 */   static final byte[] CHUNK_SEPARATOR = new byte[] { 13, 10 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private static final byte[] STANDARD_ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   private static final byte[] URL_SAFE_ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   private static final byte[] DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MASK_6BITS = 63;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] encodeTable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 145 */   private final byte[] decodeTable = DECODE_TABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] lineSeparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int decodeSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int encodeSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base64() {
/* 175 */     this(0);
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
/*     */   public Base64(boolean paramBoolean) {
/* 194 */     this(76, CHUNK_SEPARATOR, paramBoolean);
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
/*     */   public Base64(int paramInt) {
/* 217 */     this(paramInt, CHUNK_SEPARATOR);
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
/*     */   public Base64(int paramInt, byte[] paramArrayOfbyte) {
/* 244 */     this(paramInt, paramArrayOfbyte, false);
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
/*     */   public Base64(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 275 */     super(3, 4, paramInt, (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 280 */     if (paramArrayOfbyte != null) {
/* 281 */       if (containsAlphabetOrPad(paramArrayOfbyte)) {
/* 282 */         String str = StringUtils.newStringUtf8(paramArrayOfbyte);
/* 283 */         throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + str + "]");
/*     */       } 
/* 285 */       if (paramInt > 0) {
/* 286 */         this.encodeSize = 4 + paramArrayOfbyte.length;
/* 287 */         this.lineSeparator = new byte[paramArrayOfbyte.length];
/* 288 */         System.arraycopy(paramArrayOfbyte, 0, this.lineSeparator, 0, paramArrayOfbyte.length);
/*     */       } else {
/* 290 */         this.encodeSize = 4;
/* 291 */         this.lineSeparator = null;
/*     */       } 
/*     */     } else {
/* 294 */       this.encodeSize = 4;
/* 295 */       this.lineSeparator = null;
/*     */     } 
/* 297 */     this.decodeSize = this.encodeSize - 1;
/* 298 */     this.encodeTable = paramBoolean ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUrlSafe() {
/* 308 */     return (this.encodeTable == URL_SAFE_ENCODE_TABLE);
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
/*     */   void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 334 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 339 */     if (paramInt2 < 0) {
/* 340 */       paramContext.eof = true;
/* 341 */       if (0 == paramContext.modulus && this.lineLength == 0) {
/*     */         return;
/*     */       }
/* 344 */       byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 345 */       int i = paramContext.pos;
/* 346 */       switch (paramContext.modulus) {
/*     */         case 0:
/*     */           break;
/*     */         
/*     */         case 1:
/* 351 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 2 & 0x3F];
/*     */           
/* 353 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea << 4 & 0x3F];
/*     */           
/* 355 */           if (this.encodeTable == STANDARD_ENCODE_TABLE) {
/* 356 */             arrayOfByte[paramContext.pos++] = this.pad;
/* 357 */             arrayOfByte[paramContext.pos++] = this.pad;
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 2:
/* 362 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 10 & 0x3F];
/* 363 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 4 & 0x3F];
/* 364 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea << 2 & 0x3F];
/*     */           
/* 366 */           if (this.encodeTable == STANDARD_ENCODE_TABLE) {
/* 367 */             arrayOfByte[paramContext.pos++] = this.pad;
/*     */           }
/*     */           break;
/*     */         default:
/* 371 */           throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
/*     */       } 
/* 373 */       paramContext.currentLinePos += paramContext.pos - i;
/*     */       
/* 375 */       if (this.lineLength > 0 && paramContext.currentLinePos > 0) {
/* 376 */         System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 377 */         paramContext.pos += this.lineSeparator.length;
/*     */       } 
/*     */     } else {
/* 380 */       for (byte b = 0; b < paramInt2; b++) {
/* 381 */         byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 382 */         paramContext.modulus = (paramContext.modulus + 1) % 3;
/* 383 */         byte b1 = paramArrayOfbyte[paramInt1++];
/* 384 */         if (b1 < 0) {
/* 385 */           b1 += 256;
/*     */         }
/* 387 */         paramContext.ibitWorkArea = (paramContext.ibitWorkArea << 8) + b1;
/* 388 */         if (0 == paramContext.modulus) {
/* 389 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 18 & 0x3F];
/* 390 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 12 & 0x3F];
/* 391 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 6 & 0x3F];
/* 392 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea & 0x3F];
/* 393 */           paramContext.currentLinePos += 4;
/* 394 */           if (this.lineLength > 0 && this.lineLength <= paramContext.currentLinePos) {
/* 395 */             System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 396 */             paramContext.pos += this.lineSeparator.length;
/* 397 */             paramContext.currentLinePos = 0;
/*     */           } 
/*     */         } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 431 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/* 434 */     if (paramInt2 < 0) {
/* 435 */       paramContext.eof = true;
/*     */     }
/* 437 */     for (byte b = 0; b < paramInt2; b++) {
/* 438 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/* 439 */       byte b1 = paramArrayOfbyte[paramInt1++];
/* 440 */       if (b1 == this.pad) {
/*     */         
/* 442 */         paramContext.eof = true;
/*     */         break;
/*     */       } 
/* 445 */       if (b1 >= 0 && b1 < DECODE_TABLE.length) {
/* 446 */         byte b2 = DECODE_TABLE[b1];
/* 447 */         if (b2 >= 0) {
/* 448 */           paramContext.modulus = (paramContext.modulus + 1) % 4;
/* 449 */           paramContext.ibitWorkArea = (paramContext.ibitWorkArea << 6) + b2;
/* 450 */           if (paramContext.modulus == 0) {
/* 451 */             arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea >> 16 & 0xFF);
/* 452 */             arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea >> 8 & 0xFF);
/* 453 */             arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea & 0xFF);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 462 */     if (paramContext.eof && paramContext.modulus != 0) {
/* 463 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/*     */ 
/*     */ 
/*     */       
/* 467 */       switch (paramContext.modulus) {
/*     */         case 1:
/*     */           return;
/*     */ 
/*     */         
/*     */         case 2:
/* 473 */           paramContext.ibitWorkArea >>= 4;
/* 474 */           arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea & 0xFF);
/*     */         
/*     */         case 3:
/* 477 */           paramContext.ibitWorkArea >>= 2;
/* 478 */           arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea >> 8 & 0xFF);
/* 479 */           arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea & 0xFF);
/*     */       } 
/*     */       
/* 482 */       throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
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
/*     */   @Deprecated
/*     */   public static boolean isArrayByteBase64(byte[] paramArrayOfbyte) {
/* 499 */     return isBase64(paramArrayOfbyte);
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
/*     */   public static boolean isBase64(byte paramByte) {
/* 511 */     return (paramByte == 61 || (paramByte >= 0 && paramByte < DECODE_TABLE.length && DECODE_TABLE[paramByte] != -1));
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
/*     */   public static boolean isBase64(String paramString) {
/* 525 */     return isBase64(StringUtils.getBytesUtf8(paramString));
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
/*     */   public static boolean isBase64(byte[] paramArrayOfbyte) {
/* 539 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 540 */       if (!isBase64(paramArrayOfbyte[b]) && !isWhiteSpace(paramArrayOfbyte[b])) {
/* 541 */         return false;
/*     */       }
/*     */     } 
/* 544 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte) {
/* 555 */     return encodeBase64(paramArrayOfbyte, false);
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
/*     */   public static String encodeBase64String(byte[] paramArrayOfbyte) {
/* 570 */     return StringUtils.newStringUsAscii(encodeBase64(paramArrayOfbyte, false));
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
/*     */   public static byte[] encodeBase64URLSafe(byte[] paramArrayOfbyte) {
/* 583 */     return encodeBase64(paramArrayOfbyte, false, true);
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
/*     */   public static String encodeBase64URLSafeString(byte[] paramArrayOfbyte) {
/* 596 */     return StringUtils.newStringUsAscii(encodeBase64(paramArrayOfbyte, false, true));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] encodeBase64Chunked(byte[] paramArrayOfbyte) {
/* 607 */     return encodeBase64(paramArrayOfbyte, true);
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
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 622 */     return encodeBase64(paramArrayOfbyte, paramBoolean, false);
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
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2) {
/* 641 */     return encodeBase64(paramArrayOfbyte, paramBoolean1, paramBoolean2, 2147483647);
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
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 663 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 664 */       return paramArrayOfbyte;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 669 */     Base64 base64 = paramBoolean1 ? new Base64(paramBoolean2) : new Base64(0, CHUNK_SEPARATOR, paramBoolean2);
/* 670 */     long l = base64.getEncodedLength(paramArrayOfbyte);
/* 671 */     if (l > paramInt) {
/* 672 */       throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maximum size of " + paramInt);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 678 */     return base64.encode(paramArrayOfbyte);
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
/*     */   public static byte[] decodeBase64(String paramString) {
/* 693 */     return (new Base64()).decode(paramString);
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
/*     */   public static byte[] decodeBase64(byte[] paramArrayOfbyte) {
/* 707 */     return (new Base64()).decode(paramArrayOfbyte);
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
/*     */   public static BigInteger decodeInteger(byte[] paramArrayOfbyte) {
/* 722 */     return new BigInteger(1, decodeBase64(paramArrayOfbyte));
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
/*     */   public static byte[] encodeInteger(BigInteger paramBigInteger) {
/* 736 */     if (paramBigInteger == null) {
/* 737 */       throw new NullPointerException("encodeInteger called with null parameter");
/*     */     }
/* 739 */     return encodeBase64(toIntegerBytes(paramBigInteger), false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static byte[] toIntegerBytes(BigInteger paramBigInteger) {
/* 750 */     int i = paramBigInteger.bitLength();
/*     */     
/* 752 */     i = i + 7 >> 3 << 3;
/* 753 */     byte[] arrayOfByte1 = paramBigInteger.toByteArray();
/*     */     
/* 755 */     if (paramBigInteger.bitLength() % 8 != 0 && paramBigInteger.bitLength() / 8 + 1 == i / 8) {
/* 756 */       return arrayOfByte1;
/*     */     }
/*     */     
/* 759 */     boolean bool = false;
/* 760 */     int j = arrayOfByte1.length;
/*     */ 
/*     */     
/* 763 */     if (paramBigInteger.bitLength() % 8 == 0) {
/* 764 */       bool = true;
/* 765 */       j--;
/*     */     } 
/* 767 */     int k = i / 8 - j;
/* 768 */     byte[] arrayOfByte2 = new byte[i / 8];
/* 769 */     System.arraycopy(arrayOfByte1, bool, arrayOfByte2, k, j);
/* 770 */     return arrayOfByte2;
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
/*     */   protected boolean isInAlphabet(byte paramByte) {
/* 782 */     return (paramByte >= 0 && paramByte < this.decodeTable.length && this.decodeTable[paramByte] != -1);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/Base64.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */