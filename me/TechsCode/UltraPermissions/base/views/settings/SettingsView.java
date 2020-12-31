/*    */ package me.TechsCode.UltraPermissions.base.views.settings;
/*    */ import java.util.Arrays;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.Common;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class SettingsView extends GUI {
/* 17 */   private static final Phrase TITLE = Phrase.create("settingsView.title", "Settings > %");
/*    */   
/* 19 */   private static final Phrase PAGE_SELECTED = Phrase.create("settingsView.select.indicator", "This page is currently **selected**", Colors.GRAY, new Color[] { Colors.GREEN });
/* 20 */   private static final Phrase SELECT_PAGE_ACTION = Phrase.create("settingsView.select.action", "Click to show Settings", Colors.GRAY, new Color[0]);
/*    */   
/* 22 */   private final int[][] layouts = new int[][] { { 5 }, { 4, 6 }, { 4, 5, 6 }, { 3, 4, 6, 7 }, { 3, 4, 5, 6, 7 }, { 2, 3, 4, 6, 7, 8 }, { 2, 3, 4, 5, 6, 7, 8 }, { 1, 2, 3, 4, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
/*    */ 
/*    */ 
/*    */   
/*    */   protected SpigotTechPlugin plugin;
/*    */ 
/*    */ 
/*    */   
/*    */   private int current;
/*    */ 
/*    */ 
/*    */   
/*    */   private SettingsPane[] panes;
/*    */ 
/*    */ 
/*    */   
/*    */   public SettingsView(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/* 39 */     super(paramPlayer, paramSpigotTechPlugin);
/*    */     
/* 41 */     this.plugin = paramSpigotTechPlugin;
/* 42 */     this.current = 0;
/* 43 */     this.panes = getPanes();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private SettingsPane getCurrent() {
/* 51 */     return this.panes[this.current];
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCurrentSlots() {
/* 56 */     return 54;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void construct(Model paramModel) {
/* 61 */     paramModel.setTitle(TITLE.get().replace("%", getCurrent().getName()));
/* 62 */     paramModel.setSlots(54);
/*    */     
/* 64 */     SettingsPane settingsPane = this.panes[this.current];
/*    */     
/* 66 */     int[] arrayOfInt = Arrays.<int[]>stream(this.layouts).filter(paramArrayOfint -> (paramArrayOfint.length == this.panes.length)).findFirst().get();
/*    */     
/* 68 */     byte b = 0;
/*    */     
/* 70 */     for (SettingsPane settingsPane1 : this.panes) {
/* 71 */       int i = arrayOfInt[b];
/* 72 */       boolean bool = (b == this.current) ? true : false;
/*    */       
/* 74 */       byte b1 = b;
/* 75 */       paramModel.button(i, paramButton -> {
/*    */             paramButton.material(paramSettingsPane.getIcon()).name(Animation.wave(paramSettingsPane.getName(), new Color[] { Colors.Gold, Colors.YELLOW }));
/*    */ 
/*    */             
/*    */             if (paramBoolean) {
/*    */               paramButton.item().lore(new String[] { PAGE_SELECTED.get() });
/*    */ 
/*    */               
/*    */               paramButton.item().addEnchantment(Enchantment.LUCK, 1).showEnchantments(false);
/*    */             } else {
/*    */               paramButton.item().lore(new String[] { SELECT_PAGE_ACTION.get() });
/*    */             } 
/*    */             
/*    */             paramButton.action(());
/*    */           });
/*    */       
/* 91 */       b++;
/*    */     } 
/*    */     
/* 94 */     settingsPane.construct(paramModel);
/*    */     
/* 96 */     paramModel.button(50, paramButton -> Common.BackButton(paramButton, ()));
/*    */   }
/*    */   
/*    */   public abstract SettingsPane[] getPanes();
/*    */   
/*    */   public abstract void onBack();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/settings/SettingsView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */