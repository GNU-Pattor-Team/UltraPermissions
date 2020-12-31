/*    */ package me.TechsCode.UltraPermissions.base.legacy.utils;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import me.TechsCode.UltraPermissions.base.reflection.titleAndActionbar.Reflection;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerUtils
/*    */ {
/* 14 */   private static Class<?> CRAFTPLAYER = Reflection.getCraftClass("entity.CraftPlayer");
/*    */ 
/*    */   
/*    */   private static Object getCraftPlayer(Player paramPlayer) {
/* 18 */     return CRAFTPLAYER.cast(paramPlayer);
/*    */   }
/*    */   
/*    */   public static GameProfile getGameProfile(Player paramPlayer) {
/* 22 */     Object object = getCraftPlayer(paramPlayer);
/*    */     
/*    */     try {
/* 25 */       return (GameProfile)CRAFTPLAYER.getMethod("getProfile", new Class[0]).invoke(object, new Object[0]);
/* 26 */     } catch (IllegalAccessException illegalAccessException) {
/* 27 */       illegalAccessException.printStackTrace();
/* 28 */     } catch (InvocationTargetException invocationTargetException) {
/* 29 */       invocationTargetException.printStackTrace();
/* 30 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 31 */       noSuchMethodException.printStackTrace();
/*    */     } 
/*    */     
/* 34 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/utils/PlayerUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */