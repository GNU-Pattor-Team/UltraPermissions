/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.DataInput;
/*     */ import java.io.EOFException;
/*     */ import java.io.InputStream;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.EndianUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SwappedDataInputStream
/*     */   extends ProxyInputStream
/*     */   implements DataInput
/*     */ {
/*     */   public SwappedDataInputStream(InputStream paramInputStream) {
/*  47 */     super(paramInputStream);
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
/*     */   public boolean readBoolean() {
/*  60 */     return (0 != readByte());
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
/*     */   public byte readByte() {
/*  73 */     return (byte)this.in.read();
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
/*     */   public char readChar() {
/*  86 */     return (char)readShort();
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
/*     */   public double readDouble() {
/*  99 */     return EndianUtils.readSwappedDouble(this.in);
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
/*     */   public float readFloat() {
/* 112 */     return EndianUtils.readSwappedFloat(this.in);
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
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/* 126 */     readFully(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 143 */     int i = paramInt2;
/*     */     
/* 145 */     while (i > 0) {
/*     */       
/* 147 */       int j = paramInt1 + paramInt2 - i;
/* 148 */       int k = read(paramArrayOfbyte, j, i);
/*     */       
/* 150 */       if (-1 == k)
/*     */       {
/* 152 */         throw new EOFException();
/*     */       }
/*     */       
/* 155 */       i -= k;
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
/*     */   public int readInt() {
/* 169 */     return EndianUtils.readSwappedInteger(this.in);
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
/*     */   public String readLine() {
/* 182 */     throw new UnsupportedOperationException("Operation not supported: readLine()");
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
/*     */   public long readLong() {
/* 196 */     return EndianUtils.readSwappedLong(this.in);
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
/*     */   public short readShort() {
/* 209 */     return EndianUtils.readSwappedShort(this.in);
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
/*     */   public int readUnsignedByte() {
/* 222 */     return this.in.read();
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
/*     */   public int readUnsignedShort() {
/* 235 */     return EndianUtils.readSwappedUnsignedShort(this.in);
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
/*     */   public String readUTF() {
/* 248 */     throw new UnsupportedOperationException("Operation not supported: readUTF()");
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
/*     */   public int skipBytes(int paramInt) {
/* 263 */     return (int)this.in.skip(paramInt);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/SwappedDataInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */