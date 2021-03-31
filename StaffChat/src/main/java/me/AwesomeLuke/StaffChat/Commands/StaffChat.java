package me.AwesomeLuke.StaffChat.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.AwesomeLuke.StaffChat.Main;

public class StaffChat implements CommandExecutor {
	
	private Main plugin = Main.getPlugin(Main.class);
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String noPerm = plugin.noPerm.replace('&', '§');
		String noArgs = plugin.noArgs.replace('&', '§');
		String message = "";
		if (!(sender instanceof Player)) {
			
		}
		
		Player player = (Player) sender;
		
		if (!player.hasPermission(plugin.perm)) {
			player.sendMessage(noPerm);
			return false;
		}
		
		if (!(args.length > 0)) {
			player.sendMessage(noArgs);
			return false;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(String arg : args) {
			stringBuilder.append(arg).append(" ");
		}
		String newString = stringBuilder.toString();
		message = plugin.format.replace('&', '§');
		message = message.replace("%player%", player.getName());
		message = message.replace("%message%", newString);
		for (Player staff : Bukkit.getOnlinePlayers()) {
			if (staff.hasPermission("staffchat.use")) {
				staff.sendMessage(message);
			}
		}
		
		
		
		return true;
	}
	
	
}
