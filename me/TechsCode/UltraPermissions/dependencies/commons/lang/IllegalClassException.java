/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IllegalClassException
/*     */   extends IllegalArgumentException
/*     */ {
/*     */   private static final long serialVersionUID = 8063272569377254819L;
/*     */   
/*     */   public IllegalClassException(Class paramClass, Object paramObject) {
/*  62 */     super("Expected: " + safeGetClassName(paramClass) + ", actual: " + ((paramObject == null) ? "null" : paramObject.getClass().getName()));
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
/*     */   public IllegalClassException(Class paramClass1, Class paramClass2) {
/*  76 */     super("Expected: " + safeGetClassName(paramClass1) + ", actual: " + safeGetClassName(paramClass2));
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
/*     */   public IllegalClassException(String paramString) {
/*  89 */     super(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String safeGetClassName(Class paramClass) {
/* 100 */     return (paramClass == null) ? null : paramClass.getName();
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/IllegalClassException.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */