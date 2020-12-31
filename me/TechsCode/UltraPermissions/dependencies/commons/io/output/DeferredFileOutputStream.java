/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DeferredFileOutputStream
/*     */   extends ThresholdingOutputStream
/*     */ {
/*     */   private ByteArrayOutputStream memoryOutputStream;
/*     */   private OutputStream currentOutputStream;
/*     */   private File outputFile;
/*     */   private final String prefix;
/*     */   private final String suffix;
/*     */   private final File directory;
/*     */   private boolean closed = false;
/*     */   
/*     */   public DeferredFileOutputStream(int paramInt, File paramFile) {
/* 101 */     this(paramInt, paramFile, null, null, null, 1024);
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
/*     */   public DeferredFileOutputStream(int paramInt1, int paramInt2, File paramFile) {
/* 116 */     this(paramInt1, paramFile, null, null, null, paramInt2);
/* 117 */     if (paramInt2 < 0) {
/* 118 */       throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
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
/*     */   public DeferredFileOutputStream(int paramInt, String paramString1, String paramString2, File paramFile) {
/* 136 */     this(paramInt, null, paramString1, paramString2, paramFile, 1024);
/* 137 */     if (paramString1 == null) {
/* 138 */       throw new IllegalArgumentException("Temporary file prefix is missing");
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
/*     */   
/*     */   public DeferredFileOutputStream(int paramInt1, int paramInt2, String paramString1, String paramString2, File paramFile) {
/* 157 */     this(paramInt1, null, paramString1, paramString2, paramFile, paramInt2);
/* 158 */     if (paramString1 == null) {
/* 159 */       throw new IllegalArgumentException("Temporary file prefix is missing");
/*     */     }
/* 161 */     if (paramInt2 < 0) {
/* 162 */       throw new IllegalArgumentException("Initial buffer size must be atleast 0.");
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
/*     */   private DeferredFileOutputStream(int paramInt1, File paramFile1, String paramString1, String paramString2, File paramFile2, int paramInt2) {
/* 179 */     super(paramInt1);
/* 180 */     this.outputFile = paramFile1;
/* 181 */     this.prefix = paramString1;
/* 182 */     this.suffix = paramString2;
/* 183 */     this.directory = paramFile2;
/*     */     
/* 185 */     this.memoryOutputStream = new ByteArrayOutputStream(paramInt2);
/* 186 */     this.currentOutputStream = this.memoryOutputStream;
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
/*     */   protected OutputStream getStream() {
/* 204 */     return this.currentOutputStream;
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
/*     */   protected void thresholdReached() {
/* 219 */     if (this.prefix != null) {
/* 220 */       this.outputFile = File.createTempFile(this.prefix, this.suffix, this.directory);
/*     */     }
/* 222 */     FileUtils.forceMkdirParent(this.outputFile);
/* 223 */     FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile);
/*     */     try {
/* 225 */       this.memoryOutputStream.writeTo(fileOutputStream);
/* 226 */     } catch (IOException iOException) {
/* 227 */       fileOutputStream.close();
/* 228 */       throw iOException;
/*     */     } 
/* 230 */     this.currentOutputStream = fileOutputStream;
/* 231 */     this.memoryOutputStream = null;
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
/*     */   public boolean isInMemory() {
/* 247 */     return !isThresholdExceeded();
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
/*     */   public byte[] getData() {
/* 261 */     if (this.memoryOutputStream != null)
/*     */     {
/* 263 */       return this.memoryOutputStream.toByteArray();
/*     */     }
/* 265 */     return null;
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
/*     */   public File getFile() {
/* 285 */     return this.outputFile;
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
/* 297 */     super.close();
/* 298 */     this.closed = true;
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
/*     */   public void writeTo(OutputStream paramOutputStream) {
/* 314 */     if (!this.closed) {
/* 315 */       throw new IOException("Stream not closed");
/*     */     }
/*     */     
/* 318 */     if (isInMemory()) {
/* 319 */       this.memoryOutputStream.writeTo(paramOutputStream);
/*     */     } else {
/* 321 */       try (FileInputStream null = new FileInputStream(this.outputFile)) {
/* 322 */         IOUtils.copy(fileInputStream, paramOutputStream);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/DeferredFileOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */