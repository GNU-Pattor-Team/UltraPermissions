/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.spi;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.DefaultLoggingEvent;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.KeyValuePair;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.Level;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.LoggingEvent;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.event.LoggingEventAware;
/*     */ 
/*     */ public class DefaultLoggingEventBuilder
/*     */   implements LoggingEventBuilder
/*     */ {
/*     */   DefaultLoggingEvent loggingEvent;
/*     */   Logger logger;
/*     */   
/*     */   public DefaultLoggingEventBuilder(Logger paramLogger, Level paramLevel) {
/*  19 */     this.logger = paramLogger;
/*  20 */     this.loggingEvent = new DefaultLoggingEvent(paramLevel, paramLogger);
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
/*     */   public LoggingEventBuilder addMarker(Marker paramMarker) {
/*  32 */     this.loggingEvent.addMarker(paramMarker);
/*  33 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LoggingEventBuilder setCause(Throwable paramThrowable) {
/*  38 */     this.loggingEvent.setThrowable(paramThrowable);
/*  39 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LoggingEventBuilder addArgument(Object paramObject) {
/*  44 */     this.loggingEvent.addArgument(paramObject);
/*  45 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LoggingEventBuilder addArgument(Supplier<Object> paramSupplier) {
/*  50 */     this.loggingEvent.addArgument(paramSupplier.get());
/*  51 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(String paramString) {
/*  56 */     this.loggingEvent.setMessage(paramString);
/*  57 */     innerLog((LoggingEvent)this.loggingEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void log(String paramString, Object paramObject) {
/*  63 */     this.loggingEvent.setMessage(paramString);
/*  64 */     this.loggingEvent.addArgument(paramObject);
/*  65 */     innerLog((LoggingEvent)this.loggingEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(String paramString, Object paramObject1, Object paramObject2) {
/*  70 */     this.loggingEvent.setMessage(paramString);
/*  71 */     this.loggingEvent.addArgument(paramObject1);
/*  72 */     this.loggingEvent.addArgument(paramObject2);
/*  73 */     innerLog((LoggingEvent)this.loggingEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(String paramString, Object... paramVarArgs) {
/*  78 */     this.loggingEvent.setMessage(paramString);
/*  79 */     this.loggingEvent.addArguments(paramVarArgs);
/*     */     
/*  81 */     innerLog((LoggingEvent)this.loggingEvent);
/*     */   }
/*     */   
/*     */   private void innerLog(LoggingEvent paramLoggingEvent) {
/*  85 */     if (this.logger instanceof LoggingEventAware) {
/*  86 */       ((LoggingEventAware)this.logger).log(paramLoggingEvent);
/*     */     } else {
/*  88 */       logViaPublicLoggerAPI(paramLoggingEvent);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void logViaPublicLoggerAPI(LoggingEvent paramLoggingEvent) {
/*  93 */     Object[] arrayOfObject1 = paramLoggingEvent.getArgumentArray();
/*  94 */     byte b1 = (arrayOfObject1 == null) ? 0 : arrayOfObject1.length;
/*     */     
/*  96 */     Throwable throwable = paramLoggingEvent.getThrowable();
/*  97 */     byte b2 = (throwable == null) ? 0 : 1;
/*     */     
/*  99 */     String str = paramLoggingEvent.getMessage();
/*     */     
/* 101 */     Object[] arrayOfObject2 = new Object[b1 + b2];
/*     */     
/* 103 */     if (arrayOfObject1 != null) {
/* 104 */       System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, b1);
/*     */     }
/* 106 */     if (throwable != null) {
/* 107 */       arrayOfObject2[b1] = throwable;
/*     */     }
/*     */     
/* 110 */     str = mergeMarkersAndKeyValuePairs(paramLoggingEvent, str);
/*     */     
/* 112 */     switch (paramLoggingEvent.getLevel()) {
/*     */       case TRACE:
/* 114 */         this.logger.trace(str, arrayOfObject2);
/*     */         break;
/*     */       case null:
/* 117 */         this.logger.debug(str, arrayOfObject2);
/*     */         break;
/*     */       case INFO:
/* 120 */         this.logger.info(str, arrayOfObject2);
/*     */         break;
/*     */       case WARN:
/* 123 */         this.logger.warn(str, arrayOfObject2);
/*     */         break;
/*     */       case ERROR:
/* 126 */         this.logger.error(str, arrayOfObject2);
/*     */         break;
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
/*     */   private String mergeMarkersAndKeyValuePairs(LoggingEvent paramLoggingEvent, String paramString) {
/* 141 */     StringBuilder stringBuilder = null;
/*     */     
/* 143 */     if (this.loggingEvent.getMarkers() != null) {
/* 144 */       stringBuilder = new StringBuilder();
/* 145 */       for (Marker marker : paramLoggingEvent.getMarkers()) {
/* 146 */         stringBuilder.append(marker);
/* 147 */         stringBuilder.append(' ');
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     if (paramLoggingEvent.getKeyValuePairs() != null) {
/* 152 */       if (stringBuilder == null) {
/* 153 */         stringBuilder = new StringBuilder();
/*     */       }
/* 155 */       for (KeyValuePair keyValuePair : paramLoggingEvent.getKeyValuePairs()) {
/* 156 */         stringBuilder.append(keyValuePair.key);
/* 157 */         stringBuilder.append('=');
/* 158 */         stringBuilder.append(keyValuePair.value);
/* 159 */         stringBuilder.append(' ');
/*     */       } 
/*     */     } 
/*     */     
/* 163 */     if (stringBuilder != null) {
/* 164 */       stringBuilder.append(paramString);
/* 165 */       return stringBuilder.toString();
/*     */     } 
/* 167 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void log(Supplier<String> paramSupplier) {
/* 174 */     if (paramSupplier == null) {
/* 175 */       log((String)null);
/*     */     } else {
/* 177 */       log(paramSupplier.get());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LoggingEventBuilder addKeyValue(String paramString, Object paramObject) {
/* 183 */     this.loggingEvent.addKeyValue(paramString, paramObject);
/* 184 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LoggingEventBuilder addKeyValue(String paramString, Supplier<Object> paramSupplier) {
/* 189 */     this.loggingEvent.addKeyValue(paramString, paramSupplier.get());
/* 190 */     return this;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/spi/DefaultLoggingEventBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */