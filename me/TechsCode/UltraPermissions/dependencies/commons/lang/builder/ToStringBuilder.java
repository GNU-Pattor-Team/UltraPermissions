/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.builder;
/*      */ 
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.BooleanUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ObjectUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ToStringBuilder
/*      */ {
/*   98 */   private static volatile ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final StringBuffer buffer;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Object object;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final ToStringStyle style;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ToStringStyle getDefaultStyle() {
/*  121 */     return defaultStyle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setDefaultStyle(ToStringStyle paramToStringStyle) {
/*  140 */     if (paramToStringStyle == null) {
/*  141 */       throw new IllegalArgumentException("The style must not be null");
/*      */     }
/*  143 */     defaultStyle = paramToStringStyle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object paramObject) {
/*  156 */     return ReflectionToStringBuilder.toString(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object paramObject, ToStringStyle paramToStringStyle) {
/*  169 */     return ReflectionToStringBuilder.toString(paramObject, paramToStringStyle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean) {
/*  183 */     return ReflectionToStringBuilder.toString(paramObject, paramToStringStyle, paramBoolean, false, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean, Class paramClass) {
/*  203 */     return ReflectionToStringBuilder.toString(paramObject, paramToStringStyle, paramBoolean, false, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder(Object paramObject) {
/*  229 */     this(paramObject, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle) {
/*  241 */     this(paramObject, paramToStringStyle, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer) {
/*  256 */     if (paramToStringStyle == null) {
/*  257 */       paramToStringStyle = getDefaultStyle();
/*      */     }
/*  259 */     if (paramStringBuffer == null) {
/*  260 */       paramStringBuffer = new StringBuffer(512);
/*      */     }
/*  262 */     this.buffer = paramStringBuffer;
/*  263 */     this.style = paramToStringStyle;
/*  264 */     this.object = paramObject;
/*      */     
/*  266 */     paramToStringStyle.appendStart(paramStringBuffer, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(boolean paramBoolean) {
/*  279 */     this.style.append(this.buffer, (String)null, paramBoolean);
/*  280 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(boolean[] paramArrayOfboolean) {
/*  293 */     this.style.append(this.buffer, (String)null, paramArrayOfboolean, (Boolean)null);
/*  294 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(byte paramByte) {
/*  307 */     this.style.append(this.buffer, (String)null, paramByte);
/*  308 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(byte[] paramArrayOfbyte) {
/*  321 */     this.style.append(this.buffer, (String)null, paramArrayOfbyte, (Boolean)null);
/*  322 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(char paramChar) {
/*  335 */     this.style.append(this.buffer, (String)null, paramChar);
/*  336 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(char[] paramArrayOfchar) {
/*  349 */     this.style.append(this.buffer, (String)null, paramArrayOfchar, (Boolean)null);
/*  350 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(double paramDouble) {
/*  363 */     this.style.append(this.buffer, (String)null, paramDouble);
/*  364 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(double[] paramArrayOfdouble) {
/*  377 */     this.style.append(this.buffer, (String)null, paramArrayOfdouble, (Boolean)null);
/*  378 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(float paramFloat) {
/*  391 */     this.style.append(this.buffer, (String)null, paramFloat);
/*  392 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(float[] paramArrayOffloat) {
/*  405 */     this.style.append(this.buffer, (String)null, paramArrayOffloat, (Boolean)null);
/*  406 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(int paramInt) {
/*  419 */     this.style.append(this.buffer, (String)null, paramInt);
/*  420 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(int[] paramArrayOfint) {
/*  433 */     this.style.append(this.buffer, (String)null, paramArrayOfint, (Boolean)null);
/*  434 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(long paramLong) {
/*  447 */     this.style.append(this.buffer, (String)null, paramLong);
/*  448 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(long[] paramArrayOflong) {
/*  461 */     this.style.append(this.buffer, (String)null, paramArrayOflong, (Boolean)null);
/*  462 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(Object paramObject) {
/*  475 */     this.style.append(this.buffer, (String)null, paramObject, (Boolean)null);
/*  476 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(Object[] paramArrayOfObject) {
/*  489 */     this.style.append(this.buffer, (String)null, paramArrayOfObject, (Boolean)null);
/*  490 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(short paramShort) {
/*  503 */     this.style.append(this.buffer, (String)null, paramShort);
/*  504 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(short[] paramArrayOfshort) {
/*  517 */     this.style.append(this.buffer, (String)null, paramArrayOfshort, (Boolean)null);
/*  518 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, boolean paramBoolean) {
/*  530 */     this.style.append(this.buffer, paramString, paramBoolean);
/*  531 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, boolean[] paramArrayOfboolean) {
/*  543 */     this.style.append(this.buffer, paramString, paramArrayOfboolean, (Boolean)null);
/*  544 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, boolean[] paramArrayOfboolean, boolean paramBoolean) {
/*  563 */     this.style.append(this.buffer, paramString, paramArrayOfboolean, BooleanUtils.toBooleanObject(paramBoolean));
/*  564 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, byte paramByte) {
/*  576 */     this.style.append(this.buffer, paramString, paramByte);
/*  577 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, byte[] paramArrayOfbyte) {
/*  588 */     this.style.append(this.buffer, paramString, paramArrayOfbyte, (Boolean)null);
/*  589 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, byte[] paramArrayOfbyte, boolean paramBoolean) {
/*  608 */     this.style.append(this.buffer, paramString, paramArrayOfbyte, BooleanUtils.toBooleanObject(paramBoolean));
/*  609 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, char paramChar) {
/*  621 */     this.style.append(this.buffer, paramString, paramChar);
/*  622 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, char[] paramArrayOfchar) {
/*  634 */     this.style.append(this.buffer, paramString, paramArrayOfchar, (Boolean)null);
/*  635 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, char[] paramArrayOfchar, boolean paramBoolean) {
/*  654 */     this.style.append(this.buffer, paramString, paramArrayOfchar, BooleanUtils.toBooleanObject(paramBoolean));
/*  655 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, double paramDouble) {
/*  667 */     this.style.append(this.buffer, paramString, paramDouble);
/*  668 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, double[] paramArrayOfdouble) {
/*  680 */     this.style.append(this.buffer, paramString, paramArrayOfdouble, (Boolean)null);
/*  681 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, double[] paramArrayOfdouble, boolean paramBoolean) {
/*  700 */     this.style.append(this.buffer, paramString, paramArrayOfdouble, BooleanUtils.toBooleanObject(paramBoolean));
/*  701 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, float paramFloat) {
/*  713 */     this.style.append(this.buffer, paramString, paramFloat);
/*  714 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, float[] paramArrayOffloat) {
/*  726 */     this.style.append(this.buffer, paramString, paramArrayOffloat, (Boolean)null);
/*  727 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, float[] paramArrayOffloat, boolean paramBoolean) {
/*  746 */     this.style.append(this.buffer, paramString, paramArrayOffloat, BooleanUtils.toBooleanObject(paramBoolean));
/*  747 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, int paramInt) {
/*  759 */     this.style.append(this.buffer, paramString, paramInt);
/*  760 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, int[] paramArrayOfint) {
/*  772 */     this.style.append(this.buffer, paramString, paramArrayOfint, (Boolean)null);
/*  773 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, int[] paramArrayOfint, boolean paramBoolean) {
/*  792 */     this.style.append(this.buffer, paramString, paramArrayOfint, BooleanUtils.toBooleanObject(paramBoolean));
/*  793 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, long paramLong) {
/*  805 */     this.style.append(this.buffer, paramString, paramLong);
/*  806 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, long[] paramArrayOflong) {
/*  818 */     this.style.append(this.buffer, paramString, paramArrayOflong, (Boolean)null);
/*  819 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, long[] paramArrayOflong, boolean paramBoolean) {
/*  838 */     this.style.append(this.buffer, paramString, paramArrayOflong, BooleanUtils.toBooleanObject(paramBoolean));
/*  839 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object paramObject) {
/*  851 */     this.style.append(this.buffer, paramString, paramObject, (Boolean)null);
/*  852 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object paramObject, boolean paramBoolean) {
/*  866 */     this.style.append(this.buffer, paramString, paramObject, BooleanUtils.toBooleanObject(paramBoolean));
/*  867 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object[] paramArrayOfObject) {
/*  879 */     this.style.append(this.buffer, paramString, paramArrayOfObject, (Boolean)null);
/*  880 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, Object[] paramArrayOfObject, boolean paramBoolean) {
/*  899 */     this.style.append(this.buffer, paramString, paramArrayOfObject, BooleanUtils.toBooleanObject(paramBoolean));
/*  900 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, short paramShort) {
/*  912 */     this.style.append(this.buffer, paramString, paramShort);
/*  913 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, short[] paramArrayOfshort) {
/*  925 */     this.style.append(this.buffer, paramString, paramArrayOfshort, (Boolean)null);
/*  926 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String paramString, short[] paramArrayOfshort, boolean paramBoolean) {
/*  945 */     this.style.append(this.buffer, paramString, paramArrayOfshort, BooleanUtils.toBooleanObject(paramBoolean));
/*  946 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder appendAsObjectToString(Object paramObject) {
/*  959 */     ObjectUtils.identityToString(getStringBuffer(), paramObject);
/*  960 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder appendSuper(String paramString) {
/*  978 */     if (paramString != null) {
/*  979 */       this.style.appendSuper(this.buffer, paramString);
/*      */     }
/*  981 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder appendToString(String paramString) {
/* 1012 */     if (paramString != null) {
/* 1013 */       this.style.appendToString(this.buffer, paramString);
/*      */     }
/* 1015 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject() {
/* 1025 */     return this.object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer getStringBuffer() {
/* 1034 */     return this.buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringStyle getStyle() {
/* 1046 */     return this.style;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1060 */     if (getObject() == null) {
/* 1061 */       getStringBuffer().append(getStyle().getNullText());
/*      */     } else {
/* 1063 */       this.style.appendEnd(getStringBuffer(), getObject());
/*      */     } 
/* 1065 */     return getStringBuffer().toString();
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/builder/ToStringBuilder.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */