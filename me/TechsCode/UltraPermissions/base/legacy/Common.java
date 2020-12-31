/*    */ package me.TechsCode.UltraPermissions.base.legacy;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.gui.Action;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ 
/*    */ public class Common
/*    */ {
/* 13 */   public static Phrase BACK_TITLE = Phrase.create("backButton.title", "Back");
/* 14 */   public static Phrase BACK_ACTION = Phrase.create("backButton.action", "Click to go back", Colors.GRAY, new Color[0]);
/*    */   
/*    */   public static void BackButton(Button paramButton, Action paramAction) {
/* 17 */     paramButton.material(XMaterial.OAK_SIGN)
/* 18 */       .name(Animation.fading(BACK_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 19 */           })).lore(new String[] { BACK_ACTION.get() });
/*    */     
/* 21 */     paramButton.action(paramAction);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/Common.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */