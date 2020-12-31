/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language.bm;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PhoneticEngine
/*     */ {
/*     */   static final class PhonemeBuilder
/*     */   {
/*     */     private final Set<Rule.Phoneme> phonemes;
/*     */     
/*     */     public static PhonemeBuilder empty(Languages.LanguageSet param1LanguageSet) {
/*  72 */       return new PhonemeBuilder(new Rule.Phoneme("", param1LanguageSet));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private PhonemeBuilder(Rule.Phoneme param1Phoneme) {
/*  78 */       this.phonemes = new LinkedHashSet<>();
/*  79 */       this.phonemes.add(param1Phoneme);
/*     */     }
/*     */     
/*     */     private PhonemeBuilder(Set<Rule.Phoneme> param1Set) {
/*  83 */       this.phonemes = param1Set;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void append(CharSequence param1CharSequence) {
/*  92 */       for (Rule.Phoneme phoneme : this.phonemes) {
/*  93 */         phoneme.append(param1CharSequence);
/*     */       }
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
/*     */     public void apply(Rule.PhonemeExpr param1PhonemeExpr, int param1Int) {
/* 107 */       LinkedHashSet<Rule.Phoneme> linkedHashSet = new LinkedHashSet(param1Int);
/*     */       
/* 109 */       label18: for (Rule.Phoneme phoneme : this.phonemes) {
/* 110 */         for (Rule.Phoneme phoneme1 : param1PhonemeExpr.getPhonemes()) {
/* 111 */           Languages.LanguageSet languageSet = phoneme.getLanguages().restrictTo(phoneme1.getLanguages());
/* 112 */           if (!languageSet.isEmpty()) {
/* 113 */             Rule.Phoneme phoneme2 = new Rule.Phoneme(phoneme, phoneme1, languageSet);
/* 114 */             if (linkedHashSet.size() < param1Int) {
/* 115 */               linkedHashSet.add(phoneme2);
/* 116 */               if (linkedHashSet.size() >= param1Int) {
/*     */                 break label18;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 124 */       this.phonemes.clear();
/* 125 */       this.phonemes.addAll(linkedHashSet);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Rule.Phoneme> getPhonemes() {
/* 134 */       return this.phonemes;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String makeString() {
/* 145 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 147 */       for (Rule.Phoneme phoneme : this.phonemes) {
/* 148 */         if (stringBuilder.length() > 0) {
/* 149 */           stringBuilder.append("|");
/*     */         }
/* 151 */         stringBuilder.append(phoneme.getPhonemeText());
/*     */       } 
/*     */       
/* 154 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class RulesApplication
/*     */   {
/*     */     private final Map<String, List<Rule>> finalRules;
/*     */ 
/*     */     
/*     */     private final CharSequence input;
/*     */ 
/*     */     
/*     */     private final PhoneticEngine.PhonemeBuilder phonemeBuilder;
/*     */ 
/*     */     
/*     */     private int i;
/*     */ 
/*     */     
/*     */     private final int maxPhonemes;
/*     */ 
/*     */     
/*     */     private boolean found;
/*     */ 
/*     */     
/*     */     public RulesApplication(Map<String, List<Rule>> param1Map, CharSequence param1CharSequence, PhoneticEngine.PhonemeBuilder param1PhonemeBuilder, int param1Int1, int param1Int2) {
/* 181 */       if (param1Map == null) {
/* 182 */         throw new NullPointerException("The finalRules argument must not be null");
/*     */       }
/* 184 */       this.finalRules = param1Map;
/* 185 */       this.phonemeBuilder = param1PhonemeBuilder;
/* 186 */       this.input = param1CharSequence;
/* 187 */       this.i = param1Int1;
/* 188 */       this.maxPhonemes = param1Int2;
/*     */     }
/*     */     
/*     */     public int getI() {
/* 192 */       return this.i;
/*     */     }
/*     */     
/*     */     public PhoneticEngine.PhonemeBuilder getPhonemeBuilder() {
/* 196 */       return this.phonemeBuilder;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RulesApplication invoke() {
/* 207 */       this.found = false;
/* 208 */       int i = 1;
/* 209 */       List list = this.finalRules.get(this.input.subSequence(this.i, this.i + i));
/* 210 */       if (list != null) {
/* 211 */         for (Rule rule : list) {
/* 212 */           String str = rule.getPattern();
/* 213 */           i = str.length();
/* 214 */           if (rule.patternAndContextMatches(this.input, this.i)) {
/* 215 */             this.phonemeBuilder.apply(rule.getPhoneme(), this.maxPhonemes);
/* 216 */             this.found = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 222 */       if (!this.found) {
/* 223 */         i = 1;
/*     */       }
/*     */       
/* 226 */       this.i += i;
/* 227 */       return this;
/*     */     }
/*     */     
/*     */     public boolean isFound() {
/* 231 */       return this.found;
/*     */     }
/*     */   }
/*     */   private static final int DEFAULT_MAX_PHONEMES = 20;
/* 235 */   private static final Map<NameType, Set<String>> NAME_PREFIXES = new EnumMap<>(NameType.class);
/*     */   
/*     */   static {
/* 238 */     NAME_PREFIXES.put(NameType.ASHKENAZI, 
/* 239 */         Collections.unmodifiableSet(new HashSet<>(
/* 240 */             Arrays.asList(new String[] { "bar", "ben", "da", "de", "van", "von" }))));
/* 241 */     NAME_PREFIXES.put(NameType.SEPHARDIC, 
/* 242 */         Collections.unmodifiableSet(new HashSet<>(
/* 243 */             Arrays.asList(new String[] { 
/*     */                 "al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", 
/* 245 */                 "di", "do", "dos", "du", "van", "von" })))); NAME_PREFIXES.put(NameType.GENERIC, 
/* 246 */         Collections.unmodifiableSet(new HashSet<>(
/* 247 */             Arrays.asList(new String[] { 
/*     */                 "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", 
/*     */                 "dos", "du", "van", "von" }))));
/*     */   }
/*     */   private final Lang lang;
/*     */   private final NameType nameType;
/*     */   private final RuleType ruleType;
/*     */   private final boolean concat;
/*     */   private final int maxPhonemes;
/*     */   
/*     */   private static String join(Iterable<String> paramIterable, String paramString) {
/* 258 */     StringBuilder stringBuilder = new StringBuilder();
/* 259 */     Iterator<String> iterator = paramIterable.iterator();
/* 260 */     if (iterator.hasNext()) {
/* 261 */       stringBuilder.append(iterator.next());
/*     */     }
/* 263 */     while (iterator.hasNext()) {
/* 264 */       stringBuilder.append(paramString).append(iterator.next());
/*     */     }
/*     */     
/* 267 */     return stringBuilder.toString();
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
/*     */   public PhoneticEngine(NameType paramNameType, RuleType paramRuleType, boolean paramBoolean) {
/* 293 */     this(paramNameType, paramRuleType, paramBoolean, 20);
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
/*     */   public PhoneticEngine(NameType paramNameType, RuleType paramRuleType, boolean paramBoolean, int paramInt) {
/* 311 */     if (paramRuleType == RuleType.RULES) {
/* 312 */       throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES);
/*     */     }
/* 314 */     this.nameType = paramNameType;
/* 315 */     this.ruleType = paramRuleType;
/* 316 */     this.concat = paramBoolean;
/* 317 */     this.lang = Lang.instance(paramNameType);
/* 318 */     this.maxPhonemes = paramInt;
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
/*     */   private PhonemeBuilder applyFinalRules(PhonemeBuilder paramPhonemeBuilder, Map<String, List<Rule>> paramMap) {
/* 331 */     if (paramMap == null) {
/* 332 */       throw new NullPointerException("finalRules can not be null");
/*     */     }
/* 334 */     if (paramMap.isEmpty()) {
/* 335 */       return paramPhonemeBuilder;
/*     */     }
/*     */     
/* 338 */     TreeMap<Rule.Phoneme, Object> treeMap = new TreeMap<>(Rule.Phoneme.COMPARATOR);
/*     */ 
/*     */     
/* 341 */     for (Rule.Phoneme phoneme : paramPhonemeBuilder.getPhonemes()) {
/* 342 */       PhonemeBuilder phonemeBuilder = PhonemeBuilder.empty(phoneme.getLanguages());
/* 343 */       String str = phoneme.getPhonemeText().toString();
/*     */       int i;
/* 345 */       for (i = 0; i < str.length(); ) {
/*     */         
/* 347 */         RulesApplication rulesApplication = (new RulesApplication(paramMap, str, phonemeBuilder, i, this.maxPhonemes)).invoke();
/* 348 */         boolean bool = rulesApplication.isFound();
/* 349 */         phonemeBuilder = rulesApplication.getPhonemeBuilder();
/*     */         
/* 351 */         if (!bool)
/*     */         {
/* 353 */           phonemeBuilder.append(str.subSequence(i, i + 1));
/*     */         }
/*     */         
/* 356 */         i = rulesApplication.getI();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 362 */       for (Rule.Phoneme phoneme1 : phonemeBuilder.getPhonemes()) {
/* 363 */         if (treeMap.containsKey(phoneme1)) {
/* 364 */           Rule.Phoneme phoneme2 = (Rule.Phoneme)treeMap.remove(phoneme1);
/* 365 */           Rule.Phoneme phoneme3 = phoneme2.mergeWithLanguage(phoneme1.getLanguages());
/* 366 */           treeMap.put(phoneme3, phoneme3); continue;
/*     */         } 
/* 368 */         treeMap.put(phoneme1, phoneme1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 373 */     return new PhonemeBuilder(treeMap.keySet());
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
/* 384 */     Languages.LanguageSet languageSet = this.lang.guessLanguages(paramString);
/* 385 */     return encode(paramString, languageSet);
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
/*     */   public String encode(String paramString, Languages.LanguageSet paramLanguageSet) {
/* 399 */     Map<String, List<Rule>> map1 = Rule.getInstanceMap(this.nameType, RuleType.RULES, paramLanguageSet);
/*     */     
/* 401 */     Map<String, List<Rule>> map2 = Rule.getInstanceMap(this.nameType, this.ruleType, "common");
/*     */     
/* 403 */     Map<String, List<Rule>> map3 = Rule.getInstanceMap(this.nameType, this.ruleType, paramLanguageSet);
/*     */ 
/*     */ 
/*     */     
/* 407 */     paramString = paramString.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
/*     */     
/* 409 */     if (this.nameType == NameType.GENERIC) {
/* 410 */       if (paramString.length() >= 2 && paramString.substring(0, 2).equals("d'")) {
/* 411 */         String str1 = paramString.substring(2);
/* 412 */         String str2 = "d" + str1;
/* 413 */         return "(" + encode(str1) + ")-(" + encode(str2) + ")";
/*     */       } 
/* 415 */       for (String str : NAME_PREFIXES.get(this.nameType)) {
/*     */         
/* 417 */         if (paramString.startsWith(str + " ")) {
/*     */           
/* 419 */           String str1 = paramString.substring(str.length() + 1);
/* 420 */           String str2 = str + str1;
/* 421 */           return "(" + encode(str1) + ")-(" + encode(str2) + ")";
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 426 */     List<String> list = Arrays.asList(paramString.split("\\s+"));
/* 427 */     ArrayList<String> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 430 */     switch (this.nameType) {
/*     */       case SEPHARDIC:
/* 432 */         for (String str1 : list) {
/* 433 */           String[] arrayOfString = str1.split("'");
/* 434 */           String str2 = arrayOfString[arrayOfString.length - 1];
/* 435 */           arrayList.add(str2);
/*     */         } 
/* 437 */         arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
/*     */         break;
/*     */       case ASHKENAZI:
/* 440 */         arrayList.addAll(list);
/* 441 */         arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
/*     */         break;
/*     */       case GENERIC:
/* 444 */         arrayList.addAll(list);
/*     */         break;
/*     */       default:
/* 447 */         throw new IllegalStateException("Unreachable case: " + this.nameType);
/*     */     } 
/*     */     
/* 450 */     if (this.concat) {
/*     */       
/* 452 */       paramString = join(arrayList, " ");
/* 453 */     } else if (arrayList.size() == 1) {
/*     */       
/* 455 */       paramString = list.iterator().next();
/*     */     } else {
/*     */       
/* 458 */       StringBuilder stringBuilder = new StringBuilder();
/* 459 */       for (String str : arrayList) {
/* 460 */         stringBuilder.append("-").append(encode(str));
/*     */       }
/*     */       
/* 463 */       return stringBuilder.substring(1);
/*     */     } 
/*     */     
/* 466 */     PhonemeBuilder phonemeBuilder = PhonemeBuilder.empty(paramLanguageSet);
/*     */ 
/*     */     
/* 469 */     for (int i = 0; i < paramString.length(); ) {
/*     */       
/* 471 */       RulesApplication rulesApplication = (new RulesApplication(map1, paramString, phonemeBuilder, i, this.maxPhonemes)).invoke();
/* 472 */       i = rulesApplication.getI();
/* 473 */       phonemeBuilder = rulesApplication.getPhonemeBuilder();
/*     */     } 
/*     */ 
/*     */     
/* 477 */     phonemeBuilder = applyFinalRules(phonemeBuilder, map2);
/*     */     
/* 479 */     phonemeBuilder = applyFinalRules(phonemeBuilder, map3);
/*     */     
/* 481 */     return phonemeBuilder.makeString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Lang getLang() {
/* 490 */     return this.lang;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameType getNameType() {
/* 499 */     return this.nameType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RuleType getRuleType() {
/* 508 */     return this.ruleType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConcat() {
/* 517 */     return this.concat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxPhonemes() {
/* 527 */     return this.maxPhonemes;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/PhoneticEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */