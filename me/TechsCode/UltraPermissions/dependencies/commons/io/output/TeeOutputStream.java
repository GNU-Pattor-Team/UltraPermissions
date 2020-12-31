/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
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
/*     */ public class TeeOutputStream
/*     */   extends ProxyOutputStream
/*     */ {
/*     */   protected OutputStream branch;
/*     */   
/*     */   public TeeOutputStream(OutputStream paramOutputStream1, OutputStream paramOutputStream2) {
/*  39 */     super(paramOutputStream1);
/*  40 */     this.branch = paramOutputStream2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void write(byte[] paramArrayOfbyte) {
/*  50 */     super.write(paramArrayOfbyte);
/*  51 */     this.branch.write(paramArrayOfbyte);
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
/*     */   public synchronized void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  63 */     super.write(paramArrayOfbyte, paramInt1, paramInt2);
/*  64 */     this.branch.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void write(int paramInt) {
/*  74 */     super.write(paramInt);
/*  75 */     this.branch.write(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/*  84 */     super.flush();
/*  85 */     this.branch.flush();
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
/*     */   public void close() {
/*     */     try {
/* 102 */       super.close();
/*     */     } finally {
/* 104 */       this.branch.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/TeeOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */