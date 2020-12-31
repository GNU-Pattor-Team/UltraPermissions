/*     */ package me.TechsCode.UltraPermissions.dependencies.slf4j.helpers;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MessageFormatter
/*     */ {
/*     */   static final char DELIM_START = '{';
/*     */   static final char DELIM_STOP = '}';
/*     */   static final String DELIM_STR = "{}";
/*     */   private static final char ESCAPE_CHAR = '\\';
/*     */   
/*     */   public static final FormattingTuple format(String paramString, Object paramObject) {
/* 124 */     return arrayFormat(paramString, new Object[] { paramObject });
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
/*     */   public static final FormattingTuple format(String paramString, Object paramObject1, Object paramObject2) {
/* 151 */     return arrayFormat(paramString, new Object[] { paramObject1, paramObject2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static final FormattingTuple arrayFormat(String paramString, Object[] paramArrayOfObject) {
/* 156 */     Throwable throwable = getThrowableCandidate(paramArrayOfObject);
/* 157 */     Object[] arrayOfObject = paramArrayOfObject;
/* 158 */     if (throwable != null) {
/* 159 */       arrayOfObject = trimmedCopy(paramArrayOfObject);
/*     */     }
/* 161 */     return arrayFormat(paramString, arrayOfObject, throwable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String basicArrayFormat(String paramString, Object[] paramArrayOfObject) {
/* 171 */     FormattingTuple formattingTuple = arrayFormat(paramString, paramArrayOfObject, null);
/* 172 */     return formattingTuple.getMessage();
/*     */   }
/*     */   
/*     */   public static String basicArrayFormat(NormalizedParameters paramNormalizedParameters) {
/* 176 */     return basicArrayFormat(paramNormalizedParameters.getMessage(), paramNormalizedParameters.getArguments());
/*     */   }
/*     */ 
/*     */   
/*     */   public static final FormattingTuple arrayFormat(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 181 */     if (paramString == null) {
/* 182 */       return new FormattingTuple(null, paramArrayOfObject, paramThrowable);
/*     */     }
/*     */     
/* 185 */     if (paramArrayOfObject == null) {
/* 186 */       return new FormattingTuple(paramString);
/*     */     }
/*     */     
/* 189 */     int i = 0;
/*     */ 
/*     */     
/* 192 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() + 50);
/*     */ 
/*     */     
/* 195 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*     */       
/* 197 */       int j = paramString.indexOf("{}", i);
/*     */       
/* 199 */       if (j == -1) {
/*     */         
/* 201 */         if (!i) {
/* 202 */           return new FormattingTuple(paramString, paramArrayOfObject, paramThrowable);
/*     */         }
/*     */         
/* 205 */         stringBuilder.append(paramString, i, paramString.length());
/* 206 */         return new FormattingTuple(stringBuilder.toString(), paramArrayOfObject, paramThrowable);
/*     */       } 
/*     */       
/* 209 */       if (isEscapedDelimeter(paramString, j)) {
/* 210 */         if (!isDoubleEscaped(paramString, j)) {
/* 211 */           b--;
/* 212 */           stringBuilder.append(paramString, i, j - 1);
/* 213 */           stringBuilder.append('{');
/* 214 */           i = j + 1;
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 219 */           stringBuilder.append(paramString, i, j - 1);
/* 220 */           deeplyAppendParameter(stringBuilder, paramArrayOfObject[b], (Map)new HashMap<>());
/* 221 */           i = j + 2;
/*     */         } 
/*     */       } else {
/*     */         
/* 225 */         stringBuilder.append(paramString, i, j);
/* 226 */         deeplyAppendParameter(stringBuilder, paramArrayOfObject[b], (Map)new HashMap<>());
/* 227 */         i = j + 2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 232 */     stringBuilder.append(paramString, i, paramString.length());
/* 233 */     return new FormattingTuple(stringBuilder.toString(), paramArrayOfObject, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   static final boolean isEscapedDelimeter(String paramString, int paramInt) {
/* 238 */     if (paramInt == 0) {
/* 239 */       return false;
/*     */     }
/* 241 */     char c = paramString.charAt(paramInt - 1);
/* 242 */     if (c == '\\') {
/* 243 */       return true;
/*     */     }
/* 245 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static final boolean isDoubleEscaped(String paramString, int paramInt) {
/* 250 */     if (paramInt >= 2 && paramString.charAt(paramInt - 2) == '\\') {
/* 251 */       return true;
/*     */     }
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void deeplyAppendParameter(StringBuilder paramStringBuilder, Object paramObject, Map<Object[], Object> paramMap) {
/* 259 */     if (paramObject == null) {
/* 260 */       paramStringBuilder.append("null");
/*     */       return;
/*     */     } 
/* 263 */     if (!paramObject.getClass().isArray()) {
/* 264 */       safeObjectAppend(paramStringBuilder, paramObject);
/*     */ 
/*     */     
/*     */     }
/* 268 */     else if (paramObject instanceof boolean[]) {
/* 269 */       booleanArrayAppend(paramStringBuilder, (boolean[])paramObject);
/* 270 */     } else if (paramObject instanceof byte[]) {
/* 271 */       byteArrayAppend(paramStringBuilder, (byte[])paramObject);
/* 272 */     } else if (paramObject instanceof char[]) {
/* 273 */       charArrayAppend(paramStringBuilder, (char[])paramObject);
/* 274 */     } else if (paramObject instanceof short[]) {
/* 275 */       shortArrayAppend(paramStringBuilder, (short[])paramObject);
/* 276 */     } else if (paramObject instanceof int[]) {
/* 277 */       intArrayAppend(paramStringBuilder, (int[])paramObject);
/* 278 */     } else if (paramObject instanceof long[]) {
/* 279 */       longArrayAppend(paramStringBuilder, (long[])paramObject);
/* 280 */     } else if (paramObject instanceof float[]) {
/* 281 */       floatArrayAppend(paramStringBuilder, (float[])paramObject);
/* 282 */     } else if (paramObject instanceof double[]) {
/* 283 */       doubleArrayAppend(paramStringBuilder, (double[])paramObject);
/*     */     } else {
/* 285 */       objectArrayAppend(paramStringBuilder, (Object[])paramObject, paramMap);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void safeObjectAppend(StringBuilder paramStringBuilder, Object paramObject) {
/*     */     try {
/* 292 */       String str = paramObject.toString();
/* 293 */       paramStringBuilder.append(str);
/* 294 */     } catch (Throwable throwable) {
/* 295 */       Util.report("SLF4J: Failed toString() invocation on an object of type [" + paramObject.getClass().getName() + "]", throwable);
/* 296 */       paramStringBuilder.append("[FAILED toString()]");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void objectArrayAppend(StringBuilder paramStringBuilder, Object[] paramArrayOfObject, Map<Object[], Object> paramMap) {
/* 302 */     paramStringBuilder.append('[');
/* 303 */     if (!paramMap.containsKey(paramArrayOfObject)) {
/* 304 */       paramMap.put(paramArrayOfObject, null);
/* 305 */       int i = paramArrayOfObject.length;
/* 306 */       for (byte b = 0; b < i; b++) {
/* 307 */         deeplyAppendParameter(paramStringBuilder, paramArrayOfObject[b], paramMap);
/* 308 */         if (b != i - 1) {
/* 309 */           paramStringBuilder.append(", ");
/*     */         }
/*     */       } 
/* 312 */       paramMap.remove(paramArrayOfObject);
/*     */     } else {
/* 314 */       paramStringBuilder.append("...");
/*     */     } 
/* 316 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void booleanArrayAppend(StringBuilder paramStringBuilder, boolean[] paramArrayOfboolean) {
/* 320 */     paramStringBuilder.append('[');
/* 321 */     int i = paramArrayOfboolean.length;
/* 322 */     for (byte b = 0; b < i; b++) {
/* 323 */       paramStringBuilder.append(paramArrayOfboolean[b]);
/* 324 */       if (b != i - 1)
/* 325 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 327 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void byteArrayAppend(StringBuilder paramStringBuilder, byte[] paramArrayOfbyte) {
/* 331 */     paramStringBuilder.append('[');
/* 332 */     int i = paramArrayOfbyte.length;
/* 333 */     for (byte b = 0; b < i; b++) {
/* 334 */       paramStringBuilder.append(paramArrayOfbyte[b]);
/* 335 */       if (b != i - 1)
/* 336 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 338 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void charArrayAppend(StringBuilder paramStringBuilder, char[] paramArrayOfchar) {
/* 342 */     paramStringBuilder.append('[');
/* 343 */     int i = paramArrayOfchar.length;
/* 344 */     for (byte b = 0; b < i; b++) {
/* 345 */       paramStringBuilder.append(paramArrayOfchar[b]);
/* 346 */       if (b != i - 1)
/* 347 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 349 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void shortArrayAppend(StringBuilder paramStringBuilder, short[] paramArrayOfshort) {
/* 353 */     paramStringBuilder.append('[');
/* 354 */     int i = paramArrayOfshort.length;
/* 355 */     for (byte b = 0; b < i; b++) {
/* 356 */       paramStringBuilder.append(paramArrayOfshort[b]);
/* 357 */       if (b != i - 1)
/* 358 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 360 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void intArrayAppend(StringBuilder paramStringBuilder, int[] paramArrayOfint) {
/* 364 */     paramStringBuilder.append('[');
/* 365 */     int i = paramArrayOfint.length;
/* 366 */     for (byte b = 0; b < i; b++) {
/* 367 */       paramStringBuilder.append(paramArrayOfint[b]);
/* 368 */       if (b != i - 1)
/* 369 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 371 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void longArrayAppend(StringBuilder paramStringBuilder, long[] paramArrayOflong) {
/* 375 */     paramStringBuilder.append('[');
/* 376 */     int i = paramArrayOflong.length;
/* 377 */     for (byte b = 0; b < i; b++) {
/* 378 */       paramStringBuilder.append(paramArrayOflong[b]);
/* 379 */       if (b != i - 1)
/* 380 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 382 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void floatArrayAppend(StringBuilder paramStringBuilder, float[] paramArrayOffloat) {
/* 386 */     paramStringBuilder.append('[');
/* 387 */     int i = paramArrayOffloat.length;
/* 388 */     for (byte b = 0; b < i; b++) {
/* 389 */       paramStringBuilder.append(paramArrayOffloat[b]);
/* 390 */       if (b != i - 1)
/* 391 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 393 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void doubleArrayAppend(StringBuilder paramStringBuilder, double[] paramArrayOfdouble) {
/* 397 */     paramStringBuilder.append('[');
/* 398 */     int i = paramArrayOfdouble.length;
/* 399 */     for (byte b = 0; b < i; b++) {
/* 400 */       paramStringBuilder.append(paramArrayOfdouble[b]);
/* 401 */       if (b != i - 1)
/* 402 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 404 */     paramStringBuilder.append(']');
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
/*     */   public static Throwable getThrowableCandidate(Object[] paramArrayOfObject) {
/* 416 */     return NormalizedParameters.getThrowableCandidate(paramArrayOfObject);
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
/*     */   public static Object[] trimmedCopy(Object[] paramArrayOfObject) {
/* 428 */     return NormalizedParameters.trimmedCopy(paramArrayOfObject);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/helpers/MessageFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */