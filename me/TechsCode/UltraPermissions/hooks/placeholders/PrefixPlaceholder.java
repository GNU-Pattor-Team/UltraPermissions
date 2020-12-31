/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class PrefixPlaceholder
/*    */   extends UpermsPlaceholder
/*    */ {
/*    */   public PrefixPlaceholder() {
/* 13 */     super("prefix", "Player Prefix or Prefix of 1. Group");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 18 */     if (paramUser.getPrefix().isPresent()) {
/* 19 */       return paramUser.getPrefix().get();
/*    */     }
/*    */     
/* 22 */     if (paramArrayOfGroup.length != 0) {
/* 23 */       Group group = paramArrayOfGroup[0];
/*    */       
/* 25 */       return group.getPrefix().orElse("");
/*    */     } 
/*    */     
/* 28 */     return "";
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/PrefixPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */