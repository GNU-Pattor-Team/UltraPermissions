/*    */ package me.TechsCode.UltraPermissions.base.storage.implementations;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.WriteCallback;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MySQLQueue
/*    */ {
/*    */   private TechPlugin plugin;
/*    */   private boolean querying;
/*    */   private List<QueueEntry> queue;
/*    */   
/*    */   public MySQLQueue(TechPlugin paramTechPlugin) {
/* 20 */     this.plugin = paramTechPlugin;
/*    */     
/* 22 */     this.querying = false;
/* 23 */     this.queue = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public void update(String paramString, WriteCallback paramWriteCallback) {
/* 27 */     this.queue.add(new QueueEntry(paramString, paramWriteCallback));
/*    */ 
/*    */     
/* 30 */     if (!this.querying) {
/* 31 */       processQueue(null);
/*    */     }
/*    */   }
/*    */   
/*    */   private void processQueue(Connection paramConnection) {
/* 36 */     this.querying = true;
/*    */     
/* 38 */     Connection connection1 = paramConnection;
/*    */     
/*    */     try {
/* 41 */       if (connection1 == null) {
/* 42 */         connection1 = this.plugin.getMySQLManager().newConnection();
/*    */       }
/* 44 */     } catch (SQLException sQLException) {
/* 45 */       this.plugin.log("Could not process MySQL Queue:");
/* 46 */       this.plugin.log(sQLException.getMessage());
/*    */       
/*    */       return;
/*    */     } 
/* 50 */     Connection connection2 = connection1;
/*    */     
/* 52 */     this.plugin.getScheduler().runAsync(() -> {
/*    */           QueueEntry queueEntry = this.queue.get(0);
/*    */           
/*    */           this.queue.remove(0);
/*    */           
/*    */           try {
/*    */             PreparedStatement preparedStatement = paramConnection.prepareStatement(queueEntry.sql);
/*    */             
/*    */             preparedStatement.execute();
/*    */             
/*    */             preparedStatement.close();
/*    */             
/*    */             queueEntry.writeCallback.onSuccess();
/*    */             
/*    */             if (this.queue.isEmpty()) {
/*    */               paramConnection.close();
/*    */               this.querying = false;
/*    */               return;
/*    */             } 
/* 71 */           } catch (SQLException sQLException) {
/*    */             queueEntry.writeCallback.onFailure(sQLException);
/*    */           } 
/*    */           processQueue(paramConnection);
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public class QueueEntry
/*    */   {
/*    */     String sql;
/*    */     WriteCallback writeCallback;
/*    */     
/*    */     public QueueEntry(String param1String, WriteCallback param1WriteCallback) {
/* 85 */       this.sql = param1String;
/* 86 */       this.writeCallback = param1WriteCallback;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/implementations/MySQLQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */