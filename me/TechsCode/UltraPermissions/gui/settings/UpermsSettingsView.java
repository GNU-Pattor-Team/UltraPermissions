/*    */ package me.TechsCode.UltraPermissions.gui.settings;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.views.settings.CustomisationPane;
/*    */ import me.TechsCode.UltraPermissions.base.views.settings.LanguagePane;
/*    */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsPane;
/*    */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsView;
/*    */ import me.TechsCode.UltraPermissions.base.views.settings.mysqlpane.MySQLPane;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class UpermsSettingsView extends SettingsView {
/*    */   public UpermsSettingsView(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/* 12 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */   }
/*    */ 
/*    */   
/*    */   public SettingsPane[] getPanes() {
/* 17 */     return new SettingsPane[] { (SettingsPane)new CustomisationPane(this.p, this, this.plugin), (SettingsPane)new FormatPane(this.p, this, (UltraPermissions)this.plugin), (SettingsPane)new LanguagePane(this.p, this, this.plugin), new MiscPane(this.p, this, (UltraPermissions)this.plugin), (SettingsPane)new MySQLPane(this.p, this, this.plugin) };
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/settings/UpermsSettingsView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */