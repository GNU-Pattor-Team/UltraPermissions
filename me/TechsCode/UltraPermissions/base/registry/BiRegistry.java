/*    */ package me.TechsCode.UltraPermissions.base.registry;
/*    */ 
/*    */ public class BiRegistry<T extends RegistryStorable> {
/*    */   protected T local;
/*    */   protected T global;
/*    */   
/*    */   public BiRegistry(T paramT1, T paramT2) {
/*  8 */     this.local = paramT1;
/*  9 */     this.global = paramT2;
/*    */   }
/*    */   
/*    */   public T local() {
/* 13 */     return this.local;
/*    */   }
/*    */   
/*    */   public T global() {
/* 17 */     return this.global;
/*    */   }
/*    */   
/*    */   public T globalPreferred() {
/* 21 */     return hasGlobal() ? this.global : this.local;
/*    */   }
/*    */   
/*    */   public boolean hasGlobal() {
/* 25 */     return (this.global != null);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/registry/BiRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */