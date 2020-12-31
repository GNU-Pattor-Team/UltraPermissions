/*    */ package me.TechsCode.UltraPermissions.base.source;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.util.Collection;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LocalRepository
/*    */ {
/*    */   private TechPlugin plugin;
/*    */   private File folder;
/*    */   
/*    */   public LocalRepository(TechPlugin paramTechPlugin) {
/* 18 */     this.plugin = paramTechPlugin;
/*    */     
/* 20 */     this.folder = new File(paramTechPlugin.getPluginFolder().getAbsolutePath() + "/Maven");
/*    */   }
/*    */   
/*    */   public File getIfPresent(Dependency paramDependency) {
/* 24 */     File file = new File(this.folder.getAbsolutePath() + "/" + paramDependency.toURL());
/*    */     
/* 26 */     return file.exists() ? file : null;
/*    */   }
/*    */   
/*    */   public boolean load(Dependency paramDependency, Collection<String> paramCollection) {
/* 30 */     File file = new File(this.folder.getAbsolutePath() + "/" + paramDependency.toURL());
/*    */     
/* 32 */     for (String str1 : paramCollection) {
/* 33 */       String str2 = str1 + "/" + paramDependency.toURL();
/*    */       
/*    */       try {
/* 36 */         FileUtils.copyURLToFile(new URL(str2), file);
/* 37 */         return true;
/* 38 */       } catch (IOException iOException) {}
/*    */     } 
/*    */     
/* 41 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/source/LocalRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */