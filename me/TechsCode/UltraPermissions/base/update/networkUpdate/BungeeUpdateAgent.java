/*    */ package me.TechsCode.UltraPermissions.base.update.networkUpdate;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.BungeeMessagingListener;
/*    */ import me.TechsCode.UltraPermissions.base.messaging.Message;
/*    */ import me.TechsCode.UltraPermissions.base.update.UpdateServer;
/*    */ import net.md_5.bungee.api.ProxyServer;
/*    */ import net.md_5.bungee.api.config.ServerInfo;
/*    */ 
/*    */ public class BungeeUpdateAgent
/*    */   implements BungeeMessagingListener
/*    */ {
/*    */   private BungeeTechPlugin plugin;
/*    */   
/*    */   public BungeeUpdateAgent(BungeeTechPlugin paramBungeeTechPlugin) {
/* 19 */     this.plugin = paramBungeeTechPlugin;
/*    */     
/* 21 */     paramBungeeTechPlugin.getMessagingService().register(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMessage(ServerInfo paramServerInfo, Message paramMessage) {
/* 26 */     if (paramMessage.getKey().equals("update")) {
/* 27 */       ArrayList arrayList = new ArrayList(ProxyServer.getInstance().getServers().values());
/* 28 */       arrayList.remove(paramServerInfo);
/*    */ 
/*    */       
/* 31 */       this.plugin.getMessagingService().send(paramMessage, (ServerInfo[])arrayList.toArray((Object[])new ServerInfo[0]));
/*    */ 
/*    */       
/* 34 */       JsonObject jsonObject = paramMessage.getData();
/* 35 */       String str1 = jsonObject.get("updateServer").getAsString();
/* 36 */       String str2 = jsonObject.get("uid").getAsString();
/* 37 */       String str3 = jsonObject.get("version").getAsString();
/*    */       
/* 39 */       if (!this.plugin.getVersion().equals(str3))
/* 40 */         UpdateServer.requestAndPerform((TechPlugin)this.plugin, str1, str2); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/update/networkUpdate/BungeeUpdateAgent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */