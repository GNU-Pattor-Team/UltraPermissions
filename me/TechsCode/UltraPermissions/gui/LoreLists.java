/*     */ package me.TechsCode.UltraPermissions.gui;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.stream.Collectors;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.base.visual.LoreScroller;
/*     */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionCopy;
/*     */ import me.TechsCode.UltraPermissions.gui.permissionEditor.PermissionCopyList;
/*     */ import me.TechsCode.UltraPermissions.storage.collection.RankupList;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*     */ import me.TechsCode.UltraPermissions.storage.objects.UserRankup;
/*     */ 
/*     */ public class LoreLists
/*     */ {
/*  20 */   private static final Phrase LIST_NONE_LINE = Phrase.create("lists.all.noneLine", "- **None**", Colors.GRAY, new Color[] { Colors.RED });
/*     */   
/*  22 */   private static final Phrase RANK_UP_LIST_PERMANENT_LINE = Phrase.create("lists.rankUps.permanentLine", "%index%. **%group%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  23 */   private static final Phrase RANK_UP_LIST_TEMPORARY_LINE = Phrase.create("lists.rankUps.temporaryLine", "%index%. **%group%** for **%time%**", Colors.GRAY, new Color[] { Colors.YELLOW, Colors.RED });
/*     */   
/*     */   public static List<String> printRankUpLoreList(RankupList paramRankupList) {
/*  26 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  28 */     byte b = 1;
/*  29 */     for (UserRankup userRankup : paramRankupList) {
/*  30 */       Optional<Group> optional = userRankup.getGroup().get();
/*     */       
/*  32 */       if (!optional.isPresent())
/*     */         continue; 
/*  34 */       Phrase phrase = userRankup.isPermanent() ? RANK_UP_LIST_PERMANENT_LINE : RANK_UP_LIST_TEMPORARY_LINE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  39 */       String str = phrase.get().replace("%index%", Integer.toString(b)).replace("%group%", ((Group)optional.get()).getName()).replace("%time%", userRankup.isTemporary() ? Tools.getTimeString(userRankup.getLeftDuration() / 1000L) : "");
/*     */       
/*  41 */       arrayList.add(str);
/*     */       
/*  43 */       b++;
/*     */     } 
/*     */     
/*  46 */     if (b == 1) {
/*  47 */       arrayList.add(LIST_NONE_LINE.get());
/*     */     }
/*     */     
/*  50 */     return arrayList;
/*     */   }
/*     */   
/*  53 */   private static final Phrase PERMISSION_LIST_POSITIVE_INHERITED = Phrase.create("lists.permissions.inheritedPositiveLine", "- **%permission%** from **%group%**", Colors.GRAY, new Color[] { Colors.WHITE, Colors.YELLOW });
/*  54 */   private static final Phrase PERMISSION_LIST_NEGATIVE_INHERITED = Phrase.create("lists.permissions.inheritedNegativeLine", "- **-****%permission%** from **%group%**", Colors.GRAY, new Color[] { Colors.RED, Colors.WHITE, Colors.YELLOW });
/*  55 */   private static final Phrase PERMISSION_LIST_POSITIVE = Phrase.create("lists.permissions.positiveLine", "- **%permission%**", Colors.GRAY, new Color[] { Colors.WHITE });
/*  56 */   private static final Phrase PERMISSION_LIST_NEGATIVE = Phrase.create("lists.permissions.negativeLine", "- **-****%permission%**", Colors.GRAY, new Color[] { Colors.RED, Colors.WHITE });
/*  57 */   private static final Phrase PERMISSION_LIST_POSITIVE_SERVER = Phrase.create("lists.permissions.serverPositiveLine", "- **%permission%** on Server **%server%**", Colors.GRAY, new Color[] { Colors.WHITE, Colors.BLUE });
/*  58 */   private static final Phrase PERMISSION_LIST_NEGATIVE_SERVER = Phrase.create("lists.permissions.serverNegativeLine", "- **-****%permission%** on Server **%server%**", Colors.GRAY, new Color[] { Colors.RED, Colors.WHITE, Colors.BLUE });
/*  59 */   private static final Phrase PERMISSION_LIST_POSITIVE_WORLD = Phrase.create("lists.permissions.worldPositiveLine", "- **%permission%** on World **%world%**", Colors.GRAY, new Color[] { Colors.WHITE, Colors.YELLOW });
/*  60 */   private static final Phrase PERMISSION_LIST_NEGATIVE_WORLD = Phrase.create("lists.permissions.worldNegativeLine", "- **-****%permission%** on World **%world%**", Colors.GRAY, new Color[] { Colors.RED, Colors.WHITE, Colors.YELLOW });
/*  61 */   private static final Phrase PERMISSION_LIST_POSITIVE_SERVER_WORLD = Phrase.create("lists.permissions.serverWorldPositiveLine", "- **%permission%** on **%server%** in **%world%**", Colors.GRAY, new Color[] { Colors.WHITE, Colors.BLUE, Colors.YELLOW });
/*  62 */   private static final Phrase PERMISSION_LIST_NEGATIVE_SERVER_WORLD = Phrase.create("lists.permissions.serverWorldNegativeLine", "- **-****%permission%** on **%server%** in **%world%**", Colors.GRAY, new Color[] { Colors.WHITE, Colors.RED, Colors.BLUE, Colors.YELLOW });
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
/*     */   public static List<String> printPermissionCopiesList(PermissionCopyList paramPermissionCopyList, long paramLong) {
/* 100 */     List<String> list = (List)paramPermissionCopyList.stream().map(paramPermissionCopy -> { Phrase phrase; if (paramPermissionCopy.isInherited()) { Phrase phrase1; if (paramPermissionCopy.getPermission().isPositive()) { phrase1 = PERMISSION_LIST_POSITIVE_INHERITED; } else { phrase1 = PERMISSION_LIST_NEGATIVE_INHERITED; }  return phrase1.get().replace("%permission%", paramPermissionCopy.getColoredName()).replace("%group%", paramPermissionCopy.getPermission().getHolder().getName()); }  Optional<CharSequence> optional = paramPermissionCopy.getPermission().getServer(); Optional optional1 = paramPermissionCopy.getPermission().getWorld(); boolean bool = paramPermissionCopy.getPermission().isPositive(); if (optional.isPresent() && optional1.isPresent()) { phrase = bool ? PERMISSION_LIST_POSITIVE_SERVER_WORLD : PERMISSION_LIST_NEGATIVE_SERVER_WORLD; } else if (optional.isPresent()) { phrase = bool ? PERMISSION_LIST_POSITIVE_SERVER : PERMISSION_LIST_NEGATIVE_SERVER; } else if (optional1.isPresent()) { phrase = bool ? PERMISSION_LIST_POSITIVE_WORLD : PERMISSION_LIST_NEGATIVE_WORLD; } else { phrase = bool ? PERMISSION_LIST_POSITIVE : PERMISSION_LIST_NEGATIVE; }  return phrase.get().replace("%permission%", paramPermissionCopy.getColoredName()).replace("%server%", optional.orElse("INVALID")).replace("%world%", optional.orElse("INVALID")); }).collect(Collectors.toList());
/*     */     
/* 102 */     if (list.isEmpty()) {
/* 103 */       list.add(LIST_NONE_LINE.get());
/*     */     }
/*     */     
/* 106 */     return LoreScroller.scroller(list, 15, paramLong);
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/gui/LoreLists.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */