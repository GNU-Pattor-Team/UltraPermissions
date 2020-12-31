/*     */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import me.TechsCode.UltraPermissions.PermissionColor;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Common;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.gui.LoreLists;
/*     */ import me.TechsCode.UltraPermissions.permissionDatabase.PermissionInfoList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public abstract class PermissionEditorMainView extends GUI {
/*  29 */   private final int[] layout = new int[] { 11, 12, 13, 14, 15, 16, 17, 20, 21, 22, 23, 24, 25, 26, 29, 30, 31, 32, 33, 34, 35 };
/*     */   
/*     */   private final UltraPermissions plugin;
/*     */   
/*     */   private final PermissionHolder holder;
/*     */   
/*     */   private final long opened;
/*     */   
/*     */   private final List<PluginEntry> entries;
/*     */   
/*     */   private int page;
/*     */ 
/*     */   
/*     */   public PermissionEditorMainView(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder) {
/*  43 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  45 */     this.plugin = paramUltraPermissions;
/*  46 */     this.holder = paramPermissionHolder;
/*  47 */     this.opened = System.currentTimeMillis();
/*     */     
/*  49 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  55 */       .entries = (List<PluginEntry>)Stream.concat(Arrays.<Plugin>stream(Bukkit.getPluginManager().getPlugins()).map(Plugin::getName), Arrays.stream((Object[])new String[] { "Bukkit" })).sorted().map(paramString -> new PluginEntry(paramUltraPermissions, paramString)).filter(paramPluginEntry -> !paramPluginEntry.permissionsFromDatabase.isEmpty()).collect(Collectors.toList());
/*     */     
/*  57 */     this.page = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reopen() {
/*  62 */     super.reopen();
/*     */     
/*  64 */     this.entries.forEach(PluginEntry::retrieveData);
/*     */   }
/*     */   
/*  67 */   private static final Phrase TITLE = Phrase.create("permissionEditorMainView.title", "%holder% > Permissions");
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  71 */     paramModel.setTitle(TITLE.get().replace("%holder%", this.holder.getName()));
/*  72 */     paramModel.setSlots(54);
/*     */     
/*  74 */     int i = this.page * this.layout.length;
/*  75 */     for (int j : this.layout) {
/*  76 */       PluginEntry pluginEntry = (this.entries.size() > i) ? this.entries.get(i) : null;
/*     */       
/*  78 */       paramModel.button(j, (pluginEntry != null) ? (paramButton -> PluginWithPermissionsButton(paramButton, paramPluginEntry)) : this::PlaceholderButton);
/*     */       
/*  80 */       i++;
/*     */     } 
/*     */     
/*  83 */     if (this.page != 0) paramModel.button(10, this::PreviousButton); 
/*  84 */     if (this.entries.size() / this.layout.length > this.page) paramModel.button(18, this::NextButton);
/*     */     
/*  86 */     paramModel.button(47, this::SearchButton);
/*  87 */     paramModel.button(50, paramButton -> Common.BackButton(paramButton, ()));
/*  88 */     paramModel.button(52, this::AddedPermissionButton);
/*  89 */     paramModel.button(53, this::TypeInButton);
/*     */   }
/*     */   
/*  92 */   private static final Phrase ENTRY_ACTION = Phrase.create("permissionEditorMainView.entry.action", "Click to view Permissions", Colors.GRAY, new Color[0]);
/*  93 */   private static final Phrase ENTRY_PERMISSIONS_TITLE = Phrase.create("permissionEditorMainView.entry.permissionsTitle", "Added Permissions", Colors.GRAY, new Color[0]);
/*  94 */   private static final Phrase ENTRY_FOOTER = Phrase.create("permissionEditorMainView.entry.footer", "Found **%count% Permissions** for this plugin in the Permissions Database", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void PluginWithPermissionsButton(Button paramButton, PluginEntry paramPluginEntry) {
/*  97 */     if (paramPluginEntry.permissionCopies.isEmpty()) {
/*  98 */       paramButton.material(XMaterial.WHITE_STAINED_GLASS_PANE);
/*  99 */     } else if (paramPluginEntry.permissionCopies.size() == 1) {
/* 100 */       paramButton.material(PermissionColor.fromPermission(paramPluginEntry.permissionCopies.get(0)).getGlassPane());
/*     */     } else {
/* 102 */       paramButton.material(PermissionColor.cycle(paramPluginEntry.permissionCopies).getGlassBlock());
/*     */     } 
/*     */     
/* 105 */     paramButton.item()
/* 106 */       .amount(Math.max(1, paramPluginEntry.permissionCopies.size()))
/* 107 */       .name(Animation.wave(paramPluginEntry.name, new Color[] { PermissionColor.ALL_SERVERS.getColor(), Colors.WHITE
/* 108 */           })).lore(new String[] {
/* 109 */           ENTRY_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (!paramPluginEntry.permissionCopies.isEmpty()) paramButton.item().appendLore(new String[] { ENTRY_PERMISSIONS_TITLE.get() }); 
/* 116 */     paramButton.item().appendLore(LoreLists.printPermissionCopiesList(paramPluginEntry.permissionCopies, this.opened));
/*     */     
/* 118 */     paramButton.item().appendLore(new String[] { "" });
/*     */ 
/*     */     
/* 121 */     int i = paramPluginEntry.permissionsFromDatabase.size();
/* 122 */     paramButton.item().appendLore((String[])Arrays.<String>stream(ENTRY_FOOTER.split(80)).map(paramString -> paramString.replace("%count%", Integer.toString(paramInt))).toArray(paramInt -> new String[paramInt]));
/*     */     
/* 124 */     paramButton.action(paramActionType -> new PluginPermissionListView(this.p, this.plugin, this.holder, paramPluginEntry)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 128 */             PermissionEditorMainView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private void PlaceholderButton(Button paramButton) {
/* 135 */     paramButton.material(XMaterial.GRAY_STAINED_GLASS_PANE).name();
/*     */   }
/*     */   
/* 138 */   private static final Phrase NEXT_TITLE = Phrase.create("permissionEditorMainView.next.title", "Next");
/* 139 */   private static final Phrase NEXT_ACTION = Phrase.create("permissionEditorMainView.next.action", "Click to go to the next page", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void NextButton(Button paramButton) {
/* 142 */     paramButton.material(XMaterial.ARROW)
/* 143 */       .name(Animation.wave(NEXT_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 144 */           })).lore(new String[] { NEXT_ACTION.get() });
/*     */     
/* 146 */     paramButton.action(paramActionType -> this.page++);
/*     */   }
/*     */   
/* 149 */   private static final Phrase PREVIOUS_TITLE = Phrase.create("permissionEditorMainView.previous.title", "Previous");
/* 150 */   private static final Phrase PREVIOUS_ACTION = Phrase.create("permissionEditorMainView.previous.action", "Click to go to the previous page", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void PreviousButton(Button paramButton) {
/* 153 */     paramButton.material(XMaterial.ARROW)
/* 154 */       .name(Animation.wave(PREVIOUS_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 155 */           })).lore(new String[] { PREVIOUS_ACTION.get() });
/*     */     
/* 157 */     paramButton.action(paramActionType -> this.page--);
/*     */   }
/*     */   
/* 160 */   private static final Phrase ALL_PERMISSIONS_TITLE = Phrase.create("permissionEditorMainView.allPermissions.title", "All Permissions");
/* 161 */   private static final Phrase ALL_PERMISSIONS_ACTION = Phrase.create("permissionEditorMainView.allPermissions.action", "Click to show all added Permissions", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void AddedPermissionButton(Button paramButton) {
/* 164 */     paramButton.material(XMaterial.PAPER)
/* 165 */       .name(Animation.wave(ALL_PERMISSIONS_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 166 */           })).lore(new String[] {
/* 167 */           ALL_PERMISSIONS_ACTION.get()
/*     */         });
/*     */     
/* 170 */     paramButton.item().amount(Math.min(64, this.holder.getPermissions().size() + this.holder.getAdditionalPermissions().size()));
/*     */     
/* 172 */     paramButton.action(paramActionType -> new FullPermissionListView(this.p, this.plugin, this.holder)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 176 */             PermissionEditorMainView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 182 */   private static final Phrase ADD_PERMISSION_TITLE = Phrase.create("permissionEditorMainView.addPermission.title", "Add Permission");
/* 183 */   private static final Phrase ADD_PERMISSION_ADD_ACTION = Phrase.create("permissionEditorMainView.addPermission.addAction", "**Left Click** to add a Permission via Chat", Colors.GRAY, new Color[] { Colors.AQUA });
/* 184 */   private static final Phrase ADD_PERMISSION_ADD_BUNGEE_ACTION = Phrase.create("permissionEditorMainView.addPermission.addBungeeAction", "**Right Click** to add **Bungee Permission**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*     */   
/*     */   private void TypeInButton(Button paramButton) {
/* 187 */     paramButton.material(XMaterial.NAME_TAG)
/* 188 */       .name(Animation.wave(ADD_PERMISSION_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 189 */           })).lore(new String[] {
/* 190 */           ADD_PERMISSION_ADD_ACTION.get()
/*     */         });
/*     */     
/* 193 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.LEFT) {
/*     */             new AddPermissionDialog(this.p, this.plugin, this.holder)
/*     */               {
/*     */                 public void reopen() {
/* 198 */                   PermissionEditorMainView.this.reopen();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */     
/* 204 */     if (this.plugin.getMySQLManager().isEnabled() && this.plugin.isConnectedToNetwork()) {
/* 205 */       paramButton.item().appendLore(new String[] { ADD_PERMISSION_ADD_BUNGEE_ACTION.get() });
/* 206 */       paramButton.action(paramActionType -> {
/*     */             if (paramActionType == ActionType.RIGHT) {
/*     */               new AddBungeePermissionDialog(this.p, this.plugin, this.holder)
/*     */                 {
/*     */                   public void reopen() {
/* 211 */                     PermissionEditorMainView.this.reopen();
/*     */                   }
/*     */                 };
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */   
/* 219 */   private static final Phrase SEARCH_TITLE = Phrase.create("permissionEditorMainView.search.title", "Search a Permission");
/* 220 */   private static final Phrase SEARCH_ACTION = Phrase.create("permissionEditorMainView.search.action", "Click to search for a Permission", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void SearchButton(Button paramButton) {
/* 223 */     paramButton.material(XMaterial.COMPASS)
/* 224 */       .name(Animation.wave(SEARCH_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan
/* 225 */           })).lore(new String[] {
/* 226 */           SEARCH_ACTION.get()
/*     */         });
/*     */     
/* 229 */     paramButton.action(paramActionType -> new SearchPermissionDialog(this.p, this.plugin, this.holder)
/*     */         {
/*     */           public void reopen()
/*     */           {
/* 233 */             PermissionEditorMainView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract void onBack();
/*     */ 
/*     */   
/*     */   class PluginEntry
/*     */   {
/*     */     public final String name;
/*     */     public PermissionInfoList permissionsFromDatabase;
/*     */     public PermissionCopyList permissionCopies;
/*     */     
/*     */     public PluginEntry(UltraPermissions param1UltraPermissions, String param1String) {
/* 249 */       this.name = param1String;
/*     */       
/* 251 */       retrieveData();
/*     */     }
/*     */     
/*     */     public void retrieveData() {
/* 255 */       PermissionList permissionList1 = PermissionEditorMainView.this.holder.getPermissions();
/* 256 */       PermissionList permissionList2 = PermissionEditorMainView.this.holder.getAdditionalPermissions();
/*     */       
/* 258 */       this.permissionsFromDatabase = PermissionEditorMainView.this.plugin.getPermissionDatabase().getPermissionInfosFromPlugin(this.name);
/*     */       
/* 260 */       this
/* 261 */         .permissionCopies = (PermissionCopyList)(new PermissionCopyList(permissionList1, permissionList2)).stream().filter(param1PermissionCopy -> this.permissionsFromDatabase.find(param1PermissionCopy.getPermission().getName()).isPresent()).collect(Collectors.toCollection(PermissionCopyList::new));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PermissionEditorMainView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */