/*    */ package me.TechsCode.UltraPermissions.base.command.requirements;
/*    */ 
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.command.Requirement;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class PlayerRequirement
/*    */   implements Requirement
/*    */ {
/* 14 */   private static Phrase NO_CONSOLE = Phrase.create("command.noConsole", "This command cannot be run through the console", Colors.GRAY, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/*    */   
/*    */   private SpigotTechPlugin plugin;
/*    */   
/*    */   public PlayerRequirement(SpigotTechPlugin paramSpigotTechPlugin) {
/* 19 */     this.plugin = paramSpigotTechPlugin;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isMatching(CommandSender paramCommandSender, Player paramPlayer, List<String> paramList) {
/* 24 */     return (paramPlayer != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUnmatched(CommandSender paramCommandSender, Player paramPlayer) {
/* 29 */     paramCommandSender.sendMessage(this.plugin.getPrefix() + NO_CONSOLE);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/requirements/PlayerRequirement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */