/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.GsonWrapper;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ClassWrapper;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ObjectCreator;
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ReflectionMethod;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
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
/*     */ public class NBTReflectionUtil
/*     */ {
/*  31 */   private static Field field_unhandledTags = null;
/*     */   
/*     */   static {
/*     */     try {
/*  35 */       field_unhandledTags = ClassWrapper.CRAFT_METAITEM.getClazz().getDeclaredField("unhandledTags");
/*  36 */       field_unhandledTags.setAccessible(true);
/*  37 */     } catch (NoSuchFieldException noSuchFieldException) {}
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
/*     */   public static Object getNMSEntity(Entity paramEntity) {
/*     */     try {
/*  57 */       return ReflectionMethod.CRAFT_ENTITY_GET_HANDLE.run(ClassWrapper.CRAFT_ENTITY.getClazz().cast(paramEntity), new Object[0]);
/*  58 */     } catch (Exception exception) {
/*  59 */       throw new NbtApiException("Exception while getting the NMS Entity from a Bukkit Entity!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object readNBT(InputStream paramInputStream) {
/*     */     try {
/*  71 */       return ReflectionMethod.NBTFILE_READ.run(null, new Object[] { paramInputStream });
/*  72 */     } catch (Exception exception) {
/*  73 */       throw new NbtApiException("Exception while reading a NBT File!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object writeNBT(Object paramObject, OutputStream paramOutputStream) {
/*     */     try {
/*  86 */       return ReflectionMethod.NBTFILE_WRITE.run(null, new Object[] { paramObject, paramOutputStream });
/*  87 */     } catch (Exception exception) {
/*  88 */       throw new NbtApiException("Exception while writing NBT!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeApiNBT(NBTCompound paramNBTCompound, OutputStream paramOutputStream) {
/*     */     try {
/* 100 */       Object object1 = paramNBTCompound.getCompound();
/* 101 */       if (object1 == null) {
/* 102 */         object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */       }
/* 104 */       if (!valideCompound(paramNBTCompound).booleanValue())
/*     */         return; 
/* 106 */       Object object2 = gettoCompount(object1, paramNBTCompound);
/* 107 */       ReflectionMethod.NBTFILE_WRITE.run(null, new Object[] { object2, paramOutputStream });
/* 108 */     } catch (Exception exception) {
/* 109 */       throw new NbtApiException("Exception while writing NBT!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getItemRootNBTTagCompound(Object paramObject) {
/*     */     try {
/* 122 */       Object object = ReflectionMethod.NMSITEM_GETTAG.run(paramObject, new Object[0]);
/* 123 */       return (object != null) ? object : ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/* 124 */     } catch (Exception exception) {
/* 125 */       throw new NbtApiException("Exception while getting an Itemstack's NBTCompound!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object convertNBTCompoundtoNMSItem(NBTCompound paramNBTCompound) {
/*     */     try {
/* 137 */       Object object = gettoCompount(paramNBTCompound.getCompound(), paramNBTCompound);
/* 138 */       if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_11_R1.getVersionId()) {
/* 139 */         return ObjectCreator.NMS_COMPOUNDFROMITEM.getInstance(new Object[] { object });
/*     */       }
/* 141 */       return ReflectionMethod.NMSITEM_CREATESTACK.run(null, new Object[] { object });
/*     */     }
/* 143 */     catch (Exception exception) {
/* 144 */       throw new NbtApiException("Exception while converting NBTCompound to NMS ItemStack!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NBTContainer convertNMSItemtoNBTCompound(Object paramObject) {
/*     */     try {
/* 156 */       Object object = ReflectionMethod.NMSITEM_SAVE.run(paramObject, new Object[] { ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]) });
/* 157 */       return new NBTContainer(object);
/* 158 */     } catch (Exception exception) {
/* 159 */       throw new NbtApiException("Exception while converting NMS ItemStack to NBTCompound!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, Object> getUnhandledNBTTags(ItemMeta paramItemMeta) {
/*     */     try {
/* 172 */       return (Map<String, Object>)field_unhandledTags.get(paramItemMeta);
/* 173 */     } catch (Exception exception) {
/* 174 */       throw new NbtApiException("Exception while getting unhandled tags from ItemMeta!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getEntityNBTTagCompound(Object paramObject) {
/*     */     try {
/* 186 */       Object object = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
/* 187 */       Object object1 = ReflectionMethod.NMS_ENTITY_GET_NBT.run(paramObject, new Object[] { object });
/* 188 */       if (object1 == null)
/* 189 */         object1 = object; 
/* 190 */       return object1;
/* 191 */     } catch (Exception exception) {
/* 192 */       throw new NbtApiException("Exception while getting NBTCompound from NMS Entity!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object setEntityNBTTag(Object paramObject1, Object paramObject2) {
/*     */     try {
/* 205 */       ReflectionMethod.NMS_ENTITY_SET_NBT.run(paramObject2, new Object[] { paramObject1 });
/* 206 */       return paramObject2;
/* 207 */     } catch (Exception exception) {
/* 208 */       throw new NbtApiException("Exception while setting the NBTCompound of an Entity", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getTileEntityNBTTagCompound(BlockState paramBlockState) {
/*     */     try {
/* 220 */       Object object1 = ClassWrapper.CRAFT_WORLD.getClazz().cast(paramBlockState.getWorld());
/* 221 */       Object object2 = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(object1, new Object[0]);
/* 222 */       Object object3 = null;
/* 223 */       if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
/* 224 */         object3 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY_1_7_10.run(object2, new Object[] { Integer.valueOf(paramBlockState.getX()), Integer.valueOf(paramBlockState.getY()), Integer.valueOf(paramBlockState.getZ()) });
/*     */       } else {
/* 226 */         Object object = ObjectCreator.NMS_BLOCKPOSITION.getInstance(new Object[] { Integer.valueOf(paramBlockState.getX()), Integer.valueOf(paramBlockState.getY()), Integer.valueOf(paramBlockState.getZ()) });
/* 227 */         object3 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY.run(object2, new Object[] { object });
/*     */       } 
/* 229 */       Object object4 = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
/* 230 */       Object object5 = ReflectionMethod.TILEENTITY_GET_NBT.run(object3, new Object[] { object4 });
/* 231 */       if (object5 == null)
/* 232 */         object5 = object4; 
/* 233 */       return object5;
/* 234 */     } catch (Exception exception) {
/* 235 */       throw new NbtApiException("Exception while getting NBTCompound from TileEntity!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setTileEntityNBTTagCompound(BlockState paramBlockState, Object paramObject) {
/*     */     try {
/* 247 */       Object object = ClassWrapper.CRAFT_WORLD.getClazz().cast(paramBlockState.getWorld());
/* 248 */       Object object1 = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(object, new Object[0]);
/* 249 */       Object object2 = null;
/* 250 */       if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
/* 251 */         object2 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY_1_7_10.run(object1, new Object[] { Integer.valueOf(paramBlockState.getX()), Integer.valueOf(paramBlockState.getY()), Integer.valueOf(paramBlockState.getZ()) });
/*     */       } else {
/* 253 */         Object object3 = ObjectCreator.NMS_BLOCKPOSITION.getInstance(new Object[] { Integer.valueOf(paramBlockState.getX()), Integer.valueOf(paramBlockState.getY()), Integer.valueOf(paramBlockState.getZ()) });
/* 254 */         object2 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY.run(object1, new Object[] { object3 });
/*     */       } 
/* 256 */       if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_16_R1.getVersionId()) {
/* 257 */         Object object3 = ReflectionMethod.TILEENTITY_GET_BLOCKDATA.run(object2, new Object[0]);
/* 258 */         ReflectionMethod.TILEENTITY_SET_NBT.run(object2, new Object[] { object3, paramObject });
/*     */       } else {
/* 260 */         ReflectionMethod.TILEENTITY_SET_NBT_LEGACY1151.run(object2, new Object[] { paramObject });
/*     */       } 
/* 262 */     } catch (Exception exception) {
/* 263 */       throw new NbtApiException("Exception while setting NBTData for a TileEntity!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object getSubNBTTagCompound(Object paramObject, String paramString) {
/*     */     try {
/* 276 */       if (((Boolean)ReflectionMethod.COMPOUND_HAS_KEY.run(paramObject, new Object[] { paramString })).booleanValue()) {
/* 277 */         return ReflectionMethod.COMPOUND_GET_COMPOUND.run(paramObject, new Object[] { paramString });
/*     */       }
/* 279 */       throw new NbtApiException("Tried getting invalide compound '" + paramString + "' from '" + paramObject + "'!");
/*     */     }
/* 281 */     catch (Exception exception) {
/* 282 */       throw new NbtApiException("Exception while getting NBT subcompounds!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addNBTTagCompound(NBTCompound paramNBTCompound, String paramString) {
/* 293 */     if (paramString == null) {
/* 294 */       remove(paramNBTCompound, paramString);
/*     */       return;
/*     */     } 
/* 297 */     Object object1 = paramNBTCompound.getCompound();
/* 298 */     if (object1 == null) {
/* 299 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 301 */     if (!valideCompound(paramNBTCompound).booleanValue()) {
/*     */       return;
/*     */     }
/* 304 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/*     */     try {
/* 306 */       ReflectionMethod.COMPOUND_SET.run(object2, new Object[] { paramString, ClassWrapper.NMS_NBTTAGCOMPOUND
/* 307 */             .getClazz().newInstance() });
/* 308 */       paramNBTCompound.setCompound(object1);
/* 309 */     } catch (Exception exception) {
/* 310 */       throw new NbtApiException("Exception while adding a Compound!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Boolean valideCompound(NBTCompound paramNBTCompound) {
/* 321 */     Object object = paramNBTCompound.getCompound();
/* 322 */     if (object == null) {
/* 323 */       object = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 325 */     return Boolean.valueOf((gettoCompount(object, paramNBTCompound) != null));
/*     */   }
/*     */   
/*     */   protected static Object gettoCompount(Object paramObject, NBTCompound paramNBTCompound) {
/* 329 */     ArrayDeque<String> arrayDeque = new ArrayDeque();
/* 330 */     while (paramNBTCompound.getParent() != null) {
/* 331 */       arrayDeque.add(paramNBTCompound.getName());
/* 332 */       paramNBTCompound = paramNBTCompound.getParent();
/*     */     } 
/* 334 */     while (!arrayDeque.isEmpty()) {
/* 335 */       String str = arrayDeque.pollLast();
/* 336 */       paramObject = getSubNBTTagCompound(paramObject, str);
/* 337 */       if (paramObject == null) {
/* 338 */         throw new NbtApiException("Unable to find tag '" + str + "' in " + paramObject);
/*     */       }
/*     */     } 
/* 341 */     return paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void mergeOtherNBTCompound(NBTCompound paramNBTCompound1, NBTCompound paramNBTCompound2) {
/* 351 */     Object object1 = paramNBTCompound1.getCompound();
/* 352 */     if (object1 == null) {
/* 353 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 355 */     if (!valideCompound(paramNBTCompound1).booleanValue())
/* 356 */       throw new NbtApiException("The Compound wasn't able to be linked back to the root!"); 
/* 357 */     Object object2 = gettoCompount(object1, paramNBTCompound1);
/* 358 */     Object object3 = paramNBTCompound2.getCompound();
/* 359 */     if (object3 == null) {
/* 360 */       object3 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 362 */     if (!valideCompound(paramNBTCompound2).booleanValue())
/* 363 */       throw new NbtApiException("The Compound wasn't able to be linked back to the root!"); 
/* 364 */     Object object4 = gettoCompount(object3, paramNBTCompound2);
/*     */     try {
/* 366 */       ReflectionMethod.COMPOUND_MERGE.run(object2, new Object[] { object4 });
/* 367 */       paramNBTCompound1.setCompound(object1);
/* 368 */     } catch (Exception exception) {
/* 369 */       throw new NbtApiException("Exception while merging two NBTCompounds!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getContent(NBTCompound paramNBTCompound, String paramString) {
/* 381 */     Object object1 = paramNBTCompound.getCompound();
/* 382 */     if (object1 == null) {
/* 383 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 385 */     if (!valideCompound(paramNBTCompound).booleanValue())
/* 386 */       throw new NbtApiException("The Compound wasn't able to be linked back to the root!"); 
/* 387 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/*     */     try {
/* 389 */       return ReflectionMethod.COMPOUND_GET.run(object2, new Object[] { paramString }).toString();
/* 390 */     } catch (Exception exception) {
/* 391 */       throw new NbtApiException("Exception while getting the Content for key '" + paramString + "'!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void set(NBTCompound paramNBTCompound, String paramString, Object paramObject) {
/* 403 */     if (paramObject == null) {
/* 404 */       remove(paramNBTCompound, paramString);
/*     */       return;
/*     */     } 
/* 407 */     Object object1 = paramNBTCompound.getCompound();
/* 408 */     if (object1 == null) {
/* 409 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 411 */     if (!valideCompound(paramNBTCompound).booleanValue()) {
/* 412 */       throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
/*     */     }
/* 414 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/*     */     try {
/* 416 */       ReflectionMethod.COMPOUND_SET.run(object2, new Object[] { paramString, paramObject });
/* 417 */       paramNBTCompound.setCompound(object1);
/* 418 */     } catch (Exception exception) {
/* 419 */       throw new NbtApiException("Exception while setting key '" + paramString + "' to '" + paramObject + "'!", exception);
/*     */     } 
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
/*     */   public static <T> NBTList<T> getList(NBTCompound paramNBTCompound, String paramString, NBTType paramNBTType, Class<T> paramClass) {
/* 434 */     Object object1 = paramNBTCompound.getCompound();
/* 435 */     if (object1 == null) {
/* 436 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 438 */     if (!valideCompound(paramNBTCompound).booleanValue())
/* 439 */       return null; 
/* 440 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/*     */     try {
/* 442 */       Object object = ReflectionMethod.COMPOUND_GET_LIST.run(object2, new Object[] { paramString, Integer.valueOf(paramNBTType.getId()) });
/* 443 */       if (paramClass == String.class)
/* 444 */         return new NBTStringList(paramNBTCompound, paramString, paramNBTType, object); 
/* 445 */       if (paramClass == NBTListCompound.class)
/* 446 */         return new NBTCompoundList(paramNBTCompound, paramString, paramNBTType, object); 
/* 447 */       if (paramClass == Integer.class)
/* 448 */         return new NBTIntegerList(paramNBTCompound, paramString, paramNBTType, object); 
/* 449 */       if (paramClass == Float.class)
/* 450 */         return new NBTFloatList(paramNBTCompound, paramString, paramNBTType, object); 
/* 451 */       if (paramClass == Double.class)
/* 452 */         return new NBTDoubleList(paramNBTCompound, paramString, paramNBTType, object); 
/* 453 */       if (paramClass == Long.class) {
/* 454 */         return new NBTLongList(paramNBTCompound, paramString, paramNBTType, object);
/*     */       }
/* 456 */       return null;
/*     */     }
/* 458 */     catch (Exception exception) {
/* 459 */       throw new NbtApiException("Exception while getting a list with the type '" + paramNBTType + "'!", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setObject(NBTCompound paramNBTCompound, String paramString, Object paramObject) {
/* 471 */     if (!MinecraftVersion.hasGsonSupport())
/*     */       return; 
/*     */     try {
/* 474 */       String str = GsonWrapper.getString(paramObject);
/* 475 */       setData(paramNBTCompound, ReflectionMethod.COMPOUND_SET_STRING, paramString, str);
/* 476 */     } catch (Exception exception) {
/* 477 */       throw new NbtApiException("Exception while setting the Object '" + paramObject + "'!", exception);
/*     */     } 
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
/*     */   public static <T> T getObject(NBTCompound paramNBTCompound, String paramString, Class<T> paramClass) {
/* 490 */     if (!MinecraftVersion.hasGsonSupport())
/* 491 */       return null; 
/* 492 */     String str = (String)getData(paramNBTCompound, ReflectionMethod.COMPOUND_GET_STRING, paramString);
/* 493 */     if (str == null) {
/* 494 */       return null;
/*     */     }
/* 496 */     return (T)GsonWrapper.deserializeJson(str, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void remove(NBTCompound paramNBTCompound, String paramString) {
/* 506 */     Object object1 = paramNBTCompound.getCompound();
/* 507 */     if (object1 == null) {
/* 508 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 510 */     if (!valideCompound(paramNBTCompound).booleanValue())
/*     */       return; 
/* 512 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/* 513 */     ReflectionMethod.COMPOUND_REMOVE_KEY.run(object2, new Object[] { paramString });
/* 514 */     paramNBTCompound.setCompound(object1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<String> getKeys(NBTCompound paramNBTCompound) {
/* 525 */     Object object1 = paramNBTCompound.getCompound();
/* 526 */     if (object1 == null) {
/* 527 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 529 */     if (!valideCompound(paramNBTCompound).booleanValue())
/* 530 */       throw new NbtApiException("The Compound wasn't able to be linked back to the root!"); 
/* 531 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/* 532 */     return (Set<String>)ReflectionMethod.COMPOUND_GET_KEYS.run(object2, new Object[0]);
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
/*     */   public static void setData(NBTCompound paramNBTCompound, ReflectionMethod paramReflectionMethod, String paramString, Object paramObject) {
/* 544 */     if (paramObject == null) {
/* 545 */       remove(paramNBTCompound, paramString);
/*     */       return;
/*     */     } 
/* 548 */     Object object1 = paramNBTCompound.getCompound();
/* 549 */     if (object1 == null) {
/* 550 */       object1 = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
/*     */     }
/* 552 */     if (!valideCompound(paramNBTCompound).booleanValue())
/* 553 */       throw new NbtApiException("The Compound wasn't able to be linked back to the root!"); 
/* 554 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/* 555 */     paramReflectionMethod.run(object2, new Object[] { paramString, paramObject });
/* 556 */     paramNBTCompound.setCompound(object1);
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
/*     */   public static Object getData(NBTCompound paramNBTCompound, ReflectionMethod paramReflectionMethod, String paramString) {
/* 568 */     Object object1 = paramNBTCompound.getCompound();
/* 569 */     if (object1 == null) {
/* 570 */       return null;
/*     */     }
/* 572 */     if (!valideCompound(paramNBTCompound).booleanValue())
/* 573 */       throw new NbtApiException("The Compound wasn't able to be linked back to the root!"); 
/* 574 */     Object object2 = gettoCompount(object1, paramNBTCompound);
/* 575 */     return paramReflectionMethod.run(object2, new Object[] { paramString });
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTReflectionUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */