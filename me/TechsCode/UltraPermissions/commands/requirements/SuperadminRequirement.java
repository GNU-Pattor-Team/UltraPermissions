/*    */ package me.TechsCode.UltraPermissions.commands.requirements;
/*    */ 
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.command.Requirement;
/*    */ import me.TechsCode.UltraPermissions.base.command.requirements.PermissionRequirement;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SuperadminRequirement
/*    */   implements Requirement
/*    */ {
/*    */   private UltraPermissions plugin;
/*    */   
/*    */   public SuperadminRequirement(UltraPermissions paramUltraPermissions) {
/* 17 */     this.plugin = paramUltraPermissions;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isMatching(CommandSender paramCommandSender, Player paramPlayer, List<String> paramList) {
/* 22 */     return (paramPlayer == null || ((Boolean)this.plugin.getUsers().uuid(paramPlayer.getUniqueId()).map(User::isSuperadmin).orElse(Boolean.valueOf(false))).booleanValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUnmatched(CommandSender paramCommandSender, Player paramPlayer) {
/* 27 */     paramCommandSender.sendMessage(this.plugin.getPrefix() + PermissionRequirement.NO_PERMISSION_MESSAGE);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/commands/requirements/SuperadminRequirement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */