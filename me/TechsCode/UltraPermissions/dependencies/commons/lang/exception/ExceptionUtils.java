/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.exception;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.StringWriter;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.StringTokenizer;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ClassUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.NullArgumentException;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
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
/*      */ public class ExceptionUtils
/*      */ {
/*      */   static final String WRAPPED_MARKER = " [wrapped] ";
/*   60 */   private static final Object CAUSE_METHOD_NAMES_LOCK = new Object();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   65 */   private static String[] CAUSE_METHOD_NAMES = new String[] { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Method THROWABLE_CAUSE_METHOD;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Method THROWABLE_INITCAUSE_METHOD;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*      */     Method method;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*      */     try {
/*   93 */       method = Throwable.class.getMethod("getCause", null);
/*   94 */     } catch (Exception exception) {
/*   95 */       method = null;
/*      */     } 
/*   97 */     THROWABLE_CAUSE_METHOD = method;
/*      */     try {
/*   99 */       method = Throwable.class.getMethod("initCause", new Class[] { Throwable.class });
/*  100 */     } catch (Exception exception) {
/*  101 */       method = null;
/*      */     } 
/*  103 */     THROWABLE_INITCAUSE_METHOD = method;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addCauseMethodName(String paramString) {
/*  126 */     if (StringUtils.isNotEmpty(paramString) && !isCauseMethodName(paramString)) {
/*  127 */       ArrayList arrayList = getCauseMethodNameList();
/*  128 */       if (arrayList.add(paramString)) {
/*  129 */         synchronized (CAUSE_METHOD_NAMES_LOCK) {
/*  130 */           CAUSE_METHOD_NAMES = toArray(arrayList);
/*      */         } 
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
/*      */   public static void removeCauseMethodName(String paramString) {
/*  145 */     if (StringUtils.isNotEmpty(paramString)) {
/*  146 */       ArrayList arrayList = getCauseMethodNameList();
/*  147 */       if (arrayList.remove(paramString)) {
/*  148 */         synchronized (CAUSE_METHOD_NAMES_LOCK) {
/*  149 */           CAUSE_METHOD_NAMES = toArray(arrayList);
/*      */         } 
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
/*      */   public static boolean setCause(Throwable paramThrowable1, Throwable paramThrowable2) {
/*  184 */     if (paramThrowable1 == null) {
/*  185 */       throw new NullArgumentException("target");
/*      */     }
/*  187 */     Object[] arrayOfObject = { paramThrowable2 };
/*  188 */     boolean bool = false;
/*  189 */     if (THROWABLE_INITCAUSE_METHOD != null) {
/*      */       try {
/*  191 */         THROWABLE_INITCAUSE_METHOD.invoke(paramThrowable1, arrayOfObject);
/*  192 */         bool = true;
/*  193 */       } catch (IllegalAccessException illegalAccessException) {
/*      */       
/*  195 */       } catch (InvocationTargetException invocationTargetException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/*  200 */       Method method = paramThrowable1.getClass().getMethod("setCause", new Class[] { Throwable.class });
/*  201 */       method.invoke(paramThrowable1, arrayOfObject);
/*  202 */       bool = true;
/*  203 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */     
/*  205 */     } catch (IllegalAccessException illegalAccessException) {
/*      */     
/*  207 */     } catch (InvocationTargetException invocationTargetException) {}
/*      */ 
/*      */     
/*  210 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] toArray(List paramList) {
/*  219 */     return (String[])paramList.toArray((Object[])new String[paramList.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static ArrayList getCauseMethodNameList() {
/*  228 */     synchronized (CAUSE_METHOD_NAMES_LOCK) {
/*  229 */       return new ArrayList(Arrays.asList((Object[])CAUSE_METHOD_NAMES));
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
/*      */   public static boolean isCauseMethodName(String paramString) {
/*  243 */     synchronized (CAUSE_METHOD_NAMES_LOCK) {
/*  244 */       return (ArrayUtils.indexOf((Object[])CAUSE_METHOD_NAMES, paramString) >= 0);
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
/*      */ 
/*      */   
/*      */   public static Throwable getCause(Throwable paramThrowable) {
/*  281 */     synchronized (CAUSE_METHOD_NAMES_LOCK) {
/*  282 */       return getCause(paramThrowable, CAUSE_METHOD_NAMES);
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
/*      */   public static Throwable getCause(Throwable paramThrowable, String[] paramArrayOfString) {
/*  305 */     if (paramThrowable == null) {
/*  306 */       return null;
/*      */     }
/*  308 */     Throwable throwable = getCauseUsingWellKnownTypes(paramThrowable);
/*  309 */     if (throwable == null) {
/*  310 */       if (paramArrayOfString == null) {
/*  311 */         synchronized (CAUSE_METHOD_NAMES_LOCK) {
/*  312 */           paramArrayOfString = CAUSE_METHOD_NAMES;
/*      */         } 
/*      */       }
/*  315 */       for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  316 */         String str = paramArrayOfString[b];
/*  317 */         if (str != null) {
/*  318 */           throwable = getCauseUsingMethodName(paramThrowable, str);
/*  319 */           if (throwable != null) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  325 */       if (throwable == null) {
/*  326 */         throwable = getCauseUsingFieldName(paramThrowable, "detail");
/*      */       }
/*      */     } 
/*  329 */     return throwable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Throwable getRootCause(Throwable paramThrowable) {
/*  350 */     List list = getThrowableList(paramThrowable);
/*  351 */     return (list.size() < 2) ? null : list.get(list.size() - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Throwable getCauseUsingWellKnownTypes(Throwable paramThrowable) {
/*  365 */     if (paramThrowable instanceof Nestable)
/*  366 */       return ((Nestable)paramThrowable).getCause(); 
/*  367 */     if (paramThrowable instanceof SQLException)
/*  368 */       return ((SQLException)paramThrowable).getNextException(); 
/*  369 */     if (paramThrowable instanceof InvocationTargetException) {
/*  370 */       return ((InvocationTargetException)paramThrowable).getTargetException();
/*      */     }
/*  372 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Throwable getCauseUsingMethodName(Throwable paramThrowable, String paramString) {
/*  384 */     Method method = null;
/*      */     try {
/*  386 */       method = paramThrowable.getClass().getMethod(paramString, null);
/*  387 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */     
/*  389 */     } catch (SecurityException securityException) {}
/*      */ 
/*      */ 
/*      */     
/*  393 */     if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
/*      */       try {
/*  395 */         return (Throwable)method.invoke(paramThrowable, ArrayUtils.EMPTY_OBJECT_ARRAY);
/*  396 */       } catch (IllegalAccessException illegalAccessException) {
/*      */       
/*  398 */       } catch (IllegalArgumentException illegalArgumentException) {
/*      */       
/*  400 */       } catch (InvocationTargetException invocationTargetException) {}
/*      */     }
/*      */ 
/*      */     
/*  404 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Throwable getCauseUsingFieldName(Throwable paramThrowable, String paramString) {
/*  415 */     Field field = null;
/*      */     try {
/*  417 */       field = paramThrowable.getClass().getField(paramString);
/*  418 */     } catch (NoSuchFieldException noSuchFieldException) {
/*      */     
/*  420 */     } catch (SecurityException securityException) {}
/*      */ 
/*      */ 
/*      */     
/*  424 */     if (field != null && Throwable.class.isAssignableFrom(field.getType())) {
/*      */       try {
/*  426 */         return (Throwable)field.get(paramThrowable);
/*  427 */       } catch (IllegalAccessException illegalAccessException) {
/*      */       
/*  429 */       } catch (IllegalArgumentException illegalArgumentException) {}
/*      */     }
/*      */ 
/*      */     
/*  433 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isThrowableNested() {
/*  446 */     return (THROWABLE_CAUSE_METHOD != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNestedThrowable(Throwable paramThrowable) {
/*  459 */     if (paramThrowable == null) {
/*  460 */       return false;
/*      */     }
/*      */     
/*  463 */     if (paramThrowable instanceof Nestable)
/*  464 */       return true; 
/*  465 */     if (paramThrowable instanceof SQLException)
/*  466 */       return true; 
/*  467 */     if (paramThrowable instanceof InvocationTargetException)
/*  468 */       return true; 
/*  469 */     if (isThrowableNested()) {
/*  470 */       return true;
/*      */     }
/*      */     
/*  473 */     Class clazz = paramThrowable.getClass();
/*  474 */     synchronized (CAUSE_METHOD_NAMES_LOCK) {
/*  475 */       byte b; int i; for (b = 0, i = CAUSE_METHOD_NAMES.length; b < i; b++) {
/*      */         try {
/*  477 */           Method method = clazz.getMethod(CAUSE_METHOD_NAMES[b], null);
/*  478 */           if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
/*  479 */             return true;
/*      */           }
/*  481 */         } catch (NoSuchMethodException noSuchMethodException) {
/*      */         
/*  483 */         } catch (SecurityException securityException) {}
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  490 */       Field field = clazz.getField("detail");
/*  491 */       if (field != null) {
/*  492 */         return true;
/*      */       }
/*  494 */     } catch (NoSuchFieldException noSuchFieldException) {
/*      */     
/*  496 */     } catch (SecurityException securityException) {}
/*      */ 
/*      */ 
/*      */     
/*  500 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getThrowableCount(Throwable paramThrowable) {
/*  521 */     return getThrowableList(paramThrowable).size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Throwable[] getThrowables(Throwable paramThrowable) {
/*  544 */     List list = getThrowableList(paramThrowable);
/*  545 */     return (Throwable[])list.toArray((Object[])new Throwable[list.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List getThrowableList(Throwable paramThrowable) {
/*  568 */     ArrayList arrayList = new ArrayList();
/*  569 */     while (paramThrowable != null && !arrayList.contains(paramThrowable)) {
/*  570 */       arrayList.add(paramThrowable);
/*  571 */       paramThrowable = getCause(paramThrowable);
/*      */     } 
/*  573 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfThrowable(Throwable paramThrowable, Class paramClass) {
/*  592 */     return indexOf(paramThrowable, paramClass, 0, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfThrowable(Throwable paramThrowable, Class paramClass, int paramInt) {
/*  615 */     return indexOf(paramThrowable, paramClass, paramInt, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfType(Throwable paramThrowable, Class paramClass) {
/*  635 */     return indexOf(paramThrowable, paramClass, 0, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfType(Throwable paramThrowable, Class paramClass, int paramInt) {
/*  659 */     return indexOf(paramThrowable, paramClass, paramInt, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int indexOf(Throwable paramThrowable, Class paramClass, int paramInt, boolean paramBoolean) {
/*  674 */     if (paramThrowable == null || paramClass == null) {
/*  675 */       return -1;
/*      */     }
/*  677 */     if (paramInt < 0) {
/*  678 */       paramInt = 0;
/*      */     }
/*  680 */     Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
/*  681 */     if (paramInt >= arrayOfThrowable.length) {
/*  682 */       return -1;
/*      */     }
/*  684 */     if (paramBoolean) {
/*  685 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/*  686 */         if (paramClass.isAssignableFrom(arrayOfThrowable[i].getClass())) {
/*  687 */           return i;
/*      */         }
/*      */       } 
/*      */     } else {
/*  691 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/*  692 */         if (paramClass.equals(arrayOfThrowable[i].getClass())) {
/*  693 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/*  697 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void printRootCauseStackTrace(Throwable paramThrowable) {
/*  720 */     printRootCauseStackTrace(paramThrowable, System.err);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void printRootCauseStackTrace(Throwable paramThrowable, PrintStream paramPrintStream) {
/*  743 */     if (paramThrowable == null) {
/*      */       return;
/*      */     }
/*  746 */     if (paramPrintStream == null) {
/*  747 */       throw new IllegalArgumentException("The PrintStream must not be null");
/*      */     }
/*  749 */     String[] arrayOfString = getRootCauseStackTrace(paramThrowable);
/*  750 */     for (byte b = 0; b < arrayOfString.length; b++) {
/*  751 */       paramPrintStream.println(arrayOfString[b]);
/*      */     }
/*  753 */     paramPrintStream.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void printRootCauseStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter) {
/*  776 */     if (paramThrowable == null) {
/*      */       return;
/*      */     }
/*  779 */     if (paramPrintWriter == null) {
/*  780 */       throw new IllegalArgumentException("The PrintWriter must not be null");
/*      */     }
/*  782 */     String[] arrayOfString = getRootCauseStackTrace(paramThrowable);
/*  783 */     for (byte b = 0; b < arrayOfString.length; b++) {
/*  784 */       paramPrintWriter.println(arrayOfString[b]);
/*      */     }
/*  786 */     paramPrintWriter.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] getRootCauseStackTrace(Throwable paramThrowable) {
/*  804 */     if (paramThrowable == null) {
/*  805 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/*  807 */     Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
/*  808 */     int i = arrayOfThrowable.length;
/*  809 */     ArrayList arrayList = new ArrayList();
/*  810 */     List list = getStackFrameList(arrayOfThrowable[i - 1]);
/*  811 */     for (int j = i; --j >= 0; ) {
/*  812 */       List list1 = list;
/*  813 */       if (j != 0) {
/*  814 */         list = getStackFrameList(arrayOfThrowable[j - 1]);
/*  815 */         removeCommonFrames(list1, list);
/*      */       } 
/*  817 */       if (j == i - 1) {
/*  818 */         arrayList.add(arrayOfThrowable[j].toString());
/*      */       } else {
/*  820 */         arrayList.add(" [wrapped] " + arrayOfThrowable[j].toString());
/*      */       } 
/*  822 */       for (byte b = 0; b < list1.size(); b++) {
/*  823 */         arrayList.add(list1.get(b));
/*      */       }
/*      */     } 
/*  826 */     return arrayList.<String>toArray(new String[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void removeCommonFrames(List paramList1, List paramList2) {
/*  838 */     if (paramList1 == null || paramList2 == null) {
/*  839 */       throw new IllegalArgumentException("The List must not be null");
/*      */     }
/*  841 */     int i = paramList1.size() - 1;
/*  842 */     int j = paramList2.size() - 1;
/*  843 */     while (i >= 0 && j >= 0) {
/*      */ 
/*      */       
/*  846 */       String str1 = paramList1.get(i);
/*  847 */       String str2 = paramList2.get(j);
/*  848 */       if (str1.equals(str2)) {
/*  849 */         paramList1.remove(i);
/*      */       }
/*  851 */       i--;
/*  852 */       j--;
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
/*      */   public static String getFullStackTrace(Throwable paramThrowable) {
/*  868 */     StringWriter stringWriter = new StringWriter();
/*  869 */     PrintWriter printWriter = new PrintWriter(stringWriter, true);
/*  870 */     Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
/*  871 */     for (byte b = 0; b < arrayOfThrowable.length; b++) {
/*  872 */       arrayOfThrowable[b].printStackTrace(printWriter);
/*  873 */       if (isNestedThrowable(arrayOfThrowable[b])) {
/*      */         break;
/*      */       }
/*      */     } 
/*  877 */     return stringWriter.getBuffer().toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getStackTrace(Throwable paramThrowable) {
/*  894 */     StringWriter stringWriter = new StringWriter();
/*  895 */     PrintWriter printWriter = new PrintWriter(stringWriter, true);
/*  896 */     paramThrowable.printStackTrace(printWriter);
/*  897 */     return stringWriter.getBuffer().toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] getStackFrames(Throwable paramThrowable) {
/*  914 */     if (paramThrowable == null) {
/*  915 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/*  917 */     return getStackFrames(getStackTrace(paramThrowable));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String[] getStackFrames(String paramString) {
/*  934 */     String str = SystemUtils.LINE_SEPARATOR;
/*  935 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, str);
/*  936 */     ArrayList arrayList = new ArrayList();
/*  937 */     while (stringTokenizer.hasMoreTokens()) {
/*  938 */       arrayList.add(stringTokenizer.nextToken());
/*      */     }
/*  940 */     return toArray(arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static List getStackFrameList(Throwable paramThrowable) {
/*  956 */     String str1 = getStackTrace(paramThrowable);
/*  957 */     String str2 = SystemUtils.LINE_SEPARATOR;
/*  958 */     StringTokenizer stringTokenizer = new StringTokenizer(str1, str2);
/*  959 */     ArrayList arrayList = new ArrayList();
/*  960 */     boolean bool = false;
/*  961 */     while (stringTokenizer.hasMoreTokens()) {
/*  962 */       String str = stringTokenizer.nextToken();
/*      */       
/*  964 */       int i = str.indexOf("at");
/*  965 */       if (i != -1 && str.substring(0, i).trim().length() == 0) {
/*  966 */         bool = true;
/*  967 */         arrayList.add(str); continue;
/*  968 */       }  if (bool) {
/*      */         break;
/*      */       }
/*      */     } 
/*  972 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getMessage(Throwable paramThrowable) {
/*  987 */     if (paramThrowable == null) {
/*  988 */       return "";
/*      */     }
/*  990 */     String str1 = ClassUtils.getShortClassName(paramThrowable, null);
/*  991 */     String str2 = paramThrowable.getMessage();
/*  992 */     return str1 + ": " + StringUtils.defaultString(str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getRootCauseMessage(Throwable paramThrowable) {
/* 1007 */     Throwable throwable = getRootCause(paramThrowable);
/* 1008 */     throwable = (throwable == null) ? paramThrowable : throwable;
/* 1009 */     return getMessage(throwable);
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/exception/ExceptionUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */