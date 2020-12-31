/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.exception;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Serializable;
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NestableDelegate
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
/*  68 */   private Throwable nestable = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean topDown = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean trimStackFrames = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean matchSubclasses = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NestableDelegate(Nestable paramNestable) {
/* 109 */     if (paramNestable instanceof Throwable) {
/* 110 */       this.nestable = (Throwable)paramNestable;
/*     */     } else {
/* 112 */       throw new IllegalArgumentException("The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable");
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
/*     */   public String getMessage(int paramInt) {
/* 130 */     Throwable throwable = getThrowable(paramInt);
/* 131 */     if (Nestable.class.isInstance(throwable)) {
/* 132 */       return ((Nestable)throwable).getMessage(0);
/*     */     }
/* 134 */     return throwable.getMessage();
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
/*     */   public String getMessage(String paramString) {
/* 148 */     Throwable throwable = ExceptionUtils.getCause(this.nestable);
/* 149 */     String str = (throwable == null) ? null : throwable.getMessage();
/* 150 */     if (throwable == null || str == null) {
/* 151 */       return paramString;
/*     */     }
/* 153 */     if (paramString == null) {
/* 154 */       return str;
/*     */     }
/* 156 */     return paramString + ": " + str;
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
/*     */   public String[] getMessages() {
/* 169 */     Throwable[] arrayOfThrowable = getThrowables();
/* 170 */     String[] arrayOfString = new String[arrayOfThrowable.length];
/* 171 */     for (byte b = 0; b < arrayOfThrowable.length; b++) {
/* 172 */       arrayOfString[b] = Nestable.class.isInstance(arrayOfThrowable[b]) ? ((Nestable)arrayOfThrowable[b]).getMessage(0) : arrayOfThrowable[b].getMessage();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 177 */     return arrayOfString;
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
/*     */   public Throwable getThrowable(int paramInt) {
/* 193 */     if (paramInt == 0) {
/* 194 */       return this.nestable;
/*     */     }
/* 196 */     Throwable[] arrayOfThrowable = getThrowables();
/* 197 */     return arrayOfThrowable[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThrowableCount() {
/* 208 */     return ExceptionUtils.getThrowableCount(this.nestable);
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
/*     */   public Throwable[] getThrowables() {
/* 220 */     return ExceptionUtils.getThrowables(this.nestable);
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
/*     */   public int indexOfThrowable(Class paramClass, int paramInt) {
/* 248 */     if (paramClass == null) {
/* 249 */       return -1;
/*     */     }
/* 251 */     if (paramInt < 0) {
/* 252 */       throw new IndexOutOfBoundsException("The start index was out of bounds: " + paramInt);
/*     */     }
/* 254 */     Throwable[] arrayOfThrowable = ExceptionUtils.getThrowables(this.nestable);
/* 255 */     if (paramInt >= arrayOfThrowable.length) {
/* 256 */       throw new IndexOutOfBoundsException("The start index was out of bounds: " + paramInt + " >= " + arrayOfThrowable.length);
/*     */     }
/*     */     
/* 259 */     if (matchSubclasses) {
/* 260 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/* 261 */         if (paramClass.isAssignableFrom(arrayOfThrowable[i].getClass())) {
/* 262 */           return i;
/*     */         }
/*     */       } 
/*     */     } else {
/* 266 */       for (int i = paramInt; i < arrayOfThrowable.length; i++) {
/* 267 */         if (paramClass.equals(arrayOfThrowable[i].getClass())) {
/* 268 */           return i;
/*     */         }
/*     */       } 
/*     */     } 
/* 272 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/* 280 */     printStackTrace(System.err);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintStream paramPrintStream) {
/* 291 */     synchronized (paramPrintStream) {
/* 292 */       PrintWriter printWriter = new PrintWriter(paramPrintStream, false);
/* 293 */       printStackTrace(printWriter);
/*     */       
/* 295 */       printWriter.flush();
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
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/* 311 */     Throwable throwable = this.nestable;
/*     */     
/* 313 */     if (ExceptionUtils.isThrowableNested()) {
/* 314 */       if (throwable instanceof Nestable) {
/* 315 */         ((Nestable)throwable).printPartialStackTrace(paramPrintWriter);
/*     */       } else {
/* 317 */         throwable.printStackTrace(paramPrintWriter);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 323 */     ArrayList arrayList = new ArrayList();
/* 324 */     while (throwable != null) {
/* 325 */       String[] arrayOfString = getStackFrames(throwable);
/* 326 */       arrayList.add(arrayOfString);
/* 327 */       throwable = ExceptionUtils.getCause(throwable);
/*     */     } 
/*     */ 
/*     */     
/* 331 */     String str = "Caused by: ";
/* 332 */     if (!topDown) {
/* 333 */       str = "Rethrown as: ";
/* 334 */       Collections.reverse(arrayList);
/*     */     } 
/*     */ 
/*     */     
/* 338 */     if (trimStackFrames) {
/* 339 */       trimStackFrames(arrayList);
/*     */     }
/*     */     
/* 342 */     synchronized (paramPrintWriter) {
/* 343 */       for (Iterator iterator = arrayList.iterator(); iterator.hasNext(); ) {
/* 344 */         String[] arrayOfString = (String[])iterator.next(); byte b; int i;
/* 345 */         for (b = 0, i = arrayOfString.length; b < i; b++) {
/* 346 */           paramPrintWriter.println(arrayOfString[b]);
/*     */         }
/* 348 */         if (iterator.hasNext()) {
/* 349 */           paramPrintWriter.print(str);
/*     */         }
/*     */       } 
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
/*     */   protected String[] getStackFrames(Throwable paramThrowable) {
/* 365 */     StringWriter stringWriter = new StringWriter();
/* 366 */     PrintWriter printWriter = new PrintWriter(stringWriter, true);
/*     */ 
/*     */     
/* 369 */     if (paramThrowable instanceof Nestable) {
/* 370 */       ((Nestable)paramThrowable).printPartialStackTrace(printWriter);
/*     */     } else {
/* 372 */       paramThrowable.printStackTrace(printWriter);
/*     */     } 
/* 374 */     return ExceptionUtils.getStackFrames(stringWriter.getBuffer().toString());
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
/*     */   protected void trimStackFrames(List paramList) {
/* 386 */     for (int i = paramList.size(), j = i - 1; j > 0; j--) {
/* 387 */       String[] arrayOfString1 = paramList.get(j);
/* 388 */       String[] arrayOfString2 = paramList.get(j - 1);
/*     */       
/* 390 */       ArrayList arrayList = new ArrayList(Arrays.asList((Object[])arrayOfString1));
/* 391 */       ArrayList arrayList1 = new ArrayList(Arrays.asList((Object[])arrayOfString2));
/* 392 */       ExceptionUtils.removeCommonFrames(arrayList, arrayList1);
/*     */       
/* 394 */       int k = arrayOfString1.length - arrayList.size();
/* 395 */       if (k > 0) {
/* 396 */         arrayList.add("\t... " + k + " more");
/* 397 */         paramList.set(j, arrayList.toArray(new String[arrayList.size()]));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/exception/NestableDelegate.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */