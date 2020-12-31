/*     */ package me.TechsCode.UltraPermissions.bungee;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.StorageController;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissionsAPI;
/*     */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.networking.BungeeNetworkManager;
/*     */ import me.TechsCode.UltraPermissions.base.storage.implementations.MySQL;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.LookupCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.LookupOutcome;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.PermissionLookup;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.DefinedPermissionCheck;
/*     */ import me.TechsCode.UltraPermissions.storage.GroupCreator;
/*     */ import me.TechsCode.UltraPermissions.storage.GroupStorage;
/*     */ import me.TechsCode.UltraPermissions.storage.PermissionCreator;
/*     */ import me.TechsCode.UltraPermissions.storage.PermissionStorage;
/*     */ import me.TechsCode.UltraPermissions.storage.UserStorage;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.UserList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Holder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import net.md_5.bungee.api.ProxyServer;
/*     */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*     */ import net.md_5.bungee.api.event.PermissionCheckEvent;
/*     */ import net.md_5.bungee.api.plugin.Listener;
/*     */ import net.md_5.bungee.api.plugin.Plugin;
/*     */ import net.md_5.bungee.event.EventHandler;
/*     */ 
/*     */ public class UltraPermissionsBungee extends BungeeTechPlugin implements Listener, UltraPermissionsAPI, StorageController {
/*     */   private static UltraPermissionsAPI api;
/*     */   private boolean loaded;
/*     */   private HashMap<ProxiedPlayer, PermissionList> permissionsCache;
/*     */   
/*     */   public UltraPermissionsBungee(Plugin paramPlugin) {
/*  42 */     super(paramPlugin);
/*     */   }
/*     */   private GroupStorage groupStorage; private PermissionStorage permissionStorage; private UserStorage userStorage;
/*     */   
/*     */   protected void onEnable() {
/*  47 */     api = this;
/*  48 */     this.loaded = false;
/*     */     
/*  50 */     new BungeeNetworkManager(this);
/*     */     
/*  52 */     if (getMySQLManager().isEnabled()) {
/*  53 */       onLoad();
/*     */     } else {
/*  55 */       log("Waiting for MySQL Credentials...");
/*     */     } 
/*     */     
/*  58 */     getScheduler().runTaskTimer(() -> { if (!this.loaded && getMySQLManager().isEnabled()) onLoad();  }20L, 20L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onLoad() {
/*  66 */     this.loaded = true;
/*  67 */     this.permissionsCache = new HashMap<>();
/*     */     
/*  69 */     this.groupStorage = new GroupStorage((TechPlugin)this, MySQL.class);
/*  70 */     this.permissionStorage = new PermissionStorage((TechPlugin)this, MySQL.class);
/*  71 */     this.userStorage = new UserStorage((TechPlugin)this, MySQL.class);
/*     */     
/*  73 */     ProxyServer.getInstance().getPluginManager().registerListener((Plugin)getBootstrap(), this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDisable() {}
/*     */   
/*     */   @EventHandler
/*     */   public void check(PermissionCheckEvent paramPermissionCheckEvent) {
/*  81 */     if (paramPermissionCheckEvent.getSender() instanceof ProxiedPlayer) {
/*  82 */       final ProxiedPlayer pp = (ProxiedPlayer)paramPermissionCheckEvent.getSender();
/*     */       
/*  84 */       PermissionLookup permissionLookup = new PermissionLookup(paramPermissionCheckEvent.getPermission())
/*     */         {
/*     */           public LookupCheck[] getChecks() {
/*  87 */             return new LookupCheck[] { (LookupCheck)new DefinedPermissionCheck()
/*     */                 {
/*     */                   public List<Permission> getDefinedPermissions()
/*     */                   {
/*  91 */                     PermissionList permissionList = UltraPermissionsBungee.this.getPermissions(pp);
/*     */                     
/*  93 */                     return (permissionList == null) ? new ArrayList<>() : (List<Permission>)permissionList;
/*     */                   }
/*     */                 } };
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 100 */       LookupOutcome lookupOutcome = permissionLookup.perform();
/*     */       
/* 102 */       paramPermissionCheckEvent.setHasPermission(lookupOutcome.getResult());
/*     */     } 
/*     */   }
/*     */   
/*     */   public PermissionList getPermissions(ProxiedPlayer paramProxiedPlayer) {
/* 107 */     if (this.permissionsCache.containsKey(paramProxiedPlayer)) return this.permissionsCache.get(paramProxiedPlayer);
/*     */     
/* 109 */     Optional<User> optional = this.userStorage.getUsers().uuid(paramProxiedPlayer.getUniqueId());
/*     */     
/* 111 */     if (!optional.isPresent()) {
/* 112 */       log("Cannot find the user");
/* 113 */       return null;
/*     */     } 
/*     */     
/* 116 */     PermissionList permissionList = ((User)optional.get()).getPermissions().bungee();
/* 117 */     permissionList.addAll((Collection)((User)optional.get()).getAdditionalPermissions().bungee());
/* 118 */     this.permissionsCache.put(paramProxiedPlayer, permissionList);
/* 119 */     return permissionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAllowingInvalidMySQL() {
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionCreator newPermission(String paramString, Holder paramHolder) {
/* 129 */     return this.permissionStorage.newPermission(paramString, paramHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public GroupCreator newGroup(String paramString) {
/* 134 */     return this.groupStorage.newGroup(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionList getPermissions() {
/* 139 */     return this.permissionStorage.getPermissions();
/*     */   }
/*     */ 
/*     */   
/*     */   public GroupList getGroups() {
/* 144 */     return this.groupStorage.getGroups();
/*     */   }
/*     */ 
/*     */   
/*     */   public UserList getUsers() {
/* 149 */     return this.userStorage.getUsers();
/*     */   }
/*     */   
/*     */   public static UltraPermissionsAPI getAPI() {
/* 153 */     return api;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDataModification() {
/* 158 */     this.permissionsCache.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public GroupStorage getGroupStorage() {
/* 163 */     return this.groupStorage;
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionStorage getPermissionStorage() {
/* 168 */     return this.permissionStorage;
/*     */   }
/*     */ 
/*     */   
/*     */   public UserStorage getUserStorage() {
/* 173 */     return this.userStorage;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/bungee/UltraPermissionsBungee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */