/*    */ package me.TechsCode.UltraPermissions.base.command.arguments;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ import me.TechsCode.UltraPermissions.base.command.EmptyReason;
/*    */ 
/*    */ public class AnyIntegerArgument
/*    */   extends Argument<Integer>
/*    */ {
/*    */   private String usage;
/*    */   private EmptyReason emptyReason;
/*    */   
/*    */   public AnyIntegerArgument(String paramString, EmptyReason paramEmptyReason) {
/* 16 */     this.usage = paramString;
/* 17 */     this.emptyReason = paramEmptyReason;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentValue<Integer> get(String paramString) {
/*    */     try {
/* 23 */       return ArgumentValue.of(paramString, Integer.valueOf(Integer.parseInt(paramString)));
/* 24 */     } catch (NumberFormatException numberFormatException) {
/* 25 */       return ArgumentValue.empty(paramString, this.emptyReason);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 31 */     return this.usage;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getTabCompletions() {
/* 36 */     return Collections.emptyList();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/arguments/AnyIntegerArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */