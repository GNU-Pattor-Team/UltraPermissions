/*    */ package me.TechsCode.UltraPermissions.base.reflection.indexer;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.security.CodeSource;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipInputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClasspathIndexer
/*    */ {
/*    */   public static NodeList index() {
/* 14 */     NodeList nodeList = new NodeList();
/*    */     
/*    */     try {
/* 17 */       CodeSource codeSource = ClasspathIndexer.class.getProtectionDomain().getCodeSource();
/* 18 */       if (codeSource != null) {
/* 19 */         URL uRL = codeSource.getLocation();
/* 20 */         ZipInputStream zipInputStream = new ZipInputStream(uRL.openStream());
/*    */         while (true) {
/* 22 */           ZipEntry zipEntry = zipInputStream.getNextEntry();
/* 23 */           if (zipEntry == null) {
/*    */             break;
/*    */           }
/* 26 */           nodeList.add(new Node(zipEntry.getName()));
/*    */         } 
/*    */       } 
/* 29 */     } catch (IOException iOException) {
/* 30 */       iOException.printStackTrace();
/*    */     } 
/*    */     
/* 33 */     return nodeList;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/reflection/indexer/ClasspathIndexer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */