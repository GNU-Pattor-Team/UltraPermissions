/*    */ package me.TechsCode.UltraPermissions.visual;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ 
/*    */ public enum VisualType
/*    */ {
/*  7 */   CHAT("{Prefixes} &7{Player}&b: &f{Message}", XMaterial.PAPER, 12),
/*  8 */   TABLIST("{Prefix} &f{Player}", XMaterial.ITEM_FRAME, 14),
/*  9 */   DISPLAY_NAME("none", XMaterial.NAME_TAG, 16);
/*    */   
/*    */   private final String defaultFormat;
/*    */   private final XMaterial material;
/*    */   private final int guiSlot;
/*    */   
/*    */   VisualType(String paramString1, XMaterial paramXMaterial, int paramInt1) {
/* 16 */     this.defaultFormat = paramString1;
/* 17 */     this.material = paramXMaterial;
/* 18 */     this.guiSlot = paramInt1;
/*    */   }
/*    */   
/*    */   public XMaterial getMaterial() {
/* 22 */     return this.material;
/*    */   }
/*    */   
/*    */   public String getDefaultFormat() {
/* 26 */     return this.defaultFormat;
/*    */   }
/*    */   
/*    */   public int getGuiSlot() {
/* 30 */     return this.guiSlot;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/visual/VisualType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */