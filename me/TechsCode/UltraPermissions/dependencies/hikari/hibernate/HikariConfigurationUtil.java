/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari.hibernate;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Properties;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.HikariConfig;
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
/*    */ public class HikariConfigurationUtil
/*    */ {
/*    */   public static final String CONFIG_PREFIX = "hibernate.hikari.";
/*    */   public static final String CONFIG_PREFIX_DATASOURCE = "hibernate.hikari.dataSource.";
/*    */   
/*    */   public static HikariConfig loadConfiguration(Map paramMap) {
/* 45 */     Properties properties = new Properties();
/* 46 */     copyProperty("hibernate.connection.isolation", paramMap, "transactionIsolation", properties);
/* 47 */     copyProperty("hibernate.connection.autocommit", paramMap, "autoCommit", properties);
/* 48 */     copyProperty("hibernate.connection.driver_class", paramMap, "driverClassName", properties);
/* 49 */     copyProperty("hibernate.connection.url", paramMap, "jdbcUrl", properties);
/* 50 */     copyProperty("hibernate.connection.username", paramMap, "username", properties);
/* 51 */     copyProperty("hibernate.connection.password", paramMap, "password", properties);
/*    */     
/* 53 */     for (String str1 : paramMap.keySet()) {
/* 54 */       String str2 = str1;
/* 55 */       if (str2.startsWith("hibernate.hikari.")) {
/* 56 */         properties.setProperty(str2.substring("hibernate.hikari.".length()), (String)paramMap.get(str2));
/*    */       }
/*    */     } 
/*    */     
/* 60 */     return new HikariConfig(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void copyProperty(String paramString1, Map paramMap, String paramString2, Properties paramProperties) {
/* 66 */     if (paramMap.containsKey(paramString1))
/* 67 */       paramProperties.setProperty(paramString2, (String)paramMap.get(paramString1)); 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/hibernate/HikariConfigurationUtil.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */