/*     */ package me.TechsCode.UltraPermissions.hooks.pluginHooks;
/*     */ 
/*     */ import com.nametagedit.plugin.NametagEdit;
/*     */ import java.util.Optional;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*     */ import me.TechsCode.UltraPermissions.events.group.GroupPrefixChangeEvent;
/*     */ import me.TechsCode.UltraPermissions.events.group.GroupSuffixChangeEvent;
/*     */ import me.TechsCode.UltraPermissions.events.user.UserPrefixChangeEvent;
/*     */ import me.TechsCode.UltraPermissions.events.user.UserSuffixChangeEvent;
/*     */ import me.TechsCode.UltraPermissions.hooks.placeholders.PrefixPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.hooks.placeholders.SuffixPlaceholder;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import me.TechsCode.UltraPermissions.visual.VisualRegistry;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public class NametagEditHook implements Listener {
/*     */   private final UltraPermissions plugin;
/*     */   private final NServer thisServer;
/*     */   
/*     */   public NametagEditHook(UltraPermissions paramUltraPermissions) {
/*  28 */     this.plugin = paramUltraPermissions;
/*  29 */     this.thisServer = paramUltraPermissions.getThisServer().orElse(null);
/*     */     
/*  31 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*     */     
/*  33 */     paramUltraPermissions.getScheduler().runTaskLater(() -> paramUltraPermissions.getUsers().stream().filter(()).forEach(()), 5L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isEnabled() {
/*  44 */     return ((VisualRegistry)this.plugin.getVisualRegistry().get()).isEditingNametags();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent paramPlayerJoinEvent) {
/*  49 */     if (!isEnabled())
/*     */       return; 
/*  51 */     Optional optional = this.plugin.getUserStorage().getUsers().uuid(paramPlayerJoinEvent.getPlayer().getUniqueId());
/*  52 */     if (!optional.isPresent())
/*     */       return; 
/*  54 */     this.plugin.getScheduler().runTaskLater(() -> { String str1 = color((new PrefixPlaceholder()).get(paramOptional.get(), this.thisServer)); String str2 = color((new SuffixPlaceholder()).get(paramOptional.get(), this.thisServer)); NametagEdit.getApi().setNametag(((User)paramOptional.get()).getName(), str1.equals("") ? "" : (str1 + " "), str2.equals("") ? "" : (" " + str2)); }5L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onUserPrefixChange(UserPrefixChangeEvent paramUserPrefixChangeEvent) {
/*  64 */     if (!isEnabled())
/*     */       return; 
/*  66 */     Optional<Player> optional = Optional.ofNullable(Bukkit.getPlayer(paramUserPrefixChangeEvent.getUser().getUuid()));
/*  67 */     String str = color((new PrefixPlaceholder()).get(paramUserPrefixChangeEvent.getUser(), this.thisServer));
/*     */     
/*  69 */     if (optional.isPresent()) NametagEdit.getApi().setPrefix(paramUserPrefixChangeEvent.getUser().getName(), str.equals("") ? "" : (str + " ")); 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onUserSuffixChange(UserSuffixChangeEvent paramUserSuffixChangeEvent) {
/*  74 */     if (!isEnabled())
/*     */       return; 
/*  76 */     Optional<Player> optional = Optional.ofNullable(Bukkit.getPlayer(paramUserSuffixChangeEvent.getUser().getUuid()));
/*  77 */     String str = color((new SuffixPlaceholder()).get(paramUserSuffixChangeEvent.getUser(), this.thisServer));
/*     */     
/*  79 */     if (optional.isPresent()) NametagEdit.getApi().setSuffix(paramUserSuffixChangeEvent.getUser().getName(), str.equals("") ? "" : (" " + str)); 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onGroupPrefixChange(GroupPrefixChangeEvent paramGroupPrefixChangeEvent) {
/*  84 */     if (!isEnabled())
/*     */       return; 
/*  86 */     paramGroupPrefixChangeEvent.getGroup().getUsers().forEach(paramUser -> Optional.<Player>ofNullable(Bukkit.getPlayer(paramUser.getUuid())).ifPresent(()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onGroupSuffixChange(GroupSuffixChangeEvent paramGroupSuffixChangeEvent) {
/*  95 */     if (!isEnabled())
/*     */       return; 
/*  97 */     paramGroupSuffixChangeEvent.getGroup().getUsers().forEach(paramUser -> Optional.<Player>ofNullable(Bukkit.getPlayer(paramUser.getUuid())).ifPresent(()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String color(String paramString) {
/* 105 */     return ChatColor.translateAlternateColorCodes('&', paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/pluginHooks/NametagEditHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */