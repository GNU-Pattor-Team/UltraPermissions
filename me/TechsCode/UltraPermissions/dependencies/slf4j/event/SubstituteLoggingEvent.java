/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.event;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.SubstituteLogger;
/*     */ 
/*     */ 
/*     */ public class SubstituteLoggingEvent
/*     */   implements LoggingEvent
/*     */ {
/*     */   Level level;
/*     */   List<Marker> markers;
/*     */   String loggerName;
/*     */   SubstituteLogger logger;
/*     */   String threadName;
/*     */   String message;
/*     */   Object[] argArray;
/*     */   List<KeyValuePair> keyValuePairList;
/*     */   long timeStamp;
/*     */   Throwable throwable;
/*     */   
/*     */   public Level getLevel() {
/*  25 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(Level paramLevel) {
/*  29 */     this.level = paramLevel;
/*     */   }
/*     */   
/*     */   public List<Marker> getMarkers() {
/*  33 */     return this.markers;
/*     */   }
/*     */   
/*     */   public void addMarker(Marker paramMarker) {
/*  37 */     if (paramMarker == null) {
/*     */       return;
/*     */     }
/*  40 */     if (this.markers == null) {
/*  41 */       this.markers = new ArrayList<>(2);
/*     */     }
/*     */     
/*  44 */     this.markers.add(paramMarker);
/*     */   }
/*     */   
/*     */   public String getLoggerName() {
/*  48 */     return this.loggerName;
/*     */   }
/*     */   
/*     */   public void setLoggerName(String paramString) {
/*  52 */     this.loggerName = paramString;
/*     */   }
/*     */   
/*     */   public SubstituteLogger getLogger() {
/*  56 */     return this.logger;
/*     */   }
/*     */   
/*     */   public void setLogger(SubstituteLogger paramSubstituteLogger) {
/*  60 */     this.logger = paramSubstituteLogger;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*  64 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String paramString) {
/*  68 */     this.message = paramString;
/*     */   }
/*     */   
/*     */   public Object[] getArgumentArray() {
/*  72 */     return this.argArray;
/*     */   }
/*     */   
/*     */   public void setArgumentArray(Object[] paramArrayOfObject) {
/*  76 */     this.argArray = paramArrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Object> getArguments() {
/*  81 */     if (this.argArray == null) {
/*  82 */       return null;
/*     */     }
/*  84 */     return Arrays.asList(this.argArray);
/*     */   }
/*     */   
/*     */   public long getTimeStamp() {
/*  88 */     return this.timeStamp;
/*     */   }
/*     */   
/*     */   public void setTimeStamp(long paramLong) {
/*  92 */     this.timeStamp = paramLong;
/*     */   }
/*     */   
/*     */   public String getThreadName() {
/*  96 */     return this.threadName;
/*     */   }
/*     */   
/*     */   public void setThreadName(String paramString) {
/* 100 */     this.threadName = paramString;
/*     */   }
/*     */   
/*     */   public Throwable getThrowable() {
/* 104 */     return this.throwable;
/*     */   }
/*     */   
/*     */   public void setThrowable(Throwable paramThrowable) {
/* 108 */     this.throwable = paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<KeyValuePair> getKeyValuePairs() {
/* 114 */     return this.keyValuePairList;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/event/SubstituteLoggingEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */