/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.migration.MigrationAssistant;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class MigrationView extends GUI {
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public MigrationView(Player paramPlayer, UltraPermissions paramUltraPermissions, MigrationAssistant paramMigrationAssistant) {
/* 19 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 21 */     this.plugin = paramUltraPermissions;
/* 22 */     this.assistant = paramMigrationAssistant;
/*    */   }
/*    */   private final MigrationAssistant assistant;
/* 25 */   private static final Phrase TITLE = Phrase.create("migrationView.title", "Import > %plugin%");
/*    */   
/* 27 */   private static final Phrase START_TITLE = Phrase.create("migrationView.start.title", "Import Data");
/* 28 */   private static final Phrase START_ACTION = Phrase.create("migrationView.start.action", "Click to **convert** data", Colors.GRAY, new Color[] { Colors.LIGHT_PURPLE });
/* 29 */   private static final Phrase START_EXPLANATION = Phrase.create("migrationView.start.explanation", "Your existing data will be overwritten.", Colors.GRAY, new Color[0]);
/* 30 */   private static final Phrase START_DESC = Phrase.create("migrationView.start.desc", "If you dont want to convert, delete %plugin%", Colors.GRAY, new Color[0]);
/*    */ 
/*    */   
/*    */   protected void construct(Model paramModel) {
/* 34 */     paramModel.setTitle(TITLE.get().replace("%plugin%", this.assistant.getPluginName()));
/* 35 */     paramModel.setSlots(45);
/*    */     
/* 37 */     paramModel.button(23, paramButton -> {
/*    */           paramButton.material(XMaterial.END_PORTAL_FRAME).name(Animation.wave(START_TITLE.get(), new Color[] { Colors.LightPink, Colors.WHITE })).lore(new String[] { START_ACTION.get(), "", START_EXPLANATION.get(), START_DESC.get().replace("%plugin%", this.assistant.getPluginName()) });
/*    */           paramButton.action(());
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/MigrationView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */