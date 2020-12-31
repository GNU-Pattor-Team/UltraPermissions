/*    */ package me.TechsCode.UltraPermissions;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import me.TechsCode.UltraPermissions.base.registry.RegistryStorable;
/*    */ 
/*    */ public class PublicRegistry
/*    */   extends RegistryStorable {
/*    */   private boolean defaultPermissions;
/*    */   private DefaultGroupAssignOption defaultGroupAssignOption;
/*    */   
/*    */   public PublicRegistry() {
/* 12 */     super("public");
/*    */     
/* 14 */     this.defaultPermissions = false;
/* 15 */     this.defaultGroupAssignOption = DefaultGroupAssignOption.FIRST_JOIN;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(JsonObject paramJsonObject) {
/* 20 */     this.defaultPermissions = paramJsonObject.get("defaultPermissions").getAsBoolean();
/* 21 */     this.defaultGroupAssignOption = DefaultGroupAssignOption.valueOf(paramJsonObject.get("defaultAssigner").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonObject getState() {
/* 26 */     JsonObject jsonObject = new JsonObject();
/* 27 */     jsonObject.addProperty("defaultPermissions", Boolean.valueOf(this.defaultPermissions));
/* 28 */     jsonObject.addProperty("defaultAssigner", this.defaultGroupAssignOption.name());
/* 29 */     return jsonObject;
/*    */   }
/*    */   
/*    */   public boolean isDefaultPermissions() {
/* 33 */     return this.defaultPermissions;
/*    */   }
/*    */   
/*    */   public void setDefaultPermissions(boolean paramBoolean) {
/* 37 */     this.defaultPermissions = paramBoolean;
/* 38 */     sync();
/*    */   }
/*    */   
/*    */   public DefaultGroupAssignOption getDefaultAssignOption() {
/* 42 */     return this.defaultGroupAssignOption;
/*    */   }
/*    */   
/*    */   public void setDefaultGroupAssignOption(DefaultGroupAssignOption paramDefaultGroupAssignOption) {
/* 46 */     this.defaultGroupAssignOption = paramDefaultGroupAssignOption;
/* 47 */     sync();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/PublicRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */