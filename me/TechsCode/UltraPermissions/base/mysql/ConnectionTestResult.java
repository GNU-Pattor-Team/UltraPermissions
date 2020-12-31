/*    */ package me.TechsCode.UltraPermissions.base.mysql;
/*    */ 
/*    */ public class ConnectionTestResult
/*    */ {
/*    */   private boolean valid;
/*    */   private String error;
/*    */   
/*    */   public ConnectionTestResult(boolean paramBoolean, String paramString) {
/*  9 */     this.valid = paramBoolean;
/* 10 */     this.error = paramString;
/*    */   }
/*    */   
/*    */   public boolean isValid() {
/* 14 */     return this.valid;
/*    */   }
/*    */   
/*    */   public String getError() {
/* 18 */     return this.error;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/mysql/ConnectionTestResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */