/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ReflectionMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class NBTList<T>
/*     */   implements List<T>
/*     */ {
/*     */   private String listName;
/*     */   private NBTCompound parent;
/*     */   private NBTType type;
/*     */   protected Object listObject;
/*     */   
/*     */   protected NBTList(NBTCompound paramNBTCompound, String paramString, NBTType paramNBTType, Object paramObject) {
/*  29 */     this.parent = paramNBTCompound;
/*  30 */     this.listName = paramString;
/*  31 */     this.type = paramNBTType;
/*  32 */     this.listObject = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  39 */     return this.listName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTCompound getParent() {
/*  46 */     return this.parent;
/*     */   }
/*     */   
/*     */   protected void save() {
/*  50 */     this.parent.set(this.listName, this.listObject);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract Object asTag(T paramT);
/*     */   
/*     */   public boolean add(T paramT) {
/*     */     try {
/*  58 */       this.parent.getWriteLock().lock();
/*  59 */       if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
/*  60 */         ReflectionMethod.LIST_ADD.run(this.listObject, new Object[] { Integer.valueOf(size()), asTag(paramT) });
/*     */       } else {
/*  62 */         ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, new Object[] { asTag(paramT) });
/*     */       } 
/*  64 */       save();
/*  65 */       return true;
/*  66 */     } catch (Exception exception) {
/*  67 */       throw new NbtApiException(exception);
/*     */     } finally {
/*  69 */       this.parent.getWriteLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int paramInt, T paramT) {
/*     */     try {
/*  76 */       this.parent.getWriteLock().lock();
/*  77 */       if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
/*  78 */         ReflectionMethod.LIST_ADD.run(this.listObject, new Object[] { Integer.valueOf(paramInt), asTag(paramT) });
/*     */       } else {
/*  80 */         ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, new Object[] { asTag(paramT) });
/*     */       } 
/*  82 */       save();
/*  83 */     } catch (Exception exception) {
/*  84 */       throw new NbtApiException(exception);
/*     */     } finally {
/*  86 */       this.parent.getWriteLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public T set(int paramInt, T paramT) {
/*     */     try {
/*  93 */       this.parent.getWriteLock().lock();
/*  94 */       T t = get(paramInt);
/*  95 */       ReflectionMethod.LIST_SET.run(this.listObject, new Object[] { Integer.valueOf(paramInt), asTag(paramT) });
/*  96 */       save();
/*  97 */       return t;
/*  98 */     } catch (Exception exception) {
/*  99 */       throw new NbtApiException(exception);
/*     */     } finally {
/* 101 */       this.parent.getWriteLock().unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   public T remove(int paramInt) {
/*     */     try {
/* 107 */       this.parent.getWriteLock().lock();
/* 108 */       T t = get(paramInt);
/* 109 */       ReflectionMethod.LIST_REMOVE_KEY.run(this.listObject, new Object[] { Integer.valueOf(paramInt) });
/* 110 */       save();
/* 111 */       return t;
/* 112 */     } catch (Exception exception) {
/* 113 */       throw new NbtApiException(exception);
/*     */     } finally {
/* 115 */       this.parent.getWriteLock().unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   public int size() {
/*     */     try {
/* 121 */       this.parent.getReadLock().lock();
/* 122 */       return ((Integer)ReflectionMethod.LIST_SIZE.run(this.listObject, new Object[0])).intValue();
/* 123 */     } catch (Exception exception) {
/* 124 */       throw new NbtApiException(exception);
/*     */     } finally {
/* 126 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTType getType() {
/* 134 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 139 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 144 */     while (!isEmpty()) {
/* 145 */       remove(0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*     */     try {
/* 152 */       this.parent.getReadLock().lock(); byte b;
/* 153 */       for (b = 0; b < size(); b++) {
/* 154 */         if (paramObject.equals(get(b)))
/* 155 */           return true; 
/*     */       } 
/* 157 */       b = 0; return b;
/*     */     } finally {
/* 159 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/*     */     try {
/* 166 */       this.parent.getReadLock().lock(); byte b;
/* 167 */       for (b = 0; b < size(); b++) {
/* 168 */         if (paramObject.equals(get(b)))
/* 169 */           return b; 
/*     */       } 
/* 171 */       b = -1; return b;
/*     */     } finally {
/* 173 */       this.parent.getReadLock().unlock();
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
/*     */   public boolean addAll(Collection<? extends T> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield parent : Lme/TechsCode/UltraPermissions/dependencies/nbt/NBTCompound;
/*     */     //   4: invokevirtual getWriteLock : ()Ljava/util/concurrent/locks/Lock;
/*     */     //   7: invokeinterface lock : ()V
/*     */     //   12: aload_0
/*     */     //   13: invokevirtual size : ()I
/*     */     //   16: istore_2
/*     */     //   17: aload_1
/*     */     //   18: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   23: astore_3
/*     */     //   24: aload_3
/*     */     //   25: invokeinterface hasNext : ()Z
/*     */     //   30: ifeq -> 51
/*     */     //   33: aload_3
/*     */     //   34: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   39: astore #4
/*     */     //   41: aload_0
/*     */     //   42: aload #4
/*     */     //   44: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   47: pop
/*     */     //   48: goto -> 24
/*     */     //   51: iload_2
/*     */     //   52: aload_0
/*     */     //   53: invokevirtual size : ()I
/*     */     //   56: if_icmpeq -> 63
/*     */     //   59: iconst_1
/*     */     //   60: goto -> 64
/*     */     //   63: iconst_0
/*     */     //   64: istore_3
/*     */     //   65: aload_0
/*     */     //   66: getfield parent : Lme/TechsCode/UltraPermissions/dependencies/nbt/NBTCompound;
/*     */     //   69: invokevirtual getWriteLock : ()Ljava/util/concurrent/locks/Lock;
/*     */     //   72: invokeinterface unlock : ()V
/*     */     //   77: iload_3
/*     */     //   78: ireturn
/*     */     //   79: astore #5
/*     */     //   81: aload_0
/*     */     //   82: getfield parent : Lme/TechsCode/UltraPermissions/dependencies/nbt/NBTCompound;
/*     */     //   85: invokevirtual getWriteLock : ()Ljava/util/concurrent/locks/Lock;
/*     */     //   88: invokeinterface unlock : ()V
/*     */     //   93: aload #5
/*     */     //   95: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #180	-> 0
/*     */     //   #181	-> 12
/*     */     //   #182	-> 17
/*     */     //   #183	-> 41
/*     */     //   #184	-> 48
/*     */     //   #185	-> 51
/*     */     //   #187	-> 65
/*     */     //   #185	-> 77
/*     */     //   #187	-> 79
/*     */     //   #188	-> 93
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	65	79	finally
/*     */     //   79	81	79	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends T> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield parent : Lme/TechsCode/UltraPermissions/dependencies/nbt/NBTCompound;
/*     */     //   4: invokevirtual getWriteLock : ()Ljava/util/concurrent/locks/Lock;
/*     */     //   7: invokeinterface lock : ()V
/*     */     //   12: aload_0
/*     */     //   13: invokevirtual size : ()I
/*     */     //   16: istore_3
/*     */     //   17: aload_2
/*     */     //   18: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   23: astore #4
/*     */     //   25: aload #4
/*     */     //   27: invokeinterface hasNext : ()Z
/*     */     //   32: ifeq -> 57
/*     */     //   35: aload #4
/*     */     //   37: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   42: astore #5
/*     */     //   44: aload_0
/*     */     //   45: iload_1
/*     */     //   46: iinc #1, 1
/*     */     //   49: aload #5
/*     */     //   51: invokevirtual add : (ILjava/lang/Object;)V
/*     */     //   54: goto -> 25
/*     */     //   57: iload_3
/*     */     //   58: aload_0
/*     */     //   59: invokevirtual size : ()I
/*     */     //   62: if_icmpeq -> 69
/*     */     //   65: iconst_1
/*     */     //   66: goto -> 70
/*     */     //   69: iconst_0
/*     */     //   70: istore #4
/*     */     //   72: aload_0
/*     */     //   73: getfield parent : Lme/TechsCode/UltraPermissions/dependencies/nbt/NBTCompound;
/*     */     //   76: invokevirtual getWriteLock : ()Ljava/util/concurrent/locks/Lock;
/*     */     //   79: invokeinterface unlock : ()V
/*     */     //   84: iload #4
/*     */     //   86: ireturn
/*     */     //   87: astore #6
/*     */     //   89: aload_0
/*     */     //   90: getfield parent : Lme/TechsCode/UltraPermissions/dependencies/nbt/NBTCompound;
/*     */     //   93: invokevirtual getWriteLock : ()Ljava/util/concurrent/locks/Lock;
/*     */     //   96: invokeinterface unlock : ()V
/*     */     //   101: aload #6
/*     */     //   103: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #194	-> 0
/*     */     //   #195	-> 12
/*     */     //   #196	-> 17
/*     */     //   #197	-> 44
/*     */     //   #198	-> 54
/*     */     //   #199	-> 57
/*     */     //   #201	-> 72
/*     */     //   #199	-> 84
/*     */     //   #201	-> 87
/*     */     //   #202	-> 101
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	72	87	finally
/*     */     //   87	89	87	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/*     */     try {
/* 208 */       this.parent.getReadLock().lock();
/* 209 */       for (Object object : paramCollection) {
/* 210 */         if (!contains(object))
/* 211 */           return false; 
/*     */       } 
/* 213 */       return true;
/*     */     } finally {
/* 215 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/*     */     try {
/* 222 */       this.parent.getReadLock().lock();
/* 223 */       byte b1 = -1; byte b2;
/* 224 */       for (b2 = 0; b2 < size(); b2++) {
/* 225 */         if (paramObject.equals(get(b2)))
/* 226 */           b1 = b2; 
/*     */       } 
/* 228 */       b2 = b1; return b2;
/*     */     } finally {
/* 230 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/*     */     try {
/* 237 */       this.parent.getWriteLock().lock();
/* 238 */       int i = size();
/* 239 */       for (Object object : paramCollection) {
/* 240 */         remove(object);
/*     */       }
/* 242 */       return (i != size());
/*     */     } finally {
/* 244 */       this.parent.getWriteLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/*     */     try {
/* 251 */       this.parent.getWriteLock().lock();
/* 252 */       int i = size();
/* 253 */       for (Object object : paramCollection) {
/* 254 */         for (byte b = 0; b < size(); b++) {
/* 255 */           if (!object.equals(get(b))) {
/* 256 */             remove(b--);
/*     */           }
/*     */         } 
/*     */       } 
/* 260 */       return (i != size());
/*     */     } finally {
/* 262 */       this.parent.getWriteLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/*     */     try {
/* 269 */       this.parent.getWriteLock().lock();
/* 270 */       int i = size();
/* 271 */       int j = -1;
/* 272 */       while ((j = indexOf(paramObject)) != -1) {
/* 273 */         remove(j);
/*     */       }
/* 275 */       return (i != size());
/*     */     } finally {
/* 277 */       this.parent.getWriteLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 283 */     return new Iterator<T>()
/*     */       {
/* 285 */         private int index = -1;
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/* 289 */           return (NBTList.this.size() > this.index + 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public T next() {
/* 294 */           if (!hasNext())
/* 295 */             throw new NoSuchElementException(); 
/* 296 */           return NBTList.this.get(++this.index);
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 301 */           NBTList.this.remove(this.index);
/* 302 */           this.index--;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<T> listIterator() {
/* 309 */     return listIterator(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<T> listIterator(final int startIndex) {
/* 314 */     final NBTList list = this;
/* 315 */     return new ListIterator<T>()
/*     */       {
/* 317 */         int index = startIndex - 1;
/*     */ 
/*     */         
/*     */         public void add(T param1T) {
/* 321 */           list.add(this.index, param1T);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/* 326 */           return (NBTList.this.size() > this.index + 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean hasPrevious() {
/* 331 */           return (this.index >= 0 && this.index <= NBTList.this.size());
/*     */         }
/*     */ 
/*     */         
/*     */         public T next() {
/* 336 */           if (!hasNext())
/* 337 */             throw new NoSuchElementException(); 
/* 338 */           return NBTList.this.get(++this.index);
/*     */         }
/*     */ 
/*     */         
/*     */         public int nextIndex() {
/* 343 */           return this.index + 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public T previous() {
/* 348 */           if (!hasPrevious())
/* 349 */             throw new NoSuchElementException("Id: " + (this.index - 1)); 
/* 350 */           return NBTList.this.get(this.index--);
/*     */         }
/*     */ 
/*     */         
/*     */         public int previousIndex() {
/* 355 */           return this.index - 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 360 */           list.remove(this.index);
/* 361 */           this.index--;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(T param1T) {
/* 366 */           list.set(this.index, param1T);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/*     */     try {
/* 374 */       this.parent.getReadLock().lock();
/* 375 */       Object[] arrayOfObject = new Object[size()];
/* 376 */       for (byte b = 0; b < size(); b++)
/* 377 */         arrayOfObject[b] = get(b); 
/* 378 */       return arrayOfObject;
/*     */     } finally {
/* 380 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> E[] toArray(E[] paramArrayOfE) {
/*     */     try {
/* 388 */       this.parent.getReadLock().lock();
/* 389 */       Object[] arrayOfObject = Arrays.copyOf((Object[])paramArrayOfE, size());
/* 390 */       Arrays.fill(arrayOfObject, (Object)null);
/* 391 */       Class<?> clazz = paramArrayOfE.getClass().getComponentType();
/* 392 */       for (byte b = 0; b < size(); b++) {
/* 393 */         T t = get(b);
/* 394 */         if (clazz.isInstance(t)) {
/* 395 */           arrayOfObject[b] = get(b);
/*     */         } else {
/* 397 */           throw new ArrayStoreException("The array does not match the objects stored in the List.");
/*     */         } 
/*     */       } 
/* 400 */       return (E[])arrayOfObject;
/*     */     } finally {
/* 402 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<T> subList(int paramInt1, int paramInt2) {
/*     */     try {
/* 409 */       this.parent.getReadLock().lock();
/* 410 */       ArrayList<T> arrayList = new ArrayList();
/* 411 */       for (int i = paramInt1; i < paramInt2; i++)
/* 412 */         arrayList.add(get(i)); 
/* 413 */       return arrayList;
/*     */     } finally {
/* 415 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     try {
/* 422 */       this.parent.getReadLock().lock();
/* 423 */       return this.listObject.toString();
/*     */     } finally {
/* 425 */       this.parent.getReadLock().unlock();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */