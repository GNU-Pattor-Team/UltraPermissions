/*    */ package me.TechsCode.UltraPermissions.base.loader.reloader;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.lang.reflect.Field;
/*    */ import java.net.URLClassLoader;
/*    */ import java.net.URLDecoder;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.SortedSet;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.CommandMap;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.command.SimpleCommandMap;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.RegisteredListener;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class SpigotPluginReloader
/*    */   extends PluginReloader<SpigotTechPlugin> {
/*    */   public SpigotPluginReloader(SpigotTechPlugin paramSpigotTechPlugin) {
/* 24 */     super(paramSpigotTechPlugin);
/*    */   }
/*    */ 
/*    */   
/*    */   public void unload() {
/* 29 */     Bukkit.getPluginManager().disablePlugin((Plugin)this.plugin.getBootstrap());
/*    */ 
/*    */     
/*    */     try {
/* 33 */       Field field = Bukkit.getPluginManager().getClass().getDeclaredField("listeners");
/* 34 */       field.setAccessible(true);
/* 35 */       Map map = (Map)field.get(Bukkit.getPluginManager());
/*    */       
/* 37 */       map.values().forEach(paramSortedSet -> paramSortedSet.removeIf(()));
/* 38 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/*    */     try {
/* 42 */       Field field1 = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
/* 43 */       field1.setAccessible(true);
/* 44 */       SimpleCommandMap simpleCommandMap = (SimpleCommandMap)field1.get(Bukkit.getPluginManager());
/*    */       
/* 46 */       Field field2 = SimpleCommandMap.class.getDeclaredField("knownCommands");
/* 47 */       field2.setAccessible(true);
/* 48 */       Map map = (Map)field2.get(simpleCommandMap);
/*    */       
/* 50 */       for (Iterator<Map.Entry> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
/* 51 */         Map.Entry entry = iterator.next();
/* 52 */         if (entry.getValue() instanceof PluginCommand) {
/* 53 */           PluginCommand pluginCommand = (PluginCommand)entry.getValue();
/* 54 */           if (pluginCommand.getPlugin() == this.plugin.getBootstrap()) {
/* 55 */             pluginCommand.unregister((CommandMap)simpleCommandMap);
/* 56 */             iterator.remove();
/*    */           } 
/*    */         } 
/*    */       } 
/* 60 */     } catch (NoSuchFieldException|IllegalAccessException noSuchFieldException) {
/* 61 */       noSuchFieldException.printStackTrace();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 66 */     ClassLoader classLoader = ((JavaPlugin)this.plugin.getBootstrap()).getClass().getClassLoader();
/* 67 */     if (classLoader instanceof URLClassLoader) {
/*    */       try {
/* 69 */         Field field1 = classLoader.getClass().getDeclaredField("plugin");
/* 70 */         field1.setAccessible(true);
/* 71 */         field1.set(classLoader, null);
/*    */         
/* 73 */         Field field2 = classLoader.getClass().getDeclaredField("pluginInit");
/* 74 */         field2.setAccessible(true);
/* 75 */         field2.set(classLoader, null);
/* 76 */       } catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException noSuchFieldException) {
/* 77 */         noSuchFieldException.printStackTrace();
/*    */       } 
/*    */       
/*    */       try {
/* 81 */         ((URLClassLoader)classLoader).close();
/* 82 */       } catch (IOException iOException) {
/* 83 */         iOException.printStackTrace();
/*    */       } 
/*    */     } 
/*    */     
/* 87 */     System.gc();
/*    */   }
/*    */ 
/*    */   
/*    */   public void load() {
/*    */     try {
/* 93 */       File file = new File(URLDecoder.decode(this.plugin.getClass().getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8"));
/* 94 */       Plugin plugin = Bukkit.getPluginManager().loadPlugin(file);
/* 95 */       plugin.onLoad();
/* 96 */       Bukkit.getPluginManager().enablePlugin(plugin);
/* 97 */     } catch (UnsupportedEncodingException|org.bukkit.plugin.InvalidDescriptionException|org.bukkit.plugin.InvalidPluginException unsupportedEncodingException) {
/* 98 */       unsupportedEncodingException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/loader/reloader/SpigotPluginReloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */