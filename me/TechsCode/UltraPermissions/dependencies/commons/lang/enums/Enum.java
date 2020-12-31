/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.enums;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 300 */   private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 305 */   private static Map cEnumClasses = new WeakHashMap();
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
/* 325 */   protected transient String iToString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Entry
/*     */   {
/* 334 */     final Map map = new HashMap();
/*     */ 
/*     */ 
/*     */     
/* 338 */     final Map unmodifiableMap = Collections.unmodifiableMap(this.map);
/*     */ 
/*     */ 
/*     */     
/* 342 */     final List list = new ArrayList(25);
/*     */ 
/*     */ 
/*     */     
/* 346 */     final List unmodifiableList = Collections.unmodifiableList(this.list);
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
/* 368 */     init(paramString);
/* 369 */     this.iName = paramString;
/* 370 */     this.iHashCode = 7 + getEnumClass().hashCode() + 3 * paramString.hashCode();
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
/* 382 */     if (StringUtils.isEmpty(paramString)) {
/* 383 */       throw new IllegalArgumentException("The Enum name must not be empty or null");
/*     */     }
/*     */     
/* 386 */     Class clazz1 = getEnumClass();
/* 387 */     if (clazz1 == null) {
/* 388 */       throw new IllegalArgumentException("getEnumClass() must not be null");
/*     */     }
/* 390 */     Class clazz2 = getClass();
/* 391 */     boolean bool = false;
/* 392 */     while (clazz2 != null && clazz2 != Enum.class && clazz2 != ValuedEnum.class) {
/* 393 */       if (clazz2 == clazz1) {
/* 394 */         bool = true;
/*     */         break;
/*     */       } 
/* 397 */       clazz2 = clazz2.getSuperclass();
/*     */     } 
/* 399 */     if (!bool) {
/* 400 */       throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
/*     */     }
/*     */ 
/*     */     
/* 404 */     synchronized (Enum.class) {
/*     */       
/* 406 */       entry = (Entry)cEnumClasses.get(clazz1);
/* 407 */       if (entry == null) {
/* 408 */         entry = createEntry(clazz1);
/* 409 */         WeakHashMap weakHashMap = new WeakHashMap();
/* 410 */         weakHashMap.putAll(cEnumClasses);
/* 411 */         weakHashMap.put(clazz1, entry);
/* 412 */         cEnumClasses = weakHashMap;
/*     */       } 
/*     */     } 
/* 415 */     if (entry.map.containsKey(paramString)) {
/* 416 */       throw new IllegalArgumentException("The Enum name must be unique, '" + paramString + "' has already been added");
/*     */     }
/* 418 */     entry.map.put(paramString, this);
/* 419 */     entry.list.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 429 */     Entry entry = (Entry)cEnumClasses.get(getEnumClass());
/* 430 */     if (entry == null) {
/* 431 */       return null;
/*     */     }
/* 433 */     return entry.map.get(getName());
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
/* 450 */     Entry entry = getEntry(paramClass);
/* 451 */     if (entry == null) {
/* 452 */       return null;
/*     */     }
/* 454 */     return (Enum)entry.map.get(paramString);
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
/* 471 */     Entry entry = getEntry(paramClass);
/* 472 */     if (entry == null) {
/* 473 */       return EMPTY_MAP;
/*     */     }
/* 475 */     return entry.unmodifiableMap;
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
/* 493 */     Entry entry = getEntry(paramClass);
/* 494 */     if (entry == null) {
/* 495 */       return Collections.EMPTY_LIST;
/*     */     }
/* 497 */     return entry.unmodifiableList;
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
/* 515 */     return getEnumList(paramClass).iterator();
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
/* 526 */     if (paramClass == null) {
/* 527 */       throw new IllegalArgumentException("The Enum Class must not be null");
/*     */     }
/* 529 */     if (!Enum.class.isAssignableFrom(paramClass)) {
/* 530 */       throw new IllegalArgumentException("The Class must be a subclass of Enum");
/*     */     }
/* 532 */     Entry entry = (Entry)cEnumClasses.get(paramClass);
/*     */     
/* 534 */     if (entry == null) {
/*     */       
/*     */       try {
/* 537 */         Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
/* 538 */         entry = (Entry)cEnumClasses.get(paramClass);
/* 539 */       } catch (Exception exception) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 544 */     return entry;
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
/* 556 */     Entry entry = new Entry();
/* 557 */     Class clazz = paramClass.getSuperclass();
/* 558 */     while (clazz != null && clazz != Enum.class && clazz != ValuedEnum.class) {
/* 559 */       Entry entry1 = (Entry)cEnumClasses.get(clazz);
/* 560 */       if (entry1 != null) {
/* 561 */         entry.list.addAll(entry1.list);
/* 562 */         entry.map.putAll(entry1.map);
/*     */         break;
/*     */       } 
/* 565 */       clazz = (Class)clazz.getSuperclass();
/*     */     } 
/* 567 */     return entry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/* 577 */     return this.iName;
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
/* 591 */     return getClass();
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
/* 608 */     if (paramObject == this)
/* 609 */       return true; 
/* 610 */     if (paramObject == null)
/* 611 */       return false; 
/* 612 */     if (paramObject.getClass() == getClass())
/*     */     {
/*     */ 
/*     */       
/* 616 */       return this.iName.equals(((Enum)paramObject).iName);
/*     */     }
/*     */     
/* 619 */     if (!paramObject.getClass().getName().equals(getClass().getName())) {
/* 620 */       return false;
/*     */     }
/* 622 */     return this.iName.equals(getNameInOtherClassLoader(paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 632 */     return this.iHashCode;
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
/* 652 */     if (paramObject == this) {
/* 653 */       return 0;
/*     */     }
/* 655 */     if (paramObject.getClass() != getClass()) {
/* 656 */       if (paramObject.getClass().getName().equals(getClass().getName())) {
/* 657 */         return this.iName.compareTo(getNameInOtherClassLoader(paramObject));
/*     */       }
/* 659 */       throw new ClassCastException("Different enum class '" + ClassUtils.getShortClassName(paramObject.getClass()) + "'");
/*     */     } 
/*     */     
/* 662 */     return this.iName.compareTo(((Enum)paramObject).iName);
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
/* 673 */       Method method = paramObject.getClass().getMethod("getName", null);
/* 674 */       return (String)method.invoke(paramObject, null);
/*     */     }
/* 676 */     catch (NoSuchMethodException noSuchMethodException) {
/*     */     
/* 678 */     } catch (IllegalAccessException illegalAccessException) {
/*     */     
/* 680 */     } catch (InvocationTargetException invocationTargetException) {}
/*     */ 
/*     */     
/* 683 */     throw new IllegalStateException("This should not happen");
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
/* 694 */     if (this.iToString == null) {
/* 695 */       String str = ClassUtils.getShortClassName(getEnumClass());
/* 696 */       this.iToString = str + "[" + getName() + "]";
/*     */     } 
/* 698 */     return this.iToString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/enums/Enum.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */