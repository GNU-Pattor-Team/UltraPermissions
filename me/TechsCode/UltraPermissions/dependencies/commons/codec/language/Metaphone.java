/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
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
/*     */ public class Metaphone
/*     */   implements StringEncoder
/*     */ {
/*     */   private static final String VOWELS = "AEIOU";
/*     */   private static final String FRONTV = "EIY";
/*     */   private static final String VARSON = "CSPTG";
/*  73 */   private int maxCodeLen = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String metaphone(String paramString) {
/*  93 */     boolean bool = false;
/*     */     int i;
/*  95 */     if (paramString == null || (i = paramString.length()) == 0) {
/*  96 */       return "";
/*     */     }
/*     */     
/*  99 */     if (i == 1) {
/* 100 */       return paramString.toUpperCase(Locale.ENGLISH);
/*     */     }
/*     */     
/* 103 */     char[] arrayOfChar = paramString.toUpperCase(Locale.ENGLISH).toCharArray();
/*     */     
/* 105 */     StringBuilder stringBuilder1 = new StringBuilder(40);
/* 106 */     StringBuilder stringBuilder2 = new StringBuilder(10);
/*     */     
/* 108 */     switch (arrayOfChar[0]) {
/*     */       case 'G':
/*     */       case 'K':
/*     */       case 'P':
/* 112 */         if (arrayOfChar[1] == 'N') {
/* 113 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1); break;
/*     */         } 
/* 115 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       
/*     */       case 'A':
/* 119 */         if (arrayOfChar[1] == 'E') {
/* 120 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1); break;
/*     */         } 
/* 122 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       
/*     */       case 'W':
/* 126 */         if (arrayOfChar[1] == 'R') {
/* 127 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1);
/*     */           break;
/*     */         } 
/* 130 */         if (arrayOfChar[1] == 'H') {
/* 131 */           stringBuilder1.append(arrayOfChar, 1, arrayOfChar.length - 1);
/* 132 */           stringBuilder1.setCharAt(0, 'W'); break;
/*     */         } 
/* 134 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       
/*     */       case 'X':
/* 138 */         arrayOfChar[0] = 'S';
/* 139 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */       default:
/* 142 */         stringBuilder1.append(arrayOfChar);
/*     */         break;
/*     */     } 
/* 145 */     int j = stringBuilder1.length();
/* 146 */     byte b = 0;
/*     */     
/* 148 */     while (stringBuilder2.length() < getMaxCodeLen() && b < j) {
/*     */       
/* 150 */       char c = stringBuilder1.charAt(b);
/*     */       
/* 152 */       if (c != 'C' && isPreviousChar(stringBuilder1, b, c)) {
/* 153 */         b++;
/*     */       } else {
/* 155 */         switch (c) {
/*     */           case 'A':
/*     */           case 'E':
/*     */           case 'I':
/*     */           case 'O':
/*     */           case 'U':
/* 161 */             if (b == 0) {
/* 162 */               stringBuilder2.append(c);
/*     */             }
/*     */             break;
/*     */           case 'B':
/* 166 */             if (isPreviousChar(stringBuilder1, b, 'M') && 
/* 167 */               isLastChar(j, b)) {
/*     */               break;
/*     */             }
/* 170 */             stringBuilder2.append(c);
/*     */             break;
/*     */           
/*     */           case 'C':
/* 174 */             if (isPreviousChar(stringBuilder1, b, 'S') && 
/* 175 */               !isLastChar(j, b) && "EIY"
/* 176 */               .indexOf(stringBuilder1.charAt(b + 1)) >= 0) {
/*     */               break;
/*     */             }
/* 179 */             if (regionMatch(stringBuilder1, b, "CIA")) {
/* 180 */               stringBuilder2.append('X');
/*     */               break;
/*     */             } 
/* 183 */             if (!isLastChar(j, b) && "EIY"
/* 184 */               .indexOf(stringBuilder1.charAt(b + 1)) >= 0) {
/* 185 */               stringBuilder2.append('S');
/*     */               break;
/*     */             } 
/* 188 */             if (isPreviousChar(stringBuilder1, b, 'S') && 
/* 189 */               isNextChar(stringBuilder1, b, 'H')) {
/* 190 */               stringBuilder2.append('K');
/*     */               break;
/*     */             } 
/* 193 */             if (isNextChar(stringBuilder1, b, 'H')) {
/* 194 */               if (b == 0 && j >= 3 && 
/*     */                 
/* 196 */                 isVowel(stringBuilder1, 2)) {
/* 197 */                 stringBuilder2.append('K'); break;
/*     */               } 
/* 199 */               stringBuilder2.append('X');
/*     */               break;
/*     */             } 
/* 202 */             stringBuilder2.append('K');
/*     */             break;
/*     */           
/*     */           case 'D':
/* 206 */             if (!isLastChar(j, b + 1) && 
/* 207 */               isNextChar(stringBuilder1, b, 'G') && "EIY"
/* 208 */               .indexOf(stringBuilder1.charAt(b + 2)) >= 0) {
/* 209 */               stringBuilder2.append('J'); b += 2; break;
/*     */             } 
/* 211 */             stringBuilder2.append('T');
/*     */             break;
/*     */           
/*     */           case 'G':
/* 215 */             if (isLastChar(j, b + 1) && 
/* 216 */               isNextChar(stringBuilder1, b, 'H')) {
/*     */               break;
/*     */             }
/* 219 */             if (!isLastChar(j, b + 1) && 
/* 220 */               isNextChar(stringBuilder1, b, 'H') && 
/* 221 */               !isVowel(stringBuilder1, b + 2)) {
/*     */               break;
/*     */             }
/* 224 */             if (b > 0 && (
/* 225 */               regionMatch(stringBuilder1, b, "GN") || 
/* 226 */               regionMatch(stringBuilder1, b, "GNED"))) {
/*     */               break;
/*     */             }
/* 229 */             if (isPreviousChar(stringBuilder1, b, 'G')) {
/*     */               
/* 231 */               bool = true;
/*     */             } else {
/* 233 */               bool = false;
/*     */             } 
/* 235 */             if (!isLastChar(j, b) && "EIY"
/* 236 */               .indexOf(stringBuilder1.charAt(b + 1)) >= 0 && !bool) {
/*     */               
/* 238 */               stringBuilder2.append('J'); break;
/*     */             } 
/* 240 */             stringBuilder2.append('K');
/*     */             break;
/*     */           
/*     */           case 'H':
/* 244 */             if (isLastChar(j, b)) {
/*     */               break;
/*     */             }
/* 247 */             if (b > 0 && "CSPTG"
/* 248 */               .indexOf(stringBuilder1.charAt(b - 1)) >= 0) {
/*     */               break;
/*     */             }
/* 251 */             if (isVowel(stringBuilder1, b + 1)) {
/* 252 */               stringBuilder2.append('H');
/*     */             }
/*     */             break;
/*     */           case 'F':
/*     */           case 'J':
/*     */           case 'L':
/*     */           case 'M':
/*     */           case 'N':
/*     */           case 'R':
/* 261 */             stringBuilder2.append(c);
/*     */             break;
/*     */           case 'K':
/* 264 */             if (b > 0) {
/* 265 */               if (!isPreviousChar(stringBuilder1, b, 'C'))
/* 266 */                 stringBuilder2.append(c); 
/*     */               break;
/*     */             } 
/* 269 */             stringBuilder2.append(c);
/*     */             break;
/*     */           
/*     */           case 'P':
/* 273 */             if (isNextChar(stringBuilder1, b, 'H')) {
/*     */               
/* 275 */               stringBuilder2.append('F'); break;
/*     */             } 
/* 277 */             stringBuilder2.append(c);
/*     */             break;
/*     */           
/*     */           case 'Q':
/* 281 */             stringBuilder2.append('K');
/*     */             break;
/*     */           case 'S':
/* 284 */             if (regionMatch(stringBuilder1, b, "SH") || 
/* 285 */               regionMatch(stringBuilder1, b, "SIO") || 
/* 286 */               regionMatch(stringBuilder1, b, "SIA")) {
/* 287 */               stringBuilder2.append('X'); break;
/*     */             } 
/* 289 */             stringBuilder2.append('S');
/*     */             break;
/*     */           
/*     */           case 'T':
/* 293 */             if (regionMatch(stringBuilder1, b, "TIA") || 
/* 294 */               regionMatch(stringBuilder1, b, "TIO")) {
/* 295 */               stringBuilder2.append('X');
/*     */               break;
/*     */             } 
/* 298 */             if (regionMatch(stringBuilder1, b, "TCH")) {
/*     */               break;
/*     */             }
/*     */ 
/*     */             
/* 303 */             if (regionMatch(stringBuilder1, b, "TH")) {
/* 304 */               stringBuilder2.append('0'); break;
/*     */             } 
/* 306 */             stringBuilder2.append('T');
/*     */             break;
/*     */           
/*     */           case 'V':
/* 310 */             stringBuilder2.append('F'); break;
/*     */           case 'W':
/*     */           case 'Y':
/* 313 */             if (!isLastChar(j, b) && 
/* 314 */               isVowel(stringBuilder1, b + 1)) {
/* 315 */               stringBuilder2.append(c);
/*     */             }
/*     */             break;
/*     */           case 'X':
/* 319 */             stringBuilder2.append('K');
/* 320 */             stringBuilder2.append('S');
/*     */             break;
/*     */           case 'Z':
/* 323 */             stringBuilder2.append('S');
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 329 */         b++;
/*     */       } 
/* 331 */       if (stringBuilder2.length() > getMaxCodeLen()) {
/* 332 */         stringBuilder2.setLength(getMaxCodeLen());
/*     */       }
/*     */     } 
/* 335 */     return stringBuilder2.toString();
/*     */   }
/*     */   
/*     */   private boolean isVowel(StringBuilder paramStringBuilder, int paramInt) {
/* 339 */     return ("AEIOU".indexOf(paramStringBuilder.charAt(paramInt)) >= 0);
/*     */   }
/*     */   
/*     */   private boolean isPreviousChar(StringBuilder paramStringBuilder, int paramInt, char paramChar) {
/* 343 */     boolean bool = false;
/* 344 */     if (paramInt > 0 && paramInt < paramStringBuilder
/* 345 */       .length()) {
/* 346 */       bool = (paramStringBuilder.charAt(paramInt - 1) == paramChar) ? true : false;
/*     */     }
/* 348 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean isNextChar(StringBuilder paramStringBuilder, int paramInt, char paramChar) {
/* 352 */     boolean bool = false;
/* 353 */     if (paramInt >= 0 && paramInt < paramStringBuilder
/* 354 */       .length() - 1) {
/* 355 */       bool = (paramStringBuilder.charAt(paramInt + 1) == paramChar) ? true : false;
/*     */     }
/* 357 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean regionMatch(StringBuilder paramStringBuilder, int paramInt, String paramString) {
/* 361 */     boolean bool = false;
/* 362 */     if (paramInt >= 0 && paramInt + paramString
/* 363 */       .length() - 1 < paramStringBuilder.length()) {
/* 364 */       String str = paramStringBuilder.substring(paramInt, paramInt + paramString.length());
/* 365 */       bool = str.equals(paramString);
/*     */     } 
/* 367 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean isLastChar(int paramInt1, int paramInt2) {
/* 371 */     return (paramInt2 + 1 == paramInt1);
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
/* 389 */     if (!(paramObject instanceof String)) {
/* 390 */       throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
/*     */     }
/* 392 */     return metaphone((String)paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String encode(String paramString) {
/* 403 */     return metaphone(paramString);
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
/*     */   public boolean isMetaphoneEqual(String paramString1, String paramString2) {
/* 415 */     return metaphone(paramString1).equals(metaphone(paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxCodeLen() {
/* 422 */     return this.maxCodeLen;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxCodeLen(int paramInt) {
/* 428 */     this.maxCodeLen = paramInt;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/Metaphone.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */