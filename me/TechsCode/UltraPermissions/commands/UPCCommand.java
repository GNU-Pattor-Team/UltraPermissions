/*     */ package me.TechsCode.UltraPermissions.commands;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*     */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*     */ import me.TechsCode.UltraPermissions.base.command.Arguments;
/*     */ import me.TechsCode.UltraPermissions.base.command.Command;
/*     */ import me.TechsCode.UltraPermissions.base.command.CommandNode;
/*     */ import me.TechsCode.UltraPermissions.base.command.EmptyReason;
/*     */ import me.TechsCode.UltraPermissions.base.command.Requirement;
/*     */ import me.TechsCode.UltraPermissions.base.command.arguments.AnyArgument;
/*     */ import me.TechsCode.UltraPermissions.base.command.arguments.SpecificArgument;
/*     */ import me.TechsCode.UltraPermissions.base.command.arguments.SpecificArguments;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.commands.arguments.GroupArgument;
/*     */ import me.TechsCode.UltraPermissions.commands.arguments.PermissionArgument;
/*     */ import me.TechsCode.UltraPermissions.commands.arguments.UserArgument;
/*     */ import me.TechsCode.UltraPermissions.commands.requirements.MySQLEnabledRequirement;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.GroupList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.UserList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*     */ import me.TechsCode.UltraPermissions.transfer.TransferAssistant;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class UPCCommand extends Command {
/*     */   public UPCCommand(UltraPermissions paramUltraPermissions) {
/*  35 */     super((SpigotTechPlugin)paramUltraPermissions, "upc", new String[0]);
/*     */     
/*  37 */     this.plugin = paramUltraPermissions;
/*     */   }
/*     */   private UltraPermissions plugin;
/*     */   
/*     */   public void define(CommandNode<String, SpecificArgument> paramCommandNode) {
/*  42 */     paramCommandNode.require((Requirement)new SuperadminRequirement(this.plugin));
/*     */     
/*  44 */     AddGroupCommand(paramCommandNode);
/*  45 */     AddGroupPermission(paramCommandNode);
/*  46 */     AddPlayerPermission(paramCommandNode);
/*  47 */     AddSuperAdmin(paramCommandNode);
/*  48 */     RemoveGroup(paramCommandNode);
/*  49 */     RemoveGroupPermission(paramCommandNode);
/*  50 */     RemovePlayerPermission(paramCommandNode);
/*  51 */     RemoveSuperAdmin(paramCommandNode);
/*  52 */     SetGroups(paramCommandNode);
/*  53 */     SetPlayerPrefix(paramCommandNode);
/*  54 */     SetPlayerSuffix(paramCommandNode);
/*  55 */     Transfer(paramCommandNode);
/*     */   }
/*     */   
/*  58 */   private static final Phrase PLAYER_ADD_GROUP = Phrase.create("command.playerAddGroup", "Added Group **%group%** to **%player%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.AQUA });
/*  59 */   private static final Phrase PLAYER_ADD_GROUP_TIMED = Phrase.create("command.playerAddGroupTimed", "Added Group **%group%** to **%player%** for **%time**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.AQUA, Colors.RED });
/*     */   
/*     */   private void AddGroupCommand(CommandNode<String, SpecificArgument> paramCommandNode) {
/*  62 */     paramCommandNode.newNode((Argument)new SpecificArgument("AddGroup"), paramCommandNode -> paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   private static final Phrase GROUP_ALREADY_HAS_PERMISSION = Phrase.create("command.groupAlreadyHasPermission", "The group **%group%** already has the permission **%permission%**", Colors.GRAY, new Color[] { Colors.GREEN, Colors.YELLOW });
/*  96 */   private static final Phrase GROUP_ADD_PERMISSION = Phrase.create("command.groupAddPermission", "Added permission **%permission%** to **%group%**", Colors.GRAY, new Color[] { Colors.GREEN, Colors.AQUA });
/*     */   
/*     */   private void AddGroupPermission(CommandNode<String, SpecificArgument> paramCommandNode) {
/*  99 */     paramCommandNode.newNode((Argument)new SpecificArgument("AddGroupPermission"), paramCommandNode -> paramCommandNode.newNode((Argument)new GroupArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   private static final Phrase PLAYER_ALREADY_HAS_PERMISSION = Phrase.create("command.playerAlreadyHasPermission", "The player **%player%** already has the permission **%permission%**", Colors.GRAY, new Color[] { Colors.GREEN, Colors.YELLOW });
/* 143 */   private static final Phrase PLAYER_ADD_PERMISSION = Phrase.create("command.playerAddPermission", "Added permission **%permission%** to **%player%**", Colors.GRAY, new Color[] { Colors.GREEN, Colors.AQUA });
/*     */   
/*     */   private void AddPlayerPermission(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 146 */     paramCommandNode.newNode((Argument)new SpecificArgument("AddPlayerPermission"), paramCommandNode -> paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 189 */   private static final Phrase PLAYER_ALREADY_SUPER_ADMIN = Phrase.create("command.playerAlreadySuperAdmin", "**%player%** is already a superadmin", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 190 */   private static final Phrase PLAYER_ADD_SUPER_ADMIN = Phrase.create("command.playerAddSuperAdmin", "Successfully added **%player%** as a superadmin", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void AddSuperAdmin(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 193 */     paramCommandNode.newNode((Argument)new SpecificArgument("AddSuperAdmin"), paramCommandNode -> paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 211 */   private static final Phrase PLAYER_REMOVE_GROUP = Phrase.create("command.playerRemoveGroup", "The player **%player%** is not in the group **%group%**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.YELLOW });
/* 212 */   private static final Phrase PLAYER_NOT_IN_GROUP = Phrase.create("command.playerNotInGroup", "The player **%player%** is not in the group **%group%**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.YELLOW });
/*     */   
/*     */   private void RemoveGroup(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 215 */     paramCommandNode.newNode((Argument)new SpecificArgument("RemoveGroup"), paramCommandNode -> paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 247 */   private static final Phrase REMOVE_PERMISSION_UNSUCCESSFUL = Phrase.create("command.groupRemovePermission.unsuccessful", "Did not find permission **%permission%** for **target**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.AQUA });
/* 248 */   private static final Phrase REMOVE_PERMISSION_SUCCESSFUL = Phrase.create("command.groupRemovePermission.successful", "Removed permission **%permission%** from **%target%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.AQUA });
/* 249 */   private static final Phrase REMOVE_PERMISSION_SUCCESSFUL_MULTI = Phrase.create("command.groupRemovePermission.successfulMultiple", "Removed **count** copies of **%permission%** from **%target%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.YELLOW, Colors.AQUA });
/*     */   
/*     */   private void RemoveGroupPermission(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 252 */     paramCommandNode.newNode((Argument)new SpecificArgument("RemoveGroupPermission"), paramCommandNode -> paramCommandNode.newNode((Argument)new GroupArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void RemovePlayerPermission(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 296 */     paramCommandNode.newNode((Argument)new SpecificArgument("RemovePlayerPermission"), paramCommandNode -> paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 339 */   private static final Phrase PLAYER_NOT_SUPER_ADMIN = Phrase.create("command.playerNotSuperAdmin", "**%player%** is not a superadmin", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 340 */   private static final Phrase PLAYER_REMOVE_SUPER_ADMIN = Phrase.create("command.playerRemoveSuperAdmin", "Successfully removed **%player%** from the superadmins", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private void RemoveSuperAdmin(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 343 */     paramCommandNode.newNode((Argument)new SpecificArgument("RemoveSuperAdmin"), paramCommandNode -> paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 361 */   private static final Phrase PLAYER_CLEARED_GROUPS = Phrase.create("command.playerClearedGroups", "Cleared all groups of **%player%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 362 */   private static final Phrase PLAYER_SET_GROUPS = Phrase.create("command.playerSetGroups", "Set the groups **%groups%** for **%player%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.AQUA });
/*     */   
/*     */   private void SetGroups(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 365 */     paramCommandNode.newNode((Argument)new SpecificArgument("SetGroups"), paramCommandNode -> paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 403 */   private static final Phrase PLAYER_SET_PREFIX_CLEAR_ALL = Phrase.create("command.playerSetPrefix.clearAll", "Successfully cleared **%count% prefixes**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 404 */   private static final Phrase PLAYER_SET_PREFIX_CLEAR = Phrase.create("command.playerSetPrefix.clear", "Cleared the prefix of **%user%**", Colors.GRAY, new Color[] { Colors.AQUA });
/* 405 */   private static final Phrase PLAYER_SET_PREFIX_SET = Phrase.create("command.playerSetPrefix.set", "Set the prefix of **%user%** to **%prefix%**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.WHITE });
/*     */   
/*     */   private void SetPlayerPrefix(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 408 */     paramCommandNode.newNode((Argument)new SpecificArgument("SetPlayerPrefix"), paramCommandNode -> {
/*     */           paramCommandNode.newNode((Argument)new SpecificArgument("clearAll"), ());
/*     */           paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ());
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 450 */   private static final Phrase PLAYER_SET_SUFFIX_CLEAR_ALL = Phrase.create("command.playerSetSuffix.clearAll", "Successfully cleared **%count% suffixes**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 451 */   private static final Phrase PLAYER_SET_SUFFIX_CLEAR = Phrase.create("command.playerSetSuffix.clear", "Cleared the suffix of **%user%**", Colors.GRAY, new Color[] { Colors.AQUA });
/* 452 */   private static final Phrase PLAYER_SET_SUFFIX_SET = Phrase.create("command.playerSetSuffix.set", "Set the suffix of **%user%** to **%suffix%**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.WHITE });
/*     */   
/*     */   private void SetPlayerSuffix(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 455 */     paramCommandNode.newNode((Argument)new SpecificArgument("SetPlayerSuffix"), paramCommandNode -> {
/*     */           paramCommandNode.newNode((Argument)new SpecificArgument("clearAll"), ());
/*     */           paramCommandNode.newNode((Argument)new UserArgument(this.plugin, EmptyReason.INVALID), ());
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 497 */   private static final Phrase TRANSFER_SOURCES_EQUAL = Phrase.create("command.transfer.sourcesEqual", "From and To should not be equal!", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private void Transfer(CommandNode<String, SpecificArgument> paramCommandNode) {
/* 500 */     paramCommandNode.newNode((Argument)new SpecificArgument("Transfer"), paramCommandNode -> {
/*     */           paramCommandNode.require((Requirement)new MySQLEnabledRequirement(this.plugin));
/*     */           paramCommandNode.newNode((Argument)new SpecificArguments(new String[] { "File", "MySQL" }, ), ());
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRegistered() {
/* 528 */     return true;
/*     */   }
/*     */   
/* 531 */   private static final Phrase NO_VALID_USER = Phrase.create("command.noValidUser", "Could not find the user **%user%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private boolean isValidUser(CommandSender paramCommandSender, ArgumentValue<User> paramArgumentValue) {
/* 534 */     if (!paramArgumentValue.isValid()) {
/* 535 */       paramCommandSender.sendMessage(this.plugin.getPrefix() + NO_VALID_USER.get().replace("%user%", paramArgumentValue.getRaw()));
/*     */     }
/*     */     
/* 538 */     return paramArgumentValue.isValid();
/*     */   }
/*     */   
/* 541 */   private static final Phrase NO_VALID_GROUP = Phrase.create("command.noValidGroup", "Could not find the group **%group%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*     */   
/*     */   private boolean isValidGroup(CommandSender paramCommandSender, ArgumentValue<Group> paramArgumentValue) {
/* 544 */     if (!paramArgumentValue.isValid()) {
/* 545 */       paramCommandSender.sendMessage(this.plugin.getPrefix() + NO_VALID_GROUP.get().replace("%group%", paramArgumentValue.getRaw()));
/*     */     }
/*     */     
/* 548 */     return paramArgumentValue.isValid();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/commands/UPCCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */