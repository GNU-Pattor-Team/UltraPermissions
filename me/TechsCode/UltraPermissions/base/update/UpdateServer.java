/*    */ package me.TechsCode.UltraPermissions.base.update;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.net.URLDecoder;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*    */ 
/*    */ 
/*    */ public class UpdateServer
/*    */ {
/*    */   public static UpdateResponse request(TechPlugin<?> paramTechPlugin, String paramString1, String paramString2) {
/*    */     try {
/* 15 */       URL uRL = new URL(paramString1 + "/" + paramTechPlugin.getName() + "/download?uid=" + paramString2);
/*    */       
/* 17 */       File file = File.createTempFile("update", null);
/* 18 */       FileUtils.copyURLToFile(uRL, file);
/*    */       
/* 20 */       String str = FileUtils.readLines(file, "UTF-8").get(0);
/*    */       
/* 22 */       if (str.equalsIgnoreCase("NOT-AUTHENTICATED")) {
/* 23 */         return new UpdateResponse(ResponseType.NOT_AUTHENTICATED, null);
/*    */       }
/*    */       
/* 26 */       if (str.equalsIgnoreCase("NOT-VERIFIED")) {
/* 27 */         return new UpdateResponse(ResponseType.NOT_VERIFIED, null);
/*    */       }
/*    */       
/* 30 */       if (str.equalsIgnoreCase("NOT-PURCHASED")) {
/* 31 */         return new UpdateResponse(ResponseType.NOT_PURCHASED, null);
/*    */       }
/*    */       
/* 34 */       return new UpdateResponse(ResponseType.SUCCESS, file);
/* 35 */     } catch (IOException iOException) {
/* 36 */       return new UpdateResponse(ResponseType.SERVER_OFFLINE, null);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static UpdateResponse requestAndPerform(final TechPlugin<?> plugin, String paramString1, String paramString2) {
/* 41 */     UpdateResponse updateResponse = request(plugin, paramString1, paramString2);
/*    */ 
/*    */     
/* 44 */     if (updateResponse.getType() == ResponseType.SUCCESS) {
/*    */       try {
/* 46 */         File file = new File(URLDecoder.decode(plugin.getClass().getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8"));
/* 47 */         file.delete();
/*    */         
/* 49 */         new UploadCompleteThread(file)
/*    */           {
/*    */             public void onComplete() {
/* 52 */               plugin.log("Update complete! Reloading...");
/* 53 */               plugin.getPluginReloader().unload();
/* 54 */               plugin.getPluginReloader().load();
/*    */             }
/*    */           };
/*    */         
/* 58 */         FileUtils.moveFile(updateResponse.getFile(), file);
/* 59 */       } catch (IOException iOException) {
/* 60 */         iOException.printStackTrace();
/*    */       } 
/*    */     }
/*    */     
/* 64 */     return updateResponse;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/UpdateServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */