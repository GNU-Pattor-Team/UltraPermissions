/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Collection;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.UUID;
/*     */ import java.util.logging.Level;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import javax.net.ssl.HttpsURLConnection;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.RegisteredServiceProvider;
/*     */ import org.bukkit.plugin.ServicePriority;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ApiMetricsLite
/*     */ {
/*     */   private static final String PLUGINNAME = "ItemNBTAPI";
/*     */   public static final int B_STATS_VERSION = 1;
/*     */   public static final int NBT_BSTATS_VERSION = 1;
/*     */   private static final String URL = "https://bStats.org/submitData/bukkit";
/*     */   private boolean enabled;
/*     */   private static boolean logFailedRequests;
/*     */   private static boolean logSentData;
/*     */   private static boolean logResponseStatusText;
/*     */   private static String serverUUID;
/*     */   private Plugin plugin;
/*     */   
/*     */   public ApiMetricsLite() {
/*  73 */     for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
/*  74 */       this.plugin = plugin;
/*  75 */       if (this.plugin != null)
/*     */         break; 
/*     */     } 
/*  78 */     if (this.plugin == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  83 */     File file1 = new File(this.plugin.getDataFolder().getParentFile(), "bStats");
/*  84 */     File file2 = new File(file1, "config.yml");
/*  85 */     YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file2);
/*     */ 
/*     */     
/*  88 */     if (!yamlConfiguration.isSet("serverUuid")) {
/*     */ 
/*     */       
/*  91 */       yamlConfiguration.addDefault("enabled", Boolean.valueOf(true));
/*     */       
/*  93 */       yamlConfiguration.addDefault("serverUuid", UUID.randomUUID().toString());
/*     */       
/*  95 */       yamlConfiguration.addDefault("logFailedRequests", Boolean.valueOf(false));
/*     */       
/*  97 */       yamlConfiguration.addDefault("logSentData", Boolean.valueOf(false));
/*     */       
/*  99 */       yamlConfiguration.addDefault("logResponseStatusText", Boolean.valueOf(false));
/*     */ 
/*     */       
/* 102 */       yamlConfiguration.options().header("bStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https://bStats.org/ to learn more :)")
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 107 */         .copyDefaults(true);
/*     */       try {
/* 109 */         yamlConfiguration.save(file2);
/* 110 */       } catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */     
/* 114 */     serverUUID = yamlConfiguration.getString("serverUuid");
/* 115 */     logFailedRequests = yamlConfiguration.getBoolean("logFailedRequests", false);
/* 116 */     this.enabled = yamlConfiguration.getBoolean("enabled", true);
/* 117 */     logSentData = yamlConfiguration.getBoolean("logSentData", false);
/* 118 */     logResponseStatusText = yamlConfiguration.getBoolean("logResponseStatusText", false);
/* 119 */     if (this.enabled) {
/* 120 */       boolean bool1 = false;
/*     */       
/* 122 */       for (Class clazz : Bukkit.getServicesManager().getKnownServices()) {
/*     */         try {
/* 124 */           clazz.getField("NBT_BSTATS_VERSION");
/*     */           return;
/* 126 */         } catch (NoSuchFieldException noSuchFieldException) {
/*     */           try {
/* 128 */             clazz.getField("B_STATS_VERSION");
/* 129 */             bool1 = true;
/*     */             break;
/* 131 */           } catch (NoSuchFieldException noSuchFieldException1) {}
/*     */         } 
/* 133 */       }  boolean bool2 = bool1;
/*     */       
/* 135 */       if (Bukkit.isPrimaryThread()) {
/* 136 */         Bukkit.getServicesManager().register(ApiMetricsLite.class, this, this.plugin, ServicePriority.Normal);
/* 137 */         if (!bool2) {
/* 138 */           MinecraftVersion.logger.info("[NBTAPI] Using the plugin '" + this.plugin.getName() + "' to create a bStats instance!");
/*     */           
/* 140 */           startSubmitting();
/*     */         } 
/*     */       } else {
/* 143 */         Bukkit.getScheduler().runTask(this.plugin, () -> {
/*     */               Bukkit.getServicesManager().register(ApiMetricsLite.class, this, this.plugin, ServicePriority.Normal);
/*     */               if (!paramBoolean) {
/*     */                 MinecraftVersion.logger.info("[NBTAPI] Using the plugin '" + this.plugin.getName() + "' to create a bStats instance!");
/*     */                 startSubmitting();
/*     */               } 
/*     */             });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 161 */     return this.enabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void startSubmitting() {
/* 168 */     final Timer timer = new Timer(true);
/* 169 */     timer.scheduleAtFixedRate(new TimerTask()
/*     */         {
/*     */           public void run() {
/* 172 */             if (!ApiMetricsLite.this.plugin.isEnabled()) {
/* 173 */               timer.cancel();
/*     */               
/*     */               return;
/*     */             } 
/*     */             
/* 178 */             Bukkit.getScheduler().runTask(ApiMetricsLite.this.plugin, () -> ApiMetricsLite.this.submitData());
/*     */           }
/*     */         }300000L, 1800000L);
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
/*     */   public JsonObject getPluginData() {
/* 193 */     JsonObject jsonObject = new JsonObject();
/*     */     
/* 195 */     jsonObject.addProperty("pluginName", "ItemNBTAPI");
/* 196 */     jsonObject.addProperty("pluginVersion", "2.5.0");
/* 197 */     jsonObject.add("customCharts", (JsonElement)new JsonArray());
/*     */     
/* 199 */     return jsonObject;
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
/*     */   private JsonObject getServerData() {
/*     */     int i;
/*     */     try {
/* 213 */       Method method = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", new Class[0]);
/*     */ 
/*     */       
/* 216 */       i = method.getReturnType().equals(Collection.class) ? ((Collection)method.invoke(Bukkit.getServer(), new Object[0])).size() : ((Player[])method.invoke(Bukkit.getServer(), new Object[0])).length;
/* 217 */     } catch (Exception exception) {
/* 218 */       i = Bukkit.getOnlinePlayers().size();
/*     */     } 
/* 220 */     boolean bool = Bukkit.getOnlineMode() ? true : false;
/* 221 */     String str1 = Bukkit.getVersion();
/* 222 */     String str2 = Bukkit.getName();
/*     */ 
/*     */     
/* 225 */     String str3 = System.getProperty("java.version");
/* 226 */     String str4 = System.getProperty("os.name");
/* 227 */     String str5 = System.getProperty("os.arch");
/* 228 */     String str6 = System.getProperty("os.version");
/* 229 */     int j = Runtime.getRuntime().availableProcessors();
/*     */     
/* 231 */     JsonObject jsonObject = new JsonObject();
/*     */     
/* 233 */     jsonObject.addProperty("serverUUID", serverUUID);
/*     */     
/* 235 */     jsonObject.addProperty("playerAmount", Integer.valueOf(i));
/* 236 */     jsonObject.addProperty("onlineMode", Integer.valueOf(bool));
/* 237 */     jsonObject.addProperty("bukkitVersion", str1);
/* 238 */     jsonObject.addProperty("bukkitName", str2);
/*     */     
/* 240 */     jsonObject.addProperty("javaVersion", str3);
/* 241 */     jsonObject.addProperty("osName", str4);
/* 242 */     jsonObject.addProperty("osArch", str5);
/* 243 */     jsonObject.addProperty("osVersion", str6);
/* 244 */     jsonObject.addProperty("coreCount", Integer.valueOf(j));
/*     */     
/* 246 */     return jsonObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void submitData() {
/* 253 */     final JsonObject data = getServerData();
/*     */     
/* 255 */     JsonArray jsonArray = new JsonArray();
/*     */     
/* 257 */     for (Class clazz : Bukkit.getServicesManager().getKnownServices()) {
/*     */       try {
/* 259 */         clazz.getField("B_STATS_VERSION");
/*     */         
/* 261 */         for (RegisteredServiceProvider registeredServiceProvider : Bukkit.getServicesManager().getRegistrations(clazz)) {
/*     */           try {
/* 263 */             Object object = registeredServiceProvider.getService().getMethod("getPluginData", new Class[0]).invoke(registeredServiceProvider.getProvider(), new Object[0]);
/* 264 */             if (object instanceof JsonObject) {
/* 265 */               jsonArray.add((JsonElement)object); continue;
/*     */             } 
/*     */             try {
/* 268 */               Class<?> clazz1 = Class.forName("org.json.simple.JSONObject");
/* 269 */               if (object.getClass().isAssignableFrom(clazz1)) {
/* 270 */                 Method method = clazz1.getDeclaredMethod("toJSONString", new Class[0]);
/* 271 */                 method.setAccessible(true);
/* 272 */                 String str = (String)method.invoke(object, new Object[0]);
/* 273 */                 JsonObject jsonObject1 = (new JsonParser()).parse(str).getAsJsonObject();
/* 274 */                 jsonArray.add((JsonElement)jsonObject1);
/*     */               } 
/* 276 */             } catch (ClassNotFoundException classNotFoundException) {
/*     */               
/* 278 */               if (logFailedRequests) {
/* 279 */                 MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI][BSTATS] Encountered exception while posting request!", classNotFoundException);
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 286 */           catch (NullPointerException|NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException nullPointerException) {}
/*     */         }
/*     */       
/* 289 */       } catch (NoSuchFieldException noSuchFieldException) {}
/*     */     } 
/*     */     
/* 292 */     jsonObject.add("plugins", (JsonElement)jsonArray);
/*     */ 
/*     */     
/* 295 */     (new Thread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/* 300 */               ApiMetricsLite.sendData(ApiMetricsLite.this.plugin, data);
/* 301 */             } catch (Exception exception) {
/*     */               
/* 303 */               if (ApiMetricsLite.logFailedRequests) {
/* 304 */                 MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI][BSTATS] Could not submit plugin stats of " + ApiMetricsLite.this.plugin.getName(), exception);
/*     */               
/*     */               }
/*     */             }
/*     */           
/*     */           }
/* 310 */         })).start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void sendData(Plugin paramPlugin, JsonObject paramJsonObject) {
/* 321 */     if (paramJsonObject == null) {
/* 322 */       throw new IllegalArgumentException("Data cannot be null!");
/*     */     }
/* 324 */     if (Bukkit.isPrimaryThread()) {
/* 325 */       throw new IllegalAccessException("This method must not be called from the main thread!");
/*     */     }
/* 327 */     if (logSentData) {
/* 328 */       System.out.println("[NBTAPI][BSTATS] Sending data to bStats: " + paramJsonObject.toString());
/*     */     }
/*     */ 
/*     */     
/* 332 */     HttpsURLConnection httpsURLConnection = (HttpsURLConnection)(new URL("https://bStats.org/submitData/bukkit")).openConnection();
/*     */ 
/*     */     
/* 335 */     byte[] arrayOfByte = compress(paramJsonObject.toString());
/*     */ 
/*     */     
/* 338 */     httpsURLConnection.setRequestMethod("POST");
/* 339 */     httpsURLConnection.addRequestProperty("Accept", "application/json");
/* 340 */     httpsURLConnection.addRequestProperty("Connection", "close");
/* 341 */     httpsURLConnection.addRequestProperty("Content-Encoding", "gzip");
/* 342 */     httpsURLConnection.addRequestProperty("Content-Length", String.valueOf(arrayOfByte.length));
/* 343 */     httpsURLConnection.setRequestProperty("Content-Type", "application/json");
/* 344 */     httpsURLConnection.setRequestProperty("User-Agent", "MC-Server/1");
/*     */ 
/*     */     
/* 347 */     httpsURLConnection.setDoOutput(true);
/* 348 */     DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
/* 349 */     dataOutputStream.write(arrayOfByte);
/* 350 */     dataOutputStream.flush();
/* 351 */     dataOutputStream.close();
/*     */     
/* 353 */     InputStream inputStream = httpsURLConnection.getInputStream();
/* 354 */     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/*     */     
/* 356 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     String str;
/* 358 */     while ((str = bufferedReader.readLine()) != null) {
/* 359 */       stringBuilder.append(str);
/*     */     }
/* 361 */     bufferedReader.close();
/* 362 */     if (logResponseStatusText) {
/* 363 */       MinecraftVersion.logger.info("[NBTAPI][BSTATS] Sent data to bStats and received response: " + stringBuilder.toString());
/*     */     }
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
/*     */   private static byte[] compress(String paramString) {
/* 377 */     if (paramString == null) {
/* 378 */       return new byte[0];
/*     */     }
/* 380 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 381 */     GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
/* 382 */     gZIPOutputStream.write(paramString.getBytes(StandardCharsets.UTF_8));
/* 383 */     gZIPOutputStream.close();
/* 384 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/ApiMetricsLite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */