/*    */ package me.TechsCode.UltraPermissions.commands.arguments;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ import me.TechsCode.UltraPermissions.base.command.EmptyReason;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ 
/*    */ public class GroupArgument
/*    */   extends Argument<Group>
/*    */ {
/*    */   private UltraPermissions plugin;
/*    */   private EmptyReason emptyReason;
/*    */   
/*    */   public GroupArgument(UltraPermissions paramUltraPermissions, EmptyReason paramEmptyReason) {
/* 19 */     this.plugin = paramUltraPermissions;
/* 20 */     this.emptyReason = paramEmptyReason;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentValue<Group> get(String paramString) {
/* 25 */     Optional optional = this.plugin.getGroups().name(paramString);
/*    */     
/* 27 */     return optional.map(paramGroup -> ArgumentValue.of(paramString, paramGroup)).orElseGet(() -> ArgumentValue.empty(paramString, this.emptyReason));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 32 */     return "<Group>";
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getTabCompletions() {
/* 37 */     return (List<String>)this.plugin.getGroups().stream().map(Group::getName).collect(Collectors.toList());
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/commands/arguments/GroupArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */