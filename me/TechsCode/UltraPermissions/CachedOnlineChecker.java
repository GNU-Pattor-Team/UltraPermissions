/*    */ package me.TechsCode.UltraPermissions;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.UUID;
/*    */ import java.util.stream.Collectors;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CachedOnlineChecker
/*    */ {
/*    */   private Set<UUID> cache;
/*    */   
/*    */   public static CachedOnlineChecker scan() {
/* 15 */     return new CachedOnlineChecker((Set<UUID>)Bukkit.getOnlinePlayers().stream().map(OfflinePlayer::getUniqueId).collect(Collectors.toSet()));
/*    */   }
/*    */   
/*    */   private CachedOnlineChecker(Set<UUID> paramSet) {
/* 19 */     this.cache = paramSet;
/*    */   }
/*    */   
/*    */   public boolean isOnline(UUID paramUUID) {
/* 23 */     return this.cache.contains(paramUUID);
/*    */   }
/*    */   
/*    */   public boolean isOnline(Player paramPlayer) {
/* 27 */     return isOnline(paramPlayer.getUniqueId());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/CachedOnlineChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */