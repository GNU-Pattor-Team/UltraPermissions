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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NestableException
/*     */   extends Exception
/*     */   implements Nestable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/* 103 */   protected NestableDelegate delegate = new NestableDelegate(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   private Throwable cause = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NestableException() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NestableException(String paramString) {
/* 126 */     super(paramString);
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
/*     */   public NestableException(Throwable paramThrowable) {
/* 138 */     this.cause = paramThrowable;
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
/*     */   public NestableException(String paramString, Throwable paramThrowable) {
/* 150 */     super(paramString);
/* 151 */     this.cause = paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getCause() {
/* 158 */     return this.cause;
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
/* 169 */     if (super.getMessage() != null)
/* 170 */       return super.getMessage(); 
/* 171 */     if (this.cause != null) {
/* 172 */       return this.cause.toString();
/*     */     }
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage(int paramInt) {
/* 182 */     if (paramInt == 0) {
/* 183 */       return super.getMessage();
/*     */     }
/* 185 */     return this.delegate.getMessage(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getMessages() {
/* 192 */     return this.delegate.getMessages();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getThrowable(int paramInt) {
/* 199 */     return this.delegate.getThrowable(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThrowableCount() {
/* 206 */     return this.delegate.getThrowableCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable[] getThrowables() {
/* 213 */     return this.delegate.getThrowables();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOfThrowable(Class paramClass) {
/* 220 */     return this.delegate.indexOfThrowable(paramClass, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOfThrowable(Class paramClass, int paramInt) {
/* 227 */     return this.delegate.indexOfThrowable(paramClass, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/* 234 */     this.delegate.printStackTrace();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintStream paramPrintStream) {
/* 241 */     this.delegate.printStackTrace(paramPrintStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/* 248 */     this.delegate.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void printPartialStackTrace(PrintWriter paramPrintWriter) {
/* 255 */     super.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/exception/NestableException.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */