/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.UnaryOperator;
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
/*     */ 
/*     */ 
/*     */ public final class FastList<T>
/*     */   extends ArrayList<T>
/*     */ {
/*     */   private static final long serialVersionUID = -4598088075242913858L;
/*     */   private final Class<?> clazz;
/*     */   private T[] elementData;
/*     */   private int size;
/*     */   
/*     */   public FastList(Class<?> paramClass) {
/*  51 */     this.elementData = (T[])Array.newInstance(paramClass, 32);
/*  52 */     this.clazz = paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FastList(Class<?> paramClass, int paramInt) {
/*  63 */     this.elementData = (T[])Array.newInstance(paramClass, paramInt);
/*  64 */     this.clazz = paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(T paramT) {
/*     */     try {
/*  76 */       this.elementData[this.size++] = paramT;
/*     */     }
/*  78 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*     */       
/*  80 */       int i = this.elementData.length;
/*  81 */       int j = i << 1;
/*     */       
/*  83 */       Object[] arrayOfObject = (Object[])Array.newInstance(this.clazz, j);
/*  84 */       System.arraycopy(this.elementData, 0, arrayOfObject, 0, i);
/*  85 */       arrayOfObject[this.size - 1] = paramT;
/*  86 */       this.elementData = (T[])arrayOfObject;
/*     */     } 
/*     */     
/*  89 */     return true;
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
/*     */   public T get(int paramInt) {
/* 101 */     return this.elementData[paramInt];
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
/*     */   public T removeLast() {
/* 113 */     T t = this.elementData[--this.size];
/* 114 */     this.elementData[this.size] = null;
/* 115 */     return t;
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
/*     */   public boolean remove(Object paramObject) {
/* 128 */     for (int i = this.size - 1; i >= 0; i--) {
/* 129 */       if (paramObject == this.elementData[i]) {
/* 130 */         int j = this.size - i - 1;
/* 131 */         if (j > 0) {
/* 132 */           System.arraycopy(this.elementData, i + 1, this.elementData, i, j);
/*     */         }
/* 134 */         this.elementData[--this.size] = null;
/* 135 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 148 */     for (byte b = 0; b < this.size; b++) {
/* 149 */       this.elementData[b] = null;
/*     */     }
/*     */     
/* 152 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 163 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 170 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T set(int paramInt, T paramT) {
/* 177 */     T t = this.elementData[paramInt];
/* 178 */     this.elementData[paramInt] = paramT;
/* 179 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T remove(int paramInt) {
/* 186 */     T t = this.elementData[paramInt];
/*     */     
/* 188 */     int i = this.size - paramInt - 1;
/* 189 */     if (i > 0) {
/* 190 */       System.arraycopy(this.elementData, paramInt + 1, this.elementData, paramInt, i);
/*     */     }
/*     */     
/* 193 */     this.elementData[--this.size] = null;
/*     */     
/* 195 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 202 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 209 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 216 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> E[] toArray(E[] paramArrayOfE) {
/* 223 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 230 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends T> paramCollection) {
/* 237 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends T> paramCollection) {
/* 244 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 251 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 258 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int paramInt, T paramT) {
/* 265 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 272 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/* 279 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<T> listIterator() {
/* 286 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<T> listIterator(int paramInt) {
/* 293 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<T> subList(int paramInt1, int paramInt2) {
/* 300 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trimToSize() {
/* 307 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 314 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 321 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeRange(int paramInt1, int paramInt2) {
/* 328 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void forEach(Consumer<? super T> paramConsumer) {
/* 334 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Spliterator<T> spliterator() {
/* 340 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeIf(Predicate<? super T> paramPredicate) {
/* 346 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceAll(UnaryOperator<T> paramUnaryOperator) {
/* 352 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sort(Comparator<? super T> paramComparator) {
/* 358 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/FastList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */