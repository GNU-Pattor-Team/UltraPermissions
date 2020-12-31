/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Stack;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FilenameUtils
/*      */ {
/*      */   private static final int NOT_FOUND = -1;
/*      */   public static final char EXTENSION_SEPARATOR = '.';
/*   96 */   public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final char UNIX_SEPARATOR = '/';
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final char WINDOWS_SEPARATOR = '\\';
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  111 */   private static final char SYSTEM_SEPARATOR = File.separatorChar;
/*      */ 
/*      */   
/*      */   private static final char OTHER_SEPARATOR;
/*      */ 
/*      */   
/*      */   static {
/*  118 */     if (isSystemWindows()) {
/*  119 */       OTHER_SEPARATOR = '/';
/*      */     } else {
/*  121 */       OTHER_SEPARATOR = '\\';
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
/*      */   static boolean isSystemWindows() {
/*  139 */     return (SYSTEM_SEPARATOR == '\\');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isSeparator(char paramChar) {
/*  150 */     return (paramChar == '/' || paramChar == '\\');
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
/*      */   public static String normalize(String paramString) {
/*  195 */     return doNormalize(paramString, SYSTEM_SEPARATOR, true);
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
/*      */   public static String normalize(String paramString, boolean paramBoolean) {
/*  242 */     byte b = paramBoolean ? 47 : 92;
/*  243 */     return doNormalize(paramString, b, true);
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
/*      */   public static String normalizeNoEndSeparator(String paramString) {
/*  289 */     return doNormalize(paramString, SYSTEM_SEPARATOR, false);
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
/*      */   public static String normalizeNoEndSeparator(String paramString, boolean paramBoolean) {
/*  336 */     byte b = paramBoolean ? 47 : 92;
/*  337 */     return doNormalize(paramString, b, false);
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
/*      */   private static String doNormalize(String paramString, char paramChar, boolean paramBoolean) {
/*  349 */     if (paramString == null) {
/*  350 */       return null;
/*      */     }
/*      */     
/*  353 */     failIfNullBytePresent(paramString);
/*      */     
/*  355 */     int i = paramString.length();
/*  356 */     if (i == 0) {
/*  357 */       return paramString;
/*      */     }
/*  359 */     int j = getPrefixLength(paramString);
/*  360 */     if (j < 0) {
/*  361 */       return null;
/*      */     }
/*      */     
/*  364 */     char[] arrayOfChar = new char[i + 2];
/*  365 */     paramString.getChars(0, paramString.length(), arrayOfChar, 0);
/*      */ 
/*      */     
/*  368 */     char c = (paramChar == SYSTEM_SEPARATOR) ? OTHER_SEPARATOR : SYSTEM_SEPARATOR; byte b;
/*  369 */     for (b = 0; b < arrayOfChar.length; b++) {
/*  370 */       if (arrayOfChar[b] == c) {
/*  371 */         arrayOfChar[b] = paramChar;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  376 */     b = 1;
/*  377 */     if (arrayOfChar[i - 1] != paramChar) {
/*  378 */       arrayOfChar[i++] = paramChar;
/*  379 */       b = 0;
/*      */     } 
/*      */     
/*      */     int k;
/*  383 */     for (k = j + 1; k < i; k++) {
/*  384 */       if (arrayOfChar[k] == paramChar && arrayOfChar[k - 1] == paramChar) {
/*  385 */         System.arraycopy(arrayOfChar, k, arrayOfChar, k - 1, i - k);
/*  386 */         i--;
/*  387 */         k--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  392 */     for (k = j + 1; k < i; k++) {
/*  393 */       if (arrayOfChar[k] == paramChar && arrayOfChar[k - 1] == '.' && (k == j + 1 || arrayOfChar[k - 2] == paramChar)) {
/*      */         
/*  395 */         if (k == i - 1) {
/*  396 */           b = 1;
/*      */         }
/*  398 */         System.arraycopy(arrayOfChar, k + 1, arrayOfChar, k - 1, i - k);
/*  399 */         i -= 2;
/*  400 */         k--;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  406 */     for (k = j + 2; k < i; k++) {
/*  407 */       if (arrayOfChar[k] == paramChar && arrayOfChar[k - 1] == '.' && arrayOfChar[k - 2] == '.' && (k == j + 2 || arrayOfChar[k - 3] == paramChar)) {
/*      */         
/*  409 */         if (k == j + 2) {
/*  410 */           return null;
/*      */         }
/*  412 */         if (k == i - 1) {
/*  413 */           b = 1;
/*      */         }
/*      */         
/*  416 */         int m = k - 4; while (true) { if (m >= j) {
/*  417 */             if (arrayOfChar[m] == paramChar) {
/*      */               
/*  419 */               System.arraycopy(arrayOfChar, k + 1, arrayOfChar, m + 1, i - k);
/*  420 */               i -= k - m;
/*  421 */               k = m + 1; break;
/*      */             } 
/*      */             m--;
/*      */             continue;
/*      */           } 
/*  426 */           System.arraycopy(arrayOfChar, k + 1, arrayOfChar, j, i - k);
/*  427 */           i -= k + 1 - j;
/*  428 */           k = j + 1; break; }
/*      */       
/*      */       } 
/*      */     } 
/*  432 */     if (i <= 0) {
/*  433 */       return "";
/*      */     }
/*  435 */     if (i <= j) {
/*  436 */       return new String(arrayOfChar, 0, i);
/*      */     }
/*  438 */     if (b != 0 && paramBoolean) {
/*  439 */       return new String(arrayOfChar, 0, i);
/*      */     }
/*  441 */     return new String(arrayOfChar, 0, i - 1);
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
/*      */   public static String concat(String paramString1, String paramString2) {
/*  486 */     int i = getPrefixLength(paramString2);
/*  487 */     if (i < 0) {
/*  488 */       return null;
/*      */     }
/*  490 */     if (i > 0) {
/*  491 */       return normalize(paramString2);
/*      */     }
/*  493 */     if (paramString1 == null) {
/*  494 */       return null;
/*      */     }
/*  496 */     int j = paramString1.length();
/*  497 */     if (j == 0) {
/*  498 */       return normalize(paramString2);
/*      */     }
/*  500 */     char c = paramString1.charAt(j - 1);
/*  501 */     if (isSeparator(c)) {
/*  502 */       return normalize(paramString1 + paramString2);
/*      */     }
/*  504 */     return normalize(paramString1 + '/' + paramString2);
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
/*      */   public static boolean directoryContains(String paramString1, String paramString2) {
/*  535 */     if (paramString1 == null) {
/*  536 */       throw new IllegalArgumentException("Directory must not be null");
/*      */     }
/*      */     
/*  539 */     if (paramString2 == null) {
/*  540 */       return false;
/*      */     }
/*      */     
/*  543 */     if (IOCase.SYSTEM.checkEquals(paramString1, paramString2)) {
/*  544 */       return false;
/*      */     }
/*      */     
/*  547 */     return IOCase.SYSTEM.checkStartsWith(paramString2, paramString1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String separatorsToUnix(String paramString) {
/*  558 */     if (paramString == null || paramString.indexOf('\\') == -1) {
/*  559 */       return paramString;
/*      */     }
/*  561 */     return paramString.replace('\\', '/');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String separatorsToWindows(String paramString) {
/*  571 */     if (paramString == null || paramString.indexOf('/') == -1) {
/*  572 */       return paramString;
/*      */     }
/*  574 */     return paramString.replace('/', '\\');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String separatorsToSystem(String paramString) {
/*  584 */     if (paramString == null) {
/*  585 */       return null;
/*      */     }
/*  587 */     if (isSystemWindows()) {
/*  588 */       return separatorsToWindows(paramString);
/*      */     }
/*  590 */     return separatorsToUnix(paramString);
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
/*      */   public static int getPrefixLength(String paramString) {
/*  634 */     if (paramString == null) {
/*  635 */       return -1;
/*      */     }
/*  637 */     int i = paramString.length();
/*  638 */     if (i == 0) {
/*  639 */       return 0;
/*      */     }
/*  641 */     char c1 = paramString.charAt(0);
/*  642 */     if (c1 == ':') {
/*  643 */       return -1;
/*      */     }
/*  645 */     if (i == 1) {
/*  646 */       if (c1 == '~') {
/*  647 */         return 2;
/*      */       }
/*  649 */       return isSeparator(c1) ? 1 : 0;
/*      */     } 
/*  651 */     if (c1 == '~') {
/*  652 */       int j = paramString.indexOf('/', 1);
/*  653 */       int k = paramString.indexOf('\\', 1);
/*  654 */       if (j == -1 && k == -1) {
/*  655 */         return i + 1;
/*      */       }
/*  657 */       j = (j == -1) ? k : j;
/*  658 */       k = (k == -1) ? j : k;
/*  659 */       return Math.min(j, k) + 1;
/*      */     } 
/*  661 */     char c2 = paramString.charAt(1);
/*  662 */     if (c2 == ':') {
/*  663 */       c1 = Character.toUpperCase(c1);
/*  664 */       if (c1 >= 'A' && c1 <= 'Z') {
/*  665 */         if (i == 2 || !isSeparator(paramString.charAt(2))) {
/*  666 */           return 2;
/*      */         }
/*  668 */         return 3;
/*  669 */       }  if (c1 == '/') {
/*  670 */         return 1;
/*      */       }
/*  672 */       return -1;
/*      */     } 
/*  674 */     if (isSeparator(c1) && isSeparator(c2)) {
/*  675 */       int j = paramString.indexOf('/', 2);
/*  676 */       int k = paramString.indexOf('\\', 2);
/*  677 */       if ((j == -1 && k == -1) || j == 2 || k == 2) {
/*  678 */         return -1;
/*      */       }
/*  680 */       j = (j == -1) ? k : j;
/*  681 */       k = (k == -1) ? j : k;
/*  682 */       return Math.min(j, k) + 1;
/*      */     } 
/*  684 */     return isSeparator(c1) ? 1 : 0;
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
/*      */   public static int indexOfLastSeparator(String paramString) {
/*  702 */     if (paramString == null) {
/*  703 */       return -1;
/*      */     }
/*  705 */     int i = paramString.lastIndexOf('/');
/*  706 */     int j = paramString.lastIndexOf('\\');
/*  707 */     return Math.max(i, j);
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
/*      */   public static int indexOfExtension(String paramString) {
/*  725 */     if (paramString == null) {
/*  726 */       return -1;
/*      */     }
/*  728 */     int i = paramString.lastIndexOf('.');
/*  729 */     int j = indexOfLastSeparator(paramString);
/*  730 */     return (j > i) ? -1 : i;
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
/*      */   public static String getPrefix(String paramString) {
/*  764 */     if (paramString == null) {
/*  765 */       return null;
/*      */     }
/*  767 */     int i = getPrefixLength(paramString);
/*  768 */     if (i < 0) {
/*  769 */       return null;
/*      */     }
/*  771 */     if (i > paramString.length()) {
/*  772 */       failIfNullBytePresent(paramString + '/');
/*  773 */       return paramString + '/';
/*      */     } 
/*  775 */     String str = paramString.substring(0, i);
/*  776 */     failIfNullBytePresent(str);
/*  777 */     return str;
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
/*      */   public static String getPath(String paramString) {
/*  804 */     return doGetPath(paramString, 1);
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
/*      */   public static String getPathNoEndSeparator(String paramString) {
/*  832 */     return doGetPath(paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String doGetPath(String paramString, int paramInt) {
/*  843 */     if (paramString == null) {
/*  844 */       return null;
/*      */     }
/*  846 */     int i = getPrefixLength(paramString);
/*  847 */     if (i < 0) {
/*  848 */       return null;
/*      */     }
/*  850 */     int j = indexOfLastSeparator(paramString);
/*  851 */     int k = j + paramInt;
/*  852 */     if (i >= paramString.length() || j < 0 || i >= k) {
/*  853 */       return "";
/*      */     }
/*  855 */     String str = paramString.substring(i, k);
/*  856 */     failIfNullBytePresent(str);
/*  857 */     return str;
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
/*      */   public static String getFullPath(String paramString) {
/*  886 */     return doGetFullPath(paramString, true);
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
/*      */   public static String getFullPathNoEndSeparator(String paramString) {
/*  916 */     return doGetFullPath(paramString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String doGetFullPath(String paramString, boolean paramBoolean) {
/*  927 */     if (paramString == null) {
/*  928 */       return null;
/*      */     }
/*  930 */     int i = getPrefixLength(paramString);
/*  931 */     if (i < 0) {
/*  932 */       return null;
/*      */     }
/*  934 */     if (i >= paramString.length()) {
/*  935 */       if (paramBoolean) {
/*  936 */         return getPrefix(paramString);
/*      */       }
/*  938 */       return paramString;
/*      */     } 
/*      */     
/*  941 */     int j = indexOfLastSeparator(paramString);
/*  942 */     if (j < 0) {
/*  943 */       return paramString.substring(0, i);
/*      */     }
/*  945 */     int k = j + (paramBoolean ? 1 : 0);
/*  946 */     if (k == 0) {
/*  947 */       k++;
/*      */     }
/*  949 */     return paramString.substring(0, k);
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
/*      */   public static String getName(String paramString) {
/*  971 */     if (paramString == null) {
/*  972 */       return null;
/*      */     }
/*  974 */     failIfNullBytePresent(paramString);
/*  975 */     int i = indexOfLastSeparator(paramString);
/*  976 */     return paramString.substring(i + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void failIfNullBytePresent(String paramString) {
/*  986 */     int i = paramString.length();
/*  987 */     for (byte b = 0; b < i; b++) {
/*  988 */       if (paramString.charAt(b) == '\000') {
/*  989 */         throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
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
/*      */   public static String getBaseName(String paramString) {
/* 1014 */     return removeExtension(getName(paramString));
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
/*      */   public static String getExtension(String paramString) {
/* 1036 */     if (paramString == null) {
/* 1037 */       return null;
/*      */     }
/* 1039 */     int i = indexOfExtension(paramString);
/* 1040 */     if (i == -1) {
/* 1041 */       return "";
/*      */     }
/* 1043 */     return paramString.substring(i + 1);
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
/*      */   public static String removeExtension(String paramString) {
/* 1066 */     if (paramString == null) {
/* 1067 */       return null;
/*      */     }
/* 1069 */     failIfNullBytePresent(paramString);
/*      */     
/* 1071 */     int i = indexOfExtension(paramString);
/* 1072 */     if (i == -1) {
/* 1073 */       return paramString;
/*      */     }
/* 1075 */     return paramString.substring(0, i);
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
/*      */   public static boolean equals(String paramString1, String paramString2) {
/* 1092 */     return equals(paramString1, paramString2, false, IOCase.SENSITIVE);
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
/*      */   public static boolean equalsOnSystem(String paramString1, String paramString2) {
/* 1107 */     return equals(paramString1, paramString2, false, IOCase.SYSTEM);
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
/*      */   public static boolean equalsNormalized(String paramString1, String paramString2) {
/* 1123 */     return equals(paramString1, paramString2, true, IOCase.SENSITIVE);
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
/*      */   public static boolean equalsNormalizedOnSystem(String paramString1, String paramString2) {
/* 1140 */     return equals(paramString1, paramString2, true, IOCase.SYSTEM);
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
/*      */   public static boolean equals(String paramString1, String paramString2, boolean paramBoolean, IOCase paramIOCase) {
/* 1158 */     if (paramString1 == null || paramString2 == null) {
/* 1159 */       return (paramString1 == null && paramString2 == null);
/*      */     }
/* 1161 */     if (paramBoolean) {
/* 1162 */       paramString1 = normalize(paramString1);
/* 1163 */       paramString2 = normalize(paramString2);
/* 1164 */       if (paramString1 == null || paramString2 == null) {
/* 1165 */         throw new NullPointerException("Error normalizing one or both of the file names");
/*      */       }
/*      */     } 
/*      */     
/* 1169 */     if (paramIOCase == null) {
/* 1170 */       paramIOCase = IOCase.SENSITIVE;
/*      */     }
/* 1172 */     return paramIOCase.checkEquals(paramString1, paramString2);
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
/*      */   public static boolean isExtension(String paramString1, String paramString2) {
/* 1189 */     if (paramString1 == null) {
/* 1190 */       return false;
/*      */     }
/* 1192 */     failIfNullBytePresent(paramString1);
/*      */     
/* 1194 */     if (paramString2 == null || paramString2.isEmpty()) {
/* 1195 */       return (indexOfExtension(paramString1) == -1);
/*      */     }
/* 1197 */     String str = getExtension(paramString1);
/* 1198 */     return str.equals(paramString2);
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
/*      */   public static boolean isExtension(String paramString, String[] paramArrayOfString) {
/* 1214 */     if (paramString == null) {
/* 1215 */       return false;
/*      */     }
/* 1217 */     failIfNullBytePresent(paramString);
/*      */     
/* 1219 */     if (paramArrayOfString == null || paramArrayOfString.length == 0) {
/* 1220 */       return (indexOfExtension(paramString) == -1);
/*      */     }
/* 1222 */     String str = getExtension(paramString);
/* 1223 */     for (String str1 : paramArrayOfString) {
/* 1224 */       if (str.equals(str1)) {
/* 1225 */         return true;
/*      */       }
/*      */     } 
/* 1228 */     return false;
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
/*      */   public static boolean isExtension(String paramString, Collection<String> paramCollection) {
/* 1244 */     if (paramString == null) {
/* 1245 */       return false;
/*      */     }
/* 1247 */     failIfNullBytePresent(paramString);
/*      */     
/* 1249 */     if (paramCollection == null || paramCollection.isEmpty()) {
/* 1250 */       return (indexOfExtension(paramString) == -1);
/*      */     }
/* 1252 */     String str = getExtension(paramString);
/* 1253 */     for (String str1 : paramCollection) {
/* 1254 */       if (str.equals(str1)) {
/* 1255 */         return true;
/*      */       }
/*      */     } 
/* 1258 */     return false;
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
/*      */   public static boolean wildcardMatch(String paramString1, String paramString2) {
/* 1285 */     return wildcardMatch(paramString1, paramString2, IOCase.SENSITIVE);
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
/*      */   public static boolean wildcardMatchOnSystem(String paramString1, String paramString2) {
/* 1311 */     return wildcardMatch(paramString1, paramString2, IOCase.SYSTEM);
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
/*      */   public static boolean wildcardMatch(String paramString1, String paramString2, IOCase paramIOCase) {
/* 1329 */     if (paramString1 == null && paramString2 == null) {
/* 1330 */       return true;
/*      */     }
/* 1332 */     if (paramString1 == null || paramString2 == null) {
/* 1333 */       return false;
/*      */     }
/* 1335 */     if (paramIOCase == null) {
/* 1336 */       paramIOCase = IOCase.SENSITIVE;
/*      */     }
/* 1338 */     String[] arrayOfString = splitOnTokens(paramString2);
/* 1339 */     boolean bool = false;
/* 1340 */     int i = 0;
/* 1341 */     int j = 0;
/* 1342 */     Stack<int[]> stack = new Stack();
/*      */ 
/*      */     
/*      */     do {
/* 1346 */       if (stack.size() > 0) {
/* 1347 */         int[] arrayOfInt = stack.pop();
/* 1348 */         j = arrayOfInt[0];
/* 1349 */         i = arrayOfInt[1];
/* 1350 */         bool = true;
/*      */       } 
/*      */ 
/*      */       
/* 1354 */       while (j < arrayOfString.length) {
/*      */         
/* 1356 */         if (arrayOfString[j].equals("?")) {
/*      */           
/* 1358 */           i++;
/* 1359 */           if (i > paramString1.length()) {
/*      */             break;
/*      */           }
/* 1362 */           bool = false;
/*      */         }
/* 1364 */         else if (arrayOfString[j].equals("*")) {
/*      */           
/* 1366 */           bool = true;
/* 1367 */           if (j == arrayOfString.length - 1) {
/* 1368 */             i = paramString1.length();
/*      */           }
/*      */         }
/*      */         else {
/*      */           
/* 1373 */           if (bool) {
/*      */             
/* 1375 */             i = paramIOCase.checkIndexOf(paramString1, i, arrayOfString[j]);
/* 1376 */             if (i == -1) {
/*      */               break;
/*      */             }
/*      */             
/* 1380 */             int k = paramIOCase.checkIndexOf(paramString1, i + 1, arrayOfString[j]);
/* 1381 */             if (k >= 0) {
/* 1382 */               stack.push(new int[] { j, k });
/*      */             
/*      */             }
/*      */           }
/* 1386 */           else if (!paramIOCase.checkRegionMatches(paramString1, i, arrayOfString[j])) {
/*      */             break;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1393 */           i += arrayOfString[j].length();
/* 1394 */           bool = false;
/*      */         } 
/*      */         
/* 1397 */         j++;
/*      */       } 
/*      */ 
/*      */       
/* 1401 */       if (j == arrayOfString.length && i == paramString1.length()) {
/* 1402 */         return true;
/*      */       }
/*      */     }
/* 1405 */     while (stack.size() > 0);
/*      */     
/* 1407 */     return false;
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
/*      */   static String[] splitOnTokens(String paramString) {
/* 1422 */     if (paramString.indexOf('?') == -1 && paramString.indexOf('*') == -1) {
/* 1423 */       return new String[] { paramString };
/*      */     }
/*      */     
/* 1426 */     char[] arrayOfChar = paramString.toCharArray();
/* 1427 */     ArrayList<String> arrayList = new ArrayList();
/* 1428 */     StringBuilder stringBuilder = new StringBuilder();
/* 1429 */     char c = Character.MIN_VALUE;
/* 1430 */     for (char c1 : arrayOfChar) {
/* 1431 */       if (c1 == '?' || c1 == '*') {
/* 1432 */         if (stringBuilder.length() != 0) {
/* 1433 */           arrayList.add(stringBuilder.toString());
/* 1434 */           stringBuilder.setLength(0);
/*      */         } 
/* 1436 */         if (c1 == '?') {
/* 1437 */           arrayList.add("?");
/* 1438 */         } else if (c != '*') {
/* 1439 */           arrayList.add("*");
/*      */         } 
/*      */       } else {
/* 1442 */         stringBuilder.append(c1);
/*      */       } 
/* 1444 */       c = c1;
/*      */     } 
/* 1446 */     if (stringBuilder.length() != 0) {
/* 1447 */       arrayList.add(stringBuilder.toString());
/*      */     }
/*      */     
/* 1450 */     return arrayList.<String>toArray(new String[arrayList.size()]);
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/FilenameUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */