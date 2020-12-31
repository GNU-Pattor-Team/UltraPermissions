/*    */ package me.TechsCode.UltraPermissions.hooks.placeholders;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PrefixesPlaceholder
/*    */   extends UpermsPlaceholder
/*    */ {
/*    */   public PrefixesPlaceholder() {
/* 16 */     super("prefixes", "Replaced with player prefix & group prefixes");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup) {
/* 21 */     ArrayList<? extends CharSequence> arrayList = new ArrayList();
/*    */     
/* 23 */     if (paramUser.getPrefix().isPresent()) {
/* 24 */       arrayList.add(paramUser.getPrefix().get());
/*    */     }
/*    */     
/* 27 */     for (Group group : paramArrayOfGroup) {
/* 28 */       if (group.getPrefix().isPresent()) {
/* 29 */         arrayList.add(group.getPrefix().get());
/*    */       }
/*    */     } 
/*    */     
/* 33 */     return String.join(" ", arrayList);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/placeholders/PrefixesPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */