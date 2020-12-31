/*    */ package me.TechsCode.UltraPermissions.hooks.pluginHooks;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import me.clip.placeholderapi.PlaceholderAPI;
/*    */ import me.clip.placeholderapi.expansion.PlaceholderExpansion;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlaceholderAPIHook
/*    */ {
/*    */   private final UltraPermissions plugin;
/*    */   
/*    */   public PlaceholderAPIHook(final UltraPermissions plugin) {
/* 18 */     this.plugin = plugin;
/*    */     
/* 20 */     (new PlaceholderExpansion()
/*    */       {
/*    */         public String getIdentifier() {
/* 23 */           return "uperms";
/*    */         }
/*    */ 
/*    */         
/*    */         public String getAuthor() {
/* 28 */           return "TechsCode";
/*    */         }
/*    */ 
/*    */         
/*    */         public String getVersion() {
/* 33 */           return "1.0.0";
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean persist() {
/* 38 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public String onRequest(OfflinePlayer param1OfflinePlayer, String param1String) {
/* 43 */           if (param1OfflinePlayer == null) {
/* 44 */             plugin.log("Plugin tried getting the placeholder %uperms_" + param1String + "% with no player assigned!");
/* 45 */             return "";
/*    */           } 
/*    */           
/* 48 */           Optional<User> optional = plugin.getUsers().uuid(param1OfflinePlayer.getUniqueId());
/*    */           
/* 50 */           if (!optional.isPresent()) return "";
/*    */           
/* 52 */           for (UpermsPlaceholder upermsPlaceholder : UltraPermissions.placeholders) {
/* 53 */             if (upermsPlaceholder.getName().equalsIgnoreCase(param1String)) {
/* 54 */               return upermsPlaceholder.get(optional.get(), plugin.getThisServer().orElse(null));
/*    */             }
/*    */           } 
/*    */           
/* 58 */           return "";
/*    */         }
/* 60 */       }).register();
/*    */   }
/*    */   
/*    */   public String replace(OfflinePlayer paramOfflinePlayer, String paramString) {
/* 64 */     return PlaceholderAPI.setPlaceholders(paramOfflinePlayer, paramString);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/pluginHooks/PlaceholderAPIHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */