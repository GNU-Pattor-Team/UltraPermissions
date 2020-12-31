/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javassist.ClassPath;
/*     */ import javassist.ClassPool;
/*     */ import javassist.CtClass;
/*     */ import javassist.CtMethod;
/*     */ import javassist.CtNewMethod;
/*     */ import javassist.LoaderClassPath;
/*     */ import javassist.NotFoundException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.pool.ProxyCallableStatement;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.pool.ProxyConnection;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.pool.ProxyPreparedStatement;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.pool.ProxyResultSet;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.pool.ProxyStatement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JavassistProxyFactory
/*     */ {
/*     */   private static ClassPool classPool;
/*     */   
/*     */   public static void main(String... paramVarArgs) {
/*  61 */     classPool = new ClassPool();
/*  62 */     classPool.importPackage("java.sql");
/*  63 */     classPool.appendClassPath((ClassPath)new LoaderClassPath(JavassistProxyFactory.class.getClassLoader()));
/*     */ 
/*     */     
/*     */     try {
/*  67 */       String str = "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }";
/*  68 */       generateProxyClass(Connection.class, ProxyConnection.class.getName(), str);
/*  69 */       generateProxyClass(Statement.class, ProxyStatement.class.getName(), str);
/*  70 */       generateProxyClass(ResultSet.class, ProxyResultSet.class.getName(), str);
/*     */ 
/*     */       
/*  73 */       str = "{ try { return ((cast) delegate).method($$); } catch (SQLException e) { throw checkException(e); } }";
/*  74 */       generateProxyClass(PreparedStatement.class, ProxyPreparedStatement.class.getName(), str);
/*  75 */       generateProxyClass(CallableStatement.class, ProxyCallableStatement.class.getName(), str);
/*     */       
/*  77 */       modifyProxyFactory();
/*     */     }
/*  79 */     catch (Exception exception) {
/*  80 */       throw new RuntimeException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void modifyProxyFactory() {
/*  86 */     System.out.println("Generating method bodies for com.zaxxer.hikari.proxy.ProxyFactory");
/*     */     
/*  88 */     String str = ProxyConnection.class.getPackage().getName();
/*  89 */     CtClass ctClass = classPool.getCtClass("me.TechsCode.UltraPermissions.dependencies.hikari.pool.ProxyFactory");
/*  90 */     for (CtMethod ctMethod : ctClass.getMethods()) {
/*  91 */       switch (ctMethod.getName()) {
/*     */         case "getProxyConnection":
/*  93 */           ctMethod.setBody("{return new " + str + ".HikariProxyConnection($$);}");
/*     */           break;
/*     */         case "getProxyStatement":
/*  96 */           ctMethod.setBody("{return new " + str + ".HikariProxyStatement($$);}");
/*     */           break;
/*     */         case "getProxyPreparedStatement":
/*  99 */           ctMethod.setBody("{return new " + str + ".HikariProxyPreparedStatement($$);}");
/*     */           break;
/*     */         case "getProxyCallableStatement":
/* 102 */           ctMethod.setBody("{return new " + str + ".HikariProxyCallableStatement($$);}");
/*     */           break;
/*     */         case "getProxyResultSet":
/* 105 */           ctMethod.setBody("{return new " + str + ".HikariProxyResultSet($$);}");
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 110 */     ctClass.writeFile("target/classes");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> void generateProxyClass(Class<T> paramClass, String paramString1, String paramString2) {
/* 118 */     String str = paramString1.replaceAll("(.+)\\.(\\w+)", "$1.Hikari$2");
/*     */     
/* 120 */     CtClass ctClass1 = classPool.getCtClass(paramString1);
/* 121 */     CtClass ctClass2 = classPool.makeClass(str, ctClass1);
/* 122 */     ctClass2.setModifiers(16);
/*     */     
/* 124 */     System.out.println("Generating " + str);
/*     */     
/* 126 */     ctClass2.setModifiers(1);
/*     */ 
/*     */     
/* 129 */     HashSet<String> hashSet1 = new HashSet();
/* 130 */     for (CtMethod ctMethod : ctClass1.getMethods()) {
/* 131 */       if ((ctMethod.getModifiers() & 0x10) == 16) {
/* 132 */         hashSet1.add(ctMethod.getName() + ctMethod.getSignature());
/*     */       }
/*     */     } 
/*     */     
/* 136 */     HashSet<String> hashSet2 = new HashSet();
/* 137 */     Set<Class<?>> set = getAllInterfaces(paramClass);
/* 138 */     for (Class<?> clazz : set) {
/* 139 */       CtClass ctClass = classPool.getCtClass(clazz.getName());
/* 140 */       ctClass2.addInterface(ctClass);
/* 141 */       for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
/* 142 */         String str1 = ctMethod.getName() + ctMethod.getSignature();
/*     */ 
/*     */         
/* 145 */         if (!hashSet1.contains(str1))
/*     */         {
/*     */ 
/*     */ 
/*     */           
/* 150 */           if (!hashSet2.contains(str1))
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 155 */             if (!isDefaultMethod(clazz, ctClass, ctMethod)) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 160 */               hashSet2.add(str1);
/*     */ 
/*     */               
/* 163 */               CtMethod ctMethod1 = CtNewMethod.copy(ctMethod, ctClass2, null);
/*     */               
/* 165 */               String str2 = paramString2;
/*     */ 
/*     */               
/* 168 */               CtMethod ctMethod2 = ctClass1.getMethod(ctMethod.getName(), ctMethod.getSignature());
/* 169 */               if ((ctMethod2.getModifiers() & 0x400) != 1024) {
/* 170 */                 str2 = str2.replace("((cast) ", "");
/* 171 */                 str2 = str2.replace("delegate", "super");
/* 172 */                 str2 = str2.replace("super)", "super");
/*     */               } 
/*     */               
/* 175 */               str2 = str2.replace("cast", paramClass.getName());
/*     */ 
/*     */               
/* 178 */               if (isThrowsSqlException(ctMethod)) {
/* 179 */                 str2 = str2.replace("method", ctMethod1.getName());
/*     */               } else {
/*     */                 
/* 182 */                 str2 = "{ return ((cast) delegate).method($$); }".replace("method", ctMethod1.getName()).replace("cast", paramClass.getName());
/*     */               } 
/*     */               
/* 185 */               if (ctMethod1.getReturnType() == CtClass.voidType) {
/* 186 */                 str2 = str2.replace("return", "");
/*     */               }
/*     */               
/* 189 */               ctMethod1.setBody(str2);
/* 190 */               ctClass2.addMethod(ctMethod1);
/*     */             }  }  } 
/*     */       } 
/*     */     } 
/* 194 */     ctClass2.getClassFile().setMajorVersion(51);
/* 195 */     ctClass2.writeFile("target/classes");
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isThrowsSqlException(CtMethod paramCtMethod) {
/*     */     try {
/* 201 */       for (CtClass ctClass : paramCtMethod.getExceptionTypes()) {
/* 202 */         if (ctClass.getSimpleName().equals("SQLException")) {
/* 203 */           return true;
/*     */         }
/*     */       }
/*     */     
/* 207 */     } catch (NotFoundException notFoundException) {}
/*     */ 
/*     */ 
/*     */     
/* 211 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isDefaultMethod(Class<?> paramClass, CtClass paramCtClass, CtMethod paramCtMethod) {
/* 216 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*     */     
/* 218 */     for (CtClass ctClass : paramCtMethod.getParameterTypes()) {
/* 219 */       arrayList.add(toJavaClass(ctClass));
/*     */     }
/*     */     
/* 222 */     return paramClass.getDeclaredMethod(paramCtMethod.getName(), (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])new Class[arrayList.size()])).toString().contains("default ");
/*     */   }
/*     */ 
/*     */   
/*     */   private static Set<Class<?>> getAllInterfaces(Class<?> paramClass) {
/* 227 */     HashSet<Class<?>> hashSet = new HashSet();
/* 228 */     for (Class<?> clazz : Arrays.<Class<?>>asList(paramClass.getInterfaces())) {
/* 229 */       if ((clazz.getInterfaces()).length > 0) {
/* 230 */         hashSet.addAll(getAllInterfaces(clazz));
/*     */       }
/* 232 */       hashSet.add(clazz);
/*     */     } 
/* 234 */     if (paramClass.getSuperclass() != null) {
/* 235 */       hashSet.addAll(getAllInterfaces(paramClass.getSuperclass()));
/*     */     }
/*     */     
/* 238 */     if (paramClass.isInterface()) {
/* 239 */       hashSet.add(paramClass);
/*     */     }
/*     */     
/* 242 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Class<?> toJavaClass(CtClass paramCtClass) {
/* 247 */     if (paramCtClass.getName().endsWith("[]")) {
/* 248 */       return Array.newInstance(toJavaClass(paramCtClass.getName().replace("[]", "")), 0).getClass();
/*     */     }
/*     */     
/* 251 */     return toJavaClass(paramCtClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?> toJavaClass(String paramString) {
/* 257 */     switch (paramString) {
/*     */       case "int":
/* 259 */         return int.class;
/*     */       case "long":
/* 261 */         return long.class;
/*     */       case "short":
/* 263 */         return short.class;
/*     */       case "byte":
/* 265 */         return byte.class;
/*     */       case "float":
/* 267 */         return float.class;
/*     */       case "double":
/* 269 */         return double.class;
/*     */       case "boolean":
/* 271 */         return boolean.class;
/*     */       case "char":
/* 273 */         return char.class;
/*     */       case "void":
/* 275 */         return void.class;
/*     */     } 
/* 277 */     return Class.forName(paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/JavassistProxyFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */