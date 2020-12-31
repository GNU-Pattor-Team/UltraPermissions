/*     */ package me.TechsCode.UltraPermissions.base.item;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.properties.Property;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.SkinTexture;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.configuration.serialization.ConfigurationSerializable;
/*     */ import org.bukkit.configuration.serialization.ConfigurationSerialization;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.SkullMeta;
/*     */ 
/*     */ public class CustomItem implements Serializable {
/*  28 */   public static Gson gson = new Gson();
/*     */   
/*     */   private ItemStack is;
/*     */   
/*     */   public CustomItem(Material paramMaterial) {
/*  33 */     this(new ItemStack(paramMaterial));
/*     */   }
/*     */   
/*     */   public CustomItem(XMaterial paramXMaterial) {
/*  37 */     this(paramXMaterial.getAsItemStack().orElse(new ItemStack(Material.STONE)));
/*     */   }
/*     */   
/*     */   public CustomItem(XMaterial paramXMaterial, boolean paramBoolean) {
/*  41 */     this(paramXMaterial.getAsItemStack().orElse(new ItemStack(Material.STONE)), paramBoolean);
/*     */   }
/*     */   
/*     */   public CustomItem(ItemStack paramItemStack) {
/*  45 */     this(paramItemStack, true);
/*     */   }
/*     */   
/*     */   public CustomItem(ItemStack paramItemStack, boolean paramBoolean) {
/*  49 */     Preconditions.checkArgument((paramItemStack != null), "ItemStack cannot be null");
/*     */     
/*  51 */     this.is = paramItemStack.clone();
/*     */     
/*  53 */     if (paramBoolean) showAllAttributes(false); 
/*     */   }
/*     */   
/*     */   public CustomItem material(XMaterial paramXMaterial) {
/*  57 */     paramXMaterial.setMaterialOf(this.is);
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem material(Material paramMaterial) {
/*  62 */     this.is.setType(paramMaterial);
/*  63 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem skull(String paramString) {
/*  67 */     if (this.is.getItemMeta() != null && this.is.getItemMeta() instanceof SkullMeta) {
/*  68 */       SkullMeta skullMeta = (SkullMeta)this.is.getItemMeta();
/*  69 */       skullMeta.setOwner(paramString);
/*  70 */       this.is.setItemMeta((ItemMeta)skullMeta);
/*     */     } 
/*     */     
/*  73 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem setSkullTexture(SkinTexture paramSkinTexture) {
/*  77 */     if (paramSkinTexture == null) return this; 
/*  78 */     if (paramSkinTexture.getUrl() == null || paramSkinTexture.getUrl().equals("null")) return this;
/*     */     
/*  80 */     if (this.is.hasItemMeta() && this.is.getItemMeta() instanceof SkullMeta) {
/*  81 */       SkullMeta skullMeta = (SkullMeta)this.is.getItemMeta();
/*  82 */       GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "");
/*     */       
/*  84 */       byte[] arrayOfByte = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", new Object[] { paramSkinTexture.getUrl() }).getBytes());
/*  85 */       gameProfile.getProperties().put("textures", new Property("textures", new String(arrayOfByte)));
/*     */       
/*     */       try {
/*  88 */         Field field = skullMeta.getClass().getDeclaredField("profile");
/*  89 */         field.setAccessible(true);
/*  90 */         field.set(skullMeta, gameProfile);
/*  91 */       } catch (IllegalArgumentException|IllegalAccessException|NoSuchFieldException|SecurityException illegalArgumentException) {
/*  92 */         illegalArgumentException.printStackTrace();
/*     */       } 
/*     */       
/*  95 */       this.is.setItemMeta((ItemMeta)skullMeta);
/*     */     } 
/*     */     
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public String getSkullOwner() {
/* 102 */     if (this.is.getItemMeta() != null && this.is.getItemMeta() instanceof SkullMeta) {
/* 103 */       SkullMeta skullMeta = (SkullMeta)this.is.getItemMeta();
/* 104 */       return skullMeta.getOwner();
/*     */     } 
/*     */     
/* 107 */     return null;
/*     */   }
/*     */   
/*     */   public CustomItem name() {
/* 111 */     return name("§r");
/*     */   }
/*     */   
/*     */   public CustomItem name(String paramString) {
/* 115 */     if (this.is.getItemMeta() != null) {
/* 116 */       ItemMeta itemMeta = this.is.getItemMeta();
/* 117 */       itemMeta.setDisplayName(Text.color(paramString));
/* 118 */       this.is.setItemMeta(itemMeta);
/*     */     } 
/*     */     
/* 121 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem amount(int paramInt) {
/* 125 */     this.is.setAmount(paramInt);
/* 126 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem lore(String... paramVarArgs) {
/* 130 */     lore(Arrays.asList(paramVarArgs));
/* 131 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem lore(List<String> paramList) {
/* 135 */     if (this.is.getItemMeta() != null) {
/* 136 */       ItemMeta itemMeta = this.is.getItemMeta();
/* 137 */       itemMeta.setLore(paramList);
/* 138 */       this.is.setItemMeta(itemMeta);
/*     */     } 
/*     */     
/* 141 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem addEnchantment(Enchantment paramEnchantment, int paramInt) {
/* 145 */     this.is.addUnsafeEnchantment(paramEnchantment, paramInt);
/* 146 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem removeEnchantment(Enchantment paramEnchantment) {
/* 150 */     this.is.removeEnchantment(paramEnchantment);
/* 151 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem appendLoreBeginning(String... paramVarArgs) {
/* 155 */     ArrayList<String> arrayList = new ArrayList();
/* 156 */     arrayList.addAll(Arrays.asList(paramVarArgs));
/* 157 */     arrayList.addAll(getLore());
/* 158 */     lore(arrayList);
/* 159 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem appendLore(List<String> paramList) {
/* 163 */     return appendLore(paramList.<String>toArray(new String[0]));
/*     */   }
/*     */   
/*     */   public CustomItem appendLore(String... paramVarArgs) {
/* 167 */     ArrayList<String> arrayList = new ArrayList<>(getLore());
/* 168 */     arrayList.addAll(Arrays.asList(paramVarArgs));
/* 169 */     lore(arrayList);
/* 170 */     return this;
/*     */   }
/*     */   
/*     */   public XMaterial getMaterial() {
/* 174 */     return XMaterial.fromItem(this.is);
/*     */   }
/*     */   
/*     */   public Material getBukkitMaterial() {
/* 178 */     return this.is.getType();
/*     */   }
/*     */   
/*     */   public String getName() {
/* 182 */     return (this.is.getItemMeta() != null) ? this.is.getItemMeta().getDisplayName() : null;
/*     */   }
/*     */   
/*     */   public int getAmount() {
/* 186 */     return this.is.getAmount();
/*     */   }
/*     */   
/*     */   public ArrayList<String> getLore() {
/* 190 */     return (this.is.getItemMeta() != null && this.is.getItemMeta().hasLore()) ? new ArrayList<>(this.is.getItemMeta().getLore()) : new ArrayList<>();
/*     */   }
/*     */   
/*     */   public Map<Enchantment, Integer> getEnchants() {
/* 194 */     return this.is.getEnchantments();
/*     */   }
/*     */   
/*     */   public CustomItem setPlaceholders(HashMap<String, String> paramHashMap) {
/* 198 */     for (Map.Entry<String, String> entry : paramHashMap.entrySet()) {
/* 199 */       String str1 = (String)entry.getKey();
/* 200 */       String str2 = (String)entry.getValue();
/*     */       
/* 202 */       replace(str1, str2);
/*     */     } 
/*     */     
/* 205 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem replace(String paramString1, String paramString2) {
/* 209 */     if (getName() != null) name(getName().replace(paramString1, paramString2)); 
/* 210 */     if (getSkullOwner() != null) skull(getSkullOwner().replace(paramString1, paramString2));
/*     */     
/* 212 */     ArrayList<String> arrayList = new ArrayList();
/* 213 */     for (String str : getLore()) {
/* 214 */       arrayList.add(str.replace(paramString1, paramString2));
/*     */     }
/* 216 */     lore(arrayList);
/* 217 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem showEnchantments(boolean paramBoolean) {
/* 221 */     if (this.is.getItemMeta() != null) {
/* 222 */       ItemMeta itemMeta = this.is.getItemMeta();
/* 223 */       if (paramBoolean) {
/* 224 */         itemMeta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*     */       } else {
/* 226 */         itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*     */       } 
/* 228 */       this.is.setItemMeta(itemMeta);
/*     */     } 
/*     */     
/* 231 */     return this;
/*     */   }
/*     */   
/*     */   public CustomItem showAllAttributes(boolean paramBoolean) {
/* 235 */     if (this.is.getItemMeta() != null) {
/* 236 */       ItemMeta itemMeta = this.is.getItemMeta();
/* 237 */       if (paramBoolean) {
/* 238 */         itemMeta.removeItemFlags(ItemFlag.values());
/*     */       } else {
/* 240 */         itemMeta.addItemFlags(ItemFlag.values());
/*     */       } 
/* 242 */       this.is.setItemMeta(itemMeta);
/*     */     } 
/*     */     
/* 245 */     return this;
/*     */   }
/*     */   
/*     */   public boolean equals(CustomItem paramCustomItem) {
/* 249 */     return serialize().equals(paramCustomItem.serialize());
/*     */   }
/*     */   
/*     */   public boolean isSimilar(CustomItem paramCustomItem, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 253 */     if (paramCustomItem == null) return false;
/*     */     
/* 255 */     if (paramBoolean1 && 
/* 256 */       getBukkitMaterial() != paramCustomItem.getBukkitMaterial()) {
/* 257 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 261 */     if (paramBoolean2 && 
/* 262 */       getName() != null && paramCustomItem.getName() != null && 
/* 263 */       !getName().equals(paramCustomItem.getName())) {
/* 264 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 269 */     if (paramBoolean3) {
/* 270 */       if (getLore().size() != paramCustomItem.getLore().size()) {
/* 271 */         return false;
/*     */       }
/*     */       
/* 274 */       byte b = 0;
/* 275 */       for (String str : getLore()) {
/* 276 */         if (!((String)paramCustomItem.getLore().get(b)).equals(str)) {
/* 277 */           return false;
/*     */         }
/* 279 */         b++;
/*     */       } 
/*     */     } 
/*     */     
/* 283 */     return true;
/*     */   }
/*     */   
/*     */   public JsonObject serialize() {
/* 287 */     JsonObject jsonObject = new JsonObject();
/*     */     
/*     */     try {
/* 290 */       jsonObject.addProperty("base64", ItemSerializer.itemTo64(this.is));
/* 291 */     } catch (IllegalStateException illegalStateException) {
/* 292 */       illegalStateException.printStackTrace();
/*     */     } 
/*     */     
/* 295 */     return jsonObject;
/*     */   }
/*     */   
/*     */   public static CustomItem deserialize(JsonObject paramJsonObject) {
/* 299 */     if (paramJsonObject.has("base64")) {
/*     */       try {
/* 301 */         ItemStack itemStack = ItemSerializer.itemFrom64(paramJsonObject.get("base64").getAsString());
/* 302 */         return new CustomItem(itemStack, false);
/* 303 */       } catch (IOException iOException) {
/* 304 */         iOException.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 308 */     if (paramJsonObject.toString().equals("{}")) return new CustomItem(XMaterial.STONE);
/*     */     
/* 310 */     Type type = (new TypeToken<Map<String, Object>>() {  }).getType();
/*     */     
/* 312 */     Map<String, ConfigurationSerializable> map = null;
/*     */     
/*     */     try {
/* 315 */       map = (Map)gson.fromJson(paramJsonObject.getAsJsonObject("itemInfo").toString(), type);
/* 316 */     } catch (Exception exception) {
/* 317 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 320 */     if (paramJsonObject.has("meta")) {
/* 321 */       Map<String, HashMap<Object, Object>> map1 = (Map)gson.fromJson(paramJsonObject.getAsJsonObject("meta").toString(), type);
/*     */       
/* 323 */       for (Map.Entry entry : map1.entrySet()) {
/* 324 */         if (entry.getValue() instanceof Number) {
/* 325 */           entry.setValue(convertNumber(entry.getValue()));
/*     */         }
/*     */       } 
/*     */       
/* 329 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/* 331 */       if (map1.containsKey("enchants")) {
/*     */ 
/*     */ 
/*     */         
/* 335 */         String str = map1.get("enchants").toString().replace("{", "").replace("}", "").replace("\"", "");
/*     */         
/* 337 */         for (String str1 : str.split(",")) {
/* 338 */           String[] arrayOfString = str1.split("=");
/* 339 */           Enchantment enchantment = Enchantment.getByName(arrayOfString[0]);
/* 340 */           int i = Integer.parseInt(arrayOfString[1].replace(".0", ""));
/* 341 */           if (enchantment != null) {
/* 342 */             hashMap.put(enchantment, Integer.valueOf(i));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 347 */       map1.put("enchants", hashMap);
/*     */       
/* 349 */       map.put("meta", ConfigurationSerialization.deserializeObject(map1, ConfigurationSerialization.getClassByAlias("ItemMeta")));
/*     */     } 
/*     */     
/* 352 */     return new CustomItem(ItemStack.deserialize(map), false);
/*     */   }
/*     */   
/*     */   private static Number convertNumber(Object paramObject) {
/* 356 */     Number number = (Number)paramObject;
/* 357 */     if (number instanceof Long) {
/* 358 */       Long long_ = (Long)number;
/* 359 */       if (long_.longValue() == long_.intValue()) {
/* 360 */         return Integer.valueOf(long_.intValue());
/*     */       }
/*     */     } 
/*     */     
/* 364 */     if (number instanceof Float) {
/* 365 */       Float float_ = (Float)number;
/* 366 */       if (float_.floatValue() == float_.intValue()) {
/* 367 */         return Integer.valueOf(float_.intValue());
/*     */       }
/*     */     } 
/*     */     
/* 371 */     if (number instanceof Double) {
/* 372 */       Double double_ = (Double)number;
/* 373 */       if (double_.doubleValue() == double_.intValue()) {
/* 374 */         return Integer.valueOf(double_.intValue());
/*     */       }
/*     */     } 
/*     */     
/* 378 */     return number;
/*     */   }
/*     */   
/*     */   public CustomItem clone() {
/* 382 */     return new CustomItem(this.is.clone(), false);
/*     */   }
/*     */   
/*     */   public ItemStack get() {
/* 386 */     return this.is.clone();
/*     */   }
/*     */   
/*     */   public void setBukkitStack(ItemStack paramItemStack) {
/* 390 */     this.is = paramItemStack;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/item/CustomItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */