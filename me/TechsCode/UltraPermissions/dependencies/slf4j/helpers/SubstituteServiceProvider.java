/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.ILoggerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.IMarkerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.MDCAdapter;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.SLF4JServiceProvider;
/*    */ 
/*    */ public class SubstituteServiceProvider implements SLF4JServiceProvider {
/*  9 */   private SubstituteLoggerFactory loggerFactory = new SubstituteLoggerFactory();
/* 10 */   private IMarkerFactory markerFactory = new BasicMarkerFactory();
/* 11 */   private MDCAdapter mdcAdapter = new BasicMDCAdapter();
/*    */ 
/*    */   
/*    */   public ILoggerFactory getLoggerFactory() {
/* 15 */     return this.loggerFactory;
/*    */   }
/*    */   
/*    */   public SubstituteLoggerFactory getSubstituteLoggerFactory() {
/* 19 */     return this.loggerFactory;
/*    */   }
/*    */ 
/*    */   
/*    */   public IMarkerFactory getMarkerFactory() {
/* 24 */     return this.markerFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MDCAdapter getMDCAdapter() {
/* 30 */     return this.mdcAdapter;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequesteApiVersion() {
/* 36 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public void initialize() {}
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/SubstituteServiceProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */