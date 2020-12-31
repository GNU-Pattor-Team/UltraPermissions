/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NBTListCompound
/*    */   extends NBTCompound
/*    */ {
/*    */   private NBTList<?> owner;
/*    */   private Object compound;
/*    */   
/*    */   protected NBTListCompound(NBTList<?> paramNBTList, Object paramObject) {
/* 18 */     super(null, null);
/* 19 */     this.owner = paramNBTList;
/* 20 */     this.compound = paramObject;
/*    */   }
/*    */   
/*    */   public NBTList<?> getListParent() {
/* 24 */     return this.owner;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getCompound() {
/* 29 */     return this.compound;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setCompound(Object paramObject) {
/* 34 */     this.compound = paramObject;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void saveCompound() {
/* 39 */     this.owner.save();
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTListCompound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */