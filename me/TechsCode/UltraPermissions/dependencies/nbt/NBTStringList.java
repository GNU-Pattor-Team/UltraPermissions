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
/*    */ public class NBTStringList
/*    */   extends NBTList<String>
/*    */ {
/*    */   protected NBTStringList(NBTCompound paramNBTCompound, String paramString, NBTType paramNBTType, Object paramObject) {
/* 18 */     super(paramNBTCompound, paramString, paramNBTType, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public String get(int paramInt) {
/*    */     try {
/* 24 */       return (String)ReflectionMethod.LIST_GET_STRING.run(this.listObject, new Object[] { Integer.valueOf(paramInt) });
/* 25 */     } catch (Exception exception) {
/* 26 */       throw new NbtApiException(exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected Object asTag(String paramString) {
/*    */     try {
/* 33 */       Constructor constructor = ClassWrapper.NMS_NBTTAGSTRING.getClazz().getDeclaredConstructor(new Class[] { String.class });
/* 34 */       constructor.setAccessible(true);
/* 35 */       return constructor.newInstance(new Object[] { paramString });
/* 36 */     } catch (InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException instantiationException) {
/*    */       
/* 38 */       throw new NbtApiException("Error while wrapping the Object " + paramString + " to it's NMS object!", instantiationException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTStringList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */