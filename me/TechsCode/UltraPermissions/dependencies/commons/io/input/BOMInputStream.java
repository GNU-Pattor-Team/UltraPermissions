/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.ByteOrderMark;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BOMInputStream
/*     */   extends ProxyInputStream
/*     */ {
/*     */   private final boolean include;
/*     */   private final List<ByteOrderMark> boms;
/*     */   private ByteOrderMark byteOrderMark;
/*     */   private int[] firstBytes;
/*     */   private int fbLength;
/*     */   private int fbIndex;
/*     */   private int markFbIndex;
/*     */   private boolean markedAtStart;
/*     */   
/*     */   public BOMInputStream(InputStream paramInputStream) {
/* 110 */     this(paramInputStream, false, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
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
/*     */   public BOMInputStream(InputStream paramInputStream, boolean paramBoolean) {
/* 122 */     this(paramInputStream, paramBoolean, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
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
/*     */   public BOMInputStream(InputStream paramInputStream, ByteOrderMark... paramVarArgs) {
/* 134 */     this(paramInputStream, false, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>()
/*     */     {
/*     */       public int compare(ByteOrderMark param1ByteOrderMark1, ByteOrderMark param1ByteOrderMark2)
/*     */       {
/* 144 */         int i = param1ByteOrderMark1.length();
/* 145 */         int j = param1ByteOrderMark2.length();
/* 146 */         if (i > j) {
/* 147 */           return -1;
/*     */         }
/* 149 */         if (j > i) {
/* 150 */           return 1;
/*     */         }
/* 152 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BOMInputStream(InputStream paramInputStream, boolean paramBoolean, ByteOrderMark... paramVarArgs) {
/* 167 */     super(paramInputStream);
/* 168 */     if (paramVarArgs == null || paramVarArgs.length == 0) {
/* 169 */       throw new IllegalArgumentException("No BOMs specified");
/*     */     }
/* 171 */     this.include = paramBoolean;
/* 172 */     List<ByteOrderMark> list = Arrays.asList(paramVarArgs);
/*     */     
/* 174 */     Collections.sort(list, ByteOrderMarkLengthComparator);
/* 175 */     this.boms = list;
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
/*     */   public boolean hasBOM() {
/* 187 */     return (getBOM() != null);
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
/*     */   public boolean hasBOM(ByteOrderMark paramByteOrderMark) {
/* 202 */     if (!this.boms.contains(paramByteOrderMark)) {
/* 203 */       throw new IllegalArgumentException("Stream not configure to detect " + paramByteOrderMark);
/*     */     }
/* 205 */     getBOM();
/* 206 */     return (this.byteOrderMark != null && this.byteOrderMark.equals(paramByteOrderMark));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteOrderMark getBOM() {
/* 217 */     if (this.firstBytes == null) {
/* 218 */       this.fbLength = 0;
/*     */       
/* 220 */       int i = ((ByteOrderMark)this.boms.get(0)).length();
/* 221 */       this.firstBytes = new int[i];
/*     */       
/* 223 */       for (byte b = 0; b < this.firstBytes.length; b++) {
/* 224 */         this.firstBytes[b] = this.in.read();
/* 225 */         this.fbLength++;
/* 226 */         if (this.firstBytes[b] < 0) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       
/* 231 */       this.byteOrderMark = find();
/* 232 */       if (this.byteOrderMark != null && 
/* 233 */         !this.include) {
/* 234 */         if (this.byteOrderMark.length() < this.firstBytes.length) {
/* 235 */           this.fbIndex = this.byteOrderMark.length();
/*     */         } else {
/* 237 */           this.fbLength = 0;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 242 */     return this.byteOrderMark;
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
/*     */   public String getBOMCharsetName() {
/* 254 */     getBOM();
/* 255 */     return (this.byteOrderMark == null) ? null : this.byteOrderMark.getCharsetName();
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
/*     */   private int readFirstBytes() {
/* 268 */     getBOM();
/* 269 */     return (this.fbIndex < this.fbLength) ? this.firstBytes[this.fbIndex++] : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ByteOrderMark find() {
/* 278 */     for (ByteOrderMark byteOrderMark : this.boms) {
/* 279 */       if (matches(byteOrderMark)) {
/* 280 */         return byteOrderMark;
/*     */       }
/*     */     } 
/* 283 */     return null;
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
/*     */   private boolean matches(ByteOrderMark paramByteOrderMark) {
/* 298 */     for (byte b = 0; b < paramByteOrderMark.length(); b++) {
/* 299 */       if (paramByteOrderMark.get(b) != this.firstBytes[b]) {
/* 300 */         return false;
/*     */       }
/*     */     } 
/* 303 */     return true;
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
/*     */   public int read() {
/* 319 */     int i = readFirstBytes();
/* 320 */     return (i >= 0) ? i : this.in.read();
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 338 */     byte b = 0;
/* 339 */     int i = 0;
/* 340 */     while (paramInt2 > 0 && i) {
/* 341 */       i = readFirstBytes();
/* 342 */       if (i >= 0) {
/* 343 */         paramArrayOfbyte[paramInt1++] = (byte)(i & 0xFF);
/* 344 */         paramInt2--;
/* 345 */         b++;
/*     */       } 
/*     */     } 
/* 348 */     int j = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 349 */     return (j < 0) ? ((b > 0) ? b : -1) : (b + j);
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
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 363 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 374 */     this.markFbIndex = this.fbIndex;
/* 375 */     this.markedAtStart = (this.firstBytes == null);
/* 376 */     this.in.mark(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/* 387 */     this.fbIndex = this.markFbIndex;
/* 388 */     if (this.markedAtStart) {
/* 389 */       this.firstBytes = null;
/*     */     }
/*     */     
/* 392 */     this.in.reset();
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
/*     */   public long skip(long paramLong) {
/* 406 */     byte b = 0;
/* 407 */     while (paramLong > b && readFirstBytes() >= 0) {
/* 408 */       b++;
/*     */     }
/* 410 */     return this.in.skip(paramLong - b) + b;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/BOMInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */