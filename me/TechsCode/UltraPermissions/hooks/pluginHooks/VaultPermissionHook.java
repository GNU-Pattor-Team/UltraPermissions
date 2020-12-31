/*     */ package me.TechsCode.UltraPermissions.hooks.pluginHooks;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.UUID;
/*     */ import me.TechsCode.UltraPermissions.CachedPlayerPermissionProvider;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.LookupCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.PermissionLookup;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.BlankCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.DefaultPermissionCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.DefinedPermissionCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.OperatorLookupCheck;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import net.milkbowl.vault.permission.Permission;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class VaultPermissionHook
/*     */   extends Permission {
/*     */   private final UltraPermissions plugin;
/*     */   private final Optional<NServer> thisServer;
/*     */   private final CachedPlayerPermissionProvider permissionProvider;
/*     */   
/*     */   public VaultPermissionHook(UltraPermissions paramUltraPermissions) {
/*  37 */     this.plugin = paramUltraPermissions;
/*  38 */     this.thisServer = paramUltraPermissions.getThisServer();
/*  39 */     this.permissionProvider = new CachedPlayerPermissionProvider(paramUltraPermissions);
/*     */   }
/*     */   
/*     */   public void clearCache() {
/*  43 */     this.permissionProvider.clearCache();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  48 */     return "UltraPermissions";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSuperPermsCompat() {
/*  58 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerHas(String paramString1, final String playerName, String paramString3) {
/*  63 */     if (paramString1 == null) paramString1 = UUID.randomUUID().toString();
/*     */     
/*  65 */     final String world = paramString1;
/*     */     
/*  67 */     PermissionLookup permissionLookup = new PermissionLookup(paramString3)
/*     */       {
/*     */         public LookupCheck[] getChecks() {
/*  70 */           OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerName);
/*     */           
/*  72 */           return new LookupCheck[] { (offlinePlayer != null) ? (LookupCheck)new OperatorLookupCheck(offlinePlayer) : (LookupCheck)new BlankCheck(), (
/*     */               
/*  74 */               VaultPermissionHook.access$000(this.this$0).isDefaultPermissionsEnabled() && offlinePlayer != null) ? (LookupCheck)new DefaultPermissionCheck(offlinePlayer) : (LookupCheck)new BlankCheck(), (LookupCheck)new DefinedPermissionCheck()
/*     */               {
/*     */                 public List<Permission> getDefinedPermissions()
/*     */                 {
/*  78 */                   Optional<User> optional = VaultPermissionHook.this.user(playerName);
/*  79 */                   return optional.isPresent() ? (List<Permission>)VaultPermissionHook.this.permissionProvider.retrieve(((User)optional.get()).getUuid(), world) : Collections.<Permission>emptyList();
/*     */                 }
/*     */               } };
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  86 */     return permissionLookup.perform().getResult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerHas(String paramString1, OfflinePlayer paramOfflinePlayer, String paramString2) {
/*  91 */     return playerHas(paramString1, paramOfflinePlayer.getName(), paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerHas(Player paramPlayer, String paramString) {
/*  96 */     return paramPlayer.hasPermission(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerAdd(String paramString1, String paramString2, String paramString3) {
/* 101 */     return add(paramString1, (PermissionHolder)user(paramString2).orElse(null), paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerAdd(String paramString1, OfflinePlayer paramOfflinePlayer, String paramString2) {
/* 106 */     return playerAdd(paramString1, paramOfflinePlayer.getName(), paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerAdd(Player paramPlayer, String paramString) {
/* 111 */     return playerAdd(paramPlayer.getWorld().getName(), paramPlayer.getName(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerRemove(String paramString1, String paramString2, String paramString3) {
/* 116 */     return remove(paramString1, (PermissionHolder)user(paramString2).orElse(null), paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerRemove(String paramString1, OfflinePlayer paramOfflinePlayer, String paramString2) {
/* 121 */     return playerRemove(paramString1, paramOfflinePlayer.getName(), paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerRemove(Player paramPlayer, String paramString) {
/* 126 */     return playerRemove(paramPlayer.getWorld().getName(), paramPlayer.getName(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean groupHas(String paramString1, String paramString2, String paramString3) {
/* 131 */     Preconditions.checkArgument((paramString2 != null), "Group Name has to be defined");
/*     */     
/* 133 */     final Optional<Group> group = group(paramString1, paramString2);
/*     */     
/* 135 */     PermissionLookup permissionLookup = new PermissionLookup(paramString3)
/*     */       {
/*     */         public LookupCheck[] getChecks() {
/* 138 */           return new LookupCheck[] {
/* 139 */               this.val$group.isPresent() ? (LookupCheck)new DefinedPermissionCheck()
/*     */               {
/*     */                 public List<Permission> getDefinedPermissions() {
/* 142 */                   PermissionList permissionList = ((Group)group.get()).getPermissions();
/* 143 */                   permissionList.addAll((Collection)((Group)group.get()).getInheritedPermissions());
/* 144 */                   return (List<Permission>)permissionList;
/*     */                 }
/*     */               } : (LookupCheck)new BlankCheck()
/*     */             };
/*     */         }
/*     */       };
/*     */     
/* 151 */     return permissionLookup.getOutcome().getResult();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean groupHas(World paramWorld, String paramString1, String paramString2) {
/* 156 */     return groupHas(paramWorld.getName(), paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean groupAdd(String paramString1, String paramString2, String paramString3) {
/* 161 */     return add(paramString1, (PermissionHolder)group(paramString1, paramString2).orElse(null), paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean groupAdd(World paramWorld, String paramString1, String paramString2) {
/* 166 */     return groupAdd(paramWorld.getName(), paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean groupRemove(String paramString1, String paramString2, String paramString3) {
/* 171 */     return remove(paramString1, (PermissionHolder)group(paramString1, paramString2).orElse(null), paramString3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean groupRemove(World paramWorld, String paramString1, String paramString2) {
/* 176 */     return groupRemove(paramWorld.getName(), paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerInGroup(String paramString1, String paramString2, String paramString3) {
/* 181 */     Optional<User> optional = user(paramString2);
/* 182 */     Optional<Group> optional1 = group(paramString1, paramString3);
/*     */     
/* 184 */     if (!optional.isPresent() || !optional1.isPresent()) {
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     return ((User)optional.get()).getGroups().contains(((Group)optional1.get()).toStored());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerInGroup(World paramWorld, String paramString1, String paramString2) {
/* 193 */     return playerInGroup(paramWorld.getName(), paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerInGroup(String paramString1, OfflinePlayer paramOfflinePlayer, String paramString2) {
/* 198 */     return playerInGroup(paramString1, paramOfflinePlayer.getName(), paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerInGroup(Player paramPlayer, String paramString) {
/* 203 */     return playerInGroup(paramPlayer.getWorld().getName(), paramPlayer.getName(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerAddGroup(String paramString1, String paramString2, String paramString3) {
/* 208 */     Optional<User> optional = user(paramString2);
/* 209 */     Optional<Group> optional1 = group(paramString1, paramString3);
/*     */     
/* 211 */     if (!optional.isPresent() || !optional1.isPresent()) {
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     ((User)optional.get()).addGroup(optional1.get());
/*     */     
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerAddGroup(String paramString1, OfflinePlayer paramOfflinePlayer, String paramString2) {
/* 222 */     return playerAddGroup(paramString1, paramOfflinePlayer.getName(), paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerAddGroup(Player paramPlayer, String paramString) {
/* 227 */     return playerAddGroup(paramPlayer.getWorld().getName(), paramPlayer.getName(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerRemoveGroup(String paramString1, String paramString2, String paramString3) {
/* 232 */     Optional<User> optional = user(paramString2);
/* 233 */     Optional<Group> optional1 = group(paramString1, paramString3);
/*     */     
/* 235 */     if (!optional.isPresent() || !optional1.isPresent()) {
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     if (!((User)optional.get()).getGroups().contains(((Group)optional1.get()).toStored())) {
/* 240 */       return false;
/*     */     }
/*     */     
/* 243 */     ((User)optional.get()).removeGroup(optional1.get());
/*     */     
/* 245 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerRemoveGroup(String paramString1, OfflinePlayer paramOfflinePlayer, String paramString2) {
/* 250 */     return playerRemoveGroup(paramString1, paramOfflinePlayer.getName(), paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean playerRemoveGroup(Player paramPlayer, String paramString) {
/* 255 */     return playerRemoveGroup(paramPlayer.getWorld().getName(), paramPlayer.getName(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getPlayerGroups(String paramString1, String paramString2) {
/* 260 */     Optional<User> optional = user(paramString2);
/*     */     
/* 262 */     return optional.<String[]>map(paramUser -> (String[])paramUser.getActiveGroups().servers(true, new String[] { this.plugin.getThisServer().map(NServer::getName).orElse(null) }).worlds(true, new String[] { (paramString == null || paramString.isEmpty()) ? "world" : paramString
/*     */ 
/*     */ 
/*     */           
/* 266 */           }).stream().map(Group::getName).toArray(())).orElseGet(() -> new String[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getPlayerGroups(String paramString, OfflinePlayer paramOfflinePlayer) {
/* 272 */     return getPlayerGroups(paramString, paramOfflinePlayer.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getPlayerGroups(Player paramPlayer) {
/* 277 */     return getPlayerGroups(paramPlayer.getWorld().getName(), paramPlayer.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPrimaryGroup(String paramString1, String paramString2) {
/* 282 */     String[] arrayOfString = getPlayerGroups(paramString1, paramString2);
/*     */     
/* 284 */     return (arrayOfString.length == 0) ? null : arrayOfString[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPrimaryGroup(String paramString, OfflinePlayer paramOfflinePlayer) {
/* 289 */     return getPrimaryGroup(paramString, paramOfflinePlayer.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPrimaryGroup(Player paramPlayer) {
/* 294 */     return getPrimaryGroup(paramPlayer.getWorld().getName(), paramPlayer.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getGroups() {
/* 299 */     return (String[])this.plugin.getGroups()
/* 300 */       .servers(true, new String[] { this.plugin.getThisServer().map(NServer::getName).orElse(null)
/* 301 */         }).stream()
/* 302 */       .map(Group::getName)
/* 303 */       .toArray(paramInt -> new String[paramInt]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasGroupSupport() {
/* 308 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean has(Player paramPlayer, String paramString) {
/* 313 */     return paramPlayer.hasPermission(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean has(CommandSender paramCommandSender, String paramString) {
/* 318 */     return paramCommandSender.hasPermission(paramString);
/*     */   }
/*     */   
/*     */   public Optional<User> user(String paramString) {
/* 322 */     return this.plugin.getUsers().name(paramString);
/*     */   }
/*     */   
/*     */   public Optional<Group> group(String paramString1, String paramString2) {
/* 326 */     return this.plugin.getGroups()
/* 327 */       .servers(true, new String[] { this.plugin.getThisServer().map(NServer::getName).orElse(null)
/* 328 */         }).worlds(true, new String[] { paramString1
/* 329 */         }).name(paramString2);
/*     */   }
/*     */   
/*     */   public boolean add(String paramString1, PermissionHolder paramPermissionHolder, String paramString2) {
/* 333 */     if (paramPermissionHolder == null) {
/* 334 */       return false;
/*     */     }
/*     */     
/* 337 */     paramPermissionHolder.newPermission(paramString2)
/* 338 */       .setWorld((paramString1 == null || paramString1.isEmpty()) ? "world" : paramString1)
/* 339 */       .setServer(this.thisServer.<String>map(NServer::getName).orElse(null))
/* 340 */       .create();
/*     */     
/* 342 */     return true;
/*     */   }
/*     */   
/*     */   public boolean remove(String paramString1, PermissionHolder paramPermissionHolder, String paramString2) {
/* 346 */     if (paramPermissionHolder == null) {
/* 347 */       return false;
/*     */     }
/*     */     
/* 350 */     paramPermissionHolder.getPermissions()
/* 351 */       .name(paramString2)
/* 352 */       .servers(true, new String[] { this.plugin.getThisServer().map(NServer::getName).orElse(null)
/* 353 */         }).worlds(true, new String[] { (paramString1 == null || paramString1.isEmpty()) ? "world" : paramString1
/* 354 */         }).forEach(Permission::remove);
/*     */     
/* 356 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/pluginHooks/VaultPermissionHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */