/*    */ package me.TechsCode.UltraPermissions.base.gui;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.base.item.CustomItem;
/*    */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Button
/*    */ {
/* 18 */   private List<Action> actions = new ArrayList<>();
/*    */   private CustomItem item;
/*    */   
/*    */   public void setItem(CustomItem paramCustomItem) {
/* 22 */     this.item = paramCustomItem;
/*    */   }
/*    */   
/*    */   public CustomItem material(XMaterial paramXMaterial) {
/* 26 */     this.item = new CustomItem(paramXMaterial);
/* 27 */     return this.item;
/*    */   }
/*    */   
/*    */   public CustomItem material(Material paramMaterial) {
/* 31 */     this.item = new CustomItem(paramMaterial);
/* 32 */     return this.item;
/*    */   }
/*    */   
/*    */   public CustomItem stack(ItemStack paramItemStack) {
/* 36 */     this.item = new CustomItem(paramItemStack, false);
/* 37 */     return this.item;
/*    */   }
/*    */   
/*    */   public CustomItem item() {
/* 41 */     return this.item;
/*    */   }
/*    */   
/*    */   public void action(Action paramAction) {
/* 45 */     this.actions.add(paramAction);
/*    */   }
/*    */   
/*    */   public void action(ActionType paramActionType, Runnable paramRunnable) {
/* 49 */     this.actions.add(paramActionType2 -> {
/*    */           if (paramActionType2 == paramActionType1)
/*    */             paramRunnable.run(); 
/*    */         });
/*    */   }
/*    */   public List<Action> getActions() {
/* 55 */     return this.actions;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/gui/Button.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */