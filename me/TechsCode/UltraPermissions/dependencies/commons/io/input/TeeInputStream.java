/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeeInputStream
/*     */   extends ProxyInputStream
/*     */ {
/*     */   private final OutputStream branch;
/*     */   private final boolean closeBranch;
/*     */   
/*     */   public TeeInputStream(InputStream paramInputStream, OutputStream paramOutputStream) {
/*  62 */     this(paramInputStream, paramOutputStream, false);
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
/*     */   public TeeInputStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean) {
/*  78 */     super(paramInputStream);
/*  79 */     this.branch = paramOutputStream;
/*  80 */     this.closeBranch = paramBoolean;
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
/*     */   public void close() {
/*     */     try {
/*  93 */       super.close();
/*     */     } finally {
/*  95 */       if (this.closeBranch) {
/*  96 */         this.branch.close();
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
/*     */   public int read() {
/* 110 */     int i = super.read();
/* 111 */     if (i != -1) {
/* 112 */       this.branch.write(i);
/*     */     }
/* 114 */     return i;
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 129 */     int i = super.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 130 */     if (i != -1) {
/* 131 */       this.branch.write(paramArrayOfbyte, paramInt1, i);
/*     */     }
/* 133 */     return i;
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
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 146 */     int i = super.read(paramArrayOfbyte);
/* 147 */     if (i != -1) {
/* 148 */       this.branch.write(paramArrayOfbyte, 0, i);
/*     */     }
/* 150 */     return i;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/TeeInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */