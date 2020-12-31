/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ import java.lang.invoke.SerializedLambda;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.AvaliableSince;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.CheckUtil;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.FAUtil;
/*    */ import org.bukkit.block.BlockState;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NBTTileEntity
/*    */   extends NBTCompound
/*    */ {
/*    */   private final BlockState tile;
/*    */   
/*    */   public NBTTileEntity(BlockState paramBlockState) {
/* 27 */     super(null, null);
/* 28 */     if (paramBlockState == null || (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3) && !paramBlockState.isPlaced())) {
/* 29 */       throw new NullPointerException("Tile can't be null/not placed!");
/*    */     }
/* 31 */     this.tile = paramBlockState;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getCompound() {
/* 36 */     return NBTReflectionUtil.getTileEntityNBTTagCompound(this.tile);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setCompound(Object paramObject) {
/* 41 */     NBTReflectionUtil.setTileEntityNBTTagCompound(this.tile, paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @AvaliableSince(version = MinecraftVersion.MC1_14_R1)
/*    */   public NBTCompound getPersistentDataContainer() {
/* 52 */     FAUtil.check(this::getPersistentDataContainer, CheckUtil::isAvaliable);
/* 53 */     if (hasKey("PublicBukkitValues").booleanValue()) {
/* 54 */       return getCompound("PublicBukkitValues");
/*    */     }
/* 56 */     NBTContainer nBTContainer = new NBTContainer();
/* 57 */     nBTContainer.addCompound("PublicBukkitValues").setString("__nbtapi", "Marker to make the PersistentDataContainer have content");
/*    */     
/* 59 */     mergeCompound(nBTContainer);
/* 60 */     return getCompound("PublicBukkitValues");
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTTileEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */