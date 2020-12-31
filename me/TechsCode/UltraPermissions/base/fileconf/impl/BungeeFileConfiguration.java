/*     */ package me.TechsCode.UltraPermissions.base.fileconf.impl;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.base.fileconf.Configuration;
/*     */ import net.md_5.bungee.config.Configuration;
/*     */ import net.md_5.bungee.config.ConfigurationProvider;
/*     */ import net.md_5.bungee.config.YamlConfiguration;
/*     */ 
/*     */ public class BungeeFileConfiguration implements Configuration {
/*     */   private File file;
/*     */   private Configuration configuration;
/*     */   
/*     */   public BungeeFileConfiguration(File paramFile) {
/*  19 */     this.file = paramFile;
/*     */     
/*  21 */     if (!paramFile.exists()) {
/*     */       try {
/*  23 */         paramFile.getParentFile().mkdirs();
/*  24 */         paramFile.createNewFile();
/*  25 */       } catch (IOException iOException) {
/*  26 */         iOException.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*     */     try {
/*  31 */       this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(paramFile);
/*  32 */     } catch (IOException iOException) {
/*  33 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object get(String paramString) {
/*  39 */     return this.configuration.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(String paramString) {
/*  44 */     return this.configuration.getInt(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString(String paramString) {
/*  49 */     return this.configuration.getString(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String paramString) {
/*  54 */     return this.configuration.getBoolean(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<String> getKeys(boolean paramBoolean) {
/*  59 */     HashSet<String> hashSet = new HashSet();
/*     */     
/*  61 */     if (paramBoolean) {
/*  62 */       recursiveKeys(hashSet, "", this.configuration);
/*     */     } else {
/*  64 */       hashSet.addAll(this.configuration.getKeys());
/*     */     } 
/*     */     
/*  67 */     return hashSet;
/*     */   }
/*     */   
/*     */   private void recursiveKeys(Set<String> paramSet, String paramString, Configuration paramConfiguration) {
/*  71 */     paramSet.addAll((Collection<? extends String>)paramConfiguration.getKeys().stream().map(paramString2 -> paramString1 + paramString2).collect(Collectors.toList()));
/*     */     
/*  73 */     for (String str : paramConfiguration.getKeys()) {
/*     */       
/*     */       try {
/*  76 */         Configuration configuration = paramConfiguration.getSection(str);
/*  77 */         if (configuration != null) {
/*  78 */           recursiveKeys(paramSet, paramString + str + ".", configuration);
/*     */         }
/*     */       }
/*  81 */       catch (ClassCastException classCastException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(String paramString) {
/*  87 */     return this.configuration.contains(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(String paramString, Object paramObject) {
/*  92 */     this.configuration.set(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save() {
/*     */     try {
/*  98 */       ConfigurationProvider.getProvider(YamlConfiguration.class).save(this.configuration, this.file);
/*  99 */     } catch (IOException iOException) {
/* 100 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/fileconf/impl/BungeeFileConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */