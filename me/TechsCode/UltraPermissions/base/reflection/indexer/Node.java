/*    */ package me.TechsCode.UltraPermissions.base.reflection.indexer;
/*    */ 
/*    */ import java.util.Optional;
/*    */ 
/*    */ public class Node
/*    */ {
/*    */   private String path;
/*    */   
/*    */   public Node(String paramString) {
/* 10 */     this.path = paramString;
/*    */   }
/*    */   
/*    */   public boolean isClass() {
/* 14 */     return this.path.endsWith(".class");
/*    */   }
/*    */   
/*    */   public String getClassName() {
/* 18 */     return this.path.replace("/", ".").replace(".class", "");
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 22 */     return this.path;
/*    */   }
/*    */   
/*    */   public Optional<Class<?>> getAsClass() {
/* 26 */     if (!isClass()) {
/* 27 */       return Optional.empty();
/*    */     }
/*    */     
/*    */     try {
/* 31 */       return Optional.of(Class.forName(getClassName()));
/* 32 */     } catch (ClassNotFoundException classNotFoundException) {
/* 33 */       return Optional.empty();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/reflection/indexer/Node.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */