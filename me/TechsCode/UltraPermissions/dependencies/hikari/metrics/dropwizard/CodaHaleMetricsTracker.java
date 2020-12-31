/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.metrics.dropwizard;
/*     */ 
/*     */ import com.codahale.metrics.Gauge;
/*     */ import com.codahale.metrics.Histogram;
/*     */ import com.codahale.metrics.Metric;
/*     */ import com.codahale.metrics.MetricRegistry;
/*     */ import com.codahale.metrics.Timer;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.MetricsTracker;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.PoolStats;
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
/*     */ public final class CodaHaleMetricsTracker
/*     */   extends MetricsTracker
/*     */ {
/*     */   private final String poolName;
/*     */   private final Timer connectionObtainTimer;
/*     */   private final Histogram connectionUsage;
/*     */   private final MetricRegistry registry;
/*     */   
/*     */   public CodaHaleMetricsTracker(String paramString, final PoolStats poolStats, MetricRegistry paramMetricRegistry) {
/*  37 */     this.poolName = paramString;
/*  38 */     this.registry = paramMetricRegistry;
/*  39 */     this.connectionObtainTimer = paramMetricRegistry.timer(MetricRegistry.name(paramString, new String[] { "pool", "Wait" }));
/*  40 */     this.connectionUsage = paramMetricRegistry.histogram(MetricRegistry.name(paramString, new String[] { "pool", "Usage" }));
/*     */     
/*  42 */     paramMetricRegistry.register(MetricRegistry.name(paramString, new String[] { "pool", "TotalConnections" }), (Metric)new Gauge<Integer>()
/*     */         {
/*     */           public Integer getValue()
/*     */           {
/*  46 */             return Integer.valueOf(poolStats.getTotalConnections());
/*     */           }
/*     */         });
/*     */     
/*  50 */     paramMetricRegistry.register(MetricRegistry.name(paramString, new String[] { "pool", "IdleConnections" }), (Metric)new Gauge<Integer>()
/*     */         {
/*     */           public Integer getValue()
/*     */           {
/*  54 */             return Integer.valueOf(poolStats.getIdleConnections());
/*     */           }
/*     */         });
/*     */     
/*  58 */     paramMetricRegistry.register(MetricRegistry.name(paramString, new String[] { "pool", "ActiveConnections" }), (Metric)new Gauge<Integer>()
/*     */         {
/*     */           public Integer getValue()
/*     */           {
/*  62 */             return Integer.valueOf(poolStats.getActiveConnections());
/*     */           }
/*     */         });
/*     */     
/*  66 */     paramMetricRegistry.register(MetricRegistry.name(paramString, new String[] { "pool", "PendingConnections" }), (Metric)new Gauge<Integer>()
/*     */         {
/*     */           public Integer getValue()
/*     */           {
/*  70 */             return Integer.valueOf(poolStats.getPendingThreads());
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  79 */     this.registry.remove(MetricRegistry.name(this.poolName, new String[] { "pool", "Wait" }));
/*  80 */     this.registry.remove(MetricRegistry.name(this.poolName, new String[] { "pool", "Usage" }));
/*  81 */     this.registry.remove(MetricRegistry.name(this.poolName, new String[] { "pool", "TotalConnections" }));
/*  82 */     this.registry.remove(MetricRegistry.name(this.poolName, new String[] { "pool", "IdleConnections" }));
/*  83 */     this.registry.remove(MetricRegistry.name(this.poolName, new String[] { "pool", "ActiveConnections" }));
/*  84 */     this.registry.remove(MetricRegistry.name(this.poolName, new String[] { "pool", "PendingConnections" }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void recordConnectionAcquiredNanos(long paramLong) {
/*  91 */     this.connectionObtainTimer.update(paramLong, TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void recordConnectionUsageMillis(long paramLong) {
/*  98 */     this.connectionUsage.update(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public Timer getConnectionAcquisitionTimer() {
/* 103 */     return this.connectionObtainTimer;
/*     */   }
/*     */ 
/*     */   
/*     */   public Histogram getConnectionDurationHistogram() {
/* 108 */     return this.connectionUsage;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/metrics/dropwizard/CodaHaleMetricsTracker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */