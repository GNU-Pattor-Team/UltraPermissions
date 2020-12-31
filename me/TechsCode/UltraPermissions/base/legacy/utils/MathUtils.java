/*    */ package me.TechsCode.UltraPermissions.base.legacy.utils;
/*    */ 
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class MathUtils
/*    */ {
/*    */   public static Vector rotateAroundAxisX(Vector paramVector, double paramDouble) {
/*  8 */     double d1 = Math.toRadians(paramDouble);
/*  9 */     double d2 = Math.cos(d1);
/* 10 */     double d3 = Math.sin(d1);
/*    */     
/* 12 */     double d4 = paramVector.getY() * d3 - paramVector.getZ() * d2;
/* 13 */     double d5 = paramVector.getY() * d2 + paramVector.getZ() * d3;
/* 14 */     return paramVector.setY(d4).setZ(d5);
/*    */   }
/*    */   
/*    */   public static Vector rotateAroundAxisY(Vector paramVector, double paramDouble) {
/* 18 */     double d1 = Math.toRadians(paramDouble);
/* 19 */     double d2 = Math.cos(d1);
/* 20 */     double d3 = Math.sin(d1);
/*    */     
/* 22 */     double d4 = paramVector.getX() * d3 + paramVector.getZ() * d2;
/* 23 */     double d5 = paramVector.getX() * -d2 + paramVector.getZ() * d3;
/* 24 */     return paramVector.setX(d4).setZ(d5);
/*    */   }
/*    */   
/*    */   public static Vector rotateAroundAxisZ(Vector paramVector, double paramDouble) {
/* 28 */     double d1 = Math.toRadians(paramDouble);
/* 29 */     double d2 = Math.cos(d1);
/* 30 */     double d3 = Math.sin(d1);
/*    */     
/* 32 */     double d4 = paramVector.getX() * d3 - paramVector.getY() * d2;
/* 33 */     double d5 = paramVector.getX() * d2 + paramVector.getY() * d3;
/* 34 */     return paramVector.setX(d4).setY(d5);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/utils/MathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */