/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.reflect;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ClassUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MethodUtils
/*     */ {
/*     */   public static Object invokeMethod(Object paramObject1, String paramString, Object paramObject2) {
/*  95 */     return invokeMethod(paramObject1, paramString, new Object[] { paramObject2 });
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
/*     */   public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject) {
/* 123 */     if (paramArrayOfObject == null) {
/* 124 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 126 */     int i = paramArrayOfObject.length;
/* 127 */     Class[] arrayOfClass = new Class[i];
/* 128 */     for (byte b = 0; b < i; b++) {
/* 129 */       arrayOfClass[b] = paramArrayOfObject[b].getClass();
/*     */     }
/* 131 */     return invokeMethod(paramObject, paramString, paramArrayOfObject, arrayOfClass);
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
/*     */   public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass) {
/* 157 */     if (paramArrayOfClass == null) {
/* 158 */       paramArrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 160 */     if (paramArrayOfObject == null) {
/* 161 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 163 */     Method method = getMatchingAccessibleMethod(paramObject.getClass(), paramString, paramArrayOfClass);
/*     */     
/* 165 */     if (method == null) {
/* 166 */       throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
/*     */     }
/*     */ 
/*     */     
/* 170 */     return method.invoke(paramObject, paramArrayOfObject);
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
/*     */   public static Object invokeExactMethod(Object paramObject1, String paramString, Object paramObject2) {
/* 195 */     return invokeExactMethod(paramObject1, paramString, new Object[] { paramObject2 });
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
/*     */   public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject) {
/* 219 */     if (paramArrayOfObject == null) {
/* 220 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 222 */     int i = paramArrayOfObject.length;
/* 223 */     Class[] arrayOfClass = new Class[i];
/* 224 */     for (byte b = 0; b < i; b++) {
/* 225 */       arrayOfClass[b] = paramArrayOfObject[b].getClass();
/*     */     }
/* 227 */     return invokeExactMethod(paramObject, paramString, paramArrayOfObject, arrayOfClass);
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
/*     */   public static Object invokeExactMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass) {
/* 253 */     if (paramArrayOfObject == null) {
/* 254 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 256 */     if (paramArrayOfClass == null) {
/* 257 */       paramArrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 259 */     Method method = getAccessibleMethod(paramObject.getClass(), paramString, paramArrayOfClass);
/*     */     
/* 261 */     if (method == null) {
/* 262 */       throw new NoSuchMethodException("No such accessible method: " + paramString + "() on object: " + paramObject.getClass().getName());
/*     */     }
/*     */ 
/*     */     
/* 266 */     return method.invoke(paramObject, paramArrayOfObject);
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
/*     */   public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass) {
/* 292 */     if (paramArrayOfObject == null) {
/* 293 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 295 */     if (paramArrayOfClass == null) {
/* 296 */       paramArrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 298 */     Method method = getAccessibleMethod(paramClass, paramString, paramArrayOfClass);
/* 299 */     if (method == null) {
/* 300 */       throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
/*     */     }
/*     */     
/* 303 */     return method.invoke(null, paramArrayOfObject);
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
/*     */   public static Object invokeStaticMethod(Class paramClass, String paramString, Object paramObject) {
/* 333 */     return invokeStaticMethod(paramClass, paramString, new Object[] { paramObject });
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
/*     */   public static Object invokeStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject) {
/* 363 */     if (paramArrayOfObject == null) {
/* 364 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 366 */     int i = paramArrayOfObject.length;
/* 367 */     Class[] arrayOfClass = new Class[i];
/* 368 */     for (byte b = 0; b < i; b++) {
/* 369 */       arrayOfClass[b] = paramArrayOfObject[b].getClass();
/*     */     }
/* 371 */     return invokeStaticMethod(paramClass, paramString, paramArrayOfObject, arrayOfClass);
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
/*     */   public static Object invokeStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass) {
/* 400 */     if (paramArrayOfClass == null) {
/* 401 */       paramArrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 403 */     if (paramArrayOfObject == null) {
/* 404 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 406 */     Method method = getMatchingAccessibleMethod(paramClass, paramString, paramArrayOfClass);
/*     */     
/* 408 */     if (method == null) {
/* 409 */       throw new NoSuchMethodException("No such accessible method: " + paramString + "() on class: " + paramClass.getName());
/*     */     }
/*     */     
/* 412 */     return method.invoke(null, paramArrayOfObject);
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
/*     */   public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object paramObject) {
/* 437 */     return invokeExactStaticMethod(paramClass, paramString, new Object[] { paramObject });
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
/*     */   public static Object invokeExactStaticMethod(Class paramClass, String paramString, Object[] paramArrayOfObject) {
/* 461 */     if (paramArrayOfObject == null) {
/* 462 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 464 */     int i = paramArrayOfObject.length;
/* 465 */     Class[] arrayOfClass = new Class[i];
/* 466 */     for (byte b = 0; b < i; b++) {
/* 467 */       arrayOfClass[b] = paramArrayOfObject[b].getClass();
/*     */     }
/* 469 */     return invokeExactStaticMethod(paramClass, paramString, paramArrayOfObject, arrayOfClass);
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
/*     */   public static Method getAccessibleMethod(Class paramClass1, String paramString, Class paramClass2) {
/* 486 */     return getAccessibleMethod(paramClass1, paramString, new Class[] { paramClass2 });
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
/*     */   public static Method getAccessibleMethod(Class paramClass, String paramString, Class[] paramArrayOfClass) {
/*     */     try {
/* 505 */       return getAccessibleMethod(paramClass.getMethod(paramString, paramArrayOfClass));
/*     */     }
/* 507 */     catch (NoSuchMethodException noSuchMethodException) {
/* 508 */       return null;
/*     */     } 
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
/*     */   public static Method getAccessibleMethod(Method paramMethod) {
/* 521 */     if (!MemberUtils.isAccessible(paramMethod)) {
/* 522 */       return null;
/*     */     }
/*     */     
/* 525 */     Class clazz = paramMethod.getDeclaringClass();
/* 526 */     if (Modifier.isPublic(clazz.getModifiers())) {
/* 527 */       return paramMethod;
/*     */     }
/* 529 */     String str = paramMethod.getName();
/* 530 */     Class[] arrayOfClass = paramMethod.getParameterTypes();
/*     */ 
/*     */     
/* 533 */     paramMethod = getAccessibleMethodFromInterfaceNest(clazz, str, arrayOfClass);
/*     */ 
/*     */ 
/*     */     
/* 537 */     if (paramMethod == null) {
/* 538 */       paramMethod = getAccessibleMethodFromSuperclass(clazz, str, arrayOfClass);
/*     */     }
/*     */     
/* 541 */     return paramMethod;
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
/*     */   private static Method getAccessibleMethodFromSuperclass(Class paramClass, String paramString, Class[] paramArrayOfClass) {
/* 556 */     Class clazz = paramClass.getSuperclass();
/* 557 */     while (clazz != null) {
/* 558 */       if (Modifier.isPublic(clazz.getModifiers())) {
/*     */         try {
/* 560 */           return clazz.getMethod(paramString, paramArrayOfClass);
/* 561 */         } catch (NoSuchMethodException noSuchMethodException) {
/* 562 */           return null;
/*     */         } 
/*     */       }
/* 565 */       clazz = clazz.getSuperclass();
/*     */     } 
/* 567 */     return null;
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
/*     */   private static Method getAccessibleMethodFromInterfaceNest(Class paramClass, String paramString, Class[] paramArrayOfClass) {
/* 587 */     Method method = null;
/*     */ 
/*     */     
/* 590 */     for (; paramClass != null; paramClass = paramClass.getSuperclass()) {
/*     */ 
/*     */       
/* 593 */       Class[] arrayOfClass = paramClass.getInterfaces();
/* 594 */       for (byte b = 0; b < arrayOfClass.length; b++) {
/*     */         
/* 596 */         if (Modifier.isPublic(arrayOfClass[b].getModifiers())) {
/*     */ 
/*     */           
/*     */           try {
/*     */             
/* 601 */             method = arrayOfClass[b].getDeclaredMethod(paramString, paramArrayOfClass);
/*     */           }
/* 603 */           catch (NoSuchMethodException noSuchMethodException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 609 */           if (method != null) {
/*     */             break;
/*     */           }
/*     */           
/* 613 */           method = getAccessibleMethodFromInterfaceNest(arrayOfClass[b], paramString, paramArrayOfClass);
/*     */           
/* 615 */           if (method != null)
/*     */             break; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 620 */     return method;
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
/*     */   public static Method getMatchingAccessibleMethod(Class paramClass, String paramString, Class[] paramArrayOfClass) {
/*     */     try {
/* 646 */       Method method = paramClass.getMethod(paramString, paramArrayOfClass);
/* 647 */       MemberUtils.setAccessibleWorkaround(method);
/* 648 */       return method;
/* 649 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */       Method method;
/*     */       
/* 652 */       noSuchMethodException = null;
/* 653 */       Method[] arrayOfMethod = paramClass.getMethods(); byte b; int i;
/* 654 */       for (b = 0, i = arrayOfMethod.length; b < i; b++) {
/* 655 */         if (arrayOfMethod[b].getName().equals(paramString))
/*     */         {
/* 657 */           if (ClassUtils.isAssignable(paramArrayOfClass, arrayOfMethod[b].getParameterTypes(), true)) {
/*     */ 
/*     */             
/* 660 */             Method method1 = getAccessibleMethod(arrayOfMethod[b]);
/* 661 */             if (method1 != null && (
/* 662 */               noSuchMethodException == null || MemberUtils.compareParameterTypes(method1.getParameterTypes(), noSuchMethodException.getParameterTypes(), paramArrayOfClass) < 0))
/*     */             {
/*     */ 
/*     */ 
/*     */               
/* 667 */               method = method1;
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 673 */       if (method != null) {
/* 674 */         MemberUtils.setAccessibleWorkaround(method);
/*     */       }
/* 676 */       return method;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/reflect/MethodUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */