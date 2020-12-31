package me.TechsCode.UltraPermissions.dependencies.nbt.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import me.TechsCode.UltraPermissions.dependencies.nbt.utils.MinecraftVersion;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AvaliableSince {
  MinecraftVersion version();
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/dependencies/nbt/utils/annotations/AvaliableSince.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */