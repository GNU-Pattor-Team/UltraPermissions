/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
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
/*    */ public class FormattingTuple
/*    */ {
/* 34 */   public static FormattingTuple NULL = new FormattingTuple(null);
/*    */   
/*    */   private String message;
/*    */   private Throwable throwable;
/*    */   private Object[] argArray;
/*    */   
/*    */   public FormattingTuple(String paramString) {
/* 41 */     this(paramString, null, null);
/*    */   }
/*    */   
/*    */   public FormattingTuple(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 45 */     this.message = paramString;
/* 46 */     this.throwable = paramThrowable;
/* 47 */     this.argArray = paramArrayOfObject;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 51 */     return this.message;
/*    */   }
/*    */   
/*    */   public Object[] getArgArray() {
/* 55 */     return this.argArray;
/*    */   }
/*    */   
/*    */   public Throwable getThrowable() {
/* 59 */     return this.throwable;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/FormattingTuple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */