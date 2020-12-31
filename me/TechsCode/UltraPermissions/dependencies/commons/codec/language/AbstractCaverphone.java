/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
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
/*    */ public abstract class AbstractCaverphone
/*    */   implements StringEncoder
/*    */ {
/*    */   public Object encode(Object paramObject) {
/* 57 */     if (!(paramObject instanceof String)) {
/* 58 */       throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
/*    */     }
/* 60 */     return encode((String)paramObject);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEncodeEqual(String paramString1, String paramString2) {
/* 77 */     return encode(paramString1).equals(encode(paramString2));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/AbstractCaverphone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */