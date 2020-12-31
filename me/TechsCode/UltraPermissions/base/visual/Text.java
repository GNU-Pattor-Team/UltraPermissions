/*    */ package me.TechsCode.UltraPermissions.base.visual;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import java.util.ArrayList;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Text
/*    */ {
/* 12 */   private static final Pattern HEX_COLOR_PATTERN = Pattern.compile("\\{#[0-9A-Fa-f]{6}}");
/* 13 */   private static final Pattern STRIP_CHAT_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]");
/*    */   
/*    */   public static String stripHexColor(String paramString) {
/* 16 */     return paramString.replaceAll(HEX_COLOR_PATTERN.pattern(), "");
/*    */   }
/*    */   
/*    */   public static String stripChatColor(String paramString) {
/* 20 */     return paramString.replaceAll(STRIP_CHAT_COLOR_PATTERN.pattern(), "");
/*    */   }
/*    */   
/*    */   public static String stripColor(String paramString) {
/* 24 */     return stripHexColor(stripChatColor(paramString));
/*    */   }
/*    */   
/*    */   public static String color(String paramString) {
/* 28 */     return chatColor(hexColor(paramString));
/*    */   }
/*    */   
/*    */   public static String chatColor(String paramString) {
/* 32 */     Preconditions.checkArgument((paramString != null), "A text must be defined");
/*    */     
/* 34 */     char[] arrayOfChar = paramString.toCharArray();
/*    */     
/* 36 */     for (byte b = 0; b < arrayOfChar.length - 1; b++) {
/* 37 */       if (arrayOfChar[b] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(arrayOfChar[b + 1]) > -1) {
/* 38 */         arrayOfChar[b] = '§';
/* 39 */         arrayOfChar[b + 1] = Character.toLowerCase(arrayOfChar[b + 1]);
/*    */       } 
/*    */     } 
/*    */     
/* 43 */     return new String(arrayOfChar);
/*    */   }
/*    */   
/*    */   public static String hexColor(String paramString) {
/* 47 */     Preconditions.checkArgument((paramString != null), "A text must be defined");
/*    */     
/* 49 */     Matcher matcher = HEX_COLOR_PATTERN.matcher(paramString);
/*    */     
/* 51 */     while (matcher.find()) {
/* 52 */       String str1 = matcher.group();
/*    */ 
/*    */ 
/*    */       
/* 56 */       String str2 = str1.replace("{#", "").replace("}", "");
/*    */       
/* 58 */       paramString = paramString.replace(str1, Color.from(str2).getAppliedTag());
/*    */     } 
/*    */     
/* 61 */     return paramString;
/*    */   }
/*    */   
/*    */   public static String gradient(String paramString, Color... paramVarArgs) {
/* 65 */     Preconditions.checkArgument((paramVarArgs.length > 1), "Define 2 or more colors");
/*    */     
/* 67 */     int i = Math.max(1, paramString.length() / paramVarArgs.length);
/*    */     
/* 69 */     ArrayList<Color> arrayList = new ArrayList();
/*    */     
/* 71 */     byte b = 0;
/* 72 */     for (Color color1 : paramVarArgs) {
/* 73 */       Color color2 = (paramVarArgs.length == b + 1) ? null : paramVarArgs[b + 1];
/*    */       
/* 75 */       if (color2 != null) {
/* 76 */         arrayList.addAll(ColorCalculations.getColorsInbetween(color1, color2, i));
/*    */       }
/*    */       
/* 79 */       b++;
/*    */     } 
/* 81 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 83 */     b = 0;
/* 84 */     for (char c : paramString.toCharArray()) {
/* 85 */       Color color = (arrayList.size() <= b) ? arrayList.get(arrayList.size() - 1) : arrayList.get(b);
/* 86 */       stringBuilder.append(color.getAppliedTag()).append(c);
/*    */       
/* 88 */       b++;
/*    */     } 
/*    */     
/* 91 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public static String firstUpperCase(String paramString) {
/* 95 */     return paramString.substring(0, 1).toUpperCase() + paramString.substring(1).toLowerCase();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/visual/Text.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */