/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LineIterator
/*     */   implements Iterator<String>, Closeable
/*     */ {
/*     */   private final BufferedReader bufferedReader;
/*     */   private String cachedLine;
/*     */   private boolean finished = false;
/*     */   
/*     */   public LineIterator(Reader paramReader) {
/*  68 */     if (paramReader == null) {
/*  69 */       throw new IllegalArgumentException("Reader must not be null");
/*     */     }
/*  71 */     if (paramReader instanceof BufferedReader) {
/*  72 */       this.bufferedReader = (BufferedReader)paramReader;
/*     */     } else {
/*  74 */       this.bufferedReader = new BufferedReader(paramReader);
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
/*     */   public boolean hasNext() {
/*  89 */     if (this.cachedLine != null)
/*  90 */       return true; 
/*  91 */     if (this.finished) {
/*  92 */       return false;
/*     */     }
/*     */     try {
/*     */       while (true) {
/*  96 */         String str = this.bufferedReader.readLine();
/*  97 */         if (str == null) {
/*  98 */           this.finished = true;
/*  99 */           return false;
/* 100 */         }  if (isValidLine(str)) {
/* 101 */           this.cachedLine = str;
/* 102 */           return true;
/*     */         } 
/*     */       } 
/* 105 */     } catch (IOException iOException) {
/*     */       try {
/* 107 */         close();
/* 108 */       } catch (IOException iOException1) {
/* 109 */         iOException.addSuppressed(iOException1);
/*     */       } 
/* 111 */       throw new IllegalStateException(iOException);
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
/*     */   protected boolean isValidLine(String paramString) {
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String next() {
/* 134 */     return nextLine();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String nextLine() {
/* 144 */     if (!hasNext()) {
/* 145 */       throw new NoSuchElementException("No more lines");
/*     */     }
/* 147 */     String str = this.cachedLine;
/* 148 */     this.cachedLine = null;
/* 149 */     return str;
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
/*     */   public void close() {
/* 163 */     this.finished = true;
/* 164 */     this.cachedLine = null;
/* 165 */     if (this.bufferedReader != null) {
/* 166 */       this.bufferedReader.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 177 */     throw new UnsupportedOperationException("Remove unsupported on LineIterator");
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
/*     */   @Deprecated
/*     */   public static void closeQuietly(LineIterator paramLineIterator) {
/*     */     try {
/* 192 */       if (paramLineIterator != null) {
/* 193 */         paramLineIterator.close();
/*     */       }
/* 195 */     } catch (IOException iOException) {}
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/LineIterator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */