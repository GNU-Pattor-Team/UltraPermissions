/*     */ package me.TechsCode.UltraPermissions.hooks.pluginHooks;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*     */ import me.TechsCode.UltraPermissions.hooks.placeholders.PrefixPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.hooks.placeholders.SuffixPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import net.milkbowl.vault.chat.Chat;
/*     */ import net.milkbowl.vault.permission.Permission;
/*     */ 
/*     */ public class VaultChatHook
/*     */   extends Chat {
/*     */   private final UltraPermissions plugin;
/*     */   private HashMap<String, String> prefixesCache;
/*     */   private HashMap<String, String> suffixesCache;
/*     */   
/*     */   public VaultChatHook(Permission paramPermission, UltraPermissions paramUltraPermissions) {
/*  22 */     super(paramPermission);
/*     */     
/*  24 */     this.plugin = paramUltraPermissions;
/*     */     
/*  26 */     loadInCache().run();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  31 */     return "UltraPermissions";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public void clearCache() {
/*  40 */     this.plugin.getScheduler().runAsync(loadInCache());
/*     */   }
/*     */   
/*     */   private Runnable loadInCache() {
/*  44 */     return () -> {
/*     */         this.prefixesCache = new HashMap<>();
/*     */         this.suffixesCache = new HashMap<>();
/*     */         NServer nServer = this.plugin.getThisServer().orElse(null);
/*     */         for (User user : this.plugin.getUsers()) {
/*     */           this.prefixesCache.put(user.getName(), (new PrefixPlaceholder()).get(user, nServer));
/*     */           this.suffixesCache.put(user.getName(), (new SuffixPlaceholder()).get(user, nServer));
/*     */         } 
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPlayerPrefix(String paramString1, String paramString2) {
/*  59 */     return this.prefixesCache.getOrDefault(paramString2, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPlayerPrefix(String paramString1, String paramString2, String paramString3) {
/*  64 */     Optional<User> optional = user(paramString2);
/*     */     
/*  66 */     optional.ifPresent(paramUser -> paramUser.setPrefix(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlayerSuffix(String paramString1, String paramString2) {
/*  71 */     return this.suffixesCache.getOrDefault(paramString2, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPlayerSuffix(String paramString1, String paramString2, String paramString3) {
/*  76 */     Optional<User> optional = user(paramString2);
/*     */     
/*  78 */     optional.ifPresent(paramUser -> paramUser.setSuffix(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupPrefix(String paramString1, String paramString2) {
/*  83 */     Optional<Group> optional = group(paramString2);
/*     */     
/*  85 */     return optional.<String>map(paramGroup -> (String)paramGroup.getPrefix().orElse(null)).orElse(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGroupPrefix(String paramString1, String paramString2, String paramString3) {
/*  90 */     Optional<Group> optional = group(paramString2);
/*     */     
/*  92 */     optional.ifPresent(paramGroup -> paramGroup.setPrefix(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupSuffix(String paramString1, String paramString2) {
/*  97 */     Optional<Group> optional = group(paramString2);
/*     */     
/*  99 */     return optional.<String>map(paramGroup -> (String)paramGroup.getSuffix().orElse(null)).orElse(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGroupSuffix(String paramString1, String paramString2, String paramString3) {
/* 104 */     Optional<Group> optional = group(paramString2);
/*     */     
/* 106 */     optional.ifPresent(paramGroup -> paramGroup.setSuffix(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPlayerInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 111 */     Optional<User> optional = user(paramString2);
/*     */     
/* 113 */     return ((Integer)optional.<Integer>map(paramUser -> Integer.valueOf(paramUser.getPermissions().name(paramString1).servers(true, new String[] {
/*     */               
/*     */               this.plugin.getThisServer().map(NServer::getName).orElse(null)
/*     */             
/*     */             }).worlds(true, new String[] {
/*     */               
/*     */               paramString2
/*     */ 
/*     */             
/* 122 */             }).stream().filter(Permission::isPositive).map(()).filter(()).mapToInt(()).max().orElse(paramInt))).orElse(Integer.valueOf(paramInt))).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private int convertOrDefault(String paramString, int paramInt) {
/*     */     try {
/* 128 */       return Integer.valueOf(paramString).intValue();
/* 129 */     } catch (NumberFormatException numberFormatException) {
/* 130 */       return paramInt;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlayerInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGroupInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 141 */     Optional<Group> optional = group(paramString2);
/*     */     
/* 143 */     return ((Integer)optional.<Integer>map(paramGroup -> Integer.valueOf(paramGroup.getPermissions().name(paramString1).servers(true, new String[] {
/*     */               
/*     */               this.plugin.getThisServer().map(NServer::getName).orElse(null)
/*     */             
/*     */             }).worlds(true, new String[] {
/*     */               
/*     */               paramString2
/*     */ 
/*     */             
/* 152 */             }).stream().filter(Permission::isPositive).map(()).filter(()).mapToInt(()).max().orElse(paramInt))).orElse(Integer.valueOf(paramInt))).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public double getPlayerInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble) {
/* 163 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlayerInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public double getGroupInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble) {
/* 173 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPlayerInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 183 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlayerInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getGroupInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/* 193 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPlayerInfoString(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 203 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlayerInfoString(String paramString1, String paramString2, String paramString3, String paramString4) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroupInfoString(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 213 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroupInfoString(String paramString1, String paramString2, String paramString3, String paramString4) {}
/*     */ 
/*     */   
/*     */   public Optional<User> user(String paramString) {
/* 222 */     return this.plugin.getUsers().name(paramString);
/*     */   }
/*     */   public Optional<Group> group(String paramString) {
/* 225 */     return this.plugin.getGroups().name(paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/pluginHooks/VaultChatHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */