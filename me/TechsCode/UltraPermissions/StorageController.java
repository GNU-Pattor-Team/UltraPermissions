package me.TechsCode.UltraPermissions;

import me.TechsCode.UltraPermissions.storage.GroupStorage;
import me.TechsCode.UltraPermissions.storage.PermissionStorage;
import me.TechsCode.UltraPermissions.storage.UserStorage;

public interface StorageController {
  void onDataModification();
  
  GroupStorage getGroupStorage();
  
  PermissionStorage getPermissionStorage();
  
  UserStorage getUserStorage();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/StorageController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */