/*    */ package me.TechsCode.UltraPermissions.base.source;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.lang.reflect.Method;
/*    */ import java.net.URL;
/*    */ import java.net.URLClassLoader;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ 
/*    */ public class JarClassLoader
/*    */ {
/*    */   private static final Method ADD_URL_METHOD;
/*    */   private final URLClassLoader classLoader;
/*    */   
/*    */   static {
/*    */     try {
/* 18 */       ADD_URL_METHOD = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
/* 19 */       ADD_URL_METHOD.setAccessible(true);
/* 20 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 21 */       throw new ExceptionInInitializerError(noSuchMethodException);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JarClassLoader(SpigotTechPlugin paramSpigotTechPlugin) {
/* 28 */     ClassLoader classLoader = ((JavaPlugin)paramSpigotTechPlugin.getBootstrap()).getClass().getClassLoader();
/* 29 */     this.classLoader = (URLClassLoader)classLoader;
/*    */   }
/*    */   
/*    */   public void load(File paramFile) {
/*    */     try {
/* 34 */       ADD_URL_METHOD.invoke(this.classLoader, new Object[] { paramFile.toPath().toUri().toURL() });
/* 35 */     } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException|java.net.MalformedURLException illegalAccessException) {
/* 36 */       illegalAccessException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/source/JarClassLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */