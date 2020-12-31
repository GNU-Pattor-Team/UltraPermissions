/*    */ package me.TechsCode.UltraPermissions.base.command.arguments;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ import me.TechsCode.UltraPermissions.base.command.EmptyReason;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class OnlinePlayerArgument
/*    */   extends Argument<Player> {
/*    */   private String usage;
/*    */   private EmptyReason emptyReason;
/*    */   
/*    */   public OnlinePlayerArgument(String paramString, EmptyReason paramEmptyReason) {
/* 18 */     this.usage = paramString;
/* 19 */     this.emptyReason = paramEmptyReason;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentValue<Player> get(String paramString) {
/* 24 */     Player player = Bukkit.getPlayer(paramString);
/*    */     
/* 26 */     return (player != null && player.isOnline()) ? ArgumentValue.of(paramString, player) : ArgumentValue.empty(paramString, this.emptyReason);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 31 */     return this.usage;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getTabCompletions() {
/* 36 */     return (List<String>)Bukkit.getOnlinePlayers().stream().map(OfflinePlayer::getName).collect(Collectors.toList());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/arguments/OnlinePlayerArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */