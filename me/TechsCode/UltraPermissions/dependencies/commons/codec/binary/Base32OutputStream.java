/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.binary;
/*    */ 
/*    */ import java.io.OutputStream;
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
/*    */ public class Base32OutputStream
/*    */   extends BaseNCodecOutputStream
/*    */ {
/*    */   public Base32OutputStream(OutputStream paramOutputStream) {
/* 52 */     this(paramOutputStream, true);
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
/*    */   public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean) {
/* 65 */     super(paramOutputStream, new Base32(false), paramBoolean);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean, int paramInt, byte[] paramArrayOfbyte) {
/* 86 */     super(paramOutputStream, new Base32(paramInt, paramArrayOfbyte), paramBoolean);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/binary/Base32OutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */