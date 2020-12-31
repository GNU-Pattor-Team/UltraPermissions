/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari.pool;
/*    */ 
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
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
/*    */ 
/*    */ public abstract class ProxyPreparedStatement
/*    */   extends ProxyStatement
/*    */   implements PreparedStatement
/*    */ {
/*    */   protected ProxyPreparedStatement(ProxyConnection paramProxyConnection, PreparedStatement paramPreparedStatement) {
/* 32 */     super(paramProxyConnection, paramPreparedStatement);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean execute() {
/* 43 */     this.connection.markCommitStateDirty();
/* 44 */     return ((PreparedStatement)this.delegate).execute();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ResultSet executeQuery() {
/* 51 */     this.connection.markCommitStateDirty();
/* 52 */     ResultSet resultSet = ((PreparedStatement)this.delegate).executeQuery();
/* 53 */     return ProxyFactory.getProxyResultSet(this.connection, this, resultSet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int executeUpdate() {
/* 60 */     this.connection.markCommitStateDirty();
/* 61 */     return ((PreparedStatement)this.delegate).executeUpdate();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long executeLargeUpdate() {
/* 68 */     this.connection.markCommitStateDirty();
/* 69 */     return ((PreparedStatement)this.delegate).executeLargeUpdate();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/ProxyPreparedStatement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */