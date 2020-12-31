/*    */ package me.TechsCode.UltraPermissions.events;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ public abstract class UPEvent
/*    */   extends Event {
/* 10 */   private static final HandlerList HANDLERS = new HandlerList();
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 14 */     return HANDLERS;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 18 */     return HANDLERS;
/*    */   }
/*    */   
/*    */   public void call(TechPlugin paramTechPlugin, Event paramEvent) {
/* 22 */     paramTechPlugin.getScheduler().run(() -> Bukkit.getPluginManager().callEvent(paramEvent));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/events/UPEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */