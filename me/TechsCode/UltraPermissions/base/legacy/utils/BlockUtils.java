/*    */ package me.TechsCode.UltraPermissions.base.legacy.utils;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.BlockFace;
/*    */ 
/*    */ public class BlockUtils {
/*    */   public static Block[] getBlocksInRadius(Location paramLocation, int paramInt) {
/* 12 */     ArrayList<Block> arrayList = new ArrayList();
/* 13 */     for (double d = paramLocation.getX() - paramInt; d <= paramLocation.getX() + paramInt; d++) {
/* 14 */       double d1; for (d1 = paramLocation.getY() - paramInt; d1 <= paramLocation.getY() + paramInt; d1++) {
/* 15 */         double d2; for (d2 = paramLocation.getZ() - paramInt; d2 <= paramLocation.getZ() + paramInt; d2++) {
/* 16 */           Location location = new Location(paramLocation.getWorld(), d, d1, d2);
/* 17 */           arrayList.add(location.getBlock());
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 22 */     return arrayList.<Block>toArray(new Block[0]);
/*    */   }
/*    */   
/*    */   public static BlockFace[] getBlockSides() {
/* 26 */     return new BlockFace[] { BlockFace.DOWN, BlockFace.UP, BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Block[] getAttachedBlocks(Block paramBlock) {
/* 37 */     return (Block[])Arrays.<BlockFace>stream(getBlockSides()).map(paramBlock::getRelative).toArray(paramInt -> new Block[paramInt]);
/*    */   }
/*    */   
/*    */   public static Set<Block> getBlocksInSphere(Location paramLocation, int paramInt, boolean paramBoolean) {
/* 41 */     HashSet<Block> hashSet = new HashSet();
/*    */     
/* 43 */     int i = paramLocation.getBlockX();
/* 44 */     int j = paramLocation.getBlockY();
/* 45 */     int k = paramLocation.getBlockZ();
/*    */     
/* 47 */     for (int m = i - paramInt; m <= i + paramInt; m++) {
/* 48 */       for (int n = j - paramInt; n <= j + paramInt; n++) {
/* 49 */         for (int i1 = k - paramInt; i1 <= k + paramInt; i1++) {
/*    */           
/* 51 */           double d = ((i - m) * (i - m) + (k - i1) * (k - i1) + (j - n) * (j - n));
/*    */           
/* 53 */           if (d < (paramInt * paramInt) && (!paramBoolean || d >= ((paramInt - 1) * (paramInt - 1)))) {
/* 54 */             Location location = new Location(paramLocation.getWorld(), m, n, i1);
/* 55 */             hashSet.add(location.getBlock());
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 62 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/legacy/utils/BlockUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */