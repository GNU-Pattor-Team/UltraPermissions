/*    */ package me.TechsCode.UltraPermissions.base.legacy.utils;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ 
/*    */ public class LocationUtils
/*    */ {
/*    */   public static Location getValidSpawnPoint(Location paramLocation) {
/* 10 */     return getValidSpawnPoint(paramLocation, 1);
/*    */   }
/*    */   
/*    */   private static Location getValidSpawnPoint(Location paramLocation, int paramInt) {
/* 14 */     for (int i = paramLocation.getBlockX() - paramInt; i <= paramLocation.getBlockX() + paramInt; i++) {
/* 15 */       for (int j = paramLocation.getBlockY() - paramInt; j <= paramLocation.getBlockY() + paramInt; j++) {
/* 16 */         for (int k = paramLocation.getBlockZ() - paramInt; k <= paramLocation.getBlockZ() + paramInt; k++) {
/* 17 */           Location location1 = new Location(paramLocation.getWorld(), i + 0.5D, j, k + 0.5D);
/* 18 */           Location location2 = location1.clone().add(0.0D, 1.0D, 0.0D);
/* 19 */           if (location1.getBlock().getType() == Material.AIR && location2.getBlock().getType() == Material.AIR) {
/* 20 */             return location1;
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 26 */     return getValidSpawnPoint(paramLocation, paramInt + 1);
/*    */   }
/*    */   
/*    */   public static String serialize(Location paramLocation) {
/* 30 */     return paramLocation.getWorld().getName() + ";" + paramLocation.getBlockX() + ";" + paramLocation.getBlockY() + ";" + paramLocation.getBlockZ();
/*    */   }
/*    */   
/*    */   public static Location deserialize(String paramString) {
/* 34 */     String[] arrayOfString = paramString.split(";");
/* 35 */     return new Location(Bukkit.getWorld(arrayOfString[0]), Integer.valueOf(arrayOfString[1]).intValue(), Integer.valueOf(arrayOfString[2]).intValue(), Integer.valueOf(arrayOfString[3]).intValue());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/utils/LocationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */