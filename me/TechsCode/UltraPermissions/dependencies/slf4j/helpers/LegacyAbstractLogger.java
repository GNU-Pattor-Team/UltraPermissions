/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class LegacyAbstractLogger
/*    */   extends AbstractLogger
/*    */ {
/*    */   private static final long serialVersionUID = -7041884104854048950L;
/*    */   
/*    */   public boolean isTraceEnabled(Marker paramMarker) {
/* 13 */     return isTraceEnabled();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDebugEnabled(Marker paramMarker) {
/* 19 */     return isDebugEnabled();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isInfoEnabled(Marker paramMarker) {
/* 24 */     return isInfoEnabled();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isWarnEnabled(Marker paramMarker) {
/* 29 */     return isWarnEnabled();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isErrorEnabled(Marker paramMarker) {
/* 34 */     return isErrorEnabled();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/LegacyAbstractLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */