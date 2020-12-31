/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharSequenceReader
/*     */   extends Reader
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3724187752191401220L;
/*     */   private final CharSequence charSequence;
/*     */   private int idx;
/*     */   private int mark;
/*     */   
/*     */   public CharSequenceReader(CharSequence paramCharSequence) {
/*  45 */     this.charSequence = (paramCharSequence != null) ? paramCharSequence : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  53 */     this.idx = 0;
/*  54 */     this.mark = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/*  64 */     this.mark = this.idx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/*  74 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() {
/*  85 */     if (this.idx >= this.charSequence.length()) {
/*  86 */       return -1;
/*     */     }
/*  88 */     return this.charSequence.charAt(this.idx++);
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 103 */     if (this.idx >= this.charSequence.length()) {
/* 104 */       return -1;
/*     */     }
/* 106 */     if (paramArrayOfchar == null) {
/* 107 */       throw new NullPointerException("Character array is missing");
/*     */     }
/* 109 */     if (paramInt2 < 0 || paramInt1 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/* 110 */       throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfchar.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
/*     */     }
/*     */     
/* 113 */     byte b1 = 0;
/* 114 */     for (byte b2 = 0; b2 < paramInt2; b2++) {
/* 115 */       int i = read();
/* 116 */       if (i == -1) {
/* 117 */         return b1;
/*     */       }
/* 119 */       paramArrayOfchar[paramInt1 + b2] = (char)i;
/* 120 */       b1++;
/*     */     } 
/* 122 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 131 */     this.idx = this.mark;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) {
/* 142 */     if (paramLong < 0L) {
/* 143 */       throw new IllegalArgumentException("Number of characters to skip is less than zero: " + paramLong);
/*     */     }
/*     */     
/* 146 */     if (this.idx >= this.charSequence.length()) {
/* 147 */       return -1L;
/*     */     }
/* 149 */     int i = (int)Math.min(this.charSequence.length(), this.idx + paramLong);
/* 150 */     int j = i - this.idx;
/* 151 */     this.idx = i;
/* 152 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     return this.charSequence.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/CharSequenceReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */