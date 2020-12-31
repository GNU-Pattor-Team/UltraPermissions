/*    */ package me.TechsCode.UltraPermissions.base.command.requirements;
/*    */ 
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.command.Requirement;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class PermissionRequirement
/*    */   implements Requirement {
/* 14 */   public static Phrase NO_PERMISSION_MESSAGE = Phrase.create("command.noPermission", "You don't have **access** to that command", Colors.GRAY, new Color[] { Colors.RED });
/*    */   
/*    */   private SpigotTechPlugin plugin;
/*    */   private String permission;
/*    */   
/*    */   public PermissionRequirement(SpigotTechPlugin paramSpigotTechPlugin, String paramString) {
/* 20 */     this.plugin = paramSpigotTechPlugin;
/* 21 */     this.permission = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isMatching(CommandSender paramCommandSender, Player paramPlayer, List<String> paramList) {
/* 26 */     return paramCommandSender.hasPermission(this.permission);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUnmatched(CommandSender paramCommandSender, Player paramPlayer) {
/* 31 */     paramPlayer.sendMessage(this.plugin.getPrefix() + NO_PERMISSION_MESSAGE);
/* 32 */     this.plugin.log("Player " + paramPlayer.getName() + " could not access a command because he does not have " + this.permission);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/requirements/PermissionRequirement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */