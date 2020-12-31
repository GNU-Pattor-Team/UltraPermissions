/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.comparator;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
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
/*     */ public class ExtensionFileComparator
/*     */   extends AbstractFileComparator
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1928235200184222815L;
/*  58 */   public static final Comparator<File> EXTENSION_COMPARATOR = new ExtensionFileComparator();
/*     */ 
/*     */   
/*  61 */   public static final Comparator<File> EXTENSION_REVERSE = new ReverseComparator(EXTENSION_COMPARATOR);
/*     */ 
/*     */   
/*  64 */   public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR = new ExtensionFileComparator(IOCase.INSENSITIVE);
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE = new ReverseComparator(EXTENSION_INSENSITIVE_COMPARATOR);
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR = new ExtensionFileComparator(IOCase.SYSTEM);
/*     */ 
/*     */   
/*  75 */   public static final Comparator<File> EXTENSION_SYSTEM_REVERSE = new ReverseComparator(EXTENSION_SYSTEM_COMPARATOR);
/*     */ 
/*     */ 
/*     */   
/*     */   private final IOCase caseSensitivity;
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtensionFileComparator() {
/*  84 */     this.caseSensitivity = IOCase.SENSITIVE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtensionFileComparator(IOCase paramIOCase) {
/*  93 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/*     */   public int compare(File paramFile1, File paramFile2) {
/* 109 */     String str1 = FilenameUtils.getExtension(paramFile1.getName());
/* 110 */     String str2 = FilenameUtils.getExtension(paramFile2.getName());
/* 111 */     return this.caseSensitivity.checkCompareTo(str1, str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 121 */     return super.toString() + "[caseSensitivity=" + this.caseSensitivity + "]";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/comparator/ExtensionFileComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */