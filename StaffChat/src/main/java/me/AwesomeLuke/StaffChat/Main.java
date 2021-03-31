package me.AwesomeLuke.StaffChat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.AwesomeLuke.StaffChat.Commands.StaffChat;
import me.AwesomeLuke.StaffChat.Events.ChatEvent;

public class Main extends JavaPlugin {

	public String format = "";
	public String chatP = "";
	public String noPerm = "";
	public String noArgs = "";
	public String perm = "";
	
	public void onEnable() {
		getLogger().info("Staff Chat has been enabled.");
		registerCommands();
		registerEvents();
		registerVars();
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	private void registerCommands() {
		getCommand("sc").setExecutor(new StaffChat());
	}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ChatEvent(), this);
	}
	
	private void registerVars() {
		format = getConfig().getString("format");
		chatP = getConfig().getString("chat-prefix");
		noPerm = getConfig().getString("no-permission-message");
		noArgs = getConfig().getString("not-enough-args");
		perm = getConfig().getString("permission");
	}
	
}
