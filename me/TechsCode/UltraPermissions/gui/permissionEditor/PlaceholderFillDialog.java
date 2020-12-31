/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class PlaceholderFillDialog
/*    */ {
/*    */   private final Player p;
/*    */   
/*    */   public PlaceholderFillDialog(Player paramPlayer, UltraPermissions paramUltraPermissions, String paramString) {
/* 17 */     this.p = paramPlayer;
/* 18 */     this.plugin = paramUltraPermissions;
/* 19 */     this.permission = paramString;
/*    */     
/* 21 */     run();
/*    */   }
/*    */   
/*    */   private final UltraPermissions plugin;
/*    */   private String permission;
/* 26 */   private static final Phrase SUB_TITLE = Phrase.create("placeholderFillDialog.subtitle", "Type in a value for **[%placeholder%]**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */   
/*    */   private void run() {
/* 29 */     String[] arrayOfString = StringUtils.substringsBetween(this.permission, "[", "]");
/*    */     
/* 31 */     if (arrayOfString == null || arrayOfString.length == 0) {
/* 32 */       onComplete(this.permission);
/*    */       
/*    */       return;
/*    */     } 
/* 36 */     final String placeholder = arrayOfString[0];
/* 37 */     new UserInput(this.p, (SpigotTechPlugin)this.plugin, this.permission, SUB_TITLE.get().replace("%placeholder%", str))
/*    */       {
/*    */         public void onClose(Player param1Player) {
/* 40 */           PlaceholderFillDialog.this.onBack();
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean onResult(String param1String) {
/* 45 */           PlaceholderFillDialog.this.permission = PlaceholderFillDialog.this.permission.replace("[" + placeholder + "]", param1String);
/* 46 */           run();
/* 47 */           return true;
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public abstract void onBack();
/*    */   
/*    */   public abstract void onComplete(String paramString);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PlaceholderFillDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */