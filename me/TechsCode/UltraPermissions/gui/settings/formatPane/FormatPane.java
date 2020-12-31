/*    */ package me.TechsCode.UltraPermissions.gui.settings.formatPane;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsPane;
/*    */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsView;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.visual.VisualRegistry;
/*    */ import me.TechsCode.UltraPermissions.visual.VisualType;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class FormatPane
/*    */   extends SettingsPane
/*    */ {
/*    */   private UltraPermissions plugin;
/*    */   
/*    */   public FormatPane(Player paramPlayer, SettingsView paramSettingsView, UltraPermissions paramUltraPermissions) {
/* 26 */     super(paramPlayer, paramSettingsView);
/*    */     
/* 28 */     this.plugin = paramUltraPermissions;
/*    */   }
/*    */   
/* 31 */   private static final Phrase NAME = Phrase.create("formatPane.name", "Chat & Tab List Format");
/*    */ 
/*    */   
/*    */   public String getName() {
/* 35 */     return NAME.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public XMaterial getIcon() {
/* 40 */     return XMaterial.NAME_TAG;
/*    */   }
/*    */ 
/*    */   
/*    */   public void construct(Model paramModel) {
/* 45 */     for (VisualType visualType : VisualType.values()) {
/* 46 */       paramModel.button(visualType.getGuiSlot() + 9, paramButton -> FormatButton(paramButton, paramVisualType));
/*    */     }
/*    */   }
/*    */   
/* 50 */   private static final Phrase ENTRY_CHANGE_ACTION = Phrase.create("formatPane.entry.changeAction", "**Left Click** to change format", Colors.GRAY, new Color[] { Colors.AQUA });
/* 51 */   private static final Phrase ENTRY_DISABLE_ACTION = Phrase.create("formatPane.entry.disableAction", "**Right Click** to **disable**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/* 52 */   private static final Phrase ENTRY_DEFAULT_ACTION = Phrase.create("formatPane.entry.defaultAction", "**Press Q** to reset format to **default**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GREEN });
/* 53 */   private static final Phrase ENTRY_FORMAT_TITLE = Phrase.create("formatPane.entry.format.title", "Format:", Colors.GREEN, new Color[0]);
/* 54 */   private static final Phrase ENTRY_FORMAT_DISABLED = Phrase.create("formatPane.entry.format.disabled", "Feature disabled", Colors.RED, new Color[0]);
/*    */   
/*    */   private void FormatButton(Button paramButton, VisualType paramVisualType) {
/* 57 */     paramButton.material(paramVisualType.getMaterial())
/* 58 */       .name(Animation.wave(Tools.getEnumName((Enum)paramVisualType), new Color[] { Colors.GOLD, Colors.WHITE
/* 59 */           })).lore(new String[] {
/* 60 */           ENTRY_CHANGE_ACTION.get(), ENTRY_DISABLE_ACTION
/* 61 */           .get()
/*    */         });
/*    */     
/* 64 */     String str = ((VisualRegistry)this.plugin.getVisualRegistry().get()).getFormat(paramVisualType);
/*    */     
/* 66 */     if (!paramVisualType.getDefaultFormat().equals("none") && (
/* 67 */       str == null || !str.equals(paramVisualType.getDefaultFormat()))) {
/* 68 */       paramButton.item().appendLore(new String[] { ENTRY_DEFAULT_ACTION.get() });
/*    */     }
/*    */ 
/*    */     
/* 72 */     paramButton.item().appendLore(new String[] { "", ENTRY_FORMAT_TITLE
/*    */           
/* 74 */           .get(), (str == null) ? ENTRY_FORMAT_DISABLED
/* 75 */           .get() : (Colors.WHITE + str) });
/*    */ 
/*    */     
/* 78 */     paramButton.action(paramActionType -> {
/*    */           if (paramActionType == ActionType.Q) {
/*    */             ((VisualRegistry)this.plugin.getVisualRegistry().get()).resetFormat(paramVisualType);
/*    */             
/*    */             return;
/*    */           } 
/*    */           if (paramActionType == ActionType.RIGHT) {
/*    */             ((VisualRegistry)this.plugin.getVisualRegistry().get()).setFormat(paramVisualType, "none");
/*    */             return;
/*    */           } 
/*    */           new FormatDialog(this.p, this.plugin, paramVisualType)
/*    */             {
/*    */               public void reopen()
/*    */               {
/* 92 */                 FormatPane.this.reopen();
/*    */               }
/*    */             };
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/settings/formatPane/FormatPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */