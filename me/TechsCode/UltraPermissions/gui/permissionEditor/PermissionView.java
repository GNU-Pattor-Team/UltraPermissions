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
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Common;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.gui.ServerPickerView;
/*     */ import me.TechsCode.UltraPermissions.gui.WorldPickerView;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class PermissionView extends GUI {
/*     */   private final UltraPermissions plugin;
/*     */   private final PermissionHolder holder;
/*     */   private final PermissionWithInfo permissionWithInfo;
/*     */   private List<PermissionCopy> permissionCopies;
/*     */   private int currentCopy;
/*     */   
/*     */   public PermissionView(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder, PermissionWithInfo paramPermissionWithInfo) {
/*  39 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  41 */     this.plugin = paramUltraPermissions;
/*  42 */     this.holder = paramPermissionHolder;
/*  43 */     this.permissionWithInfo = paramPermissionWithInfo;
/*     */     
/*  45 */     reloadPermissionCopies();
/*     */   }
/*     */   
/*     */   private void reloadPermissionCopies() {
/*  49 */     this.permissionCopies = new ArrayList<>();
/*  50 */     this.holder.getPermissions().stream().filter(paramPermission -> this.permissionWithInfo.isThisPermission(paramPermission.getName())).forEach(paramPermission -> this.permissionCopies.add(new PermissionCopy(paramPermission, false)));
/*  51 */     this.holder.getAdditionalPermissions().stream().filter(paramPermission -> this.permissionWithInfo.isThisPermission(paramPermission.getName())).forEach(paramPermission -> this.permissionCopies.add(new PermissionCopy(paramPermission, true)));
/*     */     
/*  53 */     this.currentCopy = Math.min(this.permissionCopies.size(), this.currentCopy + 1) - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  58 */     paramModel.setTitle(this.holder.getName() + " > " + this.permissionWithInfo.getName());
/*  59 */     paramModel.setSlots(45);
/*     */     
/*  61 */     for (byte b = 0; b <= 8; b++) {
/*  62 */       byte b1 = b;
/*     */       
/*  64 */       paramModel.button(b + 1, (this.permissionCopies.size() > b) ? (paramButton -> CopyEntryButton(paramButton, this.permissionCopies.get(paramInt), paramInt)) : this::PlaceholderTabButton);
/*     */     } 
/*     */     
/*  67 */     if (this.permissionCopies.size() < 8) paramModel.button(9, this::CreateNewCopyButton);
/*     */     
/*  69 */     if (!this.permissionCopies.isEmpty()) {
/*  70 */       PermissionCopy permissionCopy = this.permissionCopies.get(this.currentCopy);
/*     */       
/*  72 */       if (permissionCopy.isInherited()) {
/*  73 */         paramModel.button(23, paramButton -> InheritedButton(paramButton, paramPermissionCopy.getPermission()));
/*     */       } else {
/*  75 */         paramModel.button(20, paramButton -> ServerButton(paramButton, paramPermissionCopy.getPermission()));
/*  76 */         paramModel.button(22, paramButton -> WorldButton(paramButton, paramPermissionCopy.getPermission()));
/*  77 */         paramModel.button(24, paramButton -> PolarityButton(paramButton, paramPermissionCopy.getPermission()));
/*  78 */         paramModel.button(26, paramButton -> DeleteButton(paramButton, paramPermissionCopy.getPermission()));
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     paramModel.button(41, paramButton -> Common.BackButton(paramButton, ()));
/*     */   }
/*     */   
/*  85 */   private static final Phrase COPY_ENTRY_SELECT_ACTION = Phrase.create("permissionView.entry.selectAction", "Click to **select** this copy", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  86 */   private static final Phrase COPY_ENTRY_SELECTED_INDICATOR = Phrase.create("permissionView.entry.selectedIndicator", "This copy is currently **selected**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  87 */   private static final Phrase COPY_ENTRY_SERVER_ATTRIBUTE = Phrase.create("permissionView.entry.serverAttribute", "Server: **%server%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  88 */   private static final Phrase COPY_ENTRY_WORLD_ATTRIBUTE = Phrase.create("permissionView.entry.worldAttribute", "World: **%world%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  89 */   private static final Phrase COPY_ENTRY_PERMANENT_DESC = Phrase.create("permissionView.entry.permanentDesc", "This permission is **permanent** and cannot expire", Colors.GRAY, new Color[] { Colors.RED });
/*  90 */   private static final Phrase COPY_ENTRY_TEMPORARY_DESC = Phrase.create("permissionView.entry.temporaryDesc", "Expiring in **%time%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void CopyEntryButton(Button paramButton, PermissionCopy paramPermissionCopy, int paramInt) {
/*  93 */     Permission permission = paramPermissionCopy.getPermission();
/*  94 */     PermissionColor permissionColor = PermissionColor.fromPermission(paramPermissionCopy);
/*     */     
/*  96 */     boolean bool = (paramInt == this.currentCopy) ? true : false;
/*  97 */     paramButton.material(permissionColor.getGlassPane())
/*  98 */       .name((permission.isPositive() ? "" : (Colors.RED + "-")) + Animation.wave(permission.getName(), new Color[] { permissionColor.getColor(), Colors.WHITE
/*  99 */           })).lore(new String[] {
/* 100 */           (bool ? COPY_ENTRY_SELECTED_INDICATOR : COPY_ENTRY_SELECT_ACTION).get(), "", COPY_ENTRY_SERVER_ATTRIBUTE
/*     */           
/* 102 */           .get().replace("%server%", getServer(permission)), COPY_ENTRY_WORLD_ATTRIBUTE
/* 103 */           .get().replace("%world%", getWorld(permission)), ""
/*     */         });
/*     */ 
/*     */     
/* 107 */     if (paramPermissionCopy.getPermission().isPermanent()) {
/* 108 */       paramButton.item().appendLore(new String[] { COPY_ENTRY_PERMANENT_DESC.get() });
/*     */     } else {
/* 110 */       String str = Tools.getTimeString(permission.getExpiration(), TimeUnit.MILLISECONDS, 2);
/* 111 */       paramButton.item().appendLore(new String[] { COPY_ENTRY_TEMPORARY_DESC.get().replace("%time%", str) });
/*     */     } 
/*     */     
/* 114 */     if (bool) paramButton.item().addEnchantment(Enchantment.LUCK, 3);
/*     */     
/* 116 */     paramButton.action(paramActionType -> this.currentCopy = paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 121 */   private static final Phrase NEW_COPY_TITLE = Phrase.create("permissionView.newCopy.title", "Create new Copy");
/* 122 */   private static final Phrase NEW_COPY_ACTION = Phrase.create("permissionView.newCopy.action", "Click to create a new copy of this permission", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void CreateNewCopyButton(Button paramButton) {
/* 125 */     paramButton.material(XMaterial.ANVIL)
/* 126 */       .name(Animation.wave(NEW_COPY_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/* 127 */           })).lore(new String[] {
/* 128 */           NEW_COPY_ACTION.get()
/*     */         });
/*     */     
/* 131 */     paramButton.action(paramActionType -> {
/*     */           this.holder.newPermission(this.permissionWithInfo.getName()).create();
/*     */           reloadPermissionCopies();
/*     */         });
/*     */   }
/*     */   
/*     */   private void PlaceholderTabButton(Button paramButton) {
/* 138 */     paramButton.material(XMaterial.GRAY_STAINED_GLASS_PANE)
/* 139 */       .name();
/*     */   }
/*     */   
/* 142 */   private static final Phrase SERVER_TITLE = Phrase.create("permissionView.server.title", "Server");
/* 143 */   private static final Phrase SERVER_ALL_SERVERS_ACTION = Phrase.create("permissionView.server.allServersAction", "Click to **allow** permission on all Servers", Colors.GRAY, new Color[] { Colors.GREEN });
/* 144 */   private static final Phrase SERVER_SPECIFIC_SERVER_ACTION = Phrase.create("permissionView.server.specificServerAction", "Click to **restrict** permission to a certain Server", Colors.GRAY, new Color[] { Colors.RED });
/* 145 */   private static final Phrase SERVER_ALL_SERVERS_DESC = Phrase.create("permissionView.server.allServersDesc", "Permission is available to all Servers", Colors.GRAY, new Color[0]);
/* 146 */   private static final Phrase SERVER_SPECIFIC_SERVERS_DESC = Phrase.create("permissionView.server.specificServersDesc", "Permission only available on Server **%server%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void ServerButton(Button paramButton, final Permission permission) {
/* 149 */     paramButton.material(XMaterial.ENDER_CHEST)
/* 150 */       .name(Animation.wave(SERVER_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/* 151 */           })).lore(new String[] {
/* 152 */           (permission.getServer().isPresent() ? SERVER_ALL_SERVERS_ACTION : SERVER_SPECIFIC_SERVER_ACTION).get(), "", 
/*     */           
/* 154 */           permission.getServer().isPresent() ? SERVER_SPECIFIC_SERVERS_DESC.get().replace("%server%", permission.getServer().get()) : SERVER_ALL_SERVERS_DESC.get()
/*     */         });
/*     */     
/* 157 */     paramButton.action(paramActionType -> {
/*     */           if (paramPermission.getServer().isPresent()) {
/*     */             paramPermission.setServer(null);
/*     */           } else {
/*     */             new ServerPickerView(this.p, this.plugin)
/*     */               {
/*     */                 public void onSelect(NServer param1NServer) {
/* 164 */                   permission.setServer(param1NServer.getName());
/* 165 */                   onBack();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public String getTitle() {
/* 170 */                   return permission.getName() + " > Server";
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void onBack() {
/* 175 */                   PermissionView.this.reopen();
/*     */                 }
/*     */               };
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/* 182 */   private static final Phrase WORLD_TITLE = Phrase.create("permissionView.world.title", "World");
/* 183 */   private static final Phrase WORLD_ALL_WORLDS_ACTION = Phrase.create("permissionView.world.allWorldsAction", "Click to **allow** permission on all Worlds", Colors.GRAY, new Color[] { Colors.GREEN });
/* 184 */   private static final Phrase WORLD_SPECIFIC_WORLD_ACTION = Phrase.create("permissionView.world.specificWorldAction", "Click to **restrict** permission to a certain World", Colors.GRAY, new Color[] { Colors.RED });
/* 185 */   private static final Phrase WORLD_ALL_WORLDS_DESC = Phrase.create("permissionView.world.allWorldsDesc", "Permission is available to all Worlds", Colors.GRAY, new Color[0]);
/* 186 */   private static final Phrase WORLD_SPECIFIC_WORLD_DESC = Phrase.create("permissionView.world.specificWorldDesc", "Permission only available on World **%world%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void WorldButton(Button paramButton, final Permission permission) {
/* 189 */     paramButton.material(XMaterial.CHEST)
/* 190 */       .name(Animation.wave(WORLD_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/* 191 */           })).lore(new String[] {
/* 192 */           (permission.getWorld().isPresent() ? WORLD_ALL_WORLDS_ACTION : WORLD_SPECIFIC_WORLD_ACTION).get(), "", 
/*     */           
/* 194 */           permission.getWorld().isPresent() ? WORLD_SPECIFIC_WORLD_DESC.get().replace("%world%", permission.getWorld().get()) : WORLD_ALL_WORLDS_DESC.get()
/*     */         });
/*     */     
/* 197 */     paramButton.action(paramActionType -> {
/*     */           if (paramPermission.getWorld().isPresent()) {
/*     */             paramPermission.setWorld(null);
/*     */           } else {
/*     */             new WorldPickerView(this.p, (SpigotTechPlugin)this.plugin)
/*     */               {
/*     */                 public void onSelect(World param1World) {
/* 204 */                   permission.setWorld(param1World.getName());
/* 205 */                   onBack();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public String getTitle() {
/* 210 */                   return permission.getName() + " > World";
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void onBack() {
/* 215 */                   PermissionView.this.reopen();
/*     */                 }
/*     */               };
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/* 222 */   private static final Phrase POLARITY_TITLE = Phrase.create("permissionView.polarity.title", "Polarity");
/* 223 */   private static final Phrase POLARITY_NEGATIVE_ACTION = Phrase.create("permissionView.polarity.negativeAction", "Click to make this Permission **negative**", Colors.GRAY, new Color[] { Colors.RED });
/* 224 */   private static final Phrase POLARITY_POSITIVE_ACTION = Phrase.create("permissionView.polarity.positiveAction", "Click to make this a **regular** Permission", Colors.GRAY, new Color[] { Colors.GREEN });
/* 225 */   private static final Phrase POLARITY_NEGATIVE_ATTRIBUTE = Phrase.create("permissionView.polarity.negativeAttribute", "This Permission is currently **negated**", Colors.GRAY, new Color[] { Colors.RED });
/* 226 */   private static final Phrase POLARITY_POSITIVE_ATTRIBUTE = Phrase.create("permissionView.polarity.positiveAttribute", "This is currently a regular, **positive** permission", Colors.GRAY, new Color[] { Colors.GREEN });
/*     */   
/*     */   private void PolarityButton(Button paramButton, Permission paramPermission) {
/* 229 */     paramButton.material(XMaterial.REPEATER)
/* 230 */       .name(Animation.wave(POLARITY_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/* 231 */           })).lore(new String[] {
/* 232 */           (paramPermission.isPositive() ? POLARITY_NEGATIVE_ACTION : POLARITY_POSITIVE_ACTION).get(), "", (
/*     */           
/* 234 */           paramPermission.isPositive() ? POLARITY_POSITIVE_ATTRIBUTE : POLARITY_NEGATIVE_ATTRIBUTE).get()
/*     */         });
/*     */     
/* 237 */     paramButton.action(paramActionType -> paramPermission.setPositive(!paramPermission.isPositive()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 242 */   private static final Phrase DELETE_TITLE = Phrase.create("permissionView.delete.title", "Delete");
/* 243 */   private static final Phrase DELETE_ACTION = Phrase.create("permissionView.delete.action", "Click to delete this copy", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void DeleteButton(Button paramButton, Permission paramPermission) {
/* 246 */     paramButton.material(Material.REDSTONE_BLOCK)
/* 247 */       .name(Animation.wave(DELETE_TITLE.get(), new Color[] { Colors.Red, Colors.WHITE
/* 248 */           })).lore(new String[] {
/* 249 */           DELETE_ACTION.get()
/*     */         });
/*     */     
/* 252 */     paramButton.action(paramActionType -> {
/*     */           paramPermission.remove();
/*     */           if (this.permissionCopies.size() == 1) {
/*     */             onBack();
/*     */             return;
/*     */           } 
/*     */           reloadPermissionCopies();
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 264 */   private static final Phrase INHERITED_TITLE = Phrase.create("permissionView.inherited.title", "Permission Inherited");
/* 265 */   private static final Phrase INHERITED_ACTION = Phrase.create("permissionView.inherited.action", "Click to jump to Group", Colors.GRAY, new Color[0]);
/* 266 */   private static final Phrase INHERITED_DESC = Phrase.create("permissionView.inherited.desc", "This permission is inherited from **%group%** and can be only edited when jumping to that group", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void InheritedButton(Button paramButton, Permission paramPermission) {
/* 269 */     paramButton.material(XMaterial.STICKY_PISTON)
/* 270 */       .name(Animation.wave(INHERITED_TITLE.get(), new Color[] { Colors.GOLD, Colors.WHITE
/* 271 */           })).lore(new String[] {
/* 272 */           INHERITED_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */     
/* 276 */     for (String str : INHERITED_DESC.split(60)) {
/* 277 */       paramButton.item().appendLore(new String[] { str.replace("%group%", paramPermission.getHolder().getName()) });
/*     */     } 
/*     */     
/* 280 */     paramButton.action(paramActionType -> {
/*     */           Optional optional = paramPermission.getHolder().get();
/*     */           optional.ifPresent(());
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getServer(Permission paramPermission) {
/* 293 */     if (paramPermission.getServer().isPresent()) {
/* 294 */       if (((String)paramPermission.getServer().get()).equals("BungeeCord")) return Colors.RED + "BungeeCord"; 
/* 295 */       if (((String)paramPermission.getServer().get()).equals(this.plugin.getThisServer().map(NServer::getName).orElse(null))) return "This Server";
/*     */       
/* 297 */       return paramPermission.getServer().get();
/*     */     } 
/*     */     
/* 300 */     return "All Servers";
/*     */   }
/*     */   
/*     */   private String getWorld(Permission paramPermission) {
/* 304 */     return paramPermission.getWorld().orElse("All Worlds");
/*     */   }
/*     */   
/*     */   public abstract void onBack();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PermissionView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */