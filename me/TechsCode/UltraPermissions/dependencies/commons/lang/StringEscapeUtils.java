/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.Locale;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.exception.NestableRuntimeException;
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
/*     */ public class StringEscapeUtils
/*     */ {
/*     */   private static final char CSV_DELIMITER = ',';
/*     */   private static final char CSV_QUOTE = '"';
/*  49 */   private static final String CSV_QUOTE_STR = String.valueOf('"');
/*  50 */   private static final char[] CSV_SEARCH_CHARS = new char[] { ',', '"', '\r', '\n' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeJava(String paramString) {
/*  90 */     return escapeJavaStyleString(paramString, false, false);
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
/*     */   public static void escapeJava(Writer paramWriter, String paramString) {
/* 106 */     escapeJavaStyleString(paramWriter, paramString, false, false);
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
/*     */   public static String escapeJavaScript(String paramString) {
/* 131 */     return escapeJavaStyleString(paramString, true, true);
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
/*     */   public static void escapeJavaScript(Writer paramWriter, String paramString) {
/* 147 */     escapeJavaStyleString(paramWriter, paramString, true, true);
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
/*     */   private static String escapeJavaStyleString(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 159 */     if (paramString == null) {
/* 160 */       return null;
/*     */     }
/*     */     try {
/* 163 */       StringWriter stringWriter = new StringWriter(paramString.length() * 2);
/* 164 */       escapeJavaStyleString(stringWriter, paramString, paramBoolean1, paramBoolean2);
/* 165 */       return stringWriter.toString();
/* 166 */     } catch (IOException iOException) {
/*     */       
/* 168 */       throw new UnhandledException(iOException);
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
/*     */   private static void escapeJavaStyleString(Writer paramWriter, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 183 */     if (paramWriter == null) {
/* 184 */       throw new IllegalArgumentException("The Writer must not be null");
/*     */     }
/* 186 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/* 190 */     int i = paramString.length();
/* 191 */     for (byte b = 0; b < i; b++) {
/* 192 */       char c = paramString.charAt(b);
/*     */ 
/*     */       
/* 195 */       if (c > '࿿') {
/* 196 */         paramWriter.write("\\u" + hex(c));
/* 197 */       } else if (c > 'ÿ') {
/* 198 */         paramWriter.write("\\u0" + hex(c));
/* 199 */       } else if (c > '') {
/* 200 */         paramWriter.write("\\u00" + hex(c));
/* 201 */       } else if (c < ' ') {
/* 202 */         switch (c) {
/*     */           case '\b':
/* 204 */             paramWriter.write(92);
/* 205 */             paramWriter.write(98);
/*     */             break;
/*     */           case '\n':
/* 208 */             paramWriter.write(92);
/* 209 */             paramWriter.write(110);
/*     */             break;
/*     */           case '\t':
/* 212 */             paramWriter.write(92);
/* 213 */             paramWriter.write(116);
/*     */             break;
/*     */           case '\f':
/* 216 */             paramWriter.write(92);
/* 217 */             paramWriter.write(102);
/*     */             break;
/*     */           case '\r':
/* 220 */             paramWriter.write(92);
/* 221 */             paramWriter.write(114);
/*     */             break;
/*     */           default:
/* 224 */             if (c > '\017') {
/* 225 */               paramWriter.write("\\u00" + hex(c)); break;
/*     */             } 
/* 227 */             paramWriter.write("\\u000" + hex(c));
/*     */             break;
/*     */         } 
/*     */       
/*     */       } else {
/* 232 */         switch (c) {
/*     */           case '\'':
/* 234 */             if (paramBoolean1) {
/* 235 */               paramWriter.write(92);
/*     */             }
/* 237 */             paramWriter.write(39);
/*     */             break;
/*     */           case '"':
/* 240 */             paramWriter.write(92);
/* 241 */             paramWriter.write(34);
/*     */             break;
/*     */           case '\\':
/* 244 */             paramWriter.write(92);
/* 245 */             paramWriter.write(92);
/*     */             break;
/*     */           case '/':
/* 248 */             if (paramBoolean2) {
/* 249 */               paramWriter.write(92);
/*     */             }
/* 251 */             paramWriter.write(47);
/*     */             break;
/*     */           default:
/* 254 */             paramWriter.write(c);
/*     */             break;
/*     */         } 
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
/*     */   private static String hex(char paramChar) {
/* 269 */     return Integer.toHexString(paramChar).toUpperCase(Locale.ENGLISH);
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
/*     */   public static String unescapeJava(String paramString) {
/* 282 */     if (paramString == null) {
/* 283 */       return null;
/*     */     }
/*     */     try {
/* 286 */       StringWriter stringWriter = new StringWriter(paramString.length());
/* 287 */       unescapeJava(stringWriter, paramString);
/* 288 */       return stringWriter.toString();
/* 289 */     } catch (IOException iOException) {
/*     */       
/* 291 */       throw new UnhandledException(iOException);
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
/*     */   public static void unescapeJava(Writer paramWriter, String paramString) {
/* 311 */     if (paramWriter == null) {
/* 312 */       throw new IllegalArgumentException("The Writer must not be null");
/*     */     }
/* 314 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 317 */     int i = paramString.length();
/* 318 */     StrBuilder strBuilder = new StrBuilder(4);
/* 319 */     boolean bool1 = false;
/* 320 */     boolean bool2 = false;
/* 321 */     for (byte b = 0; b < i; b++) {
/* 322 */       char c = paramString.charAt(b);
/* 323 */       if (bool2) {
/*     */ 
/*     */         
/* 326 */         strBuilder.append(c);
/* 327 */         if (strBuilder.length() == 4) {
/*     */           
/*     */           try {
/*     */             
/* 331 */             int j = Integer.parseInt(strBuilder.toString(), 16);
/* 332 */             paramWriter.write((char)j);
/* 333 */             strBuilder.setLength(0);
/* 334 */             bool2 = false;
/* 335 */             bool1 = false;
/* 336 */           } catch (NumberFormatException numberFormatException) {
/* 337 */             throw new NestableRuntimeException("Unable to parse unicode value: " + strBuilder, numberFormatException);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 342 */       else if (bool1) {
/*     */         
/* 344 */         bool1 = false;
/* 345 */         switch (c) {
/*     */           case '\\':
/* 347 */             paramWriter.write(92);
/*     */             break;
/*     */           case '\'':
/* 350 */             paramWriter.write(39);
/*     */             break;
/*     */           case '"':
/* 353 */             paramWriter.write(34);
/*     */             break;
/*     */           case 'r':
/* 356 */             paramWriter.write(13);
/*     */             break;
/*     */           case 'f':
/* 359 */             paramWriter.write(12);
/*     */             break;
/*     */           case 't':
/* 362 */             paramWriter.write(9);
/*     */             break;
/*     */           case 'n':
/* 365 */             paramWriter.write(10);
/*     */             break;
/*     */           case 'b':
/* 368 */             paramWriter.write(8);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 'u':
/* 373 */             bool2 = true;
/*     */             break;
/*     */           
/*     */           default:
/* 377 */             paramWriter.write(c);
/*     */             break;
/*     */         } 
/*     */       
/* 381 */       } else if (c == '\\') {
/* 382 */         bool1 = true;
/*     */       } else {
/*     */         
/* 385 */         paramWriter.write(c);
/*     */       } 
/* 387 */     }  if (bool1)
/*     */     {
/*     */       
/* 390 */       paramWriter.write(92);
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
/*     */   public static String unescapeJavaScript(String paramString) {
/* 406 */     return unescapeJava(paramString);
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
/*     */   public static void unescapeJavaScript(Writer paramWriter, String paramString) {
/* 426 */     unescapeJava(paramWriter, paramString);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeHtml(String paramString) {
/* 458 */     if (paramString == null) {
/* 459 */       return null;
/*     */     }
/*     */     try {
/* 462 */       StringWriter stringWriter = new StringWriter((int)(paramString.length() * 1.5D));
/* 463 */       escapeHtml(stringWriter, paramString);
/* 464 */       return stringWriter.toString();
/* 465 */     } catch (IOException iOException) {
/*     */       
/* 467 */       throw new UnhandledException(iOException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void escapeHtml(Writer paramWriter, String paramString) {
/* 501 */     if (paramWriter == null) {
/* 502 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 504 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 507 */     Entities.HTML40.escape(paramWriter, paramString);
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
/*     */   public static String unescapeHtml(String paramString) {
/* 528 */     if (paramString == null) {
/* 529 */       return null;
/*     */     }
/*     */     try {
/* 532 */       StringWriter stringWriter = new StringWriter((int)(paramString.length() * 1.5D));
/* 533 */       unescapeHtml(stringWriter, paramString);
/* 534 */       return stringWriter.toString();
/* 535 */     } catch (IOException iOException) {
/*     */       
/* 537 */       throw new UnhandledException(iOException);
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
/*     */   public static void unescapeHtml(Writer paramWriter, String paramString) {
/* 560 */     if (paramWriter == null) {
/* 561 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 563 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 566 */     Entities.HTML40.unescape(paramWriter, paramString);
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
/*     */   public static void escapeXml(Writer paramWriter, String paramString) {
/* 590 */     if (paramWriter == null) {
/* 591 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 593 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 596 */     Entities.XML.escape(paramWriter, paramString);
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
/*     */   public static String escapeXml(String paramString) {
/* 617 */     if (paramString == null) {
/* 618 */       return null;
/*     */     }
/* 620 */     return Entities.XML.escape(paramString);
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
/*     */   public static void unescapeXml(Writer paramWriter, String paramString) {
/* 642 */     if (paramWriter == null) {
/* 643 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 645 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 648 */     Entities.XML.unescape(paramWriter, paramString);
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
/*     */   public static String unescapeXml(String paramString) {
/* 667 */     if (paramString == null) {
/* 668 */       return null;
/*     */     }
/* 670 */     return Entities.XML.unescape(paramString);
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
/*     */   public static String escapeSql(String paramString) {
/* 693 */     if (paramString == null) {
/* 694 */       return null;
/*     */     }
/* 696 */     return StringUtils.replace(paramString, "'", "''");
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
/*     */   public static String escapeCsv(String paramString) {
/* 724 */     if (StringUtils.containsNone(paramString, CSV_SEARCH_CHARS)) {
/* 725 */       return paramString;
/*     */     }
/*     */     try {
/* 728 */       StringWriter stringWriter = new StringWriter();
/* 729 */       escapeCsv(stringWriter, paramString);
/* 730 */       return stringWriter.toString();
/* 731 */     } catch (IOException iOException) {
/*     */       
/* 733 */       throw new UnhandledException(iOException);
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
/*     */   
/*     */   public static void escapeCsv(Writer paramWriter, String paramString) {
/* 761 */     if (StringUtils.containsNone(paramString, CSV_SEARCH_CHARS)) {
/* 762 */       if (paramString != null) {
/* 763 */         paramWriter.write(paramString);
/*     */       }
/*     */       return;
/*     */     } 
/* 767 */     paramWriter.write(34);
/* 768 */     for (byte b = 0; b < paramString.length(); b++) {
/* 769 */       char c = paramString.charAt(b);
/* 770 */       if (c == '"') {
/* 771 */         paramWriter.write(34);
/*     */       }
/* 773 */       paramWriter.write(c);
/*     */     } 
/* 775 */     paramWriter.write(34);
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
/*     */   public static String unescapeCsv(String paramString) {
/* 801 */     if (paramString == null) {
/* 802 */       return null;
/*     */     }
/*     */     try {
/* 805 */       StringWriter stringWriter = new StringWriter();
/* 806 */       unescapeCsv(stringWriter, paramString);
/* 807 */       return stringWriter.toString();
/* 808 */     } catch (IOException iOException) {
/*     */       
/* 810 */       throw new UnhandledException(iOException);
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
/*     */   
/*     */   public static void unescapeCsv(Writer paramWriter, String paramString) {
/* 838 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 841 */     if (paramString.length() < 2) {
/* 842 */       paramWriter.write(paramString);
/*     */       return;
/*     */     } 
/* 845 */     if (paramString.charAt(0) != '"' || paramString.charAt(paramString.length() - 1) != '"') {
/* 846 */       paramWriter.write(paramString);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 851 */     String str = paramString.substring(1, paramString.length() - 1);
/*     */     
/* 853 */     if (StringUtils.containsAny(str, CSV_SEARCH_CHARS))
/*     */     {
/* 855 */       paramString = StringUtils.replace(str, CSV_QUOTE_STR + CSV_QUOTE_STR, CSV_QUOTE_STR);
/*     */     }
/*     */     
/* 858 */     paramWriter.write(paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/StringEscapeUtils.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */