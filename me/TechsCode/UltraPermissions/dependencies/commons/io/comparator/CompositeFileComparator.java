/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.io.comparator;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
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
/*     */ public class CompositeFileComparator
/*     */   extends AbstractFileComparator
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2224170307287243428L;
/*  47 */   private static final Comparator<?>[] NO_COMPARATORS = (Comparator<?>[])new Comparator[0];
/*     */ 
/*     */ 
/*     */   
/*     */   private final Comparator<File>[] delegates;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeFileComparator(Comparator<File>... paramVarArgs) {
/*  57 */     if (paramVarArgs == null) {
/*  58 */       this.delegates = (Comparator<File>[])NO_COMPARATORS;
/*     */     } else {
/*  60 */       this.delegates = (Comparator<File>[])new Comparator[paramVarArgs.length];
/*  61 */       System.arraycopy(paramVarArgs, 0, this.delegates, 0, paramVarArgs.length);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeFileComparator(Iterable<Comparator<File>> paramIterable) {
/*  72 */     if (paramIterable == null) {
/*  73 */       this.delegates = (Comparator<File>[])NO_COMPARATORS;
/*     */     } else {
/*  75 */       ArrayList<Comparator> arrayList = new ArrayList();
/*  76 */       for (Comparator<File> comparator : paramIterable) {
/*  77 */         arrayList.add(comparator);
/*     */       }
/*  79 */       this.delegates = arrayList.<Comparator<File>>toArray((Comparator<File>[])new Comparator[arrayList.size()]);
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
/*     */   public int compare(File paramFile1, File paramFile2) {
/*  93 */     int i = 0;
/*  94 */     for (Comparator<File> comparator : this.delegates) {
/*  95 */       i = comparator.compare(paramFile1, paramFile2);
/*  96 */       if (i != 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 100 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuilder stringBuilder = new StringBuilder();
/* 111 */     stringBuilder.append(super.toString());
/* 112 */     stringBuilder.append('{');
/* 113 */     for (byte b = 0; b < this.delegates.length; b++) {
/* 114 */       if (b > 0) {
/* 115 */         stringBuilder.append(',');
/*     */       }
/* 117 */       stringBuilder.append(this.delegates[b]);
/*     */     } 
/* 119 */     stringBuilder.append('}');
/* 120 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/comparator/CompositeFileComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */