/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.exception.Nestable;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.exception.NestableDelegate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NotImplementedException
/*     */   extends UnsupportedOperationException
/*     */   implements Nestable
/*     */ {
/*     */   private static final String DEFAULT_MESSAGE = "Code is not implemented";
/*     */   private static final long serialVersionUID = -6894122266938754088L;
/*  67 */   private NestableDelegate delegate = new NestableDelegate(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Throwable cause;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NotImplementedException() {
/*  82 */     super("Code is not implemented");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NotImplementedException(String paramString) {
/*  92 */     super((paramString == null) ? "Code is not implemented" : paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NotImplementedException(Throwable paramThrowable) {
/* 103 */     super("Code is not implemented");
/* 104 */     this.cause = paramThrowable;
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
/*     */   public NotImplementedException(String paramString, Throwable paramThrowable) {
/* 116 */     super((paramString == null) ? "Code is not implemented" : paramString);
/* 117 */     this.cause = paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NotImplementedException(Class paramClass) {
/* 127 */     super((paramClass == null) ? "Code is not implemented" : ("Code is not implemented in " + paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getCause() {
/* 138 */     return this.cause;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 148 */     if (super.getMessage() != null)
/* 149 */       return super.getMessage(); 
/* 150 */     if (this.cause != null) {
/* 151 */       return this.cause.toString();
/*     */     }
/* 153 */     return null;
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
/*     */   public String getMessage(int paramInt) {
/* 169 */     if (paramInt == 0) {
/* 170 */       return super.getMessage();
/*     */     }
/* 172 */     return this.delegate.getMessage(paramInt);
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
/*     */   public String[] getMessages() {
/* 184 */     return this.delegate.getMessages();
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
/*     */   public Throwable getThrowable(int paramInt) {
/* 197 */     return this.delegate.getThrowable(paramInt);
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
/* 208 */     return this.delegate.getThrowableCount();
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
/* 220 */     return this.delegate.getThrowables();
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
/*     */   public int indexOfThrowable(Class paramClass) {
/* 233 */     return this.delegate.indexOfThrowable(paramClass, 0);
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
/*     */   public int indexOfThrowable(Class paramClass, int paramInt) {
/* 249 */     return this.delegate.indexOfThrowable(paramClass, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/* 259 */     this.delegate.printStackTrace();
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
/* 270 */     this.delegate.printStackTrace(paramPrintStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/* 281 */     this.delegate.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void printPartialStackTrace(PrintWriter paramPrintWriter) {
/* 292 */     super.printStackTrace(paramPrintWriter);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/NotImplementedException.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */