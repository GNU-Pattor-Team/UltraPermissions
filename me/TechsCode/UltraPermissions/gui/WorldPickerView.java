/*    */ package me.TechsCode.UltraPermissions.gui;
/*    */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*    */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*    */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public abstract class WorldPickerView extends PageableGUI<World> {
/*    */   public WorldPickerView(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/* 19 */     super(paramPlayer, paramSpigotTechPlugin);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SearchFeature<World> getSearch() {
/* 26 */     return (SearchFeature<World>)new BasicSearch<World>()
/*    */       {
/*    */         public String[] getSearchableText(World param1World) {
/* 29 */           return new String[] { param1World.getName() };
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public World[] getObjects() {
/* 36 */     return (World[])Bukkit.getWorlds().toArray((Object[])new World[0]);
/*    */   }
/*    */   
/* 39 */   private static final Phrase ENTRY_ACTION = Phrase.create("worldPickerView.entry.action", "Click to **select** World", Colors.GRAY, new Color[] { Colors.YELLOW });
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, World paramWorld) {
/* 43 */     paramButton.material(XMaterial.YELLOW_STAINED_GLASS)
/* 44 */       .name(Animation.wave(paramWorld.getName(), new Color[] { Colors.YELLOW, Colors.WHITE
/* 45 */           })).lore(new String[] {
/* 46 */           ENTRY_ACTION.get()
/*    */         });
/*    */     
/* 49 */     paramButton.action(paramActionType -> onSelect(paramWorld));
/*    */   }
/*    */   
/*    */   public abstract void onSelect(World paramWorld);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/WorldPickerView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */