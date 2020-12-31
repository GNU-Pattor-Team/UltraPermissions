/*    */ package me.TechsCode.UltraPermissions.base.reflection.titleAndActionbar;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
/*    */ import org.bukkit.Bukkit;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Reflection
/*    */ {
/*    */   public static Class<?> getNMSClass(String paramString) {
/* 12 */     return getClass("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().substring(23) + "." + paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Class<?> getCraftClass(String paramString) {
/* 17 */     return getClass("org.bukkit.craftbukkit." + Bukkit.getServer().getClass().getPackage().getName().substring(23) + "." + paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static Class<?> getClass(String paramString) {
/*    */     try {
/* 24 */       return Class.forName(paramString);
/*    */     }
/* 26 */     catch (Exception exception) {
/*    */       
/* 28 */       exception.printStackTrace();
/*    */       
/* 30 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static Object getValue(Object paramObject, String paramString) {
/*    */     try {
/* 37 */       Field field = paramObject.getClass().getDeclaredField(paramString);
/* 38 */       if (!field.isAccessible()) {
/* 39 */         field.setAccessible(true);
/*    */       }
/* 41 */       return field.get(paramObject);
/*    */     }
/* 43 */     catch (Exception exception) {
/*    */       
/* 45 */       exception.printStackTrace();
/*    */       
/* 47 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static Method getMethod(Object paramObject, String paramString, Class<?>... paramVarArgs) {
/*    */     try {
/* 54 */       Method method = paramObject.getClass().getMethod(paramString, paramVarArgs);
/* 55 */       if (!method.isAccessible()) {
/* 56 */         method.setAccessible(true);
/*    */       }
/* 58 */       return method;
/*    */     }
/* 60 */     catch (Exception exception) {
/*    */       
/* 62 */       exception.printStackTrace();
/*    */       
/* 64 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Field getField(Field paramField) {
/* 69 */     paramField.setAccessible(true);
/* 70 */     return paramField;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/reflection/titleAndActionbar/Reflection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */