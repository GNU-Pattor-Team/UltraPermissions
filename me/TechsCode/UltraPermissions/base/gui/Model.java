/*    */ package me.TechsCode.UltraPermissions.base.gui;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Model
/*    */ {
/* 13 */   private String title = "Unnamed Inventory";
/* 14 */   private int slots = 27;
/*    */   
/* 16 */   private HashMap<Integer, Entry> entries = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void setTitle(String paramString) {
/* 20 */     this.title = paramString;
/*    */   }
/*    */   
/*    */   public void setSlots(int paramInt) {
/* 24 */     this.slots = paramInt;
/*    */   }
/*    */   
/*    */   public void button(Entry paramEntry, int paramInt) {
/* 28 */     this.entries.put(Integer.valueOf(paramInt), paramEntry);
/*    */   }
/*    */   
/*    */   public void button(int paramInt, Entry paramEntry) {
/* 32 */     this.entries.put(Integer.valueOf(paramInt), paramEntry);
/*    */   }
/*    */   
/*    */   public void button(Entry paramEntry, int paramInt1, int paramInt2) {
/* 36 */     this.entries.put(Integer.valueOf(format(paramInt1, paramInt2)), paramEntry);
/*    */   }
/*    */   
/*    */   public void button(int paramInt1, int paramInt2, Entry paramEntry) {
/* 40 */     this.entries.put(Integer.valueOf(format(paramInt1, paramInt2)), paramEntry);
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 44 */     return this.title;
/*    */   }
/*    */   
/*    */   public int getSlots() {
/* 48 */     return this.slots;
/*    */   }
/*    */   
/*    */   public HashMap<Integer, Entry> getEntries() {
/* 52 */     return this.entries;
/*    */   }
/*    */   
/*    */   private int format(int paramInt1, int paramInt2) {
/* 56 */     return (paramInt1 - 1) * 9 + paramInt2;
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/gui/Model.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */