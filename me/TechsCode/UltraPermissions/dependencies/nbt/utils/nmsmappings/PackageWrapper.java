/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PackageWrapper
/*    */ {
/* 11 */   NMS(new String(new byte[] { 110, 101, 116, 46, 109, 105, 110, 101, 99, 114, 97, 102, 116, 46, 115, 101, 114, 118, 101, 114 })),
/* 12 */   CRAFTBUKKIT(new String(new byte[] { 111, 114, 103, 46, 98, 117, 107, 107, 105, 116, 46, 99, 114, 97, 102, 116, 98, 117, 107, 107, 105, 116 }));
/*    */   
/*    */   private final String uri;
/*    */ 
/*    */   
/*    */   PackageWrapper(String paramString1) {
/* 18 */     this.uri = paramString1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUri() {
/* 25 */     return this.uri;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/nmsmappings/PackageWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */