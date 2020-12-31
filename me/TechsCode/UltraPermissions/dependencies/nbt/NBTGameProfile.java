/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ObjectCreator;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ReflectionMethod;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NBTGameProfile
/*    */ {
/*    */   public static NBTCompound toNBT(GameProfile paramGameProfile) {
/* 17 */     return new NBTContainer(ReflectionMethod.GAMEPROFILE_SERIALIZE.run(null, new Object[] { ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]), paramGameProfile }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GameProfile fromNBT(NBTCompound paramNBTCompound) {
/* 27 */     return (GameProfile)ReflectionMethod.GAMEPROFILE_DESERIALIZE.run(null, new Object[] { NBTReflectionUtil.gettoCompount(paramNBTCompound.getCompound(), paramNBTCompound) });
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTGameProfile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */