/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ProxyInputStream
/*     */   extends FilterInputStream
/*     */ {
/*     */   public ProxyInputStream(InputStream paramInputStream) {
/*  46 */     super(paramInputStream);
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
/*     */     try {
/*  58 */       beforeRead(1);
/*  59 */       int i = this.in.read();
/*  60 */       afterRead((i != -1) ? 1 : -1);
/*  61 */       return i;
/*  62 */     } catch (IOException iOException) {
/*  63 */       handleIOException(iOException);
/*  64 */       return -1;
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
/*     */   public int read(byte[] paramArrayOfbyte) {
/*     */     try {
/*  77 */       beforeRead((paramArrayOfbyte != null) ? paramArrayOfbyte.length : 0);
/*  78 */       int i = this.in.read(paramArrayOfbyte);
/*  79 */       afterRead(i);
/*  80 */       return i;
/*  81 */     } catch (IOException iOException) {
/*  82 */       handleIOException(iOException);
/*  83 */       return -1;
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/*  98 */       beforeRead(paramInt2);
/*  99 */       int i = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 100 */       afterRead(i);
/* 101 */       return i;
/* 102 */     } catch (IOException iOException) {
/* 103 */       handleIOException(iOException);
/* 104 */       return -1;
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
/*     */   public long skip(long paramLong) {
/*     */     try {
/* 117 */       return this.in.skip(paramLong);
/* 118 */     } catch (IOException iOException) {
/* 119 */       handleIOException(iOException);
/* 120 */       return 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/*     */     try {
/* 132 */       return super.available();
/* 133 */     } catch (IOException iOException) {
/* 134 */       handleIOException(iOException);
/* 135 */       return 0;
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
/* 146 */       this.in.close();
/* 147 */     } catch (IOException iOException) {
/* 148 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 158 */     this.in.mark(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/*     */     try {
/* 168 */       this.in.reset();
/* 169 */     } catch (IOException iOException) {
/* 170 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 180 */     return this.in.markSupported();
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
/*     */   protected void beforeRead(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void afterRead(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 236 */     throw paramIOException;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/ProxyInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */