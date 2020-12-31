/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.permissionDatabase.PermissionInfo;
/*    */ import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class PluginPermissionListView extends PermissionListView {
/*    */   private final PermissionHolder holder;
/*    */   
/*    */   public PluginPermissionListView(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder, PermissionEditorMainView.PluginEntry paramPluginEntry) {
/* 22 */     super(paramPlayer, paramUltraPermissions, paramPermissionHolder);
/*    */     
/* 24 */     this.holder = paramPermissionHolder;
/* 25 */     this.sourcePlugin = paramPluginEntry;
/*    */   }
/*    */   private final PermissionEditorMainView.PluginEntry sourcePlugin;
/*    */   
/*    */   public void reopen() {
/* 30 */     super.reopen();
/*    */     
/* 32 */     this.sourcePlugin.retrieveData();
/*    */   }
/*    */ 
/*    */   
/*    */   public PermissionWithInfo[] getObjects() {
/* 37 */     return (PermissionWithInfo[])this.sourcePlugin.permissionsFromDatabase.stream()
/* 38 */       .map(paramPermissionInfo -> new PermissionWithInfo(paramPermissionInfo.getPermission(), paramPermissionInfo))
/* 39 */       .distinct()
/* 40 */       .toArray(paramInt -> new PermissionWithInfo[paramInt]);
/*    */   }
/*    */   
/* 43 */   private static final Phrase TITLE = Phrase.create("pluginPermissionListView.title", "%plugin% > Permissions");
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 47 */     return TITLE.get().replace("%plugin%", this.sourcePlugin.name);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void construct(Model paramModel) {
/* 52 */     super.construct(paramModel);
/*    */     
/* 54 */     paramModel.button(getRightOptionSlot(), this::AllPermissionsButton);
/*    */   }
/*    */   
/* 57 */   private static final Phrase ALL_PERMISSIONS_TITLE = Phrase.create("pluginPermissionListView.allPermissions.title", "All Permissions");
/* 58 */   private static final Phrase ALL_PERMISSIONS_ADD_ACTION = Phrase.create("pluginPermissionListView.allPermissions.addAction", "**Left Click** to **add** all Permissions", Colors.GRAY, new Color[] { Colors.AQUA, Colors.GREEN });
/* 59 */   private static final Phrase ALL_PERMISSIONS_REMOVE_ACTION = Phrase.create("pluginPermissionListView.allPermissions.removeAction", "**Right Click** to **remove** all Permissions", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*    */   
/*    */   private void AllPermissionsButton(Button paramButton) {
/* 62 */     paramButton.material(XMaterial.BUCKET)
/* 63 */       .name(Animation.wave(ALL_PERMISSIONS_TITLE.get(), new Color[] { Colors.Green, Colors.WHITE
/* 64 */           })).lore(new String[] {
/* 65 */           ALL_PERMISSIONS_ADD_ACTION.get(), ALL_PERMISSIONS_REMOVE_ACTION
/* 66 */           .get()
/*    */         });
/*    */     
/* 69 */     paramButton.action(paramActionType -> {
/*    */           if (paramActionType == ActionType.LEFT) {
/*    */             PermissionList permissionList1 = this.holder.getPermissions();
/*    */             PermissionList permissionList2 = this.holder.getAdditionalPermissions();
/*    */             for (PermissionWithInfo permissionWithInfo : getObjects()) {
/*    */               if (permissionList1.name(permissionWithInfo.getName()).isEmpty() && permissionList2.name(permissionWithInfo.getName()).isEmpty())
/*    */                 this.holder.newPermission(permissionWithInfo.getName()).create(); 
/*    */             } 
/*    */           } 
/*    */           if (paramActionType == ActionType.RIGHT) {
/*    */             PermissionList permissionList = this.holder.getPermissions();
/*    */             for (PermissionWithInfo permissionWithInfo : getObjects())
/*    */               permissionList.name(permissionWithInfo.getName()).forEach(Permission::remove); 
/*    */           } 
/*    */         });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/PluginPermissionListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */