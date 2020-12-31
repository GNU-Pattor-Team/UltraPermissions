/*    */ package me.TechsCode.UltraPermissions.base.views;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Comparator;
/*    */ import java.util.Optional;
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
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public abstract class MaterialPickerView
/*    */   extends PageableGUI<XMaterial> {
/* 24 */   private static final Phrase CHOOSE_ACTION = Phrase.create("materialPickerView.choose.action", "**Click** to choose", Colors.GRAY, new Color[] { Colors.AQUA });
/*    */   
/*    */   private String title;
/*    */   private XMaterial[] materials;
/*    */   
/*    */   public MaterialPickerView(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin, String paramString) {
/* 30 */     super(paramPlayer, paramSpigotTechPlugin);
/*    */     
/* 32 */     this.title = paramString;
/*    */     
/* 34 */     ArrayList<XMaterial> arrayList = new ArrayList();
/*    */     
/* 36 */     Inventory inventory = Bukkit.createInventory(null, 9, "Testing");
/* 37 */     for (XMaterial xMaterial : XMaterial.values()) {
/* 38 */       Optional<ItemStack> optional = xMaterial.getAsItemStack();
/*    */       
/* 40 */       if (optional.isPresent()) {
/*    */         
/* 42 */         inventory.setItem(0, optional.get());
/*    */         
/* 44 */         if (inventory.getItem(0) != null) {
/*    */ 
/*    */ 
/*    */           
/* 48 */           inventory.setItem(0, null);
/*    */           
/* 50 */           arrayList.add(xMaterial);
/*    */         } 
/*    */       } 
/* 53 */     }  this
/*    */       
/* 55 */       .materials = (XMaterial[])arrayList.stream().sorted(Comparator.comparing(Enum::name)).toArray(paramInt -> new XMaterial[paramInt]);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTitle() {
/* 60 */     return this.title;
/*    */   }
/*    */ 
/*    */   
/*    */   public void construct(Button paramButton, XMaterial paramXMaterial) {
/* 65 */     paramButton.material(paramXMaterial)
/* 66 */       .name(Animation.wave(paramXMaterial.getHumanName(), new Color[] { Colors.GREEN, Colors.WHITE
/* 67 */           })).lore(new String[] { CHOOSE_ACTION.get() });
/*    */     
/* 69 */     paramButton.action(paramActionType -> choose(this.p, paramXMaterial));
/*    */   }
/*    */ 
/*    */   
/*    */   public XMaterial[] getObjects() {
/* 74 */     return this.materials;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SearchFeature<XMaterial> getSearch() {
/* 81 */     return (SearchFeature<XMaterial>)new BasicSearch<XMaterial>()
/*    */       {
/*    */         public String[] getSearchableText(XMaterial param1XMaterial) {
/* 84 */           return new String[] { param1XMaterial
/* 85 */               .getHumanName() };
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public abstract void choose(Player paramPlayer, XMaterial paramXMaterial);
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/MaterialPickerView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */