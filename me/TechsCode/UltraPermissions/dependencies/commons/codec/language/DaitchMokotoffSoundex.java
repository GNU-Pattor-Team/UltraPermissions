/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.codec.language;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Scanner;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.EncoderException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.codec.StringEncoder;
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
/*     */ public class DaitchMokotoffSoundex
/*     */   implements StringEncoder
/*     */ {
/*     */   private static final String COMMENT = "//";
/*     */   private static final String DOUBLE_QUOTE = "\"";
/*     */   private static final String MULTILINE_COMMENT_END = "*/";
/*     */   private static final String MULTILINE_COMMENT_START = "/*";
/*     */   private static final String RESOURCE_FILE = "me/TechsCode/UltraPermissions/dependencies/commons/codec/language/dmrules.txt";
/*     */   private static final int MAX_LENGTH = 6;
/*     */   
/*     */   private static final class Branch
/*     */   {
/*  83 */     private final StringBuilder builder = new StringBuilder();
/*  84 */     private String lastReplacement = null;
/*  85 */     private String cachedString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Branch createBranch() {
/*  94 */       Branch branch = new Branch();
/*  95 */       branch.builder.append(toString());
/*  96 */       branch.lastReplacement = this.lastReplacement;
/*  97 */       return branch;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 102 */       if (this == param1Object) {
/* 103 */         return true;
/*     */       }
/* 105 */       if (!(param1Object instanceof Branch)) {
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       return toString().equals(((Branch)param1Object).toString());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void finish() {
/* 116 */       while (this.builder.length() < 6) {
/* 117 */         this.builder.append('0');
/* 118 */         this.cachedString = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 124 */       return toString().hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void processNextReplacement(String param1String, boolean param1Boolean) {
/* 136 */       boolean bool = (this.lastReplacement == null || !this.lastReplacement.endsWith(param1String) || param1Boolean) ? true : false;
/*     */       
/* 138 */       if (bool && this.builder.length() < 6) {
/* 139 */         this.builder.append(param1String);
/*     */         
/* 141 */         if (this.builder.length() > 6) {
/* 142 */           this.builder.delete(6, this.builder.length());
/*     */         }
/* 144 */         this.cachedString = null;
/*     */       } 
/*     */       
/* 147 */       this.lastReplacement = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 152 */       if (this.cachedString == null) {
/* 153 */         this.cachedString = this.builder.toString();
/*     */       }
/* 155 */       return this.cachedString;
/*     */     }
/*     */ 
/*     */     
/*     */     private Branch() {}
/*     */   }
/*     */   
/*     */   private static final class Rule
/*     */   {
/*     */     private final String pattern;
/*     */     private final String[] replacementAtStart;
/*     */     private final String[] replacementBeforeVowel;
/*     */     private final String[] replacementDefault;
/*     */     
/*     */     protected Rule(String param1String1, String param1String2, String param1String3, String param1String4) {
/* 170 */       this.pattern = param1String1;
/* 171 */       this.replacementAtStart = param1String2.split("\\|");
/* 172 */       this.replacementBeforeVowel = param1String3.split("\\|");
/* 173 */       this.replacementDefault = param1String4.split("\\|");
/*     */     }
/*     */     
/*     */     public int getPatternLength() {
/* 177 */       return this.pattern.length();
/*     */     }
/*     */     
/*     */     public String[] getReplacements(String param1String, boolean param1Boolean) {
/* 181 */       if (param1Boolean) {
/* 182 */         return this.replacementAtStart;
/*     */       }
/*     */       
/* 185 */       int i = getPatternLength();
/* 186 */       boolean bool = (i < param1String.length()) ? isVowel(param1String.charAt(i)) : false;
/* 187 */       if (bool) {
/* 188 */         return this.replacementBeforeVowel;
/*     */       }
/*     */       
/* 191 */       return this.replacementDefault;
/*     */     }
/*     */     
/*     */     private boolean isVowel(char param1Char) {
/* 195 */       return (param1Char == 'a' || param1Char == 'e' || param1Char == 'i' || param1Char == 'o' || param1Char == 'u');
/*     */     }
/*     */     
/*     */     public boolean matches(String param1String) {
/* 199 */       return param1String.startsWith(this.pattern);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 204 */       return String.format("%s=(%s,%s,%s)", new Object[] { this.pattern, Arrays.asList(this.replacementAtStart), 
/* 205 */             Arrays.asList(this.replacementBeforeVowel), Arrays.asList(this.replacementDefault) });
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
/* 223 */   private static final Map<Character, List<Rule>> RULES = new HashMap<>();
/*     */ 
/*     */   
/* 226 */   private static final Map<Character, Character> FOLDINGS = new HashMap<>(); private final boolean folding;
/*     */   
/*     */   static {
/* 229 */     InputStream inputStream = DaitchMokotoffSoundex.class.getClassLoader().getResourceAsStream("me/TechsCode/UltraPermissions/dependencies/commons/codec/language/dmrules.txt");
/* 230 */     if (inputStream == null) {
/* 231 */       throw new IllegalArgumentException("Unable to load resource: org/apache/commons/codec/language/dmrules.txt");
/*     */     }
/*     */     
/* 234 */     try (Scanner null = new Scanner(inputStream, "UTF-8")) {
/* 235 */       parseRules(scanner, "me/TechsCode/UltraPermissions/dependencies/commons/codec/language/dmrules.txt", RULES, FOLDINGS);
/*     */     } 
/*     */ 
/*     */     
/* 239 */     for (Map.Entry<Character, List<Rule>> entry : RULES.entrySet()) {
/* 240 */       List<?> list = (List)entry.getValue();
/* 241 */       Collections.sort(list, new Comparator<Rule>()
/*     */           {
/*     */             public int compare(DaitchMokotoffSoundex.Rule param1Rule1, DaitchMokotoffSoundex.Rule param1Rule2) {
/* 244 */               return param1Rule2.getPatternLength() - param1Rule1.getPatternLength();
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void parseRules(Scanner paramScanner, String paramString, Map<Character, List<Rule>> paramMap, Map<Character, Character> paramMap1) {
/* 252 */     byte b = 0;
/* 253 */     boolean bool = false;
/*     */     
/* 255 */     while (paramScanner.hasNextLine()) {
/* 256 */       b++;
/* 257 */       String str1 = paramScanner.nextLine();
/* 258 */       String str2 = str1;
/*     */       
/* 260 */       if (bool) {
/* 261 */         if (str2.endsWith("*/")) {
/* 262 */           bool = false;
/*     */         }
/*     */         
/*     */         continue;
/*     */       } 
/* 267 */       if (str2.startsWith("/*")) {
/* 268 */         bool = true;
/*     */         continue;
/*     */       } 
/* 271 */       int i = str2.indexOf("//");
/* 272 */       if (i >= 0) {
/* 273 */         str2 = str2.substring(0, i);
/*     */       }
/*     */ 
/*     */       
/* 277 */       str2 = str2.trim();
/*     */       
/* 279 */       if (str2.length() == 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 283 */       if (str2.contains("=")) {
/*     */         
/* 285 */         String[] arrayOfString1 = str2.split("=");
/* 286 */         if (arrayOfString1.length != 2) {
/* 287 */           throw new IllegalArgumentException("Malformed folding statement split into " + arrayOfString1.length + " parts: " + str1 + " in " + paramString);
/*     */         }
/*     */         
/* 290 */         String str3 = arrayOfString1[0];
/* 291 */         String str4 = arrayOfString1[1];
/*     */         
/* 293 */         if (str3.length() != 1 || str4.length() != 1) {
/* 294 */           throw new IllegalArgumentException("Malformed folding statement - patterns are not single characters: " + str1 + " in " + paramString);
/*     */         }
/*     */ 
/*     */         
/* 298 */         paramMap1.put(Character.valueOf(str3.charAt(0)), Character.valueOf(str4.charAt(0)));
/*     */         continue;
/*     */       } 
/* 301 */       String[] arrayOfString = str2.split("\\s+");
/* 302 */       if (arrayOfString.length != 4) {
/* 303 */         throw new IllegalArgumentException("Malformed rule statement split into " + arrayOfString.length + " parts: " + str1 + " in " + paramString);
/*     */       }
/*     */       
/*     */       try {
/* 307 */         String str3 = stripQuotes(arrayOfString[0]);
/* 308 */         String str4 = stripQuotes(arrayOfString[1]);
/* 309 */         String str5 = stripQuotes(arrayOfString[2]);
/* 310 */         String str6 = stripQuotes(arrayOfString[3]);
/*     */         
/* 312 */         Rule rule = new Rule(str3, str4, str5, str6);
/* 313 */         char c = rule.pattern.charAt(0);
/* 314 */         List<Rule> list = paramMap.get(Character.valueOf(c));
/* 315 */         if (list == null) {
/* 316 */           list = new ArrayList();
/* 317 */           paramMap.put(Character.valueOf(c), list);
/*     */         } 
/* 319 */         list.add(rule);
/* 320 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 321 */         throw new IllegalStateException("Problem parsing line '" + b + "' in " + paramString, illegalArgumentException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String stripQuotes(String paramString) {
/* 330 */     if (paramString.startsWith("\"")) {
/* 331 */       paramString = paramString.substring(1);
/*     */     }
/*     */     
/* 334 */     if (paramString.endsWith("\"")) {
/* 335 */       paramString = paramString.substring(0, paramString.length() - 1);
/*     */     }
/*     */     
/* 338 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DaitchMokotoffSoundex() {
/* 348 */     this(true);
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
/*     */   public DaitchMokotoffSoundex(boolean paramBoolean) {
/* 362 */     this.folding = paramBoolean;
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
/*     */   private String cleanup(String paramString) {
/* 376 */     StringBuilder stringBuilder = new StringBuilder();
/* 377 */     for (char c : paramString.toCharArray()) {
/* 378 */       if (!Character.isWhitespace(c)) {
/*     */ 
/*     */ 
/*     */         
/* 382 */         c = Character.toLowerCase(c);
/* 383 */         if (this.folding && FOLDINGS.containsKey(Character.valueOf(c))) {
/* 384 */           c = ((Character)FOLDINGS.get(Character.valueOf(c))).charValue();
/*     */         }
/* 386 */         stringBuilder.append(c);
/*     */       } 
/* 388 */     }  return stringBuilder.toString();
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
/*     */   public Object encode(Object paramObject) {
/* 411 */     if (!(paramObject instanceof String)) {
/* 412 */       throw new EncoderException("Parameter supplied to DaitchMokotoffSoundex encode is not of type java.lang.String");
/*     */     }
/*     */     
/* 415 */     return encode((String)paramObject);
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
/*     */   public String encode(String paramString) {
/* 431 */     if (paramString == null) {
/* 432 */       return null;
/*     */     }
/* 434 */     return soundex(paramString, false)[0];
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
/*     */   public String soundex(String paramString) {
/* 461 */     String[] arrayOfString = soundex(paramString, true);
/* 462 */     StringBuilder stringBuilder = new StringBuilder();
/* 463 */     byte b = 0;
/* 464 */     for (String str : arrayOfString) {
/* 465 */       stringBuilder.append(str);
/* 466 */       if (++b < arrayOfString.length) {
/* 467 */         stringBuilder.append('|');
/*     */       }
/*     */     } 
/* 470 */     return stringBuilder.toString();
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
/*     */   private String[] soundex(String paramString, boolean paramBoolean) {
/* 484 */     if (paramString == null) {
/* 485 */       return null;
/*     */     }
/*     */     
/* 488 */     String str = cleanup(paramString);
/*     */     
/* 490 */     LinkedHashSet<Branch> linkedHashSet = new LinkedHashSet();
/* 491 */     linkedHashSet.add(new Branch());
/*     */     
/* 493 */     char c = Character.MIN_VALUE;
/* 494 */     for (int i = 0; i < str.length(); i++) {
/* 495 */       char c1 = str.charAt(i);
/*     */ 
/*     */       
/* 498 */       if (!Character.isWhitespace(c1)) {
/*     */ 
/*     */ 
/*     */         
/* 502 */         String str1 = str.substring(i);
/* 503 */         List list = RULES.get(Character.valueOf(c1));
/* 504 */         if (list != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 510 */           List<Branch> list1 = paramBoolean ? new ArrayList() : Collections.EMPTY_LIST;
/*     */           
/* 512 */           for (Rule rule : list) {
/* 513 */             if (rule.matches(str1)) {
/* 514 */               if (paramBoolean) {
/* 515 */                 list1.clear();
/*     */               }
/* 517 */               String[] arrayOfString1 = rule.getReplacements(str1, !c);
/* 518 */               boolean bool = (arrayOfString1.length > 1 && paramBoolean) ? true : false;
/*     */               
/* 520 */               for (Branch branch : linkedHashSet) {
/* 521 */                 String[] arrayOfString2; int j; byte b1; for (arrayOfString2 = arrayOfString1, j = arrayOfString2.length, b1 = 0; b1 < j; ) { String str2 = arrayOfString2[b1];
/*     */                   
/* 523 */                   Branch branch1 = bool ? branch.createBranch() : branch;
/*     */ 
/*     */                   
/* 526 */                   boolean bool1 = ((c == 'm' && c1 == 'n') || (c == 'n' && c1 == 'm')) ? true : false;
/*     */                   
/* 528 */                   branch1.processNextReplacement(str2, bool1);
/*     */                   
/* 530 */                   if (paramBoolean) {
/* 531 */                     list1.add(branch1);
/*     */                     
/*     */                     b1++;
/*     */                   }  }
/*     */               
/*     */               } 
/*     */               
/* 538 */               if (paramBoolean) {
/* 539 */                 linkedHashSet.clear();
/* 540 */                 linkedHashSet.addAll(list1);
/*     */               } 
/* 542 */               i += rule.getPatternLength() - 1;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 547 */           c = c1;
/*     */         } 
/*     */       } 
/* 550 */     }  String[] arrayOfString = new String[linkedHashSet.size()];
/* 551 */     byte b = 0;
/* 552 */     for (Branch branch : linkedHashSet) {
/* 553 */       branch.finish();
/* 554 */       arrayOfString[b++] = branch.toString();
/*     */     } 
/*     */     
/* 557 */     return arrayOfString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/language/DaitchMokotoffSoundex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */