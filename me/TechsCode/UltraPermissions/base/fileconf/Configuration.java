package me.TechsCode.UltraPermissions.base.fileconf;

import java.util.Set;

public interface Configuration {
  Object get(String paramString);
  
  int getInt(String paramString);
  
  String getString(String paramString);
  
  boolean getBoolean(String paramString);
  
  Set<String> getKeys(boolean paramBoolean);
  
  boolean contains(String paramString);
  
  void set(String paramString, Object paramObject);
  
  void save();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/fileconf/Configuration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */