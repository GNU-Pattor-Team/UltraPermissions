/*    */ package me.TechsCode.UltraPermissions.base.update;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class UpdateResponse
/*    */ {
/*    */   private ResponseType type;
/*    */   private File file;
/*    */   
/*    */   public UpdateResponse(ResponseType paramResponseType, File paramFile) {
/* 11 */     this.type = paramResponseType;
/* 12 */     this.file = paramFile;
/*    */   }
/*    */   
/*    */   public ResponseType getType() {
/* 16 */     return this.type;
/*    */   }
/*    */   
/*    */   public File getFile() {
/* 20 */     return this.file;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/UpdateResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */