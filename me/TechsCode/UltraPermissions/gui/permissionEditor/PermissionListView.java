/*     */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import me.TechsCode.UltraPermissions.PermissionColor;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.gui.LoreLists;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class PermissionListView
/*     */   extends PageableGUI<PermissionWithInfo> {
/*     */   private final UltraPermissions plugin;
/*     */   
/*     */   public PermissionListView(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder) {
/*  30 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  32 */     this.plugin = paramUltraPermissions;
/*  33 */     this.holder = paramPermissionHolder;
/*  34 */     this.opened = System.currentTimeMillis();
/*     */   }
/*     */   private final PermissionHolder holder;
/*     */   private final long opened;
/*     */   
/*     */   public SearchFeature<PermissionWithInfo> getSearch() {
/*  40 */     return (SearchFeature<PermissionWithInfo>)new BasicSearch<PermissionWithInfo>()
/*     */       {
/*     */         public String[] getSearchableText(PermissionWithInfo param1PermissionWithInfo) {
/*  43 */           return new String[] { param1PermissionWithInfo
/*  44 */               .getName(), 
/*  45 */               param1PermissionWithInfo.hasInfo() ? param1PermissionWithInfo.getInfo().getDescription() : "xxx" };
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void construct(Button paramButton, PermissionWithInfo paramPermissionWithInfo) {
/*  53 */     PermissionCopyList permissionCopyList = new PermissionCopyList(this.holder.getPermissions().name(paramPermissionWithInfo.getName()), this.holder.getAdditionalPermissions().name(paramPermissionWithInfo.getName()));
/*     */     
/*  55 */     if (permissionCopyList.size() == 0) {
/*  56 */       NotAddedPermission(paramButton, paramPermissionWithInfo);
/*  57 */     } else if (permissionCopyList.size() == 1) {
/*  58 */       if (permissionCopyList.inheritedCopies().size() == 1) {
/*  59 */         InheritedOnlyButton(paramButton, paramPermissionWithInfo, permissionCopyList.get(0));
/*     */       } else {
/*  61 */         SingleAddedPermissionButton(paramButton, paramPermissionWithInfo, permissionCopyList.get(0));
/*     */       } 
/*     */     } else {
/*  64 */       MultiAddedPermissionButton(paramButton, paramPermissionWithInfo, permissionCopyList);
/*     */     } 
/*     */     
/*  67 */     if (paramPermissionWithInfo.hasInfo()) {
/*  68 */       paramButton.item().appendLore(new String[] { "" });
/*  69 */       paramButton.item().appendLore(paramPermissionWithInfo.getInfo().asLore());
/*     */     } 
/*     */   }
/*     */   
/*  73 */   private static final Phrase NOT_ADDED_ACTION = Phrase.create("permissionListView.notAdded.action", "Click to **Quick Add** permission", Colors.GRAY, new Color[] { Colors.GREEN });
/*  74 */   private static final Phrase NOT_ADDED_PLACEHOLDERS_TITLE = Phrase.create("permissionListView.placeholders.title", "Please note that", Colors.GRAY, new Color[0]);
/*  75 */   private static final Phrase NOT_ADDED_PLACEHOLDERS_ENTRY = Phrase.create("permissionListView.placeholders.entry", "- **[%placeholder%]** is a placeholder", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*     */   private void NotAddedPermission(Button paramButton, PermissionWithInfo paramPermissionWithInfo) {
/*  78 */     paramButton.material(XMaterial.WHITE_STAINED_GLASS_PANE)
/*  79 */       .name(Animation.wave(paramPermissionWithInfo.getName(), new Color[] { Colors.WHITE, Colors.GRAY
/*  80 */           })).lore(new String[] { NOT_ADDED_ACTION.get() });
/*     */     
/*  82 */     if (paramPermissionWithInfo.hasInfo() && paramPermissionWithInfo.getInfo().hasPlaceholders()) {
/*  83 */       paramButton.item().appendLore(new String[] { "", NOT_ADDED_PLACEHOLDERS_TITLE
/*     */             
/*  85 */             .get() });
/*     */ 
/*     */       
/*  88 */       for (String str : paramPermissionWithInfo.getInfo().getPlaceholders()) {
/*  89 */         paramButton.item().appendLore(new String[] { NOT_ADDED_PLACEHOLDERS_ENTRY.get().replace("%placeholder%", str) });
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.LEFT) {
/*     */             new PlaceholderFillDialog(this.p, this.plugin, paramPermissionWithInfo.getName())
/*     */               {
/*     */                 public void onBack() {
/*  98 */                   PermissionListView.this.reopen();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void onComplete(String param1String) {
/* 103 */                   PermissionListView.this.holder.newPermission(param1String).create();
/* 104 */                   PermissionListView.this.reopen();
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */   }
/*     */   
/* 111 */   private static final Phrase LORE_ALL_SERVERS = Phrase.create("permissionListView.lore.allServersAttribute", "**•** Permission available on all Servers", Colors.GRAY, new Color[] { Colors.WHITE });
/* 112 */   private static final Phrase LORE_SPECIFIC_SERVER = Phrase.create("permissionListView.lore.specificServerAttribute", "**•** Only applying to Server '**%server%**'", Colors.GRAY, new Color[] { Colors.WHITE, Colors.WHITE });
/* 113 */   private static final Phrase LORE_ALL_WORLDS = Phrase.create("permissionListView.lore.allWorldsAttribute", "**•** Permission applies to every World", Colors.GRAY, new Color[] { Colors.WHITE });
/* 114 */   private static final Phrase LORE_SPECIFIC_WORLD = Phrase.create("permissionListView.lore.specificWorldAttribute", "**•** Exclusive to the World '**%world%**'", Colors.GRAY, new Color[] { Colors.WHITE, Colors.WHITE });
/* 115 */   private static final Phrase LORE_TEMPORARY = Phrase.create("permissionListView.lore.temporaryAttribute", "**•** Will expire in **%time%**", Colors.GRAY, new Color[] { Colors.WHITE, Colors.RED });
/*     */   
/*     */   private List<String> permissionSettingsLore(PermissionCopy paramPermissionCopy) {
/* 118 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 120 */     Optional<String> optional = paramPermissionCopy.getPermission().getServer();
/*     */     
/* 122 */     if (optional.isPresent()) {
/* 123 */       arrayList.add(LORE_SPECIFIC_SERVER.get().replace("%server%", paramPermissionCopy.getColor() + (String)optional.get()));
/*     */     } else {
/* 125 */       arrayList.add(LORE_ALL_SERVERS.get());
/*     */     } 
/*     */     
/* 128 */     if (paramPermissionCopy.getPermission().getWorld().isPresent()) {
/* 129 */       arrayList.add(LORE_SPECIFIC_WORLD.get().replace("%world%", paramPermissionCopy.getPermission().getWorld().get()));
/*     */     } else {
/* 131 */       arrayList.add(LORE_ALL_WORLDS.get());
/*     */     } 
/*     */     
/* 134 */     if (paramPermissionCopy.getPermission().getExpiration() != 0L) {
/* 135 */       long l = paramPermissionCopy.getPermission().getExpiration() - System.currentTimeMillis();
/* 136 */       String str = Tools.getTimeString(l, TimeUnit.MILLISECONDS, 2);
/* 137 */       arrayList.add(LORE_TEMPORARY.get().replace("%time%", str));
/*     */     } 
/*     */     
/* 140 */     return arrayList;
/*     */   }
/*     */   
/* 143 */   private static final Phrase SINGLE_EDIT_ACTION = Phrase.create("permissionListView.single.editAction", "**Left Click** to edit this Permission", Colors.GRAY, new Color[] { Colors.AQUA });
/* 144 */   private static final Phrase SINGLE_DELETE_ACTION = Phrase.create("permissionListView.single.deleteAction", "**Right Click** to **delete**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/* 145 */   private static final Phrase SINGLE_SETTINGS_TITLE = Phrase.create("permissionListView.single.settingsTitle", "Settings:", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void SingleAddedPermissionButton(Button paramButton, PermissionWithInfo paramPermissionWithInfo, PermissionCopy paramPermissionCopy) {
/* 148 */     PermissionColor permissionColor = PermissionColor.fromPermission(paramPermissionCopy);
/*     */     
/* 150 */     paramButton.material(permissionColor.getGlassPane())
/* 151 */       .name((paramPermissionCopy.getPermission().isPositive() ? "" : (Colors.RED + "-")) + Animation.wave(paramPermissionWithInfo.getName(), new Color[] { permissionColor.getColor(), Colors.WHITE
/* 152 */           })).lore(new String[] {
/* 153 */           SINGLE_EDIT_ACTION.get(), SINGLE_DELETE_ACTION
/* 154 */           .get(), ""
/*     */         });
/*     */ 
/*     */     
/* 158 */     paramButton.item().appendLore(new String[] { SINGLE_SETTINGS_TITLE.get() });
/* 159 */     paramButton.item().appendLore(permissionSettingsLore(paramPermissionCopy));
/*     */     
/* 161 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType == ActionType.LEFT) {
/*     */             new PermissionView(this.p, this.plugin, this.holder, paramPermissionWithInfo)
/*     */               {
/*     */                 public void onBack() {
/* 166 */                   PermissionListView.this.reopen();
/*     */                 }
/*     */               };
/*     */           }
/*     */           if (paramActionType == ActionType.RIGHT) {
/*     */             paramPermissionCopy.getPermission().remove();
/*     */             reopen();
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 178 */   private static final Phrase MULTI_TITLE = Phrase.create("permissionListView.title", "%permission% (See below)");
/* 179 */   private static final Phrase MULTI_ACTION = Phrase.create("permissionListView.action", "Click to view all Permission Copies", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void MultiAddedPermissionButton(Button paramButton, PermissionWithInfo paramPermissionWithInfo, PermissionCopyList paramPermissionCopyList) {
/* 182 */     paramButton.material(PermissionColor.cycle(paramPermissionCopyList).getGlassBlock())
/* 183 */       .name(Animation.wave(MULTI_TITLE.get().replace("%permission%", paramPermissionWithInfo.getName()), new Color[] { Colors.GRAY, Colors.WHITE
/* 184 */           })).lore(new String[] {
/* 185 */           MULTI_ACTION.get(), ""
/*     */         
/* 187 */         }).amount(paramPermissionCopyList.size());
/*     */     
/* 189 */     paramButton.item().appendLore(LoreLists.printPermissionCopiesList(paramPermissionCopyList, this.opened));
/*     */     
/* 191 */     paramButton.action(paramActionType -> new PermissionView(this.p, this.plugin, this.holder, paramPermissionWithInfo)
/*     */         {
/*     */           public void onBack()
/*     */           {
/* 195 */             PermissionListView.this.reopen();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 201 */   private static final Phrase INHERITED_VIEW_ACTION = Phrase.create("permissionListView.inherited.viewAction", "**Left Click** to view this Permission", Colors.GRAY, new Color[] { Colors.AQUA });
/* 202 */   private static final Phrase INHERITED_NEGATE_ACTION = Phrase.create("permissionListView.inherited.negateAction", "**Right Click** to **Quick-Negate** this permission", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/* 203 */   private static final Phrase INHERITED_SOURCE_DESC = Phrase.create("permissionListView.inherited.sourceDesc", "This Permission originates from **%group%**", Colors.GRAY, new Color[] { Colors.GREEN });
/* 204 */   private static final Phrase INHERITED_SETTINGS_TITLE = Phrase.create("permissionListView.inherited.settingsTitle", "Settings:", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void InheritedOnlyButton(Button paramButton, PermissionWithInfo paramPermissionWithInfo, PermissionCopy paramPermissionCopy) {
/* 207 */     paramButton.material(PermissionColor.INHERITED.getGlassPane())
/* 208 */       .name(Animation.wave(paramPermissionWithInfo.getName(), new Color[] { Colors.YELLOW, Colors.WHITE
/* 209 */           })).lore(new String[] { INHERITED_VIEW_ACTION.get() });
/*     */     
/* 211 */     paramButton.action(paramActionType -> new PermissionView(this.p, this.plugin, this.holder, paramPermissionWithInfo)
/*     */         {
/*     */           public void onBack() {
/* 214 */             PermissionListView.this.reopen();
/*     */           }
/*     */         });
/*     */     
/* 218 */     if (paramPermissionCopy.getPermission().isPositive()) {
/* 219 */       paramButton.item().appendLore(new String[] { INHERITED_NEGATE_ACTION.get() });
/* 220 */       paramButton.action(paramActionType -> {
/*     */             if (paramActionType == ActionType.RIGHT) {
/*     */               this.holder.newPermission(paramPermissionWithInfo.getName()).setPositive(false).setServer(paramPermissionCopy.getPermission().getServer().orElse(null)).setWorld(paramPermissionCopy.getPermission().getWorld().orElse(null)).create();
/*     */ 
/*     */ 
/*     */               
/*     */               reopen();
/*     */             } 
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 233 */     paramButton.item().appendLore(new String[] { "", INHERITED_SOURCE_DESC
/*     */           
/* 235 */           .get().replace("%group%", paramPermissionCopy.getPermission().getHolder().getName()), "", INHERITED_SETTINGS_TITLE
/*     */           
/* 237 */           .get() });
/*     */     
/* 239 */     paramButton.item().appendLore(permissionSettingsLore(paramPermissionCopy));
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PermissionListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */