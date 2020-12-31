/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
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
/*     */ public class PrefixFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8533897440809599867L;
/*     */   private final String[] prefixes;
/*     */   private final IOCase caseSensitivity;
/*     */   
/*     */   public PrefixFileFilter(String paramString) {
/*  61 */     this(paramString, IOCase.SENSITIVE);
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
/*     */   public PrefixFileFilter(String paramString, IOCase paramIOCase) {
/*  74 */     if (paramString == null) {
/*  75 */       throw new IllegalArgumentException("The prefix must not be null");
/*     */     }
/*  77 */     this.prefixes = new String[] { paramString };
/*  78 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/*     */   public PrefixFileFilter(String[] paramArrayOfString) {
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
/*     */   
/*     */   public PrefixFileFilter(String[] paramArrayOfString, IOCase paramIOCase) {
/* 104 */     if (paramArrayOfString == null) {
/* 105 */       throw new IllegalArgumentException("The array of prefixes must not be null");
/*     */     }
/* 107 */     this.prefixes = new String[paramArrayOfString.length];
/* 108 */     System.arraycopy(paramArrayOfString, 0, this.prefixes, 0, paramArrayOfString.length);
/* 109 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrefixFileFilter(List<String> paramList) {
/* 120 */     this(paramList, IOCase.SENSITIVE);
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
/*     */   public PrefixFileFilter(List<String> paramList, IOCase paramIOCase) {
/* 134 */     if (paramList == null) {
/* 135 */       throw new IllegalArgumentException("The list of prefixes must not be null");
/*     */     }
/* 137 */     this.prefixes = paramList.<String>toArray(new String[paramList.size()]);
/* 138 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/* 149 */     String str = paramFile.getName();
/* 150 */     for (String str1 : this.prefixes) {
/* 151 */       if (this.caseSensitivity.checkStartsWith(str, str1)) {
/* 152 */         return true;
/*     */       }
/*     */     } 
/* 155 */     return false;
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
/*     */   public boolean accept(File paramFile, String paramString) {
/* 167 */     for (String str : this.prefixes) {
/* 168 */       if (this.caseSensitivity.checkStartsWith(paramString, str)) {
/* 169 */         return true;
/*     */       }
/*     */     } 
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     StringBuilder stringBuilder = new StringBuilder();
/* 183 */     stringBuilder.append(super.toString());
/* 184 */     stringBuilder.append("(");
/* 185 */     if (this.prefixes != null) {
/* 186 */       for (byte b = 0; b < this.prefixes.length; b++) {
/* 187 */         if (b > 0) {
/* 188 */           stringBuilder.append(",");
/*     */         }
/* 190 */         stringBuilder.append(this.prefixes[b]);
/*     */       } 
/*     */     }
/* 193 */     stringBuilder.append(")");
/* 194 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/filefilter/PrefixFileFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */