package me.TechsCode.UltraPermissions.dependencies.slf4j.event;

import java.util.List;
import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;

public interface LoggingEvent {
  Level getLevel();
  
  String getLoggerName();
  
  String getMessage();
  
  List<Object> getArguments();
  
  Object[] getArgumentArray();
  
  List<Marker> getMarkers();
  
  List<KeyValuePair> getKeyValuePairs();
  
  Throwable getThrowable();
  
  long getTimeStamp();
  
  String getThreadName();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/event/LoggingEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */