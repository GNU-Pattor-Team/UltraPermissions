/*     */ package me.TechsCode.UltraPermissions.base.visual;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum Letter
/*     */ {
/*  10 */   A('A', 5),
/*  11 */   a('a', 5),
/*  12 */   B('B', 5),
/*  13 */   b('b', 5),
/*  14 */   C('C', 5),
/*  15 */   c('c', 5),
/*  16 */   D('D', 5),
/*  17 */   d('d', 5),
/*  18 */   E('E', 5),
/*  19 */   e('e', 5),
/*  20 */   F('F', 5),
/*  21 */   f('f', 4),
/*  22 */   G('G', 5),
/*  23 */   g('g', 5),
/*  24 */   H('H', 5),
/*  25 */   h('h', 5),
/*  26 */   I('I', 3),
/*  27 */   i('i', 1),
/*  28 */   J('J', 5),
/*  29 */   j('j', 5),
/*  30 */   K('K', 5),
/*  31 */   k('k', 4),
/*  32 */   L('L', 5),
/*  33 */   l('l', 1),
/*  34 */   M('M', 5),
/*  35 */   m('m', 5),
/*  36 */   N('N', 5),
/*  37 */   n('n', 5),
/*  38 */   O('O', 5),
/*  39 */   o('o', 5),
/*  40 */   P('P', 5),
/*  41 */   p('p', 5),
/*  42 */   Q('Q', 5),
/*  43 */   q('q', 5),
/*  44 */   R('R', 5),
/*  45 */   r('r', 5),
/*  46 */   S('S', 5),
/*  47 */   s('s', 5),
/*  48 */   T('T', 5),
/*  49 */   t('t', 4),
/*  50 */   U('U', 5),
/*  51 */   u('u', 5),
/*  52 */   V('V', 5),
/*  53 */   v('v', 5),
/*  54 */   W('W', 5),
/*  55 */   w('w', 5),
/*  56 */   X('X', 5),
/*  57 */   x('x', 5),
/*  58 */   Y('Y', 5),
/*  59 */   y('y', 5),
/*  60 */   Z('Z', 5),
/*  61 */   z('z', 5),
/*  62 */   NUM_1('1', 5),
/*  63 */   NUM_2('2', 5),
/*  64 */   NUM_3('3', 5),
/*  65 */   NUM_4('4', 5),
/*  66 */   NUM_5('5', 5),
/*  67 */   NUM_6('6', 5),
/*  68 */   NUM_7('7', 5),
/*  69 */   NUM_8('8', 5),
/*  70 */   NUM_9('9', 5),
/*  71 */   NUM_0('0', 5),
/*  72 */   EXCLAMATION_POINT('!', 1),
/*  73 */   AT_SYMBOL('@', 6),
/*  74 */   NUM_SIGN('#', 5),
/*  75 */   DOLLAR_SIGN('$', 5),
/*  76 */   PERCENT('%', 5),
/*  77 */   UP_ARROW('^', 5),
/*  78 */   AMPERSAND('&', 5),
/*  79 */   ASTERISK('*', 5),
/*  80 */   LEFT_PARENTHESIS('(', 4),
/*  81 */   RIGHT_PERENTHESIS(')', 4),
/*  82 */   MINUS('-', 5),
/*  83 */   UNDERSCORE('_', 5),
/*  84 */   PLUS_SIGN('+', 5),
/*  85 */   EQUALS_SIGN('=', 5),
/*  86 */   LEFT_CURL_BRACE('{', 4),
/*  87 */   RIGHT_CURL_BRACE('}', 4),
/*  88 */   LEFT_BRACKET('[', 3),
/*  89 */   RIGHT_BRACKET(']', 3),
/*  90 */   COLON(':', 1),
/*  91 */   SEMI_COLON(';', 1),
/*  92 */   DOUBLE_QUOTE('"', 3),
/*  93 */   SINGLE_QUOTE('\'', 1),
/*  94 */   LEFT_ARROW('<', 4),
/*  95 */   RIGHT_ARROW('>', 4),
/*  96 */   QUESTION_MARK('?', 5),
/*  97 */   SLASH('/', 5),
/*  98 */   BACK_SLASH('\\', 5),
/*  99 */   LINE('|', 1),
/* 100 */   TILDE('~', 5),
/* 101 */   TICK('`', 2),
/* 102 */   PERIOD('.', 1),
/* 103 */   COMMA(',', 1),
/* 104 */   SPACE(' ', 3),
/* 105 */   DEFAULT('a', 4);
/*     */   
/*     */   private char character;
/*     */   private int length;
/*     */   
/*     */   Letter(char paramChar, int paramInt1) {
/* 111 */     this.character = paramChar;
/* 112 */     this.length = paramInt1;
/*     */   }
/*     */   
/*     */   public char getCharacter() {
/* 116 */     return this.character;
/*     */   }
/*     */   
/*     */   public int getLength() {
/* 120 */     return this.length;
/*     */   }
/*     */   
/*     */   public int getBoldLength() {
/* 124 */     if (this == SPACE) return getLength(); 
/* 125 */     return this.length + 1;
/*     */   }
/*     */   
/*     */   public static Letter from(char paramChar) {
/* 129 */     for (Letter letter : values()) {
/* 130 */       if (letter.getCharacter() == paramChar) return letter;
/*     */     
/*     */     } 
/* 133 */     return DEFAULT;
/*     */   }
/*     */   
/*     */   public static Letters from(String paramString) {
/* 137 */     Letters letters = new Letters();
/*     */     
/* 139 */     for (char c : paramString.toCharArray()) {
/* 140 */       letters.add(from(c));
/*     */     }
/*     */     
/* 143 */     return letters;
/*     */   }
/*     */   
/*     */   public static class Letters
/*     */     extends ArrayList<Letter> {
/*     */     public int getWidth() {
/* 149 */       return size() + stream().mapToInt(Letter::getLength).sum();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/visual/Letter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */