/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaggedIOException
/*     */   extends IOExceptionWithCause
/*     */ {
/*     */   private static final long serialVersionUID = -6994123481142850163L;
/*     */   private final Serializable tag;
/*     */   
/*     */   public static boolean isTaggedWith(Throwable paramThrowable, Object paramObject) {
/*  66 */     return (paramObject != null && paramThrowable instanceof TaggedIOException && paramObject
/*     */       
/*  68 */       .equals(((TaggedIOException)paramThrowable).tag));
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
/*     */   public static void throwCauseIfTaggedWith(Throwable paramThrowable, Object paramObject) {
/*  95 */     if (isTaggedWith(paramThrowable, paramObject)) {
/*  96 */       throw ((TaggedIOException)paramThrowable).getCause();
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
/*     */   public TaggedIOException(IOException paramIOException, Serializable paramSerializable) {
/* 112 */     super(paramIOException.getMessage(), paramIOException);
/* 113 */     this.tag = paramSerializable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Serializable getTag() {
/* 122 */     return this.tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOException getCause() {
/* 133 */     return (IOException)super.getCause();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/TaggedIOException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */