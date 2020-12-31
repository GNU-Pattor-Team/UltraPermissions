/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BoundedReader
/*     */   extends Reader
/*     */ {
/*     */   private static final int INVALID = -1;
/*     */   private final Reader target;
/*  45 */   private int charsRead = 0;
/*     */   
/*  47 */   private int markedAt = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   private int readAheadLimit;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int maxCharsFromTargetReader;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundedReader(Reader paramReader, int paramInt) {
/*  61 */     this.target = paramReader;
/*  62 */     this.maxCharsFromTargetReader = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  72 */     this.target.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/*  83 */     this.charsRead = this.markedAt;
/*  84 */     this.target.reset();
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
/*     */   public void mark(int paramInt) {
/* 102 */     this.readAheadLimit = paramInt - this.charsRead;
/*     */     
/* 104 */     this.markedAt = this.charsRead;
/*     */     
/* 106 */     this.target.mark(paramInt);
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
/*     */   public int read() {
/* 119 */     if (this.charsRead >= this.maxCharsFromTargetReader) {
/* 120 */       return -1;
/*     */     }
/*     */     
/* 123 */     if (this.markedAt >= 0 && this.charsRead - this.markedAt >= this.readAheadLimit) {
/* 124 */       return -1;
/*     */     }
/* 126 */     this.charsRead++;
/* 127 */     return this.target.read();
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 143 */     for (byte b = 0; b < paramInt2; b++) {
/* 144 */       int i = read();
/* 145 */       if (i == -1) {
/* 146 */         return (b == 0) ? -1 : b;
/*     */       }
/* 148 */       paramArrayOfchar[paramInt1 + b] = (char)i;
/*     */     } 
/* 150 */     return paramInt2;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/BoundedReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */