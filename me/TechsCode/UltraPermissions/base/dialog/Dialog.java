/*    */ package me.TechsCode.UltraPermissions.base.dialog;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.reflection.titleAndActionbar.ActionBar;
/*    */ import me.TechsCode.UltraPermissions.base.reflection.titleAndActionbar.Title;
/*    */ import me.TechsCode.UltraPermissions.base.scheduler.RecurringTask;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.EventPriority;
/*    */ import org.bukkit.event.HandlerList;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryOpenEvent;
/*    */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public abstract class Dialog implements Listener, Runnable {
/*    */   private final Player p;
/*    */   private final ActionBar actionBar;
/*    */   private String lastMainTitle;
/*    */   private String lastSubTitle;
/*    */   private final RecurringTask visualTask;
/*    */   
/*    */   public Dialog(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/* 26 */     this.p = paramPlayer;
/*    */     
/* 28 */     this.actionBar = new ActionBar(paramSpigotTechPlugin);
/*    */     
/* 30 */     paramSpigotTechPlugin.getScheduler().run(paramPlayer::closeInventory);
/*    */     
/* 32 */     this.visualTask = paramSpigotTechPlugin.getScheduler().runTaskTimer(this, 1L, 1L);
/*    */     
/* 34 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramSpigotTechPlugin.getBootstrap());
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void onClose(Player paramPlayer);
/*    */ 
/*    */   
/*    */   public abstract boolean onInput(String paramString);
/*    */   
/*    */   public abstract String getMainTitle();
/*    */   
/*    */   public abstract String getSubTitle();
/*    */   
/*    */   public abstract String getActionBar();
/*    */   
/*    */   public void run() {
/* 50 */     String str1 = getMainTitle();
/* 51 */     String str2 = getSubTitle();
/* 52 */     String str3 = getActionBar();
/*    */     
/* 54 */     if (this.lastMainTitle == null || this.lastSubTitle == null || !this.lastMainTitle.equals(str1) || !this.lastSubTitle.equals(str2)) {
/* 55 */       Title.sendTitle(this.p, Integer.valueOf(30), Integer.valueOf(6000), Integer.valueOf(0), str1, str2);
/*    */       
/* 57 */       this.lastMainTitle = str1;
/* 58 */       this.lastSubTitle = str2;
/*    */     } 
/*    */     
/* 61 */     if (str3 != null) {
/* 62 */       this.actionBar.sendActionBar(this.p, str3);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler(priority = EventPriority.LOWEST)
/*    */   public void onChat(AsyncPlayerChatEvent paramAsyncPlayerChatEvent) {
/* 68 */     if (paramAsyncPlayerChatEvent.getPlayer().equals(this.p)) {
/* 69 */       onInput(paramAsyncPlayerChatEvent.getMessage());
/* 70 */       paramAsyncPlayerChatEvent.setCancelled(true);
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void close(PlayerQuitEvent paramPlayerQuitEvent) {
/* 76 */     if (paramPlayerQuitEvent.getPlayer().equals(this.p)) {
/* 77 */       close(false);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void close(InventoryOpenEvent paramInventoryOpenEvent) {
/* 83 */     if (paramInventoryOpenEvent.getPlayer().equals(this.p)) {
/* 84 */       close(false);
/*    */     }
/*    */   }
/*    */   
/*    */   public void close(boolean paramBoolean) {
/* 89 */     HandlerList.unregisterAll(this);
/*    */     
/* 91 */     this.visualTask.stop();
/*    */     
/* 93 */     if (!paramBoolean) onClose(this.p);
/*    */ 
/*    */     
/* 96 */     Title.clearTitle(this.p);
/* 97 */     this.actionBar.sendActionBar(this.p, "");
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/dialog/Dialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */