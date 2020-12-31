/*    */ package me.TechsCode.UltraPermissions.base.messaging;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.config.ServerInfo;
/*    */ import net.md_5.bungee.api.connection.Server;
/*    */ import net.md_5.bungee.api.event.PluginMessageEvent;
/*    */ import net.md_5.bungee.api.plugin.Listener;
/*    */ import net.md_5.bungee.api.plugin.Plugin;
/*    */ import net.md_5.bungee.event.EventHandler;
/*    */ 
/*    */ public class BungeeMessagingService
/*    */   implements Listener {
/*    */   private BungeeTechPlugin plugin;
/*    */   private List<BungeeMessagingListener> listeners;
/*    */   
/*    */   public BungeeMessagingService(BungeeTechPlugin paramBungeeTechPlugin) {
/* 25 */     this.plugin = paramBungeeTechPlugin;
/* 26 */     this.listeners = new ArrayList<>();
/*    */     
/* 28 */     ProxyServer.getInstance().getPluginManager().registerListener((Plugin)paramBungeeTechPlugin.getBootstrap(), this);
/* 29 */     ProxyServer.getInstance().registerChannel("BungeeCord");
/*    */   }
/*    */   
/*    */   public void register(BungeeMessagingListener paramBungeeMessagingListener) {
/* 33 */     this.listeners.add(paramBungeeMessagingListener);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void message(PluginMessageEvent paramPluginMessageEvent) {
/* 38 */     if (paramPluginMessageEvent.getSender() instanceof Server) {
/*    */       try {
/* 40 */         ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(paramPluginMessageEvent.getData());
/*    */         
/* 42 */         Server server = (Server)paramPluginMessageEvent.getSender();
/* 43 */         ServerInfo serverInfo = server.getInfo();
/*    */         
/* 45 */         String str = byteArrayDataInput.readUTF();
/*    */         
/* 47 */         if (str.startsWith(this.plugin.getName() + "//")) {
/* 48 */           Message message = Message.decode(str.replace(this.plugin.getName() + "//", ""));
/* 49 */           this.listeners.forEach(paramBungeeMessagingListener -> paramBungeeMessagingListener.onMessage(paramServerInfo, paramMessage));
/*    */         } 
/* 51 */       } catch (IllegalStateException illegalStateException) {}
/*    */     }
/*    */   }
/*    */   
/*    */   public void send(Message paramMessage, ServerInfo... paramVarArgs) {
/* 56 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 57 */     DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
/*    */     
/*    */     try {
/* 60 */       dataOutputStream.writeUTF(this.plugin.getName() + "//" + paramMessage.encode());
/* 61 */     } catch (IOException iOException) {
/* 62 */       iOException.printStackTrace();
/*    */     } 
/*    */     
/* 65 */     if (paramVarArgs.length == 0) {
/* 66 */       paramVarArgs = (ServerInfo[])ProxyServer.getInstance().getServers().values().toArray((Object[])new ServerInfo[0]);
/*    */     }
/*    */     
/* 69 */     for (ServerInfo serverInfo : paramVarArgs)
/* 70 */       serverInfo.sendData("BungeeCord", byteArrayOutputStream.toByteArray()); 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/messaging/BungeeMessagingService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */