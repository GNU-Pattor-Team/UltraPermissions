/*     */ package me.TechsCode.UltraPermissions.base.views;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class TimePickerView extends GUI {
/*  16 */   private static final Phrase REMOVE_SECOND_ = Phrase.create("timePickerView.removeSecond", "Remove 1 Second");
/*  17 */   private static final Phrase REMOVE_MINUTE_ = Phrase.create("timePickerView.removeMinute", "Remove 1 Minute");
/*  18 */   private static final Phrase REMOVE_HOUR_ = Phrase.create("timePickerView.removeHour", "Remove 1 Hour");
/*  19 */   private static final Phrase REMOVE_DAY_ = Phrase.create("timePickerView.removeDay", "Remove 1 Day");
/*     */   
/*  21 */   private static final Phrase ADD_SECOND_ = Phrase.create("timePickerView.addSecond", "Add 1 Second");
/*  22 */   private static final Phrase ADD_MINUTE_ = Phrase.create("timePickerView.addMinute", "Add 1 Minute");
/*  23 */   private static final Phrase ADD_HOUR_ = Phrase.create("timePickerView.addHour", "Add 1 Hour");
/*  24 */   private static final Phrase ADD_DAY_ = Phrase.create("timePickerView.addDay", "Add 1 Day");
/*     */   
/*  26 */   private static final Phrase INCREMENT_ACTION = Phrase.create("timePickerView.incrementAction", "Click to add", Colors.GRAY, new Color[0]);
/*  27 */   private static final Phrase DECREMENT_ACTION = Phrase.create("timePickerView.decrementAction", "Click to remove", Colors.GRAY, new Color[0]);
/*     */   
/*  29 */   private static final Phrase CONFIRM_TITLE = Phrase.create("timePickerView.confirm.title", "Confirm");
/*  30 */   private static final Phrase CONFIRM_ACTION = Phrase.create("timePickerView.confirm.action", "Click to confirm", Colors.GRAY, new Color[0]);
/*     */   
/*     */   public enum Step {
/*  33 */     REMOVE_SECOND((String)TimePickerView.REMOVE_SECOND_, -1L, 11),
/*  34 */     REMOVE_MINUTE((String)TimePickerView.REMOVE_MINUTE_, -60L, 20),
/*  35 */     REMOVE_HOUR((String)TimePickerView.REMOVE_HOUR_, -3600L, 29),
/*  36 */     REMOVE_DAY((String)TimePickerView.REMOVE_DAY_, -86400L, 38),
/*     */     
/*  38 */     ADD_SECOND((String)TimePickerView.ADD_SECOND_, 1L, 17),
/*  39 */     ADD_MINUTE((String)TimePickerView.ADD_MINUTE_, 60L, 26),
/*  40 */     ADD_HOUR((String)TimePickerView.ADD_HOUR_, 3600L, 35),
/*  41 */     ADD_DAY((String)TimePickerView.ADD_DAY_, 86400L, 44);
/*     */     
/*     */     Phrase phrase;
/*     */     long baseIncrement;
/*     */     int slot;
/*     */     
/*     */     Step(Phrase param1Phrase, long param1Long, int param1Int1) {
/*  48 */       this.phrase = param1Phrase;
/*  49 */       this.baseIncrement = param1Long;
/*  50 */       this.slot = param1Int1;
/*     */     }
/*     */   }
/*     */   
/*  54 */   private long time = 0L;
/*     */   private final String titlePrefix;
/*     */   private final String noTimePhrase;
/*     */   private final boolean noTimeContinue;
/*     */   
/*     */   public TimePickerView(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin, String paramString1, String paramString2, boolean paramBoolean) {
/*  60 */     super(paramPlayer, paramSpigotTechPlugin);
/*     */     
/*  62 */     this.titlePrefix = paramString1;
/*  63 */     this.noTimePhrase = paramString2;
/*  64 */     this.noTimeContinue = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  69 */     paramModel.setTitle(this.titlePrefix + " " + ((this.time == 0L) ? this.noTimePhrase : Tools.getTimeString(this.time)));
/*  70 */     paramModel.setSlots(54);
/*     */     
/*  72 */     for (Step step : Step.values()) {
/*  73 */       if (this.time + step.baseIncrement >= 0L) {
/*     */ 
/*     */ 
/*     */         
/*  77 */         boolean bool = (step.baseIncrement > 0L) ? true : false;
/*     */         
/*  79 */         paramModel.button(step.slot, bool ? (paramButton -> IncrementButton(paramButton, paramStep)) : (paramButton -> DecrementButton(paramButton, paramStep)));
/*     */       } 
/*     */     } 
/*  82 */     if (this.time != 0L || this.noTimeContinue) {
/*  83 */       paramModel.button(23, this::ConfirmButton);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void IncrementButton(Button paramButton, Step paramStep) {
/*  89 */     paramButton.material(XMaterial.STONE_BUTTON)
/*  90 */       .name(Animation.wave(paramStep.phrase.get(), new Color[] { Colors.GREEN, Colors.WHITE
/*  91 */           })).lore(new String[] {
/*  92 */           INCREMENT_ACTION.get()
/*     */         });
/*     */     
/*  95 */     paramButton.action(paramActionType -> this.time += paramStep.baseIncrement);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void DecrementButton(Button paramButton, Step paramStep) {
/* 101 */     paramButton.material(XMaterial.OAK_BUTTON)
/* 102 */       .name(Animation.wave(paramStep.phrase.get(), new Color[] { Colors.RED, Colors.WHITE
/* 103 */           })).lore(new String[] {
/* 104 */           DECREMENT_ACTION.get()
/*     */         });
/*     */     
/* 107 */     paramButton.action(paramActionType -> this.time += paramStep.baseIncrement);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void ConfirmButton(Button paramButton) {
/* 113 */     paramButton.material(XMaterial.EMERALD_BLOCK)
/* 114 */       .name(Animation.wave(CONFIRM_TITLE.get(), new Color[] { Colors.GREEN, Colors.WHITE
/* 115 */           })).lore(new String[] { CONFIRM_ACTION.get() });
/*     */     
/* 117 */     paramButton.action(paramActionType -> onResult(this.time));
/*     */   }
/*     */   
/*     */   public abstract void onResult(long paramLong);
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/views/TimePickerView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */