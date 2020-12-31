/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharUtils
/*     */ {
/*     */   private static final String CHAR_STRING = "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
/*  51 */   private static final String[] CHAR_STRING_ARRAY = new String[128];
/*  52 */   private static final Character[] CHAR_ARRAY = new Character[128];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char LF = '\n';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char CR = '\r';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  74 */     for (byte b = 127; b >= 0; b--) {
/*  75 */       CHAR_STRING_ARRAY[b] = "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".substring(b, b + 1);
/*  76 */       CHAR_ARRAY[b] = new Character((char)b);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Character toCharacterObject(char paramChar) {
/* 107 */     if (paramChar < CHAR_ARRAY.length) {
/* 108 */       return CHAR_ARRAY[paramChar];
/*     */     }
/* 110 */     return new Character(paramChar);
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
/*     */   public static Character toCharacterObject(String paramString) {
/* 131 */     if (StringUtils.isEmpty(paramString)) {
/* 132 */       return null;
/*     */     }
/* 134 */     return toCharacterObject(paramString.charAt(0));
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
/*     */   public static char toChar(Character paramCharacter) {
/* 152 */     if (paramCharacter == null) {
/* 153 */       throw new IllegalArgumentException("The Character must not be null");
/*     */     }
/* 155 */     return paramCharacter.charValue();
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
/*     */   public static char toChar(Character paramCharacter, char paramChar) {
/* 172 */     if (paramCharacter == null) {
/* 173 */       return paramChar;
/*     */     }
/* 175 */     return paramCharacter.charValue();
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
/*     */   public static char toChar(String paramString) {
/* 195 */     if (StringUtils.isEmpty(paramString)) {
/* 196 */       throw new IllegalArgumentException("The String must not be empty");
/*     */     }
/* 198 */     return paramString.charAt(0);
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
/*     */   public static char toChar(String paramString, char paramChar) {
/* 217 */     if (StringUtils.isEmpty(paramString)) {
/* 218 */       return paramChar;
/*     */     }
/* 220 */     return paramString.charAt(0);
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
/*     */   public static int toIntValue(char paramChar) {
/* 240 */     if (!isAsciiNumeric(paramChar)) {
/* 241 */       throw new IllegalArgumentException("The character " + paramChar + " is not in the range '0' - '9'");
/*     */     }
/* 243 */     return paramChar - 48;
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
/*     */   public static int toIntValue(char paramChar, int paramInt) {
/* 262 */     if (!isAsciiNumeric(paramChar)) {
/* 263 */       return paramInt;
/*     */     }
/* 265 */     return paramChar - 48;
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
/*     */   public static int toIntValue(Character paramCharacter) {
/* 285 */     if (paramCharacter == null) {
/* 286 */       throw new IllegalArgumentException("The character must not be null");
/*     */     }
/* 288 */     return toIntValue(paramCharacter.charValue());
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
/*     */   public static int toIntValue(Character paramCharacter, int paramInt) {
/* 308 */     if (paramCharacter == null) {
/* 309 */       return paramInt;
/*     */     }
/* 311 */     return toIntValue(paramCharacter.charValue(), paramInt);
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
/*     */   public static String toString(char paramChar) {
/* 330 */     if (paramChar < '') {
/* 331 */       return CHAR_STRING_ARRAY[paramChar];
/*     */     }
/* 333 */     return new String(new char[] { paramChar });
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
/*     */   public static String toString(Character paramCharacter) {
/* 354 */     if (paramCharacter == null) {
/* 355 */       return null;
/*     */     }
/* 357 */     return toString(paramCharacter.charValue());
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
/*     */   public static String unicodeEscaped(char paramChar) {
/* 375 */     if (paramChar < '\020')
/* 376 */       return "\\u000" + Integer.toHexString(paramChar); 
/* 377 */     if (paramChar < 'Ā')
/* 378 */       return "\\u00" + Integer.toHexString(paramChar); 
/* 379 */     if (paramChar < 'က') {
/* 380 */       return "\\u0" + Integer.toHexString(paramChar);
/*     */     }
/* 382 */     return "\\u" + Integer.toHexString(paramChar);
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
/*     */   public static String unicodeEscaped(Character paramCharacter) {
/* 402 */     if (paramCharacter == null) {
/* 403 */       return null;
/*     */     }
/* 405 */     return unicodeEscaped(paramCharacter.charValue());
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
/*     */   public static boolean isAscii(char paramChar) {
/* 425 */     return (paramChar < '');
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
/*     */   public static boolean isAsciiPrintable(char paramChar) {
/* 444 */     return (paramChar >= ' ' && paramChar < '');
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
/*     */   public static boolean isAsciiControl(char paramChar) {
/* 463 */     return (paramChar < ' ' || paramChar == '');
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
/*     */   public static boolean isAsciiAlpha(char paramChar) {
/* 482 */     return ((paramChar >= 'A' && paramChar <= 'Z') || (paramChar >= 'a' && paramChar <= 'z'));
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
/*     */   public static boolean isAsciiAlphaUpper(char paramChar) {
/* 501 */     return (paramChar >= 'A' && paramChar <= 'Z');
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
/*     */   public static boolean isAsciiAlphaLower(char paramChar) {
/* 520 */     return (paramChar >= 'a' && paramChar <= 'z');
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
/*     */   public static boolean isAsciiNumeric(char paramChar) {
/* 539 */     return (paramChar >= '0' && paramChar <= '9');
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
/*     */   public static boolean isAsciiAlphanumeric(char paramChar) {
/* 558 */     return ((paramChar >= 'A' && paramChar <= 'Z') || (paramChar >= 'a' && paramChar <= 'z') || (paramChar >= '0' && paramChar <= '9'));
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
/*     */   static boolean isHighSurrogate(char paramChar) {
/* 573 */     return ('?' <= paramChar && '?' >= paramChar);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/CharUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */