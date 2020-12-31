/*    */ package me.TechsCode.UltraPermissions.base.networking;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.URL;
/*    */ import java.util.Optional;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.Message;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class SpigotNetworkManager {
/*    */   private SpigotTechPlugin plugin;
/*    */   private String ownIpAddress;
/*    */   private NetworkData networkData;
/*    */   
/*    */   public SpigotNetworkManager(SpigotTechPlugin paramSpigotTechPlugin) {
/* 18 */     this.plugin = paramSpigotTechPlugin;
/* 19 */     this.ownIpAddress = retrieveOwnIpAddress();
/*    */     
/* 21 */     paramSpigotTechPlugin.getMessagingService().register(paramMessage -> {
/*    */           if (paramMessage.getKey().equals("networking")) {
/*    */             this.networkData = NetworkData.fromJsonObject(paramMessage.getData());
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   private String retrieveOwnIpAddress() {
/*    */     try {
/* 30 */       return (new BufferedReader(new InputStreamReader((new URL("http://checkip.amazonaws.com")).openStream()))).readLine();
/* 31 */     } catch (IOException iOException) {
/* 32 */       iOException.printStackTrace();
/* 33 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public Optional<NetworkData> getData() {
/* 38 */     return Optional.ofNullable(this.networkData);
/*    */   }
/*    */   
/*    */   public Optional<NServer> getThisServer() {
/* 42 */     if (this.networkData == null) return Optional.empty();
/*    */     
/* 44 */     int i = ((JavaPlugin)this.plugin.getBootstrap()).getServer().getPort();
/*    */     
/* 46 */     return this.networkData.getServerList().stream().filter(paramNServer -> (paramNServer.getIp().equals(this.ownIpAddress) && paramNServer.getPort() == paramInt)).findFirst();
/*    */   }
/*    */   
/*    */   public Optional<NServer> getServerFromName(String paramString) {
/* 50 */     if (this.networkData == null) return Optional.empty();
/*    */     
/* 52 */     return this.networkData.getServerList().stream().filter(paramNServer -> paramNServer.getName().equalsIgnoreCase(paramString)).findFirst();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/networking/SpigotNetworkManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */