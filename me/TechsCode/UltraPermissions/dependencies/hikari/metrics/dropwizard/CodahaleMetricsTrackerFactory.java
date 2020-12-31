/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari.metrics.dropwizard;
/*    */ 
/*    */ import com.codahale.metrics.MetricRegistry;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.MetricsTracker;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.MetricsTrackerFactory;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.metrics.PoolStats;
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
/*    */ public final class CodahaleMetricsTrackerFactory
/*    */   implements MetricsTrackerFactory
/*    */ {
/*    */   private final MetricRegistry registry;
/*    */   
/*    */   public CodahaleMetricsTrackerFactory(MetricRegistry paramMetricRegistry) {
/* 30 */     this.registry = paramMetricRegistry;
/*    */   }
/*    */ 
/*    */   
/*    */   public MetricRegistry getRegistry() {
/* 35 */     return this.registry;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MetricsTracker create(String paramString, PoolStats paramPoolStats) {
/* 41 */     return new CodaHaleMetricsTracker(paramString, paramPoolStats, this.registry);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/metrics/dropwizard/CodahaleMetricsTrackerFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */