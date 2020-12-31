/*    */ package me.TechsCode.UltraPermissions.storage.collection;
/*    */ import java.util.Collection;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Holder;
/*    */ 
/*    */ public class GroupList extends ArrayList<Group> {
/*    */   public GroupList(int paramInt) {
/* 13 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public GroupList() {}
/*    */   
/*    */   public GroupList(Collection<? extends Group> paramCollection) {
/* 20 */     super(paramCollection);
/*    */   }
/*    */   
/*    */   public GroupList servers(boolean paramBoolean, List<String> paramList) {
/* 24 */     return (GroupList)stream().filter(paramGroup -> {
/*    */           Optional optional = paramGroup.getServer();
/*    */           
/* 27 */           return ((paramBoolean && !optional.isPresent()) || (optional.isPresent() && paramList.contains(optional.get())));
/* 28 */         }).collect(Collectors.toCollection(GroupList::new));
/*    */   }
/*    */   
/*    */   public GroupList worlds(boolean paramBoolean, List<String> paramList) {
/* 32 */     return (GroupList)stream().filter(paramGroup -> {
/*    */           Optional optional = paramGroup.getWorld();
/*    */           
/* 35 */           return ((paramBoolean && !optional.isPresent()) || (optional.isPresent() && paramList.contains(optional.get())));
/* 36 */         }).collect(Collectors.toCollection(GroupList::new));
/*    */   }
/*    */   
/*    */   public GroupList servers(boolean paramBoolean, String... paramVarArgs) {
/* 40 */     return servers(paramBoolean, Arrays.asList(paramVarArgs));
/*    */   }
/*    */   
/*    */   public GroupList worlds(boolean paramBoolean, String... paramVarArgs) {
/* 44 */     return worlds(paramBoolean, Arrays.asList(paramVarArgs));
/*    */   }
/*    */   
/*    */   public GroupList worstToBest() {
/* 48 */     sort(Comparator.comparing(Group::getPriority, Comparator.reverseOrder()).thenComparing(Group::getKey));
/* 49 */     return this;
/*    */   }
/*    */   
/*    */   public GroupList bestToWorst() {
/* 53 */     sort(Comparator.comparing(Group::getPriority).thenComparing(Group::getKey));
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   public GroupList defaults(boolean paramBoolean) {
/* 58 */     return (GroupList)stream().filter(paramGroup -> (paramGroup.isDefault() == paramBoolean)).collect(Collectors.toCollection(GroupList::new));
/*    */   }
/*    */   
/*    */   public Optional<Group> name(String paramString) {
/* 62 */     return stream().filter(paramGroup -> paramGroup.getName().equalsIgnoreCase(paramString)).findFirst();
/*    */   }
/*    */   
/*    */   public List<Holder> holders() {
/* 66 */     return (List<Holder>)stream().map(Holder::fromGroup).collect(Collectors.toList());
/*    */   }
/*    */   
/*    */   public GroupList getWithRecursiveInherits() {
/* 70 */     GroupList groupList = new GroupList(this);
/*    */     
/* 72 */     for (Group group : this) {
/* 73 */       collectGroups(groupList, group);
/*    */     }
/*    */     
/* 76 */     return groupList;
/*    */   }
/*    */   
/*    */   private void collectGroups(List<Group> paramList, Group paramGroup) {
/* 80 */     for (Group group : paramGroup.getActiveInheritedGroups()) {
/* 81 */       if (!paramList.contains(group)) {
/* 82 */         paramList.add(group);
/*    */         
/* 84 */         collectGroups(paramList, group);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/collection/GroupList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */