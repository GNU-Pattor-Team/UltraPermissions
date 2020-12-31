/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*    */ 
/*    */ import java.lang.invoke.SerializedLambda;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.AvaliableSince;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.CheckUtil;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations.FAUtil;
/*    */ import org.bukkit.entity.Entity;
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
/*    */ public class NBTEntity
/*    */   extends NBTCompound
/*    */ {
/*    */   private final Entity ent;
/*    */   
/*    */   public NBTEntity(Entity paramEntity) {
/* 26 */     super(null, null);
/* 27 */     if (paramEntity == null) {
/* 28 */       throw new NullPointerException("Entity can't be null!");
/*    */     }
/* 30 */     this.ent = paramEntity;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getCompound() {
/* 35 */     return NBTReflectionUtil.getEntityNBTTagCompound(NBTReflectionUtil.getNMSEntity(this.ent));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setCompound(Object paramObject) {
/* 40 */     NBTReflectionUtil.setEntityNBTTag(paramObject, NBTReflectionUtil.getNMSEntity(this.ent));
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
/* 51 */     FAUtil.check(this::getPersistentDataContainer, CheckUtil::isAvaliable);
/* 52 */     if (hasKey("BukkitValues").booleanValue()) {
/* 53 */       return getCompound("BukkitValues");
/*    */     }
/* 55 */     NBTContainer nBTContainer = new NBTContainer();
/* 56 */     nBTContainer.addCompound("BukkitValues").setString("__nbtapi", "Marker to make the PersistentDataContainer have content");
/*    */     
/* 58 */     mergeCompound(nBTContainer);
/* 59 */     return getCompound("BukkitValues");
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */