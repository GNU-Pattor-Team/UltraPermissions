/*    */ package me.TechsCode.UltraPermissions.storage.collection;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Comparator;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.UserRankup;
/*    */ 
/*    */ public class RankupList
/*    */   extends ArrayList<UserRankup>
/*    */ {
/*    */   public RankupList(int paramInt) {
/* 13 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public RankupList() {}
/*    */   
/*    */   public RankupList(Collection<? extends UserRankup> paramCollection) {
/* 20 */     super(paramCollection);
/*    */   }
/*    */   
/*    */   public RankupList bestToWorst() {
/* 24 */     sort(Comparator.comparing(paramUserRankup -> (Integer)paramUserRankup.getGroup().get().map(Group::getPriority).orElse(Integer.valueOf(0))));
/* 25 */     return this;
/*    */   }
/*    */   
/*    */   public RankupList worstToBest() {
/* 29 */     sort(Comparator.comparing(paramUserRankup -> (Integer)paramUserRankup.getGroup().get().map(Group::getPriority).orElse(Integer.valueOf(0)), Comparator.reverseOrder()));
/* 30 */     return this;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/collection/RankupList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */