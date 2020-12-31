/*    */ package me.TechsCode.UltraPermissions.base.legacy;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class Placeholders
/*    */   extends HashMap<String, String> {
/*    */   public String apply(String paramString) {
/*  9 */     String str = paramString;
/* 10 */     for (Map.Entry<String, String> entry : entrySet()) {
/* 11 */       str = str.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
/*    */     }
/* 13 */     return str;
/*    */   }
/*    */   
/*    */   public static Placeholders c(String paramString1, String paramString2) {
/* 17 */     Placeholders placeholders = new Placeholders();
/* 18 */     placeholders.put(paramString1, paramString2);
/* 19 */     return placeholders;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/Placeholders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */