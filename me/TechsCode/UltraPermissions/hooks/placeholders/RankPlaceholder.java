/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class RankPlaceholder
/*    */   extends UpermsPlaceholder {
/*    */   public RankPlaceholder() {
/* 11 */     super("rank", "Group Name of 1. Group");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 16 */     if (paramArrayOfGroup.length == 0) return "";
/*    */     
/* 18 */     return paramArrayOfGroup[0].getName();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/RankPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */