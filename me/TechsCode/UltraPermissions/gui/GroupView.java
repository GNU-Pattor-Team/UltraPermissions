/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.GroupChangeIconView;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.GroupDeleteView;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.GroupRenameDialog;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.PrefixChangeDialog;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.SuffixChangeDialog;
/*     */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionCopyList;
/*     */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionEditorMainView;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class GroupView extends GUI {
/*  24 */   private static final Phrase TITLE = Phrase.create("groupView.title", "Groups > %group%");
/*     */   
/*     */   private final UltraPermissions plugin;
/*     */   private final Group group;
/*     */   private final long opened;
/*     */   
/*     */   public GroupView(Player paramPlayer, UltraPermissions paramUltraPermissions, Group paramGroup) {
/*  31 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  33 */     this.plugin = paramUltraPermissions;
/*  34 */     this.group = paramGroup;
/*  35 */     this.opened = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBackButton() {
/*  41 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCurrentSlots() {
/*  46 */     return 54;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentTitle() {
/*  51 */     return TITLE.get().replace("%group%", this.group.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  56 */     paramModel.button(this::SetDefaultButton, 13);
/*  57 */     paramModel.button(this::ViewPermissionsButton, 15);
/*  58 */     paramModel.button(this::ViewInheritanceButton, 20);
/*  59 */     paramModel.button(this::PrefixAndSuffixButton, 26);
/*  60 */     paramModel.button(this::RenameButton, 31);
/*  61 */     paramModel.button(this::UsersButton, 33);
/*  62 */     paramModel.button(this::ChangeIconButton, 38);
/*  63 */     paramModel.button(this::DeleteButton, 44);
/*     */     
/*  65 */     if (hasBackButton()) paramModel.button(50, paramButton -> Common.BackButton(paramButton, ())); 
/*     */   }
/*     */   
/*  68 */   private static final Phrase SET_DEFAULT_TITLE = Phrase.create("groupView.setDefault.title", "Default Group");
/*  69 */   private static final Phrase SET_DEFAULT_SET_ACTION = Phrase.create("groupView.setDefault.setAction", "**Click** to make this group **default**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.YELLOW });
/*  70 */   private static final Phrase SET_DEFAULT_UNSET_ACTION = Phrase.create("groupView.setDefault.unsetAction", "**Click** to **undefault** this group", Colors.GRAY, new Color[] { Colors.AQUA, Colors.YELLOW });
/*  71 */   private static final Phrase SET_DEFAULT_ASSIGN_OPTION_TITLE = Phrase.create("groupView.setDefault.assignOption.title", "Who will get the default groups?", Colors.GRAY, new Color[0]);
/*  72 */   private static final Phrase SET_DEFAULT_UNSET_DESC = Phrase.create("groupView.setDefault.desc", "This could be a **destructive action**, pay attention before changing", Colors.GRAY, new Color[] { Colors.RED });
/*     */   
/*     */   private void SetDefaultButton(Button paramButton) {
/*  75 */     paramButton.material(this.group.isDefault() ? XMaterial.LIME_STAINED_GLASS_PANE : XMaterial.WHITE_STAINED_GLASS_PANE)
/*  76 */       .name(Animation.wave(SET_DEFAULT_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/*  77 */           })).lore(new String[] {
/*  78 */           (this.group.isDefault() ? SET_DEFAULT_UNSET_ACTION : SET_DEFAULT_SET_ACTION).get(), ""
/*     */         });
/*     */ 
/*     */     
/*  82 */     paramButton.item().appendLore(new String[] { SET_DEFAULT_ASSIGN_OPTION_TITLE
/*  83 */           .get(), Colors.WHITE + this.plugin
/*  84 */           .getDefaultGroupAssignOption().getExplanation() });
/*     */ 
/*     */     
/*  87 */     paramButton.item().appendLore(new String[] { "", SET_DEFAULT_UNSET_DESC.get() });
/*     */     
/*  89 */     paramButton.action(paramActionType -> this.group.setDefault(!this.group.isDefault()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  94 */   private static final Phrase VIEW_PERMISSIONS_TITLE = Phrase.create("groupView.viewPermissions.title", "View Permissions");
/*  95 */   private static final Phrase VIEW_PERMISSIONS_ACTION = Phrase.create("groupView.viewPermissions.action", "**Click** to view Permissions", Colors.GRAY, new Color[] { Colors.AQUA });
/*  96 */   private static final Phrase VIEW_PERMISSIONS_LIST_TITLE = Phrase.create("groupView.viewPermissions.listTitle", "Permission Nodes:", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void ViewPermissionsButton(Button paramButton) {
/*  99 */     paramButton.material(XMaterial.WRITABLE_BOOK)
/* 100 */       .name(Animation.wave(VIEW_PERMISSIONS_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/* 101 */           })).lore(new String[] {
/* 102 */           VIEW_PERMISSIONS_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */     
/* 106 */     PermissionCopyList permissionCopyList = new PermissionCopyList(this.group.getPermissions(), this.group.getInheritedPermissions());
/*     */ 
/*     */     
/* 109 */     paramButton.item().appendLore(new String[] { VIEW_PERMISSIONS_LIST_TITLE.get() });
/* 110 */     paramButton.item().appendLore(LoreLists.printPermissionCopiesList(permissionCopyList, this.opened));
/*     */     
/* 112 */     paramButton.action(paramActionType -> new PermissionEditorMainView(this.p, this.plugin, (PermissionHolder)this.group)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 116 */             GroupView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 122 */   private static final Phrase INHERITANCE_TITLE = Phrase.create("groupView.inheritance.title", "Inheritances");
/* 123 */   private static final Phrase INHERITANCE_ACTION = Phrase.create("groupView.inheritance.action", "**Click** to edit inheritances", Colors.GRAY, new Color[] { Colors.AQUA });
/* 124 */   private static final Phrase INHERITANCE_LIST_TITLE = Phrase.create("groupView.inheritance.listTitle", "Inherited Groups:", Colors.GRAY, new Color[0]);
/* 125 */   private static final Phrase INHERITANCE_LIST_ITEM = Phrase.create("groupView.inheritance.listItem", "- **%group%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 126 */   private static final Phrase INHERITANCE_LIST_NONE_ITEM = Phrase.create("groupView.inheritance.listNoneItem", "- **None**", Colors.GRAY, new Color[] { Colors.RED });
/*     */   
/*     */   private void ViewInheritanceButton(Button paramButton) {
/* 129 */     paramButton.material(XMaterial.PAPER)
/* 130 */       .name(Animation.wave(INHERITANCE_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/* 131 */           })).lore(new String[] {
/* 132 */           INHERITANCE_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */     
/* 136 */     GroupList groupList = this.group.getActiveInheritedGroups();
/*     */     
/* 138 */     paramButton.item().appendLore(new String[] { INHERITANCE_LIST_TITLE.get() });
/*     */     
/* 140 */     groupList.forEach(paramGroup -> paramButton.item().appendLore(new String[] { INHERITANCE_LIST_ITEM.get().replace("%group%", paramGroup.getName()) }));
/*     */ 
/*     */ 
/*     */     
/* 144 */     if (groupList.isEmpty()) {
/* 145 */       paramButton.item().appendLore(new String[] { INHERITANCE_LIST_NONE_ITEM.get() });
/*     */     }
/*     */     
/* 148 */     paramButton.action(paramActionType -> new InheritedGroupListView(this.p, this.plugin, this.group)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 152 */             GroupView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 158 */   private static final Phrase PREFIX_SUFFIX_TITLE = Phrase.create("groupView.prefixSuffix.title", "Prefix and Suffix");
/* 159 */   private static final Phrase PREFIX_SUFFIX_PREFIX_ACTION = Phrase.create("groupView.prefixSuffix.prefixAction", "**Left Click** to edit prefix", Colors.GRAY, new Color[] { Colors.AQUA });
/* 160 */   private static final Phrase PREFIX_SUFFIX_SUFFIX_ACTION = Phrase.create("groupView.prefixSuffix.suffixAction", "**Right Click** to edit suffix", Colors.GRAY, new Color[] { Colors.AQUA });
/* 161 */   private static final Phrase PREFIX_SUFFIX_PREFIX_ATTRIBUTE = Phrase.create("groupView.prefixSuffix.prefixAttribute", "Prefix: **%prefix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/* 162 */   private static final Phrase PREFIX_SUFFIX_SUFFIX_ATTRIBUTE = Phrase.create("groupView.prefixSuffix.suffixAttribute", "Suffix: **%suffix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*     */   private void PrefixAndSuffixButton(Button paramButton) {
/* 165 */     String str1 = this.group.getPrefix().orElse(Colors.RED + Words.NONE.get());
/* 166 */     String str2 = this.group.getSuffix().orElse(Colors.RED + Words.NONE.get());
/*     */     
/* 168 */     paramButton.material(XMaterial.NAME_TAG)
/* 169 */       .name(Animation.wave(PREFIX_SUFFIX_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/* 170 */           })).lore(new String[] {
/* 171 */           PREFIX_SUFFIX_PREFIX_ACTION.get(), PREFIX_SUFFIX_SUFFIX_ACTION
/* 172 */           .get(), "", PREFIX_SUFFIX_PREFIX_ATTRIBUTE
/*     */           
/* 174 */           .get().replace("%prefix%", str1), PREFIX_SUFFIX_SUFFIX_ATTRIBUTE
/* 175 */           .get().replace("%suffix%", str2)
/*     */         });
/*     */ 
/*     */     
/* 179 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.LEFT) {
/*     */             new PrefixChangeDialog(this.p, this.plugin, (PermissionHolder)this.group)
/*     */               {
/*     */                 public void reopen() {
/* 184 */                   GroupView.this.reopen();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 191 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.RIGHT) {
/*     */             new SuffixChangeDialog(this.p, this.plugin, (PermissionHolder)this.group)
/*     */               {
/*     */                 public void reopen() {
/* 196 */                   GroupView.this.reopen();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */   }
/*     */   
/* 203 */   private static final Phrase RENAME_TITLE = Phrase.create("groupView.rename.title", "Rename Group");
/* 204 */   private static final Phrase RENAME_ACTION = Phrase.create("groupView.rename.action", "**Click** to rename group", Colors.GRAY, new Color[] { Colors.AQUA });
/*     */   
/*     */   private void RenameButton(Button paramButton) {
/* 207 */     paramButton.material(XMaterial.BOOK)
/* 208 */       .name(Animation.wave(RENAME_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/* 209 */           })).lore(new String[] { RENAME_ACTION.get() });
/*     */     
/* 211 */     paramButton.action(paramActionType -> new GroupRenameDialog(this.p, this.plugin, this.group)
/*     */         {
/*     */           public void reopen()
/*     */           {
/* 215 */             GroupView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 221 */   private static final Phrase CHANGE_ICON_TITLE = Phrase.create("groupView.changeIcon.title", "Change Icon");
/* 222 */   private static final Phrase CHANGE_ICON_ACTION = Phrase.create("groupView.changeIcon.action", "**Click** to change", Colors.GRAY, new Color[] { Colors.AQUA });
/*     */   
/*     */   private void ChangeIconButton(Button paramButton) {
/* 225 */     paramButton.material(XMaterial.GRASS_BLOCK)
/* 226 */       .name(Animation.wave(CHANGE_ICON_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/* 227 */           })).lore(new String[] { CHANGE_ICON_ACTION.get() });
/*     */     
/* 229 */     paramButton.action(paramActionType -> new GroupChangeIconView(this.p, this.plugin, this.group)
/*     */         {
/*     */           public void reopen()
/*     */           {
/* 233 */             GroupView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 239 */   private static final Phrase DELETE_TITLE = Phrase.create("groupView.delete.title", "Delete Group");
/* 240 */   private static final Phrase DELETE_ACTION = Phrase.create("groupView.delete.action", "**Click** to **delete** this Group", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/* 241 */   private static final Phrase DELETE_DESC = Phrase.create("groupView.delete.desc", "This action is **permanent**", Colors.GRAY, new Color[] { Colors.RED });
/*     */   
/*     */   private void DeleteButton(Button paramButton) {
/* 244 */     paramButton.material(XMaterial.REDSTONE_BLOCK)
/* 245 */       .name(Animation.wave(DELETE_TITLE.get(), new Color[] { Colors.Red, Colors.AliceBlue
/* 246 */           })).lore(new String[] {
/* 247 */           DELETE_ACTION.get(), "", DELETE_DESC
/*     */           
/* 249 */           .get()
/*     */         });
/*     */     
/* 252 */     paramButton.action(paramActionType -> new GroupDeleteView(this.p, this.plugin, this.group)
/*     */         {
/*     */           public void reopen()
/*     */           {
/* 256 */             GroupView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 262 */   private static final Phrase USERS_TITLE = Phrase.create("groupView.users.title", "Users");
/* 263 */   private static final Phrase USERS_ACTION = Phrase.create("groupView.users.action", "Click to view **Users**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 264 */   private static final Phrase USERS_AMOUNT_ATTRIBUTE = Phrase.create("groupView.users.amountAttribute", "Amount: **%count%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void UsersButton(Button paramButton) {
/* 267 */     int i = this.plugin.getUsers().usersInGroup(this.group.toStored()).size();
/*     */     
/* 269 */     paramButton.material(XMaterial.PLAYER_HEAD)
/* 270 */       .name(Animation.wave(USERS_TITLE.get(), new Color[] { Colors.DeepSkyBlue, Colors.AliceBlue
/* 271 */           })).lore(new String[] {
/* 272 */           USERS_ACTION.get(), "", USERS_AMOUNT_ATTRIBUTE
/*     */           
/* 274 */           .get().replace("%count%", Integer.toString(i))
/*     */         });
/*     */     
/* 277 */     paramButton.action(paramActionType -> new GroupUserListView(this.p, this.plugin, this.group)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 281 */             GroupView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public abstract void onBack();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/GroupView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */