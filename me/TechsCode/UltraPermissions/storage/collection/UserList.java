/*    */ package me.TechsCode.UltraPermissions.storage.collection;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Optional;
/*    */ import java.util.UUID;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Stored;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ 
/*    */ public class UserList
/*    */   extends ArrayList<User> {
/*    */   public Optional<User> uuid(UUID paramUUID) {
/* 15 */     return stream().filter(paramUser -> paramUser.getUuid().equals(paramUUID)).findFirst();
/*    */   }
/*    */   
/*    */   public Optional<User> name(String paramString) {
/* 19 */     return stream().filter(paramUser -> paramUser.getName().equalsIgnoreCase(paramString)).findFirst();
/*    */   }
/*    */   
/*    */   public UserList usersInGroup(Stored<Group> paramStored) {
/* 23 */     return (UserList)stream().filter(paramUser -> paramUser.getGroups().contains(paramStored)).collect(Collectors.toCollection(UserList::new));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/collection/UserList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */