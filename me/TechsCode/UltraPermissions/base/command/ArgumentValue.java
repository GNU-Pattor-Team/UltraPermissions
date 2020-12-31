/*    */ package me.TechsCode.UltraPermissions.base.command;
/*    */ public class ArgumentValue<T> {
/*    */   private final String raw;
/*    */   
/*    */   public static <T> ArgumentValue<T> empty(String paramString, EmptyReason paramEmptyReason) {
/*  6 */     return new ArgumentValue<>(paramString, null, Validity.valueOf(paramEmptyReason.name()));
/*    */   }
/*    */   private final T t; private final Validity validity;
/*    */   public static <T> ArgumentValue<T> of(String paramString, T paramT) {
/* 10 */     return new ArgumentValue<>(paramString, paramT, Validity.VALID);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private ArgumentValue(String paramString, T paramT, Validity paramValidity) {
/* 18 */     this.raw = paramString;
/* 19 */     this.t = paramT;
/* 20 */     this.validity = paramValidity;
/*    */   }
/*    */   
/*    */   public String getRaw() {
/* 24 */     return this.raw;
/*    */   }
/*    */   
/*    */   public T get() {
/* 28 */     return this.t;
/*    */   }
/*    */   
/*    */   public Validity getValidity() {
/* 32 */     return this.validity;
/*    */   }
/*    */   
/*    */   public boolean isValid() {
/* 36 */     return (this.validity == Validity.VALID);
/*    */   }
/*    */   
/*    */   public boolean isMatch() {
/* 40 */     return (this.validity != Validity.NO_MATCH);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/ArgumentValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */