/*    */ package me.TechsCode.UltraPermissions.base.visual;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ColorCalculations
/*    */ {
/*    */   public static List<Color> getColorsInbetween(Color paramColor1, Color paramColor2, int paramInt) {
/*  9 */     double d1 = (paramColor2.getRed() - paramColor1.getRed()) / paramInt;
/* 10 */     double d2 = (paramColor2.getGreen() - paramColor1.getGreen()) / paramInt;
/* 11 */     double d3 = (paramColor2.getBlue() - paramColor1.getBlue()) / paramInt;
/*    */     
/* 13 */     ArrayList<Color> arrayList = new ArrayList();
/* 14 */     for (byte b = 1; b <= paramInt; b++) {
/* 15 */       int i = (int)Math.round(paramColor1.getRed() + d1 * b);
/* 16 */       int j = (int)Math.round(paramColor1.getGreen() + d2 * b);
/* 17 */       int k = (int)Math.round(paramColor1.getBlue() + d3 * b);
/*    */       
/* 19 */       Color color = Color.from(i, j, k);
/* 20 */       arrayList.add(color);
/*    */     } 
/*    */     
/* 23 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/visual/ColorCalculations.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */