/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
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
/*     */ public class LocaleUtils
/*     */ {
/*     */   private static List cAvailableLocaleList;
/*     */   private static Set cAvailableLocaleSet;
/*  49 */   private static final Map cLanguagesByCountry = Collections.synchronizedMap(new HashMap());
/*     */ 
/*     */   
/*  52 */   private static final Map cCountriesByLanguage = Collections.synchronizedMap(new HashMap());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Locale toLocale(String paramString) {
/*  94 */     if (paramString == null) {
/*  95 */       return null;
/*     */     }
/*  97 */     int i = paramString.length();
/*  98 */     if (i != 2 && i != 5 && i < 7) {
/*  99 */       throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */     }
/* 101 */     char c1 = paramString.charAt(0);
/* 102 */     char c2 = paramString.charAt(1);
/* 103 */     if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z') {
/* 104 */       throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */     }
/* 106 */     if (i == 2) {
/* 107 */       return new Locale(paramString, "");
/*     */     }
/* 109 */     if (paramString.charAt(2) != '_') {
/* 110 */       throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */     }
/* 112 */     char c3 = paramString.charAt(3);
/* 113 */     if (c3 == '_') {
/* 114 */       return new Locale(paramString.substring(0, 2), "", paramString.substring(4));
/*     */     }
/* 116 */     char c4 = paramString.charAt(4);
/* 117 */     if (c3 < 'A' || c3 > 'Z' || c4 < 'A' || c4 > 'Z') {
/* 118 */       throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */     }
/* 120 */     if (i == 5) {
/* 121 */       return new Locale(paramString.substring(0, 2), paramString.substring(3, 5));
/*     */     }
/* 123 */     if (paramString.charAt(5) != '_') {
/* 124 */       throw new IllegalArgumentException("Invalid locale format: " + paramString);
/*     */     }
/* 126 */     return new Locale(paramString.substring(0, 2), paramString.substring(3, 5), paramString.substring(6));
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
/*     */   public static List localeLookupList(Locale paramLocale) {
/* 145 */     return localeLookupList(paramLocale, paramLocale);
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
/*     */   public static List localeLookupList(Locale paramLocale1, Locale paramLocale2) {
/* 167 */     ArrayList arrayList = new ArrayList(4);
/* 168 */     if (paramLocale1 != null) {
/* 169 */       arrayList.add(paramLocale1);
/* 170 */       if (paramLocale1.getVariant().length() > 0) {
/* 171 */         arrayList.add(new Locale(paramLocale1.getLanguage(), paramLocale1.getCountry()));
/*     */       }
/* 173 */       if (paramLocale1.getCountry().length() > 0) {
/* 174 */         arrayList.add(new Locale(paramLocale1.getLanguage(), ""));
/*     */       }
/* 176 */       if (!arrayList.contains(paramLocale2)) {
/* 177 */         arrayList.add(paramLocale2);
/*     */       }
/*     */     } 
/* 180 */     return Collections.unmodifiableList(arrayList);
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
/*     */   public static List availableLocaleList() {
/* 194 */     if (cAvailableLocaleList == null) {
/* 195 */       initAvailableLocaleList();
/*     */     }
/* 197 */     return cAvailableLocaleList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static synchronized void initAvailableLocaleList() {
/* 206 */     if (cAvailableLocaleList == null) {
/* 207 */       List list = Arrays.asList(Locale.getAvailableLocales());
/* 208 */       cAvailableLocaleList = Collections.unmodifiableList(list);
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
/*     */   public static Set availableLocaleSet() {
/* 223 */     if (cAvailableLocaleSet == null) {
/* 224 */       initAvailableLocaleSet();
/*     */     }
/* 226 */     return cAvailableLocaleSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static synchronized void initAvailableLocaleSet() {
/* 235 */     if (cAvailableLocaleSet == null) {
/* 236 */       cAvailableLocaleSet = Collections.unmodifiableSet(new HashSet(availableLocaleList()));
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
/*     */   public static boolean isAvailableLocale(Locale paramLocale) {
/* 248 */     return availableLocaleList().contains(paramLocale);
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
/*     */   public static List languagesByCountry(String paramString) {
/* 262 */     List list = (List)cLanguagesByCountry.get(paramString);
/* 263 */     if (list == null) {
/* 264 */       if (paramString != null) {
/* 265 */         list = new ArrayList();
/* 266 */         List list1 = availableLocaleList();
/* 267 */         for (byte b = 0; b < list1.size(); b++) {
/* 268 */           Locale locale = list1.get(b);
/* 269 */           if (paramString.equals(locale.getCountry()) && locale.getVariant().length() == 0)
/*     */           {
/* 271 */             list.add(locale);
/*     */           }
/*     */         } 
/* 274 */         list = Collections.unmodifiableList(list);
/*     */       } else {
/* 276 */         list = Collections.EMPTY_LIST;
/*     */       } 
/* 278 */       cLanguagesByCountry.put(paramString, list);
/*     */     } 
/* 280 */     return list;
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
/*     */   public static List countriesByLanguage(String paramString) {
/* 294 */     List list = (List)cCountriesByLanguage.get(paramString);
/* 295 */     if (list == null) {
/* 296 */       if (paramString != null) {
/* 297 */         list = new ArrayList();
/* 298 */         List list1 = availableLocaleList();
/* 299 */         for (byte b = 0; b < list1.size(); b++) {
/* 300 */           Locale locale = list1.get(b);
/* 301 */           if (paramString.equals(locale.getLanguage()) && locale.getCountry().length() != 0 && locale.getVariant().length() == 0)
/*     */           {
/*     */             
/* 304 */             list.add(locale);
/*     */           }
/*     */         } 
/* 307 */         list = Collections.unmodifiableList(list);
/*     */       } else {
/* 309 */         list = Collections.EMPTY_LIST;
/*     */       } 
/* 311 */       cCountriesByLanguage.put(paramString, list);
/*     */     } 
/* 313 */     return list;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/LocaleUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */