/*    */ package me.TechsCode.UltraPermissions.base.views.settings.mysqlpane;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class MySQLSetup {
/* 11 */   private static final Phrase TITLE = Phrase.create("mysqlSetup.title", "MySQL Setup", Colors.AQUA, new Color[0]);
/* 12 */   private static final Phrase SUB_TITLE = Phrase.create("mysqlSetup.subtitle", "Type in **%** into Chat", Colors.GRAY, new Color[] { Colors.YELLOW });
/* 13 */   private static final Phrase ACTION_BAR = Phrase.create("mysqlSetup.actionBar", "Default: **%**", Colors.GRAY, new Color[] { Colors.GREEN });
/*    */   
/*    */   private final Player p;
/*    */   private final SpigotTechPlugin plugin;
/*    */   private int stageNum;
/*    */   
/*    */   public MySQLSetup(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/* 20 */     this.p = paramPlayer;
/* 21 */     this.plugin = paramSpigotTechPlugin;
/* 22 */     this.stageNum = -1;
/*    */     
/* 24 */     nextStage();
/*    */   }
/*    */   
/*    */   public void nextStage() {
/* 28 */     this.stageNum++;
/*    */     
/* 30 */     SetupStage[] arrayOfSetupStage = getStages();
/*    */     
/* 32 */     if (this.stageNum >= arrayOfSetupStage.length) {
/* 33 */       onCompletion();
/*    */       
/*    */       return;
/*    */     } 
/* 37 */     final SetupStage stage = arrayOfSetupStage[this.stageNum];
/*    */     
/* 39 */     new UserInput(this.p, this.plugin, TITLE.get(), SUB_TITLE.get().replace("%", setupStage.getFieldName()), ACTION_BAR.get().replace("%", setupStage.getDefaultValue()))
/*    */       {
/*    */         public void onClose(Player param1Player) {
/* 42 */           MySQLSetup.this.onClose();
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean onResult(String param1String) {
/* 47 */           stage.getSetFunction().set(param1String);
/* 48 */           MySQLSetup.this.nextStage();
/* 49 */           return true;
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public abstract void onClose();
/*    */   
/*    */   public abstract void onCompletion();
/*    */   
/*    */   public abstract SetupStage[] getStages();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/settings/mysqlpane/MySQLSetup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */