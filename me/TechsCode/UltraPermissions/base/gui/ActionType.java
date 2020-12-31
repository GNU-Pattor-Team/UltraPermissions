/*    */ package me.TechsCode.UltraPermissions.base.gui;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.event.inventory.ClickType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ActionType
/*    */ {
/* 12 */   RIGHT(ClickType.RIGHT),
/* 13 */   LEFT(ClickType.LEFT),
/* 14 */   MIDDLE(ClickType.MIDDLE),
/* 15 */   Q(ClickType.DROP),
/* 16 */   SHIFT_RIGHT(ClickType.SHIFT_RIGHT),
/* 17 */   SHIFT_LEFT(ClickType.SHIFT_LEFT);
/*    */   
/*    */   private final ClickType nativeType;
/*    */   
/*    */   ActionType(ClickType paramClickType) {
/* 22 */     this.nativeType = paramClickType;
/*    */   }
/*    */   
/*    */   public static ActionType fromClickType(ClickType paramClickType) {
/* 26 */     return Arrays.<ActionType>stream(values()).filter(paramActionType -> (paramActionType.nativeType == paramClickType)).findFirst().orElse(null);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/gui/ActionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */