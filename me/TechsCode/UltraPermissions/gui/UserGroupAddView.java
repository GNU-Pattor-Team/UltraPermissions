/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.views.TimePickerView;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class UserGroupAddView extends PageableGUI<Group> {
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public UserGroupAddView(Player paramPlayer, UltraPermissions paramUltraPermissions, User paramUser) {
/* 22 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 24 */     this.plugin = paramUltraPermissions;
/* 25 */     this.user = paramUser;
/*    */   }
/*    */   private final User user;
/*    */   
/*    */   public Group[] getObjects() {
/* 30 */     return (Group[])this.plugin.getGroups().stream()
/* 31 */       .filter(paramGroup -> !this.user.getGroups().contains(paramGroup.toStored()))
/* 32 */       .toArray(paramInt -> new Group[paramInt]);
/*    */   }
/*    */   
/* 35 */   private static final Phrase TITLE = Phrase.create("userGroupAddView.title", "%user% > Add Group");
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 39 */     return TITLE.get().replace("%user%", this.user.getName());
/*    */   }
/*    */   
/* 42 */   private static final Phrase ENTRY_ACTION = Phrase.create("userGroupAddView.entry.action", "Click to **add** to **%user%**", Colors.GRAY, new Color[] { Colors.GREEN, Colors.YELLOW });
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, final Group group) {
/* 46 */     paramButton.material(group.getIcon())
/* 47 */       .name(Animation.wave(group.getName(), new Color[] { Colors.Green, Colors.WHITE
/* 48 */           })).lore(new String[] { ENTRY_ACTION.get().replace("%user%", this.user.getName()) });
/*    */     
/* 50 */     paramButton.action(paramActionType -> new TimePickerView(this.p, (SpigotTechPlugin)this.plugin, "Duration >", "Permanent", true)
/*    */         {
/*    */           public void onResult(long param1Long)
/*    */           {
/* 54 */             if (param1Long == 0L) {
/* 55 */               UserGroupAddView.this.user.addGroup(group);
/*    */             } else {
/* 57 */               long l = System.currentTimeMillis() + param1Long * 1000L;
/* 58 */               UserGroupAddView.this.user.addGroup(group, l);
/*    */             } 
/*    */             
/* 61 */             UserGroupAddView.this.onBack();
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SearchFeature<Group> getSearch() {
/* 69 */     return (SearchFeature<Group>)new BasicSearch<Group>()
/*    */       {
/*    */         public String[] getSearchableText(Group param1Group) {
/* 72 */           return new String[] { param1Group
/* 73 */               .getName() };
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/UserGroupAddView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */