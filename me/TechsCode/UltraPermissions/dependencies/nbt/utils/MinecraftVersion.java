/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils;
/*     */ 
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.bukkit.Bukkit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum MinecraftVersion
/*     */ {
/*     */   private static MinecraftVersion version;
/*     */   private static Boolean hasGsonSupport;
/*  18 */   UNKNOWN(2147483647),
/*  19 */   MC1_7_R4(174), MC1_8_R3(183), MC1_9_R1(191), MC1_9_R2(192), MC1_10_R1(1101), MC1_11_R1(1111), MC1_12_R1(1121),
/*  20 */   MC1_13_R1(1131), MC1_13_R2(1132), MC1_14_R1(1141), MC1_15_R1(1151), MC1_16_R1(1161), MC1_16_R2(1162); private static boolean bStatsDisabled;
/*     */   private static boolean disablePackageWarning;
/*     */   
/*     */   static {
/*  24 */     bStatsDisabled = false;
/*  25 */     disablePackageWarning = false;
/*  26 */     updateCheckDisabled = false;
/*     */ 
/*     */ 
/*     */     
/*  30 */     logger = Logger.getLogger("NBTAPI");
/*     */   }
/*     */   private static boolean updateCheckDisabled;
/*     */   public static final Logger logger;
/*     */   protected static final String VERSION = "2.5.0";
/*     */   private final int versionId;
/*     */   
/*     */   MinecraftVersion(int paramInt1) {
/*  38 */     this.versionId = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVersionId() {
/*  45 */     return this.versionId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAtLeastVersion(MinecraftVersion paramMinecraftVersion) {
/*  55 */     return (getVersion().getVersionId() >= paramMinecraftVersion.getVersionId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MinecraftVersion getVersion() {
/*  65 */     if (version != null) {
/*  66 */       return version;
/*     */     }
/*  68 */     String str = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
/*  69 */     logger.info("[NBTAPI] Found Spigot: " + str + "! Trying to find NMS support");
/*     */     try {
/*  71 */       version = valueOf(str.replace("v", "MC"));
/*  72 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  73 */       version = UNKNOWN;
/*     */     } 
/*  75 */     if (version != UNKNOWN) {
/*  76 */       logger.info("[NBTAPI] NMS support '" + version.name() + "' loaded!");
/*     */     } else {
/*  78 */       logger.warning("[NBTAPI] Wasn't able to find NMS Support! Some functions may not work!");
/*     */     } 
/*  80 */     init();
/*  81 */     return version;
/*     */   }
/*     */   
/*     */   private static void init() {
/*     */     try {
/*  86 */       if (hasGsonSupport() && !bStatsDisabled)
/*  87 */         new ApiMetricsLite(); 
/*  88 */     } catch (Exception exception) {
/*  89 */       logger.log(Level.WARNING, "[NBTAPI] Error enabling Metrics!", exception);
/*     */     } 
/*     */     
/*  92 */     if (hasGsonSupport() && !updateCheckDisabled) {
/*  93 */       (new Thread(() -> {
/*     */             try {
/*     */               VersionChecker.checkForUpdates();
/*  96 */             } catch (Exception exception) {
/*     */               logger.log(Level.WARNING, "[NBTAPI] Error while checking for updates!", exception);
/*     */             } 
/*  99 */           })).start();
/*     */     }
/*     */     
/* 102 */     String str = new String(new byte[] { 100, 101, 46, 116, 114, 55, 122, 119, 46, 99, 104, 97, 110, 103, 101, 109, 101, 46, 110, 98, 116, 97, 112, 105, 46, 117, 116, 105, 108, 115 });
/*     */     
/* 104 */     if (!disablePackageWarning && MinecraftVersion.class.getPackage().getName().equals(str)) {
/* 105 */       logger.warning("#########################################- NBTAPI -#########################################");
/*     */       
/* 107 */       logger.warning("The NBT-API package has not been moved! This *will* cause problems with other plugins containing");
/*     */       
/* 109 */       logger.warning("a different version of the api! Please read the guide on the plugin page on how to get the");
/*     */       
/* 111 */       logger.warning("Maven Shade plugin to relocate the api to your personal location! If you are not the developer,");
/*     */       
/* 113 */       logger.warning("please check your plugins and contact their developer, so he can fix this issue.");
/* 114 */       logger.warning("#########################################- NBTAPI -#########################################");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasGsonSupport() {
/* 123 */     if (hasGsonSupport != null) {
/* 124 */       return hasGsonSupport.booleanValue();
/*     */     }
/*     */     try {
/* 127 */       logger.info("[NBTAPI] Found Gson: " + Class.forName("com.google.gson.Gson"));
/* 128 */       hasGsonSupport = Boolean.valueOf(true);
/* 129 */     } catch (Exception exception) {
/* 130 */       logger.info("[NBTAPI] Gson not found! This will not allow the usage of some methods!");
/* 131 */       hasGsonSupport = Boolean.valueOf(false);
/*     */     } 
/* 133 */     return hasGsonSupport.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void disableBStats() {
/* 142 */     bStatsDisabled = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void disableUpdateCheck() {
/* 150 */     updateCheckDisabled = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void disablePackageWarning() {
/* 160 */     disablePackageWarning = true;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/MinecraftVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */