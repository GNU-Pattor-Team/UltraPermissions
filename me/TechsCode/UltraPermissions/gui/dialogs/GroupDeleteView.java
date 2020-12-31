/*    */ package me.TechsCode.UltraPermissions.gui.dialogs;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.views.ConfirmationView;
/*    */ import me.TechsCode.UltraPermissions.gui.GroupListView;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class GroupDeleteView
/*    */   extends ConfirmationView {
/* 14 */   private static final Phrase TITLE = Phrase.create("groupDeleteView.title", "Confirm deletion of %group%");
/*    */   
/*    */   private final UltraPermissions plugin;
/*    */   private final Group group;
/*    */   
/*    */   public GroupDeleteView(Player paramPlayer, UltraPermissions paramUltraPermissions, Group paramGroup) {
/* 20 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, TITLE.get().replace("%group%", paramGroup.getName()));
/*    */     
/* 22 */     this.plugin = paramUltraPermissions;
/* 23 */     this.group = paramGroup;
/*    */   }
/*    */ 
/*    */   
/*    */   public void choose(boolean paramBoolean) {
/* 28 */     if (paramBoolean) {
/* 29 */       this.group.remove();
/*    */       
/* 31 */       new GroupListView(this.p, this.plugin)
/*    */         {
/*    */           public void onBack() {
/* 34 */             GroupDeleteView.this.reopen();
/*    */           }
/*    */         };
/*    */     } else {
/* 38 */       reopen();
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract void reopen();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/dialogs/GroupDeleteView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */