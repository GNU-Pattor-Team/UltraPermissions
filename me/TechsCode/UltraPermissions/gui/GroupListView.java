/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.gui.dialogs.CreateGroupDialog;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class GroupListView extends PageableGUI<Group> {
/*  24 */   private static final Phrase TITLE = Phrase.create("groupListView.titleAllGroups", "Groups > Showing %count% Groups");
/*     */   
/*     */   private final Player p;
/*     */   
/*     */   private final UltraPermissions plugin;
/*     */   private boolean showAll;
/*  30 */   private int showing = 0;
/*     */   
/*     */   public GroupListView(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/*  33 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  35 */     this.p = paramPlayer;
/*  36 */     this.plugin = paramUltraPermissions;
/*     */     
/*  38 */     this.showAll = false;
/*  39 */     int i = (getObjects()).length;
/*     */     
/*  41 */     this.showAll = true;
/*  42 */     int j = (getObjects()).length;
/*     */     
/*  44 */     if (i != j) {
/*  45 */       this.showAll = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  51 */     return TITLE.get().replace("%count%", Integer.toString(this.showing));
/*     */   }
/*     */ 
/*     */   
/*  55 */   private static final Phrase GROUP_OPEN_ACTION = Phrase.create("groupListView.openAction", "**Left Click** to open", Colors.GRAY, new Color[] { Colors.AQUA });
/*  56 */   private static final Phrase GROUP_STORAGE_SETTINGS_ACTION = Phrase.create("groupListView.storageSettingsAction", "**Press Q** to view Storage Settings", Colors.GRAY, new Color[] { Colors.AQUA });
/*  57 */   private static final Phrase GROUP_STORAGE_DEFAULT_INDICATOR = Phrase.create("groupListView.defaultIndicator", "This is a default group", Colors.GREEN, new Color[0]);
/*     */   
/*  59 */   private static final Phrase GROUP_ATTRIBUTE_SERVER = Phrase.create("groupListview.attributes.server", "Server: **%server%**", Colors.GRAY, new Color[] { Colors.GOLD });
/*  60 */   private static final Phrase GROUP_ATTRIBUTE_WORLD = Phrase.create("groupListview.attributes.world", "World: **%world%**", Colors.GRAY, new Color[] { Colors.GOLD });
/*  61 */   private static final Phrase GROUP_ATTRIBUTE_PREFIX = Phrase.create("groupListview.attributes.prefix", "Prefix: **%prefix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  62 */   private static final Phrase GROUP_ATTRIBUTE_SUFFIX = Phrase.create("groupListview.attributes.suffix", "Suffix: **%suffix%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*  64 */   private static final Phrase GROUP_INHERITS_TITLE = Phrase.create("groupListview.inherits.title", "Inherited Groups:", Colors.GRAY, new Color[0]);
/*  65 */   private static final Phrase GROUP_INHERITS_ENTRY = Phrase.create("groupListview.inherits.entry", "- **%group%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  66 */   private static final Phrase GROUP_INHERITS_NONE = Phrase.create("groupListview.inherits.none", "- **none**", Colors.GRAY, new Color[] { Colors.RED });
/*  67 */   private static final Phrase GROUP_PERMISSION_NODES_COUNT = Phrase.create("groupListview.permissions.count", "**%count%** Permission Nodes", Colors.GRAY, new Color[] { Colors.GREEN });
/*     */ 
/*     */   
/*     */   public void construct(Button paramButton, Group paramGroup) {
/*  71 */     paramButton.material(paramGroup.getIcon())
/*  72 */       .name(Animation.wave(paramGroup.getName(), new Color[] { Colors.GOLD, Colors.YELLOW, Colors.WHITE }));
/*     */     
/*  74 */     paramButton.item()
/*  75 */       .appendLore(new String[] { GROUP_OPEN_ACTION.get()
/*  76 */         }).appendLore(new String[] { GROUP_STORAGE_SETTINGS_ACTION.get() });
/*     */     
/*  78 */     boolean bool = paramGroup.isDefault();
/*  79 */     Optional optional1 = paramGroup.getWorld();
/*  80 */     Optional optional2 = paramGroup.getServer();
/*     */ 
/*     */     
/*  83 */     if (bool || optional1.isPresent() || optional2.isPresent()) {
/*  84 */       paramButton.item().appendLore(new String[] { "" });
/*     */     }
/*     */     
/*  87 */     if (paramGroup.isDefault()) {
/*  88 */       paramButton.item().appendLore(new String[] { GROUP_STORAGE_DEFAULT_INDICATOR.get() });
/*     */     }
/*     */     
/*  91 */     optional2.ifPresent(paramString -> paramButton.item().appendLore(new String[] { GROUP_ATTRIBUTE_SERVER.get().replace("%server%", paramString) }));
/*  92 */     optional1.ifPresent(paramString -> paramButton.item().appendLore(new String[] { GROUP_ATTRIBUTE_WORLD.get().replace("%world%", paramString) }));
/*     */     
/*  94 */     String str1 = paramGroup.getPrefix().orElse(Colors.RED + Words.NONE.get());
/*  95 */     String str2 = paramGroup.getSuffix().orElse(Colors.RED + Words.NONE.get());
/*     */     
/*  97 */     paramButton.item().appendLore(new String[] { "", GROUP_ATTRIBUTE_PREFIX
/*     */           
/*  99 */           .get().replace("%prefix%", str1), GROUP_ATTRIBUTE_SUFFIX
/* 100 */           .get().replace("%suffix%", str2), "" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     paramButton.item().appendLore(new String[] { GROUP_INHERITS_TITLE.get() });
/* 107 */     GroupList groupList = paramGroup.getActiveInheritedGroups().bestToWorst();
/* 108 */     for (Group group : groupList) {
/* 109 */       paramButton.item().appendLore(new String[] { GROUP_INHERITS_ENTRY.get().replace("%group%", group.getName()) });
/*     */     } 
/*     */     
/* 112 */     if (groupList.isEmpty()) {
/* 113 */       paramButton.item().appendLore(new String[] { GROUP_INHERITS_NONE.get() });
/*     */     }
/*     */     
/* 116 */     int i = paramGroup.getPermissions().size();
/* 117 */     paramButton.item().appendLore(new String[] { "", GROUP_PERMISSION_NODES_COUNT.get().replace("%count%", Integer.toString(i)) });
/*     */     
/* 119 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.Q) {
/*     */             new GroupStorageSettingsView(this.p, this.plugin, paramGroup)
/*     */               {
/*     */                 public void onBack() {
/* 124 */                   GroupListView.this.reopen();
/*     */                 }
/*     */               };
/*     */             return;
/*     */           } 
/*     */           new GroupView(this.p, this.plugin, paramGroup)
/*     */             {
/*     */               public void onBack()
/*     */               {
/* 133 */                 GroupListView.this.reopen();
/*     */               }
/*     */             };
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/* 141 */     super.construct(paramModel);
/*     */     
/* 143 */     if (!this.showAll) {
/* 144 */       paramModel.button(47, this::ShowAllButton);
/*     */     }
/*     */     
/* 147 */     paramModel.button(52, this::ReorderButton);
/* 148 */     paramModel.button(53, this::AddButton);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getLeftOptionSlot() {
/* 154 */     return this.showAll ? 48 : super.getLeftOptionSlot();
/*     */   }
/*     */   
/* 157 */   private static final Phrase ADD_TITLE = Phrase.create("groupListView.add.title", "Create Group");
/* 158 */   private static final Phrase ADD_ACTION = Phrase.create("groupListView.add.action", "Click to create group", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void AddButton(Button paramButton) {
/* 161 */     paramButton.material(XMaterial.ANVIL)
/* 162 */       .name(Animation.fading(ADD_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 163 */           })).lore(new String[] { ADD_ACTION.get() });
/*     */     
/* 165 */     paramButton.action(paramActionType -> new CreateGroupDialog(this.p, this.plugin)
/*     */         {
/*     */           public void reopen()
/*     */           {
/* 169 */             GroupListView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 175 */   private static final Phrase REORDER_TITLE = Phrase.create("groupListView.reorder.title", "Change Order");
/* 176 */   private static final Phrase REORDER_ACTION = Phrase.create("groupListView.reorder.action", "Click to modify the order", Colors.GRAY, new Color[0]);
/*     */   
/*     */   public void ReorderButton(Button paramButton) {
/* 179 */     paramButton.material(XMaterial.ITEM_FRAME)
/* 180 */       .name(Animation.fading(REORDER_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 181 */           })).lore(new String[] { REORDER_ACTION.get() });
/*     */     
/* 183 */     paramButton.action(paramActionType -> new GroupReorderView(this.p, this.plugin)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 187 */             GroupListView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 193 */   private static final Phrase SHOW_ALL_TITLE = Phrase.create("groupListView.showAll.title", "Show all");
/* 194 */   private static final Phrase SHOW_ALL_ACTION = Phrase.create("groupListView.showAll.action", "Click to show all groups from all Servers & Worlds", Colors.GRAY, new Color[0]);
/*     */   
/*     */   public void ShowAllButton(Button paramButton) {
/* 197 */     paramButton.material(XMaterial.ENDER_EYE)
/* 198 */       .name(Animation.fading(SHOW_ALL_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 199 */           })).lore(SHOW_ALL_ACTION.split(50));
/*     */     
/* 201 */     paramButton.action(paramActionType -> this.showAll = true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Group[] getObjects() {
/* 208 */     GroupList groupList = this.plugin.getGroups();
/*     */     
/* 210 */     if (!this.showAll)
/*     */     {
/*     */       
/* 213 */       groupList = groupList.servers(true, new String[] { this.plugin.getThisServer().map(NServer::getName).orElse(null) }).worlds(true, new String[] { this.p.getWorld().getName() });
/*     */     }
/*     */     
/* 216 */     this.showing = groupList.size();
/*     */     
/* 218 */     return (Group[])groupList.toArray((Object[])new Group[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchFeature<Group> getSearch() {
/* 223 */     return (SearchFeature<Group>)new BasicSearch<Group>()
/*     */       {
/*     */         public String[] getSearchableText(Group param1Group) {
/* 226 */           return new String[] { param1Group
/* 227 */               .getName() };
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/GroupListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */