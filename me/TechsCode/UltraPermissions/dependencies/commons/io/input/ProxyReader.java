/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.FilterReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.nio.CharBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ProxyReader
/*     */   extends FilterReader
/*     */ {
/*     */   public ProxyReader(Reader paramReader) {
/*  44 */     super(paramReader);
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
/*  56 */       beforeRead(1);
/*  57 */       int i = this.in.read();
/*  58 */       afterRead((i != -1) ? 1 : -1);
/*  59 */       return i;
/*  60 */     } catch (IOException iOException) {
/*  61 */       handleIOException(iOException);
/*  62 */       return -1;
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
/*     */   public int read(char[] paramArrayOfchar) {
/*     */     try {
/*  75 */       beforeRead((paramArrayOfchar != null) ? paramArrayOfchar.length : 0);
/*  76 */       int i = this.in.read(paramArrayOfchar);
/*  77 */       afterRead(i);
/*  78 */       return i;
/*  79 */     } catch (IOException iOException) {
/*  80 */       handleIOException(iOException);
/*  81 */       return -1;
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*     */     try {
/*  96 */       beforeRead(paramInt2);
/*  97 */       int i = this.in.read(paramArrayOfchar, paramInt1, paramInt2);
/*  98 */       afterRead(i);
/*  99 */       return i;
/* 100 */     } catch (IOException iOException) {
/* 101 */       handleIOException(iOException);
/* 102 */       return -1;
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
/*     */   public int read(CharBuffer paramCharBuffer) {
/*     */     try {
/* 116 */       beforeRead((paramCharBuffer != null) ? paramCharBuffer.length() : 0);
/* 117 */       int i = this.in.read(paramCharBuffer);
/* 118 */       afterRead(i);
/* 119 */       return i;
/* 120 */     } catch (IOException iOException) {
/* 121 */       handleIOException(iOException);
/* 122 */       return -1;
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
/* 135 */       return this.in.skip(paramLong);
/* 136 */     } catch (IOException iOException) {
/* 137 */       handleIOException(iOException);
/* 138 */       return 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ready() {
/*     */     try {
/* 150 */       return this.in.ready();
/* 151 */     } catch (IOException iOException) {
/* 152 */       handleIOException(iOException);
/* 153 */       return false;
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
/* 164 */       this.in.close();
/* 165 */     } catch (IOException iOException) {
/* 166 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/*     */     try {
/* 178 */       this.in.mark(paramInt);
/* 179 */     } catch (IOException iOException) {
/* 180 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/*     */     try {
/* 191 */       this.in.reset();
/* 192 */     } catch (IOException iOException) {
/* 193 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 203 */     return this.in.markSupported();
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
/*     */   protected void handleIOException(IOException paramIOException) {
/* 257 */     throw paramIOException;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/ProxyReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */