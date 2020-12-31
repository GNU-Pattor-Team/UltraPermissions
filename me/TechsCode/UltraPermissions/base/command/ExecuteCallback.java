/*    */ package me.TechsCode.UltraPermissions.base.command;
/*    */ 
/*    */ public class ExecuteCallback
/*    */ {
/*    */   private CommandNode<?, ?> lastNode;
/*    */   private ExecuteResult result;
/*    */   
/*    */   public ExecuteCallback(CommandNode<?, ?> paramCommandNode, ExecuteResult paramExecuteResult) {
/*  9 */     this.lastNode = paramCommandNode;
/* 10 */     this.result = paramExecuteResult;
/*    */   }
/*    */   
/*    */   public CommandNode<?, ?> getLastNode() {
/* 14 */     return this.lastNode;
/*    */   }
/*    */   
/*    */   public ExecuteResult getResult() {
/* 18 */     return this.result;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/ExecuteCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */