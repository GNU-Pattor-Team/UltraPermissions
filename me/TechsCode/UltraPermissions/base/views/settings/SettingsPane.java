/*    */ package me.TechsCode.UltraPermissions.base.views.settings;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class SettingsPane
/*    */ {
/*    */   protected Player p;
/*    */   private SettingsView view;
/*    */   
/*    */   public SettingsPane(Player paramPlayer, SettingsView paramSettingsView) {
/* 13 */     this.p = paramPlayer;
/* 14 */     this.view = paramSettingsView;
/*    */   }
/*    */   
/*    */   public abstract String getName();
/*    */   
/*    */   public abstract XMaterial getIcon();
/*    */   
/*    */   public abstract void construct(Model paramModel);
/*    */   
/*    */   public void reopen() {
/* 24 */     this.view.reopen();
/*    */   }
/*    */   
/*    */   public int[] getInnerContainerSlots() {
/* 28 */     return new int[] { 20, 21, 22, 23, 24, 25, 26, 29, 30, 31, 32, 33, 34, 35 };
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/settings/SettingsPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */