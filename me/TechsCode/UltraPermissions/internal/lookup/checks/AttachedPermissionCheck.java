/*    */ package me.TechsCode.UltraPermissions.internal.lookup.checks;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.stream.Collectors;
/*    */ import java.util.stream.Stream;
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupCheck;
/*    */ import me.TechsCode.UltraPermissions.internal.lookup.LookupOutcome;
/*    */ import org.bukkit.permissions.PermissionAttachment;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AttachedPermissionCheck
/*    */   implements LookupCheck
/*    */ {
/*    */   public LookupOutcome perform(String paramString) {
/* 18 */     List list = (List)(new ArrayList(getAttachments())).stream().flatMap(paramPermissionAttachment -> paramPermissionAttachment.getPermissions().entrySet().stream()).collect(Collectors.toList());
/*    */     
/* 20 */     boolean bool1 = false;
/* 21 */     boolean bool2 = false;
/*    */     
/* 23 */     for (Map.Entry entry : list) {
/* 24 */       if (((String)entry.getKey()).equalsIgnoreCase(paramString)) {
/* 25 */         if (((Boolean)entry.getValue()).booleanValue()) {
/* 26 */           bool1 = true; continue;
/*    */         } 
/* 28 */         bool2 = true;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 33 */     if (bool2) {
/* 34 */       return new LookupOutcome(false, "Negated by Permission Attachment");
/*    */     }
/* 36 */     if (bool1) {
/* 37 */       return new LookupOutcome(true, "Allowed by Permission Attachment");
/*    */     }
/*    */ 
/*    */     
/* 41 */     return null;
/*    */   }
/*    */   
/*    */   public abstract List<PermissionAttachment> getAttachments();
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/internal/lookup/checks/AttachedPermissionCheck.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */