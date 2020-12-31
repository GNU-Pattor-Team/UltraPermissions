/*     */ package me.TechsCode.UltraPermissions.migration;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import net.luckperms.api.LuckPerms;
/*     */ import net.luckperms.api.cacheddata.CachedMetaData;
/*     */ import net.luckperms.api.model.group.Group;
/*     */ import net.luckperms.api.model.user.User;
/*     */ import net.luckperms.api.node.NodeType;
/*     */ import net.luckperms.api.node.types.PermissionNode;
/*     */ import net.luckperms.api.query.QueryOptions;
/*     */ 
/*     */ public class LuckPermsMigration extends MigrationAssistant {
/*     */   public void migrate(UltraPermissions paramUltraPermissions, Runnable paramRunnable) {
/*  23 */     LuckPerms luckPerms = LuckPermsProvider.get();
/*     */     
/*  25 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  33 */     List list = (List)luckPerms.getGroupManager().getLoadedGroups().stream().sorted((paramGroup1, paramGroup2) -> (!paramGroup1.getWeight().isPresent() || !paramGroup2.getWeight().isPresent()) ? 0 : (paramGroup1.getWeight().getAsInt() - paramGroup2.getWeight().getAsInt())).collect(Collectors.toList());
/*     */     
/*  35 */     byte b = 1;
/*  36 */     for (Group group : list) {
/*  37 */       CachedMetaData cachedMetaData = group.getCachedData().getMetaData();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  44 */       Group group1 = paramUltraPermissions.newGroup(group.getName()).setDefault(group.getName().equals("default")).setPrefix(cachedMetaData.getPrefix()).setSuffix(cachedMetaData.getSuffix()).setPriority(b).create();
/*     */       
/*  46 */       addNodes((PermissionHolder)group1, group.getNodes(NodeType.PERMISSION));
/*     */       
/*  48 */       hashMap.put(group, group1);
/*     */       
/*  50 */       b++;
/*     */     } 
/*     */ 
/*     */     
/*  54 */     hashMap.forEach((paramGroup, paramGroup1) -> {
/*     */           for (Group group : paramGroup.getInheritedGroups(QueryOptions.nonContextual())) {
/*     */             paramGroup1.addInheritance((Group)paramHashMap.get(group));
/*     */           }
/*     */         });
/*     */     
/*  60 */     AtomicInteger atomicInteger = new AtomicInteger();
/*     */ 
/*     */     
/*     */     try {
/*  64 */       Set set = luckPerms.getUserManager().getUniqueUsers().get();
/*     */       
/*  66 */       set.forEach(paramUUID -> paramLuckPerms.getUserManager().loadUser(paramUUID).whenComplete(()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  82 */     catch (InterruptedException|java.util.concurrent.ExecutionException interruptedException) {
/*  83 */       interruptedException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addNodes(PermissionHolder paramPermissionHolder, Collection<PermissionNode> paramCollection) {
/*  88 */     paramCollection.forEach(paramPermissionNode -> {
/*     */           Optional<String> optional1 = paramPermissionNode.getContexts().getAnyValue("server");
/*     */           Optional<String> optional2 = paramPermissionNode.getContexts().getAnyValue("world");
/*     */           paramPermissionHolder.newPermission(paramPermissionNode.getPermission()).setServer(optional1.orElse(null)).setWorld(optional2.orElse(null)).setPositive(!paramPermissionNode.isNegated()).setExpiration((paramPermissionNode.getExpiry() != null) ? paramPermissionNode.getExpiry().toEpochMilli() : 0L).create();
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPluginName() {
/* 103 */     return "Luck Perms";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/migration/LuckPermsMigration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */