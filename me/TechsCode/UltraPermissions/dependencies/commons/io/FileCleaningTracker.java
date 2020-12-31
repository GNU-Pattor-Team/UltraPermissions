/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
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
/*     */ public class FileCleaningTracker
/*     */ {
/*  50 */   ReferenceQueue<Object> q = new ReferenceQueue();
/*     */ 
/*     */ 
/*     */   
/*  54 */   final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet<>());
/*     */ 
/*     */ 
/*     */   
/*  58 */   final List<String> deleteFailures = Collections.synchronizedList(new ArrayList<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   volatile boolean exitWhenFinished = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Thread reaper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void track(File paramFile, Object paramObject) {
/*  79 */     track(paramFile, paramObject, (FileDeleteStrategy)null);
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
/*     */   public void track(File paramFile, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy) {
/*  93 */     if (paramFile == null) {
/*  94 */       throw new NullPointerException("The file must not be null");
/*     */     }
/*  96 */     addTracker(paramFile.getPath(), paramObject, paramFileDeleteStrategy);
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
/*     */   public void track(String paramString, Object paramObject) {
/* 109 */     track(paramString, paramObject, (FileDeleteStrategy)null);
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
/*     */   public void track(String paramString, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy) {
/* 123 */     if (paramString == null) {
/* 124 */       throw new NullPointerException("The path must not be null");
/*     */     }
/* 126 */     addTracker(paramString, paramObject, paramFileDeleteStrategy);
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
/*     */   private synchronized void addTracker(String paramString, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy) {
/* 139 */     if (this.exitWhenFinished) {
/* 140 */       throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
/*     */     }
/* 142 */     if (this.reaper == null) {
/* 143 */       this.reaper = new Reaper();
/* 144 */       this.reaper.start();
/*     */     } 
/* 146 */     this.trackers.add(new Tracker(paramString, paramFileDeleteStrategy, paramObject, this.q));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTrackCount() {
/* 157 */     return this.trackers.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getDeleteFailures() {
/* 167 */     return this.deleteFailures;
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
/*     */   public synchronized void exitWhenFinished() {
/* 194 */     this.exitWhenFinished = true;
/* 195 */     if (this.reaper != null) {
/* 196 */       synchronized (this.reaper) {
/* 197 */         this.reaper.interrupt();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final class Reaper
/*     */     extends Thread
/*     */   {
/*     */     Reaper() {
/* 209 */       super("File Reaper");
/* 210 */       setPriority(10);
/* 211 */       setDaemon(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 221 */       while (!FileCleaningTracker.this.exitWhenFinished || FileCleaningTracker.this.trackers.size() > 0) {
/*     */         
/*     */         try {
/* 224 */           FileCleaningTracker.Tracker tracker = (FileCleaningTracker.Tracker)FileCleaningTracker.this.q.remove();
/* 225 */           FileCleaningTracker.this.trackers.remove(tracker);
/* 226 */           if (!tracker.delete()) {
/* 227 */             FileCleaningTracker.this.deleteFailures.add(tracker.getPath());
/*     */           }
/* 229 */           tracker.clear();
/* 230 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
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
/*     */   private static final class Tracker
/*     */     extends PhantomReference<Object>
/*     */   {
/*     */     private final String path;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final FileDeleteStrategy deleteStrategy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Tracker(String param1String, FileDeleteStrategy param1FileDeleteStrategy, Object param1Object, ReferenceQueue<? super Object> param1ReferenceQueue) {
/* 262 */       super(param1Object, param1ReferenceQueue);
/* 263 */       this.path = param1String;
/* 264 */       this.deleteStrategy = (param1FileDeleteStrategy == null) ? FileDeleteStrategy.NORMAL : param1FileDeleteStrategy;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPath() {
/* 273 */       return this.path;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean delete() {
/* 283 */       return this.deleteStrategy.deleteQuietly(new File(this.path));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/FileCleaningTracker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */