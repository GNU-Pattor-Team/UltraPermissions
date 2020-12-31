/*     */ package me.TechsCode.UltraPermissions.base.legacy;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.IntStream;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Words;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class Tools
/*     */ {
/*     */   public static String getNumberString(long paramLong) {
/*  21 */     DecimalFormat decimalFormat = new DecimalFormat("#,###");
/*  22 */     return decimalFormat.format(paramLong);
/*     */   }
/*     */   
/*     */   public static String getNumberString(double paramDouble) {
/*  26 */     DecimalFormat decimalFormat = new DecimalFormat("#,###");
/*  27 */     return decimalFormat.format(paramDouble);
/*     */   }
/*     */   
/*     */   public static String getNumberString(float paramFloat) {
/*  31 */     DecimalFormat decimalFormat = new DecimalFormat("#,###");
/*  32 */     return decimalFormat.format(paramFloat);
/*     */   }
/*     */   
/*     */   public static String readableFileSize(long paramLong) {
/*  36 */     if (paramLong <= 0L) return "0"; 
/*  37 */     String[] arrayOfString = { "B", "kB", "MB", "GB", "TB" };
/*  38 */     int i = (int)(Math.log10(paramLong) / Math.log10(1024.0D));
/*  39 */     return (new DecimalFormat("#,##0.#")).format(paramLong / Math.pow(1024.0D, i)) + " " + arrayOfString[i];
/*     */   }
/*     */   
/*     */   public static String[] splitCamelCase(String paramString) {
/*  43 */     return paramString.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
/*     */   }
/*     */   
/*     */   public static String firstUpperCase(String paramString) {
/*  47 */     return paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
/*     */   }
/*     */   
/*     */   public static String[] lineSplitter(String paramString, int paramInt) {
/*  51 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  53 */     String str = "";
/*  54 */     for (String str1 : paramString.split(" ")) {
/*  55 */       str = str.trim();
/*     */       
/*  57 */       if (str.length() + str1.length() > paramInt) {
/*  58 */         arrayList.add(str);
/*  59 */         str = "";
/*     */       } 
/*     */       
/*  62 */       str = str + " " + str1;
/*     */     } 
/*     */     
/*  65 */     str = str.trim();
/*     */     
/*  67 */     if (str.length() != 0) {
/*  68 */       arrayList.add(str);
/*     */     }
/*     */     
/*  71 */     return arrayList.<String>toArray(new String[0]);
/*     */   }
/*     */   
/*     */   public static String removeEofsAndLineBreakers(String paramString) {
/*  75 */     if (paramString == null || paramString.length() == 0) {
/*  76 */       return paramString;
/*     */     }
/*  78 */     int i = paramString.length();
/*  79 */     char[] arrayOfChar = new char[i];
/*  80 */     byte b1 = 0;
/*  81 */     byte b2 = 0;
/*  82 */     boolean bool = true;
/*     */     
/*  84 */     for (byte b3 = 0; b3 < i; b3++) {
/*  85 */       char c = paramString.charAt(b3);
/*  86 */       boolean bool1 = Character.isWhitespace(c);
/*  87 */       if (!bool1) {
/*  88 */         bool = false;
/*  89 */         arrayOfChar[b1++] = (c == ' ') ? ' ' : c;
/*  90 */         b2 = 0;
/*     */       } else {
/*  92 */         if (!b2 && !bool) {
/*  93 */           arrayOfChar[b1++] = " ".charAt(0);
/*     */         }
/*     */         
/*  96 */         b2++;
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     if (bool) {
/* 101 */       return "";
/*     */     }
/* 103 */     return (new String(arrayOfChar, 0, b1 - ((b2 > 0) ? 1 : 0))).trim();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getEnumName(Enum<?> paramEnum) {
/* 110 */     return String.join(" ", (Iterable<? extends CharSequence>)Arrays.<String>stream(paramEnum.name().split("_")).map(paramString -> paramString.toUpperCase().charAt(0) + paramString.toLowerCase().substring(1)).collect(Collectors.toCollection(ArrayList::new)));
/*     */   }
/*     */   
/*     */   public static String getSecretPassword(String paramString) {
/* 114 */     return String.join("", Collections.nCopies(paramString.length(), "*"));
/*     */   }
/*     */   
/*     */   public static String getTimeString(long paramLong) {
/* 118 */     return getTimeString(paramLong, TimeUnit.SECONDS);
/*     */   }
/*     */   
/*     */   public static String getTimeString(long paramLong, TimeUnit paramTimeUnit) {
/* 122 */     return getTimeString(paramLong, paramTimeUnit, 0);
/*     */   }
/*     */   
/*     */   public static String getTimeString(long paramLong, TimeUnit paramTimeUnit, int paramInt) {
/* 126 */     paramLong = paramTimeUnit.toSeconds(paramLong);
/*     */     
/* 128 */     if (paramLong < 1L) return "Now";
/*     */     
/* 130 */     long l1 = TimeUnit.SECONDS.toDays(paramLong);
/* 131 */     paramLong -= TimeUnit.DAYS.toSeconds(l1);
/*     */     
/* 133 */     long l2 = TimeUnit.SECONDS.toHours(paramLong);
/* 134 */     paramLong -= TimeUnit.HOURS.toSeconds(l2);
/*     */     
/* 136 */     long l3 = TimeUnit.SECONDS.toMinutes(paramLong);
/* 137 */     paramLong -= TimeUnit.MINUTES.toSeconds(l3);
/*     */     
/* 139 */     long l4 = TimeUnit.SECONDS.toSeconds(paramLong);
/*     */     
/* 141 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 143 */     if (l1 != 0L) {
/* 144 */       Phrase phrase = (l1 == 1L) ? Words.DAY : Words.DAYS;
/* 145 */       arrayList.add(l1 + " " + phrase.firstUpper());
/*     */     } 
/*     */     
/* 148 */     if (l2 != 0L) {
/* 149 */       Phrase phrase = (l2 == 1L) ? Words.HOUR : Words.HOURS;
/* 150 */       arrayList.add(l2 + " " + phrase.firstUpper());
/*     */     } 
/*     */     
/* 153 */     if (l3 != 0L) {
/* 154 */       Phrase phrase = (l3 == 1L) ? Words.MINUTE : Words.MINUTES;
/* 155 */       arrayList.add(l3 + " " + phrase.firstUpper());
/*     */     } 
/*     */     
/* 158 */     if (l4 != 0L) {
/* 159 */       Phrase phrase = (l4 == 1L) ? Words.SECOND : Words.SECONDS;
/* 160 */       arrayList.add(l4 + " " + phrase.firstUpper());
/*     */     } 
/*     */     
/* 163 */     if (paramInt != 0) {
/* 164 */       while (arrayList.size() > paramInt) {
/* 165 */         arrayList.remove(arrayList.size() - 1);
/*     */       }
/*     */     }
/*     */     
/* 169 */     return String.join(", ", (Iterable)arrayList);
/*     */   }
/*     */   
/*     */   public static File exportFile(String paramString, boolean paramBoolean, SpigotTechPlugin paramSpigotTechPlugin) {
/* 173 */     File file = new File(paramSpigotTechPlugin.getPluginFolder() + "/" + paramString);
/* 174 */     if (paramBoolean || !file.exists()) {
/* 175 */       ((JavaPlugin)paramSpigotTechPlugin.getBootstrap()).saveResource(paramString, paramBoolean);
/*     */     }
/* 177 */     return file;
/*     */   }
/*     */   
/*     */   public static String getProgressBar(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3) {
/* 181 */     float f = paramInt1 / paramInt2;
/*     */     
/* 183 */     int i = (int)(paramInt3 * f);
/*     */     
/* 185 */     int j = paramInt3 - i;
/*     */     
/* 187 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 189 */     stringBuilder.append(Text.chatColor(paramString2));
/* 190 */     IntStream.range(0, i).mapToObj(paramInt -> paramString).forEach(stringBuilder::append);
/*     */     
/* 192 */     stringBuilder.append(Text.chatColor(paramString3));
/* 193 */     IntStream.range(0, j).mapToObj(paramInt -> paramString).forEach(stringBuilder::append);
/* 194 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static long getTimeSecondsFromString(String paramString) {
/* 198 */     long l = 0L;
/*     */     
/* 200 */     for (String str : paramString.split(" ")) {
/* 201 */       l += getTimeFromWord(str);
/*     */     }
/*     */     
/* 204 */     return l;
/*     */   }
/*     */   
/*     */   private static long getTimeFromWord(String paramString) {
/*     */     try {
/* 209 */       if (paramString.length() < 2) {
/* 210 */         return 0L;
/*     */       }
/*     */       
/* 213 */       String str = "" + paramString.toCharArray()[paramString.length() - 1];
/* 214 */       int i = Integer.valueOf(paramString.substring(0, paramString.length() - 1)).intValue();
/*     */       
/* 216 */       TimeUnit[] arrayOfTimeUnit = { TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES, TimeUnit.SECONDS };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 225 */       TimeUnit timeUnit = Arrays.<TimeUnit>stream(arrayOfTimeUnit).filter(paramTimeUnit -> paramTimeUnit.toString().toLowerCase().startsWith(paramString)).findFirst().orElse(null);
/*     */       
/* 227 */       if (timeUnit == null) {
/* 228 */         return 0L;
/*     */       }
/*     */       
/* 231 */       return timeUnit.toSeconds(i);
/* 232 */     } catch (NumberFormatException numberFormatException) {
/* 233 */       return 0L;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/Tools.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */