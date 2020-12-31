/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ClassWrapper;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NBTContainer
/*    */   extends NBTCompound
/*    */ {
/*    */   private Object nbt;
/*    */   
/*    */   public NBTContainer() {
/* 24 */     super(null, null);
/* 25 */     this.nbt = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NBTContainer(Object paramObject) {
/* 34 */     super(null, null);
/* 35 */     if (paramObject == null) {
/* 36 */       throw new NullPointerException("The NBT-Object can't be null!");
/*    */     }
/* 38 */     if (!ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().isAssignableFrom(paramObject.getClass())) {
/* 39 */       throw new NbtApiException("The object '" + paramObject.getClass() + "' is not a valid NBT-Object!");
/*    */     }
/* 41 */     this.nbt = paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NBTContainer(InputStream paramInputStream) {
/* 50 */     super(null, null);
/* 51 */     this.nbt = NBTReflectionUtil.readNBT(paramInputStream);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NBTContainer(String paramString) {
/* 61 */     super(null, null);
/* 62 */     if (paramString == null) {
/* 63 */       throw new NullPointerException("The String can't be null!");
/*    */     }
/*    */     try {
/* 66 */       this.nbt = ReflectionMethod.PARSE_NBT.run(null, new Object[] { paramString });
/* 67 */     } catch (Exception exception) {
/* 68 */       throw new NbtApiException("Unable to parse Malformed Json!", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getCompound() {
/* 74 */     return this.nbt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCompound(Object paramObject) {
/* 79 */     this.nbt = paramObject;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */