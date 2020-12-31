/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class GroupReorderView extends PageableGUI<Group> {
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public GroupReorderView(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/* 20 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 22 */     this.plugin = paramUltraPermissions;
/*    */     
/* 24 */     byte b = 1;
/*    */     
/* 26 */     for (Group group : paramUltraPermissions.getGroups().bestToWorst()) {
/* 27 */       group.setPriority(b);
/*    */       
/* 29 */       b++;
/*    */     } 
/*    */   }
/*    */   private Group selected;
/* 33 */   private static final Phrase ENTRY_DESELECT_ACTION = Phrase.create("groupReorderView.entry.deselectAction", "Click to **deselect** this group", Colors.GRAY, new Color[] { Colors.RED });
/* 34 */   private static final Phrase ENTRY_SWAP_ACTION = Phrase.create("groupReorderView.entry.swapAction", "Click to swap with **%group%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 35 */   private static final Phrase ENTRY_GRAB_ACTION = Phrase.create("groupReorderView.entry.grabAction", "Click to **grab** this group", Colors.GRAY, new Color[] { Colors.GREEN });
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, Group paramGroup) {
/* 39 */     paramButton.material(paramGroup.getIcon()).name(Animation.wave(paramGroup.getName(), new Color[] { Colors.Blue, Colors.WHITE }));
/*    */     
/* 41 */     if (this.selected != null) {
/* 42 */       if (this.selected.equals(paramGroup)) {
/* 43 */         paramButton.item().appendLore(new String[] { ENTRY_DESELECT_ACTION.get() });
/* 44 */         paramButton.item().addEnchantment(Enchantment.LUCK, 1);
/*    */       } else {
/* 46 */         paramButton.item().appendLore(new String[] { ENTRY_SWAP_ACTION.get().replace("%group%", this.selected.getName()) });
/*    */       } 
/*    */     } else {
/* 49 */       paramButton.item().appendLore(new String[] { ENTRY_GRAB_ACTION.get() });
/*    */     } 
/*    */     
/* 52 */     paramButton.action(paramActionType -> {
/*    */           if (this.selected != null) {
/*    */             if (!this.selected.equals(paramGroup)) {
/*    */               int i = this.selected.getPriority();
/*    */               this.selected.setPriority(paramGroup.getPriority());
/*    */               paramGroup.setPriority(i);
/*    */             } 
/*    */             this.selected = null;
/*    */           } else {
/*    */             this.selected = paramGroup;
/*    */           } 
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Group[] getObjects() {
/* 69 */     return (Group[])this.plugin.getGroups().bestToWorst().toArray((Object[])new Group[0]);
/*    */   }
/*    */   
/* 72 */   private static final Phrase TITLE = Phrase.create("groupReorderView.title", "Group Sorting (High to Low)");
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 76 */     return TITLE.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchFeature<Group> getSearch() {
/* 81 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/GroupReorderView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */