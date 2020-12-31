/*     */ package me.TechsCode.UltraPermissions.base.views;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateEvent;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.task.UpdateTime;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ 
/*     */ public class RestartView extends GUI {
/*  24 */   private static final Phrase TITLE = Phrase.create("restartView.title", "Restart the Server");
/*  25 */   private static final Phrase RESTARTING = Phrase.create("restartView.restarting", "Restarting...");
/*     */   
/*  27 */   private static final Phrase RESTART_BUTTON_TITLE = Phrase.create("restartView.button.title", "Restart");
/*  28 */   private static final Phrase RESTART_BUTTON_ACTION = Phrase.create("restartView.button.action", "Click to restart the Server", Colors.GRAY, new Color[0]);
/*     */   
/*     */   private boolean restarting;
/*     */   
/*     */   private final List<Integer> red;
/*     */   private final List<Integer> orange;
/*     */   private final List<Integer> yellow;
/*     */   private final List<Integer> green;
/*     */   
/*     */   public RestartView(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/*  38 */     super(paramPlayer, paramSpigotTechPlugin);
/*     */     
/*  40 */     this.restarting = false;
/*     */     
/*  42 */     this.red = new ArrayList<>();
/*  43 */     this.orange = new ArrayList<>();
/*  44 */     this.yellow = new ArrayList<>();
/*  45 */     this.green = new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  50 */     paramModel.setSlots(27);
/*     */     
/*  52 */     if (!this.restarting) {
/*  53 */       paramModel.setTitle(TITLE.get());
/*  54 */       paramModel.button(14, this::RestartButton);
/*     */       
/*     */       return;
/*     */     } 
/*  58 */     paramModel.setTitle(RESTARTING.get());
/*     */     Iterator<Integer> iterator;
/*  60 */     for (iterator = this.red.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  61 */       paramModel.button(i, paramButton -> TileButton(paramButton, XMaterial.RED_STAINED_GLASS_PANE, Colors.RED)); }
/*     */ 
/*     */     
/*  64 */     for (iterator = this.orange.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  65 */       paramModel.button(i, paramButton -> TileButton(paramButton, XMaterial.ORANGE_STAINED_GLASS_PANE, Colors.GOLD)); }
/*     */ 
/*     */     
/*  68 */     for (iterator = this.yellow.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  69 */       paramModel.button(i, paramButton -> TileButton(paramButton, XMaterial.YELLOW_STAINED_GLASS_PANE, Colors.YELLOW)); }
/*     */ 
/*     */     
/*  72 */     for (iterator = this.green.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  73 */       paramModel.button(i, paramButton -> TileButton(paramButton, XMaterial.LIME_STAINED_GLASS_PANE, Colors.GREEN)); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private void TileButton(Button paramButton, XMaterial paramXMaterial, Color paramColor) {
/*  79 */     paramButton.material(paramXMaterial)
/*  80 */       .name(Animation.wave(RESTARTING.get(), new Color[] { paramColor, Colors.WHITE }));
/*     */   }
/*     */   
/*     */   private void RestartButton(Button paramButton) {
/*  84 */     paramButton.material(XMaterial.EMERALD_BLOCK)
/*  85 */       .name(Animation.fading(RESTART_BUTTON_TITLE.get(), new Color[] { Colors.GREEN, Colors.WHITE
/*  86 */           })).lore(new String[] { RESTART_BUTTON_ACTION.get() });
/*     */     
/*  88 */     paramButton.action(paramActionType -> this.restarting = true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void update(UpdateEvent paramUpdateEvent) {
/*  95 */     if (paramUpdateEvent.getUpdateTime() != UpdateTime.TICK) {
/*     */       return;
/*     */     }
/*     */     
/*  99 */     if (!this.restarting) {
/*     */       return;
/*     */     }
/*     */     
/* 103 */     if (this.green.size() == getCurrentSlots()) {
/* 104 */       Bukkit.shutdown();
/*     */       
/*     */       return;
/*     */     } 
/* 108 */     int i = 0;
/*     */     
/* 110 */     while (!i || this.green.contains(Integer.valueOf(i))) {
/* 111 */       i = (new Random()).nextInt(getCurrentSlots()) + 1;
/*     */     }
/*     */     
/* 114 */     if (this.yellow.contains(Integer.valueOf(i))) {
/* 115 */       this.yellow.remove(Integer.valueOf(i));
/* 116 */       this.green.add(Integer.valueOf(i));
/*     */       
/*     */       return;
/*     */     } 
/* 120 */     if (this.orange.contains(Integer.valueOf(i))) {
/* 121 */       this.orange.remove(Integer.valueOf(i));
/* 122 */       this.yellow.add(Integer.valueOf(i));
/*     */       
/*     */       return;
/*     */     } 
/* 126 */     if (this.red.contains(Integer.valueOf(i))) {
/* 127 */       this.red.remove(Integer.valueOf(i));
/* 128 */       this.orange.add(Integer.valueOf(i));
/*     */       
/*     */       return;
/*     */     } 
/* 132 */     this.red.add(Integer.valueOf(i));
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/RestartView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */