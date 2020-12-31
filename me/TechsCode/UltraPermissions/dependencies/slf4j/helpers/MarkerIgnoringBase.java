/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
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
/*     */ public abstract class MarkerIgnoringBase
/*     */   extends NamedLoggerBase
/*     */   implements Logger
/*     */ {
/*     */   private static final long serialVersionUID = 9044267456635152283L;
/*     */   
/*     */   public boolean isTraceEnabled(Marker paramMarker) {
/*  44 */     return isTraceEnabled();
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString) {
/*  48 */     trace(paramString);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject) {
/*  52 */     trace(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/*  56 */     trace(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object... paramVarArgs) {
/*  60 */     trace(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Throwable paramThrowable) {
/*  64 */     trace(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled(Marker paramMarker) {
/*  68 */     return isDebugEnabled();
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString) {
/*  72 */     debug(paramString);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject) {
/*  76 */     debug(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/*  80 */     debug(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object... paramVarArgs) {
/*  84 */     debug(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Throwable paramThrowable) {
/*  88 */     debug(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled(Marker paramMarker) {
/*  92 */     return isInfoEnabled();
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString) {
/*  96 */     info(paramString);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject) {
/* 100 */     info(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 104 */     info(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 108 */     info(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 112 */     info(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isWarnEnabled(Marker paramMarker) {
/* 116 */     return isWarnEnabled();
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString) {
/* 120 */     warn(paramString);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject) {
/* 124 */     warn(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 128 */     warn(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 132 */     warn(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 136 */     warn(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isErrorEnabled(Marker paramMarker) {
/* 140 */     return isErrorEnabled();
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString) {
/* 144 */     error(paramString);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject) {
/* 148 */     error(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 152 */     error(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 156 */     error(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 160 */     error(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 164 */     return getClass().getName() + "(" + getName() + ")";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/MarkerIgnoringBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */