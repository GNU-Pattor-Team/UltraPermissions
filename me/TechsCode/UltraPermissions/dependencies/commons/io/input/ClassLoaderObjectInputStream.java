/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectStreamClass;
/*    */ import java.lang.reflect.Proxy;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClassLoaderObjectInputStream
/*    */   extends ObjectInputStream
/*    */ {
/*    */   private final ClassLoader classLoader;
/*    */   
/*    */   public ClassLoaderObjectInputStream(ClassLoader paramClassLoader, InputStream paramInputStream) {
/* 50 */     super(paramInputStream);
/* 51 */     this.classLoader = paramClassLoader;
/*    */   }
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
/*    */   protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass) {
/*    */     try {
/* 68 */       return Class.forName(paramObjectStreamClass.getName(), false, this.classLoader);
/* 69 */     } catch (ClassNotFoundException classNotFoundException) {
/*    */       
/* 71 */       return super.resolveClass(paramObjectStreamClass);
/*    */     } 
/*    */   }
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
/*    */   protected Class<?> resolveProxyClass(String[] paramArrayOfString) {
/* 89 */     Class[] arrayOfClass = new Class[paramArrayOfString.length];
/* 90 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 91 */       arrayOfClass[b] = Class.forName(paramArrayOfString[b], false, this.classLoader);
/*    */     }
/*    */     try {
/* 94 */       return Proxy.getProxyClass(this.classLoader, arrayOfClass);
/* 95 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 96 */       return super.resolveProxyClass(paramArrayOfString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/ClassLoaderObjectInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */