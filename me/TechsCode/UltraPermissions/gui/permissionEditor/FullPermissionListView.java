/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import java.util.stream.Stream;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Permission;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class FullPermissionListView
/*    */   extends PermissionListView
/*    */ {
/*    */   private final UltraPermissions plugin;
/*    */   private final PermissionHolder holder;
/*    */   
/*    */   public FullPermissionListView(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder) {
/* 27 */     super(paramPlayer, paramUltraPermissions, paramPermissionHolder);
/*    */     
/* 29 */     this.plugin = paramUltraPermissions;
/* 30 */     this.holder = paramPermissionHolder;
/*    */   }
/*    */   
/* 33 */   private static final Phrase TITLE = Phrase.create("fullPermissionListView.title", "%holder% > Added Permissions");
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 37 */     return TITLE.get().replace("%holder%", this.holder.getName());
/*    */   }
/*    */ 
/*    */   
/*    */   public PermissionWithInfo[] getObjects() {
/* 42 */     List<?> list1 = (List)this.holder.getPermissions().stream().map(Permission::getName).distinct().collect(Collectors.toList());
/* 43 */     List<?> list2 = (List)this.holder.getAdditionalPermissions().stream().map(Permission::getName).distinct().collect(Collectors.toList());
/*    */     
/* 45 */     return (PermissionWithInfo[])Stream.concat(list1.stream(), list2.stream())
/* 46 */       .map(paramString -> new PermissionWithInfo(paramString, this.plugin.getPermissionDatabase().getInfo(paramString)))
/* 47 */       .sorted(Comparator.comparing(PermissionWithInfo::getName))
/* 48 */       .toArray(paramInt -> new PermissionWithInfo[paramInt]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void construct(Model paramModel) {
/* 53 */     super.construct(paramModel);
/*    */     
/* 55 */     paramModel.button(getRightOptionSlot(), this::AddPermissionButton);
/*    */   }
/*    */   
/* 58 */   private static final Phrase ADD_PERMISSION_TITLE = Phrase.create("fullPermissionListView.addPermission.title", "Add Permission");
/* 59 */   private static final Phrase ADD_PERMISSION_ADD_ACTION = Phrase.create("fullPermissionListView.addPermission.addAction", "**Left Click** to add a Permission via Chat", Colors.GRAY, new Color[] { Colors.AQUA });
/* 60 */   private static final Phrase ADD_PERMISSION_ADD_BUNGEE_ACTION = Phrase.create("fullPermissionListView.addPermission.addBungeeAction", "**Right Click** to add **Bungee Permission**", Colors.GRAY, new Color[] { Colors.AQUA, Colors.RED });
/*    */   
/*    */   private void AddPermissionButton(Button paramButton) {
/* 63 */     paramButton.material(XMaterial.NAME_TAG)
/* 64 */       .name(Animation.wave(ADD_PERMISSION_TITLE.get(), new Color[] { Colors.Blue, Colors.WHITE
/* 65 */           })).lore(new String[] {
/* 66 */           ADD_PERMISSION_ADD_ACTION.get()
/*    */         });
/*    */     
/* 69 */     paramButton.action(paramActionType -> {
/*    */           if (paramActionType == ActionType.LEFT) {
/*    */             new AddPermissionDialog(this.p, this.plugin, this.holder)
/*    */               {
/*    */                 public void reopen() {
/* 74 */                   FullPermissionListView.this.reopen();
/*    */                 }
/*    */               };
/*    */           }
/*    */         });
/*    */     
/* 80 */     if (this.plugin.getMySQLManager().isEnabled() && this.plugin.isConnectedToNetwork()) {
/* 81 */       paramButton.item().appendLore(new String[] { ADD_PERMISSION_ADD_BUNGEE_ACTION.get() });
/* 82 */       paramButton.action(paramActionType -> {
/*    */             if (paramActionType == ActionType.RIGHT)
/*    */               new AddBungeePermissionDialog(this.p, this.plugin, this.holder)
/*    */                 {
/*    */                   public void reopen() {
/* 87 */                     FullPermissionListView.this.reopen();
/*    */                   }
/*    */                 }; 
/*    */           });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/FullPermissionListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */