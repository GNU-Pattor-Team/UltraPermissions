/*     */ package me.TechsCode.UltraPermissions;
/*     */ import java.util.ArrayList;
/*     */ import java.util.UUID;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*     */ import me.TechsCode.UltraPermissions.base.networking.SpigotNetworkManager;
/*     */ import me.TechsCode.UltraPermissions.base.registry.RegistrationChoice;
/*     */ import me.TechsCode.UltraPermissions.base.registry.SwitchableBiRegistry;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*     */ import me.TechsCode.UltraPermissions.base.storage.implementations.LocalFile;
/*     */ import me.TechsCode.UltraPermissions.base.storage.implementations.MySQL;
/*     */ import me.TechsCode.UltraPermissions.commands.UPCCommand;
/*     */ import me.TechsCode.UltraPermissions.hooks.PluginHookManager;
/*     */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.hooks.placeholders.RankPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.hooks.placeholders.RankTimerPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.hooks.placeholders.SuffixPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.internal.ModifiedPermissible;
/*     */ import me.TechsCode.UltraPermissions.permissionDatabase.PermissionDatabase;
/*     */ import me.TechsCode.UltraPermissions.permissionlogger.LoggedPermission;
/*     */ import me.TechsCode.UltraPermissions.permissionlogger.PermissionLogger;
/*     */ import me.TechsCode.UltraPermissions.storage.GroupCreator;
/*     */ import me.TechsCode.UltraPermissions.storage.GroupStorage;
/*     */ import me.TechsCode.UltraPermissions.storage.PermissionCreator;
/*     */ import me.TechsCode.UltraPermissions.storage.PermissionStorage;
/*     */ import me.TechsCode.UltraPermissions.storage.SpigotPermissionStorage;
/*     */ import me.TechsCode.UltraPermissions.storage.UserStorage;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.UserList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Holder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import me.TechsCode.UltraPermissions.visual.VisualManager;
/*     */ import me.TechsCode.UltraPermissions.visual.VisualRegistry;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class UltraPermissions extends SpigotTechPlugin implements UltraPermissionsAPI, StorageController {
/*  40 */   public static final UpermsPlaceholder[] placeholders = new UpermsPlaceholder[] { (UpermsPlaceholder)new PrefixColorPlaceholder(), (UpermsPlaceholder)new PrefixesPlaceholder(), (UpermsPlaceholder)new PrefixPlaceholder(), (UpermsPlaceholder)new SecondaryPrefixPlaceholder(), (UpermsPlaceholder)new SecondarySuffixPlaceholder(), (UpermsPlaceholder)new SuffixesPlaceholder(), (UpermsPlaceholder)new SuffixPlaceholder(), (UpermsPlaceholder)new RankPlaceholder(), (UpermsPlaceholder)new RankTimerPlaceholder() };
/*     */ 
/*     */   
/*     */   private static UltraPermissionsAPI api;
/*     */   
/*     */   private PublicRegistry publicRegistry;
/*     */   
/*     */   private PrivateRegistry privateRegistry;
/*     */   
/*     */   private SwitchableBiRegistry<VisualRegistry> visualRegistry;
/*     */   
/*     */   private SpigotNetworkManager networkManager;
/*     */   
/*     */   private GroupStorage groupStorage;
/*     */   
/*     */   private PermissionStorage permissionStorage;
/*     */   
/*     */   private UserStorage userStorage;
/*     */   
/*     */   private PermissionDatabase permissionDatabase;
/*     */   
/*     */   private PermissionLogger permissionLogger;
/*     */   
/*     */   private PluginHookManager pluginHookManager;
/*     */   
/*     */   private PluginEvents pluginEvents;
/*     */ 
/*     */   
/*     */   public UltraPermissions(JavaPlugin paramJavaPlugin) {
/*  69 */     super(paramJavaPlugin);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  74 */     api = this;
/*     */     
/*  76 */     this.publicRegistry = (PublicRegistry)getRegistry().register(PublicRegistry.class, RegistrationChoice.GLOBAL_IF_AVAILABLE);
/*  77 */     this.privateRegistry = (PrivateRegistry)getRegistry().register(PrivateRegistry.class, RegistrationChoice.LOCAL);
/*  78 */     this.visualRegistry = new SwitchableBiRegistry(getRegistry().register(VisualRegistry.class));
/*     */     
/*  80 */     this.networkManager = new SpigotNetworkManager(this);
/*     */ 
/*     */     
/*  83 */     boolean bool = getMySQLManager().isEnabled();
/*  84 */     this.groupStorage = (GroupStorage)new SpigotGroupStorage((TechPlugin)this, bool ? MySQL.class : LocalFile.class);
/*  85 */     this.permissionStorage = (PermissionStorage)new SpigotPermissionStorage((TechPlugin)this, bool ? MySQL.class : LocalFile.class);
/*  86 */     this.userStorage = (UserStorage)new SpigotUserStorage((TechPlugin)this, bool ? MySQL.class : LocalFile.class);
/*     */     
/*  88 */     this.permissionDatabase = new PermissionDatabase(this);
/*  89 */     this.permissionLogger = new PermissionLogger(this);
/*  90 */     this.pluginHookManager = new PluginHookManager(this);
/*     */     
/*  92 */     new VisualManager(this, (VisualRegistry)this.visualRegistry.get());
/*  93 */     new HeadPreloader(this);
/*  94 */     new MainCommand(this);
/*  95 */     new UPCCommand(this);
/*     */     
/*  97 */     this.pluginEvents = new PluginEvents(this, this.permissionLogger);
/*     */     
/*  99 */     getScheduler().runTaskTimer(() -> { getUsers().forEach(User::clean); getGroups().forEach(Group::clean); }20L, 6000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void issueManualSynchronization() {
/* 106 */     getSyncingAgent().notifyNewDataChanges((Storage)this.groupStorage, "*");
/* 107 */     getSyncingAgent().notifyNewDataChanges((Storage)this.permissionStorage, "*");
/* 108 */     getSyncingAgent().notifyNewDataChanges((Storage)this.userStorage, "*");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDataModification() {
/* 113 */     if (this.pluginEvents != null) {
/* 114 */       ArrayList<ModifiedPermissible> arrayList = new ArrayList<>(this.pluginEvents.getPermissibles());
/* 115 */       arrayList.forEach(ModifiedPermissible::clearCache);
/*     */     } 
/*     */     
/* 118 */     if (this.pluginHookManager != null) this.pluginHookManager.clearCaches(); 
/*     */   }
/*     */   
/*     */   public SwitchableBiRegistry<VisualRegistry> getVisualRegistry() {
/* 122 */     return this.visualRegistry;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDisable() {}
/*     */   
/*     */   public static UltraPermissionsAPI getAPI() {
/* 129 */     return api;
/*     */   }
/*     */   
/*     */   public DefaultGroupAssignOption getDefaultGroupAssignOption() {
/* 133 */     return this.publicRegistry.getDefaultAssignOption();
/*     */   }
/*     */   
/*     */   public void setDefaultGroupAssignOption(DefaultGroupAssignOption paramDefaultGroupAssignOption) {
/* 137 */     this.publicRegistry.setDefaultGroupAssignOption(paramDefaultGroupAssignOption);
/*     */   }
/*     */   
/*     */   public void setDefaultPermissions(boolean paramBoolean) {
/* 141 */     this.publicRegistry.setDefaultPermissions(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isDefaultPermissionsEnabled() {
/* 145 */     return this.publicRegistry.isDefaultPermissions();
/*     */   }
/*     */   
/*     */   public GroupCreator newGroup(String paramString) {
/* 149 */     return this.groupStorage.newGroup(paramString);
/*     */   }
/*     */   
/*     */   public PermissionCreator newPermission(String paramString, Holder paramHolder) {
/* 153 */     return this.permissionStorage.newPermission(paramString, paramHolder);
/*     */   }
/*     */   
/*     */   public User registerUser(UUID paramUUID, String paramString, boolean paramBoolean) {
/* 157 */     return this.userStorage.registerUser(paramUUID, paramString, paramBoolean);
/*     */   }
/*     */   
/*     */   public GroupList getGroups() {
/* 161 */     return this.groupStorage.getGroups();
/*     */   }
/*     */   
/*     */   public UserList getUsers() {
/* 165 */     return this.userStorage.getUsers();
/*     */   }
/*     */   
/*     */   public PermissionList getPermissions() {
/* 169 */     return this.permissionStorage.getPermissions();
/*     */   }
/*     */   
/*     */   public Optional<NServer> getThisServer() {
/* 173 */     return this.networkManager.getThisServer();
/*     */   }
/*     */   
/*     */   public PermissionDatabase getPermissionDatabase() {
/* 177 */     return this.permissionDatabase;
/*     */   }
/*     */   
/*     */   public LoggedPermission[] getLoggedPermissionChecks() {
/* 181 */     return this.permissionLogger.getLoggedPermissions();
/*     */   }
/*     */   
/*     */   public String replacePlaceholders(Player paramPlayer, String paramString) {
/* 185 */     return this.pluginHookManager.replacePlaceholders(paramPlayer, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public GroupStorage getGroupStorage() {
/* 190 */     return this.groupStorage;
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionStorage getPermissionStorage() {
/* 195 */     return this.permissionStorage;
/*     */   }
/*     */ 
/*     */   
/*     */   public UserStorage getUserStorage() {
/* 200 */     return this.userStorage;
/*     */   }
/*     */   
/*     */   public boolean isConnectedToNetwork() {
/* 204 */     return this.networkManager.getData().isPresent();
/*     */   }
/*     */   
/*     */   public SpigotNetworkManager getNetworkManager() {
/* 208 */     return this.networkManager;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/UltraPermissions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */