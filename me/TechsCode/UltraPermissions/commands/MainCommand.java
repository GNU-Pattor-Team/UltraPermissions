/*    */ package me.TechsCode.UltraPermissions.commands;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ import me.TechsCode.UltraPermissions.base.command.Arguments;
/*    */ import me.TechsCode.UltraPermissions.base.command.CommandNode;
/*    */ import me.TechsCode.UltraPermissions.base.command.EmptyReason;
/*    */ import me.TechsCode.UltraPermissions.base.command.Requirement;
/*    */ import me.TechsCode.UltraPermissions.base.command.arguments.SpecificArgument;
/*    */ import me.TechsCode.UltraPermissions.base.update.Updater;
/*    */ import me.TechsCode.UltraPermissions.gui.GroupView;
/*    */ import me.TechsCode.UltraPermissions.gui.MigrationView;
/*    */ import me.TechsCode.UltraPermissions.gui.Overview;
/*    */ import me.TechsCode.UltraPermissions.gui.UserView;
/*    */ import me.TechsCode.UltraPermissions.migration.MigrationAssistant;
/*    */ import me.TechsCode.UltraPermissions.migration.Migrations;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class MainCommand extends Command {
/*    */   public MainCommand(UltraPermissions paramUltraPermissions) {
/* 25 */     super((SpigotTechPlugin)paramUltraPermissions, "uperms", new String[0]);
/*    */     
/* 27 */     this.plugin = paramUltraPermissions;
/*    */   }
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public void define(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 32 */     paramCommandNode.require((Requirement)new PlayerRequirement((SpigotTechPlugin)this.plugin));
/* 33 */     paramCommandNode.require((Requirement)new SuperadminRequirement(this.plugin));
/*    */     
/* 35 */     paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.NO_MATCH), paramCommandNode -> paramCommandNode.action(()));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 53 */     paramCommandNode.newNode((Argument)new GroupArgument(this.plugin, EmptyReason.NO_MATCH), paramCommandNode -> paramCommandNode.action(()));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 71 */     paramCommandNode.action((paramCommandSender, paramPlayer, paramArguments) -> {
/*    */           if (Migrations.isAvailable()) {
/*    */             MigrationAssistant migrationAssistant = Migrations.getMigrationAssistant();
/*    */             new MigrationView(paramPlayer, this.plugin, migrationAssistant);
/*    */             return;
/*    */           } 
/*    */           Overview overview = new Overview(paramPlayer, this.plugin);
/*    */           Updater.suggestUpdateIfAvailable((SpigotTechPlugin)this.plugin, paramPlayer, "https://updates.techscode.de", (), false);
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isRegistered() {
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/commands/MainCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */