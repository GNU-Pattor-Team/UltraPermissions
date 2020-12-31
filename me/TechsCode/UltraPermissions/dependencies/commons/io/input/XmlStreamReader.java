/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class XmlStreamReader
/*     */   extends Reader
/*     */ {
/*     */   private static final int BUFFER_SIZE = 4096;
/*     */   private static final String UTF_8 = "UTF-8";
/*     */   private static final String US_ASCII = "US-ASCII";
/*     */   private static final String UTF_16BE = "UTF-16BE";
/*     */   private static final String UTF_16LE = "UTF-16LE";
/*     */   private static final String UTF_32BE = "UTF-32BE";
/*     */   private static final String UTF_32LE = "UTF-32LE";
/*     */   private static final String UTF_16 = "UTF-16";
/*     */   private static final String UTF_32 = "UTF-32";
/*     */   private static final String EBCDIC = "CP1047";
/*  86 */   private static final ByteOrderMark[] BOMS = new ByteOrderMark[] { ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   private static final ByteOrderMark[] XML_GUESS_BYTES = new ByteOrderMark[] { new ByteOrderMark("UTF-8", new int[] { 60, 63, 120, 109 }), new ByteOrderMark("UTF-16BE", new int[] { 0, 60, 0, 63 }), new ByteOrderMark("UTF-16LE", new int[] { 60, 0, 63, 0 }), new ByteOrderMark("UTF-32BE", new int[] { 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109 }), new ByteOrderMark("UTF-32LE", new int[] { 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0 }), new ByteOrderMark("CP1047", new int[] { 76, 111, 167, 148 }) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Reader reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String encoding;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String defaultEncoding;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultEncoding() {
/* 121 */     return this.defaultEncoding;
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
/*     */   public XmlStreamReader(File paramFile) {
/* 137 */     this(new FileInputStream(paramFile));
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
/*     */   public XmlStreamReader(InputStream paramInputStream) {
/* 152 */     this(paramInputStream, true);
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
/*     */   public XmlStreamReader(InputStream paramInputStream, boolean paramBoolean) {
/* 183 */     this(paramInputStream, paramBoolean, (String)null);
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
/*     */   public XmlStreamReader(InputStream paramInputStream, boolean paramBoolean, String paramString) {
/* 216 */     this.defaultEncoding = paramString;
/* 217 */     BOMInputStream bOMInputStream1 = new BOMInputStream(new BufferedInputStream(paramInputStream, 4096), false, BOMS);
/* 218 */     BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream1, true, XML_GUESS_BYTES);
/* 219 */     this.encoding = doRawStream(bOMInputStream1, bOMInputStream2, paramBoolean);
/* 220 */     this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
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
/*     */   public XmlStreamReader(URL paramURL) {
/* 241 */     this(paramURL.openConnection(), (String)null);
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
/*     */   public XmlStreamReader(URLConnection paramURLConnection, String paramString) {
/* 264 */     this.defaultEncoding = paramString;
/* 265 */     boolean bool = true;
/* 266 */     String str = paramURLConnection.getContentType();
/* 267 */     InputStream inputStream = paramURLConnection.getInputStream();
/* 268 */     BOMInputStream bOMInputStream1 = new BOMInputStream(new BufferedInputStream(inputStream, 4096), false, BOMS);
/* 269 */     BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream1, true, XML_GUESS_BYTES);
/* 270 */     if (paramURLConnection instanceof java.net.HttpURLConnection || str != null) {
/* 271 */       this.encoding = doHttpStream(bOMInputStream1, bOMInputStream2, str, true);
/*     */     } else {
/* 273 */       this.encoding = doRawStream(bOMInputStream1, bOMInputStream2, true);
/*     */     } 
/* 275 */     this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
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
/*     */   public XmlStreamReader(InputStream paramInputStream, String paramString) {
/* 297 */     this(paramInputStream, paramString, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamReader(InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2) {
/* 336 */     this.defaultEncoding = paramString2;
/* 337 */     BOMInputStream bOMInputStream1 = new BOMInputStream(new BufferedInputStream(paramInputStream, 4096), false, BOMS);
/* 338 */     BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream1, true, XML_GUESS_BYTES);
/* 339 */     this.encoding = doHttpStream(bOMInputStream1, bOMInputStream2, paramString1, paramBoolean);
/* 340 */     this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamReader(InputStream paramInputStream, String paramString, boolean paramBoolean) {
/* 378 */     this(paramInputStream, paramString, paramBoolean, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/* 387 */     return this.encoding;
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 400 */     return this.reader.read(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 410 */     this.reader.close();
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
/*     */   private String doRawStream(BOMInputStream paramBOMInputStream1, BOMInputStream paramBOMInputStream2, boolean paramBoolean) {
/* 425 */     String str1 = paramBOMInputStream1.getBOMCharsetName();
/* 426 */     String str2 = paramBOMInputStream2.getBOMCharsetName();
/* 427 */     String str3 = getXmlProlog(paramBOMInputStream2, str2);
/*     */     try {
/* 429 */       return calculateRawEncoding(str1, str2, str3);
/* 430 */     } catch (XmlStreamReaderException xmlStreamReaderException) {
/* 431 */       if (paramBoolean) {
/* 432 */         return doLenientDetection(null, xmlStreamReaderException);
/*     */       }
/* 434 */       throw xmlStreamReaderException;
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
/*     */   private String doHttpStream(BOMInputStream paramBOMInputStream1, BOMInputStream paramBOMInputStream2, String paramString, boolean paramBoolean) {
/* 452 */     String str1 = paramBOMInputStream1.getBOMCharsetName();
/* 453 */     String str2 = paramBOMInputStream2.getBOMCharsetName();
/* 454 */     String str3 = getXmlProlog(paramBOMInputStream2, str2);
/*     */     try {
/* 456 */       return calculateHttpEncoding(paramString, str1, str2, str3, paramBoolean);
/*     */     }
/* 458 */     catch (XmlStreamReaderException xmlStreamReaderException) {
/* 459 */       if (paramBoolean) {
/* 460 */         return doLenientDetection(paramString, xmlStreamReaderException);
/*     */       }
/* 462 */       throw xmlStreamReaderException;
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
/*     */   private String doLenientDetection(String paramString, XmlStreamReaderException paramXmlStreamReaderException) {
/* 478 */     if (paramString != null && paramString.startsWith("text/html")) {
/* 479 */       paramString = paramString.substring("text/html".length());
/* 480 */       paramString = "text/xml" + paramString;
/*     */       try {
/* 482 */         return calculateHttpEncoding(paramString, paramXmlStreamReaderException.getBomEncoding(), paramXmlStreamReaderException
/* 483 */             .getXmlGuessEncoding(), paramXmlStreamReaderException.getXmlEncoding(), true);
/* 484 */       } catch (XmlStreamReaderException xmlStreamReaderException) {
/* 485 */         paramXmlStreamReaderException = xmlStreamReaderException;
/*     */       } 
/*     */     } 
/* 488 */     String str = paramXmlStreamReaderException.getXmlEncoding();
/* 489 */     if (str == null) {
/* 490 */       str = paramXmlStreamReaderException.getContentTypeEncoding();
/*     */     }
/* 492 */     if (str == null) {
/* 493 */       str = (this.defaultEncoding == null) ? "UTF-8" : this.defaultEncoding;
/*     */     }
/* 495 */     return str;
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
/*     */   String calculateRawEncoding(String paramString1, String paramString2, String paramString3) {
/* 511 */     if (paramString1 == null) {
/* 512 */       if (paramString2 == null || paramString3 == null) {
/* 513 */         return (this.defaultEncoding == null) ? "UTF-8" : this.defaultEncoding;
/*     */       }
/* 515 */       if (paramString3.equals("UTF-16") && (paramString2
/* 516 */         .equals("UTF-16BE") || paramString2.equals("UTF-16LE"))) {
/* 517 */         return paramString2;
/*     */       }
/* 519 */       return paramString3;
/*     */     } 
/*     */ 
/*     */     
/* 523 */     if (paramString1.equals("UTF-8")) {
/* 524 */       if (paramString2 != null && !paramString2.equals("UTF-8")) {
/* 525 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 526 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 528 */       if (paramString3 != null && !paramString3.equals("UTF-8")) {
/* 529 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 530 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 532 */       return paramString1;
/*     */     } 
/*     */ 
/*     */     
/* 536 */     if (paramString1.equals("UTF-16BE") || paramString1.equals("UTF-16LE")) {
/* 537 */       if (paramString2 != null && !paramString2.equals(paramString1)) {
/* 538 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 539 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 541 */       if (paramString3 != null && !paramString3.equals("UTF-16") && !paramString3.equals(paramString1)) {
/* 542 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 543 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 545 */       return paramString1;
/*     */     } 
/*     */ 
/*     */     
/* 549 */     if (paramString1.equals("UTF-32BE") || paramString1.equals("UTF-32LE")) {
/* 550 */       if (paramString2 != null && !paramString2.equals(paramString1)) {
/* 551 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 552 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 554 */       if (paramString3 != null && !paramString3.equals("UTF-32") && !paramString3.equals(paramString1)) {
/* 555 */         String str1 = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 });
/* 556 */         throw new XmlStreamReaderException(str1, paramString1, paramString2, paramString3);
/*     */       } 
/* 558 */       return paramString1;
/*     */     } 
/*     */ 
/*     */     
/* 562 */     String str = MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM", new Object[] { paramString1, paramString2, paramString3 });
/* 563 */     throw new XmlStreamReaderException(str, paramString1, paramString2, paramString3);
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
/*     */   String calculateHttpEncoding(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
/* 584 */     if (paramBoolean && paramString4 != null) {
/* 585 */       return paramString4;
/*     */     }
/*     */ 
/*     */     
/* 589 */     String str1 = getContentTypeMime(paramString1);
/* 590 */     String str2 = getContentTypeEncoding(paramString1);
/* 591 */     boolean bool1 = isAppXml(str1);
/* 592 */     boolean bool2 = isTextXml(str1);
/*     */ 
/*     */     
/* 595 */     if (!bool1 && !bool2) {
/* 596 */       String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 597 */       throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */     } 
/*     */ 
/*     */     
/* 601 */     if (str2 == null) {
/* 602 */       if (bool1) {
/* 603 */         return calculateRawEncoding(paramString2, paramString3, paramString4);
/*     */       }
/* 605 */       return (this.defaultEncoding == null) ? "US-ASCII" : this.defaultEncoding;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 610 */     if (str2.equals("UTF-16BE") || str2.equals("UTF-16LE")) {
/* 611 */       if (paramString2 != null) {
/* 612 */         String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 613 */         throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */       } 
/* 615 */       return str2;
/*     */     } 
/*     */ 
/*     */     
/* 619 */     if (str2.equals("UTF-16")) {
/* 620 */       if (paramString2 != null && paramString2.startsWith("UTF-16")) {
/* 621 */         return paramString2;
/*     */       }
/* 623 */       String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 624 */       throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */     } 
/*     */ 
/*     */     
/* 628 */     if (str2.equals("UTF-32BE") || str2.equals("UTF-32LE")) {
/* 629 */       if (paramString2 != null) {
/* 630 */         String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 631 */         throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */       } 
/* 633 */       return str2;
/*     */     } 
/*     */ 
/*     */     
/* 637 */     if (str2.equals("UTF-32")) {
/* 638 */       if (paramString2 != null && paramString2.startsWith("UTF-32")) {
/* 639 */         return paramString2;
/*     */       }
/* 641 */       String str = MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[] { str1, str2, paramString2, paramString3, paramString4 });
/* 642 */       throw new XmlStreamReaderException(str, str1, str2, paramString2, paramString3, paramString4);
/*     */     } 
/*     */     
/* 645 */     return str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getContentTypeMime(String paramString) {
/* 655 */     String str = null;
/* 656 */     if (paramString != null) {
/* 657 */       int i = paramString.indexOf(";");
/* 658 */       if (i >= 0) {
/* 659 */         str = paramString.substring(0, i);
/*     */       } else {
/* 661 */         str = paramString;
/*     */       } 
/* 663 */       str = str.trim();
/*     */     } 
/* 665 */     return str;
/*     */   }
/*     */ 
/*     */   
/* 669 */   private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String getContentTypeEncoding(String paramString) {
/* 679 */     String str = null;
/* 680 */     if (paramString != null) {
/* 681 */       int i = paramString.indexOf(";");
/* 682 */       if (i > -1) {
/* 683 */         String str1 = paramString.substring(i + 1);
/* 684 */         Matcher matcher = CHARSET_PATTERN.matcher(str1);
/* 685 */         str = matcher.find() ? matcher.group(1) : null;
/* 686 */         str = (str != null) ? str.toUpperCase(Locale.US) : null;
/*     */       } 
/*     */     } 
/* 689 */     return str;
/*     */   }
/*     */   
/* 692 */   public static final Pattern ENCODING_PATTERN = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);
/*     */   
/*     */   private static final String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
/*     */   
/*     */   private static final String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
/*     */   
/*     */   private static final String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
/*     */   
/*     */   private static final String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
/*     */   
/*     */   private static final String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
/*     */ 
/*     */   
/*     */   private static String getXmlProlog(InputStream paramInputStream, String paramString) {
/* 706 */     String str = null;
/* 707 */     if (paramString != null) {
/* 708 */       byte[] arrayOfByte = new byte[4096];
/* 709 */       paramInputStream.mark(4096);
/* 710 */       int i = 0;
/* 711 */       int j = 4096;
/* 712 */       int k = paramInputStream.read(arrayOfByte, i, j);
/* 713 */       int m = -1;
/* 714 */       String str1 = "";
/* 715 */       while (k != -1 && m == -1 && i < 4096) {
/* 716 */         i += k;
/* 717 */         j -= k;
/* 718 */         k = paramInputStream.read(arrayOfByte, i, j);
/* 719 */         str1 = new String(arrayOfByte, 0, i, paramString);
/* 720 */         m = str1.indexOf('>');
/*     */       } 
/* 722 */       if (m == -1) {
/* 723 */         if (k == -1) {
/* 724 */           throw new IOException("Unexpected end of XML stream");
/*     */         }
/* 726 */         throw new IOException("XML prolog or ROOT element not found on first " + i + " bytes");
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 731 */       int n = i;
/* 732 */       if (n > 0) {
/* 733 */         paramInputStream.reset();
/*     */         
/* 735 */         BufferedReader bufferedReader = new BufferedReader(new StringReader(str1.substring(0, m + 1)));
/* 736 */         StringBuffer stringBuffer = new StringBuffer();
/* 737 */         String str2 = bufferedReader.readLine();
/* 738 */         while (str2 != null) {
/* 739 */           stringBuffer.append(str2);
/* 740 */           str2 = bufferedReader.readLine();
/*     */         } 
/* 742 */         Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer);
/* 743 */         if (matcher.find()) {
/* 744 */           str = matcher.group(1).toUpperCase();
/* 745 */           str = str.substring(1, str.length() - 1);
/*     */         } 
/*     */       } 
/*     */     } 
/* 749 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isAppXml(String paramString) {
/* 760 */     return (paramString != null && (paramString
/* 761 */       .equals("application/xml") || paramString
/* 762 */       .equals("application/xml-dtd") || paramString
/* 763 */       .equals("application/xml-external-parsed-entity") || (paramString
/* 764 */       .startsWith("application/") && paramString.endsWith("+xml"))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isTextXml(String paramString) {
/* 775 */     return (paramString != null && (paramString
/* 776 */       .equals("text/xml") || paramString
/* 777 */       .equals("text/xml-external-parsed-entity") || (paramString
/* 778 */       .startsWith("text/") && paramString.endsWith("+xml"))));
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/XmlStreamReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */