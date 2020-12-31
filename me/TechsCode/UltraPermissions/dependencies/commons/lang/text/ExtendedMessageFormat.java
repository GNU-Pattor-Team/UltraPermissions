/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.text;
/*     */ 
/*     */ import java.text.Format;
/*     */ import java.text.MessageFormat;
/*     */ import java.text.ParsePosition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ObjectUtils;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExtendedMessageFormat
/*     */   extends MessageFormat
/*     */ {
/*     */   private static final long serialVersionUID = -2362048321261811743L;
/*     */   private static final int HASH_SEED = 31;
/*     */   private static final String DUMMY_PATTERN = "";
/*     */   private static final String ESCAPED_QUOTE = "''";
/*     */   private static final char START_FMT = ',';
/*     */   private static final char END_FE = '}';
/*     */   private static final char START_FE = '{';
/*     */   private static final char QUOTE = '\'';
/*     */   private String toPattern;
/*     */   private final Map registry;
/*     */   
/*     */   public ExtendedMessageFormat(String paramString) {
/*  92 */     this(paramString, Locale.getDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendedMessageFormat(String paramString, Locale paramLocale) {
/* 103 */     this(paramString, paramLocale, (Map)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendedMessageFormat(String paramString, Map paramMap) {
/* 114 */     this(paramString, Locale.getDefault(), paramMap);
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
/*     */   public ExtendedMessageFormat(String paramString, Locale paramLocale, Map paramMap) {
/* 126 */     super("");
/* 127 */     setLocale(paramLocale);
/* 128 */     this.registry = paramMap;
/* 129 */     applyPattern(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toPattern() {
/* 136 */     return this.toPattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void applyPattern(String paramString) {
/* 145 */     if (this.registry == null) {
/* 146 */       super.applyPattern(paramString);
/* 147 */       this.toPattern = super.toPattern();
/*     */       return;
/*     */     } 
/* 150 */     ArrayList arrayList = new ArrayList();
/* 151 */     ArrayList arrayList1 = new ArrayList();
/* 152 */     StrBuilder strBuilder = new StrBuilder(paramString.length());
/*     */     
/* 154 */     ParsePosition parsePosition = new ParsePosition(0);
/* 155 */     char[] arrayOfChar = paramString.toCharArray();
/* 156 */     byte b = 0;
/* 157 */     while (parsePosition.getIndex() < paramString.length()) {
/* 158 */       int i, j; Format format; String str; switch (arrayOfChar[parsePosition.getIndex()]) {
/*     */         case '\'':
/* 160 */           appendQuotedString(paramString, parsePosition, strBuilder, true);
/*     */           continue;
/*     */         case '{':
/* 163 */           b++;
/* 164 */           seekNonWs(paramString, parsePosition);
/* 165 */           i = parsePosition.getIndex();
/* 166 */           j = readArgumentIndex(paramString, next(parsePosition));
/* 167 */           strBuilder.append('{').append(j);
/* 168 */           seekNonWs(paramString, parsePosition);
/* 169 */           format = null;
/* 170 */           str = null;
/* 171 */           if (arrayOfChar[parsePosition.getIndex()] == ',') {
/* 172 */             str = parseFormatDescription(paramString, next(parsePosition));
/*     */             
/* 174 */             format = getFormat(str);
/* 175 */             if (format == null) {
/* 176 */               strBuilder.append(',').append(str);
/*     */             }
/*     */           } 
/* 179 */           arrayList.add(format);
/* 180 */           arrayList1.add((format == null) ? null : str);
/* 181 */           Validate.isTrue((arrayList.size() == b));
/* 182 */           Validate.isTrue((arrayList1.size() == b));
/* 183 */           if (arrayOfChar[parsePosition.getIndex()] != '}') {
/* 184 */             throw new IllegalArgumentException("Unreadable format element at position " + i);
/*     */           }
/*     */           break;
/*     */       } 
/*     */       
/* 189 */       strBuilder.append(arrayOfChar[parsePosition.getIndex()]);
/* 190 */       next(parsePosition);
/*     */     } 
/*     */     
/* 193 */     super.applyPattern(strBuilder.toString());
/* 194 */     this.toPattern = insertFormats(super.toPattern(), arrayList1);
/* 195 */     if (containsElements(arrayList)) {
/* 196 */       Format[] arrayOfFormat = getFormats();
/*     */ 
/*     */       
/* 199 */       byte b1 = 0;
/* 200 */       for (Format format : arrayList) {
/*     */         
/* 202 */         if (format != null)
/* 203 */           arrayOfFormat[b1] = format; 
/*     */         b1++;
/*     */       } 
/* 206 */       super.setFormats(arrayOfFormat);
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
/*     */   public void setFormat(int paramInt, Format paramFormat) {
/* 218 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatByArgumentIndex(int paramInt, Format paramFormat) {
/* 229 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormats(Format[] paramArrayOfFormat) {
/* 239 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatsByArgumentIndex(Format[] paramArrayOfFormat) {
/* 249 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 260 */     if (paramObject == this) {
/* 261 */       return true;
/*     */     }
/* 263 */     if (paramObject == null) {
/* 264 */       return false;
/*     */     }
/* 266 */     if (!super.equals(paramObject)) {
/* 267 */       return false;
/*     */     }
/* 269 */     if (ObjectUtils.notEqual(getClass(), paramObject.getClass())) {
/* 270 */       return false;
/*     */     }
/* 272 */     ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat)paramObject;
/* 273 */     if (ObjectUtils.notEqual(this.toPattern, extendedMessageFormat.toPattern)) {
/* 274 */       return false;
/*     */     }
/* 276 */     if (ObjectUtils.notEqual(this.registry, extendedMessageFormat.registry)) {
/* 277 */       return false;
/*     */     }
/* 279 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 289 */     int i = super.hashCode();
/* 290 */     i = 31 * i + ObjectUtils.hashCode(this.registry);
/* 291 */     i = 31 * i + ObjectUtils.hashCode(this.toPattern);
/* 292 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Format getFormat(String paramString) {
/* 302 */     if (this.registry != null) {
/* 303 */       String str1 = paramString;
/* 304 */       String str2 = null;
/* 305 */       int i = paramString.indexOf(',');
/* 306 */       if (i > 0) {
/* 307 */         str1 = paramString.substring(0, i).trim();
/* 308 */         str2 = paramString.substring(i + 1).trim();
/*     */       } 
/* 310 */       FormatFactory formatFactory = (FormatFactory)this.registry.get(str1);
/* 311 */       if (formatFactory != null) {
/* 312 */         return formatFactory.getFormat(str1, str2, getLocale());
/*     */       }
/*     */     } 
/* 315 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readArgumentIndex(String paramString, ParsePosition paramParsePosition) {
/* 326 */     int i = paramParsePosition.getIndex();
/* 327 */     seekNonWs(paramString, paramParsePosition);
/* 328 */     StrBuilder strBuilder = new StrBuilder();
/* 329 */     boolean bool = false;
/* 330 */     for (; !bool && paramParsePosition.getIndex() < paramString.length(); next(paramParsePosition)) {
/* 331 */       char c = paramString.charAt(paramParsePosition.getIndex());
/* 332 */       if (Character.isWhitespace(c)) {
/* 333 */         seekNonWs(paramString, paramParsePosition);
/* 334 */         c = paramString.charAt(paramParsePosition.getIndex());
/* 335 */         if (c != ',' && c != '}') {
/* 336 */           bool = true;
/*     */           continue;
/*     */         } 
/*     */       } 
/* 340 */       if ((c == ',' || c == '}') && strBuilder.length() > 0) {
/*     */         try {
/* 342 */           return Integer.parseInt(strBuilder.toString());
/* 343 */         } catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 348 */       bool = !Character.isDigit(c) ? true : false;
/* 349 */       strBuilder.append(c); continue;
/*     */     } 
/* 351 */     if (bool) {
/* 352 */       throw new IllegalArgumentException("Invalid format argument index at position " + i + ": " + paramString.substring(i, paramParsePosition.getIndex()));
/*     */     }
/*     */ 
/*     */     
/* 356 */     throw new IllegalArgumentException("Unterminated format element at position " + i);
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
/*     */   private String parseFormatDescription(String paramString, ParsePosition paramParsePosition) {
/* 368 */     int i = paramParsePosition.getIndex();
/* 369 */     seekNonWs(paramString, paramParsePosition);
/* 370 */     int j = paramParsePosition.getIndex();
/* 371 */     byte b = 1;
/* 372 */     for (; paramParsePosition.getIndex() < paramString.length(); next(paramParsePosition)) {
/* 373 */       switch (paramString.charAt(paramParsePosition.getIndex())) {
/*     */         case '{':
/* 375 */           b++;
/*     */           break;
/*     */         case '}':
/* 378 */           b--;
/* 379 */           if (b == 0) {
/* 380 */             return paramString.substring(j, paramParsePosition.getIndex());
/*     */           }
/*     */           break;
/*     */         case '\'':
/* 384 */           getQuotedString(paramString, paramParsePosition, false);
/*     */           break;
/*     */       } 
/*     */     } 
/* 388 */     throw new IllegalArgumentException("Unterminated format element at position " + i);
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
/*     */   private String insertFormats(String paramString, ArrayList paramArrayList) {
/* 400 */     if (!containsElements(paramArrayList)) {
/* 401 */       return paramString;
/*     */     }
/* 403 */     StrBuilder strBuilder = new StrBuilder(paramString.length() * 2);
/* 404 */     ParsePosition parsePosition = new ParsePosition(0);
/* 405 */     byte b = -1;
/* 406 */     byte b1 = 0;
/* 407 */     while (parsePosition.getIndex() < paramString.length()) {
/* 408 */       char c = paramString.charAt(parsePosition.getIndex());
/* 409 */       switch (c) {
/*     */         case '\'':
/* 411 */           appendQuotedString(paramString, parsePosition, strBuilder, false);
/*     */           continue;
/*     */         case '{':
/* 414 */           b1++;
/* 415 */           if (b1 == 1) {
/* 416 */             b++;
/* 417 */             strBuilder.append('{').append(readArgumentIndex(paramString, next(parsePosition)));
/*     */             
/* 419 */             String str = paramArrayList.get(b);
/* 420 */             if (str != null) {
/* 421 */               strBuilder.append(',').append(str);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         case '}':
/* 426 */           b1--;
/*     */           break;
/*     */       } 
/* 429 */       strBuilder.append(c);
/* 430 */       next(parsePosition);
/*     */     } 
/*     */     
/* 433 */     return strBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void seekNonWs(String paramString, ParsePosition paramParsePosition) {
/* 443 */     int i = 0;
/* 444 */     char[] arrayOfChar = paramString.toCharArray();
/*     */     do {
/* 446 */       i = StrMatcher.splitMatcher().isMatch(arrayOfChar, paramParsePosition.getIndex());
/* 447 */       paramParsePosition.setIndex(paramParsePosition.getIndex() + i);
/* 448 */     } while (i > 0 && paramParsePosition.getIndex() < paramString.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ParsePosition next(ParsePosition paramParsePosition) {
/* 458 */     paramParsePosition.setIndex(paramParsePosition.getIndex() + 1);
/* 459 */     return paramParsePosition;
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
/*     */   private StrBuilder appendQuotedString(String paramString, ParsePosition paramParsePosition, StrBuilder paramStrBuilder, boolean paramBoolean) {
/* 474 */     int i = paramParsePosition.getIndex();
/* 475 */     char[] arrayOfChar = paramString.toCharArray();
/* 476 */     if (paramBoolean && arrayOfChar[i] == '\'') {
/* 477 */       next(paramParsePosition);
/* 478 */       return (paramStrBuilder == null) ? null : paramStrBuilder.append('\'');
/*     */     } 
/* 480 */     int j = i;
/* 481 */     for (int k = paramParsePosition.getIndex(); k < paramString.length(); k++) {
/* 482 */       if (paramBoolean && paramString.substring(k).startsWith("''")) {
/* 483 */         paramStrBuilder.append(arrayOfChar, j, paramParsePosition.getIndex() - j).append('\'');
/*     */         
/* 485 */         paramParsePosition.setIndex(k + "''".length());
/* 486 */         j = paramParsePosition.getIndex();
/*     */       } else {
/*     */         
/* 489 */         switch (arrayOfChar[paramParsePosition.getIndex()]) {
/*     */           case '\'':
/* 491 */             next(paramParsePosition);
/* 492 */             return (paramStrBuilder == null) ? null : paramStrBuilder.append(arrayOfChar, j, paramParsePosition.getIndex() - j);
/*     */         } 
/*     */         
/* 495 */         next(paramParsePosition);
/*     */       } 
/*     */     } 
/* 498 */     throw new IllegalArgumentException("Unterminated quoted string at position " + i);
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
/*     */   private void getQuotedString(String paramString, ParsePosition paramParsePosition, boolean paramBoolean) {
/* 511 */     appendQuotedString(paramString, paramParsePosition, (StrBuilder)null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean containsElements(Collection paramCollection) {
/* 520 */     if (paramCollection == null || paramCollection.size() == 0) {
/* 521 */       return false;
/*     */     }
/* 523 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext();) {
/* 524 */       if (iterator.next() != null) {
/* 525 */         return true;
/*     */       }
/*     */     } 
/* 528 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/text/ExtendedMessageFormat.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */