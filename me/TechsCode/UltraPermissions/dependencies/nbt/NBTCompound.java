/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ReflectionMethod;
/*     */ import org.bukkit.inventory.ItemStack;
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
/*     */ 
/*     */ public class NBTCompound
/*     */ {
/*  25 */   private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*  26 */   private final Lock readLock = this.readWriteLock.readLock();
/*  27 */   private final Lock writeLock = this.readWriteLock.writeLock();
/*     */   
/*     */   private String compundName;
/*     */   private NBTCompound parent;
/*     */   
/*     */   protected NBTCompound(NBTCompound paramNBTCompound, String paramString) {
/*  33 */     this.compundName = paramString;
/*  34 */     this.parent = paramNBTCompound;
/*     */   }
/*     */   
/*     */   protected Lock getReadLock() {
/*  38 */     return this.readLock;
/*     */   }
/*     */   
/*     */   protected Lock getWriteLock() {
/*  42 */     return this.writeLock;
/*     */   }
/*     */   
/*     */   protected void saveCompound() {
/*  46 */     if (this.parent != null) {
/*  47 */       this.parent.saveCompound();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  54 */     return this.compundName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getCompound() {
/*  61 */     return this.parent.getCompound();
/*     */   }
/*     */   
/*     */   protected void setCompound(Object paramObject) {
/*  65 */     this.parent.setCompound(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTCompound getParent() {
/*  72 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mergeCompound(NBTCompound paramNBTCompound) {
/*     */     try {
/*  83 */       this.writeLock.lock();
/*  84 */       NBTReflectionUtil.mergeOtherNBTCompound(this, paramNBTCompound);
/*  85 */       saveCompound();
/*     */     } finally {
/*  87 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(String paramString1, String paramString2) {
/*     */     try {
/*  99 */       this.writeLock.lock();
/* 100 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_STRING, paramString1, paramString2);
/* 101 */       saveCompound();
/*     */     } finally {
/* 103 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String paramString) {
/*     */     try {
/* 115 */       this.readLock.lock();
/* 116 */       return (String)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_STRING, paramString);
/*     */     } finally {
/* 118 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String getContent(String paramString) {
/* 123 */     return NBTReflectionUtil.getContent(this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInteger(String paramString, Integer paramInteger) {
/*     */     try {
/* 134 */       this.writeLock.lock();
/* 135 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_INT, paramString, paramInteger);
/* 136 */       saveCompound();
/*     */     } finally {
/* 138 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getInteger(String paramString) {
/*     */     try {
/* 150 */       this.readLock.lock();
/* 151 */       return (Integer)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_INT, paramString);
/*     */     } finally {
/* 153 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDouble(String paramString, Double paramDouble) {
/*     */     try {
/* 165 */       this.writeLock.lock();
/* 166 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_DOUBLE, paramString, paramDouble);
/* 167 */       saveCompound();
/*     */     } finally {
/* 169 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getDouble(String paramString) {
/*     */     try {
/* 181 */       this.readLock.lock();
/* 182 */       return (Double)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_DOUBLE, paramString);
/*     */     } finally {
/* 184 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByte(String paramString, Byte paramByte) {
/*     */     try {
/* 196 */       this.writeLock.lock();
/* 197 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BYTE, paramString, paramByte);
/* 198 */       saveCompound();
/*     */     } finally {
/* 200 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Byte getByte(String paramString) {
/*     */     try {
/* 212 */       this.readLock.lock();
/* 213 */       return (Byte)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BYTE, paramString);
/*     */     } finally {
/* 215 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShort(String paramString, Short paramShort) {
/*     */     try {
/* 227 */       this.writeLock.lock();
/* 228 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_SHORT, paramString, paramShort);
/* 229 */       saveCompound();
/*     */     } finally {
/* 231 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Short getShort(String paramString) {
/*     */     try {
/* 243 */       this.readLock.lock();
/* 244 */       return (Short)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_SHORT, paramString);
/*     */     } finally {
/* 246 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLong(String paramString, Long paramLong) {
/*     */     try {
/* 258 */       this.writeLock.lock();
/* 259 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_LONG, paramString, paramLong);
/* 260 */       saveCompound();
/*     */     } finally {
/* 262 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getLong(String paramString) {
/*     */     try {
/* 274 */       this.readLock.lock();
/* 275 */       return (Long)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_LONG, paramString);
/*     */     } finally {
/* 277 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFloat(String paramString, Float paramFloat) {
/*     */     try {
/* 289 */       this.writeLock.lock();
/* 290 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_FLOAT, paramString, paramFloat);
/* 291 */       saveCompound();
/*     */     } finally {
/* 293 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Float getFloat(String paramString) {
/*     */     try {
/* 305 */       this.readLock.lock();
/* 306 */       return (Float)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_FLOAT, paramString);
/*     */     } finally {
/* 308 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByteArray(String paramString, byte[] paramArrayOfbyte) {
/*     */     try {
/* 320 */       this.writeLock.lock();
/* 321 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BYTEARRAY, paramString, paramArrayOfbyte);
/* 322 */       saveCompound();
/*     */     } finally {
/* 324 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getByteArray(String paramString) {
/*     */     try {
/* 336 */       this.readLock.lock();
/* 337 */       return (byte[])NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BYTEARRAY, paramString);
/*     */     } finally {
/* 339 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIntArray(String paramString, int[] paramArrayOfint) {
/*     */     try {
/* 351 */       this.writeLock.lock();
/* 352 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_INTARRAY, paramString, paramArrayOfint);
/* 353 */       saveCompound();
/*     */     } finally {
/* 355 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getIntArray(String paramString) {
/*     */     try {
/* 367 */       this.readLock.lock();
/* 368 */       return (int[])NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_INTARRAY, paramString);
/*     */     } finally {
/* 370 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoolean(String paramString, Boolean paramBoolean) {
/*     */     try {
/* 382 */       this.writeLock.lock();
/* 383 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BOOLEAN, paramString, paramBoolean);
/* 384 */       saveCompound();
/*     */     } finally {
/* 386 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void set(String paramString, Object paramObject) {
/* 391 */     NBTReflectionUtil.set(this, paramString, paramObject);
/* 392 */     saveCompound();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getBoolean(String paramString) {
/*     */     try {
/* 403 */       this.readLock.lock();
/* 404 */       return (Boolean)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BOOLEAN, paramString);
/*     */     } finally {
/* 406 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(String paramString, Object paramObject) {
/*     */     try {
/* 418 */       this.writeLock.lock();
/* 419 */       NBTReflectionUtil.setObject(this, paramString, paramObject);
/* 420 */       saveCompound();
/*     */     } finally {
/* 422 */       this.writeLock.unlock();
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
/*     */   public <T> T getObject(String paramString, Class<T> paramClass) {
/*     */     try {
/* 435 */       this.readLock.lock();
/* 436 */       return (T)NBTReflectionUtil.getObject(this, paramString, (Class)paramClass);
/*     */     } finally {
/* 438 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItemStack(String paramString, ItemStack paramItemStack) {
/*     */     try {
/* 450 */       this.writeLock.lock();
/* 451 */       removeKey(paramString);
/* 452 */       addCompound(paramString).mergeCompound(NBTItem.convertItemtoNBT(paramItemStack));
/*     */     } finally {
/* 454 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getItemStack(String paramString) {
/*     */     try {
/* 466 */       this.readLock.lock();
/* 467 */       NBTCompound nBTCompound = getCompound(paramString);
/* 468 */       return NBTItem.convertNBTtoItem(nBTCompound);
/*     */     } finally {
/* 470 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUUID(String paramString, UUID paramUUID) {
/*     */     try {
/* 482 */       this.writeLock.lock();
/* 483 */       NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_UUID, paramString, paramUUID);
/* 484 */       saveCompound();
/*     */     } finally {
/* 486 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UUID getUUID(String paramString) {
/*     */     try {
/* 498 */       this.readLock.lock();
/* 499 */       return (UUID)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_UUID, paramString);
/*     */     } finally {
/* 501 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean hasKey(String paramString) {
/*     */     try {
/* 511 */       this.readLock.lock();
/* 512 */       Boolean bool = (Boolean)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_HAS_KEY, paramString);
/* 513 */       if (bool == null)
/* 514 */         return Boolean.valueOf(false); 
/* 515 */       return bool;
/*     */     } finally {
/* 517 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeKey(String paramString) {
/*     */     try {
/* 526 */       this.writeLock.lock();
/* 527 */       NBTReflectionUtil.remove(this, paramString);
/* 528 */       saveCompound();
/*     */     } finally {
/* 530 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getKeys() {
/*     */     try {
/* 539 */       this.readLock.lock();
/* 540 */       return NBTReflectionUtil.getKeys(this);
/*     */     } finally {
/* 542 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTCompound addCompound(String paramString) {
/*     */     try {
/* 554 */       this.writeLock.lock();
/* 555 */       if (getType(paramString) == NBTType.NBTTagCompound)
/* 556 */         return getCompound(paramString); 
/* 557 */       NBTReflectionUtil.addNBTTagCompound(this, paramString);
/* 558 */       NBTCompound nBTCompound = getCompound(paramString);
/* 559 */       if (nBTCompound == null)
/* 560 */         throw new NbtApiException("Error while adding Compound, got null!"); 
/* 561 */       saveCompound();
/* 562 */       return nBTCompound;
/*     */     } finally {
/* 564 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTCompound getCompound(String paramString) {
/*     */     try {
/* 574 */       this.readLock.lock();
/* 575 */       if (getType(paramString) != NBTType.NBTTagCompound)
/* 576 */         return null; 
/* 577 */       NBTCompound nBTCompound = new NBTCompound(this, paramString);
/* 578 */       if (NBTReflectionUtil.valideCompound(nBTCompound).booleanValue())
/* 579 */         return nBTCompound; 
/* 580 */       return null;
/*     */     } finally {
/* 582 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTList<String> getStringList(String paramString) {
/*     */     try {
/* 592 */       this.writeLock.lock();
/* 593 */       NBTList<String> nBTList = NBTReflectionUtil.getList(this, paramString, NBTType.NBTTagString, String.class);
/* 594 */       saveCompound();
/* 595 */       return nBTList;
/*     */     } finally {
/* 597 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTList<Integer> getIntegerList(String paramString) {
/*     */     try {
/* 607 */       this.writeLock.lock();
/* 608 */       NBTList<Integer> nBTList = NBTReflectionUtil.getList(this, paramString, NBTType.NBTTagInt, Integer.class);
/* 609 */       saveCompound();
/* 610 */       return nBTList;
/*     */     } finally {
/* 612 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTList<Float> getFloatList(String paramString) {
/*     */     try {
/* 622 */       this.writeLock.lock();
/* 623 */       NBTList<Float> nBTList = NBTReflectionUtil.getList(this, paramString, NBTType.NBTTagFloat, Float.class);
/* 624 */       saveCompound();
/* 625 */       return nBTList;
/*     */     } finally {
/* 627 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTList<Double> getDoubleList(String paramString) {
/*     */     try {
/* 637 */       this.writeLock.lock();
/* 638 */       NBTList<Double> nBTList = NBTReflectionUtil.getList(this, paramString, NBTType.NBTTagDouble, Double.class);
/* 639 */       saveCompound();
/* 640 */       return nBTList;
/*     */     } finally {
/* 642 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTList<Long> getLongList(String paramString) {
/*     */     try {
/* 652 */       this.writeLock.lock();
/* 653 */       NBTList<Long> nBTList = NBTReflectionUtil.getList(this, paramString, NBTType.NBTTagLong, Long.class);
/* 654 */       saveCompound();
/* 655 */       return nBTList;
/*     */     } finally {
/* 657 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTCompoundList getCompoundList(String paramString) {
/*     */     try {
/* 667 */       this.writeLock.lock();
/* 668 */       NBTCompoundList nBTCompoundList = (NBTCompoundList)NBTReflectionUtil.<NBTListCompound>getList(this, paramString, NBTType.NBTTagCompound, NBTListCompound.class);
/*     */       
/* 670 */       saveCompound();
/* 671 */       return nBTCompoundList;
/*     */     } finally {
/* 673 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTType getType(String paramString) {
/*     */     try {
/* 683 */       this.readLock.lock();
/* 684 */       if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
/* 685 */         Object object1 = NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET, paramString);
/* 686 */         if (object1 == null)
/* 687 */           return null; 
/* 688 */         return NBTType.valueOf(((Byte)ReflectionMethod.COMPOUND_OWN_TYPE.run(object1, new Object[0])).byteValue());
/*     */       } 
/* 690 */       Object object = NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_TYPE, paramString);
/* 691 */       if (object == null)
/* 692 */         return null; 
/* 693 */       return NBTType.valueOf(((Byte)object).byteValue());
/*     */     } finally {
/* 695 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void writeCompound(OutputStream paramOutputStream) {
/*     */     try {
/* 701 */       this.writeLock.lock();
/* 702 */       NBTReflectionUtil.writeApiNBT(this, paramOutputStream);
/*     */     } finally {
/* 704 */       this.writeLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 714 */     return asNBTString();
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String toString(String paramString) {
/* 731 */     return asNBTString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String asNBTString() {
/*     */     try {
/* 741 */       this.readLock.lock();
/* 742 */       Object object = NBTReflectionUtil.gettoCompount(getCompound(), this);
/* 743 */       if (object == null)
/* 744 */         return "{}"; 
/* 745 */       return object.toString();
/*     */     } finally {
/* 747 */       this.readLock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 753 */     return toString().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 762 */     if (this == paramObject)
/* 763 */       return true; 
/* 764 */     if (paramObject == null)
/* 765 */       return false; 
/* 766 */     return toString().equals(paramObject.toString());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTCompound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */