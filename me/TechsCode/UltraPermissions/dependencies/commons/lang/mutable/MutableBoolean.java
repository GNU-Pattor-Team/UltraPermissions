/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.mutable;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.BooleanUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MutableBoolean
/*     */   implements Mutable, Serializable, Comparable
/*     */ {
/*     */   private static final long serialVersionUID = -4830728138360036487L;
/*     */   private boolean value;
/*     */   
/*     */   public MutableBoolean() {}
/*     */   
/*     */   public MutableBoolean(boolean paramBoolean) {
/*  58 */     this.value = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableBoolean(Boolean paramBoolean) {
/*  69 */     this.value = paramBoolean.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue() {
/*  79 */     return BooleanUtils.toBooleanObject(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(boolean paramBoolean) {
/*  88 */     this.value = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object paramObject) {
/*  98 */     setValue(((Boolean)paramObject).booleanValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTrue() {
/* 109 */     return (this.value == true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFalse() {
/* 119 */     return !this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean booleanValue() {
/* 129 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean toBoolean() {
/* 140 */     return BooleanUtils.toBooleanObject(this.value);
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
/*     */   public boolean equals(Object paramObject) {
/* 153 */     if (paramObject instanceof MutableBoolean) {
/* 154 */       return (this.value == ((MutableBoolean)paramObject).booleanValue());
/*     */     }
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     return this.value ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode();
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
/*     */   public int compareTo(Object paramObject) {
/* 177 */     MutableBoolean mutableBoolean = (MutableBoolean)paramObject;
/* 178 */     boolean bool = mutableBoolean.value;
/* 179 */     return (this.value == bool) ? 0 : (this.value ? 1 : -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 189 */     return String.valueOf(this.value);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/mutable/MutableBoolean.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */