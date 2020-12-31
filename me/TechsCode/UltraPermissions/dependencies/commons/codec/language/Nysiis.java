/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*     */ 
/*     */ import java.util.regex.Pattern;
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
/*     */ public class Nysiis
/*     */   implements StringEncoder
/*     */ {
/*  72 */   private static final char[] CHARS_A = new char[] { 'A' };
/*  73 */   private static final char[] CHARS_AF = new char[] { 'A', 'F' };
/*  74 */   private static final char[] CHARS_C = new char[] { 'C' };
/*  75 */   private static final char[] CHARS_FF = new char[] { 'F', 'F' };
/*  76 */   private static final char[] CHARS_G = new char[] { 'G' };
/*  77 */   private static final char[] CHARS_N = new char[] { 'N' };
/*  78 */   private static final char[] CHARS_NN = new char[] { 'N', 'N' };
/*  79 */   private static final char[] CHARS_S = new char[] { 'S' };
/*  80 */   private static final char[] CHARS_SSS = new char[] { 'S', 'S', 'S' };
/*     */   
/*  82 */   private static final Pattern PAT_MAC = Pattern.compile("^MAC");
/*  83 */   private static final Pattern PAT_KN = Pattern.compile("^KN");
/*  84 */   private static final Pattern PAT_K = Pattern.compile("^K");
/*  85 */   private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");
/*  86 */   private static final Pattern PAT_SCH = Pattern.compile("^SCH");
/*  87 */   private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
/*  88 */   private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");
/*     */ 
/*     */   
/*     */   private static final char SPACE = ' ';
/*     */ 
/*     */   
/*     */   private static final int TRUE_LENGTH = 6;
/*     */ 
/*     */   
/*     */   private final boolean strict;
/*     */ 
/*     */   
/*     */   private static boolean isVowel(char paramChar) {
/* 101 */     return (paramChar == 'A' || paramChar == 'E' || paramChar == 'I' || paramChar == 'O' || paramChar == 'U');
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
/*     */   private static char[] transcodeRemaining(char paramChar1, char paramChar2, char paramChar3, char paramChar4) {
/* 120 */     if (paramChar2 == 'E' && paramChar3 == 'V') {
/* 121 */       return CHARS_AF;
/*     */     }
/*     */ 
/*     */     
/* 125 */     if (isVowel(paramChar2)) {
/* 126 */       return CHARS_A;
/*     */     }
/*     */ 
/*     */     
/* 130 */     if (paramChar2 == 'Q')
/* 131 */       return CHARS_G; 
/* 132 */     if (paramChar2 == 'Z')
/* 133 */       return CHARS_S; 
/* 134 */     if (paramChar2 == 'M') {
/* 135 */       return CHARS_N;
/*     */     }
/*     */ 
/*     */     
/* 139 */     if (paramChar2 == 'K') {
/* 140 */       if (paramChar3 == 'N') {
/* 141 */         return CHARS_NN;
/*     */       }
/* 143 */       return CHARS_C;
/*     */     } 
/*     */ 
/*     */     
/* 147 */     if (paramChar2 == 'S' && paramChar3 == 'C' && paramChar4 == 'H') {
/* 148 */       return CHARS_SSS;
/*     */     }
/*     */ 
/*     */     
/* 152 */     if (paramChar2 == 'P' && paramChar3 == 'H') {
/* 153 */       return CHARS_FF;
/*     */     }
/*     */ 
/*     */     
/* 157 */     if (paramChar2 == 'H' && (!isVowel(paramChar1) || !isVowel(paramChar3))) {
/* 158 */       return new char[] { paramChar1 };
/*     */     }
/*     */ 
/*     */     
/* 162 */     if (paramChar2 == 'W' && isVowel(paramChar1)) {
/* 163 */       return new char[] { paramChar1 };
/*     */     }
/*     */     
/* 166 */     return new char[] { paramChar2 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nysiis() {
/* 177 */     this(true);
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
/*     */   public Nysiis(boolean paramBoolean) {
/* 192 */     this.strict = paramBoolean;
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
/* 210 */     if (!(paramObject instanceof String)) {
/* 211 */       throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
/*     */     }
/* 213 */     return nysiis((String)paramObject);
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
/* 227 */     return nysiis(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStrict() {
/* 236 */     return this.strict;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String nysiis(String paramString) {
/* 247 */     if (paramString == null) {
/* 248 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 252 */     paramString = SoundexUtils.clean(paramString);
/*     */     
/* 254 */     if (paramString.length() == 0) {
/* 255 */       return paramString;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 260 */     paramString = PAT_MAC.matcher(paramString).replaceFirst("MCC");
/* 261 */     paramString = PAT_KN.matcher(paramString).replaceFirst("NN");
/* 262 */     paramString = PAT_K.matcher(paramString).replaceFirst("C");
/* 263 */     paramString = PAT_PH_PF.matcher(paramString).replaceFirst("FF");
/* 264 */     paramString = PAT_SCH.matcher(paramString).replaceFirst("SSS");
/*     */ 
/*     */ 
/*     */     
/* 268 */     paramString = PAT_EE_IE.matcher(paramString).replaceFirst("Y");
/* 269 */     paramString = PAT_DT_ETC.matcher(paramString).replaceFirst("D");
/*     */ 
/*     */     
/* 272 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 273 */     stringBuilder.append(paramString.charAt(0));
/*     */ 
/*     */     
/* 276 */     char[] arrayOfChar = paramString.toCharArray();
/* 277 */     int i = arrayOfChar.length;
/*     */     char c;
/* 279 */     for (c = '\001'; c < i; c++) {
/* 280 */       boolean bool1 = (c < i - 1) ? arrayOfChar[c + 1] : true;
/* 281 */       boolean bool2 = (c < i - 2) ? arrayOfChar[c + 2] : true;
/* 282 */       char[] arrayOfChar1 = transcodeRemaining(arrayOfChar[c - 1], arrayOfChar[c], bool1, bool2);
/* 283 */       System.arraycopy(arrayOfChar1, 0, arrayOfChar, c, arrayOfChar1.length);
/*     */ 
/*     */       
/* 286 */       if (arrayOfChar[c] != arrayOfChar[c - 1]) {
/* 287 */         stringBuilder.append(arrayOfChar[c]);
/*     */       }
/*     */     } 
/*     */     
/* 291 */     if (stringBuilder.length() > 1) {
/* 292 */       c = stringBuilder.charAt(stringBuilder.length() - 1);
/*     */ 
/*     */       
/* 295 */       if (c == 'S') {
/* 296 */         stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/* 297 */         c = stringBuilder.charAt(stringBuilder.length() - 1);
/*     */       } 
/*     */       
/* 300 */       if (stringBuilder.length() > 2) {
/* 301 */         char c1 = stringBuilder.charAt(stringBuilder.length() - 2);
/*     */         
/* 303 */         if (c1 == 'A' && c == 'Y') {
/* 304 */           stringBuilder.deleteCharAt(stringBuilder.length() - 2);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 309 */       if (c == 'A') {
/* 310 */         stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/*     */       }
/*     */     } 
/*     */     
/* 314 */     String str = stringBuilder.toString();
/* 315 */     return isStrict() ? str.substring(0, Math.min(6, str.length())) : str;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/Nysiis.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */