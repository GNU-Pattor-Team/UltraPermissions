/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language.bm;
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
/*     */ public class BeiderMorseEncoder
/*     */   implements StringEncoder
/*     */ {
/*  84 */   private PhoneticEngine engine = new PhoneticEngine(NameType.GENERIC, RuleType.APPROX, true);
/*     */ 
/*     */   
/*     */   public Object encode(Object paramObject) {
/*  88 */     if (!(paramObject instanceof String)) {
/*  89 */       throw new EncoderException("BeiderMorseEncoder encode parameter is not of type String");
/*     */     }
/*  91 */     return encode((String)paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public String encode(String paramString) {
/*  96 */     if (paramString == null) {
/*  97 */       return null;
/*     */     }
/*  99 */     return this.engine.encode(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameType getNameType() {
/* 108 */     return this.engine.getNameType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RuleType getRuleType() {
/* 117 */     return this.engine.getRuleType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConcat() {
/* 126 */     return this.engine.isConcat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConcat(boolean paramBoolean) {
/* 137 */     this
/*     */ 
/*     */       
/* 140 */       .engine = new PhoneticEngine(this.engine.getNameType(), this.engine.getRuleType(), paramBoolean, this.engine.getMaxPhonemes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNameType(NameType paramNameType) {
/* 151 */     this
/*     */ 
/*     */       
/* 154 */       .engine = new PhoneticEngine(paramNameType, this.engine.getRuleType(), this.engine.isConcat(), this.engine.getMaxPhonemes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRuleType(RuleType paramRuleType) {
/* 164 */     this
/*     */ 
/*     */       
/* 167 */       .engine = new PhoneticEngine(this.engine.getNameType(), paramRuleType, this.engine.isConcat(), this.engine.getMaxPhonemes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxPhonemes(int paramInt) {
/* 178 */     this
/*     */       
/* 180 */       .engine = new PhoneticEngine(this.engine.getNameType(), this.engine.getRuleType(), this.engine.isConcat(), paramInt);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/BeiderMorseEncoder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */