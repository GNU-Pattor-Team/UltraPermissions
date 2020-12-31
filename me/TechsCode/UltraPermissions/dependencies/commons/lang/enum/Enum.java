/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.enum;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ClassUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Enum
/*     */   implements Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -487045951170455942L;
/* 254 */   private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 259 */   private static Map cEnumClasses = new WeakHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String iName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final transient int iHashCode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 279 */   protected transient String iToString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Entry
/*     */   {
/* 288 */     final Map map = new HashMap();
/*     */ 
/*     */ 
/*     */     
/* 292 */     final Map unmodifiableMap = Collections.unmodifiableMap(this.map);
/*     */ 
/*     */ 
/*     */     
/* 296 */     final List list = new ArrayList(25);
/*     */ 
/*     */ 
/*     */     
/* 300 */     final List unmodifiableList = Collections.unmodifiableList(this.list);
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
/*     */   protected Enum(String paramString) {
/* 322 */     init(paramString);
/* 323 */     this.iName = paramString;
/* 324 */     this.iHashCode = 7 + getEnumClass().hashCode() + 3 * paramString.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(String paramString) {
/*     */     Entry entry;
/* 336 */     if (StringUtils.isEmpty(paramString)) {
/* 337 */       throw new IllegalArgumentException("The Enum name must not be empty or null");
/*     */     }
/*     */     
/* 340 */     Class clazz1 = getEnumClass();
/* 341 */     if (clazz1 == null) {
/* 342 */       throw new IllegalArgumentException("getEnumClass() must not be null");
/*     */     }
/* 344 */     Class clazz2 = getClass();
/* 345 */     boolean bool = false;
/* 346 */     while (clazz2 != null && clazz2 != Enum.class && clazz2 != ValuedEnum.class) {
/* 347 */       if (clazz2 == clazz1) {
/* 348 */         bool = true;
/*     */         break;
/*     */       } 
/* 351 */       clazz2 = clazz2.getSuperclass();
/*     */     } 
/* 353 */     if (!bool) {
/* 354 */       throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
/*     */     }
/*     */ 
/*     */     
/* 358 */     synchronized (Enum.class) {
/*     */       
/* 360 */       entry = (Entry)cEnumClasses.get(clazz1);
/* 361 */       if (entry == null) {
/* 362 */         entry = createEntry(clazz1);
/* 363 */         WeakHashMap weakHashMap = new WeakHashMap();
/* 364 */         weakHashMap.putAll(cEnumClasses);
/* 365 */         weakHashMap.put(clazz1, entry);
/* 366 */         cEnumClasses = weakHashMap;
/*     */       } 
/*     */     } 
/* 369 */     if (entry.map.containsKey(paramString)) {
/* 370 */       throw new IllegalArgumentException("The Enum name must be unique, '" + paramString + "' has already been added");
/*     */     }
/* 372 */     entry.map.put(paramString, this);
/* 373 */     entry.list.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 383 */     Entry entry = (Entry)cEnumClasses.get(getEnumClass());
/* 384 */     if (entry == null) {
/* 385 */       return null;
/*     */     }
/* 387 */     return entry.map.get(getName());
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
/*     */   protected static Enum getEnum(Class paramClass, String paramString) {
/* 404 */     Entry entry = getEntry(paramClass);
/* 405 */     if (entry == null) {
/* 406 */       return null;
/*     */     }
/* 408 */     return (Enum)entry.map.get(paramString);
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
/*     */   protected static Map getEnumMap(Class paramClass) {
/* 425 */     Entry entry = getEntry(paramClass);
/* 426 */     if (entry == null) {
/* 427 */       return EMPTY_MAP;
/*     */     }
/* 429 */     return entry.unmodifiableMap;
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
/*     */   protected static List getEnumList(Class paramClass) {
/* 447 */     Entry entry = getEntry(paramClass);
/* 448 */     if (entry == null) {
/* 449 */       return Collections.EMPTY_LIST;
/*     */     }
/* 451 */     return entry.unmodifiableList;
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
/*     */   protected static Iterator iterator(Class paramClass) {
/* 469 */     return getEnumList(paramClass).iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Entry getEntry(Class paramClass) {
/* 480 */     if (paramClass == null) {
/* 481 */       throw new IllegalArgumentException("The Enum Class must not be null");
/*     */     }
/* 483 */     if (!Enum.class.isAssignableFrom(paramClass)) {
/* 484 */       throw new IllegalArgumentException("The Class must be a subclass of Enum");
/*     */     }
/* 486 */     Entry entry = (Entry)cEnumClasses.get(paramClass);
/*     */     
/* 488 */     if (entry == null) {
/*     */       
/*     */       try {
/* 491 */         Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
/* 492 */         entry = (Entry)cEnumClasses.get(paramClass);
/* 493 */       } catch (Exception exception) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 498 */     return entry;
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
/*     */   private static Entry createEntry(Class paramClass) {
/* 510 */     Entry entry = new Entry();
/* 511 */     Class clazz = paramClass.getSuperclass();
/* 512 */     while (clazz != null && clazz != Enum.class && clazz != ValuedEnum.class) {
/* 513 */       Entry entry1 = (Entry)cEnumClasses.get(clazz);
/* 514 */       if (entry1 != null) {
/* 515 */         entry.list.addAll(entry1.list);
/* 516 */         entry.map.putAll(entry1.map);
/*     */         break;
/*     */       } 
/* 519 */       clazz = (Class)clazz.getSuperclass();
/*     */     } 
/* 521 */     return entry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/* 531 */     return this.iName;
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
/*     */   public Class getEnumClass() {
/* 545 */     return getClass();
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
/*     */   public final boolean equals(Object paramObject) {
/* 562 */     if (paramObject == this)
/* 563 */       return true; 
/* 564 */     if (paramObject == null)
/* 565 */       return false; 
/* 566 */     if (paramObject.getClass() == getClass())
/*     */     {
/*     */ 
/*     */       
/* 570 */       return this.iName.equals(((Enum)paramObject).iName);
/*     */     }
/*     */     
/* 573 */     if (!paramObject.getClass().getName().equals(getClass().getName())) {
/* 574 */       return false;
/*     */     }
/* 576 */     return this.iName.equals(getNameInOtherClassLoader(paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 586 */     return this.iHashCode;
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
/*     */   public int compareTo(Object paramObject) {
/* 606 */     if (paramObject == this) {
/* 607 */       return 0;
/*     */     }
/* 609 */     if (paramObject.getClass() != getClass()) {
/* 610 */       if (paramObject.getClass().getName().equals(getClass().getName())) {
/* 611 */         return this.iName.compareTo(getNameInOtherClassLoader(paramObject));
/*     */       }
/* 613 */       throw new ClassCastException("Different enum class '" + ClassUtils.getShortClassName(paramObject.getClass()) + "'");
/*     */     } 
/*     */     
/* 616 */     return this.iName.compareTo(((Enum)paramObject).iName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getNameInOtherClassLoader(Object paramObject) {
/*     */     try {
/* 627 */       Method method = paramObject.getClass().getMethod("getName", null);
/* 628 */       return (String)method.invoke(paramObject, null);
/*     */     }
/* 630 */     catch (NoSuchMethodException noSuchMethodException) {
/*     */     
/* 632 */     } catch (IllegalAccessException illegalAccessException) {
/*     */     
/* 634 */     } catch (InvocationTargetException invocationTargetException) {}
/*     */ 
/*     */     
/* 637 */     throw new IllegalStateException("This should not happen");
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
/* 648 */     if (this.iToString == null) {
/* 649 */       String str = ClassUtils.getShortClassName(getEnumClass());
/* 650 */       this.iToString = str + "[" + getName() + "]";
/*     */     } 
/* 652 */     return this.iToString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/enum/Enum.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */