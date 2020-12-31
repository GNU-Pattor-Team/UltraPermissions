/*     */ package me.TechsCode.UltraPermissions.dependencies.commons.lang.enums;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
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
/* 131 */     super(paramString);
/* 132 */     this.iValue = paramInt;
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
/* 148 */     if (paramClass == null) {
/* 149 */       throw new IllegalArgumentException("The Enum Class must not be null");
/*     */     }
/* 151 */     List list = Enum.getEnumList(paramClass);
/* 152 */     for (ValuedEnum valuedEnum : list) {
/*     */       
/* 154 */       if (valuedEnum.getValue() == paramInt) {
/* 155 */         return valuedEnum;
/*     */       }
/*     */     } 
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getValue() {
/* 167 */     return this.iValue;
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
/*     */   public int compareTo(Object paramObject) {
/* 188 */     if (paramObject == this) {
/* 189 */       return 0;
/*     */     }
/* 191 */     if (paramObject.getClass() != getClass()) {
/* 192 */       if (paramObject.getClass().getName().equals(getClass().getName())) {
/* 193 */         return this.iValue - getValueInOtherClassLoader(paramObject);
/*     */       }
/* 195 */       throw new ClassCastException("Different enum class '" + ClassUtils.getShortClassName(paramObject.getClass()) + "'");
/*     */     } 
/*     */     
/* 198 */     return this.iValue - ((ValuedEnum)paramObject).iValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getValueInOtherClassLoader(Object paramObject) {
/*     */     try {
/* 209 */       Method method = paramObject.getClass().getMethod("getValue", null);
/* 210 */       Integer integer = (Integer)method.invoke(paramObject, null);
/* 211 */       return integer.intValue();
/* 212 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */     
/* 214 */     } catch (IllegalAccessException illegalAccessException) {
/*     */     
/* 216 */     } catch (InvocationTargetException invocationTargetException) {}
/*     */ 
/*     */     
/* 219 */     throw new IllegalStateException("This should not happen");
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
/* 230 */     if (this.iToString == null) {
/* 231 */       String str = ClassUtils.getShortClassName(getEnumClass());
/* 232 */       this.iToString = str + "[" + getName() + "=" + getValue() + "]";
/*     */     } 
/* 234 */     return this.iToString;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/lang/enums/ValuedEnum.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */