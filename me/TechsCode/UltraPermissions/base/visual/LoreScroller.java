/*    */ package me.TechsCode.UltraPermissions.base.visual;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class LoreScroller
/*    */ {
/*    */   public static List<String> scroller(List<String> paramList, int paramInt, long paramLong) {
/* 10 */     if (paramList.size() <= paramInt) {
/* 11 */       return paramList;
/*    */     }
/*    */     
/* 14 */     ArrayList<String> arrayList = new ArrayList();
/* 15 */     arrayList.addAll(paramList);
/* 16 */     arrayList.addAll(paramList);
/* 17 */     arrayList.addAll(paramList);
/*    */     
/* 19 */     long l = System.currentTimeMillis() - paramLong;
/*    */     
/* 21 */     int i = Math.round((float)(l / 150L)) % paramList.size();
/*    */     
/* 23 */     return arrayList.subList(i, i + paramInt);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/visual/LoreScroller.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */