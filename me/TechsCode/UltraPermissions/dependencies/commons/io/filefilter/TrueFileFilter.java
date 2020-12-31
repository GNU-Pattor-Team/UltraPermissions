/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.filefilter;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
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
/*    */ public class TrueFileFilter
/*    */   implements IOFileFilter, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 8782512160909720199L;
/* 36 */   public static final IOFileFilter TRUE = new TrueFileFilter();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   public static final IOFileFilter INSTANCE = TRUE;
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
/*    */   public boolean accept(File paramFile) {
/* 59 */     return true;
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
/*    */   public boolean accept(File paramFile, String paramString) {
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/filefilter/TrueFileFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */