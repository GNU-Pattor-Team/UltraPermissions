/*    */ package me.TechsCode.UltraPermissions.base.command.arguments;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.command.Argument;
/*    */ import me.TechsCode.UltraPermissions.base.command.ArgumentValue;
/*    */ import me.TechsCode.UltraPermissions.base.command.EmptyReason;
/*    */ 
/*    */ public class SpecificArguments
/*    */   extends Argument<String>
/*    */ {
/*    */   private final String[] arguments;
/*    */   
/*    */   public SpecificArguments(String[] paramArrayOfString) {
/* 15 */     this.arguments = paramArrayOfString;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentValue<String> get(String paramString) {
/* 20 */     return Arrays.<String>stream(this.arguments)
/* 21 */       .filter(paramString2 -> paramString2.equalsIgnoreCase(paramString1))
/* 22 */       .findFirst()
/* 23 */       .map(paramString2 -> ArgumentValue.of(paramString1, paramString2))
/* 24 */       .orElse(ArgumentValue.empty(paramString, EmptyReason.NO_MATCH));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 29 */     return "<" + String.join(" / ", (CharSequence[])this.arguments) + ">";
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getTabCompletions() {
/* 34 */     return Arrays.asList(this.arguments);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/arguments/SpecificArguments.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */