/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FilenameUtils;
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
/*     */ @Deprecated
/*     */ public class WildcardFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -5037645902506953517L;
/*     */   private final String[] wildcards;
/*     */   
/*     */   public WildcardFilter(String paramString) {
/*  65 */     if (paramString == null) {
/*  66 */       throw new IllegalArgumentException("The wildcard must not be null");
/*     */     }
/*  68 */     this.wildcards = new String[] { paramString };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFilter(String[] paramArrayOfString) {
/*  78 */     if (paramArrayOfString == null) {
/*  79 */       throw new IllegalArgumentException("The wildcard array must not be null");
/*     */     }
/*  81 */     this.wildcards = new String[paramArrayOfString.length];
/*  82 */     System.arraycopy(paramArrayOfString, 0, this.wildcards, 0, paramArrayOfString.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFilter(List<String> paramList) {
/*  93 */     if (paramList == null) {
/*  94 */       throw new IllegalArgumentException("The wildcard list must not be null");
/*     */     }
/*  96 */     this.wildcards = paramList.<String>toArray(new String[paramList.size()]);
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
/*     */   public boolean accept(File paramFile, String paramString) {
/* 109 */     if (paramFile != null && (new File(paramFile, paramString)).isDirectory()) {
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     for (String str : this.wildcards) {
/* 114 */       if (FilenameUtils.wildcardMatch(paramString, str)) {
/* 115 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile) {
/* 130 */     if (paramFile.isDirectory()) {
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     for (String str : this.wildcards) {
/* 135 */       if (FilenameUtils.wildcardMatch(paramFile.getName(), str)) {
/* 136 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 140 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/filefilter/WildcardFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */