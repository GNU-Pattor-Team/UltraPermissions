/*     */ package me.TechsCode.UltraPermissions.permissionDatabase;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.permissions.Permission;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PermissionDatabase
/*     */ {
/*     */   private HashMap<String, PermissionInfo> map;
/*     */   public static final String githubLink = "https://raw.githubusercontent.com/TechsCode/PluginResources/master/Permissions%20Database/Database.updb";
/*     */   
/*     */   public PermissionDatabase(UltraPermissions paramUltraPermissions) {
/*  26 */     this.map = new HashMap<>();
/*     */     
/*  28 */     Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin)paramUltraPermissions.getBootstrap(), () -> {
/*     */           paramUltraPermissions.log("Loading Permission Database...");
/*     */           
/*     */           for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
/*     */             for (Permission permission : plugin.getDescription().getPermissions()) {
/*     */               this.map.put(permission.getName(), new PermissionInfo(permission.getName(), plugin.getName(), permission.getDescription(), new String[0], "Extracted from .jar"));
/*     */             }
/*     */           } 
/*     */           
/*     */           paramUltraPermissions.log("- " + this.map.size() + " Permissions extracted from .jars");
/*     */           
/*     */           File file = new File(paramUltraPermissions.getPluginFolder().getAbsolutePath() + "/Main.updb");
/*     */           
/*     */           boolean bool = false;
/*     */           
/*     */           try {
/*     */             FileUtils.copyURLToFile(new URL("https://raw.githubusercontent.com/TechsCode/PluginResources/master/Permissions%20Database/Database.updb"), file);
/*     */             bool = true;
/*  46 */           } catch (IOException iOException) {
/*     */             paramUltraPermissions.log("Failed to load Permissions from the Cloud");
/*     */           } 
/*     */           
/*     */           if (file.exists()) {
/*     */             try {
/*     */               byte b = 0;
/*     */               
/*     */               for (String str : FileUtils.readLines(file, "UTF-8")) {
/*     */                 if (!str.startsWith("#")) {
/*     */                   String[] arrayOfString1 = str.split("[+]");
/*     */                   if (arrayOfString1.length < 2) {
/*     */                     paramUltraPermissions.log("Invalid line in " + file.getName() + ":");
/*     */                     paramUltraPermissions.log(str);
/*     */                     continue;
/*     */                   } 
/*     */                   String str1 = arrayOfString1[0];
/*     */                   String str2 = arrayOfString1[1];
/*     */                   String str3 = "";
/*     */                   String[] arrayOfString2 = new String[0];
/*     */                   if (arrayOfString1.length >= 3) {
/*     */                     str3 = arrayOfString1[2];
/*     */                   }
/*     */                   if (arrayOfString1.length >= 4) {
/*     */                     arrayOfString2 = arrayOfString1[3].split(",");
/*     */                   }
/*     */                   this.map.put(str2, new PermissionInfo(str2, str1, str3, arrayOfString2, "Permission Database (" + file.getName() + ")"));
/*     */                   b++;
/*     */                 } 
/*     */               } 
/*     */               if (bool) {
/*     */                 paramUltraPermissions.log("- " + b + " Permissions downloaded from the Cloud");
/*     */               } else {
/*     */                 paramUltraPermissions.log("- " + b + " Permissions loaded from the Cache");
/*     */               } 
/*  81 */             } catch (IOException iOException) {
/*     */               iOException.printStackTrace();
/*     */             } 
/*     */           } else {
/*     */             paramUltraPermissions.log("Connect this Server to the internet to load the Permission Database");
/*     */           } 
/*     */         }20L);
/*     */   }
/*     */   
/*     */   public PermissionInfo getInfo(String paramString) {
/*  91 */     if (this.map.containsKey(paramString)) {
/*  92 */       return this.map.get(paramString);
/*     */     }
/*     */     
/*  95 */     for (PermissionInfo permissionInfo : this.map.values()) {
/*  96 */       if (permissionInfo.isThisPermission(paramString)) {
/*  97 */         return permissionInfo;
/*     */       }
/*     */     } 
/*     */     
/* 101 */     return null;
/*     */   }
/*     */   
/*     */   public List<String> getSupportedPlugins() {
/* 105 */     return (List<String>)this.map.entrySet().stream().map(paramEntry -> ((PermissionInfo)paramEntry.getValue()).getPlugin()).distinct().collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public PermissionInfoList getPermissionInfosFromPlugin(String paramString) {
/* 109 */     return (PermissionInfoList)this.map.values().stream().filter(paramPermissionInfo -> paramPermissionInfo.getPlugin().equalsIgnoreCase(paramString)).collect(Collectors.toCollection(PermissionInfoList::new));
/*     */   }
/*     */   
/*     */   public PermissionInfoList getAllPermissionInfos() {
/* 113 */     return new PermissionInfoList(this.map.values());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/permissionDatabase/PermissionDatabase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */