/*    */ package me.TechsCode.UltraPermissions.base.legacy.clickGUI;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.item.CustomItem;
/*    */ import org.bukkit.entity.ArmorStand;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Item;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public abstract class FloatingItem
/*    */   extends FloatingElement {
/*    */   public abstract CustomItem getItem();
/*    */   
/*    */   public void apply(ArmorStand paramArmorStand) {
/* 14 */     CustomItem customItem = getItem();
/* 15 */     setShown((customItem != null));
/*    */     
/* 17 */     if (paramArmorStand != null && customItem != null) {
/* 18 */       ItemStack itemStack = customItem.get();
/*    */       
/* 20 */       if (paramArmorStand.getPassenger() == null || !((Item)paramArmorStand.getPassenger()).getItemStack().isSimilar(itemStack)) {
/* 21 */         if (paramArmorStand.getPassenger() != null) {
/* 22 */           paramArmorStand.getPassenger().remove();
/*    */         }
/*    */         
/* 25 */         Item item = paramArmorStand.getLocation().getWorld().dropItem(paramArmorStand.getLocation(), itemStack);
/* 26 */         item.setGravity(false);
/* 27 */         item.setPickupDelay(2147483647);
/* 28 */         paramArmorStand.setPassenger((Entity)item);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public double getYOffset() {
/* 35 */     return 2.0D;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/clickGUI/FloatingItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */