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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NestableRuntimeException
/*     */   extends RuntimeException
/*     */   implements Nestable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  47 */   protected NestableDelegate delegate = new NestableDelegate(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private Throwable cause = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NestableRuntimeException() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NestableRuntimeException(String paramString) {
/*  70 */     super(paramString);
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
/*     */   public NestableRuntimeException(Throwable paramThrowable) {
/*  82 */     this.cause = paramThrowable;
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
/*     */   public NestableRuntimeException(String paramString, Throwable paramThrowable) {
/*  94 */     super(paramString);
/*  95 */     this.cause = paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getCause() {
/* 102 */     return this.cause;
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
/* 113 */     if (super.getMessage() != null)
/* 114 */       return super.getMessage(); 
/* 115 */     if (this.cause != null) {
/* 116 */       return this.cause.toString();
/*     */     }
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage(int paramInt) {
/* 126 */     if (paramInt == 0) {
/* 127 */       return super.getMessage();
/*     */     }
/* 129 */     return this.delegate.getMessage(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getMessages() {
/* 136 */     return this.delegate.getMessages();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getThrowable(int paramInt) {
/* 143 */     return this.delegate.getThrowable(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThrowableCount() {
/* 150 */     return this.delegate.getThrowableCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable[] getThrowables() {
/* 157 */     return this.delegate.getThrowables();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOfThrowable(Class paramClass) {
/* 164 */     return this.delegate.indexOfThrowable(paramClass, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOfThrowable(Class paramClass, int paramInt) {
/* 171 */     return this.delegate.indexOfThrowable(paramClass, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/* 178 */     this.delegate.printStackTrace();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintStream paramPrintStream) {
/* 185 */     this.delegate.printStackTrace(paramPrintStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/* 192 */     this.delegate.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void printPartialStackTrace(PrintWriter paramPrintWriter) {
/* 199 */     super.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/exception/NestableRuntimeException.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */