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
/*    */ public class DefaultFileComparator
/*    */   extends AbstractFileComparator
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 3260141861365313518L;
/* 51 */   public static final Comparator<File> DEFAULT_COMPARATOR = new DefaultFileComparator();
/*    */ 
/*    */   
/* 54 */   public static final Comparator<File> DEFAULT_REVERSE = new ReverseComparator(DEFAULT_COMPARATOR);
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
/* 66 */     return paramFile1.compareTo(paramFile2);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/comparator/DefaultFileComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */