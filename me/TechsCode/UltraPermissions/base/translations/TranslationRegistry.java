/*    */ package me.TechsCode.UltraPermissions.base.translations;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.registry.RegistryStorable;
/*    */ 
/*    */ public class TranslationRegistry
/*    */   extends RegistryStorable {
/*    */   private String language;
/*    */   
/*    */   public TranslationRegistry() {
/* 11 */     super("translation");
/*    */ 
/*    */     
/* 14 */     this.language = "English";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(JsonObject paramJsonObject) {
/* 19 */     this.language = paramJsonObject.get("language").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonObject getState() {
/* 24 */     JsonObject jsonObject = new JsonObject();
/* 25 */     jsonObject.addProperty("language", this.language);
/* 26 */     return jsonObject;
/*    */   }
/*    */   
/*    */   public String getLanguage() {
/* 30 */     return this.language;
/*    */   }
/*    */   
/*    */   public void setLanguage(String paramString) {
/* 34 */     this.language = paramString;
/* 35 */     sync();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/translations/TranslationRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */