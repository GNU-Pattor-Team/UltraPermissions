/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
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
/*     */ public class FileDeleteStrategy
/*     */ {
/*  39 */   public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FileDeleteStrategy(String paramString) {
/*  56 */     this.name = paramString;
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
/*     */   public boolean deleteQuietly(File paramFile) {
/*  71 */     if (paramFile == null || !paramFile.exists()) {
/*  72 */       return true;
/*     */     }
/*     */     try {
/*  75 */       return doDelete(paramFile);
/*  76 */     } catch (IOException iOException) {
/*  77 */       return false;
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
/*     */   public void delete(File paramFile) {
/*  92 */     if (paramFile.exists() && !doDelete(paramFile)) {
/*  93 */       throw new IOException("Deletion failed: " + paramFile);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean doDelete(File paramFile) {
/* 114 */     return paramFile.delete();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     return "FileDeleteStrategy[" + this.name + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class ForceFileDeleteStrategy
/*     */     extends FileDeleteStrategy
/*     */   {
/*     */     ForceFileDeleteStrategy() {
/* 135 */       super("Force");
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
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean doDelete(File param1File) {
/* 151 */       FileUtils.forceDelete(param1File);
/* 152 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/FileDeleteStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */