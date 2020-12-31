/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.digest;
/*    */ 
/*    */ import java.security.SecureRandom;
/*    */ import java.util.Random;
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
/*    */ class B64
/*    */ {
/*    */   static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
/*    */   
/*    */   static void b64from24bit(byte paramByte1, byte paramByte2, byte paramByte3, int paramInt, StringBuilder paramStringBuilder) {
/* 59 */     int i = paramByte1 << 16 & 0xFFFFFF | paramByte2 << 8 & 0xFFFF | paramByte3 & 0xFF;
/*    */     
/* 61 */     int j = paramInt;
/* 62 */     while (j-- > 0) {
/* 63 */       paramStringBuilder.append("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(i & 0x3F));
/* 64 */       i >>= 6;
/*    */     } 
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
/*    */   static String getRandomSalt(int paramInt) {
/* 78 */     return getRandomSalt(paramInt, new SecureRandom());
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
/*    */   static String getRandomSalt(int paramInt, Random paramRandom) {
/* 92 */     StringBuilder stringBuilder = new StringBuilder(paramInt);
/* 93 */     for (byte b = 1; b <= paramInt; b++) {
/* 94 */       stringBuilder.append("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(paramRandom.nextInt("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length())));
/*    */     }
/* 96 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/digest/B64.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */