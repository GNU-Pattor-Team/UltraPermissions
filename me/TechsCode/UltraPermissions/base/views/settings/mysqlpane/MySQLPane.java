/*     */ package me.TechsCode.UltraPermissions.base.views.settings.mysqlpane;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.misc.Getter;
/*     */ import me.TechsCode.UltraPermissions.base.misc.Setter;
/*     */ import me.TechsCode.UltraPermissions.base.mysql.ConnectionFactory;
/*     */ import me.TechsCode.UltraPermissions.base.mysql.ConnectionTestResult;
/*     */ import me.TechsCode.UltraPermissions.base.mysql.MySQLCredentials;
/*     */ import me.TechsCode.UltraPermissions.base.mysql.MySQLRegistry;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*     */ import me.TechsCode.UltraPermissions.base.views.RestartView;
/*     */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsPane;
/*     */ import me.TechsCode.UltraPermissions.base.views.settings.SettingsView;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class MySQLPane extends SettingsPane {
/*  26 */   private static final Phrase NAME = Phrase.create("mysqlPane.name", "MySQL Database");
/*     */   
/*  28 */   private static final Phrase HOSTNAME = Phrase.create("mysqlPane.hostname", "hostname");
/*  29 */   private static final Phrase PORT = Phrase.create("mysqlPane.port", "port");
/*  30 */   private static final Phrase DATABASE = Phrase.create("mysqlPane.database", "database");
/*  31 */   private static final Phrase USERNAME = Phrase.create("mysqlPane.username", "username");
/*  32 */   private static final Phrase PASSWORD = Phrase.create("mysqlPane.password", "password");
/*     */   
/*  34 */   private static final Phrase CREDENTIALS_TITLE = Phrase.create("mysqlPane.credentials.title", "Credentials");
/*  35 */   private static final Phrase CREDENTIALS_DESC = Phrase.create("mysqlPane.credentials.desc", "These must be the same for **every** Server", Colors.GRAY, new Color[] { Colors.GREEN });
/*  36 */   private static final Phrase CREDENTIALS_CLEAR_ACTION = Phrase.create("mysqlPane.credentials.clearAction", "**Click** to **clear** MySQL Credentials", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*  37 */   private static final Phrase CREDENTIALS_ENTER_ACTION = Phrase.create("mysqlPane.credentials.enterAction", "**Click** to **enter** MySQL Credentials", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GOLD });
/*  38 */   private static final Phrase CREDENTIALS_CONNECTION_URL = Phrase.create("mysqlPane.credentials.connectionsUrl", "Connection Url:", Colors.GRAY, new Color[0]);
/*  39 */   private static final Phrase CREDENTIALS_USERNAME = Phrase.create("mysqlPane.credentials.username", "Username: **%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  40 */   private static final Phrase CREDENTIALS_PASSWORD = Phrase.create("mysqlPane.credentials.password", "Password: **%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*  42 */   private static final Phrase ENCRYPTION_TITLE = Phrase.create("mysqlPane.encryption.title", "SSL");
/*  43 */   private static final Phrase ENCRYPTION_ACTION_ENABLE = Phrase.create("mysqlPane.encryption.enableAction", "**Click** to **enable** encryption", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*  44 */   private static final Phrase ENCRYPTION_ACTION_DISABLE = Phrase.create("mysqlPane.encryption.disableAction", "**Click** to **disable** encryption", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GREEN });
/*  45 */   private static final Phrase ENCRYPTION_SSL = Phrase.create("mysqlPane.encryption.ssl", "SSL: **%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*  47 */   private static final Phrase TEST_TITLE = Phrase.create("mysqlPane.test.title", "Test Changes");
/*  48 */   private static final Phrase TEST_ACTION = Phrase.create("mysqlPane.test.action", "Click to test **changes**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  49 */   private static final Phrase TEST_HOSTNAME = Phrase.create("mysqlPane.test.hostname", "Hostname: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  50 */   private static final Phrase TEST_PORT = Phrase.create("mysqlPane.test.port", "Port: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  51 */   private static final Phrase TEST_DATABASE = Phrase.create("mysqlPane.test.database", "Database: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  52 */   private static final Phrase TEST_USERNAME = Phrase.create("mysqlPane.test.username", "Username: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  53 */   private static final Phrase TEST_PASSWORD = Phrase.create("mysqlPane.test.password", "Password: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  54 */   private static final Phrase TEST_SSL = Phrase.create("mysqlPane.test.ssl", "SSL: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  55 */   private static final Phrase TEST_MINIMUM_IDLE = Phrase.create("mysqlPane.test.minimumIdle", "Minimum Idle: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  56 */   private static final Phrase TEST_MAXIMUM_POOL_SIZE = Phrase.create("mysqlPane.test.maximumPoolSize", "Maximum Pool Size: **%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*     */   
/*  58 */   private static final Phrase SAVE_TITLE = Phrase.create("mysqlPane.save.title", "Save");
/*  59 */   private static final Phrase SAVE_ACTION = Phrase.create("mysqlPane.save.action", "Click to **save** changes", Colors.GRAY, new Color[] { Colors.GREEN });
/*     */   
/*  61 */   private static final Phrase LOADING_TITLE = Phrase.create("mysqlPane.loading.title", "Testing Connection");
/*  62 */   private static final Phrase LOADING_DESC = Phrase.create("mysqlPane.loading.desc", "Please wait while the plugin runs all connection tests", Colors.GRAY, new Color[0]);
/*     */   
/*  64 */   private static final Phrase COULD_NOT_CONNECT_TITLE = Phrase.create("mysqlPane.couldNotConnect.title", "Could not connect");
/*  65 */   private static final Phrase COULD_NOT_CONNECT_DESC = Phrase.create("mysqlPane.couldNotConnect.desc", "Check if your settings are correct & if the database is accessible", Colors.GRAY, new Color[0]);
/*  66 */   private static final Phrase COULD_NOT_CONNECT_CONNECTION_ERROR = Phrase.create("mysqlPane.couldNotConnect.connectionError", "Connection Error:", Colors.GRAY, new Color[0]);
/*     */   
/*  68 */   private static final Phrase EVERYTHING_SAVED_TITLE = Phrase.create("mysqlPane.everythingSaved.title", "Everything Saved");
/*  69 */   private static final Phrase EVERYTHING_SAVED_DESC = Phrase.create("mysqlPane.everythingSaved.desc", "There are no changes to be saved", Colors.GRAY, new Color[0]);
/*     */   
/*  71 */   private static final Phrase CONNECTION_LIMITS_TITLE = Phrase.create("mysqlPane.connectionLimits.title", "Connection Limits");
/*  72 */   private static final Phrase CONNECTION_LIMITS_DESC = Phrase.create("mysqlPane.connectionLimits.desc", "Do not change these limits if you do not know what you are doing", Colors.GRAY, new Color[0]);
/*  73 */   private static final Phrase CONNECTION_LIMITS_INCREASE_ACTION = Phrase.create("mysqlPane.connectionLimits.increaseAction", "**Left Click** to **increase**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GREEN });
/*  74 */   private static final Phrase CONNECTION_LIMITS_DECREASE_ACTION = Phrase.create("mysqlPane.connectionLimits.decreaseAction", "**Right Click** to **decrease**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*  75 */   private static final Phrase CONNECTION_LIMITS_SWITCH_ACTION = Phrase.create("mysqlPane.connectionLimits.switchAction", "**Press Q** to switch option", Colors.GRAY, new Color[] { Colors.AQUA });
/*  76 */   private static final Phrase CONNECTION_LIMITS_SETTING_MINIMUM_IDLE_CONNECTIONS = Phrase.create("mysqlPane.connectionLimits.setting.minimumIdleConnections", "Minimum Idle Connections");
/*  77 */   private static final Phrase CONNECTION_LIMITS_SETTING_MAXIMUM_ACTIVE_CONNECTIONS = Phrase.create("mysqlPane.connectionLimits.setting.maximumActiveConnections", "Maximum Active Connections");
/*     */   
/*  79 */   private static final Phrase DISABLE_TITLE = Phrase.create("mysqlPane.disable.title", "Deactivate");
/*  80 */   private static final Phrase DISABLE_ACTION = Phrase.create("mysqlPane.disable.action", "Click to disable MySQL", Colors.GRAY, new Color[0]);
/*  81 */   private static final Phrase DISABLE_DESC = Phrase.create("mysqlPane.disable.desc", "You will be asked to restart to apply the changes");
/*     */   
/*  83 */   private static final Phrase SETUP_TITLE = Phrase.create("mysqlPane.setup.title", "Setup MySQL");
/*  84 */   private static final Phrase SETUP_ACTION = Phrase.create("mysqlPane.setup.action", "Click to enable MySQL", Colors.GRAY, new Color[0]);
/*  85 */   private static final Phrase SETUP_DESC = Phrase.create("mysqlPane.setup.desc", "This requires an external MySQL Database to connect to", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private final SpigotTechPlugin plugin;
/*     */   private final MySQLRegistry registry;
/*     */   private MySQLCredentials credentials;
/*     */   private boolean ssl;
/*     */   private int minimumIdle;
/*     */   private int maximumPoolSize;
/*     */   private boolean intro;
/*     */   private boolean loading;
/*     */   private int poolConfigurationNum;
/*     */   private SaveState state;
/*     */   private String error;
/*     */   
/*     */   public MySQLPane(Player paramPlayer, SettingsView paramSettingsView, SpigotTechPlugin paramSpigotTechPlugin) {
/* 100 */     super(paramPlayer, paramSettingsView);
/*     */     
/* 102 */     this.plugin = paramSpigotTechPlugin;
/* 103 */     this.registry = paramSpigotTechPlugin.getMySQLManager().getRegistry();
/*     */     
/* 105 */     this.credentials = this.registry.getCredentials();
/* 106 */     this.ssl = this.registry.hasSSL();
/* 107 */     this.minimumIdle = this.registry.getMinimumIdle();
/* 108 */     this.maximumPoolSize = this.registry.getMaximumPoolSize();
/*     */ 
/*     */     
/* 111 */     this.intro = (this.credentials == null);
/*     */     
/* 113 */     this.state = SaveState.SAVED;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 118 */     return NAME.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public XMaterial getIcon() {
/* 123 */     return XMaterial.ENDER_CHEST;
/*     */   }
/*     */ 
/*     */   
/*     */   public void construct(Model paramModel) {
/* 128 */     if (this.intro) {
/* 129 */       paramModel.button(23, this::StartSetupButton);
/*     */     } else {
/* 131 */       paramModel.button(20, this::CredentialsButton);
/* 132 */       paramModel.button(21, this::SSLButton);
/* 133 */       paramModel.button(22, this::ConnectionLimitsButton);
/*     */       
/* 135 */       boolean bool = this.plugin.getMySQLManager().isEnabled();
/* 136 */       paramModel.button(bool ? 25 : 26, this.loading ? this::LoadingButton : this::ActionButton);
/* 137 */       if (bool) paramModel.button(26, this::DisableButton); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void StartSetupButton(Button paramButton) {
/* 142 */     paramButton.material(XMaterial.EMERALD_BLOCK)
/* 143 */       .name(Animation.wave(SETUP_TITLE.get(), new Color[] { Colors.Gold, Colors.YELLOW
/* 144 */           })).lore(new String[] {
/* 145 */           SETUP_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */     
/* 149 */     paramButton.item().appendLore(SETUP_DESC.split(25));
/*     */     
/* 151 */     paramButton.action(paramActionType -> this.intro = false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void CredentialsButton(Button paramButton) {
/* 157 */     paramButton.material(XMaterial.PAPER)
/* 158 */       .name(Animation.wave(CREDENTIALS_TITLE.get(), new Color[] { Colors.Gold, Colors.YELLOW
/* 159 */           })).lore(new String[] {
/* 160 */           (this.credentials != null) ? CREDENTIALS_CLEAR_ACTION.get() : CREDENTIALS_ENTER_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 165 */     if (this.credentials != null) {
/* 166 */       String str1 = this.credentials.getHostname();
/* 167 */       String str2 = this.credentials.getPort();
/* 168 */       String str3 = this.credentials.getDatabase();
/* 169 */       String str4 = this.credentials.getUsername();
/* 170 */       String str5 = Tools.getSecretPassword(this.credentials.getPassword());
/*     */       
/* 172 */       paramButton.item().appendLore(new String[] { CREDENTIALS_CONNECTION_URL
/* 173 */             .get(), Colors.WHITE + str1 + ":" + str2 + "/" + str3, "", CREDENTIALS_USERNAME
/*     */ 
/*     */             
/* 176 */             .get().replace("%", str4), CREDENTIALS_PASSWORD
/* 177 */             .get().replace("%", str5), "" });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 182 */     paramButton.item().appendLore(new String[] { CREDENTIALS_DESC.get() });
/*     */     
/* 184 */     paramButton.action(paramActionType -> {
/*     */           if (this.credentials != null) {
/*     */             this.credentials = null;
/*     */             this.state = SaveState.UNSAVED_CHANGES;
/*     */           } else {
/*     */             final MySQLCredentials credentials = new MySQLCredentials("", "", "", "", "");
/*     */             new MySQLSetup(this.p, this.plugin)
/*     */               {
/*     */                 public void onClose()
/*     */                 {
/* 194 */                   MySQLPane.this.reopen();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void onCompletion() {
/* 199 */                   MySQLPane.this.credentials = credentials;
/* 200 */                   MySQLPane.this.state = MySQLPane.SaveState.UNSAVED_CHANGES;
/* 201 */                   MySQLPane.this.reopen();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public SetupStage[] getStages() {
/* 206 */                   return new SetupStage[] { new SetupStage(
/* 207 */                         MySQLPane.access$500().firstUpper(), "localhost", this.val$credentials::setHostname), new SetupStage(
/* 208 */                         MySQLPane.access$600().firstUpper(), "3306", this.val$credentials::setPort), new SetupStage(
/* 209 */                         MySQLPane.access$700().firstUpper(), "database", this.val$credentials::setDatabase), new SetupStage(
/* 210 */                         MySQLPane.access$800().firstUpper(), "root", this.val$credentials::setUsername), new SetupStage(
/* 211 */                         MySQLPane.access$900().firstUpper(), "yourpassword", this.val$credentials::setPassword) };
/*     */                 }
/*     */               };
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private void SSLButton(Button paramButton) {
/* 220 */     paramButton.material(XMaterial.REPEATER)
/* 221 */       .name(Animation.wave(ENCRYPTION_TITLE.get(), new Color[] { Colors.Gold, Colors.YELLOW
/* 222 */           })).lore(new String[] {
/* 223 */           (this.ssl ? ENCRYPTION_ACTION_DISABLE : ENCRYPTION_ACTION_ENABLE).get(), "", ENCRYPTION_SSL
/*     */           
/* 225 */           .get().replace("%", (this.ssl ? Words.ENABLED : Words.DISABLED).get())
/*     */         });
/*     */     
/* 228 */     paramButton.action(paramActionType -> {
/*     */           this.ssl = !this.ssl;
/*     */           this.state = SaveState.UNSAVED_CHANGES;
/*     */         });
/*     */   }
/*     */   
/*     */   private void ConnectionLimitsButton(Button paramButton) {
/*     */     class PoolSetting
/*     */     {
/*     */       private final String name;
/*     */       private final Getter<Integer> getValue;
/*     */       private final Setter<Integer> setValue;
/*     */       
/*     */       PoolSetting(String param1String, Getter<Integer> param1Getter, Setter<Integer> param1Setter) {
/* 242 */         this.name = param1String;
/* 243 */         this.getValue = param1Getter;
/* 244 */         this.setValue = param1Setter;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */     
/* 250 */     PoolSetting[] arrayOfPoolSetting = { new PoolSetting(CONNECTION_LIMITS_SETTING_MINIMUM_IDLE_CONNECTIONS.get(), () -> Integer.valueOf(this.minimumIdle), paramInteger -> this.minimumIdle = paramInteger.intValue()), new PoolSetting(this, CONNECTION_LIMITS_SETTING_MAXIMUM_ACTIVE_CONNECTIONS.get(), () -> Integer.valueOf(this.maximumPoolSize), paramInteger -> this.maximumPoolSize = paramInteger.intValue()) };
/*     */ 
/*     */     
/* 253 */     PoolSetting poolSetting = arrayOfPoolSetting[this.poolConfigurationNum];
/*     */     
/* 255 */     paramButton.material(XMaterial.WATER_BUCKET)
/* 256 */       .name(Animation.wave(CONNECTION_LIMITS_TITLE.get(), new Color[] { Colors.Gold, Colors.YELLOW
/* 257 */           })).lore(new String[] {
/* 258 */           CONNECTION_LIMITS_INCREASE_ACTION.get(), CONNECTION_LIMITS_DECREASE_ACTION
/* 259 */           .get(), CONNECTION_LIMITS_SWITCH_ACTION
/* 260 */           .get(), ""
/*     */         });
/*     */ 
/*     */     
/* 264 */     for (PoolSetting poolSetting1 : arrayOfPoolSetting) {
/* 265 */       if (poolSetting1.equals(poolSetting)) {
/* 266 */         paramButton.item().appendLore(new String[] { Colors.GREEN + "§l> " + Colors.WHITE + PoolSetting.access$000(poolSetting1) + ": " + Colors.YELLOW + PoolSetting.access$100(poolSetting1).get() });
/*     */       } else {
/* 268 */         paramButton.item().appendLore(new String[] { Colors.GRAY + " " + PoolSetting.access$000(poolSetting1) + ": " + Colors.YELLOW + PoolSetting.access$100(poolSetting1).get() });
/*     */       } 
/*     */     } 
/*     */     
/* 272 */     paramButton.item().appendLore(new String[] { "" });
/* 273 */     paramButton.item().appendLore(CONNECTION_LIMITS_DESC.split(45));
/*     */     
/* 275 */     paramButton.action(ActionType.LEFT, () -> {
/*     */           PoolSetting.access$200(paramPoolSetting).set(Integer.valueOf(((Integer)PoolSetting.access$100(paramPoolSetting).get()).intValue() + 1));
/*     */           
/*     */           this.state = SaveState.UNSAVED_CHANGES;
/*     */         });
/* 280 */     paramButton.action(ActionType.RIGHT, () -> {
/*     */           PoolSetting.access$200(paramPoolSetting).set(Integer.valueOf((((Integer)PoolSetting.access$100(paramPoolSetting).get()).intValue() == 0) ? 0 : (((Integer)PoolSetting.access$100(paramPoolSetting).get()).intValue() - 1)));
/*     */           
/*     */           this.state = SaveState.UNSAVED_CHANGES;
/*     */         });
/* 285 */     paramButton.action(ActionType.Q, () -> {
/*     */           if (this.poolConfigurationNum < 1) {
/*     */             this.poolConfigurationNum++;
/*     */           } else {
/*     */             this.poolConfigurationNum = 0;
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   private void EverythingSavedButton(Button paramButton) {
/* 295 */     paramButton.material(XMaterial.STONE)
/* 296 */       .name(Animation.wave(EVERYTHING_SAVED_TITLE.get(), new Color[] { Colors.Gray, Colors.WHITE
/* 297 */           })).lore(new String[] { EVERYTHING_SAVED_DESC.get() });
/*     */   }
/*     */   
/*     */   private void TestChangesButton(Button paramButton) {
/* 301 */     String str1 = (this.credentials != null) ? this.credentials.getHostname() : "-";
/* 302 */     String str2 = (this.credentials != null) ? this.credentials.getPort() : "-";
/* 303 */     String str3 = (this.credentials != null) ? this.credentials.getDatabase() : "-";
/* 304 */     String str4 = (this.credentials != null) ? this.credentials.getUsername() : "-";
/* 305 */     String str5 = (this.credentials != null) ? Tools.getSecretPassword(this.credentials.getPassword()) : "-";
/*     */     
/* 307 */     paramButton.material(XMaterial.EMERALD_ORE)
/* 308 */       .name(Animation.wave(TEST_TITLE.get(), new Color[] { Colors.GREEN, Colors.WHITE
/* 309 */           })).lore(new String[] { 
/* 310 */           TEST_ACTION.get(), "", TEST_HOSTNAME
/*     */           
/* 312 */           .get().replace("%", str1), TEST_PORT
/* 313 */           .get().replace("%", str2), TEST_DATABASE
/* 314 */           .get().replace("%", str3), TEST_USERNAME
/* 315 */           .get().replace("%", str4), TEST_PASSWORD
/* 316 */           .get().replace("%", str5), "", TEST_SSL
/*     */           
/* 318 */           .get().replace("%", (this.ssl ? Words.ENABLED : Words.DISABLED).get()), "", TEST_MINIMUM_IDLE
/*     */           
/* 320 */           .get().replace("%", this.minimumIdle + ""), TEST_MAXIMUM_POOL_SIZE
/* 321 */           .get().replace("%", this.maximumPoolSize + "") });
/*     */ 
/*     */     
/* 324 */     paramButton.action(paramActionType -> this.plugin.getScheduler().runAsync(()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void SaveChangesButton(Button paramButton) {
/* 352 */     paramButton.material(XMaterial.EMERALD_BLOCK)
/* 353 */       .name(Animation.wave(SAVE_TITLE.get(), new Color[] { Colors.GREEN, Colors.WHITE
/* 354 */           })).lore(new String[] { SAVE_ACTION.get() });
/*     */     
/* 356 */     paramButton.action(paramActionType -> {
/*     */           this.registry.setCredentials(this.credentials);
/*     */           this.registry.setSSL(this.ssl);
/*     */           this.registry.setMinimumIdle(this.minimumIdle);
/*     */           this.registry.setMaximumPoolSize(this.maximumPoolSize);
/*     */           this.state = SaveState.SAVED;
/*     */         });
/*     */   }
/*     */   
/*     */   private void CouldNotConnectButton(Button paramButton) {
/* 366 */     paramButton.material(XMaterial.REDSTONE_BLOCK)
/* 367 */       .name(Animation.wave(COULD_NOT_CONNECT_TITLE.get(), new Color[] { Colors.RED, Colors.WHITE
/* 368 */           })).lore(new String[] {
/* 369 */           COULD_NOT_CONNECT_DESC.get(), "", COULD_NOT_CONNECT_CONNECTION_ERROR
/*     */           
/* 371 */           .get()
/*     */         });
/*     */     
/* 374 */     for (String str : Tools.lineSplitter(this.error, 60)) {
/* 375 */       paramButton.item().appendLore(new String[] { Colors.WHITE + str });
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ActionButton(Button paramButton) {
/* 380 */     switch (this.state) {
/*     */       case SAVED:
/* 382 */         EverythingSavedButton(paramButton);
/*     */         break;
/*     */       case UNSAVED_CHANGES:
/* 385 */         TestChangesButton(paramButton);
/*     */         break;
/*     */       case CORRECT_UNSAVED_CHANGES:
/* 388 */         SaveChangesButton(paramButton);
/*     */         break;
/*     */       case INVALID_UNSAVED_CHANGES:
/* 391 */         CouldNotConnectButton(paramButton);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void LoadingButton(Button paramButton) {
/* 397 */     paramButton.material(XMaterial.EXPERIENCE_BOTTLE)
/* 398 */       .name(Animation.fading(LOADING_TITLE.get(), true, 3, 6, new Color[] { Colors.YELLOW, Colors.WHITE
/* 399 */           })).lore(new String[] { LOADING_DESC.get() });
/*     */   }
/*     */   
/*     */   private void DisableButton(Button paramButton) {
/* 403 */     paramButton.material(XMaterial.RED_STAINED_GLASS)
/* 404 */       .name(Animation.wave(DISABLE_TITLE.get(), new Color[] { Colors.RED, Colors.WHITE
/* 405 */           })).lore(new String[] {
/* 406 */           DISABLE_ACTION.get(), ""
/*     */         });
/*     */ 
/*     */     
/* 410 */     paramButton.item().appendLore(new String[] { DISABLE_DESC.get() });
/*     */     
/* 412 */     paramButton.action(paramActionType -> {
/*     */           this.credentials = null;
/*     */           this.registry.clearCredentials();
/*     */           this.state = SaveState.SAVED;
/*     */           new RestartView(this.p, this.plugin);
/*     */         });
/*     */   }
/*     */   
/*     */   public enum SaveState
/*     */   {
/* 422 */     SAVED, UNSAVED_CHANGES, CORRECT_UNSAVED_CHANGES, INVALID_UNSAVED_CHANGES;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/settings/mysqlpane/MySQLPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */