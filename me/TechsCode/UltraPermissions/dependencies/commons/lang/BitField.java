/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BitField
/*     */ {
/*     */   private final int _mask;
/*     */   private final int _shift_count;
/*     */   
/*     */   public BitField(int paramInt) {
/*  45 */     this._mask = paramInt;
/*  46 */     byte b = 0;
/*  47 */     int i = paramInt;
/*     */     
/*  49 */     if (i != 0) {
/*  50 */       while ((i & 0x1) == 0) {
/*  51 */         b++;
/*  52 */         i >>= 1;
/*     */       } 
/*     */     }
/*  55 */     this._shift_count = b;
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
/*     */   public int getValue(int paramInt) {
/*  73 */     return getRawValue(paramInt) >> this._shift_count;
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
/*     */   public short getShortValue(short paramShort) {
/*  91 */     return (short)getValue(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRawValue(int paramInt) {
/* 102 */     return paramInt & this._mask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getShortRawValue(short paramShort) {
/* 113 */     return (short)getRawValue(paramShort);
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
/*     */   public boolean isSet(int paramInt) {
/* 130 */     return ((paramInt & this._mask) != 0);
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
/*     */   public boolean isAllSet(int paramInt) {
/* 146 */     return ((paramInt & this._mask) == this._mask);
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
/*     */   public int setValue(int paramInt1, int paramInt2) {
/* 160 */     return paramInt1 & (this._mask ^ 0xFFFFFFFF) | paramInt2 << this._shift_count & this._mask;
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
/*     */   public short setShortValue(short paramShort1, short paramShort2) {
/* 174 */     return (short)setValue(paramShort1, paramShort2);
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
/*     */   public int clear(int paramInt) {
/* 186 */     return paramInt & (this._mask ^ 0xFFFFFFFF);
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
/*     */   public short clearShort(short paramShort) {
/* 198 */     return (short)clear(paramShort);
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
/*     */   public byte clearByte(byte paramByte) {
/* 211 */     return (byte)clear(paramByte);
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
/*     */   public int set(int paramInt) {
/* 223 */     return paramInt | this._mask;
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
/*     */   public short setShort(short paramShort) {
/* 235 */     return (short)set(paramShort);
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
/*     */   public byte setByte(byte paramByte) {
/* 248 */     return (byte)set(paramByte);
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
/*     */   public int setBoolean(int paramInt, boolean paramBoolean) {
/* 261 */     return paramBoolean ? set(paramInt) : clear(paramInt);
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
/*     */   public short setShortBoolean(short paramShort, boolean paramBoolean) {
/* 274 */     return paramBoolean ? setShort(paramShort) : clearShort(paramShort);
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
/*     */   public byte setByteBoolean(byte paramByte, boolean paramBoolean) {
/* 287 */     return paramBoolean ? setByte(paramByte) : clearByte(paramByte);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/BitField.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */