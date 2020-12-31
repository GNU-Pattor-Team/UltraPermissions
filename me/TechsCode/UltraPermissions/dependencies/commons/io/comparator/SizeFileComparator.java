/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.comparator;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
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
/*     */ public class SizeFileComparator
/*     */   extends AbstractFileComparator
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1201561106411416190L;
/*  56 */   public static final Comparator<File> SIZE_COMPARATOR = new SizeFileComparator();
/*     */ 
/*     */   
/*  59 */   public static final Comparator<File> SIZE_REVERSE = new ReverseComparator(SIZE_COMPARATOR);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = new SizeFileComparator(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final Comparator<File> SIZE_SUMDIR_REVERSE = new ReverseComparator(SIZE_SUMDIR_COMPARATOR);
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean sumDirectoryContents;
/*     */ 
/*     */ 
/*     */   
/*     */   public SizeFileComparator() {
/*  80 */     this.sumDirectoryContents = false;
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
/*     */   public SizeFileComparator(boolean paramBoolean) {
/*  95 */     this.sumDirectoryContents = paramBoolean;
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
/* 111 */     long l1 = 0L;
/* 112 */     if (paramFile1.isDirectory()) {
/* 113 */       l1 = (this.sumDirectoryContents && paramFile1.exists()) ? FileUtils.sizeOfDirectory(paramFile1) : 0L;
/*     */     } else {
/* 115 */       l1 = paramFile1.length();
/*     */     } 
/* 117 */     long l2 = 0L;
/* 118 */     if (paramFile2.isDirectory()) {
/* 119 */       l2 = (this.sumDirectoryContents && paramFile2.exists()) ? FileUtils.sizeOfDirectory(paramFile2) : 0L;
/*     */     } else {
/* 121 */       l2 = paramFile2.length();
/*     */     } 
/* 123 */     long l3 = l1 - l2;
/* 124 */     if (l3 < 0L)
/* 125 */       return -1; 
/* 126 */     if (l3 > 0L) {
/* 127 */       return 1;
/*     */     }
/* 129 */     return 0;
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
/* 140 */     return super.toString() + "[sumDirectoryContents=" + this.sumDirectoryContents + "]";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/comparator/SizeFileComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */