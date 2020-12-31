/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.CharArrayWriter;
/*      */ import java.io.Closeable;
/*      */ import java.io.EOFException;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.Reader;
/*      */ import java.io.Writer;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.ServerSocket;
/*      */ import java.net.Socket;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.net.URLConnection;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.channels.ReadableByteChannel;
/*      */ import java.nio.channels.Selector;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.output.ByteArrayOutputStream;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.io.output.StringBuilderWriter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class IOUtils
/*      */ {
/*      */   public static final int EOF = -1;
/*      */   public static final char DIR_SEPARATOR_UNIX = '/';
/*      */   public static final char DIR_SEPARATOR_WINDOWS = '\\';
/*  121 */   public static final char DIR_SEPARATOR = File.separatorChar;
/*      */   
/*      */   public static final String LINE_SEPARATOR_UNIX = "\n";
/*      */   
/*      */   public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
/*      */   
/*      */   public static final String LINE_SEPARATOR;
/*      */   
/*      */   private static final int DEFAULT_BUFFER_SIZE = 4096;
/*      */   
/*      */   private static final int SKIP_BUFFER_SIZE = 2048;
/*      */   
/*      */   private static char[] SKIP_CHAR_BUFFER;
/*      */   private static byte[] SKIP_BYTE_BUFFER;
/*      */   
/*      */   static {
/*  137 */     try(StringBuilderWriter null = new StringBuilderWriter(4); 
/*  138 */         PrintWriter null = new PrintWriter((Writer)stringBuilderWriter)) {
/*  139 */       printWriter.println();
/*  140 */       LINE_SEPARATOR = stringBuilderWriter.toString();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void close(URLConnection paramURLConnection) {
/*  187 */     if (paramURLConnection instanceof HttpURLConnection) {
/*  188 */       ((HttpURLConnection)paramURLConnection).disconnect();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Reader paramReader) {
/*  221 */     closeQuietly(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Writer paramWriter) {
/*  252 */     closeQuietly(paramWriter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(InputStream paramInputStream) {
/*  284 */     closeQuietly(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(OutputStream paramOutputStream) {
/*  317 */     closeQuietly(paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Closeable paramCloseable) {
/*      */     try {
/*  362 */       if (paramCloseable != null) {
/*  363 */         paramCloseable.close();
/*      */       }
/*  365 */     } catch (IOException iOException) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Closeable... paramVarArgs) {
/*  419 */     if (paramVarArgs == null) {
/*      */       return;
/*      */     }
/*  422 */     for (Closeable closeable : paramVarArgs) {
/*  423 */       closeQuietly(closeable);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Socket paramSocket) {
/*  456 */     if (paramSocket != null) {
/*      */       try {
/*  458 */         paramSocket.close();
/*  459 */       } catch (IOException iOException) {}
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(Selector paramSelector) {
/*  494 */     if (paramSelector != null) {
/*      */       try {
/*  496 */         paramSelector.close();
/*  497 */       } catch (IOException iOException) {}
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void closeQuietly(ServerSocket paramServerSocket) {
/*  532 */     if (paramServerSocket != null) {
/*      */       try {
/*  534 */         paramServerSocket.close();
/*  535 */       } catch (IOException iOException) {}
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toBufferedInputStream(InputStream paramInputStream) {
/*  563 */     return ByteArrayOutputStream.toBufferedInputStream(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt) {
/*  589 */     return ByteArrayOutputStream.toBufferedInputStream(paramInputStream, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader toBufferedReader(Reader paramReader) {
/*  603 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader toBufferedReader(Reader paramReader, int paramInt) {
/*  618 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader buffer(Reader paramReader) {
/*  631 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedReader buffer(Reader paramReader, int paramInt) {
/*  645 */     return (paramReader instanceof BufferedReader) ? (BufferedReader)paramReader : new BufferedReader(paramReader, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedWriter buffer(Writer paramWriter) {
/*  658 */     return (paramWriter instanceof BufferedWriter) ? (BufferedWriter)paramWriter : new BufferedWriter(paramWriter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedWriter buffer(Writer paramWriter, int paramInt) {
/*  672 */     return (paramWriter instanceof BufferedWriter) ? (BufferedWriter)paramWriter : new BufferedWriter(paramWriter, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedOutputStream buffer(OutputStream paramOutputStream) {
/*  686 */     if (paramOutputStream == null) {
/*  687 */       throw new NullPointerException();
/*      */     }
/*  689 */     return (paramOutputStream instanceof BufferedOutputStream) ? (BufferedOutputStream)paramOutputStream : new BufferedOutputStream(paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedOutputStream buffer(OutputStream paramOutputStream, int paramInt) {
/*  705 */     if (paramOutputStream == null) {
/*  706 */       throw new NullPointerException();
/*      */     }
/*  708 */     return (paramOutputStream instanceof BufferedOutputStream) ? (BufferedOutputStream)paramOutputStream : new BufferedOutputStream(paramOutputStream, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedInputStream buffer(InputStream paramInputStream) {
/*  723 */     if (paramInputStream == null) {
/*  724 */       throw new NullPointerException();
/*      */     }
/*  726 */     return (paramInputStream instanceof BufferedInputStream) ? (BufferedInputStream)paramInputStream : new BufferedInputStream(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedInputStream buffer(InputStream paramInputStream, int paramInt) {
/*  742 */     if (paramInputStream == null) {
/*  743 */       throw new NullPointerException();
/*      */     }
/*  745 */     return (paramInputStream instanceof BufferedInputStream) ? (BufferedInputStream)paramInputStream : new BufferedInputStream(paramInputStream, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(InputStream paramInputStream) {
/*  764 */     try (ByteArrayOutputStream null = new ByteArrayOutputStream()) {
/*  765 */       copy(paramInputStream, (OutputStream)byteArrayOutputStream);
/*  766 */       return byteArrayOutputStream.toByteArray();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(InputStream paramInputStream, long paramLong) {
/*  789 */     if (paramLong > 2147483647L) {
/*  790 */       throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + paramLong);
/*      */     }
/*      */     
/*  793 */     return toByteArray(paramInputStream, (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(InputStream paramInputStream, int paramInt) {
/*  811 */     if (paramInt < 0) {
/*  812 */       throw new IllegalArgumentException("Size must be equal or greater than zero: " + paramInt);
/*      */     }
/*      */     
/*  815 */     if (paramInt == 0) {
/*  816 */       return new byte[0];
/*      */     }
/*      */     
/*  819 */     byte[] arrayOfByte = new byte[paramInt];
/*  820 */     int i = 0;
/*      */     
/*      */     int j;
/*  823 */     while (i < paramInt && (j = paramInputStream.read(arrayOfByte, i, paramInt - i)) != -1) {
/*  824 */       i += j;
/*      */     }
/*      */     
/*  827 */     if (i != paramInt) {
/*  828 */       throw new IOException("Unexpected read size. current: " + i + ", expected: " + paramInt);
/*      */     }
/*      */     
/*  831 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] toByteArray(Reader paramReader) {
/*  849 */     return toByteArray(paramReader, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(Reader paramReader, Charset paramCharset) {
/*  867 */     try (ByteArrayOutputStream null = new ByteArrayOutputStream()) {
/*  868 */       copy(paramReader, (OutputStream)byteArrayOutputStream, paramCharset);
/*  869 */       return byteArrayOutputStream.toByteArray();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(Reader paramReader, String paramString) {
/*  894 */     return toByteArray(paramReader, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static byte[] toByteArray(String paramString) {
/*  912 */     return paramString.getBytes(Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(URI paramURI) {
/*  925 */     return toByteArray(paramURI.toURL());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(URL paramURL) {
/*  938 */     URLConnection uRLConnection = paramURL.openConnection();
/*      */     try {
/*  940 */       return toByteArray(uRLConnection);
/*      */     } finally {
/*  942 */       close(uRLConnection);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] toByteArray(URLConnection paramURLConnection) {
/*  956 */     try (InputStream null = paramURLConnection.getInputStream()) {
/*  957 */       return toByteArray(inputStream);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static char[] toCharArray(InputStream paramInputStream) {
/*  980 */     return toCharArray(paramInputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] toCharArray(InputStream paramInputStream, Charset paramCharset) {
/*  999 */     CharArrayWriter charArrayWriter = new CharArrayWriter();
/* 1000 */     copy(paramInputStream, charArrayWriter, paramCharset);
/* 1001 */     return charArrayWriter.toCharArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] toCharArray(InputStream paramInputStream, String paramString) {
/* 1025 */     return toCharArray(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static char[] toCharArray(Reader paramReader) {
/* 1041 */     CharArrayWriter charArrayWriter = new CharArrayWriter();
/* 1042 */     copy(paramReader, charArrayWriter);
/* 1043 */     return charArrayWriter.toCharArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(InputStream paramInputStream) {
/* 1064 */     return toString(paramInputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(InputStream paramInputStream, Charset paramCharset) {
/* 1083 */     try (StringBuilderWriter null = new StringBuilderWriter()) {
/* 1084 */       copy(paramInputStream, (Writer)stringBuilderWriter, paramCharset);
/* 1085 */       return stringBuilderWriter.toString();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(InputStream paramInputStream, String paramString) {
/* 1110 */     return toString(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(Reader paramReader) {
/* 1125 */     try (StringBuilderWriter null = new StringBuilderWriter()) {
/* 1126 */       copy(paramReader, (Writer)stringBuilderWriter);
/* 1127 */       return stringBuilderWriter.toString();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(URI paramURI) {
/* 1142 */     return toString(paramURI, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URI paramURI, Charset paramCharset) {
/* 1155 */     return toString(paramURI.toURL(), Charsets.toCharset(paramCharset));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URI paramURI, String paramString) {
/* 1171 */     return toString(paramURI, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(URL paramURL) {
/* 1185 */     return toString(paramURL, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URL paramURL, Charset paramCharset) {
/* 1198 */     try (InputStream null = paramURL.openStream()) {
/* 1199 */       return toString(inputStream, paramCharset);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(URL paramURL, String paramString) {
/* 1216 */     return toString(paramURL, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static String toString(byte[] paramArrayOfbyte) {
/* 1232 */     return new String(paramArrayOfbyte, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(byte[] paramArrayOfbyte, String paramString) {
/* 1249 */     return new String(paramArrayOfbyte, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String resourceToString(String paramString, Charset paramCharset) {
/* 1272 */     return resourceToString(paramString, paramCharset, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String resourceToString(String paramString, Charset paramCharset, ClassLoader paramClassLoader) {
/* 1293 */     return toString(resourceToURL(paramString, paramClassLoader), paramCharset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] resourceToByteArray(String paramString) {
/* 1311 */     return resourceToByteArray(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] resourceToByteArray(String paramString, ClassLoader paramClassLoader) {
/* 1330 */     return toByteArray(resourceToURL(paramString, paramClassLoader));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static URL resourceToURL(String paramString) {
/* 1348 */     return resourceToURL(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static URL resourceToURL(String paramString, ClassLoader paramClassLoader) {
/* 1369 */     URL uRL = (paramClassLoader == null) ? IOUtils.class.getResource(paramString) : paramClassLoader.getResource(paramString);
/*      */     
/* 1371 */     if (uRL == null) {
/* 1372 */       throw new IOException("Resource not found: " + paramString);
/*      */     }
/*      */     
/* 1375 */     return uRL;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static List<String> readLines(InputStream paramInputStream) {
/* 1397 */     return readLines(paramInputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(InputStream paramInputStream, Charset paramCharset) {
/* 1415 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset));
/* 1416 */     return readLines(inputStreamReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(InputStream paramInputStream, String paramString) {
/* 1440 */     return readLines(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> readLines(Reader paramReader) {
/* 1457 */     BufferedReader bufferedReader = toBufferedReader(paramReader);
/* 1458 */     ArrayList<String> arrayList = new ArrayList();
/* 1459 */     String str = bufferedReader.readLine();
/* 1460 */     while (str != null) {
/* 1461 */       arrayList.add(str);
/* 1462 */       str = bufferedReader.readLine();
/*      */     } 
/* 1464 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(Reader paramReader) {
/* 1498 */     return new LineIterator(paramReader);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(InputStream paramInputStream, Charset paramCharset) {
/* 1532 */     return new LineIterator(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LineIterator lineIterator(InputStream paramInputStream, String paramString) {
/* 1569 */     return lineIterator(paramInputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static InputStream toInputStream(CharSequence paramCharSequence) {
/* 1585 */     return toInputStream(paramCharSequence, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(CharSequence paramCharSequence, Charset paramCharset) {
/* 1598 */     return toInputStream(paramCharSequence.toString(), paramCharset);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(CharSequence paramCharSequence, String paramString) {
/* 1618 */     return toInputStream(paramCharSequence, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static InputStream toInputStream(String paramString) {
/* 1634 */     return toInputStream(paramString, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(String paramString, Charset paramCharset) {
/* 1647 */     return new ByteArrayInputStream(paramString.getBytes(Charsets.toCharset(paramCharset)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream toInputStream(String paramString1, String paramString2) {
/* 1667 */     byte[] arrayOfByte = paramString1.getBytes(Charsets.toCharset(paramString2));
/* 1668 */     return new ByteArrayInputStream(arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(byte[] paramArrayOfbyte, OutputStream paramOutputStream) {
/* 1686 */     if (paramArrayOfbyte != null) {
/* 1687 */       paramOutputStream.write(paramArrayOfbyte);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeChunked(byte[] paramArrayOfbyte, OutputStream paramOutputStream) {
/* 1705 */     if (paramArrayOfbyte != null) {
/* 1706 */       int i = paramArrayOfbyte.length;
/* 1707 */       int j = 0;
/* 1708 */       while (i > 0) {
/* 1709 */         int k = Math.min(i, 4096);
/* 1710 */         paramOutputStream.write(paramArrayOfbyte, j, k);
/* 1711 */         i -= k;
/* 1712 */         j += k;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(byte[] paramArrayOfbyte, Writer paramWriter) {
/* 1733 */     write(paramArrayOfbyte, paramWriter, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(byte[] paramArrayOfbyte, Writer paramWriter, Charset paramCharset) {
/* 1751 */     if (paramArrayOfbyte != null) {
/* 1752 */       paramWriter.write(new String(paramArrayOfbyte, Charsets.toCharset(paramCharset)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(byte[] paramArrayOfbyte, Writer paramWriter, String paramString) {
/* 1777 */     write(paramArrayOfbyte, paramWriter, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(char[] paramArrayOfchar, Writer paramWriter) {
/* 1794 */     if (paramArrayOfchar != null) {
/* 1795 */       paramWriter.write(paramArrayOfchar);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeChunked(char[] paramArrayOfchar, Writer paramWriter) {
/* 1812 */     if (paramArrayOfchar != null) {
/* 1813 */       int i = paramArrayOfchar.length;
/* 1814 */       int j = 0;
/* 1815 */       while (i > 0) {
/* 1816 */         int k = Math.min(i, 4096);
/* 1817 */         paramWriter.write(paramArrayOfchar, j, k);
/* 1818 */         i -= k;
/* 1819 */         j += k;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(char[] paramArrayOfchar, OutputStream paramOutputStream) {
/* 1842 */     write(paramArrayOfchar, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(char[] paramArrayOfchar, OutputStream paramOutputStream, Charset paramCharset) {
/* 1861 */     if (paramArrayOfchar != null) {
/* 1862 */       paramOutputStream.write((new String(paramArrayOfchar)).getBytes(Charsets.toCharset(paramCharset)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(char[] paramArrayOfchar, OutputStream paramOutputStream, String paramString) {
/* 1888 */     write(paramArrayOfchar, paramOutputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(CharSequence paramCharSequence, Writer paramWriter) {
/* 1904 */     if (paramCharSequence != null) {
/* 1905 */       write(paramCharSequence.toString(), paramWriter);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream) {
/* 1926 */     write(paramCharSequence, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, Charset paramCharset) {
/* 1944 */     if (paramCharSequence != null) {
/* 1945 */       write(paramCharSequence.toString(), paramOutputStream, paramCharset);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, String paramString) {
/* 1969 */     write(paramCharSequence, paramOutputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(String paramString, Writer paramWriter) {
/* 1985 */     if (paramString != null) {
/* 1986 */       paramWriter.write(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(String paramString, OutputStream paramOutputStream) {
/* 2007 */     write(paramString, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(String paramString, OutputStream paramOutputStream, Charset paramCharset) {
/* 2024 */     if (paramString != null) {
/* 2025 */       paramOutputStream.write(paramString.getBytes(Charsets.toCharset(paramCharset)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void write(String paramString1, OutputStream paramOutputStream, String paramString2) {
/* 2049 */     write(paramString1, paramOutputStream, Charsets.toCharset(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(StringBuffer paramStringBuffer, Writer paramWriter) {
/* 2068 */     if (paramStringBuffer != null) {
/* 2069 */       paramWriter.write(paramStringBuffer.toString());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream) {
/* 2090 */     write(paramStringBuffer, paramOutputStream, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream, String paramString) {
/* 2115 */     if (paramStringBuffer != null) {
/* 2116 */       paramOutputStream.write(paramStringBuffer.toString().getBytes(Charsets.toCharset(paramString)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream) {
/* 2139 */     writeLines(paramCollection, paramString, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream, Charset paramCharset) {
/* 2157 */     if (paramCollection == null) {
/*      */       return;
/*      */     }
/* 2160 */     if (paramString == null) {
/* 2161 */       paramString = LINE_SEPARATOR;
/*      */     }
/* 2163 */     Charset charset = Charsets.toCharset(paramCharset);
/* 2164 */     for (Object object : paramCollection) {
/* 2165 */       if (object != null) {
/* 2166 */         paramOutputStream.write(object.toString().getBytes(charset));
/*      */       }
/* 2168 */       paramOutputStream.write(paramString.getBytes(charset));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString1, OutputStream paramOutputStream, String paramString2) {
/* 2193 */     writeLines(paramCollection, paramString1, paramOutputStream, Charsets.toCharset(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void writeLines(Collection<?> paramCollection, String paramString, Writer paramWriter) {
/* 2209 */     if (paramCollection == null) {
/*      */       return;
/*      */     }
/* 2212 */     if (paramString == null) {
/* 2213 */       paramString = LINE_SEPARATOR;
/*      */     }
/* 2215 */     for (Object object : paramCollection) {
/* 2216 */       if (object != null) {
/* 2217 */         paramWriter.write(object.toString());
/*      */       }
/* 2219 */       paramWriter.write(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int copy(InputStream paramInputStream, OutputStream paramOutputStream) {
/* 2246 */     long l = copyLarge(paramInputStream, paramOutputStream);
/* 2247 */     if (l > 2147483647L) {
/* 2248 */       return -1;
/*      */     }
/* 2250 */     return (int)l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt) {
/* 2270 */     return copyLarge(paramInputStream, paramOutputStream, new byte[paramInt]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream) {
/* 2291 */     return copy(paramInputStream, paramOutputStream, 4096);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfbyte) {
/* 2312 */     long l = 0L;
/*      */     int i;
/* 2314 */     while (-1 != (i = paramInputStream.read(paramArrayOfbyte))) {
/* 2315 */       paramOutputStream.write(paramArrayOfbyte, 0, i);
/* 2316 */       l += i;
/*      */     } 
/* 2318 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2) {
/* 2347 */     return copyLarge(paramInputStream, paramOutputStream, paramLong1, paramLong2, new byte[4096]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2, byte[] paramArrayOfbyte) {
/* 2376 */     if (paramLong1 > 0L) {
/* 2377 */       skipFully(paramInputStream, paramLong1);
/*      */     }
/* 2379 */     if (paramLong2 == 0L) {
/* 2380 */       return 0L;
/*      */     }
/* 2382 */     int i = paramArrayOfbyte.length;
/* 2383 */     int j = i;
/* 2384 */     if (paramLong2 > 0L && paramLong2 < i) {
/* 2385 */       j = (int)paramLong2;
/*      */     }
/*      */     
/* 2388 */     long l = 0L; int k;
/* 2389 */     while (j > 0 && -1 != (k = paramInputStream.read(paramArrayOfbyte, 0, j))) {
/* 2390 */       paramOutputStream.write(paramArrayOfbyte, 0, k);
/* 2391 */       l += k;
/* 2392 */       if (paramLong2 > 0L)
/*      */       {
/* 2394 */         j = (int)Math.min(paramLong2 - l, i);
/*      */       }
/*      */     } 
/* 2397 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void copy(InputStream paramInputStream, Writer paramWriter) {
/* 2419 */     copy(paramInputStream, paramWriter, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(InputStream paramInputStream, Writer paramWriter, Charset paramCharset) {
/* 2440 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset));
/* 2441 */     copy(inputStreamReader, paramWriter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString) {
/* 2468 */     copy(paramInputStream, paramWriter, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int copy(Reader paramReader, Writer paramWriter) {
/* 2493 */     long l = copyLarge(paramReader, paramWriter);
/* 2494 */     if (l > 2147483647L) {
/* 2495 */       return -1;
/*      */     }
/* 2497 */     return (int)l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter) {
/* 2516 */     return copyLarge(paramReader, paramWriter, new char[4096]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter, char[] paramArrayOfchar) {
/* 2535 */     long l = 0L;
/*      */     int i;
/* 2537 */     while (-1 != (i = paramReader.read(paramArrayOfchar))) {
/* 2538 */       paramWriter.write(paramArrayOfchar, 0, i);
/* 2539 */       l += i;
/*      */     } 
/* 2541 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2) {
/* 2565 */     return copyLarge(paramReader, paramWriter, paramLong1, paramLong2, new char[4096]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2, char[] paramArrayOfchar) {
/* 2590 */     if (paramLong1 > 0L) {
/* 2591 */       skipFully(paramReader, paramLong1);
/*      */     }
/* 2593 */     if (paramLong2 == 0L) {
/* 2594 */       return 0L;
/*      */     }
/* 2596 */     int i = paramArrayOfchar.length;
/* 2597 */     if (paramLong2 > 0L && paramLong2 < paramArrayOfchar.length) {
/* 2598 */       i = (int)paramLong2;
/*      */     }
/*      */     
/* 2601 */     long l = 0L; int j;
/* 2602 */     while (i > 0 && -1 != (j = paramReader.read(paramArrayOfchar, 0, i))) {
/* 2603 */       paramWriter.write(paramArrayOfchar, 0, j);
/* 2604 */       l += j;
/* 2605 */       if (paramLong2 > 0L)
/*      */       {
/* 2607 */         i = (int)Math.min(paramLong2 - l, paramArrayOfchar.length);
/*      */       }
/*      */     } 
/* 2610 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void copy(Reader paramReader, OutputStream paramOutputStream) {
/* 2636 */     copy(paramReader, paramOutputStream, Charset.defaultCharset());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(Reader paramReader, OutputStream paramOutputStream, Charset paramCharset) {
/* 2664 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, Charsets.toCharset(paramCharset));
/* 2665 */     copy(paramReader, outputStreamWriter);
/*      */ 
/*      */     
/* 2668 */     outputStreamWriter.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString) {
/* 2699 */     copy(paramReader, paramOutputStream, Charsets.toCharset(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2) {
/* 2721 */     if (paramInputStream1 == paramInputStream2) {
/* 2722 */       return true;
/*      */     }
/* 2724 */     if (!(paramInputStream1 instanceof BufferedInputStream)) {
/* 2725 */       paramInputStream1 = new BufferedInputStream(paramInputStream1);
/*      */     }
/* 2727 */     if (!(paramInputStream2 instanceof BufferedInputStream)) {
/* 2728 */       paramInputStream2 = new BufferedInputStream(paramInputStream2);
/*      */     }
/*      */     
/* 2731 */     int i = paramInputStream1.read();
/* 2732 */     while (-1 != i) {
/* 2733 */       int k = paramInputStream2.read();
/* 2734 */       if (i != k) {
/* 2735 */         return false;
/*      */       }
/* 2737 */       i = paramInputStream1.read();
/*      */     } 
/*      */     
/* 2740 */     int j = paramInputStream2.read();
/* 2741 */     return (j == -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEquals(Reader paramReader1, Reader paramReader2) {
/* 2761 */     if (paramReader1 == paramReader2) {
/* 2762 */       return true;
/*      */     }
/*      */     
/* 2765 */     paramReader1 = toBufferedReader(paramReader1);
/* 2766 */     paramReader2 = toBufferedReader(paramReader2);
/*      */     
/* 2768 */     int i = paramReader1.read();
/* 2769 */     while (-1 != i) {
/* 2770 */       int k = paramReader2.read();
/* 2771 */       if (i != k) {
/* 2772 */         return false;
/*      */       }
/* 2774 */       i = paramReader1.read();
/*      */     } 
/*      */     
/* 2777 */     int j = paramReader2.read();
/* 2778 */     return (j == -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contentEqualsIgnoreEOL(Reader paramReader1, Reader paramReader2) {
/* 2797 */     if (paramReader1 == paramReader2) {
/* 2798 */       return true;
/*      */     }
/* 2800 */     BufferedReader bufferedReader1 = toBufferedReader(paramReader1);
/* 2801 */     BufferedReader bufferedReader2 = toBufferedReader(paramReader2);
/*      */     
/* 2803 */     String str1 = bufferedReader1.readLine();
/* 2804 */     String str2 = bufferedReader2.readLine();
/* 2805 */     while (str1 != null && str2 != null && str1.equals(str2)) {
/* 2806 */       str1 = bufferedReader1.readLine();
/* 2807 */       str2 = bufferedReader2.readLine();
/*      */     } 
/* 2809 */     return (str1 == null) ? ((str2 == null)) : str1.equals(str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long skip(InputStream paramInputStream, long paramLong) {
/* 2834 */     if (paramLong < 0L) {
/* 2835 */       throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2842 */     if (SKIP_BYTE_BUFFER == null) {
/* 2843 */       SKIP_BYTE_BUFFER = new byte[2048];
/*      */     }
/* 2845 */     long l = paramLong;
/* 2846 */     while (l > 0L) {
/*      */       
/* 2848 */       long l1 = paramInputStream.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l, 2048L));
/* 2849 */       if (l1 < 0L) {
/*      */         break;
/*      */       }
/* 2852 */       l -= l1;
/*      */     } 
/* 2854 */     return paramLong - l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long skip(ReadableByteChannel paramReadableByteChannel, long paramLong) {
/* 2870 */     if (paramLong < 0L) {
/* 2871 */       throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
/*      */     }
/* 2873 */     ByteBuffer byteBuffer = ByteBuffer.allocate((int)Math.min(paramLong, 2048L));
/* 2874 */     long l = paramLong;
/* 2875 */     while (l > 0L) {
/* 2876 */       byteBuffer.position(0);
/* 2877 */       byteBuffer.limit((int)Math.min(l, 2048L));
/* 2878 */       int i = paramReadableByteChannel.read(byteBuffer);
/* 2879 */       if (i == -1) {
/*      */         break;
/*      */       }
/* 2882 */       l -= i;
/*      */     } 
/* 2884 */     return paramLong - l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long skip(Reader paramReader, long paramLong) {
/* 2909 */     if (paramLong < 0L) {
/* 2910 */       throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2917 */     if (SKIP_CHAR_BUFFER == null) {
/* 2918 */       SKIP_CHAR_BUFFER = new char[2048];
/*      */     }
/* 2920 */     long l = paramLong;
/* 2921 */     while (l > 0L) {
/*      */       
/* 2923 */       long l1 = paramReader.read(SKIP_CHAR_BUFFER, 0, (int)Math.min(l, 2048L));
/* 2924 */       if (l1 < 0L) {
/*      */         break;
/*      */       }
/* 2927 */       l -= l1;
/*      */     } 
/* 2929 */     return paramLong - l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void skipFully(InputStream paramInputStream, long paramLong) {
/* 2952 */     if (paramLong < 0L) {
/* 2953 */       throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
/*      */     }
/* 2955 */     long l = skip(paramInputStream, paramLong);
/* 2956 */     if (l != paramLong) {
/* 2957 */       throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void skipFully(ReadableByteChannel paramReadableByteChannel, long paramLong) {
/* 2972 */     if (paramLong < 0L) {
/* 2973 */       throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
/*      */     }
/* 2975 */     long l = skip(paramReadableByteChannel, paramLong);
/* 2976 */     if (l != paramLong) {
/* 2977 */       throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void skipFully(Reader paramReader, long paramLong) {
/* 3001 */     long l = skip(paramReader, paramLong);
/* 3002 */     if (l != paramLong) {
/* 3003 */       throw new EOFException("Chars to skip: " + paramLong + " actual: " + l);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(Reader paramReader, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 3024 */     if (paramInt2 < 0) {
/* 3025 */       throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
/*      */     }
/* 3027 */     int i = paramInt2;
/* 3028 */     while (i > 0) {
/* 3029 */       int j = paramInt2 - i;
/* 3030 */       int k = paramReader.read(paramArrayOfchar, paramInt1 + j, i);
/* 3031 */       if (-1 == k) {
/*      */         break;
/*      */       }
/* 3034 */       i -= k;
/*      */     } 
/* 3036 */     return paramInt2 - i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(Reader paramReader, char[] paramArrayOfchar) {
/* 3052 */     return read(paramReader, paramArrayOfchar, 0, paramArrayOfchar.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 3071 */     if (paramInt2 < 0) {
/* 3072 */       throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
/*      */     }
/* 3074 */     int i = paramInt2;
/* 3075 */     while (i > 0) {
/* 3076 */       int j = paramInt2 - i;
/* 3077 */       int k = paramInputStream.read(paramArrayOfbyte, paramInt1 + j, i);
/* 3078 */       if (-1 == k) {
/*      */         break;
/*      */       }
/* 3081 */       i -= k;
/*      */     } 
/* 3083 */     return paramInt2 - i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(InputStream paramInputStream, byte[] paramArrayOfbyte) {
/* 3099 */     return read(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int read(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer) {
/* 3116 */     int i = paramByteBuffer.remaining();
/* 3117 */     while (paramByteBuffer.remaining() > 0) {
/* 3118 */       int j = paramReadableByteChannel.read(paramByteBuffer);
/* 3119 */       if (-1 == j) {
/*      */         break;
/*      */       }
/*      */     } 
/* 3123 */     return i - paramByteBuffer.remaining();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(Reader paramReader, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 3143 */     int i = read(paramReader, paramArrayOfchar, paramInt1, paramInt2);
/* 3144 */     if (i != paramInt2) {
/* 3145 */       throw new EOFException("Length to read: " + paramInt2 + " actual: " + i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(Reader paramReader, char[] paramArrayOfchar) {
/* 3163 */     readFully(paramReader, paramArrayOfchar, 0, paramArrayOfchar.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 3183 */     int i = read(paramInputStream, paramArrayOfbyte, paramInt1, paramInt2);
/* 3184 */     if (i != paramInt2) {
/* 3185 */       throw new EOFException("Length to read: " + paramInt2 + " actual: " + i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte) {
/* 3203 */     readFully(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] readFully(InputStream paramInputStream, int paramInt) {
/* 3221 */     byte[] arrayOfByte = new byte[paramInt];
/* 3222 */     readFully(paramInputStream, arrayOfByte, 0, arrayOfByte.length);
/* 3223 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void readFully(ReadableByteChannel paramReadableByteChannel, ByteBuffer paramByteBuffer) {
/* 3239 */     int i = paramByteBuffer.remaining();
/* 3240 */     int j = read(paramReadableByteChannel, paramByteBuffer);
/* 3241 */     if (j != i)
/* 3242 */       throw new EOFException("Length to read: " + i + " actual: " + j); 
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/IOUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */