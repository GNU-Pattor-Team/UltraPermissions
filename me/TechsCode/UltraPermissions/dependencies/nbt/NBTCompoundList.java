/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.NotImplementedException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ClassWrapper;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ReflectionMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NBTCompoundList
/*     */   extends NBTList<NBTListCompound>
/*     */ {
/*     */   protected NBTCompoundList(NBTCompound paramNBTCompound, String paramString, NBTType paramNBTType, Object paramObject) {
/*  18 */     super(paramNBTCompound, paramString, paramNBTType, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTListCompound addCompound() {
/*  27 */     return (NBTListCompound)addCompound((NBTCompound)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTCompound addCompound(NBTCompound paramNBTCompound) {
/*     */     try {
/*  39 */       Object object = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
/*  40 */       if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
/*  41 */         ReflectionMethod.LIST_ADD.run(this.listObject, new Object[] { Integer.valueOf(size()), object });
/*     */       } else {
/*  43 */         ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, new Object[] { object });
/*     */       } 
/*  45 */       getParent().saveCompound();
/*  46 */       NBTListCompound nBTListCompound = new NBTListCompound(this, object);
/*  47 */       if (paramNBTCompound != null) {
/*  48 */         nBTListCompound.mergeCompound(paramNBTCompound);
/*     */       }
/*  50 */       return nBTListCompound;
/*  51 */     } catch (Exception exception) {
/*  52 */       throw new NbtApiException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean add(NBTListCompound paramNBTListCompound) {
/*  67 */     return (addCompound(paramNBTListCompound) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int paramInt, NBTListCompound paramNBTListCompound) {
/*  72 */     if (paramNBTListCompound != null) {
/*  73 */       throw new NotImplementedException("You need to pass null! ListCompounds from other lists won't work.");
/*     */     }
/*     */     try {
/*  76 */       Object object = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
/*  77 */       if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
/*  78 */         ReflectionMethod.LIST_ADD.run(this.listObject, new Object[] { Integer.valueOf(paramInt), object });
/*     */       } else {
/*  80 */         ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, new Object[] { object });
/*     */       } 
/*  82 */       getParent().saveCompound();
/*  83 */     } catch (Exception exception) {
/*  84 */       throw new NbtApiException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTListCompound get(int paramInt) {
/*     */     try {
/*  91 */       Object object = ReflectionMethod.LIST_GET_COMPOUND.run(this.listObject, new Object[] { Integer.valueOf(paramInt) });
/*  92 */       return new NBTListCompound(this, object);
/*  93 */     } catch (Exception exception) {
/*  94 */       throw new NbtApiException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTListCompound set(int paramInt, NBTListCompound paramNBTListCompound) {
/* 100 */     throw new NotImplementedException("This method doesn't work in the ListCompound context.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected Object asTag(NBTListCompound paramNBTListCompound) {
/* 105 */     return null;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTCompoundList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */