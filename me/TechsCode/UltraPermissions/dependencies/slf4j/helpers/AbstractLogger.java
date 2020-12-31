/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.LoggerFactory;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.Level;
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
/*     */ 
/*     */ public abstract class AbstractLogger
/*     */   implements Logger, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2529255052481744503L;
/*     */   protected String name;
/*     */   
/*     */   public String getName() {
/*  49 */     return this.name;
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/*  69 */     return LoggerFactory.getLogger(getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(String paramString) {
/*  74 */     if (isTraceEnabled()) {
/*  75 */       handle_0ArgsCall(Level.TRACE, (Marker)null, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(String paramString, Object paramObject) {
/*  81 */     if (isTraceEnabled()) {
/*  82 */       handle_1ArgsCall(Level.TRACE, (Marker)null, paramString, paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(String paramString, Object paramObject1, Object paramObject2) {
/*  88 */     if (isTraceEnabled()) {
/*  89 */       handle2ArgsCall(Level.TRACE, (Marker)null, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(String paramString, Object... paramVarArgs) {
/*  95 */     if (isTraceEnabled()) {
/*  96 */       handleArgArrayCall(Level.TRACE, (Marker)null, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(String paramString, Throwable paramThrowable) {
/* 102 */     if (isTraceEnabled()) {
/* 103 */       handle_0ArgsCall(Level.TRACE, (Marker)null, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString) {
/* 109 */     if (isTraceEnabled(paramMarker)) {
/* 110 */       handle_0ArgsCall(Level.TRACE, paramMarker, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject) {
/* 116 */     if (isTraceEnabled(paramMarker)) {
/* 117 */       handle_1ArgsCall(Level.TRACE, paramMarker, paramString, paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 123 */     if (isTraceEnabled(paramMarker)) {
/* 124 */       handle2ArgsCall(Level.TRACE, paramMarker, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 130 */     if (isTraceEnabled(paramMarker)) {
/* 131 */       handleArgArrayCall(Level.TRACE, paramMarker, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 136 */     if (isTraceEnabled(paramMarker)) {
/* 137 */       handle_0ArgsCall(Level.TRACE, paramMarker, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(String paramString) {
/* 142 */     if (isDebugEnabled()) {
/* 143 */       handle_0ArgsCall(Level.DEBUG, (Marker)null, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject) {
/* 148 */     if (isDebugEnabled()) {
/* 149 */       handle_1ArgsCall(Level.DEBUG, (Marker)null, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject1, Object paramObject2) {
/* 154 */     if (isDebugEnabled()) {
/* 155 */       handle2ArgsCall(Level.DEBUG, (Marker)null, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object... paramVarArgs) {
/* 160 */     if (isDebugEnabled()) {
/* 161 */       handleArgArrayCall(Level.DEBUG, (Marker)null, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Throwable paramThrowable) {
/* 166 */     if (isDebugEnabled()) {
/* 167 */       handle_0ArgsCall(Level.DEBUG, (Marker)null, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString) {
/* 172 */     if (isDebugEnabled(paramMarker)) {
/* 173 */       handle_0ArgsCall(Level.DEBUG, paramMarker, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject) {
/* 178 */     if (isDebugEnabled(paramMarker)) {
/* 179 */       handle_1ArgsCall(Level.DEBUG, paramMarker, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 184 */     if (isDebugEnabled(paramMarker)) {
/* 185 */       handle2ArgsCall(Level.DEBUG, paramMarker, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 190 */     if (isDebugEnabled(paramMarker)) {
/* 191 */       handleArgArrayCall(Level.DEBUG, paramMarker, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 196 */     if (isDebugEnabled(paramMarker)) {
/* 197 */       handle_0ArgsCall(Level.DEBUG, paramMarker, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(String paramString) {
/* 202 */     if (isInfoEnabled()) {
/* 203 */       handle_0ArgsCall(Level.INFO, (Marker)null, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject) {
/* 208 */     if (isInfoEnabled()) {
/* 209 */       handle_1ArgsCall(Level.INFO, (Marker)null, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject1, Object paramObject2) {
/* 214 */     if (isInfoEnabled()) {
/* 215 */       handle2ArgsCall(Level.INFO, (Marker)null, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object... paramVarArgs) {
/* 220 */     if (isInfoEnabled()) {
/* 221 */       handleArgArrayCall(Level.INFO, (Marker)null, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(String paramString, Throwable paramThrowable) {
/* 226 */     if (isInfoEnabled()) {
/* 227 */       handle_0ArgsCall(Level.INFO, (Marker)null, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString) {
/* 232 */     if (isInfoEnabled(paramMarker)) {
/* 233 */       handle_0ArgsCall(Level.INFO, paramMarker, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject) {
/* 238 */     if (isInfoEnabled(paramMarker)) {
/* 239 */       handle_1ArgsCall(Level.INFO, paramMarker, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 244 */     if (isInfoEnabled(paramMarker)) {
/* 245 */       handle2ArgsCall(Level.INFO, paramMarker, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 250 */     if (isInfoEnabled(paramMarker)) {
/* 251 */       handleArgArrayCall(Level.INFO, paramMarker, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 256 */     if (isInfoEnabled(paramMarker)) {
/* 257 */       handle_0ArgsCall(Level.INFO, paramMarker, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(String paramString) {
/* 262 */     if (isWarnEnabled()) {
/* 263 */       handle_0ArgsCall(Level.WARN, (Marker)null, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject) {
/* 268 */     if (isWarnEnabled()) {
/* 269 */       handle_1ArgsCall(Level.WARN, (Marker)null, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject1, Object paramObject2) {
/* 274 */     if (isWarnEnabled()) {
/* 275 */       handle2ArgsCall(Level.WARN, (Marker)null, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object... paramVarArgs) {
/* 280 */     if (isWarnEnabled()) {
/* 281 */       handleArgArrayCall(Level.WARN, (Marker)null, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Throwable paramThrowable) {
/* 286 */     if (isWarnEnabled()) {
/* 287 */       handle_0ArgsCall(Level.WARN, (Marker)null, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString) {
/* 292 */     if (isWarnEnabled(paramMarker)) {
/* 293 */       handle_0ArgsCall(Level.WARN, paramMarker, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject) {
/* 298 */     if (isWarnEnabled(paramMarker)) {
/* 299 */       handle_1ArgsCall(Level.WARN, paramMarker, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 304 */     if (isWarnEnabled(paramMarker)) {
/* 305 */       handle2ArgsCall(Level.WARN, paramMarker, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 310 */     if (isWarnEnabled(paramMarker)) {
/* 311 */       handleArgArrayCall(Level.WARN, paramMarker, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 316 */     if (isWarnEnabled(paramMarker)) {
/* 317 */       handle_0ArgsCall(Level.WARN, paramMarker, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(String paramString) {
/* 322 */     if (isErrorEnabled()) {
/* 323 */       handle_0ArgsCall(Level.ERROR, (Marker)null, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject) {
/* 328 */     if (isErrorEnabled()) {
/* 329 */       handle_1ArgsCall(Level.ERROR, (Marker)null, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject1, Object paramObject2) {
/* 334 */     if (isErrorEnabled()) {
/* 335 */       handle2ArgsCall(Level.ERROR, (Marker)null, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object... paramVarArgs) {
/* 340 */     if (isErrorEnabled()) {
/* 341 */       handleArgArrayCall(Level.ERROR, (Marker)null, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(String paramString, Throwable paramThrowable) {
/* 346 */     if (isErrorEnabled()) {
/* 347 */       handle_0ArgsCall(Level.ERROR, (Marker)null, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString) {
/* 352 */     if (isErrorEnabled(paramMarker)) {
/* 353 */       handle_0ArgsCall(Level.ERROR, paramMarker, paramString, (Throwable)null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject) {
/* 358 */     if (isErrorEnabled(paramMarker)) {
/* 359 */       handle_1ArgsCall(Level.ERROR, paramMarker, paramString, paramObject);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 364 */     if (isErrorEnabled(paramMarker)) {
/* 365 */       handle2ArgsCall(Level.ERROR, paramMarker, paramString, paramObject1, paramObject2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 370 */     if (isErrorEnabled(paramMarker)) {
/* 371 */       handleArgArrayCall(Level.ERROR, paramMarker, paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 376 */     if (isErrorEnabled(paramMarker)) {
/* 377 */       handle_0ArgsCall(Level.ERROR, paramMarker, paramString, paramThrowable);
/*     */     }
/*     */   }
/*     */   
/*     */   private void handle_0ArgsCall(Level paramLevel, Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 382 */     handleNormalizedLoggingCall(paramLevel, paramMarker, paramString, (Object[])null, paramThrowable);
/*     */   }
/*     */   
/*     */   private void handle_1ArgsCall(Level paramLevel, Marker paramMarker, String paramString, Object paramObject) {
/* 386 */     handleNormalizedLoggingCall(paramLevel, paramMarker, paramString, new Object[] { paramObject }, (Throwable)null);
/*     */   }
/*     */   
/*     */   private void handle2ArgsCall(Level paramLevel, Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 390 */     if (paramObject2 instanceof Throwable) {
/* 391 */       handleNormalizedLoggingCall(paramLevel, paramMarker, paramString, new Object[] { paramObject1 }, (Throwable)paramObject2);
/*     */     } else {
/* 393 */       handleNormalizedLoggingCall(paramLevel, paramMarker, paramString, new Object[] { paramObject1, paramObject2 }, (Throwable)null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void handleArgArrayCall(Level paramLevel, Marker paramMarker, String paramString, Object[] paramArrayOfObject) {
/* 398 */     Throwable throwable = MessageFormatter.getThrowableCandidate(paramArrayOfObject);
/* 399 */     if (throwable != null) {
/* 400 */       Object[] arrayOfObject = MessageFormatter.trimmedCopy(paramArrayOfObject);
/* 401 */       handleNormalizedLoggingCall(paramLevel, paramMarker, paramString, arrayOfObject, throwable);
/*     */     } else {
/* 403 */       handleNormalizedLoggingCall(paramLevel, paramMarker, paramString, paramArrayOfObject, (Throwable)null);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract String getFullyQualifiedCallerName();
/*     */   
/*     */   protected abstract void handleNormalizedLoggingCall(Level paramLevel, Marker paramMarker, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable);
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/AbstractLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */