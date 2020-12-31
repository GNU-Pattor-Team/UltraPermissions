/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SuffixPlaceholder
/*    */   extends UpermsPlaceholder {
/*    */   public SuffixPlaceholder() {
/* 11 */     super("suffix", "Player Suffix or Suffix of 1. Group");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 16 */     if (paramUser.getSuffix().isPresent()) {
/* 17 */       return paramUser.getSuffix().get();
/*    */     }
/*    */     
/* 20 */     if (paramArrayOfGroup.length != 0) {
/* 21 */       Group group = paramArrayOfGroup[0];
/*    */       
/* 23 */       return group.getSuffix().orElse("");
/*    */     } 
/*    */     
/* 26 */     return "";
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/SuffixPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */