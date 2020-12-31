/*    */ package me.TechsCode.UltraPermissions.gui.permissionEditor;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.permissionDatabase.PermissionInfo;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.PermissionHolder;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public abstract class SearchPermissionListView
/*    */   extends PermissionListView
/*    */ {
/*    */   private final String searchTerm;
/*    */   private final PermissionWithInfo[] permissions;
/*    */   
/*    */   public SearchPermissionListView(Player paramPlayer, UltraPermissions paramUltraPermissions, PermissionHolder paramPermissionHolder, String paramString) {
/* 23 */     super(paramPlayer, paramUltraPermissions, paramPermissionHolder);
/*    */     
/* 25 */     this.searchTerm = paramString;
/*    */ 
/*    */ 
/*    */     
/* 29 */     List list = (List)Arrays.<Plugin>stream(Bukkit.getPluginManager().getPlugins()).map(Plugin::getName).map(String::toLowerCase).collect(Collectors.toList());
/*    */     
/* 31 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 36 */       .permissions = (PermissionWithInfo[])paramUltraPermissions.getPermissionDatabase().getAllPermissionInfos().stream().filter(paramPermissionInfo -> (paramList.contains(paramPermissionInfo.getPlugin().toLowerCase()) || paramPermissionInfo.getPlugin().toLowerCase().equals("bukkit"))).filter(paramPermissionInfo -> paramPermissionInfo.getPermission().toLowerCase().contains(paramString.toLowerCase())).sorted(Comparator.comparing(PermissionInfo::getPermission)).map(paramPermissionInfo -> new PermissionWithInfo(paramPermissionInfo.getPermission(), paramPermissionInfo)).toArray(paramInt -> new PermissionWithInfo[paramInt]);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 41 */     return "Permissions with '" + this.searchTerm + "'";
/*    */   }
/*    */ 
/*    */   
/*    */   public PermissionWithInfo[] getObjects() {
/* 46 */     return this.permissions;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SearchFeature<PermissionWithInfo> getSearch() {
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/permissionEditor/SearchPermissionListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */