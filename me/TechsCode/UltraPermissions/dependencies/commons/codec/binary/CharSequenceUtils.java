/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
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
/*    */ public class CharSequenceUtils
/*    */ {
/*    */   static boolean regionMatches(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3) {
/* 51 */     if (paramCharSequence1 instanceof String && paramCharSequence2 instanceof String) {
/* 52 */       return ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
/*    */     }
/* 54 */     int i = paramInt1;
/* 55 */     int j = paramInt2;
/* 56 */     int k = paramInt3;
/*    */     
/* 58 */     while (k-- > 0) {
/* 59 */       char c1 = paramCharSequence1.charAt(i++);
/* 60 */       char c2 = paramCharSequence2.charAt(j++);
/*    */       
/* 62 */       if (c1 == c2) {
/*    */         continue;
/*    */       }
/*    */       
/* 66 */       if (!paramBoolean) {
/* 67 */         return false;
/*    */       }
/*    */ 
/*    */       
/* 71 */       if (Character.toUpperCase(c1) != Character.toUpperCase(c2) && 
/* 72 */         Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
/* 73 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/CharSequenceUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */