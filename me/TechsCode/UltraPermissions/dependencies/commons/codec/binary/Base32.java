/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Base32
/*     */   extends BaseNCodec
/*     */ {
/*     */   private static final int BITS_PER_ENCODED_BYTE = 5;
/*     */   private static final int BYTES_PER_ENCODED_BLOCK = 8;
/*     */   private static final int BYTES_PER_UNENCODED_BLOCK = 5;
/*  60 */   private static final byte[] CHUNK_SEPARATOR = new byte[] { 13, 10 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   private static final byte[] DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   private static final byte[] ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   private static final byte[] HEX_DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   private static final byte[] HEX_ENCODE_TABLE = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MASK_5BITS = 31;
/*     */ 
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
/*     */   private final byte[] decodeTable;
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
/*     */   private final byte[] encodeTable;
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
/*     */   
/*     */   public Base32() {
/* 165 */     this(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base32(byte paramByte) {
/* 176 */     this(false, paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base32(boolean paramBoolean) {
/* 187 */     this(0, (byte[])null, paramBoolean, (byte)61);
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
/*     */   public Base32(boolean paramBoolean, byte paramByte) {
/* 199 */     this(0, (byte[])null, paramBoolean, paramByte);
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
/*     */   public Base32(int paramInt) {
/* 214 */     this(paramInt, CHUNK_SEPARATOR);
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
/*     */   public Base32(int paramInt, byte[] paramArrayOfbyte) {
/* 236 */     this(paramInt, paramArrayOfbyte, false, (byte)61);
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
/*     */   public Base32(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 261 */     this(paramInt, paramArrayOfbyte, paramBoolean, (byte)61);
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
/*     */   public Base32(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean, byte paramByte) {
/* 287 */     super(5, 8, paramInt, (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length, paramByte);
/*     */     
/* 289 */     if (paramBoolean) {
/* 290 */       this.encodeTable = HEX_ENCODE_TABLE;
/* 291 */       this.decodeTable = HEX_DECODE_TABLE;
/*     */     } else {
/* 293 */       this.encodeTable = ENCODE_TABLE;
/* 294 */       this.decodeTable = DECODE_TABLE;
/*     */     } 
/* 296 */     if (paramInt > 0) {
/* 297 */       if (paramArrayOfbyte == null) {
/* 298 */         throw new IllegalArgumentException("lineLength " + paramInt + " > 0, but lineSeparator is null");
/*     */       }
/*     */       
/* 301 */       if (containsAlphabetOrPad(paramArrayOfbyte)) {
/* 302 */         String str = StringUtils.newStringUtf8(paramArrayOfbyte);
/* 303 */         throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + str + "]");
/*     */       } 
/* 305 */       this.encodeSize = 8 + paramArrayOfbyte.length;
/* 306 */       this.lineSeparator = new byte[paramArrayOfbyte.length];
/* 307 */       System.arraycopy(paramArrayOfbyte, 0, this.lineSeparator, 0, paramArrayOfbyte.length);
/*     */     } else {
/* 309 */       this.encodeSize = 8;
/* 310 */       this.lineSeparator = null;
/*     */     } 
/* 312 */     this.decodeSize = this.encodeSize - 1;
/*     */     
/* 314 */     if (isInAlphabet(paramByte) || isWhiteSpace(paramByte)) {
/* 315 */       throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
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
/*     */   void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 345 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/* 348 */     if (paramInt2 < 0) {
/* 349 */       paramContext.eof = true;
/*     */     }
/* 351 */     for (byte b = 0; b < paramInt2; b++) {
/* 352 */       byte b1 = paramArrayOfbyte[paramInt1++];
/* 353 */       if (b1 == this.pad) {
/*     */         
/* 355 */         paramContext.eof = true;
/*     */         break;
/*     */       } 
/* 358 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/* 359 */       if (b1 >= 0 && b1 < this.decodeTable.length) {
/* 360 */         byte b2 = this.decodeTable[b1];
/* 361 */         if (b2 >= 0) {
/* 362 */           paramContext.modulus = (paramContext.modulus + 1) % 8;
/*     */           
/* 364 */           paramContext.lbitWorkArea = (paramContext.lbitWorkArea << 5L) + b2;
/* 365 */           if (paramContext.modulus == 0) {
/* 366 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 32L & 0xFFL);
/* 367 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 24L & 0xFFL);
/* 368 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 369 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 370 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 379 */     if (paramContext.eof && paramContext.modulus >= 2) {
/* 380 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/*     */ 
/*     */       
/* 383 */       switch (paramContext.modulus) {
/*     */         case 2:
/* 385 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 2L & 0xFFL);
/*     */           return;
/*     */         case 3:
/* 388 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 7L & 0xFFL);
/*     */           return;
/*     */         case 4:
/* 391 */           paramContext.lbitWorkArea >>= 4L;
/* 392 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 393 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */         case 5:
/* 396 */           paramContext.lbitWorkArea >>= 1L;
/* 397 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 398 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 399 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */         case 6:
/* 402 */           paramContext.lbitWorkArea >>= 6L;
/* 403 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 404 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 405 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */         case 7:
/* 408 */           paramContext.lbitWorkArea >>= 3L;
/* 409 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 24L & 0xFFL);
/* 410 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 411 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 412 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */       } 
/*     */       
/* 416 */       throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
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
/*     */   void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 440 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 445 */     if (paramInt2 < 0) {
/* 446 */       paramContext.eof = true;
/* 447 */       if (0 == paramContext.modulus && this.lineLength == 0) {
/*     */         return;
/*     */       }
/* 450 */       byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 451 */       int i = paramContext.pos;
/* 452 */       switch (paramContext.modulus) {
/*     */         case 0:
/*     */           break;
/*     */         case 1:
/* 456 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 3L) & 0x1F];
/* 457 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 2L) & 0x1F];
/* 458 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 459 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 460 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 461 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 462 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 463 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         case 2:
/* 466 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 11L) & 0x1F];
/* 467 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 6L) & 0x1F];
/* 468 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 1L) & 0x1F];
/* 469 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 4L) & 0x1F];
/* 470 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 471 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 472 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 473 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         case 3:
/* 476 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 19L) & 0x1F];
/* 477 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 14L) & 0x1F];
/* 478 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 9L) & 0x1F];
/* 479 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 4L) & 0x1F];
/* 480 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 1L) & 0x1F];
/* 481 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 482 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 483 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         case 4:
/* 486 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 27L) & 0x1F];
/* 487 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 22L) & 0x1F];
/* 488 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 17L) & 0x1F];
/* 489 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 12L) & 0x1F];
/* 490 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 7L) & 0x1F];
/* 491 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 2L) & 0x1F];
/* 492 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 3L) & 0x1F];
/* 493 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         default:
/* 496 */           throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
/*     */       } 
/* 498 */       paramContext.currentLinePos += paramContext.pos - i;
/*     */       
/* 500 */       if (this.lineLength > 0 && paramContext.currentLinePos > 0) {
/* 501 */         System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 502 */         paramContext.pos += this.lineSeparator.length;
/*     */       } 
/*     */     } else {
/* 505 */       for (byte b = 0; b < paramInt2; b++) {
/* 506 */         byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 507 */         paramContext.modulus = (paramContext.modulus + 1) % 5;
/* 508 */         byte b1 = paramArrayOfbyte[paramInt1++];
/* 509 */         if (b1 < 0) {
/* 510 */           b1 += 256;
/*     */         }
/* 512 */         paramContext.lbitWorkArea = (paramContext.lbitWorkArea << 8L) + b1;
/* 513 */         if (0 == paramContext.modulus) {
/* 514 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 35L) & 0x1F];
/* 515 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 30L) & 0x1F];
/* 516 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 25L) & 0x1F];
/* 517 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 20L) & 0x1F];
/* 518 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 15L) & 0x1F];
/* 519 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 10L) & 0x1F];
/* 520 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 5L) & 0x1F];
/* 521 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)paramContext.lbitWorkArea & 0x1F];
/* 522 */           paramContext.currentLinePos += 8;
/* 523 */           if (this.lineLength > 0 && this.lineLength <= paramContext.currentLinePos) {
/* 524 */             System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 525 */             paramContext.pos += this.lineSeparator.length;
/* 526 */             paramContext.currentLinePos = 0;
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
/*     */   public boolean isInAlphabet(byte paramByte) {
/* 542 */     return (paramByte >= 0 && paramByte < this.decodeTable.length && this.decodeTable[paramByte] != -1);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/Base32.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */