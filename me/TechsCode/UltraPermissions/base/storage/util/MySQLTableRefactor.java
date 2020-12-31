/*    */ package me.TechsCode.UltraPermissions.base.storage.util;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ 
/*    */ public abstract class MySQLTableRefactor
/*    */ {
/*    */   public class RefactorTable
/*    */   {
/*    */     private String from;
/*    */     private String to;
/*    */     
/*    */     public RefactorTable(String param1String1, String param1String2) {
/* 17 */       this.from = param1String1;
/* 18 */       this.to = param1String2;
/*    */     }
/*    */   }
/*    */   
/*    */   public MySQLTableRefactor(TechPlugin paramTechPlugin) {
/* 23 */     if (!paramTechPlugin.getMySQLManager().isEnabled()) {
/*    */       return;
/*    */     }
/*    */     
/*    */     try {
/* 28 */       Connection connection = paramTechPlugin.getMySQLManager().newConnection();
/*    */       
/* 30 */       for (RefactorTable refactorTable : getRefactors()) {
/* 31 */         if (tableExist(connection, refactorTable.from)) {
/* 32 */           if (tableExist(connection, refactorTable.to)) {
/* 33 */             paramTechPlugin.log("Archiving Table " + refactorTable.to);
/* 34 */             tableRename(connection, refactorTable.to, "OLD_" + refactorTable.to);
/*    */           } 
/*    */           
/* 37 */           paramTechPlugin.log("Renaming Table " + refactorTable.from + " to " + refactorTable.to);
/* 38 */           tableRename(connection, refactorTable.from, refactorTable.to);
/*    */         } 
/*    */       } 
/*    */       
/* 42 */       connection.close();
/* 43 */     } catch (SQLException sQLException) {
/* 44 */       sQLException.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean tableExist(Connection paramConnection, String paramString) {
/* 49 */     boolean bool = false;
/* 50 */     try (ResultSet null = paramConnection.getMetaData().getTables(null, null, paramString, null)) {
/* 51 */       while (resultSet.next()) {
/* 52 */         String str = resultSet.getString("TABLE_NAME");
/* 53 */         if (str != null && str.equals(paramString)) {
/* 54 */           bool = true;
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } 
/* 59 */     return bool;
/*    */   }
/*    */   
/*    */   private void tableDelete(Connection paramConnection, String paramString) {
/* 63 */     Statement statement = paramConnection.createStatement();
/*    */     
/* 65 */     statement.executeUpdate("DROP TABLE " + paramString + ";");
/* 66 */     statement.close();
/*    */   }
/*    */   
/*    */   private void tableRename(Connection paramConnection, String paramString1, String paramString2) {
/* 70 */     Statement statement = paramConnection.createStatement();
/*    */     
/* 72 */     statement.executeUpdate("RENAME TABLE " + paramString1 + " TO " + paramString2 + ";");
/* 73 */     statement.close();
/*    */   }
/*    */   
/*    */   public abstract RefactorTable[] getRefactors();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/util/MySQLTableRefactor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */