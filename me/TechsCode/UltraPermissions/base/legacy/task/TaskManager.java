/*    */ package me.TechsCode.UltraPermissions.base.legacy.task;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import org.bukkit.Bukkit;
/*    */ 
/*    */ 
/*    */ public class TaskManager
/*    */ {
/*    */   public TaskManager(SpigotTechPlugin paramSpigotTechPlugin) {
/* 10 */     for (UpdateTime updateTime : UpdateTime.values())
/* 11 */       paramSpigotTechPlugin.getScheduler().runTaskTimer(() -> Bukkit.getPluginManager().callEvent(new UpdateEvent(paramUpdateTime)), 0L, updateTime.getTime()); 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/task/TaskManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */