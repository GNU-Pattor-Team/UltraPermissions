/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariConfig;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.LoggerFactory;
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
/*     */ public final class PropertyElf
/*     */ {
/*  40 */   private static final Logger LOGGER = LoggerFactory.getLogger(PropertyElf.class);
/*     */ 
/*     */   
/*     */   public static void setTargetFromProperties(Object paramObject, Properties paramProperties) {
/*  44 */     if (paramObject == null || paramProperties == null) {
/*     */       return;
/*     */     }
/*     */     
/*  48 */     Enumeration<?> enumeration = paramProperties.propertyNames();
/*  49 */     while (enumeration.hasMoreElements()) {
/*  50 */       Object object1 = enumeration.nextElement();
/*  51 */       String str = object1.toString();
/*  52 */       Object object2 = paramProperties.getProperty(str);
/*  53 */       if (object2 == null) {
/*  54 */         object2 = paramProperties.get(object1);
/*     */       }
/*     */       
/*  57 */       if (paramObject instanceof HikariConfig && str.startsWith("dataSource.")) {
/*  58 */         HikariConfig hikariConfig = (HikariConfig)paramObject;
/*  59 */         hikariConfig.addDataSourceProperty(str.substring("dataSource.".length()), object2);
/*     */         continue;
/*     */       } 
/*  62 */       setProperty(paramObject, str, object2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<String> getPropertyNames(Class<?> paramClass) {
/*  75 */     HashSet<String> hashSet = new HashSet();
/*  76 */     for (Method method : paramClass.getMethods()) {
/*  77 */       String str = method.getName();
/*  78 */       if (str.matches("(get|is)[A-Z].+") && (method.getParameterTypes()).length == 0) {
/*  79 */         str = str.replaceFirst("(get|is)", "");
/*     */         try {
/*  81 */           if (paramClass.getMethod("set" + str, new Class[] { method.getReturnType() }) != null) {
/*  82 */             str = Character.toLowerCase(str.charAt(0)) + str.substring(1);
/*  83 */             hashSet.add(str);
/*     */           }
/*     */         
/*  86 */         } catch (Exception exception) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  92 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Object getProperty(String paramString, Object paramObject) {
/*     */     try {
/*  98 */       String str = "get" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
/*  99 */       Method method = paramObject.getClass().getMethod(str, new Class[0]);
/* 100 */       return method.invoke(paramObject, new Object[0]);
/*     */     }
/* 102 */     catch (Exception exception) {
/*     */       try {
/* 104 */         String str = "is" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
/* 105 */         Method method = paramObject.getClass().getMethod(str, new Class[0]);
/* 106 */         return method.invoke(paramObject, new Object[0]);
/*     */       }
/* 108 */       catch (Exception exception1) {
/* 109 */         return null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Properties copyProperties(Properties paramProperties) {
/* 116 */     Properties properties = new Properties();
/* 117 */     for (Map.Entry<Object, Object> entry : paramProperties.entrySet()) {
/* 118 */       properties.setProperty(entry.getKey().toString(), entry.getValue().toString());
/*     */     }
/* 120 */     return properties;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setProperty(Object paramObject1, String paramString, Object paramObject2) {
/* 125 */     Method method = null;
/* 126 */     String str = "set" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
/*     */     
/* 128 */     List<Method> list = Arrays.asList(paramObject1.getClass().getMethods());
/* 129 */     for (Method method1 : list) {
/* 130 */       if (method1.getName().equals(str) && (method1.getParameterTypes()).length == 1) {
/* 131 */         method = method1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 136 */     if (method == null) {
/* 137 */       str = "set" + paramString.toUpperCase();
/* 138 */       for (Method method1 : list) {
/* 139 */         if (method1.getName().equals(str) && (method1.getParameterTypes()).length == 1) {
/* 140 */           method = method1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 146 */     if (method == null) {
/* 147 */       LOGGER.error("Property {} does not exist on target {}", paramString, paramObject1.getClass());
/* 148 */       throw new RuntimeException(String.format("Property %s does not exist on target %s", new Object[] { paramString, paramObject1.getClass() }));
/*     */     } 
/*     */     
/*     */     try {
/* 152 */       Class<?> clazz = method.getParameterTypes()[0];
/* 153 */       if (clazz == int.class) {
/* 154 */         method.invoke(paramObject1, new Object[] { Integer.valueOf(Integer.parseInt(paramObject2.toString())) });
/*     */       }
/* 156 */       else if (clazz == long.class) {
/* 157 */         method.invoke(paramObject1, new Object[] { Long.valueOf(Long.parseLong(paramObject2.toString())) });
/*     */       }
/* 159 */       else if (clazz == boolean.class || clazz == Boolean.class) {
/* 160 */         method.invoke(paramObject1, new Object[] { Boolean.valueOf(Boolean.parseBoolean(paramObject2.toString())) });
/*     */       }
/* 162 */       else if (clazz == String.class) {
/* 163 */         method.invoke(paramObject1, new Object[] { paramObject2.toString() });
/*     */       } else {
/*     */         
/* 166 */         method.invoke(paramObject1, new Object[] { paramObject2 });
/*     */       }
/*     */     
/* 169 */     } catch (Exception exception) {
/* 170 */       LOGGER.error("Exception setting property {} on target {}", new Object[] { paramString, paramObject1.getClass(), exception });
/* 171 */       throw new RuntimeException(exception);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/PropertyElf.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */