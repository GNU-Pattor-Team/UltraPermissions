/*     */ package me.TechsCode.UltraPermissions.base.translations;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.reflection.indexer.ClasspathIndexer;
/*     */ import me.TechsCode.UltraPermissions.base.reflection.indexer.Node;
/*     */ import me.TechsCode.UltraPermissions.base.registry.RegistrationChoice;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.IOUtils;
/*     */ 
/*     */ public class TranslationManager {
/*     */   private final TranslationRegistry translationRegistry;
/*     */   private final Map<String, Phrase> phrases;
/*     */   
/*     */   public TranslationManager(TechPlugin<?> paramTechPlugin) {
/*  37 */     this.translationRegistry = (TranslationRegistry)paramTechPlugin.getRegistry().register(new TranslationRegistry(), RegistrationChoice.GLOBAL_IF_AVAILABLE);
/*     */     
/*  39 */     File file = new File(paramTechPlugin.getPluginFolder().getAbsolutePath() + "/Languages");
/*  40 */     file.mkdirs();
/*     */ 
/*     */     
/*  43 */     Map<Phrase, Class<?>> map = loadPhrasesFromClasses();
/*  44 */     validatePhrases(map.keySet());
/*     */     
/*  46 */     this.phrases = (Map<String, Phrase>)map.entrySet().stream().collect(Collectors.toMap(paramEntry -> ((Phrase)paramEntry.getKey()).getName(), Map.Entry::getKey));
/*     */ 
/*     */     
/*  49 */     this.phrases.values().forEach(paramPhrase -> paramPhrase.inject(this));
/*     */     
/*  51 */     paramTechPlugin.getScheduler().runAsync(() -> {
/*     */           createDefaultLanguageFile(paramMap, paramFile, "Base", ());
/*     */           createDefaultLanguageFile(paramMap, paramFile, paramTechPlugin.getName(), ());
/*     */           downloadTranslationFromGithub(paramTechPlugin, paramFile);
/*     */           this.translationFiles = (List<TranslationFile>)Arrays.<Object>stream((Object[])Objects.requireNonNull(paramFile.listFiles())).map(TranslationFile::new).filter(TranslationFile::isValid).collect(Collectors.toList());
/*     */           paramTechPlugin.log("Translations successfully loaded & applied");
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<TranslationFile> translationFiles;
/*     */ 
/*     */   
/*     */   private Map<String, String> translationCache;
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTranslation(String paramString) {
/*  70 */     if (this.translationCache != null) {
/*  71 */       return this.translationCache.get(paramString);
/*     */     }
/*     */     
/*  74 */     this.translationCache = getPhrases(getSelectedLanguage());
/*     */     
/*  76 */     if (this.translationCache == null) return null;
/*     */     
/*  78 */     return this.translationCache.get(paramString);
/*     */   }
/*     */   
/*     */   public Map<String, String> getPhrases(String paramString) {
/*  82 */     if (this.translationFiles == null) return null;
/*     */     
/*  84 */     return (Map<String, String>)this.translationFiles.stream()
/*  85 */       .filter(paramTranslationFile -> paramTranslationFile.getLanguage().equalsIgnoreCase(paramString))
/*  86 */       .flatMap(paramTranslationFile -> paramTranslationFile.getPhrases().entrySet().stream())
/*  87 */       .filter(paramEntry -> this.phrases.containsKey(paramEntry.getKey()))
/*  88 */       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
/*     */   }
/*     */   
/*     */   private static void downloadTranslationFromGithub(TechPlugin<?> paramTechPlugin, File paramFile) {
/*     */     try {
/*  93 */       String str = IOUtils.toString(new URI("https://api.github.com/repos/TechsCode/Translations/contents/translations"));
/*     */       
/*  95 */       JsonParser jsonParser = new JsonParser();
/*  96 */       JsonArray jsonArray = (JsonArray)jsonParser.parse(str);
/*     */       
/*  98 */       for (JsonElement jsonElement : jsonArray) {
/*  99 */         JsonObject jsonObject = (JsonObject)jsonElement;
/* 100 */         String str1 = jsonObject.get("name").getAsString();
/*     */         
/* 102 */         if (!str1.endsWith(".lang") || !str1.contains("_") || (
/* 103 */           !str1.startsWith("Base_") && !str1.startsWith(paramTechPlugin.getName())))
/*     */           continue; 
/* 105 */         String str2 = jsonObject.get("download_url").getAsString();
/*     */         
/* 107 */         File file = new File(paramFile.getAbsolutePath() + "/" + str1);
/* 108 */         FileUtils.copyURLToFile(new URL(str2), file);
/*     */       }
/*     */     
/* 111 */     } catch (IOException|java.net.URISyntaxException iOException) {
/* 112 */       paramTechPlugin.log("Could not load translations from github");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void createDefaultLanguageFile(Map<Phrase, Class<?>> paramMap, File paramFile, String paramString, Predicate<? super Map.Entry<Phrase, Class<?>>> paramPredicate) {
/* 120 */     Map<String, String> map = (Map)paramMap.entrySet().stream().filter(paramPredicate).map(Map.Entry::getKey).collect(Collectors.toMap(Phrase::getName, Phrase::getDefaultPhrase));
/* 121 */     TranslationFile.createFile(paramFile, paramString, "English", map);
/*     */   }
/*     */   
/*     */   private static void validatePhrases(Collection<Phrase> paramCollection) {
/* 125 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 127 */     for (Phrase phrase : paramCollection) {
/* 128 */       if (arrayList.contains(phrase.getName())) {
/* 129 */         throw new IllegalStateException("Duplicate Phrase '" + phrase.getName() + "'");
/*     */       }
/*     */       
/* 132 */       if (phrase.getDefaultPhrase().contains("§")) {
/* 133 */         throw new IllegalStateException("Phrase '" + phrase.getName() + "' contains illegal symbol");
/*     */       }
/*     */       
/* 136 */       arrayList.add(phrase.getName());
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Map<Phrase, Class<?>> loadPhrasesFromClasses() {
/* 141 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 143 */     for (Node node : ClasspathIndexer.index().classes()) {
/* 144 */       if (!node.getClassName().startsWith("me.TechsCode"))
/*     */         continue; 
/*     */       try {
/* 147 */         Optional<Class<?>> optional = node.getAsClass();
/* 148 */         if (optional.isPresent()) {
/* 149 */           for (Field field : ((Class)optional.get()).getDeclaredFields()) {
/* 150 */             if (Modifier.isStatic(field.getModifiers()) && field.getType() == Phrase.class) {
/*     */               try {
/* 152 */                 field.setAccessible(true);
/*     */                 
/* 154 */                 Phrase phrase = (Phrase)field.get(null);
/* 155 */                 hashMap.put(phrase, optional.get());
/* 156 */               } catch (IllegalAccessException illegalAccessException) {
/* 157 */                 illegalAccessException.printStackTrace();
/*     */               }
/*     */             
/*     */             }
/*     */           } 
/*     */         }
/* 163 */       } catch (NoClassDefFoundError noClassDefFoundError) {}
/*     */     } 
/*     */     
/* 166 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSelectedLanguage() {
/* 171 */     return this.translationRegistry.getLanguage();
/*     */   }
/*     */   
/*     */   public void setSelectedLanguage(String paramString) {
/* 175 */     this.translationRegistry.setLanguage(paramString);
/* 176 */     this.translationCache = null;
/*     */   }
/*     */   
/*     */   public List<String> getAvailableLanguages() {
/* 180 */     return (List<String>)this.translationFiles.stream().map(TranslationFile::getLanguage).distinct().collect(Collectors.toList());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/translations/TranslationManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */