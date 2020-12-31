/*     */ package me.TechsCode.UltraPermissions.base.command;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import me.TechsCode.UltraPermissions.base.command.arguments.SpecificArgument;
/*     */ import me.TechsCode.UltraPermissions.base.misc.Callback;
/*     */ import me.TechsCode.UltraPermissions.base.misc.Setter;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class CommandNode<T, ARGUMENT extends Argument<T>> {
/*     */   public static CommandNode<String, SpecificArgument> create(String paramString) {
/*  15 */     return new CommandNode<>(null, new SpecificArgument(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   private final CommandNode<?, ?> parent;
/*     */   private final ARGUMENT argument;
/*     */   private final List<CommandNode<?, ?>> children;
/*     */   private final List<Requirement> requirements;
/*     */   private String description;
/*     */   private Action<T> action;
/*     */   
/*     */   public CommandNode(CommandNode<?, ?> paramCommandNode, ARGUMENT paramARGUMENT) {
/*  27 */     this.parent = paramCommandNode;
/*  28 */     this.children = new ArrayList<>();
/*  29 */     this.argument = paramARGUMENT;
/*  30 */     this.requirements = new ArrayList<>();
/*     */     
/*  32 */     this.description = null;
/*  33 */     this.action = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <NEW_T, NEW_ARGUMENT extends Argument<NEW_T>> CommandNode<T, ARGUMENT> newNode(NEW_ARGUMENT paramNEW_ARGUMENT, Setter<CommandNode<NEW_T, NEW_ARGUMENT>> paramSetter) {
/*  44 */     CommandNode<?, ?> commandNode = new CommandNode(this, (ARGUMENT)paramNEW_ARGUMENT);
/*  45 */     paramSetter.set(commandNode);
/*  46 */     this.children.add(commandNode);
/*     */     
/*  48 */     return this;
/*     */   }
/*     */   
/*     */   public void description(String paramString) {
/*  52 */     this.description = paramString;
/*     */   }
/*     */   
/*     */   public void require(Requirement paramRequirement) {
/*  56 */     this.requirements.add(paramRequirement);
/*     */   }
/*     */   
/*     */   public void action(Action<T> paramAction) {
/*  60 */     this.action = paramAction;
/*     */   }
/*     */   
/*     */   public CommandNode<?, ?> getCurrentNode(CommandSender paramCommandSender, Player paramPlayer, List<String> paramList) {
/*  64 */     return getCurrentNode(paramCommandSender, paramPlayer, paramList, 0);
/*     */   }
/*     */   
/*     */   private CommandNode<?, ?> getCurrentNode(CommandSender paramCommandSender, Player paramPlayer, List<String> paramList, int paramInt) {
/*  68 */     if (paramList.size() == paramInt) {
/*  69 */       return null;
/*     */     }
/*     */     
/*  72 */     String str = paramList.get(paramInt);
/*  73 */     if (this.argument.hasMatch(str)) {
/*  74 */       for (Requirement requirement : this.requirements) {
/*  75 */         if (!requirement.isMatching(paramCommandSender, paramPlayer, paramList)) {
/*  76 */           return null;
/*     */         }
/*     */       } 
/*     */       
/*  80 */       int i = paramList.size() - paramInt + 1;
/*     */       
/*  82 */       if (i == 0) {
/*  83 */         return this;
/*     */       }
/*     */       
/*  86 */       for (CommandNode<?, ?> commandNode1 : this.children) {
/*  87 */         CommandNode<?, ?> commandNode2 = commandNode1.getCurrentNode(paramCommandSender, paramPlayer, paramList, paramInt + 1);
/*     */         
/*  89 */         if (commandNode2 != null) {
/*  90 */           return commandNode2;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     return null;
/*     */   }
/*     */   
/*     */   public void execute(CommandSender paramCommandSender, Player paramPlayer, Arguments paramArguments, Callback<ExecuteCallback> paramCallback) {
/*  99 */     execute(paramCommandSender, paramPlayer, paramArguments, 0, paramCallback);
/*     */   }
/*     */   
/*     */   private boolean execute(CommandSender paramCommandSender, Player paramPlayer, Arguments paramArguments, int paramInt, Callback<ExecuteCallback> paramCallback) {
/* 103 */     if (paramArguments.size() == paramInt) {
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     String str = paramArguments.get(paramInt);
/*     */     
/* 109 */     if (this.argument.hasMatch(str)) {
/* 110 */       for (Requirement requirement : this.requirements) {
/* 111 */         if (!requirement.isMatching(paramCommandSender, paramPlayer, paramArguments)) {
/* 112 */           requirement.onUnmatched(paramCommandSender, paramPlayer);
/* 113 */           return true;
/*     */         } 
/*     */       } 
/*     */       
/* 117 */       for (CommandNode<?, ?> commandNode : this.children) {
/* 118 */         boolean bool = commandNode.execute(paramCommandSender, paramPlayer, paramArguments, paramInt + 1, paramCallback);
/*     */         
/* 120 */         if (bool) {
/* 121 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 125 */       if (this.action != null) {
/* 126 */         this.action.run(paramCommandSender, paramPlayer, paramArguments);
/* 127 */         paramCallback.run(new ExecuteCallback(this, ExecuteResult.SUCCESSFUL));
/*     */       } else {
/* 129 */         paramCallback.run(new ExecuteCallback(this, ExecuteResult.NO_ACTION));
/*     */       } 
/*     */       
/* 132 */       return true;
/*     */     } 
/*     */     
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   public String getUsagePath() {
/* 139 */     return getNodesOnPath().stream()
/* 140 */       .map(paramCommandNode -> paramCommandNode.argument.getUsage())
/* 141 */       .collect(Collectors.joining(" "));
/*     */   }
/*     */   
/*     */   public ArgumentValue<T> getValue(Arguments paramArguments) {
/* 145 */     byte b = 0;
/*     */     
/* 147 */     CommandNode<?, ?> commandNode = this.parent;
/* 148 */     while (commandNode != null) {
/* 149 */       commandNode = commandNode.parent;
/* 150 */       b++;
/*     */     } 
/*     */     
/* 153 */     String str = paramArguments.get(b);
/* 154 */     return this.argument.get(str);
/*     */   }
/*     */   
/*     */   public List<String> getSpareArguments(Arguments paramArguments) {
/* 158 */     byte b = 0;
/*     */     
/* 160 */     CommandNode<?, ?> commandNode = this;
/* 161 */     while (commandNode != null) {
/* 162 */       commandNode = commandNode.parent;
/* 163 */       b++;
/*     */     } 
/*     */     
/* 166 */     return paramArguments.subList(b, paramArguments.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CommandNode<?, ?>> getEndNodes() {
/* 174 */     if (this.children.size() == 0) {
/* 175 */       return Collections.singletonList(this);
/*     */     }
/*     */     
/* 178 */     ArrayList<CommandNode<?, ?>> arrayList = new ArrayList();
/*     */     
/* 180 */     for (CommandNode<?, ?> commandNode : this.children) {
/* 181 */       arrayList.addAll(commandNode.getEndNodes());
/*     */     }
/*     */     
/* 184 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CommandNode<?, ?>> getNodesOnPath() {
/* 192 */     ArrayList<CommandNode> arrayList = new ArrayList();
/*     */     
/* 194 */     arrayList.add(this);
/*     */     
/* 196 */     CommandNode<?, ?> commandNode = this;
/* 197 */     while (commandNode != null) {
/* 198 */       commandNode = commandNode.parent;
/*     */       
/* 200 */       if (commandNode != null) arrayList.add(commandNode);
/*     */     
/*     */     } 
/* 203 */     Collections.reverse(arrayList);
/*     */     
/* 205 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   public List<CommandNode<?, ?>> getChildren() {
/* 209 */     return this.children;
/*     */   }
/*     */   
/*     */   public boolean hasDescription() {
/* 213 */     return (this.description != null);
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 217 */     return this.description;
/*     */   }
/*     */   
/*     */   public ARGUMENT getArgument() {
/* 221 */     return this.argument;
/*     */   }
/*     */   
/*     */   public List<Requirement> getRequirements() {
/* 225 */     return this.requirements;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Requirement> getAllRequirements() {
/* 234 */     return (List<Requirement>)getNodesOnPath().stream()
/* 235 */       .flatMap(paramCommandNode -> paramCommandNode.getRequirements().stream())
/* 236 */       .filter(Objects::nonNull)
/* 237 */       .collect(Collectors.toList());
/*     */   }
/*     */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/CommandNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */