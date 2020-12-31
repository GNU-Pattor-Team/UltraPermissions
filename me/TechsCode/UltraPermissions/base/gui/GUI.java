/*     */ package me.TechsCode.UltraPermissions.base.gui;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.scheduler.RecurringTask;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.HandlerList;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.inventory.InventoryCloseEvent;
/*     */ import org.bukkit.event.inventory.InventoryDragEvent;
/*     */ import org.bukkit.event.inventory.InventoryType;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ public abstract class GUI
/*     */   implements Listener
/*     */ {
/*     */   protected Player p;
/*     */   private final SpigotTechPlugin plugin;
/*     */   private boolean stopped;
/*     */   private RecurringTask recurringTask;
/*     */   private Inventory inventory;
/*     */   private HashMap<Integer, List<Action>> actions;
/*     */   
/*     */   public GUI(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/*  32 */     this.p = paramPlayer;
/*  33 */     this.plugin = paramSpigotTechPlugin;
/*     */     
/*  35 */     this.recurringTask = paramSpigotTechPlugin.getScheduler().runTaskTimer(() -> { if (this.stopped) { this.recurringTask.stop(); HandlerList.unregisterAll(this); return; }  Model model = new Model(); model.setTitle(getCurrentTitle()); model.setSlots(getCurrentSlots()); construct(model); if (this.inventory == null || !paramPlayer.getOpenInventory().getTitle().equals(model.getTitle()) || this.inventory.getSize() != model.getSlots()) { this.inventory = Bukkit.createInventory(null, model.getSlots(), model.getTitle()); paramPlayer.openInventory(this.inventory); }  HashMap<Integer, Entry> hashMap = model.getEntries(); for (byte b = 1; b <= this.inventory.getSize(); b++) { if (!hashMap.containsKey(Integer.valueOf(b))) this.inventory.clear(b - 1);  }  this.actions = new HashMap<>(); hashMap.forEach(()); paramPlayer.updateInventory(); }0L, 1L);
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
/*  78 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)paramSpigotTechPlugin.getBootstrap());
/*     */   }
/*     */   
/*     */   public void preventOpening() {
/*  82 */     this.stopped = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reopen() {
/*  88 */     if (this.inventory != null)
/*     */       return; 
/*  90 */     this.recurringTask.start();
/*  91 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)this.plugin.getBootstrap());
/*     */   }
/*     */   
/*     */   private void close() {
/*  95 */     this.inventory = null;
/*  96 */     this.recurringTask.stop();
/*  97 */     HandlerList.unregisterAll(this);
/*     */     
/*  99 */     onClose();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void click(InventoryClickEvent paramInventoryClickEvent) {
/* 104 */     if (!paramInventoryClickEvent.getWhoClicked().equals(this.p)) {
/*     */       return;
/*     */     }
/* 107 */     if (paramInventoryClickEvent.getSlotType() == InventoryType.SlotType.OUTSIDE) {
/* 108 */       paramInventoryClickEvent.setCancelled(true);
/*     */       
/*     */       return;
/*     */     } 
/* 112 */     paramInventoryClickEvent.setCancelled(true);
/*     */     
/* 114 */     if (!(paramInventoryClickEvent.getClickedInventory() instanceof org.bukkit.inventory.PlayerInventory) && 
/* 115 */       this.actions.containsKey(Integer.valueOf(paramInventoryClickEvent.getSlot()))) {
/* 116 */       ActionType actionType = ActionType.fromClickType(paramInventoryClickEvent.getClick());
/* 117 */       ((List)this.actions.get(Integer.valueOf(paramInventoryClickEvent.getSlot()))).forEach(paramAction -> paramAction.onClick(paramActionType));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void drag(InventoryDragEvent paramInventoryDragEvent) {
/* 124 */     if (!paramInventoryDragEvent.getWhoClicked().equals(this.p))
/*     */       return; 
/* 126 */     if (paramInventoryDragEvent.getInventory() instanceof org.bukkit.inventory.PlayerInventory)
/*     */       return; 
/* 128 */     if (paramInventoryDragEvent.getInventorySlots().size() > 1) {
/* 129 */       paramInventoryDragEvent.setCancelled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void leave(PlayerQuitEvent paramPlayerQuitEvent) {
/* 135 */     if (paramPlayerQuitEvent.getPlayer().equals(this.p)) close(); 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void close(InventoryCloseEvent paramInventoryCloseEvent) {
/* 140 */     if (this.inventory != null && this.inventory.equals(paramInventoryCloseEvent.getInventory())) {
/* 141 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getCurrentSlots() {
/* 146 */     return 27;
/*     */   }
/*     */   
/*     */   public String getCurrentTitle() {
/* 150 */     return "Unnamed Inventory";
/*     */   }
/*     */   
/*     */   public void onClose() {}
/*     */   
/*     */   protected abstract void construct(Model paramModel);
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/gui/GUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */