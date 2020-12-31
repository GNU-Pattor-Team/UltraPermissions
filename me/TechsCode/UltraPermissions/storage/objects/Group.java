/*     */ package me.TechsCode.UltraPermissions.storage.objects;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import me.TechsCode.UltraPermissions.StorageController;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Storage;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Stored;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ import me.TechsCode.UltraPermissions.storage.PermissionCreator;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.UserList;
/*     */ 
/*     */ public class Group extends Storable implements PermissionHolder {
/*     */   private StorageController controller;
/*     */   private int id;
/*     */   private String name;
/*     */   private String world;
/*     */   private String server;
/*     */   
/*     */   public Group(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, Set<Stored<Group>> paramSet, boolean paramBoolean, String paramString4, String paramString5, String paramString6) {
/*  33 */     this.id = paramInt1;
/*  34 */     this.name = paramString1;
/*  35 */     this.world = paramString2;
/*  36 */     this.server = paramString3;
/*  37 */     this.priority = paramInt2;
/*  38 */     this.inheritedGroups = paramSet;
/*  39 */     this.isDefault = paramBoolean;
/*  40 */     this.prefix = paramString4;
/*  41 */     this.suffix = paramString5;
/*  42 */     this.icon = paramString6;
/*     */   }
/*     */   private int priority; private Set<Stored<Group>> inheritedGroups; private boolean isDefault; private String prefix; private String suffix; private String icon;
/*     */   public List<UserRankup> getRankups() {
/*  46 */     return (List<UserRankup>)this.controller.getUserStorage().getUsers().stream()
/*  47 */       .flatMap(paramUser -> paramUser.getRankups().stream())
/*  48 */       .filter(paramUserRankup -> paramUserRankup.getGroup().equals(toStored()))
/*  49 */       .collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public String getName() {
/*  53 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String paramString) {
/*  57 */     this.name = paramString;
/*  58 */     sync();
/*     */   }
/*     */   
/*     */   public Optional<String> getWorld() {
/*  62 */     return Optional.ofNullable(this.world);
/*     */   }
/*     */   
/*     */   public void setWorld(String paramString) {
/*  66 */     this.world = paramString;
/*  67 */     sync();
/*     */   }
/*     */   public Optional<String> getServer() {
/*  70 */     return Optional.ofNullable(this.server);
/*     */   }
/*     */   public void setServer(String paramString) {
/*  73 */     this.server = paramString;
/*  74 */     sync();
/*     */   }
/*     */   
/*     */   public int getPriority() {
/*  78 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void setPriority(int paramInt) {
/*  82 */     this.priority = paramInt;
/*  83 */     sync();
/*     */   }
/*     */   
/*     */   public Set<Stored<Group>> getInheritedGroups() {
/*  87 */     return this.inheritedGroups;
/*     */   }
/*     */   
/*     */   public GroupList getActiveInheritedGroups() {
/*  91 */     return (GroupList)this.inheritedGroups.stream()
/*  92 */       .map(paramStored -> (Group)paramStored.get().orElse(null))
/*  93 */       .filter(Objects::nonNull)
/*  94 */       .collect(Collectors.toCollection(GroupList::new));
/*     */   }
/*     */   
/*     */   public void addInheritance(Group paramGroup) {
/*  98 */     this.inheritedGroups.add(paramGroup.toStored());
/*  99 */     sync();
/*     */   }
/*     */   public void removeInheritance(Group paramGroup) {
/* 102 */     this.inheritedGroups.remove(paramGroup.toStored());
/* 103 */     sync();
/*     */   }
/*     */   
/*     */   public boolean isDefault() {
/* 107 */     return this.isDefault;
/*     */   }
/*     */   
/*     */   public void setDefault(boolean paramBoolean) {
/* 111 */     this.isDefault = paramBoolean;
/* 112 */     sync();
/*     */   }
/*     */   
/*     */   public Optional<String> getPrefix() {
/* 116 */     return Optional.ofNullable(this.prefix);
/*     */   }
/*     */   
/*     */   public void setPrefix(String paramString) {
/* 120 */     this.prefix = (paramString != null) ? Text.color(paramString) : null;
/* 121 */     sync();
/*     */   }
/*     */   
/*     */   public Optional<String> getSuffix() {
/* 125 */     return Optional.ofNullable(this.suffix);
/*     */   }
/*     */   
/*     */   public void setSuffix(String paramString) {
/* 129 */     this.suffix = (paramString != null) ? Text.color(paramString) : null;
/* 130 */     sync();
/*     */   }
/*     */   
/*     */   public XMaterial getIcon() {
/* 134 */     return XMaterial.valueOf(this.icon);
/*     */   }
/*     */   
/*     */   public void setIcon(XMaterial paramXMaterial) {
/* 138 */     this.icon = paramXMaterial.name();
/* 139 */     sync();
/*     */   }
/*     */   
/*     */   public PermissionList getPermissions() {
/* 143 */     return this.controller.getPermissionStorage().getPermissions().holder(new Holder[] { Holder.fromGroup(this) });
/*     */   }
/*     */   
/*     */   public PermissionCreator newPermission(String paramString) {
/* 147 */     return this.controller.getPermissionStorage().newPermission(paramString, Holder.fromGroup(this));
/*     */   }
/*     */   
/*     */   public UserList getUsers() {
/* 151 */     return this.controller.getUserStorage().getUsers().usersInGroup(toStored());
/*     */   }
/*     */   
/*     */   public void remove() {
/* 155 */     this.controller.getGroupStorage().getGroups().forEach(paramGroup -> paramGroup.removeInheritance(this));
/* 156 */     getUsers().forEach(paramUser -> paramUser.removeGroup(this));
/* 157 */     getPermissions().forEach(Permission::remove);
/*     */     
/* 159 */     destroy();
/*     */   }
/*     */   
/*     */   public PermissionList getInheritedPermissions() {
/* 163 */     return this.controller.getPermissionStorage().getPermissions().holder(getActiveInheritedGroups().getWithRecursiveInherits().holders());
/*     */   }
/*     */ 
/*     */   
/*     */   public PermissionList getAdditionalPermissions() {
/* 168 */     return getInheritedPermissions();
/*     */   }
/*     */   
/*     */   public Group createCopy() {
/* 172 */     return new Group(this.id, this.name, this.world, this.server, this.priority, this.inheritedGroups, this.isDefault, this.prefix, this.suffix, this.icon);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 177 */     return this.id + "";
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKey(String paramString) {
/* 182 */     this.id = Integer.parseInt(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonObject getState() {
/* 187 */     JsonObject jsonObject = new JsonObject();
/* 188 */     jsonObject.addProperty("name", this.name);
/* 189 */     if (this.world != null) jsonObject.addProperty("world", this.world); 
/* 190 */     if (this.server != null) jsonObject.addProperty("serverId", this.server); 
/* 191 */     jsonObject.addProperty("priority", Integer.valueOf(this.priority));
/*     */     
/* 193 */     if (this.inheritedGroups.size() != 0) {
/* 194 */       String str = this.inheritedGroups.stream().map(Stored::getKey).collect(Collectors.joining(";"));
/* 195 */       jsonObject.addProperty("inherits", str);
/*     */     } 
/*     */     
/* 198 */     jsonObject.addProperty("default", Boolean.valueOf(this.isDefault));
/* 199 */     if (this.prefix != null) jsonObject.addProperty("prefix", this.prefix); 
/* 200 */     if (this.suffix != null) jsonObject.addProperty("suffix", this.suffix); 
/* 201 */     if (this.icon != null) jsonObject.addProperty("icon", this.icon);
/*     */     
/* 203 */     return jsonObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setState(JsonObject paramJsonObject, TechPlugin paramTechPlugin) {
/* 208 */     StorageController storageController = (StorageController)paramTechPlugin;
/*     */     
/* 210 */     this.name = paramJsonObject.get("name").getAsString();
/* 211 */     this.world = paramJsonObject.has("world") ? (paramJsonObject.get("world").isJsonNull() ? null : paramJsonObject.get("world").getAsString()) : null;
/* 212 */     this.server = paramJsonObject.has("serverId") ? (paramJsonObject.get("serverId").isJsonNull() ? null : paramJsonObject.get("serverId").getAsString()) : null;
/* 213 */     this.priority = paramJsonObject.get("priority").getAsInt();
/*     */     
/* 215 */     if (paramJsonObject.has("inherits")) {
/* 216 */       this
/*     */         
/* 218 */         .inheritedGroups = (Set<Stored<Group>>)Arrays.<String>stream(paramJsonObject.get("inherits").getAsString().split(";")).filter(paramString -> (paramString.length() != 0)).map(paramString -> new Stored(paramString, paramStorageController::getGroupStorage)).collect(Collectors.toSet());
/*     */     } else {
/* 220 */       this.inheritedGroups = new HashSet<>();
/*     */     } 
/*     */     
/* 223 */     this.isDefault = paramJsonObject.get("default").getAsBoolean();
/* 224 */     this.prefix = paramJsonObject.has("prefix") ? Text.color(paramJsonObject.get("prefix").getAsString()) : null;
/* 225 */     this.suffix = paramJsonObject.has("suffix") ? Text.color(paramJsonObject.get("suffix").getAsString()) : null;
/* 226 */     this.icon = paramJsonObject.get("icon").getAsString();
/*     */   }
/*     */   
/*     */   public void onMount(TechPlugin paramTechPlugin) {
/* 230 */     this.controller = (StorageController)paramTechPlugin;
/*     */   }
/*     */   
/*     */   public void clean() {
/* 234 */     for (Stored stored : new ArrayList(this.inheritedGroups)) {
/* 235 */       if (!stored.isPresent()) {
/* 236 */         this.inheritedGroups.remove(stored);
/* 237 */         sync();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public Stored<Group> toStored() {
/* 243 */     return new Stored(getKey(), () -> this.storage);
/*     */   }
/*     */   
/*     */   public void _justDestroy() {
/* 247 */     destroy();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/objects/Group.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */