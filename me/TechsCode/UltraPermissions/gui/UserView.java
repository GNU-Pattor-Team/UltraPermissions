/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Common;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.PrefixChangeDialog;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.SuffixChangeDialog;
/*     */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionCopyList;
/*     */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionEditorMainView;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class UserView extends GUI {
/*  24 */   private static final Phrase TITLE = Phrase.create("userView.title", "User > %user%");
/*     */   
/*  26 */   private static final Phrase GROUPS_TITLE = Phrase.create("userView.groups.title", "Groups");
/*  27 */   private static final Phrase GROUPS_ACTION = Phrase.create("userView.groups.action", "**Click** to view Groups", Colors.GRAY, new Color[] { Colors.AQUA });
/*  28 */   private static final Phrase GROUPS_LIST_TITLE = Phrase.create("userView.groups.list.title", "Groups:", Colors.GRAY, new Color[0]);
/*     */   
/*  30 */   private static final Phrase PERMISSIONS_TITLE = Phrase.create("userView.permissions.title", "View Permissions");
/*  31 */   private static final Phrase PERMISSIONS_ACTION = Phrase.create("userView.permissions.action", "**Click** to view Permissions", Colors.GRAY, new Color[] { Colors.AQUA });
/*  32 */   private static final Phrase PERMISSIONS_LIST_TITLE = Phrase.create("userView.permissions.list.title", "Permission Nodes:", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private final UltraPermissions plugin;
/*     */   private final User user;
/*     */   private final long opened;
/*     */   
/*     */   public UserView(Player paramPlayer, UltraPermissions paramUltraPermissions, User paramUser) {
/*  39 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  41 */     this.plugin = paramUltraPermissions;
/*  42 */     this.user = paramUser;
/*  43 */     this.opened = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   public boolean hasBackButton() {
/*  47 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentSlots() {
/*  54 */     return 54;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentTitle() {
/*  59 */     return TITLE.get().replace("%user%", this.user.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  64 */     paramModel.button(this::GroupsButton, 20);
/*  65 */     paramModel.button(this::ViewPermissionsButton, 14);
/*  66 */     paramModel.button(this::PrefixSuffixButton, 26);
/*     */     
/*  68 */     if (hasBackButton()) paramModel.button(50, paramButton -> Common.BackButton(paramButton, ())); 
/*     */   }
/*     */   
/*     */   private void GroupsButton(Button paramButton) {
/*  72 */     paramButton.material(XMaterial.BOOKSHELF)
/*  73 */       .name(Animation.wave(GROUPS_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/*  74 */           })).lore(new String[] {
/*  75 */           GROUPS_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */     
/*  79 */     paramButton.item().appendLore(new String[] { GROUPS_LIST_TITLE.get() });
/*  80 */     paramButton.item().appendLore(LoreLists.printRankUpLoreList(this.user.getRankups()));
/*     */     
/*  82 */     paramButton.action(paramActionType -> new UserGroupListView(this.p, this.plugin, this.user)
/*     */         {
/*     */           public void onBack() {
/*  85 */             UserView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void ViewPermissionsButton(Button paramButton) {
/*  91 */     paramButton.material(XMaterial.WRITABLE_BOOK)
/*  92 */       .name(Animation.wave(PERMISSIONS_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/*  93 */           })).lore(new String[] {
/*  94 */           PERMISSIONS_ACTION.get(), "", PERMISSIONS_LIST_TITLE
/*     */           
/*  96 */           .get()
/*     */         });
/*     */     
/*  99 */     PermissionCopyList permissionCopyList = new PermissionCopyList(this.user.getPermissions(), this.user.getAdditionalPermissions());
/*     */     
/* 101 */     paramButton.item().appendLore(LoreLists.printPermissionCopiesList(permissionCopyList, this.opened));
/*     */     
/* 103 */     paramButton.action(paramActionType -> new PermissionEditorMainView(this.p, this.plugin, (PermissionHolder)this.user)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 107 */             UserView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 113 */   private static final Phrase PREFIX_SUFFIX_TITLE = Phrase.create("userView.prefixSuffix.title", "Prefix and Suffix");
/* 114 */   private static final Phrase PREFIX_SUFFIX_PREFIX_ACTION = Phrase.create("userView.prefixSuffix.prefixAction", "**Left Click** to edit prefix", Colors.GRAY, new Color[] { Colors.AQUA });
/* 115 */   private static final Phrase PREFIX_SUFFIX_SUFFIX_ACTION = Phrase.create("userView.prefixSuffix.suffixAction", "**Right Click** to edit suffix", Colors.GRAY, new Color[] { Colors.AQUA });
/* 116 */   private static final Phrase PREFIX_SUFFIX_PREFIX_ATTRIBUTE = Phrase.create("userView.prefixSuffix.prefixAttribute", "Prefix: **%prefix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/* 117 */   private static final Phrase PREFIX_SUFFIX_SUFFIX_ATTRIBUTE = Phrase.create("userView.prefixSuffix.suffixAttribute", "Suffix: **%suffix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*     */   private void PrefixSuffixButton(Button paramButton) {
/* 120 */     String str1 = this.user.getPrefix().orElse(Colors.RED + Words.NONE.get());
/* 121 */     String str2 = this.user.getSuffix().orElse(Colors.RED + Words.NONE.get());
/*     */     
/* 123 */     paramButton.material(XMaterial.NAME_TAG)
/* 124 */       .name(Animation.wave(PREFIX_SUFFIX_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/* 125 */           })).lore(new String[] {
/* 126 */           PREFIX_SUFFIX_PREFIX_ACTION.get(), PREFIX_SUFFIX_SUFFIX_ACTION
/* 127 */           .get(), "", PREFIX_SUFFIX_PREFIX_ATTRIBUTE
/*     */           
/* 129 */           .get().replace("%prefix%", str1), PREFIX_SUFFIX_SUFFIX_ATTRIBUTE
/* 130 */           .get().replace("%suffix%", str2)
/*     */         });
/*     */ 
/*     */     
/* 134 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.LEFT) {
/*     */             new PrefixChangeDialog(this.p, this.plugin, (PermissionHolder)this.user)
/*     */               {
/*     */                 public void reopen() {
/* 139 */                   UserView.this.reopen();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 146 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.RIGHT)
/*     */             new SuffixChangeDialog(this.p, this.plugin, (PermissionHolder)this.user)
/*     */               {
/*     */                 public void reopen() {
/* 151 */                   UserView.this.reopen();
/*     */                 }
/*     */               }; 
/*     */         });
/*     */   }
/*     */   
/*     */   public abstract void onBack();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/UserView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */