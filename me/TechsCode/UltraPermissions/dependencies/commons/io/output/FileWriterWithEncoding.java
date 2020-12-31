/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileWriterWithEncoding
/*     */   extends Writer
/*     */ {
/*     */   private final Writer out;
/*     */   
/*     */   public FileWriterWithEncoding(String paramString1, String paramString2) {
/*  65 */     this(new File(paramString1), paramString2, false);
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
/*     */   public FileWriterWithEncoding(String paramString1, String paramString2, boolean paramBoolean) {
/*  79 */     this(new File(paramString1), paramString2, paramBoolean);
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
/*     */   public FileWriterWithEncoding(String paramString, Charset paramCharset) {
/*  91 */     this(new File(paramString), paramCharset, false);
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
/*     */   public FileWriterWithEncoding(String paramString, Charset paramCharset, boolean paramBoolean) {
/* 105 */     this(new File(paramString), paramCharset, paramBoolean);
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
/*     */   public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder) {
/* 117 */     this(new File(paramString), paramCharsetEncoder, false);
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
/*     */   public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder, boolean paramBoolean) {
/* 131 */     this(new File(paramString), paramCharsetEncoder, paramBoolean);
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
/*     */   public FileWriterWithEncoding(File paramFile, String paramString) {
/* 143 */     this(paramFile, paramString, false);
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
/*     */   public FileWriterWithEncoding(File paramFile, String paramString, boolean paramBoolean) {
/* 157 */     this.out = initWriter(paramFile, paramString, paramBoolean);
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
/*     */   public FileWriterWithEncoding(File paramFile, Charset paramCharset) {
/* 169 */     this(paramFile, paramCharset, false);
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
/*     */   public FileWriterWithEncoding(File paramFile, Charset paramCharset, boolean paramBoolean) {
/* 183 */     this.out = initWriter(paramFile, paramCharset, paramBoolean);
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
/*     */   public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder) {
/* 195 */     this(paramFile, paramCharsetEncoder, false);
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
/*     */   public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder, boolean paramBoolean) {
/* 210 */     this.out = initWriter(paramFile, paramCharsetEncoder, paramBoolean);
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
/*     */   private static Writer initWriter(File paramFile, Object paramObject, boolean paramBoolean) {
/* 226 */     if (paramFile == null) {
/* 227 */       throw new NullPointerException("File is missing");
/*     */     }
/* 229 */     if (paramObject == null) {
/* 230 */       throw new NullPointerException("Encoding is missing");
/*     */     }
/* 232 */     FileOutputStream fileOutputStream = null;
/* 233 */     boolean bool = paramFile.exists();
/*     */     try {
/* 235 */       fileOutputStream = new FileOutputStream(paramFile, paramBoolean);
/* 236 */       if (paramObject instanceof Charset)
/* 237 */         return new OutputStreamWriter(fileOutputStream, (Charset)paramObject); 
/* 238 */       if (paramObject instanceof CharsetEncoder) {
/* 239 */         return new OutputStreamWriter(fileOutputStream, (CharsetEncoder)paramObject);
/*     */       }
/* 241 */       return new OutputStreamWriter(fileOutputStream, (String)paramObject);
/*     */     }
/* 243 */     catch (IOException|RuntimeException iOException) {
/*     */       try {
/* 245 */         if (fileOutputStream != null) {
/* 246 */           fileOutputStream.close();
/*     */         }
/* 248 */       } catch (IOException iOException1) {
/* 249 */         iOException.addSuppressed(iOException1);
/*     */       } 
/* 251 */       if (!bool) {
/* 252 */         FileUtils.deleteQuietly(paramFile);
/*     */       }
/* 254 */       throw iOException;
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
/*     */   public void write(int paramInt) {
/* 266 */     this.out.write(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar) {
/* 276 */     this.out.write(paramArrayOfchar);
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
/* 288 */     this.out.write(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String paramString) {
/* 298 */     this.out.write(paramString);
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
/* 310 */     this.out.write(paramString, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 319 */     this.out.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 328 */     this.out.close();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/FileWriterWithEncoding.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */