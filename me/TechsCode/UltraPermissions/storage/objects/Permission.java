/*     */ package me.TechsCode.UltraPermissions.storage.objects;
/*     */ 
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*     */ import me.TechsCode.UltraPermissions.internal.Node;
/*     */ 
/*     */ 
/*     */ public class Permission
/*     */   extends Storable
/*     */ {
/*     */   private int id;
/*     */   private Holder holder;
/*     */   private String world;
/*     */   private String server;
/*     */   private String permission;
/*     */   private boolean positive;
/*     */   private long expiration;
/*     */   
/*     */   public Permission(int paramInt, Holder paramHolder, String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong) {
/*  22 */     this.id = paramInt;
/*  23 */     this.holder = paramHolder;
/*  24 */     this.world = paramString1;
/*  25 */     this.server = paramString2;
/*  26 */     this.permission = paramString3;
/*  27 */     this.positive = paramBoolean;
/*  28 */     this.expiration = paramLong;
/*     */   }
/*     */   
/*     */   public int getId() {
/*  32 */     return this.id;
/*     */   }
/*     */   
/*     */   public Optional<String> getServer() {
/*  36 */     return Optional.ofNullable(this.server);
/*     */   }
/*     */   
/*     */   public Optional<String> getWorld() {
/*  40 */     return Optional.ofNullable(this.world);
/*     */   }
/*     */   
/*     */   public Holder getHolder() {
/*  44 */     return this.holder;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  48 */     return this.permission;
/*     */   }
/*     */   
/*     */   public void setName(String paramString) {
/*  52 */     this.permission = paramString;
/*  53 */     sync();
/*     */   }
/*     */   
/*     */   public void setWorld(String paramString) {
/*  57 */     this.world = paramString;
/*  58 */     sync();
/*     */   }
/*     */   
/*     */   public void setServer(String paramString) {
/*  62 */     this.server = paramString;
/*  63 */     sync();
/*     */   }
/*     */   
/*     */   public String getDisplayName() {
/*  67 */     return (isPositive() ? "" : "-") + getName();
/*     */   }
/*     */   
/*     */   public boolean isPositive() {
/*  71 */     return this.positive;
/*     */   }
/*     */   
/*     */   public boolean isPermanent() {
/*  75 */     return (this.expiration != 0L);
/*     */   }
/*     */   
/*     */   public void setPositive(boolean paramBoolean) {
/*  79 */     this.positive = paramBoolean;
/*  80 */     sync();
/*     */   }
/*     */   
/*     */   public long getExpiration() {
/*  84 */     return this.expiration;
/*     */   }
/*     */   
/*     */   public void setExpiration(long paramLong) {
/*  88 */     this.expiration = paramLong;
/*  89 */     sync();
/*     */   }
/*     */   
/*     */   public void remove() {
/*  93 */     destroy();
/*     */   }
/*     */   
/*     */   public boolean isBungeePermission() {
/*  97 */     return (this.server != null && this.server.equals("BungeeCord"));
/*     */   }
/*     */   
/*     */   public boolean isExpired() {
/* 101 */     return (this.expiration != 0L && this.expiration < System.currentTimeMillis());
/*     */   }
/*     */   
/*     */   public void copyTo(PermissionHolder paramPermissionHolder) {
/* 105 */     paramPermissionHolder.newPermission(this.permission)
/* 106 */       .setServer(this.server)
/* 107 */       .setExpiration(this.expiration)
/* 108 */       .setWorld(this.world)
/* 109 */       .setPositive(this.positive)
/* 110 */       .create();
/*     */   }
/*     */   
/*     */   public Node asNode() {
/* 114 */     return new Node(this.permission);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 119 */     if (!(paramObject instanceof Permission)) return false;
/*     */     
/* 121 */     Permission permission = (Permission)paramObject;
/* 122 */     return (permission.id == this.id);
/*     */   }
/*     */   
/*     */   public Permission createCopy() {
/* 126 */     return new Permission(this.id, this.holder, this.world, this.server, this.permission, this.positive, this.expiration);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 131 */     return this.id + "";
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKey(String paramString) {
/* 136 */     this.id = Integer.parseInt(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonObject getState() {
/* 141 */     JsonObject jsonObject = new JsonObject();
/* 142 */     jsonObject.addProperty("holder", this.holder.toStored().getKey());
/* 143 */     if (this.world != null) jsonObject.addProperty("world", this.world); 
/* 144 */     if (this.server != null) jsonObject.addProperty("serverId", this.server); 
/* 145 */     jsonObject.addProperty("permission", this.permission);
/* 146 */     jsonObject.addProperty("positive", Boolean.valueOf(this.positive));
/* 147 */     jsonObject.addProperty("expiry", Long.valueOf(this.expiration));
/* 148 */     return jsonObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setState(JsonObject paramJsonObject, TechPlugin<?> paramTechPlugin) {
/* 153 */     this.holder = Holder.fromKey(paramJsonObject.get("holder"), paramTechPlugin);
/* 154 */     this.world = paramJsonObject.has("world") ? paramJsonObject.get("world").getAsString() : null;
/* 155 */     this.server = (paramJsonObject.has("serverId") && !paramJsonObject.get("serverId").isJsonNull()) ? paramJsonObject.get("serverId").getAsString() : null;
/* 156 */     this.permission = paramJsonObject.get("permission").getAsString();
/* 157 */     this.positive = paramJsonObject.get("positive").getAsBoolean();
/* 158 */     this.expiration = paramJsonObject.get("expiry").getAsLong();
/*     */   }
/*     */   
/*     */   public void onMount(TechPlugin paramTechPlugin) {}
/*     */   
/*     */   public void _justDestroy() {
/* 164 */     destroy();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/objects/Permission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */