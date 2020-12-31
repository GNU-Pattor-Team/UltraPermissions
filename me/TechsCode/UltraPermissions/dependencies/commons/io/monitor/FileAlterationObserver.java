/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.monitor;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.IOCase;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.comparator.NameFileComparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileAlterationObserver
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1185122225658782848L;
/* 125 */   private final List<FileAlterationListener> listeners = new CopyOnWriteArrayList<>();
/*     */ 
/*     */   
/*     */   private final FileEntry rootEntry;
/*     */   
/*     */   private final FileFilter fileFilter;
/*     */   
/*     */   private final Comparator<File> comparator;
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(String paramString) {
/* 136 */     this(new File(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(String paramString, FileFilter paramFileFilter) {
/* 146 */     this(new File(paramString), paramFileFilter);
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
/*     */   public FileAlterationObserver(String paramString, FileFilter paramFileFilter, IOCase paramIOCase) {
/* 159 */     this(new File(paramString), paramFileFilter, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(File paramFile) {
/* 168 */     this(paramFile, (FileFilter)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationObserver(File paramFile, FileFilter paramFileFilter) {
/* 178 */     this(paramFile, paramFileFilter, (IOCase)null);
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
/*     */   public FileAlterationObserver(File paramFile, FileFilter paramFileFilter, IOCase paramIOCase) {
/* 190 */     this(new FileEntry(paramFile), paramFileFilter, paramIOCase);
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
/*     */   protected FileAlterationObserver(FileEntry paramFileEntry, FileFilter paramFileFilter, IOCase paramIOCase) {
/* 203 */     if (paramFileEntry == null) {
/* 204 */       throw new IllegalArgumentException("Root entry is missing");
/*     */     }
/* 206 */     if (paramFileEntry.getFile() == null) {
/* 207 */       throw new IllegalArgumentException("Root directory is missing");
/*     */     }
/* 209 */     this.rootEntry = paramFileEntry;
/* 210 */     this.fileFilter = paramFileFilter;
/* 211 */     if (paramIOCase == null || paramIOCase.equals(IOCase.SYSTEM)) {
/* 212 */       this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
/* 213 */     } else if (paramIOCase.equals(IOCase.INSENSITIVE)) {
/* 214 */       this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
/*     */     } else {
/* 216 */       this.comparator = NameFileComparator.NAME_COMPARATOR;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getDirectory() {
/* 226 */     return this.rootEntry.getFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileFilter getFileFilter() {
/* 236 */     return this.fileFilter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(FileAlterationListener paramFileAlterationListener) {
/* 245 */     if (paramFileAlterationListener != null) {
/* 246 */       this.listeners.add(paramFileAlterationListener);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeListener(FileAlterationListener paramFileAlterationListener) {
/* 256 */     if (paramFileAlterationListener != null) {
/* 257 */       while (this.listeners.remove(paramFileAlterationListener));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<FileAlterationListener> getListeners() {
/* 268 */     return this.listeners;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/* 277 */     this.rootEntry.refresh(this.rootEntry.getFile());
/* 278 */     FileEntry[] arrayOfFileEntry = doListFiles(this.rootEntry.getFile(), this.rootEntry);
/* 279 */     this.rootEntry.setChildren(arrayOfFileEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroy() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkAndNotify() {
/* 296 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 297 */       fileAlterationListener.onStart(this);
/*     */     }
/*     */ 
/*     */     
/* 301 */     File file = this.rootEntry.getFile();
/* 302 */     if (file.exists()) {
/* 303 */       checkAndNotify(this.rootEntry, this.rootEntry.getChildren(), listFiles(file));
/* 304 */     } else if (this.rootEntry.isExists()) {
/* 305 */       checkAndNotify(this.rootEntry, this.rootEntry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 312 */       fileAlterationListener.onStop(this);
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
/*     */   private void checkAndNotify(FileEntry paramFileEntry, FileEntry[] paramArrayOfFileEntry, File[] paramArrayOfFile) {
/* 324 */     byte b = 0;
/* 325 */     FileEntry[] arrayOfFileEntry = (paramArrayOfFile.length > 0) ? new FileEntry[paramArrayOfFile.length] : FileEntry.EMPTY_ENTRIES;
/* 326 */     for (FileEntry fileEntry : paramArrayOfFileEntry) {
/* 327 */       while (b < paramArrayOfFile.length && this.comparator.compare(fileEntry.getFile(), paramArrayOfFile[b]) > 0) {
/* 328 */         arrayOfFileEntry[b] = createFileEntry(paramFileEntry, paramArrayOfFile[b]);
/* 329 */         doCreate(arrayOfFileEntry[b]);
/* 330 */         b++;
/*     */       } 
/* 332 */       if (b < paramArrayOfFile.length && this.comparator.compare(fileEntry.getFile(), paramArrayOfFile[b]) == 0) {
/* 333 */         doMatch(fileEntry, paramArrayOfFile[b]);
/* 334 */         checkAndNotify(fileEntry, fileEntry.getChildren(), listFiles(paramArrayOfFile[b]));
/* 335 */         arrayOfFileEntry[b] = fileEntry;
/* 336 */         b++;
/*     */       } else {
/* 338 */         checkAndNotify(fileEntry, fileEntry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
/* 339 */         doDelete(fileEntry);
/*     */       } 
/*     */     } 
/* 342 */     for (; b < paramArrayOfFile.length; b++) {
/* 343 */       arrayOfFileEntry[b] = createFileEntry(paramFileEntry, paramArrayOfFile[b]);
/* 344 */       doCreate(arrayOfFileEntry[b]);
/*     */     } 
/* 346 */     paramFileEntry.setChildren(arrayOfFileEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileEntry createFileEntry(FileEntry paramFileEntry, File paramFile) {
/* 357 */     FileEntry fileEntry = paramFileEntry.newChildInstance(paramFile);
/* 358 */     fileEntry.refresh(paramFile);
/* 359 */     FileEntry[] arrayOfFileEntry = doListFiles(paramFile, fileEntry);
/* 360 */     fileEntry.setChildren(arrayOfFileEntry);
/* 361 */     return fileEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileEntry[] doListFiles(File paramFile, FileEntry paramFileEntry) {
/* 371 */     File[] arrayOfFile = listFiles(paramFile);
/* 372 */     FileEntry[] arrayOfFileEntry = (arrayOfFile.length > 0) ? new FileEntry[arrayOfFile.length] : FileEntry.EMPTY_ENTRIES;
/* 373 */     for (byte b = 0; b < arrayOfFile.length; b++) {
/* 374 */       arrayOfFileEntry[b] = createFileEntry(paramFileEntry, arrayOfFile[b]);
/*     */     }
/* 376 */     return arrayOfFileEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doCreate(FileEntry paramFileEntry) {
/* 385 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 386 */       if (paramFileEntry.isDirectory()) {
/* 387 */         fileAlterationListener.onDirectoryCreate(paramFileEntry.getFile()); continue;
/*     */       } 
/* 389 */       fileAlterationListener.onFileCreate(paramFileEntry.getFile());
/*     */     } 
/*     */     
/* 392 */     FileEntry[] arrayOfFileEntry = paramFileEntry.getChildren();
/* 393 */     for (FileEntry fileEntry : arrayOfFileEntry) {
/* 394 */       doCreate(fileEntry);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doMatch(FileEntry paramFileEntry, File paramFile) {
/* 405 */     if (paramFileEntry.refresh(paramFile)) {
/* 406 */       for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 407 */         if (paramFileEntry.isDirectory()) {
/* 408 */           fileAlterationListener.onDirectoryChange(paramFile); continue;
/*     */         } 
/* 410 */         fileAlterationListener.onFileChange(paramFile);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doDelete(FileEntry paramFileEntry) {
/* 422 */     for (FileAlterationListener fileAlterationListener : this.listeners) {
/* 423 */       if (paramFileEntry.isDirectory()) {
/* 424 */         fileAlterationListener.onDirectoryDelete(paramFileEntry.getFile()); continue;
/*     */       } 
/* 426 */       fileAlterationListener.onFileDelete(paramFileEntry.getFile());
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
/*     */   private File[] listFiles(File paramFile) {
/* 439 */     File[] arrayOfFile = null;
/* 440 */     if (paramFile.isDirectory()) {
/* 441 */       arrayOfFile = (this.fileFilter == null) ? paramFile.listFiles() : paramFile.listFiles(this.fileFilter);
/*     */     }
/* 443 */     if (arrayOfFile == null) {
/* 444 */       arrayOfFile = FileUtils.EMPTY_FILE_ARRAY;
/*     */     }
/* 446 */     if (this.comparator != null && arrayOfFile.length > 1) {
/* 447 */       Arrays.sort(arrayOfFile, this.comparator);
/*     */     }
/* 449 */     return arrayOfFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 459 */     StringBuilder stringBuilder = new StringBuilder();
/* 460 */     stringBuilder.append(getClass().getSimpleName());
/* 461 */     stringBuilder.append("[file='");
/* 462 */     stringBuilder.append(getDirectory().getPath());
/* 463 */     stringBuilder.append('\'');
/* 464 */     if (this.fileFilter != null) {
/* 465 */       stringBuilder.append(", ");
/* 466 */       stringBuilder.append(this.fileFilter.toString());
/*     */     } 
/* 468 */     stringBuilder.append(", listeners=");
/* 469 */     stringBuilder.append(this.listeners.size());
/* 470 */     stringBuilder.append("]");
/* 471 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/monitor/FileAlterationObserver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */