/*     */ package me.TechsCode.UltraPermissions.base.update;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateEvent;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateTime;
/*     */ import me.TechsCode.UltraPermissions.base.misc.Callback;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.HandlerList;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ public class UpdateProcess implements Listener {
/*  21 */   private static final Phrase CLICK_TO_AUTHENTICATE = Phrase.create("update.clickToAuthenticate", "Click the link below to authenticate using **Discord**:", Colors.GRAY, new Color[] { Colors.AQUA });
/*  22 */   private static final Phrase YOU_NOT_VERIFIED = Phrase.create("update.youAreNotVerified", "You are not verified on our **Discord**", Colors.GRAY, new Color[] { Colors.AQUA });
/*  23 */   private static final Phrase YOU_NOT_OWN_PLUGIN = Phrase.create("update.youNotOwnPlugin", "You do not own this plugin. **Purchase it** to unlock this feature", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  24 */   private static final Phrase UPDATED_PLUGIN = Phrase.create("update.updatedPlugin", "Updated the plugin to **%**, reloading..", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  25 */   private static final Phrase SERVER_OFFLINE = Phrase.create("update.serverOffline", "There was an error communicating with our update Server", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private final SpigotTechPlugin plugin;
/*     */   private final Player p;
/*     */   private final String updateServer;
/*     */   private final String version;
/*     */   private final String uid;
/*     */   private final long start;
/*     */   private final Callback<CloseReason> callback;
/*     */   
/*     */   public UpdateProcess(SpigotTechPlugin paramSpigotTechPlugin, Player paramPlayer, String paramString1, String paramString2, Callback<CloseReason> paramCallback) {
/*  36 */     this.plugin = paramSpigotTechPlugin;
/*  37 */     this.p = paramPlayer;
/*  38 */     this.updateServer = paramString1;
/*  39 */     this.version = paramString2;
/*  40 */     this.uid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
/*  41 */     this.start = System.currentTimeMillis();
/*  42 */     this.callback = paramCallback;
/*     */     
/*  44 */     String str = paramString1 + "/authenticate?uid=" + this.uid;
/*     */     
/*  46 */     paramPlayer.sendMessage("");
/*  47 */     paramPlayer.sendMessage(paramSpigotTechPlugin.getPrefix() + CLICK_TO_AUTHENTICATE);
/*  48 */     paramPlayer.sendMessage(Colors.YELLOW + str);
/*  49 */     paramPlayer.sendMessage("");
/*     */     
/*  51 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramSpigotTechPlugin.getBootstrap());
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void check(UpdateEvent paramUpdateEvent) {
/*  56 */     if (paramUpdateEvent.getUpdateTime() != UpdateTime.SLOW) {
/*     */       return;
/*     */     }
/*     */     
/*  60 */     long l = System.currentTimeMillis() - this.start;
/*     */ 
/*     */     
/*  63 */     if (TimeUnit.MILLISECONDS.toMinutes(l) >= 15L) {
/*  64 */       close(CloseReason.TIME_OUT);
/*     */       
/*     */       return;
/*     */     } 
/*  68 */     UpdateResponse updateResponse = UpdateServer.requestAndPerform((TechPlugin<?>)this.plugin, this.updateServer, this.uid);
/*     */     
/*  70 */     switch (updateResponse.getType()) {
/*     */ 
/*     */       
/*     */       case NOT_VERIFIED:
/*  74 */         this.p.sendMessage(this.plugin.getPrefix() + YOU_NOT_VERIFIED);
/*  75 */         close(CloseReason.NO_REQUIREMENTS);
/*     */         break;
/*     */       case NOT_PURCHASED:
/*  78 */         this.p.sendMessage(this.plugin.getPrefix() + YOU_NOT_OWN_PLUGIN);
/*  79 */         close(CloseReason.NO_REQUIREMENTS);
/*     */         break;
/*     */       case SUCCESS:
/*  82 */         this.p.sendMessage(this.plugin.getPrefix() + UPDATED_PLUGIN.get().replace("%", this.version));
/*  83 */         this.plugin.getUpdateAgent().sendUpdateRequestToBungee(this.updateServer, this.uid, this.version);
/*  84 */         close(CloseReason.COMPLETE);
/*     */         break;
/*     */       case SERVER_OFFLINE:
/*  87 */         this.p.sendMessage(this.plugin.getPrefix() + SERVER_OFFLINE);
/*  88 */         close(CloseReason.SERVER_OFFLINE);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void leave(PlayerQuitEvent paramPlayerQuitEvent) {
/*  95 */     close(CloseReason.QUIT);
/*     */   }
/*     */   
/*     */   private void close(CloseReason paramCloseReason) {
/*  99 */     HandlerList.unregisterAll(this);
/*     */     
/* 101 */     this.callback.run(paramCloseReason);
/*     */   }
/*     */   
/*     */   enum CloseReason {
/* 105 */     QUIT, COMPLETE, NO_REQUIREMENTS, TIME_OUT, SERVER_OFFLINE;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/UpdateProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */