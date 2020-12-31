/*    */ package me.TechsCode.UltraPermissions.dependencies.hikari;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Hashtable;
/*    */ import java.util.Properties;
/*    */ import java.util.Set;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.InitialContext;
/*    */ import javax.naming.Name;
/*    */ import javax.naming.NamingException;
/*    */ import javax.naming.RefAddr;
/*    */ import javax.naming.Reference;
/*    */ import javax.naming.spi.ObjectFactory;
/*    */ import javax.sql.DataSource;
/*    */ import me.TechsCode.UltraPermissions.dependencies.hikari.util.PropertyElf;
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
/*    */ public class HikariJNDIFactory
/*    */   implements ObjectFactory
/*    */ {
/*    */   public Object getObjectInstance(Object paramObject, Name paramName, Context paramContext, Hashtable<?, ?> paramHashtable) {
/* 46 */     if (paramObject == null || !(paramObject instanceof Reference)) {
/* 47 */       return null;
/*    */     }
/*    */     
/* 50 */     Reference reference = (Reference)paramObject;
/* 51 */     if (!"javax.sql.DataSource".equals(reference.getClassName())) {
/* 52 */       throw new NamingException(reference.getClassName() + " is not a valid class name/type for this JNDI factory.");
/*    */     }
/*    */     
/* 55 */     Set set = PropertyElf.getPropertyNames(HikariConfig.class);
/*    */     
/* 57 */     Properties properties = new Properties();
/* 58 */     Enumeration<RefAddr> enumeration = reference.getAll();
/* 59 */     while (enumeration.hasMoreElements()) {
/* 60 */       RefAddr refAddr = enumeration.nextElement();
/* 61 */       String str = refAddr.getType();
/* 62 */       if (str.startsWith("dataSource.") || set.contains(str)) {
/* 63 */         properties.setProperty(str, refAddr.getContent().toString());
/*    */       }
/*    */     } 
/*    */     
/* 67 */     return createDataSource(properties, paramContext);
/*    */   }
/*    */ 
/*    */   
/*    */   private DataSource createDataSource(Properties paramProperties, Context paramContext) {
/* 72 */     if (paramProperties.getProperty("dataSourceJNDI") != null) {
/* 73 */       return lookupJndiDataSource(paramProperties, paramContext);
/*    */     }
/*    */     
/* 76 */     return new HikariDataSource(new HikariConfig(paramProperties));
/*    */   }
/*    */ 
/*    */   
/*    */   private DataSource lookupJndiDataSource(Properties paramProperties, Context paramContext) {
/* 81 */     if (paramContext == null) {
/* 82 */       throw new RuntimeException("dataSourceJNDI property is configured, but local JNDI context is null.");
/*    */     }
/*    */     
/* 85 */     String str = paramProperties.getProperty("dataSourceJNDI");
/* 86 */     DataSource dataSource = (DataSource)paramContext.lookup(str);
/* 87 */     if (dataSource == null) {
/* 88 */       paramContext = new InitialContext();
/* 89 */       dataSource = (DataSource)paramContext.lookup(str);
/* 90 */       paramContext.close();
/*    */     } 
/*    */     
/* 93 */     if (dataSource != null) {
/* 94 */       HikariConfig hikariConfig = new HikariConfig(paramProperties);
/* 95 */       hikariConfig.setDataSource(dataSource);
/* 96 */       return new HikariDataSource(hikariConfig);
/*    */     } 
/*    */     
/* 99 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/HikariJNDIFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */