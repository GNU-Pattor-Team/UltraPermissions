/*    */ package me.TechsCode.UltraPermissions;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DefaultGroupAssignOption
/*    */ {
/*  7 */   FIRST_JOIN("Only add default groups on the first join", "Default Groups will be only added on first join"),
/*  8 */   NO_GROUP("If a player has no groups, assign all default groups", "Default Groups will be assigned if a player has no groups"),
/*  9 */   ALWAYS_ASSIGN("Always force every player to all default groups", "Default Groups will always be assigned to all players");
/*    */   private final String description;
/*    */   private final String explanation;
/*    */   
/*    */   DefaultGroupAssignOption(String paramString1, String paramString2) {
/* 14 */     this.description = paramString1;
/* 15 */     this.explanation = paramString2;
/*    */   }
/*    */   
/*    */   public DefaultGroupAssignOption next() {
/* 19 */     switch (this) { case FIRST_JOIN:
/* 20 */         return NO_GROUP;
/* 21 */       case NO_GROUP: return ALWAYS_ASSIGN;
/* 22 */       case ALWAYS_ASSIGN: return FIRST_JOIN; }
/*    */ 
/*    */     
/* 25 */     return null;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 29 */     return this.description;
/*    */   }
/*    */   
/*    */   public String getExplanation() {
/* 33 */     return this.explanation;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/DefaultGroupAssignOption.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */