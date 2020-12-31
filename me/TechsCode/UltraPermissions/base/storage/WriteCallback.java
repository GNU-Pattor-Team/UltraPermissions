package me.TechsCode.UltraPermissions.base.storage;

public interface WriteCallback {
  void onSuccess();
  
  void onFailure(Exception paramException);
  
  public static class EmptyWriteCallback implements WriteCallback {
    public void onSuccess() {}
    
    public void onFailure(Exception param1Exception) {}
  }
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/WriteCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */