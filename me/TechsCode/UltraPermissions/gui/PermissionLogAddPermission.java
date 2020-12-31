/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionEditorMainView;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class PermissionLogAddPermission extends PageableGUI<PermissionHolder> {
/*    */   private final Player p;
/*    */   private final UltraPermissions plugin;
/*    */   private final String permission;
/*    */   
/*    */   public PermissionLogAddPermission(Player paramPlayer, UltraPermissions paramUltraPermissions, String paramString) {
/* 27 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*    */     
/* 29 */     this.p = paramPlayer;
/* 30 */     this.plugin = paramUltraPermissions;
/* 31 */     this.permission = paramString;
/*    */   }
/*    */   
/* 34 */   private static final Phrase TITLE = Phrase.create("permissionLogAddPermission.title", "Permission > %permission%");
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 38 */     return TITLE.get().replace("%permission%", this.permission);
/*    */   }
/*    */   
/* 41 */   private static final Phrase ENTRY_ACTION = Phrase.create("permissionLogAddPermission.entry.action", "Click to **add** permission", Colors.GRAY, new Color[] { Colors.AQUA });
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, PermissionHolder paramPermissionHolder) {
/* 45 */     paramButton.material(XMaterial.WHITE_STAINED_GLASS_PANE)
/* 46 */       .name(Animation.wave(paramPermissionHolder.getName(), new Color[] { Colors.Green, Colors.WHITE
/* 47 */           })).lore(new String[] { ENTRY_ACTION.get() });
/*    */     
/* 49 */     paramButton.action(paramActionType -> {
/*    */           paramPermissionHolder.newPermission(this.permission).create();
/*    */           new PermissionEditorMainView(this.p, this.plugin, paramPermissionHolder)
/*    */             {
/*    */               public void onBack()
/*    */               {
/* 55 */                 PermissionLogAddPermission.this.onBack();
/*    */               }
/*    */             };
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public PermissionHolder[] getObjects() {
/* 63 */     ArrayList arrayList = new ArrayList();
/* 64 */     arrayList.addAll((Collection)this.plugin.getGroups());
/* 65 */     arrayList.addAll((Collection)this.plugin.getUsers());
/* 66 */     return (PermissionHolder[])arrayList.toArray((Object[])new PermissionHolder[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchFeature<PermissionHolder> getSearch() {
/* 71 */     return (SearchFeature<PermissionHolder>)new BasicSearch<PermissionHolder>()
/*    */       {
/*    */         public String[] getSearchableText(PermissionHolder param1PermissionHolder) {
/* 74 */           return new String[] { param1PermissionHolder.getName() };
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/PermissionLogAddPermission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */