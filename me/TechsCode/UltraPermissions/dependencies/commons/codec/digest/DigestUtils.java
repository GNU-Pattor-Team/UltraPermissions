/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.digest;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.InputStream;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.security.MessageDigest;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.Hex;
/*      */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.binary.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DigestUtils
/*      */ {
/*      */   private static final int STREAM_BUFFER_LENGTH = 1024;
/*      */   private final MessageDigest messageDigest;
/*      */   
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, byte[] paramArrayOfbyte) {
/*   68 */     return paramMessageDigest.digest(paramArrayOfbyte);
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, ByteBuffer paramByteBuffer) {
/*   83 */     paramMessageDigest.update(paramByteBuffer);
/*   84 */     return paramMessageDigest.digest();
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, File paramFile) {
/*  100 */     return updateDigest(paramMessageDigest, paramFile).digest();
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
/*      */   public static byte[] digest(MessageDigest paramMessageDigest, InputStream paramInputStream) {
/*  116 */     return updateDigest(paramMessageDigest, paramInputStream).digest();
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
/*      */   public static MessageDigest getDigest(String paramString) {
/*      */     try {
/*  134 */       return MessageDigest.getInstance(paramString);
/*  135 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  136 */       throw new IllegalArgumentException(noSuchAlgorithmException);
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
/*      */   public static MessageDigest getDigest(String paramString, MessageDigest paramMessageDigest) {
/*      */     try {
/*  159 */       return MessageDigest.getInstance(paramString);
/*  160 */     } catch (Exception exception) {
/*  161 */       return paramMessageDigest;
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
/*      */   public static MessageDigest getMd2Digest() {
/*  176 */     return getDigest("MD2");
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
/*      */   public static MessageDigest getMd5Digest() {
/*  189 */     return getDigest("MD5");
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
/*      */   public static MessageDigest getSha1Digest() {
/*  203 */     return getDigest("SHA-1");
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
/*      */   public static MessageDigest getSha256Digest() {
/*  216 */     return getDigest("SHA-256");
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
/*      */   public static MessageDigest getSha3_224Digest() {
/*  229 */     return getDigest("SHA3-224");
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
/*      */   public static MessageDigest getSha3_256Digest() {
/*  242 */     return getDigest("SHA3-256");
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
/*      */   public static MessageDigest getSha3_384Digest() {
/*  255 */     return getDigest("SHA3-384");
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
/*      */   public static MessageDigest getSha3_512Digest() {
/*  268 */     return getDigest("SHA3-512");
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
/*      */   public static MessageDigest getSha384Digest() {
/*  281 */     return getDigest("SHA-384");
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
/*      */   public static MessageDigest getSha512Digest() {
/*  294 */     return getDigest("SHA-512");
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
/*      */   @Deprecated
/*      */   public static MessageDigest getShaDigest() {
/*  307 */     return getSha1Digest();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAvailable(String paramString) {
/*  317 */     return (getDigest(paramString, null) != null);
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
/*      */   public static byte[] md2(byte[] paramArrayOfbyte) {
/*  329 */     return getMd2Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] md2(InputStream paramInputStream) {
/*  343 */     return digest(getMd2Digest(), paramInputStream);
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
/*      */   public static byte[] md2(String paramString) {
/*  355 */     return md2(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String md2Hex(byte[] paramArrayOfbyte) {
/*  367 */     return Hex.encodeHexString(md2(paramArrayOfbyte));
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
/*      */   public static String md2Hex(InputStream paramInputStream) {
/*  381 */     return Hex.encodeHexString(md2(paramInputStream));
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
/*      */   public static String md2Hex(String paramString) {
/*  393 */     return Hex.encodeHexString(md2(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] md5(byte[] paramArrayOfbyte) {
/*  404 */     return getMd5Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] md5(InputStream paramInputStream) {
/*  418 */     return digest(getMd5Digest(), paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] md5(String paramString) {
/*  429 */     return md5(StringUtils.getBytesUtf8(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String md5Hex(byte[] paramArrayOfbyte) {
/*  440 */     return Hex.encodeHexString(md5(paramArrayOfbyte));
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
/*      */   public static String md5Hex(InputStream paramInputStream) {
/*  454 */     return Hex.encodeHexString(md5(paramInputStream));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String md5Hex(String paramString) {
/*  465 */     return Hex.encodeHexString(md5(paramString));
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
/*      */   @Deprecated
/*      */   public static byte[] sha(byte[] paramArrayOfbyte) {
/*  478 */     return sha1(paramArrayOfbyte);
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
/*      */   public static byte[] sha(InputStream paramInputStream) {
/*  494 */     return sha1(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static byte[] sha(String paramString) {
/*  507 */     return sha1(paramString);
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
/*      */   public static byte[] sha1(byte[] paramArrayOfbyte) {
/*  519 */     return getSha1Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha1(InputStream paramInputStream) {
/*  533 */     return digest(getSha1Digest(), paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] sha1(String paramString) {
/*  544 */     return sha1(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha1Hex(byte[] paramArrayOfbyte) {
/*  556 */     return Hex.encodeHexString(sha1(paramArrayOfbyte));
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
/*      */   public static String sha1Hex(InputStream paramInputStream) {
/*  570 */     return Hex.encodeHexString(sha1(paramInputStream));
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
/*      */   public static String sha1Hex(String paramString) {
/*  582 */     return Hex.encodeHexString(sha1(paramString));
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
/*      */   public static byte[] sha256(byte[] paramArrayOfbyte) {
/*  594 */     return getSha256Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha256(InputStream paramInputStream) {
/*  608 */     return digest(getSha256Digest(), paramInputStream);
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
/*      */   public static byte[] sha256(String paramString) {
/*  620 */     return sha256(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha256Hex(byte[] paramArrayOfbyte) {
/*  632 */     return Hex.encodeHexString(sha256(paramArrayOfbyte));
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
/*      */   public static String sha256Hex(InputStream paramInputStream) {
/*  646 */     return Hex.encodeHexString(sha256(paramInputStream));
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
/*      */   public static String sha256Hex(String paramString) {
/*  658 */     return Hex.encodeHexString(sha256(paramString));
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
/*      */   public static byte[] sha3_224(byte[] paramArrayOfbyte) {
/*  670 */     return getSha3_224Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_224(InputStream paramInputStream) {
/*  684 */     return digest(getSha3_224Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_224(String paramString) {
/*  696 */     return sha3_224(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_224Hex(String paramString) {
/*  708 */     return Hex.encodeHexString(sha3_224(paramString));
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
/*      */   public static byte[] sha3_256(byte[] paramArrayOfbyte) {
/*  720 */     return getSha3_256Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_256(InputStream paramInputStream) {
/*  734 */     return digest(getSha3_256Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_256(String paramString) {
/*  746 */     return sha3_256(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_256Hex(String paramString) {
/*  758 */     return Hex.encodeHexString(sha3_256(paramString));
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
/*      */   public static byte[] sha3_384(byte[] paramArrayOfbyte) {
/*  770 */     return getSha3_384Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_384(InputStream paramInputStream) {
/*  784 */     return digest(getSha3_384Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_384(String paramString) {
/*  796 */     return sha3_384(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_384Hex(String paramString) {
/*  808 */     return Hex.encodeHexString(sha3_384(paramString));
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
/*      */   public static byte[] sha3_512(byte[] paramArrayOfbyte) {
/*  820 */     return getSha3_512Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha3_512(InputStream paramInputStream) {
/*  834 */     return digest(getSha3_512Digest(), paramInputStream);
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
/*      */   public static byte[] sha3_512(String paramString) {
/*  846 */     return sha3_512(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha3_512Hex(String paramString) {
/*  858 */     return Hex.encodeHexString(sha3_512(paramString));
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
/*      */   public static byte[] sha384(byte[] paramArrayOfbyte) {
/*  870 */     return getSha384Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha384(InputStream paramInputStream) {
/*  884 */     return digest(getSha384Digest(), paramInputStream);
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
/*      */   public static byte[] sha384(String paramString) {
/*  896 */     return sha384(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha384Hex(byte[] paramArrayOfbyte) {
/*  908 */     return Hex.encodeHexString(sha384(paramArrayOfbyte));
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
/*      */   public static String sha384Hex(InputStream paramInputStream) {
/*  922 */     return Hex.encodeHexString(sha384(paramInputStream));
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
/*      */   public static String sha384Hex(String paramString) {
/*  934 */     return Hex.encodeHexString(sha384(paramString));
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
/*      */   public static byte[] sha512(byte[] paramArrayOfbyte) {
/*  946 */     return getSha512Digest().digest(paramArrayOfbyte);
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
/*      */   public static byte[] sha512(InputStream paramInputStream) {
/*  960 */     return digest(getSha512Digest(), paramInputStream);
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
/*      */   public static byte[] sha512(String paramString) {
/*  972 */     return sha512(StringUtils.getBytesUtf8(paramString));
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
/*      */   public static String sha512Hex(byte[] paramArrayOfbyte) {
/*  984 */     return Hex.encodeHexString(sha512(paramArrayOfbyte));
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
/*      */   public static String sha3_224Hex(byte[] paramArrayOfbyte) {
/*  996 */     return Hex.encodeHexString(sha3_224(paramArrayOfbyte));
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
/*      */   public static String sha3_256Hex(byte[] paramArrayOfbyte) {
/* 1008 */     return Hex.encodeHexString(sha3_256(paramArrayOfbyte));
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
/*      */   public static String sha3_384Hex(byte[] paramArrayOfbyte) {
/* 1020 */     return Hex.encodeHexString(sha3_384(paramArrayOfbyte));
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
/*      */   public static String sha3_512Hex(byte[] paramArrayOfbyte) {
/* 1032 */     return Hex.encodeHexString(sha3_512(paramArrayOfbyte));
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
/*      */   public static String sha512Hex(InputStream paramInputStream) {
/* 1046 */     return Hex.encodeHexString(sha512(paramInputStream));
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
/*      */   public static String sha3_224Hex(InputStream paramInputStream) {
/* 1060 */     return Hex.encodeHexString(sha3_224(paramInputStream));
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
/*      */   public static String sha3_256Hex(InputStream paramInputStream) {
/* 1074 */     return Hex.encodeHexString(sha3_256(paramInputStream));
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
/*      */   public static String sha3_384Hex(InputStream paramInputStream) {
/* 1088 */     return Hex.encodeHexString(sha3_384(paramInputStream));
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
/*      */   public static String sha3_512Hex(InputStream paramInputStream) {
/* 1102 */     return Hex.encodeHexString(sha3_512(paramInputStream));
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
/*      */   public static String sha512Hex(String paramString) {
/* 1114 */     return Hex.encodeHexString(sha512(paramString));
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
/*      */   @Deprecated
/*      */   public static String shaHex(byte[] paramArrayOfbyte) {
/* 1127 */     return sha1Hex(paramArrayOfbyte);
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
/*      */   public static String shaHex(InputStream paramInputStream) {
/* 1143 */     return sha1Hex(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static String shaHex(String paramString) {
/* 1156 */     return sha1Hex(paramString);
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, byte[] paramArrayOfbyte) {
/* 1170 */     paramMessageDigest.update(paramArrayOfbyte);
/* 1171 */     return paramMessageDigest;
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, ByteBuffer paramByteBuffer) {
/* 1185 */     paramMessageDigest.update(paramByteBuffer);
/* 1186 */     return paramMessageDigest;
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, File paramFile) {
/* 1202 */     try (BufferedInputStream null = new BufferedInputStream(new FileInputStream(paramFile))) {
/* 1203 */       return updateDigest(paramMessageDigest, bufferedInputStream);
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, InputStream paramInputStream) {
/* 1220 */     byte[] arrayOfByte = new byte[1024];
/* 1221 */     int i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     
/* 1223 */     while (i > -1) {
/* 1224 */       paramMessageDigest.update(arrayOfByte, 0, i);
/* 1225 */       i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     } 
/*      */     
/* 1228 */     return paramMessageDigest;
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
/*      */   public static MessageDigest updateDigest(MessageDigest paramMessageDigest, String paramString) {
/* 1248 */     paramMessageDigest.update(StringUtils.getBytesUtf8(paramString));
/* 1249 */     return paramMessageDigest;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public DigestUtils() {
/* 1261 */     this.messageDigest = null;
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
/*      */   public DigestUtils(MessageDigest paramMessageDigest) {
/* 1274 */     this.messageDigest = paramMessageDigest;
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
/*      */   public DigestUtils(String paramString) {
/* 1290 */     this(getDigest(paramString));
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
/*      */   public byte[] digest(byte[] paramArrayOfbyte) {
/* 1302 */     return updateDigest(this.messageDigest, paramArrayOfbyte).digest();
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
/*      */   public byte[] digest(ByteBuffer paramByteBuffer) {
/* 1315 */     return updateDigest(this.messageDigest, paramByteBuffer).digest();
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
/*      */   public byte[] digest(File paramFile) {
/* 1329 */     return updateDigest(this.messageDigest, paramFile).digest();
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
/*      */   public byte[] digest(InputStream paramInputStream) {
/* 1343 */     return updateDigest(this.messageDigest, paramInputStream).digest();
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
/*      */   public byte[] digest(String paramString) {
/* 1355 */     return updateDigest(this.messageDigest, paramString).digest();
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
/*      */   public String digestAsHex(byte[] paramArrayOfbyte) {
/* 1367 */     return Hex.encodeHexString(digest(paramArrayOfbyte));
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
/*      */   public String digestAsHex(ByteBuffer paramByteBuffer) {
/* 1380 */     return Hex.encodeHexString(digest(paramByteBuffer));
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
/*      */   public String digestAsHex(File paramFile) {
/* 1394 */     return Hex.encodeHexString(digest(paramFile));
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
/*      */   public String digestAsHex(InputStream paramInputStream) {
/* 1408 */     return Hex.encodeHexString(digest(paramInputStream));
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
/*      */   public String digestAsHex(String paramString) {
/* 1420 */     return Hex.encodeHexString(digest(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MessageDigest getMessageDigest() {
/* 1429 */     return this.messageDigest;
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/digest/DigestUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */