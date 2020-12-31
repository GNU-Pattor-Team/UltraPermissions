/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.ColorPalette;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.SkinTexture;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.base.visual.LoreScroller;
/*     */ import me.TechsCode.UltraPermissions.gui.settings.UpermsSettingsView;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class Overview
/*     */   extends GUI {
/*     */   private final UltraPermissions plugin;
/*     */   private final long start;
/*     */   private boolean expanded = false;
/*     */   private List<SkinTexture> skinTextures;
/*     */   private List<String> playerList;
/*     */   private List<String> groupList;
/*     */   
/*     */   public Overview(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/*  37 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  39 */     this.plugin = paramUltraPermissions;
/*  40 */     this.start = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reopen() {
/*  45 */     super.reopen();
/*     */   }
/*     */ 
/*     */   
/*     */   public void construct(Model paramModel) {
/*  50 */     paramModel.setTitle("Ultra Permissions v" + this.plugin.getVersion());
/*  51 */     paramModel.setSlots(this.expanded ? 54 : 45);
/*     */     
/*  53 */     paramModel.button(this::UsersButton, this.expanded ? 12 : 21);
/*  54 */     paramModel.button(this::GroupsButton, this.expanded ? 16 : 25);
/*     */     
/*  56 */     if (this.expanded) {
/*  57 */       paramModel.button(this::PermissionLogButton, 31);
/*  58 */       paramModel.button(this::SettingsButton, 33);
/*     */       
/*  60 */       paramModel.button(this::ReduceButton, 50);
/*     */     } else {
/*  62 */       paramModel.button(this::ExpandButton, 41);
/*     */     } 
/*     */   }
/*     */   
/*  66 */   private static final Phrase USERS_TITLE = Phrase.create("overview.users.title", "Users");
/*  67 */   private static final Phrase USERS_ACTION = Phrase.create("overview.users.action", "Click to view all **Users**", Colors.GRAY, new Color[] { Colors.GREEN });
/*  68 */   private static final Phrase USERS_DESC = Phrase.create("overview.users.desc", "%count% Players registered so far", Colors.DARK_GRAY, new Color[0]);
/*  69 */   private static final Phrase USERS_SCROLLING_ENTRY = Phrase.create("overview.users.scrollingEntry", "- **%prefix%** %user%", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*     */   private void UsersButton(Button paramButton) {
/*  72 */     paramButton.material(XMaterial.PLAYER_HEAD)
/*  73 */       .name(Animation.wave(USERS_TITLE.get(), new Color[] { ColorPalette.MAIN, Colors.WHITE
/*  74 */           })).lore(new String[] { USERS_ACTION.get() });
/*     */     
/*  76 */     paramButton.item().appendLore(new String[] { "" });
/*     */     
/*  78 */     if (this.playerList == null) {
/*  79 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  96 */         .playerList = (List<String>)this.plugin.getUsers().stream().map(paramUser -> { String str = paramUser.getPrefix().orElse(""); if (str.isEmpty()) { Optional<Group> optional = paramUser.getActiveGroups().bestToWorst().stream().findFirst(); if (optional.isPresent() && ((Group)optional.get()).getPrefix().isPresent()) str = (String)((Group)optional.get()).getPrefix().get() + " ";  }  return USERS_SCROLLING_ENTRY.get().replace("%prefix%", str).replace("%user%", paramUser.getName()).trim(); }).collect(Collectors.toList());
/*     */     }
/*     */     
/*  99 */     paramButton.item().appendLore(LoreScroller.scroller(this.playerList, 8, this.start));
/*     */     
/* 101 */     paramButton.item().appendLore(new String[] { "", USERS_DESC.get().replace("%count%", Integer.toString(this.playerList.size())) });
/*     */     
/* 103 */     if (this.skinTextures == null) {
/* 104 */       this
/*     */ 
/*     */         
/* 107 */         .skinTextures = (List<SkinTexture>)this.plugin.getUsers().stream().map(paramUser -> (SkinTexture)paramUser.getSkinTexture().orElse(null)).filter(Objects::nonNull).collect(Collectors.toList());
/*     */     }
/*     */     
/* 110 */     if (!this.skinTextures.isEmpty()) {
/* 111 */       long l = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
/*     */       
/* 113 */       int i = (int)(l % this.skinTextures.size());
/* 114 */       paramButton.item().setSkullTexture(this.skinTextures.get(i));
/*     */     } 
/*     */     
/* 117 */     paramButton.action(paramActionType -> new UserListView(this.p, this.plugin)
/*     */         {
/*     */           public void onBack() {
/* 120 */             Overview.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/* 125 */   private static final Phrase GROUPS_TITLE = Phrase.create("overview.groups.title", "Groups");
/* 126 */   private static final Phrase GROUPS_ACTION = Phrase.create("overview.groups.action", "Click to view all **Groups**", Colors.GRAY, new Color[] { Colors.GREEN });
/* 127 */   private static final Phrase GROUPS_DESC = Phrase.create("overview.groups.desc", "%count% Groups created so far", Colors.DARK_GRAY, new Color[0]);
/* 128 */   private static final Phrase GROUPS_SCROLLING_ENTRY = Phrase.create("overview.groups.scrollingEntry", "- **%prefix%** %group% **%suffix%**", Colors.GRAY, new Color[] { Colors.WHITE, Colors.WHITE });
/*     */   
/*     */   private void GroupsButton(Button paramButton) {
/* 131 */     paramButton.material(XMaterial.BOOKSHELF)
/* 132 */       .name(Animation.wave(GROUPS_TITLE.get(), new Color[] { ColorPalette.MAIN, Colors.WHITE
/* 133 */           })).lore(new String[] { GROUPS_ACTION.get() });
/*     */     
/* 135 */     paramButton.item().appendLore(new String[] { "" });
/*     */     
/* 137 */     if (this.groupList == null) {
/* 138 */       this
/*     */ 
/*     */ 
/*     */         
/* 142 */         .groupList = (List<String>)this.plugin.getGroups().stream().map(paramGroup -> GROUPS_SCROLLING_ENTRY.get().replace("%prefix%", paramGroup.getPrefix().orElse("")).replace("%suffix%", paramGroup.getSuffix().orElse("")).replace("%group%", paramGroup.getName()).trim()).collect(Collectors.toList());
/*     */     }
/*     */     
/* 145 */     paramButton.item().appendLore(LoreScroller.scroller(this.groupList, 8, this.start));
/*     */     
/* 147 */     paramButton.item().appendLore(new String[] { "" });
/* 148 */     paramButton.item().appendLore(new String[] { GROUPS_DESC.get().replace("%count%", Integer.toString(this.groupList.size())) });
/*     */     
/* 150 */     paramButton.action(paramActionType -> new GroupListView(this.p, this.plugin)
/*     */         {
/*     */           public void onBack() {
/* 153 */             Overview.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/* 158 */   private static final Phrase PERMISSION_LOG_TITLE = Phrase.create("overview.permissionLog.title", "Permission Log");
/* 159 */   private static final Phrase PERMISSION_LOG_ACTION = Phrase.create("overview.permissionLog.action", "**Click** to open the Permission Log", Colors.GRAY, new Color[] { Colors.AQUA });
/* 160 */   private static final Phrase PERMISSION_LOG_DESC = Phrase.create("overview.permissionLog.desc", "Here you can take a look at all recent permission checks", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void PermissionLogButton(Button paramButton) {
/* 163 */     paramButton.material(XMaterial.WRITABLE_BOOK)
/* 164 */       .name(Animation.wave(PERMISSION_LOG_TITLE.get(), new Color[] { ColorPalette.MAIN, Colors.WHITE
/* 165 */           })).lore(new String[] {
/* 166 */           PERMISSION_LOG_ACTION.get(), "", PERMISSION_LOG_DESC
/*     */           
/* 168 */           .get()
/*     */         });
/*     */     
/* 171 */     paramButton.action(paramActionType -> new PermissionLogViewer(this.p, this.plugin)
/*     */         {
/*     */           public void onBack() {
/* 174 */             Overview.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/* 179 */   private static final Phrase SETTINGS_TITLE = Phrase.create("overview.settings.title", "Settings");
/* 180 */   private static final Phrase SETTINGS_ACTION = Phrase.create("overview.settings.action", "**Click** to view Settings", Colors.GRAY, new Color[] { Colors.AQUA });
/* 181 */   private static final Phrase SETTINGS_DESC = Phrase.create("overview.settings.desc", "Adjust all settings of the plugin", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void SettingsButton(Button paramButton) {
/* 184 */     paramButton.material(XMaterial.COMMAND_BLOCK)
/* 185 */       .name(Animation.wave(SETTINGS_TITLE.get(), new Color[] { ColorPalette.MAIN, Colors.WHITE
/* 186 */           })).lore(new String[] {
/* 187 */           SETTINGS_ACTION.get(), "", SETTINGS_DESC
/*     */           
/* 189 */           .get()
/*     */         });
/*     */     
/* 192 */     paramButton.action(paramActionType -> new UpermsSettingsView(this.p, this.plugin)
/*     */         {
/*     */           public void onBack() {
/* 195 */             Overview.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/* 200 */   private static final Phrase REDUCE_TITLE = Phrase.create("overview.settings.reduce.title", "Reduce");
/* 201 */   private static final Phrase REDUCE_ACTION = Phrase.create("overview.settings.reduce.action", "**Click** to hide advanced features", Colors.GRAY, new Color[] { Colors.AQUA });
/* 202 */   private static final Phrase REDUCE_DESC = Phrase.create("overview.settings.reduce.desc", "This will hide the advanced options", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void ReduceButton(Button paramButton) {
/* 205 */     paramButton.material(XMaterial.TRIPWIRE_HOOK)
/* 206 */       .name(Animation.wave(REDUCE_TITLE.get(), new Color[] { ColorPalette.MAIN, Colors.WHITE
/* 207 */           })).lore(new String[] {
/* 208 */           REDUCE_ACTION.get(), "", REDUCE_DESC
/*     */           
/* 210 */           .get()
/*     */         });
/*     */     
/* 213 */     paramButton.action(paramActionType -> this.expanded = false);
/*     */   }
/*     */   
/* 216 */   private static final Phrase EXPAND_TITLE = Phrase.create("overview.settings.expand.title", "Expand");
/* 217 */   private static final Phrase EXPAND_ACTION = Phrase.create("overview.settings.expand.action", "**Click** to show advanced features", Colors.GRAY, new Color[] { Colors.AQUA });
/* 218 */   private static final Phrase EXPAND_DESC = Phrase.create("overview.settings.expand.desc", "This will show you more advanced options", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void ExpandButton(Button paramButton) {
/* 221 */     paramButton.material(XMaterial.TRIPWIRE_HOOK)
/* 222 */       .name(Animation.wave(EXPAND_TITLE.get(), new Color[] { ColorPalette.MAIN, Colors.WHITE
/* 223 */           })).lore(new String[] {
/* 224 */           EXPAND_ACTION.get(), "", EXPAND_DESC
/*     */           
/* 226 */           .get()
/*     */         });
/*     */     
/* 229 */     paramButton.action(paramActionType -> this.expanded = true);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/Overview.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */