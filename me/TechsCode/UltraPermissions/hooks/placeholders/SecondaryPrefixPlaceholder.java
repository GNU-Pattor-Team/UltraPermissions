/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class SecondaryPrefixPlaceholder
/*    */   extends UpermsPlaceholder {
/*    */   public SecondaryPrefixPlaceholder() {
/* 11 */     super("secondaryprefix", "Prefix of 2. Group");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 16 */     if (paramArrayOfGroup.length >= 2 && paramArrayOfGroup[1].getPrefix().isPresent()) return paramArrayOfGroup[1].getPrefix().get();
/*    */     
/* 18 */     return "";
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/SecondaryPrefixPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */