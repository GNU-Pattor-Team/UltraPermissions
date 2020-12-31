/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.pool;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ProxyResultSet
/*     */   implements ResultSet
/*     */ {
/*     */   protected final ProxyConnection connection;
/*     */   protected final ProxyStatement statement;
/*     */   protected final ResultSet delegate;
/*     */   
/*     */   protected ProxyResultSet(ProxyConnection paramProxyConnection, ProxyStatement paramProxyStatement, ResultSet paramResultSet) {
/*  37 */     this.connection = paramProxyConnection;
/*  38 */     this.statement = paramProxyStatement;
/*  39 */     this.delegate = paramResultSet;
/*     */   }
/*     */ 
/*     */   
/*     */   final SQLException checkException(SQLException paramSQLException) {
/*  44 */     return this.connection.checkException(paramSQLException);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  54 */     return (new StringBuilder(64)).append(getClass().getSimpleName()).append('@').append(System.identityHashCode(this)).append(" wrapping ").append(this.delegate).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Statement getStatement() {
/*  65 */     return this.statement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateRow() {
/*  72 */     this.connection.markCommitStateDirty();
/*  73 */     this.delegate.updateRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertRow() {
/*  80 */     this.connection.markCommitStateDirty();
/*  81 */     this.delegate.insertRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteRow() {
/*  88 */     this.connection.markCommitStateDirty();
/*  89 */     this.delegate.deleteRow();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T unwrap(Class<T> paramClass) {
/*  97 */     if (paramClass.isInstance(this.delegate)) {
/*  98 */       return (T)this.delegate;
/*     */     }
/* 100 */     if (this.delegate instanceof java.sql.Wrapper) {
/* 101 */       return this.delegate.unwrap(paramClass);
/*     */     }
/*     */     
/* 104 */     throw new SQLException("Wrapped ResultSet is not an instance of " + paramClass);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/ProxyResultSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */