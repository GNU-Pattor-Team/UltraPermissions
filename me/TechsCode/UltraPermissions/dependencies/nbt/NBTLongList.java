/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ClassWrapper;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ReflectionMethod;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NBTLongList
/*    */   extends NBTList<Long>
/*    */ {
/*    */   protected NBTLongList(NBTCompound paramNBTCompound, String paramString, NBTType paramNBTType, Object paramObject) {
/* 18 */     super(paramNBTCompound, paramString, paramNBTType, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Object asTag(Long paramLong) {
/*    */     try {
/* 24 */       Constructor constructor = ClassWrapper.NMS_NBTTAGLONG.getClazz().getDeclaredConstructor(new Class[] { long.class });
/* 25 */       constructor.setAccessible(true);
/* 26 */       return constructor.newInstance(new Object[] { paramLong });
/* 27 */     } catch (InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException instantiationException) {
/*    */       
/* 29 */       throw new NbtApiException("Error while wrapping the Object " + paramLong + " to it's NMS object!", instantiationException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Long get(int paramInt) {
/*    */     try {
/* 36 */       Object object = ReflectionMethod.LIST_GET.run(this.listObject, new Object[] { Integer.valueOf(paramInt) });
/* 37 */       return Long.valueOf(object.toString().replace("L", ""));
/* 38 */     } catch (NumberFormatException numberFormatException) {
/* 39 */       return Long.valueOf(0L);
/* 40 */     } catch (Exception exception) {
/* 41 */       throw new NbtApiException(exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTLongList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */