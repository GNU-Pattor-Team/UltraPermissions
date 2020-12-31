/*    */ package me.TechsCode.UltraPermissions.base.gui.pageableview;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ 
/*    */ public abstract class BasicSearch<OBJ>
/*    */   extends SearchFeature<OBJ> {
/*  9 */   public static Phrase TITLE = Phrase.create("pageableView.basicSearch.title", "Search");
/* 10 */   public static Phrase ACTION = Phrase.create("pageableView.basicSearch.action", "Click to search", Colors.GRAY, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/*    */   
/*    */   public BasicSearch() {
/* 13 */     super(XMaterial.COMPASS, TITLE.get(), ACTION.get());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/gui/pageableview/BasicSearch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */