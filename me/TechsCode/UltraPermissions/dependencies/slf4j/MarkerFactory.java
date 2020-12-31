/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.BasicMarkerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.Util;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.SLF4JServiceProvider;
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
/*    */ public class MarkerFactory
/*    */ {
/*    */   static IMarkerFactory MARKER_FACTORY;
/*    */   
/*    */   static {
/* 53 */     SLF4JServiceProvider sLF4JServiceProvider = LoggerFactory.getProvider();
/* 54 */     if (sLF4JServiceProvider != null) {
/* 55 */       MARKER_FACTORY = sLF4JServiceProvider.getMarkerFactory();
/*    */     } else {
/* 57 */       Util.report("Failed to find provider");
/* 58 */       Util.report("Defaulting to BasicMarkerFactory.");
/* 59 */       MARKER_FACTORY = (IMarkerFactory)new BasicMarkerFactory();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Marker getMarker(String paramString) {
/* 72 */     return MARKER_FACTORY.getMarker(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Marker getDetachedMarker(String paramString) {
/* 83 */     return MARKER_FACTORY.getDetachedMarker(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static IMarkerFactory getIMarkerFactory() {
/* 95 */     return MARKER_FACTORY;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/MarkerFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */