/*    */ package me.TechsCode.UltraPermissions.visual;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import me.TechsCode.UltraPermissions.base.registry.RegistryStorable;
/*    */ import me.TechsCode.UltraPermissions.base.registry.Switchable;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*    */ 
/*    */ public class VisualRegistry
/*    */   extends RegistryStorable
/*    */   implements Switchable {
/*    */   private boolean switchedTo;
/*    */   private Map<VisualType, String> formats;
/*    */   private boolean editingNametags;
/*    */   
/*    */   public VisualRegistry() {
/* 19 */     super("visual");
/*    */     
/* 21 */     this.switchedTo = false;
/* 22 */     this.formats = new HashMap<>();
/* 23 */     this.editingNametags = true;
/*    */     
/* 25 */     for (VisualType visualType : VisualType.values()) {
/* 26 */       this.formats.put(visualType, visualType.getDefaultFormat());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(JsonObject paramJsonObject) {
/* 32 */     this.switchedTo = paramJsonObject.get("switchedTo").getAsBoolean();
/*    */     
/* 34 */     this.formats = new HashMap<>();
/* 35 */     JsonObject jsonObject = paramJsonObject.getAsJsonObject("formats");
/* 36 */     jsonObject.entrySet().forEach(paramEntry -> this.formats.put(VisualType.valueOf((String)paramEntry.getKey()), Text.color(((JsonElement)paramEntry.getValue()).getAsString())));
/*    */ 
/*    */ 
/*    */     
/* 40 */     this.editingNametags = (!paramJsonObject.has("editingNametags") || paramJsonObject.get("editingNametags").getAsBoolean());
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonObject getState() {
/* 45 */     JsonObject jsonObject1 = new JsonObject();
/*    */     
/* 47 */     jsonObject1.addProperty("switchedTo", Boolean.valueOf(this.switchedTo));
/*    */     
/* 49 */     JsonObject jsonObject2 = new JsonObject();
/* 50 */     this.formats.forEach((paramVisualType, paramString) -> paramJsonObject.addProperty(paramVisualType.name(), paramString));
/*    */     
/* 52 */     jsonObject1.add("formats", (JsonElement)jsonObject2);
/* 53 */     jsonObject1.addProperty("editingNametags", Boolean.valueOf(this.editingNametags));
/*    */     
/* 55 */     return jsonObject1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSwitchedTo() {
/* 60 */     return this.switchedTo;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setSwitchedTo(boolean paramBoolean) {
/* 65 */     this.switchedTo = paramBoolean;
/* 66 */     sync();
/*    */   }
/*    */   
/*    */   public void setFormat(VisualType paramVisualType, String paramString) {
/* 70 */     this.formats.put(paramVisualType, Text.color(paramString));
/* 71 */     sync();
/*    */   }
/*    */   
/*    */   public String getFormat(VisualType paramVisualType) {
/* 75 */     String str = this.formats.get(paramVisualType);
/*    */     
/* 77 */     return str.equalsIgnoreCase("none") ? null : str;
/*    */   }
/*    */   
/*    */   public void resetFormat(VisualType paramVisualType) {
/* 81 */     setFormat(paramVisualType, paramVisualType.getDefaultFormat());
/*    */   }
/*    */   
/*    */   public boolean isEditingNametags() {
/* 85 */     return this.editingNametags;
/*    */   }
/*    */   
/*    */   public void setEditingNametags(boolean paramBoolean) {
/* 89 */     this.editingNametags = paramBoolean;
/* 90 */     sync();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/visual/VisualRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */