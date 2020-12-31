/*     */ package me.TechsCode.UltraPermissions.migration;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import org.bukkit.Bukkit;
/*     */ import ru.tehkode.permissions.PermissionEntity;
/*     */ import ru.tehkode.permissions.PermissionGroup;
/*     */ import ru.tehkode.permissions.PermissionManager;
/*     */ import ru.tehkode.permissions.PermissionUser;
/*     */ import ru.tehkode.permissions.PermissionsData;
/*     */ import ru.tehkode.permissions.bukkit.PermissionsEx;
/*     */ 
/*     */ public class PermissionsExMigration
/*     */   extends MigrationAssistant {
/*     */   static {
/*     */     try {
/*  24 */       GET_DATA_METHOD = PermissionEntity.class.getDeclaredMethod("getData", new Class[0]);
/*  25 */       GET_DATA_METHOD.setAccessible(true);
/*  26 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  27 */       throw new ExceptionInInitializerError(noSuchMethodException);
/*     */     } 
/*     */   }
/*     */   private static final Method GET_DATA_METHOD;
/*     */   
/*     */   public String getPluginName() {
/*  33 */     return "Permissions Ex";
/*     */   }
/*     */ 
/*     */   
/*     */   protected void migrate(UltraPermissions paramUltraPermissions, Runnable paramRunnable) {
/*  38 */     PermissionManager permissionManager = PermissionsEx.getPermissionManager();
/*     */     
/*  40 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  42 */     permissionManager.getGroupList().forEach(paramPermissionGroup -> {
/*  43 */           Group group = paramUltraPermissions.newGroup(paramPermissionGroup.getName()).setPrefix(paramPermissionGroup.getOwnPrefix()).setSuffix(paramPermissionGroup.getOwnSuffix()).setDefault((paramPermissionGroup.isDefault("world") || paramPermissionGroup.getName().equals("default"))).setPriority(paramPermissionGroup.getRank() + 1).create();
/*     */ 
/*     */ 
/*     */           
/*     */           paramUltraPermissions.log("Created Group " + group.getName());
/*     */ 
/*     */           
/*     */           addPermissions(paramUltraPermissions, (PermissionHolder)group, (PermissionEntity)paramPermissionGroup);
/*     */ 
/*     */           
/*     */           paramHashMap.put(paramPermissionGroup.getName(), group);
/*     */         });
/*     */ 
/*     */     
/*  57 */     hashMap.forEach((paramString, paramGroup) -> {
/*     */           PermissionGroup permissionGroup = paramPermissionManager.getGroup(paramString);
/*     */           
/*     */           for (PermissionGroup permissionGroup1 : permissionGroup.getParents()) {
/*     */             if (paramHashMap.containsKey(permissionGroup1.getName())) {
/*     */               paramGroup.addInheritance((Group)paramHashMap.get(permissionGroup1.getName()));
/*     */               
/*     */               paramUltraPermissions.log("Added Inherited Group " + permissionGroup1.getName() + " to " + paramGroup.getName());
/*     */             } 
/*     */           } 
/*     */         });
/*     */     
/*  69 */     for (PermissionUser permissionUser : permissionManager.getUsers()) {
/*  70 */       UUID uUID = Bukkit.getOfflinePlayer(permissionUser.getName()).getUniqueId();
/*  71 */       User user = paramUltraPermissions.registerUser(uUID, permissionUser.getName(), false);
/*     */       
/*  73 */       for (PermissionGroup permissionGroup : permissionUser.getGroups()) {
/*  74 */         if (hashMap.containsKey(permissionGroup.getName())) {
/*  75 */           user.addGroup((Group)hashMap.get(permissionGroup.getName()));
/*     */         }
/*     */       } 
/*     */       
/*  79 */       user.setPrefix(permissionUser.getOwnPrefix());
/*  80 */       user.setSuffix(permissionUser.getOwnSuffix());
/*     */       
/*  82 */       paramUltraPermissions.log("Added User " + user.getName());
/*     */       
/*  84 */       addPermissions(paramUltraPermissions, (PermissionHolder)user, (PermissionEntity)permissionUser);
/*     */     } 
/*     */     
/*  87 */     paramRunnable.run();
/*     */   }
/*     */   
/*     */   private void addPermissions(UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder, PermissionEntity paramPermissionEntity) {
/*  91 */     for (Map.Entry<String, List<String>> entry : getPermanentPermissions(paramPermissionEntity).entrySet()) {
/*  92 */       String str = null;
/*     */       
/*  94 */       if (entry.getKey() != null && !((String)entry.getKey()).isEmpty()) str = (String)entry.getKey();
/*     */       
/*  96 */       for (String str1 : entry.getValue()) {
/*  97 */         if (str1.isEmpty())
/*  98 */           continue;  paramPermissionHolder.newPermission(str1).setWorld(str).create();
/*     */         
/* 100 */         paramUltraPermissions.log("Added Permission " + str1 + " to " + paramPermissionHolder.getName());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Map<String, List<String>> getPermanentPermissions(PermissionEntity paramPermissionEntity) {
/*     */     try {
/* 107 */       PermissionsData permissionsData = (PermissionsData)GET_DATA_METHOD.invoke(paramPermissionEntity, new Object[0]);
/* 108 */       return permissionsData.getPermissionsMap();
/* 109 */     } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/* 110 */       throw new RuntimeException(illegalAccessException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/migration/PermissionsExMigration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */