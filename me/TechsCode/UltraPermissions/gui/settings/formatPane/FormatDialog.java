/*    */ package me.TechsCode.UltraPermissions.gui.settings.formatPane;
/*    */ import java.util.Arrays;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.visual.VisualRegistry;
/*    */ import me.TechsCode.UltraPermissions.visual.VisualType;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class FormatDialog extends UserInput {
/* 15 */   private static final Phrase TITLE = Phrase.create("formatDialog.title", "Set Format", Colors.AQUA, new Color[0]);
/* 16 */   private static final Phrase SUBTITLE = Phrase.create("formatDialog.subtitle", "Type in a new format", Colors.GRAY, new Color[0]);
/* 17 */   private static final Phrase ACTION_BAR = Phrase.create("formatDialog.actionBar", "Use the placeholders in the chat", Colors.GRAY, new Color[0]);
/*    */   
/* 19 */   private static final Phrase PLACEHOLDERS_TITLE = Phrase.create("formatDialog.placeholders.title", "Placeholders:", Colors.GREEN, new Color[0]);
/* 20 */   private static final Phrase PLACEHOLDERS_ENTRY = Phrase.create("formatDialog.placeholders.entry", "**>** %placeholder% **-** %description%", Colors.GRAY, new Color[] { Colors.BLUE, Colors.YELLOW });
/* 21 */   private static final Phrase PLACEHOLDERS_OTHER = Phrase.create("formatDialog.placeholders.other", "and **{Player}** or **{DisplayName}**", Colors.GRAY, new Color[] { Colors.BLUE, Colors.BLUE });
/*    */   
/* 23 */   private static final Phrase DEFAULT = Phrase.create("formatDialog.default", "Default: **%format%**", Colors.GOLD, new Color[] { Colors.WHITE });
/*    */   
/*    */   private final UltraPermissions plugin;
/*    */   private final VisualType type;
/*    */   
/*    */   public FormatDialog(Player paramPlayer, UltraPermissions paramUltraPermissions, VisualType paramVisualType) {
/* 29 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, TITLE, SUBTITLE, ACTION_BAR);
/*    */     
/* 31 */     this.plugin = paramUltraPermissions;
/* 32 */     this.type = paramVisualType;
/*    */     
/* 34 */     paramPlayer.sendMessage("");
/* 35 */     paramPlayer.sendMessage(PLACEHOLDERS_TITLE.get());
/* 36 */     Arrays.<UpermsPlaceholder>stream(UltraPermissions.placeholders)
/* 37 */       .forEach(paramUpermsPlaceholder -> {
/*    */           String str = PLACEHOLDERS_ENTRY.get().replace("%placeholder%", paramUpermsPlaceholder.getNativePlaceholder()).replace("%description%", paramUpermsPlaceholder.getDescription());
/*    */ 
/*    */           
/*    */           paramPlayer.sendMessage(str);
/*    */         });
/*    */ 
/*    */     
/* 45 */     paramPlayer.sendMessage(PLACEHOLDERS_OTHER.get());
/* 46 */     paramPlayer.sendMessage("");
/* 47 */     paramPlayer.sendMessage(DEFAULT.get().replace("%format%", paramVisualType.getDefaultFormat()));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onResult(String paramString) {
/* 52 */     ((VisualRegistry)this.plugin.getVisualRegistry().get()).setFormat(this.type, paramString);
/* 53 */     reopen();
/* 54 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClose(Player paramPlayer) {
/* 59 */     reopen();
/*    */   }
/*    */   
/*    */   public abstract void reopen();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/settings/formatPane/FormatDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */