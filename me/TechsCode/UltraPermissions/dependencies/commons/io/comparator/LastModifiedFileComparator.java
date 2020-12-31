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
/*    */ 
/*    */ 
/*    */ public class LastModifiedFileComparator
/*    */   extends AbstractFileComparator
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 7372168004395734046L;
/* 52 */   public static final Comparator<File> LASTMODIFIED_COMPARATOR = new LastModifiedFileComparator();
/*    */ 
/*    */   
/* 55 */   public static final Comparator<File> LASTMODIFIED_REVERSE = new ReverseComparator(LASTMODIFIED_COMPARATOR);
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
/*    */   public int compare(File paramFile1, File paramFile2) {
/* 70 */     long l = paramFile1.lastModified() - paramFile2.lastModified();
/* 71 */     if (l < 0L)
/* 72 */       return -1; 
/* 73 */     if (l > 0L) {
/* 74 */       return 1;
/*    */     }
/* 76 */     return 0;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/comparator/LastModifiedFileComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */