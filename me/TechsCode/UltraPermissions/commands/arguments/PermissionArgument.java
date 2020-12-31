/*    */ package me.TechsCode.UltraPermissions.commands.arguments;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ import me.TechsCode.UltraPermissions.permissionDatabase.PermissionInfo;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class PermissionArgument
/*    */   extends Argument<String>
/*    */ {
/*    */   private UltraPermissions plugin;
/*    */   
/*    */   public PermissionArgument(UltraPermissions paramUltraPermissions) {
/* 20 */     this.plugin = paramUltraPermissions;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentValue<String> get(String paramString) {
/* 25 */     return ArgumentValue.of(paramString, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 30 */     return "<Permission>";
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getTabCompletions() {
/* 35 */     List<String> list = (List)Arrays.<Plugin>stream(Bukkit.getPluginManager().getPlugins()).map(Plugin::getName).collect(Collectors.toList());
/* 36 */     list.add("Bukkit");
/*    */     
/* 38 */     return (List<String>)this.plugin.getPermissionDatabase().getAllPermissionInfos().plugins(list).stream()
/* 39 */       .map(PermissionInfo::getPermission).collect(Collectors.toList());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/commands/arguments/PermissionArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */