/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.monitor;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.ThreadFactory;
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
/*     */ public final class FileAlterationMonitor
/*     */   implements Runnable
/*     */ {
/*     */   private final long interval;
/*  34 */   private final List<FileAlterationObserver> observers = new CopyOnWriteArrayList<>();
/*  35 */   private Thread thread = null;
/*     */   
/*     */   private ThreadFactory threadFactory;
/*     */   
/*     */   private volatile boolean running = false;
/*     */ 
/*     */   
/*     */   public FileAlterationMonitor() {
/*  43 */     this(10000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationMonitor(long paramLong) {
/*  53 */     this.interval = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationMonitor(long paramLong, FileAlterationObserver... paramVarArgs) {
/*  64 */     this(paramLong);
/*  65 */     if (paramVarArgs != null) {
/*  66 */       for (FileAlterationObserver fileAlterationObserver : paramVarArgs) {
/*  67 */         addObserver(fileAlterationObserver);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getInterval() {
/*  78 */     return this.interval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setThreadFactory(ThreadFactory paramThreadFactory) {
/*  87 */     this.threadFactory = paramThreadFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addObserver(FileAlterationObserver paramFileAlterationObserver) {
/*  96 */     if (paramFileAlterationObserver != null) {
/*  97 */       this.observers.add(paramFileAlterationObserver);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeObserver(FileAlterationObserver paramFileAlterationObserver) {
/* 107 */     if (paramFileAlterationObserver != null) {
/* 108 */       while (this.observers.remove(paramFileAlterationObserver));
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
/*     */   public Iterable<FileAlterationObserver> getObservers() {
/* 120 */     return this.observers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void start() {
/* 129 */     if (this.running) {
/* 130 */       throw new IllegalStateException("Monitor is already running");
/*     */     }
/* 132 */     for (FileAlterationObserver fileAlterationObserver : this.observers) {
/* 133 */       fileAlterationObserver.initialize();
/*     */     }
/* 135 */     this.running = true;
/* 136 */     if (this.threadFactory != null) {
/* 137 */       this.thread = this.threadFactory.newThread(this);
/*     */     } else {
/* 139 */       this.thread = new Thread(this);
/*     */     } 
/* 141 */     this.thread.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void stop() {
/* 150 */     stop(this.interval);
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
/*     */   public synchronized void stop(long paramLong) {
/* 162 */     if (!this.running) {
/* 163 */       throw new IllegalStateException("Monitor is not running");
/*     */     }
/* 165 */     this.running = false;
/*     */     try {
/* 167 */       this.thread.join(paramLong);
/* 168 */     } catch (InterruptedException interruptedException) {
/* 169 */       Thread.currentThread().interrupt();
/*     */     } 
/* 171 */     for (FileAlterationObserver fileAlterationObserver : this.observers) {
/* 172 */       fileAlterationObserver.destroy();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 181 */     while (this.running) {
/* 182 */       for (FileAlterationObserver fileAlterationObserver : this.observers) {
/* 183 */         fileAlterationObserver.checkAndNotify();
/*     */       }
/* 185 */       if (!this.running) {
/*     */         break;
/*     */       }
/*     */       try {
/* 189 */         Thread.sleep(this.interval);
/* 190 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/monitor/FileAlterationMonitor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */