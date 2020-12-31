/*    */ package me.TechsCode.UltraPermissions.gui.dialogs;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.views.MaterialPickerView;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class GroupChangeIconView extends MaterialPickerView {
/* 12 */   private static final Phrase TITLE = Phrase.create("groupChangeIconView.title", "%group% > Change Icon");
/*    */   
/*    */   private final Group group;
/*    */   
/*    */   public GroupChangeIconView(Player paramPlayer, UltraPermissions paramUltraPermissions, Group paramGroup) {
/* 17 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, TITLE.get().replace("%group%", paramGroup.getName()));
/*    */     
/* 19 */     this.group = paramGroup;
/*    */   }
/*    */ 
/*    */   
/*    */   public void choose(Player paramPlayer, XMaterial paramXMaterial) {
/* 24 */     this.group.setIcon(paramXMaterial);
/* 25 */     reopen();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onBack() {
/* 30 */     reopen();
/*    */   }
/*    */   
/*    */   public abstract void reopen();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/dialogs/GroupChangeIconView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */