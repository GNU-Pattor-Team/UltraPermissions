/*     */ package me.TechsCode.UltraPermissions.permissionDatabase;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import me.TechsCode.UltraPermissions.base.legacy.Tools;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Color;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ public class PermissionInfo
/*     */ {
/*     */   private final String permission;
/*     */   private final String plugin;
/*     */   private final String description;
/*     */   private final String[] commands;
/*     */   private final String source;
/*     */   private String[] placeholders;
/*     */   
/*     */   public PermissionInfo(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, String paramString4) {
/*  22 */     this.permission = paramString1;
/*  23 */     this.plugin = paramString2;
/*  24 */     this.description = paramString3;
/*  25 */     this.commands = paramArrayOfString;
/*  26 */     this.source = paramString4;
/*     */     
/*  28 */     this.placeholders = StringUtils.substringsBetween(paramString1, "[", "]");
/*     */     
/*  30 */     this.placeholders = (this.placeholders == null) ? new String[0] : this.placeholders;
/*     */   }
/*     */   
/*     */   public String getPermission() {
/*  34 */     return this.permission;
/*     */   }
/*     */   
/*     */   public String getPlugin() {
/*  38 */     return this.plugin;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  42 */     return this.description;
/*     */   }
/*     */   
/*     */   public String[] getCommands() {
/*  46 */     return this.commands;
/*     */   }
/*     */   
/*     */   public String getSource() {
/*  50 */     return this.source;
/*     */   }
/*     */   
/*     */   public boolean hasPlaceholders() {
/*  54 */     return (this.placeholders.length != 0);
/*     */   }
/*     */   
/*     */   public String[] getPlaceholders() {
/*  58 */     return this.placeholders;
/*     */   }
/*     */   
/*  61 */   private static final Phrase COMMANDS_TITLE = Phrase.create("permissionInfo.commands.title", "Commands:", Colors.GRAY, new Color[0]);
/*  62 */   private static final Phrase COMMANDS_ENTRY = Phrase.create("permissionInfo.commands.entry", "- **/%command%**", Colors.GRAY, new Color[] { Colors.YELLOW });
/*  63 */   private static final Phrase DESCRIPTION_TITLE = Phrase.create("permissionInfo.description.title", "Description:", Colors.GRAY, new Color[0]);
/*     */   
/*     */   public List<String> asLore() {
/*  66 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  68 */     if ((getCommands()).length != 0) {
/*  69 */       arrayList.add(COMMANDS_TITLE.get());
/*     */       
/*  71 */       for (String str : getCommands()) {
/*  72 */         str = str.replace("/", "");
/*     */         
/*  74 */         arrayList.add(COMMANDS_ENTRY.get().replace("%command%", str));
/*     */       } 
/*     */       
/*  77 */       arrayList.add("");
/*     */     } 
/*     */     
/*  80 */     arrayList.add(DESCRIPTION_TITLE.get());
/*  81 */     for (String str : Tools.lineSplitter(getDescription(), 60)) {
/*  82 */       arrayList.add("   " + Colors.WHITE + str);
/*     */     }
/*     */     
/*  85 */     return arrayList;
/*     */   }
/*     */   
/*     */   public boolean isThisPermission(String paramString) {
/*  89 */     if (paramString.equalsIgnoreCase(this.permission)) return true;
/*     */     
/*  91 */     if (hasPlaceholders()) {
/*  92 */       String str = this.permission;
/*     */       
/*  94 */       for (String str1 : this.placeholders) str = str.replace("[" + str1 + "]", "$$$");
/*     */       
/*  96 */       for (String str1 : str.split("[$$$]")) {
/*  97 */         if (!paramString.contains(str1)) {
/*  98 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 102 */       return true;
/*     */     } 
/*     */     
/* 105 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/permissionDatabase/PermissionInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */