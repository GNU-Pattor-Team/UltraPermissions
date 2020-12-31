/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.builder;
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
/*    */ final class IDKey
/*    */ {
/*    */   private final Object value;
/*    */   private final int id;
/*    */   
/*    */   public IDKey(Object paramObject) {
/* 42 */     this.id = System.identityHashCode(paramObject);
/*    */ 
/*    */ 
/*    */     
/* 46 */     this.value = paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 54 */     return this.id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 63 */     if (!(paramObject instanceof IDKey)) {
/* 64 */       return false;
/*    */     }
/* 66 */     IDKey iDKey = (IDKey)paramObject;
/* 67 */     if (this.id != iDKey.id) {
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     return (this.value == iDKey.value);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/builder/IDKey.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */