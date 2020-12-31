/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.NbtApiException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GsonWrapper
/*    */ {
/* 22 */   private static final Gson gson = new Gson();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getString(Object paramObject) {
/* 31 */     return gson.toJson(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> T deserializeJson(String paramString, Class<T> paramClass) {
/*    */     try {
/* 43 */       if (paramString == null) {
/* 44 */         return null;
/*    */       }
/*    */       
/* 47 */       Object object = gson.fromJson(paramString, paramClass);
/* 48 */       return paramClass.cast(object);
/* 49 */     } catch (Exception exception) {
/* 50 */       throw new NbtApiException("Error while converting json to " + paramClass.getName(), exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/GsonWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */