/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.event;
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
/*    */ public enum Level
/*    */ {
/* 18 */   ERROR(40, "ERROR"), WARN(30, "WARN"), INFO(20, "INFO"), DEBUG(10, "DEBUG"),
/* 19 */   TRACE(0, "TRACE");
/*    */   
/*    */   private int levelInt;
/*    */   private String levelStr;
/*    */   
/*    */   Level(int paramInt1, String paramString1) {
/* 25 */     this.levelInt = paramInt1;
/* 26 */     this.levelStr = paramString1;
/*    */   }
/*    */   
/*    */   public int toInt() {
/* 30 */     return this.levelInt;
/*    */   }
/*    */   
/*    */   public static Level intToLevel(int paramInt) {
/* 34 */     switch (paramInt) {
/*    */       case 0:
/* 36 */         return TRACE;
/*    */       case 10:
/* 38 */         return DEBUG;
/*    */       case 20:
/* 40 */         return INFO;
/*    */       case 30:
/* 42 */         return WARN;
/*    */       case 40:
/* 44 */         return ERROR;
/*    */     } 
/* 46 */     throw new IllegalArgumentException("Level integer [" + paramInt + "] not recognized.");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     return this.levelStr;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/event/Level.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */