/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.mutable;
/*     */ 
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
/*     */ public class MutableObject
/*     */   implements Mutable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 86241875189L;
/*     */   private Object value;
/*     */   
/*     */   public MutableObject() {}
/*     */   
/*     */   public MutableObject(Object paramObject) {
/*  55 */     this.value = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue() {
/*  65 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object paramObject) {
/*  74 */     this.value = paramObject;
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
/*  87 */     if (paramObject instanceof MutableObject) {
/*  88 */       Object object = ((MutableObject)paramObject).value;
/*  89 */       return (this.value == object || (this.value != null && this.value.equals(object)));
/*     */     } 
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 100 */     return (this.value == null) ? 0 : this.value.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 110 */     return (this.value == null) ? "null" : this.value.toString();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/mutable/MutableObject.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */