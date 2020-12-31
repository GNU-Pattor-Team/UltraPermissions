/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.text.StrBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CharRange
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8270183163158333422L;
/*     */   private final char start;
/*     */   private final char end;
/*     */   private final boolean negated;
/*     */   private transient String iToString;
/*     */   
/*     */   public static CharRange is(char paramChar) {
/*  67 */     return new CharRange(paramChar, paramChar, false);
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
/*     */   public static CharRange isNot(char paramChar) {
/*  79 */     return new CharRange(paramChar, paramChar, true);
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
/*     */   public static CharRange isIn(char paramChar1, char paramChar2) {
/*  92 */     return new CharRange(paramChar1, paramChar2, false);
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
/*     */   public static CharRange isNotIn(char paramChar1, char paramChar2) {
/* 105 */     return new CharRange(paramChar1, paramChar2, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharRange(char paramChar) {
/* 115 */     this(paramChar, paramChar, false);
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
/*     */   public CharRange(char paramChar, boolean paramBoolean) {
/* 128 */     this(paramChar, paramChar, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharRange(char paramChar1, char paramChar2) {
/* 138 */     this(paramChar1, paramChar2, false);
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
/*     */   public CharRange(char paramChar1, char paramChar2, boolean paramBoolean) {
/* 157 */     if (paramChar1 > paramChar2) {
/* 158 */       char c = paramChar1;
/* 159 */       paramChar1 = paramChar2;
/* 160 */       paramChar2 = c;
/*     */     } 
/*     */     
/* 163 */     this.start = paramChar1;
/* 164 */     this.end = paramChar2;
/* 165 */     this.negated = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getStart() {
/* 176 */     return this.start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getEnd() {
/* 185 */     return this.end;
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
/*     */   public boolean isNegated() {
/* 197 */     return this.negated;
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
/*     */   public boolean contains(char paramChar) {
/* 209 */     return (((paramChar >= this.start && paramChar <= this.end)) != this.negated);
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
/*     */   public boolean contains(CharRange paramCharRange) {
/* 221 */     if (paramCharRange == null) {
/* 222 */       throw new IllegalArgumentException("The Range must not be null");
/*     */     }
/* 224 */     if (this.negated) {
/* 225 */       if (paramCharRange.negated) {
/* 226 */         return (this.start >= paramCharRange.start && this.end <= paramCharRange.end);
/*     */       }
/* 228 */       return (paramCharRange.end < this.start || paramCharRange.start > this.end);
/*     */     } 
/* 230 */     if (paramCharRange.negated) {
/* 231 */       return (this.start == '\000' && this.end == Character.MAX_VALUE);
/*     */     }
/* 233 */     return (this.start <= paramCharRange.start && this.end >= paramCharRange.end);
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
/*     */   public boolean equals(Object paramObject) {
/* 246 */     if (paramObject == this) {
/* 247 */       return true;
/*     */     }
/* 249 */     if (!(paramObject instanceof CharRange)) {
/* 250 */       return false;
/*     */     }
/* 252 */     CharRange charRange = (CharRange)paramObject;
/* 253 */     return (this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 262 */     return 83 + this.start + 7 * this.end + (this.negated ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 271 */     if (this.iToString == null) {
/* 272 */       StrBuilder strBuilder = new StrBuilder(4);
/* 273 */       if (isNegated()) {
/* 274 */         strBuilder.append('^');
/*     */       }
/* 276 */       strBuilder.append(this.start);
/* 277 */       if (this.start != this.end) {
/* 278 */         strBuilder.append('-');
/* 279 */         strBuilder.append(this.end);
/*     */       } 
/* 281 */       this.iToString = strBuilder.toString();
/*     */     } 
/* 283 */     return this.iToString;
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
/*     */   public Iterator iterator() {
/* 296 */     return new CharacterIterator(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CharacterIterator
/*     */     implements Iterator
/*     */   {
/*     */     private char current;
/*     */ 
/*     */     
/*     */     private final CharRange range;
/*     */ 
/*     */     
/*     */     private boolean hasNext;
/*     */ 
/*     */ 
/*     */     
/*     */     private CharacterIterator(CharRange param1CharRange) {
/* 316 */       this.range = param1CharRange;
/* 317 */       this.hasNext = true;
/*     */       
/* 319 */       if (this.range.negated) {
/* 320 */         if (this.range.start == '\000') {
/* 321 */           if (this.range.end == Character.MAX_VALUE) {
/*     */             
/* 323 */             this.hasNext = false;
/*     */           } else {
/* 325 */             this.current = (char)(this.range.end + 1);
/*     */           } 
/*     */         } else {
/* 328 */           this.current = Character.MIN_VALUE;
/*     */         } 
/*     */       } else {
/* 331 */         this.current = this.range.start;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void prepareNext() {
/* 339 */       if (this.range.negated) {
/* 340 */         if (this.current == Character.MAX_VALUE) {
/* 341 */           this.hasNext = false;
/* 342 */         } else if (this.current + 1 == this.range.start) {
/* 343 */           if (this.range.end == Character.MAX_VALUE) {
/* 344 */             this.hasNext = false;
/*     */           } else {
/* 346 */             this.current = (char)(this.range.end + 1);
/*     */           } 
/*     */         } else {
/* 349 */           this.current = (char)(this.current + 1);
/*     */         } 
/* 351 */       } else if (this.current < this.range.end) {
/* 352 */         this.current = (char)(this.current + 1);
/*     */       } else {
/* 354 */         this.hasNext = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 364 */       return this.hasNext;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object next() {
/* 373 */       if (!this.hasNext) {
/* 374 */         throw new NoSuchElementException();
/*     */       }
/* 376 */       char c = this.current;
/* 377 */       prepareNext();
/* 378 */       return new Character(c);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/CharRange.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */