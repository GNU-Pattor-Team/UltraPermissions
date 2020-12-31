/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class InheritedGroupListView extends PageableGUI<Group> {
/* 16 */   private static final Phrase TITLE = Phrase.create("inheritedGroupListView.title", "%group% > Inherited Groups");
/*    */   
/*    */   private final UltraPermissions plugin;
/*    */   private final Group target;
/*    */   
/*    */   public InheritedGroupListView(Player paramPlayer, UltraPermissions paramUltraPermissions, Group paramGroup) {
/* 22 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 24 */     this.plugin = paramUltraPermissions;
/* 25 */     this.target = paramGroup;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 30 */     return TITLE.get().replace("%group%", this.target.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, Group paramGroup) {
/* 35 */     boolean bool = this.target.getInheritedGroups().contains(paramGroup.toStored());
/*    */     
/* 37 */     if (bool) {
/* 38 */       InheritedButton(paramButton, paramGroup);
/*    */     } else {
/* 40 */       NotInheritedButton(paramButton, paramGroup);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Group[] getObjects() {
/* 46 */     return (Group[])this.plugin.getGroups()
/* 47 */       .servers(true, new String[] { this.target.getServer().orElse(null)
/* 48 */         }).worlds(true, new String[] { this.target.getWorld().orElse(null)
/* 49 */         }).stream()
/* 50 */       .filter(paramGroup -> !paramGroup.equals(this.target))
/* 51 */       .toArray(paramInt -> new Group[paramInt]);
/*    */   }
/*    */   
/* 54 */   private static final Phrase INHERITING_ACTION = Phrase.create("inheritedGroupListView.inheriting.action", "Click to **remove**", Colors.GRAY, new Color[] { Colors.RED });
/* 55 */   private static final Phrase INHERITING_EXPLANATION = Phrase.create("inheritedGroupListView.inheriting.explanation", "This will add all permissions from **%from%** to **%to%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.AQUA });
/*    */   
/*    */   private void InheritedButton(Button paramButton, Group paramGroup) {
/* 58 */     paramButton.material(XMaterial.YELLOW_STAINED_GLASS_PANE)
/* 59 */       .name(Animation.wave(paramGroup.getName(), new Color[] { Colors.YELLOW, Colors.WHITE
/* 60 */           })).lore(new String[] {
/* 61 */           INHERITING_ACTION.get(), "", INHERITING_EXPLANATION
/*    */           
/* 63 */           .get().replace("%from%", paramGroup.getName()).replace("%to%", this.target.getName())
/*    */         });
/*    */     
/* 66 */     paramButton.action(paramActionType -> this.target.removeInheritance(paramGroup));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 71 */   private static final Phrase NOT_INHERITING_ACTION = Phrase.create("inheritedGroupListView.notInheriting.action", "Click to **add**", Colors.GRAY, new Color[] { Colors.GREEN });
/* 72 */   private static final Phrase NOT_INHERITING_EXPLANATION = Phrase.create("inheritedGroupListView.notInheriting.explanation", "All Permissions from **%from%** will be added to **%to%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.AQUA });
/*    */   
/*    */   private void NotInheritedButton(Button paramButton, Group paramGroup) {
/* 75 */     paramButton.material(XMaterial.GRAY_STAINED_GLASS_PANE)
/* 76 */       .name(Animation.wave(paramGroup.getName(), new Color[] { Colors.Gray, Colors.WHITE
/* 77 */           })).lore(new String[] {
/* 78 */           NOT_INHERITING_ACTION.get(), "", NOT_INHERITING_EXPLANATION
/*    */           
/* 80 */           .get().replace("%from%", paramGroup.getName()).replace("%to%", this.target.getName())
/*    */         });
/*    */     
/* 83 */     paramButton.action(paramActionType -> this.target.addInheritance(paramGroup));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SearchFeature<Group> getSearch() {
/* 90 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/InheritedGroupListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */