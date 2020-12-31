/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*      */ 
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileFilter;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.math.BigInteger;
/*      */ import java.net.URL;
/*      */ import java.net.URLConnection;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.channels.FileChannel;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import java.nio.file.Files;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.zip.CRC32;
/*      */ import java.util.zip.CheckedInputStream;
/*      */ import java.util.zip.Checksum;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.DirectoryFileFilter;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.FalseFileFilter;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.FileFilterUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.IOFileFilter;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.SuffixFileFilter;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter.TrueFileFilter;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.output.NullOutputStream;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FileUtils
/*      */ {
/*      */   public static final long ONE_KB = 1024L;
/*   98 */   public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024L);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_MB = 1048576L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  110 */   public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_GB = 1073741824L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  127 */   public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_TB = 1099511627776L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  139 */   public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_PB = 1125899906842624L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  151 */   public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long ONE_EB = 1152921504606846976L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  163 */   public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  168 */   public static final BigInteger ONE_ZB = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  173 */   public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  178 */   public static final File[] EMPTY_FILE_ARRAY = new File[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getFile(File paramFile, String... paramVarArgs) {
/*  190 */     if (paramFile == null) {
/*  191 */       throw new NullPointerException("directory must not be null");
/*      */     }
/*  193 */     if (paramVarArgs == null) {
/*  194 */       throw new NullPointerException("names must not be null");
/*      */     }
/*  196 */     File file = paramFile;
/*  197 */     for (String str : paramVarArgs) {
/*  198 */       file = new File(file, str);
/*      */     }
/*  200 */     return file;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getFile(String... paramVarArgs) {
/*  211 */     if (paramVarArgs == null) {
/*  212 */       throw new NullPointerException("names must not be null");
/*      */     }
/*  214 */     File file = null;
/*  215 */     for (String str : paramVarArgs) {
/*  216 */       if (file == null) {
/*  217 */         file = new File(str);
/*      */       } else {
/*  219 */         file = new File(file, str);
/*      */       } 
/*      */     } 
/*  222 */     return file;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getTempDirectoryPath() {
/*  233 */     return System.getProperty("java.io.tmpdir");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getTempDirectory() {
/*  244 */     return new File(getTempDirectoryPath());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getUserDirectoryPath() {
/*  255 */     return System.getProperty("user.home");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File getUserDirectory() {
/*  266 */     return new File(getUserDirectoryPath());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FileInputStream openInputStream(File paramFile) {
/*  289 */     if (paramFile.exists()) {
/*  290 */       if (paramFile.isDirectory()) {
/*  291 */         throw new IOException("File '" + paramFile + "' exists but is a directory");
/*      */       }
/*  293 */       if (!paramFile.canRead()) {
/*  294 */         throw new IOException("File '" + paramFile + "' cannot be read");
/*      */       }
/*      */     } else {
/*  297 */       throw new FileNotFoundException("File '" + paramFile + "' does not exist");
/*      */     } 
/*  299 */     return new FileInputStream(paramFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FileOutputStream openOutputStream(File paramFile) {
/*  324 */     return openOutputStream(paramFile, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FileOutputStream openOutputStream(File paramFile, boolean paramBoolean) {
/*  350 */     if (paramFile.exists()) {
/*  351 */       if (paramFile.isDirectory()) {
/*  352 */         throw new IOException("File '" + paramFile + "' exists but is a directory");
/*      */       }
/*  354 */       if (!paramFile.canWrite()) {
/*  355 */         throw new IOException("File '" + paramFile + "' cannot be written to");
/*      */       }
/*      */     } else {
/*  358 */       File file = paramFile.getParentFile();
/*  359 */       if (file != null && 
/*  360 */         !file.mkdirs() && !file.isDirectory()) {
/*  361 */         throw new IOException("Directory '" + file + "' could not be created");
/*      */       }
/*      */     } 
/*      */     
/*  365 */     return new FileOutputStream(paramFile, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String byteCountToDisplaySize(BigInteger paramBigInteger) {
/*      */     String str;
/*  388 */     if (paramBigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  389 */       str = String.valueOf(paramBigInteger.divide(ONE_EB_BI)) + " EB";
/*  390 */     } else if (paramBigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  391 */       str = String.valueOf(paramBigInteger.divide(ONE_PB_BI)) + " PB";
/*  392 */     } else if (paramBigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  393 */       str = String.valueOf(paramBigInteger.divide(ONE_TB_BI)) + " TB";
/*  394 */     } else if (paramBigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  395 */       str = String.valueOf(paramBigInteger.divide(ONE_GB_BI)) + " GB";
/*  396 */     } else if (paramBigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  397 */       str = String.valueOf(paramBigInteger.divide(ONE_MB_BI)) + " MB";
/*  398 */     } else if (paramBigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
/*  399 */       str = String.valueOf(paramBigInteger.divide(ONE_KB_BI)) + " KB";
/*      */     } else {
/*  401 */       str = String.valueOf(paramBigInteger) + " bytes";
/*      */     } 
/*  403 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String byteCountToDisplaySize(long paramLong) {
/*  422 */     return byteCountToDisplaySize(BigInteger.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void touch(File paramFile) {
/*  439 */     if (!paramFile.exists()) {
/*  440 */       openOutputStream(paramFile).close();
/*      */     }
/*  442 */     boolean bool = paramFile.setLastModified(System.currentTimeMillis());
/*  443 */     if (!bool) {
/*  444 */       throw new IOException("Unable to set the last modification time for " + paramFile);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File[] convertFileCollectionToFileArray(Collection<File> paramCollection) {
/*  458 */     return paramCollection.<File>toArray(new File[paramCollection.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void innerListFiles(Collection<File> paramCollection, File paramFile, IOFileFilter paramIOFileFilter, boolean paramBoolean) {
/*  473 */     File[] arrayOfFile = paramFile.listFiles((FileFilter)paramIOFileFilter);
/*      */     
/*  475 */     if (arrayOfFile != null) {
/*  476 */       for (File file : arrayOfFile) {
/*  477 */         if (file.isDirectory()) {
/*  478 */           if (paramBoolean) {
/*  479 */             paramCollection.add(file);
/*      */           }
/*  481 */           innerListFiles(paramCollection, file, paramIOFileFilter, paramBoolean);
/*      */         } else {
/*  483 */           paramCollection.add(file);
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Collection<File> listFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/*  517 */     validateListFilesParameters(paramFile, paramIOFileFilter1);
/*      */     
/*  519 */     IOFileFilter iOFileFilter1 = setUpEffectiveFileFilter(paramIOFileFilter1);
/*  520 */     IOFileFilter iOFileFilter2 = setUpEffectiveDirFilter(paramIOFileFilter2);
/*      */ 
/*      */     
/*  523 */     LinkedList<File> linkedList = new LinkedList();
/*  524 */     innerListFiles(linkedList, paramFile, 
/*  525 */         FileFilterUtils.or(new IOFileFilter[] { iOFileFilter1, iOFileFilter2 }, ), false);
/*  526 */     return linkedList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void validateListFilesParameters(File paramFile, IOFileFilter paramIOFileFilter) {
/*  540 */     if (!paramFile.isDirectory()) {
/*  541 */       throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + paramFile);
/*      */     }
/*  543 */     if (paramIOFileFilter == null) {
/*  544 */       throw new NullPointerException("Parameter 'fileFilter' is null");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter paramIOFileFilter) {
/*  555 */     return FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter paramIOFileFilter) {
/*  565 */     return (paramIOFileFilter == null) ? FalseFileFilter.INSTANCE : FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, DirectoryFileFilter.INSTANCE });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Collection<File> listFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/*  590 */     validateListFilesParameters(paramFile, paramIOFileFilter1);
/*      */     
/*  592 */     IOFileFilter iOFileFilter1 = setUpEffectiveFileFilter(paramIOFileFilter1);
/*  593 */     IOFileFilter iOFileFilter2 = setUpEffectiveDirFilter(paramIOFileFilter2);
/*      */ 
/*      */     
/*  596 */     LinkedList<File> linkedList = new LinkedList();
/*  597 */     if (paramFile.isDirectory()) {
/*  598 */       linkedList.add(paramFile);
/*      */     }
/*  600 */     innerListFiles(linkedList, paramFile, 
/*  601 */         FileFilterUtils.or(new IOFileFilter[] { iOFileFilter1, iOFileFilter2 }, ), true);
/*  602 */     return linkedList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator<File> iterateFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/*  625 */     return listFiles(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator<File> iterateFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/*  650 */     return listFilesAndDirs(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] toSuffixes(String[] paramArrayOfString) {
/*  662 */     String[] arrayOfString = new String[paramArrayOfString.length];
/*  663 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  664 */       arrayOfString[b] = "." + paramArrayOfString[b];
/*      */     }
/*  666 */     return arrayOfString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Collection<File> listFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean) {
/*      */     SuffixFileFilter suffixFileFilter;
/*  683 */     if (paramArrayOfString == null) {
/*  684 */       IOFileFilter iOFileFilter = TrueFileFilter.INSTANCE;
/*      */     } else {
/*  686 */       String[] arrayOfString = toSuffixes(paramArrayOfString);
/*  687 */       suffixFileFilter = new SuffixFileFilter(arrayOfString);
/*      */     } 
/*  689 */     return listFiles(paramFile, (IOFileFilter)suffixFileFilter, paramBoolean ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator<File> iterateFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean) {
/*  708 */     return listFiles(paramFile, paramArrayOfString, paramBoolean).iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEquals(File paramFile1, File paramFile2) {
/*  728 */     boolean bool = paramFile1.exists();
/*  729 */     if (bool != paramFile2.exists()) {
/*  730 */       return false;
/*      */     }
/*      */     
/*  733 */     if (!bool)
/*      */     {
/*  735 */       return true;
/*      */     }
/*      */     
/*  738 */     if (paramFile1.isDirectory() || paramFile2.isDirectory())
/*      */     {
/*  740 */       throw new IOException("Can't compare directories, only files");
/*      */     }
/*      */     
/*  743 */     if (paramFile1.length() != paramFile2.length())
/*      */     {
/*  745 */       return false;
/*      */     }
/*      */     
/*  748 */     if (paramFile1.getCanonicalFile().equals(paramFile2.getCanonicalFile()))
/*      */     {
/*  750 */       return true;
/*      */     }
/*      */     
/*  753 */     try(FileInputStream null = new FileInputStream(paramFile1); 
/*  754 */         FileInputStream null = new FileInputStream(paramFile2)) {
/*  755 */       return IOUtils.contentEquals(fileInputStream, fileInputStream1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEqualsIgnoreEOL(File paramFile1, File paramFile2, String paramString) {
/*  779 */     boolean bool = paramFile1.exists();
/*  780 */     if (bool != paramFile2.exists()) {
/*  781 */       return false;
/*      */     }
/*      */     
/*  784 */     if (!bool)
/*      */     {
/*  786 */       return true;
/*      */     }
/*      */     
/*  789 */     if (paramFile1.isDirectory() || paramFile2.isDirectory())
/*      */     {
/*  791 */       throw new IOException("Can't compare directories, only files");
/*      */     }
/*      */     
/*  794 */     if (paramFile1.getCanonicalFile().equals(paramFile2.getCanonicalFile()))
/*      */     {
/*  796 */       return true;
/*      */     }
/*      */     
/*  799 */     try(InputStreamReader null = (paramString == null) ? new InputStreamReader(new FileInputStream(paramFile1), 
/*  800 */           Charset.defaultCharset()) : new InputStreamReader(new FileInputStream(paramFile1), paramString); 
/*      */         
/*  802 */         InputStreamReader null = (paramString == null) ? new InputStreamReader(new FileInputStream(paramFile2), 
/*  803 */           Charset.defaultCharset()) : new InputStreamReader(new FileInputStream(paramFile2), paramString)) {
/*      */       
/*  805 */       return IOUtils.contentEqualsIgnoreEOL(inputStreamReader, inputStreamReader1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File toFile(URL paramURL) {
/*  825 */     if (paramURL == null || !"file".equalsIgnoreCase(paramURL.getProtocol())) {
/*  826 */       return null;
/*      */     }
/*  828 */     String str = paramURL.getFile().replace('/', File.separatorChar);
/*  829 */     str = decodeUrl(str);
/*  830 */     return new File(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String decodeUrl(String paramString) {
/*  849 */     String str = paramString;
/*  850 */     if (paramString != null && paramString.indexOf('%') >= 0) {
/*  851 */       int i = paramString.length();
/*  852 */       StringBuilder stringBuilder = new StringBuilder();
/*  853 */       ByteBuffer byteBuffer = ByteBuffer.allocate(i);
/*  854 */       for (byte b = 0; b < i; ) {
/*  855 */         if (paramString.charAt(b) == '%') {
/*      */           try {
/*      */             do {
/*  858 */               byte b1 = (byte)Integer.parseInt(paramString.substring(b + 1, b + 3), 16);
/*  859 */               byteBuffer.put(b1);
/*  860 */               b += 3;
/*  861 */             } while (b < i && paramString.charAt(b) == '%');
/*      */             continue;
/*  863 */           } catch (RuntimeException runtimeException) {
/*      */ 
/*      */           
/*      */           } finally {
/*  867 */             if (byteBuffer.position() > 0) {
/*  868 */               byteBuffer.flip();
/*  869 */               stringBuilder.append(StandardCharsets.UTF_8.decode(byteBuffer).toString());
/*  870 */               byteBuffer.clear();
/*      */             } 
/*      */           } 
/*      */         }
/*  874 */         stringBuilder.append(paramString.charAt(b++));
/*      */       } 
/*  876 */       str = stringBuilder.toString();
/*      */     } 
/*  878 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File[] toFiles(URL[] paramArrayOfURL) {
/*  901 */     if (paramArrayOfURL == null || paramArrayOfURL.length == 0) {
/*  902 */       return EMPTY_FILE_ARRAY;
/*      */     }
/*  904 */     File[] arrayOfFile = new File[paramArrayOfURL.length];
/*  905 */     for (byte b = 0; b < paramArrayOfURL.length; b++) {
/*  906 */       URL uRL = paramArrayOfURL[b];
/*  907 */       if (uRL != null) {
/*  908 */         if (!uRL.getProtocol().equals("file")) {
/*  909 */           throw new IllegalArgumentException("URL could not be converted to a File: " + uRL);
/*      */         }
/*      */         
/*  912 */         arrayOfFile[b] = toFile(uRL);
/*      */       } 
/*      */     } 
/*  915 */     return arrayOfFile;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static URL[] toURLs(File[] paramArrayOfFile) {
/*  929 */     URL[] arrayOfURL = new URL[paramArrayOfFile.length];
/*      */     
/*  931 */     for (byte b = 0; b < arrayOfURL.length; b++) {
/*  932 */       arrayOfURL[b] = paramArrayOfFile[b].toURI().toURL();
/*      */     }
/*      */     
/*  935 */     return arrayOfURL;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFileToDirectory(File paramFile1, File paramFile2) {
/*  961 */     copyFileToDirectory(paramFile1, paramFile2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) {
/*  993 */     if (paramFile2 == null) {
/*  994 */       throw new NullPointerException("Destination must not be null");
/*      */     }
/*  996 */     if (paramFile2.exists() && !paramFile2.isDirectory()) {
/*  997 */       throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/*  999 */     File file = new File(paramFile2, paramFile1.getName());
/* 1000 */     copyFile(paramFile1, file, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFile(File paramFile1, File paramFile2) {
/* 1028 */     copyFile(paramFile1, paramFile2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean) {
/* 1060 */     checkFileRequirements(paramFile1, paramFile2);
/* 1061 */     if (paramFile1.isDirectory()) {
/* 1062 */       throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
/*      */     }
/* 1064 */     if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
/* 1065 */       throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
/*      */     }
/* 1067 */     File file = paramFile2.getParentFile();
/* 1068 */     if (file != null && 
/* 1069 */       !file.mkdirs() && !file.isDirectory()) {
/* 1070 */       throw new IOException("Destination '" + file + "' directory cannot be created");
/*      */     }
/*      */     
/* 1073 */     if (paramFile2.exists() && !paramFile2.canWrite()) {
/* 1074 */       throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
/*      */     }
/* 1076 */     doCopyFile(paramFile1, paramFile2, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyFile(File paramFile, OutputStream paramOutputStream) {
/* 1093 */     try (FileInputStream null = new FileInputStream(paramFile)) {
/* 1094 */       return IOUtils.copyLarge(fileInputStream, paramOutputStream);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean) {
/* 1117 */     if (paramFile2.exists() && paramFile2.isDirectory()) {
/* 1118 */       throw new IOException("Destination '" + paramFile2 + "' exists but is a directory");
/*      */     }
/*      */     
/* 1121 */     try(FileInputStream null = new FileInputStream(paramFile1); 
/* 1122 */         FileChannel null = fileInputStream.getChannel(); 
/* 1123 */         FileOutputStream null = new FileOutputStream(paramFile2); 
/* 1124 */         FileChannel null = fileOutputStream.getChannel()) {
/* 1125 */       long l3 = fileChannel.size();
/* 1126 */       long l4 = 0L;
/* 1127 */       long l5 = 0L;
/* 1128 */       while (l4 < l3) {
/* 1129 */         long l6 = l3 - l4;
/* 1130 */         l5 = (l6 > 31457280L) ? 31457280L : l6;
/* 1131 */         long l7 = fileChannel1.transferFrom(fileChannel, l4, l5);
/* 1132 */         if (l7 == 0L) {
/*      */           break;
/*      */         }
/* 1135 */         l4 += l7;
/*      */       } 
/*      */     } 
/*      */     
/* 1139 */     long l1 = paramFile1.length();
/* 1140 */     long l2 = paramFile2.length();
/* 1141 */     if (l1 != l2) {
/* 1142 */       throw new IOException("Failed to copy full contents from '" + paramFile1 + "' to '" + paramFile2 + "' Expected length: " + l1 + " Actual: " + l2);
/*      */     }
/*      */     
/* 1145 */     if (paramBoolean) {
/* 1146 */       paramFile2.setLastModified(paramFile1.lastModified());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectoryToDirectory(File paramFile1, File paramFile2) {
/* 1175 */     if (paramFile1 == null) {
/* 1176 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 1178 */     if (paramFile1.exists() && !paramFile1.isDirectory()) {
/* 1179 */       throw new IllegalArgumentException("Source '" + paramFile2 + "' is not a directory");
/*      */     }
/* 1181 */     if (paramFile2 == null) {
/* 1182 */       throw new NullPointerException("Destination must not be null");
/*      */     }
/* 1184 */     if (paramFile2.exists() && !paramFile2.isDirectory()) {
/* 1185 */       throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/* 1187 */     copyDirectory(paramFile1, new File(paramFile2, paramFile1.getName()), true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2) {
/* 1215 */     copyDirectory(paramFile1, paramFile2, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2, boolean paramBoolean) {
/* 1246 */     copyDirectory(paramFile1, paramFile2, null, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter) {
/* 1295 */     copyDirectory(paramFile1, paramFile2, paramFileFilter, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean) {
/* 1346 */     checkFileRequirements(paramFile1, paramFile2);
/* 1347 */     if (!paramFile1.isDirectory()) {
/* 1348 */       throw new IOException("Source '" + paramFile1 + "' exists but is not a directory");
/*      */     }
/* 1350 */     if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
/* 1351 */       throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
/*      */     }
/*      */ 
/*      */     
/* 1355 */     ArrayList<String> arrayList = null;
/* 1356 */     if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath())) {
/* 1357 */       File[] arrayOfFile = (paramFileFilter == null) ? paramFile1.listFiles() : paramFile1.listFiles(paramFileFilter);
/* 1358 */       if (arrayOfFile != null && arrayOfFile.length > 0) {
/* 1359 */         arrayList = new ArrayList(arrayOfFile.length);
/* 1360 */         for (File file1 : arrayOfFile) {
/* 1361 */           File file2 = new File(paramFile2, file1.getName());
/* 1362 */           arrayList.add(file2.getCanonicalPath());
/*      */         } 
/*      */       } 
/*      */     } 
/* 1366 */     doCopyDirectory(paramFile1, paramFile2, paramFileFilter, paramBoolean, arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkFileRequirements(File paramFile1, File paramFile2) {
/* 1376 */     if (paramFile1 == null) {
/* 1377 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 1379 */     if (paramFile2 == null) {
/* 1380 */       throw new NullPointerException("Destination must not be null");
/*      */     }
/* 1382 */     if (!paramFile1.exists()) {
/* 1383 */       throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void doCopyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List<String> paramList) {
/* 1402 */     File[] arrayOfFile = (paramFileFilter == null) ? paramFile1.listFiles() : paramFile1.listFiles(paramFileFilter);
/* 1403 */     if (arrayOfFile == null) {
/* 1404 */       throw new IOException("Failed to list contents of " + paramFile1);
/*      */     }
/* 1406 */     if (paramFile2.exists()) {
/* 1407 */       if (!paramFile2.isDirectory()) {
/* 1408 */         throw new IOException("Destination '" + paramFile2 + "' exists but is not a directory");
/*      */       }
/*      */     }
/* 1411 */     else if (!paramFile2.mkdirs() && !paramFile2.isDirectory()) {
/* 1412 */       throw new IOException("Destination '" + paramFile2 + "' directory cannot be created");
/*      */     } 
/*      */     
/* 1415 */     if (!paramFile2.canWrite()) {
/* 1416 */       throw new IOException("Destination '" + paramFile2 + "' cannot be written to");
/*      */     }
/* 1418 */     for (File file1 : arrayOfFile) {
/* 1419 */       File file2 = new File(paramFile2, file1.getName());
/* 1420 */       if (paramList == null || !paramList.contains(file1.getCanonicalPath())) {
/* 1421 */         if (file1.isDirectory()) {
/* 1422 */           doCopyDirectory(file1, file2, paramFileFilter, paramBoolean, paramList);
/*      */         } else {
/* 1424 */           doCopyFile(file1, file2, paramBoolean);
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1430 */     if (paramBoolean) {
/* 1431 */       paramFile2.setLastModified(paramFile1.lastModified());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyURLToFile(URL paramURL, File paramFile) {
/* 1456 */     copyInputStreamToFile(paramURL.openStream(), paramFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyURLToFile(URL paramURL, File paramFile, int paramInt1, int paramInt2) {
/* 1481 */     URLConnection uRLConnection = paramURL.openConnection();
/* 1482 */     uRLConnection.setConnectTimeout(paramInt1);
/* 1483 */     uRLConnection.setReadTimeout(paramInt2);
/* 1484 */     copyInputStreamToFile(uRLConnection.getInputStream(), paramFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyInputStreamToFile(InputStream paramInputStream, File paramFile) {
/* 1505 */     try (InputStream null = paramInputStream) {
/* 1506 */       copyToFile(inputStream, paramFile);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyToFile(InputStream paramInputStream, File paramFile) {
/* 1528 */     try(InputStream null = paramInputStream; 
/* 1529 */         FileOutputStream null = openOutputStream(paramFile)) {
/* 1530 */       IOUtils.copy(inputStream, fileOutputStream);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyToDirectory(File paramFile1, File paramFile2) {
/* 1560 */     if (paramFile1 == null) {
/* 1561 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 1563 */     if (paramFile1.isFile()) {
/* 1564 */       copyFileToDirectory(paramFile1, paramFile2);
/* 1565 */     } else if (paramFile1.isDirectory()) {
/* 1566 */       copyDirectoryToDirectory(paramFile1, paramFile2);
/*      */     } else {
/* 1568 */       throw new IOException("The source " + paramFile1 + " does not exist");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyToDirectory(Iterable<File> paramIterable, File paramFile) {
/* 1595 */     if (paramIterable == null) {
/* 1596 */       throw new NullPointerException("Sources must not be null");
/*      */     }
/* 1598 */     for (File file : paramIterable) {
/* 1599 */       copyFileToDirectory(file, paramFile);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void deleteDirectory(File paramFile) {
/* 1612 */     if (!paramFile.exists()) {
/*      */       return;
/*      */     }
/*      */     
/* 1616 */     if (!isSymlink(paramFile)) {
/* 1617 */       cleanDirectory(paramFile);
/*      */     }
/*      */     
/* 1620 */     if (!paramFile.delete()) {
/* 1621 */       String str = "Unable to delete directory " + paramFile + ".";
/*      */       
/* 1623 */       throw new IOException(str);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean deleteQuietly(File paramFile) {
/* 1643 */     if (paramFile == null) {
/* 1644 */       return false;
/*      */     }
/*      */     try {
/* 1647 */       if (paramFile.isDirectory()) {
/* 1648 */         cleanDirectory(paramFile);
/*      */       }
/* 1650 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/*      */     try {
/* 1654 */       return paramFile.delete();
/* 1655 */     } catch (Exception exception) {
/* 1656 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean directoryContains(File paramFile1, File paramFile2) {
/* 1685 */     if (paramFile1 == null) {
/* 1686 */       throw new IllegalArgumentException("Directory must not be null");
/*      */     }
/*      */     
/* 1689 */     if (!paramFile1.isDirectory()) {
/* 1690 */       throw new IllegalArgumentException("Not a directory: " + paramFile1);
/*      */     }
/*      */     
/* 1693 */     if (paramFile2 == null) {
/* 1694 */       return false;
/*      */     }
/*      */     
/* 1697 */     if (!paramFile1.exists() || !paramFile2.exists()) {
/* 1698 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1702 */     String str1 = paramFile1.getCanonicalPath();
/* 1703 */     String str2 = paramFile2.getCanonicalPath();
/*      */     
/* 1705 */     return FilenameUtils.directoryContains(str1, str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void cleanDirectory(File paramFile) {
/* 1716 */     File[] arrayOfFile = verifiedListFiles(paramFile);
/*      */     
/* 1718 */     IOException iOException = null;
/* 1719 */     for (File file : arrayOfFile) {
/*      */       try {
/* 1721 */         forceDelete(file);
/* 1722 */       } catch (IOException iOException1) {
/* 1723 */         iOException = iOException1;
/*      */       } 
/*      */     } 
/*      */     
/* 1727 */     if (null != iOException) {
/* 1728 */       throw iOException;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static File[] verifiedListFiles(File paramFile) {
/* 1739 */     if (!paramFile.exists()) {
/* 1740 */       String str = paramFile + " does not exist";
/* 1741 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 1744 */     if (!paramFile.isDirectory()) {
/* 1745 */       String str = paramFile + " is not a directory";
/* 1746 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 1749 */     File[] arrayOfFile = paramFile.listFiles();
/* 1750 */     if (arrayOfFile == null) {
/* 1751 */       throw new IOException("Failed to list contents of " + paramFile);
/*      */     }
/* 1753 */     return arrayOfFile;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean waitFor(File paramFile, int paramInt) {
/* 1769 */     long l = System.currentTimeMillis() + paramInt * 1000L;
/* 1770 */     boolean bool = false;
/*      */     try {
/* 1772 */       while (!paramFile.exists()) {
/* 1773 */         long l1 = l - System.currentTimeMillis();
/* 1774 */         if (l1 < 0L) {
/* 1775 */           return false;
/*      */         }
/*      */         try {
/* 1778 */           Thread.sleep(Math.min(100L, l1));
/* 1779 */         } catch (InterruptedException interruptedException) {
/* 1780 */           bool = true;
/* 1781 */         } catch (Exception exception) {
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } finally {
/* 1786 */       if (bool) {
/* 1787 */         Thread.currentThread().interrupt();
/*      */       }
/*      */     } 
/* 1790 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String readFileToString(File paramFile, Charset paramCharset) {
/* 1805 */     try (FileInputStream null = openInputStream(paramFile)) {
/* 1806 */       return IOUtils.toString(fileInputStream, Charsets.toCharset(paramCharset));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String readFileToString(File paramFile, String paramString) {
/* 1822 */     return readFileToString(paramFile, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String readFileToString(File paramFile) {
/* 1838 */     return readFileToString(paramFile, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] readFileToByteArray(File paramFile) {
/* 1851 */     try (FileInputStream null = openInputStream(paramFile)) {
/* 1852 */       long l = paramFile.length();
/*      */       
/* 1854 */       return (l > 0L) ? IOUtils.toByteArray(fileInputStream, l) : IOUtils.toByteArray(fileInputStream);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(File paramFile, Charset paramCharset) {
/* 1869 */     try (FileInputStream null = openInputStream(paramFile)) {
/* 1870 */       return IOUtils.readLines(fileInputStream, Charsets.toCharset(paramCharset));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(File paramFile, String paramString) {
/* 1886 */     return readLines(paramFile, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static List<String> readLines(File paramFile) {
/* 1901 */     return readLines(paramFile, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(File paramFile, String paramString) {
/* 1936 */     FileInputStream fileInputStream = null;
/*      */     try {
/* 1938 */       fileInputStream = openInputStream(paramFile);
/* 1939 */       return IOUtils.lineIterator(fileInputStream, paramString);
/* 1940 */     } catch (IOException|RuntimeException iOException) {
/*      */       try {
/* 1942 */         if (fileInputStream != null) {
/* 1943 */           fileInputStream.close();
/*      */         }
/*      */       }
/* 1946 */       catch (IOException iOException1) {
/* 1947 */         iOException.addSuppressed(iOException1);
/*      */       } 
/* 1949 */       throw iOException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(File paramFile) {
/* 1963 */     return lineIterator(paramFile, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset) {
/* 1983 */     writeStringToFile(paramFile, paramString, paramCharset, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeStringToFile(File paramFile, String paramString1, String paramString2) {
/* 1999 */     writeStringToFile(paramFile, paramString1, paramString2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset, boolean paramBoolean) {
/* 2015 */     try (FileOutputStream null = openOutputStream(paramFile, paramBoolean)) {
/* 2016 */       IOUtils.write(paramString, fileOutputStream, paramCharset);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeStringToFile(File paramFile, String paramString1, String paramString2, boolean paramBoolean) {
/* 2035 */     writeStringToFile(paramFile, paramString1, Charsets.toCharset(paramString2), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void writeStringToFile(File paramFile, String paramString) {
/* 2048 */     writeStringToFile(paramFile, paramString, Charset.defaultCharset(), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void writeStringToFile(File paramFile, String paramString, boolean paramBoolean) {
/* 2064 */     writeStringToFile(paramFile, paramString, Charset.defaultCharset(), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(File paramFile, CharSequence paramCharSequence) {
/* 2078 */     write(paramFile, paramCharSequence, Charset.defaultCharset(), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, boolean paramBoolean) {
/* 2094 */     write(paramFile, paramCharSequence, Charset.defaultCharset(), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset) {
/* 2107 */     write(paramFile, paramCharSequence, paramCharset, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, String paramString) {
/* 2121 */     write(paramFile, paramCharSequence, paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset, boolean paramBoolean) {
/* 2137 */     String str = (paramCharSequence == null) ? null : paramCharSequence.toString();
/* 2138 */     writeStringToFile(paramFile, str, paramCharset, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(File paramFile, CharSequence paramCharSequence, String paramString, boolean paramBoolean) {
/* 2156 */     write(paramFile, paramCharSequence, Charsets.toCharset(paramString), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte) {
/* 2171 */     writeByteArrayToFile(paramFile, paramArrayOfbyte, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 2186 */     writeByteArrayToFile(paramFile, paramArrayOfbyte, 0, paramArrayOfbyte.length, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 2203 */     writeByteArrayToFile(paramFile, paramArrayOfbyte, paramInt1, paramInt2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 2222 */     try (FileOutputStream null = openOutputStream(paramFile, paramBoolean)) {
/* 2223 */       fileOutputStream.write(paramArrayOfbyte, paramInt1, paramInt2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection) {
/* 2244 */     writeLines(paramFile, paramString, paramCollection, null, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection, boolean paramBoolean) {
/* 2263 */     writeLines(paramFile, paramString, paramCollection, null, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection) {
/* 2277 */     writeLines(paramFile, null, paramCollection, null, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection, boolean paramBoolean) {
/* 2293 */     writeLines(paramFile, null, paramCollection, null, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2) {
/* 2314 */     writeLines(paramFile, paramString1, paramCollection, paramString2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2, boolean paramBoolean) {
/* 2334 */     try (BufferedOutputStream null = new BufferedOutputStream(openOutputStream(paramFile, paramBoolean))) {
/* 2335 */       IOUtils.writeLines(paramCollection, paramString2, bufferedOutputStream, paramString1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString) {
/* 2352 */     writeLines(paramFile, null, paramCollection, paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString, boolean paramBoolean) {
/* 2370 */     writeLines(paramFile, null, paramCollection, paramString, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void forceDelete(File paramFile) {
/* 2390 */     if (paramFile.isDirectory()) {
/* 2391 */       deleteDirectory(paramFile);
/*      */     } else {
/* 2393 */       boolean bool = paramFile.exists();
/* 2394 */       if (!paramFile.delete()) {
/* 2395 */         if (!bool) {
/* 2396 */           throw new FileNotFoundException("File does not exist: " + paramFile);
/*      */         }
/* 2398 */         String str = "Unable to delete file: " + paramFile;
/*      */         
/* 2400 */         throw new IOException(str);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void forceDeleteOnExit(File paramFile) {
/* 2414 */     if (paramFile.isDirectory()) {
/* 2415 */       deleteDirectoryOnExit(paramFile);
/*      */     } else {
/* 2417 */       paramFile.deleteOnExit();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void deleteDirectoryOnExit(File paramFile) {
/* 2429 */     if (!paramFile.exists()) {
/*      */       return;
/*      */     }
/*      */     
/* 2433 */     paramFile.deleteOnExit();
/* 2434 */     if (!isSymlink(paramFile)) {
/* 2435 */       cleanDirectoryOnExit(paramFile);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void cleanDirectoryOnExit(File paramFile) {
/* 2447 */     File[] arrayOfFile = verifiedListFiles(paramFile);
/*      */     
/* 2449 */     IOException iOException = null;
/* 2450 */     for (File file : arrayOfFile) {
/*      */       try {
/* 2452 */         forceDeleteOnExit(file);
/* 2453 */       } catch (IOException iOException1) {
/* 2454 */         iOException = iOException1;
/*      */       } 
/*      */     } 
/*      */     
/* 2458 */     if (null != iOException) {
/* 2459 */       throw iOException;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void forceMkdir(File paramFile) {
/* 2475 */     if (paramFile.exists()) {
/* 2476 */       if (!paramFile.isDirectory()) {
/* 2477 */         String str = "File " + paramFile + " exists and is not a directory. Unable to create directory.";
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2482 */         throw new IOException(str);
/*      */       }
/*      */     
/* 2485 */     } else if (!paramFile.mkdirs()) {
/*      */ 
/*      */       
/* 2488 */       if (!paramFile.isDirectory()) {
/* 2489 */         String str = "Unable to create directory " + paramFile;
/*      */         
/* 2491 */         throw new IOException(str);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void forceMkdirParent(File paramFile) {
/* 2507 */     File file = paramFile.getParentFile();
/* 2508 */     if (file == null) {
/*      */       return;
/*      */     }
/* 2511 */     forceMkdir(file);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long sizeOf(File paramFile) {
/* 2539 */     if (!paramFile.exists()) {
/* 2540 */       String str = paramFile + " does not exist";
/* 2541 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 2544 */     if (paramFile.isDirectory()) {
/* 2545 */       return sizeOfDirectory0(paramFile);
/*      */     }
/* 2547 */     return paramFile.length();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigInteger sizeOfAsBigInteger(File paramFile) {
/* 2572 */     if (!paramFile.exists()) {
/* 2573 */       String str = paramFile + " does not exist";
/* 2574 */       throw new IllegalArgumentException(str);
/*      */     } 
/*      */     
/* 2577 */     if (paramFile.isDirectory()) {
/* 2578 */       return sizeOfDirectoryBig0(paramFile);
/*      */     }
/* 2580 */     return BigInteger.valueOf(paramFile.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long sizeOfDirectory(File paramFile) {
/* 2598 */     checkDirectory(paramFile);
/* 2599 */     return sizeOfDirectory0(paramFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long sizeOfDirectory0(File paramFile) {
/* 2610 */     File[] arrayOfFile = paramFile.listFiles();
/* 2611 */     if (arrayOfFile == null) {
/* 2612 */       return 0L;
/*      */     }
/* 2614 */     long l = 0L;
/*      */     
/* 2616 */     for (File file : arrayOfFile) {
/*      */       try {
/* 2618 */         if (!isSymlink(file)) {
/* 2619 */           l += sizeOf0(file);
/* 2620 */           if (l < 0L) {
/*      */             break;
/*      */           }
/*      */         } 
/* 2624 */       } catch (IOException iOException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2629 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long sizeOf0(File paramFile) {
/* 2640 */     if (paramFile.isDirectory()) {
/* 2641 */       return sizeOfDirectory0(paramFile);
/*      */     }
/* 2643 */     return paramFile.length();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigInteger sizeOfDirectoryAsBigInteger(File paramFile) {
/* 2656 */     checkDirectory(paramFile);
/* 2657 */     return sizeOfDirectoryBig0(paramFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static BigInteger sizeOfDirectoryBig0(File paramFile) {
/* 2669 */     File[] arrayOfFile = paramFile.listFiles();
/* 2670 */     if (arrayOfFile == null) {
/* 2671 */       return BigInteger.ZERO;
/*      */     }
/* 2673 */     BigInteger bigInteger = BigInteger.ZERO;
/*      */     
/* 2675 */     for (File file : arrayOfFile) {
/*      */       try {
/* 2677 */         if (!isSymlink(file)) {
/* 2678 */           bigInteger = bigInteger.add(sizeOfBig0(file));
/*      */         }
/* 2680 */       } catch (IOException iOException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2685 */     return bigInteger;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static BigInteger sizeOfBig0(File paramFile) {
/* 2696 */     if (paramFile.isDirectory()) {
/* 2697 */       return sizeOfDirectoryBig0(paramFile);
/*      */     }
/* 2699 */     return BigInteger.valueOf(paramFile.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkDirectory(File paramFile) {
/* 2710 */     if (!paramFile.exists()) {
/* 2711 */       throw new IllegalArgumentException(paramFile + " does not exist");
/*      */     }
/* 2713 */     if (!paramFile.isDirectory()) {
/* 2714 */       throw new IllegalArgumentException(paramFile + " is not a directory");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFileNewer(File paramFile1, File paramFile2) {
/* 2733 */     if (paramFile2 == null) {
/* 2734 */       throw new IllegalArgumentException("No specified reference file");
/*      */     }
/* 2736 */     if (!paramFile2.exists()) {
/* 2737 */       throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
/*      */     }
/*      */     
/* 2740 */     return isFileNewer(paramFile1, paramFile2.lastModified());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFileNewer(File paramFile, Date paramDate) {
/* 2756 */     if (paramDate == null) {
/* 2757 */       throw new IllegalArgumentException("No specified date");
/*      */     }
/* 2759 */     return isFileNewer(paramFile, paramDate.getTime());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFileNewer(File paramFile, long paramLong) {
/* 2775 */     if (paramFile == null) {
/* 2776 */       throw new IllegalArgumentException("No specified file");
/*      */     }
/* 2778 */     if (!paramFile.exists()) {
/* 2779 */       return false;
/*      */     }
/* 2781 */     return (paramFile.lastModified() > paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFileOlder(File paramFile1, File paramFile2) {
/* 2800 */     if (paramFile2 == null) {
/* 2801 */       throw new IllegalArgumentException("No specified reference file");
/*      */     }
/* 2803 */     if (!paramFile2.exists()) {
/* 2804 */       throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
/*      */     }
/*      */     
/* 2807 */     return isFileOlder(paramFile1, paramFile2.lastModified());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFileOlder(File paramFile, Date paramDate) {
/* 2823 */     if (paramDate == null) {
/* 2824 */       throw new IllegalArgumentException("No specified date");
/*      */     }
/* 2826 */     return isFileOlder(paramFile, paramDate.getTime());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFileOlder(File paramFile, long paramLong) {
/* 2842 */     if (paramFile == null) {
/* 2843 */       throw new IllegalArgumentException("No specified file");
/*      */     }
/* 2845 */     if (!paramFile.exists()) {
/* 2846 */       return false;
/*      */     }
/* 2848 */     return (paramFile.lastModified() < paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long checksumCRC32(File paramFile) {
/* 2864 */     CRC32 cRC32 = new CRC32();
/* 2865 */     checksum(paramFile, cRC32);
/* 2866 */     return cRC32.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Checksum checksum(File paramFile, Checksum paramChecksum) {
/* 2887 */     if (paramFile.isDirectory()) {
/* 2888 */       throw new IllegalArgumentException("Checksums can't be computed on directories");
/*      */     }
/* 2890 */     try (CheckedInputStream null = new CheckedInputStream(new FileInputStream(paramFile), paramChecksum)) {
/* 2891 */       IOUtils.copy(checkedInputStream, (OutputStream)new NullOutputStream());
/*      */     } 
/* 2893 */     return paramChecksum;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void moveDirectory(File paramFile1, File paramFile2) {
/* 2910 */     if (paramFile1 == null) {
/* 2911 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 2913 */     if (paramFile2 == null) {
/* 2914 */       throw new NullPointerException("Destination must not be null");
/*      */     }
/* 2916 */     if (!paramFile1.exists()) {
/* 2917 */       throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
/*      */     }
/* 2919 */     if (!paramFile1.isDirectory()) {
/* 2920 */       throw new IOException("Source '" + paramFile1 + "' is not a directory");
/*      */     }
/* 2922 */     if (paramFile2.exists()) {
/* 2923 */       throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
/*      */     }
/* 2925 */     boolean bool = paramFile1.renameTo(paramFile2);
/* 2926 */     if (!bool) {
/* 2927 */       if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath() + File.separator)) {
/* 2928 */         throw new IOException("Cannot move directory: " + paramFile1 + " to a subdirectory of itself: " + paramFile2);
/*      */       }
/* 2930 */       copyDirectory(paramFile1, paramFile2);
/* 2931 */       deleteDirectory(paramFile1);
/* 2932 */       if (paramFile1.exists()) {
/* 2933 */         throw new IOException("Failed to delete original directory '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void moveDirectoryToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) {
/* 2954 */     if (paramFile1 == null) {
/* 2955 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 2957 */     if (paramFile2 == null) {
/* 2958 */       throw new NullPointerException("Destination directory must not be null");
/*      */     }
/* 2960 */     if (!paramFile2.exists() && paramBoolean) {
/* 2961 */       paramFile2.mkdirs();
/*      */     }
/* 2963 */     if (!paramFile2.exists()) {
/* 2964 */       throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
/*      */     }
/*      */     
/* 2967 */     if (!paramFile2.isDirectory()) {
/* 2968 */       throw new IOException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/* 2970 */     moveDirectory(paramFile1, new File(paramFile2, paramFile1.getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void moveFile(File paramFile1, File paramFile2) {
/* 2988 */     if (paramFile1 == null) {
/* 2989 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 2991 */     if (paramFile2 == null) {
/* 2992 */       throw new NullPointerException("Destination must not be null");
/*      */     }
/* 2994 */     if (!paramFile1.exists()) {
/* 2995 */       throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
/*      */     }
/* 2997 */     if (paramFile1.isDirectory()) {
/* 2998 */       throw new IOException("Source '" + paramFile1 + "' is a directory");
/*      */     }
/* 3000 */     if (paramFile2.exists()) {
/* 3001 */       throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
/*      */     }
/* 3003 */     if (paramFile2.isDirectory()) {
/* 3004 */       throw new IOException("Destination '" + paramFile2 + "' is a directory");
/*      */     }
/* 3006 */     boolean bool = paramFile1.renameTo(paramFile2);
/* 3007 */     if (!bool) {
/* 3008 */       copyFile(paramFile1, paramFile2);
/* 3009 */       if (!paramFile1.delete()) {
/* 3010 */         deleteQuietly(paramFile2);
/* 3011 */         throw new IOException("Failed to delete original file '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void moveFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) {
/* 3032 */     if (paramFile1 == null) {
/* 3033 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 3035 */     if (paramFile2 == null) {
/* 3036 */       throw new NullPointerException("Destination directory must not be null");
/*      */     }
/* 3038 */     if (!paramFile2.exists() && paramBoolean) {
/* 3039 */       paramFile2.mkdirs();
/*      */     }
/* 3041 */     if (!paramFile2.exists()) {
/* 3042 */       throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
/*      */     }
/*      */     
/* 3045 */     if (!paramFile2.isDirectory()) {
/* 3046 */       throw new IOException("Destination '" + paramFile2 + "' is not a directory");
/*      */     }
/* 3048 */     moveFile(paramFile1, new File(paramFile2, paramFile1.getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void moveToDirectory(File paramFile1, File paramFile2, boolean paramBoolean) {
/* 3068 */     if (paramFile1 == null) {
/* 3069 */       throw new NullPointerException("Source must not be null");
/*      */     }
/* 3071 */     if (paramFile2 == null) {
/* 3072 */       throw new NullPointerException("Destination must not be null");
/*      */     }
/* 3074 */     if (!paramFile1.exists()) {
/* 3075 */       throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
/*      */     }
/* 3077 */     if (paramFile1.isDirectory()) {
/* 3078 */       moveDirectoryToDirectory(paramFile1, paramFile2, paramBoolean);
/*      */     } else {
/* 3080 */       moveFileToDirectory(paramFile1, paramFile2, paramBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSymlink(File paramFile) {
/* 3104 */     if (paramFile == null) {
/* 3105 */       throw new NullPointerException("File must not be null");
/*      */     }
/* 3107 */     return Files.isSymbolicLink(paramFile.toPath());
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/FileUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */