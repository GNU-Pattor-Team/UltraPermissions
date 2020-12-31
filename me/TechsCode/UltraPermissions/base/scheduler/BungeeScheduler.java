/*    */ package me.TechsCode.UltraPermissions.base.scheduler;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ import net.md_5.bungee.api.scheduler.ScheduledTask;
/*    */ 
/*    */ public class BungeeScheduler
/*    */   implements Scheduler {
/*    */   private BungeeTechPlugin plugin;
/*    */   
/*    */   public BungeeScheduler(BungeeTechPlugin paramBungeeTechPlugin) {
/* 14 */     this.plugin = paramBungeeTechPlugin;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run(Runnable paramRunnable) {
/* 19 */     paramRunnable.run();
/*    */   }
/*    */ 
/*    */   
/*    */   public void runAsync(Runnable paramRunnable) {
/* 24 */     ProxyServer.getInstance().getScheduler().runAsync((Plugin)this.plugin.getBootstrap(), paramRunnable);
/*    */   }
/*    */ 
/*    */   
/*    */   public Task runTaskLater(Runnable paramRunnable, long paramLong) {
/* 29 */     final ScheduledTask t = ProxyServer.getInstance().getScheduler().schedule((Plugin)this.plugin.getBootstrap(), paramRunnable, paramLong * 1000L / 20L, TimeUnit.MILLISECONDS);
/*    */     
/* 31 */     return new Task()
/*    */       {
/*    */         public void cancel() {
/* 34 */           t.cancel();
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public RecurringTask runTaskTimer(final Runnable task, final long delay, final long period) {
/* 41 */     final ScheduledTask t = ProxyServer.getInstance().getScheduler().schedule((Plugin)this.plugin.getBootstrap(), task, delay * 1000L / 20L, period * 1000L / 20L, TimeUnit.MILLISECONDS);
/*    */     
/* 43 */     return new RecurringTask()
/*    */       {
/*    */         private boolean cancelled;
/*    */ 
/*    */         
/*    */         public void stop() {
/* 49 */           t.cancel();
/*    */           
/* 51 */           this.cancelled = true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void start() {
/* 56 */           if (this.cancelled) {
/* 57 */             BungeeScheduler.this.runTaskTimer(task, delay, period);
/*    */           }
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public Task runTaskLaterAsync(Runnable paramRunnable, long paramLong) {
/* 65 */     throw new UnsupportedOperationException("The method runTaskLaterAsync is not defined for BungeeCord");
/*    */   }
/*    */ 
/*    */   
/*    */   public RecurringTask runTaskTimerAsync(Runnable paramRunnable, long paramLong1, long paramLong2) {
/* 70 */     throw new UnsupportedOperationException("The method runTaskTimerAsync is not defined for BungeeCord");
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/scheduler/BungeeScheduler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */