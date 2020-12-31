/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*      */ 
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
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
/*      */ public class ClassUtils
/*      */ {
/*      */   public static final char PACKAGE_SEPARATOR_CHAR = '.';
/*   58 */   public static final String PACKAGE_SEPARATOR = String.valueOf('.');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   68 */   public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   73 */   private static final Map primitiveWrapperMap = new HashMap();
/*      */   static {
/*   75 */     primitiveWrapperMap.put(boolean.class, Boolean.class);
/*   76 */     primitiveWrapperMap.put(byte.class, Byte.class);
/*   77 */     primitiveWrapperMap.put(char.class, Character.class);
/*   78 */     primitiveWrapperMap.put(short.class, Short.class);
/*   79 */     primitiveWrapperMap.put(int.class, Integer.class);
/*   80 */     primitiveWrapperMap.put(long.class, Long.class);
/*   81 */     primitiveWrapperMap.put(double.class, Double.class);
/*   82 */     primitiveWrapperMap.put(float.class, Float.class);
/*   83 */     primitiveWrapperMap.put(void.class, void.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   89 */   private static final Map wrapperPrimitiveMap = new HashMap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  103 */   private static final Map abbreviationMap = new HashMap();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  108 */   private static final Map reverseAbbreviationMap = new HashMap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addAbbreviation(String paramString1, String paramString2) {
/*  117 */     abbreviationMap.put(paramString1, paramString2);
/*  118 */     reverseAbbreviationMap.put(paramString2, paramString1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  125 */     addAbbreviation("int", "I");
/*  126 */     addAbbreviation("boolean", "Z");
/*  127 */     addAbbreviation("float", "F");
/*  128 */     addAbbreviation("long", "J");
/*  129 */     addAbbreviation("short", "S");
/*  130 */     addAbbreviation("byte", "B");
/*  131 */     addAbbreviation("double", "D");
/*  132 */     addAbbreviation("char", "C");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortClassName(Object paramObject, String paramString) {
/*  157 */     if (paramObject == null) {
/*  158 */       return paramString;
/*      */     }
/*  160 */     return getShortClassName(paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortClassName(Class paramClass) {
/*  170 */     if (paramClass == null) {
/*  171 */       return "";
/*      */     }
/*  173 */     return getShortClassName(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortClassName(String paramString) {
/*  185 */     if (paramString == null) {
/*  186 */       return "";
/*      */     }
/*  188 */     if (paramString.length() == 0) {
/*  189 */       return "";
/*      */     }
/*      */     
/*  192 */     StrBuilder strBuilder = new StrBuilder();
/*      */ 
/*      */     
/*  195 */     if (paramString.startsWith("[")) {
/*  196 */       while (paramString.charAt(0) == '[') {
/*  197 */         paramString = paramString.substring(1);
/*  198 */         strBuilder.append("[]");
/*      */       } 
/*      */       
/*  201 */       if (paramString.charAt(0) == 'L' && paramString.charAt(paramString.length() - 1) == ';') {
/*  202 */         paramString = paramString.substring(1, paramString.length() - 1);
/*      */       }
/*      */     } 
/*      */     
/*  206 */     if (reverseAbbreviationMap.containsKey(paramString)) {
/*  207 */       paramString = (String)reverseAbbreviationMap.get(paramString);
/*      */     }
/*      */     
/*  210 */     int i = paramString.lastIndexOf('.');
/*  211 */     int j = paramString.indexOf('$', (i == -1) ? 0 : (i + 1));
/*      */     
/*  213 */     String str = paramString.substring(i + 1);
/*  214 */     if (j != -1) {
/*  215 */       str = str.replace('$', '.');
/*      */     }
/*  217 */     return str + strBuilder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageName(Object paramObject, String paramString) {
/*  230 */     if (paramObject == null) {
/*  231 */       return paramString;
/*      */     }
/*  233 */     return getPackageName(paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageName(Class paramClass) {
/*  243 */     if (paramClass == null) {
/*  244 */       return "";
/*      */     }
/*  246 */     return getPackageName(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageName(String paramString) {
/*  259 */     if (paramString == null || paramString.length() == 0) {
/*  260 */       return "";
/*      */     }
/*      */ 
/*      */     
/*  264 */     while (paramString.charAt(0) == '[') {
/*  265 */       paramString = paramString.substring(1);
/*      */     }
/*      */     
/*  268 */     if (paramString.charAt(0) == 'L' && paramString.charAt(paramString.length() - 1) == ';') {
/*  269 */       paramString = paramString.substring(1);
/*      */     }
/*      */     
/*  272 */     int i = paramString.lastIndexOf('.');
/*  273 */     if (i == -1) {
/*  274 */       return "";
/*      */     }
/*  276 */     return paramString.substring(0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List getAllSuperclasses(Class paramClass) {
/*  289 */     if (paramClass == null) {
/*  290 */       return null;
/*      */     }
/*  292 */     ArrayList arrayList = new ArrayList();
/*  293 */     Class clazz = paramClass.getSuperclass();
/*  294 */     while (clazz != null) {
/*  295 */       arrayList.add(clazz);
/*  296 */       clazz = clazz.getSuperclass();
/*      */     } 
/*  298 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List getAllInterfaces(Class paramClass) {
/*  315 */     if (paramClass == null) {
/*  316 */       return null;
/*      */     }
/*      */     
/*  319 */     ArrayList arrayList = new ArrayList();
/*  320 */     getAllInterfaces(paramClass, arrayList);
/*      */     
/*  322 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void getAllInterfaces(Class paramClass, List paramList) {
/*  332 */     while (paramClass != null) {
/*  333 */       Class[] arrayOfClass = paramClass.getInterfaces();
/*      */       
/*  335 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/*  336 */         if (!paramList.contains(arrayOfClass[b])) {
/*  337 */           paramList.add(arrayOfClass[b]);
/*  338 */           getAllInterfaces(arrayOfClass[b], paramList);
/*      */         } 
/*      */       } 
/*      */       
/*  342 */       paramClass = paramClass.getSuperclass();
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
/*      */   public static List convertClassNamesToClasses(List paramList) {
/*  361 */     if (paramList == null) {
/*  362 */       return null;
/*      */     }
/*  364 */     ArrayList arrayList = new ArrayList(paramList.size());
/*  365 */     for (String str : paramList) {
/*      */       
/*      */       try {
/*  368 */         arrayList.add(Class.forName(str));
/*  369 */       } catch (Exception exception) {
/*  370 */         arrayList.add(null);
/*      */       } 
/*      */     } 
/*  373 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List convertClassesToClassNames(List paramList) {
/*  389 */     if (paramList == null) {
/*  390 */       return null;
/*      */     }
/*  392 */     ArrayList arrayList = new ArrayList(paramList.size());
/*  393 */     for (Class clazz : paramList) {
/*      */       
/*  395 */       if (clazz == null) {
/*  396 */         arrayList.add(null); continue;
/*      */       } 
/*  398 */       arrayList.add(clazz.getName());
/*      */     } 
/*      */     
/*  401 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2) {
/*  438 */     return isAssignable(paramArrayOfClass1, paramArrayOfClass2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, boolean paramBoolean) {
/*  475 */     if (!ArrayUtils.isSameLength((Object[])paramArrayOfClass1, (Object[])paramArrayOfClass2)) {
/*  476 */       return false;
/*      */     }
/*  478 */     if (paramArrayOfClass1 == null) {
/*  479 */       paramArrayOfClass1 = ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/*  481 */     if (paramArrayOfClass2 == null) {
/*  482 */       paramArrayOfClass2 = ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/*  484 */     for (byte b = 0; b < paramArrayOfClass1.length; b++) {
/*  485 */       if (!isAssignable(paramArrayOfClass1[b], paramArrayOfClass2[b], paramBoolean)) {
/*  486 */         return false;
/*      */       }
/*      */     } 
/*  489 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Class paramClass1, Class paramClass2) {
/*  519 */     return isAssignable(paramClass1, paramClass2, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Class paramClass1, Class paramClass2, boolean paramBoolean) {
/*  551 */     if (paramClass2 == null) {
/*  552 */       return false;
/*      */     }
/*      */     
/*  555 */     if (paramClass1 == null) {
/*  556 */       return !paramClass2.isPrimitive();
/*      */     }
/*      */     
/*  559 */     if (paramBoolean) {
/*  560 */       if (paramClass1.isPrimitive() && !paramClass2.isPrimitive()) {
/*  561 */         paramClass1 = primitiveToWrapper(paramClass1);
/*  562 */         if (paramClass1 == null) {
/*  563 */           return false;
/*      */         }
/*      */       } 
/*  566 */       if (paramClass2.isPrimitive() && !paramClass1.isPrimitive()) {
/*  567 */         paramClass1 = wrapperToPrimitive(paramClass1);
/*  568 */         if (paramClass1 == null) {
/*  569 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*  573 */     if (paramClass1.equals(paramClass2)) {
/*  574 */       return true;
/*      */     }
/*  576 */     if (paramClass1.isPrimitive()) {
/*  577 */       if (!paramClass2.isPrimitive()) {
/*  578 */         return false;
/*      */       }
/*  580 */       if (int.class.equals(paramClass1)) {
/*  581 */         return (long.class.equals(paramClass2) || float.class.equals(paramClass2) || double.class.equals(paramClass2));
/*      */       }
/*      */ 
/*      */       
/*  585 */       if (long.class.equals(paramClass1)) {
/*  586 */         return (float.class.equals(paramClass2) || double.class.equals(paramClass2));
/*      */       }
/*      */       
/*  589 */       if (boolean.class.equals(paramClass1)) {
/*  590 */         return false;
/*      */       }
/*  592 */       if (double.class.equals(paramClass1)) {
/*  593 */         return false;
/*      */       }
/*  595 */       if (float.class.equals(paramClass1)) {
/*  596 */         return double.class.equals(paramClass2);
/*      */       }
/*  598 */       if (char.class.equals(paramClass1)) {
/*  599 */         return (int.class.equals(paramClass2) || long.class.equals(paramClass2) || float.class.equals(paramClass2) || double.class.equals(paramClass2));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  604 */       if (short.class.equals(paramClass1)) {
/*  605 */         return (int.class.equals(paramClass2) || long.class.equals(paramClass2) || float.class.equals(paramClass2) || double.class.equals(paramClass2));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  610 */       if (byte.class.equals(paramClass1)) {
/*  611 */         return (short.class.equals(paramClass2) || int.class.equals(paramClass2) || long.class.equals(paramClass2) || float.class.equals(paramClass2) || double.class.equals(paramClass2));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  618 */       return false;
/*      */     } 
/*  620 */     return paramClass2.isAssignableFrom(paramClass1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class primitiveToWrapper(Class paramClass) {
/*  636 */     Class clazz = paramClass;
/*  637 */     if (paramClass != null && paramClass.isPrimitive()) {
/*  638 */       clazz = (Class)primitiveWrapperMap.get(paramClass);
/*      */     }
/*  640 */     return clazz;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class[] primitivesToWrappers(Class[] paramArrayOfClass) {
/*  654 */     if (paramArrayOfClass == null) {
/*  655 */       return null;
/*      */     }
/*      */     
/*  658 */     if (paramArrayOfClass.length == 0) {
/*  659 */       return paramArrayOfClass;
/*      */     }
/*      */     
/*  662 */     Class[] arrayOfClass = new Class[paramArrayOfClass.length];
/*  663 */     for (byte b = 0; b < paramArrayOfClass.length; b++) {
/*  664 */       arrayOfClass[b] = primitiveToWrapper(paramArrayOfClass[b]);
/*      */     }
/*  666 */     return arrayOfClass;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class wrapperToPrimitive(Class paramClass) {
/*  686 */     return (Class)wrapperPrimitiveMap.get(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class[] wrappersToPrimitives(Class[] paramArrayOfClass) {
/*  704 */     if (paramArrayOfClass == null) {
/*  705 */       return null;
/*      */     }
/*      */     
/*  708 */     if (paramArrayOfClass.length == 0) {
/*  709 */       return paramArrayOfClass;
/*      */     }
/*      */     
/*  712 */     Class[] arrayOfClass = new Class[paramArrayOfClass.length];
/*  713 */     for (byte b = 0; b < paramArrayOfClass.length; b++) {
/*  714 */       arrayOfClass[b] = wrapperToPrimitive(paramArrayOfClass[b]);
/*      */     }
/*  716 */     return arrayOfClass;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isInnerClass(Class paramClass) {
/*  729 */     if (paramClass == null) {
/*  730 */       return false;
/*      */     }
/*  732 */     return (paramClass.getName().indexOf('$') >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class getClass(ClassLoader paramClassLoader, String paramString, boolean paramBoolean) {
/*      */     try {
/*      */       Class clazz;
/*  753 */       if (abbreviationMap.containsKey(paramString)) {
/*  754 */         String str = "[" + abbreviationMap.get(paramString);
/*  755 */         clazz = Class.forName(str, paramBoolean, paramClassLoader).getComponentType();
/*      */       } else {
/*  757 */         clazz = Class.forName(toCanonicalName(paramString), paramBoolean, paramClassLoader);
/*      */       } 
/*  759 */       return clazz;
/*  760 */     } catch (ClassNotFoundException classNotFoundException) {
/*      */       
/*  762 */       int i = paramString.lastIndexOf('.');
/*      */       
/*  764 */       if (i != -1) {
/*      */         try {
/*  766 */           return getClass(paramClassLoader, paramString.substring(0, i) + '$' + paramString.substring(i + 1), paramBoolean);
/*      */         
/*      */         }
/*  769 */         catch (ClassNotFoundException classNotFoundException1) {}
/*      */       }
/*      */ 
/*      */       
/*  773 */       throw classNotFoundException;
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
/*      */   public static Class getClass(ClassLoader paramClassLoader, String paramString) {
/*  790 */     return getClass(paramClassLoader, paramString, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class getClass(String paramString) {
/*  805 */     return getClass(paramString, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class getClass(String paramString, boolean paramBoolean) {
/*  820 */     ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
/*  821 */     ClassLoader classLoader2 = (classLoader1 == null) ? ClassUtils.class.getClassLoader() : classLoader1;
/*  822 */     return getClass(classLoader2, paramString, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Method getPublicMethod(Class paramClass, String paramString, Class[] paramArrayOfClass) {
/*  851 */     Method method = paramClass.getMethod(paramString, paramArrayOfClass);
/*  852 */     if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
/*  853 */       return method;
/*      */     }
/*      */     
/*  856 */     ArrayList arrayList = new ArrayList();
/*  857 */     arrayList.addAll(getAllInterfaces(paramClass));
/*  858 */     arrayList.addAll(getAllSuperclasses(paramClass));
/*      */     
/*  860 */     for (Class clazz : arrayList) {
/*      */       Method method1;
/*  862 */       if (!Modifier.isPublic(clazz.getModifiers())) {
/*      */         continue;
/*      */       }
/*      */       
/*      */       try {
/*  867 */         method1 = clazz.getMethod(paramString, paramArrayOfClass);
/*  868 */       } catch (NoSuchMethodException noSuchMethodException) {
/*      */         continue;
/*      */       } 
/*  871 */       if (Modifier.isPublic(method1.getDeclaringClass().getModifiers())) {
/*  872 */         return method1;
/*      */       }
/*      */     } 
/*      */     
/*  876 */     throw new NoSuchMethodException("Can't find a public method for " + paramString + " " + ArrayUtils.toString(paramArrayOfClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String toCanonicalName(String paramString) {
/*  888 */     paramString = StringUtils.deleteWhitespace(paramString);
/*  889 */     if (paramString == null)
/*  890 */       throw new NullArgumentException("className"); 
/*  891 */     if (paramString.endsWith("[]")) {
/*  892 */       StrBuilder strBuilder = new StrBuilder();
/*  893 */       while (paramString.endsWith("[]")) {
/*  894 */         paramString = paramString.substring(0, paramString.length() - 2);
/*  895 */         strBuilder.append("[");
/*      */       } 
/*  897 */       String str = (String)abbreviationMap.get(paramString);
/*  898 */       if (str != null) {
/*  899 */         strBuilder.append(str);
/*      */       } else {
/*  901 */         strBuilder.append("L").append(paramString).append(";");
/*      */       } 
/*  903 */       paramString = strBuilder.toString();
/*      */     } 
/*  905 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class[] toClass(Object[] paramArrayOfObject) {
/*  919 */     if (paramArrayOfObject == null)
/*  920 */       return null; 
/*  921 */     if (paramArrayOfObject.length == 0) {
/*  922 */       return ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/*  924 */     Class[] arrayOfClass = new Class[paramArrayOfObject.length];
/*  925 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*  926 */       arrayOfClass[b] = (paramArrayOfObject[b] == null) ? null : paramArrayOfObject[b].getClass();
/*      */     }
/*  928 */     return arrayOfClass;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortCanonicalName(Object paramObject, String paramString) {
/*  942 */     if (paramObject == null) {
/*  943 */       return paramString;
/*      */     }
/*  945 */     return getShortCanonicalName(paramObject.getClass().getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortCanonicalName(Class paramClass) {
/*  956 */     if (paramClass == null) {
/*  957 */       return "";
/*      */     }
/*  959 */     return getShortCanonicalName(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortCanonicalName(String paramString) {
/*  972 */     return getShortClassName(getCanonicalName(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageCanonicalName(Object paramObject, String paramString) {
/*  986 */     if (paramObject == null) {
/*  987 */       return paramString;
/*      */     }
/*  989 */     return getPackageCanonicalName(paramObject.getClass().getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageCanonicalName(Class paramClass) {
/* 1000 */     if (paramClass == null) {
/* 1001 */       return "";
/*      */     }
/* 1003 */     return getPackageCanonicalName(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageCanonicalName(String paramString) {
/* 1017 */     return getPackageName(getCanonicalName(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String getCanonicalName(String paramString) {
/* 1037 */     paramString = StringUtils.deleteWhitespace(paramString);
/* 1038 */     if (paramString == null) {
/* 1039 */       return null;
/*      */     }
/* 1041 */     byte b1 = 0;
/* 1042 */     while (paramString.startsWith("[")) {
/* 1043 */       b1++;
/* 1044 */       paramString = paramString.substring(1);
/*      */     } 
/* 1046 */     if (b1 < 1) {
/* 1047 */       return paramString;
/*      */     }
/* 1049 */     if (paramString.startsWith("L")) {
/* 1050 */       paramString = paramString.substring(1, paramString.endsWith(";") ? (paramString.length() - 1) : paramString.length());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1056 */     else if (paramString.length() > 0) {
/* 1057 */       paramString = (String)reverseAbbreviationMap.get(paramString.substring(0, 1));
/*      */     } 
/*      */ 
/*      */     
/* 1061 */     StrBuilder strBuilder = new StrBuilder(paramString);
/* 1062 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 1063 */       strBuilder.append("[]");
/*      */     }
/* 1065 */     return strBuilder.toString();
/*      */   }
/*      */   
/*      */   static {
/*      */     for (Class clazz1 : (Iterable)primitiveWrapperMap.keySet()) {
/*      */       Class clazz2 = (Class)primitiveWrapperMap.get(clazz1);
/*      */       if (!clazz1.equals(clazz2))
/*      */         wrapperPrimitiveMap.put(clazz2, clazz1); 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/ClassUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */