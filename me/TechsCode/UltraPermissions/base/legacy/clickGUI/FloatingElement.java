/*    */ package me.TechsCode.UltraPermissions.base.legacy.clickGUI;
/*    */ 
/*    */ import org.bukkit.entity.ArmorStand;
/*    */ 
/*    */ public abstract class FloatingElement
/*    */ {
/*    */   private boolean shown = true;
/*    */   private boolean hovering;
/*    */   
/*    */   public void hovering(boolean paramBoolean) {
/* 11 */     if (this.hovering == paramBoolean)
/*    */       return; 
/* 13 */     this.hovering = paramBoolean;
/*    */     
/* 15 */     onHoverChange(paramBoolean);
/*    */   }
/*    */   
/*    */   public boolean isHovering() {
/* 19 */     return this.hovering;
/*    */   }
/*    */   
/*    */   public boolean isShown() {
/* 23 */     return this.shown;
/*    */   }
/*    */   
/*    */   public void setShown(boolean paramBoolean) {
/* 27 */     if (this.shown == paramBoolean)
/*    */       return; 
/* 29 */     this.shown = paramBoolean;
/*    */   }
/*    */   
/*    */   public abstract void apply(ArmorStand paramArmorStand);
/*    */   
/*    */   public abstract double getYOffset();
/*    */   
/*    */   public abstract double getX();
/*    */   
/*    */   public abstract double getY();
/*    */   
/*    */   public abstract double getRadius();
/*    */   
/*    */   public abstract void click();
/*    */   
/*    */   protected abstract void onHoverChange(boolean paramBoolean);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/clickGUI/FloatingElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */