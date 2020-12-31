/*    */ package me.TechsCode.UltraPermissions.base.reflection;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import sun.misc.Unsafe;
/*    */ 
/*    */ 
/*    */ public class ClassInstanceCreator
/*    */ {
/*    */   static Unsafe unsafe;
/*    */   
/*    */   static {
/*    */     try {
/* 13 */       Field field = Unsafe.class.getDeclaredField("theUnsafe");
/* 14 */       field.setAccessible(true);
/* 15 */       unsafe = (Unsafe)field.get(null);
/* 16 */     } catch (Exception exception) {
/* 17 */       exception.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Object create(Class<?> paramClass) {
/*    */     try {
/* 23 */       return unsafe.allocateInstance(paramClass);
/* 24 */     } catch (InstantiationException instantiationException) {
/* 25 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/reflection/ClassInstanceCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */