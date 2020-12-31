/*    */ package me.TechsCode.UltraPermissions.base.legacy.task;
/*    */ 
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ public class UpdateEvent
/*    */   extends Event
/*    */ {
/*    */   private UpdateTime time;
/* 10 */   private static final HandlerList handlers = new HandlerList();
/*    */   
/*    */   public UpdateEvent(UpdateTime paramUpdateTime) {
/* 13 */     this.time = paramUpdateTime;
/*    */   }
/* 15 */   public HandlerList getHandlers() { return handlers; } public static HandlerList getHandlerList() {
/* 16 */     return handlers;
/*    */   }
/*    */   public UpdateTime getUpdateTime() {
/* 19 */     return this.time;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/task/UpdateEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */