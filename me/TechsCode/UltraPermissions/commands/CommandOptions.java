/*    */ package me.TechsCode.UltraPermissions.commands;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*    */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*    */ import me.TechsCode.UltraPermissions.base.networking.NServer;
/*    */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*    */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandOptions
/*    */ {
/*    */   public CommandOptions(UltraPermissions paramUltraPermissions, List<String> paramList) {
/* 22 */     this(paramUltraPermissions, paramList.<String>toArray(new String[0]));
/*    */   }
/*    */ 
/*    */   
/* 26 */   private String world = null;
/* 27 */   private String server = null;
/* 28 */   private long expiration = 0L;
/*    */   public CommandOptions(UltraPermissions paramUltraPermissions, String[] paramArrayOfString) {
/* 30 */     if (ArrayUtils.contains((Object[])paramArrayOfString, "local")) this.server = paramUltraPermissions.getThisServer().map(NServer::getName).orElse(null);
/*    */     
/* 32 */     if (ArrayUtils.contains((Object[])paramArrayOfString, "bungee")) this.server = "BungeeCord";
/*    */     
/* 34 */     this.secs = Tools.getTimeSecondsFromString(String.join(" ", (CharSequence[])paramArrayOfString));
/*    */     
/* 36 */     if (this.secs != 0L) {
/* 37 */       this.expiration = System.currentTimeMillis() + this.secs * 1000L;
/*    */     }
/*    */     
/* 40 */     for (World world : Bukkit.getWorlds()) {
/* 41 */       if (ArrayUtils.contains((Object[])paramArrayOfString, world.getName()))
/* 42 */         this.world = world.getName(); 
/*    */     } 
/*    */   }
/*    */   private final long secs;
/*    */   
/*    */   public String getWorld() {
/* 48 */     return this.world;
/*    */   }
/*    */   
/*    */   public String getServer() {
/* 52 */     return this.server;
/*    */   }
/*    */   
/*    */   public long getExpiration() {
/* 56 */     return this.expiration;
/*    */   }
/*    */   
/*    */   public long getSecs() {
/* 60 */     return this.secs;
/*    */   }
/*    */   
/*    */   public String getCombinedInfo() {
/* 64 */     ArrayList<String> arrayList = new ArrayList();
/*    */     
/* 66 */     if (this.expiration != 0L) arrayList.add(Tools.getTimeString(this.secs)); 
/* 67 */     if (this.server != null) arrayList.add(this.server); 
/* 68 */     if (this.world != null) arrayList.add(this.world);
/*    */     
/* 70 */     if (arrayList.isEmpty()) return "";
/*    */     
/* 72 */     return Colors.GRAY + "(" + Colors.YELLOW + String.join(Colors.DARK_GRAY + " | " + Colors.YELLOW, (Iterable)arrayList) + Colors.GRAY + ")";
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/commands/CommandOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */