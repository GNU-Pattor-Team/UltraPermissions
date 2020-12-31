/*     */ package me.TechsCode.UltraPermissions.base.gui.pageableview;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.dialog.UserInput;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.GUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Common;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class PageableGUI<OBJ> extends GUI {
/*  21 */   private static final Phrase NEXT_TITLE = Phrase.create("pageableView.next.title", "Next");
/*  22 */   private static final Phrase NEXT_ACTION = Phrase.create("pageableView.next.action", "Click to go to the next page", Colors.GRAY, new Color[0]);
/*     */   
/*  24 */   private static final Phrase PREVIOUS_TITLE = Phrase.create("pageableView.previous.title", "Previous");
/*  25 */   private static final Phrase PREVIOUS_ACTION = Phrase.create("pageableView.previous.action", "Click to go to the previous page", Colors.GRAY, new Color[0]);
/*     */   
/*  27 */   private static final Phrase SEARCH_TITLE = Phrase.create("pageableView.search.title", "Search");
/*  28 */   private static final Phrase SEARCH_SUBTITLE = Phrase.create("pageableView.search.subtitle", "Type in a search term", Colors.GRAY, new Color[0]);
/*  29 */   private static final Phrase SEARCH_CLOSE_ACTION = Phrase.create("pageableView.search.closeAction", "Click to **close** the search", Colors.GRAY, new Color[] { Colors.RED });
/*     */   
/*  31 */   private final int maxObjectsPerPage = 36;
/*     */   
/*     */   private SpigotTechPlugin plugin;
/*     */   
/*  35 */   private int page = 0;
/*     */   private int pages;
/*  37 */   private String searchTerm = null;
/*     */   
/*     */   public PageableGUI(Player paramPlayer, SpigotTechPlugin paramSpigotTechPlugin) {
/*  40 */     super(paramPlayer, paramSpigotTechPlugin);
/*     */     
/*  42 */     this.plugin = paramSpigotTechPlugin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  49 */     paramModel.setTitle(getTitle());
/*  50 */     paramModel.setSlots(54);
/*     */     
/*  52 */     SearchFeature<OBJ> searchFeature = getSearch();
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
/*  67 */     List list1 = (List)Arrays.<OBJ>stream(getObjects()).filter(paramObject -> { if (paramSearchFeature == null) return true;  if (this.searchTerm == null) return true;  for (String str : paramSearchFeature.getSearchableText(paramObject)) { if (str != null && str.toLowerCase().contains(this.searchTerm.toLowerCase())) return true;  }  return false; }).collect(Collectors.toList());
/*     */ 
/*     */     
/*  70 */     int i = Math.min(list1.size(), this.page * 36);
/*  71 */     int j = Math.min(list1.size(), i + 36);
/*  72 */     List list2 = list1.subList(i, j);
/*     */     
/*  74 */     byte b = 1;
/*  75 */     for (Object object : list2) {
/*  76 */       paramModel.button(paramButton -> construct(paramButton, (OBJ)paramObject), b);
/*     */       
/*  78 */       b++;
/*     */     } 
/*     */ 
/*     */     
/*  82 */     this.pages = (int)Math.round(Math.ceil(list1.size() / 36.0D));
/*     */ 
/*     */     
/*  85 */     if (this.page != 0) {
/*  86 */       paramModel.button(paramButton -> { paramButton.material(XMaterial.ARROW).name(Animation.fading(PREVIOUS_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan })).lore(new String[] { PREVIOUS_ACTION.get() }); paramButton.action(()); }46);
/*     */     }
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
/* 101 */     if (this.page + 1 < this.pages) {
/* 102 */       paramModel.button(paramButton -> { paramButton.material(XMaterial.ARROW).name(Animation.fading(NEXT_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan })).lore(new String[] { NEXT_ACTION.get() }); paramButton.action(()); }54);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     if (searchFeature != null) {
/* 113 */       if (this.searchTerm == null) {
/* 114 */         paramModel.button(paramButton -> {
/*     */               paramButton.material(paramSearchFeature.getIcon()).name(Animation.fading(paramSearchFeature.getTitle(), new Color[] { Colors.DarkCyan, Colors.Cyan })).lore(new String[] { paramSearchFeature.getAction() });
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
/*     */               paramButton.action(());
/* 136 */             }getLeftOptionSlot());
/*     */       } else {
/* 138 */         paramModel.button(paramButton -> {
/*     */               paramButton.material(XMaterial.REDSTONE_BLOCK).name(Animation.fading(paramSearchFeature.getTitle(), new Color[] { Colors.RED, Colors.WHITE })).lore(new String[] { SEARCH_CLOSE_ACTION.get() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               paramButton.action(());
/* 147 */             }getLeftOptionSlot());
/*     */       } 
/*     */     }
/*     */     
/* 151 */     if (hasBackButton()) {
/* 152 */       paramModel.button(50, paramButton -> Common.BackButton(paramButton, ()));
/*     */     }
/*     */   }
/*     */   
/*     */   protected int getLeftOptionSlot() {
/* 157 */     return (this.page != 0) ? 48 : 47;
/*     */   }
/*     */   
/*     */   protected int getRightOptionSlot() {
/* 161 */     return (this.pages <= 1) ? 52 : 53;
/*     */   }
/*     */   
/*     */   public boolean hasBackButton() {
/* 165 */     return true;
/*     */   }
/*     */   
/*     */   public abstract String getTitle();
/*     */   
/*     */   public abstract void onBack();
/*     */   
/*     */   public abstract SearchFeature<OBJ> getSearch();
/*     */   
/*     */   public abstract OBJ[] getObjects();
/*     */   
/*     */   public abstract void construct(Button paramButton, OBJ paramOBJ);
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/gui/pageableview/PageableGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */