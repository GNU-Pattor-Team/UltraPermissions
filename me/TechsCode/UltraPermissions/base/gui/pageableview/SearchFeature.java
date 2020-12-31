/*    */ package me.TechsCode.UltraPermissions.base.gui.pageableview;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ 
/*    */ public abstract class SearchFeature<OBJ>
/*    */ {
/*    */   private XMaterial icon;
/*    */   private String title;
/*    */   private String action;
/*    */   
/*    */   public SearchFeature(XMaterial paramXMaterial, String paramString1, String paramString2) {
/* 12 */     this.icon = paramXMaterial;
/* 13 */     this.title = paramString1;
/* 14 */     this.action = paramString2;
/*    */   }
/*    */   
/*    */   public abstract String[] getSearchableText(OBJ paramOBJ);
/*    */   
/*    */   public XMaterial getIcon() {
/* 20 */     return this.icon;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 24 */     return this.title;
/*    */   }
/*    */   
/*    */   public String getAction() {
/* 28 */     return this.action;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/gui/pageableview/SearchFeature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */