/*    */ package me.TechsCode.UltraPermissions.base;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*    */ import me.TechsCode.UltraPermissions.base.registry.RegistryStorable;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ 
/*    */ public class AppearanceRegistry
/*    */   extends RegistryStorable {
/*    */   private String prefix;
/*    */   private final String defaultPrefix;
/*    */   
/*    */   public AppearanceRegistry(TechPlugin<?> paramTechPlugin) {
/* 14 */     super("appearance");
/*    */     
/* 16 */     this.prefix = Colors.BLUE + String.join(" ", (CharSequence[])Tools.splitCamelCase(paramTechPlugin.getName())) + ">";
/* 17 */     this.defaultPrefix = this.prefix;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(JsonObject paramJsonObject) {
/* 22 */     this.prefix = paramJsonObject.get("prefix").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonObject getState() {
/* 27 */     JsonObject jsonObject = new JsonObject();
/* 28 */     jsonObject.addProperty("prefix", this.prefix.trim());
/* 29 */     return jsonObject;
/*    */   }
/*    */   
/*    */   public String getPrefix() {
/* 33 */     return this.prefix;
/*    */   }
/*    */   
/*    */   public void setPrefix(String paramString) {
/* 37 */     this.prefix = paramString;
/* 38 */     sync();
/*    */   }
/*    */   
/*    */   public boolean isPrefixModified() {
/* 42 */     return (this.prefix.length() != 0 && !this.prefix.equals(this.defaultPrefix));
/*    */   }
/*    */   
/*    */   public boolean isPrefixDisabled() {
/* 46 */     return (this.prefix.length() == 0);
/*    */   }
/*    */   
/*    */   public void resetPrefix() {
/* 50 */     this.prefix = this.defaultPrefix;
/* 51 */     sync();
/*    */   }
/*    */   
/*    */   public void disablePrefix() {
/* 55 */     this.prefix = "";
/* 56 */     sync();
/*    */   }
/*    */   
/*    */   public void enablePrefix() {
/* 60 */     resetPrefix();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/AppearanceRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */