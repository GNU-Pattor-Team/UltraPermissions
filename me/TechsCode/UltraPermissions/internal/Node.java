/*    */ package me.TechsCode.UltraPermissions.internal;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import me.TechsCode.UltraPermissions.utility.ChildrenResolver;
/*    */ 
/*    */ 
/*    */ public class Node
/*    */ {
/*    */   private String permission;
/*    */   
/*    */   public Node(String paramString) {
/* 15 */     this.permission = paramString;
/*    */   }
/*    */   
/*    */   public List<String> getWildcards() {
/* 19 */     ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])new String[] { "*" }));
/*    */     
/* 21 */     String str = "";
/*    */     
/* 23 */     for (String str1 : this.permission.split("\\.")) {
/* 24 */       if (!str.equals("")) {
/* 25 */         str = str + ".";
/*    */       }
/* 27 */       str = str + str1;
/*    */       
/* 29 */       arrayList.add(str + ".*");
/*    */     } 
/*    */     
/* 32 */     return arrayList;
/*    */   }
/*    */   
/*    */   public List<String> getSelfAndWildcards() {
/* 36 */     ArrayList<String> arrayList = new ArrayList();
/* 37 */     arrayList.add(this.permission);
/* 38 */     arrayList.addAll(getWildcards());
/* 39 */     return arrayList;
/*    */   }
/*    */   
/*    */   public Set<String> getSelfAndContainedPermissions() {
/* 43 */     return ChildrenResolver.retrieveChildPermissions(this.permission);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/Node.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */