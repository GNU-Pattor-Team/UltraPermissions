/*     */ package me.TechsCode.UltraPermissions.base.reflection.titleAndActionbar;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Title
/*     */ {
/*     */   public static void sendPacket(Player paramPlayer, Object paramObject) {
/*     */     try {
/*  19 */       Object object1 = paramPlayer.getClass().getMethod("getHandle", new Class[0]).invoke(paramPlayer, new Object[0]);
/*  20 */       Object object2 = object1.getClass().getField("playerConnection").get(object1);
/*  21 */       object2.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(object2, new Object[] { paramObject });
/*     */     }
/*  23 */     catch (Exception exception) {
/*     */       
/*  25 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Class<?> getNMSClass(String paramString) {
/*  31 */     String str = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
/*     */     
/*     */     try {
/*  34 */       return Class.forName("net.minecraft.server." + str + "." + paramString);
/*     */     }
/*  36 */     catch (ClassNotFoundException classNotFoundException) {
/*     */       
/*  38 */       classNotFoundException.printStackTrace();
/*     */       
/*  40 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void sendTitle(Player paramPlayer, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString) {
/*  45 */     sendTitle(paramPlayer, paramInteger1, paramInteger2, paramInteger3, paramString, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendSubtitle(Player paramPlayer, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString) {
/*  50 */     sendTitle(paramPlayer, paramInteger1, paramInteger2, paramInteger3, null, paramString);
/*     */   }
/*     */   
/*     */   public static void sendFullTitle(Player paramPlayer, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2) {
/*  54 */     sendTitle(paramPlayer, paramInteger1, paramInteger2, paramInteger3, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sendTitle(Player paramPlayer, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2) {
/*     */     try {
/*  61 */       Method method = paramPlayer.getClass().getDeclaredMethod("sendTitle", new Class[] { String.class, String.class, int.class, int.class, int.class });
/*     */       
/*  63 */       if (method != null) {
/*  64 */         method.invoke(paramPlayer, new Object[] { paramString1, paramString2, paramInteger1, paramInteger2, paramInteger3 });
/*     */         return;
/*     */       } 
/*  67 */     } catch (NoSuchMethodException|java.lang.reflect.InvocationTargetException|IllegalAccessException noSuchMethodException) {}
/*     */ 
/*     */     
/*     */     try {
/*  71 */       if (paramString1 != null) {
/*     */         
/*  73 */         paramString1 = ChatColor.translateAlternateColorCodes('&', paramString1);
/*  74 */         paramString1 = paramString1.replaceAll("%player%", paramPlayer.getDisplayName());
/*     */         
/*  76 */         Object object1 = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
/*  77 */         Object object2 = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + paramString1 + "\"}" });
/*  78 */         Constructor<?> constructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
/*  79 */         Object object3 = constructor.newInstance(new Object[] { object1, object2, paramInteger1, paramInteger2, paramInteger3 });
/*  80 */         sendPacket(paramPlayer, object3);
/*     */         
/*  82 */         object1 = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
/*  83 */         object2 = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + paramString1 + "\"}" });
/*  84 */         constructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent") });
/*  85 */         object3 = constructor.newInstance(new Object[] { object1, object2 });
/*  86 */         sendPacket(paramPlayer, object3);
/*     */       } 
/*  88 */       if (paramString2 != null)
/*     */       {
/*  90 */         paramString2 = ChatColor.translateAlternateColorCodes('&', paramString2);
/*  91 */         paramString2 = paramString2.replaceAll("%player%", paramPlayer.getDisplayName());
/*     */         
/*  93 */         Object object1 = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
/*  94 */         Object object2 = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + paramString1 + "\"}" });
/*  95 */         Constructor<?> constructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
/*  96 */         Object object3 = constructor.newInstance(new Object[] { object1, object2, paramInteger1, paramInteger2, paramInteger3 });
/*  97 */         sendPacket(paramPlayer, object3);
/*     */         
/*  99 */         object1 = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
/* 100 */         object2 = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + paramString2 + "\"}" });
/* 101 */         constructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class });
/* 102 */         object3 = constructor.newInstance(new Object[] { object1, object2, paramInteger1, paramInteger2, paramInteger3 });
/* 103 */         sendPacket(paramPlayer, object3);
/*     */       }
/*     */     
/* 106 */     } catch (Exception exception) {
/*     */       
/* 108 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearTitle(Player paramPlayer) {
/* 114 */     sendTitle(paramPlayer, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), "", "");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendTabTitle(Player paramPlayer, String paramString1, String paramString2) {
/* 119 */     if (paramString1 == null) {
/* 120 */       paramString1 = "";
/*     */     }
/* 122 */     paramString1 = ChatColor.translateAlternateColorCodes('&', paramString1);
/* 123 */     if (paramString2 == null) {
/* 124 */       paramString2 = "";
/*     */     }
/* 126 */     paramString2 = ChatColor.translateAlternateColorCodes('&', paramString2);
/*     */     
/* 128 */     paramString1 = paramString1.replaceAll("%player%", paramPlayer.getDisplayName());
/* 129 */     paramString2 = paramString2.replaceAll("%player%", paramPlayer.getDisplayName());
/*     */     
/*     */     try {
/* 132 */       Object object1 = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + paramString1 + "\"}" });
/* 133 */       Object object2 = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + paramString2 + "\"}" });
/* 134 */       Constructor<?> constructor = getNMSClass("PacketPlayOutPlayerListHeaderFooter").getConstructor(new Class[0]);
/* 135 */       Object object3 = constructor.newInstance(new Object[0]);
/* 136 */       Field field1 = object3.getClass().getDeclaredField("a");
/* 137 */       field1.setAccessible(true);
/* 138 */       field1.set(object3, object1);
/* 139 */       Field field2 = object3.getClass().getDeclaredField("b");
/* 140 */       field2.setAccessible(true);
/* 141 */       field2.set(object3, object2);
/* 142 */       sendPacket(paramPlayer, object3);
/*     */     }
/* 144 */     catch (Exception exception) {
/*     */       
/* 146 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/reflection/titleAndActionbar/Title.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */