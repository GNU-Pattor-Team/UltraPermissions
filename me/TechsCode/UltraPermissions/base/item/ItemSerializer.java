/*    */ package me.TechsCode.UltraPermissions.base.item;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.util.io.BukkitObjectInputStream;
/*    */ import org.bukkit.util.io.BukkitObjectOutputStream;
/*    */ import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
/*    */ 
/*    */ 
/*    */ public class ItemSerializer
/*    */ {
/*    */   public static String itemTo64(ItemStack paramItemStack) {
/*    */     try {
/* 16 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 17 */       BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(byteArrayOutputStream);
/* 18 */       bukkitObjectOutputStream.writeObject(paramItemStack);
/*    */ 
/*    */       
/* 21 */       bukkitObjectOutputStream.close();
/* 22 */       return Base64Coder.encodeLines(byteArrayOutputStream.toByteArray());
/* 23 */     } catch (Exception exception) {
/* 24 */       throw new IllegalStateException("Unable to save item stack.", exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ItemStack itemFrom64(String paramString) {
/*    */     try {
/* 30 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64Coder.decodeLines(paramString));
/* 31 */       BukkitObjectInputStream bukkitObjectInputStream = new BukkitObjectInputStream(byteArrayInputStream);
/*    */       try {
/* 33 */         return (ItemStack)bukkitObjectInputStream.readObject();
/*    */       } finally {
/* 35 */         bukkitObjectInputStream.close();
/*    */       } 
/* 37 */     } catch (ClassNotFoundException classNotFoundException) {
/* 38 */       throw new IOException("Unable to decode class type.", classNotFoundException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/item/ItemSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */