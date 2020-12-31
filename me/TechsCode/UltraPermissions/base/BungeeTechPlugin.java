/*     */ package me.TechsCode.UltraPermissions.base;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import me.TechsCode.UltraPermissions.base.fileconf.FileConfiguration;
/*     */ import me.TechsCode.UltraPermissions.base.loader.reloader.BungeePluginReloader;
/*     */ import me.TechsCode.UltraPermissions.base.loader.reloader.PluginReloader;
/*     */ import me.TechsCode.UltraPermissions.base.messaging.BungeeMessagingService;
/*     */ import me.TechsCode.UltraPermissions.base.scheduler.BungeeScheduler;
/*     */ import me.TechsCode.UltraPermissions.base.scheduler.Scheduler;
/*     */ import me.TechsCode.UltraPermissions.base.storage.syncing.BungeeSyncingAgent;
/*     */ import me.TechsCode.UltraPermissions.base.storage.syncing.SyncingAgent;
/*     */ import me.TechsCode.UltraPermissions.base.update.networkUpdate.BungeeUpdateAgent;
/*     */ import net.md_5.bungee.api.ProxyServer;
/*     */ import net.md_5.bungee.api.plugin.Plugin;
/*     */ 
/*     */ public abstract class BungeeTechPlugin
/*     */   extends TechPlugin<Plugin>
/*     */ {
/*     */   private BungeeScheduler scheduler;
/*     */   private BungeeMessagingService messagingService;
/*     */   private SyncingAgent syncingAgent;
/*     */   
/*     */   public BungeeTechPlugin(Plugin paramPlugin) {
/*  25 */     super(paramPlugin);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onInitialization() {
/*  30 */     this.scheduler = new BungeeScheduler(this);
/*  31 */     this.messagingService = new BungeeMessagingService(this);
/*  32 */     this.syncingAgent = (SyncingAgent)new BungeeSyncingAgent(this);
/*     */     
/*  34 */     new BungeeUpdateAgent(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onPlatformEnable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onPlatformDisable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  49 */     return getBootstrap().getDescription().getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  54 */     return getBootstrap().getDescription().getVersion();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBuildNumber() {
/*  59 */     File file = getBootstrap().getDescription().getFile();
/*  60 */     FileConfiguration fileConfiguration = new FileConfiguration(this, file);
/*  61 */     return fileConfiguration.getInt("build");
/*     */   }
/*     */ 
/*     */   
/*     */   public File getPluginFolder() {
/*  66 */     return getBootstrap().getDataFolder();
/*     */   }
/*     */ 
/*     */   
/*     */   public File getServerFolder() {
/*  71 */     return ProxyServer.getInstance().getPluginsFolder().getParentFile();
/*     */   }
/*     */ 
/*     */   
/*     */   public Scheduler getScheduler() {
/*  76 */     return (Scheduler)this.scheduler;
/*     */   }
/*     */   
/*     */   public BungeeMessagingService getMessagingService() {
/*  80 */     return this.messagingService;
/*     */   }
/*     */ 
/*     */   
/*     */   public SyncingAgent getSyncingAgent() {
/*  85 */     return this.syncingAgent;
/*     */   }
/*     */ 
/*     */   
/*     */   public PluginReloader<?> getPluginReloader() {
/*  90 */     return (PluginReloader<?>)new BungeePluginReloader(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void sendConsole(String paramString) {
/*  95 */     getBootstrap().getLogger().info(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getResource(String paramString) {
/* 100 */     return getBootstrap().getResourceAsStream(paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/BungeeTechPlugin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */