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
/*     */ public class Caverphone2
/*     */   extends AbstractCaverphone
/*     */ {
/*     */   private static final String TEN_1 = "1111111111";
/*     */   
/*     */   public String encode(String paramString) {
/*  46 */     String str = paramString;
/*  47 */     if (str == null || str.length() == 0) {
/*  48 */       return "1111111111";
/*     */     }
/*     */ 
/*     */     
/*  52 */     str = str.toLowerCase(Locale.ENGLISH);
/*     */ 
/*     */     
/*  55 */     str = str.replaceAll("[^a-z]", "");
/*     */ 
/*     */     
/*  58 */     str = str.replaceAll("e$", "");
/*     */ 
/*     */     
/*  61 */     str = str.replaceAll("^cough", "cou2f");
/*  62 */     str = str.replaceAll("^rough", "rou2f");
/*  63 */     str = str.replaceAll("^tough", "tou2f");
/*  64 */     str = str.replaceAll("^enough", "enou2f");
/*  65 */     str = str.replaceAll("^trough", "trou2f");
/*     */     
/*  67 */     str = str.replaceAll("^gn", "2n");
/*     */ 
/*     */     
/*  70 */     str = str.replaceAll("mb$", "m2");
/*     */ 
/*     */     
/*  73 */     str = str.replaceAll("cq", "2q");
/*  74 */     str = str.replaceAll("ci", "si");
/*  75 */     str = str.replaceAll("ce", "se");
/*  76 */     str = str.replaceAll("cy", "sy");
/*  77 */     str = str.replaceAll("tch", "2ch");
/*  78 */     str = str.replaceAll("c", "k");
/*  79 */     str = str.replaceAll("q", "k");
/*  80 */     str = str.replaceAll("x", "k");
/*  81 */     str = str.replaceAll("v", "f");
/*  82 */     str = str.replaceAll("dg", "2g");
/*  83 */     str = str.replaceAll("tio", "sio");
/*  84 */     str = str.replaceAll("tia", "sia");
/*  85 */     str = str.replaceAll("d", "t");
/*  86 */     str = str.replaceAll("ph", "fh");
/*  87 */     str = str.replaceAll("b", "p");
/*  88 */     str = str.replaceAll("sh", "s2");
/*  89 */     str = str.replaceAll("z", "s");
/*  90 */     str = str.replaceAll("^[aeiou]", "A");
/*  91 */     str = str.replaceAll("[aeiou]", "3");
/*  92 */     str = str.replaceAll("j", "y");
/*  93 */     str = str.replaceAll("^y3", "Y3");
/*  94 */     str = str.replaceAll("^y", "A");
/*  95 */     str = str.replaceAll("y", "3");
/*  96 */     str = str.replaceAll("3gh3", "3kh3");
/*  97 */     str = str.replaceAll("gh", "22");
/*  98 */     str = str.replaceAll("g", "k");
/*  99 */     str = str.replaceAll("s+", "S");
/* 100 */     str = str.replaceAll("t+", "T");
/* 101 */     str = str.replaceAll("p+", "P");
/* 102 */     str = str.replaceAll("k+", "K");
/* 103 */     str = str.replaceAll("f+", "F");
/* 104 */     str = str.replaceAll("m+", "M");
/* 105 */     str = str.replaceAll("n+", "N");
/* 106 */     str = str.replaceAll("w3", "W3");
/* 107 */     str = str.replaceAll("wh3", "Wh3");
/* 108 */     str = str.replaceAll("w$", "3");
/* 109 */     str = str.replaceAll("w", "2");
/* 110 */     str = str.replaceAll("^h", "A");
/* 111 */     str = str.replaceAll("h", "2");
/* 112 */     str = str.replaceAll("r3", "R3");
/* 113 */     str = str.replaceAll("r$", "3");
/* 114 */     str = str.replaceAll("r", "2");
/* 115 */     str = str.replaceAll("l3", "L3");
/* 116 */     str = str.replaceAll("l$", "3");
/* 117 */     str = str.replaceAll("l", "2");
/*     */ 
/*     */     
/* 120 */     str = str.replaceAll("2", "");
/* 121 */     str = str.replaceAll("3$", "A");
/* 122 */     str = str.replaceAll("3", "");
/*     */ 
/*     */     
/* 125 */     str = str + "1111111111";
/*     */ 
/*     */     
/* 128 */     return str.substring(0, "1111111111".length());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/Caverphone2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */