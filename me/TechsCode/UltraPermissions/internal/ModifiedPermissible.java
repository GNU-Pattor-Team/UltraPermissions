/*     */ package me.TechsCode.UltraPermissions.internal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import me.TechsCode.UltraPermissions.CachedPlayerPermissionProvider;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.LookupCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.LookupOutcome;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.PermissionLookup;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.AttachedPermissionCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.BlankCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.DefaultPermissionCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.DefinedPermissionCheck;
/*     */ import me.TechsCode.UltraPermissions.internal.lookup.checks.OperatorLookupCheck;
/*     */ import me.TechsCode.UltraPermissions.permissionlogger.PermissionLogger;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.permissions.Permissible;
/*     */ import org.bukkit.permissions.PermissibleBase;
/*     */ import org.bukkit.permissions.Permission;
/*     */ import org.bukkit.permissions.PermissionAttachment;
/*     */ import org.bukkit.permissions.PermissionAttachmentInfo;
/*     */ import org.bukkit.permissions.ServerOperator;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public class ModifiedPermissible extends PermissibleBase implements Listener {
/*     */   private final Player p;
/*     */   private final UltraPermissions plugin;
/*     */   private final PermissionLogger permissionLogger;
/*     */   
/*     */   public ModifiedPermissible(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionLogger paramPermissionLogger) {
/*  35 */     super((ServerOperator)paramPlayer);
/*     */     
/*  37 */     this.p = paramPlayer;
/*  38 */     this.plugin = paramUltraPermissions;
/*  39 */     this.permissionLogger = paramPermissionLogger;
/*     */     
/*  41 */     this.defaultPerms = paramUltraPermissions.isDefaultPermissionsEnabled();
/*     */     
/*  43 */     this.attachments = new ArrayList<>();
/*  44 */     this.permissionProvider = new CachedPlayerPermissionProvider(paramUltraPermissions);
/*     */     
/*  46 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*     */   }
/*     */   private final boolean defaultPerms; private final List<PermissionAttachment> attachments; private final CachedPlayerPermissionProvider permissionProvider;
/*     */   public void clearCache() {
/*  50 */     this.permissionProvider.clearCache();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPermissionSet(String paramString) {
/*  55 */     return hasPermission(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPermissionSet(Permission paramPermission) {
/*  60 */     if (isPermissionSet(paramPermission.getName())) {
/*  61 */       return true;
/*     */     }
/*     */     
/*  64 */     if (this.defaultPerms) {
/*  65 */       return paramPermission.getDefault().getValue(isOp());
/*     */     }
/*  67 */     return Permission.DEFAULT_PERMISSION.getValue(isOp());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPermission(Permission paramPermission) {
/*  73 */     return hasPermission(paramPermission.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasPermission(String paramString) {
/*  78 */     if (paramString == null) return false;
/*     */     
/*  80 */     PermissionLookup permissionLookup = new PermissionLookup(paramString)
/*     */       {
/*     */         public LookupCheck[] getChecks() {
/*  83 */           return new LookupCheck[] { (LookupCheck)new OperatorLookupCheck(
/*  84 */                 (OfflinePlayer)ModifiedPermissible.access$000(this.this$0)), 
/*  85 */               ModifiedPermissible.access$100(this.this$0) ? (LookupCheck)new DefaultPermissionCheck((OfflinePlayer)ModifiedPermissible.access$000(this.this$0)) : (LookupCheck)new BlankCheck(), (LookupCheck)new AttachedPermissionCheck()
/*     */               {
/*     */                 public List<PermissionAttachment> getAttachments()
/*     */                 {
/*  89 */                   return ModifiedPermissible.this.attachments;
/*     */                 }
/*     */               }, (LookupCheck)new DefinedPermissionCheck()
/*     */               {
/*     */                 public List<Permission> getDefinedPermissions()
/*     */                 {
/*  95 */                   return (List<Permission>)ModifiedPermissible.this.permissionProvider.retrieve(ModifiedPermissible.this.p.getUniqueId(), ModifiedPermissible.this.p.getWorld().getName());
/*     */                 }
/*     */               } };
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 102 */     LookupOutcome lookupOutcome = permissionLookup.perform();
/*     */     
/* 104 */     this.permissionLogger.log(this.p, paramString, lookupOutcome.getResult(), lookupOutcome.getSource());
/*     */     
/* 106 */     return lookupOutcome.getResult();
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionAttachment addAttachment(Plugin paramPlugin) {
/* 111 */     PermissionAttachment permissionAttachment = new PermissionAttachment(paramPlugin, (Permissible)this);
/* 112 */     this.attachments.add(permissionAttachment);
/* 113 */     return permissionAttachment;
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionAttachment addAttachment(Plugin paramPlugin, String paramString, boolean paramBoolean) {
/* 118 */     PermissionAttachment permissionAttachment = addAttachment(paramPlugin);
/* 119 */     permissionAttachment.setPermission(paramString, paramBoolean);
/* 120 */     return permissionAttachment;
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionAttachment addAttachment(Plugin paramPlugin, int paramInt) {
/* 125 */     PermissionAttachment permissionAttachment = addAttachment(paramPlugin);
/*     */     
/* 127 */     Bukkit.getScheduler().runTaskLater(paramPlugin, permissionAttachment::remove, paramInt);
/*     */     
/* 129 */     return permissionAttachment;
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionAttachment addAttachment(Plugin paramPlugin, String paramString, boolean paramBoolean, int paramInt) {
/* 134 */     PermissionAttachment permissionAttachment = addAttachment(paramPlugin, paramInt);
/* 135 */     permissionAttachment.setPermission(paramString, paramBoolean);
/* 136 */     return permissionAttachment;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAttachment(PermissionAttachment paramPermissionAttachment) {
/* 141 */     this.attachments.remove(paramPermissionAttachment);
/*     */   }
/*     */ 
/*     */   
/*     */   public void recalculatePermissions() {}
/*     */ 
/*     */   
/*     */   public synchronized void clearPermissions() {
/* 149 */     this.attachments.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<PermissionAttachmentInfo> getEffectivePermissions() {
/* 154 */     PermissionList permissionList = this.permissionProvider.retrieve(this.p.getUniqueId(), this.p.getWorld().getName());
/*     */     
/* 156 */     return (Set<PermissionAttachmentInfo>)permissionList.stream().map(paramPermission -> new PermissionAttachmentInfo((Permissible)this, paramPermission.getName(), null, paramPermission.isPositive())).collect(Collectors.toSet());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/ModifiedPermissible.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */