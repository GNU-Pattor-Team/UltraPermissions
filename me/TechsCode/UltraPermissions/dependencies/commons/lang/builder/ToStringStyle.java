/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.builder;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.Collection;
/*      */ import java.util.Map;
/*      */ import java.util.WeakHashMap;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ClassUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ObjectUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.SystemUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class ToStringStyle
/*      */   implements Serializable
/*      */ {
/*   80 */   public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   94 */   public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  105 */   public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  117 */   public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  127 */   public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  135 */   private static final ThreadLocal REGISTRY = new ThreadLocal();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Map getRegistry() {
/*  146 */     return REGISTRY.get();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isRegistered(Object paramObject) {
/*  161 */     Map map = getRegistry();
/*  162 */     return (map != null && map.containsKey(paramObject));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void register(Object paramObject) {
/*  175 */     if (paramObject != null) {
/*  176 */       Map map = getRegistry();
/*  177 */       if (map == null) {
/*  178 */         map = new WeakHashMap();
/*  179 */         REGISTRY.set(map);
/*      */       } 
/*  181 */       map.put(paramObject, null);
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
/*      */   static void unregister(Object paramObject) {
/*  198 */     if (paramObject != null) {
/*  199 */       Map map = getRegistry();
/*  200 */       if (map != null) {
/*  201 */         map.remove(paramObject);
/*  202 */         if (map.isEmpty()) {
/*  203 */           REGISTRY.set(null);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useFieldNames = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useClassName = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useShortClassName = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useIdentityHashCode = true;
/*      */ 
/*      */ 
/*      */   
/*  232 */   private String contentStart = "[";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  237 */   private String contentEnd = "]";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  242 */   private String fieldNameValueSeparator = "=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtStart = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtEnd = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  257 */   private String fieldSeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  262 */   private String arrayStart = "{";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  267 */   private String arraySeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean arrayContentDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  277 */   private String arrayEnd = "}";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean defaultFullDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  288 */   private String nullText = "<null>";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  293 */   private String sizeStartText = "<size=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  298 */   private String sizeEndText = ">";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  303 */   private String summaryObjectStartText = "<";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  308 */   private String summaryObjectEndText = ">";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendSuper(StringBuffer paramStringBuffer, String paramString) {
/*  332 */     appendToString(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendToString(StringBuffer paramStringBuffer, String paramString) {
/*  346 */     if (paramString != null) {
/*  347 */       int i = paramString.indexOf(this.contentStart) + this.contentStart.length();
/*  348 */       int j = paramString.lastIndexOf(this.contentEnd);
/*  349 */       if (i != j && i >= 0 && j >= 0) {
/*  350 */         String str = paramString.substring(i, j);
/*  351 */         if (this.fieldSeparatorAtStart) {
/*  352 */           removeLastFieldSeparator(paramStringBuffer);
/*      */         }
/*  354 */         paramStringBuffer.append(str);
/*  355 */         appendFieldSeparator(paramStringBuffer);
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
/*      */   public void appendStart(StringBuffer paramStringBuffer, Object paramObject) {
/*  367 */     if (paramObject != null) {
/*  368 */       appendClassName(paramStringBuffer, paramObject);
/*  369 */       appendIdentityHashCode(paramStringBuffer, paramObject);
/*  370 */       appendContentStart(paramStringBuffer);
/*  371 */       if (this.fieldSeparatorAtStart) {
/*  372 */         appendFieldSeparator(paramStringBuffer);
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
/*      */   public void appendEnd(StringBuffer paramStringBuffer, Object paramObject) {
/*  385 */     if (!this.fieldSeparatorAtEnd) {
/*  386 */       removeLastFieldSeparator(paramStringBuffer);
/*      */     }
/*  388 */     appendContentEnd(paramStringBuffer);
/*  389 */     unregister(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeLastFieldSeparator(StringBuffer paramStringBuffer) {
/*  399 */     int i = paramStringBuffer.length();
/*  400 */     int j = this.fieldSeparator.length();
/*  401 */     if (i > 0 && j > 0 && i >= j) {
/*  402 */       boolean bool = true;
/*  403 */       for (byte b = 0; b < j; b++) {
/*  404 */         if (paramStringBuffer.charAt(i - 1 - b) != this.fieldSeparator.charAt(j - 1 - b)) {
/*  405 */           bool = false;
/*      */           break;
/*      */         } 
/*      */       } 
/*  409 */       if (bool) {
/*  410 */         paramStringBuffer.setLength(i - j);
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
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, Object paramObject, Boolean paramBoolean) {
/*  429 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/*  431 */     if (paramObject == null) {
/*  432 */       appendNullText(paramStringBuffer, paramString);
/*      */     } else {
/*      */       
/*  435 */       appendInternal(paramStringBuffer, paramString, paramObject, isFullDetail(paramBoolean));
/*      */     } 
/*      */     
/*  438 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendInternal(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean) {
/*  461 */     if (isRegistered(paramObject) && !(paramObject instanceof Number) && !(paramObject instanceof Boolean) && !(paramObject instanceof Character)) {
/*      */       
/*  463 */       appendCyclicObject(paramStringBuffer, paramString, paramObject);
/*      */       
/*      */       return;
/*      */     } 
/*  467 */     register(paramObject);
/*      */     
/*      */     try {
/*  470 */       if (paramObject instanceof Collection) {
/*  471 */         if (paramBoolean) {
/*  472 */           appendDetail(paramStringBuffer, paramString, (Collection)paramObject);
/*      */         } else {
/*  474 */           appendSummarySize(paramStringBuffer, paramString, ((Collection)paramObject).size());
/*      */         }
/*      */       
/*  477 */       } else if (paramObject instanceof Map) {
/*  478 */         if (paramBoolean) {
/*  479 */           appendDetail(paramStringBuffer, paramString, (Map)paramObject);
/*      */         } else {
/*  481 */           appendSummarySize(paramStringBuffer, paramString, ((Map)paramObject).size());
/*      */         }
/*      */       
/*  484 */       } else if (paramObject instanceof long[]) {
/*  485 */         if (paramBoolean) {
/*  486 */           appendDetail(paramStringBuffer, paramString, (long[])paramObject);
/*      */         } else {
/*  488 */           appendSummary(paramStringBuffer, paramString, (long[])paramObject);
/*      */         }
/*      */       
/*  491 */       } else if (paramObject instanceof int[]) {
/*  492 */         if (paramBoolean) {
/*  493 */           appendDetail(paramStringBuffer, paramString, (int[])paramObject);
/*      */         } else {
/*  495 */           appendSummary(paramStringBuffer, paramString, (int[])paramObject);
/*      */         }
/*      */       
/*  498 */       } else if (paramObject instanceof short[]) {
/*  499 */         if (paramBoolean) {
/*  500 */           appendDetail(paramStringBuffer, paramString, (short[])paramObject);
/*      */         } else {
/*  502 */           appendSummary(paramStringBuffer, paramString, (short[])paramObject);
/*      */         }
/*      */       
/*  505 */       } else if (paramObject instanceof byte[]) {
/*  506 */         if (paramBoolean) {
/*  507 */           appendDetail(paramStringBuffer, paramString, (byte[])paramObject);
/*      */         } else {
/*  509 */           appendSummary(paramStringBuffer, paramString, (byte[])paramObject);
/*      */         }
/*      */       
/*  512 */       } else if (paramObject instanceof char[]) {
/*  513 */         if (paramBoolean) {
/*  514 */           appendDetail(paramStringBuffer, paramString, (char[])paramObject);
/*      */         } else {
/*  516 */           appendSummary(paramStringBuffer, paramString, (char[])paramObject);
/*      */         }
/*      */       
/*  519 */       } else if (paramObject instanceof double[]) {
/*  520 */         if (paramBoolean) {
/*  521 */           appendDetail(paramStringBuffer, paramString, (double[])paramObject);
/*      */         } else {
/*  523 */           appendSummary(paramStringBuffer, paramString, (double[])paramObject);
/*      */         }
/*      */       
/*  526 */       } else if (paramObject instanceof float[]) {
/*  527 */         if (paramBoolean) {
/*  528 */           appendDetail(paramStringBuffer, paramString, (float[])paramObject);
/*      */         } else {
/*  530 */           appendSummary(paramStringBuffer, paramString, (float[])paramObject);
/*      */         }
/*      */       
/*  533 */       } else if (paramObject instanceof boolean[]) {
/*  534 */         if (paramBoolean) {
/*  535 */           appendDetail(paramStringBuffer, paramString, (boolean[])paramObject);
/*      */         } else {
/*  537 */           appendSummary(paramStringBuffer, paramString, (boolean[])paramObject);
/*      */         }
/*      */       
/*  540 */       } else if (paramObject.getClass().isArray()) {
/*  541 */         if (paramBoolean) {
/*  542 */           appendDetail(paramStringBuffer, paramString, (Object[])paramObject);
/*      */         } else {
/*  544 */           appendSummary(paramStringBuffer, paramString, (Object[])paramObject);
/*      */         }
/*      */       
/*      */       }
/*  548 */       else if (paramBoolean) {
/*  549 */         appendDetail(paramStringBuffer, paramString, paramObject);
/*      */       } else {
/*  551 */         appendSummary(paramStringBuffer, paramString, paramObject);
/*      */       } 
/*      */     } finally {
/*      */       
/*  555 */       unregister(paramObject);
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
/*      */   protected void appendCyclicObject(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  572 */     ObjectUtils.identityToString(paramStringBuffer, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  585 */     paramStringBuffer.append(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Collection paramCollection) {
/*  597 */     paramStringBuffer.append(paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Map paramMap) {
/*  609 */     paramStringBuffer.append(paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  622 */     paramStringBuffer.append(this.summaryObjectStartText);
/*  623 */     paramStringBuffer.append(getShortClassName(paramObject.getClass()));
/*  624 */     paramStringBuffer.append(this.summaryObjectEndText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, long paramLong) {
/*  638 */     appendFieldStart(paramStringBuffer, paramString);
/*  639 */     appendDetail(paramStringBuffer, paramString, paramLong);
/*  640 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, long paramLong) {
/*  652 */     paramStringBuffer.append(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, int paramInt) {
/*  666 */     appendFieldStart(paramStringBuffer, paramString);
/*  667 */     appendDetail(paramStringBuffer, paramString, paramInt);
/*  668 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, int paramInt) {
/*  680 */     paramStringBuffer.append(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, short paramShort) {
/*  694 */     appendFieldStart(paramStringBuffer, paramString);
/*  695 */     appendDetail(paramStringBuffer, paramString, paramShort);
/*  696 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, short paramShort) {
/*  708 */     paramStringBuffer.append(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, byte paramByte) {
/*  722 */     appendFieldStart(paramStringBuffer, paramString);
/*  723 */     appendDetail(paramStringBuffer, paramString, paramByte);
/*  724 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, byte paramByte) {
/*  736 */     paramStringBuffer.append(paramByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, char paramChar) {
/*  750 */     appendFieldStart(paramStringBuffer, paramString);
/*  751 */     appendDetail(paramStringBuffer, paramString, paramChar);
/*  752 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, char paramChar) {
/*  764 */     paramStringBuffer.append(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, double paramDouble) {
/*  778 */     appendFieldStart(paramStringBuffer, paramString);
/*  779 */     appendDetail(paramStringBuffer, paramString, paramDouble);
/*  780 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, double paramDouble) {
/*  792 */     paramStringBuffer.append(paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, float paramFloat) {
/*  806 */     appendFieldStart(paramStringBuffer, paramString);
/*  807 */     appendDetail(paramStringBuffer, paramString, paramFloat);
/*  808 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, float paramFloat) {
/*  820 */     paramStringBuffer.append(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean) {
/*  834 */     appendFieldStart(paramStringBuffer, paramString);
/*  835 */     appendDetail(paramStringBuffer, paramString, paramBoolean);
/*  836 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean) {
/*  848 */     paramStringBuffer.append(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject, Boolean paramBoolean) {
/*  862 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/*  864 */     if (paramArrayOfObject == null) {
/*  865 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/*  867 */     else if (isFullDetail(paramBoolean)) {
/*  868 */       appendDetail(paramStringBuffer, paramString, paramArrayOfObject);
/*      */     } else {
/*      */       
/*  871 */       appendSummary(paramStringBuffer, paramString, paramArrayOfObject);
/*      */     } 
/*      */     
/*  874 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject) {
/*  889 */     paramStringBuffer.append(this.arrayStart);
/*  890 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*  891 */       Object object = paramArrayOfObject[b];
/*  892 */       if (b > 0) {
/*  893 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/*  895 */       if (object == null) {
/*  896 */         appendNullText(paramStringBuffer, paramString);
/*      */       } else {
/*      */         
/*  899 */         appendInternal(paramStringBuffer, paramString, object, this.arrayContentDetail);
/*      */       } 
/*      */     } 
/*  902 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void reflectionAppendArrayDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/*  915 */     paramStringBuffer.append(this.arrayStart);
/*  916 */     int i = Array.getLength(paramObject);
/*  917 */     for (byte b = 0; b < i; b++) {
/*  918 */       Object object = Array.get(paramObject, b);
/*  919 */       if (b > 0) {
/*  920 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/*  922 */       if (object == null) {
/*  923 */         appendNullText(paramStringBuffer, paramString);
/*      */       } else {
/*      */         
/*  926 */         appendInternal(paramStringBuffer, paramString, object, this.arrayContentDetail);
/*      */       } 
/*      */     } 
/*  929 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject) {
/*  942 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfObject.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOflong, Boolean paramBoolean) {
/*  958 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/*  960 */     if (paramArrayOflong == null) {
/*  961 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/*  963 */     else if (isFullDetail(paramBoolean)) {
/*  964 */       appendDetail(paramStringBuffer, paramString, paramArrayOflong);
/*      */     } else {
/*      */       
/*  967 */       appendSummary(paramStringBuffer, paramString, paramArrayOflong);
/*      */     } 
/*      */     
/*  970 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOflong) {
/*  983 */     paramStringBuffer.append(this.arrayStart);
/*  984 */     for (byte b = 0; b < paramArrayOflong.length; b++) {
/*  985 */       if (b > 0) {
/*  986 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/*  988 */       appendDetail(paramStringBuffer, paramString, paramArrayOflong[b]);
/*      */     } 
/*  990 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOflong) {
/* 1003 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOflong.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfint, Boolean paramBoolean) {
/* 1019 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1021 */     if (paramArrayOfint == null) {
/* 1022 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1024 */     else if (isFullDetail(paramBoolean)) {
/* 1025 */       appendDetail(paramStringBuffer, paramString, paramArrayOfint);
/*      */     } else {
/*      */       
/* 1028 */       appendSummary(paramStringBuffer, paramString, paramArrayOfint);
/*      */     } 
/*      */     
/* 1031 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfint) {
/* 1044 */     paramStringBuffer.append(this.arrayStart);
/* 1045 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 1046 */       if (b > 0) {
/* 1047 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1049 */       appendDetail(paramStringBuffer, paramString, paramArrayOfint[b]);
/*      */     } 
/* 1051 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfint) {
/* 1064 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfint.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfshort, Boolean paramBoolean) {
/* 1080 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1082 */     if (paramArrayOfshort == null) {
/* 1083 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1085 */     else if (isFullDetail(paramBoolean)) {
/* 1086 */       appendDetail(paramStringBuffer, paramString, paramArrayOfshort);
/*      */     } else {
/*      */       
/* 1089 */       appendSummary(paramStringBuffer, paramString, paramArrayOfshort);
/*      */     } 
/*      */     
/* 1092 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfshort) {
/* 1105 */     paramStringBuffer.append(this.arrayStart);
/* 1106 */     for (byte b = 0; b < paramArrayOfshort.length; b++) {
/* 1107 */       if (b > 0) {
/* 1108 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1110 */       appendDetail(paramStringBuffer, paramString, paramArrayOfshort[b]);
/*      */     } 
/* 1112 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfshort) {
/* 1125 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfshort.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfbyte, Boolean paramBoolean) {
/* 1141 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1143 */     if (paramArrayOfbyte == null) {
/* 1144 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1146 */     else if (isFullDetail(paramBoolean)) {
/* 1147 */       appendDetail(paramStringBuffer, paramString, paramArrayOfbyte);
/*      */     } else {
/*      */       
/* 1150 */       appendSummary(paramStringBuffer, paramString, paramArrayOfbyte);
/*      */     } 
/*      */     
/* 1153 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfbyte) {
/* 1166 */     paramStringBuffer.append(this.arrayStart);
/* 1167 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 1168 */       if (b > 0) {
/* 1169 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1171 */       appendDetail(paramStringBuffer, paramString, paramArrayOfbyte[b]);
/*      */     } 
/* 1173 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfbyte) {
/* 1186 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfchar, Boolean paramBoolean) {
/* 1202 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1204 */     if (paramArrayOfchar == null) {
/* 1205 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1207 */     else if (isFullDetail(paramBoolean)) {
/* 1208 */       appendDetail(paramStringBuffer, paramString, paramArrayOfchar);
/*      */     } else {
/*      */       
/* 1211 */       appendSummary(paramStringBuffer, paramString, paramArrayOfchar);
/*      */     } 
/*      */     
/* 1214 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfchar) {
/* 1227 */     paramStringBuffer.append(this.arrayStart);
/* 1228 */     for (byte b = 0; b < paramArrayOfchar.length; b++) {
/* 1229 */       if (b > 0) {
/* 1230 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1232 */       appendDetail(paramStringBuffer, paramString, paramArrayOfchar[b]);
/*      */     } 
/* 1234 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfchar) {
/* 1247 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfchar.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfdouble, Boolean paramBoolean) {
/* 1263 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1265 */     if (paramArrayOfdouble == null) {
/* 1266 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1268 */     else if (isFullDetail(paramBoolean)) {
/* 1269 */       appendDetail(paramStringBuffer, paramString, paramArrayOfdouble);
/*      */     } else {
/*      */       
/* 1272 */       appendSummary(paramStringBuffer, paramString, paramArrayOfdouble);
/*      */     } 
/*      */     
/* 1275 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfdouble) {
/* 1288 */     paramStringBuffer.append(this.arrayStart);
/* 1289 */     for (byte b = 0; b < paramArrayOfdouble.length; b++) {
/* 1290 */       if (b > 0) {
/* 1291 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1293 */       appendDetail(paramStringBuffer, paramString, paramArrayOfdouble[b]);
/*      */     } 
/* 1295 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfdouble) {
/* 1308 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfdouble.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOffloat, Boolean paramBoolean) {
/* 1324 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1326 */     if (paramArrayOffloat == null) {
/* 1327 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1329 */     else if (isFullDetail(paramBoolean)) {
/* 1330 */       appendDetail(paramStringBuffer, paramString, paramArrayOffloat);
/*      */     } else {
/*      */       
/* 1333 */       appendSummary(paramStringBuffer, paramString, paramArrayOffloat);
/*      */     } 
/*      */     
/* 1336 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOffloat) {
/* 1349 */     paramStringBuffer.append(this.arrayStart);
/* 1350 */     for (byte b = 0; b < paramArrayOffloat.length; b++) {
/* 1351 */       if (b > 0) {
/* 1352 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1354 */       appendDetail(paramStringBuffer, paramString, paramArrayOffloat[b]);
/*      */     } 
/* 1356 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOffloat) {
/* 1369 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOffloat.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfboolean, Boolean paramBoolean) {
/* 1385 */     appendFieldStart(paramStringBuffer, paramString);
/*      */     
/* 1387 */     if (paramArrayOfboolean == null) {
/* 1388 */       appendNullText(paramStringBuffer, paramString);
/*      */     }
/* 1390 */     else if (isFullDetail(paramBoolean)) {
/* 1391 */       appendDetail(paramStringBuffer, paramString, paramArrayOfboolean);
/*      */     } else {
/*      */       
/* 1394 */       appendSummary(paramStringBuffer, paramString, paramArrayOfboolean);
/*      */     } 
/*      */     
/* 1397 */     appendFieldEnd(paramStringBuffer, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfboolean) {
/* 1410 */     paramStringBuffer.append(this.arrayStart);
/* 1411 */     for (byte b = 0; b < paramArrayOfboolean.length; b++) {
/* 1412 */       if (b > 0) {
/* 1413 */         paramStringBuffer.append(this.arraySeparator);
/*      */       }
/* 1415 */       appendDetail(paramStringBuffer, paramString, paramArrayOfboolean[b]);
/*      */     } 
/* 1417 */     paramStringBuffer.append(this.arrayEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummary(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfboolean) {
/* 1430 */     appendSummarySize(paramStringBuffer, paramString, paramArrayOfboolean.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendClassName(StringBuffer paramStringBuffer, Object paramObject) {
/* 1442 */     if (this.useClassName && paramObject != null) {
/* 1443 */       register(paramObject);
/* 1444 */       if (this.useShortClassName) {
/* 1445 */         paramStringBuffer.append(getShortClassName(paramObject.getClass()));
/*      */       } else {
/* 1447 */         paramStringBuffer.append(paramObject.getClass().getName());
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
/*      */   protected void appendIdentityHashCode(StringBuffer paramStringBuffer, Object paramObject) {
/* 1459 */     if (isUseIdentityHashCode() && paramObject != null) {
/* 1460 */       register(paramObject);
/* 1461 */       paramStringBuffer.append('@');
/* 1462 */       paramStringBuffer.append(Integer.toHexString(System.identityHashCode(paramObject)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentStart(StringBuffer paramStringBuffer) {
/* 1472 */     paramStringBuffer.append(this.contentStart);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentEnd(StringBuffer paramStringBuffer) {
/* 1481 */     paramStringBuffer.append(this.contentEnd);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendNullText(StringBuffer paramStringBuffer, String paramString) {
/* 1493 */     paramStringBuffer.append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldSeparator(StringBuffer paramStringBuffer) {
/* 1502 */     paramStringBuffer.append(this.fieldSeparator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldStart(StringBuffer paramStringBuffer, String paramString) {
/* 1512 */     if (this.useFieldNames && paramString != null) {
/* 1513 */       paramStringBuffer.append(paramString);
/* 1514 */       paramStringBuffer.append(this.fieldNameValueSeparator);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldEnd(StringBuffer paramStringBuffer, String paramString) {
/* 1525 */     appendFieldSeparator(paramStringBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendSummarySize(StringBuffer paramStringBuffer, String paramString, int paramInt) {
/* 1544 */     paramStringBuffer.append(this.sizeStartText);
/* 1545 */     paramStringBuffer.append(paramInt);
/* 1546 */     paramStringBuffer.append(this.sizeEndText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isFullDetail(Boolean paramBoolean) {
/* 1564 */     if (paramBoolean == null) {
/* 1565 */       return this.defaultFullDetail;
/*      */     }
/* 1567 */     return paramBoolean.booleanValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getShortClassName(Class paramClass) {
/* 1580 */     return ClassUtils.getShortClassName(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseClassName() {
/* 1594 */     return this.useClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseClassName(boolean paramBoolean) {
/* 1603 */     this.useClassName = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseShortClassName() {
/* 1615 */     return this.useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isShortClassName() {
/* 1626 */     return this.useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseShortClassName(boolean paramBoolean) {
/* 1636 */     this.useShortClassName = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setShortClassName(boolean paramBoolean) {
/* 1647 */     this.useShortClassName = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseIdentityHashCode() {
/* 1658 */     return this.useIdentityHashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseIdentityHashCode(boolean paramBoolean) {
/* 1667 */     this.useIdentityHashCode = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseFieldNames() {
/* 1678 */     return this.useFieldNames;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseFieldNames(boolean paramBoolean) {
/* 1687 */     this.useFieldNames = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isDefaultFullDetail() {
/* 1699 */     return this.defaultFullDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setDefaultFullDetail(boolean paramBoolean) {
/* 1709 */     this.defaultFullDetail = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isArrayContentDetail() {
/* 1720 */     return this.arrayContentDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setArrayContentDetail(boolean paramBoolean) {
/* 1729 */     this.arrayContentDetail = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayStart() {
/* 1740 */     return this.arrayStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setArrayStart(String paramString) {
/* 1752 */     if (paramString == null) {
/* 1753 */       paramString = "";
/*      */     }
/* 1755 */     this.arrayStart = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayEnd() {
/* 1766 */     return this.arrayEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setArrayEnd(String paramString) {
/* 1778 */     if (paramString == null) {
/* 1779 */       paramString = "";
/*      */     }
/* 1781 */     this.arrayEnd = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArraySeparator() {
/* 1792 */     return this.arraySeparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setArraySeparator(String paramString) {
/* 1804 */     if (paramString == null) {
/* 1805 */       paramString = "";
/*      */     }
/* 1807 */     this.arraySeparator = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentStart() {
/* 1818 */     return this.contentStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setContentStart(String paramString) {
/* 1830 */     if (paramString == null) {
/* 1831 */       paramString = "";
/*      */     }
/* 1833 */     this.contentStart = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentEnd() {
/* 1844 */     return this.contentEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setContentEnd(String paramString) {
/* 1856 */     if (paramString == null) {
/* 1857 */       paramString = "";
/*      */     }
/* 1859 */     this.contentEnd = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldNameValueSeparator() {
/* 1870 */     return this.fieldNameValueSeparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldNameValueSeparator(String paramString) {
/* 1882 */     if (paramString == null) {
/* 1883 */       paramString = "";
/*      */     }
/* 1885 */     this.fieldNameValueSeparator = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldSeparator() {
/* 1896 */     return this.fieldSeparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparator(String paramString) {
/* 1908 */     if (paramString == null) {
/* 1909 */       paramString = "";
/*      */     }
/* 1911 */     this.fieldSeparator = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isFieldSeparatorAtStart() {
/* 1924 */     return this.fieldSeparatorAtStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtStart(boolean paramBoolean) {
/* 1935 */     this.fieldSeparatorAtStart = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isFieldSeparatorAtEnd() {
/* 1948 */     return this.fieldSeparatorAtEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtEnd(boolean paramBoolean) {
/* 1959 */     this.fieldSeparatorAtEnd = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getNullText() {
/* 1970 */     return this.nullText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setNullText(String paramString) {
/* 1982 */     if (paramString == null) {
/* 1983 */       paramString = "";
/*      */     }
/* 1985 */     this.nullText = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getSizeStartText() {
/* 1999 */     return this.sizeStartText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setSizeStartText(String paramString) {
/* 2014 */     if (paramString == null) {
/* 2015 */       paramString = "";
/*      */     }
/* 2017 */     this.sizeStartText = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getSizeEndText() {
/* 2031 */     return this.sizeEndText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setSizeEndText(String paramString) {
/* 2046 */     if (paramString == null) {
/* 2047 */       paramString = "";
/*      */     }
/* 2049 */     this.sizeEndText = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getSummaryObjectStartText() {
/* 2063 */     return this.summaryObjectStartText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setSummaryObjectStartText(String paramString) {
/* 2078 */     if (paramString == null) {
/* 2079 */       paramString = "";
/*      */     }
/* 2081 */     this.summaryObjectStartText = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getSummaryObjectEndText() {
/* 2095 */     return this.summaryObjectEndText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setSummaryObjectEndText(String paramString) {
/* 2110 */     if (paramString == null) {
/* 2111 */       paramString = "";
/*      */     }
/* 2113 */     this.summaryObjectEndText = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class DefaultToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2148 */       return ToStringStyle.DEFAULT_STYLE;
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
/*      */   private static final class NoFieldNameToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     NoFieldNameToStringStyle() {
/* 2173 */       setUseFieldNames(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2182 */       return ToStringStyle.NO_FIELD_NAMES_STYLE;
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
/*      */   private static final class ShortPrefixToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ShortPrefixToStringStyle() {
/* 2207 */       setUseShortClassName(true);
/* 2208 */       setUseIdentityHashCode(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2216 */       return ToStringStyle.SHORT_PREFIX_STYLE;
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
/*      */   private static final class SimpleToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     SimpleToStringStyle() {
/* 2239 */       setUseClassName(false);
/* 2240 */       setUseIdentityHashCode(false);
/* 2241 */       setUseFieldNames(false);
/* 2242 */       setContentStart("");
/* 2243 */       setContentEnd("");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2251 */       return ToStringStyle.SIMPLE_STYLE;
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
/*      */   private static final class MultiLineToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MultiLineToStringStyle() {
/* 2275 */       setContentStart("[");
/* 2276 */       setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
/* 2277 */       setFieldSeparatorAtStart(true);
/* 2278 */       setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2287 */       return ToStringStyle.MULTI_LINE_STYLE;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/builder/ToStringStyle.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */