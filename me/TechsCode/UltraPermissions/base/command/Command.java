/*     */ package me.TechsCode.UltraPermissions.base.command;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import me.TechsCode.UltraPermissions.base.SpigotTechPlugin;
/*     */ import me.TechsCode.UltraPermissions.base.command.arguments.SpecificArgument;
/*     */ import me.TechsCode.UltraPermissions.base.reflection.titleAndActionbar.ActionBar;
/*     */ import me.TechsCode.UltraPermissions.base.scheduler.RecurringTask;
/*     */ import me.TechsCode.UltraPermissions.base.translations.Phrase;
/*     */ import me.TechsCode.UltraPermissions.base.visual.Colors;
/*     */ import me.TechsCode.UltraPermissions.dependencies.commons.lang.ArrayUtils;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.command.CommandMap;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.command.defaults.BukkitCommand;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public abstract class Command extends BukkitCommand implements Listener {
/*  23 */   private static final Phrase USAGE_TITLE = Phrase.create("command.usage.title", "Usage:", Colors.BLUE, new me.TechsCode.UltraPermissions.base.visual.Color[0]);
/*     */   
/*     */   private final ActionBar actionBar;
/*     */   
/*     */   private boolean isCurrentlyRegistered;
/*     */   
/*     */   public Command(SpigotTechPlugin paramSpigotTechPlugin, String paramString, String... paramVarArgs) {
/*  30 */     this(paramSpigotTechPlugin, paramString, "", "/" + paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public Command(SpigotTechPlugin paramSpigotTechPlugin, String paramString1, String paramString2, String paramString3, String... paramVarArgs) {
/*  34 */     super(paramString1, paramString2, paramString3, Arrays.asList(paramVarArgs));
/*     */     
/*  36 */     this.actionBar = new ActionBar(paramSpigotTechPlugin);
/*     */     
/*  38 */     if (isRegistered()) {
/*  39 */       register();
/*     */     }
/*     */     
/*  42 */     RecurringTask recurringTask = paramSpigotTechPlugin.getScheduler().runTaskTimer(() -> { if (isRegistered() && !this.isCurrentlyRegistered) register();  if (!isRegistered() && this.isCurrentlyRegistered) unregister();  }20L, 20L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     paramSpigotTechPlugin.addDisableHook(() -> {
/*     */           paramRecurringTask.stop();
/*     */           if (this.isCurrentlyRegistered) {
/*     */             unregister();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute(CommandSender paramCommandSender, String paramString, String[] paramArrayOfString) {
/*  63 */     Arguments arguments = new Arguments();
/*  64 */     arguments.add(getName());
/*  65 */     arguments.addAll(Arrays.asList(paramArrayOfString));
/*     */     
/*  67 */     Player player = (paramCommandSender instanceof Player) ? (Player)paramCommandSender : null;
/*     */     
/*  69 */     CommandNode<String, SpecificArgument> commandNode = CommandNode.create(getName());
/*  70 */     define(commandNode);
/*     */     
/*  72 */     commandNode.execute(paramCommandSender, player, arguments, paramExecuteCallback -> {
/*     */           if (paramExecuteCallback.getResult() == ExecuteResult.NO_ACTION) {
/*     */             paramCommandSender.sendMessage("");
/*     */             
/*     */             paramCommandSender.sendMessage(USAGE_TITLE.get());
/*     */             
/*     */             for (CommandNode<?, ?> commandNode : paramExecuteCallback.getLastNode().getChildren()) {
/*     */               boolean bool = commandNode.getAllRequirements().stream().allMatch(());
/*     */               
/*     */               if (bool) {
/*     */                 paramCommandSender.sendMessage(Colors.GRAY + "- " + Colors.YELLOW + "/" + commandNode.getUsagePath() + (commandNode.hasDescription() ? (" " + Colors.GRAY + commandNode.getDescription()) : ""));
/*     */               }
/*     */             } 
/*     */           } 
/*     */         });
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> tabComplete(CommandSender paramCommandSender, String paramString, String[] paramArrayOfString) {
/*  92 */     Arguments arguments = new Arguments();
/*  93 */     arguments.add(getName());
/*  94 */     arguments.addAll(Arrays.asList(paramArrayOfString));
/*     */     
/*  96 */     Player player = (paramCommandSender instanceof Player) ? (Player)paramCommandSender : null;
/*     */     
/*  98 */     CommandNode<String, SpecificArgument> commandNode = CommandNode.create(getName());
/*  99 */     define(commandNode);
/*     */     
/* 101 */     CommandNode<?, ?> commandNode1 = commandNode.getCurrentNode(paramCommandSender, player, arguments.subList(0, arguments.size() - 1));
/*     */     
/* 103 */     if (commandNode1 == null) return new ArrayList<>();
/*     */     
/* 105 */     if (player != null) {
/* 106 */       List<CommandNode<?, ?>> list = commandNode1.getEndNodes();
/*     */       
/* 108 */       if (list.size() == 1) {
/* 109 */         CommandNode<?, ?> commandNode2 = commandNode.getCurrentNode(paramCommandSender, player, arguments);
/* 110 */         CommandNode<?, ?> commandNode3 = list.get(0);
/*     */         
/* 112 */         this.actionBar.sendActionBar(player, getTabCompletionActionBar(commandNode2, commandNode3, arguments));
/*     */       } 
/*     */     } 
/*     */     
/* 116 */     return (List<String>)commandNode1.getChildren().stream()
/* 117 */       .flatMap(paramCommandNode -> paramCommandNode.getArgument().getTabCompletions().stream())
/* 118 */       .filter(paramString -> paramString.toLowerCase().startsWith(paramArrayOfString[paramArrayOfString.length - 1].toLowerCase()))
/* 119 */       .collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   private String getTabCompletionActionBar(CommandNode<?, ?> paramCommandNode1, CommandNode<?, ?> paramCommandNode2, Arguments paramArguments) {
/* 123 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 125 */     byte b = 0;
/* 126 */     for (CommandNode<?, ?> commandNode : paramCommandNode2.getNodesOnPath()) {
/* 127 */       String str1 = commandNode.getArgument().getUsage();
/*     */       
/* 129 */       boolean bool1 = (b < paramArguments.size()) ? true : false;
/* 130 */       String str2 = bool1 ? paramArguments.get(b) : null;
/*     */       
/* 132 */       if (b == paramArguments.size() - 1) {
/* 133 */         stringBuilder.append(" ").append(str2.isEmpty() ? Colors.GREEN : Colors.YELLOW).append(str2.isEmpty() ? str1 : str2);
/* 134 */       } else if (b < paramArguments.size()) {
/* 135 */         stringBuilder.append(" ").append(Colors.GRAY).append(str2);
/*     */       } else {
/* 137 */         stringBuilder.append(" ").append(Colors.GRAY).append(str1);
/*     */       } 
/*     */       
/* 140 */       b++;
/*     */     } 
/*     */     
/* 143 */     String str = paramArguments.get(paramArguments.size() - 1);
/*     */     
/* 145 */     boolean bool = (paramCommandNode2.equals(paramCommandNode1) && !str.isEmpty() && paramCommandNode1.getArgument().hasMatch(str)) ? true : false;
/* 146 */     return Colors.GRAY + "/" + stringBuilder.toString().trim() + (bool ? (Colors.GREEN + "§l ✓") : "");
/*     */   }
/*     */   
/*     */   private void register() {
/*     */     try {
/* 151 */       Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
/* 152 */       field.setAccessible(true);
/* 153 */       CommandMap commandMap = (CommandMap)field.get(Bukkit.getServer());
/* 154 */       commandMap.register("command", (org.bukkit.command.Command)this);
/* 155 */       this.isCurrentlyRegistered = true;
/* 156 */     } catch (NoSuchFieldException|IllegalAccessException noSuchFieldException) {
/* 157 */       noSuchFieldException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void unregister() {
/*     */     try {
/* 163 */       Field field1 = Bukkit.getServer().getClass().getDeclaredField("commandMap");
/* 164 */       field1.setAccessible(true);
/* 165 */       CommandMap commandMap = (CommandMap)field1.get(Bukkit.getServer());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 170 */       Field field2 = Arrays.<Field>stream((Field[])ArrayUtils.addAll((Object[])commandMap.getClass().getDeclaredFields(), (Object[])commandMap.getClass().getSuperclass().getDeclaredFields())).filter(paramField -> paramField.getName().equals("knownCommands")).findAny().get();
/*     */       
/* 172 */       field2.setAccessible(true);
/* 173 */       Map map = (Map)field2.get(commandMap);
/* 174 */       map.remove(getName());
/* 175 */       field2.set(commandMap, map);
/* 176 */       this.isCurrentlyRegistered = false;
/* 177 */     } catch (NoSuchFieldException|IllegalAccessException noSuchFieldException) {
/* 178 */       noSuchFieldException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract void define(CommandNode<String, SpecificArgument> paramCommandNode);
/*     */   
/*     */   public abstract boolean isRegistered();
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/Command.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */