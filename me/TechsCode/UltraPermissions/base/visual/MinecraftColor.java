/*    */ package me.TechsCode.UltraPermissions.base.visual;
/*    */ 
/*    */ public enum MinecraftColor
/*    */ {
/*  5 */   DARK_RED("&4", "#AA0000"),
/*  6 */   RED("&c", "#FF5555"),
/*  7 */   GOLD("&6", "#FFAA00"),
/*  8 */   YELLOW("&e", "#FFFF55"),
/*  9 */   DARK_GREEN("&2", "#00AA00"),
/* 10 */   GREEN("&a", "#55FF55"),
/* 11 */   AQUA("&b", "#55FFFF"),
/* 12 */   DARK_AQUA("&3", "#00AAAA"),
/* 13 */   DARK_BLUE("&1", "#0000AA"),
/* 14 */   BLUE("&9", "#5555FF"),
/* 15 */   LIGHT_PURPLE("&d", "#FF55FF"),
/* 16 */   DARK_PURPLE("&5", "#AA00AA"),
/* 17 */   WHITE("&f", "#FFFFFF"),
/* 18 */   GRAY("&7", "#AAAAAA"),
/* 19 */   DARK_GRAY("&8", "#555555"),
/* 20 */   BLACK("&0", "#000000");
/*    */   
/*    */   public static MinecraftColor getClosest(Color paramColor) {
/* 23 */     MinecraftColor minecraftColor = null;
/* 24 */     int i = 0;
/*    */     
/* 26 */     for (MinecraftColor minecraftColor1 : values()) {
/* 27 */       int j = Color.difference(paramColor, minecraftColor1.getColor());
/*    */       
/* 29 */       if (minecraftColor == null || i > j) {
/* 30 */         i = j;
/* 31 */         minecraftColor = minecraftColor1;
/*    */       } 
/*    */     } 
/*    */     
/* 35 */     return minecraftColor;
/*    */   }
/*    */   
/*    */   private final String chatColor;
/*    */   private final Color color;
/*    */   
/*    */   MinecraftColor(String paramString1, String paramString2) {
/* 42 */     this.chatColor = paramString1;
/* 43 */     this.color = Color.from(paramString2);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 47 */     return name().toLowerCase();
/*    */   }
/*    */   
/*    */   public Color getColor() {
/* 51 */     return this.color;
/*    */   }
/*    */   
/*    */   public String getTag() {
/* 55 */     return this.chatColor;
/*    */   }
/*    */   
/*    */   public String getAppliedTag() {
/* 59 */     return this.chatColor.replace("&", "§");
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     return getAppliedTag();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/visual/MinecraftColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */