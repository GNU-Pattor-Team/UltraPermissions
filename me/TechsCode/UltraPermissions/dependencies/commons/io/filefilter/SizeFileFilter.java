/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SizeFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7388077430788600069L;
/*     */   private final long size;
/*     */   private final boolean acceptLarger;
/*     */   
/*     */   public SizeFileFilter(long paramLong) {
/*  58 */     this(paramLong, true);
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
/*     */   public SizeFileFilter(long paramLong, boolean paramBoolean) {
/*  71 */     if (paramLong < 0L) {
/*  72 */       throw new IllegalArgumentException("The size must be non-negative");
/*     */     }
/*  74 */     this.size = paramLong;
/*  75 */     this.acceptLarger = paramBoolean;
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
/*     */   public boolean accept(File paramFile) {
/*  92 */     boolean bool = (paramFile.length() < this.size) ? true : false;
/*  93 */     return this.acceptLarger ? (!bool) : bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 103 */     String str = this.acceptLarger ? ">=" : "<";
/* 104 */     return super.toString() + "(" + str + this.size + ")";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/filefilter/SizeFileFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */