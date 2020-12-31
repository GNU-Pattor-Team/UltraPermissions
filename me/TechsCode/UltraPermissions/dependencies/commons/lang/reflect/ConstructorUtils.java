/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.reflect;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
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
/*     */ public class ConstructorUtils
/*     */ {
/*     */   public static Object invokeConstructor(Class paramClass, Object paramObject) {
/*  92 */     return invokeConstructor(paramClass, new Object[] { paramObject });
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
/*     */   public static Object invokeConstructor(Class paramClass, Object[] paramArrayOfObject) {
/* 120 */     if (null == paramArrayOfObject) {
/* 121 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 123 */     Class[] arrayOfClass = new Class[paramArrayOfObject.length];
/* 124 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 125 */       arrayOfClass[b] = paramArrayOfObject[b].getClass();
/*     */     }
/* 127 */     return invokeConstructor(paramClass, paramArrayOfObject, arrayOfClass);
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
/*     */   public static Object invokeConstructor(Class paramClass, Object[] paramArrayOfObject, Class[] paramArrayOfClass) {
/* 151 */     if (paramArrayOfClass == null) {
/* 152 */       paramArrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 154 */     if (paramArrayOfObject == null) {
/* 155 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 157 */     Constructor constructor = getMatchingAccessibleConstructor(paramClass, paramArrayOfClass);
/* 158 */     if (null == constructor) {
/* 159 */       throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
/*     */     }
/*     */     
/* 162 */     return constructor.newInstance(paramArrayOfObject);
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
/*     */   public static Object invokeExactConstructor(Class paramClass, Object paramObject) {
/* 188 */     return invokeExactConstructor(paramClass, new Object[] { paramObject });
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
/*     */   public static Object invokeExactConstructor(Class paramClass, Object[] paramArrayOfObject) {
/* 217 */     if (null == paramArrayOfObject) {
/* 218 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 220 */     int i = paramArrayOfObject.length;
/* 221 */     Class[] arrayOfClass = new Class[i];
/* 222 */     for (byte b = 0; b < i; b++) {
/* 223 */       arrayOfClass[b] = paramArrayOfObject[b].getClass();
/*     */     }
/* 225 */     return invokeExactConstructor(paramClass, paramArrayOfObject, arrayOfClass);
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
/*     */   public static Object invokeExactConstructor(Class paramClass, Object[] paramArrayOfObject, Class[] paramArrayOfClass) {
/* 249 */     if (paramArrayOfObject == null) {
/* 250 */       paramArrayOfObject = ArrayUtils.EMPTY_OBJECT_ARRAY;
/*     */     }
/* 252 */     if (paramArrayOfClass == null) {
/* 253 */       paramArrayOfClass = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 255 */     Constructor constructor = getAccessibleConstructor(paramClass, paramArrayOfClass);
/* 256 */     if (null == constructor) {
/* 257 */       throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
/*     */     }
/*     */     
/* 260 */     return constructor.newInstance(paramArrayOfObject);
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
/*     */   public static Constructor getAccessibleConstructor(Class paramClass1, Class paramClass2) {
/* 273 */     return getAccessibleConstructor(paramClass1, new Class[] { paramClass2 });
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
/*     */   public static Constructor getAccessibleConstructor(Class paramClass, Class[] paramArrayOfClass) {
/*     */     try {
/* 287 */       return getAccessibleConstructor(paramClass.getConstructor(paramArrayOfClass));
/* 288 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 289 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Constructor getAccessibleConstructor(Constructor paramConstructor) {
/* 300 */     return (MemberUtils.isAccessible(paramConstructor) && Modifier.isPublic(paramConstructor.getDeclaringClass().getModifiers())) ? paramConstructor : null;
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
/*     */   public static Constructor getMatchingAccessibleConstructor(Class paramClass, Class[] paramArrayOfClass) {
/*     */     try {
/* 325 */       Constructor constructor = paramClass.getConstructor(paramArrayOfClass);
/* 326 */       MemberUtils.setAccessibleWorkaround(constructor);
/* 327 */       return constructor;
/* 328 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */       Constructor constructor;
/* 330 */       noSuchMethodException = null;
/*     */       
/* 332 */       Constructor[] arrayOfConstructor = (Constructor[])paramClass.getConstructors();
/*     */       
/* 334 */       for (byte b = 0; b < arrayOfConstructor.length; b++) {
/*     */ 
/*     */         
/* 337 */         if (ClassUtils.isAssignable(paramArrayOfClass, arrayOfConstructor[b].getParameterTypes(), true)) {
/*     */           
/* 339 */           Constructor constructor1 = getAccessibleConstructor(arrayOfConstructor[b]);
/* 340 */           if (constructor1 != null) {
/* 341 */             MemberUtils.setAccessibleWorkaround(constructor1);
/* 342 */             if (noSuchMethodException == null || MemberUtils.compareParameterTypes(constructor1.getParameterTypes(), noSuchMethodException.getParameterTypes(), paramArrayOfClass) < 0)
/*     */             {
/*     */               
/* 345 */               constructor = constructor1;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 350 */       return constructor;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/reflect/ConstructorUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */