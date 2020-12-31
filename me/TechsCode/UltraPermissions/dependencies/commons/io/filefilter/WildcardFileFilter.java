/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FilenameUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.IOCase;
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
/*     */ public class WildcardFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7426486598995782105L;
/*     */   private final String[] wildcards;
/*     */   private final IOCase caseSensitivity;
/*     */   
/*     */   public WildcardFileFilter(String paramString) {
/*  65 */     this(paramString, IOCase.SENSITIVE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFileFilter(String paramString, IOCase paramIOCase) {
/*  76 */     if (paramString == null) {
/*  77 */       throw new IllegalArgumentException("The wildcard must not be null");
/*     */     }
/*  79 */     this.wildcards = new String[] { paramString };
/*  80 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFileFilter(String[] paramArrayOfString) {
/*  91 */     this(paramArrayOfString, IOCase.SENSITIVE);
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
/*     */   public WildcardFileFilter(String[] paramArrayOfString, IOCase paramIOCase) {
/* 103 */     if (paramArrayOfString == null) {
/* 104 */       throw new IllegalArgumentException("The wildcard array must not be null");
/*     */     }
/* 106 */     this.wildcards = new String[paramArrayOfString.length];
/* 107 */     System.arraycopy(paramArrayOfString, 0, this.wildcards, 0, paramArrayOfString.length);
/* 108 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFileFilter(List<String> paramList) {
/* 119 */     this(paramList, IOCase.SENSITIVE);
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
/*     */   public WildcardFileFilter(List<String> paramList, IOCase paramIOCase) {
/* 131 */     if (paramList == null) {
/* 132 */       throw new IllegalArgumentException("The wildcard list must not be null");
/*     */     }
/* 134 */     this.wildcards = paramList.<String>toArray(new String[paramList.size()]);
/* 135 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/* 148 */     for (String str : this.wildcards) {
/* 149 */       if (FilenameUtils.wildcardMatch(paramString, str, this.caseSensitivity)) {
/* 150 */         return true;
/*     */       }
/*     */     } 
/* 153 */     return false;
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
/* 164 */     String str = paramFile.getName();
/* 165 */     for (String str1 : this.wildcards) {
/* 166 */       if (FilenameUtils.wildcardMatch(str, str1, this.caseSensitivity)) {
/* 167 */         return true;
/*     */       }
/*     */     } 
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 180 */     StringBuilder stringBuilder = new StringBuilder();
/* 181 */     stringBuilder.append(super.toString());
/* 182 */     stringBuilder.append("(");
/* 183 */     if (this.wildcards != null) {
/* 184 */       for (byte b = 0; b < this.wildcards.length; b++) {
/* 185 */         if (b > 0) {
/* 186 */           stringBuilder.append(",");
/*     */         }
/* 188 */         stringBuilder.append(this.wildcards[b]);
/*     */       } 
/*     */     }
/* 191 */     stringBuilder.append(")");
/* 192 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/filefilter/WildcardFileFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */