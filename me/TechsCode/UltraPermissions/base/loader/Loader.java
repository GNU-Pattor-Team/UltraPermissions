/*    */ package me.TechsCode.UltraPermissions.base.loader;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Loader
/*    */ {
/*    */   private TechPlugin<?> techPlugin;
/*    */   
/*    */   public Loader(Object paramObject, Class<? extends TechPlugin<?>> paramClass, ClassLoader paramClassLoader) {
/* 13 */     Optional<Class<?>> optional = LoaderUtil.getMainClass(paramClass, paramClassLoader);
/*    */     
/* 15 */     if (!optional.isPresent()) {
/*    */       return;
/*    */     }
/*    */     
/*    */     try {
/* 20 */       this.techPlugin = (TechPlugin)((Class)optional.get()).getDeclaredConstructors()[0].newInstance(new Object[] { paramObject });
/* 21 */     } catch (InstantiationException|IllegalAccessException|java.lang.reflect.InvocationTargetException instantiationException) {
/* 22 */       instantiationException.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void unload() {
/* 27 */     if (this.techPlugin != null)
/* 28 */       this.techPlugin.disable(); 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/loader/Loader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */