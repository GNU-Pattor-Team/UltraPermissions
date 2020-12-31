/*    */ package me.TechsCode.UltraPermissions.base.fileconf.impl;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Set;
/*    */ import me.TechsCode.UltraPermissions.base.fileconf.Configuration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ public class SpigotFileConfiguration
/*    */   implements Configuration
/*    */ {
/*    */   private File file;
/*    */   private YamlConfiguration cfg;
/*    */   
/*    */   public SpigotFileConfiguration(File paramFile) {
/* 16 */     this.file = paramFile;
/* 17 */     this.cfg = YamlConfiguration.loadConfiguration(paramFile);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object get(String paramString) {
/* 22 */     return this.cfg.get(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getInt(String paramString) {
/* 27 */     return this.cfg.getInt(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getString(String paramString) {
/* 32 */     return this.cfg.getString(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getBoolean(String paramString) {
/* 37 */     return this.cfg.getBoolean(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<String> getKeys(boolean paramBoolean) {
/* 42 */     return this.cfg.getKeys(paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean contains(String paramString) {
/* 47 */     return this.cfg.contains(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(String paramString, Object paramObject) {
/* 52 */     this.cfg.set(paramString, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void save() {
/*    */     try {
/* 58 */       this.cfg.save(this.file);
/* 59 */     } catch (IOException iOException) {
/* 60 */       iOException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/fileconf/impl/SpigotFileConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */