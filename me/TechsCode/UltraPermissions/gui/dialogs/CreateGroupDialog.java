/*    */ package me.TechsCode.UltraPermissions.gui.dialogs;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class CreateGroupDialog extends UserInput {
/* 11 */   private static final Phrase TITLE = Phrase.create("createGroupDialog.title", "Create Group");
/* 12 */   private static final Phrase SUB_TITLE = Phrase.create("createGroupDialog.subTitle", "Type in a group name", Colors.GRAY, new Color[0]);
/*    */   
/* 14 */   private static final Phrase NO_SPACES = Phrase.create("createGroupDialog.noSpaces", "The Group Name **should not** contain spaces", Colors.GRAY, new Color[] { Colors.RED });
/* 15 */   private static final Phrase NO_COLORS = Phrase.create("createGroupDialog.noColors", "The Group Name **should not** contain Color Codes", Colors.GRAY, new Color[] { Colors.RED });
/* 16 */   private static final Phrase NAME_TAKEN = Phrase.create("createGroupDialog.nameTaken", "This Group Name is already in use", Colors.GRAY, new Color[0]);
/*    */   
/*    */   private final Player p;
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public CreateGroupDialog(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/* 22 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions, TITLE.get(), SUB_TITLE.get());
/*    */     
/* 24 */     this.p = paramPlayer;
/* 25 */     this.plugin = paramUltraPermissions;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onResult(String paramString) {
/* 30 */     if (paramString.contains(" ")) {
/* 31 */       this.p.sendMessage(this.plugin.getPrefix() + NO_SPACES);
/* 32 */       return false;
/*    */     } 
/*    */     
/* 35 */     if (paramString.contains("&")) {
/* 36 */       this.p.sendMessage(this.plugin.getPrefix() + NO_COLORS);
/* 37 */       return false;
/*    */     } 
/*    */     
/* 40 */     boolean bool = this.plugin.getGroups().name(paramString).isPresent();
/*    */     
/* 42 */     if (bool) {
/* 43 */       this.p.sendMessage(this.plugin.getPrefix() + NAME_TAKEN);
/* 44 */       return false;
/*    */     } 
/*    */     
/* 47 */     this.plugin.newGroup(paramString).setPrefix(Colors.GREEN + paramString).create();
/* 48 */     reopen();
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClose(Player paramPlayer) {
/* 55 */     reopen();
/*    */   }
/*    */   
/*    */   public abstract void reopen();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/dialogs/CreateGroupDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */