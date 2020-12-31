/*     */ package me.TechsCode.UltraPermissions.base.reflection.titleAndActionbar;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Text;
/*     */ import net.md_5.bungee.api.ChatMessageType;
/*     */ import net.md_5.bungee.api.chat.TextComponent;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ public class ActionBar
/*     */ {
/*     */   private static SpigotTechPlugin plugin;
/*     */   private static String nmsver;
/*     */   private static boolean useOldMethods;
/*     */   
/*     */   public ActionBar(SpigotTechPlugin paramSpigotTechPlugin) {
/*  21 */     plugin = paramSpigotTechPlugin;
/*     */     
/*  23 */     if (nmsver == null) {
/*  24 */       nmsver = Bukkit.getServer().getClass().getPackage().getName();
/*  25 */       nmsver = nmsver.substring(nmsver.lastIndexOf(".") + 1);
/*     */       
/*  27 */       if (nmsver.equalsIgnoreCase("v1_8_R1") || nmsver.startsWith("v1_7_")) {
/*  28 */         useOldMethods = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendActionBar(Player paramPlayer, String paramString) {
/*  34 */     sendActionBarNoColorReplacement(paramPlayer, Text.color(paramString));
/*     */   }
/*     */   
/*     */   public void sendActionBarNoColorReplacement(Player paramPlayer, String paramString) {
/*     */     try {
/*  39 */       paramPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(paramString));
/*  40 */     } catch (NoSuchMethodError noSuchMethodError) {
/*     */       try {
/*  42 */         Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
/*  43 */       } catch (ClassNotFoundException classNotFoundException) {
/*     */         return;
/*     */       } 
/*     */       try {
/*     */         Object object;
/*  48 */         Class<?> clazz1 = Class.forName("org.bukkit.craftbukkit." + nmsver + ".entity.CraftPlayer");
/*  49 */         Object object1 = clazz1.cast(paramPlayer);
/*  50 */         Class<?> clazz2 = Class.forName("net.minecraft.server." + nmsver + ".PacketPlayOutChat");
/*  51 */         Class<?> clazz3 = Class.forName("net.minecraft.server." + nmsver + ".Packet");
/*     */ 
/*     */         
/*  54 */         if (useOldMethods) {
/*  55 */           Class<?> clazz4 = Class.forName("net.minecraft.server." + nmsver + ".ChatSerializer");
/*  56 */           Class<?> clazz5 = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
/*  57 */           Method method = clazz4.getDeclaredMethod("a", new Class[] { String.class });
/*  58 */           Object object4 = clazz5.cast(method.invoke(clazz4, new Object[] { "{\"text\": \"" + paramString + "\"}" }));
/*  59 */           object = clazz2.getConstructor(new Class[] { clazz5, byte.class }).newInstance(new Object[] { object4, Byte.valueOf((byte)2) });
/*     */         } else {
/*  61 */           Class<?> clazz4 = Class.forName("net.minecraft.server." + nmsver + ".ChatComponentText");
/*  62 */           Class<?> clazz5 = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
/*     */           try {
/*  64 */             Class<?> clazz = Class.forName("net.minecraft.server." + nmsver + ".ChatMessageType");
/*  65 */             Object[] arrayOfObject = clazz.getEnumConstants();
/*  66 */             Object object4 = null;
/*  67 */             for (Object object6 : arrayOfObject) {
/*  68 */               if (object6.toString().equals("GAME_INFO")) {
/*  69 */                 object4 = object6;
/*     */               }
/*     */             } 
/*  72 */             Object object5 = clazz4.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
/*  73 */             object = clazz2.getConstructor(new Class[] { clazz5, clazz }).newInstance(new Object[] { object5, object4 });
/*     */           }
/*  75 */           catch (ClassNotFoundException classNotFoundException) {
/*  76 */             Object object4 = clazz4.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
/*  77 */             object = clazz2.getConstructor(new Class[] { clazz5, byte.class }).newInstance(new Object[] { object4, Byte.valueOf((byte)2) });
/*     */           } 
/*     */         } 
/*  80 */         Method method1 = clazz1.getDeclaredMethod("getHandle", new Class[0]);
/*  81 */         Object object2 = method1.invoke(object1, new Object[0]);
/*  82 */         Field field = object2.getClass().getDeclaredField("playerConnection");
/*  83 */         Object object3 = field.get(object2);
/*  84 */         Method method2 = object3.getClass().getDeclaredMethod("sendPacket", new Class[] { clazz3 });
/*  85 */         method2.invoke(object3, new Object[] { object });
/*  86 */       } catch (Exception exception) {
/*  87 */         noSuchMethodError.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendActionBar(final Player p, final String message, int paramInt) {
/*  93 */     sendActionBar(p, message);
/*  94 */     if (paramInt >= 0) {
/*  95 */       (new BukkitRunnable() {
/*     */           public void run() {
/*  97 */             ActionBar.this.sendActionBar(p, "");
/*     */           }
/*  99 */         }).runTaskLater((Plugin)plugin.getBootstrap(), (paramInt + 1));
/*     */     }
/* 101 */     while (paramInt > 40) {
/* 102 */       paramInt -= 40;
/* 103 */       (new BukkitRunnable() {
/*     */           public void run() {
/* 105 */             ActionBar.this.sendActionBar(p, message);
/*     */           }
/* 107 */         }).runTaskLater((Plugin)plugin.getBootstrap(), paramInt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sendActionBarToAllPlayers(String paramString) {
/* 112 */     sendActionBarToAllPlayers(paramString, -1);
/*     */   }
/*     */   
/*     */   public void sendActionBarToAllPlayers(String paramString, int paramInt) {
/* 116 */     for (Player player : Bukkit.getOnlinePlayers())
/* 117 */       sendActionBar(player, paramString, paramInt); 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/reflection/titleAndActionbar/ActionBar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */