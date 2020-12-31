/*    */ package me.TechsCode.UltraPermissions.base.loader;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class SpigotLoader
/*    */   extends JavaPlugin
/*    */ {
/*    */   private Loader loader;
/*    */   
/*    */   public void onEnable() {
/* 12 */     this.loader = new Loader(this, (Class)SpigotTechPlugin.class, getClassLoader());
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDisable() {
/* 17 */     this.loader.unload();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/loader/SpigotLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */