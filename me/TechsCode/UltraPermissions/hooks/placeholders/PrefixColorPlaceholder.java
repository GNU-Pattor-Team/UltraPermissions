/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class PrefixColorPlaceholder
/*    */   extends UpermsPlaceholder {
/*    */   public PrefixColorPlaceholder() {
/* 12 */     super("prefix_color", "Color of Player Prefix or Prefix of 1. Group");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 17 */     if (paramUser.getPrefix().isPresent()) {
/* 18 */       return ChatColor.getLastColors(paramUser.getPrefix().get());
/*    */     }
/*    */     
/* 21 */     if (paramArrayOfGroup.length != 0) {
/* 22 */       Group group = paramArrayOfGroup[0];
/*    */       
/* 24 */       return ChatColor.getLastColors(group.getPrefix().orElse(""));
/*    */     } 
/*    */     
/* 27 */     return ChatColor.WHITE.toString();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/PrefixColorPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */