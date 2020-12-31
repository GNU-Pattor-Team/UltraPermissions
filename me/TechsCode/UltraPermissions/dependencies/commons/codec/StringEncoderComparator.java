/*    */ package me.TechsCode.UltraPermissions.dependencies.commons.codec;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringEncoderComparator
/*    */   implements Comparator
/*    */ {
/*    */   private final StringEncoder stringEncoder;
/*    */   
/*    */   @Deprecated
/*    */   public StringEncoderComparator() {
/* 48 */     this.stringEncoder = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StringEncoderComparator(StringEncoder paramStringEncoder) {
/* 58 */     this.stringEncoder = paramStringEncoder;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(Object paramObject1, Object paramObject2) {
/* 77 */     int i = 0;
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 82 */       Comparable<Comparable> comparable = (Comparable)this.stringEncoder.encode(paramObject1);
/* 83 */       Comparable comparable1 = (Comparable)this.stringEncoder.encode(paramObject2);
/* 84 */       i = comparable.compareTo(comparable1);
/* 85 */     } catch (EncoderException encoderException) {
/* 86 */       i = 0;
/*    */     } 
/* 88 */     return i;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/codec/StringEncoderComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */