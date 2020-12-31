/*    */ package me.TechsCode.UltraPermissions.hooks;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class UpermsPlaceholder
/*    */ {
/*    */   private final String name;
/*    */   private final String description;
/*    */   
/*    */   public UpermsPlaceholder(String paramString1, String paramString2) {
/* 16 */     this.name = paramString1;
/* 17 */     this.description = paramString2;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 21 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 25 */     return this.description;
/*    */   }
/*    */   
/*    */   public String getNativePlaceholder() {
/* 29 */     return "{" + Text.firstUpperCase(this.name) + "}";
/*    */   }
/*    */   
/*    */   public String get(User paramUser, NServer paramNServer) {
/* 33 */     if (paramUser == null) return "";
/*    */     
/* 35 */     Player player = Bukkit.getPlayer(paramUser.getUuid());
/*    */     
/* 37 */     if (player != null && !player.isOnline()) {
/* 38 */       player = null;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 45 */     Group[] arrayOfGroup = (Group[])paramUser.getActiveGroups().bestToWorst().servers(true, new String[] { (paramNServer != null) ? paramNServer.getName() : null }).worlds(true, new String[] { (player != null) ? player.getWorld().getName() : "*" }).toArray((Object[])new Group[0]);
/*    */     
/* 47 */     return replace(player, paramUser, arrayOfGroup);
/*    */   }
/*    */   
/*    */   protected abstract String replace(Player paramPlayer, User paramUser, Group[] paramArrayOfGroup);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/UpermsPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */