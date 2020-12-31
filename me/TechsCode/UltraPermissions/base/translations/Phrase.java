/*     */ package me.TechsCode.UltraPermissions.base.translations;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
/*     */ 
/*     */ public class Phrase {
/*     */   private final String name;
/*     */   private final String defaultPhrase;
/*     */   
/*     */   public static Phrase create(String paramString1, String paramString2, Future<Color> paramFuture, Future<Color>... paramVarArgs) {
/*  18 */     return new Phrase(paramString1, paramString2, paramFuture, Arrays.asList(paramVarArgs));
/*     */   }
/*     */   private final Future<Color> mainColor; private final List<Future<Color>> colors; private TranslationManager translationManager;
/*     */   public static Phrase create(String paramString1, String paramString2, Color paramColor, Color... paramVarArgs) {
/*  22 */     ArrayList<Future> arrayList = new ArrayList();
/*     */     
/*  24 */     for (Color color : paramVarArgs) {
/*  25 */       Future future = () -> paramColor;
/*  26 */       arrayList.add(future);
/*     */     } 
/*     */     
/*  29 */     return new Phrase(paramString1, paramString2, () -> paramColor, Collections.unmodifiableList((List)arrayList));
/*     */   }
/*     */   
/*     */   public static Phrase create(String paramString1, String paramString2) {
/*  33 */     return new Phrase(paramString1, paramString2, null, Collections.emptyList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Phrase(String paramString1, String paramString2, Future<Color> paramFuture, List<Future<Color>> paramList) {
/*  44 */     this.name = paramString1;
/*  45 */     this.defaultPhrase = paramString2;
/*  46 */     this.mainColor = paramFuture;
/*  47 */     this.colors = paramList;
/*     */     
/*  49 */     int i = StringUtils.countMatches(paramString2, "**");
/*     */     
/*  51 */     if (i % 2 != 0) {
/*  52 */       throw new IllegalArgumentException("Invalid Coloring of Phrase '" + paramString1 + "' (Uneven Markers)");
/*     */     }
/*     */     
/*  55 */     if (i / 2 != paramList.size()) {
/*  56 */       throw new IllegalArgumentException("Invalid Coloring of Phrase '" + paramString1 + "' (Invalid Amount of Markers)");
/*     */     }
/*     */   }
/*     */   
/*     */   public void inject(TranslationManager paramTranslationManager) {
/*  61 */     this.translationManager = paramTranslationManager;
/*     */   }
/*     */   
/*     */   public String firstUpper() {
/*  65 */     return Text.firstUpperCase(get());
/*     */   }
/*     */   
/*     */   public String lower() {
/*  69 */     return get().toLowerCase();
/*     */   }
/*     */   
/*     */   public String upper() {
/*  73 */     return get().toUpperCase();
/*     */   }
/*     */   
/*     */   public String get() {
/*  77 */     String str1 = null;
/*     */     
/*  79 */     if (this.translationManager != null) {
/*  80 */       str1 = this.translationManager.getTranslation(this.name);
/*     */     }
/*     */ 
/*     */     
/*  84 */     boolean bool = (str1 != null && StringUtils.countMatches(this.defaultPhrase, "**") != StringUtils.countMatches(str1, "**")) ? true : false;
/*     */     
/*  86 */     String str2 = (str1 == null || bool) ? this.defaultPhrase : str1;
/*     */     
/*  88 */     if (this.mainColor != null) {
/*  89 */       List<Color> list = (List)this.colors.stream().map(Future::get).collect(Collectors.toList());
/*     */ 
/*     */       
/*  92 */       Pattern pattern = Pattern.compile("\\*\\*");
/*  93 */       Matcher matcher = pattern.matcher(str2);
/*     */       
/*  95 */       StringBuffer stringBuffer = new StringBuffer();
/*  96 */       boolean bool1 = false;
/*     */       
/*  98 */       while (matcher.find()) {
/*  99 */         if (bool1) {
/* 100 */           matcher.appendReplacement(stringBuffer, ((Color)this.mainColor.get()).getAppliedTag());
/*     */         } else {
/* 102 */           matcher.appendReplacement(stringBuffer, ((Color)list.get(0)).getAppliedTag());
/* 103 */           list.remove(0);
/*     */         } 
/*     */         
/* 106 */         bool1 = !bool1 ? true : false;
/*     */       } 
/*     */       
/* 109 */       matcher.appendTail(stringBuffer);
/* 110 */       str2 = ((Color)this.mainColor.get()).getAppliedTag() + stringBuffer.toString();
/*     */     } 
/*     */     
/* 113 */     return str2;
/*     */   }
/*     */   
/*     */   public String[] split(int paramInt) {
/* 117 */     String str1 = get();
/*     */     
/* 119 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 121 */     String str2 = "";
/* 122 */     for (String str : str1.split(" ")) {
/* 123 */       int i = Text.stripColor(str2).length();
/*     */       
/* 125 */       if (i > paramInt) {
/* 126 */         arrayList.add(str2);
/* 127 */         str2 = "";
/*     */       } 
/*     */       
/* 130 */       str2 = (str2 + " " + str).trim();
/*     */     } 
/*     */     
/* 133 */     if (!str2.isEmpty()) arrayList.add(str2);
/*     */     
/* 135 */     return (String[])arrayList.stream()
/* 136 */       .map(paramString -> (this.mainColor != null && !paramString.startsWith(((Color)this.mainColor.get()).getAppliedTag())) ? (((Color)this.mainColor.get()).getAppliedTag() + paramString) : paramString)
/* 137 */       .toArray(paramInt -> new String[paramInt]);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 141 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getDefaultPhrase() {
/* 145 */     return this.defaultPhrase;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 150 */     return get();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/translations/Phrase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */