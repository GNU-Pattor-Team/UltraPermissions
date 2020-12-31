/*    */ package me.TechsCode.UltraPermissions.gui.dialogs;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class PrefixChangeDialog extends UserInput {
/* 13 */   private static final Phrase MAIN_TITLE = Phrase.create("prefixDialog.title", "Edit Prefix", Colors.AQUA, new Color[0]);
/* 14 */   private static final Phrase SUB_TITLE = Phrase.create("prefixDialog.subtitle", "Type in a new prefix for **%holder%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 15 */   private static final Phrase ACTION_BAR = Phrase.create("prefixDialog.actionBar", "Type in **none** to clear the prefix", Colors.GRAY, new Color[] { Colors.RED });
/*    */   
/*    */   private final PermissionHolder holder;
/*    */   
/*    */   public PrefixChangeDialog(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder) {
/* 20 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, MAIN_TITLE.get(), SUB_TITLE.get().replace("%holder%", paramPermissionHolder.getName()), ACTION_BAR.get());
/*    */     
/* 22 */     this.holder = paramPermissionHolder;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void reopen();
/*    */   
/*    */   public void onClose(Player paramPlayer) {
/* 29 */     reopen();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onResult(String paramString) {
/* 34 */     this.holder.setPrefix(paramString.equalsIgnoreCase("none") ? null : paramString);
/* 35 */     reopen();
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/dialogs/PrefixChangeDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */