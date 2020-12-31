/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.digest;
/*     */ 
/*     */ import java.util.zip.Checksum;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XXHash32
/*     */   implements Checksum
/*     */ {
/*     */   private static final int BUF_SIZE = 16;
/*     */   private static final int ROTATE_BITS = 13;
/*     */   private static final int PRIME1 = -1640531535;
/*     */   private static final int PRIME2 = -2048144777;
/*     */   private static final int PRIME3 = -1028477379;
/*     */   private static final int PRIME4 = 668265263;
/*     */   private static final int PRIME5 = 374761393;
/*  44 */   private final byte[] oneByte = new byte[1];
/*  45 */   private final int[] state = new int[4];
/*     */ 
/*     */   
/*  48 */   private final byte[] buffer = new byte[16];
/*     */   
/*     */   private final int seed;
/*     */   
/*     */   private int totalLen;
/*     */   
/*     */   private int pos;
/*     */ 
/*     */   
/*     */   public XXHash32() {
/*  58 */     this(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XXHash32(int paramInt) {
/*  66 */     this.seed = paramInt;
/*  67 */     initializeState();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/*  72 */     initializeState();
/*  73 */     this.totalLen = 0;
/*  74 */     this.pos = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(int paramInt) {
/*  79 */     this.oneByte[0] = (byte)(paramInt & 0xFF);
/*  80 */     update(this.oneByte, 0, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  85 */     if (paramInt2 <= 0) {
/*     */       return;
/*     */     }
/*  88 */     this.totalLen += paramInt2;
/*     */     
/*  90 */     int i = paramInt1 + paramInt2;
/*     */     
/*  92 */     if (this.pos + paramInt2 < 16) {
/*  93 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.pos, paramInt2);
/*  94 */       this.pos += paramInt2;
/*     */       
/*     */       return;
/*     */     } 
/*  98 */     if (this.pos > 0) {
/*  99 */       int k = 16 - this.pos;
/* 100 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, this.pos, k);
/* 101 */       process(this.buffer, 0);
/* 102 */       paramInt1 += k;
/*     */     } 
/*     */     
/* 105 */     int j = i - 16;
/* 106 */     while (paramInt1 <= j) {
/* 107 */       process(paramArrayOfbyte, paramInt1);
/* 108 */       paramInt1 += 16;
/*     */     } 
/*     */     
/* 111 */     if (paramInt1 < i) {
/* 112 */       this.pos = i - paramInt1;
/* 113 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.buffer, 0, this.pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long getValue() {
/*     */     int i;
/* 120 */     if (this.totalLen > 16) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 125 */       i = Integer.rotateLeft(this.state[0], 1) + Integer.rotateLeft(this.state[1], 7) + Integer.rotateLeft(this.state[2], 12) + Integer.rotateLeft(this.state[3], 18);
/*     */     } else {
/* 127 */       i = this.state[2] + 374761393;
/*     */     } 
/* 129 */     i += this.totalLen;
/*     */     
/* 131 */     byte b = 0;
/* 132 */     int j = this.pos - 4;
/* 133 */     for (; b <= j; b += 4) {
/* 134 */       i = Integer.rotateLeft(i + getInt(this.buffer, b) * -1028477379, 17) * 668265263;
/*     */     }
/* 136 */     while (b < this.pos) {
/* 137 */       i = Integer.rotateLeft(i + (this.buffer[b++] & 0xFF) * 374761393, 11) * -1640531535;
/*     */     }
/*     */     
/* 140 */     i ^= i >>> 15;
/* 141 */     i *= -2048144777;
/* 142 */     i ^= i >>> 13;
/* 143 */     i *= -1028477379;
/* 144 */     i ^= i >>> 16;
/* 145 */     return i & 0xFFFFFFFFL;
/*     */   }
/*     */   
/*     */   private static int getInt(byte[] paramArrayOfbyte, int paramInt) {
/* 149 */     return (int)(fromLittleEndian(paramArrayOfbyte, paramInt, 4) & 0xFFFFFFFFL);
/*     */   }
/*     */   
/*     */   private void initializeState() {
/* 153 */     this.state[0] = this.seed + -1640531535 + -2048144777;
/* 154 */     this.state[1] = this.seed + -2048144777;
/* 155 */     this.state[2] = this.seed;
/* 156 */     this.state[3] = this.seed - -1640531535;
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(byte[] paramArrayOfbyte, int paramInt) {
/* 161 */     int i = this.state[0];
/* 162 */     int j = this.state[1];
/* 163 */     int k = this.state[2];
/* 164 */     int m = this.state[3];
/*     */     
/* 166 */     i = Integer.rotateLeft(i + getInt(paramArrayOfbyte, paramInt) * -2048144777, 13) * -1640531535;
/* 167 */     j = Integer.rotateLeft(j + getInt(paramArrayOfbyte, paramInt + 4) * -2048144777, 13) * -1640531535;
/* 168 */     k = Integer.rotateLeft(k + getInt(paramArrayOfbyte, paramInt + 8) * -2048144777, 13) * -1640531535;
/* 169 */     m = Integer.rotateLeft(m + getInt(paramArrayOfbyte, paramInt + 12) * -2048144777, 13) * -1640531535;
/*     */     
/* 171 */     this.state[0] = i;
/* 172 */     this.state[1] = j;
/* 173 */     this.state[2] = k;
/* 174 */     this.state[3] = m;
/*     */     
/* 176 */     this.pos = 0;
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
/*     */   private static long fromLittleEndian(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 188 */     if (paramInt2 > 8) {
/* 189 */       throw new IllegalArgumentException("can't read more than eight bytes into a long value");
/*     */     }
/* 191 */     long l = 0L;
/* 192 */     for (byte b = 0; b < paramInt2; b++) {
/* 193 */       l |= (paramArrayOfbyte[paramInt1 + b] & 0xFFL) << 8 * b;
/*     */     }
/* 195 */     return l;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/digest/XXHash32.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */