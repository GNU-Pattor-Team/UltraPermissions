/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class RankTimerPlaceholder
/*    */   extends UpermsPlaceholder
/*    */ {
/*    */   public RankTimerPlaceholder() {
/* 14 */     super("rank_timer", "Rank Timer of next highest timed group");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 19 */     for (Group group : paramArrayOfGroup) {
/* 20 */       long l = paramUser.getGroupExpiry(group.toStored());
/*    */       
/* 22 */       if (l != 0L) {
/* 23 */         long l1 = l - System.currentTimeMillis();
/*    */         
/* 25 */         return Tools.getTimeString(l1, TimeUnit.MILLISECONDS);
/*    */       } 
/*    */     } 
/*    */     
/* 29 */     return "Permanent";
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/RankTimerPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */