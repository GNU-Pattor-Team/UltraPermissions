/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.builder;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReflectionToStringBuilder
/*     */   extends ToStringBuilder
/*     */ {
/*     */   public static String toString(Object paramObject) {
/* 121 */     return toString(paramObject, (ToStringStyle)null, false, false, (Class)null);
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
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle) {
/* 153 */     return toString(paramObject, paramToStringStyle, false, false, (Class)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean) {
/* 191 */     return toString(paramObject, paramToStringStyle, paramBoolean, false, (Class)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2) {
/* 237 */     return toString(paramObject, paramToStringStyle, paramBoolean1, paramBoolean2, (Class)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2, Class paramClass) {
/* 287 */     return (new ReflectionToStringBuilder(paramObject, paramToStringStyle, null, paramClass, paramBoolean1, paramBoolean2)).toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean, Class paramClass) {
/* 334 */     return (new ReflectionToStringBuilder(paramObject, paramToStringStyle, null, paramClass, paramBoolean)).toString();
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
/*     */   public static String toStringExclude(Object paramObject, String paramString) {
/* 347 */     return toStringExclude(paramObject, new String[] { paramString });
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
/*     */   public static String toStringExclude(Object paramObject, Collection paramCollection) {
/* 360 */     return toStringExclude(paramObject, toNoNullStringArray(paramCollection));
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
/*     */   static String[] toNoNullStringArray(Collection paramCollection) {
/* 373 */     if (paramCollection == null) {
/* 374 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*     */     }
/* 376 */     return toNoNullStringArray(paramCollection.toArray());
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
/*     */   static String[] toNoNullStringArray(Object[] paramArrayOfObject) {
/* 389 */     ArrayList arrayList = new ArrayList(paramArrayOfObject.length);
/* 390 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 391 */       Object object = paramArrayOfObject[b];
/* 392 */       if (object != null) {
/* 393 */         arrayList.add(object.toString());
/*     */       }
/*     */     } 
/* 396 */     return arrayList.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
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
/*     */   public static String toStringExclude(Object paramObject, String[] paramArrayOfString) {
/* 410 */     return (new ReflectionToStringBuilder(paramObject)).setExcludeFieldNames(paramArrayOfString).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean appendStatics = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean appendTransients = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] excludeFieldNames;
/*     */ 
/*     */ 
/*     */   
/* 431 */   private Class upToClass = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectionToStringBuilder(Object paramObject) {
/* 448 */     super(paramObject);
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
/*     */   public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle) {
/* 468 */     super(paramObject, paramToStringStyle);
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
/*     */   public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer) {
/* 494 */     super(paramObject, paramToStringStyle, paramStringBuffer);
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
/*     */   public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer, Class paramClass, boolean paramBoolean) {
/* 515 */     super(paramObject, paramToStringStyle, paramStringBuffer);
/* 516 */     setUpToClass(paramClass);
/* 517 */     setAppendTransients(paramBoolean);
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
/*     */   public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer, Class paramClass, boolean paramBoolean1, boolean paramBoolean2) {
/* 539 */     super(paramObject, paramToStringStyle, paramStringBuffer);
/* 540 */     setUpToClass(paramClass);
/* 541 */     setAppendTransients(paramBoolean1);
/* 542 */     setAppendStatics(paramBoolean2);
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
/*     */   protected boolean accept(Field paramField) {
/* 558 */     if (paramField.getName().indexOf('$') != -1)
/*     */     {
/* 560 */       return false;
/*     */     }
/* 562 */     if (Modifier.isTransient(paramField.getModifiers()) && !isAppendTransients())
/*     */     {
/* 564 */       return false;
/*     */     }
/* 566 */     if (Modifier.isStatic(paramField.getModifiers()) && !isAppendStatics())
/*     */     {
/* 568 */       return false;
/*     */     }
/* 570 */     if (getExcludeFieldNames() != null && Arrays.binarySearch((Object[])getExcludeFieldNames(), paramField.getName()) >= 0)
/*     */     {
/*     */       
/* 573 */       return false;
/*     */     }
/* 575 */     return true;
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
/*     */   protected void appendFieldsIn(Class paramClass) {
/* 592 */     if (paramClass.isArray()) {
/* 593 */       reflectionAppendArray(getObject());
/*     */       return;
/*     */     } 
/* 596 */     Field[] arrayOfField = paramClass.getDeclaredFields();
/* 597 */     AccessibleObject.setAccessible((AccessibleObject[])arrayOfField, true);
/* 598 */     for (byte b = 0; b < arrayOfField.length; b++) {
/* 599 */       Field field = arrayOfField[b];
/* 600 */       String str = field.getName();
/* 601 */       if (accept(field)) {
/*     */         
/*     */         try {
/*     */           
/* 605 */           Object object = getValue(field);
/* 606 */           append(str, object);
/* 607 */         } catch (IllegalAccessException illegalAccessException) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 612 */           throw new InternalError("Unexpected IllegalAccessException: " + illegalAccessException.getMessage());
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getExcludeFieldNames() {
/* 622 */     return this.excludeFieldNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getUpToClass() {
/* 633 */     return this.upToClass;
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
/*     */   protected Object getValue(Field paramField) {
/* 653 */     return paramField.get(getObject());
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
/*     */   public boolean isAppendStatics() {
/* 665 */     return this.appendStatics;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAppendTransients() {
/* 676 */     return this.appendTransients;
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
/*     */   public ToStringBuilder reflectionAppendArray(Object paramObject) {
/* 689 */     getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, paramObject);
/* 690 */     return this;
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
/*     */   public void setAppendStatics(boolean paramBoolean) {
/* 703 */     this.appendStatics = paramBoolean;
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
/*     */   public void setAppendTransients(boolean paramBoolean) {
/* 715 */     this.appendTransients = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectionToStringBuilder setExcludeFieldNames(String[] paramArrayOfString) {
/* 726 */     if (paramArrayOfString == null) {
/* 727 */       this.excludeFieldNames = null;
/*     */     } else {
/* 729 */       this.excludeFieldNames = toNoNullStringArray((Object[])paramArrayOfString);
/* 730 */       Arrays.sort((Object[])this.excludeFieldNames);
/*     */     } 
/* 732 */     return this;
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
/*     */   public void setUpToClass(Class paramClass) {
/* 744 */     if (paramClass != null) {
/* 745 */       Object object = getObject();
/* 746 */       if (object != null && !paramClass.isInstance(object)) {
/* 747 */         throw new IllegalArgumentException("Specified class is not a superclass of the object");
/*     */       }
/*     */     } 
/* 750 */     this.upToClass = paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 761 */     if (getObject() == null) {
/* 762 */       return getStyle().getNullText();
/*     */     }
/* 764 */     Class clazz = getObject().getClass();
/* 765 */     appendFieldsIn(clazz);
/* 766 */     while (clazz.getSuperclass() != null && clazz != getUpToClass()) {
/* 767 */       clazz = clazz.getSuperclass();
/* 768 */       appendFieldsIn(clazz);
/*     */     } 
/* 770 */     return super.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/builder/ReflectionToStringBuilder.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */