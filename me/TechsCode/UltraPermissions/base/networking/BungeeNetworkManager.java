/*    */ package me.TechsCode.UltraPermissions.base.networking;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.InetAddress;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.URL;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.Message;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.config.ServerInfo;
/*    */ import net.md_5.bungee.api.connection.ProxiedPlayer;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ 
/*    */ public class BungeeNetworkManager {
/* 21 */   private static List<String> LOCALHOST_IPS = Arrays.asList(new String[] { "localhost", "127.0.0.1" });
/*    */   
/*    */   private BungeeTechPlugin plugin;
/*    */   private String ownIpAddress;
/*    */   
/*    */   public BungeeNetworkManager(BungeeTechPlugin paramBungeeTechPlugin) {
/* 27 */     this.plugin = paramBungeeTechPlugin;
/* 28 */     this.ownIpAddress = retrieveOwnIpAddress();
/*    */     
/* 30 */     paramBungeeTechPlugin.getScheduler().runTaskTimer(this::SendServerListInfoTask, 10L, 100L);
/*    */   }
/*    */   
/*    */   private String retrieveOwnIpAddress() {
/*    */     try {
/* 35 */       return (new BufferedReader(new InputStreamReader((new URL("http://checkip.amazonaws.com")).openStream()))).readLine();
/* 36 */     } catch (IOException iOException) {
/* 37 */       iOException.printStackTrace();
/* 38 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void SendServerListInfoTask() {
/* 44 */     String str = this.plugin.getVersion();
/* 45 */     ServerList serverList = fetchServerList();
/* 46 */     NetworkData networkData = new NetworkData(str, serverList);
/*    */     
/* 48 */     this.plugin.getMessagingService().send(new Message("networking", networkData.toJsonObject()), new ServerInfo[0]);
/*    */   }
/*    */   
/*    */   private ServerList fetchServerList() {
/* 52 */     ProxyServer proxyServer = ((Plugin)this.plugin.getBootstrap()).getProxy();
/*    */     
/* 54 */     return (ServerList)proxyServer.getServers().entrySet().stream()
/* 55 */       .map(paramEntry -> {
/*    */           String str1 = ((ServerInfo)paramEntry.getValue()).getName();
/*    */           
/*    */           InetSocketAddress inetSocketAddress = ((ServerInfo)paramEntry.getValue()).getAddress();
/*    */           
/*    */           if (inetSocketAddress == null) {
/*    */             return null;
/*    */           }
/*    */           
/*    */           InetAddress inetAddress = inetSocketAddress.getAddress();
/*    */           
/*    */           if (inetAddress == null) {
/*    */             return null;
/*    */           }
/*    */           
/*    */           String str2 = inetAddress.getHostAddress();
/*    */           
/*    */           if (LOCALHOST_IPS.contains(str2) || str2.startsWith("192.168")) {
/*    */             str2 = this.ownIpAddress;
/*    */           }
/*    */           
/*    */           int i = ((ServerInfo)paramEntry.getValue()).getAddress().getPort();
/*    */           NServer nServer = new NServer(str1, str2, i, new ArrayList<>());
/*    */           ((ServerInfo)paramEntry.getValue()).getPlayers().stream().map(()).forEach(());
/*    */           return nServer;
/* 80 */         }).filter(Objects::nonNull)
/* 81 */       .collect(Collectors.toCollection(ServerList::new));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/networking/BungeeNetworkManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */