package me.TechsCode.UltraPermissions.dependencies.commons.io.input;

public interface TailerListener {
  void init(Tailer paramTailer);
  
  void fileNotFound();
  
  void fileRotated();
  
  void handle(String paramString);
  
  void handle(Exception paramException);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/commons/io/input/TailerListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */