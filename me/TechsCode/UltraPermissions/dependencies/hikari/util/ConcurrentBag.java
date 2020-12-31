/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.Logger;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.LoggerFactory;
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
/*     */ public class ConcurrentBag<T extends ConcurrentBag.IConcurrentBagEntry>
/*     */   implements AutoCloseable
/*     */ {
/*  59 */   private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentBag.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final QueuedSequenceSynchronizer synchronizer;
/*     */ 
/*     */ 
/*     */   
/*     */   private final CopyOnWriteArrayList<T> sharedList;
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean weakThreadLocals;
/*     */ 
/*     */ 
/*     */   
/*     */   private final ThreadLocal<List> threadList;
/*     */ 
/*     */ 
/*     */   
/*     */   private final IBagStateListener listener;
/*     */ 
/*     */ 
/*     */   
/*     */   private final AtomicInteger waiters;
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean closed;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConcurrentBag(IBagStateListener paramIBagStateListener) {
/*  94 */     this.listener = paramIBagStateListener;
/*  95 */     this.weakThreadLocals = useWeakThreadLocals();
/*     */     
/*  97 */     this.waiters = new AtomicInteger();
/*  98 */     this.sharedList = new CopyOnWriteArrayList<>();
/*  99 */     this.synchronizer = new QueuedSequenceSynchronizer();
/* 100 */     if (this.weakThreadLocals) {
/* 101 */       this.threadList = new ThreadLocal<>();
/*     */     } else {
/*     */       
/* 104 */       this.threadList = new ThreadLocal<List>()
/*     */         {
/*     */           protected List initialValue()
/*     */           {
/* 108 */             return new FastList(ConcurrentBag.IConcurrentBagEntry.class, 16);
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface IBagStateListener
/*     */   {
/*     */     Future<Boolean> addBagItem();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T borrow(long paramLong, TimeUnit paramTimeUnit) {
/* 126 */     List<WeakReference<IConcurrentBagEntry>> list = this.threadList.get();
/* 127 */     if (this.weakThreadLocals && list == null) {
/* 128 */       list = new ArrayList(16);
/* 129 */       this.threadList.set(list);
/*     */     } 
/*     */     
/* 132 */     for (int i = list.size() - 1; i >= 0; i--) {
/*     */       
/* 134 */       IConcurrentBagEntry iConcurrentBagEntry = this.weakThreadLocals ? ((WeakReference<IConcurrentBagEntry>)list.remove(i)).get() : (IConcurrentBagEntry)list.remove(i);
/* 135 */       if (iConcurrentBagEntry != null && iConcurrentBagEntry.compareAndSet(0, 1)) {
/* 136 */         return (T)iConcurrentBagEntry;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 141 */     paramLong = paramTimeUnit.toNanos(paramLong);
/* 142 */     Future<Boolean> future = null;
/* 143 */     long l1 = System.nanoTime();
/* 144 */     long l2 = paramLong;
/*     */     
/* 146 */     this.waiters.incrementAndGet();
/*     */ 
/*     */ 
/*     */     
/*     */     try { while (true) {
/* 151 */         long l = this.synchronizer.currentSequence();
/* 152 */         for (IConcurrentBagEntry iConcurrentBagEntry : this.sharedList) {
/* 153 */           if (iConcurrentBagEntry.compareAndSet(0, 1)) {
/*     */             
/* 155 */             if (this.waiters.get() > 1 && future == null) {
/* 156 */               this.listener.addBagItem();
/*     */             }
/*     */             
/* 159 */             return (T)iConcurrentBagEntry;
/*     */           } 
/*     */         } 
/* 162 */         if (l >= this.synchronizer.currentSequence())
/*     */         
/* 164 */         { if (future == null || future.isDone()) {
/* 165 */             future = this.listener.addBagItem();
/*     */           }
/*     */           
/* 168 */           paramLong = l2 - System.nanoTime() - l1;
/* 169 */           if (paramLong <= 10000L || !this.synchronizer.waitUntilSequenceExceeded(l, paramLong))
/*     */             break;  } 
/*     */       }  }
/* 172 */     finally { this.waiters.decrementAndGet(); }
/*     */ 
/*     */     
/* 175 */     return null;
/*     */   }
/*     */   public static interface IConcurrentBagEntry {
/*     */     public static final int STATE_NOT_IN_USE = 0;
/*     */     public static final int STATE_IN_USE = 1;
/*     */     public static final int STATE_REMOVED = -1;
/*     */     public static final int STATE_RESERVED = -2;
/*     */     
/*     */     boolean compareAndSet(int param1Int1, int param1Int2);
/*     */     
/*     */     void lazySet(int param1Int);
/*     */     
/*     */     int getState(); }
/*     */   
/*     */   public void requite(T paramT) {
/* 190 */     paramT.lazySet(0);
/*     */     
/* 192 */     List list = this.threadList.get();
/* 193 */     if (list != null) {
/* 194 */       list.add(this.weakThreadLocals ? new WeakReference<>(paramT) : paramT);
/*     */     }
/*     */     
/* 197 */     this.synchronizer.signal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(T paramT) {
/* 207 */     if (this.closed) {
/* 208 */       LOGGER.info("ConcurrentBag has been closed, ignoring add()");
/* 209 */       throw new IllegalStateException("ConcurrentBag has been closed, ignoring add()");
/*     */     } 
/*     */     
/* 212 */     this.sharedList.add(paramT);
/* 213 */     this.synchronizer.signal();
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
/*     */   public boolean remove(T paramT) {
/* 227 */     if (!paramT.compareAndSet(1, -1) && !paramT.compareAndSet(-2, -1) && !this.closed) {
/* 228 */       LOGGER.warn("Attempt to remove an object from the bag that was not borrowed or reserved: {}", paramT);
/* 229 */       return false;
/*     */     } 
/*     */     
/* 232 */     boolean bool = this.sharedList.remove(paramT);
/* 233 */     if (!bool && !this.closed) {
/* 234 */       LOGGER.warn("Attempt to remove an object from the bag that does not exist: {}", paramT);
/*     */     }
/*     */ 
/*     */     
/* 238 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 247 */     this.closed = true;
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
/*     */   public List<T> values(int paramInt) {
/* 261 */     ArrayList<IConcurrentBagEntry> arrayList = new ArrayList(this.sharedList.size());
/* 262 */     for (IConcurrentBagEntry iConcurrentBagEntry : this.sharedList) {
/* 263 */       if (iConcurrentBagEntry.getState() == paramInt) {
/* 264 */         arrayList.add(iConcurrentBagEntry);
/*     */       }
/*     */     } 
/*     */     
/* 268 */     return (List)arrayList;
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
/*     */   public List<T> values() {
/* 282 */     return (List<T>)this.sharedList.clone();
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
/*     */   
/*     */   public boolean reserve(T paramT) {
/* 299 */     return paramT.compareAndSet(0, -2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unreserve(T paramT) {
/* 310 */     if (paramT.compareAndSet(-2, 0)) {
/* 311 */       this.synchronizer.signal();
/*     */     } else {
/*     */       
/* 314 */       LOGGER.warn("Attempt to relinquish an object to the bag that was not reserved: {}", paramT);
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
/*     */   public int getPendingQueue() {
/* 326 */     return this.synchronizer.getQueueLength();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCount(int paramInt) {
/* 337 */     byte b = 0;
/* 338 */     for (IConcurrentBagEntry iConcurrentBagEntry : this.sharedList) {
/* 339 */       if (iConcurrentBagEntry.getState() == paramInt) {
/* 340 */         b++;
/*     */       }
/*     */     } 
/* 343 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 353 */     return this.sharedList.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dumpState() {
/* 358 */     for (IConcurrentBagEntry iConcurrentBagEntry : this.sharedList) {
/* 359 */       LOGGER.info(iConcurrentBagEntry.toString());
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
/*     */   private boolean useWeakThreadLocals() {
/*     */     try {
/* 373 */       if (System.getProperty("me.TechsCode.UltraPermissions.dependencies.hikari.useWeakReferences") != null) {
/* 374 */         return Boolean.getBoolean("me.TechsCode.UltraPermissions.dependencies.hikari.useWeakReferences");
/*     */       }
/*     */       
/* 377 */       return (getClass().getClassLoader() != ClassLoader.getSystemClassLoader());
/*     */     }
/* 379 */     catch (SecurityException securityException) {
/* 380 */       return true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/ConcurrentBag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */