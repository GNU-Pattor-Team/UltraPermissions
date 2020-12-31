/*    */ package me.TechsCode.UltraPermissions;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.UUID;
/*    */ import me.TechsCode.UltraPermissions.base.registry.RegistryStorable;
/*    */ 
/*    */ public class PrivateRegistry
/*    */   extends RegistryStorable
/*    */ {
/*    */   private UUID serverIdentifier;
/*    */   
/*    */   public PrivateRegistry() {
/* 13 */     super("private");
/*    */     
/* 15 */     this.serverIdentifier = UUID.randomUUID();
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(JsonObject paramJsonObject) {
/* 20 */     this.serverIdentifier = UUID.fromString(paramJsonObject.get("serverIdentifier").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonObject getState() {
/* 25 */     JsonObject jsonObject = new JsonObject();
/* 26 */     jsonObject.addProperty("serverIdentifier", this.serverIdentifier.toString());
/* 27 */     return jsonObject;
/*    */   }
/*    */   
/*    */   public UUID getServerIdentifier() {
/* 31 */     return this.serverIdentifier;
/*    */   }
/*    */   
/*    */   public void setServerIdentifier(UUID paramUUID) {
/* 35 */     this.serverIdentifier = paramUUID;
/* 36 */     sync();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/PrivateRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */