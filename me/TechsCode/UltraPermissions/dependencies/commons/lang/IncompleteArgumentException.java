/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*    */ 
/*    */ import java.util.Arrays;
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
/*    */ public class IncompleteArgumentException
/*    */   extends IllegalArgumentException
/*    */ {
/*    */   private static final long serialVersionUID = 4954193403612068178L;
/*    */   
/*    */   public IncompleteArgumentException(String paramString) {
/* 63 */     super(paramString + " is incomplete.");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IncompleteArgumentException(String paramString, String[] paramArrayOfString) {
/* 73 */     super(paramString + " is missing the following items: " + safeArrayToString((Object[])paramArrayOfString));
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
/*    */   
/*    */   private static final String safeArrayToString(Object[] paramArrayOfObject) {
/* 86 */     return (paramArrayOfObject == null) ? null : Arrays.<Object>asList(paramArrayOfObject).toString();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/IncompleteArgumentException.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */