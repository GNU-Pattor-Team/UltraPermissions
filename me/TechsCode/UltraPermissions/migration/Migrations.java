/*    */ package me.TechsCode.UltraPermissions.migration;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ 
/*    */ 
/*    */ public enum Migrations
/*    */ {
/*  9 */   LuckPerms((Class)LuckPermsMigration.class),
/* 10 */   PermissionsEx((Class)PermissionsExMigration.class);
/*    */   
/*    */   private Class<? extends MigrationAssistant> migrationClass;
/*    */   
/*    */   Migrations(Class<? extends MigrationAssistant> paramClass) {
/* 15 */     this.migrationClass = paramClass;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static MigrationAssistant getMigrationAssistant() {
/* 21 */     Migrations migrations = Arrays.<Migrations>stream(values()).filter(paramMigrations -> Bukkit.getPluginManager().isPluginEnabled(paramMigrations.name())).findFirst().orElse(null);
/*    */     
/* 23 */     if (migrations == null) return null;
/*    */     
/*    */     try {
/* 26 */       return migrations.migrationClass.newInstance();
/* 27 */     } catch (InstantiationException|IllegalAccessException instantiationException) {
/* 28 */       instantiationException.printStackTrace();
/*    */ 
/*    */       
/* 31 */       return null;
/*    */     } 
/*    */   }
/*    */   public static boolean isAvailable() {
/* 35 */     return Arrays.<Migrations>stream(values()).anyMatch(paramMigrations -> Bukkit.getPluginManager().isPluginEnabled(paramMigrations.name()));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/migration/Migrations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */