/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.SequenceInputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.input.ClosedInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ByteArrayOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   static final int DEFAULT_SIZE = 1024;
/*  61 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*     */ 
/*     */   
/*  64 */   private final List<byte[]> buffers = (List)new ArrayList<>();
/*     */ 
/*     */   
/*     */   private int currentBufferIndex;
/*     */ 
/*     */   
/*     */   private int filledBufferSum;
/*     */ 
/*     */   
/*     */   private byte[] currentBuffer;
/*     */   
/*     */   private int count;
/*     */   
/*     */   private boolean reuseBuffers = true;
/*     */ 
/*     */   
/*     */   public ByteArrayOutputStream() {
/*  81 */     this(1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteArrayOutputStream(int paramInt) {
/*  92 */     if (paramInt < 0) {
/*  93 */       throw new IllegalArgumentException("Negative initial size: " + paramInt);
/*     */     }
/*     */     
/*  96 */     synchronized (this) {
/*  97 */       needNewBuffer(paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void needNewBuffer(int paramInt) {
/* 108 */     if (this.currentBufferIndex < this.buffers.size() - 1) {
/*     */       
/* 110 */       this.filledBufferSum += this.currentBuffer.length;
/*     */       
/* 112 */       this.currentBufferIndex++;
/* 113 */       this.currentBuffer = this.buffers.get(this.currentBufferIndex);
/*     */     } else {
/*     */       int i;
/*     */       
/* 117 */       if (this.currentBuffer == null) {
/* 118 */         i = paramInt;
/* 119 */         this.filledBufferSum = 0;
/*     */       } else {
/* 121 */         i = Math.max(this.currentBuffer.length << 1, paramInt - this.filledBufferSum);
/*     */ 
/*     */         
/* 124 */         this.filledBufferSum += this.currentBuffer.length;
/*     */       } 
/*     */       
/* 127 */       this.currentBufferIndex++;
/* 128 */       this.currentBuffer = new byte[i];
/* 129 */       this.buffers.add(this.currentBuffer);
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
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 141 */     if (paramInt1 < 0 || paramInt1 > paramArrayOfbyte.length || paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length || paramInt1 + paramInt2 < 0)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 146 */       throw new IndexOutOfBoundsException(); } 
/* 147 */     if (paramInt2 == 0) {
/*     */       return;
/*     */     }
/* 150 */     synchronized (this) {
/* 151 */       int i = this.count + paramInt2;
/* 152 */       int j = paramInt2;
/* 153 */       int k = this.count - this.filledBufferSum;
/* 154 */       while (j > 0) {
/* 155 */         int m = Math.min(j, this.currentBuffer.length - k);
/* 156 */         System.arraycopy(paramArrayOfbyte, paramInt1 + paramInt2 - j, this.currentBuffer, k, m);
/* 157 */         j -= m;
/* 158 */         if (j > 0) {
/* 159 */           needNewBuffer(i);
/* 160 */           k = 0;
/*     */         } 
/*     */       } 
/* 163 */       this.count = i;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void write(int paramInt) {
/* 173 */     int i = this.count - this.filledBufferSum;
/* 174 */     if (i == this.currentBuffer.length) {
/* 175 */       needNewBuffer(this.count + 1);
/* 176 */       i = 0;
/*     */     } 
/* 178 */     this.currentBuffer[i] = (byte)paramInt;
/* 179 */     this.count++;
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
/*     */   public synchronized int write(InputStream paramInputStream) {
/* 194 */     int i = 0;
/* 195 */     int j = this.count - this.filledBufferSum;
/* 196 */     int k = paramInputStream.read(this.currentBuffer, j, this.currentBuffer.length - j);
/* 197 */     while (k != -1) {
/* 198 */       i += k;
/* 199 */       j += k;
/* 200 */       this.count += k;
/* 201 */       if (j == this.currentBuffer.length) {
/* 202 */         needNewBuffer(this.currentBuffer.length);
/* 203 */         j = 0;
/*     */       } 
/* 205 */       k = paramInputStream.read(this.currentBuffer, j, this.currentBuffer.length - j);
/*     */     } 
/* 207 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int size() {
/* 215 */     return this.count;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/* 235 */     this.count = 0;
/* 236 */     this.filledBufferSum = 0;
/* 237 */     this.currentBufferIndex = 0;
/* 238 */     if (this.reuseBuffers) {
/* 239 */       this.currentBuffer = this.buffers.get(this.currentBufferIndex);
/*     */     } else {
/*     */       
/* 242 */       this.currentBuffer = null;
/* 243 */       int i = ((byte[])this.buffers.get(0)).length;
/* 244 */       this.buffers.clear();
/* 245 */       needNewBuffer(i);
/* 246 */       this.reuseBuffers = true;
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
/*     */   public synchronized void writeTo(OutputStream paramOutputStream) {
/* 259 */     int i = this.count;
/* 260 */     for (byte[] arrayOfByte : this.buffers) {
/* 261 */       int j = Math.min(arrayOfByte.length, i);
/* 262 */       paramOutputStream.write(arrayOfByte, 0, j);
/* 263 */       i -= j;
/* 264 */       if (i == 0) {
/*     */         break;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InputStream toBufferedInputStream(InputStream paramInputStream) {
/* 293 */     return toBufferedInputStream(paramInputStream, 1024);
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
/*     */ 
/*     */   
/*     */   public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt) {
/* 322 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramInt);
/* 323 */     byteArrayOutputStream.write(paramInputStream);
/* 324 */     return byteArrayOutputStream.toInputStream();
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
/*     */   public synchronized InputStream toInputStream() {
/* 338 */     int i = this.count;
/* 339 */     if (i == 0) {
/* 340 */       return (InputStream)new ClosedInputStream();
/*     */     }
/* 342 */     ArrayList<ByteArrayInputStream> arrayList = new ArrayList(this.buffers.size());
/* 343 */     for (byte[] arrayOfByte : this.buffers) {
/* 344 */       int j = Math.min(arrayOfByte.length, i);
/* 345 */       arrayList.add(new ByteArrayInputStream(arrayOfByte, 0, j));
/* 346 */       i -= j;
/* 347 */       if (i == 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 351 */     this.reuseBuffers = false;
/* 352 */     return new SequenceInputStream(Collections.enumeration((Collection)arrayList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized byte[] toByteArray() {
/* 363 */     int i = this.count;
/* 364 */     if (i == 0) {
/* 365 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 367 */     byte[] arrayOfByte = new byte[i];
/* 368 */     int j = 0;
/* 369 */     for (byte[] arrayOfByte1 : this.buffers) {
/* 370 */       int k = Math.min(arrayOfByte1.length, i);
/* 371 */       System.arraycopy(arrayOfByte1, 0, arrayOfByte, j, k);
/* 372 */       j += k;
/* 373 */       i -= k;
/* 374 */       if (i == 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 378 */     return arrayOfByte;
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
/*     */   public String toString() {
/* 392 */     return new String(toByteArray(), Charset.defaultCharset());
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
/*     */   public String toString(String paramString) {
/* 405 */     return new String(toByteArray(), paramString);
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
/*     */   public String toString(Charset paramCharset) {
/* 418 */     return new String(toByteArray(), paramCharset);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/ByteArrayOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */