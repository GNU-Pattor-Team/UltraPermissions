/*    */ package me.TechsCode.UltraPermissions.base.views.settings.mysqlpane;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.misc.Setter;
/*    */ 
/*    */ public class SetupStage
/*    */ {
/*    */   private final String fieldName;
/*    */   private final String defaultValue;
/*    */   private final Setter<String> setFunction;
/*    */   
/*    */   public SetupStage(String paramString1, String paramString2, Setter<String> paramSetter) {
/* 12 */     this.fieldName = paramString1;
/* 13 */     this.defaultValue = paramString2;
/* 14 */     this.setFunction = paramSetter;
/*    */   }
/*    */   
/*    */   public String getFieldName() {
/* 18 */     return this.fieldName;
/*    */   }
/*    */   
/*    */   public String getDefaultValue() {
/* 22 */     return this.defaultValue;
/*    */   }
/*    */   
/*    */   public Setter<String> getSetFunction() {
/* 26 */     return this.setFunction;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/settings/mysqlpane/SetupStage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */