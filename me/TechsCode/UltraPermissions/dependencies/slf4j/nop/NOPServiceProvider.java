/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.nop;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.ILoggerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.IMarkerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.BasicMarkerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.NOPLoggerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.NOPMDCAdapter;
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
/* 18 */   public static String REQUESTED_API_VERSION = "1.8.99";
/*    */   
/* 20 */   private ILoggerFactory loggerFactory = (ILoggerFactory)new NOPLoggerFactory();
/* 21 */   private IMarkerFactory markerFactory = (IMarkerFactory)new BasicMarkerFactory();
/* 22 */   private MDCAdapter mdcAdapter = (MDCAdapter)new NOPMDCAdapter();
/*    */   
/*    */   public ILoggerFactory getLoggerFactory() {
/* 25 */     return this.loggerFactory;
/*    */   }
/*    */   
/*    */   public IMarkerFactory getMarkerFactory() {
/* 29 */     return this.markerFactory;
/*    */   }
/*    */   
/*    */   public MDCAdapter getMDCAdapter() {
/* 33 */     return this.mdcAdapter;
/*    */   }
/*    */   
/*    */   public String getRequesteApiVersion() {
/* 37 */     return REQUESTED_API_VERSION;
/*    */   }
/*    */   
/*    */   public void initialize() {}
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/nop/NOPServiceProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */