/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.security.MessageDigest;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MessageDigestCalculatingInputStream
/*     */   extends ObservableInputStream
/*     */ {
/*     */   private final MessageDigest messageDigest;
/*     */   
/*     */   public static class MessageDigestMaintainingObserver
/*     */     extends ObservableInputStream.Observer
/*     */   {
/*     */     private final MessageDigest md;
/*     */     
/*     */     public MessageDigestMaintainingObserver(MessageDigest param1MessageDigest) {
/*  45 */       this.md = param1MessageDigest;
/*     */     }
/*     */ 
/*     */     
/*     */     void data(int param1Int) {
/*  50 */       this.md.update((byte)param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     void data(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*  55 */       this.md.update(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MessageDigestCalculatingInputStream(InputStream paramInputStream, MessageDigest paramMessageDigest) {
/*  67 */     super(paramInputStream);
/*  68 */     this.messageDigest = paramMessageDigest;
/*  69 */     add(new MessageDigestMaintainingObserver(paramMessageDigest));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MessageDigestCalculatingInputStream(InputStream paramInputStream, String paramString) {
/*  79 */     this(paramInputStream, MessageDigest.getInstance(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MessageDigestCalculatingInputStream(InputStream paramInputStream) {
/*  88 */     this(paramInputStream, MessageDigest.getInstance("MD5"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MessageDigest getMessageDigest() {
/* 100 */     return this.messageDigest;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/MessageDigestCalculatingInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */