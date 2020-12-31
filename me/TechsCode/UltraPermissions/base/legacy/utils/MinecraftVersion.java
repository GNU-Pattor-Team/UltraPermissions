/*    */ package me.TechsCode.UltraPermissions.base.legacy.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.Bukkit;
/*    */ 
/*    */ public enum MinecraftVersion {
/*  7 */   UNKNOWN,
/*  8 */   V1_8_R1,
/*  9 */   V1_8_R2,
/* 10 */   V1_8_R3,
/* 11 */   V1_9_R1,
/* 12 */   V1_9_R2,
/* 13 */   V1_10_R1,
/* 14 */   V1_11_R1,
/* 15 */   V1_12_R1,
/* 16 */   V1_13_R1,
/* 17 */   V1_13_R2,
/* 18 */   V1_14_R1,
/* 19 */   V1_15_R1,
/* 20 */   V1_16_R1,
/* 21 */   V1_16_R2;
/*    */   
/*    */   private static MinecraftVersion currentVersion;
/*    */   
/*    */   static {
/*    */     try {
/* 27 */       File file1 = new File("server.properties");
/* 28 */       File file2 = new File("bukkit.yml");
/*    */       
/* 30 */       if (file1.exists() && file2.exists()) {
/* 31 */         currentVersion = valueOf(Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].toUpperCase());
/*    */       } else {
/* 33 */         currentVersion = UNKNOWN;
/*    */       }
/*    */     
/* 36 */     } catch (Exception exception) {
/* 37 */       currentVersion = UNKNOWN;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isAboveOrEqual(MinecraftVersion paramMinecraftVersion) {
/* 43 */     return (ordinal() >= paramMinecraftVersion.ordinal());
/*    */   }
/*    */   public static MinecraftVersion getServersVersion() {
/* 46 */     return currentVersion;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/utils/MinecraftVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */