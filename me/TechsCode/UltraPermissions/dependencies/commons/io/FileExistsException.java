/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
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
/*    */ public class FileExistsException
/*    */   extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public FileExistsException() {}
/*    */   
/*    */   public FileExistsException(String paramString) {
/* 47 */     super(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FileExistsException(File paramFile) {
/* 56 */     super("File " + paramFile + " exists");
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/FileExistsException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */