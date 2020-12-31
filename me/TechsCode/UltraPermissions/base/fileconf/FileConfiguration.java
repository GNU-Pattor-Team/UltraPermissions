/*    */ package me.TechsCode.UltraPermissions.base.fileconf;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import me.TechsCode.UltraPermissions.base.BungeeTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.fileconf.impl.BungeeFileConfiguration;
/*    */ import me.TechsCode.UltraPermissions.base.fileconf.impl.SpigotFileConfiguration;
/*    */ 
/*    */ 
/*    */ public class FileConfiguration
/*    */   implements Configuration
/*    */ {
/*    */   private Configuration configuration;
/*    */   
/*    */   public FileConfiguration(TechPlugin<?> paramTechPlugin, File paramFile) {
/* 20 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 21 */     hashMap.put(SpigotTechPlugin.class, SpigotFileConfiguration.class);
/* 22 */     hashMap.put(BungeeTechPlugin.class, BungeeFileConfiguration.class);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     Class<Configuration> clazz = (Class)hashMap.entrySet().stream().filter(paramEntry -> ((Class)paramEntry.getKey()).isInstance(paramTechPlugin)).map(Map.Entry::getValue).findFirst().orElse(null);
/*    */     
/* 29 */     if (clazz == null) {
/* 30 */       throw new IllegalStateException("Could not find File Configuration Implementation");
/*    */     }
/*    */     
/*    */     try {
/* 34 */       this.configuration = clazz.getDeclaredConstructor(new Class[] { File.class }).newInstance(new Object[] { paramFile });
/* 35 */     } catch (InstantiationException|IllegalAccessException|java.lang.reflect.InvocationTargetException|NoSuchMethodException instantiationException) {
/* 36 */       instantiationException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Object get(String paramString) {
/* 42 */     return this.configuration.get(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getInt(String paramString) {
/* 47 */     return this.configuration.getInt(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getString(String paramString) {
/* 52 */     return this.configuration.getString(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean getBoolean(String paramString) {
/* 57 */     return this.configuration.getBoolean(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<String> getKeys(boolean paramBoolean) {
/* 62 */     return this.configuration.getKeys(paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean contains(String paramString) {
/* 67 */     return this.configuration.contains(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(String paramString, Object paramObject) {
/* 72 */     this.configuration.set(paramString, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public void save() {
/* 77 */     this.configuration.save();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/fileconf/FileConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */