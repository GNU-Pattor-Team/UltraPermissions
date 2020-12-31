/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SecondarySuffixPlaceholder
/*    */   extends UpermsPlaceholder {
/*    */   public SecondarySuffixPlaceholder() {
/* 11 */     super("secondarysuffix", "Suffix of 2. Group");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 16 */     if (paramArrayOfGroup.length >= 2 && paramArrayOfGroup[1].getSuffix().isPresent()) return paramArrayOfGroup[1].getSuffix().get();
/*    */     
/* 18 */     return "";
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/SecondarySuffixPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */