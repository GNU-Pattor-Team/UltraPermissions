/*    */ package me.TechsCode.UltraPermissions.storage;
/*    */ 
/*    */ import me.TechsCode.UltraPermissions.base.TechPlugin;
/*    */ import me.TechsCode.UltraPermissions.base.storage.Storable;
/*    */ import me.TechsCode.UltraPermissions.base.storage.StorageImplementation;
/*    */ import me.TechsCode.UltraPermissions.events.user.UserCreationEvent;
/*    */ import me.TechsCode.UltraPermissions.storage.objects.User;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpigotUserStorage
/*    */   extends UserStorage
/*    */ {
/*    */   public SpigotUserStorage(TechPlugin paramTechPlugin, Class<? extends StorageImplementation> paramClass) {
/* 18 */     super(paramTechPlugin, paramClass);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCreation(User paramUser) {
/* 23 */     super.onCreation(paramUser);
/*    */     
/* 25 */     UserCreationEvent userCreationEvent = new UserCreationEvent(paramUser);
/* 26 */     userCreationEvent.call(this.plugin, (Event)userCreationEvent);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onChange(User paramUser) {
/* 31 */     super.onChange(paramUser);
/*    */   }
/*    */ }


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/SpigotUserStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */