/*     */ package me.TechsCode.UltraPermissions.base;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.TaskManager;
/*     */ import me.TechsCode.UltraPermissions.base.loader.reloader.PluginReloader;
/*     */ import me.TechsCode.UltraPermissions.base.loader.reloader.SpigotPluginReloader;
/*     */ import me.TechsCode.UltraPermissions.base.messaging.SpigotMessagingService;
/*     */ import me.TechsCode.UltraPermissions.base.scheduler.Scheduler;
/*     */ import me.TechsCode.UltraPermissions.base.scheduler.SpigotScheduler;
/*     */ import me.TechsCode.UltraPermissions.base.source.Maven;
/*     */ import me.TechsCode.UltraPermissions.base.storage.syncing.SpigotSyncingAgent;
/*     */ import me.TechsCode.UltraPermissions.base.storage.syncing.SyncingAgent;
/*     */ import me.TechsCode.UltraPermissions.base.update.networkUpdate.SpigotUpdateAgent;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ 
/*     */ public abstract class SpigotTechPlugin
/*     */   extends TechPlugin<JavaPlugin>
/*     */ {
/*     */   private SpigotScheduler scheduler;
/*     */   private SpigotMessagingService messagingService;
/*     */   private SyncingAgent syncingAgent;
/*     */   private SpigotUpdateAgent updateAgent;
/*     */   
/*     */   public SpigotTechPlugin(JavaPlugin paramJavaPlugin) {
/*  32 */     super(paramJavaPlugin);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onInitialization() {
/*  37 */     this.scheduler = new SpigotScheduler(this);
/*  38 */     this.messagingService = new SpigotMessagingService(this);
/*  39 */     this.syncingAgent = (SyncingAgent)new SpigotSyncingAgent(this);
/*  40 */     this.updateAgent = new SpigotUpdateAgent(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onPlatformEnable() {
/*  45 */     Maven.initialize(this);
/*  46 */     Maven.addRepository("https://repo.everit.biz/artifactory/public-release");
/*     */     
/*  48 */     new TaskManager(this);
/*     */     
/*  50 */     Logger.getLogger("NBTAPI").setLevel(Level.OFF);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onPlatformDisable() {
/*  55 */     this.messagingService.onDisable();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  60 */     return getBootstrap().getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  65 */     return getBootstrap().getDescription().getVersion();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBuildNumber() {
/*  70 */     InputStream inputStream = getBootstrap().getResource("plugin.yml");
/*     */     
/*  72 */     if (inputStream == null) return 0;
/*     */     
/*  74 */     return ((Integer)(new BufferedReader(new InputStreamReader(inputStream))).lines()
/*  75 */       .filter(paramString -> paramString.startsWith("build: "))
/*  76 */       .map(paramString -> paramString.replace("build: ", ""))
/*  77 */       .map(Integer::parseInt)
/*  78 */       .findFirst().orElse(Integer.valueOf(0))).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public File getPluginFolder() {
/*  83 */     return getBootstrap().getDataFolder();
/*     */   }
/*     */ 
/*     */   
/*     */   public File getServerFolder() {
/*  88 */     return new File(".");
/*     */   }
/*     */ 
/*     */   
/*     */   public Scheduler getScheduler() {
/*  93 */     return (Scheduler)this.scheduler;
/*     */   }
/*     */   
/*     */   public SpigotMessagingService getMessagingService() {
/*  97 */     return this.messagingService;
/*     */   }
/*     */ 
/*     */   
/*     */   public SyncingAgent getSyncingAgent() {
/* 102 */     return this.syncingAgent;
/*     */   }
/*     */ 
/*     */   
/*     */   public PluginReloader<?> getPluginReloader() {
/* 107 */     return (PluginReloader<?>)new SpigotPluginReloader(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void sendConsole(String paramString) {
/* 112 */     Bukkit.getConsoleSender().sendMessage(paramString);
/*     */   }
/*     */   
/*     */   public SpigotUpdateAgent getUpdateAgent() {
/* 116 */     return this.updateAgent;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getResource(String paramString) {
/* 121 */     return getBootstrap().getResource(paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/SpigotTechPlugin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */