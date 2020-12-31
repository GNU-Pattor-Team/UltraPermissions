package me.TechsCode.UltraPermissions.dependencies.slf4j.spi;

import me.TechsCode.UltraPermissions.dependencies.slf4j.ILoggerFactory;
import me.TechsCode.UltraPermissions.dependencies.slf4j.IMarkerFactory;

public interface SLF4JServiceProvider {
  ILoggerFactory getLoggerFactory();
  
  IMarkerFactory getMarkerFactory();
  
  MDCAdapter getMDCAdapter();
  
  String getRequesteApiVersion();
  
  void initialize();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/spi/SLF4JServiceProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */