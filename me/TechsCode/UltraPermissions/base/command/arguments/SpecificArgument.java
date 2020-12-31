/*    */ package me.TechsCode.UltraPermissions.base.command.arguments;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ import me.TechsCode.UltraPermissions.base.command.EmptyReason;
/*    */ 
/*    */ public class SpecificArgument
/*    */   extends Argument<String>
/*    */ {
/*    */   private String argument;
/*    */   
/*    */   public SpecificArgument(String paramString) {
/* 15 */     this.argument = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 20 */     return this.argument;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentValue<String> get(String paramString) {
/* 25 */     return this.argument.equalsIgnoreCase(paramString) ? ArgumentValue.of(paramString, this.argument) : ArgumentValue.empty(paramString, EmptyReason.NO_MATCH);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getTabCompletions() {
/* 30 */     return Collections.singletonList(this.argument);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/arguments/SpecificArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */