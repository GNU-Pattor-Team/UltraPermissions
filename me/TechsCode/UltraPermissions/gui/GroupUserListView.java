/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ import java.util.Arrays;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import me.TechsCode.UltraPermissions.UltraPermissions;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.gui.ActionType;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Button;
/*     */ import me.TechsCode.UltraPermissions.base.gui.Model;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.BasicSearch;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.PageableGUI;
/*     */ import me.TechsCode.UltraPermissions.base.gui.pageableview.SearchFeature;
/*     */ import me.TechsCode.UltraPermissions.base.item.XMaterial;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.SkinTexture;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.views.ConfirmationView;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Animation;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.UserRankup;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class GroupUserListView extends PageableGUI<UserRankup> {
/*     */   private final Group group;
/*     */   
/*     */   public GroupUserListView(Player paramPlayer, UltraPermissions paramUltraPermissions, Group paramGroup) {
/*  29 */     super(paramPlayer, (SpigotTechPlugin)paramUltraPermissions);
/*     */     
/*  31 */     this.group = paramGroup;
/*  32 */     this.plugin = paramUltraPermissions;
/*     */   }
/*     */   private final UltraPermissions plugin;
/*  35 */   private static final Phrase TITLE = Phrase.create("groupUserListView.title", "%group% > Users");
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  39 */     return TITLE.get().replace("%group%", this.group.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchFeature<UserRankup> getSearch() {
/*  44 */     return (SearchFeature<UserRankup>)new BasicSearch<UserRankup>()
/*     */       {
/*     */         public String[] getSearchableText(UserRankup param1UserRankup) {
/*  47 */           return new String[] { param1UserRankup.getUser().getName() };
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public UserRankup[] getObjects() {
/*  54 */     return (UserRankup[])this.group.getRankups().toArray((Object[])new UserRankup[0]);
/*     */   }
/*     */   
/*  57 */   private static final Phrase WIPE_TITLE = Phrase.create("groupUserListView.wipe.title", "Wipe Users");
/*  58 */   private static final Phrase WIPE_ACTION = Phrase.create("groupUserListView.wipe.action", "Click to **remove** all Users from this Group", Colors.GRAY, new Color[] { Colors.RED });
/*     */ 
/*     */   
/*     */   protected void construct(Model paramModel) {
/*  62 */     super.construct(paramModel);
/*     */     
/*  64 */     paramModel.button(paramButton -> {
/*     */           paramButton.material(XMaterial.REDSTONE_BLOCK).name(Animation.fading(WIPE_TITLE.get(), new Color[] { Colors.DarkCyan, Colors.Cyan })).lore(new String[] { WIPE_ACTION.get() });
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
/*     */           paramButton.action(());
/*  81 */         }getRightOptionSlot());
/*     */   }
/*     */   
/*  84 */   private static final Phrase ENTRY_ACTION = Phrase.create("groupUserListView.entry.action", "Click to **remove** User", Colors.GRAY, new Color[] { Colors.RED });
/*  85 */   private static final Phrase ENTRY_EXPLANATION = Phrase.create("groupUserListView.entry.explanation", "This group is added **permanently** to that user", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  86 */   private static final Phrase ENTRY_TIME_TITLE = Phrase.create("groupUserListView.entry.timeTitle", "Time until removal:", Colors.GRAY, new Color[0]);
/*     */ 
/*     */   
/*     */   public void construct(Button paramButton, UserRankup paramUserRankup) {
/*  90 */     Optional<SkinTexture> optional = paramUserRankup.getUser().getSkinTexture();
/*     */     
/*  92 */     if (optional.isPresent()) {
/*  93 */       paramButton.material(XMaterial.PLAYER_HEAD)
/*  94 */         .setSkullTexture(optional.get());
/*     */     } else {
/*  96 */       paramButton.material(XMaterial.GRAY_STAINED_GLASS);
/*     */     } 
/*     */     
/*  99 */     paramButton.item()
/* 100 */       .name(Animation.wave(paramUserRankup.getUser().getName(), new Color[] { Colors.Blue, Colors.WHITE
/* 101 */           })).lore(new String[] { ENTRY_ACTION.get() });
/*     */     
/* 103 */     if (paramUserRankup.isPermanent()) {
/* 104 */       paramButton.item().appendLore(new String[] { "", ENTRY_EXPLANATION.get() });
/*     */     } else {
/* 106 */       paramButton.item()
/* 107 */         .appendLore(new String[] { ""
/* 108 */           }).appendLore(new String[] { ENTRY_TIME_TITLE.get()
/* 109 */           }).appendLore(new String[] { Colors.RED + Tools.getTimeString(paramUserRankup.getExpiry() - System.currentTimeMillis(), TimeUnit.MILLISECONDS) });
/*     */     } 
/*     */     
/* 112 */     paramButton.action(paramActionType -> paramUserRankup.remove());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/GroupUserListView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */