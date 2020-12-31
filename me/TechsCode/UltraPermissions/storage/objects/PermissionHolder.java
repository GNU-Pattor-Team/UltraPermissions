package me.TechsCode.UltraPermissions.storage.objects;

import java.util.Optional;
import me.TechsCode.UltraPermissions.storage.PermissionCreator;
import me.TechsCode.UltraPermissions.storage.collection.PermissionList;

public interface PermissionHolder {
  String getName();
  
  PermissionList getPermissions();
  
  PermissionList getAdditionalPermissions();
  
  PermissionCreator newPermission(String paramString);
  
  Optional<String> getPrefix();
  
  Optional<String> getSuffix();
  
  void setPrefix(String paramString);
  
  void setSuffix(String paramString);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/storage/objects/PermissionHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */