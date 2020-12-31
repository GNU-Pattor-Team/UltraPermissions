package me.TechsCode.UltraPermissions.dependencies.slf4j;

import java.io.Serializable;
import java.util.Iterator;

public interface Marker extends Serializable {
  public static final String ANY_MARKER = "*";
  
  public static final String ANY_NON_NULL_MARKER = "+";
  
  String getName();
  
  void add(Marker paramMarker);
  
  boolean remove(Marker paramMarker);
  
  @Deprecated
  boolean hasChildren();
  
  boolean hasReferences();
  
  Iterator<Marker> iterator();
  
  boolean contains(Marker paramMarker);
  
  boolean contains(String paramString);
  
  boolean equals(Object paramObject);
  
  int hashCode();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/Marker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */