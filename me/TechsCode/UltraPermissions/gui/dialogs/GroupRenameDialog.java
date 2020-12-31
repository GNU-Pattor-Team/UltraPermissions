/*    */ package me.TechsCode.UltraPermissions.gui.dialogs;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class GroupRenameDialog extends UserInput {
/* 13 */   private static final Phrase TITLE = Phrase.create("groupRenameDialog.title", "Rename Group");
/* 14 */   private static final Phrase SUB_TITLE = Phrase.create("groupRenameDialog.subtitle", "Type in a new name for **%group%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */   
/*    */   private final Group group;
/*    */   
/*    */   public GroupRenameDialog(Player paramPlayer, UltraPermissions paramUltraPermissions, Group paramGroup) {
/* 19 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, TITLE.get(), SUB_TITLE.get().replace("%group%", paramGroup.getName()));
/*    */     
/* 21 */     this.group = paramGroup;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void reopen();
/*    */   
/*    */   public boolean onResult(String paramString) {
/* 28 */     this.group.setName(paramString.replace(" ", ""));
/* 29 */     reopen();
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClose(Player paramPlayer) {
/* 35 */     reopen();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/dialogs/GroupRenameDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */