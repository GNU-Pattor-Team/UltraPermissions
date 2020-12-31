/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlStreamReaderException
/*     */   extends IOException
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String bomEncoding;
/*     */   private final String xmlGuessEncoding;
/*     */   private final String xmlEncoding;
/*     */   private final String contentTypeMime;
/*     */   private final String contentTypeEncoding;
/*     */   
/*     */   public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4) {
/*  60 */     this(paramString1, null, null, paramString2, paramString3, paramString4);
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
/*     */   public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
/*  78 */     super(paramString1);
/*  79 */     this.contentTypeMime = paramString2;
/*  80 */     this.contentTypeEncoding = paramString3;
/*  81 */     this.bomEncoding = paramString4;
/*  82 */     this.xmlGuessEncoding = paramString5;
/*  83 */     this.xmlEncoding = paramString6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBomEncoding() {
/*  92 */     return this.bomEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXmlGuessEncoding() {
/* 101 */     return this.xmlGuessEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXmlEncoding() {
/* 110 */     return this.xmlEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentTypeMime() {
/* 121 */     return this.contentTypeMime;
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
/*     */   public String getContentTypeEncoding() {
/* 133 */     return this.contentTypeEncoding;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/XmlStreamReaderException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */