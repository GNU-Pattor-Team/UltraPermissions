/*    */ package me.TechsCode.UltraPermissions.internal;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.permissions.PermissibleBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PermissibleInjector
/*    */ {
/*    */   private static final String CRAFTBUKKIT_PREFIX = "org.bukkit.craftbukkit";
/*    */   private static final String VERSION;
/*    */   
/*    */   public static String getCBClassName(String paramString) {
/* 17 */     if (VERSION == null) return null;
/*    */     
/* 19 */     return "org.bukkit.craftbukkit" + VERSION + paramString;
/*    */   }
/*    */   
/*    */   static {
/* 23 */     Class<?> clazz = Bukkit.getServer().getClass();
/* 24 */     if (!clazz.getSimpleName().equals("CraftServer")) {
/* 25 */       VERSION = null;
/* 26 */     } else if (clazz.getName().equals("org.bukkit.craftbukkit.CraftServer")) {
/* 27 */       VERSION = ".";
/*    */     } else {
/* 29 */       String str = clazz.getName();
/* 30 */       str = str.substring("org.bukkit.craftbukkit".length());
/* 31 */       str = str.substring(0, str.length() - "CraftServer".length());
/* 32 */       VERSION = str;
/*    */     } 
/*    */   }
/* 35 */   protected static final String className = getCBClassName("entity.CraftHumanEntity");
/* 36 */   protected static final String fieldName = "perm";
/*    */ 
/*    */   
/*    */   public static void inject(Player paramPlayer, PermissibleBase paramPermissibleBase) {
/* 40 */     Field field = null;
/*    */     try {
/* 42 */       field = getPermissibleField(paramPlayer);
/* 43 */     } catch (Exception exception) {}
/* 44 */     if (field == null) {
/*    */       return;
/*    */     }
/* 47 */     field.set(paramPlayer, paramPermissibleBase);
/*    */   }
/*    */   
/*    */   private static Field getPermissibleField(Player paramPlayer) {
/*    */     Class<?> clazz;
/*    */     try {
/* 53 */       clazz = Class.forName(className);
/* 54 */     } catch (ClassNotFoundException classNotFoundException) {
/* 55 */       throw new Exception("Invalid Server Jar");
/*    */     } 
/*    */     
/* 58 */     if (!clazz.isAssignableFrom(paramPlayer.getClass())) {
/* 59 */       System.out.println("Failed to inject permissions for " + paramPlayer.getName());
/* 60 */       return null;
/*    */     } 
/*    */     
/* 63 */     Field field = clazz.getDeclaredField(fieldName);
/*    */     
/* 65 */     field.setAccessible(true);
/* 66 */     return field;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/PermissibleInjector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */