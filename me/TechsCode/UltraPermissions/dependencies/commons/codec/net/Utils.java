/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.net;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.DecoderException;
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
/*    */ class Utils
/*    */ {
/*    */   private static final int RADIX = 16;
/*    */   
/*    */   static int digit16(byte paramByte) {
/* 48 */     int i = Character.digit((char)paramByte, 16);
/* 49 */     if (i == -1) {
/* 50 */       throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + paramByte);
/*    */     }
/* 52 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static char hexDigit(int paramInt) {
/* 62 */     return Character.toUpperCase(Character.forDigit(paramInt & 0xF, 16));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/net/Utils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */