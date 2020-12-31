/*     */ package me.TechsCode.UltraPermissions.dependencies.hikari.util;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import java.util.concurrent.atomic.LongAdder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Sequence
/*     */ {
/*     */   void increment();
/*     */   
/*     */   long get();
/*     */   
/*     */   public static final class Factory
/*     */   {
/*     */     public static Sequence create() {
/*     */       try {
/*  53 */         if (Sequence.class.getClassLoader().loadClass("java.util.concurrent.atomic.LongAdder") != null && !Boolean.getBoolean("me.TechsCode.UltraPermissions.dependencies.hikari.useAtomicLongSequence")) {
/*  54 */           return new Sequence.Java8Sequence();
/*     */         }
/*     */       }
/*  57 */       catch (ClassNotFoundException classNotFoundException) {
/*     */         try {
/*  59 */           Class<?> clazz = Sequence.class.getClassLoader().loadClass("com.codahale.metrics.LongAdder");
/*  60 */           return new Sequence.DropwizardSequence(clazz);
/*     */         }
/*  62 */         catch (Exception exception) {}
/*     */       } 
/*     */ 
/*     */       
/*  66 */       return new Sequence.Java7Sequence();
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Java7Sequence
/*     */     extends AtomicLong
/*     */     implements Sequence {
/*     */     public void increment() {
/*  74 */       incrementAndGet();
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Java8Sequence
/*     */     extends LongAdder implements Sequence {
/*     */     public long get() {
/*  81 */       return sum();
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class DropwizardSequence implements Sequence {
/*     */     private final Object longAdder;
/*     */     private final Method increment;
/*     */     private final Method sum;
/*     */     
/*     */     public DropwizardSequence(Class<?> param1Class) {
/*  91 */       Constructor<?> constructor = param1Class.getDeclaredConstructors()[0];
/*  92 */       constructor.setAccessible(true);
/*  93 */       this.increment = param1Class.getMethod("increment", new Class[0]);
/*  94 */       this.increment.setAccessible(true);
/*  95 */       this.sum = param1Class.getMethod("sum", new Class[0]);
/*  96 */       this.sum.setAccessible(true);
/*  97 */       this.longAdder = constructor.newInstance(new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void increment() {
/*     */       try {
/* 104 */         this.increment.invoke(this.longAdder, new Object[0]);
/*     */       }
/* 106 */       catch (IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/* 107 */         throw new RuntimeException(illegalAccessException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public long get() {
/*     */       try {
/* 115 */         return ((Long)this.sum.invoke(this.longAdder, new Object[0])).longValue();
/*     */       }
/* 117 */       catch (IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/* 118 */         throw new RuntimeException(illegalAccessException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/hikari/util/Sequence.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */