/*    */ package me.TechsCode.UltraPermissions.dependencies.slf4j.nop;
/*    */ 
/*    */ import java.util.Map;
/*    */ import me.TechsCode.UltraPermissions.dependencies.slf4j.spi.MDCAdapter;
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
/*    */ public class NOPMDCAdapter
/*    */   implements MDCAdapter
/*    */ {
/*    */   public void clear() {}
/*    */   
/*    */   public String get(String paramString) {
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void put(String paramString1, String paramString2) {}
/*    */ 
/*    */   
/*    */   public void remove(String paramString) {}
/*    */   
/*    */   public Map<String, String> getCopyOfContextMap() {
/* 56 */     return null;
/*    */   }
/*    */   
/*    */   public void setContextMap(Map<String, String> paramMap) {}
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/nop/NOPMDCAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */