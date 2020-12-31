/*    */ package me.TechsCode.UltraPermissions.permissionDatabase;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ 
/*    */ public class PermissionInfoList extends ArrayList<PermissionInfo> {
/*    */   public PermissionInfoList(int paramInt) {
/* 12 */     super(paramInt);
/*    */   }
/*    */   
/*    */   public PermissionInfoList() {}
/*    */   
/*    */   public PermissionInfoList(Collection<? extends PermissionInfo> paramCollection) {
/* 18 */     super(paramCollection);
/*    */   }
/*    */   
/*    */   public Optional<PermissionInfo> find(String paramString) {
/* 22 */     for (PermissionInfo permissionInfo : this) { if (permissionInfo.isThisPermission(paramString)) return Optional.of(permissionInfo);  }
/*    */     
/* 24 */     return Optional.empty();
/*    */   }
/*    */   
/*    */   public PermissionInfoList plugins(List<String> paramList) {
/* 28 */     return (PermissionInfoList)stream().filter(paramPermissionInfo -> paramList.contains(paramPermissionInfo.getPlugin())).collect(Collectors.toCollection(PermissionInfoList::new));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/permissionDatabase/PermissionInfoList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */