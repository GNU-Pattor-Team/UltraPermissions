/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.text;
/*     */ 
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class StrLookup
/*     */ {
/*  49 */   private static final StrLookup NONE_LOOKUP = new MapStrLookup(null); static {
/*  50 */     StrLookup strLookup = null;
/*     */     try {
/*  52 */       strLookup = new MapStrLookup(System.getProperties());
/*  53 */     } catch (SecurityException securityException) {
/*  54 */       strLookup = NONE_LOOKUP;
/*     */     } 
/*  56 */     SYSTEM_PROPERTIES_LOOKUP = strLookup;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final StrLookup SYSTEM_PROPERTIES_LOOKUP;
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrLookup noneLookup() {
/*  66 */     return NONE_LOOKUP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrLookup systemPropertiesLookup() {
/*  81 */     return SYSTEM_PROPERTIES_LOOKUP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrLookup mapLookup(Map paramMap) {
/*  94 */     return new MapStrLookup(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String lookup(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class MapStrLookup
/*     */     extends StrLookup
/*     */   {
/*     */     private final Map map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     MapStrLookup(Map param1Map) {
/* 145 */       this.map = param1Map;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String lookup(String param1String) {
/* 158 */       if (this.map == null) {
/* 159 */         return null;
/*     */       }
/* 161 */       Object object = this.map.get(param1String);
/* 162 */       if (object == null) {
/* 163 */         return null;
/*     */       }
/* 165 */       return object.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/text/StrLookup.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */