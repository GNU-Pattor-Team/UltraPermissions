/*    */ package me.TechsCode.UltraPermissions.internal.lookup;
/*    */ 
/*    */ public class LookupOutcome
/*    */ {
/*    */   private boolean result;
/*    */   private String source;
/*    */   
/*    */   public LookupOutcome(boolean paramBoolean, String paramString) {
/*  9 */     this.result = paramBoolean;
/* 10 */     this.source = paramString;
/*    */   }
/*    */   
/*    */   public boolean getResult() {
/* 14 */     return this.result;
/*    */   }
/*    */   
/*    */   public boolean hasSource() {
/* 18 */     return (this.source != null);
/*    */   }
/*    */   
/*    */   public String getSource() {
/* 22 */     return this.source;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/lookup/LookupOutcome.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */