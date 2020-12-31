/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.exception;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NestableError
/*     */   extends Error
/*     */   implements Nestable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  43 */   protected NestableDelegate delegate = new NestableDelegate(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private Throwable cause = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NestableError() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NestableError(String paramString) {
/*  66 */     super(paramString);
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
/*     */   public NestableError(Throwable paramThrowable) {
/*  78 */     this.cause = paramThrowable;
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
/*     */   public NestableError(String paramString, Throwable paramThrowable) {
/*  90 */     super(paramString);
/*  91 */     this.cause = paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getCause() {
/*  98 */     return this.cause;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 109 */     if (super.getMessage() != null)
/* 110 */       return super.getMessage(); 
/* 111 */     if (this.cause != null) {
/* 112 */       return this.cause.toString();
/*     */     }
/* 114 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage(int paramInt) {
/* 122 */     if (paramInt == 0) {
/* 123 */       return super.getMessage();
/*     */     }
/* 125 */     return this.delegate.getMessage(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getMessages() {
/* 132 */     return this.delegate.getMessages();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getThrowable(int paramInt) {
/* 139 */     return this.delegate.getThrowable(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThrowableCount() {
/* 146 */     return this.delegate.getThrowableCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable[] getThrowables() {
/* 153 */     return this.delegate.getThrowables();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOfThrowable(Class paramClass) {
/* 160 */     return this.delegate.indexOfThrowable(paramClass, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOfThrowable(Class paramClass, int paramInt) {
/* 167 */     return this.delegate.indexOfThrowable(paramClass, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/* 174 */     this.delegate.printStackTrace();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintStream paramPrintStream) {
/* 181 */     this.delegate.printStackTrace(paramPrintStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/* 188 */     this.delegate.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void printPartialStackTrace(PrintWriter paramPrintWriter) {
/* 195 */     super.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/exception/NestableError.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */