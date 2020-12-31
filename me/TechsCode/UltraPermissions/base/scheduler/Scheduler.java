package me.TechsCode.UltraPermissions.base.scheduler;

public interface Scheduler {
  void run(Runnable paramRunnable);
  
  void runAsync(Runnable paramRunnable);
  
  Task runTaskLater(Runnable paramRunnable, long paramLong);
  
  RecurringTask runTaskTimer(Runnable paramRunnable, long paramLong1, long paramLong2);
  
  Task runTaskLaterAsync(Runnable paramRunnable, long paramLong);
  
  RecurringTask runTaskTimerAsync(Runnable paramRunnable, long paramLong1, long paramLong2);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/scheduler/Scheduler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */