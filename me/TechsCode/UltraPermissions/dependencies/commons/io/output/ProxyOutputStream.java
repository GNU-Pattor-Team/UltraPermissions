/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
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
/*     */ public class ProxyOutputStream
/*     */   extends FilterOutputStream
/*     */ {
/*     */   public ProxyOutputStream(OutputStream paramOutputStream) {
/*  41 */     super(paramOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) {
/*     */     try {
/*  53 */       beforeWrite(1);
/*  54 */       this.out.write(paramInt);
/*  55 */       afterWrite(1);
/*  56 */     } catch (IOException iOException) {
/*  57 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) {
/*     */     try {
/*  69 */       boolean bool = (paramArrayOfbyte != null) ? paramArrayOfbyte.length : false;
/*  70 */       beforeWrite(bool);
/*  71 */       this.out.write(paramArrayOfbyte);
/*  72 */       afterWrite(bool);
/*  73 */     } catch (IOException iOException) {
/*  74 */       handleIOException(iOException);
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
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/*  88 */       beforeWrite(paramInt2);
/*  89 */       this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/*  90 */       afterWrite(paramInt2);
/*  91 */     } catch (IOException iOException) {
/*  92 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/*     */     try {
/* 103 */       this.out.flush();
/* 104 */     } catch (IOException iOException) {
/* 105 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/* 116 */       this.out.close();
/* 117 */     } catch (IOException iOException) {
/* 118 */       handleIOException(iOException);
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
/*     */   protected void beforeWrite(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void afterWrite(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleIOException(IOException paramIOException) {
/* 165 */     throw paramIOException;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/ProxyOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */