/*    */ package me.TechsCode.UltraPermissions.base.messaging;
/*    */ 
/*    */ import com.google.common.collect.Iterables;
/*    */ import com.google.common.io.ByteArrayDataOutput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.DataInputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.scheduler.RecurringTask;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.messaging.PluginMessageListener;
/*    */ 
/*    */ 
/*    */ public class SpigotMessagingService
/*    */   implements PluginMessageListener
/*    */ {
/*    */   private SpigotTechPlugin plugin;
/*    */   private List<QueuedMessage> queuedMessages;
/*    */   private RecurringTask sendTask;
/*    */   private List<SpigotMessagingListener> listeners;
/*    */   
/*    */   public SpigotMessagingService(SpigotTechPlugin paramSpigotTechPlugin) {
/* 29 */     this.plugin = paramSpigotTechPlugin;
/* 30 */     this.queuedMessages = new ArrayList<>();
/* 31 */     this.listeners = new ArrayList<>();
/*    */     
/* 33 */     this.sendTask = paramSpigotTechPlugin.getScheduler().runTaskTimer(this::SendTask, 1L, 1L);
/*    */     
/* 35 */     Bukkit.getMessenger().registerOutgoingPluginChannel((Plugin)paramSpigotTechPlugin.getBootstrap(), "BungeeCord");
/* 36 */     Bukkit.getMessenger().registerIncomingPluginChannel((Plugin)paramSpigotTechPlugin.getBootstrap(), "BungeeCord", this);
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 40 */     this.sendTask.stop();
/*    */   }
/*    */ 
/*    */   
/*    */   private void SendTask() {
/* 45 */     Player player = (Player)Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
/*    */     
/* 47 */     Iterator<QueuedMessage> iterator = this.queuedMessages.iterator();
/*    */     
/* 49 */     if (iterator.hasNext() && player != null) {
/* 50 */       QueuedMessage queuedMessage = iterator.next();
/*    */ 
/*    */       
/* 53 */       ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
/* 54 */       byteArrayDataOutput.writeUTF(this.plugin.getName() + "//" + queuedMessage.encode());
/* 55 */       player.sendPluginMessage((Plugin)this.plugin.getBootstrap(), "BungeeCord", byteArrayDataOutput.toByteArray());
/*    */       
/* 57 */       queuedMessage.onSend();
/*    */       
/* 59 */       this.queuedMessages.remove(queuedMessage);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void register(SpigotMessagingListener paramSpigotMessagingListener) {
/* 64 */     this.listeners.add(paramSpigotMessagingListener);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onPluginMessageReceived(String paramString, Player paramPlayer, byte[] paramArrayOfbyte) {
/*    */     try {
/* 70 */       DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfbyte));
/* 71 */       if (dataInputStream.available() == 0)
/*    */         return; 
/* 73 */       String str = dataInputStream.readUTF();
/*    */       
/* 75 */       if (str.startsWith(this.plugin.getName() + "//")) {
/* 76 */         Message message = Message.decode(str.replace(this.plugin.getName() + "//", ""));
/* 77 */         this.listeners.forEach(paramSpigotMessagingListener -> paramSpigotMessagingListener.onMessage(paramMessage));
/*    */       } 
/* 79 */     } catch (IOException iOException) {
/* 80 */       iOException.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void send(QueuedMessage paramQueuedMessage) {
/* 85 */     for (QueuedMessage queuedMessage : new ArrayList(this.queuedMessages)) {
/* 86 */       if (queuedMessage.encode().equals(paramQueuedMessage.encode())) {
/*    */         return;
/*    */       }
/*    */     } 
/*    */     
/* 91 */     this.queuedMessages.add(paramQueuedMessage);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/messaging/SpigotMessagingService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */