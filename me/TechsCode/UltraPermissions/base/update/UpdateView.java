/*    */ package me.TechsCode.UltraPermissions.base.update;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class UpdateView extends GUI {
/* 15 */   private static final Phrase TITLE = Phrase.create("updateView.title", "Update from %from% to %to%");
/*    */   
/* 17 */   private static final Phrase YES_TITLE = Phrase.create("updateView.yes.title", "Update");
/* 18 */   private static final Phrase YES_ACTION = Phrase.create("updateView.yes.action", "Click to load **update**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 19 */   private static final Phrase YES_DESCRIPTION = Phrase.create("updateView.yes.desc", "This feature requires **Discord** to verify your purchase", Colors.GRAY, new Color[] { Colors.AQUA });
/*    */   
/* 21 */   private static final Phrase NO_TITLE = Phrase.create("updateView.no.title", "Stay on this Version");
/* 22 */   private static final Phrase NO_ACTION = Phrase.create("updateView.no.action", "Click to stay on this Version", Colors.GRAY, new Color[0]);
/* 23 */   private static final Phrase NO_DESC_YOURVERSION = Phrase.create("updateView.no.desc.yourVersion", "Your Version: **%**", Colors.GRAY, new Color[] { Colors.RED });
/* 24 */   private static final Phrase NO_DESC_NEWVERSION = Phrase.create("updateView.no.desc.newVersion", "New Version: **%**", Colors.GRAY, new Color[] { Colors.GREEN });
/*    */   
/*    */   private final String localVersion;
/*    */   private final String globalVersion;
/*    */   
/*    */   public UpdateView(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin, String paramString1, String paramString2) {
/* 30 */     super(paramPlayer, paramSpigotTechPlugin);
/*    */     
/* 32 */     this.localVersion = paramString1;
/* 33 */     this.globalVersion = paramString2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void construct(Model paramModel) {
/* 40 */     paramModel.button(12, this::YesButton);
/* 41 */     paramModel.button(16, this::NoButton);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCurrentSlots() {
/* 46 */     return 27;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCurrentTitle() {
/* 51 */     return TITLE.get()
/* 52 */       .replace("%from%", this.localVersion)
/* 53 */       .replace("%to%", this.globalVersion);
/*    */   }
/*    */   
/*    */   private void YesButton(Button paramButton) {
/* 57 */     paramButton.material(XMaterial.EMERALD_BLOCK)
/* 58 */       .name(Animation.wave(YES_TITLE.get(), new Color[] { Colors.GREEN, Colors.WHITE
/* 59 */           })).lore(new String[] {
/* 60 */           YES_ACTION.get(), ""
/*    */         });
/*    */ 
/*    */     
/* 64 */     paramButton.item().appendLore(YES_DESCRIPTION.split(25));
/*    */ 
/*    */     
/* 67 */     paramButton.action(paramActionType -> {
/*    */           this.p.closeInventory();
/*    */           onResponse(true);
/*    */         });
/*    */   }
/*    */   
/*    */   private void NoButton(Button paramButton) {
/* 74 */     paramButton.material(XMaterial.REDSTONE_BLOCK)
/* 75 */       .name(Animation.wave(NO_TITLE.get(), new Color[] { Colors.RED, Colors.WHITE
/* 76 */           })).lore(new String[] {
/* 77 */           NO_ACTION.get(), "", NO_DESC_YOURVERSION
/*    */           
/* 79 */           .get().replace("%", this.localVersion), NO_DESC_NEWVERSION
/* 80 */           .get().replace("%", this.globalVersion)
/*    */         });
/*    */     
/* 83 */     paramButton.action(paramActionType -> {
/*    */           this.p.closeInventory();
/*    */           onResponse(false);
/*    */         });
/*    */   }
/*    */   
/*    */   public abstract void onResponse(boolean paramBoolean);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/UpdateView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */