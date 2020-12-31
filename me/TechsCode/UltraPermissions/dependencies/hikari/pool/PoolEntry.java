/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.pool;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.Statement;
/*     */ import java.util.Comparator;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.ClockSource;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.ConcurrentBag;
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
/*     */ final class PoolEntry
/*     */   implements ConcurrentBag.IConcurrentBagEntry
/*     */ {
/*  39 */   private static final Logger LOGGER = LoggerFactory.getLogger(PoolEntry.class);
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
/*  59 */   static final Comparator<PoolEntry> LASTACCESS_COMPARABLE = new Comparator<PoolEntry>()
/*     */     {
/*     */       public int compare(PoolEntry param1PoolEntry1, PoolEntry param1PoolEntry2) {
/*  62 */         return Long.compare(param1PoolEntry1.lastAccessed, param1PoolEntry2.lastAccessed);
/*     */       }
/*     */     };
/*     */   Connection connection;
/*     */   long lastAccessed;
/*     */   
/*     */   PoolEntry(Connection paramConnection, PoolBase paramPoolBase, boolean paramBoolean1, boolean paramBoolean2) {
/*  69 */     this.connection = paramConnection;
/*  70 */     this.hikariPool = (HikariPool)paramPoolBase;
/*  71 */     this.isReadOnly = paramBoolean1;
/*  72 */     this.isAutoCommit = paramBoolean2;
/*  73 */     this.state = new AtomicInteger();
/*  74 */     this.lastAccessed = ClockSource.INSTANCE.currentTime();
/*  75 */     this.openStatements = new FastList(Statement.class, 16);
/*     */   }
/*     */   long lastBorrowed; private volatile boolean evict; private volatile ScheduledFuture<?> endOfLife;
/*     */   private final FastList<Statement> openStatements;
/*     */   private final HikariPool hikariPool;
/*     */   private final AtomicInteger state;
/*     */   private final boolean isReadOnly;
/*     */   private final boolean isAutoCommit;
/*     */   
/*     */   void recycle(long paramLong) {
/*  85 */     this.lastAccessed = paramLong;
/*  86 */     this.hikariPool.releaseConnection(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setFutureEol(ScheduledFuture<?> paramScheduledFuture) {
/*  94 */     this.endOfLife = paramScheduledFuture;
/*     */   }
/*     */ 
/*     */   
/*     */   Connection createProxyConnection(ProxyLeakTask paramProxyLeakTask, long paramLong) {
/*  99 */     return ProxyFactory.getProxyConnection(this, this.connection, this.openStatements, paramProxyLeakTask, paramLong, this.isReadOnly, this.isAutoCommit);
/*     */   }
/*     */ 
/*     */   
/*     */   void resetConnectionState(ProxyConnection paramProxyConnection, int paramInt) {
/* 104 */     this.hikariPool.resetConnectionState(this.connection, paramProxyConnection, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   String getPoolName() {
/* 109 */     return this.hikariPool.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isMarkedEvicted() {
/* 114 */     return this.evict;
/*     */   }
/*     */ 
/*     */   
/*     */   void markEvicted() {
/* 119 */     this.evict = true;
/*     */   }
/*     */ 
/*     */   
/*     */   void evict(String paramString) {
/* 124 */     this.hikariPool.closeConnection(this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   long getMillisSinceBorrowed() {
/* 130 */     return ClockSource.INSTANCE.elapsedMillis(this.lastBorrowed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 137 */     long l = ClockSource.INSTANCE.currentTime();
/* 138 */     return this.connection + ", borrowed " + ClockSource.INSTANCE
/* 139 */       .elapsedMillis(this.lastBorrowed, l) + "ms ago, " + ", accessed " + ClockSource.INSTANCE
/* 140 */       .elapsedMillis(this.lastAccessed, l) + "ms ago, " + 
/* 141 */       stateToString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getState() {
/* 152 */     return this.state.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean compareAndSet(int paramInt1, int paramInt2) {
/* 159 */     return this.state.compareAndSet(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void lazySet(int paramInt) {
/* 166 */     this.state.lazySet(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   void close() {
/* 171 */     if (this.endOfLife != null && !this.endOfLife.isDone() && !this.endOfLife.cancel(false)) {
/* 172 */       LOGGER.warn("{} - maxLifeTime expiration task cancellation unexpectedly returned false for connection {}", getPoolName(), this.connection);
/*     */     }
/*     */     
/* 175 */     this.endOfLife = null;
/* 176 */     this.connection = null;
/*     */   }
/*     */ 
/*     */   
/*     */   private String stateToString() {
/* 181 */     switch (this.state.get()) {
/*     */       case 1:
/* 183 */         return "IN_USE";
/*     */       case 0:
/* 185 */         return "NOT_IN_USE";
/*     */       case -1:
/* 187 */         return "REMOVED";
/*     */       case -2:
/* 189 */         return "RESERVED";
/*     */     } 
/* 191 */     return "Invalid";
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/pool/PoolEntry.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */