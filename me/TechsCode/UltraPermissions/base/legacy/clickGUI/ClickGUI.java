/*     */ package me.TechsCode.UltraPermissions.base.legacy.clickGUI;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateEvent;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateTime;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.utils.Armorstands;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.entity.ArmorStand;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.HandlerList;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ 
/*     */ public abstract class ClickGUI
/*     */   implements Listener
/*     */ {
/*     */   protected Player p;
/*     */   private SpigotTechPlugin plugin;
/*     */   private HashMap<FloatingElement, ArmorStand> items;
/*     */   private boolean opened;
/*     */   private double offsetDegree;
/*     */   private FloatingElement currentlyHovering;
/*     */   
/*     */   public ClickGUI(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/*  34 */     this.p = paramPlayer;
/*  35 */     this.plugin = paramSpigotTechPlugin;
/*     */     
/*  37 */     this.items = new HashMap<>();
/*     */     
/*  39 */     this.opened = false;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void draw(UpdateEvent paramUpdateEvent) {
/*  44 */     if (paramUpdateEvent.getUpdateTime() != UpdateTime.TWOTICKS) {
/*     */       return;
/*     */     }
/*     */     
/*  48 */     redraw();
/*     */   }
/*     */   
/*     */   protected void redraw() {
/*  52 */     if (isFixed()) {
/*  53 */       this.offsetDegree = this.p.getLocation().getYaw();
/*     */     }
/*     */     
/*  56 */     double d = 0.0D;
/*  57 */     FloatingElement floatingElement = null;
/*     */     
/*  59 */     for (Map.Entry<FloatingElement, ArmorStand> entry : this.items.entrySet()) {
/*  60 */       FloatingElement floatingElement1 = (FloatingElement)entry.getKey();
/*     */ 
/*     */       
/*  63 */       Location location1 = this.p.getEyeLocation();
/*  64 */       Vector vector1 = this.p.getEyeLocation().getDirection().multiply(floatingElement1.getRadius());
/*  65 */       location1.add(vector1);
/*     */ 
/*     */       
/*  68 */       double d1 = this.offsetDegree + 90.0D + floatingElement1.getX() * 10.0D;
/*     */       
/*  70 */       double d2 = Math.toRadians(d1);
/*  71 */       double d3 = Math.cos(d2);
/*  72 */       double d4 = floatingElement1.getY();
/*  73 */       double d5 = Math.sin(d2);
/*     */       
/*  75 */       Vector vector2 = new Vector(d3, 0.0D, d5);
/*  76 */       vector2.multiply(floatingElement1.getRadius());
/*     */       
/*  78 */       Location location2 = this.p.getEyeLocation();
/*  79 */       location2.add(vector2);
/*  80 */       location2.subtract(0.0D, d4, 0.0D);
/*     */ 
/*     */       
/*  83 */       if (floatingElement1.isShown()) {
/*  84 */         double d6 = location2.distance(location1);
/*  85 */         if (floatingElement == null || d6 < d) {
/*  86 */           d = d6;
/*  87 */           floatingElement = (FloatingElement)entry.getKey();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  92 */       location2.subtract(0.0D, floatingElement1.getYOffset(), 0.0D);
/*  93 */       ArmorStand armorStand = (ArmorStand)entry.getValue();
/*     */ 
/*     */       
/*  96 */       if (((FloatingElement)entry.getKey()).isShown()) {
/*  97 */         if (armorStand == null) {
/*  98 */           armorStand = (ArmorStand)location2.getWorld().spawn(location2, ArmorStand.class);
/*  99 */           armorStand.setGravity(false);
/* 100 */           armorStand.setVisible(false);
/* 101 */           armorStand.setBasePlate(false);
/* 102 */           entry.setValue(armorStand);
/*     */         } else {
/* 104 */           Armorstands.move(armorStand, location2);
/*     */         }
/*     */       
/*     */       }
/* 108 */       else if (armorStand != null) {
/* 109 */         if (armorStand.getPassenger() != null) armorStand.getPassenger().remove(); 
/* 110 */         armorStand.remove();
/* 111 */         entry.setValue(null);
/*     */       } 
/*     */ 
/*     */       
/* 115 */       ((FloatingElement)entry.getKey()).apply(armorStand);
/*     */     } 
/*     */ 
/*     */     
/* 119 */     if (d < 0.5D) {
/* 120 */       this.currentlyHovering = floatingElement;
/* 121 */       this.currentlyHovering.hovering(true);
/*     */     } else {
/* 123 */       this.currentlyHovering = null;
/*     */     } 
/*     */     
/* 126 */     this.items.keySet().stream().filter(paramFloatingElement -> (this.currentlyHovering == null || !paramFloatingElement.equals(this.currentlyHovering))).forEach(paramFloatingElement -> paramFloatingElement.hovering(false));
/*     */   }
/*     */   
/*     */   protected void addItem(FloatingElement paramFloatingElement) {
/* 130 */     this.items.put(paramFloatingElement, null);
/*     */   }
/*     */   
/*     */   protected void removeItem(FloatingElement paramFloatingElement) {
/* 134 */     ArmorStand armorStand = this.items.get(paramFloatingElement);
/*     */     
/* 136 */     if (armorStand != null) {
/* 137 */       if (armorStand.getPassenger() != null) armorStand.getPassenger().remove(); 
/* 138 */       armorStand.remove();
/*     */     } 
/*     */     
/* 141 */     this.items.remove(paramFloatingElement);
/*     */   }
/*     */   
/*     */   protected FloatingElement[] getItems() {
/* 145 */     return (FloatingElement[])this.items.keySet().toArray((Object[])new FloatingElement[this.items.size()]);
/*     */   }
/*     */   
/*     */   protected void clear() {
/* 149 */     Arrays.<FloatingElement>stream(getItems()).forEach(paramFloatingElement -> removeItem(paramFloatingElement));
/*     */   }
/*     */   
/*     */   protected void open() {
/* 153 */     if (this.opened)
/*     */       return; 
/* 155 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)this.plugin.getBootstrap());
/* 156 */     this.opened = true;
/* 157 */     this.offsetDegree = this.p.getLocation().getYaw();
/*     */   }
/*     */   
/*     */   protected void close() {
/* 161 */     if (!this.opened)
/*     */       return; 
/* 163 */     HandlerList.unregisterAll(this);
/*     */     
/* 165 */     Arrays.<FloatingElement>stream(getItems()).forEach(paramFloatingElement -> removeItem(paramFloatingElement));
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void interact(PlayerInteractEvent paramPlayerInteractEvent) {
/* 170 */     if (!paramPlayerInteractEvent.getPlayer().equals(this.p)) {
/*     */       return;
/*     */     }
/*     */     
/* 174 */     if (paramPlayerInteractEvent.getAction() == Action.LEFT_CLICK_AIR && 
/* 175 */       this.currentlyHovering != null) {
/* 176 */       this.currentlyHovering.click();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected FloatingElement getCursor() {
/* 182 */     return this.currentlyHovering;
/*     */   }
/*     */   
/*     */   public abstract boolean isFixed();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/clickGUI/ClickGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */