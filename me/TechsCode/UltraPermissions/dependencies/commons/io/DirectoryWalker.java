/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.FileFilterUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.IOFileFilter;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.TrueFileFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DirectoryWalker<T>
/*     */ {
/*     */   private final FileFilter filter;
/*     */   private final int depthLimit;
/*     */   
/*     */   protected DirectoryWalker() {
/* 266 */     this(null, -1);
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
/*     */   protected DirectoryWalker(FileFilter paramFileFilter, int paramInt) {
/* 282 */     this.filter = paramFileFilter;
/* 283 */     this.depthLimit = paramInt;
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
/*     */   protected DirectoryWalker(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2, int paramInt) {
/* 301 */     if (paramIOFileFilter1 == null && paramIOFileFilter2 == null) {
/* 302 */       this.filter = null;
/*     */     } else {
/* 304 */       paramIOFileFilter1 = (paramIOFileFilter1 != null) ? paramIOFileFilter1 : TrueFileFilter.TRUE;
/* 305 */       paramIOFileFilter2 = (paramIOFileFilter2 != null) ? paramIOFileFilter2 : TrueFileFilter.TRUE;
/* 306 */       paramIOFileFilter1 = FileFilterUtils.makeDirectoryOnly(paramIOFileFilter1);
/* 307 */       paramIOFileFilter2 = FileFilterUtils.makeFileOnly(paramIOFileFilter2);
/* 308 */       this.filter = (FileFilter)FileFilterUtils.or(new IOFileFilter[] { paramIOFileFilter1, paramIOFileFilter2 });
/*     */     } 
/* 310 */     this.depthLimit = paramInt;
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
/*     */   protected final void walk(File paramFile, Collection<T> paramCollection) {
/* 330 */     if (paramFile == null) {
/* 331 */       throw new NullPointerException("Start Directory is null");
/*     */     }
/*     */     try {
/* 334 */       handleStart(paramFile, paramCollection);
/* 335 */       walk(paramFile, 0, paramCollection);
/* 336 */       handleEnd(paramCollection);
/* 337 */     } catch (CancelException cancelException) {
/* 338 */       handleCancelled(paramFile, paramCollection, cancelException);
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
/*     */   private void walk(File paramFile, int paramInt, Collection<T> paramCollection) {
/* 351 */     checkIfCancelled(paramFile, paramInt, paramCollection);
/* 352 */     if (handleDirectory(paramFile, paramInt, paramCollection)) {
/* 353 */       handleDirectoryStart(paramFile, paramInt, paramCollection);
/* 354 */       int i = paramInt + 1;
/* 355 */       if (this.depthLimit < 0 || i <= this.depthLimit) {
/* 356 */         checkIfCancelled(paramFile, paramInt, paramCollection);
/* 357 */         File[] arrayOfFile = (this.filter == null) ? paramFile.listFiles() : paramFile.listFiles(this.filter);
/* 358 */         arrayOfFile = filterDirectoryContents(paramFile, paramInt, arrayOfFile);
/* 359 */         if (arrayOfFile == null) {
/* 360 */           handleRestricted(paramFile, i, paramCollection);
/*     */         } else {
/* 362 */           for (File file : arrayOfFile) {
/* 363 */             if (file.isDirectory()) {
/* 364 */               walk(file, i, paramCollection);
/*     */             } else {
/* 366 */               checkIfCancelled(file, i, paramCollection);
/* 367 */               handleFile(file, i, paramCollection);
/* 368 */               checkIfCancelled(file, i, paramCollection);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 373 */       handleDirectoryEnd(paramFile, paramInt, paramCollection);
/*     */     } 
/* 375 */     checkIfCancelled(paramFile, paramInt, paramCollection);
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
/*     */   protected final void checkIfCancelled(File paramFile, int paramInt, Collection<T> paramCollection) {
/* 395 */     if (handleIsCancelled(paramFile, paramInt, paramCollection)) {
/* 396 */       throw new CancelException(paramFile, paramInt);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean handleIsCancelled(File paramFile, int paramInt, Collection<T> paramCollection) {
/* 438 */     return false;
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
/*     */   protected void handleCancelled(File paramFile, Collection<T> paramCollection, CancelException paramCancelException) {
/* 457 */     throw paramCancelException;
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
/*     */   protected void handleStart(File paramFile, Collection<T> paramCollection) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean handleDirectory(File paramFile, int paramInt, Collection<T> paramCollection) {
/* 492 */     return true;
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
/*     */   protected void handleDirectoryStart(File paramFile, int paramInt, Collection<T> paramCollection) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected File[] filterDirectoryContents(File paramFile, int paramInt, File[] paramArrayOfFile) {
/* 524 */     return paramArrayOfFile;
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
/*     */   protected void handleFile(File paramFile, int paramInt, Collection<T> paramCollection) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleRestricted(File paramFile, int paramInt, Collection<T> paramCollection) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleDirectoryEnd(File paramFile, int paramInt, Collection<T> paramCollection) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleEnd(Collection<T> paramCollection) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CancelException
/*     */     extends IOException
/*     */   {
/*     */     private static final long serialVersionUID = 1347339620135041008L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final File file;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int depth;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CancelException(File param1File, int param1Int) {
/* 606 */       this("Operation Cancelled", param1File, param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CancelException(String param1String, File param1File, int param1Int) {
/* 619 */       super(param1String);
/* 620 */       this.file = param1File;
/* 621 */       this.depth = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public File getFile() {
/* 630 */       return this.file;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getDepth() {
/* 639 */       return this.depth;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/DirectoryWalker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */