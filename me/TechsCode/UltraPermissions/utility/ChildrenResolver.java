/*    */ package me.TechsCode.UltraPermissions.utility;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class ChildrenResolver
/*    */ {
/*  9 */   private static HashMap<String, Set<String>> cache = new HashMap<>();
/*    */   private static boolean isSpigot;
/*    */   
/*    */   static {
/*    */     try {
/* 14 */       Class.forName("org.bukkit.entity.Player$Spigot");
/* 15 */       isSpigot = true;
/* 16 */     } catch (ClassNotFoundException classNotFoundException) {
/* 17 */       isSpigot = false;
/*    */     } 
/*    */   }
/*    */   public static Set<String> retrieveChildPermissions(String paramString) {
/*    */     HashSet<String> hashSet;
/* 22 */     if (cache.containsKey(paramString)) return cache.get(paramString);
/*    */ 
/*    */ 
/*    */     
/* 26 */     if (!isSpigot) {
/* 27 */       hashSet = new HashSet();
/*    */     } else {
/* 29 */       hashSet = BukkitChildrenResolver.getInstance().retrieveChildPermissions(paramString);
/*    */     } 
/*    */     
/* 32 */     hashSet.add(paramString);
/*    */     
/* 34 */     cache.put(paramString, hashSet);
/* 35 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/utility/ChildrenResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */