/*    */ package me.TechsCode.UltraPermissions.base.command.arguments;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ 
/*    */ public class AnyArgument
/*    */   extends Argument<String>
/*    */ {
/*    */   private String usage;
/*    */   
/*    */   public AnyArgument(String paramString) {
/* 14 */     this.usage = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 19 */     return this.usage;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentValue<String> get(String paramString) {
/* 24 */     return ArgumentValue.of(paramString, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getTabCompletions() {
/* 29 */     return Collections.emptyList();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/arguments/AnyArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */