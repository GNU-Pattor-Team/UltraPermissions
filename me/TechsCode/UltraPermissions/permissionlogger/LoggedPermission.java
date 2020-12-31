/*    */ package me.TechsCode.UltraPermissions.permissionlogger;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class LoggedPermission
/*    */ {
/*    */   private final Player p;
/*    */   private final String permission;
/*    */   private final boolean outcome;
/*    */   private final long time;
/*    */   private final String source;
/*    */   
/*    */   public LoggedPermission(Player paramPlayer, String paramString1, boolean paramBoolean, long paramLong, String paramString2) {
/* 14 */     this.p = paramPlayer;
/* 15 */     this.permission = paramString1;
/* 16 */     this.outcome = paramBoolean;
/* 17 */     this.time = paramLong;
/* 18 */     this.source = paramString2;
/*    */   }
/*    */   
/*    */   public Player getPlayer() {
/* 22 */     return this.p;
/*    */   }
/*    */   
/*    */   public String getPermission() {
/* 26 */     return this.permission;
/*    */   }
/*    */   
/*    */   public boolean getOutcome() {
/* 30 */     return this.outcome;
/*    */   }
/*    */   
/*    */   public String getSource() {
/* 34 */     return this.source;
/*    */   }
/*    */   
/*    */   public long getTime() {
/* 38 */     return this.time;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/permissionlogger/LoggedPermission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */