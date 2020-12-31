/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
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
/*    */ public abstract class SearchPermissionDialog extends UserInput {
/* 13 */   private static final Phrase TITLE = Phrase.create("searchPermissionDialog.title", "Search for Permission", Colors.AQUA, new Color[0]);
/* 14 */   private static final Phrase SUBTITLE = Phrase.create("searchPermissionDialog.subtitle", "Type in a **Search Term** in Chat to search", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */   
/*    */   private final Player p;
/*    */   private final UltraPermissions plugin;
/*    */   private final PermissionHolder holder;
/*    */   
/*    */   public SearchPermissionDialog(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder) {
/* 21 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, TITLE, SUBTITLE);
/*    */     
/* 23 */     this.p = paramPlayer;
/* 24 */     this.plugin = paramUltraPermissions;
/* 25 */     this.holder = paramPermissionHolder;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onResult(String paramString) {
/* 30 */     new SearchPermissionListView(this.p, this.plugin, this.holder, paramString)
/*    */       {
/*    */         public void onBack() {
/* 33 */           SearchPermissionDialog.this.reopen();
/*    */         }
/*    */       };
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClose(Player paramPlayer) {
/* 42 */     reopen();
/*    */   }
/*    */   
/*    */   public abstract void reopen();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/SearchPermissionDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */