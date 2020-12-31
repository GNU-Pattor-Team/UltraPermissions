/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.comparator;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
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
/*    */ public class DirectoryFileComparator
/*    */   extends AbstractFileComparator
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 296132640160964395L;
/* 50 */   public static final Comparator<File> DIRECTORY_COMPARATOR = new DirectoryFileComparator();
/*    */ 
/*    */   
/* 53 */   public static final Comparator<File> DIRECTORY_REVERSE = new ReverseComparator(DIRECTORY_COMPARATOR);
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
/* 65 */     return getType(paramFile1) - getType(paramFile2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private int getType(File paramFile) {
/* 75 */     if (paramFile.isDirectory()) {
/* 76 */       return 1;
/*    */     }
/* 78 */     return 2;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/comparator/DirectoryFileComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */