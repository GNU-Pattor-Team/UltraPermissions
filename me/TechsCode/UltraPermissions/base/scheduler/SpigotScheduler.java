/*    */ package me.TechsCode.UltraPermissions.base.scheduler;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitTask;
/*    */ 
/*    */ public class SpigotScheduler implements Scheduler {
/*    */   private SpigotTechPlugin plugin;
/*    */   
/*    */   public SpigotScheduler(SpigotTechPlugin paramSpigotTechPlugin) {
/* 12 */     this.plugin = paramSpigotTechPlugin;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run(Runnable paramRunnable) {
/* 17 */     Bukkit.getScheduler().runTask((Plugin)this.plugin.getBootstrap(), paramRunnable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void runAsync(Runnable paramRunnable) {
/* 22 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)this.plugin.getBootstrap(), paramRunnable);
/*    */   }
/*    */ 
/*    */   
/*    */   public Task runTaskLater(Runnable paramRunnable, long paramLong) {
/* 27 */     BukkitTask bukkitTask = Bukkit.getScheduler().runTaskLater((Plugin)this.plugin.getBootstrap(), paramRunnable, paramLong);
/*    */     
/* 29 */     return toGenericTask(bukkitTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public RecurringTask runTaskTimer(Runnable paramRunnable, long paramLong1, long paramLong2) {
/* 34 */     return toRecurringTask(() -> Bukkit.getScheduler().runTaskTimer((Plugin)this.plugin.getBootstrap(), paramRunnable, paramLong1, paramLong2));
/*    */   }
/*    */ 
/*    */   
/*    */   public Task runTaskLaterAsync(Runnable paramRunnable, long paramLong) {
/* 39 */     BukkitTask bukkitTask = Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin)this.plugin.getBootstrap(), paramRunnable, paramLong);
/*    */     
/* 41 */     return toGenericTask(bukkitTask);
/*    */   }
/*    */ 
/*    */   
/*    */   public RecurringTask runTaskTimerAsync(Runnable paramRunnable, long paramLong1, long paramLong2) {
/* 46 */     return toRecurringTask(() -> Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)this.plugin.getBootstrap(), paramRunnable, paramLong1, paramLong2));
/*    */   }
/*    */   
/*    */   private Task toGenericTask(final BukkitTask bukkitTask) {
/* 50 */     return new Task()
/*    */       {
/*    */         public void cancel() {
/* 53 */           bukkitTask.cancel();
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   private RecurringTask toRecurringTask(final TaskCreator creator) {
/* 59 */     return new RecurringTask() {
/* 60 */         private BukkitTask bukkitTask = creator.build();
/*    */ 
/*    */         
/*    */         public void stop() {
/* 64 */           if (this.bukkitTask != null) {
/* 65 */             this.bukkitTask.cancel();
/* 66 */             this.bukkitTask = null;
/*    */           } 
/*    */         }
/*    */ 
/*    */         
/*    */         public void start() {
/* 72 */           if (this.bukkitTask == null)
/* 73 */             this.bukkitTask = creator.build(); 
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   static interface TaskCreator {
/*    */     BukkitTask build();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/scheduler/SpigotScheduler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */