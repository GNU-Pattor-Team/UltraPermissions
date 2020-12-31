/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnixLineEndingInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private boolean slashNSeen = false;
/*     */   private boolean slashRSeen = false;
/*     */   private boolean eofSeen = false;
/*     */   private final InputStream target;
/*     */   private final boolean ensureLineFeedAtEndOfFile;
/*     */   
/*     */   public UnixLineEndingInputStream(InputStream paramInputStream, boolean paramBoolean) {
/*  47 */     this.target = paramInputStream;
/*  48 */     this.ensureLineFeedAtEndOfFile = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readWithUpdate() {
/*  57 */     int i = this.target.read();
/*  58 */     this.eofSeen = (i == -1);
/*  59 */     if (this.eofSeen) {
/*  60 */       return i;
/*     */     }
/*  62 */     this.slashNSeen = (i == 10);
/*  63 */     this.slashRSeen = (i == 13);
/*  64 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() {
/*  72 */     boolean bool = this.slashRSeen;
/*  73 */     if (this.eofSeen) {
/*  74 */       return eofGame(bool);
/*     */     }
/*     */     
/*  77 */     int i = readWithUpdate();
/*  78 */     if (this.eofSeen) {
/*  79 */       return eofGame(bool);
/*     */     }
/*  81 */     if (this.slashRSeen)
/*     */     {
/*  83 */       return 10;
/*     */     }
/*     */     
/*  86 */     if (bool && this.slashNSeen) {
/*  87 */       return read();
/*     */     }
/*     */     
/*  90 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int eofGame(boolean paramBoolean) {
/* 100 */     if (paramBoolean || !this.ensureLineFeedAtEndOfFile) {
/* 101 */       return -1;
/*     */     }
/* 103 */     if (!this.slashNSeen) {
/* 104 */       this.slashNSeen = true;
/* 105 */       return 10;
/*     */     } 
/* 107 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 117 */     super.close();
/* 118 */     this.target.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 126 */     throw new UnsupportedOperationException("Mark notsupported");
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/UnixLineEndingInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */