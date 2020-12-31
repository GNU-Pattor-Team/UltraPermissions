/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.exception.CloneFailedException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.reflect.MethodUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObjectUtils
/*     */ {
/*  63 */   public static final Null NULL = new Null();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object defaultIfNull(Object paramObject1, Object paramObject2) {
/*  96 */     return (paramObject1 != null) ? paramObject1 : paramObject2;
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
/*     */   public static boolean equals(Object paramObject1, Object paramObject2) {
/* 119 */     if (paramObject1 == paramObject2) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (paramObject1 == null || paramObject2 == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return paramObject1.equals(paramObject2);
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
/*     */   public static boolean notEqual(Object paramObject1, Object paramObject2) {
/* 149 */     return !equals(paramObject1, paramObject2);
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
/*     */   public static int hashCode(Object paramObject) {
/* 166 */     return (paramObject == null) ? 0 : paramObject.hashCode();
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
/*     */   public static String identityToString(Object paramObject) {
/* 188 */     if (paramObject == null) {
/* 189 */       return null;
/*     */     }
/* 191 */     StringBuffer stringBuffer = new StringBuffer();
/* 192 */     identityToString(stringBuffer, paramObject);
/* 193 */     return stringBuffer.toString();
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
/*     */   public static void identityToString(StringBuffer paramStringBuffer, Object paramObject) {
/* 212 */     if (paramObject == null) {
/* 213 */       throw new NullPointerException("Cannot get the toString of a null identity");
/*     */     }
/* 215 */     paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
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
/*     */   public static StringBuffer appendIdentityToString(StringBuffer paramStringBuffer, Object paramObject) {
/* 240 */     if (paramObject == null) {
/* 241 */       return null;
/*     */     }
/* 243 */     if (paramStringBuffer == null) {
/* 244 */       paramStringBuffer = new StringBuffer();
/*     */     }
/* 246 */     return paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
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
/*     */   public static String toString(Object paramObject) {
/* 272 */     return (paramObject == null) ? "" : paramObject.toString();
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
/*     */   public static String toString(Object paramObject, String paramString) {
/* 295 */     return (paramObject == null) ? paramString : paramObject.toString();
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
/*     */   public static Object min(Comparable paramComparable1, Comparable paramComparable2) {
/* 314 */     return (compare(paramComparable1, paramComparable2, true) <= 0) ? paramComparable1 : paramComparable2;
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
/*     */   public static Object max(Comparable paramComparable1, Comparable paramComparable2) {
/* 331 */     return (compare(paramComparable1, paramComparable2, false) >= 0) ? paramComparable1 : paramComparable2;
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
/*     */   public static int compare(Comparable paramComparable1, Comparable paramComparable2) {
/* 345 */     return compare(paramComparable1, paramComparable2, false);
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
/*     */   public static int compare(Comparable paramComparable1, Comparable paramComparable2, boolean paramBoolean) {
/* 362 */     if (paramComparable1 == paramComparable2)
/* 363 */       return 0; 
/* 364 */     if (paramComparable1 == null)
/* 365 */       return paramBoolean ? 1 : -1; 
/* 366 */     if (paramComparable2 == null) {
/* 367 */       return paramBoolean ? -1 : 1;
/*     */     }
/* 369 */     return paramComparable1.compareTo(paramComparable2);
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
/*     */   public static Object clone(Object paramObject) {
/* 381 */     if (paramObject instanceof Cloneable) {
/*     */       Object object;
/* 383 */       if (paramObject.getClass().isArray()) {
/* 384 */         Class clazz = paramObject.getClass().getComponentType();
/* 385 */         if (!clazz.isPrimitive()) {
/* 386 */           object = ((Object[])paramObject).clone();
/*     */         } else {
/* 388 */           int i = Array.getLength(paramObject);
/* 389 */           object = Array.newInstance(clazz, i);
/* 390 */           while (i-- > 0) {
/* 391 */             Array.set(object, i, Array.get(paramObject, i));
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         try {
/* 396 */           object = MethodUtils.invokeMethod(paramObject, "clone", null);
/* 397 */         } catch (NoSuchMethodException noSuchMethodException) {
/* 398 */           throw new CloneFailedException("Cloneable type " + paramObject.getClass().getName() + " has no clone method", noSuchMethodException);
/*     */         
/*     */         }
/* 401 */         catch (IllegalAccessException illegalAccessException) {
/* 402 */           throw new CloneFailedException("Cannot clone Cloneable type " + paramObject.getClass().getName(), illegalAccessException);
/*     */         }
/* 404 */         catch (InvocationTargetException invocationTargetException) {
/* 405 */           throw new CloneFailedException("Exception cloning Cloneable type " + paramObject.getClass().getName(), invocationTargetException.getTargetException());
/*     */         } 
/*     */       } 
/*     */       
/* 409 */       return object;
/*     */     } 
/*     */     
/* 412 */     return null;
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
/*     */   public static Object cloneIfPossible(Object paramObject) {
/* 429 */     Object object = clone(paramObject);
/* 430 */     return (object == null) ? paramObject : object;
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
/*     */   public static class Null
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 7092611880189329093L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object readResolve() {
/* 470 */       return ObjectUtils.NULL;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/ObjectUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */