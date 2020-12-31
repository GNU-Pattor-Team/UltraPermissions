/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FilenameFilter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.IOCase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileFilterUtils
/*     */ {
/*     */   public static File[] filter(IOFileFilter paramIOFileFilter, File... paramVarArgs) {
/*  77 */     if (paramIOFileFilter == null) {
/*  78 */       throw new IllegalArgumentException("file filter is null");
/*     */     }
/*  80 */     if (paramVarArgs == null) {
/*  81 */       return new File[0];
/*     */     }
/*  83 */     ArrayList<File> arrayList = new ArrayList();
/*  84 */     for (File file : paramVarArgs) {
/*  85 */       if (file == null) {
/*  86 */         throw new IllegalArgumentException("file array contains null");
/*     */       }
/*  88 */       if (paramIOFileFilter.accept(file)) {
/*  89 */         arrayList.add(file);
/*     */       }
/*     */     } 
/*  92 */     return arrayList.<File>toArray(new File[arrayList.size()]);
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
/*     */   public static File[] filter(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable) {
/* 122 */     List<File> list = filterList(paramIOFileFilter, paramIterable);
/* 123 */     return list.<File>toArray(new File[list.size()]);
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
/*     */   public static List<File> filterList(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable) {
/* 152 */     return filter(paramIOFileFilter, paramIterable, new ArrayList<>());
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
/*     */   public static List<File> filterList(IOFileFilter paramIOFileFilter, File... paramVarArgs) {
/* 181 */     File[] arrayOfFile = filter(paramIOFileFilter, paramVarArgs);
/* 182 */     return Arrays.asList(arrayOfFile);
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
/*     */   public static Set<File> filterSet(IOFileFilter paramIOFileFilter, File... paramVarArgs) {
/* 212 */     File[] arrayOfFile = filter(paramIOFileFilter, paramVarArgs);
/* 213 */     return new HashSet<>(Arrays.asList(arrayOfFile));
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
/*     */   public static Set<File> filterSet(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable) {
/* 243 */     return filter(paramIOFileFilter, paramIterable, new HashSet<>());
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
/*     */   private static <T extends java.util.Collection<File>> T filter(IOFileFilter paramIOFileFilter, Iterable<File> paramIterable, T paramT) {
/* 270 */     if (paramIOFileFilter == null) {
/* 271 */       throw new IllegalArgumentException("file filter is null");
/*     */     }
/* 273 */     if (paramIterable != null) {
/* 274 */       for (File file : paramIterable) {
/* 275 */         if (file == null) {
/* 276 */           throw new IllegalArgumentException("file collection contains null");
/*     */         }
/* 278 */         if (paramIOFileFilter.accept(file)) {
/* 279 */           paramT.add(file);
/*     */         }
/*     */       } 
/*     */     }
/* 283 */     return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter prefixFileFilter(String paramString) {
/* 294 */     return new PrefixFileFilter(paramString);
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
/*     */   public static IOFileFilter prefixFileFilter(String paramString, IOCase paramIOCase) {
/* 307 */     return new PrefixFileFilter(paramString, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter suffixFileFilter(String paramString) {
/* 318 */     return new SuffixFileFilter(paramString);
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
/*     */   public static IOFileFilter suffixFileFilter(String paramString, IOCase paramIOCase) {
/* 331 */     return new SuffixFileFilter(paramString, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter nameFileFilter(String paramString) {
/* 342 */     return new NameFileFilter(paramString);
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
/*     */   public static IOFileFilter nameFileFilter(String paramString, IOCase paramIOCase) {
/* 355 */     return new NameFileFilter(paramString, paramIOCase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter directoryFileFilter() {
/* 365 */     return DirectoryFileFilter.DIRECTORY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter fileFileFilter() {
/* 375 */     return FileFileFilter.FILE;
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
/*     */   @Deprecated
/*     */   public static IOFileFilter andFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 391 */     return new AndFileFilter(paramIOFileFilter1, paramIOFileFilter2);
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
/*     */   public static IOFileFilter orFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/* 406 */     return new OrFileFilter(paramIOFileFilter1, paramIOFileFilter2);
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
/*     */   public static IOFileFilter and(IOFileFilter... paramVarArgs) {
/* 421 */     return new AndFileFilter(toList(paramVarArgs));
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
/*     */   public static IOFileFilter or(IOFileFilter... paramVarArgs) {
/* 436 */     return new OrFileFilter(toList(paramVarArgs));
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
/*     */   public static List<IOFileFilter> toList(IOFileFilter... paramVarArgs) {
/* 449 */     if (paramVarArgs == null) {
/* 450 */       throw new IllegalArgumentException("The filters must not be null");
/*     */     }
/* 452 */     ArrayList<IOFileFilter> arrayList = new ArrayList(paramVarArgs.length);
/* 453 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 454 */       if (paramVarArgs[b] == null) {
/* 455 */         throw new IllegalArgumentException("The filter[" + b + "] is null");
/*     */       }
/* 457 */       arrayList.add(paramVarArgs[b]);
/*     */     } 
/* 459 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter notFileFilter(IOFileFilter paramIOFileFilter) {
/* 470 */     return new NotFileFilter(paramIOFileFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter trueFileFilter() {
/* 481 */     return TrueFileFilter.TRUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter falseFileFilter() {
/* 491 */     return FalseFileFilter.FALSE;
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
/*     */   public static IOFileFilter asFileFilter(FileFilter paramFileFilter) {
/* 504 */     return new DelegateFileFilter(paramFileFilter);
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
/*     */   public static IOFileFilter asFileFilter(FilenameFilter paramFilenameFilter) {
/* 516 */     return new DelegateFileFilter(paramFilenameFilter);
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
/*     */   public static IOFileFilter ageFileFilter(long paramLong) {
/* 530 */     return new AgeFileFilter(paramLong);
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
/*     */   public static IOFileFilter ageFileFilter(long paramLong, boolean paramBoolean) {
/* 543 */     return new AgeFileFilter(paramLong, paramBoolean);
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
/*     */   public static IOFileFilter ageFileFilter(Date paramDate) {
/* 556 */     return new AgeFileFilter(paramDate);
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
/*     */   public static IOFileFilter ageFileFilter(Date paramDate, boolean paramBoolean) {
/* 569 */     return new AgeFileFilter(paramDate, paramBoolean);
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
/*     */   public static IOFileFilter ageFileFilter(File paramFile) {
/* 583 */     return new AgeFileFilter(paramFile);
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
/*     */   public static IOFileFilter ageFileFilter(File paramFile, boolean paramBoolean) {
/* 597 */     return new AgeFileFilter(paramFile, paramBoolean);
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
/*     */   public static IOFileFilter sizeFileFilter(long paramLong) {
/* 610 */     return new SizeFileFilter(paramLong);
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
/*     */   public static IOFileFilter sizeFileFilter(long paramLong, boolean paramBoolean) {
/* 623 */     return new SizeFileFilter(paramLong, paramBoolean);
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
/*     */   public static IOFileFilter sizeRangeFileFilter(long paramLong1, long paramLong2) {
/* 637 */     SizeFileFilter sizeFileFilter1 = new SizeFileFilter(paramLong1, true);
/* 638 */     SizeFileFilter sizeFileFilter2 = new SizeFileFilter(paramLong2 + 1L, false);
/* 639 */     return new AndFileFilter(sizeFileFilter1, sizeFileFilter2);
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
/*     */   public static IOFileFilter magicNumberFileFilter(String paramString) {
/* 658 */     return new MagicNumberFileFilter(paramString);
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
/*     */   public static IOFileFilter magicNumberFileFilter(String paramString, long paramLong) {
/* 679 */     return new MagicNumberFileFilter(paramString, paramLong);
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
/*     */   public static IOFileFilter magicNumberFileFilter(byte[] paramArrayOfbyte) {
/* 698 */     return new MagicNumberFileFilter(paramArrayOfbyte);
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
/*     */   public static IOFileFilter magicNumberFileFilter(byte[] paramArrayOfbyte, long paramLong) {
/* 719 */     return new MagicNumberFileFilter(paramArrayOfbyte, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 724 */   private static final IOFileFilter cvsFilter = notFileFilter(
/* 725 */       and(new IOFileFilter[] { directoryFileFilter(), nameFileFilter("CVS") }));
/*     */ 
/*     */   
/* 728 */   private static final IOFileFilter svnFilter = notFileFilter(
/* 729 */       and(new IOFileFilter[] { directoryFileFilter(), nameFileFilter(".svn") }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOFileFilter makeCVSAware(IOFileFilter paramIOFileFilter) {
/* 741 */     if (paramIOFileFilter == null) {
/* 742 */       return cvsFilter;
/*     */     }
/* 744 */     return and(new IOFileFilter[] { paramIOFileFilter, cvsFilter });
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
/*     */   public static IOFileFilter makeSVNAware(IOFileFilter paramIOFileFilter) {
/* 758 */     if (paramIOFileFilter == null) {
/* 759 */       return svnFilter;
/*     */     }
/* 761 */     return and(new IOFileFilter[] { paramIOFileFilter, svnFilter });
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
/*     */   public static IOFileFilter makeDirectoryOnly(IOFileFilter paramIOFileFilter) {
/* 775 */     if (paramIOFileFilter == null) {
/* 776 */       return DirectoryFileFilter.DIRECTORY;
/*     */     }
/* 778 */     return new AndFileFilter(DirectoryFileFilter.DIRECTORY, paramIOFileFilter);
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
/*     */   public static IOFileFilter makeFileOnly(IOFileFilter paramIOFileFilter) {
/* 790 */     if (paramIOFileFilter == null) {
/* 791 */       return FileFileFilter.FILE;
/*     */     }
/* 793 */     return new AndFileFilter(FileFileFilter.FILE, paramIOFileFilter);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/filefilter/FileFilterUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */