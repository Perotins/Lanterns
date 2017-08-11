package me.perotin.lanterns;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class LanternMain extends JavaPlugin {

	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new LanternEvents(this), this);
		saveDefaultConfig();
		getCommand("lantern").setExecutor(new LanternCommand(this));
		getCommand("lanternreload").setExecutor(new LanternReloadCommand(this));
	}


	public void giveLantern(Player toGive){
		Material off = Material.valueOf(getConfig().getString("off-lantern"));
		ItemStack lantern = new ItemStack(off);
		ItemMeta lanternMeta = lantern.getItemMeta();
		lanternMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', getConfig().getString("lantern-name")));
		for(ItemFlag itemFlag : ItemFlag.values()){
			lanternMeta.addItemFlags(itemFlag);
		}


		lantern.setItemMeta(lanternMeta);
		toGive.getInventory().addItem(lantern);
	}


}
