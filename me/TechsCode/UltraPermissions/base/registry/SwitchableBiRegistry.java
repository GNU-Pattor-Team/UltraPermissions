/*    */ package me.TechsCode.UltraPermissions.base.registry;
/*    */ 
/*    */ public class SwitchableBiRegistry<T extends RegistryStorable & Switchable>
/*    */ {
/*    */   private BiRegistry<T> registry;
/*    */   
/*    */   public SwitchableBiRegistry(BiRegistry<T> paramBiRegistry) {
/*  8 */     this.registry = paramBiRegistry;
/*    */   }
/*    */   
/*    */   public T get() {
/* 12 */     return ((Switchable)this.registry.local).isSwitchedTo() ? this.registry.local : ((this.registry.global != null) ? this.registry.global : this.registry.local);
/*    */   }
/*    */   
/*    */   public void switchToLocal() {
/* 16 */     ((Switchable)this.registry.local).setSwitchedTo(true);
/*    */   }
/*    */   
/*    */   public void switchToGlobal() {
/* 20 */     ((Switchable)this.registry.local).setSwitchedTo(false);
/*    */   }
/*    */   
/*    */   public T local() {
/* 24 */     return this.registry.local;
/*    */   }
/*    */   
/*    */   public T global() {
/* 28 */     return this.registry.global;
/*    */   }
/*    */   
/*    */   public boolean hasGlobal() {
/* 32 */     return (this.registry.global != null);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/registry/SwitchableBiRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */