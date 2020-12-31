/*    */ package me.TechsCode.UltraPermissions.utility;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.permissions.Permission;
/*    */ 
/*    */ 
/*    */ public class BukkitChildrenResolver
/*    */ {
/*    */   private static BukkitChildrenResolver i;
/*    */   private Set<Permission> permissions;
/*    */   
/*    */   public static BukkitChildrenResolver getInstance() {
/* 15 */     if (i == null) i = new BukkitChildrenResolver();
/*    */     
/* 17 */     return i;
/*    */   }
/*    */   
/*    */   public BukkitChildrenResolver() {
/* 21 */     this.permissions = Bukkit.getPluginManager().getPermissions();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public HashSet<String> retrieveChildPermissions(String paramString) {
/* 27 */     Permission permission = this.permissions.stream().filter(paramPermission -> paramPermission.getName().equalsIgnoreCase(paramString)).findFirst().orElse(null);
/*    */     
/* 29 */     if (permission == null) return new HashSet<>();
/*    */     
/* 31 */     HashSet<String> hashSet = new HashSet();
/*    */     
/* 33 */     permission.getChildren().forEach((paramString, paramBoolean) -> {
/*    */           if (paramBoolean.booleanValue()) {
/*    */             paramHashSet.add(paramString);
/*    */             
/*    */             paramHashSet.addAll(retrieveChildPermissions(paramString));
/*    */           } 
/*    */         });
/* 40 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/utility/BukkitChildrenResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */