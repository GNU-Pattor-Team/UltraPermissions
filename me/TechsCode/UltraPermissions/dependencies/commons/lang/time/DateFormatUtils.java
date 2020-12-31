/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.time;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateFormatUtils
/*     */ {
/*  44 */   public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-ddZZ");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   public static final FastDateFormat ISO_TIME_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ss");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static final FastDateFormat ISO_TIME_NO_T_FORMAT = FastDateFormat.getInstance("HH:mm:ss");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT = FastDateFormat.getInstance("HH:mm:ssZZ");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public static final FastDateFormat SMTP_DATETIME_FORMAT = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatUTC(long paramLong, String paramString) {
/* 128 */     return format(new Date(paramLong), paramString, DateUtils.UTC_TIME_ZONE, (Locale)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatUTC(Date paramDate, String paramString) {
/* 139 */     return format(paramDate, paramString, DateUtils.UTC_TIME_ZONE, (Locale)null);
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
/*     */   public static String formatUTC(long paramLong, String paramString, Locale paramLocale) {
/* 151 */     return format(new Date(paramLong), paramString, DateUtils.UTC_TIME_ZONE, paramLocale);
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
/*     */   public static String formatUTC(Date paramDate, String paramString, Locale paramLocale) {
/* 163 */     return format(paramDate, paramString, DateUtils.UTC_TIME_ZONE, paramLocale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String format(long paramLong, String paramString) {
/* 174 */     return format(new Date(paramLong), paramString, (TimeZone)null, (Locale)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String format(Date paramDate, String paramString) {
/* 185 */     return format(paramDate, paramString, (TimeZone)null, (Locale)null);
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
/*     */   public static String format(Calendar paramCalendar, String paramString) {
/* 198 */     return format(paramCalendar, paramString, (TimeZone)null, (Locale)null);
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
/*     */   public static String format(long paramLong, String paramString, TimeZone paramTimeZone) {
/* 210 */     return format(new Date(paramLong), paramString, paramTimeZone, (Locale)null);
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
/*     */   public static String format(Date paramDate, String paramString, TimeZone paramTimeZone) {
/* 222 */     return format(paramDate, paramString, paramTimeZone, (Locale)null);
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
/*     */   public static String format(Calendar paramCalendar, String paramString, TimeZone paramTimeZone) {
/* 236 */     return format(paramCalendar, paramString, paramTimeZone, (Locale)null);
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
/*     */   public static String format(long paramLong, String paramString, Locale paramLocale) {
/* 248 */     return format(new Date(paramLong), paramString, (TimeZone)null, paramLocale);
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
/*     */   public static String format(Date paramDate, String paramString, Locale paramLocale) {
/* 260 */     return format(paramDate, paramString, (TimeZone)null, paramLocale);
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
/*     */   public static String format(Calendar paramCalendar, String paramString, Locale paramLocale) {
/* 274 */     return format(paramCalendar, paramString, (TimeZone)null, paramLocale);
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
/*     */   public static String format(long paramLong, String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/* 287 */     return format(new Date(paramLong), paramString, paramTimeZone, paramLocale);
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
/*     */   public static String format(Date paramDate, String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/* 300 */     FastDateFormat fastDateFormat = FastDateFormat.getInstance(paramString, paramTimeZone, paramLocale);
/* 301 */     return fastDateFormat.format(paramDate);
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
/*     */   public static String format(Calendar paramCalendar, String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/* 316 */     FastDateFormat fastDateFormat = FastDateFormat.getInstance(paramString, paramTimeZone, paramLocale);
/* 317 */     return fastDateFormat.format(paramCalendar);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/time/DateFormatUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */