/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.pool;
/*     */ 
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Savepoint;
/*     */ import java.sql.Statement;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Executor;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.ClockSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.FastList;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.LoggerFactory;
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
/*     */ 
/*     */ public abstract class ProxyConnection
/*     */   implements Connection
/*     */ {
/*     */   static final int DIRTY_BIT_READONLY = 1;
/*     */   static final int DIRTY_BIT_AUTOCOMMIT = 2;
/*     */   static final int DIRTY_BIT_ISOLATION = 4;
/*     */   static final int DIRTY_BIT_CATALOG = 8;
/*     */   static final int DIRTY_BIT_NETTIMEOUT = 16;
/*  74 */   private static final Logger LOGGER = LoggerFactory.getLogger(ProxyConnection.class); private static final Set<String> SQL_ERRORS;
/*  75 */   private static final ClockSource clockSource = ClockSource.INSTANCE; protected Connection delegate; private final PoolEntry poolEntry; private final ProxyLeakTask leakTask; private final FastList<Statement> openStatements; private int dirtyBits; private long lastAccess;
/*     */   static {
/*  77 */     SQL_ERRORS = new HashSet<>();
/*  78 */     SQL_ERRORS.add("57P01");
/*  79 */     SQL_ERRORS.add("57P02");
/*  80 */     SQL_ERRORS.add("57P03");
/*  81 */     SQL_ERRORS.add("01002");
/*  82 */     SQL_ERRORS.add("JZ0C0");
/*  83 */     SQL_ERRORS.add("JZ0C1");
/*     */   }
/*     */   private boolean isCommitStateDirty; private boolean isReadOnly; private boolean isAutoCommit; private int networkTimeout; private int transactionIsolation; private String dbcatalog;
/*     */   protected ProxyConnection(PoolEntry paramPoolEntry, Connection paramConnection, FastList<Statement> paramFastList, ProxyLeakTask paramProxyLeakTask, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/*  87 */     this.poolEntry = paramPoolEntry;
/*  88 */     this.delegate = paramConnection;
/*  89 */     this.openStatements = paramFastList;
/*  90 */     this.leakTask = paramProxyLeakTask;
/*  91 */     this.lastAccess = paramLong;
/*  92 */     this.isReadOnly = paramBoolean1;
/*  93 */     this.isAutoCommit = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 103 */     return (new StringBuilder(64)).append(getClass().getSimpleName()).append('@').append(System.identityHashCode(this)).append(" wrapping ").append(this.delegate).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final boolean getAutoCommitState() {
/* 112 */     return this.isAutoCommit;
/*     */   }
/*     */ 
/*     */   
/*     */   final String getCatalogState() {
/* 117 */     return this.dbcatalog;
/*     */   }
/*     */ 
/*     */   
/*     */   final int getTransactionIsolationState() {
/* 122 */     return this.transactionIsolation;
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean getReadOnlyState() {
/* 127 */     return this.isReadOnly;
/*     */   }
/*     */ 
/*     */   
/*     */   final int getNetworkTimeoutState() {
/* 132 */     return this.networkTimeout;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final PoolEntry getPoolEntry() {
/* 141 */     return this.poolEntry;
/*     */   }
/*     */ 
/*     */   
/*     */   final SQLException checkException(SQLException paramSQLException) {
/* 146 */     String str = paramSQLException.getSQLState();
/* 147 */     if (str != null) {
/* 148 */       boolean bool = (str.startsWith("08") || SQL_ERRORS.contains(str)) ? true : false;
/* 149 */       if (bool && this.delegate != ClosedConnection.CLOSED_CONNECTION) {
/* 150 */         LOGGER.warn("{} - Connection {} marked as broken because of SQLSTATE({}), ErrorCode({})", new Object[] { this.poolEntry
/* 151 */               .getPoolName(), this.delegate, str, Integer.valueOf(paramSQLException.getErrorCode()), paramSQLException });
/* 152 */         this.leakTask.cancel();
/* 153 */         this.poolEntry.evict("(connection broken)");
/* 154 */         this.delegate = ClosedConnection.CLOSED_CONNECTION;
/*     */       } else {
/*     */         
/* 157 */         SQLException sQLException = paramSQLException.getNextException();
/* 158 */         if (sQLException != null && sQLException != paramSQLException) {
/* 159 */           checkException(sQLException);
/*     */         }
/*     */       } 
/*     */     } 
/* 163 */     return paramSQLException;
/*     */   }
/*     */ 
/*     */   
/*     */   final void untrackStatement(Statement paramStatement) {
/* 168 */     this.openStatements.remove(paramStatement);
/*     */   }
/*     */ 
/*     */   
/*     */   final void markCommitStateDirty() {
/* 173 */     if (this.isAutoCommit) {
/* 174 */       this.lastAccess = clockSource.currentTime();
/*     */     } else {
/*     */       
/* 177 */       this.isCommitStateDirty = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void cancelLeakTask() {
/* 186 */     this.leakTask.cancel();
/*     */   }
/*     */ 
/*     */   
/*     */   private final <T extends Statement> T trackStatement(T paramT) {
/* 191 */     this.openStatements.add(paramT);
/*     */     
/* 193 */     return paramT;
/*     */   }
/*     */ 
/*     */   
/*     */   private final void closeStatements() {
/* 198 */     int i = this.openStatements.size();
/* 199 */     if (i > 0) {
/* 200 */       for (byte b = 0; b < i && this.delegate != ClosedConnection.CLOSED_CONNECTION; b++) {
/*     */         try {
/* 202 */           Statement statement = (Statement)this.openStatements.get(b);
/* 203 */           if (statement != null) {
/* 204 */             statement.close();
/*     */           }
/*     */         }
/* 207 */         catch (SQLException sQLException) {
/* 208 */           checkException(sQLException);
/*     */         } 
/*     */       } 
/*     */       
/* 212 */       this.openStatements.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void close() {
/* 225 */     closeStatements();
/*     */     
/* 227 */     if (this.delegate != ClosedConnection.CLOSED_CONNECTION) {
/* 228 */       this.leakTask.cancel();
/*     */       
/*     */       try {
/* 231 */         if (this.isCommitStateDirty && !this.isAutoCommit && !this.isReadOnly) {
/* 232 */           this.delegate.rollback();
/* 233 */           this.lastAccess = clockSource.currentTime();
/* 234 */           LOGGER.debug("{} - Executed rollback on connection {} due to dirty commit state on close().", this.poolEntry.getPoolName(), this.delegate);
/*     */         } 
/*     */         
/* 237 */         if (this.dirtyBits != 0) {
/* 238 */           this.poolEntry.resetConnectionState(this, this.dirtyBits);
/* 239 */           this.lastAccess = clockSource.currentTime();
/*     */         } 
/*     */         
/* 242 */         this.delegate.clearWarnings();
/*     */       }
/* 244 */       catch (SQLException sQLException) {
/*     */         
/* 246 */         if (!this.poolEntry.isMarkedEvicted()) {
/* 247 */           throw checkException(sQLException);
/*     */         }
/*     */       } finally {
/*     */         
/* 251 */         this.delegate = ClosedConnection.CLOSED_CONNECTION;
/* 252 */         this.poolEntry.recycle(this.lastAccess);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() {
/* 261 */     return (this.delegate == ClosedConnection.CLOSED_CONNECTION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement() {
/* 268 */     return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement(int paramInt1, int paramInt2) {
/* 275 */     return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement(paramInt1, paramInt2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement(int paramInt1, int paramInt2, int paramInt3) {
/* 282 */     return ProxyFactory.getProxyStatement(this, trackStatement(this.delegate.createStatement(paramInt1, paramInt2, paramInt3)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String paramString) {
/* 289 */     return ProxyFactory.getProxyCallableStatement(this, trackStatement(this.delegate.prepareCall(paramString)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String paramString, int paramInt1, int paramInt2) {
/* 296 */     return ProxyFactory.getProxyCallableStatement(this, trackStatement(this.delegate.prepareCall(paramString, paramInt1, paramInt2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 303 */     return ProxyFactory.getProxyCallableStatement(this, trackStatement(this.delegate.prepareCall(paramString, paramInt1, paramInt2, paramInt3)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String paramString) {
/* 310 */     return ProxyFactory.getProxyPreparedStatement(this, trackStatement(this.delegate.prepareStatement(paramString)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String paramString, int paramInt) {
/* 317 */     return ProxyFactory.getProxyPreparedStatement(this, trackStatement(this.delegate.prepareStatement(paramString, paramInt)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String paramString, int paramInt1, int paramInt2) {
/* 324 */     return ProxyFactory.getProxyPreparedStatement(this, trackStatement(this.delegate.prepareStatement(paramString, paramInt1, paramInt2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 331 */     return ProxyFactory.getProxyPreparedStatement(this, trackStatement(this.delegate.prepareStatement(paramString, paramInt1, paramInt2, paramInt3)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String paramString, int[] paramArrayOfint) {
/* 338 */     return ProxyFactory.getProxyPreparedStatement(this, trackStatement(this.delegate.prepareStatement(paramString, paramArrayOfint)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String paramString, String[] paramArrayOfString) {
/* 345 */     return ProxyFactory.getProxyPreparedStatement(this, trackStatement(this.delegate.prepareStatement(paramString, paramArrayOfString)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit() {
/* 352 */     this.delegate.commit();
/* 353 */     this.isCommitStateDirty = false;
/* 354 */     this.lastAccess = clockSource.currentTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback() {
/* 361 */     this.delegate.rollback();
/* 362 */     this.isCommitStateDirty = false;
/* 363 */     this.lastAccess = clockSource.currentTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(Savepoint paramSavepoint) {
/* 370 */     this.delegate.rollback(paramSavepoint);
/* 371 */     this.isCommitStateDirty = false;
/* 372 */     this.lastAccess = clockSource.currentTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoCommit(boolean paramBoolean) {
/* 379 */     this.delegate.setAutoCommit(paramBoolean);
/* 380 */     this.isAutoCommit = paramBoolean;
/* 381 */     this.dirtyBits |= 0x2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean paramBoolean) {
/* 388 */     this.delegate.setReadOnly(paramBoolean);
/* 389 */     this.isReadOnly = paramBoolean;
/* 390 */     this.dirtyBits |= 0x1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionIsolation(int paramInt) {
/* 397 */     this.delegate.setTransactionIsolation(paramInt);
/* 398 */     this.transactionIsolation = paramInt;
/* 399 */     this.dirtyBits |= 0x4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatalog(String paramString) {
/* 406 */     this.delegate.setCatalog(paramString);
/* 407 */     this.dbcatalog = paramString;
/* 408 */     this.dirtyBits |= 0x8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNetworkTimeout(Executor paramExecutor, int paramInt) {
/* 415 */     this.delegate.setNetworkTimeout(paramExecutor, paramInt);
/* 416 */     this.networkTimeout = paramInt;
/* 417 */     this.dirtyBits |= 0x10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isWrapperFor(Class<?> paramClass) {
/* 424 */     return (paramClass.isInstance(this.delegate) || (this.delegate instanceof java.sql.Wrapper && this.delegate.isWrapperFor(paramClass)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T unwrap(Class<T> paramClass) {
/* 432 */     if (paramClass.isInstance(this.delegate)) {
/* 433 */       return (T)this.delegate;
/*     */     }
/* 435 */     if (this.delegate instanceof java.sql.Wrapper) {
/* 436 */       return this.delegate.unwrap(paramClass);
/*     */     }
/*     */     
/* 439 */     throw new SQLException("Wrapped connection is not an instance of " + paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class ClosedConnection
/*     */   {
/* 448 */     static final Connection CLOSED_CONNECTION = getClosedConnection();
/*     */ 
/*     */     
/*     */     private static Connection getClosedConnection() {
/* 452 */       InvocationHandler invocationHandler = new InvocationHandler()
/*     */         {
/*     */           
/*     */           public Object invoke(Object param2Object, Method param2Method, Object[] param2ArrayOfObject)
/*     */           {
/* 457 */             String str = param2Method.getName();
/* 458 */             if ("abort".equals(str)) {
/* 459 */               return void.class;
/*     */             }
/* 461 */             if ("isValid".equals(str)) {
/* 462 */               return Boolean.FALSE;
/*     */             }
/* 464 */             if ("toString".equals(str)) {
/* 465 */               return ProxyConnection.ClosedConnection.class.getCanonicalName();
/*     */             }
/*     */             
/* 468 */             throw new SQLException("Connection is closed");
/*     */           }
/*     */         };
/*     */       
/* 472 */       return (Connection)Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[] { Connection.class }, invocationHandler);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/ProxyConnection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */