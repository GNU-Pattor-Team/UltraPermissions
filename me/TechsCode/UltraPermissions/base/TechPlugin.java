/*     */ package me.TechsCode.UltraPermissions.base;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.base.loader.reloader.PluginReloader;
/*     */ import me.TechsCode.UltraPermissions.base.mysql.MySQLManager;
/*     */ import me.TechsCode.UltraPermissions.base.registry.RegistrationChoice;
/*     */ import me.TechsCode.UltraPermissions.base.registry.Registry;
/*     */ import me.TechsCode.UltraPermissions.base.scheduler.Scheduler;
/*     */ import me.TechsCode.UltraPermissions.base.storage.syncing.SyncingAgent;
/*     */ import me.TechsCode.UltraPermissions.base.translations.TranslationManager;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TechPlugin<BOOTSTRAP>
/*     */ {
/*     */   private final BOOTSTRAP bootstrap;
/*     */   private Registry registry;
/*     */   private MySQLManager mySQLManager;
/*     */   private AppearanceRegistry appearanceRegistry;
/*     */   private TranslationManager translationManager;
/*     */   private List<Runnable> disableHooks;
/*     */   
/*     */   public TechPlugin(BOOTSTRAP paramBOOTSTRAP) {
/*  28 */     this.bootstrap = paramBOOTSTRAP;
/*     */     
/*  30 */     log("Loading Plugin...");
/*  31 */     long l1 = System.currentTimeMillis();
/*     */     
/*  33 */     onInitialization();
/*     */     
/*  35 */     boolean bool = onGlobalEnable();
/*  36 */     if (!bool)
/*     */       return; 
/*  38 */     onPlatformEnable();
/*  39 */     onEnable();
/*     */     
/*  41 */     long l2 = System.currentTimeMillis() - l1;
/*  42 */     log("Successfully loaded in " + l2 + " ms");
/*     */   }
/*     */   
/*     */   public void disable() {
/*  46 */     onDisable();
/*  47 */     onPlatformDisable();
/*  48 */     onGlobalDisable();
/*     */   }
/*     */   
/*     */   private boolean onGlobalEnable() {
/*  52 */     this.registry = new Registry(this);
/*     */     
/*  54 */     this.mySQLManager = new MySQLManager(this);
/*     */     
/*  56 */     this.appearanceRegistry = (AppearanceRegistry)this.registry.register(new AppearanceRegistry(this), RegistrationChoice.GLOBAL_IF_AVAILABLE);
/*  57 */     this.translationManager = new TranslationManager(this);
/*     */     
/*  59 */     this.disableHooks = new ArrayList<>();
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   private void onGlobalDisable() {
/*  64 */     this.disableHooks.forEach(Runnable::run);
/*     */   }
/*     */   
/*     */   protected abstract void onEnable();
/*     */   
/*     */   protected abstract void onDisable();
/*     */   
/*     */   protected abstract void onInitialization();
/*     */   
/*     */   protected abstract void onPlatformEnable();
/*     */   
/*     */   protected abstract void onPlatformDisable();
/*     */   
/*     */   public BOOTSTRAP getBootstrap() {
/*  78 */     return this.bootstrap;
/*     */   }
/*     */   
/*     */   public abstract String getName();
/*     */   
/*     */   public abstract String getVersion();
/*     */   
/*     */   public abstract int getBuildNumber();
/*     */   
/*     */   public abstract File getPluginFolder();
/*     */   
/*     */   public abstract File getServerFolder();
/*     */   
/*     */   public abstract Scheduler getScheduler();
/*     */   
/*     */   public abstract SyncingAgent getSyncingAgent();
/*     */   
/*     */   public abstract InputStream getResource(String paramString);
/*     */   
/*     */   public abstract PluginReloader<?> getPluginReloader();
/*     */   
/*     */   protected abstract void sendConsole(String paramString);
/*     */   
/*     */   public Registry getRegistry() {
/* 102 */     return this.registry;
/*     */   }
/*     */   
/*     */   public AppearanceRegistry getAppearanceRegistry() {
/* 106 */     return this.appearanceRegistry;
/*     */   }
/*     */   
/*     */   public String getPrefix() {
/* 110 */     return Text.chatColor(this.appearanceRegistry.getPrefix()) + " ";
/*     */   }
/*     */   
/*     */   public void log(String paramString) {
/* 114 */     sendConsole("§b[§7" + getName() + "§b] §r" + paramString);
/*     */   }
/*     */   
/*     */   public MySQLManager getMySQLManager() {
/* 118 */     return this.mySQLManager;
/*     */   }
/*     */   
/*     */   public void addDisableHook(Runnable paramRunnable) {
/* 122 */     this.disableHooks.add(paramRunnable);
/*     */   }
/*     */   
/*     */   public boolean isAllowingInvalidMySQL() {
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public TranslationManager getTranslationManager() {
/* 130 */     return this.translationManager;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/TechPlugin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */