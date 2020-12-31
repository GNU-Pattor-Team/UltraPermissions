/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.util.Map;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.NOPMDCAdapter;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.helpers.Util;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.MDCAdapter;
/*     */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.SLF4JServiceProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MDC
/*     */ {
/*     */   static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
/*     */   static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
/*     */   static MDCAdapter mdcAdapter;
/*     */   
/*     */   public static class MDCCloseable
/*     */     implements Closeable
/*     */   {
/*     */     private final String key;
/*     */     
/*     */     private MDCCloseable(String param1String) {
/*  77 */       this.key = param1String;
/*     */     }
/*     */     
/*     */     public void close() {
/*  81 */       MDC.remove(this.key);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  89 */     SLF4JServiceProvider sLF4JServiceProvider = LoggerFactory.getProvider();
/*  90 */     if (sLF4JServiceProvider != null) {
/*  91 */       mdcAdapter = sLF4JServiceProvider.getMDCAdapter();
/*     */     } else {
/*  93 */       Util.report("Failed to find provider.");
/*  94 */       Util.report("Defaulting to no-operation MDCAdapter implementation.");
/*  95 */       mdcAdapter = (MDCAdapter)new NOPMDCAdapter();
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
/*     */   public static void put(String paramString1, String paramString2) {
/* 115 */     if (paramString1 == null) {
/* 116 */       throw new IllegalArgumentException("key parameter cannot be null");
/*     */     }
/* 118 */     if (mdcAdapter == null) {
/* 119 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 121 */     mdcAdapter.put(paramString1, paramString2);
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
/*     */   public static MDCCloseable putCloseable(String paramString1, String paramString2) {
/* 153 */     put(paramString1, paramString2);
/* 154 */     return new MDCCloseable(paramString1);
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
/*     */   public static String get(String paramString) {
/* 170 */     if (paramString == null) {
/* 171 */       throw new IllegalArgumentException("key parameter cannot be null");
/*     */     }
/*     */     
/* 174 */     if (mdcAdapter == null) {
/* 175 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 177 */     return mdcAdapter.get(paramString);
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
/*     */   public static void remove(String paramString) {
/* 191 */     if (paramString == null) {
/* 192 */       throw new IllegalArgumentException("key parameter cannot be null");
/*     */     }
/*     */     
/* 195 */     if (mdcAdapter == null) {
/* 196 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 198 */     mdcAdapter.remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clear() {
/* 205 */     if (mdcAdapter == null) {
/* 206 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 208 */     mdcAdapter.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, String> getCopyOfContextMap() {
/* 219 */     if (mdcAdapter == null) {
/* 220 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 222 */     return mdcAdapter.getCopyOfContextMap();
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
/*     */   public static void setContextMap(Map<String, String> paramMap) {
/* 235 */     if (mdcAdapter == null) {
/* 236 */       throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
/*     */     }
/* 238 */     mdcAdapter.setContextMap(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MDCAdapter getMDCAdapter() {
/* 248 */     return mdcAdapter;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/MDC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */