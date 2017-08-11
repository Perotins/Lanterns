package me.perotin.lanterns;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class LanternEvents implements Listener {

	
	private LanternMain plugin;
	
	public LanternEvents (LanternMain plugin){
		this.plugin = plugin;
	}
	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action a = e.getAction();
		Material on = Material.valueOf(plugin.getConfig().getString("on-lantern"));
		Material off = Material.valueOf(plugin.getConfig().getString("off-lantern"));

		if(a == Action.RIGHT_CLICK_AIR || a == Action.LEFT_CLICK_AIR){
			if(p.getInventory().getItemInMainHand().getType() == off){
				p.getInventory().getItemInMainHand().setType(on);
			}else if(p.getInventory().getItemInMainHand().getType() == on){
				p.getInventory().getItemInMainHand().setType(off);
			}
		}
	}
	
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event){
		Material on = Material.valueOf(plugin.getConfig().getString("on-lantern"));
		Material off = Material.valueOf(plugin.getConfig().getString("off-lantern"));
		if(event.getItemDrop().getItemStack().getType() == on || event.getItemDrop().getItemStack().getType() == off){
			if(plugin.getConfig().getBoolean("undroppable")){
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onPlace(BlockBreakEvent event){
		Material on = Material.valueOf(plugin.getConfig().getString("on-lantern"));
		Material off = Material.valueOf(plugin.getConfig().getString("off-lantern"));
		if(event.getBlock().getType() == on || event.getBlock().getType() == off){
			if(plugin.getConfig().getBoolean("unbreakable")){
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent event){
		Material on = Material.valueOf(plugin.getConfig().getString("on-lantern"));
		Material off = Material.valueOf(plugin.getConfig().getString("off-lantern"));
		if(event.getBlock().getType() == on || event.getBlock().getType() == off){
			if(plugin.getConfig().getBoolean("unplaceable")){
				event.setCancelled(true);
			}
		}
	}
	
	






}
