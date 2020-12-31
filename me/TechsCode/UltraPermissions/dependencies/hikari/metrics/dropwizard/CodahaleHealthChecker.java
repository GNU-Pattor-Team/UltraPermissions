/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.metrics.dropwizard;
/*     */ 
/*     */ import com.codahale.metrics.Metric;
/*     */ import com.codahale.metrics.MetricFilter;
/*     */ import com.codahale.metrics.MetricRegistry;
/*     */ import com.codahale.metrics.Timer;
/*     */ import com.codahale.metrics.health.HealthCheck;
/*     */ import com.codahale.metrics.health.HealthCheckRegistry;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.SortedMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariConfig;
/*     */ import me.TechsCode.UltraPermissions.dependencies.hikari.pool.HikariPool;
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
/*     */ public final class CodahaleHealthChecker
/*     */ {
/*     */   public static void registerHealthChecks(HikariPool paramHikariPool, final HikariConfig hikariConfig, HealthCheckRegistry paramHealthCheckRegistry) {
/*  60 */     Properties properties = hikariConfig.getHealthCheckProperties();
/*  61 */     MetricRegistry metricRegistry = (MetricRegistry)hikariConfig.getMetricRegistry();
/*     */     
/*  63 */     long l1 = Long.parseLong(properties.getProperty("connectivityCheckTimeoutMs", String.valueOf(hikariConfig.getConnectionTimeout())));
/*  64 */     paramHealthCheckRegistry.register(MetricRegistry.name(hikariConfig.getPoolName(), new String[] { "pool", "ConnectivityCheck" }), new ConnectivityHealthCheck(paramHikariPool, l1));
/*     */     
/*  66 */     long l2 = Long.parseLong(properties.getProperty("expected99thPercentileMs", "0"));
/*  67 */     if (metricRegistry != null && l2 > 0L) {
/*  68 */       SortedMap sortedMap = metricRegistry.getTimers(new MetricFilter()
/*     */           {
/*     */             public boolean matches(String param1String, Metric param1Metric)
/*     */             {
/*  72 */               return param1String.equals(MetricRegistry.name(hikariConfig.getPoolName(), new String[] { "pool", "Wait" }));
/*     */             }
/*     */           });
/*     */       
/*  76 */       if (!sortedMap.isEmpty()) {
/*  77 */         Timer timer = (Timer)((Map.Entry)sortedMap.entrySet().iterator().next()).getValue();
/*  78 */         paramHealthCheckRegistry.register(MetricRegistry.name(hikariConfig.getPoolName(), new String[] { "pool", "Connection99Percent" }), new Connection99Percent(timer, l2));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class ConnectivityHealthCheck
/*     */     extends HealthCheck
/*     */   {
/*     */     private final HikariPool pool;
/*     */ 
/*     */     
/*     */     private final long checkTimeoutMs;
/*     */ 
/*     */     
/*     */     ConnectivityHealthCheck(HikariPool param1HikariPool, long param1Long) {
/*  95 */       this.pool = param1HikariPool;
/*  96 */       this.checkTimeoutMs = (param1Long > 0L && param1Long != 2147483647L) ? param1Long : TimeUnit.SECONDS.toMillis(10L);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected HealthCheck.Result check() {
/* 103 */       Connection connection = null;
/*     */       try {
/* 105 */         connection = this.pool.getConnection(this.checkTimeoutMs);
/* 106 */         return HealthCheck.Result.healthy();
/*     */       }
/* 108 */       catch (SQLException sQLException) {
/* 109 */         return HealthCheck.Result.unhealthy(sQLException);
/*     */       } finally {
/*     */         
/* 112 */         if (connection != null) {
/* 113 */           connection.close();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Connection99Percent
/*     */     extends HealthCheck
/*     */   {
/*     */     private final Timer waitTimer;
/*     */     private final long expected99thPercentile;
/*     */     
/*     */     Connection99Percent(Timer param1Timer, long param1Long) {
/* 126 */       this.waitTimer = param1Timer;
/* 127 */       this.expected99thPercentile = param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected HealthCheck.Result check() {
/* 134 */       long l = TimeUnit.NANOSECONDS.toMillis(Math.round(this.waitTimer.getSnapshot().get99thPercentile()));
/* 135 */       return (l <= this.expected99thPercentile) ? HealthCheck.Result.healthy() : HealthCheck.Result.unhealthy("99th percentile connection wait time of %dms exceeds the threshold %dms", new Object[] { Long.valueOf(l), Long.valueOf(this.expected99thPercentile) });
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/metrics/dropwizard/CodahaleHealthChecker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */