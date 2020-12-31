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
/*    */ public class NBTFloatList
/*    */   extends NBTList<Float>
/*    */ {
/*    */   protected NBTFloatList(NBTCompound paramNBTCompound, String paramString, NBTType paramNBTType, Object paramObject) {
/* 18 */     super(paramNBTCompound, paramString, paramNBTType, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Object asTag(Float paramFloat) {
/*    */     try {
/* 24 */       Constructor constructor = ClassWrapper.NMS_NBTTAGFLOAT.getClazz().getDeclaredConstructor(new Class[] { float.class });
/* 25 */       constructor.setAccessible(true);
/* 26 */       return constructor.newInstance(new Object[] { paramFloat });
/* 27 */     } catch (InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException instantiationException) {
/*    */       
/* 29 */       throw new NbtApiException("Error while wrapping the Object " + paramFloat + " to it's NMS object!", instantiationException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Float get(int paramInt) {
/*    */     try {
/* 36 */       Object object = ReflectionMethod.LIST_GET.run(this.listObject, new Object[] { Integer.valueOf(paramInt) });
/* 37 */       return Float.valueOf(object.toString());
/* 38 */     } catch (NumberFormatException numberFormatException) {
/* 39 */       return Float.valueOf(0.0F);
/* 40 */     } catch (Exception exception) {
/* 41 */       throw new NbtApiException(exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTFloatList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */