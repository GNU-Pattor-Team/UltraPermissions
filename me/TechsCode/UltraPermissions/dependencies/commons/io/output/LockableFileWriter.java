/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.Charsets;
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
/*     */ 
/*     */ 
/*     */ public class LockableFileWriter
/*     */   extends Writer
/*     */ {
/*     */   private static final String LCK = ".lck";
/*     */   private final Writer out;
/*     */   private final File lockFile;
/*     */   
/*     */   public LockableFileWriter(String paramString) {
/*  69 */     this(paramString, false, (String)null);
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
/*     */   public LockableFileWriter(String paramString, boolean paramBoolean) {
/*  81 */     this(paramString, paramBoolean, (String)null);
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
/*     */   public LockableFileWriter(String paramString1, boolean paramBoolean, String paramString2) {
/*  94 */     this(new File(paramString1), paramBoolean, paramString2);
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
/*     */   public LockableFileWriter(File paramFile) {
/* 106 */     this(paramFile, false, (String)null);
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
/*     */   public LockableFileWriter(File paramFile, boolean paramBoolean) {
/* 118 */     this(paramFile, paramBoolean, (String)null);
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
/*     */   @Deprecated
/*     */   public LockableFileWriter(File paramFile, boolean paramBoolean, String paramString) {
/* 133 */     this(paramFile, Charset.defaultCharset(), paramBoolean, paramString);
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
/*     */   public LockableFileWriter(File paramFile, Charset paramCharset) {
/* 146 */     this(paramFile, paramCharset, false, (String)null);
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
/*     */   public LockableFileWriter(File paramFile, String paramString) {
/* 161 */     this(paramFile, paramString, false, (String)null);
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
/*     */   public LockableFileWriter(File paramFile, Charset paramCharset, boolean paramBoolean, String paramString) {
/* 179 */     paramFile = paramFile.getAbsoluteFile();
/* 180 */     if (paramFile.getParentFile() != null) {
/* 181 */       FileUtils.forceMkdir(paramFile.getParentFile());
/*     */     }
/* 183 */     if (paramFile.isDirectory()) {
/* 184 */       throw new IOException("File specified is a directory");
/*     */     }
/*     */ 
/*     */     
/* 188 */     if (paramString == null) {
/* 189 */       paramString = System.getProperty("java.io.tmpdir");
/*     */     }
/* 191 */     File file = new File(paramString);
/* 192 */     FileUtils.forceMkdir(file);
/* 193 */     testLockDir(file);
/* 194 */     this.lockFile = new File(file, paramFile.getName() + ".lck");
/*     */ 
/*     */     
/* 197 */     createLock();
/*     */ 
/*     */     
/* 200 */     this.out = initWriter(paramFile, paramCharset, paramBoolean);
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
/*     */   public LockableFileWriter(File paramFile, String paramString1, boolean paramBoolean, String paramString2) {
/* 218 */     this(paramFile, Charsets.toCharset(paramString1), paramBoolean, paramString2);
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
/*     */   private void testLockDir(File paramFile) {
/* 230 */     if (!paramFile.exists()) {
/* 231 */       throw new IOException("Could not find lockDir: " + paramFile
/* 232 */           .getAbsolutePath());
/*     */     }
/* 234 */     if (!paramFile.canWrite()) {
/* 235 */       throw new IOException("Could not write to lockDir: " + paramFile
/* 236 */           .getAbsolutePath());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createLock() {
/* 246 */     synchronized (LockableFileWriter.class) {
/* 247 */       if (!this.lockFile.createNewFile()) {
/* 248 */         throw new IOException("Can't write file, lock " + this.lockFile
/* 249 */             .getAbsolutePath() + " exists");
/*     */       }
/* 251 */       this.lockFile.deleteOnExit();
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
/*     */   private Writer initWriter(File paramFile, Charset paramCharset, boolean paramBoolean) {
/* 266 */     boolean bool = paramFile.exists();
/*     */     try {
/* 268 */       return new OutputStreamWriter(new FileOutputStream(paramFile.getAbsolutePath(), paramBoolean), 
/* 269 */           Charsets.toCharset(paramCharset));
/*     */     }
/* 271 */     catch (IOException|RuntimeException iOException) {
/* 272 */       FileUtils.deleteQuietly(this.lockFile);
/* 273 */       if (!bool) {
/* 274 */         FileUtils.deleteQuietly(paramFile);
/*     */       }
/* 276 */       throw iOException;
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
/*     */   public void close() {
/*     */     try {
/* 289 */       this.out.close();
/*     */     } finally {
/* 291 */       this.lockFile.delete();
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
/* 303 */     this.out.write(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar) {
/* 313 */     this.out.write(paramArrayOfchar);
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
/* 325 */     this.out.write(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String paramString) {
/* 335 */     this.out.write(paramString);
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
/* 347 */     this.out.write(paramString, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 356 */     this.out.flush();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/LockableFileWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */