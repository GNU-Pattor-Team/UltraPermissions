/*    */ package me.TechsCode.UltraPermissions.base.visual;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.utils.MinecraftVersion;
/*    */ 
/*    */ public class Color {
/*    */   private final String colorCode;
/*    */   private final int r;
/*    */   private final int g;
/*    */   private final int b;
/*    */   
/*    */   public static Color from(String paramString) {
/* 14 */     return new Color(paramString);
/*    */   }
/*    */   
/*    */   public static Color from(int paramInt1, int paramInt2, int paramInt3) {
/* 18 */     java.awt.Color color = new java.awt.Color(paramInt1, paramInt2, paramInt3);
/* 19 */     return from(Integer.toHexString(color.getRGB()).substring(2));
/*    */   }
/*    */   
/*    */   private Color(String paramString) {
/* 23 */     this.colorCode = paramString.replace("#", "");
/*    */     
/* 25 */     java.awt.Color color = new java.awt.Color(Integer.parseInt(this.colorCode, 16));
/* 26 */     this.r = color.getRed();
/* 27 */     this.g = color.getGreen();
/* 28 */     this.b = color.getBlue();
/*    */   }
/*    */   
/*    */   public String getTag() {
/* 32 */     return "{#" + this.colorCode + "}";
/*    */   }
/*    */   
/*    */   public String getColorCode() {
/* 36 */     return this.colorCode;
/*    */   }
/*    */   
/*    */   public int getRed() {
/* 40 */     return this.r;
/*    */   }
/*    */   
/*    */   public int getGreen() {
/* 44 */     return this.g;
/*    */   }
/*    */   
/*    */   public int getBlue() {
/* 48 */     return this.b;
/*    */   }
/*    */   
/*    */   public String getAppliedTag() {
/* 52 */     boolean bool = MinecraftVersion.getServersVersion().isAboveOrEqual(MinecraftVersion.V1_16_R1);
/*    */     
/* 54 */     if (bool) {
/* 55 */       return "§x" + (String)Arrays.<String>stream(this.colorCode.split("")).map(paramString -> "§" + paramString).collect(Collectors.joining());
/*    */     }
/* 57 */     return MinecraftColor.getClosest(this).getAppliedTag();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getColorTag() {
/* 62 */     return "{#" + this.colorCode + "}";
/*    */   }
/*    */   
/*    */   public static int difference(Color paramColor1, Color paramColor2) {
/* 66 */     return Math.abs(paramColor1.r - paramColor2.r) + Math.abs(paramColor1.g - paramColor2.g) + Math.abs(paramColor1.b - paramColor2.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 71 */     return getAppliedTag();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/visual/Color.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */