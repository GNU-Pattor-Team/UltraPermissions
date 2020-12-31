/*     */ package me.TechsCode.UltraPermissions;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateEvent;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateTime;
/*     */ import me.TechsCode.UltraPermissions.internal.ModifiedPermissible;
/*     */ import me.TechsCode.UltraPermissions.internal.PermissibleInjector;
/*     */ import me.TechsCode.UltraPermissions.permissionlogger.PermissionLogger;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.UserList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.UserRankup;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerLoginEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.permissions.PermissibleBase;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public class PluginEvents
/*     */   implements Listener {
/*     */   private final UltraPermissions plugin;
/*     */   private final PermissionLogger permissionLogger;
/*     */   private HashMap<Player, ModifiedPermissible> permissibleHashMap;
/*     */   
/*     */   public PluginEvents(UltraPermissions paramUltraPermissions, PermissionLogger paramPermissionLogger) {
/*  35 */     this.plugin = paramUltraPermissions;
/*  36 */     this.permissionLogger = paramPermissionLogger;
/*     */     
/*  38 */     this.permissibleHashMap = new HashMap<>();
/*     */     
/*  40 */     Bukkit.getOnlinePlayers().forEach(this::login);
/*  41 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*     */   }
/*     */   
/*     */   public void login(Player paramPlayer) {
/*  45 */     Optional<User> optional = this.plugin.getUsers().uuid(paramPlayer.getUniqueId());
/*     */     
/*  47 */     if (optional.isPresent()) {
/*  48 */       if (!((User)optional.get()).getName().equals(paramPlayer.getName())) {
/*  49 */         ((User)optional.get()).setPlayerName(paramPlayer.getName());
/*     */       }
/*     */     } else {
/*  52 */       this.plugin.registerUser(paramPlayer.getUniqueId(), paramPlayer.getName(), true);
/*     */     } 
/*     */     
/*     */     try {
/*  56 */       ModifiedPermissible modifiedPermissible = new ModifiedPermissible(paramPlayer, this.plugin, this.permissionLogger);
/*  57 */       this.permissibleHashMap.put(paramPlayer, modifiedPermissible);
/*  58 */       PermissibleInjector.inject(paramPlayer, (PermissibleBase)modifiedPermissible);
/*  59 */     } catch (IllegalAccessException illegalAccessException) {
/*  60 */       illegalAccessException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Collection<ModifiedPermissible> getPermissibles() {
/*  65 */     return this.permissibleHashMap.values();
/*     */   }
/*     */   
/*     */   @EventHandler(priority = EventPriority.LOW)
/*     */   public void login(PlayerLoginEvent paramPlayerLoginEvent) {
/*  70 */     if (paramPlayerLoginEvent.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST)
/*     */       return; 
/*  72 */     login(paramPlayerLoginEvent.getPlayer());
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quit(PlayerQuitEvent paramPlayerQuitEvent) {
/*  77 */     this.permissibleHashMap.remove(paramPlayerQuitEvent.getPlayer());
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void updateData(UpdateEvent paramUpdateEvent) {
/*  82 */     if (paramUpdateEvent.getUpdateTime() != UpdateTime.SEC)
/*     */       return; 
/*  84 */     this.plugin.getScheduler().runAsync(() -> {
/*     */           GroupList groupList1 = this.plugin.getGroups();
/*     */           
/*     */           UserList userList = this.plugin.getUsers();
/*     */           
/*     */           PermissionList permissionList = this.plugin.getPermissions();
/*     */           
/*     */           GroupList groupList2 = groupList1.defaults(true);
/*     */           
/*     */           for (User user : userList) {
/*     */             DefaultGroupAssignOption defaultGroupAssignOption = this.plugin.getDefaultGroupAssignOption();
/*     */             
/*  96 */             boolean bool1 = (user.getGroups().isEmpty() && defaultGroupAssignOption == DefaultGroupAssignOption.NO_GROUP) ? true : false;
/*     */             boolean bool2 = (defaultGroupAssignOption == DefaultGroupAssignOption.ALWAYS_ASSIGN) ? true : false;
/*     */             if (bool1 || bool2)
/*     */               for (Group group : groupList2) {
/*     */                 if (!user.getGroups().contains(group.toStored()))
/*     */                   user.addGroup(group); 
/*     */               }  
/*     */             for (UserRankup userRankup : user.getRankups()) {
/*     */               if (userRankup.isExpired())
/*     */                 userRankup.remove(); 
/*     */             } 
/*     */           } 
/*     */           for (Group group : groupList1) {
/*     */             for (Group group1 : group.getActiveInheritedGroups()) {
/*     */               boolean bool1 = !group.getServer().equals(group1.getServer()) ? true : false;
/*     */               boolean bool2 = !group.getWorld().equals(group1.getWorld()) ? true : false;
/*     */               if (bool1 || bool2)
/*     */                 group.removeInheritance(group1); 
/*     */             } 
/*     */           } 
/*     */           permissionList.expired().forEach(Permission::remove);
/*     */         });
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/PluginEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */