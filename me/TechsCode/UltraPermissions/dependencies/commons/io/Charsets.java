/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Collections;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Charsets
/*     */ {
/*     */   public static SortedMap<String, Charset> requiredCharsets() {
/*  76 */     TreeMap<String, Object> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
/*  77 */     treeMap.put(StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1);
/*  78 */     treeMap.put(StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII);
/*  79 */     treeMap.put(StandardCharsets.UTF_16.name(), StandardCharsets.UTF_16);
/*  80 */     treeMap.put(StandardCharsets.UTF_16BE.name(), StandardCharsets.UTF_16BE);
/*  81 */     treeMap.put(StandardCharsets.UTF_16LE.name(), StandardCharsets.UTF_16LE);
/*  82 */     treeMap.put(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8);
/*  83 */     return (SortedMap)Collections.unmodifiableSortedMap(treeMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Charset toCharset(Charset paramCharset) {
/*  94 */     return (paramCharset == null) ? Charset.defaultCharset() : paramCharset;
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
/*     */   public static Charset toCharset(String paramString) {
/* 107 */     return (paramString == null) ? Charset.defaultCharset() : Charset.forName(paramString);
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
/*     */   @Deprecated
/* 120 */   public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
/*     */ 
/*     */ 
/*     */ 
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
/* 134 */   public static final Charset US_ASCII = StandardCharsets.US_ASCII;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 149 */   public static final Charset UTF_16 = StandardCharsets.UTF_16;
/*     */ 
/*     */ 
/*     */ 
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
/* 163 */   public static final Charset UTF_16BE = StandardCharsets.UTF_16BE;
/*     */ 
/*     */ 
/*     */ 
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
/* 177 */   public static final Charset UTF_16LE = StandardCharsets.UTF_16LE;
/*     */ 
/*     */ 
/*     */ 
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
/* 191 */   public static final Charset UTF_8 = StandardCharsets.UTF_8;
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/Charsets.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */