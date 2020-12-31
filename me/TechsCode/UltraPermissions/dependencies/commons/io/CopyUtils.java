/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class CopyUtils
/*     */ {
/*     */   private static final int DEFAULT_BUFFER_SIZE = 4096;
/*     */   
/*     */   public static void copy(byte[] paramArrayOfbyte, OutputStream paramOutputStream) {
/* 136 */     paramOutputStream.write(paramArrayOfbyte);
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
/*     */   @Deprecated
/*     */   public static void copy(byte[] paramArrayOfbyte, Writer paramWriter) {
/* 155 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
/* 156 */     copy(byteArrayInputStream, paramWriter);
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
/*     */   public static void copy(byte[] paramArrayOfbyte, Writer paramWriter, String paramString) {
/* 175 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
/* 176 */     copy(byteArrayInputStream, paramWriter, paramString);
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
/*     */   public static int copy(InputStream paramInputStream, OutputStream paramOutputStream) {
/* 196 */     byte[] arrayOfByte = new byte[4096];
/* 197 */     int i = 0;
/* 198 */     int j = 0;
/* 199 */     while (-1 != (j = paramInputStream.read(arrayOfByte))) {
/* 200 */       paramOutputStream.write(arrayOfByte, 0, j);
/* 201 */       i += j;
/*     */     } 
/* 203 */     return i;
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
/*     */   public static int copy(Reader paramReader, Writer paramWriter) {
/* 221 */     char[] arrayOfChar = new char[4096];
/* 222 */     int i = 0;
/* 223 */     int j = 0;
/* 224 */     while (-1 != (j = paramReader.read(arrayOfChar))) {
/* 225 */       paramWriter.write(arrayOfChar, 0, j);
/* 226 */       i += j;
/*     */     } 
/* 228 */     return i;
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
/*     */   @Deprecated
/*     */   public static void copy(InputStream paramInputStream, Writer paramWriter) {
/* 250 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, Charset.defaultCharset());
/* 251 */     copy(inputStreamReader, paramWriter);
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
/*     */   public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString) {
/* 269 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, paramString);
/* 270 */     copy(inputStreamReader, paramWriter);
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
/*     */   @Deprecated
/*     */   public static void copy(Reader paramReader, OutputStream paramOutputStream) {
/* 293 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, Charset.defaultCharset());
/* 294 */     copy(paramReader, outputStreamWriter);
/*     */ 
/*     */     
/* 297 */     outputStreamWriter.flush();
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
/*     */   public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString) {
/* 316 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, paramString);
/* 317 */     copy(paramReader, outputStreamWriter);
/*     */ 
/*     */     
/* 320 */     outputStreamWriter.flush();
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
/*     */   @Deprecated
/*     */   public static void copy(String paramString, OutputStream paramOutputStream) {
/* 342 */     StringReader stringReader = new StringReader(paramString);
/*     */     
/* 344 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, Charset.defaultCharset());
/* 345 */     copy(stringReader, outputStreamWriter);
/*     */ 
/*     */     
/* 348 */     outputStreamWriter.flush();
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
/*     */   public static void copy(String paramString1, OutputStream paramOutputStream, String paramString2) {
/* 368 */     StringReader stringReader = new StringReader(paramString1);
/* 369 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, paramString2);
/* 370 */     copy(stringReader, outputStreamWriter);
/*     */ 
/*     */     
/* 373 */     outputStreamWriter.flush();
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
/*     */   public static void copy(String paramString, Writer paramWriter) {
/* 388 */     paramWriter.write(paramString);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/CopyUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */