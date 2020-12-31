/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.UUID;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.NbtApiException;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*     */ import org.bukkit.inventory.ItemStack;
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
/*     */ public enum ReflectionMethod
/*     */ {
/*  22 */   COMPOUND_SET_FLOAT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, float.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setFloat") }),
/*  23 */   COMPOUND_SET_STRING(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setString") }),
/*  24 */   COMPOUND_SET_INT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, int.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setInt") }),
/*  25 */   COMPOUND_SET_BYTEARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, byte[].class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setByteArray") }),
/*  26 */   COMPOUND_SET_INTARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, int[].class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setIntArray") }),
/*  27 */   COMPOUND_SET_LONG(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, long.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setLong") }),
/*  28 */   COMPOUND_SET_SHORT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, short.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setShort") }),
/*  29 */   COMPOUND_SET_BYTE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, byte.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setByte") }),
/*  30 */   COMPOUND_SET_DOUBLE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, double.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setDouble") }),
/*  31 */   COMPOUND_SET_BOOLEAN(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, boolean.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setBoolean") }),
/*  32 */   COMPOUND_SET_UUID(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, UUID.class }, MinecraftVersion.MC1_16_R1, new Since[] { new Since(MinecraftVersion.MC1_16_R1, "a") }),
/*  33 */   COMPOUND_MERGE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "a") }),
/*  34 */   COMPOUND_SET(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, ClassWrapper.NMS_NBTBASE.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "set") }),
/*  35 */   COMPOUND_GET(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "get") }),
/*  36 */   COMPOUND_GET_LIST(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class, int.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getList") }),
/*  37 */   COMPOUND_OWN_TYPE(ClassWrapper.NMS_NBTBASE.getClazz(), new Class[0], MinecraftVersion.MC1_7_R4, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getTypeId")
/*     */     }),
/*  39 */   COMPOUND_GET_FLOAT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getFloat") }),
/*  40 */   COMPOUND_GET_STRING(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getString") }),
/*  41 */   COMPOUND_GET_INT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getInt") }),
/*  42 */   COMPOUND_GET_BYTEARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getByteArray") }),
/*  43 */   COMPOUND_GET_INTARRAY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getIntArray") }),
/*  44 */   COMPOUND_GET_LONG(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getLong") }),
/*  45 */   COMPOUND_GET_SHORT(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getShort") }),
/*  46 */   COMPOUND_GET_BYTE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getByte") }),
/*  47 */   COMPOUND_GET_DOUBLE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getDouble") }),
/*  48 */   COMPOUND_GET_BOOLEAN(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getBoolean") }),
/*  49 */   COMPOUND_GET_UUID(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_16_R1, new Since[] { new Since(MinecraftVersion.MC1_16_R1, "a") }),
/*  50 */   COMPOUND_GET_COMPOUND(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getCompound")
/*     */     }),
/*  52 */   NMSITEM_GETTAG(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[0], MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getTag") }),
/*  53 */   NMSITEM_SAVE(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "save") }),
/*  54 */   NMSITEM_CREATESTACK(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, MinecraftVersion.MC1_10_R1, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "createStack")
/*     */     }),
/*  56 */   COMPOUND_REMOVE_KEY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "remove") }),
/*  57 */   COMPOUND_HAS_KEY(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "hasKey") }),
/*  58 */   COMPOUND_GET_TYPE(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "b"), new Since(MinecraftVersion.MC1_9_R1, "d"), new Since(MinecraftVersion.MC1_15_R1, "e"), new Since(MinecraftVersion.MC1_16_R1, "d") }),
/*  59 */   COMPOUND_GET_KEYS(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[0], MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "c"), new Since(MinecraftVersion.MC1_13_R1, "getKeys")
/*     */     }),
/*  61 */   LISTCOMPOUND_GET_KEYS(ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[0], MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "c"), new Since(MinecraftVersion.MC1_13_R1, "getKeys") }),
/*  62 */   LIST_REMOVE_KEY(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[] { int.class }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "a"), new Since(MinecraftVersion.MC1_9_R1, "remove") }),
/*  63 */   LIST_SIZE(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[0], MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "size") }),
/*  64 */   LIST_SET(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[] { int.class, ClassWrapper.NMS_NBTBASE.getClazz() }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "a"), new Since(MinecraftVersion.MC1_13_R1, "set") }),
/*  65 */   LEGACY_LIST_ADD(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[] { ClassWrapper.NMS_NBTBASE.getClazz() }, MinecraftVersion.MC1_7_R4, MinecraftVersion.MC1_13_R2, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "add") }),
/*  66 */   LIST_ADD(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[] { int.class, ClassWrapper.NMS_NBTBASE.getClazz() }, MinecraftVersion.MC1_14_R1, new Since[] { new Since(MinecraftVersion.MC1_14_R1, "add") }),
/*  67 */   LIST_GET_STRING(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[] { int.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getString") }),
/*  68 */   LIST_GET_COMPOUND(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[] { int.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "get") }),
/*  69 */   LIST_GET(ClassWrapper.NMS_NBTTAGLIST.getClazz(), new Class[] { int.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "get"), new Since(MinecraftVersion.MC1_8_R3, "g"), new Since(MinecraftVersion.MC1_9_R1, "h"), new Since(MinecraftVersion.MC1_12_R1, "i"), new Since(MinecraftVersion.MC1_13_R1, "get")
/*     */     }),
/*  71 */   ITEMSTACK_SET_TAG(ClassWrapper.NMS_ITEMSTACK.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "setTag") }),
/*  72 */   ITEMSTACK_NMSCOPY(ClassWrapper.CRAFT_ITEMSTACK.getClazz(), new Class[] { ItemStack.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "asNMSCopy") }),
/*  73 */   ITEMSTACK_BUKKITMIRROR(ClassWrapper.CRAFT_ITEMSTACK.getClazz(), new Class[] { ClassWrapper.NMS_ITEMSTACK.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "asCraftMirror")
/*     */     }),
/*  75 */   CRAFT_WORLD_GET_HANDLE(ClassWrapper.CRAFT_WORLD.getClazz(), new Class[0], MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getHandle") }),
/*  76 */   NMS_WORLD_GET_TILEENTITY(ClassWrapper.NMS_WORLDSERVER.getClazz(), new Class[] { ClassWrapper.NMS_BLOCKPOSITION.getClazz() }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "getTileEntity") }),
/*  77 */   NMS_WORLD_SET_TILEENTITY(ClassWrapper.NMS_WORLDSERVER.getClazz(), new Class[] { ClassWrapper.NMS_BLOCKPOSITION.getClazz(), ClassWrapper.NMS_TILEENTITY.getClazz() }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "setTileEntity") }),
/*  78 */   NMS_WORLD_REMOVE_TILEENTITY(ClassWrapper.NMS_WORLDSERVER.getClazz(), new Class[] { ClassWrapper.NMS_BLOCKPOSITION.getClazz() }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "t"), new Since(MinecraftVersion.MC1_9_R1, "s"), new Since(MinecraftVersion.MC1_13_R1, "n"), new Since(MinecraftVersion.MC1_14_R1, "removeTileEntity")
/*     */     }),
/*  80 */   NMS_WORLD_GET_TILEENTITY_1_7_10(ClassWrapper.NMS_WORLDSERVER.getClazz(), new Class[] { int.class, int.class, int.class }, MinecraftVersion.MC1_7_R4, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getTileEntity")
/*     */     }),
/*  82 */   TILEENTITY_LOAD_LEGACY191(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_MINECRAFTSERVER.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_9_R1, MinecraftVersion.MC1_9_R1, new Since[] { new Since(MinecraftVersion.MC1_9_R1, "a") }),
/*  83 */   TILEENTITY_LOAD_LEGACY183(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_8_R3, MinecraftVersion.MC1_9_R2, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "c"), new Since(MinecraftVersion.MC1_9_R1, "a"), new Since(MinecraftVersion.MC1_9_R2, "c") }),
/*  84 */   TILEENTITY_LOAD_LEGACY1121(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_WORLD.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_10_R1, MinecraftVersion.MC1_12_R1, new Since[] { new Since(MinecraftVersion.MC1_10_R1, "a"), new Since(MinecraftVersion.MC1_12_R1, "create") }),
/*  85 */   TILEENTITY_LOAD_LEGACY1151(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_13_R1, MinecraftVersion.MC1_15_R1, new Since[] { new Since(MinecraftVersion.MC1_12_R1, "create") }),
/*  86 */   TILEENTITY_LOAD(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_IBLOCKDATA.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_16_R1, new Since[] { new Since(MinecraftVersion.MC1_16_R1, "create")
/*     */     }),
/*  88 */   TILEENTITY_GET_NBT(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "b"), new Since(MinecraftVersion.MC1_9_R1, "save") }),
/*  89 */   TILEENTITY_SET_NBT_LEGACY1151(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, MinecraftVersion.MC1_15_R1, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "a"), new Since(MinecraftVersion.MC1_12_R1, "load") }),
/*  90 */   TILEENTITY_SET_NBT(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[] { ClassWrapper.NMS_IBLOCKDATA.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_16_R1, new Since[] { new Since(MinecraftVersion.MC1_16_R1, "load") }),
/*  91 */   TILEENTITY_GET_BLOCKDATA(ClassWrapper.NMS_TILEENTITY.getClazz(), new Class[0], MinecraftVersion.MC1_16_R1, new Since[] { new Since(MinecraftVersion.MC1_16_R1, "getBlock")
/*     */     }),
/*  93 */   CRAFT_ENTITY_GET_HANDLE(ClassWrapper.CRAFT_ENTITY.getClazz(), new Class[0], MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "getHandle") }),
/*  94 */   NMS_ENTITY_SET_NBT(ClassWrapper.NMS_ENTITY.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "f"), new Since(MinecraftVersion.MC1_16_R1, "load") }),
/*  95 */   NMS_ENTITY_GET_NBT(ClassWrapper.NMS_ENTITY.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "e"), new Since(MinecraftVersion.MC1_12_R1, "save") }),
/*  96 */   NMS_ENTITY_GETSAVEID(ClassWrapper.NMS_ENTITY.getClazz(), new Class[0], MinecraftVersion.MC1_14_R1, new Since[] { new Since(MinecraftVersion.MC1_14_R1, "getSaveID")
/*     */     }),
/*  98 */   NBTFILE_READ(ClassWrapper.NMS_NBTCOMPRESSEDSTREAMTOOLS.getClazz(), new Class[] { InputStream.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "a") }),
/*  99 */   NBTFILE_WRITE(ClassWrapper.NMS_NBTCOMPRESSEDSTREAMTOOLS.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), OutputStream.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "a")
/*     */     }),
/* 101 */   PARSE_NBT(ClassWrapper.NMS_MOJANGSONPARSER.getClazz(), new Class[] { String.class }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "parse") }),
/* 102 */   REGISTRY_KEYSET(ClassWrapper.NMS_REGISTRYSIMPLE.getClazz(), new Class[0], MinecraftVersion.MC1_11_R1, MinecraftVersion.MC1_13_R1, new Since[] { new Since(MinecraftVersion.MC1_11_R1, "keySet") }),
/* 103 */   REGISTRY_GET(ClassWrapper.NMS_REGISTRYSIMPLE.getClazz(), new Class[] { Object.class }, MinecraftVersion.MC1_11_R1, MinecraftVersion.MC1_13_R1, new Since[] { new Since(MinecraftVersion.MC1_11_R1, "get") }),
/* 104 */   REGISTRY_SET(ClassWrapper.NMS_REGISTRYSIMPLE.getClazz(), new Class[] { Object.class, Object.class }, MinecraftVersion.MC1_11_R1, MinecraftVersion.MC1_13_R1, new Since[] { new Since(MinecraftVersion.MC1_11_R1, "a") }),
/* 105 */   REGISTRY_GET_INVERSE(ClassWrapper.NMS_REGISTRYMATERIALS.getClazz(), new Class[] { Object.class }, MinecraftVersion.MC1_11_R1, MinecraftVersion.MC1_13_R1, new Since[] { new Since(MinecraftVersion.MC1_11_R1, "b") }),
/* 106 */   REGISTRYMATERIALS_KEYSET(ClassWrapper.NMS_REGISTRYMATERIALS.getClazz(), new Class[0], MinecraftVersion.MC1_13_R1, new Since[] { new Since(MinecraftVersion.MC1_13_R1, "keySet") }),
/* 107 */   REGISTRYMATERIALS_GET(ClassWrapper.NMS_REGISTRYMATERIALS.getClazz(), new Class[] { ClassWrapper.NMS_MINECRAFTKEY.getClazz() }, MinecraftVersion.MC1_13_R1, new Since[] { new Since(MinecraftVersion.MC1_13_R1, "get") }),
/* 108 */   REGISTRYMATERIALS_GETKEY(ClassWrapper.NMS_REGISTRYMATERIALS.getClazz(), new Class[] { Object.class }, MinecraftVersion.MC1_13_R2, new Since[] { new Since(MinecraftVersion.MC1_13_R2, "getKey")
/*     */     }),
/* 110 */   GAMEPROFILE_DESERIALIZE(ClassWrapper.NMS_GAMEPROFILESERIALIZER.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz() }, MinecraftVersion.MC1_7_R4, new Since[] { new Since(MinecraftVersion.MC1_7_R4, "deserialize") }),
/* 111 */   GAMEPROFILE_SERIALIZE(ClassWrapper.NMS_GAMEPROFILESERIALIZER.getClazz(), new Class[] { ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), ClassWrapper.GAMEPROFILE.getClazz() }, MinecraftVersion.MC1_8_R3, new Since[] { new Since(MinecraftVersion.MC1_8_R3, "serialize") });
/*     */ 
/*     */   
/*     */   private boolean loaded = false;
/*     */   
/*     */   private boolean compatible = false;
/*     */   
/* 118 */   private String methodName = null;
/*     */   
/*     */   ReflectionMethod(Class<?> paramClass, Class<?>[] paramArrayOfClass, MinecraftVersion paramMinecraftVersion1, MinecraftVersion paramMinecraftVersion2, Since... paramVarArgs) {
/* 121 */     this.removedAfter = paramMinecraftVersion2;
/* 122 */     MinecraftVersion minecraftVersion = MinecraftVersion.getVersion();
/* 123 */     if (minecraftVersion.compareTo((Enum)paramMinecraftVersion1) < 0 || (this.removedAfter != null && minecraftVersion.getVersionId() > this.removedAfter.getVersionId()))
/* 124 */       return;  this.compatible = true;
/* 125 */     Since since = paramVarArgs[0];
/* 126 */     for (Since since1 : paramVarArgs) {
/* 127 */       if (since1.version.getVersionId() <= minecraftVersion.getVersionId() && since.version.getVersionId() < since1.version.getVersionId())
/* 128 */         since = since1; 
/*     */     } 
/* 130 */     this.targetVersion = since;
/*     */     try {
/* 132 */       this.method = paramClass.getMethod(this.targetVersion.name, paramArrayOfClass);
/* 133 */       this.method.setAccessible(true);
/* 134 */       this.loaded = true;
/* 135 */       this.methodName = this.targetVersion.name;
/* 136 */     } catch (NullPointerException|NoSuchMethodException|SecurityException nullPointerException) {
/* 137 */       System.out.println("[NBTAPI] Unable to find the method '" + this.targetVersion.name + "' in '" + ((paramClass == null) ? "null" : paramClass.getSimpleName()) + "' Enum: " + this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private MinecraftVersion removedAfter;
/*     */ 
/*     */   
/*     */   private Since targetVersion;
/*     */ 
/*     */   
/*     */   private Method method;
/*     */ 
/*     */   
/*     */   public Object run(Object paramObject, Object... paramVarArgs) {
/* 153 */     if (this.method == null)
/* 154 */       throw new NbtApiException("Method not loaded! '" + this + "'"); 
/*     */     try {
/* 156 */       return this.method.invoke(paramObject, paramVarArgs);
/* 157 */     } catch (Exception exception) {
/* 158 */       throw new NbtApiException("Error while calling the method '" + this.methodName + "', loaded: " + this.loaded + ", Enum: " + this, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMethodName() {
/* 166 */     return this.methodName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLoaded() {
/* 173 */     return this.loaded;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCompatible() {
/* 180 */     return this.compatible;
/*     */   }
/*     */   
/*     */   protected static class Since { public final MinecraftVersion version;
/*     */     public final String name;
/*     */     
/*     */     public Since(MinecraftVersion param1MinecraftVersion, String param1String) {
/* 187 */       this.version = param1MinecraftVersion;
/* 188 */       this.name = param1String;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/nmsmappings/ReflectionMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */