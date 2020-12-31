/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObservableInputStream
/*     */   extends ProxyInputStream
/*     */ {
/*     */   public static abstract class Observer
/*     */   {
/*     */     void data(int param1Int) {}
/*     */     
/*     */     void data(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {}
/*     */     
/*     */     void finished() {}
/*     */     
/*     */     void closed() {}
/*     */     
/*     */     void error(IOException param1IOException) {
/*  77 */       throw param1IOException;
/*     */     } }
/*     */   
/*  80 */   private final List<Observer> observers = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObservableInputStream(InputStream paramInputStream) {
/*  87 */     super(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Observer paramObserver) {
/*  95 */     this.observers.add(paramObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Observer paramObserver) {
/* 103 */     this.observers.remove(paramObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAllObservers() {
/* 110 */     this.observers.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() {
/* 115 */     int i = 0;
/* 116 */     IOException iOException = null;
/*     */     try {
/* 118 */       i = super.read();
/* 119 */     } catch (IOException iOException1) {
/* 120 */       iOException = iOException1;
/*     */     } 
/* 122 */     if (iOException != null) {
/* 123 */       noteError(iOException);
/* 124 */     } else if (i == -1) {
/* 125 */       noteFinished();
/*     */     } else {
/* 127 */       noteDataByte(i);
/*     */     } 
/* 129 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 134 */     int i = 0;
/* 135 */     IOException iOException = null;
/*     */     try {
/* 137 */       i = super.read(paramArrayOfbyte);
/* 138 */     } catch (IOException iOException1) {
/* 139 */       iOException = iOException1;
/*     */     } 
/* 141 */     if (iOException != null) {
/* 142 */       noteError(iOException);
/* 143 */     } else if (i == -1) {
/* 144 */       noteFinished();
/* 145 */     } else if (i > 0) {
/* 146 */       noteDataBytes(paramArrayOfbyte, 0, i);
/*     */     } 
/* 148 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 153 */     int i = 0;
/* 154 */     IOException iOException = null;
/*     */     try {
/* 156 */       i = super.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 157 */     } catch (IOException iOException1) {
/* 158 */       iOException = iOException1;
/*     */     } 
/* 160 */     if (iOException != null) {
/* 161 */       noteError(iOException);
/* 162 */     } else if (i == -1) {
/* 163 */       noteFinished();
/* 164 */     } else if (i > 0) {
/* 165 */       noteDataBytes(paramArrayOfbyte, paramInt1, i);
/*     */     } 
/* 167 */     return i;
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
/*     */   protected void noteDataBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 179 */     for (Observer observer : getObservers()) {
/* 180 */       observer.data(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void noteFinished() {
/* 189 */     for (Observer observer : getObservers()) {
/* 190 */       observer.finished();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void noteDataByte(int paramInt) {
/* 201 */     for (Observer observer : getObservers()) {
/* 202 */       observer.data(paramInt);
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
/*     */   protected void noteError(IOException paramIOException) {
/* 214 */     for (Observer observer : getObservers()) {
/* 215 */       observer.error(paramIOException);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void noteClosed() {
/* 224 */     for (Observer observer : getObservers()) {
/* 225 */       observer.closed();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Observer> getObservers() {
/* 233 */     return this.observers;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 238 */     IOException iOException = null;
/*     */     try {
/* 240 */       super.close();
/* 241 */     } catch (IOException iOException1) {
/* 242 */       iOException = iOException1;
/*     */     } 
/* 244 */     if (iOException == null) {
/* 245 */       noteClosed();
/*     */     } else {
/* 247 */       noteError(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void consume() {
/*     */     int i;
/* 257 */     byte[] arrayOfByte = new byte[8192];
/*     */     do {
/* 259 */       i = read(arrayOfByte);
/* 260 */     } while (i != -1);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/ObservableInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */