package me.perotin.lanterns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class LanternReloadCommand implements CommandExecutor {

	
	private LanternMain plugin;
	
	public LanternReloadCommand(LanternMain plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender.hasPermission("lanterns.reload")){
			plugin.reloadConfig();
			sender.sendMessage(ChatColor.GRAY + "Reloaded the config file for Lanterns v1.0");
			return true;
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
			return true;
		}
	}

}
