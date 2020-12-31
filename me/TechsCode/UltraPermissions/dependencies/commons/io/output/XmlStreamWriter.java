/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.output;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.io.input.XmlStreamReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlStreamWriter
/*     */   extends Writer
/*     */ {
/*     */   private static final int BUFFER_SIZE = 4096;
/*     */   private final OutputStream out;
/*     */   private final String defaultEncoding;
/*  46 */   private StringWriter xmlPrologWriter = new StringWriter(4096);
/*     */ 
/*     */ 
/*     */   
/*     */   private Writer writer;
/*     */ 
/*     */ 
/*     */   
/*     */   private String encoding;
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamWriter(OutputStream paramOutputStream) {
/*  59 */     this(paramOutputStream, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlStreamWriter(OutputStream paramOutputStream, String paramString) {
/*  70 */     this.out = paramOutputStream;
/*  71 */     this.defaultEncoding = (paramString != null) ? paramString : "UTF-8";
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
/*     */   public XmlStreamWriter(File paramFile) {
/*  83 */     this(paramFile, (String)null);
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
/*     */   public XmlStreamWriter(File paramFile, String paramString) {
/*  96 */     this(new FileOutputStream(paramFile), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/* 105 */     return this.encoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultEncoding() {
/* 114 */     return this.defaultEncoding;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 124 */     if (this.writer == null) {
/* 125 */       this.encoding = this.defaultEncoding;
/* 126 */       this.writer = new OutputStreamWriter(this.out, this.encoding);
/* 127 */       this.writer.write(this.xmlPrologWriter.toString());
/*     */     } 
/* 129 */     this.writer.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 139 */     if (this.writer != null) {
/* 140 */       this.writer.flush();
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
/*     */   private void detectEncoding(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 154 */     int i = paramInt2;
/* 155 */     StringBuffer stringBuffer = this.xmlPrologWriter.getBuffer();
/* 156 */     if (stringBuffer.length() + paramInt2 > 4096) {
/* 157 */       i = 4096 - stringBuffer.length();
/*     */     }
/* 159 */     this.xmlPrologWriter.write(paramArrayOfchar, paramInt1, i);
/*     */ 
/*     */     
/* 162 */     if (stringBuffer.length() >= 5) {
/* 163 */       if (stringBuffer.substring(0, 5).equals("<?xml")) {
/*     */         
/* 165 */         int j = stringBuffer.indexOf("?>");
/* 166 */         if (j > 0) {
/*     */           
/* 168 */           Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer.substring(0, j));
/*     */           
/* 170 */           if (matcher.find()) {
/* 171 */             this.encoding = matcher.group(1).toUpperCase();
/* 172 */             this.encoding = this.encoding.substring(1, this.encoding.length() - 1);
/*     */           }
/*     */           else {
/*     */             
/* 176 */             this.encoding = this.defaultEncoding;
/*     */           }
/*     */         
/* 179 */         } else if (stringBuffer.length() >= 4096) {
/*     */ 
/*     */           
/* 182 */           this.encoding = this.defaultEncoding;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 187 */         this.encoding = this.defaultEncoding;
/*     */       } 
/* 189 */       if (this.encoding != null) {
/*     */         
/* 191 */         this.xmlPrologWriter = null;
/* 192 */         this.writer = new OutputStreamWriter(this.out, this.encoding);
/* 193 */         this.writer.write(stringBuffer.toString());
/* 194 */         if (paramInt2 > i) {
/* 195 */           this.writer.write(paramArrayOfchar, paramInt1 + i, paramInt2 - i);
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
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 211 */     if (this.xmlPrologWriter != null) {
/* 212 */       detectEncoding(paramArrayOfchar, paramInt1, paramInt2);
/*     */     } else {
/* 214 */       this.writer.write(paramArrayOfchar, paramInt1, paramInt2);
/*     */     } 
/*     */   }
/*     */   
/* 218 */   static final Pattern ENCODING_PATTERN = XmlStreamReader.ENCODING_PATTERN;
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/output/XmlStreamWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */