/*     */ package me.TechsCode.UltraPermissions.storage.objects;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.StorageController;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.SkinTexture;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Stored;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ import me.TechsCode.UltraPermissions.storage.PermissionCreator;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.RankupList;
/*     */ 
/*     */ public class User extends Storable implements PermissionHolder {
/*     */   private StorageController controller;
/*     */   private UUID uuid;
/*     */   private String playerName;
/*     */   private boolean superadmin;
/*     */   
/*     */   public User(UUID paramUUID, String paramString1, boolean paramBoolean, Map<Stored<Group>, Long> paramMap, String paramString2, String paramString3, SkinTexture paramSkinTexture) {
/*  31 */     this.uuid = paramUUID;
/*  32 */     this.playerName = paramString1;
/*  33 */     this.superadmin = paramBoolean;
/*  34 */     this.rankups = paramMap;
/*  35 */     this.prefix = paramString2;
/*  36 */     this.suffix = paramString3;
/*  37 */     this.skinTexture = paramSkinTexture;
/*     */   }
/*     */   private Map<Stored<Group>, Long> rankups; private String prefix; private String suffix; private SkinTexture skinTexture;
/*     */   public RankupList getRankups() {
/*  41 */     return ((RankupList)this.rankups.entrySet().stream()
/*  42 */       .map(paramEntry -> new UserRankup(this, (Stored<Group>)paramEntry.getKey(), ((Long)paramEntry.getValue()).longValue()))
/*  43 */       .collect(Collectors.toCollection(RankupList::new)))
/*  44 */       .bestToWorst();
/*     */   }
/*     */   
/*     */   public UUID getUuid() {
/*  48 */     return this.uuid;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  52 */     return this.playerName;
/*     */   }
/*     */   
/*     */   public void setPlayerName(String paramString) {
/*  56 */     this.playerName = paramString;
/*  57 */     sync();
/*     */   }
/*     */   
/*     */   public boolean isSuperadmin() {
/*  61 */     return this.superadmin;
/*     */   }
/*     */   
/*     */   public void setSuperadmin(boolean paramBoolean) {
/*  65 */     this.superadmin = paramBoolean;
/*  66 */     sync();
/*     */   }
/*     */   
/*     */   public void addGroup(Group paramGroup) {
/*  70 */     this.rankups.put(paramGroup.toStored(), Long.valueOf(0L));
/*  71 */     sync();
/*     */   }
/*     */   
/*     */   public void addGroup(Group paramGroup, long paramLong) {
/*  75 */     this.rankups.put(paramGroup.toStored(), Long.valueOf(paramLong));
/*  76 */     sync();
/*     */   }
/*     */   
/*     */   public long getGroupExpiry(Stored<Group> paramStored) {
/*  80 */     return ((Long)this.rankups.get(paramStored)).longValue();
/*     */   }
/*     */   
/*     */   public Set<Stored<Group>> getGroups() {
/*  84 */     return this.rankups.keySet();
/*     */   }
/*     */   
/*     */   public GroupList getActiveGroups() {
/*  88 */     return ((GroupList)this.rankups.keySet().stream()
/*  89 */       .map(paramStored -> (Group)paramStored.get().orElse(null))
/*  90 */       .filter(Objects::nonNull)
/*  91 */       .collect(Collectors.toCollection(GroupList::new))).bestToWorst();
/*     */   }
/*     */   
/*     */   public Optional<SkinTexture> getSkinTexture() {
/*  95 */     return Optional.ofNullable(this.skinTexture);
/*     */   }
/*     */   
/*     */   public void setSkinTexture(SkinTexture paramSkinTexture) {
/*  99 */     if (paramSkinTexture == null || (this.skinTexture != null && this.skinTexture.getUrl().equalsIgnoreCase(paramSkinTexture.getUrl())))
/*     */       return; 
/* 101 */     this.skinTexture = paramSkinTexture;
/* 102 */     sync();
/*     */   }
/*     */   
/*     */   public void removeGroup(Group paramGroup) {
/* 106 */     if (!this.rankups.containsKey(paramGroup.toStored()))
/*     */       return; 
/* 108 */     this.rankups.remove(paramGroup.toStored());
/* 109 */     sync();
/*     */   }
/*     */   
/*     */   public boolean hasPrefix() {
/* 113 */     return getPrefix().isPresent();
/*     */   }
/*     */   
/*     */   public Optional<String> getPrefix() {
/* 117 */     return Optional.ofNullable(this.prefix);
/*     */   }
/*     */   
/*     */   public boolean hasSuffix() {
/* 121 */     return getSuffix().isPresent();
/*     */   }
/*     */   
/*     */   public Optional<String> getSuffix() {
/* 125 */     return Optional.ofNullable(this.suffix);
/*     */   }
/*     */   
/*     */   public void setPrefix(String paramString) {
/* 129 */     this.prefix = (paramString != null) ? Text.color(paramString) : null;
/* 130 */     sync();
/*     */   }
/*     */   
/*     */   public void setSuffix(String paramString) {
/* 134 */     this.suffix = (paramString != null) ? Text.color(paramString) : null;
/* 135 */     sync();
/*     */   }
/*     */   
/*     */   public PermissionCreator newPermission(String paramString) {
/* 139 */     return this.controller.getPermissionStorage().newPermission(paramString, Holder.fromUser(this));
/*     */   }
/*     */   
/*     */   public PermissionList getPermissions() {
/* 143 */     return this.controller.getPermissionStorage().getPermissions().holder(new Holder[] { Holder.fromUser(this) });
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 148 */     getPermissions().forEach(Permission::remove);
/*     */     
/* 150 */     destroy();
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionList getAdditionalPermissions() {
/* 155 */     return this.controller.getPermissionStorage().getPermissions().holder(getActiveGroups().getWithRecursiveInherits().holders());
/*     */   }
/*     */   
/*     */   public User createCopy() {
/* 159 */     return new User(this.uuid, this.playerName, this.superadmin, this.rankups, this.prefix, this.suffix, this.skinTexture);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 164 */     return this.uuid.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKey(String paramString) {
/* 169 */     this.uuid = UUID.fromString(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonObject getState() {
/* 174 */     JsonObject jsonObject1 = new JsonObject();
/* 175 */     jsonObject1.addProperty("name", this.playerName);
/* 176 */     jsonObject1.addProperty("superadmin", Boolean.valueOf(this.superadmin));
/*     */     
/* 178 */     JsonObject jsonObject2 = new JsonObject();
/* 179 */     this.rankups.forEach((paramStored, paramLong) -> paramJsonObject.addProperty(paramStored.getKey(), paramLong));
/*     */ 
/*     */ 
/*     */     
/* 183 */     if (this.rankups.size() != 0) jsonObject1.add("groups", (JsonElement)jsonObject2);
/*     */     
/* 185 */     if (this.prefix != null) jsonObject1.addProperty("prefix", this.prefix); 
/* 186 */     if (this.suffix != null) jsonObject1.addProperty("suffix", this.suffix); 
/* 187 */     if (this.skinTexture != null) jsonObject1.addProperty("skull", this.skinTexture.toString());
/*     */     
/* 189 */     return jsonObject1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setState(JsonObject paramJsonObject, TechPlugin paramTechPlugin) {
/* 194 */     StorageController storageController = (StorageController)paramTechPlugin;
/*     */     
/* 196 */     this.playerName = paramJsonObject.get("name").getAsString();
/* 197 */     this.superadmin = paramJsonObject.get("superadmin").getAsBoolean();
/*     */     
/* 199 */     this.rankups = new HashMap<>();
/* 200 */     if (paramJsonObject.has("groups")) {
/* 201 */       paramJsonObject.get("groups").getAsJsonObject().entrySet().forEach(paramEntry -> this.rankups.put(new Stored((String)paramEntry.getKey(), paramStorageController::getGroupStorage), Long.valueOf(((JsonElement)paramEntry.getValue()).getAsLong())));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 206 */     this.prefix = paramJsonObject.has("prefix") ? Text.color(paramJsonObject.get("prefix").getAsString()) : null;
/* 207 */     this.suffix = paramJsonObject.has("suffix") ? Text.color(paramJsonObject.get("suffix").getAsString()) : null;
/*     */     
/* 209 */     this.skinTexture = (paramJsonObject.has("skull") && !paramJsonObject.get("skull").getAsString().contains("null:split:")) ? new SkinTexture(paramJsonObject.get("skull").getAsString()) : null;
/*     */   }
/*     */   
/*     */   public void onMount(TechPlugin paramTechPlugin) {
/* 213 */     this.controller = (StorageController)paramTechPlugin;
/*     */   }
/*     */   
/*     */   public void clean() {
/* 217 */     for (Stored stored : new ArrayList(this.rankups.keySet())) {
/* 218 */       if (!stored.isPresent()) {
/* 219 */         this.rankups.remove(stored);
/* 220 */         sync();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Stored<User> toStored() {
/* 226 */     return new Stored(getKey(), () -> this.storage);
/*     */   }
/*     */   
/*     */   public void _justDestroy() {
/* 230 */     destroy();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/objects/User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */