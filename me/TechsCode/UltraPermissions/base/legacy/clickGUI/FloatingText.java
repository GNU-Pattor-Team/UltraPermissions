/*    */ package me.TechsCode.UltraPermissions.base.legacy.clickGUI;
/*    */ 
/*    */ import org.bukkit.entity.ArmorStand;
/*    */ 
/*    */ public abstract class FloatingText
/*    */   extends FloatingElement
/*    */ {
/*    */   public abstract String getText();
/*    */   
/*    */   public void apply(ArmorStand paramArmorStand) {
/* 11 */     String str = getText();
/* 12 */     setShown((str != null));
/*    */     
/* 14 */     if (paramArmorStand != null && str != null) {
/* 15 */       paramArmorStand.setCustomName(str);
/* 16 */       paramArmorStand.setCustomNameVisible(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double getYOffset() {
/* 23 */     return 2.5D;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/clickGUI/FloatingText.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */