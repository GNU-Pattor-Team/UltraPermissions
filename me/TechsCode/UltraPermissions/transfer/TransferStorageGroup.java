/*    */ package me.TechsCode.UltraPermissions.transfer;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.implementations.LocalFile;
/*    */ import me.TechsCode.UltraPermissions.base.storage.implementations.MySQL;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TransferStorageGroup
/*    */ {
/*    */   TransferStorage<User> userStorage;
/*    */   TransferStorage<Permission> permissionStorage;
/*    */   TransferStorage<Group> groupStorage;
/*    */   
/*    */   public TransferStorageGroup(UltraPermissions paramUltraPermissions, boolean paramBoolean) {
/* 64 */     this.userStorage = new TransferStorage<>((TechPlugin)paramUltraPermissions, "Users", (Class)User.class, paramBoolean ? (Class)MySQL.class : (Class)LocalFile.class, false);
/* 65 */     this.permissionStorage = new TransferStorage<>((TechPlugin)paramUltraPermissions, "Permissions", (Class)Permission.class, paramBoolean ? (Class)MySQL.class : (Class)LocalFile.class, false);
/* 66 */     this.groupStorage = new TransferStorage<>((TechPlugin)paramUltraPermissions, "Groups", (Class)Group.class, paramBoolean ? (Class)MySQL.class : (Class)LocalFile.class, false);
/*    */   }
/*    */   
/*    */   public void copyTo(TransferStorageGroup paramTransferStorageGroup) {
/* 70 */     (new ArrayList(paramTransferStorageGroup.userStorage.get())).forEach(User::_justDestroy);
/* 71 */     (new ArrayList(paramTransferStorageGroup.permissionStorage.get())).forEach(Permission::_justDestroy);
/* 72 */     (new ArrayList(paramTransferStorageGroup.groupStorage.get())).forEach(Group::_justDestroy);
/*    */     
/* 74 */     this.groupStorage.get().forEach(paramGroup -> (Group)paramTransferStorageGroup.groupStorage.create((Storable)paramGroup.createCopy()));
/* 75 */     this.permissionStorage.get().forEach(paramPermission -> (Permission)paramTransferStorageGroup.permissionStorage.create((Storable)paramPermission.createCopy()));
/* 76 */     this.userStorage.get().forEach(paramUser -> (User)paramTransferStorageGroup.userStorage.create((Storable)paramUser.createCopy()));
/*    */   }
/*    */   
/*    */   public long getLastWrite() {
/* 80 */     return ((Long)Collections.<Long>max(Arrays.asList(new Long[] { Long.valueOf(this.userStorage.getLastWrite()), Long.valueOf(this.permissionStorage.getLastWrite()), Long.valueOf(this.groupStorage.getLastWrite()) }))).longValue();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/transfer/TransferStorageGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */