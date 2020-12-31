/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations;
/*    */ 
/*    */ import java.lang.invoke.SerializedLambda;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.HashSet;
/*    */ import java.util.function.Function;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.ref.MethodRefrence;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.ref.MethodRefrence1;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.ref.MethodRefrence2;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FAUtil
/*    */ {
/*    */   public static <T> T getAnnotation(MethodRefrence paramMethodRefrence, Class<T> paramClass) {
/* 18 */     return (T)getInternalMethod(paramMethodRefrence).getAnnotation((Class)paramClass);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T, Z> T getAnnotation(MethodRefrence1<Z> paramMethodRefrence1, Class<T> paramClass) {
/* 23 */     return (T)getInternalMethod(paramMethodRefrence1).getAnnotation((Class)paramClass);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T, Z, X> T getAnnotation(MethodRefrence2<Z, X> paramMethodRefrence2, Class<T> paramClass) {
/* 28 */     return (T)getInternalMethod(paramMethodRefrence2).getAnnotation((Class)paramClass);
/*    */   }
/*    */   
/*    */   public static Method getMethod(MethodRefrence paramMethodRefrence) {
/* 32 */     return getInternalMethod(paramMethodRefrence);
/*    */   }
/*    */   
/*    */   public static <Z> Method getMethod(MethodRefrence1<Z> paramMethodRefrence1) {
/* 36 */     return getInternalMethod(paramMethodRefrence1);
/*    */   }
/*    */   
/*    */   public static <T, Z> Method getMethod(MethodRefrence2<T, Z> paramMethodRefrence2) {
/* 40 */     return getInternalMethod(paramMethodRefrence2);
/*    */   }
/*    */   
/*    */   public static void check(MethodRefrence paramMethodRefrence, Function<Method, Boolean> paramFunction) {
/* 44 */     checkLambda(paramMethodRefrence, paramFunction);
/*    */   }
/*    */   
/*    */   public static <T> T check(MethodRefrence1<T> paramMethodRefrence1, Function<Method, Boolean> paramFunction) {
/* 48 */     checkLambda(paramMethodRefrence1, paramFunction);
/* 49 */     return null;
/*    */   }
/*    */   
/*    */   public static <T, Z> T check(MethodRefrence2<T, Z> paramMethodRefrence2, Function<Method, Boolean> paramFunction) {
/* 53 */     checkLambda(paramMethodRefrence2, paramFunction);
/* 54 */     return null;
/*    */   }
/*    */   
/* 57 */   private static HashSet<String> cache = new HashSet<>();
/*    */   
/*    */   private static void checkLambda(Object paramObject, Function<Method, Boolean> paramFunction) {
/* 60 */     if (cache.contains(paramObject.toString().split("/")[0]))
/*    */       return; 
/* 62 */     Method method = getInternalMethod(paramObject);
/* 63 */     if (method != null) {
/* 64 */       Boolean bool = paramFunction.apply(method);
/* 65 */       if (bool.booleanValue() == true) {
/* 66 */         cache.add(paramObject.toString().split("/")[0]);
/*    */       }
/*    */     } 
/* 69 */     cache.add(paramObject.toString().split("/")[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static Method getInternalMethod(Object paramObject) {
/* 75 */     for (Class<?> clazz = paramObject.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
/*    */       try {
/* 77 */         Method method = clazz.getDeclaredMethod("writeReplace", new Class[0]);
/* 78 */         method.setAccessible(true);
/* 79 */         Object object = method.invoke(paramObject, new Object[0]);
/* 80 */         if (!(object instanceof SerializedLambda))
/*    */           break; 
/* 82 */         SerializedLambda serializedLambda = (SerializedLambda)object;
/* 83 */         for (Method method1 : Class.forName(serializedLambda.getImplClass().replace('/', '.')).getDeclaredMethods()) {
/* 84 */           if (method1.getName().equals(serializedLambda.getImplMethodName()))
/*    */           {
/*    */ 
/*    */             
/* 88 */             return method1;
/*    */           }
/*    */         } 
/* 91 */       } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/*    */         break;
/* 93 */       } catch (Exception exception) {}
/*    */     } 
/*    */     
/* 96 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/annotations/FAUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */