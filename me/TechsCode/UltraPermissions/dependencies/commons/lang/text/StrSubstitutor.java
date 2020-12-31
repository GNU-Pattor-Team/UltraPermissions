/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.text;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StrSubstitutor
/*     */ {
/*     */   public static final char DEFAULT_ESCAPE = '$';
/* 114 */   public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
/*     */ 
/*     */ 
/*     */   
/* 118 */   public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private char escapeChar;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StrMatcher prefixMatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StrMatcher suffixMatcher;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StrLookup variableResolver;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean enableSubstitutionInVariables;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String replace(Object paramObject, Map paramMap) {
/* 151 */     return (new StrSubstitutor(paramMap)).replace(paramObject);
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
/*     */   public static String replace(Object paramObject, Map paramMap, String paramString1, String paramString2) {
/* 167 */     return (new StrSubstitutor(paramMap, paramString1, paramString2)).replace(paramObject);
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
/*     */   public static String replace(Object paramObject, Properties paramProperties) {
/* 181 */     if (paramProperties == null) {
/* 182 */       return paramObject.toString();
/*     */     }
/* 184 */     HashMap hashMap = new HashMap();
/* 185 */     Enumeration enumeration = paramProperties.propertyNames();
/* 186 */     while (enumeration.hasMoreElements()) {
/*     */       
/* 188 */       String str1 = (String)enumeration.nextElement();
/* 189 */       String str2 = paramProperties.getProperty(str1);
/* 190 */       hashMap.put(str1, str2);
/*     */     } 
/* 192 */     return replace(paramObject, hashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String replaceSystemProperties(Object paramObject) {
/* 203 */     return (new StrSubstitutor(StrLookup.systemPropertiesLookup())).replace(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrSubstitutor() {
/* 212 */     this((StrLookup)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrSubstitutor(Map paramMap) {
/* 222 */     this(StrLookup.mapLookup(paramMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
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
/*     */   public StrSubstitutor(Map paramMap, String paramString1, String paramString2) {
/* 234 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, '$');
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
/*     */   public StrSubstitutor(Map paramMap, String paramString1, String paramString2, char paramChar) {
/* 247 */     this(StrLookup.mapLookup(paramMap), paramString1, paramString2, paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrSubstitutor(StrLookup paramStrLookup) {
/* 256 */     this(paramStrLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
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
/*     */   public StrSubstitutor(StrLookup paramStrLookup, String paramString1, String paramString2, char paramChar) {
/* 269 */     setVariableResolver(paramStrLookup);
/* 270 */     setVariablePrefix(paramString1);
/* 271 */     setVariableSuffix(paramString2);
/* 272 */     setEscapeChar(paramChar);
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
/*     */   public StrSubstitutor(StrLookup paramStrLookup, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2, char paramChar) {
/* 286 */     setVariableResolver(paramStrLookup);
/* 287 */     setVariablePrefixMatcher(paramStrMatcher1);
/* 288 */     setVariableSuffixMatcher(paramStrMatcher2);
/* 289 */     setEscapeChar(paramChar);
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
/*     */   public String replace(String paramString) {
/* 301 */     if (paramString == null) {
/* 302 */       return null;
/*     */     }
/* 304 */     StrBuilder strBuilder = new StrBuilder(paramString);
/* 305 */     if (!substitute(strBuilder, 0, paramString.length())) {
/* 306 */       return paramString;
/*     */     }
/* 308 */     return strBuilder.toString();
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
/*     */   public String replace(String paramString, int paramInt1, int paramInt2) {
/* 324 */     if (paramString == null) {
/* 325 */       return null;
/*     */     }
/* 327 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramString, paramInt1, paramInt2);
/* 328 */     if (!substitute(strBuilder, 0, paramInt2)) {
/* 329 */       return paramString.substring(paramInt1, paramInt1 + paramInt2);
/*     */     }
/* 331 */     return strBuilder.toString();
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
/*     */   public String replace(char[] paramArrayOfchar) {
/* 344 */     if (paramArrayOfchar == null) {
/* 345 */       return null;
/*     */     }
/* 347 */     StrBuilder strBuilder = (new StrBuilder(paramArrayOfchar.length)).append(paramArrayOfchar);
/* 348 */     substitute(strBuilder, 0, paramArrayOfchar.length);
/* 349 */     return strBuilder.toString();
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
/*     */   public String replace(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 366 */     if (paramArrayOfchar == null) {
/* 367 */       return null;
/*     */     }
/* 369 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramArrayOfchar, paramInt1, paramInt2);
/* 370 */     substitute(strBuilder, 0, paramInt2);
/* 371 */     return strBuilder.toString();
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
/*     */   public String replace(StringBuffer paramStringBuffer) {
/* 384 */     if (paramStringBuffer == null) {
/* 385 */       return null;
/*     */     }
/* 387 */     StrBuilder strBuilder = (new StrBuilder(paramStringBuffer.length())).append(paramStringBuffer);
/* 388 */     substitute(strBuilder, 0, strBuilder.length());
/* 389 */     return strBuilder.toString();
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
/*     */   public String replace(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/* 406 */     if (paramStringBuffer == null) {
/* 407 */       return null;
/*     */     }
/* 409 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/* 410 */     substitute(strBuilder, 0, paramInt2);
/* 411 */     return strBuilder.toString();
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
/*     */   public String replace(StrBuilder paramStrBuilder) {
/* 424 */     if (paramStrBuilder == null) {
/* 425 */       return null;
/*     */     }
/* 427 */     StrBuilder strBuilder = (new StrBuilder(paramStrBuilder.length())).append(paramStrBuilder);
/* 428 */     substitute(strBuilder, 0, strBuilder.length());
/* 429 */     return strBuilder.toString();
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
/*     */   public String replace(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/* 446 */     if (paramStrBuilder == null) {
/* 447 */       return null;
/*     */     }
/* 449 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStrBuilder, paramInt1, paramInt2);
/* 450 */     substitute(strBuilder, 0, paramInt2);
/* 451 */     return strBuilder.toString();
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
/*     */   public String replace(Object paramObject) {
/* 464 */     if (paramObject == null) {
/* 465 */       return null;
/*     */     }
/* 467 */     StrBuilder strBuilder = (new StrBuilder()).append(paramObject);
/* 468 */     substitute(strBuilder, 0, strBuilder.length());
/* 469 */     return strBuilder.toString();
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
/*     */   public boolean replaceIn(StringBuffer paramStringBuffer) {
/* 482 */     if (paramStringBuffer == null) {
/* 483 */       return false;
/*     */     }
/* 485 */     return replaceIn(paramStringBuffer, 0, paramStringBuffer.length());
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
/*     */   public boolean replaceIn(StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {
/* 502 */     if (paramStringBuffer == null) {
/* 503 */       return false;
/*     */     }
/* 505 */     StrBuilder strBuilder = (new StrBuilder(paramInt2)).append(paramStringBuffer, paramInt1, paramInt2);
/* 506 */     if (!substitute(strBuilder, 0, paramInt2)) {
/* 507 */       return false;
/*     */     }
/* 509 */     paramStringBuffer.replace(paramInt1, paramInt1 + paramInt2, strBuilder.toString());
/* 510 */     return true;
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
/*     */   public boolean replaceIn(StrBuilder paramStrBuilder) {
/* 522 */     if (paramStrBuilder == null) {
/* 523 */       return false;
/*     */     }
/* 525 */     return substitute(paramStrBuilder, 0, paramStrBuilder.length());
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
/*     */   public boolean replaceIn(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/* 541 */     if (paramStrBuilder == null) {
/* 542 */       return false;
/*     */     }
/* 544 */     return substitute(paramStrBuilder, paramInt1, paramInt2);
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
/*     */   protected boolean substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/* 563 */     return (substitute(paramStrBuilder, paramInt1, paramInt2, null) > 0);
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
/*     */   private int substitute(StrBuilder paramStrBuilder, int paramInt1, int paramInt2, List paramList) {
/* 579 */     StrMatcher strMatcher1 = getVariablePrefixMatcher();
/* 580 */     StrMatcher strMatcher2 = getVariableSuffixMatcher();
/* 581 */     char c = getEscapeChar();
/*     */     
/* 583 */     boolean bool1 = (paramList == null) ? true : false;
/* 584 */     boolean bool2 = false;
/* 585 */     int i = 0;
/* 586 */     char[] arrayOfChar = paramStrBuilder.buffer;
/* 587 */     int j = paramInt1 + paramInt2;
/* 588 */     int k = paramInt1;
/* 589 */     while (k < j) {
/* 590 */       int m = strMatcher1.isMatch(arrayOfChar, k, paramInt1, j);
/*     */       
/* 592 */       if (m == 0) {
/* 593 */         k++;
/*     */         continue;
/*     */       } 
/* 596 */       if (k > paramInt1 && arrayOfChar[k - 1] == c) {
/*     */         
/* 598 */         paramStrBuilder.deleteCharAt(k - 1);
/* 599 */         arrayOfChar = paramStrBuilder.buffer;
/* 600 */         i--;
/* 601 */         bool2 = true;
/* 602 */         j--;
/*     */         continue;
/*     */       } 
/* 605 */       int n = k;
/* 606 */       k += m;
/* 607 */       int i1 = 0;
/* 608 */       byte b = 0;
/* 609 */       while (k < j) {
/* 610 */         if (isEnableSubstitutionInVariables() && (i1 = strMatcher1.isMatch(arrayOfChar, k, paramInt1, j)) != 0) {
/*     */ 
/*     */ 
/*     */           
/* 614 */           b++;
/* 615 */           k += i1;
/*     */           
/*     */           continue;
/*     */         } 
/* 619 */         i1 = strMatcher2.isMatch(arrayOfChar, k, paramInt1, j);
/*     */         
/* 621 */         if (i1 == 0) {
/* 622 */           k++;
/*     */           continue;
/*     */         } 
/* 625 */         if (b == 0) {
/* 626 */           String str1 = new String(arrayOfChar, n + m, k - n - m);
/*     */ 
/*     */           
/* 629 */           if (isEnableSubstitutionInVariables()) {
/* 630 */             StrBuilder strBuilder = new StrBuilder(str1);
/* 631 */             substitute(strBuilder, 0, strBuilder.length());
/* 632 */             str1 = strBuilder.toString();
/*     */           } 
/* 634 */           k += i1;
/* 635 */           int i2 = k;
/*     */ 
/*     */           
/* 638 */           if (paramList == null) {
/* 639 */             paramList = new ArrayList();
/* 640 */             paramList.add(new String(arrayOfChar, paramInt1, paramInt2));
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 645 */           checkCyclicSubstitution(str1, paramList);
/* 646 */           paramList.add(str1);
/*     */ 
/*     */           
/* 649 */           String str2 = resolveVariable(str1, paramStrBuilder, n, i2);
/*     */           
/* 651 */           if (str2 != null) {
/*     */             
/* 653 */             int i3 = str2.length();
/* 654 */             paramStrBuilder.replace(n, i2, str2);
/* 655 */             bool2 = true;
/* 656 */             int i4 = substitute(paramStrBuilder, n, i3, paramList);
/*     */             
/* 658 */             i4 += i3 - i2 - n;
/*     */             
/* 660 */             k += i4;
/* 661 */             j += i4;
/* 662 */             i += i4;
/* 663 */             arrayOfChar = paramStrBuilder.buffer;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 668 */           paramList.remove(paramList.size() - 1);
/*     */           
/*     */           break;
/*     */         } 
/* 672 */         b--;
/* 673 */         k += i1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 680 */     if (bool1) {
/* 681 */       return bool2 ? 1 : 0;
/*     */     }
/* 683 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkCyclicSubstitution(String paramString, List paramList) {
/* 693 */     if (!paramList.contains(paramString)) {
/*     */       return;
/*     */     }
/* 696 */     StrBuilder strBuilder = new StrBuilder(256);
/* 697 */     strBuilder.append("Infinite loop in property interpolation of ");
/* 698 */     strBuilder.append(paramList.remove(0));
/* 699 */     strBuilder.append(": ");
/* 700 */     strBuilder.appendWithSeparators(paramList, "->");
/* 701 */     throw new IllegalStateException(strBuilder.toString());
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
/*     */   protected String resolveVariable(String paramString, StrBuilder paramStrBuilder, int paramInt1, int paramInt2) {
/* 722 */     StrLookup strLookup = getVariableResolver();
/* 723 */     if (strLookup == null) {
/* 724 */       return null;
/*     */     }
/* 726 */     return strLookup.lookup(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getEscapeChar() {
/* 737 */     return this.escapeChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscapeChar(char paramChar) {
/* 748 */     this.escapeChar = paramChar;
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
/*     */   public StrMatcher getVariablePrefixMatcher() {
/* 763 */     return this.prefixMatcher;
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
/*     */   public StrSubstitutor setVariablePrefixMatcher(StrMatcher paramStrMatcher) {
/* 778 */     if (paramStrMatcher == null) {
/* 779 */       throw new IllegalArgumentException("Variable prefix matcher must not be null!");
/*     */     }
/* 781 */     this.prefixMatcher = paramStrMatcher;
/* 782 */     return this;
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
/*     */   public StrSubstitutor setVariablePrefix(char paramChar) {
/* 796 */     return setVariablePrefixMatcher(StrMatcher.charMatcher(paramChar));
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
/*     */   public StrSubstitutor setVariablePrefix(String paramString) {
/* 810 */     if (paramString == null) {
/* 811 */       throw new IllegalArgumentException("Variable prefix must not be null!");
/*     */     }
/* 813 */     return setVariablePrefixMatcher(StrMatcher.stringMatcher(paramString));
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
/*     */   public StrMatcher getVariableSuffixMatcher() {
/* 828 */     return this.suffixMatcher;
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
/*     */   public StrSubstitutor setVariableSuffixMatcher(StrMatcher paramStrMatcher) {
/* 843 */     if (paramStrMatcher == null) {
/* 844 */       throw new IllegalArgumentException("Variable suffix matcher must not be null!");
/*     */     }
/* 846 */     this.suffixMatcher = paramStrMatcher;
/* 847 */     return this;
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
/*     */   public StrSubstitutor setVariableSuffix(char paramChar) {
/* 861 */     return setVariableSuffixMatcher(StrMatcher.charMatcher(paramChar));
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
/*     */   public StrSubstitutor setVariableSuffix(String paramString) {
/* 875 */     if (paramString == null) {
/* 876 */       throw new IllegalArgumentException("Variable suffix must not be null!");
/*     */     }
/* 878 */     return setVariableSuffixMatcher(StrMatcher.stringMatcher(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StrLookup getVariableResolver() {
/* 889 */     return this.variableResolver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVariableResolver(StrLookup paramStrLookup) {
/* 898 */     this.variableResolver = paramStrLookup;
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
/*     */   public boolean isEnableSubstitutionInVariables() {
/* 910 */     return this.enableSubstitutionInVariables;
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
/*     */   public void setEnableSubstitutionInVariables(boolean paramBoolean) {
/* 924 */     this.enableSubstitutionInVariables = paramBoolean;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/text/StrSubstitutor.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */