/*     */ package me.TechsCode.UltraPermissions.gui.settings;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.DefaultGroupAssignOption;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*     */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsPane;
/*     */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsView;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.visual.VisualRegistry;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class MiscPane
/*     */   extends SettingsPane {
/*     */   private final UltraPermissions plugin;
/*     */   private DefaultGroupAssignOption selected;
/*     */   
/*     */   public MiscPane(Player paramPlayer, SettingsView paramSettingsView, UltraPermissions paramUltraPermissions) {
/*  26 */     super(paramPlayer, paramSettingsView);
/*     */     
/*  28 */     this.plugin = paramUltraPermissions;
/*     */   }
/*     */   
/*  31 */   private static final Phrase NAME = Phrase.create("miscPane.name", "Miscellaneous");
/*     */ 
/*     */   
/*     */   public String getName() {
/*  35 */     return NAME.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public XMaterial getIcon() {
/*  40 */     return XMaterial.BOWL;
/*     */   }
/*     */ 
/*     */   
/*     */   public void construct(Model paramModel) {
/*  45 */     paramModel.button(21, this::DefaultPermissionToggle);
/*  46 */     paramModel.button(23, this::DefaultGroupAssignToggle);
/*  47 */     paramModel.button(25, this::NameTagsButton);
/*     */   }
/*     */   
/*  50 */   private static final Phrase DEFAULT_PERMS_TITLE = Phrase.create("miscPane.defaultPerms.title", "Default Permissions");
/*  51 */   private static final Phrase DEFAULT_PERMS_ENABLE_ACTION = Phrase.create("miscPane.defaultPerms.enableAction", "Click to **enable** default permissions", Colors.GRAY, new Color[] { Colors.GREEN });
/*  52 */   private static final Phrase DEFAULT_PERMS_DISABLE_ACTION = Phrase.create("miscPane.defaultPerms.disableAction", "Click to **disable** default permissions", Colors.GRAY, new Color[] { Colors.RED });
/*  53 */   private static final Phrase DEFAULT_PERMS_STATE = Phrase.create("miscPane.defaultPerms.state", "State: **%status%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  54 */   private static final Phrase DEFAULT_PERMS_EXPLANATION = Phrase.create("miscPane.defaultPerms.explanation", "It is recommended to keep it **disabled** to avoid unwanted side effects and to maintain full control", Colors.GRAY, new Color[] { Colors.RED });
/*  55 */   private static final Phrase DEFAULT_PERMS_DESC = Phrase.create("miscPane.defaultPerms.desc", "Changes take effect on reconnect", Colors.DARK_GRAY, new Color[0]);
/*     */   
/*     */   private void DefaultPermissionToggle(Button paramButton) {
/*  58 */     paramButton.material(XMaterial.BEDROCK)
/*  59 */       .name(Animation.wave(DEFAULT_PERMS_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/*  60 */           })).lore(new String[] {
/*  61 */           (this.plugin.isDefaultPermissionsEnabled() ? DEFAULT_PERMS_DISABLE_ACTION : DEFAULT_PERMS_ENABLE_ACTION).get(), "", DEFAULT_PERMS_STATE
/*     */           
/*  63 */           .get().replace("%status%", (this.plugin.isDefaultPermissionsEnabled() ? Words.ENABLED : Words.DISABLED).get()), ""
/*     */         });
/*     */ 
/*     */     
/*  67 */     paramButton.item().appendLore(DEFAULT_PERMS_EXPLANATION.split(60));
/*     */     
/*  69 */     paramButton.item().appendLore(new String[] { "", DEFAULT_PERMS_DESC
/*     */           
/*  71 */           .get() });
/*     */ 
/*     */     
/*  74 */     paramButton.action(paramActionType -> this.plugin.setDefaultPermissions(!this.plugin.isDefaultPermissionsEnabled()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  79 */   private static final Phrase DEFAULT_GROUP_ASSIGN_TITLE = Phrase.create("miscPane.defaultGroupAssign.title", "Default Group Assigning");
/*  80 */   private static final Phrase DEFAULT_GROUP_ASSIGN_TOGGLE_ACTION = Phrase.create("miscPane.defaultGroupAssign.toggleAction", "Click to **toggle**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  81 */   private static final Phrase DEFAULT_GROUP_ASSIGN_SAVE_ACTION = Phrase.create("miscPane.defaultGroupAssign.saveAction", "**Press Q** to **save** changes", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GREEN });
/*  82 */   private static final Phrase DEFAULT_GROUP_ASSIGN_DESC = Phrase.create("miscPane.defaultGroupAssign.desc", "This could be a **destructive action**, pay attention before confirming", Colors.GRAY, new Color[] { Colors.RED });
/*     */   
/*     */   private void DefaultGroupAssignToggle(Button paramButton) {
/*  85 */     paramButton.material(XMaterial.PISTON)
/*  86 */       .name(Animation.wave(DEFAULT_GROUP_ASSIGN_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/*  87 */           })).lore(new String[] { DEFAULT_GROUP_ASSIGN_TOGGLE_ACTION.get() });
/*     */     
/*  89 */     if (this.selected != null) {
/*  90 */       paramButton.item().appendLore(new String[] { DEFAULT_GROUP_ASSIGN_SAVE_ACTION.get() });
/*  91 */       paramButton.action(paramActionType -> {
/*     */             if (paramActionType == ActionType.Q) {
/*     */               this.plugin.setDefaultGroupAssignOption(this.selected);
/*     */               
/*     */               this.selected = null;
/*     */             } 
/*     */           });
/*     */     } 
/*  99 */     paramButton.item().appendLore(new String[] { "" });
/*     */     
/* 101 */     DefaultGroupAssignOption defaultGroupAssignOption = this.plugin.getDefaultGroupAssignOption();
/*     */     
/* 103 */     for (DefaultGroupAssignOption defaultGroupAssignOption1 : DefaultGroupAssignOption.values()) {
/* 104 */       boolean bool1 = (this.selected == null && defaultGroupAssignOption == defaultGroupAssignOption1) ? true : false;
/* 105 */       boolean bool2 = (this.selected == defaultGroupAssignOption1) ? true : false;
/*     */       
/* 107 */       paramButton.item().appendLore(new String[] { (bool1 ? (String)Colors.GREEN : (bool2 ? (String)Colors.YELLOW : (String)Colors.WHITE)) + "- " + Colors.GRAY + defaultGroupAssignOption1.getDescription() });
/*     */     } 
/*     */     
/* 110 */     paramButton.item().appendLore(new String[] { "", DEFAULT_GROUP_ASSIGN_DESC.get() });
/*     */     
/* 112 */     paramButton.action(paramActionType -> {
/*     */           if (paramActionType != ActionType.Q) {
/*     */             this.selected = ((this.selected != null) ? this.selected : paramDefaultGroupAssignOption).next();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/* 119 */   private static final Phrase NAME_TAGS_TITLE = Phrase.create("miscPane.nameTags.title", "Name Tags");
/* 120 */   private static final Phrase NAME_TAGS_DISABLE_ACTION = Phrase.create("miscPane.nameTags.disableAction", "Click to **disable** this feature", Colors.GRAY, new Color[] { Colors.RED });
/* 121 */   private static final Phrase NAME_TAGS_ENABLE_ACTION = Phrase.create("miscPane.nameTags.enableAction", "Click to **enable** this feature", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 122 */   private static final Phrase NAME_TAGS_DISABLED = Phrase.create("miscPane.nameTags.disabled", "The Plugin **NameTagEdit** is required for this feature", Colors.GRAY, new Color[] { Colors.RED });
/* 123 */   private static final Phrase NAME_TAGS_ENABLED_INDICATOR = Phrase.create("miscPane.nameTags.enabledIndicator", "Name Tags will be **shown** above player heads", Colors.GRAY, new Color[] { Colors.GREEN });
/* 124 */   private static final Phrase NAME_TAGS_DISABLED_INDICATOR = Phrase.create("miscPane.nameTags.disabledIndicator", "Name Tags are currently **not showing**", Colors.GRAY, new Color[] { Colors.RED });
/* 125 */   private static final Phrase NAME_TAGS_DESC = Phrase.create("miscPane.nameTags.desc", "Show **Prefix**/**Suffix** in the Name Tag above other players", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.YELLOW });
/*     */   
/*     */   private void NameTagsButton(Button paramButton) {
/* 128 */     boolean bool1 = Bukkit.getPluginManager().isPluginEnabled("NametagEdit");
/* 129 */     boolean bool2 = ((VisualRegistry)this.plugin.getVisualRegistry().get()).isEditingNametags();
/*     */     
/* 131 */     paramButton.material(XMaterial.NAME_TAG)
/* 132 */       .name(Animation.wave(NAME_TAGS_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/* 133 */           })).lore(new String[] {
/* 134 */           (bool1 ? (bool2 ? NAME_TAGS_DISABLE_ACTION : NAME_TAGS_ENABLE_ACTION) : NAME_TAGS_DISABLED).get(), "", (bool2 ? NAME_TAGS_ENABLED_INDICATOR : NAME_TAGS_DISABLED_INDICATOR)
/*     */           
/* 136 */           .get(), "", NAME_TAGS_DESC
/*     */           
/* 138 */           .get()
/*     */         });
/*     */     
/* 141 */     paramButton.action(paramActionType -> {
/*     */           if (paramBoolean1)
/*     */             ((VisualRegistry)this.plugin.getVisualRegistry().get()).setEditingNametags(!paramBoolean2); 
/*     */         });
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/settings/MiscPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */