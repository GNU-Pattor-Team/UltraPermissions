/*   */ package me.TechsCode.UltraPermissions.base.messaging;
/*   */ 
/*   */ import com.google.gson.JsonObject;
/*   */ 
/*   */ public abstract class QueuedMessage
/*   */   extends Message {
/*   */   public QueuedMessage(String paramString, JsonObject paramJsonObject) {
/* 8 */     super(paramString, paramJsonObject);
/*   */   }
/*   */   
/*   */   public abstract void onSend();
/*   */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/messaging/QueuedMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */