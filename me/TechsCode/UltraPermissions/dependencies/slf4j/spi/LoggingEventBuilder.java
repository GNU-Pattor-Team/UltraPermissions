package me.TechsCode.UltraPermissions.dependencies.slf4j.spi;

import java.util.function.Supplier;
import me.TechsCode.UltraPermissions.dependencies.slf4j.Marker;

public interface LoggingEventBuilder {
  LoggingEventBuilder setCause(Throwable paramThrowable);
  
  LoggingEventBuilder addMarker(Marker paramMarker);
  
  LoggingEventBuilder addArgument(Object paramObject);
  
  LoggingEventBuilder addArgument(Supplier<Object> paramSupplier);
  
  LoggingEventBuilder addKeyValue(String paramString, Object paramObject);
  
  LoggingEventBuilder addKeyValue(String paramString, Supplier<Object> paramSupplier);
  
  void log(String paramString);
  
  void log(String paramString, Object paramObject);
  
  void log(String paramString, Object paramObject1, Object paramObject2);
  
  void log(String paramString, Object... paramVarArgs);
  
  void log(Supplier<String> paramSupplier);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/slf4j/spi/LoggingEventBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */