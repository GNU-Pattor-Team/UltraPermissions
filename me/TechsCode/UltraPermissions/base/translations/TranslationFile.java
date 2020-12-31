/*    */ package me.TechsCode.UltraPermissions.base.translations;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*    */ 
/*    */ public class TranslationFile
/*    */ {
/* 15 */   private static final String[] disclaimer = new String[] { "#", "# Official Language File", "# To make your own language file, copy this file and edit the copy", "#", "# Changes made to this file will be reset!", "# Do not edit it!", "#", "" };
/*    */ 
/*    */   
/*    */   private String name;
/*    */ 
/*    */   
/*    */   private String language;
/*    */   
/*    */   private Map<String, String> phrases;
/*    */ 
/*    */   
/*    */   public static TranslationFile createFile(File paramFile, String paramString1, String paramString2, Map<String, String> paramMap) {
/* 27 */     File file = new File(paramFile.getAbsolutePath() + "/" + paramString1 + "_" + paramString2 + ".lang");
/*    */     
/* 29 */     if (file.exists() && 
/* 30 */       !file.delete()) {
/* 31 */       throw new IllegalStateException("No write access to directory");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 36 */       if (file.createNewFile()) {
/* 37 */         ArrayList arrayList = new ArrayList(Arrays.asList((Object[])disclaimer));
/*    */ 
/*    */         
/* 40 */         paramMap.entrySet().stream()
/* 41 */           .sorted(Map.Entry.comparingByKey())
/* 42 */           .forEach(paramEntry -> paramList.add((String)paramEntry.getKey() + ": \"" + (String)paramEntry.getValue() + "\""));
/*    */         
/* 44 */         FileUtils.writeLines(file, arrayList);
/*    */         
/* 46 */         return new TranslationFile(file);
/*    */       } 
/* 48 */       throw new IllegalStateException("No write access to file");
/*    */     }
/* 50 */     catch (IOException iOException) {
/* 51 */       iOException.printStackTrace();
/* 52 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TranslationFile(File paramFile) {
/* 61 */     String str = paramFile.getName();
/*    */     
/* 63 */     if (!str.endsWith(".lang") || !str.contains("_")) {
/*    */       return;
/*    */     }
/*    */     
/* 67 */     this.name = str.split("_")[0];
/* 68 */     this.language = str.split("_")[1].replace(".lang", "");
/*    */     
/*    */     try {
/* 71 */       this
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 76 */         .phrases = (Map<String, String>)FileUtils.readLines(paramFile, StandardCharsets.UTF_8).stream().filter(paramString -> !paramString.startsWith("#")).map(paramString -> paramString.split(": \"")).filter(paramArrayOfString -> (paramArrayOfString.length == 2)).filter(paramArrayOfString -> !paramArrayOfString[0].contains("_")).collect(Collectors.toMap(paramArrayOfString -> paramArrayOfString[0], paramArrayOfString -> paramArrayOfString[1].replace("\"", "")));
/* 77 */     } catch (IOException iOException) {
/* 78 */       iOException.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getLanguage() {
/* 83 */     return this.language;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 87 */     return this.name;
/*    */   }
/*    */   
/*    */   public Map<String, String> getPhrases() {
/* 91 */     return this.phrases;
/*    */   }
/*    */   
/*    */   public boolean isValid() {
/* 95 */     return (this.name != null && this.language != null && this.phrases != null);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/translations/TranslationFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */