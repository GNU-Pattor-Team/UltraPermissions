/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.ILoggerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.IMarkerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.MDCAdapter;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.SLF4JServiceProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NOPServiceProvider
/*    */   implements SLF4JServiceProvider
/*    */ {
/* 15 */   public static String REQUESTED_API_VERSION = "1.8.99";
/*    */   
/* 17 */   private ILoggerFactory loggerFactory = new NOPLoggerFactory();
/* 18 */   private IMarkerFactory markerFactory = new BasicMarkerFactory();
/* 19 */   private MDCAdapter mdcAdapter = new NOPMDCAdapter();
/*    */   
/*    */   public ILoggerFactory getLoggerFactory() {
/* 22 */     return this.loggerFactory;
/*    */   }
/*    */   
/*    */   public IMarkerFactory getMarkerFactory() {
/* 26 */     return this.markerFactory;
/*    */   }
/*    */   
/*    */   public MDCAdapter getMDCAdapter() {
/* 30 */     return this.mdcAdapter;
/*    */   }
/*    */   
/*    */   public String getRequesteApiVersion() {
/* 34 */     return REQUESTED_API_VERSION;
/*    */   }
/*    */   
/*    */   public void initialize() {}
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/NOPServiceProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */