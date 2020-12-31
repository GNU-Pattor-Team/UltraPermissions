package me.TechsCode.UltraPermissions.base.storage;

import com.google.gson.JsonObject;
import java.util.HashMap;

public interface ReadCallback {
  void onSuccess(HashMap<String, JsonObject> paramHashMap);
  
  void onFailure(Exception paramException);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/storage/ReadCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */