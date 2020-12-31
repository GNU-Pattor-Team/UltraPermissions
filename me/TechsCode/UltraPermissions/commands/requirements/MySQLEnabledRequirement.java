/*    */ package me.TechsCode.UltraPermissions.commands.requirements;
/*    */ 
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.command.Requirement;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class MySQLEnabledRequirement
/*    */   implements Requirement
/*    */ {
/*    */   private UltraPermissions plugin;
/*    */   
/*    */   public MySQLEnabledRequirement(UltraPermissions paramUltraPermissions) {
/* 17 */     this.plugin = paramUltraPermissions;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isMatching(CommandSender paramCommandSender, Player paramPlayer, List<String> paramList) {
/* 22 */     return this.plugin.getMySQLManager().isEnabled();
/*    */   }
/*    */   
/* 25 */   private static final Phrase MESSAGE = Phrase.create("mysqlEnabledRequirement.message", "Command not available if MySQL is not configured", Colors.GRAY, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/*    */ 
/*    */   
/*    */   public void onUnmatched(CommandSender paramCommandSender, Player paramPlayer) {
/* 29 */     paramCommandSender.sendMessage(this.plugin.getPrefix() + MESSAGE.get());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/commands/requirements/MySQLEnabledRequirement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */