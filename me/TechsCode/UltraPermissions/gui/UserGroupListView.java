/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.UserRankup;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class UserGroupListView
/*    */   extends PageableGUI<UserRankup> {
/*    */   private final Player p;
/*    */   
/*    */   public UserGroupListView(Player paramPlayer, UltraPermissions paramUltraPermissions, User paramUser) {
/* 28 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 30 */     this.p = paramPlayer;
/* 31 */     this.plugin = paramUltraPermissions;
/* 32 */     this.user = paramUser;
/*    */   }
/*    */   private final UltraPermissions plugin; private final User user;
/* 35 */   private static final Phrase TITLE = Phrase.create("userGroupListView.title", "%user% > Groups");
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 39 */     return TITLE.get().replace("%user%", this.user.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void construct(Model paramModel) {
/* 44 */     super.construct(paramModel);
/*    */     
/* 46 */     paramModel.button(this::AddButton, getRightOptionSlot());
/*    */   }
/*    */   
/* 49 */   private static final Phrase ENTRY_ACTION = Phrase.create("userGroupListView.entry.action", "Click to **remove** group", Colors.GRAY, new Color[] { Colors.RED });
/* 50 */   private static final Phrase ENTRY_TIME_TITLE = Phrase.create("userGroupListView.entry.timeTitle", "Time until removal:", Colors.GRAY, new Color[0]);
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, UserRankup paramUserRankup) {
/* 54 */     paramButton.material(paramUserRankup.getIcon())
/* 55 */       .name(Animation.wave(paramUserRankup.getGroupName(), new Color[] { Colors.YELLOW, Colors.WHITE
/* 56 */           })).lore(new String[] {
/* 57 */           ENTRY_ACTION.get()
/*    */         });
/*    */     
/* 60 */     if (!paramUserRankup.isPermanent()) {
/* 61 */       paramButton.item()
/* 62 */         .appendLore(new String[] { ""
/* 63 */           }).appendLore(new String[] { ENTRY_TIME_TITLE.get()
/* 64 */           }).appendLore(new String[] { Colors.RED + Tools.getTimeString(paramUserRankup.getExpiry() - System.currentTimeMillis(), TimeUnit.MILLISECONDS) });
/*    */     }
/*    */     
/* 67 */     paramButton.action(paramActionType -> paramUserRankup.remove());
/*    */   }
/*    */ 
/*    */   
/*    */   public UserRankup[] getObjects() {
/* 72 */     return (UserRankup[])this.user.getRankups().toArray((Object[])new UserRankup[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchFeature<UserRankup> getSearch() {
/* 77 */     return (SearchFeature<UserRankup>)new BasicSearch<UserRankup>()
/*    */       {
/*    */         public String[] getSearchableText(UserRankup param1UserRankup) {
/* 80 */           return new String[] { param1UserRankup
/* 81 */               .getGroup().get().map(Group::getName).orElse("xxx") };
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/* 87 */   private static final Phrase ADD_TITLE = Phrase.create("userGroupListView.add.title", "Add");
/* 88 */   private static final Phrase ADD_ACTION = Phrase.create("userGroupListView.add.action", "Click to add group", Colors.GRAY, new Color[0]);
/*    */   
/*    */   private void AddButton(Button paramButton) {
/* 91 */     paramButton.material(XMaterial.ANVIL)
/* 92 */       .name(Animation.fading(ADD_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 93 */           })).lore(new String[] { ADD_ACTION.get() });
/*    */     
/* 95 */     paramButton.action(paramActionType -> new UserGroupAddView(this.p, this.plugin, this.user)
/*    */         {
/*    */           public void onBack()
/*    */           {
/* 99 */             UserGroupListView.this.reopen();
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/UserGroupListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */