/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.event;
/*    */ 
/*    */ import java.util.Queue;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.LegacyAbstractLogger;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.SubstituteLogger;
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
/*    */ public class EventRecodingLogger
/*    */   extends LegacyAbstractLogger
/*    */ {
/*    */   private static final long serialVersionUID = -176083308134819629L;
/*    */   String name;
/*    */   SubstituteLogger logger;
/*    */   Queue<SubstituteLoggingEvent> eventQueue;
/*    */   static final boolean RECORD_ALL_EVENTS = true;
/*    */   
/*    */   public EventRecodingLogger(SubstituteLogger paramSubstituteLogger, Queue<SubstituteLoggingEvent> paramQueue) {
/* 31 */     this.logger = paramSubstituteLogger;
/* 32 */     this.name = paramSubstituteLogger.getName();
/* 33 */     this.eventQueue = paramQueue;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 37 */     return this.name;
/*    */   }
/*    */   
/*    */   public boolean isTraceEnabled() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isDebugEnabled() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isInfoEnabled() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isWarnEnabled() {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isErrorEnabled() {
/* 57 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void handleNormalizedLoggingCall(Level paramLevel, Marker paramMarker, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 63 */     SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
/* 64 */     substituteLoggingEvent.setTimeStamp(System.currentTimeMillis());
/* 65 */     substituteLoggingEvent.setLevel(paramLevel);
/* 66 */     substituteLoggingEvent.setLogger(this.logger);
/* 67 */     substituteLoggingEvent.setLoggerName(this.name);
/* 68 */     if (paramMarker != null) {
/* 69 */       substituteLoggingEvent.addMarker(paramMarker);
/*    */     }
/* 71 */     substituteLoggingEvent.setMessage(paramString);
/* 72 */     substituteLoggingEvent.setThreadName(Thread.currentThread().getName());
/*    */     
/* 74 */     substituteLoggingEvent.setArgumentArray(paramArrayOfObject);
/* 75 */     substituteLoggingEvent.setThrowable(paramThrowable);
/*    */     
/* 77 */     this.eventQueue.add(substituteLoggingEvent);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getFullyQualifiedCallerName() {
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/event/EventRecodingLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */