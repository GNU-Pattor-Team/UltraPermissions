/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ 
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Common;
/*     */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class GroupStorageSettingsView extends GUI {
/*     */   private final UltraPermissions plugin;
/*     */   
/*     */   public GroupStorageSettingsView(Player paramPlayer, UltraPermissions paramUltraPermissions, Group paramGroup) {
/*  25 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  27 */     this.plugin = paramUltraPermissions;
/*  28 */     this.group = paramGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   private final Group group;
/*     */   
/*     */   public int getCurrentSlots() {
/*  35 */     return 36;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentTitle() {
/*  40 */     return this.group.getName() + " > Storage Settings";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  45 */     paramModel.button(12, this::WorldButton);
/*  46 */     paramModel.button(16, this::ServerButton);
/*  47 */     paramModel.button(32, paramButton -> Common.BackButton(paramButton, ()));
/*     */   }
/*     */   
/*  50 */   private static final Phrase WORLD_TITLE = Phrase.create("groupStorageSettingsView.world.title", "World");
/*  51 */   private static final Phrase WORLD_ALL_WORLDS_ACTION = Phrase.create("groupStorageSettingsView.world.allWorldsAction", "Click to allow this Group on all Worlds", Colors.GRAY, new Color[0]);
/*  52 */   private static final Phrase WORLD_SPECIFIC_WORLDS_ACTION = Phrase.create("groupStorageSettingsView.world.specificWorldAction", "Click to restrict this Group to a certain World", Colors.GRAY, new Color[0]);
/*  53 */   private static final Phrase WORLD_ATTRIBUTE = Phrase.create("groupStorageSettingsView.world.attribute", "World: **%world%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void WorldButton(Button paramButton) {
/*  56 */     Optional optional = this.group.getWorld();
/*     */     
/*  58 */     paramButton.material(optional.isPresent() ? XMaterial.YELLOW_STAINED_GLASS : XMaterial.GRAY_STAINED_GLASS_PANE)
/*  59 */       .name(Animation.wave(WORLD_TITLE.get(), new Color[] { Colors.YELLOW, Colors.WHITE
/*  60 */           })).lore(new String[] {
/*  61 */           (optional.isPresent() ? WORLD_ALL_WORLDS_ACTION : WORLD_SPECIFIC_WORLDS_ACTION).get()
/*     */         });
/*     */     
/*  64 */     optional.ifPresent(paramString -> paramButton.item().appendLore(new String[] { "", WORLD_ATTRIBUTE.get().replace("%world%", paramString) }));
/*     */ 
/*     */ 
/*     */     
/*  68 */     paramButton.action(paramActionType -> {
/*     */           if (paramOptional.isPresent()) {
/*     */             this.group.setWorld(null);
/*     */           } else {
/*     */             new WorldPickerView(this.p, (SpigotTechPlugin)this.plugin)
/*     */               {
/*     */                 public void onSelect(World param1World) {
/*  75 */                   GroupStorageSettingsView.this.group.setWorld(param1World.getName());
/*  76 */                   onBack();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public String getTitle() {
/*  81 */                   return GroupStorageSettingsView.this.group.getName() + " > World";
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void onBack() {
/*  86 */                   GroupStorageSettingsView.this.reopen();
/*     */                 }
/*     */               };
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*  93 */   private static final Phrase SERVER_TITLE = Phrase.create("groupStorageSettingsView.server.title", "Server");
/*  94 */   private static final Phrase SERVER_DISABLED_NO_NETWORK = Phrase.create("groupStorageSettingsView.server.disabled", "This feature is only available for networks", Colors.GRAY, new Color[0]);
/*  95 */   private static final Phrase SERVER_ALL_SERVERS_ACTION = Phrase.create("groupStorageSettingsView.server.allServersAction", "Click to allow this Group on all Servers", Colors.GRAY, new Color[0]);
/*  96 */   private static final Phrase SERVER_SPECIFIC_SERVERS_ACTION = Phrase.create("groupStorageSettingsView.server.specificServersAction", "Click to restrict this Group to a certain Server", Colors.GRAY, new Color[0]);
/*  97 */   private static final Phrase SERVER_ATTRIBUTE = Phrase.create("groupStorageSettingsView.server.attribute", "Server: **%server%**", Colors.GRAY, new Color[] { Colors.BLUE });
/*     */   
/*     */   private void ServerButton(Button paramButton) {
/* 100 */     if (!this.plugin.isConnectedToNetwork()) {
/* 101 */       paramButton.material(XMaterial.RED_STAINED_GLASS_PANE)
/* 102 */         .name(Animation.wave(SERVER_TITLE.get(), new Color[] { Colors.Red, Colors.WHITE
/* 103 */             })).lore(new String[] { SERVER_DISABLED_NO_NETWORK.get() });
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 108 */     Optional optional = this.group.getServer();
/*     */     
/* 110 */     paramButton.material(optional.isPresent() ? XMaterial.BLUE_STAINED_GLASS : XMaterial.GRAY_STAINED_GLASS_PANE)
/* 111 */       .name(Animation.wave(SERVER_TITLE.get(), new Color[] { Colors.DarkBlue, Colors.WHITE
/* 112 */           })).lore(new String[] {
/* 113 */           (optional.isPresent() ? SERVER_ALL_SERVERS_ACTION : SERVER_SPECIFIC_SERVERS_ACTION).get()
/*     */         });
/*     */     
/* 116 */     optional.ifPresent(paramString -> paramButton.item().appendLore(new String[] { "", SERVER_ATTRIBUTE.get().replace("%server%", paramString) }));
/*     */     
/* 118 */     paramButton.action(paramActionType -> {
/*     */           if (paramOptional.isPresent()) {
/*     */             this.group.setServer(null);
/*     */           } else {
/*     */             new ServerPickerView(this.p, this.plugin)
/*     */               {
/*     */                 public void onSelect(NServer param1NServer) {
/* 125 */                   GroupStorageSettingsView.this.group.setServer(param1NServer.getName());
/* 126 */                   onBack();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public String getTitle() {
/* 131 */                   return GroupStorageSettingsView.this.group.getName() + " > Server";
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void onBack() {
/* 136 */                   GroupStorageSettingsView.this.reopen();
/*     */                 }
/*     */               };
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public abstract void onBack();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/GroupStorageSettingsView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */