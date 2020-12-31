/*    */ package me.TechsCode.UltraPermissions.base.legacy.utils;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.function.Supplier;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.entity.ArmorStand;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Armorstands
/*    */ {
/*    */   private static final Method[] methods;
/*    */   
/*    */   static {
/* 22 */     methods = (() -> { try { Method method = Class.forName(Bukkit.getServer().getClass().getPackage().getName() + ".entity.CraftEntity").getDeclaredMethod("getHandle", new Class[0]); return (Supplier)new Method[] { method, method.getReturnType().getDeclaredMethod("setPositionRotation", new Class[] { double.class, double.class, double.class, float.class, float.class }) }; } catch (Exception exception) { return null; }  }).get();
/*    */   }
/*    */   public static void move(ArmorStand paramArmorStand, Location paramLocation) {
/*    */     try {
/* 26 */       methods[1].invoke(methods[0].invoke(paramArmorStand, new Object[0]), new Object[] { Double.valueOf(paramLocation.getX()), Double.valueOf(paramLocation.getY()), Double.valueOf(paramLocation.getZ()), Float.valueOf(paramLocation.getYaw()), Float.valueOf(paramLocation.getPitch()) });
/* 27 */     } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/* 28 */       illegalAccessException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/utils/Armorstands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */