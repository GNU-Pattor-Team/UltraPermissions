package me.TechsCode.UltraPermissions.dependencies.hikari;

public interface HikariConfigMXBean {
  long getConnectionTimeout();
  
  void setConnectionTimeout(long paramLong);
  
  long getValidationTimeout();
  
  void setValidationTimeout(long paramLong);
  
  long getIdleTimeout();
  
  void setIdleTimeout(long paramLong);
  
  long getLeakDetectionThreshold();
  
  void setLeakDetectionThreshold(long paramLong);
  
  long getMaxLifetime();
  
  void setMaxLifetime(long paramLong);
  
  int getMinimumIdle();
  
  void setMinimumIdle(int paramInt);
  
  int getMaximumPoolSize();
  
  void setMaximumPoolSize(int paramInt);
  
  void setPassword(String paramString);
  
  void setUsername(String paramString);
  
  String getPoolName();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/HikariConfigMXBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */