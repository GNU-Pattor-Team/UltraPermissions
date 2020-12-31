/*    */ package me.TechsCode.UltraPermissions;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Optional;
/*    */ import java.util.UUID;
/*    */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*    */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*    */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Holder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class CachedPlayerPermissionProvider
/*    */ {
/*    */   private static Optional<NServer> thisServer;
/*    */   
/*    */   public CachedPlayerPermissionProvider(UltraPermissions paramUltraPermissions) {
/* 19 */     thisServer = paramUltraPermissions.getThisServer();
/*    */     
/* 21 */     this.plugin = paramUltraPermissions;
/* 22 */     this.cache = new HashMap<>();
/*    */   }
/*    */   private UltraPermissions plugin; private Map<UUID, CacheEntry> cache;
/*    */   public PermissionList retrieve(UUID paramUUID, String paramString) {
/* 26 */     if ((thisServer == null || !thisServer.isPresent()) && 
/* 27 */       this.plugin.getThisServer().isPresent()) {
/* 28 */       thisServer = this.plugin.getThisServer();
/* 29 */       this.cache.clear();
/*    */     } 
/*    */ 
/*    */     
/* 33 */     if (this.cache.containsKey(paramUUID)) {
/* 34 */       CacheEntry cacheEntry = this.cache.get(paramUUID);
/*    */       
/* 36 */       if (cacheEntry.world.equals(paramString)) return cacheEntry.list;
/*    */     
/*    */     } 
/* 39 */     Optional<User> optional = this.plugin.getUsers().uuid(paramUUID);
/*    */     
/* 41 */     if (!optional.isPresent()) {
/* 42 */       return new PermissionList();
/*    */     }
/*    */     
/* 45 */     String str = thisServer.<String>map(NServer::getName).orElse(null);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     GroupList groupList = ((User)optional.get()).getActiveGroups().servers(true, new String[] { str }).worlds(true, new String[] { paramString }).getWithRecursiveInherits().servers(true, new String[] { str }).worlds(true, new String[] { paramString });
/*    */     
/* 54 */     ArrayList<Holder> arrayList = new ArrayList(groupList.holders());
/* 55 */     arrayList.add(Holder.fromUser(optional.get()));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 60 */     PermissionList permissionList = this.plugin.getPermissions().holder(arrayList).servers(true, new String[] { str }).worlds(true, new String[] { paramString });
/*    */     
/* 62 */     this.cache.put(paramUUID, new CacheEntry(permissionList, paramString));
/* 63 */     return permissionList;
/*    */   }
/*    */   
/*    */   public void clearCache() {
/* 67 */     this.cache = new HashMap<>();
/*    */   }
/*    */   
/*    */   public class CacheEntry
/*    */   {
/*    */     final PermissionList list;
/*    */     final String world;
/*    */     
/*    */     public CacheEntry(PermissionList param1PermissionList, String param1String) {
/* 76 */       this.list = param1PermissionList;
/* 77 */       this.world = param1String;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/CachedPlayerPermissionProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */