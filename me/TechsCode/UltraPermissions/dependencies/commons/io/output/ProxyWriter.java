/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.FilterWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProxyWriter
/*     */   extends FilterWriter
/*     */ {
/*     */   public ProxyWriter(Writer paramWriter) {
/*  40 */     super(paramWriter);
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
/*     */   public Writer append(char paramChar) {
/*     */     try {
/*  54 */       beforeWrite(1);
/*  55 */       this.out.append(paramChar);
/*  56 */       afterWrite(1);
/*  57 */     } catch (IOException iOException) {
/*  58 */       handleIOException(iOException);
/*     */     } 
/*  60 */     return this;
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
/*     */   public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*     */     try {
/*  75 */       beforeWrite(paramInt2 - paramInt1);
/*  76 */       this.out.append(paramCharSequence, paramInt1, paramInt2);
/*  77 */       afterWrite(paramInt2 - paramInt1);
/*  78 */     } catch (IOException iOException) {
/*  79 */       handleIOException(iOException);
/*     */     } 
/*  81 */     return this;
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
/*     */   public Writer append(CharSequence paramCharSequence) {
/*     */     try {
/*  94 */       int i = 0;
/*  95 */       if (paramCharSequence != null) {
/*  96 */         i = paramCharSequence.length();
/*     */       }
/*     */       
/*  99 */       beforeWrite(i);
/* 100 */       this.out.append(paramCharSequence);
/* 101 */       afterWrite(i);
/* 102 */     } catch (IOException iOException) {
/* 103 */       handleIOException(iOException);
/*     */     } 
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) {
/*     */     try {
/* 116 */       beforeWrite(1);
/* 117 */       this.out.write(paramInt);
/* 118 */       afterWrite(1);
/* 119 */     } catch (IOException iOException) {
/* 120 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar) {
/*     */     try {
/* 132 */       int i = 0;
/* 133 */       if (paramArrayOfchar != null) {
/* 134 */         i = paramArrayOfchar.length;
/*     */       }
/*     */       
/* 137 */       beforeWrite(i);
/* 138 */       this.out.write(paramArrayOfchar);
/* 139 */       afterWrite(i);
/* 140 */     } catch (IOException iOException) {
/* 141 */       handleIOException(iOException);
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
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*     */     try {
/* 155 */       beforeWrite(paramInt2);
/* 156 */       this.out.write(paramArrayOfchar, paramInt1, paramInt2);
/* 157 */       afterWrite(paramInt2);
/* 158 */     } catch (IOException iOException) {
/* 159 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String paramString) {
/*     */     try {
/* 171 */       int i = 0;
/* 172 */       if (paramString != null) {
/* 173 */         i = paramString.length();
/*     */       }
/*     */       
/* 176 */       beforeWrite(i);
/* 177 */       this.out.write(paramString);
/* 178 */       afterWrite(i);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String paramString, int paramInt1, int paramInt2) {
/*     */     try {
/* 194 */       beforeWrite(paramInt2);
/* 195 */       this.out.write(paramString, paramInt1, paramInt2);
/* 196 */       afterWrite(paramInt2);
/* 197 */     } catch (IOException iOException) {
/* 198 */       handleIOException(iOException);
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
/* 209 */       this.out.flush();
/* 210 */     } catch (IOException iOException) {
/* 211 */       handleIOException(iOException);
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
/* 222 */       this.out.close();
/* 223 */     } catch (IOException iOException) {
/* 224 */       handleIOException(iOException);
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
/* 271 */     throw paramIOException;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/ProxyWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */