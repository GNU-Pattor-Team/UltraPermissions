/*    */ package me.TechsCode.UltraPermissions.base.loader.reloader;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ 
/*    */ public abstract class PluginReloader<PLUGIN extends TechPlugin<?>>
/*    */ {
/*    */   protected PLUGIN plugin;
/*    */   
/*    */   public PluginReloader(PLUGIN paramPLUGIN) {
/* 10 */     this.plugin = paramPLUGIN;
/*    */   }
/*    */   
/*    */   public abstract void unload();
/*    */   
/*    */   public abstract void load();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/loader/reloader/PluginReloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */