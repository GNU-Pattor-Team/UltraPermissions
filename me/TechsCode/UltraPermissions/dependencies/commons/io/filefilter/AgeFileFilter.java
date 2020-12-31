/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AgeFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2132740084016138541L;
/*     */   private final long cutoff;
/*     */   private final boolean acceptOlder;
/*     */   
/*     */   public AgeFileFilter(long paramLong) {
/*  66 */     this(paramLong, true);
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
/*     */   public AgeFileFilter(long paramLong, boolean paramBoolean) {
/*  78 */     this.acceptOlder = paramBoolean;
/*  79 */     this.cutoff = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AgeFileFilter(Date paramDate) {
/*  89 */     this(paramDate, true);
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
/*     */   public AgeFileFilter(Date paramDate, boolean paramBoolean) {
/* 101 */     this(paramDate.getTime(), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AgeFileFilter(File paramFile) {
/* 112 */     this(paramFile, true);
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
/*     */   public AgeFileFilter(File paramFile, boolean paramBoolean) {
/* 126 */     this(paramFile.lastModified(), paramBoolean);
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
/*     */   public boolean accept(File paramFile) {
/* 144 */     boolean bool = FileUtils.isFileNewer(paramFile, this.cutoff);
/* 145 */     return this.acceptOlder ? (!bool) : bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 155 */     String str = this.acceptOlder ? "<=" : ">";
/* 156 */     return super.toString() + "(" + str + this.cutoff + ")";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/filefilter/AgeFileFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */