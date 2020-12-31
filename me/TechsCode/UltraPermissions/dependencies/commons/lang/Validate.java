/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Validate
/*     */ {
/*     */   public static void isTrue(boolean paramBoolean, String paramString, Object paramObject) {
/*  70 */     if (!paramBoolean) {
/*  71 */       throw new IllegalArgumentException(paramString + paramObject);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean, String paramString, long paramLong) {
/*  92 */     if (!paramBoolean) {
/*  93 */       throw new IllegalArgumentException(paramString + paramLong);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean, String paramString, double paramDouble) {
/* 114 */     if (!paramBoolean) {
/* 115 */       throw new IllegalArgumentException(paramString + paramDouble);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean, String paramString) {
/* 135 */     if (!paramBoolean) {
/* 136 */       throw new IllegalArgumentException(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void isTrue(boolean paramBoolean) {
/* 157 */     if (!paramBoolean) {
/* 158 */       throw new IllegalArgumentException("The validated expression is false");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notNull(Object paramObject) {
/* 178 */     notNull(paramObject, "The validated object is null");
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
/*     */   public static void notNull(Object paramObject, String paramString) {
/* 191 */     if (paramObject == null) {
/* 192 */       throw new IllegalArgumentException(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(Object[] paramArrayOfObject, String paramString) {
/* 211 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/* 212 */       throw new IllegalArgumentException(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(Object[] paramArrayOfObject) {
/* 229 */     notEmpty(paramArrayOfObject, "The validated array is empty");
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
/*     */   public static void notEmpty(Collection paramCollection, String paramString) {
/* 247 */     if (paramCollection == null || paramCollection.size() == 0) {
/* 248 */       throw new IllegalArgumentException(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(Collection paramCollection) {
/* 265 */     notEmpty(paramCollection, "The validated collection is empty");
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
/*     */   public static void notEmpty(Map paramMap, String paramString) {
/* 283 */     if (paramMap == null || paramMap.size() == 0) {
/* 284 */       throw new IllegalArgumentException(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(Map paramMap) {
/* 302 */     notEmpty(paramMap, "The validated map is empty");
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
/*     */   public static void notEmpty(String paramString1, String paramString2) {
/* 320 */     if (paramString1 == null || paramString1.length() == 0) {
/* 321 */       throw new IllegalArgumentException(paramString2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void notEmpty(String paramString) {
/* 339 */     notEmpty(paramString, "The validated string is empty");
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
/*     */   public static void noNullElements(Object[] paramArrayOfObject, String paramString) {
/* 361 */     notNull(paramArrayOfObject);
/* 362 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 363 */       if (paramArrayOfObject[b] == null) {
/* 364 */         throw new IllegalArgumentException(paramString);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void noNullElements(Object[] paramArrayOfObject) {
/* 388 */     notNull(paramArrayOfObject);
/* 389 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 390 */       if (paramArrayOfObject[b] == null) {
/* 391 */         throw new IllegalArgumentException("The validated array contains null element at index: " + b);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void noNullElements(Collection paramCollection, String paramString) {
/* 416 */     notNull(paramCollection);
/* 417 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext();) {
/* 418 */       if (iterator.next() == null) {
/* 419 */         throw new IllegalArgumentException(paramString);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void noNullElements(Collection paramCollection) {
/* 443 */     notNull(paramCollection);
/* 444 */     byte b = 0;
/* 445 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext(); b++) {
/* 446 */       if (iterator.next() == null) {
/* 447 */         throw new IllegalArgumentException("The validated collection contains null element at index: " + b);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void allElementsOfType(Collection paramCollection, Class paramClass, String paramString) {
/* 467 */     notNull(paramCollection);
/* 468 */     notNull(paramClass);
/* 469 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext();) {
/* 470 */       if (!paramClass.isInstance(iterator.next())) {
/* 471 */         throw new IllegalArgumentException(paramString);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void allElementsOfType(Collection paramCollection, Class paramClass) {
/* 495 */     notNull(paramCollection);
/* 496 */     notNull(paramClass);
/* 497 */     byte b = 0;
/* 498 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext(); b++) {
/* 499 */       if (!paramClass.isInstance(iterator.next()))
/* 500 */         throw new IllegalArgumentException("The validated collection contains an element not of type " + paramClass.getName() + " at index: " + b); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/Validate.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */