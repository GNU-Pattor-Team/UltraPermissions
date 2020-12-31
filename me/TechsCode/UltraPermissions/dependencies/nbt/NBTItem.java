/*     */ package me.TechsCode.UltraPermissions.dependencies.nbt;
/*     */ 
/*     */ import me.TechsCode.UltraPermissions.dependencies.nbt.utils.nmsmappings.ReflectionMethod;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NBTItem
/*     */   extends NBTCompound
/*     */ {
/*     */   private ItemStack bukkitItem;
/*     */   private boolean directApply;
/*  20 */   private ItemStack originalSrcStack = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTItem(ItemStack paramItemStack) {
/*  28 */     this(paramItemStack, false);
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
/*     */   public NBTItem(ItemStack paramItemStack, boolean paramBoolean) {
/*  40 */     super(null, null);
/*  41 */     if (paramItemStack == null || paramItemStack.getType() == Material.AIR) {
/*  42 */       throw new NullPointerException("ItemStack can't be null/Air!");
/*     */     }
/*  44 */     this.directApply = paramBoolean;
/*  45 */     this.bukkitItem = paramItemStack.clone();
/*  46 */     if (paramBoolean) {
/*  47 */       this.originalSrcStack = paramItemStack;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getCompound() {
/*  53 */     return NBTReflectionUtil.getItemRootNBTTagCompound(ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, new Object[] { this.bukkitItem }));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setCompound(Object paramObject) {
/*  58 */     Object object = ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, new Object[] { this.bukkitItem });
/*  59 */     ReflectionMethod.ITEMSTACK_SET_TAG.run(object, new Object[] { paramObject });
/*  60 */     this.bukkitItem = (ItemStack)ReflectionMethod.ITEMSTACK_BUKKITMIRROR.run(null, new Object[] { object });
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
/*     */   public void applyNBT(ItemStack paramItemStack) {
/*  73 */     if (paramItemStack == null || paramItemStack.getType() == Material.AIR) {
/*  74 */       throw new NullPointerException("ItemStack can't be null/Air!");
/*     */     }
/*  76 */     NBTItem nBTItem = new NBTItem(new ItemStack(paramItemStack.getType()));
/*  77 */     nBTItem.mergeCompound(this);
/*  78 */     paramItemStack.setItemMeta(nBTItem.getItem().getItemMeta());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mergeNBT(ItemStack paramItemStack) {
/*  87 */     NBTItem nBTItem = new NBTItem(paramItemStack);
/*  88 */     nBTItem.mergeCompound(this);
/*  89 */     paramItemStack.setItemMeta(nBTItem.getItem().getItemMeta());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mergeCustomNBT(ItemStack paramItemStack) {
/*  98 */     if (paramItemStack == null || paramItemStack.getType() == Material.AIR) {
/*  99 */       throw new NullPointerException("ItemStack can't be null/Air!");
/*     */     }
/* 101 */     ItemMeta itemMeta = paramItemStack.getItemMeta();
/* 102 */     NBTReflectionUtil.getUnhandledNBTTags(itemMeta).putAll(NBTReflectionUtil.getUnhandledNBTTags(this.bukkitItem.getItemMeta()));
/* 103 */     paramItemStack.setItemMeta(itemMeta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearCustomNBT() {
/* 110 */     ItemMeta itemMeta = this.bukkitItem.getItemMeta();
/* 111 */     NBTReflectionUtil.getUnhandledNBTTags(itemMeta).clear();
/* 112 */     this.bukkitItem.setItemMeta(itemMeta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getItem() {
/* 119 */     return this.bukkitItem;
/*     */   }
/*     */   
/*     */   protected void setItem(ItemStack paramItemStack) {
/* 123 */     this.bukkitItem = paramItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNBTData() {
/* 132 */     return (getCompound() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NBTContainer convertItemtoNBT(ItemStack paramItemStack) {
/* 143 */     return NBTReflectionUtil.convertNMSItemtoNBTCompound(ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, new Object[] { paramItemStack }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemStack convertNBTtoItem(NBTCompound paramNBTCompound) {
/* 154 */     return (ItemStack)ReflectionMethod.ITEMSTACK_BUKKITMIRROR.run(null, new Object[] {
/* 155 */           NBTReflectionUtil.convertNBTCompoundtoNMSItem(paramNBTCompound)
/*     */         });
/*     */   }
/*     */   
/*     */   protected void saveCompound() {
/* 160 */     if (this.directApply)
/* 161 */       applyNBT(this.originalSrcStack); 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/NBTItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */