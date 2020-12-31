/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.reflect;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Iterator;
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
/*     */ public class FieldUtils
/*     */ {
/*     */   public static Field getField(Class paramClass, String paramString) {
/*  60 */     Field field = getField(paramClass, paramString, false);
/*  61 */     MemberUtils.setAccessibleWorkaround(field);
/*  62 */     return field;
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
/*     */   public static Field getField(Class paramClass, String paramString, boolean paramBoolean) {
/*     */     Field field;
/*  78 */     if (paramClass == null) {
/*  79 */       throw new IllegalArgumentException("The class must not be null");
/*     */     }
/*  81 */     if (paramString == null) {
/*  82 */       throw new IllegalArgumentException("The field name must not be null");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Class clazz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     for (clazz = paramClass; clazz != null; clazz = clazz.getSuperclass()) {
/*     */       try {
/* 100 */         Field field1 = clazz.getDeclaredField(paramString);
/*     */ 
/*     */         
/* 103 */         if (!Modifier.isPublic(field1.getModifiers()))
/* 104 */         { if (paramBoolean)
/* 105 */           { field1.setAccessible(true);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 110 */             return field1; }  } else { return field1; } 
/* 111 */       } catch (NoSuchFieldException noSuchFieldException) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     clazz = null;
/* 119 */     Iterator iterator = ClassUtils.getAllInterfaces(paramClass).iterator();
/* 120 */     while (iterator.hasNext()) {
/*     */       try {
/* 122 */         Field field1 = ((Class)iterator.next()).getField(paramString);
/* 123 */         if (clazz != null) {
/* 124 */           throw new IllegalArgumentException("Reference to field " + paramString + " is ambiguous relative to " + paramClass + "; a matching field exists on two or more implemented interfaces.");
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 131 */         field = field1;
/* 132 */       } catch (NoSuchFieldException noSuchFieldException) {}
/*     */     } 
/*     */ 
/*     */     
/* 136 */     return field;
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
/*     */   public static Field getDeclaredField(Class paramClass, String paramString) {
/* 149 */     return getDeclaredField(paramClass, paramString, false);
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
/*     */   public static Field getDeclaredField(Class paramClass, String paramString, boolean paramBoolean) {
/* 164 */     if (paramClass == null) {
/* 165 */       throw new IllegalArgumentException("The class must not be null");
/*     */     }
/* 167 */     if (paramString == null) {
/* 168 */       throw new IllegalArgumentException("The field name must not be null");
/*     */     }
/*     */     
/*     */     try {
/* 172 */       Field field = paramClass.getDeclaredField(paramString);
/* 173 */       if (!MemberUtils.isAccessible(field)) {
/* 174 */         if (paramBoolean) {
/* 175 */           field.setAccessible(true);
/*     */         } else {
/* 177 */           return null;
/*     */         } 
/*     */       }
/* 180 */       return field;
/* 181 */     } catch (NoSuchFieldException noSuchFieldException) {
/*     */       
/* 183 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readStaticField(Field paramField) {
/* 194 */     return readStaticField(paramField, false);
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
/*     */   public static Object readStaticField(Field paramField, boolean paramBoolean) {
/* 207 */     if (paramField == null) {
/* 208 */       throw new IllegalArgumentException("The field must not be null");
/*     */     }
/* 210 */     if (!Modifier.isStatic(paramField.getModifiers())) {
/* 211 */       throw new IllegalArgumentException("The field '" + paramField.getName() + "' is not static");
/*     */     }
/* 213 */     return readField(paramField, (Object)null, paramBoolean);
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
/*     */   public static Object readStaticField(Class paramClass, String paramString) {
/* 225 */     return readStaticField(paramClass, paramString, false);
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
/*     */   public static Object readStaticField(Class paramClass, String paramString, boolean paramBoolean) {
/* 240 */     Field field = getField(paramClass, paramString, paramBoolean);
/* 241 */     if (field == null) {
/* 242 */       throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + paramClass);
/*     */     }
/*     */     
/* 245 */     return readStaticField(field, false);
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
/*     */   public static Object readDeclaredStaticField(Class paramClass, String paramString) {
/* 259 */     return readDeclaredStaticField(paramClass, paramString, false);
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
/*     */   public static Object readDeclaredStaticField(Class paramClass, String paramString, boolean paramBoolean) {
/* 277 */     Field field = getDeclaredField(paramClass, paramString, paramBoolean);
/* 278 */     if (field == null) {
/* 279 */       throw new IllegalArgumentException("Cannot locate declared field " + paramClass.getName() + "." + paramString);
/*     */     }
/*     */     
/* 282 */     return readStaticField(field, false);
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
/*     */   public static Object readField(Field paramField, Object paramObject) {
/* 294 */     return readField(paramField, paramObject, false);
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
/*     */   public static Object readField(Field paramField, Object paramObject, boolean paramBoolean) {
/* 308 */     if (paramField == null) {
/* 309 */       throw new IllegalArgumentException("The field must not be null");
/*     */     }
/* 311 */     if (paramBoolean && !paramField.isAccessible()) {
/* 312 */       paramField.setAccessible(true);
/*     */     } else {
/* 314 */       MemberUtils.setAccessibleWorkaround(paramField);
/*     */     } 
/* 316 */     return paramField.get(paramObject);
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
/*     */   public static Object readField(Object paramObject, String paramString) {
/* 328 */     return readField(paramObject, paramString, false);
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
/*     */   public static Object readField(Object paramObject, String paramString, boolean paramBoolean) {
/* 343 */     if (paramObject == null) {
/* 344 */       throw new IllegalArgumentException("target object must not be null");
/*     */     }
/* 346 */     Class clazz = paramObject.getClass();
/* 347 */     Field field = getField(clazz, paramString, paramBoolean);
/* 348 */     if (field == null) {
/* 349 */       throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + clazz);
/*     */     }
/*     */     
/* 352 */     return readField(field, paramObject);
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
/*     */   public static Object readDeclaredField(Object paramObject, String paramString) {
/* 364 */     return readDeclaredField(paramObject, paramString, false);
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
/*     */   public static Object readDeclaredField(Object paramObject, String paramString, boolean paramBoolean) {
/* 381 */     if (paramObject == null) {
/* 382 */       throw new IllegalArgumentException("target object must not be null");
/*     */     }
/* 384 */     Class clazz = paramObject.getClass();
/* 385 */     Field field = getDeclaredField(clazz, paramString, paramBoolean);
/* 386 */     if (field == null) {
/* 387 */       throw new IllegalArgumentException("Cannot locate declared field " + clazz.getName() + "." + paramString);
/*     */     }
/*     */     
/* 390 */     return readField(field, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeStaticField(Field paramField, Object paramObject) {
/* 401 */     writeStaticField(paramField, paramObject, false);
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
/*     */   public static void writeStaticField(Field paramField, Object paramObject, boolean paramBoolean) {
/* 415 */     if (paramField == null) {
/* 416 */       throw new IllegalArgumentException("The field must not be null");
/*     */     }
/* 418 */     if (!Modifier.isStatic(paramField.getModifiers())) {
/* 419 */       throw new IllegalArgumentException("The field '" + paramField.getName() + "' is not static");
/*     */     }
/* 421 */     writeField(paramField, (Object)null, paramObject, paramBoolean);
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
/*     */   public static void writeStaticField(Class paramClass, String paramString, Object paramObject) {
/* 433 */     writeStaticField(paramClass, paramString, paramObject, false);
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
/*     */   public static void writeStaticField(Class paramClass, String paramString, Object paramObject, boolean paramBoolean) {
/* 449 */     Field field = getField(paramClass, paramString, paramBoolean);
/* 450 */     if (field == null) {
/* 451 */       throw new IllegalArgumentException("Cannot locate field " + paramString + " on " + paramClass);
/*     */     }
/*     */     
/* 454 */     writeStaticField(field, paramObject);
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
/*     */   public static void writeDeclaredStaticField(Class paramClass, String paramString, Object paramObject) {
/* 467 */     writeDeclaredStaticField(paramClass, paramString, paramObject, false);
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
/*     */   public static void writeDeclaredStaticField(Class paramClass, String paramString, Object paramObject, boolean paramBoolean) {
/* 483 */     Field field = getDeclaredField(paramClass, paramString, paramBoolean);
/* 484 */     if (field == null) {
/* 485 */       throw new IllegalArgumentException("Cannot locate declared field " + paramClass.getName() + "." + paramString);
/*     */     }
/*     */     
/* 488 */     writeField(field, (Object)null, paramObject);
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
/*     */   public static void writeField(Field paramField, Object paramObject1, Object paramObject2) {
/* 500 */     writeField(paramField, paramObject1, paramObject2, false);
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
/*     */   public static void writeField(Field paramField, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/* 515 */     if (paramField == null) {
/* 516 */       throw new IllegalArgumentException("The field must not be null");
/*     */     }
/* 518 */     if (paramBoolean && !paramField.isAccessible()) {
/* 519 */       paramField.setAccessible(true);
/*     */     } else {
/* 521 */       MemberUtils.setAccessibleWorkaround(paramField);
/*     */     } 
/* 523 */     paramField.set(paramObject1, paramObject2);
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
/*     */   public static void writeField(Object paramObject1, String paramString, Object paramObject2) {
/* 535 */     writeField(paramObject1, paramString, paramObject2, false);
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
/*     */   public static void writeField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean) {
/* 551 */     if (paramObject1 == null) {
/* 552 */       throw new IllegalArgumentException("target object must not be null");
/*     */     }
/* 554 */     Class clazz = paramObject1.getClass();
/* 555 */     Field field = getField(clazz, paramString, paramBoolean);
/* 556 */     if (field == null) {
/* 557 */       throw new IllegalArgumentException("Cannot locate declared field " + clazz.getName() + "." + paramString);
/*     */     }
/*     */     
/* 560 */     writeField(field, paramObject1, paramObject2);
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
/*     */   public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2) {
/* 572 */     writeDeclaredField(paramObject1, paramString, paramObject2, false);
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
/*     */   public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean) {
/* 588 */     if (paramObject1 == null) {
/* 589 */       throw new IllegalArgumentException("target object must not be null");
/*     */     }
/* 591 */     Class clazz = paramObject1.getClass();
/* 592 */     Field field = getDeclaredField(clazz, paramString, paramBoolean);
/* 593 */     if (field == null) {
/* 594 */       throw new IllegalArgumentException("Cannot locate declared field " + clazz.getName() + "." + paramString);
/*     */     }
/*     */     
/* 597 */     writeField(field, paramObject1, paramObject2);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/reflect/FieldUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */