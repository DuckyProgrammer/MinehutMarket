package me.AwesomeLuke.StaffChat;

import org.bukkit.plugin.java.JavaPlugin;

import me.AwesomeLuke.StaffChat.Commands.StaffChat;

public class Main extends JavaPlugin {

	public String format = "";
	public String chatP = "";
	public String noPerm = "";
	public String noArgs = "";
	
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
		
	}
	
	private void registerVars() {
		format = getConfig().getString("format");
		chatP = getConfig().getString("chat-prefix");
		noPerm = getConfig().getString("no-permission-message");
		noArgs = getConfig().getString("not-enough-args");
	}
	
}
