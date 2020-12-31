/*    */ package me.TechsCode.UltraPermissions.base.update;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.misc.Callback;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.io.IOUtils;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Updater
/*    */ {
/* 16 */   private static final List<Player> askedPlayers = new ArrayList<>();
/*    */   
/*    */   public static void suggestUpdateIfAvailable(SpigotTechPlugin paramSpigotTechPlugin, Player paramPlayer, String paramString, Callback<Player> paramCallback, boolean paramBoolean) {
/* 19 */     if (!paramBoolean && askedPlayers.contains(paramPlayer)) {
/*    */       return;
/*    */     }
/*    */     
/* 23 */     paramSpigotTechPlugin.getScheduler().runAsync(() -> {
/*    */           UpdateState updateState = getUpdateState(paramSpigotTechPlugin, paramString);
/*    */           if (updateState == UpdateState.UP_TO_DATE || updateState == UpdateState.UNKNOWN) {
/*    */             return;
/*    */           }
/*    */           askedPlayers.add(paramPlayer);
/*    */           String str1 = paramSpigotTechPlugin.getVersion();
/*    */           String str2 = getNewestVersionOnServer(paramSpigotTechPlugin, paramString);
/*    */           paramSpigotTechPlugin.getScheduler().run(());
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static UpdateState getUpdateState(SpigotTechPlugin paramSpigotTechPlugin, String paramString) {
/* 56 */     String str1 = paramSpigotTechPlugin.getVersion();
/* 57 */     String str2 = getNewestVersionOnServer(paramSpigotTechPlugin, paramString);
/*    */     
/* 59 */     if (str2 == null) return UpdateState.UNKNOWN;
/*    */     
/* 61 */     return str1.equalsIgnoreCase(str2) ? UpdateState.UP_TO_DATE : UpdateState.OUTDATED;
/*    */   }
/*    */   
/*    */   private static String getNewestVersionOnServer(SpigotTechPlugin paramSpigotTechPlugin, String paramString) {
/* 65 */     String str = paramString + "/" + paramSpigotTechPlugin.getName() + "/version";
/*    */     
/*    */     try {
/* 68 */       String str1 = IOUtils.toString(new URL(str), "UTF-8");
/*    */       
/* 70 */       if (str1.contains(".")) {
/* 71 */         return str1;
/*    */       }
/* 73 */       return null;
/*    */     }
/* 75 */     catch (IOException iOException) {
/* 76 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   enum UpdateState {
/* 81 */     UP_TO_DATE, OUTDATED, UNKNOWN;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/Updater.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */