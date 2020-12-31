package me.TechsCode.UltraPermissions.dependencies.commons.io.monitor;

import java.io.File;

public interface FileAlterationListener {
  void onStart(FileAlterationObserver paramFileAlterationObserver);
  
  void onDirectoryCreate(File paramFile);
  
  void onDirectoryChange(File paramFile);
  
  void onDirectoryDelete(File paramFile);
  
  void onFileCreate(File paramFile);
  
  void onFileChange(File paramFile);
  
  void onFileDelete(File paramFile);
  
  void onStop(FileAlterationObserver paramFileAlterationObserver);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/monitor/FileAlterationListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */