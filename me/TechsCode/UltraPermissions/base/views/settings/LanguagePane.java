/*    */ package me.TechsCode.UltraPermissions.base.views.settings;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.translations.TranslationManager;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class LanguagePane
/*    */   extends SettingsPane {
/* 22 */   private static final Phrase NAME = Phrase.create("languagePane.name", "Language");
/* 23 */   private static final Phrase SELECT_ACTION = Phrase.create("languagePane.select.action", "**Click** to **select** this language", Colors.GRAY, new Color[] { Colors.AQUA, Colors.YELLOW });
/* 24 */   private static final Phrase SELECTED_INDICATOR = Phrase.create("languagePane.select.indicator", "This language is **currently** selected", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 25 */   private static final Phrase PHRASES = Phrase.create("languagePane.phrases", "Phrases: **%phrases%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 26 */   private static final Phrase COVERAGE = Phrase.create("languagePane.coverage", "Coverage: **%coverage% %**", Colors.GRAY, new Color[] { Colors.GREEN });
/*    */   
/*    */   private final SpigotTechPlugin plugin;
/*    */   
/*    */   public LanguagePane(Player paramPlayer, SettingsView paramSettingsView, SpigotTechPlugin paramSpigotTechPlugin) {
/* 31 */     super(paramPlayer, paramSettingsView);
/*    */     
/* 33 */     this.plugin = paramSpigotTechPlugin;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 38 */     return NAME.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public XMaterial getIcon() {
/* 43 */     return XMaterial.WRITABLE_BOOK;
/*    */   }
/*    */ 
/*    */   
/*    */   public void construct(Model paramModel) {
/* 48 */     int[] arrayOfInt = getInnerContainerSlots();
/*    */     
/* 50 */     TranslationManager translationManager = this.plugin.getTranslationManager();
/*    */     
/* 52 */     Map map = (Map)translationManager.getAvailableLanguages().stream().collect(Collectors.toMap(paramString -> paramString, paramString -> Integer.valueOf(paramTranslationManager.getPhrases(paramString).size())));
/*    */     
/* 54 */     int i = ((Integer)Collections.<Integer>max(map.values())).intValue();
/*    */ 
/*    */ 
/*    */     
/* 58 */     Iterator<String> iterator = translationManager.getAvailableLanguages().stream().filter(paramString -> (paramTranslationManager.getPhrases(paramString).size() > 0)).iterator();
/*    */     
/* 60 */     for (int j : arrayOfInt) {
/* 61 */       if (iterator.hasNext()) {
/* 62 */         String str = iterator.next();
/*    */         
/* 64 */         int k = ((Integer)map.get(str)).intValue();
/* 65 */         int m = Math.round(k / i * 100.0F);
/* 66 */         boolean bool = translationManager.getSelectedLanguage().equals(str);
/*    */         
/* 68 */         paramModel.button(j, paramButton -> LanguageButton(paramButton, paramString, paramInt1, paramInt2, paramBoolean));
/*    */       } else {
/* 70 */         paramModel.button(j, paramButton -> paramButton.material(XMaterial.WHITE_STAINED_GLASS_PANE).name());
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void LanguageButton(Button paramButton, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 78 */     paramButton.material(XMaterial.PAPER)
/* 79 */       .name(Animation.wave(paramString, new Color[] { Colors.GOLD, Colors.YELLOW
/* 80 */           })).lore(new String[] {
/* 81 */           paramBoolean ? SELECTED_INDICATOR.get() : SELECT_ACTION.get(), "", PHRASES
/*    */           
/* 83 */           .get().replace("%phrases%", paramInt1 + ""), COVERAGE
/* 84 */           .get().replace("%coverage%", paramInt2 + "")
/*    */         });
/*    */     
/* 87 */     if (paramBoolean) {
/* 88 */       paramButton.item().showEnchantments(false).addEnchantment(Enchantment.LUCK, 1);
/*    */     }
/*    */     
/* 91 */     paramButton.action(paramActionType -> {
/*    */           if (!paramBoolean)
/*    */             this.plugin.getTranslationManager().setSelectedLanguage(paramString); 
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/settings/LanguagePane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */