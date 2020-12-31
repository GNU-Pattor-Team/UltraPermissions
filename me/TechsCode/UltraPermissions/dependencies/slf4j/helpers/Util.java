/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
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
/*     */ 
/*     */ 
/*     */ public final class Util
/*     */ {
/*     */   private static ClassContextSecurityManager SECURITY_MANAGER;
/*     */   
/*     */   public static String safeGetSystemProperty(String paramString) {
/*  40 */     if (paramString == null) {
/*  41 */       throw new IllegalArgumentException("null input");
/*     */     }
/*  43 */     String str = null;
/*     */     try {
/*  45 */       str = System.getProperty(paramString);
/*  46 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/*  49 */     return str;
/*     */   }
/*     */   
/*     */   public static boolean safeGetBooleanSystemProperty(String paramString) {
/*  53 */     String str = safeGetSystemProperty(paramString);
/*  54 */     if (str == null) {
/*  55 */       return false;
/*     */     }
/*  57 */     return str.equalsIgnoreCase("true");
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class ClassContextSecurityManager
/*     */     extends SecurityManager
/*     */   {
/*     */     private ClassContextSecurityManager() {}
/*     */     
/*     */     protected Class<?>[] getClassContext() {
/*  67 */       return super.getClassContext();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;
/*     */   
/*     */   private static ClassContextSecurityManager getSecurityManager() {
/*  75 */     if (SECURITY_MANAGER != null)
/*  76 */       return SECURITY_MANAGER; 
/*  77 */     if (SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
/*  78 */       return null;
/*     */     }
/*  80 */     SECURITY_MANAGER = safeCreateSecurityManager();
/*  81 */     SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
/*  82 */     return SECURITY_MANAGER;
/*     */   }
/*     */ 
/*     */   
/*     */   private static ClassContextSecurityManager safeCreateSecurityManager() {
/*     */     try {
/*  88 */       return new ClassContextSecurityManager();
/*  89 */     } catch (SecurityException securityException) {
/*  90 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getCallingClass() {
/* 100 */     ClassContextSecurityManager classContextSecurityManager = getSecurityManager();
/* 101 */     if (classContextSecurityManager == null)
/* 102 */       return null; 
/* 103 */     Class[] arrayOfClass = classContextSecurityManager.getClassContext();
/* 104 */     String str = Util.class.getName();
/*     */     
/*     */     byte b;
/*     */     
/* 108 */     for (b = 0; b < arrayOfClass.length && 
/* 109 */       !str.equals(arrayOfClass[b].getName()); b++);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     if (b >= arrayOfClass.length || b + 2 >= arrayOfClass.length) {
/* 115 */       throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
/*     */     }
/*     */     
/* 118 */     return arrayOfClass[b + 2];
/*     */   }
/*     */   
/*     */   public static final void report(String paramString, Throwable paramThrowable) {
/* 122 */     System.err.println(paramString);
/* 123 */     System.err.println("Reported exception:");
/* 124 */     paramThrowable.printStackTrace();
/*     */   }
/*     */   
/*     */   public static final void report(String paramString) {
/* 128 */     System.err.println("SLF4J: " + paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/Util.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */