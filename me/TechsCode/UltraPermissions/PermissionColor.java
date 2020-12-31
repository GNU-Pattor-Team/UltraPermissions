/*    */ package me.TechsCode.UltraPermissions;
/*    */ 
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionCopy;
/*    */ 
/*    */ 
/*    */ public enum PermissionColor
/*    */ {
/* 12 */   ALL_SERVERS(Colors.GREEN, XMaterial.LIME_STAINED_GLASS_PANE, XMaterial.LIME_STAINED_GLASS),
/* 13 */   SPECIFIC_SERVER(Colors.BLUE, XMaterial.BLUE_STAINED_GLASS_PANE, XMaterial.BLUE_STAINED_GLASS),
/* 14 */   BUNGEE_SERVER(Colors.RED, XMaterial.RED_STAINED_GLASS_PANE, XMaterial.RED_STAINED_GLASS),
/* 15 */   INHERITED(Colors.YELLOW, XMaterial.YELLOW_STAINED_GLASS_PANE, XMaterial.YELLOW_STAINED_GLASS);
/*    */   private final Color color;
/*    */   private final XMaterial glassPane;
/*    */   private final XMaterial glassBlock;
/*    */   
/*    */   PermissionColor(Color paramColor, XMaterial paramXMaterial1, XMaterial paramXMaterial2) {
/* 21 */     this.color = paramColor;
/* 22 */     this.glassPane = paramXMaterial1;
/* 23 */     this.glassBlock = paramXMaterial2;
/*    */   }
/*    */   
/*    */   public Color getColor() {
/* 27 */     return this.color;
/*    */   }
/*    */   
/*    */   public XMaterial getGlassPane() {
/* 31 */     return this.glassPane;
/*    */   }
/*    */   
/*    */   public XMaterial getGlassBlock() {
/* 35 */     return this.glassBlock;
/*    */   }
/*    */   
/*    */   public static PermissionColor fromPermission(PermissionCopy paramPermissionCopy) {
/* 39 */     if (paramPermissionCopy.isInherited()) return INHERITED;
/*    */     
/* 41 */     if (paramPermissionCopy.getPermission().getServer().isPresent()) {
/* 42 */       if (((String)paramPermissionCopy.getPermission().getServer().get()).equals("BungeeCord")) return BUNGEE_SERVER;
/*    */       
/* 44 */       return SPECIFIC_SERVER;
/*    */     } 
/*    */     
/* 47 */     return ALL_SERVERS;
/*    */   }
/*    */   
/*    */   public static PermissionColor cycle(List<PermissionCopy> paramList) {
/* 51 */     int i = (int)(System.currentTimeMillis() / 1000L % paramList.size());
/*    */     
/* 53 */     return fromPermission(paramList.get(i));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/PermissionColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */