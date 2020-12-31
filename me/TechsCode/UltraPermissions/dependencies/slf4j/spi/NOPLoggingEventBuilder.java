/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.spi;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NOPLoggingEventBuilder
/*    */   implements LoggingEventBuilder
/*    */ {
/* 17 */   static final NOPLoggingEventBuilder SINGLETON = new NOPLoggingEventBuilder();
/*    */   
/*    */   public static LoggingEventBuilder singleton() {
/* 20 */     return SINGLETON;
/*    */   }
/*    */ 
/*    */   
/*    */   public LoggingEventBuilder addMarker(Marker paramMarker) {
/* 25 */     return singleton();
/*    */   }
/*    */ 
/*    */   
/*    */   public LoggingEventBuilder addArgument(Object paramObject) {
/* 30 */     return singleton();
/*    */   }
/*    */ 
/*    */   
/*    */   public LoggingEventBuilder addArgument(Supplier<Object> paramSupplier) {
/* 35 */     return singleton();
/*    */   }
/*    */ 
/*    */   
/*    */   public LoggingEventBuilder addKeyValue(String paramString, Object paramObject) {
/* 40 */     return singleton();
/*    */   }
/*    */ 
/*    */   
/*    */   public LoggingEventBuilder addKeyValue(String paramString, Supplier<Object> paramSupplier) {
/* 45 */     return singleton();
/*    */   }
/*    */ 
/*    */   
/*    */   public LoggingEventBuilder setCause(Throwable paramThrowable) {
/* 50 */     return singleton();
/*    */   }
/*    */   
/*    */   public void log(String paramString) {}
/*    */   
/*    */   public void log(Supplier<String> paramSupplier) {}
/*    */   
/*    */   public void log(String paramString, Object paramObject) {}
/*    */   
/*    */   public void log(String paramString, Object paramObject1, Object paramObject2) {}
/*    */   
/*    */   public void log(String paramString, Object... paramVarArgs) {}
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/spi/NOPLoggingEventBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */