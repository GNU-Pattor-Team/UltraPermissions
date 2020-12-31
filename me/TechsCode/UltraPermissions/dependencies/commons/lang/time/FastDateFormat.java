/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.time;
/*      */ 
/*      */ import java.io.ObjectInputStream;
/*      */ import java.text.DateFormat;
/*      */ import java.text.DateFormatSymbols;
/*      */ import java.text.FieldPosition;
/*      */ import java.text.Format;
/*      */ import java.text.ParsePosition;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.TimeZone;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.Validate;
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
/*      */ public class FastDateFormat
/*      */   extends Format
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   public static final int FULL = 0;
/*      */   public static final int LONG = 1;
/*      */   public static final int MEDIUM = 2;
/*      */   public static final int SHORT = 3;
/*      */   private static String cDefaultPattern;
/*  111 */   private static final Map cInstanceCache = new HashMap(7);
/*  112 */   private static final Map cDateInstanceCache = new HashMap(7);
/*  113 */   private static final Map cTimeInstanceCache = new HashMap(7);
/*  114 */   private static final Map cDateTimeInstanceCache = new HashMap(7);
/*  115 */   private static final Map cTimeZoneDisplayCache = new HashMap(7);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String mPattern;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final TimeZone mTimeZone;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean mTimeZoneForced;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Locale mLocale;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean mLocaleForced;
/*      */ 
/*      */ 
/*      */   
/*      */   private transient Rule[] mRules;
/*      */ 
/*      */ 
/*      */   
/*      */   private transient int mMaxLengthEstimate;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance() {
/*  154 */     return getInstance(getDefaultPattern(), null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance(String paramString) {
/*  167 */     return getInstance(paramString, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance(String paramString, TimeZone paramTimeZone) {
/*  182 */     return getInstance(paramString, paramTimeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance(String paramString, Locale paramLocale) {
/*  196 */     return getInstance(paramString, null, paramLocale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/*  213 */     FastDateFormat fastDateFormat1 = new FastDateFormat(paramString, paramTimeZone, paramLocale);
/*  214 */     FastDateFormat fastDateFormat2 = (FastDateFormat)cInstanceCache.get(fastDateFormat1);
/*  215 */     if (fastDateFormat2 == null) {
/*  216 */       fastDateFormat2 = fastDateFormat1;
/*  217 */       fastDateFormat2.init();
/*  218 */       cInstanceCache.put(fastDateFormat2, fastDateFormat2);
/*      */     } 
/*  220 */     return fastDateFormat2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateInstance(int paramInt) {
/*  235 */     return getDateInstance(paramInt, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateInstance(int paramInt, Locale paramLocale) {
/*  250 */     return getDateInstance(paramInt, null, paramLocale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone) {
/*  266 */     return getDateInstance(paramInt, paramTimeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale) {
/*  281 */     Integer integer = new Integer(paramInt);
/*  282 */     if (paramTimeZone != null) {
/*  283 */       pair = new Pair(integer, paramTimeZone);
/*      */     }
/*      */     
/*  286 */     if (paramLocale == null) {
/*  287 */       paramLocale = Locale.getDefault();
/*      */     }
/*      */     
/*  290 */     Pair pair = new Pair(pair, paramLocale);
/*      */     
/*  292 */     FastDateFormat fastDateFormat = (FastDateFormat)cDateInstanceCache.get(pair);
/*  293 */     if (fastDateFormat == null) {
/*      */       try {
/*  295 */         SimpleDateFormat simpleDateFormat = (SimpleDateFormat)DateFormat.getDateInstance(paramInt, paramLocale);
/*  296 */         String str = simpleDateFormat.toPattern();
/*  297 */         fastDateFormat = getInstance(str, paramTimeZone, paramLocale);
/*  298 */         cDateInstanceCache.put(pair, fastDateFormat);
/*      */       }
/*  300 */       catch (ClassCastException classCastException) {
/*  301 */         throw new IllegalArgumentException("No date pattern for locale: " + paramLocale);
/*      */       } 
/*      */     }
/*  304 */     return fastDateFormat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getTimeInstance(int paramInt) {
/*  319 */     return getTimeInstance(paramInt, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getTimeInstance(int paramInt, Locale paramLocale) {
/*  334 */     return getTimeInstance(paramInt, null, paramLocale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone) {
/*  350 */     return getTimeInstance(paramInt, paramTimeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale) {
/*      */     Pair pair;
/*  366 */     Integer integer = new Integer(paramInt);
/*  367 */     if (paramTimeZone != null) {
/*  368 */       pair = new Pair(integer, paramTimeZone);
/*      */     }
/*  370 */     if (paramLocale != null) {
/*  371 */       pair = new Pair(pair, paramLocale);
/*      */     }
/*      */     
/*  374 */     FastDateFormat fastDateFormat = (FastDateFormat)cTimeInstanceCache.get(pair);
/*  375 */     if (fastDateFormat == null) {
/*  376 */       if (paramLocale == null) {
/*  377 */         paramLocale = Locale.getDefault();
/*      */       }
/*      */       
/*      */       try {
/*  381 */         SimpleDateFormat simpleDateFormat = (SimpleDateFormat)DateFormat.getTimeInstance(paramInt, paramLocale);
/*  382 */         String str = simpleDateFormat.toPattern();
/*  383 */         fastDateFormat = getInstance(str, paramTimeZone, paramLocale);
/*  384 */         cTimeInstanceCache.put(pair, fastDateFormat);
/*      */       }
/*  386 */       catch (ClassCastException classCastException) {
/*  387 */         throw new IllegalArgumentException("No date pattern for locale: " + paramLocale);
/*      */       } 
/*      */     } 
/*  390 */     return fastDateFormat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2) {
/*  407 */     return getDateTimeInstance(paramInt1, paramInt2, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, Locale paramLocale) {
/*  424 */     return getDateTimeInstance(paramInt1, paramInt2, null, paramLocale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone) {
/*  442 */     return getDateTimeInstance(paramInt1, paramInt2, paramTimeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone, Locale paramLocale) {
/*  460 */     Pair pair = new Pair(new Integer(paramInt1), new Integer(paramInt2));
/*  461 */     if (paramTimeZone != null) {
/*  462 */       pair = new Pair(pair, paramTimeZone);
/*      */     }
/*  464 */     if (paramLocale == null) {
/*  465 */       paramLocale = Locale.getDefault();
/*      */     }
/*  467 */     pair = new Pair(pair, paramLocale);
/*      */     
/*  469 */     FastDateFormat fastDateFormat = (FastDateFormat)cDateTimeInstanceCache.get(pair);
/*  470 */     if (fastDateFormat == null) {
/*      */       try {
/*  472 */         SimpleDateFormat simpleDateFormat = (SimpleDateFormat)DateFormat.getDateTimeInstance(paramInt1, paramInt2, paramLocale);
/*      */         
/*  474 */         String str = simpleDateFormat.toPattern();
/*  475 */         fastDateFormat = getInstance(str, paramTimeZone, paramLocale);
/*  476 */         cDateTimeInstanceCache.put(pair, fastDateFormat);
/*      */       }
/*  478 */       catch (ClassCastException classCastException) {
/*  479 */         throw new IllegalArgumentException("No date time pattern for locale: " + paramLocale);
/*      */       } 
/*      */     }
/*  482 */     return fastDateFormat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static synchronized String getTimeZoneDisplay(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale) {
/*  497 */     TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(paramTimeZone, paramBoolean, paramInt, paramLocale);
/*  498 */     String str = (String)cTimeZoneDisplayCache.get(timeZoneDisplayKey);
/*  499 */     if (str == null) {
/*      */       
/*  501 */       str = paramTimeZone.getDisplayName(paramBoolean, paramInt, paramLocale);
/*  502 */       cTimeZoneDisplayCache.put(timeZoneDisplayKey, str);
/*      */     } 
/*  504 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static synchronized String getDefaultPattern() {
/*  513 */     if (cDefaultPattern == null) {
/*  514 */       cDefaultPattern = (new SimpleDateFormat()).toPattern();
/*      */     }
/*  516 */     return cDefaultPattern;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected FastDateFormat(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/*  536 */     if (paramString == null) {
/*  537 */       throw new IllegalArgumentException("The pattern must not be null");
/*      */     }
/*  539 */     this.mPattern = paramString;
/*      */     
/*  541 */     this.mTimeZoneForced = (paramTimeZone != null);
/*  542 */     if (paramTimeZone == null) {
/*  543 */       paramTimeZone = TimeZone.getDefault();
/*      */     }
/*  545 */     this.mTimeZone = paramTimeZone;
/*      */     
/*  547 */     this.mLocaleForced = (paramLocale != null);
/*  548 */     if (paramLocale == null) {
/*  549 */       paramLocale = Locale.getDefault();
/*      */     }
/*  551 */     this.mLocale = paramLocale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void init() {
/*  558 */     List list = parsePattern();
/*  559 */     this.mRules = (Rule[])list.toArray((Object[])new Rule[list.size()]);
/*      */     
/*  561 */     int i = 0;
/*  562 */     for (int j = this.mRules.length; --j >= 0;) {
/*  563 */       i += this.mRules[j].estimateLength();
/*      */     }
/*      */     
/*  566 */     this.mMaxLengthEstimate = i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List parsePattern() {
/*  578 */     DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
/*  579 */     ArrayList arrayList = new ArrayList();
/*      */     
/*  581 */     String[] arrayOfString1 = dateFormatSymbols.getEras();
/*  582 */     String[] arrayOfString2 = dateFormatSymbols.getMonths();
/*  583 */     String[] arrayOfString3 = dateFormatSymbols.getShortMonths();
/*  584 */     String[] arrayOfString4 = dateFormatSymbols.getWeekdays();
/*  585 */     String[] arrayOfString5 = dateFormatSymbols.getShortWeekdays();
/*  586 */     String[] arrayOfString6 = dateFormatSymbols.getAmPmStrings();
/*      */     
/*  588 */     int i = this.mPattern.length();
/*  589 */     int[] arrayOfInt = new int[1];
/*      */     
/*  591 */     for (int j = 0; j < i; j++) {
/*  592 */       TextField textField3; TwoDigitYearField twoDigitYearField; UnpaddedMonthField unpaddedMonthField; NumberRule numberRule3; TextField textField2; NumberRule numberRule2; TextField textField1; TwentyFourHourField twentyFourHourField; NumberRule numberRule1; TimeZoneNameRule timeZoneNameRule; TimeZoneNumberRule timeZoneNumberRule; StringLiteral stringLiteral; String str2; arrayOfInt[0] = j;
/*  593 */       String str1 = parseToken(this.mPattern, arrayOfInt);
/*  594 */       j = arrayOfInt[0];
/*      */       
/*  596 */       int k = str1.length();
/*  597 */       if (k == 0) {
/*      */         break;
/*      */       }
/*      */ 
/*      */       
/*  602 */       char c = str1.charAt(0);
/*      */       
/*  604 */       switch (c) {
/*      */         case 'G':
/*  606 */           textField3 = new TextField(0, arrayOfString1);
/*      */           break;
/*      */         case 'y':
/*  609 */           if (k >= 4) {
/*  610 */             NumberRule numberRule = selectNumberRule(1, k); break;
/*      */           } 
/*  612 */           twoDigitYearField = TwoDigitYearField.INSTANCE;
/*      */           break;
/*      */         
/*      */         case 'M':
/*  616 */           if (k >= 4) {
/*  617 */             TextField textField = new TextField(2, arrayOfString2); break;
/*  618 */           }  if (k == 3) {
/*  619 */             TextField textField = new TextField(2, arrayOfString3); break;
/*  620 */           }  if (k == 2) {
/*  621 */             TwoDigitMonthField twoDigitMonthField = TwoDigitMonthField.INSTANCE; break;
/*      */           } 
/*  623 */           unpaddedMonthField = UnpaddedMonthField.INSTANCE;
/*      */           break;
/*      */         
/*      */         case 'd':
/*  627 */           numberRule3 = selectNumberRule(5, k);
/*      */           break;
/*      */         case 'h':
/*  630 */           numberRule3 = new TwelveHourField(selectNumberRule(10, k));
/*      */           break;
/*      */         case 'H':
/*  633 */           numberRule3 = selectNumberRule(11, k);
/*      */           break;
/*      */         case 'm':
/*  636 */           numberRule3 = selectNumberRule(12, k);
/*      */           break;
/*      */         case 's':
/*  639 */           numberRule3 = selectNumberRule(13, k);
/*      */           break;
/*      */         case 'S':
/*  642 */           numberRule3 = selectNumberRule(14, k);
/*      */           break;
/*      */         case 'E':
/*  645 */           textField2 = new TextField(7, (k < 4) ? arrayOfString5 : arrayOfString4);
/*      */           break;
/*      */         case 'D':
/*  648 */           numberRule2 = selectNumberRule(6, k);
/*      */           break;
/*      */         case 'F':
/*  651 */           numberRule2 = selectNumberRule(8, k);
/*      */           break;
/*      */         case 'w':
/*  654 */           numberRule2 = selectNumberRule(3, k);
/*      */           break;
/*      */         case 'W':
/*  657 */           numberRule2 = selectNumberRule(4, k);
/*      */           break;
/*      */         case 'a':
/*  660 */           textField1 = new TextField(9, arrayOfString6);
/*      */           break;
/*      */         case 'k':
/*  663 */           twentyFourHourField = new TwentyFourHourField(selectNumberRule(11, k));
/*      */           break;
/*      */         case 'K':
/*  666 */           numberRule1 = selectNumberRule(10, k);
/*      */           break;
/*      */         case 'z':
/*  669 */           if (k >= 4) {
/*  670 */             TimeZoneNameRule timeZoneNameRule1 = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1); break;
/*      */           } 
/*  672 */           timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
/*      */           break;
/*      */         
/*      */         case 'Z':
/*  676 */           if (k == 1) {
/*  677 */             TimeZoneNumberRule timeZoneNumberRule1 = TimeZoneNumberRule.INSTANCE_NO_COLON; break;
/*      */           } 
/*  679 */           timeZoneNumberRule = TimeZoneNumberRule.INSTANCE_COLON;
/*      */           break;
/*      */         
/*      */         case '\'':
/*  683 */           str2 = str1.substring(1);
/*  684 */           if (str2.length() == 1) {
/*  685 */             CharacterLiteral characterLiteral = new CharacterLiteral(str2.charAt(0)); break;
/*      */           } 
/*  687 */           stringLiteral = new StringLiteral(str2);
/*      */           break;
/*      */         
/*      */         default:
/*  691 */           throw new IllegalArgumentException("Illegal pattern component: " + str1);
/*      */       } 
/*      */       
/*  694 */       arrayList.add(stringLiteral);
/*      */     } 
/*      */     
/*  697 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String parseToken(String paramString, int[] paramArrayOfint) {
/*  708 */     StrBuilder strBuilder = new StrBuilder();
/*      */     
/*  710 */     int i = paramArrayOfint[0];
/*  711 */     int j = paramString.length();
/*      */     
/*  713 */     char c = paramString.charAt(i);
/*  714 */     if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
/*      */ 
/*      */       
/*  717 */       strBuilder.append(c);
/*      */       
/*  719 */       while (i + 1 < j) {
/*  720 */         char c1 = paramString.charAt(i + 1);
/*  721 */         if (c1 == c) {
/*  722 */           strBuilder.append(c);
/*  723 */           i++;
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  730 */       strBuilder.append('\'');
/*      */       
/*  732 */       boolean bool = false;
/*      */       
/*  734 */       for (; i < j; i++) {
/*  735 */         c = paramString.charAt(i);
/*      */         
/*  737 */         if (c == '\'')
/*  738 */         { if (i + 1 < j && paramString.charAt(i + 1) == '\'') {
/*      */             
/*  740 */             i++;
/*  741 */             strBuilder.append(c);
/*      */           } else {
/*  743 */             bool = !bool ? true : false;
/*      */           }  }
/*  745 */         else { if (!bool && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
/*      */             
/*  747 */             i--;
/*      */             break;
/*      */           } 
/*  750 */           strBuilder.append(c); }
/*      */       
/*      */       } 
/*      */     } 
/*      */     
/*  755 */     paramArrayOfint[0] = i;
/*  756 */     return strBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected NumberRule selectNumberRule(int paramInt1, int paramInt2) {
/*  767 */     switch (paramInt2) {
/*      */       case 1:
/*  769 */         return new UnpaddedNumberField(paramInt1);
/*      */       case 2:
/*  771 */         return new TwoDigitNumberField(paramInt1);
/*      */     } 
/*  773 */     return new PaddedNumberField(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition) {
/*  789 */     if (paramObject instanceof Date)
/*  790 */       return format((Date)paramObject, paramStringBuffer); 
/*  791 */     if (paramObject instanceof Calendar)
/*  792 */       return format((Calendar)paramObject, paramStringBuffer); 
/*  793 */     if (paramObject instanceof Long) {
/*  794 */       return format(((Long)paramObject).longValue(), paramStringBuffer);
/*      */     }
/*  796 */     throw new IllegalArgumentException("Unknown class: " + ((paramObject == null) ? "<null>" : paramObject.getClass().getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(long paramLong) {
/*  809 */     return format(new Date(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Date paramDate) {
/*  819 */     GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone, this.mLocale);
/*  820 */     gregorianCalendar.setTime(paramDate);
/*  821 */     return applyRules(gregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Calendar paramCalendar) {
/*  831 */     return format(paramCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(long paramLong, StringBuffer paramStringBuffer) {
/*  844 */     return format(new Date(paramLong), paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer) {
/*  856 */     GregorianCalendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
/*  857 */     gregorianCalendar.setTime(paramDate);
/*  858 */     return applyRules(gregorianCalendar, paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer) {
/*  870 */     if (this.mTimeZoneForced) {
/*  871 */       paramCalendar.getTime();
/*  872 */       paramCalendar = (Calendar)paramCalendar.clone();
/*  873 */       paramCalendar.setTimeZone(this.mTimeZone);
/*      */     } 
/*  875 */     return applyRules(paramCalendar, paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer) {
/*  887 */     Rule[] arrayOfRule = this.mRules;
/*  888 */     int i = this.mRules.length;
/*  889 */     for (byte b = 0; b < i; b++) {
/*  890 */       arrayOfRule[b].appendTo(paramStringBuffer, paramCalendar);
/*      */     }
/*  892 */     return paramStringBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object parseObject(String paramString, ParsePosition paramParsePosition) {
/*  905 */     paramParsePosition.setIndex(0);
/*  906 */     paramParsePosition.setErrorIndex(0);
/*  907 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPattern() {
/*  918 */     return this.mPattern;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TimeZone getTimeZone() {
/*  932 */     return this.mTimeZone;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getTimeZoneOverridesCalendar() {
/*  943 */     return this.mTimeZoneForced;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Locale getLocale() {
/*  952 */     return this.mLocale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxLengthEstimate() {
/*  965 */     return this.mMaxLengthEstimate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  977 */     if (!(paramObject instanceof FastDateFormat)) {
/*  978 */       return false;
/*      */     }
/*  980 */     FastDateFormat fastDateFormat = (FastDateFormat)paramObject;
/*  981 */     if ((this.mPattern == fastDateFormat.mPattern || this.mPattern.equals(fastDateFormat.mPattern)) && (this.mTimeZone == fastDateFormat.mTimeZone || this.mTimeZone.equals(fastDateFormat.mTimeZone)) && (this.mLocale == fastDateFormat.mLocale || this.mLocale.equals(fastDateFormat.mLocale)) && this.mTimeZoneForced == fastDateFormat.mTimeZoneForced && this.mLocaleForced == fastDateFormat.mLocaleForced)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  988 */       return true;
/*      */     }
/*  990 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  999 */     int i = 0;
/* 1000 */     i += this.mPattern.hashCode();
/* 1001 */     i += this.mTimeZone.hashCode();
/* 1002 */     i += this.mTimeZoneForced ? 1 : 0;
/* 1003 */     i += this.mLocale.hashCode();
/* 1004 */     i += this.mLocaleForced ? 1 : 0;
/* 1005 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1014 */     return "FastDateFormat[" + this.mPattern + "]";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream paramObjectInputStream) {
/* 1028 */     paramObjectInputStream.defaultReadObject();
/* 1029 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface Rule
/*      */   {
/*      */     int estimateLength();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface NumberRule
/*      */     extends Rule
/*      */   {
/*      */     void appendTo(StringBuffer param1StringBuffer, int param1Int);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class CharacterLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final char mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CharacterLiteral(char param1Char) {
/* 1080 */       this.mValue = param1Char;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1087 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1094 */       param1StringBuffer.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class StringLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final String mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     StringLiteral(String param1String) {
/* 1111 */       this.mValue = param1String;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1118 */       return this.mValue.length();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1125 */       param1StringBuffer.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TextField
/*      */     implements Rule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */     
/*      */     private final String[] mValues;
/*      */ 
/*      */ 
/*      */     
/*      */     TextField(int param1Int, String[] param1ArrayOfString) {
/* 1144 */       this.mField = param1Int;
/* 1145 */       this.mValues = param1ArrayOfString;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1152 */       int i = 0;
/* 1153 */       for (int j = this.mValues.length; --j >= 0; ) {
/* 1154 */         int k = this.mValues[j].length();
/* 1155 */         if (k > i) {
/* 1156 */           i = k;
/*      */         }
/*      */       } 
/* 1159 */       return i;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1166 */       param1StringBuffer.append(this.mValues[param1Calendar.get(this.mField)]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class UnpaddedNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     UnpaddedNumberField(int param1Int) {
/* 1182 */       this.mField = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1189 */       return 4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1196 */       appendTo(param1StringBuffer, param1Calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1203 */       if (param1Int < 10) {
/* 1204 */         param1StringBuffer.append((char)(param1Int + 48));
/* 1205 */       } else if (param1Int < 100) {
/* 1206 */         param1StringBuffer.append((char)(param1Int / 10 + 48));
/* 1207 */         param1StringBuffer.append((char)(param1Int % 10 + 48));
/*      */       } else {
/* 1209 */         param1StringBuffer.append(Integer.toString(param1Int));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class UnpaddedMonthField
/*      */     implements NumberRule
/*      */   {
/* 1218 */     static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1232 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1239 */       appendTo(param1StringBuffer, param1Calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1246 */       if (param1Int < 10) {
/* 1247 */         param1StringBuffer.append((char)(param1Int + 48));
/*      */       } else {
/* 1249 */         param1StringBuffer.append((char)(param1Int / 10 + 48));
/* 1250 */         param1StringBuffer.append((char)(param1Int % 10 + 48));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class PaddedNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */     
/*      */     private final int mSize;
/*      */ 
/*      */ 
/*      */     
/*      */     PaddedNumberField(int param1Int1, int param1Int2) {
/* 1269 */       if (param1Int2 < 3)
/*      */       {
/* 1271 */         throw new IllegalArgumentException();
/*      */       }
/* 1273 */       this.mField = param1Int1;
/* 1274 */       this.mSize = param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1281 */       return 4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1288 */       appendTo(param1StringBuffer, param1Calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1295 */       if (param1Int < 100) {
/* 1296 */         for (int i = this.mSize; --i >= 2;) {
/* 1297 */           param1StringBuffer.append('0');
/*      */         }
/* 1299 */         param1StringBuffer.append((char)(param1Int / 10 + 48));
/* 1300 */         param1StringBuffer.append((char)(param1Int % 10 + 48));
/*      */       } else {
/*      */         int i;
/* 1303 */         if (param1Int < 1000) {
/* 1304 */           i = 3;
/*      */         } else {
/* 1306 */           Validate.isTrue((param1Int > -1), "Negative values should not be possible", param1Int);
/* 1307 */           i = Integer.toString(param1Int).length();
/*      */         } 
/* 1309 */         for (int j = this.mSize; --j >= i;) {
/* 1310 */           param1StringBuffer.append('0');
/*      */         }
/* 1312 */         param1StringBuffer.append(Integer.toString(param1Int));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwoDigitNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwoDigitNumberField(int param1Int) {
/* 1329 */       this.mField = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1336 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1343 */       appendTo(param1StringBuffer, param1Calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1350 */       if (param1Int < 100) {
/* 1351 */         param1StringBuffer.append((char)(param1Int / 10 + 48));
/* 1352 */         param1StringBuffer.append((char)(param1Int % 10 + 48));
/*      */       } else {
/* 1354 */         param1StringBuffer.append(Integer.toString(param1Int));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitYearField
/*      */     implements NumberRule
/*      */   {
/* 1363 */     static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1376 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1383 */       appendTo(param1StringBuffer, param1Calendar.get(1) % 100);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1390 */       param1StringBuffer.append((char)(param1Int / 10 + 48));
/* 1391 */       param1StringBuffer.append((char)(param1Int % 10 + 48));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitMonthField
/*      */     implements NumberRule
/*      */   {
/* 1399 */     static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1412 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1419 */       appendTo(param1StringBuffer, param1Calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1426 */       param1StringBuffer.append((char)(param1Int / 10 + 48));
/* 1427 */       param1StringBuffer.append((char)(param1Int % 10 + 48));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwelveHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDateFormat.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwelveHourField(FastDateFormat.NumberRule param1NumberRule) {
/* 1444 */       this.mRule = param1NumberRule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1451 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1458 */       int i = param1Calendar.get(10);
/* 1459 */       if (i == 0) {
/* 1460 */         i = param1Calendar.getLeastMaximum(10) + 1;
/*      */       }
/* 1462 */       this.mRule.appendTo(param1StringBuffer, i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1469 */       this.mRule.appendTo(param1StringBuffer, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwentyFourHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDateFormat.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwentyFourHourField(FastDateFormat.NumberRule param1NumberRule) {
/* 1486 */       this.mRule = param1NumberRule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1493 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1500 */       int i = param1Calendar.get(11);
/* 1501 */       if (i == 0) {
/* 1502 */         i = param1Calendar.getMaximum(11) + 1;
/*      */       }
/* 1504 */       this.mRule.appendTo(param1StringBuffer, i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, int param1Int) {
/* 1511 */       this.mRule.appendTo(param1StringBuffer, param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNameRule
/*      */     implements Rule
/*      */   {
/*      */     private final TimeZone mTimeZone;
/*      */ 
/*      */     
/*      */     private final boolean mTimeZoneForced;
/*      */     
/*      */     private final Locale mLocale;
/*      */     
/*      */     private final int mStyle;
/*      */     
/*      */     private final String mStandard;
/*      */     
/*      */     private final String mDaylight;
/*      */ 
/*      */     
/*      */     TimeZoneNameRule(TimeZone param1TimeZone, boolean param1Boolean, Locale param1Locale, int param1Int) {
/* 1535 */       this.mTimeZone = param1TimeZone;
/* 1536 */       this.mTimeZoneForced = param1Boolean;
/* 1537 */       this.mLocale = param1Locale;
/* 1538 */       this.mStyle = param1Int;
/*      */       
/* 1540 */       if (param1Boolean) {
/* 1541 */         this.mStandard = FastDateFormat.getTimeZoneDisplay(param1TimeZone, false, param1Int, param1Locale);
/* 1542 */         this.mDaylight = FastDateFormat.getTimeZoneDisplay(param1TimeZone, true, param1Int, param1Locale);
/*      */       } else {
/* 1544 */         this.mStandard = null;
/* 1545 */         this.mDaylight = null;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1553 */       if (this.mTimeZoneForced)
/* 1554 */         return Math.max(this.mStandard.length(), this.mDaylight.length()); 
/* 1555 */       if (this.mStyle == 0) {
/* 1556 */         return 4;
/*      */       }
/* 1558 */       return 40;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1566 */       if (this.mTimeZoneForced) {
/* 1567 */         if (this.mTimeZone.useDaylightTime() && param1Calendar.get(16) != 0) {
/* 1568 */           param1StringBuffer.append(this.mDaylight);
/*      */         } else {
/* 1570 */           param1StringBuffer.append(this.mStandard);
/*      */         } 
/*      */       } else {
/* 1573 */         TimeZone timeZone = param1Calendar.getTimeZone();
/* 1574 */         if (timeZone.useDaylightTime() && param1Calendar.get(16) != 0) {
/* 1575 */           param1StringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
/*      */         } else {
/* 1577 */           param1StringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNumberRule
/*      */     implements Rule
/*      */   {
/* 1588 */     static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
/* 1589 */     static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean mColon;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneNumberRule(boolean param1Boolean) {
/* 1599 */       this.mColon = param1Boolean;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1606 */       return 5;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar) {
/* 1613 */       int i = param1Calendar.get(15) + param1Calendar.get(16);
/*      */       
/* 1615 */       if (i < 0) {
/* 1616 */         param1StringBuffer.append('-');
/* 1617 */         i = -i;
/*      */       } else {
/* 1619 */         param1StringBuffer.append('+');
/*      */       } 
/*      */       
/* 1622 */       int j = i / 3600000;
/* 1623 */       param1StringBuffer.append((char)(j / 10 + 48));
/* 1624 */       param1StringBuffer.append((char)(j % 10 + 48));
/*      */       
/* 1626 */       if (this.mColon) {
/* 1627 */         param1StringBuffer.append(':');
/*      */       }
/*      */       
/* 1630 */       int k = i / 60000 - 60 * j;
/* 1631 */       param1StringBuffer.append((char)(k / 10 + 48));
/* 1632 */       param1StringBuffer.append((char)(k % 10 + 48));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneDisplayKey
/*      */   {
/*      */     private final TimeZone mTimeZone;
/*      */ 
/*      */ 
/*      */     
/*      */     private final int mStyle;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Locale mLocale;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneDisplayKey(TimeZone param1TimeZone, boolean param1Boolean, int param1Int, Locale param1Locale) {
/* 1655 */       this.mTimeZone = param1TimeZone;
/* 1656 */       if (param1Boolean) {
/* 1657 */         param1Int |= Integer.MIN_VALUE;
/*      */       }
/* 1659 */       this.mStyle = param1Int;
/* 1660 */       this.mLocale = param1Locale;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1667 */       return this.mStyle * 31 + this.mLocale.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 1674 */       if (this == param1Object) {
/* 1675 */         return true;
/*      */       }
/* 1677 */       if (param1Object instanceof TimeZoneDisplayKey) {
/* 1678 */         TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey)param1Object;
/* 1679 */         return (this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale));
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1684 */       return false;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Pair
/*      */   {
/*      */     private final Object mObj1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Object mObj2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pair(Object param1Object1, Object param1Object2) {
/* 1705 */       this.mObj1 = param1Object1;
/* 1706 */       this.mObj2 = param1Object2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 1713 */       if (this == param1Object) {
/* 1714 */         return true;
/*      */       }
/*      */       
/* 1717 */       if (!(param1Object instanceof Pair)) {
/* 1718 */         return false;
/*      */       }
/*      */       
/* 1721 */       Pair pair = (Pair)param1Object;
/*      */       
/* 1723 */       if ((this.mObj1 == null) ? (pair.mObj1 == null) : this.mObj1.equals(pair.mObj1)) if ((this.mObj2 == null) ? (pair.mObj2 == null) : this.mObj2.equals(pair.mObj2));  return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1734 */       return ((this.mObj1 == null) ? 0 : this.mObj1.hashCode()) + ((this.mObj2 == null) ? 0 : this.mObj2.hashCode());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1743 */       return "[" + this.mObj1 + ':' + this.mObj2 + ']';
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/time/FastDateFormat.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */