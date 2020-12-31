/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class Caverphone
/*     */   implements StringEncoder
/*     */ {
/*  41 */   private final Caverphone2 encoder = new Caverphone2();
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
/*     */   public String caverphone(String paramString) {
/*  58 */     return this.encoder.encode(paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object encode(Object paramObject) {
/*  74 */     if (!(paramObject instanceof String)) {
/*  75 */       throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
/*     */     }
/*  77 */     return caverphone((String)paramObject);
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
/*     */   public String encode(String paramString) {
/*  89 */     return caverphone(paramString);
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
/*     */   
/*     */   public boolean isCaverphoneEqual(String paramString1, String paramString2) {
/* 102 */     return caverphone(paramString1).equals(caverphone(paramString2));
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/Caverphone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */