/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.logging.Level;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.NbtApiException;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
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
/*    */ public enum ObjectCreator
/*    */ {
/* 19 */   NMS_NBTTAGCOMPOUND(null, null, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[0]),
/* 20 */   NMS_BLOCKPOSITION(null, null, ClassWrapper.NMS_BLOCKPOSITION.getClazz(), new Class[] { int.class, int.class, int.class }),
/* 21 */   NMS_COMPOUNDFROMITEM(MinecraftVersion.MC1_11_R1, null, ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() });
/*    */   
/*    */   private Constructor<?> construct;
/*    */   private Class<?> targetClass;
/*    */   
/*    */   ObjectCreator(MinecraftVersion paramMinecraftVersion1, MinecraftVersion paramMinecraftVersion2, Class<?> paramClass, Class<?>... paramVarArgs) {
/* 27 */     if (paramClass == null)
/*    */       return; 
/* 29 */     if (paramMinecraftVersion1 != null && MinecraftVersion.getVersion().getVersionId() < paramMinecraftVersion1.getVersionId())
/*    */       return; 
/* 31 */     if (paramMinecraftVersion2 != null && MinecraftVersion.getVersion().getVersionId() > paramMinecraftVersion2.getVersionId())
/*    */       return; 
/*    */     try {
/* 34 */       this.targetClass = paramClass;
/* 35 */       this.construct = paramClass.getDeclaredConstructor(paramVarArgs);
/* 36 */       this.construct.setAccessible(true);
/* 37 */     } catch (Exception exception) {
/* 38 */       MinecraftVersion.logger.log(Level.SEVERE, "Unable to find the constructor for the class '" + paramClass.getName() + "'", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getInstance(Object... paramVarArgs) {
/*    */     try {
/* 50 */       return this.construct.newInstance(paramVarArgs);
/* 51 */     } catch (Exception exception) {
/* 52 */       throw new NbtApiException("Exception while creating a new instance of '" + this.targetClass + "'", exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/nmsmappings/ObjectCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */