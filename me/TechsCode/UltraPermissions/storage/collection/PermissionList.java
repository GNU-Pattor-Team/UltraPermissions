/*    */ package me.TechsCode.UltraPermissions.storage.collection;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Holder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ public class PermissionList extends ArrayList<Permission> {
/*    */   public PermissionList(int paramInt) {
/* 12 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public PermissionList() {}
/*    */   
/*    */   public PermissionList(Collection<? extends Permission> paramCollection) {
/* 19 */     super(paramCollection);
/*    */   }
/*    */   
/*    */   public PermissionList name(String paramString) {
/* 23 */     return (PermissionList)stream().filter(paramPermission -> paramPermission.getName().equalsIgnoreCase(paramString)).collect(Collectors.toCollection(PermissionList::new));
/*    */   }
/*    */   
/*    */   public PermissionList holder(List<Holder> paramList) {
/* 27 */     return (PermissionList)stream().filter(paramPermission -> paramList.contains(paramPermission.getHolder())).collect(Collectors.toCollection(PermissionList::new));
/*    */   }
/*    */   
/*    */   public PermissionList holder(Holder... paramVarArgs) {
/* 31 */     return holder(Arrays.asList(paramVarArgs));
/*    */   }
/*    */   
/*    */   public PermissionList bungee() {
/* 35 */     return (PermissionList)stream().filter(Permission::isBungeePermission).collect(Collectors.toCollection(PermissionList::new));
/*    */   }
/*    */   
/*    */   public PermissionList expired() {
/* 39 */     return (PermissionList)stream().filter(Permission::isExpired).collect(Collectors.toCollection(PermissionList::new));
/*    */   }
/*    */   
/*    */   public PermissionList worlds(boolean paramBoolean, List<String> paramList) {
/* 43 */     return (PermissionList)stream().filter(paramPermission -> {
/*    */           Optional optional = paramPermission.getWorld();
/*    */           
/* 46 */           return ((paramBoolean && !optional.isPresent()) || (optional.isPresent() && paramList.contains(optional.get())));
/* 47 */         }).collect(Collectors.toCollection(PermissionList::new));
/*    */   }
/*    */   
/*    */   public PermissionList worlds(boolean paramBoolean, String... paramVarArgs) {
/* 51 */     return worlds(paramBoolean, Arrays.asList(paramVarArgs));
/*    */   }
/*    */   
/*    */   public PermissionList servers(boolean paramBoolean, List<String> paramList) {
/* 55 */     return (PermissionList)stream().filter(paramPermission -> {
/*    */           Optional optional = paramPermission.getServer();
/*    */           
/* 58 */           return ((paramBoolean && !optional.isPresent()) || (optional.isPresent() && paramList.contains(optional.get())));
/* 59 */         }).collect(Collectors.toCollection(PermissionList::new));
/*    */   }
/*    */   
/*    */   public PermissionList servers(boolean paramBoolean, String... paramVarArgs) {
/* 63 */     return servers(paramBoolean, Arrays.asList(paramVarArgs));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/collection/PermissionList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */