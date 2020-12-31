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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Soundex
/*     */   implements StringEncoder
/*     */ {
/*     */   public static final char SILENT_MARKER = '-';
/*     */   public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
/*  68 */   private static final char[] US_ENGLISH_MAPPING = "01230120022455012623010202".toCharArray();
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
/*  79 */   public static final Soundex US_ENGLISH = new Soundex();
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
/*  92 */   public static final Soundex US_ENGLISH_SIMPLIFIED = new Soundex("01230120022455012623010202", false);
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
/* 107 */   public static final Soundex US_ENGLISH_GENEALOGY = new Soundex("-123-12--22455-12623-1-2-2");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 115 */   private int maxLength = 4;
/*     */ 
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
/*     */ 
/*     */   
/*     */   private final boolean specialCaseHW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Soundex() {
/* 140 */     this.soundexMapping = US_ENGLISH_MAPPING;
/* 141 */     this.specialCaseHW = true;
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
/*     */   public Soundex(char[] paramArrayOfchar) {
/* 157 */     this.soundexMapping = new char[paramArrayOfchar.length];
/* 158 */     System.arraycopy(paramArrayOfchar, 0, this.soundexMapping, 0, paramArrayOfchar.length);
/* 159 */     this.specialCaseHW = !hasMarker(this.soundexMapping);
/*     */   }
/*     */   
/*     */   private boolean hasMarker(char[] paramArrayOfchar) {
/* 163 */     for (char c : paramArrayOfchar) {
/* 164 */       if (c == '-') {
/* 165 */         return true;
/*     */       }
/*     */     } 
/* 168 */     return false;
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
/*     */   public Soundex(String paramString) {
/* 182 */     this.soundexMapping = paramString.toCharArray();
/* 183 */     this.specialCaseHW = !hasMarker(this.soundexMapping);
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
/*     */   public Soundex(String paramString, boolean paramBoolean) {
/* 196 */     this.soundexMapping = paramString.toCharArray();
/* 197 */     this.specialCaseHW = paramBoolean;
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
/*     */   public int difference(String paramString1, String paramString2) {
/* 220 */     return SoundexUtils.difference(this, paramString1, paramString2);
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
/* 238 */     if (!(paramObject instanceof String)) {
/* 239 */       throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
/*     */     }
/* 241 */     return soundex((String)paramObject);
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
/*     */   public String encode(String paramString) {
/* 255 */     return soundex(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int getMaxLength() {
/* 266 */     return this.maxLength;
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
/*     */   private char map(char paramChar) {
/* 279 */     int i = paramChar - 65;
/* 280 */     if (i < 0 || i >= this.soundexMapping.length) {
/* 281 */       throw new IllegalArgumentException("The character is not mapped: " + paramChar + " (index=" + i + ")");
/*     */     }
/* 283 */     return this.soundexMapping[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setMaxLength(int paramInt) {
/* 295 */     this.maxLength = paramInt;
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
/*     */   public String soundex(String paramString) {
/* 308 */     if (paramString == null) {
/* 309 */       return null;
/*     */     }
/* 311 */     paramString = SoundexUtils.clean(paramString);
/* 312 */     if (paramString.length() == 0) {
/* 313 */       return paramString;
/*     */     }
/* 315 */     char[] arrayOfChar = { '0', '0', '0', '0' };
/* 316 */     byte b1 = 0;
/* 317 */     char c1 = paramString.charAt(0);
/* 318 */     arrayOfChar[b1++] = c1;
/* 319 */     char c2 = map(c1);
/* 320 */     for (byte b2 = 1; b2 < paramString.length() && b1 < arrayOfChar.length; b2++) {
/* 321 */       char c = paramString.charAt(b2);
/* 322 */       if (!this.specialCaseHW || (c != 'H' && c != 'W')) {
/*     */ 
/*     */         
/* 325 */         char c3 = map(c);
/* 326 */         if (c3 != '-')
/*     */         
/*     */         { 
/* 329 */           if (c3 != '0' && c3 != c2) {
/* 330 */             arrayOfChar[b1++] = c3;
/*     */           }
/* 332 */           c2 = c3; } 
/*     */       } 
/* 334 */     }  return new String(arrayOfChar);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/Soundex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */