/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum NBTType
/*    */ {
/* 11 */   NBTTagEnd(0),
/* 12 */   NBTTagByte(1),
/* 13 */   NBTTagShort(2),
/* 14 */   NBTTagInt(3),
/* 15 */   NBTTagLong(4),
/* 16 */   NBTTagFloat(5),
/* 17 */   NBTTagDouble(6),
/* 18 */   NBTTagByteArray(7),
/* 19 */   NBTTagIntArray(11),
/* 20 */   NBTTagString(8),
/* 21 */   NBTTagList(9),
/* 22 */   NBTTagCompound(10);
/*    */   
/*    */   NBTType(int paramInt1) {
/* 25 */     this.id = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private final int id;
/*    */ 
/*    */   
/*    */   public int getId() {
/* 34 */     return this.id;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */