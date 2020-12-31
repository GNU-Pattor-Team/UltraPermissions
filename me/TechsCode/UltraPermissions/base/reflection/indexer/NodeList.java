/*    */ package me.TechsCode.UltraPermissions.base.reflection.indexer;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ 
/*    */ public class NodeList extends ArrayList<Node> {
/*    */   public NodeList(int paramInt) {
/* 10 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public NodeList() {}
/*    */   
/*    */   public NodeList(Collection<? extends Node> paramCollection) {
/* 17 */     super(paramCollection);
/*    */   }
/*    */   
/*    */   public NodeList classes() {
/* 21 */     return (NodeList)stream().filter(Node::isClass).collect(Collectors.toCollection(NodeList::new));
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/reflection/indexer/NodeList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */