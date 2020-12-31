/*    */ package me.TechsCode.UltraPermissions.base.dialog;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ 
/*    */ public abstract class UserInput
/*    */   extends Dialog {
/* 15 */   private static final Phrase LEFT_CLICK_CLOSE = Phrase.create("userInput.leftClickClose", "**Left Click** to close", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */   private final Player p;
/*    */   private final String mainTitle;
/*    */   private final String subTitle;
/*    */   private String actionbar;
/* 20 */   private long lastTimeMoved = 0L;
/*    */   
/*    */   public UserInput(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin, Object paramObject1, Object paramObject2) {
/* 23 */     super(paramPlayer, paramSpigotTechPlugin);
/*    */     
/* 25 */     this.p = paramPlayer;
/* 26 */     this.mainTitle = paramObject1.toString();
/* 27 */     this.subTitle = paramObject2.toString();
/*    */   }
/*    */   
/*    */   public UserInput(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin, Object paramObject1, Object paramObject2, Object paramObject3) {
/* 31 */     super(paramPlayer, paramSpigotTechPlugin);
/*    */     
/* 33 */     this.p = paramPlayer;
/* 34 */     this.mainTitle = paramObject1.toString();
/* 35 */     this.subTitle = paramObject2.toString();
/* 36 */     this.actionbar = paramObject3.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean onResult(String paramString);
/*    */   
/*    */   public boolean onInput(String paramString) {
/* 43 */     boolean bool = onResult(paramString);
/*    */     
/* 45 */     if (bool) close(true);
/*    */     
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void move(PlayerMoveEvent paramPlayerMoveEvent) {
/* 52 */     if (paramPlayerMoveEvent.getPlayer().equals(this.p)) {
/* 53 */       this.lastTimeMoved = System.currentTimeMillis();
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void close(PlayerInteractEvent paramPlayerInteractEvent) {
/* 59 */     if (paramPlayerInteractEvent.getPlayer().equals(this.p) && (
/* 60 */       paramPlayerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || paramPlayerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK)) {
/* 61 */       close(false);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean hasMoved() {
/* 67 */     return (this.lastTimeMoved != 0L && System.currentTimeMillis() - this.lastTimeMoved < 3000L);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMainTitle() {
/* 72 */     return this.mainTitle;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSubTitle() {
/* 77 */     return hasMoved() ? LEFT_CLICK_CLOSE.get() : this.subTitle;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getActionBar() {
/* 82 */     return this.actionbar;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/dialog/UserInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */