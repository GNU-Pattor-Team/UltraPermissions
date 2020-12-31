package me.TechsCode.UltraPermissions.dependencies.slf4j;

public interface IMarkerFactory {
  Marker getMarker(String paramString);
  
  boolean exists(String paramString);
  
  boolean detachMarker(String paramString);
  
  Marker getDetachedMarker(String paramString);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/IMarkerFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */