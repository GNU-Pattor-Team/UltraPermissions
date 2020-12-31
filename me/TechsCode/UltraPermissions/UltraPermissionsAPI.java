package me.TechsCode.UltraPermissions;

import me.TechsCode.UltraPermissions.storage.GroupCreator;
import me.TechsCode.UltraPermissions.storage.PermissionCreator;
import me.TechsCode.UltraPermissions.storage.collection.GroupList;
import me.TechsCode.UltraPermissions.storage.collection.PermissionList;
import me.TechsCode.UltraPermissions.storage.collection.UserList;
import me.TechsCode.UltraPermissions.storage.objects.Holder;

public interface UltraPermissionsAPI {
  GroupCreator newGroup(String paramString);
  
  PermissionCreator newPermission(String paramString, Holder paramHolder);
  
  PermissionList getPermissions();
  
  GroupList getGroups();
  
  UserList getUsers();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/UltraPermissionsAPI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */