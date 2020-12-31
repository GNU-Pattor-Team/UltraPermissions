/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language.bm;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Scanner;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Rule
/*     */ {
/*     */   public static final class Phoneme
/*     */     implements PhonemeExpr
/*     */   {
/*  85 */     public static final Comparator<Phoneme> COMPARATOR = new Comparator<Phoneme>()
/*     */       {
/*     */         public int compare(Rule.Phoneme param2Phoneme1, Rule.Phoneme param2Phoneme2) {
/*  88 */           for (byte b = 0; b < param2Phoneme1.phonemeText.length(); b++) {
/*  89 */             if (b >= param2Phoneme2.phonemeText.length()) {
/*  90 */               return 1;
/*     */             }
/*  92 */             int i = param2Phoneme1.phonemeText.charAt(b) - param2Phoneme2.phonemeText.charAt(b);
/*  93 */             if (i != 0) {
/*  94 */               return i;
/*     */             }
/*     */           } 
/*     */           
/*  98 */           if (param2Phoneme1.phonemeText.length() < param2Phoneme2.phonemeText.length()) {
/*  99 */             return -1;
/*     */           }
/*     */           
/* 102 */           return 0;
/*     */         }
/*     */       };
/*     */     
/*     */     private final StringBuilder phonemeText;
/*     */     private final Languages.LanguageSet languages;
/*     */     
/*     */     public Phoneme(CharSequence param1CharSequence, Languages.LanguageSet param1LanguageSet) {
/* 110 */       this.phonemeText = new StringBuilder(param1CharSequence);
/* 111 */       this.languages = param1LanguageSet;
/*     */     }
/*     */     
/*     */     public Phoneme(Phoneme param1Phoneme1, Phoneme param1Phoneme2) {
/* 115 */       this(param1Phoneme1.phonemeText, param1Phoneme1.languages);
/* 116 */       this.phonemeText.append(param1Phoneme2.phonemeText);
/*     */     }
/*     */     
/*     */     public Phoneme(Phoneme param1Phoneme1, Phoneme param1Phoneme2, Languages.LanguageSet param1LanguageSet) {
/* 120 */       this(param1Phoneme1.phonemeText, param1LanguageSet);
/* 121 */       this.phonemeText.append(param1Phoneme2.phonemeText);
/*     */     }
/*     */     
/*     */     public Phoneme append(CharSequence param1CharSequence) {
/* 125 */       this.phonemeText.append(param1CharSequence);
/* 126 */       return this;
/*     */     }
/*     */     
/*     */     public Languages.LanguageSet getLanguages() {
/* 130 */       return this.languages;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterable<Phoneme> getPhonemes() {
/* 135 */       return Collections.singleton(this);
/*     */     }
/*     */     
/*     */     public CharSequence getPhonemeText() {
/* 139 */       return this.phonemeText;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public Phoneme join(Phoneme param1Phoneme) {
/* 151 */       return new Phoneme(this.phonemeText.toString() + param1Phoneme.phonemeText.toString(), this.languages
/* 152 */           .restrictTo(param1Phoneme.languages));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Phoneme mergeWithLanguage(Languages.LanguageSet param1LanguageSet) {
/* 163 */       return new Phoneme(this.phonemeText.toString(), this.languages.merge(param1LanguageSet));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 168 */       return this.phonemeText.toString() + "[" + this.languages + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class PhonemeList
/*     */     implements PhonemeExpr
/*     */   {
/*     */     private final List<Rule.Phoneme> phonemes;
/*     */ 
/*     */     
/*     */     public PhonemeList(List<Rule.Phoneme> param1List) {
/* 180 */       this.phonemes = param1List;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Rule.Phoneme> getPhonemes() {
/* 185 */       return this.phonemes;
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
/* 196 */   public static final RPattern ALL_STRINGS_RMATCHER = new RPattern()
/*     */     {
/*     */       public boolean isMatch(CharSequence param1CharSequence) {
/* 199 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public static final String ALL = "ALL";
/*     */   
/*     */   private static final String DOUBLE_QUOTE = "\"";
/*     */   
/*     */   private static final String HASH_INCLUDE = "#include";
/* 209 */   private static final Map<NameType, Map<RuleType, Map<String, Map<String, List<Rule>>>>> RULES = new EnumMap<>(NameType.class); private final RPattern lContext;
/*     */   private final String pattern;
/*     */   
/*     */   static {
/* 213 */     for (NameType nameType : NameType.values()) {
/* 214 */       EnumMap<RuleType, Object> enumMap = new EnumMap<>(RuleType.class);
/*     */ 
/*     */       
/* 217 */       for (RuleType ruleType : RuleType.values()) {
/* 218 */         HashMap<Object, Object> hashMap = new HashMap<>();
/*     */         
/* 220 */         Languages languages = Languages.getInstance(nameType);
/* 221 */         for (String str : languages.getLanguages()) {
/* 222 */           try (Scanner null = createScanner(nameType, ruleType, str)) {
/* 223 */             hashMap.put(str, parseRules(scanner, createResourceName(nameType, ruleType, str)));
/* 224 */           } catch (IllegalStateException illegalStateException) {
/* 225 */             throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, str), illegalStateException);
/*     */           } 
/*     */         } 
/* 228 */         if (!ruleType.equals(RuleType.RULES)) {
/* 229 */           try (Scanner null = createScanner(nameType, ruleType, "common")) {
/* 230 */             hashMap.put("common", parseRules(scanner, createResourceName(nameType, ruleType, "common")));
/*     */           } 
/*     */         }
/*     */         
/* 234 */         enumMap.put(ruleType, Collections.unmodifiableMap(hashMap));
/*     */       } 
/*     */       
/* 237 */       RULES.put(nameType, (Map)Collections.unmodifiableMap(enumMap));
/*     */     } 
/*     */   }
/*     */   private final PhonemeExpr phoneme; private final RPattern rContext;
/*     */   private static boolean contains(CharSequence paramCharSequence, char paramChar) {
/* 242 */     for (byte b = 0; b < paramCharSequence.length(); b++) {
/* 243 */       if (paramCharSequence.charAt(b) == paramChar) {
/* 244 */         return true;
/*     */       }
/*     */     } 
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   private static String createResourceName(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 251 */     return String.format("me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/%s_%s_%s.txt", new Object[] { paramNameType
/* 252 */           .getName(), paramRuleType.getName(), paramString });
/*     */   }
/*     */   
/*     */   private static Scanner createScanner(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 256 */     String str = createResourceName(paramNameType, paramRuleType, paramString);
/* 257 */     InputStream inputStream = Languages.class.getClassLoader().getResourceAsStream(str);
/*     */     
/* 259 */     if (inputStream == null) {
/* 260 */       throw new IllegalArgumentException("Unable to load resource: " + str);
/*     */     }
/*     */     
/* 263 */     return new Scanner(inputStream, "UTF-8");
/*     */   }
/*     */   
/*     */   private static Scanner createScanner(String paramString) {
/* 267 */     String str = String.format("me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/%s.txt", new Object[] { paramString });
/* 268 */     InputStream inputStream = Languages.class.getClassLoader().getResourceAsStream(str);
/*     */     
/* 270 */     if (inputStream == null) {
/* 271 */       throw new IllegalArgumentException("Unable to load resource: " + str);
/*     */     }
/*     */     
/* 274 */     return new Scanner(inputStream, "UTF-8");
/*     */   }
/*     */   
/*     */   private static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 278 */     if (paramCharSequence2.length() > paramCharSequence1.length()) {
/* 279 */       return false;
/*     */     }
/* 281 */     for (int i = paramCharSequence1.length() - 1, j = paramCharSequence2.length() - 1; j >= 0; i--, j--) {
/* 282 */       if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(j)) {
/* 283 */         return false;
/*     */       }
/*     */     } 
/* 286 */     return true;
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
/*     */   public static List<Rule> getInstance(NameType paramNameType, RuleType paramRuleType, Languages.LanguageSet paramLanguageSet) {
/* 302 */     Map<String, List<Rule>> map = getInstanceMap(paramNameType, paramRuleType, paramLanguageSet);
/* 303 */     ArrayList<Rule> arrayList = new ArrayList();
/* 304 */     for (List<Rule> list : map.values()) {
/* 305 */       arrayList.addAll(list);
/*     */     }
/* 307 */     return arrayList;
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
/*     */   public static List<Rule> getInstance(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 322 */     return getInstance(paramNameType, paramRuleType, Languages.LanguageSet.from(new HashSet<>(Arrays.asList(new String[] { paramString }))));
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
/*     */   public static Map<String, List<Rule>> getInstanceMap(NameType paramNameType, RuleType paramRuleType, Languages.LanguageSet paramLanguageSet) {
/* 339 */     return paramLanguageSet.isSingleton() ? getInstanceMap(paramNameType, paramRuleType, paramLanguageSet.getAny()) : 
/* 340 */       getInstanceMap(paramNameType, paramRuleType, "any");
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
/*     */   public static Map<String, List<Rule>> getInstanceMap(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 357 */     Map<String, List<Rule>> map = (Map)((Map)((Map)RULES.get(paramNameType)).get(paramRuleType)).get(paramString);
/*     */     
/* 359 */     if (map == null) {
/* 360 */       throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", new Object[] { paramNameType
/* 361 */               .getName(), paramRuleType.getName(), paramString }));
/*     */     }
/*     */     
/* 364 */     return map;
/*     */   }
/*     */   
/*     */   private static Phoneme parsePhoneme(String paramString) {
/* 368 */     int i = paramString.indexOf("[");
/* 369 */     if (i >= 0) {
/* 370 */       if (!paramString.endsWith("]")) {
/* 371 */         throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
/*     */       }
/* 373 */       String str1 = paramString.substring(0, i);
/* 374 */       String str2 = paramString.substring(i + 1, paramString.length() - 1);
/* 375 */       HashSet<String> hashSet = new HashSet(Arrays.asList((Object[])str2.split("[+]")));
/*     */       
/* 377 */       return new Phoneme(str1, Languages.LanguageSet.from(hashSet));
/*     */     } 
/* 379 */     return new Phoneme(paramString, Languages.ANY_LANGUAGE);
/*     */   }
/*     */   
/*     */   private static PhonemeExpr parsePhonemeExpr(String paramString) {
/* 383 */     if (paramString.startsWith("(")) {
/* 384 */       if (!paramString.endsWith(")")) {
/* 385 */         throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
/*     */       }
/*     */       
/* 388 */       ArrayList<Phoneme> arrayList = new ArrayList();
/* 389 */       String str = paramString.substring(1, paramString.length() - 1);
/* 390 */       for (String str1 : str.split("[|]")) {
/* 391 */         arrayList.add(parsePhoneme(str1));
/*     */       }
/* 393 */       if (str.startsWith("|") || str.endsWith("|")) {
/* 394 */         arrayList.add(new Phoneme("", Languages.ANY_LANGUAGE));
/*     */       }
/*     */       
/* 397 */       return new PhonemeList(arrayList);
/*     */     } 
/* 399 */     return parsePhoneme(paramString);
/*     */   }
/*     */   
/*     */   private static Map<String, List<Rule>> parseRules(Scanner paramScanner, final String location) {
/* 403 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 404 */     byte b = 0;
/*     */     
/* 406 */     boolean bool = false;
/* 407 */     while (paramScanner.hasNextLine()) {
/* 408 */       b++;
/* 409 */       String str1 = paramScanner.nextLine();
/* 410 */       String str2 = str1;
/*     */       
/* 412 */       if (bool) {
/* 413 */         if (str2.endsWith("*/"))
/* 414 */           bool = false; 
/*     */         continue;
/*     */       } 
/* 417 */       if (str2.startsWith("/*")) {
/* 418 */         bool = true;
/*     */         continue;
/*     */       } 
/* 421 */       int i = str2.indexOf("//");
/* 422 */       if (i >= 0) {
/* 423 */         str2 = str2.substring(0, i);
/*     */       }
/*     */ 
/*     */       
/* 427 */       str2 = str2.trim();
/*     */       
/* 429 */       if (str2.length() == 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 433 */       if (str2.startsWith("#include")) {
/*     */         
/* 435 */         String str = str2.substring("#include".length()).trim();
/* 436 */         if (str.contains(" ")) {
/* 437 */           throw new IllegalArgumentException("Malformed import statement '" + str1 + "' in " + location);
/*     */         }
/*     */         
/* 440 */         try (Scanner null = createScanner(str)) {
/* 441 */           hashMap.putAll(parseRules(scanner, location + "->" + str));
/*     */         } 
/*     */         continue;
/*     */       } 
/* 445 */       String[] arrayOfString = str2.split("\\s+");
/* 446 */       if (arrayOfString.length != 4) {
/* 447 */         throw new IllegalArgumentException("Malformed rule statement split into " + arrayOfString.length + " parts: " + str1 + " in " + location);
/*     */       }
/*     */       
/*     */       try {
/* 451 */         final String pat = stripQuotes(arrayOfString[0]);
/* 452 */         final String lCon = stripQuotes(arrayOfString[1]);
/* 453 */         final String rCon = stripQuotes(arrayOfString[2]);
/* 454 */         PhonemeExpr phonemeExpr = parsePhonemeExpr(stripQuotes(arrayOfString[3]));
/* 455 */         final byte cLine = b;
/* 456 */         Rule rule = new Rule(str3, str4, str5, phonemeExpr) {
/* 457 */             private final int myLine = cLine;
/* 458 */             private final String loc = location;
/*     */ 
/*     */             
/*     */             public String toString() {
/* 462 */               StringBuilder stringBuilder = new StringBuilder();
/* 463 */               stringBuilder.append("Rule");
/* 464 */               stringBuilder.append("{line=").append(this.myLine);
/* 465 */               stringBuilder.append(", loc='").append(this.loc).append('\'');
/* 466 */               stringBuilder.append(", pat='").append(pat).append('\'');
/* 467 */               stringBuilder.append(", lcon='").append(lCon).append('\'');
/* 468 */               stringBuilder.append(", rcon='").append(rCon).append('\'');
/* 469 */               stringBuilder.append('}');
/* 470 */               return stringBuilder.toString();
/*     */             }
/*     */           };
/* 473 */         String str6 = rule.pattern.substring(0, 1);
/* 474 */         List<Rule> list = (List)hashMap.get(str6);
/* 475 */         if (list == null) {
/* 476 */           list = new ArrayList();
/* 477 */           hashMap.put(str6, list);
/*     */         } 
/* 479 */         list.add(rule);
/* 480 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 481 */         throw new IllegalStateException("Problem parsing line '" + b + "' in " + location, illegalArgumentException);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 489 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static RPattern pattern(final String regex) {
/* 500 */     boolean bool1 = regex.startsWith("^");
/* 501 */     boolean bool2 = regex.endsWith("$");
/* 502 */     final String content = regex.substring(bool1 ? 1 : 0, bool2 ? (regex.length() - 1) : regex.length());
/* 503 */     boolean bool3 = str.contains("[");
/*     */     
/* 505 */     if (!bool3) {
/* 506 */       if (bool1 && bool2) {
/*     */         
/* 508 */         if (str.length() == 0)
/*     */         {
/* 510 */           return new RPattern()
/*     */             {
/*     */               public boolean isMatch(CharSequence param1CharSequence) {
/* 513 */                 return (param1CharSequence.length() == 0);
/*     */               }
/*     */             };
/*     */         }
/* 517 */         return new RPattern()
/*     */           {
/*     */             public boolean isMatch(CharSequence param1CharSequence) {
/* 520 */               return param1CharSequence.equals(content); }
/*     */           };
/*     */       } 
/* 523 */       if ((bool1 || bool2) && str.length() == 0)
/*     */       {
/* 525 */         return ALL_STRINGS_RMATCHER; } 
/* 526 */       if (bool1)
/*     */       {
/* 528 */         return new RPattern()
/*     */           {
/*     */             public boolean isMatch(CharSequence param1CharSequence) {
/* 531 */               return Rule.startsWith(param1CharSequence, content);
/*     */             }
/*     */           }; } 
/* 534 */       if (bool2)
/*     */       {
/* 536 */         return new RPattern()
/*     */           {
/*     */             public boolean isMatch(CharSequence param1CharSequence) {
/* 539 */               return Rule.endsWith(param1CharSequence, content);
/*     */             }
/*     */           };
/*     */       }
/*     */     } else {
/* 544 */       boolean bool4 = str.startsWith("[");
/* 545 */       boolean bool5 = str.endsWith("]");
/*     */       
/* 547 */       if (bool4 && bool5) {
/* 548 */         String str1 = str.substring(1, str.length() - 1);
/* 549 */         if (!str1.contains("[")) {
/*     */           
/* 551 */           boolean bool = str1.startsWith("^");
/* 552 */           if (bool) {
/* 553 */             str1 = str1.substring(1);
/*     */           }
/* 555 */           final String bContent = str1;
/* 556 */           final boolean shouldMatch = !bool ? true : false;
/*     */           
/* 558 */           if (bool1 && bool2)
/*     */           {
/* 560 */             return new RPattern()
/*     */               {
/*     */                 public boolean isMatch(CharSequence param1CharSequence) {
/* 563 */                   return (param1CharSequence.length() == 1 && Rule.contains(bContent, param1CharSequence.charAt(0)) == shouldMatch);
/*     */                 }
/*     */               }; } 
/* 566 */           if (bool1)
/*     */           {
/* 568 */             return new RPattern()
/*     */               {
/*     */                 public boolean isMatch(CharSequence param1CharSequence) {
/* 571 */                   return (param1CharSequence.length() > 0 && Rule.contains(bContent, param1CharSequence.charAt(0)) == shouldMatch);
/*     */                 }
/*     */               }; } 
/* 574 */           if (bool2)
/*     */           {
/* 576 */             return new RPattern()
/*     */               {
/*     */                 public boolean isMatch(CharSequence param1CharSequence) {
/* 579 */                   return (param1CharSequence.length() > 0 && Rule
/* 580 */                     .contains(bContent, param1CharSequence.charAt(param1CharSequence.length() - 1)) == shouldMatch);
/*     */                 }
/*     */               };
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 588 */     return new RPattern() {
/* 589 */         Pattern pattern = Pattern.compile(regex);
/*     */ 
/*     */         
/*     */         public boolean isMatch(CharSequence param1CharSequence) {
/* 593 */           Matcher matcher = this.pattern.matcher(param1CharSequence);
/* 594 */           return matcher.find();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 600 */     if (paramCharSequence2.length() > paramCharSequence1.length()) {
/* 601 */       return false;
/*     */     }
/* 603 */     for (byte b = 0; b < paramCharSequence2.length(); b++) {
/* 604 */       if (paramCharSequence1.charAt(b) != paramCharSequence2.charAt(b)) {
/* 605 */         return false;
/*     */       }
/*     */     } 
/* 608 */     return true;
/*     */   }
/*     */   
/*     */   private static String stripQuotes(String paramString) {
/* 612 */     if (paramString.startsWith("\"")) {
/* 613 */       paramString = paramString.substring(1);
/*     */     }
/*     */     
/* 616 */     if (paramString.endsWith("\"")) {
/* 617 */       paramString = paramString.substring(0, paramString.length() - 1);
/*     */     }
/*     */     
/* 620 */     return paramString;
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
/*     */   public Rule(String paramString1, String paramString2, String paramString3, PhonemeExpr paramPhonemeExpr) {
/* 644 */     this.pattern = paramString1;
/* 645 */     this.lContext = pattern(paramString2 + "$");
/* 646 */     this.rContext = pattern("^" + paramString3);
/* 647 */     this.phoneme = paramPhonemeExpr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RPattern getLContext() {
/* 656 */     return this.lContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPattern() {
/* 665 */     return this.pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PhonemeExpr getPhoneme() {
/* 674 */     return this.phoneme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RPattern getRContext() {
/* 683 */     return this.rContext;
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
/*     */   public boolean patternAndContextMatches(CharSequence paramCharSequence, int paramInt) {
/* 698 */     if (paramInt < 0) {
/* 699 */       throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
/*     */     }
/*     */     
/* 702 */     int i = this.pattern.length();
/* 703 */     int j = paramInt + i;
/*     */     
/* 705 */     if (j > paramCharSequence.length())
/*     */     {
/* 707 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 712 */     if (!paramCharSequence.subSequence(paramInt, j).equals(this.pattern))
/* 713 */       return false; 
/* 714 */     if (!this.rContext.isMatch(paramCharSequence.subSequence(j, paramCharSequence.length()))) {
/* 715 */       return false;
/*     */     }
/* 717 */     return this.lContext.isMatch(paramCharSequence.subSequence(0, paramInt));
/*     */   }
/*     */   
/*     */   public static interface RPattern {
/*     */     boolean isMatch(CharSequence param1CharSequence);
/*     */   }
/*     */   
/*     */   public static interface PhonemeExpr {
/*     */     Iterable<Rule.Phoneme> getPhonemes();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/Rule.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */