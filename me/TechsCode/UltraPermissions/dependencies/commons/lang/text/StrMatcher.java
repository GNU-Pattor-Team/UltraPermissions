/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.text;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class StrMatcher
/*     */ {
/*  37 */   private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
/*     */ 
/*     */ 
/*     */   
/*  41 */   private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
/*     */ 
/*     */ 
/*     */   
/*  45 */   private static final StrMatcher SPACE_MATCHER = new CharMatcher(' ');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
/*     */ 
/*     */ 
/*     */   
/*  54 */   private static final StrMatcher TRIM_MATCHER = new TrimMatcher();
/*     */ 
/*     */ 
/*     */   
/*  58 */   private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
/*     */ 
/*     */ 
/*     */   
/*  62 */   private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('"');
/*     */ 
/*     */ 
/*     */   
/*  66 */   private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
/*     */ 
/*     */ 
/*     */   
/*  70 */   private static final StrMatcher NONE_MATCHER = new NoMatcher();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher commaMatcher() {
/*  80 */     return COMMA_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher tabMatcher() {
/*  89 */     return TAB_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher spaceMatcher() {
/*  98 */     return SPACE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher splitMatcher() {
/* 108 */     return SPLIT_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher trimMatcher() {
/* 117 */     return TRIM_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher singleQuoteMatcher() {
/* 126 */     return SINGLE_QUOTE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher doubleQuoteMatcher() {
/* 135 */     return DOUBLE_QUOTE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher quoteMatcher() {
/* 144 */     return QUOTE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher noneMatcher() {
/* 153 */     return NONE_MATCHER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher charMatcher(char paramChar) {
/* 163 */     return new CharMatcher(paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher charSetMatcher(char[] paramArrayOfchar) {
/* 173 */     if (paramArrayOfchar == null || paramArrayOfchar.length == 0) {
/* 174 */       return NONE_MATCHER;
/*     */     }
/* 176 */     if (paramArrayOfchar.length == 1) {
/* 177 */       return new CharMatcher(paramArrayOfchar[0]);
/*     */     }
/* 179 */     return new CharSetMatcher(paramArrayOfchar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher charSetMatcher(String paramString) {
/* 189 */     if (paramString == null || paramString.length() == 0) {
/* 190 */       return NONE_MATCHER;
/*     */     }
/* 192 */     if (paramString.length() == 1) {
/* 193 */       return new CharMatcher(paramString.charAt(0));
/*     */     }
/* 195 */     return new CharSetMatcher(paramString.toCharArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrMatcher stringMatcher(String paramString) {
/* 205 */     if (paramString == null || paramString.length() == 0) {
/* 206 */       return NONE_MATCHER;
/*     */     }
/* 208 */     return new StringMatcher(paramString);
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
/*     */   
/*     */   public abstract int isMatch(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int isMatch(char[] paramArrayOfchar, int paramInt) {
/* 267 */     return isMatch(paramArrayOfchar, paramInt, 0, paramArrayOfchar.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class CharSetMatcher
/*     */     extends StrMatcher
/*     */   {
/*     */     private final char[] chars;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CharSetMatcher(char[] param1ArrayOfchar) {
/* 285 */       this.chars = (char[])param1ArrayOfchar.clone();
/* 286 */       Arrays.sort(this.chars);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 299 */       return (Arrays.binarySearch(this.chars, param1ArrayOfchar[param1Int1]) >= 0) ? 1 : 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class CharMatcher
/*     */     extends StrMatcher
/*     */   {
/*     */     private final char ch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     CharMatcher(char param1Char) {
/* 318 */       this.ch = param1Char;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 331 */       return (this.ch == param1ArrayOfchar[param1Int1]) ? 1 : 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class StringMatcher
/*     */     extends StrMatcher
/*     */   {
/*     */     private final char[] chars;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StringMatcher(String param1String) {
/* 350 */       this.chars = param1String.toCharArray();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 363 */       int i = this.chars.length;
/* 364 */       if (param1Int1 + i > param1Int3) {
/* 365 */         return 0;
/*     */       }
/* 367 */       for (byte b = 0; b < this.chars.length; b++, param1Int1++) {
/* 368 */         if (this.chars[b] != param1ArrayOfchar[param1Int1]) {
/* 369 */           return 0;
/*     */         }
/*     */       } 
/* 372 */       return i;
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
/*     */   static final class NoMatcher
/*     */     extends StrMatcher
/*     */   {
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 399 */       return 0;
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
/*     */   static final class TrimMatcher
/*     */     extends StrMatcher
/*     */   {
/*     */     public int isMatch(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 426 */       return (param1ArrayOfchar[param1Int1] <= ' ') ? 1 : 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/text/StrMatcher.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */