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
/*    */ public class NBTDoubleList
/*    */   extends NBTList<Double>
/*    */ {
/*    */   protected NBTDoubleList(NBTCompound paramNBTCompound, String paramString, NBTType paramNBTType, Object paramObject) {
/* 18 */     super(paramNBTCompound, paramString, paramNBTType, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Object asTag(Double paramDouble) {
/*    */     try {
/* 24 */       Constructor constructor = ClassWrapper.NMS_NBTTAGDOUBLE.getClazz().getDeclaredConstructor(new Class[] { double.class });
/* 25 */       constructor.setAccessible(true);
/* 26 */       return constructor.newInstance(new Object[] { paramDouble });
/* 27 */     } catch (InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException instantiationException) {
/*    */       
/* 29 */       throw new NbtApiException("Error while wrapping the Object " + paramDouble + " to it's NMS object!", instantiationException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Double get(int paramInt) {
/*    */     try {
/* 36 */       Object object = ReflectionMethod.LIST_GET.run(this.listObject, new Object[] { Integer.valueOf(paramInt) });
/* 37 */       return Double.valueOf(object.toString());
/* 38 */     } catch (NumberFormatException numberFormatException) {
/* 39 */       return Double.valueOf(0.0D);
/* 40 */     } catch (Exception exception) {
/* 41 */       throw new NbtApiException(exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTDoubleList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */