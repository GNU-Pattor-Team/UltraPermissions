/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.enum;
/*     */ 
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ClassUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ValuedEnum
/*     */   extends Enum
/*     */ {
/*     */   private static final long serialVersionUID = -7129650521543789085L;
/*     */   private final int iValue;
/*     */   
/*     */   protected ValuedEnum(String paramString, int paramInt) {
/* 126 */     super(paramString);
/* 127 */     this.iValue = paramInt;
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
/*     */   protected static Enum getEnum(Class paramClass, int paramInt) {
/* 143 */     if (paramClass == null) {
/* 144 */       throw new IllegalArgumentException("The Enum Class must not be null");
/*     */     }
/* 146 */     List list = Enum.getEnumList(paramClass);
/* 147 */     for (ValuedEnum valuedEnum : list) {
/*     */       
/* 149 */       if (valuedEnum.getValue() == paramInt) {
/* 150 */         return valuedEnum;
/*     */       }
/*     */     } 
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getValue() {
/* 162 */     return this.iValue;
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
/*     */   public int compareTo(Object paramObject) {
/* 179 */     return this.iValue - ((ValuedEnum)paramObject).iValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 190 */     if (this.iToString == null) {
/* 191 */       String str = ClassUtils.getShortClassName(getEnumClass());
/* 192 */       this.iToString = str + "[" + getName() + "=" + getValue() + "]";
/*     */     } 
/* 194 */     return this.iToString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/enum/ValuedEnum.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */