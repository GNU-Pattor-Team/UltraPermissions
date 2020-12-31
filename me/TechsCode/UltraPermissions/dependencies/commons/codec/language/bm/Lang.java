/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language.bm;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Scanner;
/*     */ import java.util.Set;
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
/*     */ public class Lang
/*     */ {
/*     */   private static final class LangRule
/*     */   {
/*     */     private final boolean acceptOnMatch;
/*     */     private final Set<String> languages;
/*     */     private final Pattern pattern;
/*     */     
/*     */     private LangRule(Pattern param1Pattern, Set<String> param1Set, boolean param1Boolean) {
/*  86 */       this.pattern = param1Pattern;
/*  87 */       this.languages = param1Set;
/*  88 */       this.acceptOnMatch = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean matches(String param1String) {
/*  92 */       return this.pattern.matcher(param1String).find();
/*     */     }
/*     */   }
/*     */   
/*  96 */   private static final Map<NameType, Lang> Langs = new EnumMap<>(NameType.class);
/*     */   
/*     */   private static final String LANGUAGE_RULES_RN = "me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/%s_lang.txt";
/*     */   
/*     */   static {
/* 101 */     for (NameType nameType : NameType.values()) {
/* 102 */       Langs.put(nameType, loadFromResource(String.format("me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/%s_lang.txt", new Object[] { nameType.getName() }), Languages.getInstance(nameType)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final Languages languages;
/*     */   
/*     */   private final List<LangRule> rules;
/*     */ 
/*     */   
/*     */   public static Lang instance(NameType paramNameType) {
/* 114 */     return Langs.get(paramNameType);
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
/*     */   public static Lang loadFromResource(String paramString, Languages paramLanguages) {
/* 130 */     ArrayList<LangRule> arrayList = new ArrayList();
/* 131 */     InputStream inputStream = Lang.class.getClassLoader().getResourceAsStream(paramString);
/*     */     
/* 133 */     if (inputStream == null) {
/* 134 */       throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/%s_lang.txt");
/*     */     }
/*     */     
/* 137 */     try (Scanner null = new Scanner(inputStream, "UTF-8")) {
/* 138 */       boolean bool = false;
/* 139 */       while (scanner.hasNextLine()) {
/* 140 */         String str1 = scanner.nextLine();
/* 141 */         String str2 = str1;
/* 142 */         if (bool) {
/*     */           
/* 144 */           if (str2.endsWith("*/"))
/* 145 */             bool = false; 
/*     */           continue;
/*     */         } 
/* 148 */         if (str2.startsWith("/*")) {
/* 149 */           bool = true;
/*     */           continue;
/*     */         } 
/* 152 */         int i = str2.indexOf("//");
/* 153 */         if (i >= 0) {
/* 154 */           str2 = str2.substring(0, i);
/*     */         }
/*     */ 
/*     */         
/* 158 */         str2 = str2.trim();
/*     */         
/* 160 */         if (str2.length() == 0) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 165 */         String[] arrayOfString1 = str2.split("\\s+");
/*     */         
/* 167 */         if (arrayOfString1.length != 3) {
/* 168 */           throw new IllegalArgumentException("Malformed line '" + str1 + "' in language resource '" + paramString + "'");
/*     */         }
/*     */ 
/*     */         
/* 172 */         Pattern pattern = Pattern.compile(arrayOfString1[0]);
/* 173 */         String[] arrayOfString2 = arrayOfString1[1].split("\\+");
/* 174 */         boolean bool1 = arrayOfString1[2].equals("true");
/*     */         
/* 176 */         arrayList.add(new LangRule(pattern, new HashSet(Arrays.asList((Object[])arrayOfString2)), bool1));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 181 */     return new Lang(arrayList, paramLanguages);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Lang(List<LangRule> paramList, Languages paramLanguages) {
/* 188 */     this.rules = Collections.unmodifiableList(paramList);
/* 189 */     this.languages = paramLanguages;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String guessLanguage(String paramString) {
/* 200 */     Languages.LanguageSet languageSet = guessLanguages(paramString);
/* 201 */     return languageSet.isSingleton() ? languageSet.getAny() : "any";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Languages.LanguageSet guessLanguages(String paramString) {
/* 212 */     String str = paramString.toLowerCase(Locale.ENGLISH);
/*     */     
/* 214 */     HashSet<String> hashSet = new HashSet<>(this.languages.getLanguages());
/* 215 */     for (LangRule langRule : this.rules) {
/* 216 */       if (langRule.matches(str)) {
/* 217 */         if (langRule.acceptOnMatch) {
/* 218 */           hashSet.retainAll(langRule.languages); continue;
/*     */         } 
/* 220 */         hashSet.removeAll(langRule.languages);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 225 */     Languages.LanguageSet languageSet = Languages.LanguageSet.from(hashSet);
/* 226 */     return languageSet.equals(Languages.NO_LANGUAGES) ? Languages.ANY_LANGUAGE : languageSet;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/Lang.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */