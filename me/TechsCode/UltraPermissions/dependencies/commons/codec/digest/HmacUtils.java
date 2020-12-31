/*      */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.digest;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.InputStream;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.security.InvalidKeyException;
/*      */ import java.security.NoSuchAlgorithmException;
/*      */ import javax.crypto.Mac;
/*      */ import javax.crypto.spec.SecretKeySpec;
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
/*      */ public final class HmacUtils
/*      */ {
/*      */   private static final int STREAM_BUFFER_LENGTH = 1024;
/*      */   private final Mac mac;
/*      */   
/*      */   public static boolean isAvailable(String paramString) {
/*      */     try {
/*   70 */       Mac.getInstance(paramString);
/*   71 */       return true;
/*   72 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*   73 */       return false;
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
/*      */   public static boolean isAvailable(HmacAlgorithms paramHmacAlgorithms) {
/*      */     try {
/*   86 */       Mac.getInstance(paramHmacAlgorithms.getName());
/*   87 */       return true;
/*   88 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*   89 */       return false;
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
/*      */   public static Mac getHmacMd5(byte[] paramArrayOfbyte) {
/*  110 */     return getInitializedMac(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte);
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
/*      */   public static Mac getHmacSha1(byte[] paramArrayOfbyte) {
/*  130 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte);
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
/*      */   public static Mac getHmacSha256(byte[] paramArrayOfbyte) {
/*  150 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte);
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
/*      */   public static Mac getHmacSha384(byte[] paramArrayOfbyte) {
/*  170 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte);
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
/*      */   public static Mac getHmacSha512(byte[] paramArrayOfbyte) {
/*  190 */     return getInitializedMac(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte);
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
/*      */   public static Mac getInitializedMac(HmacAlgorithms paramHmacAlgorithms, byte[] paramArrayOfbyte) {
/*  210 */     return getInitializedMac(paramHmacAlgorithms.getName(), paramArrayOfbyte);
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
/*      */   public static Mac getInitializedMac(String paramString, byte[] paramArrayOfbyte) {
/*  231 */     if (paramArrayOfbyte == null) {
/*  232 */       throw new IllegalArgumentException("Null key");
/*      */     }
/*      */     
/*      */     try {
/*  236 */       SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte, paramString);
/*  237 */       Mac mac = Mac.getInstance(paramString);
/*  238 */       mac.init(secretKeySpec);
/*  239 */       return mac;
/*  240 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  241 */       throw new IllegalArgumentException(noSuchAlgorithmException);
/*  242 */     } catch (InvalidKeyException invalidKeyException) {
/*  243 */       throw new IllegalArgumentException(invalidKeyException);
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
/*      */   public static byte[] hmacMd5(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  263 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
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
/*      */   public static byte[] hmacMd5(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  285 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte)).hmac(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static byte[] hmacMd5(String paramString1, String paramString2) {
/*  302 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramString1)).hmac(paramString2);
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
/*      */   @Deprecated
/*      */   public static String hmacMd5Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  319 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
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
/*      */   public static String hmacMd5Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  341 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramArrayOfbyte)).hmacHex(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static String hmacMd5Hex(String paramString1, String paramString2) {
/*  358 */     return (new HmacUtils(HmacAlgorithms.HMAC_MD5, paramString1)).hmacHex(paramString2);
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
/*      */   public static byte[] hmacSha1(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  377 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
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
/*      */   public static byte[] hmacSha1(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  399 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte)).hmac(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static byte[] hmacSha1(String paramString1, String paramString2) {
/*  416 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramString1)).hmac(paramString2);
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
/*      */   @Deprecated
/*      */   public static String hmacSha1Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  433 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
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
/*      */   public static String hmacSha1Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  455 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramArrayOfbyte)).hmacHex(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static String hmacSha1Hex(String paramString1, String paramString2) {
/*  472 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_1, paramString1)).hmacHex(paramString2);
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
/*      */   public static byte[] hmacSha256(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  491 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
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
/*      */   public static byte[] hmacSha256(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  513 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte)).hmac(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static byte[] hmacSha256(String paramString1, String paramString2) {
/*  530 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramString1)).hmac(paramString2);
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
/*      */   @Deprecated
/*      */   public static String hmacSha256Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  547 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
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
/*      */   public static String hmacSha256Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  569 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramArrayOfbyte)).hmacHex(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static String hmacSha256Hex(String paramString1, String paramString2) {
/*  586 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_256, paramString1)).hmacHex(paramString2);
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
/*      */   public static byte[] hmacSha384(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  605 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
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
/*      */   public static byte[] hmacSha384(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  627 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte)).hmac(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static byte[] hmacSha384(String paramString1, String paramString2) {
/*  644 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramString1)).hmac(paramString2);
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
/*      */   @Deprecated
/*      */   public static String hmacSha384Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  661 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
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
/*      */   public static String hmacSha384Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  683 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramArrayOfbyte)).hmacHex(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static String hmacSha384Hex(String paramString1, String paramString2) {
/*  700 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_384, paramString1)).hmacHex(paramString2);
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
/*      */   public static byte[] hmacSha512(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  719 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte1)).hmac(paramArrayOfbyte2);
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
/*      */   public static byte[] hmacSha512(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  741 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte)).hmac(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static byte[] hmacSha512(String paramString1, String paramString2) {
/*  758 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramString1)).hmac(paramString2);
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
/*      */   @Deprecated
/*      */   public static String hmacSha512Hex(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  775 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte1)).hmacHex(paramArrayOfbyte2);
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
/*      */   public static String hmacSha512Hex(byte[] paramArrayOfbyte, InputStream paramInputStream) {
/*  797 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramArrayOfbyte)).hmacHex(paramInputStream);
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
/*      */   @Deprecated
/*      */   public static String hmacSha512Hex(String paramString1, String paramString2) {
/*  814 */     return (new HmacUtils(HmacAlgorithms.HMAC_SHA_512, paramString1)).hmacHex(paramString2);
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
/*      */   public static Mac updateHmac(Mac paramMac, byte[] paramArrayOfbyte) {
/*  831 */     paramMac.reset();
/*  832 */     paramMac.update(paramArrayOfbyte);
/*  833 */     return paramMac;
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
/*      */   public static Mac updateHmac(Mac paramMac, InputStream paramInputStream) {
/*  853 */     paramMac.reset();
/*  854 */     byte[] arrayOfByte = new byte[1024];
/*  855 */     int i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     
/*  857 */     while (i > -1) {
/*  858 */       paramMac.update(arrayOfByte, 0, i);
/*  859 */       i = paramInputStream.read(arrayOfByte, 0, 1024);
/*      */     } 
/*      */     
/*  862 */     return paramMac;
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
/*      */   public static Mac updateHmac(Mac paramMac, String paramString) {
/*  877 */     paramMac.reset();
/*  878 */     paramMac.update(StringUtils.getBytesUtf8(paramString));
/*  879 */     return paramMac;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public HmacUtils() {
/*  889 */     this(null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private HmacUtils(Mac paramMac) {
/*  895 */     this.mac = paramMac;
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
/*      */   public HmacUtils(String paramString, byte[] paramArrayOfbyte) {
/*  908 */     this(getInitializedMac(paramString, paramArrayOfbyte));
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
/*      */   public HmacUtils(String paramString1, String paramString2) {
/*  921 */     this(paramString1, StringUtils.getBytesUtf8(paramString2));
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
/*      */   public HmacUtils(HmacAlgorithms paramHmacAlgorithms, String paramString) {
/*  934 */     this(paramHmacAlgorithms.getName(), StringUtils.getBytesUtf8(paramString));
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
/*      */   public HmacUtils(HmacAlgorithms paramHmacAlgorithms, byte[] paramArrayOfbyte) {
/*  947 */     this(paramHmacAlgorithms.getName(), paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(byte[] paramArrayOfbyte) {
/*  958 */     return this.mac.doFinal(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(byte[] paramArrayOfbyte) {
/*  969 */     return Hex.encodeHexString(hmac(paramArrayOfbyte));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(String paramString) {
/*  980 */     return this.mac.doFinal(StringUtils.getBytesUtf8(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(String paramString) {
/*  991 */     return Hex.encodeHexString(hmac(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] hmac(ByteBuffer paramByteBuffer) {
/* 1002 */     this.mac.update(paramByteBuffer);
/* 1003 */     return this.mac.doFinal();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String hmacHex(ByteBuffer paramByteBuffer) {
/* 1014 */     return Hex.encodeHexString(hmac(paramByteBuffer));
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
/*      */   public byte[] hmac(InputStream paramInputStream) {
/* 1031 */     byte[] arrayOfByte = new byte[1024];
/*      */     
/*      */     int i;
/* 1034 */     while ((i = paramInputStream.read(arrayOfByte, 0, 1024)) > -1) {
/* 1035 */       this.mac.update(arrayOfByte, 0, i);
/*      */     }
/* 1037 */     return this.mac.doFinal();
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
/*      */   public String hmacHex(InputStream paramInputStream) {
/* 1054 */     return Hex.encodeHexString(hmac(paramInputStream));
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
/*      */   public byte[] hmac(File paramFile) {
/* 1067 */     try (BufferedInputStream null = new BufferedInputStream(new FileInputStream(paramFile))) {
/* 1068 */       return hmac(bufferedInputStream);
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
/*      */   public String hmacHex(File paramFile) {
/* 1082 */     return Hex.encodeHexString(hmac(paramFile));
/*      */   }
/*      */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/digest/HmacUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */