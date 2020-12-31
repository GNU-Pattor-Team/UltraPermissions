/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ import me.TechsCode.UltraPermissions.events.group.GroupCreationEvent;
/*    */ import me.TechsCode.UltraPermissions.events.group.GroupDeletionEvent;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.Group;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ public class SpigotGroupStorage extends GroupStorage {
/*    */   public SpigotGroupStorage(TechPlugin paramTechPlugin, Class<? extends StorageImplementation> paramClass) {
/* 13 */     super(paramTechPlugin, paramClass);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreation(Group paramGroup) {
/* 18 */     super.onCreation(paramGroup);
/*    */     
/* 20 */     GroupCreationEvent groupCreationEvent = new GroupCreationEvent(paramGroup);
/* 21 */     groupCreationEvent.call(this.plugin, (Event)groupCreationEvent);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onDestroy(Group paramGroup) {
/* 26 */     super.onDestroy(paramGroup);
/*    */     
/* 28 */     GroupDeletionEvent groupDeletionEvent = new GroupDeletionEvent(paramGroup);
/* 29 */     groupDeletionEvent.call(this.plugin, (Event)groupDeletionEvent);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onChange(Group paramGroup) {
/* 34 */     super.onChange(paramGroup);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/SpigotGroupStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */