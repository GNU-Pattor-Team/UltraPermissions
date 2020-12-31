/*     */ package me.TechsCode.UltraPermissions.base.mysql;
/*     */ 
/*     */ import com.google.gson.JsonObject;
/*     */ import me.TechsCode.UltraPermissions.base.registry.RegistryStorable;
/*     */ 
/*     */ public class MySQLRegistry
/*     */   extends RegistryStorable
/*     */ {
/*     */   private String hostname;
/*     */   private String port;
/*     */   private String database;
/*     */   private String username;
/*     */   
/*     */   public MySQLRegistry() {
/*  15 */     super("mysql");
/*     */     
/*  17 */     this.hostname = "";
/*  18 */     this.port = "";
/*  19 */     this.database = "";
/*  20 */     this.username = "";
/*  21 */     this.password = "";
/*  22 */     this.ssl = false;
/*  23 */     this.minimumIdle = 10;
/*  24 */     this.maximumPoolSize = 10;
/*     */   }
/*     */   private String password; private boolean ssl; private int minimumIdle; private int maximumPoolSize;
/*     */   
/*     */   public void setState(JsonObject paramJsonObject) {
/*  29 */     this.hostname = paramJsonObject.get("hostname").getAsString();
/*  30 */     this.port = paramJsonObject.get("port").getAsString();
/*  31 */     this.database = paramJsonObject.get("database").getAsString();
/*  32 */     this.username = paramJsonObject.get("username").getAsString();
/*  33 */     this.password = paramJsonObject.get("password").getAsString();
/*  34 */     this.ssl = (paramJsonObject.has("ssl") && paramJsonObject.get("ssl").getAsBoolean());
/*  35 */     this.minimumIdle = paramJsonObject.has("minimumIdle") ? paramJsonObject.get("minimumIdle").getAsInt() : 10;
/*  36 */     this.maximumPoolSize = paramJsonObject.has("maximumPoolSize") ? paramJsonObject.get("maximumPoolSize").getAsInt() : 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonObject getState() {
/*  41 */     JsonObject jsonObject = new JsonObject();
/*  42 */     jsonObject.addProperty("hostname", this.hostname);
/*  43 */     jsonObject.addProperty("port", this.port);
/*  44 */     jsonObject.addProperty("database", this.database);
/*  45 */     jsonObject.addProperty("username", this.username);
/*  46 */     jsonObject.addProperty("password", this.password);
/*  47 */     jsonObject.addProperty("ssl", Boolean.valueOf(this.ssl));
/*  48 */     jsonObject.addProperty("minimumIdle", Integer.valueOf(this.minimumIdle));
/*  49 */     jsonObject.addProperty("maximumPoolSize", Integer.valueOf(this.maximumPoolSize));
/*  50 */     return jsonObject;
/*     */   }
/*     */   
/*     */   public void updateState(JsonObject paramJsonObject) {
/*  54 */     setState(paramJsonObject);
/*  55 */     sync();
/*     */   }
/*     */   
/*     */   public boolean hasCredentials() {
/*  59 */     return (!this.hostname.isEmpty() && !this.port.isEmpty() && !this.database.isEmpty() && !this.username.isEmpty() && !this.password.isEmpty());
/*     */   }
/*     */   
/*     */   public void setCredentials(MySQLCredentials paramMySQLCredentials) {
/*  63 */     if (paramMySQLCredentials == null) {
/*  64 */       clearCredentials();
/*     */       
/*     */       return;
/*     */     } 
/*  68 */     this.hostname = paramMySQLCredentials.getHostname();
/*  69 */     this.port = paramMySQLCredentials.getPort();
/*  70 */     this.database = paramMySQLCredentials.getDatabase();
/*  71 */     this.username = paramMySQLCredentials.getUsername();
/*  72 */     this.password = paramMySQLCredentials.getPassword();
/*  73 */     sync();
/*     */   }
/*     */   
/*     */   public void clearCredentials() {
/*  77 */     this.hostname = "";
/*  78 */     this.port = "";
/*  79 */     this.database = "";
/*  80 */     this.username = "";
/*  81 */     this.password = "";
/*  82 */     sync();
/*     */   }
/*     */   
/*     */   public MySQLCredentials getCredentials() {
/*  86 */     return hasCredentials() ? new MySQLCredentials(this.hostname, this.port, this.database, this.username, this.password) : null;
/*     */   }
/*     */   
/*     */   public boolean hasSSL() {
/*  90 */     return this.ssl;
/*     */   }
/*     */   
/*     */   public void setSSL(boolean paramBoolean) {
/*  94 */     this.ssl = paramBoolean;
/*  95 */     sync();
/*     */   }
/*     */   
/*     */   public int getMinimumIdle() {
/*  99 */     return this.minimumIdle;
/*     */   }
/*     */   
/*     */   public void setMinimumIdle(int paramInt) {
/* 103 */     this.minimumIdle = paramInt;
/* 104 */     sync();
/*     */   }
/*     */   
/*     */   public int getMaximumPoolSize() {
/* 108 */     return this.maximumPoolSize;
/*     */   }
/*     */   
/*     */   public void setMaximumPoolSize(int paramInt) {
/* 112 */     this.maximumPoolSize = paramInt;
/* 113 */     sync();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/mysql/MySQLRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */