/*     */ package me.TechsCode.UltraPermissions.base.storage;
/*     */ 
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.reflection.ClassInstanceCreator;
/*     */ import me.TechsCode.UltraPermissions.base.storage.syncing.SyncingAgent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Storage<STORABLE extends Storable>
/*     */ {
/*     */   protected TechPlugin<?> plugin;
/*     */   private final Class<? extends Storable> storable;
/*     */   private StorageImplementation implementation;
/*     */   private SyncingAgent syncingAgent;
/*     */   private Map<String, STORABLE> instances;
/*     */   
/*     */   public Storage(final TechPlugin<?> plugin, String paramString, final Class<? extends Storable> storable, Class<? extends StorageImplementation> paramClass1, boolean paramBoolean) {
/*  25 */     this.plugin = plugin;
/*  26 */     this.storable = storable;
/*     */     
/*     */     try {
/*  29 */       this.implementation = paramClass1.getConstructor(new Class[] { TechPlugin.class, String.class }).newInstance(new Object[] { plugin, paramString });
/*  30 */     } catch (InstantiationException|IllegalAccessException|NoSuchMethodException|java.lang.reflect.InvocationTargetException instantiationException) {
/*  31 */       instantiationException.printStackTrace();
/*     */       
/*     */       return;
/*     */     } 
/*  35 */     this.syncingAgent = (this.implementation.hasMultiServerSupport() && paramBoolean) ? plugin.getSyncingAgent() : (SyncingAgent)new SyncingAgent.EmptyAgent();
/*  36 */     this.syncingAgent.register(this);
/*     */     
/*  38 */     this.instances = new HashMap<>();
/*     */     
/*  40 */     this.implementation.read("*", new ReadCallback()
/*     */         {
/*     */           public void onSuccess(HashMap<String, JsonObject> param1HashMap) {
/*  43 */             Storage.this.createInstances(param1HashMap);
/*     */           }
/*     */ 
/*     */           
/*     */           public void onFailure(Exception param1Exception) {
/*  48 */             plugin.log("Could not retrieve data from Storage '" + storable.getName() + "' :");
/*  49 */             plugin.log(param1Exception.getMessage());
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void createInstances(Map<String, JsonObject> paramMap) {
/*  55 */     for (Map.Entry<String, JsonObject> entry : paramMap.entrySet()) {
/*  56 */       Storable storable = (Storable)ClassInstanceCreator.create(this.storable);
/*     */       
/*     */       try {
/*  59 */         storable.onMount(this.plugin);
/*  60 */         storable.setKey((String)entry.getKey());
/*  61 */         storable.setState((JsonObject)entry.getValue(), this.plugin);
/*  62 */         storable.setLastSyncedState((JsonObject)entry.getValue());
/*  63 */         storable.setStorage(this);
/*  64 */         onMount((STORABLE)storable);
/*     */         
/*  66 */         this.instances.put(storable.getKey(), (STORABLE)storable);
/*  67 */       } catch (Exception exception) {
/*  68 */         this.plugin.log(((JsonObject)entry.getValue()).toString());
/*  69 */         this.plugin.log("Error with Storage " + getModelName() + " with key " + (String)entry.getKey() + ":");
/*     */         
/*  71 */         throw exception;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void syncFromDatabase(final String key) {
/*  77 */     this.plugin.getScheduler().runAsync(() -> this.implementation.read(paramString, new ReadCallback()
/*     */           {
/*     */             public void onSuccess(HashMap<String, JsonObject> param1HashMap)
/*     */             {
/*  81 */               if (key.equalsIgnoreCase("*")) {
/*     */ 
/*     */                 
/*  84 */                 Map map1 = (Map)param1HashMap.entrySet().stream().filter(param1Entry -> !Storage.this.instances.containsKey(param1Entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
/*     */                 
/*  86 */                 Storage.this.createInstances(map1);
/*     */ 
/*     */ 
/*     */                 
/*  90 */                 Map map2 = (Map)param1HashMap.entrySet().stream().filter(param1Entry -> Storage.this.instances.containsKey(param1Entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
/*     */                 
/*  92 */                 for (Map.Entry entry : map2.entrySet()) {
/*  93 */                   Storable storable = (Storable)Storage.this.instances.get(entry.getKey());
/*     */                   
/*  95 */                   if (!storable.getState().toString().equalsIgnoreCase(((JsonObject)entry.getValue()).toString())) {
/*  96 */                     storable.setState((JsonObject)entry.getValue(), Storage.this.plugin);
/*  97 */                     storable.setLastSyncedState((JsonObject)entry.getValue());
/*     */                   } 
/*     */                 } 
/*     */ 
/*     */ 
/*     */                 
/* 103 */                 Map map3 = (Map)Storage.this.instances.entrySet().stream().filter(param1Entry -> !param1HashMap.containsKey(param1Entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
/*     */                 
/* 105 */                 for (Map.Entry entry : map3.entrySet()) {
/* 106 */                   Storage.this.instances.remove(entry.getKey());
/*     */                 }
/*     */               }
/* 109 */               else if (!param1HashMap.isEmpty() && !Storage.this.instances.containsKey(key)) {
/* 110 */                 Storage.this.createInstances(param1HashMap);
/*     */               
/*     */               }
/* 113 */               else if (!param1HashMap.isEmpty() && Storage.this.instances.containsKey(key)) {
/* 114 */                 ((Storable)Storage.this.instances.get(key)).setState(param1HashMap.get(key), Storage.this.plugin);
/* 115 */                 ((Storable)Storage.this.instances.get(key)).setLastSyncedState(param1HashMap.get(key));
/*     */               }
/* 117 */               else if (param1HashMap.isEmpty() && Storage.this.instances.containsKey(key)) {
/*     */                 
/* 119 */                 Storage.this.instances.remove(key);
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 124 */               Storage.this.onDataSynchronization();
/*     */             }
/*     */ 
/*     */             
/*     */             public void onFailure(Exception param1Exception) {
/* 129 */               Storage.this.plugin.log("Could not update Storage Instances of Storage '" + Storage.this.storable.getName() + "' :");
/* 130 */               Storage.this.plugin.log(param1Exception.getMessage());
/*     */             }
/*     */           }));
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<STORABLE> get() {
/* 137 */     return this.instances.values();
/*     */   }
/*     */   
/*     */   void update(final Storable storable, JsonObject paramJsonObject) {
/* 141 */     onChange((STORABLE)storable);
/*     */     
/* 143 */     this.implementation.update(storable.getKey(), paramJsonObject, new WriteCallback()
/*     */         {
/*     */           public void onSuccess() {
/* 146 */             Storage.this.syncingAgent.notifyNewDataChanges(Storage.this, storable.getKey());
/*     */           }
/*     */ 
/*     */           
/*     */           public void onFailure(Exception param1Exception) {
/* 151 */             Storage.this.plugin.log("Could not sync '" + storable.getKey() + "' of '" + Storage.this.storable.getName() + "' :");
/* 152 */             Storage.this.plugin.log("" + param1Exception.getMessage());
/* 153 */             Storage.this.plugin.log("Json Data:");
/* 154 */             Storage.this.plugin.log(storable.getState().toString());
/* 155 */             Storage.this.plugin.log("It is strongly advised to restart the Server!");
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   void destroy(final Storable storable) {
/* 161 */     this.instances.remove(storable.getKey());
/*     */     
/* 163 */     onDestroy((STORABLE)storable);
/*     */     
/* 165 */     this.implementation.destroy(storable.getKey(), new WriteCallback()
/*     */         {
/*     */           public void onSuccess() {
/* 168 */             Storage.this.syncingAgent.notifyNewDataChanges(Storage.this, storable.getKey());
/*     */           }
/*     */ 
/*     */           
/*     */           public void onFailure(Exception param1Exception) {
/* 173 */             Storage.this.plugin.log("Could not destroy '" + storable.getKey() + "' of '" + Storage.this.storable.getName() + "' :");
/* 174 */             Storage.this.plugin.log("" + param1Exception.getMessage());
/* 175 */             Storage.this.plugin.log("Json Data:");
/* 176 */             Storage.this.plugin.log(storable.getState().toString());
/* 177 */             Storage.this.plugin.log("It is strongly advised to restart the Server!");
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public STORABLE create(final STORABLE storable) {
/* 183 */     storable.onMount(this.plugin);
/* 184 */     storable.setStorage(this);
/* 185 */     onMount(storable);
/*     */     
/* 187 */     this.instances.put(storable.getKey(), storable);
/*     */     
/* 189 */     onCreation(storable);
/*     */     
/* 191 */     this.implementation.create(storable.getKey(), storable.getState(), new WriteCallback()
/*     */         {
/*     */           public void onSuccess() {
/* 194 */             Storage.this.syncingAgent.notifyNewDataChanges(Storage.this, storable.getKey());
/*     */           }
/*     */ 
/*     */           
/*     */           public void onFailure(Exception param1Exception) {
/* 199 */             Storage.this.plugin.log("Could not create '" + storable.getKey() + "' of '" + Storage.this.storable.getName() + "' :");
/* 200 */             Storage.this.plugin.log("" + param1Exception.getMessage());
/* 201 */             Storage.this.plugin.log("Json Data:");
/* 202 */             Storage.this.plugin.log(storable.getState().toString());
/* 203 */             Storage.this.plugin.log("It is strongly advised to restart the Server!");
/*     */           }
/*     */         });
/*     */     
/* 207 */     return storable;
/*     */   }
/*     */   
/*     */   public int getNextNumericId() {
/* 211 */     return this.instances.keySet().stream().mapToInt(Integer::parseInt).max().orElse(0) + 1;
/*     */   }
/*     */   
/*     */   public Class<? extends Storable> getModel() {
/* 215 */     return this.storable;
/*     */   }
/*     */   
/*     */   public String getModelName() {
/* 219 */     return getModel().getName();
/*     */   }
/*     */   
/*     */   public abstract void onMount(STORABLE paramSTORABLE);
/*     */   
/*     */   public abstract void onCreation(STORABLE paramSTORABLE);
/*     */   
/*     */   public abstract void onChange(STORABLE paramSTORABLE);
/*     */   
/*     */   public abstract void onDestroy(STORABLE paramSTORABLE);
/*     */   
/*     */   public abstract void onDataSynchronization();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/Storage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */