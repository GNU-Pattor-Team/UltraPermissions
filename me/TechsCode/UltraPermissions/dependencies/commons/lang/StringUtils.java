/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.text.StrBuilder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StringUtils
/*      */ {
/*      */   public static final String EMPTY = "";
/*      */   public static final int INDEX_NOT_FOUND = -1;
/*      */   private static final int PAD_LIMIT = 8192;
/*      */   
/*      */   public static boolean isEmpty(String paramString) {
/*  195 */     return (paramString == null || paramString.length() == 0);
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
/*      */   public static boolean isNotEmpty(String paramString) {
/*  213 */     return !isEmpty(paramString);
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
/*      */   public static boolean isBlank(String paramString) {
/*      */     int i;
/*  233 */     if (paramString == null || (i = paramString.length()) == 0) {
/*  234 */       return true;
/*      */     }
/*  236 */     for (byte b = 0; b < i; b++) {
/*  237 */       if (!Character.isWhitespace(paramString.charAt(b))) {
/*  238 */         return false;
/*      */       }
/*      */     } 
/*  241 */     return true;
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
/*      */   public static boolean isNotBlank(String paramString) {
/*  261 */     return !isBlank(paramString);
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
/*      */   public static String clean(String paramString) {
/*  286 */     return (paramString == null) ? "" : paramString.trim();
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
/*      */   public static String trim(String paramString) {
/*  313 */     return (paramString == null) ? null : paramString.trim();
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
/*      */   public static String trimToNull(String paramString) {
/*  339 */     String str = trim(paramString);
/*  340 */     return isEmpty(str) ? null : str;
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
/*      */   public static String trimToEmpty(String paramString) {
/*  365 */     return (paramString == null) ? "" : paramString.trim();
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
/*      */   public static String strip(String paramString) {
/*  393 */     return strip(paramString, null);
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
/*      */   public static String stripToNull(String paramString) {
/*  420 */     if (paramString == null) {
/*  421 */       return null;
/*      */     }
/*  423 */     paramString = strip(paramString, null);
/*  424 */     return (paramString.length() == 0) ? null : paramString;
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
/*      */   public static String stripToEmpty(String paramString) {
/*  450 */     return (paramString == null) ? "" : strip(paramString, null);
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
/*      */   public static String strip(String paramString1, String paramString2) {
/*  480 */     if (isEmpty(paramString1)) {
/*  481 */       return paramString1;
/*      */     }
/*  483 */     paramString1 = stripStart(paramString1, paramString2);
/*  484 */     return stripEnd(paramString1, paramString2);
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
/*      */   public static String stripStart(String paramString1, String paramString2) {
/*      */     int i;
/*  513 */     if (paramString1 == null || (i = paramString1.length()) == 0) {
/*  514 */       return paramString1;
/*      */     }
/*  516 */     int j = 0;
/*  517 */     if (paramString2 == null) {
/*  518 */       while (j != i && Character.isWhitespace(paramString1.charAt(j)))
/*  519 */         j++; 
/*      */     } else {
/*  521 */       if (paramString2.length() == 0) {
/*  522 */         return paramString1;
/*      */       }
/*  524 */       while (j != i && paramString2.indexOf(paramString1.charAt(j)) != -1) {
/*  525 */         j++;
/*      */       }
/*      */     } 
/*  528 */     return paramString1.substring(j);
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
/*      */   public static String stripEnd(String paramString1, String paramString2) {
/*      */     int i;
/*  558 */     if (paramString1 == null || (i = paramString1.length()) == 0) {
/*  559 */       return paramString1;
/*      */     }
/*      */     
/*  562 */     if (paramString2 == null) {
/*  563 */       while (i != 0 && Character.isWhitespace(paramString1.charAt(i - 1)))
/*  564 */         i--; 
/*      */     } else {
/*  566 */       if (paramString2.length() == 0) {
/*  567 */         return paramString1;
/*      */       }
/*  569 */       while (i != 0 && paramString2.indexOf(paramString1.charAt(i - 1)) != -1) {
/*  570 */         i--;
/*      */       }
/*      */     } 
/*  573 */     return paramString1.substring(0, i);
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
/*      */   public static String[] stripAll(String[] paramArrayOfString) {
/*  598 */     return stripAll(paramArrayOfString, null);
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
/*      */   public static String[] stripAll(String[] paramArrayOfString, String paramString) {
/*      */     int i;
/*  628 */     if (paramArrayOfString == null || (i = paramArrayOfString.length) == 0) {
/*  629 */       return paramArrayOfString;
/*      */     }
/*  631 */     String[] arrayOfString = new String[i];
/*  632 */     for (byte b = 0; b < i; b++) {
/*  633 */       arrayOfString[b] = strip(paramArrayOfString[b], paramString);
/*      */     }
/*  635 */     return arrayOfString;
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
/*      */   public static boolean equals(String paramString1, String paramString2) {
/*  661 */     return (paramString1 == null) ? ((paramString2 == null)) : paramString1.equals(paramString2);
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
/*      */   public static boolean equalsIgnoreCase(String paramString1, String paramString2) {
/*  686 */     return (paramString1 == null) ? ((paramString2 == null)) : paramString1.equalsIgnoreCase(paramString2);
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
/*      */   public static int indexOf(String paramString, char paramChar) {
/*  711 */     if (isEmpty(paramString)) {
/*  712 */       return -1;
/*      */     }
/*  714 */     return paramString.indexOf(paramChar);
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
/*      */   public static int indexOf(String paramString, char paramChar, int paramInt) {
/*  743 */     if (isEmpty(paramString)) {
/*  744 */       return -1;
/*      */     }
/*  746 */     return paramString.indexOf(paramChar, paramInt);
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
/*      */   public static int indexOf(String paramString1, String paramString2) {
/*  773 */     if (paramString1 == null || paramString2 == null) {
/*  774 */       return -1;
/*      */     }
/*  776 */     return paramString1.indexOf(paramString2);
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
/*      */   public static int ordinalIndexOf(String paramString1, String paramString2, int paramInt) {
/*  813 */     return ordinalIndexOf(paramString1, paramString2, paramInt, false);
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
/*      */   private static int ordinalIndexOf(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
/*  831 */     if (paramString1 == null || paramString2 == null || paramInt <= 0) {
/*  832 */       return -1;
/*      */     }
/*  834 */     if (paramString2.length() == 0) {
/*  835 */       return paramBoolean ? paramString1.length() : 0;
/*      */     }
/*  837 */     byte b = 0;
/*  838 */     int i = paramBoolean ? paramString1.length() : -1;
/*      */     while (true) {
/*  840 */       if (paramBoolean) {
/*  841 */         i = paramString1.lastIndexOf(paramString2, i - 1);
/*      */       } else {
/*  843 */         i = paramString1.indexOf(paramString2, i + 1);
/*      */       } 
/*  845 */       if (i < 0) {
/*  846 */         return i;
/*      */       }
/*  848 */       b++;
/*  849 */       if (b >= paramInt) {
/*  850 */         return i;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(String paramString1, String paramString2, int paramInt) {
/*  886 */     if (paramString1 == null || paramString2 == null) {
/*  887 */       return -1;
/*      */     }
/*      */     
/*  890 */     if (paramString2.length() == 0 && paramInt >= paramString1.length()) {
/*  891 */       return paramString1.length();
/*      */     }
/*  893 */     return paramString1.indexOf(paramString2, paramInt);
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
/*      */   public static int indexOfIgnoreCase(String paramString1, String paramString2) {
/*  921 */     return indexOfIgnoreCase(paramString1, paramString2, 0);
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
/*      */   public static int indexOfIgnoreCase(String paramString1, String paramString2, int paramInt) {
/*  956 */     if (paramString1 == null || paramString2 == null) {
/*  957 */       return -1;
/*      */     }
/*  959 */     if (paramInt < 0) {
/*  960 */       paramInt = 0;
/*      */     }
/*  962 */     int i = paramString1.length() - paramString2.length() + 1;
/*  963 */     if (paramInt > i) {
/*  964 */       return -1;
/*      */     }
/*  966 */     if (paramString2.length() == 0) {
/*  967 */       return paramInt;
/*      */     }
/*  969 */     for (int j = paramInt; j < i; j++) {
/*  970 */       if (paramString1.regionMatches(true, j, paramString2, 0, paramString2.length())) {
/*  971 */         return j;
/*      */       }
/*      */     } 
/*  974 */     return -1;
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
/*      */   public static int lastIndexOf(String paramString, char paramChar) {
/*  999 */     if (isEmpty(paramString)) {
/* 1000 */       return -1;
/*      */     }
/* 1002 */     return paramString.lastIndexOf(paramChar);
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
/*      */   public static int lastIndexOf(String paramString, char paramChar, int paramInt) {
/* 1033 */     if (isEmpty(paramString)) {
/* 1034 */       return -1;
/*      */     }
/* 1036 */     return paramString.lastIndexOf(paramChar, paramInt);
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
/*      */   public static int lastIndexOf(String paramString1, String paramString2) {
/* 1062 */     if (paramString1 == null || paramString2 == null) {
/* 1063 */       return -1;
/*      */     }
/* 1065 */     return paramString1.lastIndexOf(paramString2);
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
/*      */   public static int lastOrdinalIndexOf(String paramString1, String paramString2, int paramInt) {
/* 1102 */     return ordinalIndexOf(paramString1, paramString2, paramInt, true);
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
/*      */   public static int lastIndexOf(String paramString1, String paramString2, int paramInt) {
/* 1134 */     if (paramString1 == null || paramString2 == null) {
/* 1135 */       return -1;
/*      */     }
/* 1137 */     return paramString1.lastIndexOf(paramString2, paramInt);
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
/*      */   public static int lastIndexOfIgnoreCase(String paramString1, String paramString2) {
/* 1163 */     if (paramString1 == null || paramString2 == null) {
/* 1164 */       return -1;
/*      */     }
/* 1166 */     return lastIndexOfIgnoreCase(paramString1, paramString2, paramString1.length());
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
/*      */   public static int lastIndexOfIgnoreCase(String paramString1, String paramString2, int paramInt) {
/* 1198 */     if (paramString1 == null || paramString2 == null) {
/* 1199 */       return -1;
/*      */     }
/* 1201 */     if (paramInt > paramString1.length() - paramString2.length()) {
/* 1202 */       paramInt = paramString1.length() - paramString2.length();
/*      */     }
/* 1204 */     if (paramInt < 0) {
/* 1205 */       return -1;
/*      */     }
/* 1207 */     if (paramString2.length() == 0) {
/* 1208 */       return paramInt;
/*      */     }
/*      */     
/* 1211 */     for (int i = paramInt; i >= 0; i--) {
/* 1212 */       if (paramString1.regionMatches(true, i, paramString2, 0, paramString2.length())) {
/* 1213 */         return i;
/*      */       }
/*      */     } 
/* 1216 */     return -1;
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
/*      */   public static boolean contains(String paramString, char paramChar) {
/* 1241 */     if (isEmpty(paramString)) {
/* 1242 */       return false;
/*      */     }
/* 1244 */     return (paramString.indexOf(paramChar) >= 0);
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
/*      */   public static boolean contains(String paramString1, String paramString2) {
/* 1269 */     if (paramString1 == null || paramString2 == null) {
/* 1270 */       return false;
/*      */     }
/* 1272 */     return (paramString1.indexOf(paramString2) >= 0);
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
/*      */   public static boolean containsIgnoreCase(String paramString1, String paramString2) {
/* 1299 */     if (paramString1 == null || paramString2 == null) {
/* 1300 */       return false;
/*      */     }
/* 1302 */     int i = paramString2.length();
/* 1303 */     int j = paramString1.length() - i;
/* 1304 */     for (byte b = 0; b <= j; b++) {
/* 1305 */       if (paramString1.regionMatches(true, b, paramString2, 0, i)) {
/* 1306 */         return true;
/*      */       }
/*      */     } 
/* 1309 */     return false;
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
/*      */   public static int indexOfAny(String paramString, char[] paramArrayOfchar) {
/* 1337 */     if (isEmpty(paramString) || ArrayUtils.isEmpty(paramArrayOfchar)) {
/* 1338 */       return -1;
/*      */     }
/* 1340 */     int i = paramString.length();
/* 1341 */     int j = i - 1;
/* 1342 */     int k = paramArrayOfchar.length;
/* 1343 */     int m = k - 1;
/* 1344 */     for (byte b = 0; b < i; b++) {
/* 1345 */       char c = paramString.charAt(b);
/* 1346 */       for (byte b1 = 0; b1 < k; b1++) {
/* 1347 */         if (paramArrayOfchar[b1] == c) {
/* 1348 */           if (b < j && b1 < m && CharUtils.isHighSurrogate(c)) {
/*      */             
/* 1350 */             if (paramArrayOfchar[b1 + 1] == paramString.charAt(b + 1)) {
/* 1351 */               return b;
/*      */             }
/*      */           } else {
/* 1354 */             return b;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1359 */     return -1;
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
/*      */   public static int indexOfAny(String paramString1, String paramString2) {
/* 1385 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 1386 */       return -1;
/*      */     }
/* 1388 */     return indexOfAny(paramString1, paramString2.toCharArray());
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
/*      */   public static boolean containsAny(String paramString, char[] paramArrayOfchar) {
/* 1417 */     if (isEmpty(paramString) || ArrayUtils.isEmpty(paramArrayOfchar)) {
/* 1418 */       return false;
/*      */     }
/* 1420 */     int i = paramString.length();
/* 1421 */     int j = paramArrayOfchar.length;
/* 1422 */     int k = i - 1;
/* 1423 */     int m = j - 1;
/* 1424 */     for (byte b = 0; b < i; b++) {
/* 1425 */       char c = paramString.charAt(b);
/* 1426 */       for (byte b1 = 0; b1 < j; b1++) {
/* 1427 */         if (paramArrayOfchar[b1] == c) {
/* 1428 */           if (CharUtils.isHighSurrogate(c)) {
/* 1429 */             if (b1 == m)
/*      */             {
/* 1431 */               return true;
/*      */             }
/* 1433 */             if (b < k && paramArrayOfchar[b1 + 1] == paramString.charAt(b + 1)) {
/* 1434 */               return true;
/*      */             }
/*      */           } else {
/*      */             
/* 1438 */             return true;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1443 */     return false;
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
/*      */   public static boolean containsAny(String paramString1, String paramString2) {
/* 1474 */     if (paramString2 == null) {
/* 1475 */       return false;
/*      */     }
/* 1477 */     return containsAny(paramString1, paramString2.toCharArray());
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
/*      */   public static int indexOfAnyBut(String paramString, char[] paramArrayOfchar) {
/* 1505 */     if (isEmpty(paramString) || ArrayUtils.isEmpty(paramArrayOfchar)) {
/* 1506 */       return -1;
/*      */     }
/* 1508 */     int i = paramString.length();
/* 1509 */     int j = i - 1;
/* 1510 */     int k = paramArrayOfchar.length;
/* 1511 */     int m = k - 1;
/*      */     
/* 1513 */     for (byte b = 0; b < i; b++) {
/* 1514 */       char c = paramString.charAt(b);
/* 1515 */       byte b1 = 0; while (true) { if (b1 < k) {
/* 1516 */           if (paramArrayOfchar[b1] == c && (
/* 1517 */             b >= j || b1 >= m || !CharUtils.isHighSurrogate(c) || 
/* 1518 */             paramArrayOfchar[b1 + 1] == paramString.charAt(b + 1))) {
/*      */             break;
/*      */           }
/*      */           
/*      */           b1++;
/*      */           
/*      */           continue;
/*      */         } 
/* 1526 */         return b; }
/*      */     
/* 1528 */     }  return -1;
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
/*      */   public static int indexOfAnyBut(String paramString1, String paramString2) {
/* 1554 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 1555 */       return -1;
/*      */     }
/* 1557 */     int i = paramString1.length();
/* 1558 */     for (byte b = 0; b < i; b++) {
/* 1559 */       char c = paramString1.charAt(b);
/* 1560 */       boolean bool = (paramString2.indexOf(c) >= 0) ? true : false;
/* 1561 */       if (b + 1 < i && CharUtils.isHighSurrogate(c)) {
/* 1562 */         char c1 = paramString1.charAt(b + 1);
/* 1563 */         if (bool && paramString2.indexOf(c1) < 0) {
/* 1564 */           return b;
/*      */         }
/*      */       }
/* 1567 */       else if (!bool) {
/* 1568 */         return b;
/*      */       } 
/*      */     } 
/*      */     
/* 1572 */     return -1;
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
/*      */   public static boolean containsOnly(String paramString, char[] paramArrayOfchar) {
/* 1600 */     if (paramArrayOfchar == null || paramString == null) {
/* 1601 */       return false;
/*      */     }
/* 1603 */     if (paramString.length() == 0) {
/* 1604 */       return true;
/*      */     }
/* 1606 */     if (paramArrayOfchar.length == 0) {
/* 1607 */       return false;
/*      */     }
/* 1609 */     return (indexOfAnyBut(paramString, paramArrayOfchar) == -1);
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
/*      */   public static boolean containsOnly(String paramString1, String paramString2) {
/* 1635 */     if (paramString1 == null || paramString2 == null) {
/* 1636 */       return false;
/*      */     }
/* 1638 */     return containsOnly(paramString1, paramString2.toCharArray());
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
/*      */   public static boolean containsNone(String paramString, char[] paramArrayOfchar) {
/* 1666 */     if (paramString == null || paramArrayOfchar == null) {
/* 1667 */       return true;
/*      */     }
/* 1669 */     int i = paramString.length();
/* 1670 */     int j = i - 1;
/* 1671 */     int k = paramArrayOfchar.length;
/* 1672 */     int m = k - 1;
/* 1673 */     for (byte b = 0; b < i; b++) {
/* 1674 */       char c = paramString.charAt(b);
/* 1675 */       for (byte b1 = 0; b1 < k; b1++) {
/* 1676 */         if (paramArrayOfchar[b1] == c) {
/* 1677 */           if (CharUtils.isHighSurrogate(c)) {
/* 1678 */             if (b1 == m)
/*      */             {
/* 1680 */               return false;
/*      */             }
/* 1682 */             if (b < j && paramArrayOfchar[b1 + 1] == paramString.charAt(b + 1)) {
/* 1683 */               return false;
/*      */             }
/*      */           } else {
/*      */             
/* 1687 */             return false;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1692 */     return true;
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
/*      */   public static boolean containsNone(String paramString1, String paramString2) {
/* 1718 */     if (paramString1 == null || paramString2 == null) {
/* 1719 */       return true;
/*      */     }
/* 1721 */     return containsNone(paramString1, paramString2.toCharArray());
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
/*      */   public static int indexOfAny(String paramString, String[] paramArrayOfString) {
/* 1753 */     if (paramString == null || paramArrayOfString == null) {
/* 1754 */       return -1;
/*      */     }
/* 1756 */     int i = paramArrayOfString.length;
/*      */ 
/*      */     
/* 1759 */     int j = Integer.MAX_VALUE;
/*      */     
/* 1761 */     int k = 0;
/* 1762 */     for (byte b = 0; b < i; b++) {
/* 1763 */       String str = paramArrayOfString[b];
/* 1764 */       if (str != null) {
/*      */ 
/*      */         
/* 1767 */         k = paramString.indexOf(str);
/* 1768 */         if (k != -1)
/*      */         {
/*      */ 
/*      */           
/* 1772 */           if (k < j)
/* 1773 */             j = k; 
/*      */         }
/*      */       } 
/*      */     } 
/* 1777 */     return (j == Integer.MAX_VALUE) ? -1 : j;
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
/*      */   public static int lastIndexOfAny(String paramString, String[] paramArrayOfString) {
/* 1806 */     if (paramString == null || paramArrayOfString == null) {
/* 1807 */       return -1;
/*      */     }
/* 1809 */     int i = paramArrayOfString.length;
/* 1810 */     int j = -1;
/* 1811 */     int k = 0;
/* 1812 */     for (byte b = 0; b < i; b++) {
/* 1813 */       String str = paramArrayOfString[b];
/* 1814 */       if (str != null) {
/*      */ 
/*      */         
/* 1817 */         k = paramString.lastIndexOf(str);
/* 1818 */         if (k > j)
/* 1819 */           j = k; 
/*      */       } 
/*      */     } 
/* 1822 */     return j;
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
/*      */   public static String substring(String paramString, int paramInt) {
/* 1852 */     if (paramString == null) {
/* 1853 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1857 */     if (paramInt < 0) {
/* 1858 */       paramInt = paramString.length() + paramInt;
/*      */     }
/*      */     
/* 1861 */     if (paramInt < 0) {
/* 1862 */       paramInt = 0;
/*      */     }
/* 1864 */     if (paramInt > paramString.length()) {
/* 1865 */       return "";
/*      */     }
/*      */     
/* 1868 */     return paramString.substring(paramInt);
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
/*      */   public static String substring(String paramString, int paramInt1, int paramInt2) {
/* 1907 */     if (paramString == null) {
/* 1908 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1912 */     if (paramInt2 < 0) {
/* 1913 */       paramInt2 = paramString.length() + paramInt2;
/*      */     }
/* 1915 */     if (paramInt1 < 0) {
/* 1916 */       paramInt1 = paramString.length() + paramInt1;
/*      */     }
/*      */ 
/*      */     
/* 1920 */     if (paramInt2 > paramString.length()) {
/* 1921 */       paramInt2 = paramString.length();
/*      */     }
/*      */ 
/*      */     
/* 1925 */     if (paramInt1 > paramInt2) {
/* 1926 */       return "";
/*      */     }
/*      */     
/* 1929 */     if (paramInt1 < 0) {
/* 1930 */       paramInt1 = 0;
/*      */     }
/* 1932 */     if (paramInt2 < 0) {
/* 1933 */       paramInt2 = 0;
/*      */     }
/*      */     
/* 1936 */     return paramString.substring(paramInt1, paramInt2);
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
/*      */   public static String left(String paramString, int paramInt) {
/* 1962 */     if (paramString == null) {
/* 1963 */       return null;
/*      */     }
/* 1965 */     if (paramInt < 0) {
/* 1966 */       return "";
/*      */     }
/* 1968 */     if (paramString.length() <= paramInt) {
/* 1969 */       return paramString;
/*      */     }
/* 1971 */     return paramString.substring(0, paramInt);
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
/*      */   public static String right(String paramString, int paramInt) {
/* 1995 */     if (paramString == null) {
/* 1996 */       return null;
/*      */     }
/* 1998 */     if (paramInt < 0) {
/* 1999 */       return "";
/*      */     }
/* 2001 */     if (paramString.length() <= paramInt) {
/* 2002 */       return paramString;
/*      */     }
/* 2004 */     return paramString.substring(paramString.length() - paramInt);
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
/*      */   public static String mid(String paramString, int paramInt1, int paramInt2) {
/* 2033 */     if (paramString == null) {
/* 2034 */       return null;
/*      */     }
/* 2036 */     if (paramInt2 < 0 || paramInt1 > paramString.length()) {
/* 2037 */       return "";
/*      */     }
/* 2039 */     if (paramInt1 < 0) {
/* 2040 */       paramInt1 = 0;
/*      */     }
/* 2042 */     if (paramString.length() <= paramInt1 + paramInt2) {
/* 2043 */       return paramString.substring(paramInt1);
/*      */     }
/* 2045 */     return paramString.substring(paramInt1, paramInt1 + paramInt2);
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
/*      */   public static String substringBefore(String paramString1, String paramString2) {
/* 2078 */     if (isEmpty(paramString1) || paramString2 == null) {
/* 2079 */       return paramString1;
/*      */     }
/* 2081 */     if (paramString2.length() == 0) {
/* 2082 */       return "";
/*      */     }
/* 2084 */     int i = paramString1.indexOf(paramString2);
/* 2085 */     if (i == -1) {
/* 2086 */       return paramString1;
/*      */     }
/* 2088 */     return paramString1.substring(0, i);
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
/*      */   public static String substringAfter(String paramString1, String paramString2) {
/* 2120 */     if (isEmpty(paramString1)) {
/* 2121 */       return paramString1;
/*      */     }
/* 2123 */     if (paramString2 == null) {
/* 2124 */       return "";
/*      */     }
/* 2126 */     int i = paramString1.indexOf(paramString2);
/* 2127 */     if (i == -1) {
/* 2128 */       return "";
/*      */     }
/* 2130 */     return paramString1.substring(i + paramString2.length());
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
/*      */   public static String substringBeforeLast(String paramString1, String paramString2) {
/* 2161 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 2162 */       return paramString1;
/*      */     }
/* 2164 */     int i = paramString1.lastIndexOf(paramString2);
/* 2165 */     if (i == -1) {
/* 2166 */       return paramString1;
/*      */     }
/* 2168 */     return paramString1.substring(0, i);
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
/*      */   public static String substringAfterLast(String paramString1, String paramString2) {
/* 2201 */     if (isEmpty(paramString1)) {
/* 2202 */       return paramString1;
/*      */     }
/* 2204 */     if (isEmpty(paramString2)) {
/* 2205 */       return "";
/*      */     }
/* 2207 */     int i = paramString1.lastIndexOf(paramString2);
/* 2208 */     if (i == -1 || i == paramString1.length() - paramString2.length()) {
/* 2209 */       return "";
/*      */     }
/* 2211 */     return paramString1.substring(i + paramString2.length());
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
/*      */   public static String substringBetween(String paramString1, String paramString2) {
/* 2238 */     return substringBetween(paramString1, paramString2, paramString2);
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
/*      */   public static String substringBetween(String paramString1, String paramString2, String paramString3) {
/* 2269 */     if (paramString1 == null || paramString2 == null || paramString3 == null) {
/* 2270 */       return null;
/*      */     }
/* 2272 */     int i = paramString1.indexOf(paramString2);
/* 2273 */     if (i != -1) {
/* 2274 */       int j = paramString1.indexOf(paramString3, i + paramString2.length());
/* 2275 */       if (j != -1) {
/* 2276 */         return paramString1.substring(i + paramString2.length(), j);
/*      */       }
/*      */     } 
/* 2279 */     return null;
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
/*      */   public static String[] substringsBetween(String paramString1, String paramString2, String paramString3) {
/* 2305 */     if (paramString1 == null || isEmpty(paramString2) || isEmpty(paramString3)) {
/* 2306 */       return null;
/*      */     }
/* 2308 */     int i = paramString1.length();
/* 2309 */     if (i == 0) {
/* 2310 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 2312 */     int j = paramString3.length();
/* 2313 */     int k = paramString2.length();
/* 2314 */     ArrayList arrayList = new ArrayList();
/* 2315 */     int m = 0;
/* 2316 */     while (m < i - j) {
/* 2317 */       int n = paramString1.indexOf(paramString2, m);
/* 2318 */       if (n < 0) {
/*      */         break;
/*      */       }
/* 2321 */       n += k;
/* 2322 */       int i1 = paramString1.indexOf(paramString3, n);
/* 2323 */       if (i1 < 0) {
/*      */         break;
/*      */       }
/* 2326 */       arrayList.add(paramString1.substring(n, i1));
/* 2327 */       m = i1 + j;
/*      */     } 
/* 2329 */     if (arrayList.isEmpty()) {
/* 2330 */       return null;
/*      */     }
/* 2332 */     return arrayList.<String>toArray(new String[arrayList.size()]);
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
/*      */   public static String getNestedString(String paramString1, String paramString2) {
/* 2360 */     return substringBetween(paramString1, paramString2, paramString2);
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
/*      */   public static String getNestedString(String paramString1, String paramString2, String paramString3) {
/* 2390 */     return substringBetween(paramString1, paramString2, paramString3);
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
/*      */   public static String[] split(String paramString) {
/* 2418 */     return split(paramString, null, -1);
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
/*      */   public static String[] split(String paramString, char paramChar) {
/* 2446 */     return splitWorker(paramString, paramChar, false);
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
/*      */   public static String[] split(String paramString1, String paramString2) {
/* 2475 */     return splitWorker(paramString1, paramString2, -1, false);
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
/*      */   public static String[] split(String paramString1, String paramString2, int paramInt) {
/* 2509 */     return splitWorker(paramString1, paramString2, paramInt, false);
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
/*      */   public static String[] splitByWholeSeparator(String paramString1, String paramString2) {
/* 2536 */     return splitByWholeSeparatorWorker(paramString1, paramString2, -1, false);
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
/*      */   public static String[] splitByWholeSeparator(String paramString1, String paramString2, int paramInt) {
/* 2567 */     return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, false);
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
/*      */   public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2) {
/* 2596 */     return splitByWholeSeparatorWorker(paramString1, paramString2, -1, true);
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
/*      */   public static String[] splitByWholeSeparatorPreserveAllTokens(String paramString1, String paramString2, int paramInt) {
/* 2629 */     return splitByWholeSeparatorWorker(paramString1, paramString2, paramInt, true);
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
/*      */   private static String[] splitByWholeSeparatorWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
/* 2649 */     if (paramString1 == null) {
/* 2650 */       return null;
/*      */     }
/*      */     
/* 2653 */     int i = paramString1.length();
/*      */     
/* 2655 */     if (i == 0) {
/* 2656 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/*      */     
/* 2659 */     if (paramString2 == null || "".equals(paramString2))
/*      */     {
/* 2661 */       return splitWorker(paramString1, null, paramInt, paramBoolean);
/*      */     }
/*      */     
/* 2664 */     int j = paramString2.length();
/*      */     
/* 2666 */     ArrayList arrayList = new ArrayList();
/* 2667 */     byte b = 0;
/* 2668 */     int k = 0;
/* 2669 */     int m = 0;
/* 2670 */     while (m < i) {
/* 2671 */       m = paramString1.indexOf(paramString2, k);
/*      */       
/* 2673 */       if (m > -1) {
/* 2674 */         if (m > k) {
/* 2675 */           b++;
/*      */           
/* 2677 */           if (b == paramInt) {
/* 2678 */             m = i;
/* 2679 */             arrayList.add(paramString1.substring(k));
/*      */             
/*      */             continue;
/*      */           } 
/* 2683 */           arrayList.add(paramString1.substring(k, m));
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2688 */           k = m + j;
/*      */           
/*      */           continue;
/*      */         } 
/* 2692 */         if (paramBoolean) {
/* 2693 */           b++;
/* 2694 */           if (b == paramInt) {
/* 2695 */             m = i;
/* 2696 */             arrayList.add(paramString1.substring(k));
/*      */           } else {
/* 2698 */             arrayList.add("");
/*      */           } 
/*      */         } 
/* 2701 */         k = m + j;
/*      */         
/*      */         continue;
/*      */       } 
/* 2705 */       arrayList.add(paramString1.substring(k));
/* 2706 */       m = i;
/*      */     } 
/*      */ 
/*      */     
/* 2710 */     return arrayList.<String>toArray(new String[arrayList.size()]);
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
/*      */   public static String[] splitPreserveAllTokens(String paramString) {
/* 2739 */     return splitWorker(paramString, null, -1, true);
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
/*      */   public static String[] splitPreserveAllTokens(String paramString, char paramChar) {
/* 2775 */     return splitWorker(paramString, paramChar, true);
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
/*      */   private static String[] splitWorker(String paramString, char paramChar, boolean paramBoolean) {
/* 2793 */     if (paramString == null) {
/* 2794 */       return null;
/*      */     }
/* 2796 */     int i = paramString.length();
/* 2797 */     if (i == 0) {
/* 2798 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 2800 */     ArrayList arrayList = new ArrayList();
/* 2801 */     byte b1 = 0, b2 = 0;
/* 2802 */     boolean bool1 = false;
/* 2803 */     boolean bool2 = false;
/* 2804 */     while (b1 < i) {
/* 2805 */       if (paramString.charAt(b1) == paramChar) {
/* 2806 */         if (bool1 || paramBoolean) {
/* 2807 */           arrayList.add(paramString.substring(b2, b1));
/* 2808 */           bool1 = false;
/* 2809 */           bool2 = true;
/*      */         } 
/* 2811 */         b2 = ++b1;
/*      */         continue;
/*      */       } 
/* 2814 */       bool2 = false;
/* 2815 */       bool1 = true;
/* 2816 */       b1++;
/*      */     } 
/* 2818 */     if (bool1 || (paramBoolean && bool2)) {
/* 2819 */       arrayList.add(paramString.substring(b2, b1));
/*      */     }
/* 2821 */     return arrayList.<String>toArray(new String[arrayList.size()]);
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
/*      */   public static String[] splitPreserveAllTokens(String paramString1, String paramString2) {
/* 2858 */     return splitWorker(paramString1, paramString2, -1, true);
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
/*      */   public static String[] splitPreserveAllTokens(String paramString1, String paramString2, int paramInt) {
/* 2898 */     return splitWorker(paramString1, paramString2, paramInt, true);
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
/*      */   private static String[] splitWorker(String paramString1, String paramString2, int paramInt, boolean paramBoolean) {
/* 2920 */     if (paramString1 == null) {
/* 2921 */       return null;
/*      */     }
/* 2923 */     int i = paramString1.length();
/* 2924 */     if (i == 0) {
/* 2925 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 2927 */     ArrayList arrayList = new ArrayList();
/* 2928 */     byte b = 1;
/* 2929 */     int j = 0, k = 0;
/* 2930 */     boolean bool1 = false;
/* 2931 */     boolean bool2 = false;
/* 2932 */     if (paramString2 == null) {
/*      */       
/* 2934 */       while (j < i) {
/* 2935 */         if (Character.isWhitespace(paramString1.charAt(j))) {
/* 2936 */           if (bool1 || paramBoolean) {
/* 2937 */             bool2 = true;
/* 2938 */             if (b++ == paramInt) {
/* 2939 */               j = i;
/* 2940 */               bool2 = false;
/*      */             } 
/* 2942 */             arrayList.add(paramString1.substring(k, j));
/* 2943 */             bool1 = false;
/*      */           } 
/* 2945 */           k = ++j;
/*      */           continue;
/*      */         } 
/* 2948 */         bool2 = false;
/* 2949 */         bool1 = true;
/* 2950 */         j++;
/*      */       } 
/* 2952 */     } else if (paramString2.length() == 1) {
/*      */       
/* 2954 */       char c = paramString2.charAt(0);
/* 2955 */       while (j < i) {
/* 2956 */         if (paramString1.charAt(j) == c) {
/* 2957 */           if (bool1 || paramBoolean) {
/* 2958 */             bool2 = true;
/* 2959 */             if (b++ == paramInt) {
/* 2960 */               j = i;
/* 2961 */               bool2 = false;
/*      */             } 
/* 2963 */             arrayList.add(paramString1.substring(k, j));
/* 2964 */             bool1 = false;
/*      */           } 
/* 2966 */           k = ++j;
/*      */           continue;
/*      */         } 
/* 2969 */         bool2 = false;
/* 2970 */         bool1 = true;
/* 2971 */         j++;
/*      */       } 
/*      */     } else {
/*      */       
/* 2975 */       while (j < i) {
/* 2976 */         if (paramString2.indexOf(paramString1.charAt(j)) >= 0) {
/* 2977 */           if (bool1 || paramBoolean) {
/* 2978 */             bool2 = true;
/* 2979 */             if (b++ == paramInt) {
/* 2980 */               j = i;
/* 2981 */               bool2 = false;
/*      */             } 
/* 2983 */             arrayList.add(paramString1.substring(k, j));
/* 2984 */             bool1 = false;
/*      */           } 
/* 2986 */           k = ++j;
/*      */           continue;
/*      */         } 
/* 2989 */         bool2 = false;
/* 2990 */         bool1 = true;
/* 2991 */         j++;
/*      */       } 
/*      */     } 
/* 2994 */     if (bool1 || (paramBoolean && bool2)) {
/* 2995 */       arrayList.add(paramString1.substring(k, j));
/*      */     }
/* 2997 */     return arrayList.<String>toArray(new String[arrayList.size()]);
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
/*      */   public static String[] splitByCharacterType(String paramString) {
/* 3020 */     return splitByCharacterType(paramString, false);
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
/*      */   public static String[] splitByCharacterTypeCamelCase(String paramString) {
/* 3048 */     return splitByCharacterType(paramString, true);
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
/*      */   private static String[] splitByCharacterType(String paramString, boolean paramBoolean) {
/* 3066 */     if (paramString == null) {
/* 3067 */       return null;
/*      */     }
/* 3069 */     if (paramString.length() == 0) {
/* 3070 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 3072 */     char[] arrayOfChar = paramString.toCharArray();
/* 3073 */     ArrayList arrayList = new ArrayList();
/* 3074 */     int i = 0;
/* 3075 */     int j = Character.getType(arrayOfChar[i]);
/* 3076 */     for (int k = i + 1; k < arrayOfChar.length; k++) {
/* 3077 */       int m = Character.getType(arrayOfChar[k]);
/* 3078 */       if (m != j) {
/*      */ 
/*      */         
/* 3081 */         if (paramBoolean && m == 2 && j == 1) {
/* 3082 */           int n = k - 1;
/* 3083 */           if (n != i) {
/* 3084 */             arrayList.add(new String(arrayOfChar, i, n - i));
/* 3085 */             i = n;
/*      */           } 
/*      */         } else {
/* 3088 */           arrayList.add(new String(arrayOfChar, i, k - i));
/* 3089 */           i = k;
/*      */         } 
/* 3091 */         j = m;
/*      */       } 
/* 3093 */     }  arrayList.add(new String(arrayOfChar, i, arrayOfChar.length - i));
/* 3094 */     return arrayList.<String>toArray(new String[arrayList.size()]);
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
/*      */   public static String concatenate(Object[] paramArrayOfObject) {
/* 3120 */     return join(paramArrayOfObject, (String)null);
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
/*      */   public static String join(Object[] paramArrayOfObject) {
/* 3144 */     return join(paramArrayOfObject, (String)null);
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
/*      */   public static String join(Object[] paramArrayOfObject, char paramChar) {
/* 3170 */     if (paramArrayOfObject == null) {
/* 3171 */       return null;
/*      */     }
/*      */     
/* 3174 */     return join(paramArrayOfObject, paramChar, 0, paramArrayOfObject.length);
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
/*      */   public static String join(Object[] paramArrayOfObject, char paramChar, int paramInt1, int paramInt2) {
/* 3204 */     if (paramArrayOfObject == null) {
/* 3205 */       return null;
/*      */     }
/* 3207 */     int i = paramInt2 - paramInt1;
/* 3208 */     if (i <= 0) {
/* 3209 */       return "";
/*      */     }
/*      */     
/* 3212 */     i *= ((paramArrayOfObject[paramInt1] == null) ? 16 : paramArrayOfObject[paramInt1].toString().length()) + 1;
/* 3213 */     StrBuilder strBuilder = new StrBuilder(i);
/*      */     
/* 3215 */     for (int j = paramInt1; j < paramInt2; j++) {
/* 3216 */       if (j > paramInt1) {
/* 3217 */         strBuilder.append(paramChar);
/*      */       }
/* 3219 */       if (paramArrayOfObject[j] != null) {
/* 3220 */         strBuilder.append(paramArrayOfObject[j]);
/*      */       }
/*      */     } 
/* 3223 */     return strBuilder.toString();
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
/*      */   public static String join(Object[] paramArrayOfObject, String paramString) {
/* 3251 */     if (paramArrayOfObject == null) {
/* 3252 */       return null;
/*      */     }
/* 3254 */     return join(paramArrayOfObject, paramString, 0, paramArrayOfObject.length);
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
/*      */   public static String join(Object[] paramArrayOfObject, String paramString, int paramInt1, int paramInt2) {
/* 3285 */     if (paramArrayOfObject == null) {
/* 3286 */       return null;
/*      */     }
/* 3288 */     if (paramString == null) {
/* 3289 */       paramString = "";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 3294 */     int i = paramInt2 - paramInt1;
/* 3295 */     if (i <= 0) {
/* 3296 */       return "";
/*      */     }
/*      */     
/* 3299 */     i *= ((paramArrayOfObject[paramInt1] == null) ? 16 : paramArrayOfObject[paramInt1].toString().length()) + paramString.length();
/*      */ 
/*      */     
/* 3302 */     StrBuilder strBuilder = new StrBuilder(i);
/*      */     
/* 3304 */     for (int j = paramInt1; j < paramInt2; j++) {
/* 3305 */       if (j > paramInt1) {
/* 3306 */         strBuilder.append(paramString);
/*      */       }
/* 3308 */       if (paramArrayOfObject[j] != null) {
/* 3309 */         strBuilder.append(paramArrayOfObject[j]);
/*      */       }
/*      */     } 
/* 3312 */     return strBuilder.toString();
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
/*      */   public static String join(Iterator paramIterator, char paramChar) {
/* 3332 */     if (paramIterator == null) {
/* 3333 */       return null;
/*      */     }
/* 3335 */     if (!paramIterator.hasNext()) {
/* 3336 */       return "";
/*      */     }
/* 3338 */     Object object = paramIterator.next();
/* 3339 */     if (!paramIterator.hasNext()) {
/* 3340 */       return ObjectUtils.toString(object);
/*      */     }
/*      */ 
/*      */     
/* 3344 */     StrBuilder strBuilder = new StrBuilder(256);
/* 3345 */     if (object != null) {
/* 3346 */       strBuilder.append(object);
/*      */     }
/*      */     
/* 3349 */     while (paramIterator.hasNext()) {
/* 3350 */       strBuilder.append(paramChar);
/* 3351 */       Object object1 = paramIterator.next();
/* 3352 */       if (object1 != null) {
/* 3353 */         strBuilder.append(object1);
/*      */       }
/*      */     } 
/*      */     
/* 3357 */     return strBuilder.toString();
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
/*      */   public static String join(Iterator paramIterator, String paramString) {
/* 3376 */     if (paramIterator == null) {
/* 3377 */       return null;
/*      */     }
/* 3379 */     if (!paramIterator.hasNext()) {
/* 3380 */       return "";
/*      */     }
/* 3382 */     Object object = paramIterator.next();
/* 3383 */     if (!paramIterator.hasNext()) {
/* 3384 */       return ObjectUtils.toString(object);
/*      */     }
/*      */ 
/*      */     
/* 3388 */     StrBuilder strBuilder = new StrBuilder(256);
/* 3389 */     if (object != null) {
/* 3390 */       strBuilder.append(object);
/*      */     }
/*      */     
/* 3393 */     while (paramIterator.hasNext()) {
/* 3394 */       if (paramString != null) {
/* 3395 */         strBuilder.append(paramString);
/*      */       }
/* 3397 */       Object object1 = paramIterator.next();
/* 3398 */       if (object1 != null) {
/* 3399 */         strBuilder.append(object1);
/*      */       }
/*      */     } 
/* 3402 */     return strBuilder.toString();
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
/*      */   public static String join(Collection paramCollection, char paramChar) {
/* 3420 */     if (paramCollection == null) {
/* 3421 */       return null;
/*      */     }
/* 3423 */     return join(paramCollection.iterator(), paramChar);
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
/*      */   public static String join(Collection paramCollection, String paramString) {
/* 3441 */     if (paramCollection == null) {
/* 3442 */       return null;
/*      */     }
/* 3444 */     return join(paramCollection.iterator(), paramString);
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
/*      */   public static String deleteSpaces(String paramString) {
/* 3476 */     if (paramString == null) {
/* 3477 */       return null;
/*      */     }
/* 3479 */     return CharSetUtils.delete(paramString, " \t\r\n\b");
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
/*      */   public static String deleteWhitespace(String paramString) {
/* 3497 */     if (isEmpty(paramString)) {
/* 3498 */       return paramString;
/*      */     }
/* 3500 */     int i = paramString.length();
/* 3501 */     char[] arrayOfChar = new char[i];
/* 3502 */     byte b1 = 0;
/* 3503 */     for (byte b2 = 0; b2 < i; b2++) {
/* 3504 */       if (!Character.isWhitespace(paramString.charAt(b2))) {
/* 3505 */         arrayOfChar[b1++] = paramString.charAt(b2);
/*      */       }
/*      */     } 
/* 3508 */     if (b1 == i) {
/* 3509 */       return paramString;
/*      */     }
/* 3511 */     return new String(arrayOfChar, 0, b1);
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
/*      */   public static String removeStart(String paramString1, String paramString2) {
/* 3541 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 3542 */       return paramString1;
/*      */     }
/* 3544 */     if (paramString1.startsWith(paramString2)) {
/* 3545 */       return paramString1.substring(paramString2.length());
/*      */     }
/* 3547 */     return paramString1;
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
/*      */   public static String removeStartIgnoreCase(String paramString1, String paramString2) {
/* 3576 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 3577 */       return paramString1;
/*      */     }
/* 3579 */     if (startsWithIgnoreCase(paramString1, paramString2)) {
/* 3580 */       return paramString1.substring(paramString2.length());
/*      */     }
/* 3582 */     return paramString1;
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
/*      */   public static String removeEnd(String paramString1, String paramString2) {
/* 3610 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 3611 */       return paramString1;
/*      */     }
/* 3613 */     if (paramString1.endsWith(paramString2)) {
/* 3614 */       return paramString1.substring(0, paramString1.length() - paramString2.length());
/*      */     }
/* 3616 */     return paramString1;
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
/*      */   public static String removeEndIgnoreCase(String paramString1, String paramString2) {
/* 3646 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 3647 */       return paramString1;
/*      */     }
/* 3649 */     if (endsWithIgnoreCase(paramString1, paramString2)) {
/* 3650 */       return paramString1.substring(0, paramString1.length() - paramString2.length());
/*      */     }
/* 3652 */     return paramString1;
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
/*      */   public static String remove(String paramString1, String paramString2) {
/* 3679 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 3680 */       return paramString1;
/*      */     }
/* 3682 */     return replace(paramString1, paramString2, "", -1);
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
/*      */   public static String remove(String paramString, char paramChar) {
/* 3705 */     if (isEmpty(paramString) || paramString.indexOf(paramChar) == -1) {
/* 3706 */       return paramString;
/*      */     }
/* 3708 */     char[] arrayOfChar = paramString.toCharArray();
/* 3709 */     byte b1 = 0;
/* 3710 */     for (byte b2 = 0; b2 < arrayOfChar.length; b2++) {
/* 3711 */       if (arrayOfChar[b2] != paramChar) {
/* 3712 */         arrayOfChar[b1++] = arrayOfChar[b2];
/*      */       }
/*      */     } 
/* 3715 */     return new String(arrayOfChar, 0, b1);
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
/*      */   public static String replaceOnce(String paramString1, String paramString2, String paramString3) {
/* 3744 */     return replace(paramString1, paramString2, paramString3, 1);
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
/*      */   public static String replace(String paramString1, String paramString2, String paramString3) {
/* 3771 */     return replace(paramString1, paramString2, paramString3, -1);
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
/*      */   public static String replace(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 3803 */     if (isEmpty(paramString1) || isEmpty(paramString2) || paramString3 == null || paramInt == 0) {
/* 3804 */       return paramString1;
/*      */     }
/* 3806 */     int i = 0;
/* 3807 */     int j = paramString1.indexOf(paramString2, i);
/* 3808 */     if (j == -1) {
/* 3809 */       return paramString1;
/*      */     }
/* 3811 */     int k = paramString2.length();
/* 3812 */     int m = paramString3.length() - k;
/* 3813 */     m = (m < 0) ? 0 : m;
/* 3814 */     m *= (paramInt < 0) ? 16 : ((paramInt > 64) ? 64 : paramInt);
/* 3815 */     StrBuilder strBuilder = new StrBuilder(paramString1.length() + m);
/* 3816 */     while (j != -1) {
/* 3817 */       strBuilder.append(paramString1.substring(i, j)).append(paramString3);
/* 3818 */       i = j + k;
/* 3819 */       if (--paramInt == 0) {
/*      */         break;
/*      */       }
/* 3822 */       j = paramString1.indexOf(paramString2, i);
/*      */     } 
/* 3824 */     strBuilder.append(paramString1.substring(i));
/* 3825 */     return strBuilder.toString();
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
/*      */   public static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 3868 */     return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, false, 0);
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
/*      */   public static String replaceEachRepeatedly(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 3919 */     boolean bool = (paramArrayOfString1 == null) ? false : paramArrayOfString1.length;
/* 3920 */     return replaceEach(paramString, paramArrayOfString1, paramArrayOfString2, true, bool);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String replaceEach(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean, int paramInt) {
/* 3978 */     if (paramString == null || paramString.length() == 0 || paramArrayOfString1 == null || paramArrayOfString1.length == 0 || paramArrayOfString2 == null || paramArrayOfString2.length == 0)
/*      */     {
/*      */       
/* 3981 */       return paramString;
/*      */     }
/*      */ 
/*      */     
/* 3985 */     if (paramInt < 0) {
/* 3986 */       throw new IllegalStateException("TimeToLive of " + paramInt + " is less than 0: " + paramString);
/*      */     }
/*      */     
/* 3989 */     int i = paramArrayOfString1.length;
/* 3990 */     int j = paramArrayOfString2.length;
/*      */ 
/*      */     
/* 3993 */     if (i != j) {
/* 3994 */       throw new IllegalArgumentException("Search and Replace array lengths don't match: " + i + " vs " + j);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4001 */     boolean[] arrayOfBoolean = new boolean[i];
/*      */ 
/*      */     
/* 4004 */     int k = -1;
/* 4005 */     int m = -1;
/* 4006 */     int n = -1;
/*      */     
/*      */     int i1;
/*      */     
/* 4010 */     for (i1 = 0; i1 < i; i1++) {
/* 4011 */       if (!arrayOfBoolean[i1] && paramArrayOfString1[i1] != null && paramArrayOfString1[i1].length() != 0 && paramArrayOfString2[i1] != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 4016 */         n = paramString.indexOf(paramArrayOfString1[i1]);
/*      */ 
/*      */         
/* 4019 */         if (n == -1) {
/* 4020 */           arrayOfBoolean[i1] = true;
/*      */         }
/* 4022 */         else if (k == -1 || n < k) {
/* 4023 */           k = n;
/* 4024 */           m = i1;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 4031 */     if (k == -1) {
/* 4032 */       return paramString;
/*      */     }
/*      */     
/* 4035 */     i1 = 0;
/*      */ 
/*      */     
/* 4038 */     int i2 = 0;
/*      */ 
/*      */     
/* 4041 */     for (byte b = 0; b < paramArrayOfString1.length; b++) {
/* 4042 */       if (paramArrayOfString1[b] != null && paramArrayOfString2[b] != null) {
/*      */ 
/*      */         
/* 4045 */         int i5 = paramArrayOfString2[b].length() - paramArrayOfString1[b].length();
/* 4046 */         if (i5 > 0) {
/* 4047 */           i2 += 3 * i5;
/*      */         }
/*      */       } 
/*      */     } 
/* 4051 */     i2 = Math.min(i2, paramString.length() / 5);
/*      */     
/* 4053 */     StrBuilder strBuilder = new StrBuilder(paramString.length() + i2);
/*      */     
/* 4055 */     while (k != -1) {
/*      */       int i5;
/* 4057 */       for (i5 = i1; i5 < k; i5++) {
/* 4058 */         strBuilder.append(paramString.charAt(i5));
/*      */       }
/* 4060 */       strBuilder.append(paramArrayOfString2[m]);
/*      */       
/* 4062 */       i1 = k + paramArrayOfString1[m].length();
/*      */       
/* 4064 */       k = -1;
/* 4065 */       m = -1;
/* 4066 */       n = -1;
/*      */ 
/*      */       
/* 4069 */       for (i5 = 0; i5 < i; i5++) {
/* 4070 */         if (!arrayOfBoolean[i5] && paramArrayOfString1[i5] != null && paramArrayOfString1[i5].length() != 0 && paramArrayOfString2[i5] != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4075 */           n = paramString.indexOf(paramArrayOfString1[i5], i1);
/*      */ 
/*      */           
/* 4078 */           if (n == -1) {
/* 4079 */             arrayOfBoolean[i5] = true;
/*      */           }
/* 4081 */           else if (k == -1 || n < k) {
/* 4082 */             k = n;
/* 4083 */             m = i5;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 4090 */     int i3 = paramString.length();
/* 4091 */     for (int i4 = i1; i4 < i3; i4++) {
/* 4092 */       strBuilder.append(paramString.charAt(i4));
/*      */     }
/* 4094 */     String str = strBuilder.toString();
/* 4095 */     if (!paramBoolean) {
/* 4096 */       return str;
/*      */     }
/*      */     
/* 4099 */     return replaceEach(str, paramArrayOfString1, paramArrayOfString2, paramBoolean, paramInt - 1);
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
/*      */   public static String replaceChars(String paramString, char paramChar1, char paramChar2) {
/* 4125 */     if (paramString == null) {
/* 4126 */       return null;
/*      */     }
/* 4128 */     return paramString.replace(paramChar1, paramChar2);
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
/*      */   public static String replaceChars(String paramString1, String paramString2, String paramString3) {
/* 4168 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 4169 */       return paramString1;
/*      */     }
/* 4171 */     if (paramString3 == null) {
/* 4172 */       paramString3 = "";
/*      */     }
/* 4174 */     boolean bool = false;
/* 4175 */     int i = paramString3.length();
/* 4176 */     int j = paramString1.length();
/* 4177 */     StrBuilder strBuilder = new StrBuilder(j);
/* 4178 */     for (byte b = 0; b < j; b++) {
/* 4179 */       char c = paramString1.charAt(b);
/* 4180 */       int k = paramString2.indexOf(c);
/* 4181 */       if (k >= 0) {
/* 4182 */         bool = true;
/* 4183 */         if (k < i) {
/* 4184 */           strBuilder.append(paramString3.charAt(k));
/*      */         }
/*      */       } else {
/* 4187 */         strBuilder.append(c);
/*      */       } 
/*      */     } 
/* 4190 */     if (bool) {
/* 4191 */       return strBuilder.toString();
/*      */     }
/* 4193 */     return paramString1;
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
/*      */   public static String overlayString(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 4224 */     return (new StrBuilder(paramInt1 + paramString2.length() + paramString1.length() - paramInt2 + 1)).append(paramString1.substring(0, paramInt1)).append(paramString2).append(paramString1.substring(paramInt2)).toString();
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
/*      */   public static String overlay(String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 4261 */     if (paramString1 == null) {
/* 4262 */       return null;
/*      */     }
/* 4264 */     if (paramString2 == null) {
/* 4265 */       paramString2 = "";
/*      */     }
/* 4267 */     int i = paramString1.length();
/* 4268 */     if (paramInt1 < 0) {
/* 4269 */       paramInt1 = 0;
/*      */     }
/* 4271 */     if (paramInt1 > i) {
/* 4272 */       paramInt1 = i;
/*      */     }
/* 4274 */     if (paramInt2 < 0) {
/* 4275 */       paramInt2 = 0;
/*      */     }
/* 4277 */     if (paramInt2 > i) {
/* 4278 */       paramInt2 = i;
/*      */     }
/* 4280 */     if (paramInt1 > paramInt2) {
/* 4281 */       int j = paramInt1;
/* 4282 */       paramInt1 = paramInt2;
/* 4283 */       paramInt2 = j;
/*      */     } 
/* 4285 */     return (new StrBuilder(i + paramInt1 - paramInt2 + paramString2.length() + 1)).append(paramString1.substring(0, paramInt1)).append(paramString2).append(paramString1.substring(paramInt2)).toString();
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
/*      */   public static String chomp(String paramString) {
/* 4320 */     if (isEmpty(paramString)) {
/* 4321 */       return paramString;
/*      */     }
/*      */     
/* 4324 */     if (paramString.length() == 1) {
/* 4325 */       char c1 = paramString.charAt(0);
/* 4326 */       if (c1 == '\r' || c1 == '\n') {
/* 4327 */         return "";
/*      */       }
/* 4329 */       return paramString;
/*      */     } 
/*      */     
/* 4332 */     int i = paramString.length() - 1;
/* 4333 */     char c = paramString.charAt(i);
/*      */     
/* 4335 */     if (c == '\n') {
/* 4336 */       if (paramString.charAt(i - 1) == '\r') {
/* 4337 */         i--;
/*      */       }
/* 4339 */     } else if (c != '\r') {
/* 4340 */       i++;
/*      */     } 
/* 4342 */     return paramString.substring(0, i);
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
/*      */   public static String chomp(String paramString1, String paramString2) {
/* 4372 */     if (isEmpty(paramString1) || paramString2 == null) {
/* 4373 */       return paramString1;
/*      */     }
/* 4375 */     if (paramString1.endsWith(paramString2)) {
/* 4376 */       return paramString1.substring(0, paramString1.length() - paramString2.length());
/*      */     }
/* 4378 */     return paramString1;
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
/*      */   public static String chompLast(String paramString) {
/* 4392 */     return chompLast(paramString, "\n");
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
/*      */   public static String chompLast(String paramString1, String paramString2) {
/* 4406 */     if (paramString1.length() == 0) {
/* 4407 */       return paramString1;
/*      */     }
/* 4409 */     String str = paramString1.substring(paramString1.length() - paramString2.length());
/* 4410 */     if (paramString2.equals(str)) {
/* 4411 */       return paramString1.substring(0, paramString1.length() - paramString2.length());
/*      */     }
/* 4413 */     return paramString1;
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
/*      */   public static String getChomp(String paramString1, String paramString2) {
/* 4429 */     int i = paramString1.lastIndexOf(paramString2);
/* 4430 */     if (i == paramString1.length() - paramString2.length())
/* 4431 */       return paramString2; 
/* 4432 */     if (i != -1) {
/* 4433 */       return paramString1.substring(i);
/*      */     }
/* 4435 */     return "";
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
/*      */   public static String prechomp(String paramString1, String paramString2) {
/* 4451 */     int i = paramString1.indexOf(paramString2);
/* 4452 */     if (i == -1) {
/* 4453 */       return paramString1;
/*      */     }
/* 4455 */     return paramString1.substring(i + paramString2.length());
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
/*      */   public static String getPrechomp(String paramString1, String paramString2) {
/* 4471 */     int i = paramString1.indexOf(paramString2);
/* 4472 */     if (i == -1) {
/* 4473 */       return "";
/*      */     }
/* 4475 */     return paramString1.substring(0, i + paramString2.length());
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
/*      */   public static String chop(String paramString) {
/* 4504 */     if (paramString == null) {
/* 4505 */       return null;
/*      */     }
/* 4507 */     int i = paramString.length();
/* 4508 */     if (i < 2) {
/* 4509 */       return "";
/*      */     }
/* 4511 */     int j = i - 1;
/* 4512 */     String str = paramString.substring(0, j);
/* 4513 */     char c = paramString.charAt(j);
/* 4514 */     if (c == '\n' && 
/* 4515 */       str.charAt(j - 1) == '\r') {
/* 4516 */       return str.substring(0, j - 1);
/*      */     }
/*      */     
/* 4519 */     return str;
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
/*      */   public static String chopNewline(String paramString) {
/* 4533 */     int i = paramString.length() - 1;
/* 4534 */     if (i <= 0) {
/* 4535 */       return "";
/*      */     }
/* 4537 */     char c = paramString.charAt(i);
/* 4538 */     if (c == '\n') {
/* 4539 */       if (paramString.charAt(i - 1) == '\r') {
/* 4540 */         i--;
/*      */       }
/*      */     } else {
/* 4543 */       i++;
/*      */     } 
/* 4545 */     return paramString.substring(0, i);
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
/*      */   public static String escape(String paramString) {
/* 4567 */     return StringEscapeUtils.escapeJava(paramString);
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
/*      */   public static String repeat(String paramString, int paramInt) {
/*      */     char c1, arrayOfChar1[];
/*      */     int k;
/*      */     char c2, arrayOfChar2[];
/*      */     int m;
/* 4593 */     if (paramString == null) {
/* 4594 */       return null;
/*      */     }
/* 4596 */     if (paramInt <= 0) {
/* 4597 */       return "";
/*      */     }
/* 4599 */     int i = paramString.length();
/* 4600 */     if (paramInt == 1 || i == 0) {
/* 4601 */       return paramString;
/*      */     }
/* 4603 */     if (i == 1 && paramInt <= 8192) {
/* 4604 */       return padding(paramInt, paramString.charAt(0));
/*      */     }
/*      */     
/* 4607 */     int j = i * paramInt;
/* 4608 */     switch (i) {
/*      */       case 1:
/* 4610 */         c1 = paramString.charAt(0);
/* 4611 */         arrayOfChar1 = new char[j];
/* 4612 */         for (k = paramInt - 1; k >= 0; k--) {
/* 4613 */           arrayOfChar1[k] = c1;
/*      */         }
/* 4615 */         return new String(arrayOfChar1);
/*      */       case 2:
/* 4617 */         k = paramString.charAt(0);
/* 4618 */         c2 = paramString.charAt(1);
/* 4619 */         arrayOfChar2 = new char[j];
/* 4620 */         for (m = paramInt * 2 - 2; m >= 0; m--, m--) {
/* 4621 */           arrayOfChar2[m] = k;
/* 4622 */           arrayOfChar2[m + 1] = c2;
/*      */         } 
/* 4624 */         return new String(arrayOfChar2);
/*      */     } 
/* 4626 */     StrBuilder strBuilder = new StrBuilder(j);
/* 4627 */     for (byte b = 0; b < paramInt; b++) {
/* 4628 */       strBuilder.append(paramString);
/*      */     }
/* 4630 */     return strBuilder.toString();
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
/*      */   public static String repeat(String paramString1, String paramString2, int paramInt) {
/* 4655 */     if (paramString1 == null || paramString2 == null) {
/* 4656 */       return repeat(paramString1, paramInt);
/*      */     }
/*      */     
/* 4659 */     String str = repeat(paramString1 + paramString2, paramInt);
/* 4660 */     return removeEnd(str, paramString2);
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
/*      */   private static String padding(int paramInt, char paramChar) {
/* 4688 */     if (paramInt < 0) {
/* 4689 */       throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + paramInt);
/*      */     }
/* 4691 */     char[] arrayOfChar = new char[paramInt];
/* 4692 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 4693 */       arrayOfChar[b] = paramChar;
/*      */     }
/* 4695 */     return new String(arrayOfChar);
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
/*      */   public static String rightPad(String paramString, int paramInt) {
/* 4718 */     return rightPad(paramString, paramInt, ' ');
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
/*      */   public static String rightPad(String paramString, int paramInt, char paramChar) {
/* 4743 */     if (paramString == null) {
/* 4744 */       return null;
/*      */     }
/* 4746 */     int i = paramInt - paramString.length();
/* 4747 */     if (i <= 0) {
/* 4748 */       return paramString;
/*      */     }
/* 4750 */     if (i > 8192) {
/* 4751 */       return rightPad(paramString, paramInt, String.valueOf(paramChar));
/*      */     }
/* 4753 */     return paramString.concat(padding(i, paramChar));
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
/*      */   public static String rightPad(String paramString1, int paramInt, String paramString2) {
/* 4780 */     if (paramString1 == null) {
/* 4781 */       return null;
/*      */     }
/* 4783 */     if (isEmpty(paramString2)) {
/* 4784 */       paramString2 = " ";
/*      */     }
/* 4786 */     int i = paramString2.length();
/* 4787 */     int j = paramString1.length();
/* 4788 */     int k = paramInt - j;
/* 4789 */     if (k <= 0) {
/* 4790 */       return paramString1;
/*      */     }
/* 4792 */     if (i == 1 && k <= 8192) {
/* 4793 */       return rightPad(paramString1, paramInt, paramString2.charAt(0));
/*      */     }
/*      */     
/* 4796 */     if (k == i)
/* 4797 */       return paramString1.concat(paramString2); 
/* 4798 */     if (k < i) {
/* 4799 */       return paramString1.concat(paramString2.substring(0, k));
/*      */     }
/* 4801 */     char[] arrayOfChar1 = new char[k];
/* 4802 */     char[] arrayOfChar2 = paramString2.toCharArray();
/* 4803 */     for (byte b = 0; b < k; b++) {
/* 4804 */       arrayOfChar1[b] = arrayOfChar2[b % i];
/*      */     }
/* 4806 */     return paramString1.concat(new String(arrayOfChar1));
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
/*      */   public static String leftPad(String paramString, int paramInt) {
/* 4830 */     return leftPad(paramString, paramInt, ' ');
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
/*      */   public static String leftPad(String paramString, int paramInt, char paramChar) {
/* 4855 */     if (paramString == null) {
/* 4856 */       return null;
/*      */     }
/* 4858 */     int i = paramInt - paramString.length();
/* 4859 */     if (i <= 0) {
/* 4860 */       return paramString;
/*      */     }
/* 4862 */     if (i > 8192) {
/* 4863 */       return leftPad(paramString, paramInt, String.valueOf(paramChar));
/*      */     }
/* 4865 */     return padding(i, paramChar).concat(paramString);
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
/*      */   public static String leftPad(String paramString1, int paramInt, String paramString2) {
/* 4892 */     if (paramString1 == null) {
/* 4893 */       return null;
/*      */     }
/* 4895 */     if (isEmpty(paramString2)) {
/* 4896 */       paramString2 = " ";
/*      */     }
/* 4898 */     int i = paramString2.length();
/* 4899 */     int j = paramString1.length();
/* 4900 */     int k = paramInt - j;
/* 4901 */     if (k <= 0) {
/* 4902 */       return paramString1;
/*      */     }
/* 4904 */     if (i == 1 && k <= 8192) {
/* 4905 */       return leftPad(paramString1, paramInt, paramString2.charAt(0));
/*      */     }
/*      */     
/* 4908 */     if (k == i)
/* 4909 */       return paramString2.concat(paramString1); 
/* 4910 */     if (k < i) {
/* 4911 */       return paramString2.substring(0, k).concat(paramString1);
/*      */     }
/* 4913 */     char[] arrayOfChar1 = new char[k];
/* 4914 */     char[] arrayOfChar2 = paramString2.toCharArray();
/* 4915 */     for (byte b = 0; b < k; b++) {
/* 4916 */       arrayOfChar1[b] = arrayOfChar2[b % i];
/*      */     }
/* 4918 */     return (new String(arrayOfChar1)).concat(paramString1);
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
/*      */   public static int length(String paramString) {
/* 4931 */     return (paramString == null) ? 0 : paramString.length();
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
/*      */   public static String center(String paramString, int paramInt) {
/* 4960 */     return center(paramString, paramInt, ' ');
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
/*      */   public static String center(String paramString, int paramInt, char paramChar) {
/* 4988 */     if (paramString == null || paramInt <= 0) {
/* 4989 */       return paramString;
/*      */     }
/* 4991 */     int i = paramString.length();
/* 4992 */     int j = paramInt - i;
/* 4993 */     if (j <= 0) {
/* 4994 */       return paramString;
/*      */     }
/* 4996 */     paramString = leftPad(paramString, i + j / 2, paramChar);
/* 4997 */     paramString = rightPad(paramString, paramInt, paramChar);
/* 4998 */     return paramString;
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
/*      */   public static String center(String paramString1, int paramInt, String paramString2) {
/* 5028 */     if (paramString1 == null || paramInt <= 0) {
/* 5029 */       return paramString1;
/*      */     }
/* 5031 */     if (isEmpty(paramString2)) {
/* 5032 */       paramString2 = " ";
/*      */     }
/* 5034 */     int i = paramString1.length();
/* 5035 */     int j = paramInt - i;
/* 5036 */     if (j <= 0) {
/* 5037 */       return paramString1;
/*      */     }
/* 5039 */     paramString1 = leftPad(paramString1, i + j / 2, paramString2);
/* 5040 */     paramString1 = rightPad(paramString1, paramInt, paramString2);
/* 5041 */     return paramString1;
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
/*      */   public static String upperCase(String paramString) {
/* 5066 */     if (paramString == null) {
/* 5067 */       return null;
/*      */     }
/* 5069 */     return paramString.toUpperCase();
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
/*      */   public static String upperCase(String paramString, Locale paramLocale) {
/* 5089 */     if (paramString == null) {
/* 5090 */       return null;
/*      */     }
/* 5092 */     return paramString.toUpperCase(paramLocale);
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
/*      */   public static String lowerCase(String paramString) {
/* 5115 */     if (paramString == null) {
/* 5116 */       return null;
/*      */     }
/* 5118 */     return paramString.toLowerCase();
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
/*      */   public static String lowerCase(String paramString, Locale paramLocale) {
/* 5138 */     if (paramString == null) {
/* 5139 */       return null;
/*      */     }
/* 5141 */     return paramString.toLowerCase(paramLocale);
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
/*      */   public static String capitalize(String paramString) {
/*      */     int i;
/* 5166 */     if (paramString == null || (i = paramString.length()) == 0) {
/* 5167 */       return paramString;
/*      */     }
/* 5169 */     return (new StrBuilder(i)).append(Character.toTitleCase(paramString.charAt(0))).append(paramString.substring(1)).toString();
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
/*      */   public static String capitalise(String paramString) {
/* 5185 */     return capitalize(paramString);
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
/*      */   public static String uncapitalize(String paramString) {
/*      */     int i;
/* 5210 */     if (paramString == null || (i = paramString.length()) == 0) {
/* 5211 */       return paramString;
/*      */     }
/* 5213 */     return (new StrBuilder(i)).append(Character.toLowerCase(paramString.charAt(0))).append(paramString.substring(1)).toString();
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
/*      */   public static String uncapitalise(String paramString) {
/* 5229 */     return uncapitalize(paramString);
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
/*      */   public static String swapCase(String paramString) {
/*      */     int i;
/* 5261 */     if (paramString == null || (i = paramString.length()) == 0) {
/* 5262 */       return paramString;
/*      */     }
/* 5264 */     StrBuilder strBuilder = new StrBuilder(i);
/*      */     
/* 5266 */     char c = Character.MIN_VALUE;
/* 5267 */     for (byte b = 0; b < i; b++) {
/* 5268 */       c = paramString.charAt(b);
/* 5269 */       if (Character.isUpperCase(c)) {
/* 5270 */         c = Character.toLowerCase(c);
/* 5271 */       } else if (Character.isTitleCase(c)) {
/* 5272 */         c = Character.toLowerCase(c);
/* 5273 */       } else if (Character.isLowerCase(c)) {
/* 5274 */         c = Character.toUpperCase(c);
/*      */       } 
/* 5276 */       strBuilder.append(c);
/*      */     } 
/* 5278 */     return strBuilder.toString();
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
/*      */   public static String capitaliseAllWords(String paramString) {
/* 5294 */     return WordUtils.capitalize(paramString);
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
/*      */   public static int countMatches(String paramString1, String paramString2) {
/* 5319 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 5320 */       return 0;
/*      */     }
/* 5322 */     byte b = 0;
/* 5323 */     int i = 0;
/* 5324 */     while ((i = paramString1.indexOf(paramString2, i)) != -1) {
/* 5325 */       b++;
/* 5326 */       i += paramString2.length();
/*      */     } 
/* 5328 */     return b;
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
/*      */   public static boolean isAlpha(String paramString) {
/* 5352 */     if (paramString == null) {
/* 5353 */       return false;
/*      */     }
/* 5355 */     int i = paramString.length();
/* 5356 */     for (byte b = 0; b < i; b++) {
/* 5357 */       if (!Character.isLetter(paramString.charAt(b))) {
/* 5358 */         return false;
/*      */       }
/*      */     } 
/* 5361 */     return true;
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
/*      */   public static boolean isAlphaSpace(String paramString) {
/* 5386 */     if (paramString == null) {
/* 5387 */       return false;
/*      */     }
/* 5389 */     int i = paramString.length();
/* 5390 */     for (byte b = 0; b < i; b++) {
/* 5391 */       if (!Character.isLetter(paramString.charAt(b)) && paramString.charAt(b) != ' ') {
/* 5392 */         return false;
/*      */       }
/*      */     } 
/* 5395 */     return true;
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
/*      */   public static boolean isAlphanumeric(String paramString) {
/* 5419 */     if (paramString == null) {
/* 5420 */       return false;
/*      */     }
/* 5422 */     int i = paramString.length();
/* 5423 */     for (byte b = 0; b < i; b++) {
/* 5424 */       if (!Character.isLetterOrDigit(paramString.charAt(b))) {
/* 5425 */         return false;
/*      */       }
/*      */     } 
/* 5428 */     return true;
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
/*      */   public static boolean isAlphanumericSpace(String paramString) {
/* 5453 */     if (paramString == null) {
/* 5454 */       return false;
/*      */     }
/* 5456 */     int i = paramString.length();
/* 5457 */     for (byte b = 0; b < i; b++) {
/* 5458 */       if (!Character.isLetterOrDigit(paramString.charAt(b)) && paramString.charAt(b) != ' ') {
/* 5459 */         return false;
/*      */       }
/*      */     } 
/* 5462 */     return true;
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
/*      */   public static boolean isAsciiPrintable(String paramString) {
/* 5491 */     if (paramString == null) {
/* 5492 */       return false;
/*      */     }
/* 5494 */     int i = paramString.length();
/* 5495 */     for (byte b = 0; b < i; b++) {
/* 5496 */       if (!CharUtils.isAsciiPrintable(paramString.charAt(b))) {
/* 5497 */         return false;
/*      */       }
/*      */     } 
/* 5500 */     return true;
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
/*      */   public static boolean isNumeric(String paramString) {
/* 5525 */     if (paramString == null) {
/* 5526 */       return false;
/*      */     }
/* 5528 */     int i = paramString.length();
/* 5529 */     for (byte b = 0; b < i; b++) {
/* 5530 */       if (!Character.isDigit(paramString.charAt(b))) {
/* 5531 */         return false;
/*      */       }
/*      */     } 
/* 5534 */     return true;
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
/*      */   public static boolean isNumericSpace(String paramString) {
/* 5561 */     if (paramString == null) {
/* 5562 */       return false;
/*      */     }
/* 5564 */     int i = paramString.length();
/* 5565 */     for (byte b = 0; b < i; b++) {
/* 5566 */       if (!Character.isDigit(paramString.charAt(b)) && paramString.charAt(b) != ' ') {
/* 5567 */         return false;
/*      */       }
/*      */     } 
/* 5570 */     return true;
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
/*      */   public static boolean isWhitespace(String paramString) {
/* 5593 */     if (paramString == null) {
/* 5594 */       return false;
/*      */     }
/* 5596 */     int i = paramString.length();
/* 5597 */     for (byte b = 0; b < i; b++) {
/* 5598 */       if (!Character.isWhitespace(paramString.charAt(b))) {
/* 5599 */         return false;
/*      */       }
/*      */     } 
/* 5602 */     return true;
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
/*      */   public static boolean isAllLowerCase(String paramString) {
/* 5624 */     if (paramString == null || isEmpty(paramString)) {
/* 5625 */       return false;
/*      */     }
/* 5627 */     int i = paramString.length();
/* 5628 */     for (byte b = 0; b < i; b++) {
/* 5629 */       if (!Character.isLowerCase(paramString.charAt(b))) {
/* 5630 */         return false;
/*      */       }
/*      */     } 
/* 5633 */     return true;
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
/*      */   public static boolean isAllUpperCase(String paramString) {
/* 5655 */     if (paramString == null || isEmpty(paramString)) {
/* 5656 */       return false;
/*      */     }
/* 5658 */     int i = paramString.length();
/* 5659 */     for (byte b = 0; b < i; b++) {
/* 5660 */       if (!Character.isUpperCase(paramString.charAt(b))) {
/* 5661 */         return false;
/*      */       }
/*      */     } 
/* 5664 */     return true;
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
/*      */   public static String defaultString(String paramString) {
/* 5686 */     return (paramString == null) ? "" : paramString;
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
/*      */   public static String defaultString(String paramString1, String paramString2) {
/* 5707 */     return (paramString1 == null) ? paramString2 : paramString1;
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
/*      */   public static String defaultIfBlank(String paramString1, String paramString2) {
/* 5729 */     return isBlank(paramString1) ? paramString2 : paramString1;
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
/*      */   public static String defaultIfEmpty(String paramString1, String paramString2) {
/* 5750 */     return isEmpty(paramString1) ? paramString2 : paramString1;
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
/*      */   public static String reverse(String paramString) {
/* 5770 */     if (paramString == null) {
/* 5771 */       return null;
/*      */     }
/* 5773 */     return (new StrBuilder(paramString)).reverse().toString();
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
/*      */   public static String reverseDelimited(String paramString, char paramChar) {
/* 5796 */     if (paramString == null) {
/* 5797 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 5801 */     String[] arrayOfString = split(paramString, paramChar);
/* 5802 */     ArrayUtils.reverse((Object[])arrayOfString);
/* 5803 */     return join((Object[])arrayOfString, paramChar);
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
/*      */   public static String reverseDelimitedString(String paramString1, String paramString2) {
/* 5829 */     if (paramString1 == null) {
/* 5830 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 5834 */     String[] arrayOfString = split(paramString1, paramString2);
/* 5835 */     ArrayUtils.reverse((Object[])arrayOfString);
/* 5836 */     if (paramString2 == null) {
/* 5837 */       return join((Object[])arrayOfString, ' ');
/*      */     }
/* 5839 */     return join((Object[])arrayOfString, paramString2);
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
/*      */   public static String abbreviate(String paramString, int paramInt) {
/* 5877 */     return abbreviate(paramString, 0, paramInt);
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
/*      */   public static String abbreviate(String paramString, int paramInt1, int paramInt2) {
/* 5916 */     if (paramString == null) {
/* 5917 */       return null;
/*      */     }
/* 5919 */     if (paramInt2 < 4) {
/* 5920 */       throw new IllegalArgumentException("Minimum abbreviation width is 4");
/*      */     }
/* 5922 */     if (paramString.length() <= paramInt2) {
/* 5923 */       return paramString;
/*      */     }
/* 5925 */     if (paramInt1 > paramString.length()) {
/* 5926 */       paramInt1 = paramString.length();
/*      */     }
/* 5928 */     if (paramString.length() - paramInt1 < paramInt2 - 3) {
/* 5929 */       paramInt1 = paramString.length() - paramInt2 - 3;
/*      */     }
/* 5931 */     if (paramInt1 <= 4) {
/* 5932 */       return paramString.substring(0, paramInt2 - 3) + "...";
/*      */     }
/* 5934 */     if (paramInt2 < 7) {
/* 5935 */       throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
/*      */     }
/* 5937 */     if (paramInt1 + paramInt2 - 3 < paramString.length()) {
/* 5938 */       return "..." + abbreviate(paramString.substring(paramInt1), paramInt2 - 3);
/*      */     }
/* 5940 */     return "..." + paramString.substring(paramString.length() - paramInt2 - 3);
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
/*      */   public static String abbreviateMiddle(String paramString1, String paramString2, int paramInt) {
/* 5973 */     if (isEmpty(paramString1) || isEmpty(paramString2)) {
/* 5974 */       return paramString1;
/*      */     }
/*      */     
/* 5977 */     if (paramInt >= paramString1.length() || paramInt < paramString2.length() + 2) {
/* 5978 */       return paramString1;
/*      */     }
/*      */     
/* 5981 */     int i = paramInt - paramString2.length();
/* 5982 */     int j = i / 2 + i % 2;
/* 5983 */     int k = paramString1.length() - i / 2;
/*      */     
/* 5985 */     StrBuilder strBuilder = new StrBuilder(paramInt);
/* 5986 */     strBuilder.append(paramString1.substring(0, j));
/* 5987 */     strBuilder.append(paramString2);
/* 5988 */     strBuilder.append(paramString1.substring(k));
/*      */     
/* 5990 */     return strBuilder.toString();
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
/*      */   public static String difference(String paramString1, String paramString2) {
/* 6021 */     if (paramString1 == null) {
/* 6022 */       return paramString2;
/*      */     }
/* 6024 */     if (paramString2 == null) {
/* 6025 */       return paramString1;
/*      */     }
/* 6027 */     int i = indexOfDifference(paramString1, paramString2);
/* 6028 */     if (i == -1) {
/* 6029 */       return "";
/*      */     }
/* 6031 */     return paramString2.substring(i);
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
/*      */   public static int indexOfDifference(String paramString1, String paramString2) {
/* 6058 */     if (paramString1 == paramString2) {
/* 6059 */       return -1;
/*      */     }
/* 6061 */     if (paramString1 == null || paramString2 == null) {
/* 6062 */       return 0;
/*      */     }
/*      */     byte b;
/* 6065 */     for (b = 0; b < paramString1.length() && b < paramString2.length() && 
/* 6066 */       paramString1.charAt(b) == paramString2.charAt(b); b++);
/*      */ 
/*      */ 
/*      */     
/* 6070 */     if (b < paramString2.length() || b < paramString1.length()) {
/* 6071 */       return b;
/*      */     }
/* 6073 */     return -1;
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
/*      */   public static int indexOfDifference(String[] paramArrayOfString) {
/* 6108 */     if (paramArrayOfString == null || paramArrayOfString.length <= 1) {
/* 6109 */       return -1;
/*      */     }
/* 6111 */     boolean bool1 = false;
/* 6112 */     boolean bool2 = true;
/* 6113 */     int i = paramArrayOfString.length;
/* 6114 */     int j = Integer.MAX_VALUE;
/* 6115 */     int k = 0;
/*      */ 
/*      */     
/*      */     byte b;
/*      */     
/* 6120 */     for (b = 0; b < i; b++) {
/* 6121 */       if (paramArrayOfString[b] == null) {
/* 6122 */         bool1 = true;
/* 6123 */         j = 0;
/*      */       } else {
/* 6125 */         bool2 = false;
/* 6126 */         j = Math.min(paramArrayOfString[b].length(), j);
/* 6127 */         k = Math.max(paramArrayOfString[b].length(), k);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 6132 */     if (bool2 || (k == 0 && !bool1)) {
/* 6133 */       return -1;
/*      */     }
/*      */ 
/*      */     
/* 6137 */     if (j == 0) {
/* 6138 */       return 0;
/*      */     }
/*      */ 
/*      */     
/* 6142 */     b = -1;
/* 6143 */     for (byte b1 = 0; b1 < j; b1++) {
/* 6144 */       char c = paramArrayOfString[0].charAt(b1);
/* 6145 */       for (byte b2 = 1; b2 < i; b2++) {
/* 6146 */         if (paramArrayOfString[b2].charAt(b1) != c) {
/* 6147 */           b = b1;
/*      */           break;
/*      */         } 
/*      */       } 
/* 6151 */       if (b != -1) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */     
/* 6156 */     if (b == -1 && j != k)
/*      */     {
/*      */ 
/*      */       
/* 6160 */       return j;
/*      */     }
/* 6162 */     return b;
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
/*      */   public static String getCommonPrefix(String[] paramArrayOfString) {
/* 6199 */     if (paramArrayOfString == null || paramArrayOfString.length == 0) {
/* 6200 */       return "";
/*      */     }
/* 6202 */     int i = indexOfDifference(paramArrayOfString);
/* 6203 */     if (i == -1) {
/*      */       
/* 6205 */       if (paramArrayOfString[0] == null) {
/* 6206 */         return "";
/*      */       }
/* 6208 */       return paramArrayOfString[0];
/* 6209 */     }  if (i == 0)
/*      */     {
/* 6211 */       return "";
/*      */     }
/*      */     
/* 6214 */     return paramArrayOfString[0].substring(0, i);
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
/*      */   public static int getLevenshteinDistance(String paramString1, String paramString2) {
/* 6255 */     if (paramString1 == null || paramString2 == null) {
/* 6256 */       throw new IllegalArgumentException("Strings must not be null");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6276 */     int i = paramString1.length();
/* 6277 */     int j = paramString2.length();
/*      */     
/* 6279 */     if (i == 0)
/* 6280 */       return j; 
/* 6281 */     if (j == 0) {
/* 6282 */       return i;
/*      */     }
/*      */     
/* 6285 */     if (i > j) {
/*      */       
/* 6287 */       String str = paramString1;
/* 6288 */       paramString1 = paramString2;
/* 6289 */       paramString2 = str;
/* 6290 */       i = j;
/* 6291 */       j = paramString2.length();
/*      */     } 
/*      */     
/* 6294 */     int[] arrayOfInt1 = new int[i + 1];
/* 6295 */     int[] arrayOfInt2 = new int[i + 1];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     byte b1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 6306 */     for (b1 = 0; b1 <= i; b1++) {
/* 6307 */       arrayOfInt1[b1] = b1;
/*      */     }
/*      */     
/* 6310 */     for (byte b2 = 1; b2 <= j; b2++) {
/* 6311 */       char c = paramString2.charAt(b2 - 1);
/* 6312 */       arrayOfInt2[0] = b2;
/*      */       
/* 6314 */       for (b1 = 1; b1 <= i; b1++) {
/* 6315 */         byte b = (paramString1.charAt(b1 - 1) == c) ? 0 : 1;
/*      */         
/* 6317 */         arrayOfInt2[b1] = Math.min(Math.min(arrayOfInt2[b1 - 1] + 1, arrayOfInt1[b1] + 1), arrayOfInt1[b1 - 1] + b);
/*      */       } 
/*      */ 
/*      */       
/* 6321 */       int[] arrayOfInt = arrayOfInt1;
/* 6322 */       arrayOfInt1 = arrayOfInt2;
/* 6323 */       arrayOfInt2 = arrayOfInt;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 6328 */     return arrayOfInt1[i];
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
/*      */   public static boolean startsWith(String paramString1, String paramString2) {
/* 6356 */     return startsWith(paramString1, paramString2, false);
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
/*      */   public static boolean startsWithIgnoreCase(String paramString1, String paramString2) {
/* 6381 */     return startsWith(paramString1, paramString2, true);
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
/*      */   private static boolean startsWith(String paramString1, String paramString2, boolean paramBoolean) {
/* 6396 */     if (paramString1 == null || paramString2 == null) {
/* 6397 */       return (paramString1 == null && paramString2 == null);
/*      */     }
/* 6399 */     if (paramString2.length() > paramString1.length()) {
/* 6400 */       return false;
/*      */     }
/* 6402 */     return paramString1.regionMatches(paramBoolean, 0, paramString2, 0, paramString2.length());
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
/*      */   public static boolean startsWithAny(String paramString, String[] paramArrayOfString) {
/* 6425 */     if (isEmpty(paramString) || ArrayUtils.isEmpty((Object[])paramArrayOfString)) {
/* 6426 */       return false;
/*      */     }
/* 6428 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 6429 */       String str = paramArrayOfString[b];
/* 6430 */       if (startsWith(paramString, str)) {
/* 6431 */         return true;
/*      */       }
/*      */     } 
/* 6434 */     return false;
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
/*      */   public static boolean endsWith(String paramString1, String paramString2) {
/* 6463 */     return endsWith(paramString1, paramString2, false);
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
/*      */   public static boolean endsWithIgnoreCase(String paramString1, String paramString2) {
/* 6489 */     return endsWith(paramString1, paramString2, true);
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
/*      */   private static boolean endsWith(String paramString1, String paramString2, boolean paramBoolean) {
/* 6504 */     if (paramString1 == null || paramString2 == null) {
/* 6505 */       return (paramString1 == null && paramString2 == null);
/*      */     }
/* 6507 */     if (paramString2.length() > paramString1.length()) {
/* 6508 */       return false;
/*      */     }
/* 6510 */     int i = paramString1.length() - paramString2.length();
/* 6511 */     return paramString1.regionMatches(paramBoolean, i, paramString2, 0, paramString2.length());
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
/*      */   public static String normalizeSpace(String paramString) {
/* 6545 */     paramString = strip(paramString);
/* 6546 */     if (paramString == null || paramString.length() <= 2) {
/* 6547 */       return paramString;
/*      */     }
/* 6549 */     StrBuilder strBuilder = new StrBuilder(paramString.length());
/* 6550 */     for (byte b = 0; b < paramString.length(); b++) {
/* 6551 */       char c = paramString.charAt(b);
/* 6552 */       if (Character.isWhitespace(c)) {
/* 6553 */         if (b > 0 && !Character.isWhitespace(paramString.charAt(b - 1))) {
/* 6554 */           strBuilder.append(' ');
/*      */         }
/*      */       } else {
/* 6557 */         strBuilder.append(c);
/*      */       } 
/*      */     } 
/* 6560 */     return strBuilder.toString();
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
/*      */   public static boolean endsWithAny(String paramString, String[] paramArrayOfString) {
/* 6582 */     if (isEmpty(paramString) || ArrayUtils.isEmpty((Object[])paramArrayOfString)) {
/* 6583 */       return false;
/*      */     }
/* 6585 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 6586 */       String str = paramArrayOfString[b];
/* 6587 */       if (endsWith(paramString, str)) {
/* 6588 */         return true;
/*      */       }
/*      */     } 
/* 6591 */     return false;
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/StringUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */