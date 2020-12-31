package me.TechsCode.UltraPermissions.base.command;

import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface Requirement {
  boolean isMatching(CommandSender paramCommandSender, Player paramPlayer, List<String> paramList);
  
  void onUnmatched(CommandSender paramCommandSender, Player paramPlayer);
}


/* Location:              /home/octo/Downloads/Telegram Desktop/UltraPermissions-4.8.9-Cracked.jar!/me/TechsCode/UltraPermissions/base/command/Requirement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */