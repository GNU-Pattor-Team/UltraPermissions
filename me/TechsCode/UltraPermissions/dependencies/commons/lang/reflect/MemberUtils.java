/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.reflect;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ClassUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.SystemUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class MemberUtils
/*     */ {
/*     */   private static final int ACCESS_TEST = 7;
/*     */   private static final Method IS_SYNTHETIC;
/*     */   
/*     */   static {
/*  46 */     Method method = null;
/*  47 */     if (SystemUtils.isJavaVersionAtLeast(1.5F)) {
/*     */       
/*     */       try {
/*  50 */         method = Member.class.getMethod("isSynthetic", ArrayUtils.EMPTY_CLASS_ARRAY);
/*     */       }
/*  52 */       catch (Exception exception) {}
/*     */     }
/*     */     
/*  55 */     IS_SYNTHETIC = method;
/*     */   }
/*     */ 
/*     */   
/*  59 */   private static final Class[] ORDERED_PRIMITIVE_TYPES = new Class[] { byte.class, short.class, char.class, int.class, long.class, float.class, double.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void setAccessibleWorkaround(AccessibleObject paramAccessibleObject) {
/*  75 */     if (paramAccessibleObject == null || paramAccessibleObject.isAccessible()) {
/*     */       return;
/*     */     }
/*  78 */     Member member = (Member)paramAccessibleObject;
/*  79 */     if (Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
/*     */       
/*     */       try {
/*  82 */         paramAccessibleObject.setAccessible(true);
/*  83 */       } catch (SecurityException securityException) {}
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
/*     */   static boolean isPackageAccess(int paramInt) {
/*  95 */     return ((paramInt & 0x7) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isAccessible(Member paramMember) {
/* 104 */     return (paramMember != null && Modifier.isPublic(paramMember.getModifiers()) && !isSynthetic(paramMember));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isSynthetic(Member paramMember) {
/* 113 */     if (IS_SYNTHETIC != null) {
/*     */       try {
/* 115 */         return ((Boolean)IS_SYNTHETIC.invoke(paramMember, null)).booleanValue();
/* 116 */       } catch (Exception exception) {}
/*     */     }
/*     */     
/* 119 */     return false;
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
/*     */   static int compareParameterTypes(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, Class[] paramArrayOfClass3) {
/* 135 */     float f1 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass1);
/* 136 */     float f2 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass2);
/* 137 */     return (f1 < f2) ? -1 : ((f2 < f1) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float getTotalTransformationCost(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2) {
/* 148 */     float f = 0.0F;
/* 149 */     for (byte b = 0; b < paramArrayOfClass1.length; b++) {
/*     */       
/* 151 */       Class clazz1 = paramArrayOfClass1[b];
/* 152 */       Class clazz2 = paramArrayOfClass2[b];
/* 153 */       f += getObjectTransformationCost(clazz1, clazz2);
/*     */     } 
/* 155 */     return f;
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
/*     */   private static float getObjectTransformationCost(Class paramClass1, Class paramClass2) {
/* 167 */     if (paramClass2.isPrimitive()) {
/* 168 */       return getPrimitivePromotionCost(paramClass1, paramClass2);
/*     */     }
/* 170 */     float f = 0.0F;
/* 171 */     while (paramClass1 != null && !paramClass2.equals(paramClass1)) {
/* 172 */       if (paramClass2.isInterface() && ClassUtils.isAssignable(paramClass1, paramClass2)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 178 */         f += 0.25F;
/*     */         break;
/*     */       } 
/* 181 */       f++;
/* 182 */       paramClass1 = paramClass1.getSuperclass();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     if (paramClass1 == null) {
/* 189 */       f += 1.5F;
/*     */     }
/* 191 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float getPrimitivePromotionCost(Class paramClass1, Class paramClass2) {
/* 202 */     float f = 0.0F;
/* 203 */     Class clazz = paramClass1;
/* 204 */     if (!clazz.isPrimitive()) {
/*     */       
/* 206 */       f += 0.1F;
/* 207 */       clazz = ClassUtils.wrapperToPrimitive(clazz);
/*     */     } 
/* 209 */     for (byte b = 0; clazz != paramClass2 && b < ORDERED_PRIMITIVE_TYPES.length; b++) {
/* 210 */       if (clazz == ORDERED_PRIMITIVE_TYPES[b]) {
/* 211 */         f += 0.1F;
/* 212 */         if (b < ORDERED_PRIMITIVE_TYPES.length - 1) {
/* 213 */           clazz = ORDERED_PRIMITIVE_TYPES[b + 1];
/*     */         }
/*     */       } 
/*     */     } 
/* 217 */     return f;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/reflect/MemberUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */