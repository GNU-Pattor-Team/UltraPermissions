/*     */ package me.TechsCode.UltraPermissions.base.visual;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ 
/*     */ public class Animation {
/*  11 */   private static HashMap<String, List<String>> animationCache = new HashMap<>();
/*     */   
/*     */   public static String wave(String paramString, Color... paramVarArgs) {
/*  14 */     return wave(paramString, true, 5, 10, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String wave(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, Color... paramVarArgs) {
/*  18 */     Preconditions.checkArgument((paramVarArgs.length > 1), "Not enough colors provided");
/*     */     
/*  20 */     String str = "wave-" + paramString + "-" + paramBoolean + "-" + paramInt1 + "-" + paramInt2 + "-" + (String)Arrays.<Color>stream(paramVarArgs).map(Color::getColorCode).collect(Collectors.joining("-"));
/*     */     
/*  22 */     if (animationCache.containsKey(str)) {
/*  23 */       return currentFrame(animationCache.get(str));
/*     */     }
/*     */     
/*  26 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  28 */     byte b = 0;
/*  29 */     for (Color color1 : paramVarArgs) {
/*  30 */       Color color2 = paramVarArgs[(paramVarArgs.length == b + 1) ? 0 : (b + 1)];
/*     */ 
/*     */       
/*  33 */       arrayList.addAll(Collections.nCopies(paramInt1, color1.getAppliedTag() + (paramBoolean ? "§l" : "") + paramString));
/*     */ 
/*     */       
/*  36 */       ArrayList<String> arrayList1 = new ArrayList();
/*  37 */       arrayList1.addAll(Collections.nCopies(paramString.length(), color1.getAppliedTag()));
/*  38 */       arrayList1.addAll((Collection)ColorCalculations.getColorsInbetween(color1, color2, paramInt2).stream().map(Color::getAppliedTag).collect(Collectors.toList()));
/*  39 */       arrayList1.addAll(Collections.nCopies(paramString.length(), color2.getAppliedTag()));
/*  40 */       for (byte b1 = 0; b1 <= arrayList1.size() - paramString.length(); b1++) {
/*  41 */         StringBuilder stringBuilder = new StringBuilder();
/*     */         
/*  43 */         byte b2 = 0;
/*  44 */         for (char c : paramString.toCharArray()) {
/*  45 */           String str1 = arrayList1.get(b2 + b1);
/*  46 */           stringBuilder.append(str1).append(paramBoolean ? "§l" : "").append(c);
/*  47 */           b2++;
/*     */         } 
/*     */         
/*  50 */         arrayList.add(stringBuilder.toString());
/*     */       } 
/*     */ 
/*     */       
/*  54 */       arrayList.addAll(Collections.nCopies(paramInt1, color2.getAppliedTag() + (paramBoolean ? "§l" : "") + paramString));
/*     */       
/*  56 */       b++;
/*     */     } 
/*     */     
/*  59 */     animationCache.put(str, arrayList);
/*     */     
/*  61 */     return currentFrame(arrayList);
/*     */   }
/*     */   
/*     */   public static String fading(String paramString, Color... paramVarArgs) {
/*  65 */     return fading(paramString, true, 10, 20, paramVarArgs);
/*     */   }
/*     */   
/*     */   public static String fading(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, Color... paramVarArgs) {
/*  69 */     Preconditions.checkArgument((paramVarArgs.length > 1), "Not enough colors provided");
/*     */     
/*  71 */     String str = "fading-" + paramString + "-" + paramBoolean + "-" + paramInt1 + "-" + paramInt2 + "-" + (String)Arrays.<Color>stream(paramVarArgs).map(Color::getColorCode).collect(Collectors.joining("-"));
/*     */     
/*  73 */     if (animationCache.containsKey(str)) {
/*  74 */       return currentFrame(animationCache.get(str));
/*     */     }
/*     */     
/*  77 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  79 */     byte b = 0;
/*  80 */     for (Color color1 : paramVarArgs) {
/*  81 */       Color color2 = paramVarArgs[(paramVarArgs.length == b + 1) ? 0 : (b + 1)];
/*     */ 
/*     */       
/*  84 */       arrayList.addAll(Collections.nCopies(paramInt1, color1.getAppliedTag() + (paramBoolean ? "§l" : "") + paramString));
/*     */ 
/*     */       
/*  87 */       for (Color color : ColorCalculations.getColorsInbetween(color1, color2, paramInt2)) {
/*  88 */         arrayList.add(color.getAppliedTag() + (paramBoolean ? "§l" : "") + paramString);
/*     */       }
/*     */       
/*  91 */       b++;
/*     */     } 
/*     */     
/*  94 */     animationCache.put(str, arrayList);
/*     */     
/*  96 */     return currentFrame(arrayList);
/*     */   }
/*     */   
/*     */   private static String currentFrame(List<String> paramList) {
/* 100 */     long l = System.currentTimeMillis() / 50L;
/* 101 */     int i = (int)(l % paramList.size());
/*     */     
/* 103 */     return paramList.get(i);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/visual/Animation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */