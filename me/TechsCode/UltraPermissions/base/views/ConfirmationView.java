/*    */ package me.TechsCode.UltraPermissions.base.views;
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
/*    */ public abstract class ConfirmationView extends GUI {
/* 15 */   private static final Phrase CONFIRM_TITLE = Phrase.create("confirmationView.confirm.title", "Confirm");
/* 16 */   private static final Phrase CONFIRM_ACTION = Phrase.create("confirmationView.confirm.action", "Click to confirm", Colors.GRAY, new Color[0]);
/*    */   
/* 18 */   private static final Phrase DENY_TITLE = Phrase.create("confirmationView.deny.title", "Abort");
/* 19 */   private static final Phrase DENY_ACTION = Phrase.create("confirmationView.deny.action", "Click to abort", Colors.GRAY, new Color[0]);
/*    */   
/*    */   private String title;
/*    */   
/*    */   public ConfirmationView(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin, String paramString) {
/* 24 */     super(paramPlayer, paramSpigotTechPlugin);
/*    */     
/* 26 */     this.title = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void construct(Model paramModel) {
/* 31 */     paramModel.setTitle(this.title);
/* 32 */     paramModel.setSlots(27);
/* 33 */     paramModel.button(12, this::ConfirmButton);
/* 34 */     paramModel.button(16, this::DenyButton);
/*    */   }
/*    */   
/*    */   private void ConfirmButton(Button paramButton) {
/* 38 */     paramButton.material(XMaterial.EMERALD_BLOCK)
/* 39 */       .name(Animation.wave(CONFIRM_TITLE.get(), new Color[] { Colors.GREEN, Colors.WHITE
/* 40 */           })).lore(new String[] { CONFIRM_ACTION.get() });
/*    */     
/* 42 */     paramButton.action(paramActionType -> choose(true));
/*    */   }
/*    */   
/*    */   private void DenyButton(Button paramButton) {
/* 46 */     paramButton.material(XMaterial.REDSTONE_BLOCK)
/* 47 */       .name(Animation.wave(DENY_TITLE.get(), new Color[] { Colors.RED, Colors.WHITE
/* 48 */           })).lore(new String[] { DENY_ACTION.get() });
/*    */     
/* 50 */     paramButton.action(paramActionType -> choose(false));
/*    */   }
/*    */   
/*    */   public abstract void choose(boolean paramBoolean);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/ConfirmationView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */