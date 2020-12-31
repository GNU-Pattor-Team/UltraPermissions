/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ColognePhonetic
/*     */   implements StringEncoder
/*     */ {
/* 185 */   private static final char[] AEIJOUY = new char[] { 'A', 'E', 'I', 'J', 'O', 'U', 'Y' };
/* 186 */   private static final char[] SCZ = new char[] { 'S', 'C', 'Z' };
/* 187 */   private static final char[] WFPV = new char[] { 'W', 'F', 'P', 'V' };
/* 188 */   private static final char[] GKQ = new char[] { 'G', 'K', 'Q' };
/* 189 */   private static final char[] CKQ = new char[] { 'C', 'K', 'Q' };
/* 190 */   private static final char[] AHKLOQRUX = new char[] { 'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X' };
/* 191 */   private static final char[] SZ = new char[] { 'S', 'Z' };
/* 192 */   private static final char[] AHOUKQX = new char[] { 'A', 'H', 'O', 'U', 'K', 'Q', 'X' };
/* 193 */   private static final char[] TDX = new char[] { 'T', 'D', 'X' };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private abstract class CologneBuffer
/*     */   {
/*     */     protected final char[] data;
/*     */ 
/*     */ 
/*     */     
/* 204 */     protected int length = 0;
/*     */     
/*     */     public CologneBuffer(char[] param1ArrayOfchar) {
/* 207 */       this.data = param1ArrayOfchar;
/* 208 */       this.length = param1ArrayOfchar.length;
/*     */     }
/*     */     
/*     */     public CologneBuffer(int param1Int) {
/* 212 */       this.data = new char[param1Int];
/* 213 */       this.length = 0;
/*     */     }
/*     */     
/*     */     protected abstract char[] copyData(int param1Int1, int param1Int2);
/*     */     
/*     */     public int length() {
/* 219 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 224 */       return new String(copyData(0, this.length));
/*     */     }
/*     */   }
/*     */   
/*     */   private class CologneOutputBuffer
/*     */     extends CologneBuffer {
/*     */     public CologneOutputBuffer(int param1Int) {
/* 231 */       super(param1Int);
/*     */     }
/*     */     
/*     */     public void addRight(char param1Char) {
/* 235 */       this.data[this.length] = param1Char;
/* 236 */       this.length++;
/*     */     }
/*     */ 
/*     */     
/*     */     protected char[] copyData(int param1Int1, int param1Int2) {
/* 241 */       char[] arrayOfChar = new char[param1Int2];
/* 242 */       System.arraycopy(this.data, param1Int1, arrayOfChar, 0, param1Int2);
/* 243 */       return arrayOfChar;
/*     */     }
/*     */   }
/*     */   
/*     */   private class CologneInputBuffer
/*     */     extends CologneBuffer {
/*     */     public CologneInputBuffer(char[] param1ArrayOfchar) {
/* 250 */       super(param1ArrayOfchar);
/*     */     }
/*     */     
/*     */     public void addLeft(char param1Char) {
/* 254 */       this.length++;
/* 255 */       this.data[getNextPos()] = param1Char;
/*     */     }
/*     */ 
/*     */     
/*     */     protected char[] copyData(int param1Int1, int param1Int2) {
/* 260 */       char[] arrayOfChar = new char[param1Int2];
/* 261 */       System.arraycopy(this.data, this.data.length - this.length + param1Int1, arrayOfChar, 0, param1Int2);
/* 262 */       return arrayOfChar;
/*     */     }
/*     */     
/*     */     public char getNextChar() {
/* 266 */       return this.data[getNextPos()];
/*     */     }
/*     */     
/*     */     protected int getNextPos() {
/* 270 */       return this.data.length - this.length;
/*     */     }
/*     */     
/*     */     public char removeNext() {
/* 274 */       char c = getNextChar();
/* 275 */       this.length--;
/* 276 */       return c;
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
/*     */   private static boolean arrayContains(char[] paramArrayOfchar, char paramChar) {
/* 294 */     for (char c : paramArrayOfchar) {
/* 295 */       if (c == paramChar) {
/* 296 */         return true;
/*     */       }
/*     */     } 
/* 299 */     return false;
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
/*     */   public String colognePhonetic(String paramString) {
/* 314 */     if (paramString == null) {
/* 315 */       return null;
/*     */     }
/*     */     
/* 318 */     CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess(paramString));
/* 319 */     CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(cologneInputBuffer.length() * 2);
/*     */ 
/*     */ 
/*     */     
/* 323 */     byte b1 = 47;
/* 324 */     byte b2 = 45;
/*     */     
/* 326 */     char c1 = '-';
/* 327 */     char c2 = '/';
/*     */ 
/*     */ 
/*     */     
/* 331 */     while (cologneInputBuffer.length() > 0) {
/* 332 */       byte b; char c; char c3 = cologneInputBuffer.removeNext();
/*     */       
/* 334 */       if (cologneInputBuffer.length() > 0) {
/* 335 */         b = cologneInputBuffer.getNextChar();
/*     */       } else {
/* 337 */         b = 45;
/*     */       } 
/*     */ 
/*     */       
/* 341 */       if (c3 == 'H' || c3 < 'A' || c3 > 'Z') {
/*     */         continue;
/*     */       }
/*     */       
/* 345 */       if (arrayContains(AEIJOUY, c3)) {
/* 346 */         c = '0';
/* 347 */       } else if (c3 == 'B' || (c3 == 'P' && b != 72)) {
/* 348 */         c = '1';
/* 349 */       } else if ((c3 == 'D' || c3 == 'T') && !arrayContains(SCZ, b)) {
/* 350 */         c = '2';
/* 351 */       } else if (arrayContains(WFPV, c3)) {
/* 352 */         c = '3';
/* 353 */       } else if (arrayContains(GKQ, c3)) {
/* 354 */         c = '4';
/* 355 */       } else if (c3 == 'X' && !arrayContains(CKQ, c1)) {
/* 356 */         c = '4';
/* 357 */         cologneInputBuffer.addLeft('S');
/* 358 */       } else if (c3 == 'S' || c3 == 'Z') {
/* 359 */         c = '8';
/* 360 */       } else if (c3 == 'C') {
/* 361 */         if (c2 == '/') {
/* 362 */           if (arrayContains(AHKLOQRUX, b)) {
/* 363 */             c = '4';
/*     */           } else {
/* 365 */             c = '8';
/*     */           }
/*     */         
/* 368 */         } else if (arrayContains(SZ, c1) || !arrayContains(AHOUKQX, b)) {
/* 369 */           c = '8';
/*     */         } else {
/* 371 */           c = '4';
/*     */         }
/*     */       
/* 374 */       } else if (arrayContains(TDX, c3)) {
/* 375 */         c = '8';
/* 376 */       } else if (c3 == 'R') {
/* 377 */         c = '7';
/* 378 */       } else if (c3 == 'L') {
/* 379 */         c = '5';
/* 380 */       } else if (c3 == 'M' || c3 == 'N') {
/* 381 */         c = '6';
/*     */       } else {
/* 383 */         c = c3;
/*     */       } 
/*     */       
/* 386 */       if (c != '-' && ((c2 != c && (c != '0' || c2 == '/')) || c < '0' || c > '8')) {
/* 387 */         cologneOutputBuffer.addRight(c);
/*     */       }
/*     */       
/* 390 */       c1 = c3;
/* 391 */       c2 = c;
/*     */     } 
/* 393 */     return cologneOutputBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object encode(Object paramObject) {
/* 398 */     if (!(paramObject instanceof String)) {
/* 399 */       throw new EncoderException("This method's parameter was expected to be of the type " + String.class
/* 400 */           .getName() + ". But actually it was of the type " + paramObject
/*     */           
/* 402 */           .getClass().getName() + ".");
/*     */     }
/*     */     
/* 405 */     return encode((String)paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public String encode(String paramString) {
/* 410 */     return colognePhonetic(paramString);
/*     */   }
/*     */   
/*     */   public boolean isEncodeEqual(String paramString1, String paramString2) {
/* 414 */     return colognePhonetic(paramString1).equals(colognePhonetic(paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private char[] preprocess(String paramString) {
/* 422 */     char[] arrayOfChar = paramString.toUpperCase(Locale.GERMAN).toCharArray();
/*     */     
/* 424 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 425 */       switch (arrayOfChar[b]) {
/*     */         case 'Ä':
/* 427 */           arrayOfChar[b] = 'A';
/*     */           break;
/*     */         case 'Ü':
/* 430 */           arrayOfChar[b] = 'U';
/*     */           break;
/*     */         case 'Ö':
/* 433 */           arrayOfChar[b] = 'O';
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 439 */     return arrayOfChar;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/ColognePhonetic.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */