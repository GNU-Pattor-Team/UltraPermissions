/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.charset.Charset;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.FileUtils;
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
/*     */ public class Tailer
/*     */   implements Runnable
/*     */ {
/*     */   private static final int DEFAULT_DELAY_MILLIS = 1000;
/*     */   private static final String RAF_MODE = "r";
/*     */   private static final int DEFAULT_BUFSIZE = 4096;
/* 129 */   private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] inbuf;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final File file;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Charset cset;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final long delayMillis;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean end;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TailerListener listener;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean reOpen;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean run = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener) {
/* 177 */     this(paramFile, paramTailerListener, 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong) {
/* 187 */     this(paramFile, paramTailerListener, paramLong, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean) {
/* 198 */     this(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
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
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 211 */     this(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
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
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt) {
/* 224 */     this(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
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
/*     */   public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 238 */     this(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
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
/*     */   public Tailer(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 254 */     this.file = paramFile;
/* 255 */     this.delayMillis = paramLong;
/* 256 */     this.end = paramBoolean1;
/*     */     
/* 258 */     this.inbuf = new byte[paramInt];
/*     */ 
/*     */     
/* 261 */     this.listener = paramTailerListener;
/* 262 */     paramTailerListener.init(this);
/* 263 */     this.reOpen = paramBoolean2;
/* 264 */     this.cset = paramCharset;
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt) {
/* 279 */     return create(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 296 */     return create(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
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
/*     */   public static Tailer create(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 314 */     Tailer tailer = new Tailer(paramFile, paramCharset, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
/* 315 */     Thread thread = new Thread(tailer);
/* 316 */     thread.setDaemon(true);
/* 317 */     thread.start();
/* 318 */     return tailer;
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean) {
/* 332 */     return create(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 347 */     return create(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong) {
/* 359 */     return create(paramFile, paramTailerListener, paramLong, false);
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
/*     */   public static Tailer create(File paramFile, TailerListener paramTailerListener) {
/* 371 */     return create(paramFile, paramTailerListener, 1000L, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getFile() {
/* 380 */     return this.file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean getRun() {
/* 390 */     return this.run;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDelay() {
/* 399 */     return this.delayMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 407 */     RandomAccessFile randomAccessFile = null;
/*     */     try {
/* 409 */       long l1 = 0L;
/* 410 */       long l2 = 0L;
/*     */       
/* 412 */       while (getRun() && randomAccessFile == null) {
/*     */         try {
/* 414 */           randomAccessFile = new RandomAccessFile(this.file, "r");
/* 415 */         } catch (FileNotFoundException fileNotFoundException) {
/* 416 */           this.listener.fileNotFound();
/*     */         } 
/* 418 */         if (randomAccessFile == null) {
/* 419 */           Thread.sleep(this.delayMillis);
/*     */           continue;
/*     */         } 
/* 422 */         l2 = this.end ? this.file.length() : 0L;
/* 423 */         l1 = this.file.lastModified();
/* 424 */         randomAccessFile.seek(l2);
/*     */       } 
/*     */       
/* 427 */       while (getRun()) {
/* 428 */         boolean bool = FileUtils.isFileNewer(this.file, l1);
/*     */         
/* 430 */         long l = this.file.length();
/* 431 */         if (l < l2) {
/*     */           
/* 433 */           this.listener.fileRotated();
/*     */ 
/*     */           
/* 436 */           try (RandomAccessFile null = randomAccessFile) {
/* 437 */             randomAccessFile = new RandomAccessFile(this.file, "r");
/*     */ 
/*     */             
/*     */             try {
/* 441 */               readLines(randomAccessFile1);
/* 442 */             } catch (IOException iOException) {
/* 443 */               this.listener.handle(iOException);
/*     */             } 
/* 445 */             l2 = 0L;
/* 446 */           } catch (FileNotFoundException fileNotFoundException) {
/*     */             
/* 448 */             this.listener.fileNotFound();
/* 449 */             Thread.sleep(this.delayMillis);
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 455 */         if (l > l2) {
/*     */           
/* 457 */           l2 = readLines(randomAccessFile);
/* 458 */           l1 = this.file.lastModified();
/* 459 */         } else if (bool) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 464 */           l2 = 0L;
/* 465 */           randomAccessFile.seek(l2);
/*     */ 
/*     */           
/* 468 */           l2 = readLines(randomAccessFile);
/* 469 */           l1 = this.file.lastModified();
/*     */         } 
/*     */         
/* 472 */         if (this.reOpen && randomAccessFile != null) {
/* 473 */           randomAccessFile.close();
/*     */         }
/* 475 */         Thread.sleep(this.delayMillis);
/* 476 */         if (getRun() && this.reOpen) {
/* 477 */           randomAccessFile = new RandomAccessFile(this.file, "r");
/* 478 */           randomAccessFile.seek(l2);
/*     */         } 
/*     */       } 
/* 481 */     } catch (InterruptedException interruptedException) {
/* 482 */       Thread.currentThread().interrupt();
/* 483 */       this.listener.handle(interruptedException);
/* 484 */     } catch (Exception exception) {
/* 485 */       this.listener.handle(exception);
/*     */     } finally {
/*     */       try {
/* 488 */         if (randomAccessFile != null) {
/* 489 */           randomAccessFile.close();
/*     */         }
/*     */       }
/* 492 */       catch (IOException iOException) {
/* 493 */         this.listener.handle(iOException);
/*     */       } 
/* 495 */       stop();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 503 */     this.run = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long readLines(RandomAccessFile paramRandomAccessFile) {
/* 514 */     try (ByteArrayOutputStream null = new ByteArrayOutputStream(64)) {
/* 515 */       long l1 = paramRandomAccessFile.getFilePointer();
/* 516 */       long l2 = l1;
/*     */       
/* 518 */       boolean bool = false; int i;
/* 519 */       while (getRun() && (i = paramRandomAccessFile.read(this.inbuf)) != -1) {
/* 520 */         for (byte b = 0; b < i; b++) {
/* 521 */           byte b1 = this.inbuf[b];
/* 522 */           switch (b1) {
/*     */             case 10:
/* 524 */               bool = false;
/* 525 */               this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
/* 526 */               byteArrayOutputStream.reset();
/* 527 */               l2 = l1 + b + 1L;
/*     */               break;
/*     */             case 13:
/* 530 */               if (bool) {
/* 531 */                 byteArrayOutputStream.write(13);
/*     */               }
/* 533 */               bool = true;
/*     */               break;
/*     */             default:
/* 536 */               if (bool) {
/* 537 */                 bool = false;
/* 538 */                 this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
/* 539 */                 byteArrayOutputStream.reset();
/* 540 */                 l2 = l1 + b + 1L;
/*     */               } 
/* 542 */               byteArrayOutputStream.write(b1); break;
/*     */           } 
/*     */         } 
/* 545 */         l1 = paramRandomAccessFile.getFilePointer();
/*     */       } 
/*     */       
/* 548 */       paramRandomAccessFile.seek(l2);
/*     */       
/* 550 */       if (this.listener instanceof TailerListenerAdapter) {
/* 551 */         ((TailerListenerAdapter)this.listener).endOfFileReached();
/*     */       }
/*     */       
/* 554 */       return l2;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/Tailer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */