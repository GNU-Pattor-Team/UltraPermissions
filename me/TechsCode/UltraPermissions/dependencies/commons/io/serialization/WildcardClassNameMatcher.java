/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.io.serialization;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FilenameUtils;
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
/*    */ final class WildcardClassNameMatcher
/*    */   implements ClassNameMatcher
/*    */ {
/*    */   private final String pattern;
/*    */   
/*    */   public WildcardClassNameMatcher(String paramString) {
/* 40 */     this.pattern = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean matches(String paramString) {
/* 45 */     return FilenameUtils.wildcardMatch(paramString, this.pattern);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/serialization/WildcardClassNameMatcher.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */