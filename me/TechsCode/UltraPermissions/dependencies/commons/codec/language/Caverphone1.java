/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Caverphone1
/*     */   extends AbstractCaverphone
/*     */ {
/*     */   private static final String SIX_1 = "111111";
/*     */   
/*     */   public String encode(String paramString) {
/*  46 */     String str = paramString;
/*  47 */     if (str == null || str.length() == 0) {
/*  48 */       return "111111";
/*     */     }
/*     */ 
/*     */     
/*  52 */     str = str.toLowerCase(Locale.ENGLISH);
/*     */ 
/*     */     
/*  55 */     str = str.replaceAll("[^a-z]", "");
/*     */ 
/*     */ 
/*     */     
/*  59 */     str = str.replaceAll("^cough", "cou2f");
/*  60 */     str = str.replaceAll("^rough", "rou2f");
/*  61 */     str = str.replaceAll("^tough", "tou2f");
/*  62 */     str = str.replaceAll("^enough", "enou2f");
/*  63 */     str = str.replaceAll("^gn", "2n");
/*     */ 
/*     */     
/*  66 */     str = str.replaceAll("mb$", "m2");
/*     */ 
/*     */     
/*  69 */     str = str.replaceAll("cq", "2q");
/*  70 */     str = str.replaceAll("ci", "si");
/*  71 */     str = str.replaceAll("ce", "se");
/*  72 */     str = str.replaceAll("cy", "sy");
/*  73 */     str = str.replaceAll("tch", "2ch");
/*  74 */     str = str.replaceAll("c", "k");
/*  75 */     str = str.replaceAll("q", "k");
/*  76 */     str = str.replaceAll("x", "k");
/*  77 */     str = str.replaceAll("v", "f");
/*  78 */     str = str.replaceAll("dg", "2g");
/*  79 */     str = str.replaceAll("tio", "sio");
/*  80 */     str = str.replaceAll("tia", "sia");
/*  81 */     str = str.replaceAll("d", "t");
/*  82 */     str = str.replaceAll("ph", "fh");
/*  83 */     str = str.replaceAll("b", "p");
/*  84 */     str = str.replaceAll("sh", "s2");
/*  85 */     str = str.replaceAll("z", "s");
/*  86 */     str = str.replaceAll("^[aeiou]", "A");
/*     */     
/*  88 */     str = str.replaceAll("[aeiou]", "3");
/*  89 */     str = str.replaceAll("3gh3", "3kh3");
/*  90 */     str = str.replaceAll("gh", "22");
/*  91 */     str = str.replaceAll("g", "k");
/*  92 */     str = str.replaceAll("s+", "S");
/*  93 */     str = str.replaceAll("t+", "T");
/*  94 */     str = str.replaceAll("p+", "P");
/*  95 */     str = str.replaceAll("k+", "K");
/*  96 */     str = str.replaceAll("f+", "F");
/*  97 */     str = str.replaceAll("m+", "M");
/*  98 */     str = str.replaceAll("n+", "N");
/*  99 */     str = str.replaceAll("w3", "W3");
/* 100 */     str = str.replaceAll("wy", "Wy");
/* 101 */     str = str.replaceAll("wh3", "Wh3");
/* 102 */     str = str.replaceAll("why", "Why");
/* 103 */     str = str.replaceAll("w", "2");
/* 104 */     str = str.replaceAll("^h", "A");
/* 105 */     str = str.replaceAll("h", "2");
/* 106 */     str = str.replaceAll("r3", "R3");
/* 107 */     str = str.replaceAll("ry", "Ry");
/* 108 */     str = str.replaceAll("r", "2");
/* 109 */     str = str.replaceAll("l3", "L3");
/* 110 */     str = str.replaceAll("ly", "Ly");
/* 111 */     str = str.replaceAll("l", "2");
/* 112 */     str = str.replaceAll("j", "y");
/* 113 */     str = str.replaceAll("y3", "Y3");
/* 114 */     str = str.replaceAll("y", "2");
/*     */ 
/*     */     
/* 117 */     str = str.replaceAll("2", "");
/* 118 */     str = str.replaceAll("3", "");
/*     */ 
/*     */     
/* 121 */     str = str + "111111";
/*     */ 
/*     */     
/* 124 */     return str.substring(0, "111111".length());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/Caverphone1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */