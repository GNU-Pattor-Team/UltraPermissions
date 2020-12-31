/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.NoSuchElementException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StrTokenizer
/*      */   implements ListIterator, Cloneable
/*      */ {
/*   93 */   private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*   94 */     CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.commaMatcher());
/*   95 */     CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*   96 */     CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*   97 */     CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*   98 */     CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*   99 */     CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*  101 */   private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*  102 */     TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.tabMatcher());
/*  103 */     TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*  104 */     TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*  105 */     TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*  106 */     TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  107 */     TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] chars;
/*      */   
/*      */   private String[] tokens;
/*      */   
/*      */   private int tokenPos;
/*      */   
/*  118 */   private StrMatcher delimMatcher = StrMatcher.splitMatcher();
/*      */   
/*  120 */   private StrMatcher quoteMatcher = StrMatcher.noneMatcher();
/*      */   
/*  122 */   private StrMatcher ignoredMatcher = StrMatcher.noneMatcher();
/*      */   
/*  124 */   private StrMatcher trimmerMatcher = StrMatcher.noneMatcher();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean emptyAsNull = false;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ignoreEmptyTokens = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getCSVClone() {
/*  139 */     return (StrTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
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
/*      */   public static StrTokenizer getCSVInstance() {
/*  152 */     return getCSVClone();
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
/*      */   public static StrTokenizer getCSVInstance(String paramString) {
/*  165 */     StrTokenizer strTokenizer = getCSVClone();
/*  166 */     strTokenizer.reset(paramString);
/*  167 */     return strTokenizer;
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
/*      */   public static StrTokenizer getCSVInstance(char[] paramArrayOfchar) {
/*  180 */     StrTokenizer strTokenizer = getCSVClone();
/*  181 */     strTokenizer.reset(paramArrayOfchar);
/*  182 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getTSVClone() {
/*  191 */     return (StrTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
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
/*      */   public static StrTokenizer getTSVInstance() {
/*  204 */     return getTSVClone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(String paramString) {
/*  215 */     StrTokenizer strTokenizer = getTSVClone();
/*  216 */     strTokenizer.reset(paramString);
/*  217 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(char[] paramArrayOfchar) {
/*  228 */     StrTokenizer strTokenizer = getTSVClone();
/*  229 */     strTokenizer.reset(paramArrayOfchar);
/*  230 */     return strTokenizer;
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
/*      */   public StrTokenizer() {
/*  242 */     this.chars = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString) {
/*  253 */     if (paramString != null) {
/*  254 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  256 */       this.chars = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString, char paramChar) {
/*  267 */     this(paramString);
/*  268 */     setDelimiterChar(paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString1, String paramString2) {
/*  278 */     this(paramString1);
/*  279 */     setDelimiterString(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String paramString, StrMatcher paramStrMatcher) {
/*  289 */     this(paramString);
/*  290 */     setDelimiterMatcher(paramStrMatcher);
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
/*      */   public StrTokenizer(String paramString, char paramChar1, char paramChar2) {
/*  302 */     this(paramString, paramChar1);
/*  303 */     setQuoteChar(paramChar2);
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
/*      */   public StrTokenizer(String paramString, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2) {
/*  315 */     this(paramString, paramStrMatcher1);
/*  316 */     setQuoteMatcher(paramStrMatcher2);
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
/*      */   public StrTokenizer(char[] paramArrayOfchar) {
/*  330 */     this.chars = paramArrayOfchar;
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
/*      */   public StrTokenizer(char[] paramArrayOfchar, char paramChar) {
/*  343 */     this(paramArrayOfchar);
/*  344 */     setDelimiterChar(paramChar);
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
/*      */   public StrTokenizer(char[] paramArrayOfchar, String paramString) {
/*  357 */     this(paramArrayOfchar);
/*  358 */     setDelimiterString(paramString);
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
/*      */   public StrTokenizer(char[] paramArrayOfchar, StrMatcher paramStrMatcher) {
/*  371 */     this(paramArrayOfchar);
/*  372 */     setDelimiterMatcher(paramStrMatcher);
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
/*      */   public StrTokenizer(char[] paramArrayOfchar, char paramChar1, char paramChar2) {
/*  387 */     this(paramArrayOfchar, paramChar1);
/*  388 */     setQuoteChar(paramChar2);
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
/*      */   public StrTokenizer(char[] paramArrayOfchar, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2) {
/*  403 */     this(paramArrayOfchar, paramStrMatcher1);
/*  404 */     setQuoteMatcher(paramStrMatcher2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  415 */     checkTokenized();
/*  416 */     return this.tokens.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String nextToken() {
/*  427 */     if (hasNext()) {
/*  428 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  430 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previousToken() {
/*  439 */     if (hasPrevious()) {
/*  440 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  442 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getTokenArray() {
/*  451 */     checkTokenized();
/*  452 */     return (String[])this.tokens.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List getTokenList() {
/*  461 */     checkTokenized();
/*  462 */     ArrayList arrayList = new ArrayList(this.tokens.length);
/*  463 */     for (byte b = 0; b < this.tokens.length; b++) {
/*  464 */       arrayList.add(this.tokens[b]);
/*      */     }
/*  466 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer reset() {
/*  477 */     this.tokenPos = 0;
/*  478 */     this.tokens = null;
/*  479 */     return this;
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
/*      */   public StrTokenizer reset(String paramString) {
/*  491 */     reset();
/*  492 */     if (paramString != null) {
/*  493 */       this.chars = paramString.toCharArray();
/*      */     } else {
/*  495 */       this.chars = null;
/*      */     } 
/*  497 */     return this;
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
/*      */   public StrTokenizer reset(char[] paramArrayOfchar) {
/*  512 */     reset();
/*  513 */     this.chars = paramArrayOfchar;
/*  514 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasNext() {
/*  525 */     checkTokenized();
/*  526 */     return (this.tokenPos < this.tokens.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object next() {
/*  536 */     if (hasNext()) {
/*  537 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  539 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextIndex() {
/*  548 */     return this.tokenPos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPrevious() {
/*  557 */     checkTokenized();
/*  558 */     return (this.tokenPos > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object previous() {
/*  567 */     if (hasPrevious()) {
/*  568 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  570 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int previousIndex() {
/*  579 */     return this.tokenPos - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove() {
/*  588 */     throw new UnsupportedOperationException("remove() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(Object paramObject) {
/*  597 */     throw new UnsupportedOperationException("set() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(Object paramObject) {
/*  606 */     throw new UnsupportedOperationException("add() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkTokenized() {
/*  615 */     if (this.tokens == null) {
/*  616 */       if (this.chars == null) {
/*      */         
/*  618 */         List list = tokenize(null, 0, 0);
/*  619 */         this.tokens = (String[])list.toArray((Object[])new String[list.size()]);
/*      */       } else {
/*  621 */         List list = tokenize(this.chars, 0, this.chars.length);
/*  622 */         this.tokens = (String[])list.toArray((Object[])new String[list.size()]);
/*      */       } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List tokenize(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  648 */     if (paramArrayOfchar == null || paramInt2 == 0) {
/*  649 */       return Collections.EMPTY_LIST;
/*      */     }
/*  651 */     StrBuilder strBuilder = new StrBuilder();
/*  652 */     ArrayList arrayList = new ArrayList();
/*  653 */     int i = paramInt1;
/*      */ 
/*      */     
/*  656 */     while (i >= 0 && i < paramInt2) {
/*      */       
/*  658 */       i = readNextToken(paramArrayOfchar, i, paramInt2, strBuilder, arrayList);
/*      */ 
/*      */       
/*  661 */       if (i >= paramInt2) {
/*  662 */         addToken(arrayList, "");
/*      */       }
/*      */     } 
/*  665 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addToken(List paramList, String paramString) {
/*  675 */     if (paramString == null || paramString.length() == 0) {
/*  676 */       if (isIgnoreEmptyTokens()) {
/*      */         return;
/*      */       }
/*  679 */       if (isEmptyTokenAsNull()) {
/*  680 */         paramString = null;
/*      */       }
/*      */     } 
/*  683 */     paramList.add(paramString);
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
/*      */   private int readNextToken(char[] paramArrayOfchar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List paramList) {
/*  700 */     while (paramInt1 < paramInt2) {
/*  701 */       int k = Math.max(getIgnoredMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2), getTrimmerMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2));
/*      */ 
/*      */       
/*  704 */       if (k == 0 || getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0 || getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2) > 0) {
/*      */         break;
/*      */       }
/*      */ 
/*      */       
/*  709 */       paramInt1 += k;
/*      */     } 
/*      */ 
/*      */     
/*  713 */     if (paramInt1 >= paramInt2) {
/*  714 */       addToken(paramList, "");
/*  715 */       return -1;
/*      */     } 
/*      */ 
/*      */     
/*  719 */     int i = getDelimiterMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  720 */     if (i > 0) {
/*  721 */       addToken(paramList, "");
/*  722 */       return paramInt1 + i;
/*      */     } 
/*      */ 
/*      */     
/*  726 */     int j = getQuoteMatcher().isMatch(paramArrayOfchar, paramInt1, paramInt1, paramInt2);
/*  727 */     if (j > 0) {
/*  728 */       return readWithQuotes(paramArrayOfchar, paramInt1 + j, paramInt2, paramStrBuilder, paramList, paramInt1, j);
/*      */     }
/*  730 */     return readWithQuotes(paramArrayOfchar, paramInt1, paramInt2, paramStrBuilder, paramList, 0, 0);
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
/*      */   private int readWithQuotes(char[] paramArrayOfchar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List paramList, int paramInt3, int paramInt4) {
/*  752 */     paramStrBuilder.clear();
/*  753 */     int i = paramInt1;
/*  754 */     boolean bool = (paramInt4 > 0) ? true : false;
/*  755 */     int j = 0;
/*      */     
/*  757 */     while (i < paramInt2) {
/*      */ 
/*      */ 
/*      */       
/*  761 */       if (bool) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  768 */         if (isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  769 */           if (isQuote(paramArrayOfchar, i + paramInt4, paramInt2, paramInt3, paramInt4)) {
/*      */             
/*  771 */             paramStrBuilder.append(paramArrayOfchar, i, paramInt4);
/*  772 */             i += paramInt4 * 2;
/*  773 */             j = paramStrBuilder.size();
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*  778 */           bool = false;
/*  779 */           i += paramInt4;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  784 */         paramStrBuilder.append(paramArrayOfchar[i++]);
/*  785 */         j = paramStrBuilder.size();
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  791 */       int k = getDelimiterMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  792 */       if (k > 0) {
/*      */         
/*  794 */         addToken(paramList, paramStrBuilder.substring(0, j));
/*  795 */         return i + k;
/*      */       } 
/*      */ 
/*      */       
/*  799 */       if (paramInt4 > 0 && 
/*  800 */         isQuote(paramArrayOfchar, i, paramInt2, paramInt3, paramInt4)) {
/*  801 */         bool = true;
/*  802 */         i += paramInt4;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  808 */       int m = getIgnoredMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  809 */       if (m > 0) {
/*  810 */         i += m;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  817 */       int n = getTrimmerMatcher().isMatch(paramArrayOfchar, i, paramInt1, paramInt2);
/*  818 */       if (n > 0) {
/*  819 */         paramStrBuilder.append(paramArrayOfchar, i, n);
/*  820 */         i += n;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  825 */       paramStrBuilder.append(paramArrayOfchar[i++]);
/*  826 */       j = paramStrBuilder.size();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  831 */     addToken(paramList, paramStrBuilder.substring(0, j));
/*  832 */     return -1;
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
/*      */   private boolean isQuote(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  847 */     for (byte b = 0; b < paramInt4; b++) {
/*  848 */       if (paramInt1 + b >= paramInt2 || paramArrayOfchar[paramInt1 + b] != paramArrayOfchar[paramInt3 + b]) {
/*  849 */         return false;
/*      */       }
/*      */     } 
/*  852 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getDelimiterMatcher() {
/*  863 */     return this.delimMatcher;
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
/*      */   public StrTokenizer setDelimiterMatcher(StrMatcher paramStrMatcher) {
/*  875 */     if (paramStrMatcher == null) {
/*  876 */       this.delimMatcher = StrMatcher.noneMatcher();
/*      */     } else {
/*  878 */       this.delimMatcher = paramStrMatcher;
/*      */     } 
/*  880 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterChar(char paramChar) {
/*  890 */     return setDelimiterMatcher(StrMatcher.charMatcher(paramChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterString(String paramString) {
/*  900 */     return setDelimiterMatcher(StrMatcher.stringMatcher(paramString));
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
/*      */   public StrMatcher getQuoteMatcher() {
/*  915 */     return this.quoteMatcher;
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
/*      */   public StrTokenizer setQuoteMatcher(StrMatcher paramStrMatcher) {
/*  928 */     if (paramStrMatcher != null) {
/*  929 */       this.quoteMatcher = paramStrMatcher;
/*      */     }
/*  931 */     return this;
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
/*      */   public StrTokenizer setQuoteChar(char paramChar) {
/*  944 */     return setQuoteMatcher(StrMatcher.charMatcher(paramChar));
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
/*      */   public StrMatcher getIgnoredMatcher() {
/*  959 */     return this.ignoredMatcher;
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
/*      */   public StrTokenizer setIgnoredMatcher(StrMatcher paramStrMatcher) {
/*  972 */     if (paramStrMatcher != null) {
/*  973 */       this.ignoredMatcher = paramStrMatcher;
/*      */     }
/*  975 */     return this;
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
/*      */   public StrTokenizer setIgnoredChar(char paramChar) {
/*  988 */     return setIgnoredMatcher(StrMatcher.charMatcher(paramChar));
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
/*      */   public StrMatcher getTrimmerMatcher() {
/* 1003 */     return this.trimmerMatcher;
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
/*      */   public StrTokenizer setTrimmerMatcher(StrMatcher paramStrMatcher) {
/* 1016 */     if (paramStrMatcher != null) {
/* 1017 */       this.trimmerMatcher = paramStrMatcher;
/*      */     }
/* 1019 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmptyTokenAsNull() {
/* 1030 */     return this.emptyAsNull;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setEmptyTokenAsNull(boolean paramBoolean) {
/* 1041 */     this.emptyAsNull = paramBoolean;
/* 1042 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIgnoreEmptyTokens() {
/* 1053 */     return this.ignoreEmptyTokens;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setIgnoreEmptyTokens(boolean paramBoolean) {
/* 1064 */     this.ignoreEmptyTokens = paramBoolean;
/* 1065 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContent() {
/* 1075 */     if (this.chars == null) {
/* 1076 */       return null;
/*      */     }
/* 1078 */     return new String(this.chars);
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
/*      */   public Object clone() {
/*      */     try {
/* 1091 */       return cloneReset();
/* 1092 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 1093 */       return null;
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
/*      */   Object cloneReset() {
/* 1106 */     StrTokenizer strTokenizer = (StrTokenizer)super.clone();
/* 1107 */     if (strTokenizer.chars != null) {
/* 1108 */       strTokenizer.chars = (char[])strTokenizer.chars.clone();
/*      */     }
/* 1110 */     strTokenizer.reset();
/* 1111 */     return strTokenizer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1121 */     if (this.tokens == null) {
/* 1122 */       return "StrTokenizer[not tokenized yet]";
/*      */     }
/* 1124 */     return "StrTokenizer" + getTokenList();
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/text/StrTokenizer.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */