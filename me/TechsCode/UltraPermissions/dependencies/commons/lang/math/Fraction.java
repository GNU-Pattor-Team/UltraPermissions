/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.math;
/*     */ 
/*     */ import java.math.BigInteger;
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
/*     */ public final class Fraction
/*     */   extends Number
/*     */   implements Comparable
/*     */ {
/*     */   private static final long serialVersionUID = 65382027393090L;
/*  50 */   public static final Fraction ZERO = new Fraction(0, 1);
/*     */ 
/*     */ 
/*     */   
/*  54 */   public static final Fraction ONE = new Fraction(1, 1);
/*     */ 
/*     */ 
/*     */   
/*  58 */   public static final Fraction ONE_HALF = new Fraction(1, 2);
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final Fraction ONE_THIRD = new Fraction(1, 3);
/*     */ 
/*     */ 
/*     */   
/*  66 */   public static final Fraction TWO_THIRDS = new Fraction(2, 3);
/*     */ 
/*     */ 
/*     */   
/*  70 */   public static final Fraction ONE_QUARTER = new Fraction(1, 4);
/*     */ 
/*     */ 
/*     */   
/*  74 */   public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
/*     */ 
/*     */ 
/*     */   
/*  78 */   public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
/*     */ 
/*     */ 
/*     */   
/*  82 */   public static final Fraction ONE_FIFTH = new Fraction(1, 5);
/*     */ 
/*     */ 
/*     */   
/*  86 */   public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
/*     */ 
/*     */ 
/*     */   
/*  94 */   public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int numerator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int denominator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/* 113 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */   
/* 117 */   private transient String toProperString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Fraction(int paramInt1, int paramInt2) {
/* 128 */     this.numerator = paramInt1;
/* 129 */     this.denominator = paramInt2;
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
/*     */   public static Fraction getFraction(int paramInt1, int paramInt2) {
/* 144 */     if (paramInt2 == 0) {
/* 145 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 147 */     if (paramInt2 < 0) {
/* 148 */       if (paramInt1 == Integer.MIN_VALUE || paramInt2 == Integer.MIN_VALUE)
/*     */       {
/* 150 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 152 */       paramInt1 = -paramInt1;
/* 153 */       paramInt2 = -paramInt2;
/*     */     } 
/* 155 */     return new Fraction(paramInt1, paramInt2);
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
/*     */   public static Fraction getFraction(int paramInt1, int paramInt2, int paramInt3) {
/*     */     long l;
/* 175 */     if (paramInt3 == 0) {
/* 176 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 178 */     if (paramInt3 < 0) {
/* 179 */       throw new ArithmeticException("The denominator must not be negative");
/*     */     }
/* 181 */     if (paramInt2 < 0) {
/* 182 */       throw new ArithmeticException("The numerator must not be negative");
/*     */     }
/*     */     
/* 185 */     if (paramInt1 < 0) {
/* 186 */       l = paramInt1 * paramInt3 - paramInt2;
/*     */     } else {
/* 188 */       l = paramInt1 * paramInt3 + paramInt2;
/*     */     } 
/* 190 */     if (l < -2147483648L || l > 2147483647L)
/*     */     {
/* 192 */       throw new ArithmeticException("Numerator too large to represent as an Integer.");
/*     */     }
/* 194 */     return new Fraction((int)l, paramInt3);
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
/*     */   public static Fraction getReducedFraction(int paramInt1, int paramInt2) {
/* 212 */     if (paramInt2 == 0) {
/* 213 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 215 */     if (paramInt1 == 0) {
/* 216 */       return ZERO;
/*     */     }
/*     */     
/* 219 */     if (paramInt2 == Integer.MIN_VALUE && (paramInt1 & 0x1) == 0) {
/* 220 */       paramInt1 /= 2; paramInt2 /= 2;
/*     */     } 
/* 222 */     if (paramInt2 < 0) {
/* 223 */       if (paramInt1 == Integer.MIN_VALUE || paramInt2 == Integer.MIN_VALUE)
/*     */       {
/* 225 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 227 */       paramInt1 = -paramInt1;
/* 228 */       paramInt2 = -paramInt2;
/*     */     } 
/*     */     
/* 231 */     int i = greatestCommonDivisor(paramInt1, paramInt2);
/* 232 */     paramInt1 /= i;
/* 233 */     paramInt2 /= i;
/* 234 */     return new Fraction(paramInt1, paramInt2);
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
/*     */   public static Fraction getFraction(double paramDouble) {
/*     */     double d5;
/* 252 */     byte b1 = (paramDouble < 0.0D) ? -1 : 1;
/* 253 */     paramDouble = Math.abs(paramDouble);
/* 254 */     if (paramDouble > 2.147483647E9D || Double.isNaN(paramDouble)) {
/* 255 */       throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
/*     */     }
/*     */     
/* 258 */     int i = (int)paramDouble;
/* 259 */     paramDouble -= i;
/*     */     
/* 261 */     int j = 0;
/* 262 */     int k = 1;
/* 263 */     int m = 1;
/* 264 */     int n = 0;
/* 265 */     int i1 = 0;
/* 266 */     int i2 = 0;
/* 267 */     int i3 = (int)paramDouble;
/* 268 */     int i4 = 0;
/* 269 */     double d1 = 1.0D;
/* 270 */     double d2 = 0.0D;
/* 271 */     double d3 = paramDouble - i3;
/* 272 */     double d4 = 0.0D;
/* 273 */     double d6 = Double.MAX_VALUE;
/*     */     
/* 275 */     byte b2 = 1;
/*     */     
/*     */     do {
/* 278 */       d5 = d6;
/* 279 */       i4 = (int)(d1 / d3);
/* 280 */       d2 = d3;
/* 281 */       d4 = d1 - i4 * d3;
/* 282 */       i1 = i3 * m + j;
/* 283 */       i2 = i3 * n + k;
/* 284 */       double d = i1 / i2;
/* 285 */       d6 = Math.abs(paramDouble - d);
/*     */       
/* 287 */       i3 = i4;
/* 288 */       d1 = d2;
/* 289 */       d3 = d4;
/* 290 */       j = m;
/* 291 */       k = n;
/* 292 */       m = i1;
/* 293 */       n = i2;
/* 294 */       b2++;
/*     */     }
/* 296 */     while (d5 > d6 && i2 <= 10000 && i2 > 0 && b2 < 25);
/* 297 */     if (b2 == 25) {
/* 298 */       throw new ArithmeticException("Unable to convert double to fraction");
/*     */     }
/* 300 */     return getReducedFraction((j + i * k) * b1, k);
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
/*     */   public static Fraction getFraction(String paramString) {
/* 322 */     if (paramString == null) {
/* 323 */       throw new IllegalArgumentException("The string must not be null");
/*     */     }
/*     */     
/* 326 */     int i = paramString.indexOf('.');
/* 327 */     if (i >= 0) {
/* 328 */       return getFraction(Double.parseDouble(paramString));
/*     */     }
/*     */ 
/*     */     
/* 332 */     i = paramString.indexOf(' ');
/* 333 */     if (i > 0) {
/* 334 */       int m = Integer.parseInt(paramString.substring(0, i));
/* 335 */       paramString = paramString.substring(i + 1);
/* 336 */       i = paramString.indexOf('/');
/* 337 */       if (i < 0) {
/* 338 */         throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
/*     */       }
/* 340 */       int n = Integer.parseInt(paramString.substring(0, i));
/* 341 */       int i1 = Integer.parseInt(paramString.substring(i + 1));
/* 342 */       return getFraction(m, n, i1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 347 */     i = paramString.indexOf('/');
/* 348 */     if (i < 0)
/*     */     {
/* 350 */       return getFraction(Integer.parseInt(paramString), 1);
/*     */     }
/* 352 */     int j = Integer.parseInt(paramString.substring(0, i));
/* 353 */     int k = Integer.parseInt(paramString.substring(i + 1));
/* 354 */     return getFraction(j, k);
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
/*     */   public int getNumerator() {
/* 370 */     return this.numerator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDenominator() {
/* 379 */     return this.denominator;
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
/*     */   public int getProperNumerator() {
/* 394 */     return Math.abs(this.numerator % this.denominator);
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
/*     */   public int getProperWhole() {
/* 409 */     return this.numerator / this.denominator;
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
/*     */   public int intValue() {
/* 422 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 432 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 442 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 452 */     return this.numerator / this.denominator;
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
/*     */   public Fraction reduce() {
/* 468 */     if (this.numerator == 0) {
/* 469 */       return equals(ZERO) ? this : ZERO;
/*     */     }
/* 471 */     int i = greatestCommonDivisor(Math.abs(this.numerator), this.denominator);
/* 472 */     if (i == 1) {
/* 473 */       return this;
/*     */     }
/* 475 */     return getFraction(this.numerator / i, this.denominator / i);
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
/*     */   public Fraction invert() {
/* 488 */     if (this.numerator == 0) {
/* 489 */       throw new ArithmeticException("Unable to invert zero.");
/*     */     }
/* 491 */     if (this.numerator == Integer.MIN_VALUE) {
/* 492 */       throw new ArithmeticException("overflow: can't negate numerator");
/*     */     }
/* 494 */     if (this.numerator < 0) {
/* 495 */       return new Fraction(-this.denominator, -this.numerator);
/*     */     }
/* 497 */     return new Fraction(this.denominator, this.numerator);
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
/*     */   public Fraction negate() {
/* 510 */     if (this.numerator == Integer.MIN_VALUE) {
/* 511 */       throw new ArithmeticException("overflow: too large to negate");
/*     */     }
/* 513 */     return new Fraction(-this.numerator, this.denominator);
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
/*     */   public Fraction abs() {
/* 526 */     if (this.numerator >= 0) {
/* 527 */       return this;
/*     */     }
/* 529 */     return negate();
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
/*     */   public Fraction pow(int paramInt) {
/* 545 */     if (paramInt == 1)
/* 546 */       return this; 
/* 547 */     if (paramInt == 0)
/* 548 */       return ONE; 
/* 549 */     if (paramInt < 0) {
/* 550 */       if (paramInt == Integer.MIN_VALUE) {
/* 551 */         return invert().pow(2).pow(-(paramInt / 2));
/*     */       }
/* 553 */       return invert().pow(-paramInt);
/*     */     } 
/* 555 */     Fraction fraction = multiplyBy(this);
/* 556 */     if (paramInt % 2 == 0) {
/* 557 */       return fraction.pow(paramInt / 2);
/*     */     }
/* 559 */     return fraction.pow(paramInt / 2).multiplyBy(this);
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
/*     */   private static int greatestCommonDivisor(int paramInt1, int paramInt2) {
/* 576 */     if (Math.abs(paramInt1) <= 1 || Math.abs(paramInt2) <= 1) {
/* 577 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 583 */     if (paramInt1 > 0) paramInt1 = -paramInt1; 
/* 584 */     if (paramInt2 > 0) paramInt2 = -paramInt2;
/*     */     
/* 586 */     byte b = 0;
/* 587 */     while ((paramInt1 & 0x1) == 0 && (paramInt2 & 0x1) == 0 && b < 31) {
/* 588 */       paramInt1 /= 2; paramInt2 /= 2; b++;
/*     */     } 
/* 590 */     if (b == 31) {
/* 591 */       throw new ArithmeticException("overflow: gcd is 2^31");
/*     */     }
/*     */ 
/*     */     
/* 595 */     int i = ((paramInt1 & 0x1) == 1) ? paramInt2 : -(paramInt1 / 2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 601 */       while ((i & 0x1) == 0) {
/* 602 */         i /= 2;
/*     */       }
/*     */       
/* 605 */       if (i > 0) {
/* 606 */         paramInt1 = -i;
/*     */       } else {
/* 608 */         paramInt2 = i;
/*     */       } 
/*     */       
/* 611 */       i = (paramInt2 - paramInt1) / 2;
/*     */ 
/*     */       
/* 614 */       if (i == 0) {
/* 615 */         return -paramInt1 * (1 << b);
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
/*     */   private static int mulAndCheck(int paramInt1, int paramInt2) {
/* 631 */     long l = paramInt1 * paramInt2;
/* 632 */     if (l < -2147483648L || l > 2147483647L)
/*     */     {
/* 634 */       throw new ArithmeticException("overflow: mul");
/*     */     }
/* 636 */     return (int)l;
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
/*     */   private static int mulPosAndCheck(int paramInt1, int paramInt2) {
/* 650 */     long l = paramInt1 * paramInt2;
/* 651 */     if (l > 2147483647L) {
/* 652 */       throw new ArithmeticException("overflow: mulPos");
/*     */     }
/* 654 */     return (int)l;
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
/*     */   private static int addAndCheck(int paramInt1, int paramInt2) {
/* 667 */     long l = paramInt1 + paramInt2;
/* 668 */     if (l < -2147483648L || l > 2147483647L)
/*     */     {
/* 670 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 672 */     return (int)l;
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
/*     */   private static int subAndCheck(int paramInt1, int paramInt2) {
/* 685 */     long l = paramInt1 - paramInt2;
/* 686 */     if (l < -2147483648L || l > 2147483647L)
/*     */     {
/* 688 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 690 */     return (int)l;
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
/*     */   public Fraction add(Fraction paramFraction) {
/* 704 */     return addSub(paramFraction, true);
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
/*     */   public Fraction subtract(Fraction paramFraction) {
/* 718 */     return addSub(paramFraction, false);
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
/*     */   private Fraction addSub(Fraction paramFraction, boolean paramBoolean) {
/* 732 */     if (paramFraction == null) {
/* 733 */       throw new IllegalArgumentException("The fraction must not be null");
/*     */     }
/*     */     
/* 736 */     if (this.numerator == 0) {
/* 737 */       return paramBoolean ? paramFraction : paramFraction.negate();
/*     */     }
/* 739 */     if (paramFraction.numerator == 0) {
/* 740 */       return this;
/*     */     }
/*     */ 
/*     */     
/* 744 */     int i = greatestCommonDivisor(this.denominator, paramFraction.denominator);
/* 745 */     if (i == 1) {
/*     */       
/* 747 */       int m = mulAndCheck(this.numerator, paramFraction.denominator);
/* 748 */       int n = mulAndCheck(paramFraction.numerator, this.denominator);
/* 749 */       return new Fraction(paramBoolean ? addAndCheck(m, n) : subAndCheck(m, n), mulPosAndCheck(this.denominator, paramFraction.denominator));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 756 */     BigInteger bigInteger1 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf((paramFraction.denominator / i)));
/*     */     
/* 758 */     BigInteger bigInteger2 = BigInteger.valueOf(paramFraction.numerator).multiply(BigInteger.valueOf((this.denominator / i)));
/*     */     
/* 760 */     BigInteger bigInteger3 = paramBoolean ? bigInteger1.add(bigInteger2) : bigInteger1.subtract(bigInteger2);
/*     */ 
/*     */     
/* 763 */     int j = bigInteger3.mod(BigInteger.valueOf(i)).intValue();
/* 764 */     int k = (j == 0) ? i : greatestCommonDivisor(j, i);
/*     */ 
/*     */     
/* 767 */     BigInteger bigInteger4 = bigInteger3.divide(BigInteger.valueOf(k));
/* 768 */     if (bigInteger4.bitLength() > 31) {
/* 769 */       throw new ArithmeticException("overflow: numerator too large after multiply");
/*     */     }
/*     */     
/* 772 */     return new Fraction(bigInteger4.intValue(), mulPosAndCheck(this.denominator / i, paramFraction.denominator / k));
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
/*     */   public Fraction multiplyBy(Fraction paramFraction) {
/* 788 */     if (paramFraction == null) {
/* 789 */       throw new IllegalArgumentException("The fraction must not be null");
/*     */     }
/* 791 */     if (this.numerator == 0 || paramFraction.numerator == 0) {
/* 792 */       return ZERO;
/*     */     }
/*     */ 
/*     */     
/* 796 */     int i = greatestCommonDivisor(this.numerator, paramFraction.denominator);
/* 797 */     int j = greatestCommonDivisor(paramFraction.numerator, this.denominator);
/* 798 */     return getReducedFraction(mulAndCheck(this.numerator / i, paramFraction.numerator / j), mulPosAndCheck(this.denominator / j, paramFraction.denominator / i));
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
/*     */   public Fraction divideBy(Fraction paramFraction) {
/* 814 */     if (paramFraction == null) {
/* 815 */       throw new IllegalArgumentException("The fraction must not be null");
/*     */     }
/* 817 */     if (paramFraction.numerator == 0) {
/* 818 */       throw new ArithmeticException("The fraction to divide by must not be zero");
/*     */     }
/* 820 */     return multiplyBy(paramFraction.invert());
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
/*     */   public boolean equals(Object paramObject) {
/* 835 */     if (paramObject == this) {
/* 836 */       return true;
/*     */     }
/* 838 */     if (!(paramObject instanceof Fraction)) {
/* 839 */       return false;
/*     */     }
/* 841 */     Fraction fraction = (Fraction)paramObject;
/* 842 */     return (getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 852 */     if (this.hashCode == 0)
/*     */     {
/* 854 */       this.hashCode = 37 * (629 + getNumerator()) + getDenominator();
/*     */     }
/* 856 */     return this.hashCode;
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
/*     */   public int compareTo(Object paramObject) {
/* 872 */     Fraction fraction = (Fraction)paramObject;
/* 873 */     if (this == fraction) {
/* 874 */       return 0;
/*     */     }
/* 876 */     if (this.numerator == fraction.numerator && this.denominator == fraction.denominator) {
/* 877 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 881 */     long l1 = this.numerator * fraction.denominator;
/* 882 */     long l2 = fraction.numerator * this.denominator;
/* 883 */     if (l1 == l2)
/* 884 */       return 0; 
/* 885 */     if (l1 < l2) {
/* 886 */       return -1;
/*     */     }
/* 888 */     return 1;
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
/*     */   public String toString() {
/* 900 */     if (this.toString == null) {
/* 901 */       this.toString = (new StrBuilder(32)).append(getNumerator()).append('/').append(getDenominator()).toString();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 906 */     return this.toString;
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
/*     */   public String toProperString() {
/* 919 */     if (this.toProperString == null) {
/* 920 */       if (this.numerator == 0) {
/* 921 */         this.toProperString = "0";
/* 922 */       } else if (this.numerator == this.denominator) {
/* 923 */         this.toProperString = "1";
/* 924 */       } else if (this.numerator == -1 * this.denominator) {
/* 925 */         this.toProperString = "-1";
/* 926 */       } else if (((this.numerator > 0) ? -this.numerator : this.numerator) < -this.denominator) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 931 */         int i = getProperNumerator();
/* 932 */         if (i == 0) {
/* 933 */           this.toProperString = Integer.toString(getProperWhole());
/*     */         } else {
/* 935 */           this.toProperString = (new StrBuilder(32)).append(getProperWhole()).append(' ').append(i).append('/').append(getDenominator()).toString();
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 941 */         this.toProperString = (new StrBuilder(32)).append(getNumerator()).append('/').append(getDenominator()).toString();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 946 */     return this.toProperString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/math/Fraction.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */