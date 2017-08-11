package me.perotin.lanterns;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LanternCommand implements CommandExecutor{


	private LanternMain plugin;

	public LanternCommand(LanternMain plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(args.length == 1){
			if(sender.hasPermission("lanterns.other")){
				Player target = Bukkit.getPlayer(args[0]);
				if(target == null){

					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("could-not-find")
							.replace("$player$", args[0])));
					return true;
				} else {
					plugin.giveLantern(target);
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("got-lantern")));
					sender.sendMessage(ChatColor.GRAY + "Given lantern to " + ChatColor.YELLOW + target.getName());
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
				return true;
			}
		}
		if(args.length == 0){
			if(sender instanceof Player){
				Player target = (Player) sender;
				if(target.hasPermission("lanterns.self")){
					plugin.giveLantern(target);
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("got-lantern")));
					
					return true;
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("no-permission")));
					return true;
				}


			} else {
				sender.sendMessage("Players only, try /lantern <name>");
			}
		}
		return true;
	}


}
