/*   */ package me.TechsCode.UltraPermissions.base.command;
/*   */ 
/*   */ import java.util.List;
/*   */ 
/*   */ public abstract class Argument<T>
/*   */ {
/*   */   public boolean hasMatch(String paramString) {
/* 8 */     return (get(paramString).getValidity() != Validity.NO_MATCH);
/*   */   }
/*   */   
/*   */   public abstract ArgumentValue<T> get(String paramString);
/*   */   
/*   */   public abstract String getUsage();
/*   */   
/*   */   public abstract List<String> getTabCompletions();
/*   */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/Argument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */