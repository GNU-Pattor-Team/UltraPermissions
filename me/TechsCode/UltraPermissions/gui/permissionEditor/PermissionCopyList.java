/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ 
/*    */ public class PermissionCopyList extends ArrayList<PermissionCopy> {
/*    */   public PermissionCopyList(int paramInt) {
/* 12 */     super(paramInt);
/*    */   }
/*    */   
/*    */   public PermissionCopyList() {}
/*    */   
/*    */   public PermissionCopyList(Collection<? extends PermissionCopy> paramCollection) {
/* 18 */     super(paramCollection);
/*    */   }
/*    */   
/*    */   public PermissionCopyList(PermissionList paramPermissionList1, PermissionList paramPermissionList2) {
/* 22 */     paramPermissionList1.forEach(paramPermission -> add(new PermissionCopy(paramPermission, false)));
/* 23 */     paramPermissionList2.forEach(paramPermission -> add(new PermissionCopy(paramPermission, true)));
/*    */   }
/*    */   
/*    */   public List<PermissionCopy> inheritedCopies() {
/* 27 */     return (List<PermissionCopy>)stream().filter(PermissionCopy::isInherited).collect(Collectors.toList());
/*    */   }
/*    */   
/*    */   public List<PermissionCopy> regularCopies() {
/* 31 */     return (List<PermissionCopy>)stream().filter(paramPermissionCopy -> !paramPermissionCopy.isInherited()).collect(Collectors.toList());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PermissionCopyList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */