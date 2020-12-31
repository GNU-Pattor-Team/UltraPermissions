/*     */ package me.TechsCode.UltraPermissions.base.views.settings;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.base.AppearanceRegistry;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class CustomisationPane extends SettingsPane {
/*  19 */   private static final Phrase TITLE = Phrase.create("customisationPane.title", "Customisation");
/*     */   
/*  21 */   private static final Phrase PREFIX_TITLE = Phrase.create("customisationPane.prefix.title", "Prefix");
/*  22 */   private static final Phrase PREFIX_RESET_ACTION = Phrase.create("customisationPane.prefix.resetAction", "**Left Click** to **reset** the prefix", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GOLD });
/*  23 */   private static final Phrase PREFIX_CHANGE_ACTION = Phrase.create("customisationPane.prefix.changeAction", "**Left Click** to **change** the prefix", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GREEN });
/*  24 */   private static final Phrase PREFIX_DISABLE_ACTION = Phrase.create("customisationPane.prefix.disableAction", "**Press Q** to **disable** the prefix", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*  25 */   private static final Phrase PREFIX_ENABLE_ACTION = Phrase.create("customisationPane.prefix.enableAction", "Click to **enable** the prefix", Colors.GRAY, new Color[] { Colors.GREEN });
/*  26 */   private static final Phrase PREFIX_ATTRIBUTE = Phrase.create("customisationPane.prefix.attribute", "Prefix: **%prefix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*     */   private final SpigotTechPlugin plugin;
/*     */   
/*     */   public CustomisationPane(Player paramPlayer, SettingsView paramSettingsView, SpigotTechPlugin paramSpigotTechPlugin) {
/*  31 */     super(paramPlayer, paramSettingsView);
/*     */     
/*  33 */     this.plugin = paramSpigotTechPlugin;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  38 */     return TITLE.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public XMaterial getIcon() {
/*  43 */     return XMaterial.CRAFTING_TABLE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void construct(Model paramModel) {
/*  48 */     paramModel.button(23, this::PrefixButton);
/*     */   }
/*     */   
/*     */   private void PrefixButton(Button paramButton) {
/*  52 */     AppearanceRegistry appearanceRegistry = this.plugin.getAppearanceRegistry();
/*     */     
/*  54 */     paramButton.material(XMaterial.NAME_TAG)
/*  55 */       .name(Animation.wave(PREFIX_TITLE.get(), new Color[] { Colors.Gold, Colors.YELLOW
/*  56 */           })).lore(new String[] {
/*  57 */           (appearanceRegistry.isPrefixModified() ? PREFIX_RESET_ACTION : PREFIX_CHANGE_ACTION).get()
/*     */         });
/*     */     
/*  60 */     if (appearanceRegistry.isPrefixModified()) {
/*  61 */       paramButton.item().lore(new String[] { PREFIX_RESET_ACTION
/*  62 */             .get(), PREFIX_DISABLE_ACTION
/*  63 */             .get() });
/*     */     }
/*  65 */     else if (appearanceRegistry.isPrefixDisabled()) {
/*  66 */       paramButton.item().lore(new String[] { PREFIX_ENABLE_ACTION
/*  67 */             .get() });
/*     */     } else {
/*     */       
/*  70 */       paramButton.item().lore(new String[] { PREFIX_CHANGE_ACTION
/*  71 */             .get(), PREFIX_DISABLE_ACTION
/*  72 */             .get() });
/*     */     } 
/*     */ 
/*     */     
/*  76 */     paramButton.item().appendLore(new String[] { "", PREFIX_ATTRIBUTE
/*     */           
/*  78 */           .get().replace("%prefix%", appearanceRegistry.isPrefixDisabled() ? (Colors.RED + Words.DISABLED.get()) : appearanceRegistry.getPrefix()) });
/*     */ 
/*     */     
/*  81 */     paramButton.action(paramActionType -> {
/*     */           if (paramAppearanceRegistry.isPrefixDisabled()) {
/*     */             paramAppearanceRegistry.enablePrefix();
/*     */             
/*     */             return;
/*     */           } 
/*     */           if (paramActionType == ActionType.Q) {
/*     */             paramAppearanceRegistry.disablePrefix();
/*     */             return;
/*     */           } 
/*     */           if (paramAppearanceRegistry.isPrefixModified()) {
/*     */             paramAppearanceRegistry.resetPrefix();
/*     */           } else {
/*     */             new PrefixSetDialog(this.p, this.plugin)
/*     */               {
/*     */                 void setPrefix(String param1String)
/*     */                 {
/*  98 */                   registry.setPrefix(param1String);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 void reopen() {
/* 103 */                   CustomisationPane.this.reopen();
/*     */                 }
/*     */               };
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   static abstract class PrefixSetDialog
/*     */     extends UserInput
/*     */   {
/* 113 */     private static final Phrase TITLE = Phrase.create("customisationPane.prefix.change.title", "Prefix", Colors.AQUA, new Color[0]);
/* 114 */     private static final Phrase SUBTITLE = Phrase.create("customisationPane.prefix.change.subtitle", "Type in a prefix", Colors.GRAY, new Color[0]);
/*     */     
/*     */     public PrefixSetDialog(Player param1Player, SpigotTechPlugin param1SpigotTechPlugin) {
/* 117 */       super(param1Player, param1SpigotTechPlugin, TITLE, SUBTITLE);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean onResult(String param1String) {
/* 122 */       setPrefix(Text.color(param1String));
/* 123 */       reopen();
/* 124 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void onClose(Player param1Player) {
/* 129 */       reopen();
/*     */     }
/*     */     
/*     */     abstract void setPrefix(String param1String);
/*     */     
/*     */     abstract void reopen();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/settings/CustomisationPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */