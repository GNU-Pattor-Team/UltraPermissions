/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.time;
/*      */ 
/*      */ import java.text.ParseException;
/*      */ import java.text.ParsePosition;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.TimeZone;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DateUtils
/*      */ {
/*   61 */   public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long MILLIS_PER_SECOND = 1000L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long MILLIS_PER_MINUTE = 60000L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long MILLIS_PER_HOUR = 3600000L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final long MILLIS_PER_DAY = 86400000L;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int SEMI_MONTH = 1001;
/*      */ 
/*      */ 
/*      */   
/*   89 */   private static final int[][] fields = new int[][] { { 14 }, { 13 }, { 12 }, { 11, 10 }, { 5, 5, 9 }, { 2, 1001 }, { 1 }, { 0 } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_SUNDAY = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_MONDAY = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_RELATIVE = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_CENTER = 4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_MONTH_SUNDAY = 5;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_MONTH_MONDAY = 6;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MODIFY_TRUNCATE = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MODIFY_ROUND = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MODIFY_CEILING = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int MILLIS_IN_SECOND = 1000;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int MILLIS_IN_MINUTE = 60000;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int MILLIS_IN_HOUR = 3600000;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int MILLIS_IN_DAY = 86400000;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameDay(Date paramDate1, Date paramDate2) {
/*  173 */     if (paramDate1 == null || paramDate2 == null) {
/*  174 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  176 */     Calendar calendar1 = Calendar.getInstance();
/*  177 */     calendar1.setTime(paramDate1);
/*  178 */     Calendar calendar2 = Calendar.getInstance();
/*  179 */     calendar2.setTime(paramDate2);
/*  180 */     return isSameDay(calendar1, calendar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameDay(Calendar paramCalendar1, Calendar paramCalendar2) {
/*  197 */     if (paramCalendar1 == null || paramCalendar2 == null) {
/*  198 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  200 */     return (paramCalendar1.get(0) == paramCalendar2.get(0) && paramCalendar1.get(1) == paramCalendar2.get(1) && paramCalendar1.get(6) == paramCalendar2.get(6));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameInstant(Date paramDate1, Date paramDate2) {
/*  218 */     if (paramDate1 == null || paramDate2 == null) {
/*  219 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  221 */     return (paramDate1.getTime() == paramDate2.getTime());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameInstant(Calendar paramCalendar1, Calendar paramCalendar2) {
/*  236 */     if (paramCalendar1 == null || paramCalendar2 == null) {
/*  237 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  239 */     return (paramCalendar1.getTime().getTime() == paramCalendar2.getTime().getTime());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameLocalTime(Calendar paramCalendar1, Calendar paramCalendar2) {
/*  256 */     if (paramCalendar1 == null || paramCalendar2 == null) {
/*  257 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  259 */     return (paramCalendar1.get(14) == paramCalendar2.get(14) && paramCalendar1.get(13) == paramCalendar2.get(13) && paramCalendar1.get(12) == paramCalendar2.get(12) && paramCalendar1.get(10) == paramCalendar2.get(10) && paramCalendar1.get(6) == paramCalendar2.get(6) && paramCalendar1.get(1) == paramCalendar2.get(1) && paramCalendar1.get(0) == paramCalendar2.get(0) && paramCalendar1.getClass() == paramCalendar2.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date parseDate(String paramString, String[] paramArrayOfString) {
/*  285 */     return parseDateWithLeniency(paramString, paramArrayOfString, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date parseDateStrictly(String paramString, String[] paramArrayOfString) {
/*  305 */     return parseDateWithLeniency(paramString, paramArrayOfString, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Date parseDateWithLeniency(String paramString, String[] paramArrayOfString, boolean paramBoolean) {
/*  325 */     if (paramString == null || paramArrayOfString == null) {
/*  326 */       throw new IllegalArgumentException("Date and Patterns must not be null");
/*      */     }
/*      */     
/*  329 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
/*  330 */     simpleDateFormat.setLenient(paramBoolean);
/*  331 */     ParsePosition parsePosition = new ParsePosition(0);
/*  332 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*      */       
/*  334 */       String str1 = paramArrayOfString[b];
/*      */ 
/*      */       
/*  337 */       if (paramArrayOfString[b].endsWith("ZZ")) {
/*  338 */         str1 = str1.substring(0, str1.length() - 1);
/*      */       }
/*      */       
/*  341 */       simpleDateFormat.applyPattern(str1);
/*  342 */       parsePosition.setIndex(0);
/*      */       
/*  344 */       String str2 = paramString;
/*      */       
/*  346 */       if (paramArrayOfString[b].endsWith("ZZ")) {
/*  347 */         int i = indexOfSignChars(str2, 0);
/*  348 */         while (i >= 0) {
/*  349 */           str2 = reformatTimezone(str2, i);
/*  350 */           i = indexOfSignChars(str2, ++i);
/*      */         } 
/*      */       } 
/*      */       
/*  354 */       Date date = simpleDateFormat.parse(str2, parsePosition);
/*  355 */       if (date != null && parsePosition.getIndex() == str2.length()) {
/*  356 */         return date;
/*      */       }
/*      */     } 
/*  359 */     throw new ParseException("Unable to parse the date: " + paramString, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int indexOfSignChars(String paramString, int paramInt) {
/*  370 */     int i = StringUtils.indexOf(paramString, '+', paramInt);
/*  371 */     if (i < 0) {
/*  372 */       i = StringUtils.indexOf(paramString, '-', paramInt);
/*      */     }
/*  374 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String reformatTimezone(String paramString, int paramInt) {
/*  385 */     String str = paramString;
/*  386 */     if (paramInt >= 0 && paramInt + 5 < paramString.length() && Character.isDigit(paramString.charAt(paramInt + 1)) && Character.isDigit(paramString.charAt(paramInt + 2)) && paramString.charAt(paramInt + 3) == ':' && Character.isDigit(paramString.charAt(paramInt + 4)) && Character.isDigit(paramString.charAt(paramInt + 5)))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  393 */       str = paramString.substring(0, paramInt + 3) + paramString.substring(paramInt + 4);
/*      */     }
/*  395 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addYears(Date paramDate, int paramInt) {
/*  409 */     return add(paramDate, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addMonths(Date paramDate, int paramInt) {
/*  423 */     return add(paramDate, 2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addWeeks(Date paramDate, int paramInt) {
/*  437 */     return add(paramDate, 3, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addDays(Date paramDate, int paramInt) {
/*  451 */     return add(paramDate, 5, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addHours(Date paramDate, int paramInt) {
/*  465 */     return add(paramDate, 11, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addMinutes(Date paramDate, int paramInt) {
/*  479 */     return add(paramDate, 12, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addSeconds(Date paramDate, int paramInt) {
/*  493 */     return add(paramDate, 13, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addMilliseconds(Date paramDate, int paramInt) {
/*  507 */     return add(paramDate, 14, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date add(Date paramDate, int paramInt1, int paramInt2) {
/*  523 */     if (paramDate == null) {
/*  524 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  526 */     Calendar calendar = Calendar.getInstance();
/*  527 */     calendar.setTime(paramDate);
/*  528 */     calendar.add(paramInt1, paramInt2);
/*  529 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setYears(Date paramDate, int paramInt) {
/*  544 */     return set(paramDate, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setMonths(Date paramDate, int paramInt) {
/*  559 */     return set(paramDate, 2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setDays(Date paramDate, int paramInt) {
/*  574 */     return set(paramDate, 5, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setHours(Date paramDate, int paramInt) {
/*  590 */     return set(paramDate, 11, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setMinutes(Date paramDate, int paramInt) {
/*  605 */     return set(paramDate, 12, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setSeconds(Date paramDate, int paramInt) {
/*  620 */     return set(paramDate, 13, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setMilliseconds(Date paramDate, int paramInt) {
/*  635 */     return set(paramDate, 14, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Date set(Date paramDate, int paramInt1, int paramInt2) {
/*  652 */     if (paramDate == null) {
/*  653 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*      */     
/*  656 */     Calendar calendar = Calendar.getInstance();
/*  657 */     calendar.setLenient(false);
/*  658 */     calendar.setTime(paramDate);
/*  659 */     calendar.set(paramInt1, paramInt2);
/*  660 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar toCalendar(Date paramDate) {
/*  673 */     Calendar calendar = Calendar.getInstance();
/*  674 */     calendar.setTime(paramDate);
/*  675 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date round(Date paramDate, int paramInt) {
/*  708 */     if (paramDate == null) {
/*  709 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  711 */     Calendar calendar = Calendar.getInstance();
/*  712 */     calendar.setTime(paramDate);
/*  713 */     modify(calendar, paramInt, 1);
/*  714 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar round(Calendar paramCalendar, int paramInt) {
/*  746 */     if (paramCalendar == null) {
/*  747 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  749 */     Calendar calendar = (Calendar)paramCalendar.clone();
/*  750 */     modify(calendar, paramInt, 1);
/*  751 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date round(Object paramObject, int paramInt) {
/*  785 */     if (paramObject == null) {
/*  786 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  788 */     if (paramObject instanceof Date)
/*  789 */       return round((Date)paramObject, paramInt); 
/*  790 */     if (paramObject instanceof Calendar) {
/*  791 */       return round((Calendar)paramObject, paramInt).getTime();
/*      */     }
/*  793 */     throw new ClassCastException("Could not round " + paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date truncate(Date paramDate, int paramInt) {
/*  815 */     if (paramDate == null) {
/*  816 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  818 */     Calendar calendar = Calendar.getInstance();
/*  819 */     calendar.setTime(paramDate);
/*  820 */     modify(calendar, paramInt, 0);
/*  821 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar truncate(Calendar paramCalendar, int paramInt) {
/*  841 */     if (paramCalendar == null) {
/*  842 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  844 */     Calendar calendar = (Calendar)paramCalendar.clone();
/*  845 */     modify(calendar, paramInt, 0);
/*  846 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date truncate(Object paramObject, int paramInt) {
/*  870 */     if (paramObject == null) {
/*  871 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  873 */     if (paramObject instanceof Date)
/*  874 */       return truncate((Date)paramObject, paramInt); 
/*  875 */     if (paramObject instanceof Calendar) {
/*  876 */       return truncate((Calendar)paramObject, paramInt).getTime();
/*      */     }
/*  878 */     throw new ClassCastException("Could not truncate " + paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date ceiling(Date paramDate, int paramInt) {
/*  901 */     if (paramDate == null) {
/*  902 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  904 */     Calendar calendar = Calendar.getInstance();
/*  905 */     calendar.setTime(paramDate);
/*  906 */     modify(calendar, paramInt, 2);
/*  907 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar ceiling(Calendar paramCalendar, int paramInt) {
/*  928 */     if (paramCalendar == null) {
/*  929 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  931 */     Calendar calendar = (Calendar)paramCalendar.clone();
/*  932 */     modify(calendar, paramInt, 2);
/*  933 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date ceiling(Object paramObject, int paramInt) {
/*  958 */     if (paramObject == null) {
/*  959 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/*  961 */     if (paramObject instanceof Date)
/*  962 */       return ceiling((Date)paramObject, paramInt); 
/*  963 */     if (paramObject instanceof Calendar) {
/*  964 */       return ceiling((Calendar)paramObject, paramInt).getTime();
/*      */     }
/*  966 */     throw new ClassCastException("Could not find ceiling of for type: " + paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void modify(Calendar paramCalendar, int paramInt1, int paramInt2) {
/*  980 */     if (paramCalendar.get(1) > 280000000) {
/*  981 */       throw new ArithmeticException("Calendar value too large for accurate calculations");
/*      */     }
/*      */     
/*  984 */     if (paramInt1 == 14) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  994 */     Date date = paramCalendar.getTime();
/*  995 */     long l = date.getTime();
/*  996 */     boolean bool1 = false;
/*      */ 
/*      */     
/*  999 */     int i = paramCalendar.get(14);
/* 1000 */     if (0 == paramInt2 || i < 500) {
/* 1001 */       l -= i;
/*      */     }
/* 1003 */     if (paramInt1 == 13) {
/* 1004 */       bool1 = true;
/*      */     }
/*      */ 
/*      */     
/* 1008 */     int j = paramCalendar.get(13);
/* 1009 */     if (!bool1 && (0 == paramInt2 || j < 30)) {
/* 1010 */       l -= j * 1000L;
/*      */     }
/* 1012 */     if (paramInt1 == 12) {
/* 1013 */       bool1 = true;
/*      */     }
/*      */ 
/*      */     
/* 1017 */     int k = paramCalendar.get(12);
/* 1018 */     if (!bool1 && (0 == paramInt2 || k < 30)) {
/* 1019 */       l -= k * 60000L;
/*      */     }
/*      */ 
/*      */     
/* 1023 */     if (date.getTime() != l) {
/* 1024 */       date.setTime(l);
/* 1025 */       paramCalendar.setTime(date);
/*      */     } 
/*      */ 
/*      */     
/* 1029 */     boolean bool2 = false;
/* 1030 */     for (byte b = 0; b < fields.length; b++) {
/* 1031 */       int m; for (m = 0; m < (fields[b]).length; m++) {
/* 1032 */         if (fields[b][m] == paramInt1) {
/*      */           
/* 1034 */           if (paramInt2 == 2 || (paramInt2 == 1 && bool2)) {
/* 1035 */             if (paramInt1 == 1001) {
/*      */ 
/*      */ 
/*      */               
/* 1039 */               if (paramCalendar.get(5) == 1) {
/* 1040 */                 paramCalendar.add(5, 15);
/*      */               } else {
/* 1042 */                 paramCalendar.add(5, -15);
/* 1043 */                 paramCalendar.add(2, 1);
/*      */               }
/*      */             
/* 1046 */             } else if (paramInt1 == 9) {
/*      */ 
/*      */ 
/*      */               
/* 1050 */               if (paramCalendar.get(11) == 0) {
/* 1051 */                 paramCalendar.add(11, 12);
/*      */               } else {
/* 1053 */                 paramCalendar.add(11, -12);
/* 1054 */                 paramCalendar.add(5, 1);
/*      */               }
/*      */             
/*      */             }
/*      */             else {
/*      */               
/* 1060 */               paramCalendar.add(fields[b][0], 1);
/*      */             } 
/*      */           }
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/* 1067 */       m = 0;
/* 1068 */       boolean bool = false;
/*      */       
/* 1070 */       switch (paramInt1) {
/*      */         case 1001:
/* 1072 */           if (fields[b][0] == 5) {
/*      */ 
/*      */ 
/*      */             
/* 1076 */             m = paramCalendar.get(5) - 1;
/*      */ 
/*      */             
/* 1079 */             if (m >= 15) {
/* 1080 */               m -= 15;
/*      */             }
/*      */             
/* 1083 */             bool2 = (m > 7) ? true : false;
/* 1084 */             bool = true;
/*      */           } 
/*      */           break;
/*      */         case 9:
/* 1088 */           if (fields[b][0] == 11) {
/*      */ 
/*      */             
/* 1091 */             m = paramCalendar.get(11);
/* 1092 */             if (m >= 12) {
/* 1093 */               m -= 12;
/*      */             }
/* 1095 */             bool2 = (m >= 6) ? true : false;
/* 1096 */             bool = true;
/*      */           } 
/*      */           break;
/*      */       } 
/* 1100 */       if (!bool) {
/* 1101 */         int n = paramCalendar.getActualMinimum(fields[b][0]);
/* 1102 */         int i1 = paramCalendar.getActualMaximum(fields[b][0]);
/*      */         
/* 1104 */         m = paramCalendar.get(fields[b][0]) - n;
/*      */         
/* 1106 */         bool2 = (m > (i1 - n) / 2) ? true : false;
/*      */       } 
/*      */       
/* 1109 */       if (m != 0) {
/* 1110 */         paramCalendar.set(fields[b][0], paramCalendar.get(fields[b][0]) - m);
/*      */       }
/*      */     } 
/* 1113 */     throw new IllegalArgumentException("The field " + paramInt1 + " is not supported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator iterator(Date paramDate, int paramInt) {
/* 1143 */     if (paramDate == null) {
/* 1144 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/* 1146 */     Calendar calendar = Calendar.getInstance();
/* 1147 */     calendar.setTime(paramDate);
/* 1148 */     return iterator(calendar, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator iterator(Calendar paramCalendar, int paramInt) {
/* 1176 */     if (paramCalendar == null) {
/* 1177 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/* 1179 */     Calendar calendar1 = null;
/* 1180 */     Calendar calendar2 = null;
/* 1181 */     int i = 1;
/* 1182 */     int j = 7;
/* 1183 */     switch (paramInt) {
/*      */       
/*      */       case 5:
/*      */       case 6:
/* 1187 */         calendar1 = truncate(paramCalendar, 2);
/*      */         
/* 1189 */         calendar2 = (Calendar)calendar1.clone();
/* 1190 */         calendar2.add(2, 1);
/* 1191 */         calendar2.add(5, -1);
/*      */         
/* 1193 */         if (paramInt == 6) {
/* 1194 */           i = 2;
/* 1195 */           j = 1;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/* 1203 */         calendar1 = truncate(paramCalendar, 5);
/* 1204 */         calendar2 = truncate(paramCalendar, 5);
/* 1205 */         switch (paramInt) {
/*      */ 
/*      */ 
/*      */           
/*      */           case 2:
/* 1210 */             i = 2;
/* 1211 */             j = 1;
/*      */             break;
/*      */           case 3:
/* 1214 */             i = paramCalendar.get(7);
/* 1215 */             j = i - 1;
/*      */             break;
/*      */           case 4:
/* 1218 */             i = paramCalendar.get(7) - 3;
/* 1219 */             j = paramCalendar.get(7) + 3;
/*      */             break;
/*      */         } 
/*      */         break;
/*      */       default:
/* 1224 */         throw new IllegalArgumentException("The range style " + paramInt + " is not valid.");
/*      */     } 
/* 1226 */     if (i < 1) {
/* 1227 */       i += 7;
/*      */     }
/* 1229 */     if (i > 7) {
/* 1230 */       i -= 7;
/*      */     }
/* 1232 */     if (j < 1) {
/* 1233 */       j += 7;
/*      */     }
/* 1235 */     if (j > 7) {
/* 1236 */       j -= 7;
/*      */     }
/* 1238 */     while (calendar1.get(7) != i) {
/* 1239 */       calendar1.add(5, -1);
/*      */     }
/* 1241 */     while (calendar2.get(7) != j) {
/* 1242 */       calendar2.add(5, 1);
/*      */     }
/* 1244 */     return new DateIterator(calendar1, calendar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator iterator(Object paramObject, int paramInt) {
/* 1267 */     if (paramObject == null) {
/* 1268 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/* 1270 */     if (paramObject instanceof Date)
/* 1271 */       return iterator((Date)paramObject, paramInt); 
/* 1272 */     if (paramObject instanceof Calendar) {
/* 1273 */       return iterator((Calendar)paramObject, paramInt);
/*      */     }
/* 1275 */     throw new ClassCastException("Could not iterate based on " + paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMilliseconds(Date paramDate, int paramInt) {
/* 1313 */     return getFragment(paramDate, paramInt, 14);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInSeconds(Date paramDate, int paramInt) {
/* 1353 */     return getFragment(paramDate, paramInt, 13);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMinutes(Date paramDate, int paramInt) {
/* 1393 */     return getFragment(paramDate, paramInt, 12);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInHours(Date paramDate, int paramInt) {
/* 1433 */     return getFragment(paramDate, paramInt, 11);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInDays(Date paramDate, int paramInt) {
/* 1473 */     return getFragment(paramDate, paramInt, 6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMilliseconds(Calendar paramCalendar, int paramInt) {
/* 1513 */     return getFragment(paramCalendar, paramInt, 14);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInSeconds(Calendar paramCalendar, int paramInt) {
/* 1552 */     return getFragment(paramCalendar, paramInt, 13);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMinutes(Calendar paramCalendar, int paramInt) {
/* 1592 */     return getFragment(paramCalendar, paramInt, 12);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInHours(Calendar paramCalendar, int paramInt) {
/* 1632 */     return getFragment(paramCalendar, paramInt, 11);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInDays(Calendar paramCalendar, int paramInt) {
/* 1674 */     return getFragment(paramCalendar, paramInt, 6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getFragment(Date paramDate, int paramInt1, int paramInt2) {
/* 1689 */     if (paramDate == null) {
/* 1690 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/* 1692 */     Calendar calendar = Calendar.getInstance();
/* 1693 */     calendar.setTime(paramDate);
/* 1694 */     return getFragment(calendar, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getFragment(Calendar paramCalendar, int paramInt1, int paramInt2) {
/* 1709 */     if (paramCalendar == null) {
/* 1710 */       throw new IllegalArgumentException("The date must not be null");
/*      */     }
/* 1712 */     long l1 = getMillisPerUnit(paramInt2);
/* 1713 */     long l2 = 0L;
/*      */ 
/*      */     
/* 1716 */     switch (paramInt1) {
/*      */       case 1:
/* 1718 */         l2 += paramCalendar.get(6) * 86400000L / l1;
/*      */         break;
/*      */       case 2:
/* 1721 */         l2 += paramCalendar.get(5) * 86400000L / l1;
/*      */         break;
/*      */     } 
/*      */     
/* 1725 */     switch (paramInt1) {
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 5:
/*      */       case 6:
/* 1733 */         l2 += paramCalendar.get(11) * 3600000L / l1;
/*      */       
/*      */       case 11:
/* 1736 */         l2 += paramCalendar.get(12) * 60000L / l1;
/*      */       
/*      */       case 12:
/* 1739 */         l2 += paramCalendar.get(13) * 1000L / l1;
/*      */       
/*      */       case 13:
/* 1742 */         l2 += (paramCalendar.get(14) * 1) / l1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 14:
/* 1749 */         return l2;
/*      */     } 
/*      */     throw new IllegalArgumentException("The fragment " + paramInt1 + " is not supported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean truncatedEquals(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt) {
/* 1766 */     return (truncatedCompareTo(paramCalendar1, paramCalendar2, paramInt) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean truncatedEquals(Date paramDate1, Date paramDate2, int paramInt) {
/* 1783 */     return (truncatedCompareTo(paramDate1, paramDate2, paramInt) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int truncatedCompareTo(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt) {
/* 1801 */     Calendar calendar1 = truncate(paramCalendar1, paramInt);
/* 1802 */     Calendar calendar2 = truncate(paramCalendar2, paramInt);
/* 1803 */     return calendar1.getTime().compareTo(calendar2.getTime());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int truncatedCompareTo(Date paramDate1, Date paramDate2, int paramInt) {
/* 1821 */     Date date1 = truncate(paramDate1, paramInt);
/* 1822 */     Date date2 = truncate(paramDate2, paramInt);
/* 1823 */     return date1.compareTo(date2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getMillisPerUnit(int paramInt) {
/* 1835 */     long l = Long.MAX_VALUE;
/* 1836 */     switch (paramInt) {
/*      */       case 5:
/*      */       case 6:
/* 1839 */         l = 86400000L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1855 */         return l;case 11: l = 3600000L; return l;case 12: l = 60000L; return l;case 13: l = 1000L; return l;case 14: l = 1L; return l;
/*      */     } 
/*      */     throw new IllegalArgumentException("The unit " + paramInt + " cannot be represented is milleseconds");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class DateIterator
/*      */     implements Iterator
/*      */   {
/*      */     private final Calendar endFinal;
/*      */ 
/*      */     
/*      */     private final Calendar spot;
/*      */ 
/*      */ 
/*      */     
/*      */     DateIterator(Calendar param1Calendar1, Calendar param1Calendar2) {
/* 1873 */       this.endFinal = param1Calendar2;
/* 1874 */       this.spot = param1Calendar1;
/* 1875 */       this.spot.add(5, -1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/* 1884 */       return this.spot.before(this.endFinal);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object next() {
/* 1893 */       if (this.spot.equals(this.endFinal)) {
/* 1894 */         throw new NoSuchElementException();
/*      */       }
/* 1896 */       this.spot.add(5, 1);
/* 1897 */       return this.spot.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1907 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/time/DateUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */