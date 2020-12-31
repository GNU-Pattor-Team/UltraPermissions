/*    */ package me.TechsCode.UltraPermissions.permissionlogger;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class PermissionLogger
/*    */   implements Listener {
/*    */   private ArrayList<LoggedPermission> list;
/*    */   
/*    */   public PermissionLogger(UltraPermissions paramUltraPermissions) {
/* 19 */     this.list = new ArrayList<>();
/*    */     
/* 21 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramUltraPermissions.getBootstrap());
/*    */   }
/*    */   
/*    */   public void log(Player paramPlayer, String paramString1, boolean paramBoolean, String paramString2) {
/* 25 */     LoggedPermission loggedPermission = new LoggedPermission(paramPlayer, paramString1, paramBoolean, System.currentTimeMillis(), paramString2);
/*    */     
/*    */     try {
/* 28 */       (new ArrayList(this.list)).stream().filter(paramLoggedPermission -> (paramLoggedPermission != null)).forEach(paramLoggedPermission2 -> {
/*    */             if (paramLoggedPermission2.getPermission().equals(paramLoggedPermission1.getPermission()) && paramLoggedPermission2.getPlayer().equals(paramLoggedPermission1.getPlayer())) {
/*    */               this.list.remove(paramLoggedPermission2);
/*    */             }
/*    */           });
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 37 */       if (this.list.size() > 500) {
/* 38 */         this.list.remove(0);
/*    */       }
/*    */       
/* 41 */       this.list.add(loggedPermission);
/* 42 */     } catch (Exception exception) {}
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public LoggedPermission[] getLoggedPermissions() {
/* 48 */     return (LoggedPermission[])Arrays.stream(this.list.toArray((Object[])new LoggedPermission[this.list.size()]))
/* 49 */       .filter(paramLoggedPermission -> (paramLoggedPermission != null))
/* 50 */       .sorted(Comparator.comparing(LoggedPermission::getTime, Comparator.reverseOrder()).thenComparing(LoggedPermission::getPermission))
/* 51 */       .toArray(paramInt -> new LoggedPermission[paramInt]);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void clear(PlayerQuitEvent paramPlayerQuitEvent) {
/*    */     try {
/* 57 */       for (LoggedPermission loggedPermission : new ArrayList(this.list)) {
/* 58 */         if (loggedPermission == null) {
/*    */           continue;
/*    */         }
/*    */         
/* 62 */         if (loggedPermission.getPlayer() == null) {
/*    */           continue;
/*    */         }
/*    */         
/* 66 */         if (loggedPermission.getPlayer().equals(paramPlayerQuitEvent.getPlayer())) {
/* 67 */           this.list.remove(loggedPermission);
/*    */         }
/*    */       } 
/* 70 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/permissionlogger/PermissionLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */