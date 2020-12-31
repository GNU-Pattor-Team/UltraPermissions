/*    */ package me.TechsCode.UltraPermissions.hooks.pluginHooks;
/*    */ import be.maximvdw.placeholderapi.PlaceholderAPI;
/*    */ import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*    */ import me.TechsCode.UltraPermissions.hooks.UpermsPlaceholder;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class MvdwPlaceholderAPIHook {
/*    */   public MvdwPlaceholderAPIHook(UltraPermissions paramUltraPermissions) {
/* 15 */     Optional optional = paramUltraPermissions.getThisServer();
/*    */     
/* 17 */     for (UpermsPlaceholder upermsPlaceholder : UltraPermissions.placeholders) {
/* 18 */       PlaceholderAPI.registerPlaceholder((Plugin)paramUltraPermissions.getBootstrap(), "uperms_" + upermsPlaceholder.getName(), paramPlaceholderReplaceEvent -> {
/*    */             Optional<User> optional = paramUltraPermissions.getUsers().uuid(paramPlaceholderReplaceEvent.getOfflinePlayer().getUniqueId());
/*    */             return optional.isPresent() ? paramUpermsPlaceholder.get(optional.get(), paramOptional.orElse(null)) : "";
/*    */           });
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String replace(Player paramPlayer, String paramString) {
/* 31 */     return PlaceholderAPI.replacePlaceholders((OfflinePlayer)paramPlayer, paramString);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/hooks/pluginHooks/MvdwPlaceholderAPIHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */