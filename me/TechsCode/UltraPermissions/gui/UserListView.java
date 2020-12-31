/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ import java.util.Arrays;
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.CachedOnlineChecker;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.SkinTexture;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class UserListView extends PageableGUI<User> {
/*  22 */   private static final Phrase TITLE = Phrase.create("userListView.title", "Overview > Users");
/*     */   
/*  24 */   private static final Phrase USER_ACTION = Phrase.create("userListView.user.action", "**Click** to view", Colors.GRAY, new Color[] { Colors.AQUA });
/*  25 */   private static final Phrase USER_DELETE_ACTION = Phrase.create("userListView.user.deleteAction", "**Press Q** to **delete**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*  26 */   private static final Phrase USER_SUPER_ADMIN_INDICATOR = Phrase.create("userListView.user.superAdminIndicator", "This user is a superadmin", Colors.GREEN, new Color[0]);
/*  27 */   private static final Phrase USER_PREFIX_ATTRIBUTE = Phrase.create("userListView.user.prefixAttribute", "Prefix: **%prefix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  28 */   private static final Phrase USER_SUFFIX_ATTRIBUTE = Phrase.create("userListView.user.suffixAttribute", "Suffix: **%suffix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*  30 */   private static final Phrase USER_RANK_UP_LIST_TITLE = Phrase.create("userListView.rankUpList.title", "Groups:", Colors.GRAY, new Color[0]);
/*  31 */   private static final Phrase USER_DESC_NO_HEAD = Phrase.create("userListView.user.noHeadDesc", "Head will be shown after the next connect", Colors.DARK_GRAY, new Color[0]);
/*     */   
/*  33 */   private static final Phrase SEARCH_TITLE = Phrase.create("userListView.search.title", "Search User");
/*  34 */   private static final Phrase SEARCH_ACTION = Phrase.create("userListView.search.action", "Click to type in a name", Colors.GRAY, new Color[0]);
/*     */   
/*  36 */   private static final Phrase FILTER_TITLE = Phrase.create("userListView.onlineFilter.title", "Visibility");
/*  37 */   private static final Phrase FILTER_ENABLE_ACTION = Phrase.create("userListView.onlineFilter.enableAction", "Click to **hide** Offline Users", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  38 */   private static final Phrase FILTER_DISABLE_ACTION = Phrase.create("userListView.onlineFilter.disableAction", "Click to **show** Offline Users", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private final UltraPermissions plugin;
/*     */   
/*     */   private final CachedOnlineChecker onlineChecker;
/*     */   public boolean onlineOnly;
/*     */   
/*     */   public UserListView(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/*  46 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  48 */     this.plugin = paramUltraPermissions;
/*  49 */     this.onlineChecker = CachedOnlineChecker.scan();
/*     */     
/*  51 */     this.onlineOnly = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  56 */     return TITLE.get();
/*     */   }
/*     */   
/*     */   public User[] getUsers() {
/*  60 */     return (User[])this.plugin.getUsers().toArray((Object[])new User[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public User[] getObjects() {
/*  65 */     return (User[])Arrays.<User>stream(getUsers())
/*  66 */       .filter(paramUser -> (!this.onlineOnly || this.onlineChecker.isOnline(paramUser.getUuid())))
/*  67 */       .toArray(paramInt -> new User[paramInt]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void construct(Button paramButton, User paramUser) {
/*  72 */     Optional<SkinTexture> optional = paramUser.getSkinTexture();
/*     */     
/*  74 */     if (optional.isPresent()) {
/*  75 */       paramButton.material(XMaterial.PLAYER_HEAD)
/*  76 */         .setSkullTexture(optional.get());
/*     */     } else {
/*  78 */       paramButton.material(XMaterial.GRAY_STAINED_GLASS);
/*     */     } 
/*     */     
/*  81 */     paramButton.item().name(Animation.wave(paramUser.getName(), new Color[] { Colors.GOLD, Colors.YELLOW, Colors.WHITE
/*  82 */           })).appendLore(new String[] { USER_ACTION.get() });
/*     */ 
/*     */     
/*  85 */     if (!this.onlineChecker.isOnline(paramUser.getUuid())) {
/*  86 */       paramButton.item().appendLore(new String[] { USER_DELETE_ACTION.get() });
/*     */       
/*  88 */       paramButton.action(paramActionType -> {
/*     */             if (paramActionType == ActionType.Q) {
/*     */               paramUser.remove();
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/*  95 */     if (paramUser.isSuperadmin()) {
/*  96 */       paramButton.item().appendLore(new String[] { "", USER_SUPER_ADMIN_INDICATOR.get() });
/*     */     }
/*     */ 
/*     */     
/* 100 */     String str1 = paramUser.getPrefix().orElse(Colors.RED + Words.NONE.firstUpper());
/* 101 */     String str2 = paramUser.getSuffix().orElse(Colors.RED + Words.NONE.firstUpper());
/*     */     
/* 103 */     paramButton.item().appendLore(new String[] { "", USER_PREFIX_ATTRIBUTE
/*     */           
/* 105 */           .get().replace("%prefix%", str1), USER_SUFFIX_ATTRIBUTE
/* 106 */           .get().replace("%suffix%", str2), "" });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     paramButton.item().appendLore(new String[] { USER_RANK_UP_LIST_TITLE.get() });
/* 112 */     paramButton.item().appendLore(LoreLists.printRankUpLoreList(paramUser.getRankups()));
/*     */ 
/*     */     
/* 115 */     if (!optional.isPresent()) {
/* 116 */       paramButton.item().appendLore(new String[] { "", USER_DESC_NO_HEAD.get() });
/*     */     }
/*     */     
/* 119 */     paramButton.action(paramActionType -> new UserView(this.p, this.plugin, paramUser)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 123 */             UserListView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/* 131 */     super.construct(paramModel);
/*     */     
/* 133 */     paramModel.button(getRightOptionSlot(), paramButton -> {
/*     */           paramButton.material(this.onlineOnly ? XMaterial.ENDER_EYE : XMaterial.ENDER_PEARL).name(Animation.wave(FILTER_TITLE.get(), new Color[] { Colors.AQUA, Colors.WHITE })).lore(new String[] { (this.onlineOnly ? FILTER_DISABLE_ACTION : FILTER_ENABLE_ACTION).get() });
/*     */           paramButton.action(());
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentSlots() {
/* 148 */     return 54;
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchFeature<User> getSearch() {
/* 153 */     return new SearchFeature<User>(XMaterial.NAME_TAG, SEARCH_TITLE.get(), SEARCH_ACTION.get())
/*     */       {
/*     */         public String[] getSearchableText(User param1User) {
/* 156 */           return new String[] { param1User
/* 157 */               .getName() };
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/UserListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */