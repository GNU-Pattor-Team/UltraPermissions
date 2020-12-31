/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaseNCodecOutputStream
/*     */   extends FilterOutputStream
/*     */ {
/*     */   private final boolean doEncode;
/*     */   private final BaseNCodec baseNCodec;
/*  46 */   private final byte[] singleByte = new byte[1];
/*     */   
/*  48 */   private final BaseNCodec.Context context = new BaseNCodec.Context();
/*     */ 
/*     */   
/*     */   public BaseNCodecOutputStream(OutputStream paramOutputStream, BaseNCodec paramBaseNCodec, boolean paramBoolean) {
/*  52 */     super(paramOutputStream);
/*  53 */     this.baseNCodec = paramBaseNCodec;
/*  54 */     this.doEncode = paramBoolean;
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
/*     */   public void write(int paramInt) {
/*  67 */     this.singleByte[0] = (byte)paramInt;
/*  68 */     write(this.singleByte, 0, 1);
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
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  91 */     if (paramArrayOfbyte == null)
/*  92 */       throw new NullPointerException(); 
/*  93 */     if (paramInt1 < 0 || paramInt2 < 0)
/*  94 */       throw new IndexOutOfBoundsException(); 
/*  95 */     if (paramInt1 > paramArrayOfbyte.length || paramInt1 + paramInt2 > paramArrayOfbyte.length)
/*  96 */       throw new IndexOutOfBoundsException(); 
/*  97 */     if (paramInt2 > 0) {
/*  98 */       if (this.doEncode) {
/*  99 */         this.baseNCodec.encode(paramArrayOfbyte, paramInt1, paramInt2, this.context);
/*     */       } else {
/* 101 */         this.baseNCodec.decode(paramArrayOfbyte, paramInt1, paramInt2, this.context);
/*     */       } 
/* 103 */       flush(false);
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
/*     */   private void flush(boolean paramBoolean) {
/* 117 */     int i = this.baseNCodec.available(this.context);
/* 118 */     if (i > 0) {
/* 119 */       byte[] arrayOfByte = new byte[i];
/* 120 */       int j = this.baseNCodec.readResults(arrayOfByte, 0, i, this.context);
/* 121 */       if (j > 0) {
/* 122 */         this.out.write(arrayOfByte, 0, j);
/*     */       }
/*     */     } 
/* 125 */     if (paramBoolean) {
/* 126 */       this.out.flush();
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
/*     */   public void flush() {
/* 138 */     flush(true);
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
/*     */   public void close() {
/* 155 */     eof();
/* 156 */     flush();
/* 157 */     this.out.close();
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
/*     */   public void eof() {
/* 169 */     if (this.doEncode) {
/* 170 */       this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
/*     */     } else {
/* 172 */       this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/BaseNCodecOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */