/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.comparator;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ReverseComparator
/*    */   extends AbstractFileComparator
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -4808255005272229056L;
/*    */   private final Comparator<File> delegate;
/*    */   
/*    */   public ReverseComparator(Comparator<File> paramComparator) {
/* 40 */     if (paramComparator == null) {
/* 41 */       throw new IllegalArgumentException("Delegate comparator is missing");
/*    */     }
/* 43 */     this.delegate = paramComparator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(File paramFile1, File paramFile2) {
/* 56 */     return this.delegate.compare(paramFile2, paramFile1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 66 */     return super.toString() + "[" + this.delegate.toString() + "]";
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/comparator/ReverseComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */