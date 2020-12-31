/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ import java.util.Arrays;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.permissionDatabase.PermissionInfo;
/*    */ import me.TechsCode.UltraPermissions.permissionlogger.LoggedPermission;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class PermissionLogViewer extends PageableGUI<LoggedPermission> {
/* 22 */   private static final Phrase TITLE = Phrase.create("permissionLogViewer.title", "Overview > Permission Log");
/*    */   
/* 24 */   private static final Phrase ITEM_ACTION = Phrase.create("permissionLogViewer.item.action", "Click to add this permission to a **group** or **user**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.AQUA });
/* 25 */   private static final Phrase RESULT_RESULT_ATTRIBUTE_PASSED = Phrase.create("permissionLogViewer.item.passedAttribute", "Player **has** this Permission", Colors.GRAY, new Color[] { Colors.GREEN });
/* 26 */   private static final Phrase RESULT_RESULT_ATTRIBUTE_FAILED = Phrase.create("permissionLogViewer.item.failedAttribute", "Player does **not** have this Permission", Colors.GRAY, new Color[] { Colors.RED });
/* 27 */   private static final Phrase RESULT_TIME_ATTRIBUTE = Phrase.create("permissionLogViewer.item.timeAttribute", "Checked **%duration%** ago", Colors.GRAY, new Color[] { Colors.RED });
/* 28 */   private static final Phrase SOURCE_ATTRIBUTE = Phrase.create("permissionLogViewer.item.sourceAttribute", "Allowed by **%source%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */   
/*    */   private final Player p;
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public PermissionLogViewer(Player paramPlayer, UltraPermissions paramUltraPermissions) {
/* 34 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 36 */     this.p = paramPlayer;
/* 37 */     this.plugin = paramUltraPermissions;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 42 */     return TITLE.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, LoggedPermission paramLoggedPermission) {
/* 47 */     paramButton.material(paramLoggedPermission.getOutcome() ? XMaterial.LIME_STAINED_GLASS_PANE : XMaterial.RED_STAINED_GLASS_PANE)
/* 48 */       .name(Animation.wave(paramLoggedPermission.getPermission(), new Color[] { paramLoggedPermission.getOutcome() ? Colors.GREEN : Colors.RED, Colors.WHITE
/* 49 */           })).lore(new String[] {
/* 50 */           ITEM_ACTION.get(), "", (
/*    */           
/* 52 */           paramLoggedPermission.getOutcome() ? RESULT_RESULT_ATTRIBUTE_PASSED : RESULT_RESULT_ATTRIBUTE_FAILED).get()
/*    */         });
/*    */     
/* 55 */     if (paramLoggedPermission.getOutcome()) {
/* 56 */       paramButton.item().appendLore(new String[] { "", SOURCE_ATTRIBUTE
/*    */             
/* 58 */             .get().replace("%source%", paramLoggedPermission.getSource()) });
/*    */     }
/*    */ 
/*    */     
/* 62 */     PermissionInfo permissionInfo = this.plugin.getPermissionDatabase().getInfo(paramLoggedPermission.getPermission());
/*    */     
/* 64 */     if (permissionInfo != null) {
/* 65 */       paramButton.item().appendLore(new String[] { "" });
/* 66 */       paramButton.item().appendLore(permissionInfo.asLore());
/*    */     } 
/*    */     
/* 69 */     if (paramLoggedPermission.getTime() > 1000L) {
/* 70 */       String str = Tools.getTimeString(System.currentTimeMillis() - paramLoggedPermission.getTime(), TimeUnit.MILLISECONDS);
/*    */       
/* 72 */       paramButton.item().appendLore(new String[] { "", RESULT_TIME_ATTRIBUTE
/*    */             
/* 74 */             .get().replace("%duration%", str) });
/*    */     } 
/*    */ 
/*    */     
/* 78 */     paramButton.action(paramActionType -> new PermissionLogAddPermission(this.p, this.plugin, paramLoggedPermission.getPermission())
/*    */         {
/*    */           public void onBack()
/*    */           {
/* 82 */             PermissionLogViewer.this.reopen();
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public LoggedPermission[] getObjects() {
/* 90 */     return (LoggedPermission[])Arrays.<LoggedPermission>stream(this.plugin.getLoggedPermissionChecks()).filter(paramLoggedPermission -> paramLoggedPermission.getPlayer().equals(this.p)).toArray(paramInt -> new LoggedPermission[paramInt]);
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchFeature<LoggedPermission> getSearch() {
/* 95 */     return (SearchFeature<LoggedPermission>)new BasicSearch<LoggedPermission>()
/*    */       {
/*    */         public String[] getSearchableText(LoggedPermission param1LoggedPermission) {
/* 98 */           return new String[] { param1LoggedPermission
/* 99 */               .getPermission(), param1LoggedPermission.getSource() };
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/PermissionLogViewer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */