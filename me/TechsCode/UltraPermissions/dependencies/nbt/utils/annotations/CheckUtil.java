/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.NbtApiException;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*    */ 
/*    */ 
/*    */ public class CheckUtil
/*    */ {
/*    */   public static boolean isAvaliable(Method paramMethod) {
/* 11 */     if (MinecraftVersion.getVersion().getVersionId() < ((AvaliableSince)paramMethod.getAnnotation((Class)AvaliableSince.class)).version().getVersionId())
/* 12 */       throw new NbtApiException("The Method '" + paramMethod.getName() + "' is only avaliable for the Versions " + ((AvaliableSince)paramMethod.getAnnotation(AvaliableSince.class)).version() + "+, but still got called!"); 
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/annotations/CheckUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */