/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.text;
/*      */ 
/*      */ import java.io.Reader;
/*      */ import java.io.Writer;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.SystemUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StrBuilder
/*      */   implements Cloneable
/*      */ {
/*      */   static final int CAPACITY = 32;
/*      */   private static final long serialVersionUID = 7628716375283629643L;
/*      */   protected char[] buffer;
/*      */   protected int size;
/*      */   private String newLine;
/*      */   private String nullText;
/*      */   
/*      */   public StrBuilder() {
/*  102 */     this(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(int paramInt) {
/*  112 */     if (paramInt <= 0) {
/*  113 */       paramInt = 32;
/*      */     }
/*  115 */     this.buffer = new char[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(String paramString) {
/*  126 */     if (paramString == null) {
/*  127 */       this.buffer = new char[32];
/*      */     } else {
/*  129 */       this.buffer = new char[paramString.length() + 32];
/*  130 */       append(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNewLineText() {
/*  141 */     return this.newLine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNewLineText(String paramString) {
/*  151 */     this.newLine = paramString;
/*  152 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNullText() {
/*  162 */     return this.nullText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNullText(String paramString) {
/*  172 */     if (paramString != null && paramString.length() == 0) {
/*  173 */       paramString = null;
/*      */     }
/*  175 */     this.nullText = paramString;
/*  176 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  186 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setLength(int paramInt) {
/*  198 */     if (paramInt < 0) {
/*  199 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  201 */     if (paramInt < this.size) {
/*  202 */       this.size = paramInt;
/*  203 */     } else if (paramInt > this.size) {
/*  204 */       ensureCapacity(paramInt);
/*  205 */       int i = this.size;
/*  206 */       int j = paramInt;
/*  207 */       this.size = paramInt;
/*  208 */       for (int k = i; k < j; k++) {
/*  209 */         this.buffer[k] = Character.MIN_VALUE;
/*      */       }
/*      */     } 
/*  212 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int capacity() {
/*  222 */     return this.buffer.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder ensureCapacity(int paramInt) {
/*  232 */     if (paramInt > this.buffer.length) {
/*  233 */       char[] arrayOfChar = this.buffer;
/*  234 */       this.buffer = new char[paramInt * 2];
/*  235 */       System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
/*      */     } 
/*  237 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder minimizeCapacity() {
/*  246 */     if (this.buffer.length > length()) {
/*  247 */       char[] arrayOfChar = this.buffer;
/*  248 */       this.buffer = new char[length()];
/*  249 */       System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
/*      */     } 
/*  251 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  264 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  276 */     return (this.size == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder clear() {
/*  291 */     this.size = 0;
/*  292 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char charAt(int paramInt) {
/*  306 */     if (paramInt < 0 || paramInt >= length()) {
/*  307 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  309 */     return this.buffer[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setCharAt(int paramInt, char paramChar) {
/*  323 */     if (paramInt < 0 || paramInt >= length()) {
/*  324 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  326 */     this.buffer[paramInt] = paramChar;
/*  327 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteCharAt(int paramInt) {
/*  340 */     if (paramInt < 0 || paramInt >= this.size) {
/*  341 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  343 */     deleteImpl(paramInt, paramInt + 1, 1);
/*  344 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray() {
/*  354 */     if (this.size == 0) {
/*  355 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  357 */     char[] arrayOfChar = new char[this.size];
/*  358 */     System.arraycopy(this.buffer, 0, arrayOfChar, 0, this.size);
/*  359 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray(int paramInt1, int paramInt2) {
/*  373 */     paramInt2 = validateRange(paramInt1, paramInt2);
/*  374 */     int i = paramInt2 - paramInt1;
/*  375 */     if (i == 0) {
/*  376 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  378 */     char[] arrayOfChar = new char[i];
/*  379 */     System.arraycopy(this.buffer, paramInt1, arrayOfChar, 0, i);
/*  380 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] getChars(char[] paramArrayOfchar) {
/*  390 */     int i = length();
/*  391 */     if (paramArrayOfchar == null || paramArrayOfchar.length < i) {
/*  392 */       paramArrayOfchar = new char[i];
/*      */     }
/*  394 */     System.arraycopy(this.buffer, 0, paramArrayOfchar, 0, i);
/*  395 */     return paramArrayOfchar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3) {
/*  409 */     if (paramInt1 < 0) {
/*  410 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/*  412 */     if (paramInt2 < 0 || paramInt2 > length()) {
/*  413 */       throw new StringIndexOutOfBoundsException(paramInt2);
/*      */     }
/*  415 */     if (paramInt1 > paramInt2) {
/*  416 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/*  418 */     System.arraycopy(this.buffer, paramInt1, paramArrayOfchar, paramInt3, paramInt2 - paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendNewLine() {
/*  432 */     if (this.newLine == null) {
/*  433 */       append(SystemUtils.LINE_SEPARATOR);
/*  434 */       return this;
/*      */     } 
/*  436 */     return append(this.newLine);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendNull() {
/*  445 */     if (this.nullText == null) {
/*  446 */       return this;
/*      */     }
/*  448 */     return append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(Object paramObject) {
/*  459 */     if (paramObject == null) {
/*  460 */       return appendNull();
/*      */     }
/*  462 */     return append(paramObject.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(String paramString) {
/*  473 */     if (paramString == null) {
/*  474 */       return appendNull();
/*      */     }
/*  476 */     int i = paramString.length();
/*  477 */     if (i > 0) {
/*  478 */       int j = length();
/*  479 */       ensureCapacity(j + i);
/*  480 */       paramString.getChars(0, i, this.buffer, j);
/*  481 */       this.size += i;
/*      */     } 
/*  483 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(String paramString, int paramInt1, int paramInt2) {
/*  496 */     if (paramString == null) {
/*  497 */       return appendNull();
/*      */     }
/*  499 */     if (paramInt1 < 0 || paramInt1 > paramString.length()) {
/*  500 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  502 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramString.length()) {
/*  503 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  505 */     if (paramInt2 > 0) {
/*  506 */       int i = length();
/*  507 */       ensureCapacity(i + paramInt2);
/*  508 */       paramString.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  509 */       this.size += paramInt2;
/*      */     } 
/*  511 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuffer paramStringBuffer) {
/*  522 */     if (paramStringBuffer == null) {
/*  523 */       return appendNull();
/*      */     }
/*  525 */     int i = paramStringBuffer.length();
/*  526 */     if (i > 0) {
/*  527 */       int j = length();
/*  528 */       ensureCapacity(j + i);
/*  529 */       paramStringBuffer.getChars(0, i, this.buffer, j);
/*  530 */       this.size += i;
/*      */     } 
/*  532 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/*  545 */     if (paramStringBuffer == null) {
/*  546 */       return appendNull();
/*      */     }
/*  548 */     if (paramInt1 < 0 || paramInt1 > paramStringBuffer.length()) {
/*  549 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  551 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStringBuffer.length()) {
/*  552 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  554 */     if (paramInt2 > 0) {
/*  555 */       int i = length();
/*  556 */       ensureCapacity(i + paramInt2);
/*  557 */       paramStringBuffer.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  558 */       this.size += paramInt2;
/*      */     } 
/*  560 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StrBuilder paramStrBuilder) {
/*  571 */     if (paramStrBuilder == null) {
/*  572 */       return appendNull();
/*      */     }
/*  574 */     int i = paramStrBuilder.length();
/*  575 */     if (i > 0) {
/*  576 */       int j = length();
/*  577 */       ensureCapacity(j + i);
/*  578 */       System.arraycopy(paramStrBuilder.buffer, 0, this.buffer, j, i);
/*  579 */       this.size += i;
/*      */     } 
/*  581 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/*  594 */     if (paramStrBuilder == null) {
/*  595 */       return appendNull();
/*      */     }
/*  597 */     if (paramInt1 < 0 || paramInt1 > paramStrBuilder.length()) {
/*  598 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  600 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramStrBuilder.length()) {
/*  601 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  603 */     if (paramInt2 > 0) {
/*  604 */       int i = length();
/*  605 */       ensureCapacity(i + paramInt2);
/*  606 */       paramStrBuilder.getChars(paramInt1, paramInt1 + paramInt2, this.buffer, i);
/*  607 */       this.size += paramInt2;
/*      */     } 
/*  609 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char[] paramArrayOfchar) {
/*  620 */     if (paramArrayOfchar == null) {
/*  621 */       return appendNull();
/*      */     }
/*  623 */     int i = paramArrayOfchar.length;
/*  624 */     if (i > 0) {
/*  625 */       int j = length();
/*  626 */       ensureCapacity(j + i);
/*  627 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, j, i);
/*  628 */       this.size += i;
/*      */     } 
/*  630 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  643 */     if (paramArrayOfchar == null) {
/*  644 */       return appendNull();
/*      */     }
/*  646 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfchar.length) {
/*  647 */       throw new StringIndexOutOfBoundsException("Invalid startIndex: " + paramInt2);
/*      */     }
/*  649 */     if (paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/*  650 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt2);
/*      */     }
/*  652 */     if (paramInt2 > 0) {
/*  653 */       int i = length();
/*  654 */       ensureCapacity(i + paramInt2);
/*  655 */       System.arraycopy(paramArrayOfchar, paramInt1, this.buffer, i, paramInt2);
/*  656 */       this.size += paramInt2;
/*      */     } 
/*  658 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(boolean paramBoolean) {
/*  668 */     if (paramBoolean) {
/*  669 */       ensureCapacity(this.size + 4);
/*  670 */       this.buffer[this.size++] = 't';
/*  671 */       this.buffer[this.size++] = 'r';
/*  672 */       this.buffer[this.size++] = 'u';
/*  673 */       this.buffer[this.size++] = 'e';
/*      */     } else {
/*  675 */       ensureCapacity(this.size + 5);
/*  676 */       this.buffer[this.size++] = 'f';
/*  677 */       this.buffer[this.size++] = 'a';
/*  678 */       this.buffer[this.size++] = 'l';
/*  679 */       this.buffer[this.size++] = 's';
/*  680 */       this.buffer[this.size++] = 'e';
/*      */     } 
/*  682 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char paramChar) {
/*  692 */     int i = length();
/*  693 */     ensureCapacity(i + 1);
/*  694 */     this.buffer[this.size++] = paramChar;
/*  695 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(int paramInt) {
/*  705 */     return append(String.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(long paramLong) {
/*  715 */     return append(String.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(float paramFloat) {
/*  725 */     return append(String.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(double paramDouble) {
/*  735 */     return append(String.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(Object paramObject) {
/*  748 */     return append(paramObject).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(String paramString) {
/*  760 */     return append(paramString).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(String paramString, int paramInt1, int paramInt2) {
/*  774 */     return append(paramString, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuffer paramStringBuffer) {
/*  786 */     return append(paramStringBuffer).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/*  800 */     return append(paramStringBuffer, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StrBuilder paramStrBuilder) {
/*  812 */     return append(paramStrBuilder).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/*  826 */     return append(paramStrBuilder, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char[] paramArrayOfchar) {
/*  838 */     return append(paramArrayOfchar).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  852 */     return append(paramArrayOfchar, paramInt1, paramInt2).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(boolean paramBoolean) {
/*  863 */     return append(paramBoolean).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char paramChar) {
/*  874 */     return append(paramChar).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(int paramInt) {
/*  885 */     return append(paramInt).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(long paramLong) {
/*  896 */     return append(paramLong).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(float paramFloat) {
/*  907 */     return append(paramFloat).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(double paramDouble) {
/*  918 */     return append(paramDouble).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendAll(Object[] paramArrayOfObject) {
/*  932 */     if (paramArrayOfObject != null && paramArrayOfObject.length > 0) {
/*  933 */       for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*  934 */         append(paramArrayOfObject[b]);
/*      */       }
/*      */     }
/*  937 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendAll(Collection paramCollection) {
/*  950 */     if (paramCollection != null && paramCollection.size() > 0) {
/*  951 */       Iterator iterator = paramCollection.iterator();
/*  952 */       while (iterator.hasNext()) {
/*  953 */         append(iterator.next());
/*      */       }
/*      */     } 
/*  956 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendAll(Iterator paramIterator) {
/*  969 */     if (paramIterator != null) {
/*  970 */       while (paramIterator.hasNext()) {
/*  971 */         append(paramIterator.next());
/*      */       }
/*      */     }
/*  974 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendWithSeparators(Object[] paramArrayOfObject, String paramString) {
/*  989 */     if (paramArrayOfObject != null && paramArrayOfObject.length > 0) {
/*  990 */       paramString = (paramString == null) ? "" : paramString;
/*  991 */       append(paramArrayOfObject[0]);
/*  992 */       for (byte b = 1; b < paramArrayOfObject.length; b++) {
/*  993 */         append(paramString);
/*  994 */         append(paramArrayOfObject[b]);
/*      */       } 
/*      */     } 
/*  997 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendWithSeparators(Collection paramCollection, String paramString) {
/* 1011 */     if (paramCollection != null && paramCollection.size() > 0) {
/* 1012 */       paramString = (paramString == null) ? "" : paramString;
/* 1013 */       Iterator iterator = paramCollection.iterator();
/* 1014 */       while (iterator.hasNext()) {
/* 1015 */         append(iterator.next());
/* 1016 */         if (iterator.hasNext()) {
/* 1017 */           append(paramString);
/*      */         }
/*      */       } 
/*      */     } 
/* 1021 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendWithSeparators(Iterator paramIterator, String paramString) {
/* 1035 */     if (paramIterator != null) {
/* 1036 */       paramString = (paramString == null) ? "" : paramString;
/* 1037 */       while (paramIterator.hasNext()) {
/* 1038 */         append(paramIterator.next());
/* 1039 */         if (paramIterator.hasNext()) {
/* 1040 */           append(paramString);
/*      */         }
/*      */       } 
/*      */     } 
/* 1044 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(String paramString) {
/* 1069 */     return appendSeparator(paramString, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(String paramString1, String paramString2) {
/* 1100 */     String str = isEmpty() ? paramString2 : paramString1;
/* 1101 */     if (str != null) {
/* 1102 */       append(str);
/*      */     }
/* 1104 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(char paramChar) {
/* 1127 */     if (size() > 0) {
/* 1128 */       append(paramChar);
/*      */     }
/* 1130 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(char paramChar1, char paramChar2) {
/* 1145 */     if (size() > 0) {
/* 1146 */       append(paramChar1);
/*      */     } else {
/*      */       
/* 1149 */       append(paramChar2);
/*      */     } 
/* 1151 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(String paramString, int paramInt) {
/* 1175 */     if (paramString != null && paramInt > 0) {
/* 1176 */       append(paramString);
/*      */     }
/* 1178 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(char paramChar, int paramInt) {
/* 1202 */     if (paramInt > 0) {
/* 1203 */       append(paramChar);
/*      */     }
/* 1205 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendPadding(int paramInt, char paramChar) {
/* 1217 */     if (paramInt >= 0) {
/* 1218 */       ensureCapacity(this.size + paramInt);
/* 1219 */       for (byte b = 0; b < paramInt; b++) {
/* 1220 */         this.buffer[this.size++] = paramChar;
/*      */       }
/*      */     } 
/* 1223 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadLeft(Object paramObject, int paramInt, char paramChar) {
/* 1239 */     if (paramInt > 0) {
/* 1240 */       ensureCapacity(this.size + paramInt);
/* 1241 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/* 1242 */       if (str == null) {
/* 1243 */         str = "";
/*      */       }
/* 1245 */       int i = str.length();
/* 1246 */       if (i >= paramInt) {
/* 1247 */         str.getChars(i - paramInt, i, this.buffer, this.size);
/*      */       } else {
/* 1249 */         int j = paramInt - i;
/* 1250 */         for (byte b = 0; b < j; b++) {
/* 1251 */           this.buffer[this.size + b] = paramChar;
/*      */         }
/* 1253 */         str.getChars(0, i, this.buffer, this.size + j);
/*      */       } 
/* 1255 */       this.size += paramInt;
/*      */     } 
/* 1257 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadLeft(int paramInt1, int paramInt2, char paramChar) {
/* 1271 */     return appendFixedWidthPadLeft(String.valueOf(paramInt1), paramInt2, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadRight(Object paramObject, int paramInt, char paramChar) {
/* 1286 */     if (paramInt > 0) {
/* 1287 */       ensureCapacity(this.size + paramInt);
/* 1288 */       String str = (paramObject == null) ? getNullText() : paramObject.toString();
/* 1289 */       if (str == null) {
/* 1290 */         str = "";
/*      */       }
/* 1292 */       int i = str.length();
/* 1293 */       if (i >= paramInt) {
/* 1294 */         str.getChars(0, paramInt, this.buffer, this.size);
/*      */       } else {
/* 1296 */         int j = paramInt - i;
/* 1297 */         str.getChars(0, i, this.buffer, this.size);
/* 1298 */         for (byte b = 0; b < j; b++) {
/* 1299 */           this.buffer[this.size + i + b] = paramChar;
/*      */         }
/*      */       } 
/* 1302 */       this.size += paramInt;
/*      */     } 
/* 1304 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendFixedWidthPadRight(int paramInt1, int paramInt2, char paramChar) {
/* 1318 */     return appendFixedWidthPadRight(String.valueOf(paramInt1), paramInt2, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, Object paramObject) {
/* 1332 */     if (paramObject == null) {
/* 1333 */       return insert(paramInt, this.nullText);
/*      */     }
/* 1335 */     return insert(paramInt, paramObject.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, String paramString) {
/* 1348 */     validateIndex(paramInt);
/* 1349 */     if (paramString == null) {
/* 1350 */       paramString = this.nullText;
/*      */     }
/* 1352 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1353 */     if (b) {
/* 1354 */       int i = this.size + b;
/* 1355 */       ensureCapacity(i);
/* 1356 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + b, this.size - paramInt);
/* 1357 */       this.size = i;
/* 1358 */       paramString.getChars(0, b, this.buffer, paramInt);
/*      */     } 
/* 1360 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, char[] paramArrayOfchar) {
/* 1373 */     validateIndex(paramInt);
/* 1374 */     if (paramArrayOfchar == null) {
/* 1375 */       return insert(paramInt, this.nullText);
/*      */     }
/* 1377 */     int i = paramArrayOfchar.length;
/* 1378 */     if (i > 0) {
/* 1379 */       ensureCapacity(this.size + i);
/* 1380 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + i, this.size - paramInt);
/* 1381 */       System.arraycopy(paramArrayOfchar, 0, this.buffer, paramInt, i);
/* 1382 */       this.size += i;
/*      */     } 
/* 1384 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
/* 1399 */     validateIndex(paramInt1);
/* 1400 */     if (paramArrayOfchar == null) {
/* 1401 */       return insert(paramInt1, this.nullText);
/*      */     }
/* 1403 */     if (paramInt2 < 0 || paramInt2 > paramArrayOfchar.length) {
/* 1404 */       throw new StringIndexOutOfBoundsException("Invalid offset: " + paramInt2);
/*      */     }
/* 1406 */     if (paramInt3 < 0 || paramInt2 + paramInt3 > paramArrayOfchar.length) {
/* 1407 */       throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt3);
/*      */     }
/* 1409 */     if (paramInt3 > 0) {
/* 1410 */       ensureCapacity(this.size + paramInt3);
/* 1411 */       System.arraycopy(this.buffer, paramInt1, this.buffer, paramInt1 + paramInt3, this.size - paramInt1);
/* 1412 */       System.arraycopy(paramArrayOfchar, paramInt2, this.buffer, paramInt1, paramInt3);
/* 1413 */       this.size += paramInt3;
/*      */     } 
/* 1415 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, boolean paramBoolean) {
/* 1427 */     validateIndex(paramInt);
/* 1428 */     if (paramBoolean) {
/* 1429 */       ensureCapacity(this.size + 4);
/* 1430 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 4, this.size - paramInt);
/* 1431 */       this.buffer[paramInt++] = 't';
/* 1432 */       this.buffer[paramInt++] = 'r';
/* 1433 */       this.buffer[paramInt++] = 'u';
/* 1434 */       this.buffer[paramInt] = 'e';
/* 1435 */       this.size += 4;
/*      */     } else {
/* 1437 */       ensureCapacity(this.size + 5);
/* 1438 */       System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 5, this.size - paramInt);
/* 1439 */       this.buffer[paramInt++] = 'f';
/* 1440 */       this.buffer[paramInt++] = 'a';
/* 1441 */       this.buffer[paramInt++] = 'l';
/* 1442 */       this.buffer[paramInt++] = 's';
/* 1443 */       this.buffer[paramInt] = 'e';
/* 1444 */       this.size += 5;
/*      */     } 
/* 1446 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, char paramChar) {
/* 1458 */     validateIndex(paramInt);
/* 1459 */     ensureCapacity(this.size + 1);
/* 1460 */     System.arraycopy(this.buffer, paramInt, this.buffer, paramInt + 1, this.size - paramInt);
/* 1461 */     this.buffer[paramInt] = paramChar;
/* 1462 */     this.size++;
/* 1463 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt1, int paramInt2) {
/* 1475 */     return insert(paramInt1, String.valueOf(paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, long paramLong) {
/* 1487 */     return insert(paramInt, String.valueOf(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, float paramFloat) {
/* 1499 */     return insert(paramInt, String.valueOf(paramFloat));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder insert(int paramInt, double paramDouble) {
/* 1511 */     return insert(paramInt, String.valueOf(paramDouble));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void deleteImpl(int paramInt1, int paramInt2, int paramInt3) {
/* 1524 */     System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1, this.size - paramInt2);
/* 1525 */     this.size -= paramInt3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder delete(int paramInt1, int paramInt2) {
/* 1538 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1539 */     int i = paramInt2 - paramInt1;
/* 1540 */     if (i > 0) {
/* 1541 */       deleteImpl(paramInt1, paramInt2, i);
/*      */     }
/* 1543 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(char paramChar) {
/* 1554 */     for (int i = 0; i < this.size; i++) {
/* 1555 */       if (this.buffer[i] == paramChar) {
/* 1556 */         int j = i; do {  }
/* 1557 */         while (++i < this.size && 
/* 1558 */           this.buffer[i] == paramChar);
/*      */ 
/*      */ 
/*      */         
/* 1562 */         int k = i - j;
/* 1563 */         deleteImpl(j, i, k);
/* 1564 */         i -= k;
/*      */       } 
/*      */     } 
/* 1567 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(char paramChar) {
/* 1577 */     for (byte b = 0; b < this.size; b++) {
/* 1578 */       if (this.buffer[b] == paramChar) {
/* 1579 */         deleteImpl(b, b + 1, 1);
/*      */         break;
/*      */       } 
/*      */     } 
/* 1583 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(String paramString) {
/* 1594 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1595 */     if (b) {
/* 1596 */       int i = indexOf(paramString, 0);
/* 1597 */       while (i >= 0) {
/* 1598 */         deleteImpl(i, i + b, b);
/* 1599 */         i = indexOf(paramString, i);
/*      */       } 
/*      */     } 
/* 1602 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(String paramString) {
/* 1612 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1613 */     if (b) {
/* 1614 */       int i = indexOf(paramString, 0);
/* 1615 */       if (i >= 0) {
/* 1616 */         deleteImpl(i, i + b, b);
/*      */       }
/*      */     } 
/* 1619 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(StrMatcher paramStrMatcher) {
/* 1634 */     return replace(paramStrMatcher, null, 0, this.size, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(StrMatcher paramStrMatcher) {
/* 1648 */     return replace(paramStrMatcher, null, 0, this.size, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void replaceImpl(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4) {
/* 1663 */     int i = this.size - paramInt3 + paramInt4;
/* 1664 */     if (paramInt4 != paramInt3) {
/* 1665 */       ensureCapacity(i);
/* 1666 */       System.arraycopy(this.buffer, paramInt2, this.buffer, paramInt1 + paramInt4, this.size - paramInt2);
/* 1667 */       this.size = i;
/*      */     } 
/* 1669 */     if (paramInt4 > 0) {
/* 1670 */       paramString.getChars(0, paramInt4, this.buffer, paramInt1);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replace(int paramInt1, int paramInt2, String paramString) {
/* 1686 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1687 */     boolean bool = (paramString == null) ? false : paramString.length();
/* 1688 */     replaceImpl(paramInt1, paramInt2, paramInt2 - paramInt1, paramString, bool);
/* 1689 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceAll(char paramChar1, char paramChar2) {
/* 1702 */     if (paramChar1 != paramChar2) {
/* 1703 */       for (byte b = 0; b < this.size; b++) {
/* 1704 */         if (this.buffer[b] == paramChar1) {
/* 1705 */           this.buffer[b] = paramChar2;
/*      */         }
/*      */       } 
/*      */     }
/* 1709 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(char paramChar1, char paramChar2) {
/* 1721 */     if (paramChar1 != paramChar2) {
/* 1722 */       for (byte b = 0; b < this.size; b++) {
/* 1723 */         if (this.buffer[b] == paramChar1) {
/* 1724 */           this.buffer[b] = paramChar2;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 1729 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceAll(String paramString1, String paramString2) {
/* 1741 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 1742 */     if (b) {
/* 1743 */       byte b1 = (paramString2 == null) ? 0 : paramString2.length();
/* 1744 */       int i = indexOf(paramString1, 0);
/* 1745 */       while (i >= 0) {
/* 1746 */         replaceImpl(i, i + b, b, paramString2, b1);
/* 1747 */         i = indexOf(paramString1, i + b1);
/*      */       } 
/*      */     } 
/* 1750 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(String paramString1, String paramString2) {
/* 1761 */     byte b = (paramString1 == null) ? 0 : paramString1.length();
/* 1762 */     if (b) {
/* 1763 */       int i = indexOf(paramString1, 0);
/* 1764 */       if (i >= 0) {
/* 1765 */         boolean bool = (paramString2 == null) ? false : paramString2.length();
/* 1766 */         replaceImpl(i, i + b, b, paramString2, bool);
/*      */       } 
/*      */     } 
/* 1769 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceAll(StrMatcher paramStrMatcher, String paramString) {
/* 1785 */     return replace(paramStrMatcher, paramString, 0, this.size, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(StrMatcher paramStrMatcher, String paramString) {
/* 1800 */     return replace(paramStrMatcher, paramString, 0, this.size, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replace(StrMatcher paramStrMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 1823 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1824 */     return replaceImpl(paramStrMatcher, paramString, paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrBuilder replaceImpl(StrMatcher paramStrMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 1845 */     if (paramStrMatcher == null || this.size == 0) {
/* 1846 */       return this;
/*      */     }
/* 1848 */     byte b = (paramString == null) ? 0 : paramString.length();
/* 1849 */     char[] arrayOfChar = this.buffer;
/* 1850 */     for (int i = paramInt1; i < paramInt2 && paramInt3 != 0; i++) {
/* 1851 */       int j = paramStrMatcher.isMatch(arrayOfChar, i, paramInt1, paramInt2);
/* 1852 */       if (j > 0) {
/* 1853 */         replaceImpl(i, i + j, j, paramString, b);
/* 1854 */         paramInt2 = paramInt2 - j + b;
/* 1855 */         i = i + b - 1;
/* 1856 */         if (paramInt3 > 0) {
/* 1857 */           paramInt3--;
/*      */         }
/*      */       } 
/*      */     } 
/* 1861 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder reverse() {
/* 1871 */     if (this.size == 0) {
/* 1872 */       return this;
/*      */     }
/*      */     
/* 1875 */     int i = this.size / 2;
/* 1876 */     char[] arrayOfChar = this.buffer; byte b; int j;
/* 1877 */     for (b = 0, j = this.size - 1; b < i; b++, j--) {
/* 1878 */       char c = arrayOfChar[b];
/* 1879 */       arrayOfChar[b] = arrayOfChar[j];
/* 1880 */       arrayOfChar[j] = c;
/*      */     } 
/* 1882 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder trim() {
/* 1893 */     if (this.size == 0) {
/* 1894 */       return this;
/*      */     }
/* 1896 */     int i = this.size;
/* 1897 */     char[] arrayOfChar = this.buffer;
/* 1898 */     byte b = 0;
/* 1899 */     while (b < i && arrayOfChar[b] <= ' ') {
/* 1900 */       b++;
/*      */     }
/* 1902 */     while (b < i && arrayOfChar[i - 1] <= ' ') {
/* 1903 */       i--;
/*      */     }
/* 1905 */     if (i < this.size) {
/* 1906 */       delete(i, this.size);
/*      */     }
/* 1908 */     if (b > 0) {
/* 1909 */       delete(0, b);
/*      */     }
/* 1911 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean startsWith(String paramString) {
/* 1924 */     if (paramString == null) {
/* 1925 */       return false;
/*      */     }
/* 1927 */     int i = paramString.length();
/* 1928 */     if (i == 0) {
/* 1929 */       return true;
/*      */     }
/* 1931 */     if (i > this.size) {
/* 1932 */       return false;
/*      */     }
/* 1934 */     for (byte b = 0; b < i; b++) {
/* 1935 */       if (this.buffer[b] != paramString.charAt(b)) {
/* 1936 */         return false;
/*      */       }
/*      */     } 
/* 1939 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean endsWith(String paramString) {
/* 1951 */     if (paramString == null) {
/* 1952 */       return false;
/*      */     }
/* 1954 */     int i = paramString.length();
/* 1955 */     if (i == 0) {
/* 1956 */       return true;
/*      */     }
/* 1958 */     if (i > this.size) {
/* 1959 */       return false;
/*      */     }
/* 1961 */     int j = this.size - i;
/* 1962 */     for (byte b = 0; b < i; b++, j++) {
/* 1963 */       if (this.buffer[j] != paramString.charAt(b)) {
/* 1964 */         return false;
/*      */       }
/*      */     } 
/* 1967 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String substring(int paramInt) {
/* 1979 */     return substring(paramInt, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String substring(int paramInt1, int paramInt2) {
/* 1996 */     paramInt2 = validateRange(paramInt1, paramInt2);
/* 1997 */     return new String(this.buffer, paramInt1, paramInt2 - paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String leftString(int paramInt) {
/* 2013 */     if (paramInt <= 0)
/* 2014 */       return ""; 
/* 2015 */     if (paramInt >= this.size) {
/* 2016 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2018 */     return new String(this.buffer, 0, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String rightString(int paramInt) {
/* 2035 */     if (paramInt <= 0)
/* 2036 */       return ""; 
/* 2037 */     if (paramInt >= this.size) {
/* 2038 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2040 */     return new String(this.buffer, this.size - paramInt, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String midString(int paramInt1, int paramInt2) {
/* 2061 */     if (paramInt1 < 0) {
/* 2062 */       paramInt1 = 0;
/*      */     }
/* 2064 */     if (paramInt2 <= 0 || paramInt1 >= this.size) {
/* 2065 */       return "";
/*      */     }
/* 2067 */     if (this.size <= paramInt1 + paramInt2) {
/* 2068 */       return new String(this.buffer, paramInt1, this.size - paramInt1);
/*      */     }
/* 2070 */     return new String(this.buffer, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(char paramChar) {
/* 2082 */     char[] arrayOfChar = this.buffer;
/* 2083 */     for (byte b = 0; b < this.size; b++) {
/* 2084 */       if (arrayOfChar[b] == paramChar) {
/* 2085 */         return true;
/*      */       }
/*      */     } 
/* 2088 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(String paramString) {
/* 2098 */     return (indexOf(paramString, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(StrMatcher paramStrMatcher) {
/* 2113 */     return (indexOf(paramStrMatcher, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char paramChar) {
/* 2124 */     return indexOf(paramChar, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char paramChar, int paramInt) {
/* 2135 */     paramInt = (paramInt < 0) ? 0 : paramInt;
/* 2136 */     if (paramInt >= this.size) {
/* 2137 */       return -1;
/*      */     }
/* 2139 */     char[] arrayOfChar = this.buffer;
/* 2140 */     for (int i = paramInt; i < this.size; i++) {
/* 2141 */       if (arrayOfChar[i] == paramChar) {
/* 2142 */         return i;
/*      */       }
/*      */     } 
/* 2145 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(String paramString) {
/* 2157 */     return indexOf(paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(String paramString, int paramInt) {
/* 2171 */     paramInt = (paramInt < 0) ? 0 : paramInt;
/* 2172 */     if (paramString == null || paramInt >= this.size) {
/* 2173 */       return -1;
/*      */     }
/* 2175 */     int i = paramString.length();
/* 2176 */     if (i == 1) {
/* 2177 */       return indexOf(paramString.charAt(0), paramInt);
/*      */     }
/* 2179 */     if (i == 0) {
/* 2180 */       return paramInt;
/*      */     }
/* 2182 */     if (i > this.size) {
/* 2183 */       return -1;
/*      */     }
/* 2185 */     char[] arrayOfChar = this.buffer;
/* 2186 */     int j = this.size - i + 1;
/*      */     
/* 2188 */     for (int k = paramInt; k < j; k++) {
/* 2189 */       byte b = 0; while (true) { if (b < i) {
/* 2190 */           if (paramString.charAt(b) != arrayOfChar[k + b])
/*      */             break;  b++;
/*      */           continue;
/*      */         } 
/* 2194 */         return k; }
/*      */     
/* 2196 */     }  return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(StrMatcher paramStrMatcher) {
/* 2210 */     return indexOf(paramStrMatcher, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(StrMatcher paramStrMatcher, int paramInt) {
/* 2226 */     paramInt = (paramInt < 0) ? 0 : paramInt;
/* 2227 */     if (paramStrMatcher == null || paramInt >= this.size) {
/* 2228 */       return -1;
/*      */     }
/* 2230 */     int i = this.size;
/* 2231 */     char[] arrayOfChar = this.buffer;
/* 2232 */     for (int j = paramInt; j < i; j++) {
/* 2233 */       if (paramStrMatcher.isMatch(arrayOfChar, j, paramInt, i) > 0) {
/* 2234 */         return j;
/*      */       }
/*      */     } 
/* 2237 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char paramChar) {
/* 2248 */     return lastIndexOf(paramChar, this.size - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char paramChar, int paramInt) {
/* 2259 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2260 */     if (paramInt < 0) {
/* 2261 */       return -1;
/*      */     }
/* 2263 */     for (int i = paramInt; i >= 0; i--) {
/* 2264 */       if (this.buffer[i] == paramChar) {
/* 2265 */         return i;
/*      */       }
/*      */     } 
/* 2268 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(String paramString) {
/* 2280 */     return lastIndexOf(paramString, this.size - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(String paramString, int paramInt) {
/* 2294 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2295 */     if (paramString == null || paramInt < 0) {
/* 2296 */       return -1;
/*      */     }
/* 2298 */     int i = paramString.length();
/* 2299 */     if (i > 0 && i <= this.size) {
/* 2300 */       if (i == 1) {
/* 2301 */         return lastIndexOf(paramString.charAt(0), paramInt);
/*      */       }
/*      */ 
/*      */       
/* 2305 */       for (int j = paramInt - i + 1; j >= 0; j--) {
/* 2306 */         byte b = 0; while (true) { if (b < i) {
/* 2307 */             if (paramString.charAt(b) != this.buffer[j + b])
/*      */               break;  b++;
/*      */             continue;
/*      */           } 
/* 2311 */           return j; }
/*      */       
/*      */       } 
/* 2314 */     } else if (i == 0) {
/* 2315 */       return paramInt;
/*      */     } 
/* 2317 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(StrMatcher paramStrMatcher) {
/* 2331 */     return lastIndexOf(paramStrMatcher, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(StrMatcher paramStrMatcher, int paramInt) {
/* 2347 */     paramInt = (paramInt >= this.size) ? (this.size - 1) : paramInt;
/* 2348 */     if (paramStrMatcher == null || paramInt < 0) {
/* 2349 */       return -1;
/*      */     }
/* 2351 */     char[] arrayOfChar = this.buffer;
/* 2352 */     int i = paramInt + 1;
/* 2353 */     for (int j = paramInt; j >= 0; j--) {
/* 2354 */       if (paramStrMatcher.isMatch(arrayOfChar, j, 0, i) > 0) {
/* 2355 */         return j;
/*      */       }
/*      */     } 
/* 2358 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer asTokenizer() {
/* 2395 */     return new StrBuilderTokenizer(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Reader asReader() {
/* 2419 */     return new StrBuilderReader(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Writer asWriter() {
/* 2444 */     return new StrBuilderWriter(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equalsIgnoreCase(StrBuilder paramStrBuilder) {
/* 2486 */     if (this == paramStrBuilder) {
/* 2487 */       return true;
/*      */     }
/* 2489 */     if (this.size != paramStrBuilder.size) {
/* 2490 */       return false;
/*      */     }
/* 2492 */     char[] arrayOfChar1 = this.buffer;
/* 2493 */     char[] arrayOfChar2 = paramStrBuilder.buffer;
/* 2494 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2495 */       char c1 = arrayOfChar1[i];
/* 2496 */       char c2 = arrayOfChar2[i];
/* 2497 */       if (c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
/* 2498 */         return false;
/*      */       }
/*      */     } 
/* 2501 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(StrBuilder paramStrBuilder) {
/* 2512 */     if (this == paramStrBuilder) {
/* 2513 */       return true;
/*      */     }
/* 2515 */     if (this.size != paramStrBuilder.size) {
/* 2516 */       return false;
/*      */     }
/* 2518 */     char[] arrayOfChar1 = this.buffer;
/* 2519 */     char[] arrayOfChar2 = paramStrBuilder.buffer;
/* 2520 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2521 */       if (arrayOfChar1[i] != arrayOfChar2[i]) {
/* 2522 */         return false;
/*      */       }
/*      */     } 
/* 2525 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 2536 */     if (paramObject instanceof StrBuilder) {
/* 2537 */       return equals((StrBuilder)paramObject);
/*      */     }
/* 2539 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 2548 */     char[] arrayOfChar = this.buffer;
/* 2549 */     int i = 0;
/* 2550 */     for (int j = this.size - 1; j >= 0; j--) {
/* 2551 */       i = 31 * i + arrayOfChar[j];
/*      */     }
/* 2553 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 2567 */     return new String(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer toStringBuffer() {
/* 2577 */     return (new StringBuffer(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object clone() {
/* 2588 */     StrBuilder strBuilder = (StrBuilder)super.clone();
/* 2589 */     strBuilder.buffer = new char[this.buffer.length];
/* 2590 */     System.arraycopy(this.buffer, 0, strBuilder.buffer, 0, this.buffer.length);
/* 2591 */     return strBuilder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int validateRange(int paramInt1, int paramInt2) {
/* 2605 */     if (paramInt1 < 0) {
/* 2606 */       throw new StringIndexOutOfBoundsException(paramInt1);
/*      */     }
/* 2608 */     if (paramInt2 > this.size) {
/* 2609 */       paramInt2 = this.size;
/*      */     }
/* 2611 */     if (paramInt1 > paramInt2) {
/* 2612 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/* 2614 */     return paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateIndex(int paramInt) {
/* 2624 */     if (paramInt < 0 || paramInt > this.size) {
/* 2625 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class StrBuilderTokenizer
/*      */     extends StrTokenizer
/*      */   {
/*      */     private final StrBuilder this$0;
/*      */ 
/*      */     
/*      */     StrBuilderTokenizer(StrBuilder this$0) {
/* 2638 */       this.this$0 = this$0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected List tokenize(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 2644 */       if (param1ArrayOfchar == null) {
/* 2645 */         return super.tokenize(this.this$0.buffer, 0, this.this$0.size());
/*      */       }
/* 2647 */       return super.tokenize(param1ArrayOfchar, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getContent() {
/* 2653 */       String str = super.getContent();
/* 2654 */       if (str == null) {
/* 2655 */         return this.this$0.toString();
/*      */       }
/* 2657 */       return str;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class StrBuilderReader
/*      */     extends Reader
/*      */   {
/*      */     private int pos;
/*      */ 
/*      */     
/*      */     private int mark;
/*      */     
/*      */     private final StrBuilder this$0;
/*      */ 
/*      */     
/*      */     StrBuilderReader(StrBuilder this$0) {
/* 2675 */       this.this$0 = this$0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public int read() {
/* 2686 */       if (!ready()) {
/* 2687 */         return -1;
/*      */       }
/* 2689 */       return this.this$0.charAt(this.pos++);
/*      */     }
/*      */ 
/*      */     
/*      */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 2694 */       if (param1Int1 < 0 || param1Int2 < 0 || param1Int1 > param1ArrayOfchar.length || param1Int1 + param1Int2 > param1ArrayOfchar.length || param1Int1 + param1Int2 < 0)
/*      */       {
/* 2696 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 2698 */       if (param1Int2 == 0) {
/* 2699 */         return 0;
/*      */       }
/* 2701 */       if (this.pos >= this.this$0.size()) {
/* 2702 */         return -1;
/*      */       }
/* 2704 */       if (this.pos + param1Int2 > this.this$0.size()) {
/* 2705 */         param1Int2 = this.this$0.size() - this.pos;
/*      */       }
/* 2707 */       this.this$0.getChars(this.pos, this.pos + param1Int2, param1ArrayOfchar, param1Int1);
/* 2708 */       this.pos += param1Int2;
/* 2709 */       return param1Int2;
/*      */     }
/*      */ 
/*      */     
/*      */     public long skip(long param1Long) {
/* 2714 */       if (this.pos + param1Long > this.this$0.size()) {
/* 2715 */         param1Long = (this.this$0.size() - this.pos);
/*      */       }
/* 2717 */       if (param1Long < 0L) {
/* 2718 */         return 0L;
/*      */       }
/* 2720 */       this.pos = (int)(this.pos + param1Long);
/* 2721 */       return param1Long;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean ready() {
/* 2726 */       return (this.pos < this.this$0.size());
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean markSupported() {
/* 2731 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void mark(int param1Int) {
/* 2736 */       this.mark = this.pos;
/*      */     }
/*      */ 
/*      */     
/*      */     public void reset() {
/* 2741 */       this.pos = this.mark;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class StrBuilderWriter
/*      */     extends Writer
/*      */   {
/*      */     private final StrBuilder this$0;
/*      */ 
/*      */     
/*      */     StrBuilderWriter(StrBuilder this$0) {
/* 2754 */       this.this$0 = this$0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void flush() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(int param1Int) {
/* 2770 */       this.this$0.append((char)param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar) {
/* 2775 */       this.this$0.append(param1ArrayOfchar);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 2780 */       this.this$0.append(param1ArrayOfchar, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(String param1String) {
/* 2785 */       this.this$0.append(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(String param1String, int param1Int1, int param1Int2) {
/* 2790 */       this.this$0.append(param1String, param1Int1, param1Int2);
/*      */     }
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/text/StrBuilder.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */