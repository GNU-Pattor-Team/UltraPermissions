/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class AddBungeePermissionDialog
/*    */   extends UserInput {
/*    */   private final Player p;
/*    */   private final UltraPermissions plugin;
/*    */   private final PermissionHolder holder;
/* 17 */   private static final Phrase TITLE = Phrase.create("addBungeePermissionDialog.title", "Add Bungee Permission", Colors.AQUA, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/* 18 */   private static final Phrase SUBTITLE = Phrase.create("addBungeePermissionDialog.subtitle", "Type in a Permission via Chat", Colors.GRAY, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/*    */   
/*    */   public AddBungeePermissionDialog(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder) {
/* 21 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, TITLE, SUBTITLE);
/*    */     
/* 23 */     this.p = paramPlayer;
/* 24 */     this.plugin = paramUltraPermissions;
/* 25 */     this.holder = paramPermissionHolder;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onResult(String paramString) {
/* 30 */     String str = paramString.replace(" ", ".");
/*    */     
/* 32 */     this.holder.newPermission(str).setServer("BungeeCord").create();
/*    */     
/* 34 */     new FullPermissionListView(this.p, this.plugin, this.holder)
/*    */       {
/*    */         public void onBack() {
/* 37 */           AddBungeePermissionDialog.this.reopen();
/*    */         }
/*    */       };
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClose(Player paramPlayer) {
/* 46 */     reopen();
/*    */   }
/*    */   
/*    */   public abstract void reopen();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/AddBungeePermissionDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */