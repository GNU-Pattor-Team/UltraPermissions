/*    */ package me.TechsCode.UltraPermissions.base.loader;
/*    */ 
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.reflection.indexer.ClasspathIndexer;
/*    */ import me.TechsCode.UltraPermissions.base.reflection.indexer.Node;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoaderUtil
/*    */ {
/*    */   public static Optional<Class<?>> getMainClass(Class<? extends TechPlugin<?>> paramClass, ClassLoader paramClassLoader) {
/* 26 */     Optional<Node> optional = ClasspathIndexer.index().classes().stream().filter(paramNode -> { if (!paramNode.getClassName().startsWith("me.TechsCode")) return false;  try { Class<?> clazz = paramClassLoader.loadClass(paramNode.getClassName()); return (paramClass.isAssignableFrom(clazz) && !Modifier.isAbstract(clazz.getModifiers())); } catch (NoClassDefFoundError|ClassNotFoundException noClassDefFoundError) { return false; }  }).findFirst();
/*    */     
/* 28 */     return optional.isPresent() ? ((Node)optional.get()).getAsClass() : Optional.<Class<?>>empty();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/loader/LoaderUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */