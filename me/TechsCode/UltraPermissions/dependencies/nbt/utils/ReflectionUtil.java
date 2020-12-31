/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
/*    */ import java.lang.reflect.Modifier;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.NbtApiException;
/*    */ 
/*    */ 
/*    */ public final class ReflectionUtil
/*    */ {
/*    */   private static Field field_modifiers;
/*    */   
/*    */   static {
/*    */     try {
/* 15 */       field_modifiers = Field.class.getDeclaredField("modifiers");
/* 16 */       field_modifiers.setAccessible(true);
/* 17 */     } catch (NoSuchFieldException noSuchFieldException) {
/*    */       
/*    */       try {
/* 20 */         Method method = Class.class.getDeclaredMethod("getDeclaredFields0", new Class[] { boolean.class });
/* 21 */         method.setAccessible(true);
/* 22 */         Field[] arrayOfField = (Field[])method.invoke(Field.class, new Object[] { Boolean.valueOf(false) });
/* 23 */         for (Field field : arrayOfField) {
/* 24 */           if (field.getName().equals("modifiers")) {
/* 25 */             field_modifiers = field;
/* 26 */             field_modifiers.setAccessible(true); break;
/*    */           } 
/*    */         } 
/* 29 */       } catch (Exception exception) {
/* 30 */         throw new NbtApiException(exception);
/*    */       } 
/*    */     } 
/* 33 */     if (field_modifiers == null) {
/* 34 */       throw new NbtApiException("Unable to init the modifiers Field.");
/*    */     }
/*    */   }
/*    */   
/*    */   public static Field makeNonFinal(Field paramField) {
/* 39 */     int i = paramField.getModifiers();
/* 40 */     if (Modifier.isFinal(i)) {
/* 41 */       field_modifiers.set(paramField, Integer.valueOf(i & 0xFFFFFFEF));
/*    */     }
/* 43 */     return paramField;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setFinal(Object paramObject1, Field paramField, Object paramObject2) {
/* 48 */     paramField.setAccessible(true);
/* 49 */     paramField = makeNonFinal(paramField);
/* 50 */     paramField.set(paramObject1, paramObject2);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/ReflectionUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */