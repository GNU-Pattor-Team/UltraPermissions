/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharSet
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5947847346149275958L;
/*  53 */   public static final CharSet EMPTY = new CharSet((String)null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final CharSet ASCII_ALPHA = new CharSet("a-zA-Z");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   public static final CharSet ASCII_ALPHA_LOWER = new CharSet("a-z");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final CharSet ASCII_ALPHA_UPPER = new CharSet("A-Z");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public static final CharSet ASCII_NUMERIC = new CharSet("0-9");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   protected static final Map COMMON = Collections.synchronizedMap(new HashMap());
/*     */   
/*     */   static {
/*  87 */     COMMON.put(null, EMPTY);
/*  88 */     COMMON.put("", EMPTY);
/*  89 */     COMMON.put("a-zA-Z", ASCII_ALPHA);
/*  90 */     COMMON.put("A-Za-z", ASCII_ALPHA);
/*  91 */     COMMON.put("a-z", ASCII_ALPHA_LOWER);
/*  92 */     COMMON.put("A-Z", ASCII_ALPHA_UPPER);
/*  93 */     COMMON.put("0-9", ASCII_NUMERIC);
/*     */   }
/*     */ 
/*     */   
/*  97 */   private final Set set = Collections.synchronizedSet(new HashSet());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSet getInstance(String paramString) {
/* 144 */     Object object = COMMON.get(paramString);
/* 145 */     if (object != null) {
/* 146 */       return (CharSet)object;
/*     */     }
/* 148 */     return new CharSet(paramString);
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
/*     */   public static CharSet getInstance(String[] paramArrayOfString) {
/* 160 */     if (paramArrayOfString == null) {
/* 161 */       return null;
/*     */     }
/* 163 */     return new CharSet(paramArrayOfString);
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
/*     */   protected CharSet(String paramString) {
/* 175 */     add(paramString);
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
/*     */   protected CharSet(String[] paramArrayOfString) {
/* 187 */     int i = paramArrayOfString.length;
/* 188 */     for (byte b = 0; b < i; b++) {
/* 189 */       add(paramArrayOfString[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void add(String paramString) {
/* 200 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/* 204 */     int i = paramString.length();
/* 205 */     byte b = 0;
/* 206 */     while (b < i) {
/* 207 */       int j = i - b;
/* 208 */       if (j >= 4 && paramString.charAt(b) == '^' && paramString.charAt(b + 2) == '-') {
/*     */         
/* 210 */         this.set.add(CharRange.isNotIn(paramString.charAt(b + 1), paramString.charAt(b + 3)));
/* 211 */         b += 4; continue;
/* 212 */       }  if (j >= 3 && paramString.charAt(b + 1) == '-') {
/*     */         
/* 214 */         this.set.add(CharRange.isIn(paramString.charAt(b), paramString.charAt(b + 2)));
/* 215 */         b += 3; continue;
/* 216 */       }  if (j >= 2 && paramString.charAt(b) == '^') {
/*     */         
/* 218 */         this.set.add(CharRange.isNot(paramString.charAt(b + 1)));
/* 219 */         b += 2;
/*     */         continue;
/*     */       } 
/* 222 */       this.set.add(CharRange.is(paramString.charAt(b)));
/* 223 */       b++;
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
/*     */   public CharRange[] getCharRanges() {
/* 236 */     return (CharRange[])this.set.toArray((Object[])new CharRange[this.set.size()]);
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
/*     */   public boolean contains(char paramChar) {
/* 248 */     for (CharRange charRange : this.set) {
/*     */       
/* 250 */       if (charRange.contains(paramChar)) {
/* 251 */         return true;
/*     */       }
/*     */     } 
/* 254 */     return false;
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
/*     */   public boolean equals(Object paramObject) {
/* 271 */     if (paramObject == this) {
/* 272 */       return true;
/*     */     }
/* 274 */     if (!(paramObject instanceof CharSet)) {
/* 275 */       return false;
/*     */     }
/* 277 */     CharSet charSet = (CharSet)paramObject;
/* 278 */     return this.set.equals(charSet.set);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 288 */     return 89 + this.set.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 297 */     return this.set.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/CharSet.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */