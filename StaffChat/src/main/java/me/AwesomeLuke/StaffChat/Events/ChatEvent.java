package me.AwesomeLuke.StaffChat.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.AwesomeLuke.StaffChat.Main;

public class ChatEvent implements Listener {
	
	private Main plugin = Main.getPlugin(Main.class);

	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String noArgs = plugin.noArgs.replace('&', '§');
		String message = "";
		Player player = event.getPlayer();
		if (event.getMessage().startsWith(plugin.chatP)) {
			if (player.hasPermission(plugin.perm)) {
				if (event.getMessage().equals(plugin.chatP)) {
					player.sendMessage(noArgs);
					event.setCancelled(true);
					return;
				}
				String toSend = event.getMessage().replace(plugin.chatP, "");
				message = plugin.format.replace('&', '§');
				message = message.replace("%player%", player.getName());
				message = message.replace("%message%", toSend);
				for (Player staff : Bukkit.getOnlinePlayers()) {
					if (staff.hasPermission(plugin.perm)) {
						staff.sendMessage(message);
					}
				}
				event.setCancelled(true);
			}
		}
	}

}
