/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.Charsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReversedLinesFileReader
/*     */   implements Closeable
/*     */ {
/*     */   private final int blockSize;
/*     */   private final Charset encoding;
/*     */   private final RandomAccessFile randomAccessFile;
/*     */   private final long totalByteLength;
/*     */   private final long totalBlockCount;
/*     */   private final byte[][] newLineSequences;
/*     */   private final int avoidNewlineSplitBufferSize;
/*     */   private final int byteDecrement;
/*     */   private FilePart currentFilePart;
/*     */   private boolean trailingNewlineOfFileSkipped = false;
/*     */   
/*     */   @Deprecated
/*     */   public ReversedLinesFileReader(File paramFile) {
/*  65 */     this(paramFile, 4096, Charset.defaultCharset());
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
/*     */   public ReversedLinesFileReader(File paramFile, Charset paramCharset) {
/*  79 */     this(paramFile, 4096, paramCharset);
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
/*     */   public ReversedLinesFileReader(File paramFile, int paramInt, Charset paramCharset) {
/*  96 */     this.blockSize = paramInt;
/*  97 */     this.encoding = paramCharset;
/*     */ 
/*     */     
/* 100 */     Charset charset = Charsets.toCharset(paramCharset);
/* 101 */     CharsetEncoder charsetEncoder = charset.newEncoder();
/* 102 */     float f = charsetEncoder.maxBytesPerChar();
/* 103 */     if (f == 1.0F)
/*     */     
/* 105 */     { this.byteDecrement = 1; }
/* 106 */     else if (charset == StandardCharsets.UTF_8)
/*     */     
/*     */     { 
/* 109 */       this.byteDecrement = 1; }
/* 110 */     else if (charset == Charset.forName("Shift_JIS") || charset == 
/*     */       
/* 112 */       Charset.forName("windows-31j") || charset == 
/* 113 */       Charset.forName("x-windows-949") || charset == 
/* 114 */       Charset.forName("gbk") || charset == 
/* 115 */       Charset.forName("x-windows-950"))
/* 116 */     { this.byteDecrement = 1; }
/* 117 */     else if (charset == StandardCharsets.UTF_16BE || charset == StandardCharsets.UTF_16LE)
/*     */     
/*     */     { 
/* 120 */       this.byteDecrement = 2; }
/* 121 */     else { if (charset == StandardCharsets.UTF_16) {
/* 122 */         throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
/*     */       }
/*     */       
/* 125 */       throw new UnsupportedEncodingException("Encoding " + paramCharset + " is not supported yet (feel free to submit a patch)"); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     this.newLineSequences = new byte[][] { "\r\n".getBytes(paramCharset), "\n".getBytes(paramCharset), "\r".getBytes(paramCharset) };
/*     */     
/* 132 */     this.avoidNewlineSplitBufferSize = (this.newLineSequences[0]).length;
/*     */ 
/*     */     
/* 135 */     this.randomAccessFile = new RandomAccessFile(paramFile, "r");
/* 136 */     this.totalByteLength = this.randomAccessFile.length();
/* 137 */     int i = (int)(this.totalByteLength % paramInt);
/* 138 */     if (i > 0) {
/* 139 */       this.totalBlockCount = this.totalByteLength / paramInt + 1L;
/*     */     } else {
/* 141 */       this.totalBlockCount = this.totalByteLength / paramInt;
/* 142 */       if (this.totalByteLength > 0L) {
/* 143 */         i = paramInt;
/*     */       }
/*     */     } 
/* 146 */     this.currentFilePart = new FilePart(this.totalBlockCount, i, null);
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
/*     */   public ReversedLinesFileReader(File paramFile, int paramInt, String paramString) {
/* 165 */     this(paramFile, paramInt, Charsets.toCharset(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readLine() {
/* 176 */     String str = this.currentFilePart.readLine();
/* 177 */     while (str == null) {
/* 178 */       this.currentFilePart = this.currentFilePart.rollOver();
/* 179 */       if (this.currentFilePart != null) {
/* 180 */         str = this.currentFilePart.readLine();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     if ("".equals(str) && !this.trailingNewlineOfFileSkipped) {
/* 189 */       this.trailingNewlineOfFileSkipped = true;
/* 190 */       str = readLine();
/*     */     } 
/*     */     
/* 193 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 203 */     this.randomAccessFile.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class FilePart
/*     */   {
/*     */     private final long no;
/*     */ 
/*     */     
/*     */     private final byte[] data;
/*     */ 
/*     */     
/*     */     private byte[] leftOver;
/*     */ 
/*     */     
/*     */     private int currentLastBytePos;
/*     */ 
/*     */     
/*     */     private FilePart(long param1Long, int param1Int, byte[] param1ArrayOfbyte) {
/* 223 */       this.no = param1Long;
/* 224 */       int i = param1Int + ((param1ArrayOfbyte != null) ? param1ArrayOfbyte.length : 0);
/* 225 */       this.data = new byte[i];
/* 226 */       long l = (param1Long - 1L) * ReversedLinesFileReader.this.blockSize;
/*     */ 
/*     */       
/* 229 */       if (param1Long > 0L) {
/* 230 */         ReversedLinesFileReader.this.randomAccessFile.seek(l);
/* 231 */         int j = ReversedLinesFileReader.this.randomAccessFile.read(this.data, 0, param1Int);
/* 232 */         if (j != param1Int) {
/* 233 */           throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
/*     */         }
/*     */       } 
/*     */       
/* 237 */       if (param1ArrayOfbyte != null) {
/* 238 */         System.arraycopy(param1ArrayOfbyte, 0, this.data, param1Int, param1ArrayOfbyte.length);
/*     */       }
/* 240 */       this.currentLastBytePos = this.data.length - 1;
/* 241 */       this.leftOver = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private FilePart rollOver() {
/* 252 */       if (this.currentLastBytePos > -1) {
/* 253 */         throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
/*     */       }
/*     */ 
/*     */       
/* 257 */       if (this.no > 1L) {
/* 258 */         return new FilePart(this.no - 1L, ReversedLinesFileReader.this.blockSize, this.leftOver);
/*     */       }
/*     */       
/* 261 */       if (this.leftOver != null) {
/* 262 */         throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this
/* 263 */               .encoding));
/*     */       }
/* 265 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String readLine() {
/* 277 */       String str = null;
/*     */ 
/*     */       
/* 280 */       boolean bool = (this.no == 1L) ? true : false;
/*     */       
/* 282 */       int i = this.currentLastBytePos;
/* 283 */       while (i > -1) {
/*     */         
/* 285 */         if (!bool && i < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
/*     */ 
/*     */           
/* 288 */           createLeftOver();
/*     */           
/*     */           break;
/*     */         } 
/*     */         int j;
/* 293 */         if ((j = getNewLineMatchByteCount(this.data, i)) > 0) {
/* 294 */           int k = i + 1;
/* 295 */           int m = this.currentLastBytePos - k + 1;
/*     */           
/* 297 */           if (m < 0) {
/* 298 */             throw new IllegalStateException("Unexpected negative line length=" + m);
/*     */           }
/* 300 */           byte[] arrayOfByte = new byte[m];
/* 301 */           System.arraycopy(this.data, k, arrayOfByte, 0, m);
/*     */           
/* 303 */           str = new String(arrayOfByte, ReversedLinesFileReader.this.encoding);
/*     */           
/* 305 */           this.currentLastBytePos = i - j;
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 310 */         i -= ReversedLinesFileReader.this.byteDecrement;
/*     */ 
/*     */         
/* 313 */         if (i < 0) {
/* 314 */           createLeftOver();
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 320 */       if (bool && this.leftOver != null) {
/*     */         
/* 322 */         str = new String(this.leftOver, ReversedLinesFileReader.this.encoding);
/* 323 */         this.leftOver = null;
/*     */       } 
/*     */       
/* 326 */       return str;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void createLeftOver() {
/* 333 */       int i = this.currentLastBytePos + 1;
/* 334 */       if (i > 0) {
/*     */         
/* 336 */         this.leftOver = new byte[i];
/* 337 */         System.arraycopy(this.data, 0, this.leftOver, 0, i);
/*     */       } else {
/* 339 */         this.leftOver = null;
/*     */       } 
/* 341 */       this.currentLastBytePos = -1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int getNewLineMatchByteCount(byte[] param1ArrayOfbyte, int param1Int) {
/* 352 */       for (byte[] arrayOfByte : ReversedLinesFileReader.this.newLineSequences) {
/* 353 */         int i = 1;
/* 354 */         for (int j = arrayOfByte.length - 1; j >= 0; j--) {
/* 355 */           int k = param1Int + j - arrayOfByte.length - 1;
/* 356 */           i &= (k >= 0 && param1ArrayOfbyte[k] == arrayOfByte[j]) ? 1 : 0;
/*     */         } 
/* 358 */         if (i != 0) {
/* 359 */           return arrayOfByte.length;
/*     */         }
/*     */       } 
/* 362 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/ReversedLinesFileReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */