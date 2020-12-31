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
/*     */ public class RefinedSoundex
/*     */   implements StringEncoder
/*     */ {
/*     */   public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
/*  58 */   private static final char[] US_ENGLISH_MAPPING = "01360240043788015936020505".toCharArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final char[] soundexMapping;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RefinedSoundex() {
/*  78 */     this.soundexMapping = US_ENGLISH_MAPPING;
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
/*     */   public RefinedSoundex(char[] paramArrayOfchar) {
/*  91 */     this.soundexMapping = new char[paramArrayOfchar.length];
/*  92 */     System.arraycopy(paramArrayOfchar, 0, this.soundexMapping, 0, paramArrayOfchar.length);
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
/*     */   public RefinedSoundex(String paramString) {
/* 104 */     this.soundexMapping = paramString.toCharArray();
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
/*     */   public int difference(String paramString1, String paramString2) {
/* 130 */     return SoundexUtils.difference(this, paramString1, paramString2);
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
/*     */ 
/*     */   
/*     */   public Object encode(Object paramObject) {
/* 148 */     if (!(paramObject instanceof String)) {
/* 149 */       throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
/*     */     }
/* 151 */     return soundex((String)paramObject);
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
/* 163 */     return soundex(paramString);
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
/*     */   char getMappingCode(char paramChar) {
/* 176 */     if (!Character.isLetter(paramChar)) {
/* 177 */       return Character.MIN_VALUE;
/*     */     }
/* 179 */     return this.soundexMapping[Character.toUpperCase(paramChar) - 65];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String soundex(String paramString) {
/* 190 */     if (paramString == null) {
/* 191 */       return null;
/*     */     }
/* 193 */     paramString = SoundexUtils.clean(paramString);
/* 194 */     if (paramString.length() == 0) {
/* 195 */       return paramString;
/*     */     }
/*     */     
/* 198 */     StringBuilder stringBuilder = new StringBuilder();
/* 199 */     stringBuilder.append(paramString.charAt(0));
/*     */ 
/*     */     
/* 202 */     char c = '*';
/*     */     
/* 204 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       
/* 206 */       char c1 = getMappingCode(paramString.charAt(b));
/* 207 */       if (c1 != c) {
/*     */         
/* 209 */         if (c1 != '\000') {
/* 210 */           stringBuilder.append(c1);
/*     */         }
/*     */         
/* 213 */         c = c1;
/*     */       } 
/*     */     } 
/*     */     
/* 217 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/RefinedSoundex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */