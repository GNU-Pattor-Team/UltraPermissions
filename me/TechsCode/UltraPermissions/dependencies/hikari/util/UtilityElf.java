/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.sql.Connection;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.RejectedExecutionHandler;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public final class UtilityElf
/*     */ {
/*     */   public static String getNullIfEmpty(String paramString) {
/*  40 */     return (paramString == null) ? null : (paramString.trim().isEmpty() ? null : paramString.trim());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void quietlySleep(long paramLong) {
/*     */     try {
/*  51 */       Thread.sleep(paramLong);
/*     */     }
/*  53 */     catch (InterruptedException interruptedException) {}
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T createInstance(String paramString, Class<T> paramClass, Object... paramVarArgs) {
/*  70 */     if (paramString == null) {
/*  71 */       return null;
/*     */     }
/*     */     
/*     */     try {
/*  75 */       Class<?> clazz = UtilityElf.class.getClassLoader().loadClass(paramString);
/*     */       
/*  77 */       Class[] arrayOfClass = new Class[paramVarArgs.length];
/*  78 */       for (byte b = 0; b < paramVarArgs.length; b++) {
/*  79 */         arrayOfClass[b] = paramVarArgs[b].getClass();
/*     */       }
/*     */       
/*  82 */       if (paramVarArgs.length > 0) {
/*  83 */         Constructor<?> constructor = clazz.getConstructor(arrayOfClass);
/*  84 */         return paramClass.cast(constructor.newInstance(paramVarArgs));
/*     */       } 
/*     */       
/*  87 */       return paramClass.cast(clazz.newInstance());
/*     */     }
/*  89 */     catch (Exception exception) {
/*  90 */       throw new RuntimeException(exception);
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
/*     */ 
/*     */   
/*     */   public static ThreadPoolExecutor createThreadPoolExecutor(int paramInt, String paramString, ThreadFactory paramThreadFactory, RejectedExecutionHandler paramRejectedExecutionHandler) {
/* 105 */     if (paramThreadFactory == null) {
/* 106 */       paramThreadFactory = new DefaultThreadFactory(paramString, true);
/*     */     }
/*     */     
/* 109 */     LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue(paramInt);
/* 110 */     ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.SECONDS, linkedBlockingQueue, paramThreadFactory, paramRejectedExecutionHandler);
/* 111 */     threadPoolExecutor.allowCoreThreadTimeOut(true);
/* 112 */     return threadPoolExecutor;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getTransactionIsolation(String paramString) {
/* 127 */     if (paramString != null) {
/*     */       try {
/* 129 */         String str = paramString.toUpperCase();
/* 130 */         if (str.startsWith("TRANSACTION_")) {
/* 131 */           Field field = Connection.class.getField(str);
/* 132 */           return field.getInt(null);
/*     */         } 
/* 134 */         int i = Integer.parseInt(paramString);
/* 135 */         switch (i) {
/*     */           case 0:
/*     */           case 1:
/*     */           case 2:
/*     */           case 4:
/*     */           case 8:
/* 141 */             return i;
/*     */         } 
/* 143 */         throw new IllegalArgumentException();
/*     */       
/*     */       }
/* 146 */       catch (Exception exception) {
/* 147 */         throw new IllegalArgumentException("Invalid transaction isolation value: " + paramString);
/*     */       } 
/*     */     }
/*     */     
/* 151 */     return -1;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/UtilityElf.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */