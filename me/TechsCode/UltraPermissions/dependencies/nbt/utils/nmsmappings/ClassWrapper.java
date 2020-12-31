/*    */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings;
/*    */ 
/*    */ import java.util.logging.Level;
/*    */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*    */ import org.bukkit.Bukkit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ClassWrapper
/*    */ {
/* 17 */   CRAFT_ITEMSTACK(PackageWrapper.CRAFTBUKKIT, "inventory.CraftItemStack"),
/* 18 */   CRAFT_METAITEM(PackageWrapper.CRAFTBUKKIT, "inventory.CraftMetaItem"),
/* 19 */   CRAFT_ENTITY(PackageWrapper.CRAFTBUKKIT, "entity.CraftEntity"),
/* 20 */   CRAFT_WORLD(PackageWrapper.CRAFTBUKKIT, "CraftWorld"),
/* 21 */   NMS_NBTBASE(PackageWrapper.NMS, "NBTBase"),
/* 22 */   NMS_NBTTAGSTRING(PackageWrapper.NMS, "NBTTagString"),
/* 23 */   NMS_NBTTAGINT(PackageWrapper.NMS, "NBTTagInt"),
/* 24 */   NMS_NBTTAGFLOAT(PackageWrapper.NMS, "NBTTagFloat"),
/* 25 */   NMS_NBTTAGDOUBLE(PackageWrapper.NMS, "NBTTagDouble"),
/* 26 */   NMS_NBTTAGLONG(PackageWrapper.NMS, "NBTTagLong"),
/* 27 */   NMS_ITEMSTACK(PackageWrapper.NMS, "ItemStack"),
/* 28 */   NMS_NBTTAGCOMPOUND(PackageWrapper.NMS, "NBTTagCompound"),
/* 29 */   NMS_NBTTAGLIST(PackageWrapper.NMS, "NBTTagList"),
/* 30 */   NMS_NBTCOMPRESSEDSTREAMTOOLS(PackageWrapper.NMS, "NBTCompressedStreamTools"),
/* 31 */   NMS_MOJANGSONPARSER(PackageWrapper.NMS, "MojangsonParser"),
/* 32 */   NMS_TILEENTITY(PackageWrapper.NMS, "TileEntity"),
/* 33 */   NMS_BLOCKPOSITION(PackageWrapper.NMS, "BlockPosition", MinecraftVersion.MC1_8_R3, null),
/* 34 */   NMS_WORLDSERVER(PackageWrapper.NMS, "WorldServer"),
/* 35 */   NMS_MINECRAFTSERVER(PackageWrapper.NMS, "MinecraftServer"),
/* 36 */   NMS_WORLD(PackageWrapper.NMS, "World"),
/* 37 */   NMS_ENTITY(PackageWrapper.NMS, "Entity"),
/* 38 */   NMS_ENTITYTYPES(PackageWrapper.NMS, "EntityTypes"),
/* 39 */   NMS_REGISTRYSIMPLE(PackageWrapper.NMS, "RegistrySimple", MinecraftVersion.MC1_11_R1, MinecraftVersion.MC1_12_R1),
/* 40 */   NMS_REGISTRYMATERIALS(PackageWrapper.NMS, "RegistryMaterials"),
/* 41 */   NMS_IREGISTRY(PackageWrapper.NMS, "IRegistry"),
/* 42 */   NMS_MINECRAFTKEY(PackageWrapper.NMS, "MinecraftKey", MinecraftVersion.MC1_8_R3, null),
/* 43 */   NMS_GAMEPROFILESERIALIZER(PackageWrapper.NMS, "GameProfileSerializer"),
/* 44 */   NMS_IBLOCKDATA(PackageWrapper.NMS, "IBlockData", MinecraftVersion.MC1_8_R3, null),
/* 45 */   GAMEPROFILE("com.mojang.authlib.GameProfile", MinecraftVersion.MC1_8_R3);
/*    */ 
/*    */   
/*    */   private boolean enabled = false;
/*    */ 
/*    */   
/*    */   private Class<?> clazz;
/*    */ 
/*    */ 
/*    */   
/*    */   ClassWrapper(PackageWrapper paramPackageWrapper, String paramString1, MinecraftVersion paramMinecraftVersion1, MinecraftVersion paramMinecraftVersion2) {
/* 56 */     if (paramMinecraftVersion1 != null && MinecraftVersion.getVersion().getVersionId() < paramMinecraftVersion1.getVersionId()) {
/*    */       return;
/*    */     }
/* 59 */     if (paramMinecraftVersion2 != null && MinecraftVersion.getVersion().getVersionId() > paramMinecraftVersion2.getVersionId()) {
/*    */       return;
/*    */     }
/* 62 */     this.enabled = true;
/*    */     try {
/* 64 */       String str = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
/* 65 */       this.clazz = Class.forName(paramPackageWrapper.getUri() + "." + str + "." + paramString1);
/* 66 */     } catch (Exception exception) {
/* 67 */       MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] Error while trying to resolve the class '" + paramString1 + "'!", exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   ClassWrapper(String paramString1, MinecraftVersion paramMinecraftVersion) {
/* 72 */     if (paramMinecraftVersion != null && MinecraftVersion.getVersion().getVersionId() < paramMinecraftVersion.getVersionId()) {
/*    */       return;
/*    */     }
/* 75 */     this.enabled = true;
/*    */     try {
/* 77 */       this.clazz = Class.forName(paramString1);
/* 78 */     } catch (Exception exception) {
/* 79 */       MinecraftVersion.logger.log(Level.WARNING, "[NBTAPI] Error while trying to resolve the class '" + paramString1 + "'!", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> getClazz() {
/* 87 */     return this.clazz;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 94 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/nmsmappings/ClassWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */