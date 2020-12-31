/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.LoggingEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NormalizedParameters
/*     */ {
/*     */   final String message;
/*     */   final Object[] arguments;
/*     */   final Throwable throwable;
/*     */   
/*     */   public NormalizedParameters(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/*  20 */     this.message = paramString;
/*  21 */     this.arguments = paramArrayOfObject;
/*  22 */     this.throwable = paramThrowable;
/*     */   }
/*     */   
/*     */   public NormalizedParameters(String paramString, Object[] paramArrayOfObject) {
/*  26 */     this(paramString, paramArrayOfObject, null);
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*  30 */     return this.message;
/*     */   }
/*     */   
/*     */   public Object[] getArguments() {
/*  34 */     return this.arguments;
/*     */   }
/*     */   
/*     */   public Throwable getThrowable() {
/*  38 */     return this.throwable;
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
/*     */   public static Throwable getThrowableCandidate(Object[] paramArrayOfObject) {
/*  51 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/*  52 */       return null;
/*     */     }
/*     */     
/*  55 */     Object object = paramArrayOfObject[paramArrayOfObject.length - 1];
/*  56 */     if (object instanceof Throwable) {
/*  57 */       return (Throwable)object;
/*     */     }
/*     */     
/*  60 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object[] trimmedCopy(Object[] paramArrayOfObject) {
/*  71 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/*  72 */       throw new IllegalStateException("non-sensical empty or null argument array");
/*     */     }
/*     */     
/*  75 */     int i = paramArrayOfObject.length - 1;
/*     */     
/*  77 */     Object[] arrayOfObject = new Object[i];
/*     */     
/*  79 */     if (i > 0) {
/*  80 */       System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
/*     */     }
/*     */     
/*  83 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NormalizedParameters normalize(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/*  94 */     if (paramThrowable != null) {
/*  95 */       return new NormalizedParameters(paramString, paramArrayOfObject, paramThrowable);
/*     */     }
/*     */     
/*  98 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/*  99 */       return new NormalizedParameters(paramString, paramArrayOfObject, paramThrowable);
/*     */     }
/*     */     
/* 102 */     Throwable throwable = getThrowableCandidate(paramArrayOfObject);
/* 103 */     if (throwable != null) {
/* 104 */       Object[] arrayOfObject = MessageFormatter.trimmedCopy(paramArrayOfObject);
/* 105 */       return new NormalizedParameters(paramString, arrayOfObject, throwable);
/*     */     } 
/* 107 */     return new NormalizedParameters(paramString, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static NormalizedParameters normalize(LoggingEvent paramLoggingEvent) {
/* 113 */     return normalize(paramLoggingEvent.getMessage(), paramLoggingEvent.getArgumentArray(), paramLoggingEvent.getThrowable());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/NormalizedParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */