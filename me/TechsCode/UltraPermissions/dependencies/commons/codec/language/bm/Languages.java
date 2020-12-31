/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language.bm;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Scanner;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Languages
/*     */ {
/*     */   public static final String ANY = "any";
/*     */   
/*     */   public static abstract class LanguageSet
/*     */   {
/*     */     public static LanguageSet from(Set<String> param1Set) {
/*  64 */       return param1Set.isEmpty() ? Languages.NO_LANGUAGES : new Languages.SomeLanguages(param1Set);
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract boolean contains(String param1String);
/*     */     
/*     */     public abstract String getAny();
/*     */     
/*     */     public abstract boolean isEmpty();
/*     */     
/*     */     public abstract boolean isSingleton();
/*     */     
/*     */     public abstract LanguageSet restrictTo(LanguageSet param1LanguageSet);
/*     */     
/*     */     abstract LanguageSet merge(LanguageSet param1LanguageSet);
/*     */   }
/*     */   
/*     */   public static final class SomeLanguages
/*     */     extends LanguageSet
/*     */   {
/*     */     private final Set<String> languages;
/*     */     
/*     */     private SomeLanguages(Set<String> param1Set) {
/*  87 */       this.languages = Collections.unmodifiableSet(param1Set);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(String param1String) {
/*  92 */       return this.languages.contains(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getAny() {
/*  97 */       return this.languages.iterator().next();
/*     */     }
/*     */     
/*     */     public Set<String> getLanguages() {
/* 101 */       return this.languages;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 106 */       return this.languages.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSingleton() {
/* 111 */       return (this.languages.size() == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
/* 116 */       if (param1LanguageSet == Languages.NO_LANGUAGES)
/* 117 */         return param1LanguageSet; 
/* 118 */       if (param1LanguageSet == Languages.ANY_LANGUAGE) {
/* 119 */         return this;
/*     */       }
/* 121 */       SomeLanguages someLanguages = (SomeLanguages)param1LanguageSet;
/* 122 */       HashSet<String> hashSet = new HashSet(Math.min(this.languages.size(), someLanguages.languages.size()));
/* 123 */       for (String str : this.languages) {
/* 124 */         if (someLanguages.languages.contains(str)) {
/* 125 */           hashSet.add(str);
/*     */         }
/*     */       } 
/* 128 */       return from(hashSet);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Languages.LanguageSet merge(Languages.LanguageSet param1LanguageSet) {
/* 134 */       if (param1LanguageSet == Languages.NO_LANGUAGES)
/* 135 */         return this; 
/* 136 */       if (param1LanguageSet == Languages.ANY_LANGUAGE) {
/* 137 */         return param1LanguageSet;
/*     */       }
/* 139 */       SomeLanguages someLanguages = (SomeLanguages)param1LanguageSet;
/* 140 */       HashSet<String> hashSet = new HashSet<>(this.languages);
/* 141 */       for (String str : someLanguages.languages) {
/* 142 */         hashSet.add(str);
/*     */       }
/* 144 */       return from(hashSet);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 150 */       return "Languages(" + this.languages.toString() + ")";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   private static final Map<NameType, Languages> LANGUAGES = new EnumMap<>(NameType.class); private final Set<String> languages;
/*     */   
/*     */   static {
/* 160 */     for (NameType nameType : NameType.values()) {
/* 161 */       LANGUAGES.put(nameType, getInstance(langResourceName(nameType)));
/*     */     }
/*     */   }
/*     */   
/*     */   public static Languages getInstance(NameType paramNameType) {
/* 166 */     return LANGUAGES.get(paramNameType);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Languages getInstance(String paramString) {
/* 171 */     HashSet<String> hashSet = new HashSet();
/* 172 */     InputStream inputStream = Languages.class.getClassLoader().getResourceAsStream(paramString);
/*     */     
/* 174 */     if (inputStream == null) {
/* 175 */       throw new IllegalArgumentException("Unable to resolve required resource: " + paramString);
/*     */     }
/*     */     
/* 178 */     try (Scanner null = new Scanner(inputStream, "UTF-8")) {
/* 179 */       boolean bool = false;
/* 180 */       while (scanner.hasNextLine()) {
/* 181 */         String str = scanner.nextLine().trim();
/* 182 */         if (bool) {
/* 183 */           if (str.endsWith("*/"))
/* 184 */             bool = false; 
/*     */           continue;
/*     */         } 
/* 187 */         if (str.startsWith("/*")) {
/* 188 */           bool = true; continue;
/* 189 */         }  if (str.length() > 0) {
/* 190 */           hashSet.add(str);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 196 */     return new Languages(Collections.unmodifiableSet(hashSet));
/*     */   }
/*     */   
/*     */   private static String langResourceName(NameType paramNameType) {
/* 200 */     return String.format("me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/%s_languages.txt", new Object[] { paramNameType.getName() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 208 */   public static final LanguageSet NO_LANGUAGES = new LanguageSet()
/*     */     {
/*     */       public boolean contains(String param1String) {
/* 211 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public String getAny() {
/* 216 */         throw new NoSuchElementException("Can't fetch any language from the empty language set.");
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEmpty() {
/* 221 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isSingleton() {
/* 226 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
/* 231 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet merge(Languages.LanguageSet param1LanguageSet) {
/* 236 */         return param1LanguageSet;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 241 */         return "NO_LANGUAGES";
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 248 */   public static final LanguageSet ANY_LANGUAGE = new LanguageSet()
/*     */     {
/*     */       public boolean contains(String param1String) {
/* 251 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public String getAny() {
/* 256 */         throw new NoSuchElementException("Can't fetch any language from the any language set.");
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEmpty() {
/* 261 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isSingleton() {
/* 266 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
/* 271 */         return param1LanguageSet;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet merge(Languages.LanguageSet param1LanguageSet) {
/* 276 */         return param1LanguageSet;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 281 */         return "ANY_LANGUAGE";
/*     */       }
/*     */     };
/*     */   
/*     */   private Languages(Set<String> paramSet) {
/* 286 */     this.languages = paramSet;
/*     */   }
/*     */   
/*     */   public Set<String> getLanguages() {
/* 290 */     return this.languages;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/bm/Languages.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */